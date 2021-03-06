/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.actions.remote;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;

import org.openide.util.NbBundle;

import java.awt.Component;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.cismet.cids.custom.udm2020di.protocol.ExportActionProtocolStep;
import de.cismet.cids.custom.udm2020di.types.Parameter;

import de.cismet.cids.server.actions.ServerActionParameter;

import de.cismet.commons.gui.protocol.ProtocolHandler;

import de.cismet.tools.gui.downloadmanager.DownloadManager;
import de.cismet.tools.gui.downloadmanager.DownloadManagerDialog;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
public abstract class AbstractExportAction extends AbstractAction implements ExportAction {

    //~ Static fields/initializers ---------------------------------------------

    protected static transient Logger LOGGER = Logger.getLogger(MossExportAction.class);

    //~ Instance fields --------------------------------------------------------

    @Getter @Setter protected Collection<Parameter> parameters;

    @Getter @Setter protected Map<Long, String> objects;

    @Getter @Setter protected String exportFormat;

    @Getter @Setter protected String exportName;

    protected boolean protocolEnabled = true;

    protected boolean protocolAction = false;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new AbstractExportAction object.
     */
    protected AbstractExportAction() {
        super(NbBundle.getMessage(
                AbstractExportAction.class,
                "AbstractExportAction.name")); // NOI18N
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("creating new Export Action");
        }
    }

    /**
     * Copy Constructor for protocol actions.
     *
     * @param  exportAction  DOCUMENT ME!
     */
    protected AbstractExportAction(final AbstractExportAction exportAction) {
        this();
        this.parameters = new ArrayList<Parameter>(exportAction.getParameters().size());
        for (final Parameter parameter : exportAction.getParameters()) {
            this.parameters.add(new Parameter(parameter));
        }
        this.objects = new HashMap<Long, String>(exportAction.getObjects());
        this.exportFormat = exportAction.getExportFormat();
        this.exportName = exportAction.getExportName();
        this.protocolEnabled = false;
        this.protocolAction = true;
        super.setEnabled(!this.parameters.isEmpty());
        super.putValue(Action.SMALL_ICON, exportAction.getValue(Action.SMALL_ICON));
        super.putValue(Action.SHORT_DESCRIPTION, exportAction.getValue(Action.SHORT_DESCRIPTION));
    }

    /**
     * Creates a new AbstractExportAction object.
     *
     * @param  parameters  DOCUMENT ME!
     * @param  objects     DOCUMENT ME!
     */
    protected AbstractExportAction(final Collection<Parameter> parameters,
            final Map<Long, String> objects) {
        this();
        this.parameters = parameters;
        this.objects = objects;
        super.setEnabled((this.parameters != null) && !this.parameters.isEmpty());
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param   exportFormat  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected String getExtention(final String exportFormat) {
        if (exportFormat.equalsIgnoreCase(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_XLSX)) {
            return ".xlsx";
        } else if (exportFormat.equalsIgnoreCase(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_XLS)) {
            return ".xls";
        } else if (exportFormat.equalsIgnoreCase(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_CSV)) {
            return ".csv";
        } else if (exportFormat.equalsIgnoreCase(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_SHP)) {
            // return ".shp";
            return ".zip";
        } else {
            LOGGER.warn("unsupported export format '" + exportFormat + "', setting extension to '.bin'");
            return ".bin";
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected abstract ServerActionParameter[] createServerActionParameters();

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected abstract String getTaskname();

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected abstract String getDefaultExportName();

    @Override
    public void actionPerformed(final ActionEvent e) {
        final Component component;
        if (Component.class.isAssignableFrom(e.getSource().getClass())) {
            component = (Component)e.getSource();
        } else {
            LOGGER.warn("could not determine source frame of action");
            component = JFrame.getFrames()[0];
        }

        final ServerActionParameter[] serverActionParameters = this.createServerActionParameters();
        if ((serverActionParameters != null) && (serverActionParameters.length > 0)) {
            if (DownloadManagerDialog.getInstance().showAskingForUserTitleDialog(component)) {
                final String jobname = DownloadManagerDialog.getInstance().getJobName();
                this.setExportName(((jobname != null) && !jobname.isEmpty()) ? jobname : this.getDefaultExportName());
            }

            if ((this.getExportName() == null) || this.getExportName().isEmpty()) {
                this.setExportName(this.getDefaultExportName());
            }

            final String extension = this.getExtention(this.getExportFormat());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("export filename is " + this.getExportName() + "." + extension);
            }
            DownloadManager.instance()
                    .add(
                        new ExportActionDownload(
                            this.getExportName(),
                            "",
                            this.getExportName(),
                            extension,
                            this.getTaskname(),
                            serverActionParameters));

            if (this.isProtocolEnabled()) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("saving export settings to protocol");
                }
                try {
                    ProtocolHandler.getInstance()
                            .recordStep(
                                new ExportActionProtocolStep(AbstractExportAction.this.clone()));
                } catch (Exception ex) {
                    LOGGER.error("could not save protocol: " + ex.getMessage(), ex);
                }
            } else {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("protocol is globally disabled, or action is invoked from protocol panel");
                }
            }
        } else {
            LOGGER.error("no server action parameters provided");
            JOptionPane.showMessageDialog(
                component,
                "<html><p>Bitte wählen Sie mindestens einen Parameter aus.</p></html>",
                "Datenexport",
                JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public boolean isProtocolEnabled() {
        return this.protocolEnabled && ProtocolHandler.getInstance().isRecordEnabled();
    }

    @Override
    public void setProtocolEnabled(final boolean protocolEnabled) {
        this.protocolEnabled = protocolEnabled;
    }

    @Override
    public ImageIcon getIcon() {
        final Object icon = this.getValue(Action.SMALL_ICON);
        if ((icon != null) && ImageIcon.class.isAssignableFrom(icon.getClass())) {
            return (ImageIcon)icon;
        }

        return null;
    }

    @Override
    public String getTitle() {
        final Object title = this.getValue(Action.SHORT_DESCRIPTION);
        if (title != null) {
            return title.toString();
        }

        return null;
    }

    @Override
    public boolean isProtocolAction() {
        return this.protocolAction;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public Collection<Long> getObjectIds() {
        return (this.objects != null) ? this.objects.keySet() : new ArrayList<Long>(0);
    }

    @Override
    public abstract ExportAction clone() throws CloneNotSupportedException;
}
