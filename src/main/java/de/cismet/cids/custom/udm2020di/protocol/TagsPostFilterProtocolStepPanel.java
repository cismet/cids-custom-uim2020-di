/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.protocol;

import Sirius.navigator.ui.ComponentRegistry;

import Sirius.server.middleware.types.Node;

import org.apache.log4j.Logger;

import org.openide.awt.Mnemonics;
import org.openide.util.NbBundle;

import java.awt.Component;
import java.awt.EventQueue;

import java.util.HashMap;
import java.util.Map;

import de.cismet.cids.custom.udm2020di.tools.PostfilterConfigurationRegistry;

import de.cismet.commons.gui.protocol.AbstractProtocolStepPanel;

import static de.cismet.cids.custom.udm2020di.postfilter.CommonTagsPostFilterGui.SELECTED_TAGS;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé <pascal.dihe@cismet.de>
 * @version  $Revision$, $Date$
 */
public class TagsPostFilterProtocolStepPanel extends AbstractProtocolStepPanel {

    //~ Static fields/initializers ---------------------------------------------

    protected static final Logger LOGGER = Logger.getLogger(TagsPostFilterProtocolStepPanel.class);

    //~ Instance fields --------------------------------------------------------

    protected TagsPostFilterProtocolStep protocolStep;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private org.jdesktop.swingx.JXHyperlink restorePostFilterHyperlink;
    private org.jdesktop.swingx.JXHyperlink restoreSearchResultsHyperlink;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form ExportActionProtocolStepPanel.
     *
     * @param  protocolStep  exportAction DOCUMENT ME!
     */
    public TagsPostFilterProtocolStepPanel(final TagsPostFilterProtocolStep protocolStep) {
        initComponents();
        this.setProtocolStep(protocolStep);

        // ComponentRegistry.getRegistry().getDescriptionPane().gotoMetaObjects(to, TOOL_TIP_TEXT_KEY);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param  protocolStep  exportAction DOCUMENT ME!
     */
    protected final void setProtocolStep(final TagsPostFilterProtocolStep protocolStep) {
        this.protocolStep = protocolStep;

        final Runnable r = new Runnable() {

                @Override
                public void run() {
                    iconLabel.setIcon(protocolStep.getIcon());
                    titleLabel.setText(NbBundle.getMessage(
                            TagsPostFilterProtocolStepPanel.class,
                            protocolStep.getPostFilter()));

                    Mnemonics.setLocalizedText(
                        restoreSearchResultsHyperlink,
                        NbBundle.getMessage(
                            TagsPostFilterProtocolStepPanel.class,
                            "TagsPostFilterProtocolStepPanel.restoreSearchResultsHyperlink.text",
                            String.valueOf(protocolStep.getNodes().size())));

                    Mnemonics.setLocalizedText(
                        restorePostFilterHyperlink,
                        NbBundle.getMessage(
                            TagsPostFilterProtocolStepPanel.class,
                            "TagsPostFilterProtocolStepPanel.restorePostFilterHyperlink.text",
                            protocolStep.getTitle(),
                            String.valueOf(protocolStep.getSelectedTags().size())));
                }
            };

        if (EventQueue.isDispatchThread()) {
            r.run();
        } else {
            EventQueue.invokeLater(r);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iconLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        restoreSearchResultsHyperlink = new org.jdesktop.swingx.JXHyperlink();
        restorePostFilterHyperlink = new org.jdesktop.swingx.JXHyperlink();

        org.openide.awt.Mnemonics.setLocalizedText(
            iconLabel,
            org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.iconLabel.text")); // NOI18N
        iconLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(
            titleLabel,
            org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.titleLabel.text")); // NOI18N

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(
            restoreSearchResultsHyperlink,
            org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.restoreSearchResultsHyperlink.text"));          // NOI18N
        restoreSearchResultsHyperlink.setActionCommand(org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.restoreSearchResultsHyperlink.actionCommand")); // NOI18N
        restoreSearchResultsHyperlink.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    restoreSearchResultsHyperlinkActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(restoreSearchResultsHyperlink, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(
            restorePostFilterHyperlink,
            org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.restorePostFilterHyperlink.text"));          // NOI18N
        restorePostFilterHyperlink.setActionCommand(org.openide.util.NbBundle.getMessage(
                TagsPostFilterProtocolStepPanel.class,
                "TagsPostFilterProtocolStepPanel.restorePostFilterHyperlink.actionCommand")); // NOI18N
        restorePostFilterHyperlink.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    restorePostFilterHyperlinkActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        add(restorePostFilterHyperlink, gridBagConstraints);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void restoreSearchResultsHyperlinkActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_restoreSearchResultsHyperlinkActionPerformed

        if (!this.protocolStep.getNodes().isEmpty()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("restoring " + this.protocolStep.getNodes()
                            + " search results from  protocol of post filter '"
                            + this.protocolStep.getPostFilter() + "'");
            }

            ComponentRegistry.getRegistry()
                    .getSearchResultsTree()
                    .setResultNodes(
                        this.protocolStep.getNodes().toArray(new Node[this.protocolStep.getNodes().size()]));
        } else {
            LOGGER.error("nodes list is empty, cannot restore search result from  protocol of post filter '"
                        + this.protocolStep.getPostFilter() + "'");
        }
    } //GEN-LAST:event_restoreSearchResultsHyperlinkActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void restorePostFilterHyperlinkActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_restorePostFilterHyperlinkActionPerformed
        if (!this.protocolStep.getSelectedTags().isEmpty()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("restoring " + this.protocolStep.getSelectedTags()
                            + " selected tags from protocol of post filter '"
                            + this.protocolStep.getPostFilter() + "'");
            }

            final Map<String, Object> settings = new HashMap<String, Object>();
            settings.put(SELECTED_TAGS, this.protocolStep.getSelectedTags());
            PostfilterConfigurationRegistry.getInstance().pushSettings(this.protocolStep.getPostFilter(), settings);

            this.restoreSearchResultsHyperlinkActionPerformed(evt);
        } else {
            LOGGER.error("selected tags list is empty, cannot filter settings from protocol of post filter '"
                        + this.protocolStep.getPostFilter() + "'");
        }
    } //GEN-LAST:event_restorePostFilterHyperlinkActionPerformed

    @Override
    public Component getIconComponent() {
        return this.iconLabel;
    }

    @Override
    public Component getTitleComponent() {
        return this.titleLabel;
    }
}