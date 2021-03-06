/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

import org.apache.log4j.Logger;

import org.openide.util.ImageUtilities;

import javax.swing.ImageIcon;

import de.cismet.cids.custom.udm2020di.ImageUtil;
import de.cismet.cids.custom.udm2020di.actions.remote.ExportAction;

import de.cismet.commons.gui.protocol.AbstractProtocolStep;
import de.cismet.commons.gui.protocol.AbstractProtocolStepPanel;
import de.cismet.commons.gui.protocol.ProtocolStepMetaInfo;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé <pascal.dihe@cismet.de>
 * @version  $Revision$, $Date$
 */
public class ExportActionProtocolStep extends AbstractProtocolStep {

    //~ Static fields/initializers ---------------------------------------------

    private static final Logger LOGGER = Logger.getLogger(ExportActionProtocolStep.class);

    protected static final ImageIcon ICON = ImageUtilities.loadImageIcon(ImageUtil.getResourcePath(
                ExportActionProtocolStep.class,
                "table_export.png"),
            false);

    @JsonIgnore protected static final ProtocolStepMetaInfo META_INFO = new ProtocolStepMetaInfo(
            ExportActionProtocolStep.class.getSimpleName(),
            "ExportAction");

    //~ Instance fields --------------------------------------------------------

    @Getter
    @JsonProperty(required = true)
    protected final ExportAction exportAction;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new ExportActionProtocolStep object.
     *
     * @param  exportAction  DOCUMENT ME!
     */
    @JsonCreator
    public ExportActionProtocolStep(@JsonProperty("exportAction") final ExportAction exportAction) {
        super();
        this.exportAction = exportAction;
    }

    //~ Methods ----------------------------------------------------------------

    @Override
    protected ProtocolStepMetaInfo createMetaInfo() {
        return META_INFO;
    }

    @Override
    public AbstractProtocolStepPanel visualize() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("visualizing ExportActionProtocolStepPanel");
        }
        return new ExportActionProtocolStepPanel(this.getExportAction());
    }
}
