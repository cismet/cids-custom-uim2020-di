/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.protocol;

import java.awt.Component;

import javax.swing.ImageIcon;

import de.cismet.cids.custom.udm2020di.actions.remote.ExportAction;
import de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction;

import de.cismet.commons.gui.protocol.AbstractProtocolStepPanel;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé <pascal.dihe@cismet.de>
 * @version  $Revision$, $Date$
 */
public class ExportActionProtocolStepPanel extends AbstractProtocolStepPanel {

    //~ Instance fields --------------------------------------------------------

    protected final ExportAction exportAction;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXHyperlink exportActionHyperlink;
    private javax.swing.JLabel exportFileIcon;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form ExportActionProtocolStepPanel.
     *
     * @param  exportAction  DOCUMENT ME!
     */
    public ExportActionProtocolStepPanel(final ExportAction exportAction) {
        this.exportAction = exportAction;
        initComponents();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        iconLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        exportFileIcon = new javax.swing.JLabel();
        exportActionHyperlink = new org.jdesktop.swingx.JXHyperlink();

        iconLabel.setIcon(this.exportAction.getIcon());
        org.openide.awt.Mnemonics.setLocalizedText(
            iconLabel,
            org.openide.util.NbBundle.getMessage(
                ExportActionProtocolStepPanel.class,
                "ExportActionProtocolStepPanel.iconLabel.text")); // NOI18N
        iconLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(titleLabel, this.exportAction.getTitle());

        setLayout(new java.awt.GridBagLayout());

        exportFileIcon.setIcon(this.getFileIcon());
        org.openide.awt.Mnemonics.setLocalizedText(
            exportFileIcon,
            org.openide.util.NbBundle.getMessage(
                ExportActionProtocolStepPanel.class,
                "ExportActionProtocolStepPanel.exportFileIcon.text")); // NOI18N
        exportFileIcon.setToolTipText(this.exportAction.getExportFormat());
        add(exportFileIcon, new java.awt.GridBagConstraints());

        exportActionHyperlink.setAction(this.exportAction);
        org.openide.awt.Mnemonics.setLocalizedText(
            exportActionHyperlink,
            org.openide.util.NbBundle.getMessage(
                ExportActionProtocolStepPanel.class,
                "ExportActionProtocolStepPanel.exportActionHyperlink.text")); // NOI18N
        add(exportActionHyperlink, new java.awt.GridBagConstraints());
    }                                                                         // </editor-fold>//GEN-END:initComponents

    @Override
    public Component getIconComponent() {
        return this.iconLabel;
    }

    @Override
    public Component getTitleComponent() {
        return this.titleLabel;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public ExportAction getExportAction() {
        return exportAction;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected ImageIcon getFileIcon() {
        if (this.exportAction.getExportFormat().equalsIgnoreCase(AbstractExportAction.PARAM_EXPORTFORMAT_CSV)) {
            return new javax.swing.ImageIcon(getClass().getResource(
                        "/de/cismet/cids/custom/udm2020di/protocol/text_exports.png"));
        } else if (this.exportAction.getExportFormat().equalsIgnoreCase(AbstractExportAction.PARAM_EXPORTFORMAT_XLS)) {
            return new javax.swing.ImageIcon(getClass().getResource(
                        "/de/cismet/cids/custom/udm2020di/protocol/table_excel.png"));
        } else if (this.exportAction.getExportFormat().equalsIgnoreCase(AbstractExportAction.PARAM_EXPORTFORMAT_XLSX)) {
            return new javax.swing.ImageIcon(getClass().getResource(
                        "/de/cismet/cids/custom/udm2020di/protocol/excel_exports.png"));
        } else if (this.exportAction.getExportFormat().equalsIgnoreCase(AbstractExportAction.PARAM_EXPORTFORMAT_SHP)) {
            return new javax.swing.ImageIcon(getClass().getResource(
                        "/de/cismet/cids/custom/udm2020di/protocol/map_go.png"));
        }

        return null;
    }
}
