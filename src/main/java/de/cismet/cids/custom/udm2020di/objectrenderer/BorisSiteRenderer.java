/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.objectrenderer;

import org.apache.log4j.Logger;

import org.openide.util.WeakListeners;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.cismet.cids.custom.udm2020di.AbstractCidsBeanRenderer;
import de.cismet.cids.custom.udm2020di.actions.remote.BorisExportAction;
import de.cismet.cids.custom.udm2020di.indeximport.OracleImport;
import de.cismet.cids.custom.udm2020di.types.AggregationValue;
import de.cismet.cids.custom.udm2020di.types.Parameter;
import de.cismet.cids.custom.udm2020di.types.boris.Probenparameter;
import de.cismet.cids.custom.udm2020di.types.boris.Standort;
import de.cismet.cids.custom.udm2020di.types.boris.Standortparameter;

import static de.cismet.cids.custom.udm2020di.objectrenderer.EprtrInstallationRenderer.SELECTED_TAB;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
public class BorisSiteRenderer extends AbstractCidsBeanRenderer {

    //~ Static fields/initializers ---------------------------------------------

    protected static final Logger LOGGER = Logger.getLogger(BorisSiteRenderer.class);
    protected static int SELECTED_TAB = 0;

    //~ Instance fields --------------------------------------------------------

    private Standort borisStandort;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel exportPanel;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTabbedPane jTabbedPane;
    private de.cismet.cids.custom.udm2020di.widgets.MesswerteTable messwerteTable;
    private de.cismet.cids.custom.udm2020di.widgets.ParameterPanel parameterPanel;
    private de.cismet.cids.custom.udm2020di.widgets.ParameterSelectionPanel parameterSelectionPanel;
    private javax.swing.JPanel standortdatenPanel;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form BorisSiteRenderer.
     */
    public BorisSiteRenderer() {
        initComponents();
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Get the value of borisStandort.
     *
     * @return  the value of borisStandort
     */
    public Standort getBorisStandort() {
        return borisStandort;
    }

    /**
     * Set the value of borisStandort.
     *
     * @param  borisStandort  new value of borisStandort
     */
    public void setBorisStandort(final Standort borisStandort) {
        this.borisStandort = borisStandort;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane = new javax.swing.JTabbedPane();
        infoPanel = new javax.swing.JPanel();
        standortdatenPanel = new javax.swing.JPanel();
        parameterPanel = new de.cismet.cids.custom.udm2020di.widgets.ParameterPanel();
        messwerteTable = new de.cismet.cids.custom.udm2020di.widgets.MesswerteTable();
        exportPanel = new javax.swing.JPanel();
        parameterSelectionPanel = new de.cismet.cids.custom.udm2020di.widgets.ParameterSelectionPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767));

        setLayout(new java.awt.BorderLayout());

        jTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {

                @Override
                public void stateChanged(final javax.swing.event.ChangeEvent evt) {
                    jTabbedPaneStateChanged(evt);
                }
            });

        infoPanel.setLayout(new java.awt.BorderLayout());

        standortdatenPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5),
                javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createTitledBorder(
                        org.openide.util.NbBundle.getMessage(
                            BorisSiteRenderer.class,
                            "BorisSiteRenderer.standortdatenPanel.border.insideBorder.outsideBorder.title")),
                    javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)))); // NOI18N
        standortdatenPanel.setLayout(new java.awt.GridBagLayout());
        infoPanel.add(standortdatenPanel, java.awt.BorderLayout.CENTER);

        parameterPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        infoPanel.add(parameterPanel, java.awt.BorderLayout.EAST);

        jTabbedPane.addTab(org.openide.util.NbBundle.getMessage(
                BorisSiteRenderer.class,
                "BorisSiteRenderer.infoPanel.TabConstraints.tabTitle"),
            infoPanel);      // NOI18N
        jTabbedPane.addTab(org.openide.util.NbBundle.getMessage(
                BorisSiteRenderer.class,
                "BorisSiteRenderer.messwerteTable.TabConstraints.tabTitle"),
            messwerteTable); // NOI18N

        exportPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        exportPanel.add(parameterSelectionPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        exportPanel.add(filler2, gridBagConstraints);

        jTabbedPane.addTab(org.openide.util.NbBundle.getMessage(
                BorisSiteRenderer.class,
                "BorisSiteRenderer.exportPanel.TabConstraints.tabTitle_1"),
            exportPanel); // NOI18N

        add(jTabbedPane, java.awt.BorderLayout.CENTER);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void jTabbedPaneStateChanged(final javax.swing.event.ChangeEvent evt) { //GEN-FIRST:event_jTabbedPaneStateChanged
        SELECTED_TAB = jTabbedPane.getSelectedIndex();
    }                                                                               //GEN-LAST:event_jTabbedPaneStateChanged

    /**
     * DOCUMENT ME!
     */
    @Override
    protected void init() {
        final Runnable r = new Runnable() {

                @Override
                public void run() {
                    try {
                        BorisSiteRenderer.this.borisStandort = OracleImport.JSON_MAPPER.readValue(BorisSiteRenderer.this
                                        .getCidsBean().getProperty("src_content").toString(),
                                Standort.class);
                    } catch (Exception ex) {
                        LOGGER.error("could not deserialize boris Standort JSON: " + ex.getMessage(), ex);
                        return;
                    }

                    final GridBagConstraints gridBagConstraints = new GridBagConstraints();
                    gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                    gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
                    gridBagConstraints.gridy = 0;

                    // Standortparameter ---------------------------------------
                    JLabel label;
                    int i = 0;
                    for (final Standortparameter standortparameter : borisStandort.getStandortparameter()) {
                        if ((standortparameter.getWert() != null) && !standortparameter.getWert().isEmpty()
                                    && !standortparameter.getWert().equalsIgnoreCase("null")) {
                            gridBagConstraints.gridy = i;
                            gridBagConstraints.gridx = 0;
                            gridBagConstraints.weightx = 0.0;
                            label = new JLabel("<html><p>" + standortparameter.getName() + ": </p></html>");
                            label.setMaximumSize(new Dimension(150, 50));
                            standortdatenPanel.add(label, gridBagConstraints);

                            if (i == (borisStandort.getStandortparameter().size() - 1)) {
                                gridBagConstraints.weighty = 1.0;
                            }
                            gridBagConstraints.gridx = 1;
                            gridBagConstraints.weightx = 1.0;
                            label = new JLabel("<html><p>" + standortparameter.getWert() + "</p></html>");
                            label.setMaximumSize(new Dimension(200, 50));
                            standortdatenPanel.add(label, gridBagConstraints);
                            i++;
                        }
                    }

                    // ParameterPanel ------------------------------------------
                    if ((borisStandort.getProbenparameter() != null)
                                && !borisStandort.getProbenparameter().isEmpty()) {
                        final ArrayList<String> parameterNames = new ArrayList<String>(
                                borisStandort.getProbenparameter().size());
                        for (final Probenparameter probenparameter : borisStandort.getProbenparameter()) {
                            parameterNames.add(probenparameter.getParameterName());
                        }
                        parameterPanel.setParameterNames(parameterNames);
                    }

                    // AggregationTable ----------------------------------------
                    messwerteTable.setAggregationValues(
                        borisStandort.getAggregationValues().toArray(
                            new AggregationValue[0]));

                    // ParameterSelection (EXPORT) -----------------------------
                    parameterSelectionPanel.setParameters(
                        new ArrayList<Parameter>(borisStandort.getProbenparameter()));
                    final BorisExportAction borisExportAction = new BorisExportAction(Arrays.asList(
                                new String[] { borisStandort.getPk() }),
                            parameterSelectionPanel.getSelectedParameters());
                    parameterSelectionPanel.setExportAction(borisExportAction);
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("restoring selected tab index: " + SELECTED_TAB);
                    }
                    jTabbedPane.setSelectedIndex(SELECTED_TAB);
                    jTabbedPane.addChangeListener(WeakListeners.create(
                            ChangeListener.class,
                            new ChangeListener() {

                                @Override
                                public void stateChanged(final ChangeEvent evt) {
                                    SELECTED_TAB = jTabbedPane.getSelectedIndex();
                                }
                            },
                            jTabbedPane));
                }
            };

        if (EventQueue.isDispatchThread()) {
            r.run();
        } else {
            EventQueue.invokeLater(r);
        }
    }
}
