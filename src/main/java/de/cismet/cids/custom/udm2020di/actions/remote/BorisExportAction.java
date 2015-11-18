/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.actions.remote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.log4j.Logger;

import org.openide.util.NbBundle;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Action;

import de.cismet.cids.custom.udm2020di.types.Parameter;

import de.cismet.cids.server.actions.ServerActionParameter;

import static de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.PARAM_EXPORTFORMAT;
import static de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.PARAM_NAME;
import static de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.PARAM_PARAMETER;
import static de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.PARAM_STANDORTE;
import static de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.TASK_NAME;
import static de.cismet.cids.custom.udm2020di.treeicons.BorisSiteIconFactory.BORIS_SITE_ICON;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
public class BorisExportAction extends AbstractExportAction {

    //~ Static fields/initializers ---------------------------------------------

    protected static final String DEFAULT_EXPORTFILE = "boris-export";
    protected static final transient Logger LOGGER = Logger.getLogger(BorisExportAction.class);

    //~ Instance fields --------------------------------------------------------

    @JsonProperty
    protected Collection<String> standorte;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new BorisExportAction object.
     *
     * @param  exportAction  DOCUMENT ME!
     */
    public BorisExportAction(final BorisExportAction exportAction) {
        super(exportAction);
        this.standorte = new ArrayList<String>(exportAction.getStandorte());
    }

    /**
     * Creates a new BorisExportAction object.
     *
     * @param  standorte   DOCUMENT ME!
     * @param  parameters  DOCUMENT ME!
     */
    public BorisExportAction(final Collection<String> standorte,
            final Collection<Parameter> parameters) {
        super(parameters);

        this.standorte = standorte;
        this.exportFormat =
            de.cismet.cids.custom.udm2020di.serveractions.boris.BorisExportAction.PARAM_EXPORTFORMAT_CSV;
        super.putValue(Action.SMALL_ICON, BORIS_SITE_ICON);
        super.putValue(
            Action.SHORT_DESCRIPTION,
            NbBundle.getMessage(
                BorisExportAction.class,
                "BorisExportAction.description"));
    }

    /**
     * Creates a new BorisExportAction object.
     *
     * @param  standorte     DOCUMENT ME!
     * @param  parameters    DOCUMENT ME!
     * @param  exportFormat  DOCUMENT ME!
     * @param  exportName    DOCUMENT ME!
     */
    @JsonCreator
    public BorisExportAction(final Collection<String> standorte,
            final Collection<Parameter> parameters,
            final String exportFormat,
            final String exportName) {
        this(standorte, parameters);
        this.exportFormat = exportFormat;
        this.exportName = exportName;
        this.protocolEnabled = false;
    }

    /**
     * Creates a new BorisExportAction object.
     */
    private BorisExportAction() {
        super();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public Collection<String> getStandorte() {
        return standorte;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  standorte  DOCUMENT ME!
     */
    public void setStandorte(final Collection<String> standorte) {
        this.standorte = standorte;
    }

    @Override
    protected ServerActionParameter[] createServerActionParameters() {
        if ((standorte != null) && !standorte.isEmpty()
                    && (parameters != null) && !parameters.isEmpty()) {
            LOGGER.info("perfoming BORIS Export for " + standorte.size() + " standorte and "
                        + parameters.size() + " parameters");

            return new ServerActionParameter[] {
                    new ServerActionParameter<Collection<String>>(PARAM_STANDORTE, this.standorte),
                    new ServerActionParameter<Collection<Parameter>>(PARAM_PARAMETER, this.parameters),
                    new ServerActionParameter<String>(PARAM_EXPORTFORMAT, this.exportFormat),
                    new ServerActionParameter<String>(PARAM_NAME, "boris-export")
                };
        }

        return null;
    }

    @Override
    protected String getTaskname() {
        return TASK_NAME;
    }

    @Override
    protected String getDefaultExportName() {
        return DEFAULT_EXPORTFILE;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  args  DOCUMENT ME!
     */
    public static void main(final String[] args) {
        try {
            final com.fasterxml.jackson.databind.ObjectMapper mapper =
                new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
            final BorisExportAction borisExportAction = new BorisExportAction();
            System.out.println(mapper.writeValueAsString(borisExportAction));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
