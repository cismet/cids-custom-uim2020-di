/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.widgets;

import org.apache.log4j.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.SwingWorker;

import de.cismet.cids.custom.udm2020di.actions.remote.VisualisationAction;
import de.cismet.cids.custom.udm2020di.types.Parameter;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé <pascal.dihe@cismet.de>
 * @version  $Revision$, $Date$
 */
public class VisualisationPanel extends javax.swing.JPanel implements ChartVisualisationComponent {

    //~ Static fields/initializers ---------------------------------------------

    protected static Logger LOGGER = Logger.getLogger(VisualisationPanel.class);

    //~ Instance fields --------------------------------------------------------

    protected final boolean narrowLayout;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton backButton;
    protected javax.swing.JPanel chartsPanel;
    protected javax.swing.Box.Filler filler;
    protected javax.swing.Box.Filler filler2;
    protected javax.swing.JProgressBar jProgressBar;
    protected javax.swing.JLabel messageLabel;
    protected javax.swing.JPanel parameterPanel;
    protected javax.swing.JPanel progressPanel;
    protected de.cismet.cids.custom.udm2020di.widgets.VisualisationParameterSelectionPanel
        visualisationParameterSelectionPanel;
    protected javax.swing.JLabel waitingLabel;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form VisualisationPanel.
     */
    public VisualisationPanel() {
        this(false);
    }

    /**
     * Creates a new VisualisationPanel object.
     *
     * @param  narrowLayout  DOCUMENT ME!
     */
    public VisualisationPanel(final boolean narrowLayout) {
        this.narrowLayout = narrowLayout;
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
        java.awt.GridBagConstraints gridBagConstraints;

        parameterPanel = new javax.swing.JPanel();
        visualisationParameterSelectionPanel = new VisualisationParameterSelectionPanel(this.narrowLayout);
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767));
        progressPanel = new javax.swing.JPanel();
        waitingLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        chartsPanel = new javax.swing.JPanel();
        filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5),
                new java.awt.Dimension(0, 5),
                new java.awt.Dimension(32767, 5));
        backButton = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        parameterPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        parameterPanel.add(visualisationParameterSelectionPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        parameterPanel.add(filler2, gridBagConstraints);

        add(parameterPanel, "parameter");

        progressPanel.setLayout(new java.awt.GridBagLayout());

        waitingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        waitingLabel.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/Sirius/navigator/resource/img/load.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.75;
        progressPanel.add(waitingLabel, gridBagConstraints);

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(
            messageLabel,
            org.openide.util.NbBundle.getMessage(VisualisationPanel.class, "VisualisationPanel.messageLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        progressPanel.add(messageLabel, gridBagConstraints);

        jProgressBar.setIndeterminate(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        progressPanel.add(jProgressBar, gridBagConstraints);

        add(progressPanel, "progress");

        chartsPanel.setLayout(new javax.swing.BoxLayout(chartsPanel, javax.swing.BoxLayout.PAGE_AXIS));
        chartsPanel.add(filler);

        org.openide.awt.Mnemonics.setLocalizedText(
            backButton,
            org.openide.util.NbBundle.getMessage(VisualisationPanel.class, "VisualisationPanel.backButton.text")); // NOI18N
        backButton.setActionCommand(org.openide.util.NbBundle.getMessage(
                VisualisationPanel.class,
                "VisualisationPanel.backButton.actionCommand"));                                                   // NOI18N
        backButton.setAlignmentX(0.5F);
        backButton.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    backButtonActionPerformed(evt);
                }
            });
        chartsPanel.add(backButton);

        add(chartsPanel, "charts");
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void backButtonActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_backButtonActionPerformed
        this.showParameterPanel();
    }                                                                              //GEN-LAST:event_backButtonActionPerformed

    @Override
    public void renderCharts(final Map<String, Dataset> chartData) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("visualising " + chartData.size() + " charts");
        }

        chartsPanel.removeAll();
        final SwingWorker chartRenderWorker = new SwingWorker<Void, JFreeChart>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (final String title : chartData.keySet()) {
                        final JFreeChart chart = createChart(title, chartData.get(title));
                        publish(chart);
                    }
                    return null;
                }

                @Override
                protected void process(final List<JFreeChart> chunks) {
                    for (final JFreeChart chart : chunks) {
                        final ChartPanel chartPanel = new ChartPanel(chart);
                        chartsPanel.add(chartPanel);
                    }
                }

                @Override
                protected void done() {
                    chartsPanel.add(filler);
                    chartsPanel.add(backButton);
                    ((CardLayout)getLayout()).show(VisualisationPanel.this, "charts");
                    chartsPanel.validate();
                }
            };

        chartRenderWorker.execute();
    }

    @Override
    public void showProgressPanel() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("showing progress panel");
        }
        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    ((CardLayout)getLayout()).show(VisualisationPanel.this, "progress");
                }
            });
    }

    @Override
    public void showParameterPanel() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("showing parameter panel");
        }
        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    ((CardLayout)getLayout()).show(VisualisationPanel.this, "parameter");
                }
            });
    }

    /**
     * DOCUMENT ME!
     *
     * @param  visualisationAction  DOCUMENT ME!
     */
    public void setVisualisationAction(final VisualisationAction visualisationAction) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("setting visualisation action");
        }
        this.visualisationParameterSelectionPanel.setVisualisationActionAction(visualisationAction);
    }

    /**
     * DOCUMENT ME!
     *
     * @param   title    DOCUMENT ME!
     * @param   dataset  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    protected JFreeChart createChart(final String title, final Dataset dataset) {
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                title,                                                                                                   // title
                org.openide.util.NbBundle.getMessage(VisualisationPanel.class, "VisualisationPanel.chart.x-axis-label"), // x-axis label
                org.openide.util.NbBundle.getMessage(VisualisationPanel.class, "VisualisationPanel.chart.y-axis-label"), // y-axis label
                (XYDataset)dataset,                                                                                      // data
                true,                                                                                                    // create legend?
                true,                                                                                                    // generate tooltips?
                false                                                                                                    // generate URLs?
                );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        final XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }

        final DateAxis axis = (DateAxis)plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return chart;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public Collection<Parameter> getSelectedParameters() {
        return this.visualisationParameterSelectionPanel.getSelectedParameters();
    }

    /**
     * DOCUMENT ME!
     *
     * @param  parameters  DOCUMENT ME!
     */
    public void setParameters(final Collection<Parameter> parameters) {
        this.visualisationParameterSelectionPanel.setParameters(parameters);
    }
}
