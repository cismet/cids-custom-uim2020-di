/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.objectrenderer;

import org.apache.log4j.Logger;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import de.cismet.cids.custom.udm2020di.AbstractCidsBeanRenderer;
import de.cismet.cids.custom.udm2020di.actions.remote.BorisExportAction;
import de.cismet.cids.custom.udm2020di.indeximport.OracleImport;
import de.cismet.cids.custom.udm2020di.types.AggregationValue;
import de.cismet.cids.custom.udm2020di.types.Parameter;
import de.cismet.cids.custom.udm2020di.types.boris.Probenparameter;
import de.cismet.cids.custom.udm2020di.types.boris.Standort;
import de.cismet.cids.custom.udm2020di.types.boris.Standortparameter;

/**
 * DOCUMENT ME!
 *
 * @author   pd
 * @version  $Revision$, $Date$
 */
public class BorisSiteRenderer extends AbstractCidsBeanRenderer {

    //~ Static fields/initializers ---------------------------------------------

    protected static final Logger logger = Logger.getLogger(BorisSiteRenderer.class);

    //~ Instance fields --------------------------------------------------------

    private Standort borisStandort;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel exportPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel messwertePanel;
    private javax.swing.JTable messwerteTable;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        infoPanel = new javax.swing.JPanel();
        standortdatenPanel = new javax.swing.JPanel();
        parameterPanel = new de.cismet.cids.custom.udm2020di.widgets.ParameterPanel();
        messwertePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messwerteTable = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        exportPanel = new javax.swing.JPanel();
        parameterSelectionPanel = new de.cismet.cids.custom.udm2020di.widgets.ParameterSelectionPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        infoPanel.setLayout(new java.awt.BorderLayout());

        standortdatenPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(BorisSiteRenderer.class, "BorisSiteRenderer.standortdatenPanel.border.insideBorder.outsideBorder.title")), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)))); // NOI18N
        standortdatenPanel.setLayout(new java.awt.GridBagLayout());
        infoPanel.add(standortdatenPanel, java.awt.BorderLayout.CENTER);

        parameterPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        parameterPanel.setPreferredSize(new java.awt.Dimension(200, 300));
        infoPanel.add(parameterPanel, java.awt.BorderLayout.EAST);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(BorisSiteRenderer.class, "BorisSiteRenderer.infoPanel.TabConstraints.tabTitle"), infoPanel); // NOI18N

        messwertePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        messwertePanel.setLayout(new java.awt.GridBagLayout());

        messwerteTable.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Table.dropLineColor")));
        messwerteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parametername", "Datum der Probe", "Maximalwert", "Minimalwert"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        messwerteTable.setFillsViewportHeight(true);
        messwerteTable.setPreferredSize(new java.awt.Dimension(300, 500));
        messwerteTable.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(messwerteTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        messwertePanel.add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        messwertePanel.add(filler1, gridBagConstraints);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(BorisSiteRenderer.class, "BorisSiteRenderer.messwertePanel.TabConstraints.tabTitle"), messwertePanel); // NOI18N

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

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(BorisSiteRenderer.class, "BorisSiteRenderer.exportPanel.TabConstraints.tabTitle_1"), exportPanel); // NOI18N

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

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
                        logger.error("could not deserialize boris Standort JSON: " + ex.getMessage(), ex);
                        return;
                    }

                    final GridBagConstraints gridBagConstraints = new GridBagConstraints();
                    gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
                    gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
                    gridBagConstraints.gridy = 0;

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

                    final ArrayList<String> parameterNames = new ArrayList<String>(borisStandort.getProbenparameter()
                                    .size());
                    for (final Probenparameter probenparameter : borisStandort.getProbenparameter()) {
                        parameterNames.add(probenparameter.getParameterName());
                    }

                    parameterPanel.setParameterNames(parameterNames);

                    final DefaultTableModel tableModel = (DefaultTableModel)messwerteTable.getModel();
                    for (final AggregationValue aggregationValue : borisStandort.getAggregationValues()) {
                        final Object[] rowData = new Object[] {
                                aggregationValue.getName(),
                                aggregationValue.getMaxDate(),
                                aggregationValue.getMaxValue(),
                                aggregationValue.getMinValue()
                            };
                        tableModel.addRow(rowData);
                    }

                    parameterSelectionPanel.setParameters(
                        new ArrayList<Parameter>(borisStandort.getProbenparameter()));
                    final BorisExportAction borisExportAction = new BorisExportAction(Arrays.asList(
                                new String[] { borisStandort.getPk() }),
                            parameterSelectionPanel.getSelectedParameters());

                    parameterSelectionPanel.setExportAction(borisExportAction);
                }
            };

        if (EventQueue.isDispatchThread()) {
            r.run();
        } else {
            EventQueue.invokeLater(r);
        }
    }
}