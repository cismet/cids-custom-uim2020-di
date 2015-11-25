/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.widgets;

import org.apache.log4j.Logger;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;

import org.openide.util.WeakListeners;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JCheckBox;

import de.cismet.cids.custom.udm2020di.actions.remote.ExportAction;
import de.cismet.cids.custom.udm2020di.types.Parameter;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
public class ExportParameterSelectionPanel extends javax.swing.JPanel implements ItemListener {

    //~ Static fields/initializers ---------------------------------------------

    protected static final Logger LOGGER = Logger.getLogger(ExportParameterSelectionPanel.class);

    //~ Instance fields --------------------------------------------------------

    protected transient org.jdesktop.beansbinding.BindingGroup bindingGroup;

    protected final transient SortedSet<Parameter> parameters = new TreeSet<Parameter>();

    protected final transient List selectedParameters = Collections.synchronizedList(new ArrayList());

    protected boolean disableEvents = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected final javax.swing.JPanel actionPanel = new javax.swing.JPanel();
    protected final javax.swing.JButton btnExport = new javax.swing.JButton();
    protected final javax.swing.JButton btnReset = new javax.swing.JButton();
    protected final javax.swing.JButton btnSelectAll = new javax.swing.JButton();
    protected final javax.swing.ButtonGroup exportButtonGroup = new javax.swing.ButtonGroup();
    protected final javax.swing.JLabel formatLabel = new javax.swing.JLabel();
    protected final javax.swing.JRadioButton rbtnCsv = new javax.swing.JRadioButton();
    protected final javax.swing.JRadioButton rbtnShp = new javax.swing.JRadioButton();
    protected final javax.swing.JRadioButton rbtnXlsx = new javax.swing.JRadioButton();
    protected final javax.swing.JPanel selectionPanel = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form ParameterSelectionPanel.
     */
    public ExportParameterSelectionPanel() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
        initComponents();
    }

    /**
     * Creates a new ExportParameterSelectionPanel object.
     *
     * @param  narrowLayout  DOCUMENT ME!
     */
    public ExportParameterSelectionPanel(final boolean narrowLayout) {
        this();

        if (narrowLayout) {
            this.selectionPanel.setLayout(new java.awt.GridLayout(0, 2, 5, 5));
        }
    }

    /**
     * Creates a new ParameterSelectionPanel object.
     *
     * @param  parameters  DOCUMENT ME!
     */
    public ExportParameterSelectionPanel(final Collection<Parameter> parameters) {
        this();
        this.setParameters(parameters);
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

        setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5),
                javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createTitledBorder(
                        org.openide.util.NbBundle.getMessage(
                            ExportParameterSelectionPanel.class,
                            "ExportParameterSelectionPanel.border.insideBorder.outsideBorder.title")),
                    javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)))); // NOI18N
        setMinimumSize(new java.awt.Dimension(500, 100));
        setLayout(new java.awt.BorderLayout(5, 5));

        selectionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        selectionPanel.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
        add(selectionPanel, java.awt.BorderLayout.CENTER);

        actionPanel.setPreferredSize(new java.awt.Dimension(571, 46));
        actionPanel.setLayout(new java.awt.GridBagLayout());

        btnExport.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.btnExport.text"));          // NOI18N
        btnExport.setActionCommand(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.btnExport.actionCommand")); // NOI18N
        btnExport.setAutoscrolls(true);
        exportButtonGroup.add(btnExport);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(btnExport, gridBagConstraints);

        btnReset.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.btnReset.text"));          // NOI18N
        btnReset.setActionCommand(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.btnReset.actionCommand")); // NOI18N
        exportButtonGroup.add(btnReset);
        btnReset.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    btnResetActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(btnReset, gridBagConstraints);

        btnSelectAll.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.btnSelectAll.text")); // NOI18N
        exportButtonGroup.add(btnSelectAll);
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(final java.awt.event.ActionEvent evt) {
                    btnSelectAllActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(btnSelectAll, gridBagConstraints);

        formatLabel.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.formatLabel.text")); // NOI18N
        formatLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(formatLabel, gridBagConstraints);

        exportButtonGroup.add(rbtnCsv);
        rbtnCsv.setSelected(true);
        rbtnCsv.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnCsv.text"));        // NOI18N
        rbtnCsv.setToolTipText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnCsv.toolTipText")); // NOI18N
        rbtnCsv.addItemListener(new java.awt.event.ItemListener() {

                @Override
                public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                    exportFormatSelected(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(rbtnCsv, gridBagConstraints);

        exportButtonGroup.add(rbtnXlsx);
        rbtnXlsx.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnXlsx.text"));        // NOI18N
        rbtnXlsx.setToolTipText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnXlsx.toolTipText")); // NOI18N
        rbtnXlsx.addItemListener(new java.awt.event.ItemListener() {

                @Override
                public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                    exportFormatSelected(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(rbtnXlsx, gridBagConstraints);

        exportButtonGroup.add(rbtnShp);
        rbtnShp.setText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnShp.text"));        // NOI18N
        rbtnShp.setToolTipText(org.openide.util.NbBundle.getMessage(
                ExportParameterSelectionPanel.class,
                "ExportParameterSelectionPanel.rbtnShp.toolTipText")); // NOI18N
        rbtnShp.addItemListener(new java.awt.event.ItemListener() {

                @Override
                public void itemStateChanged(final java.awt.event.ItemEvent evt) {
                    exportFormatSelected(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        actionPanel.add(rbtnShp, gridBagConstraints);

        add(actionPanel, java.awt.BorderLayout.SOUTH);
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void btnResetActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnResetActionPerformed
        this.disableEvents = true;
        if ((this.parameters != null) && !this.parameters.isEmpty()) {
            for (final Parameter parameter : this.parameters) {
                parameter.setSelected(false);
            }
        }
        this.disableEvents = false;
        this.enableButtons();
    }                                                                            //GEN-LAST:event_btnResetActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void btnSelectAllActionPerformed(final java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnSelectAllActionPerformed
        this.disableEvents = true;
        for (final Parameter parameter : this.parameters) {
            parameter.setSelected(true);
        }
        this.disableEvents = false;
        this.enableButtons();
    }                                                                                //GEN-LAST:event_btnSelectAllActionPerformed

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    private void exportFormatSelected(final java.awt.event.ItemEvent evt) { //GEN-FIRST:event_exportFormatSelected
        // TODO add your handling code here:

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            final ExportAction exportAction = this.getExportAction();
            if (exportAction != null) {
                if (evt.getItemSelectable() == this.rbtnCsv) {
                    exportAction.setExportFormat(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_CSV);
                } else if (evt.getItemSelectable() == this.rbtnXlsx) {
                    exportAction.setExportFormat(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_XLSX);
                } else if (evt.getItemSelectable() == this.rbtnShp) {
                    exportAction.setExportFormat(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_SHP);
                } else {
                    LOGGER.warn("unsupported export format: " + evt.getItem());
                }
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("export format '" + exportAction.getExportFormat() + "' selected");
                }
            }
        }
    } //GEN-LAST:event_exportFormatSelected

    /**
     * Get the value of parameters.
     *
     * @return  the value of parameters
     */
    public final Collection<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Set the value of parameters.
     *
     * @param  parameters  new value of parameters
     */
    public final void setParameters(final Collection<Parameter> parameters) {
        this.parameters.addAll(parameters);

        ExportParameterSelectionPanel.this.selectionPanel.removeAll();
        bindingGroup.unbind();
        if ((parameters != null) && !ExportParameterSelectionPanel.this.parameters.isEmpty()) {
            for (final Parameter parameter : ExportParameterSelectionPanel.this.parameters) {
                final JCheckBox checkBox = new JCheckBox(parameter.getParameterName());
                checkBox.addItemListener(WeakListeners.create(
                        ItemListener.class,
                        ExportParameterSelectionPanel.this,
                        checkBox));
                ExportParameterSelectionPanel.this.selectionPanel.add(checkBox);
                final Binding binding = Bindings.createAutoBinding(
                        AutoBinding.UpdateStrategy.READ_WRITE,
                        parameter,
                        ELProperty.create("${selected}"),
                        checkBox,
                        BeanProperty.create("selected"));
                bindingGroup.addBinding(binding);
            }

            bindingGroup.bind();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public final Collection<Parameter> getSelectedParameters() {
        synchronized (selectedParameters) {
            selectedParameters.clear();
            if ((this.parameters != null) && !this.parameters.isEmpty()) {
//                if (LOGGER.isDebugEnabled()) {
//                    LOGGER.debug("selecting parameters of " + this.parameters.size() + " parameters");
//                }
                for (final Parameter parameter : this.parameters) {
                    if (parameter.isSelected()) {
                        selectedParameters.add(parameter);
                    }
                }
            }
        }
        return selectedParameters;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  selectedParameters  DOCUMENT ME!
     */
    public void setSelectedParameters(final Collection<Parameter> selectedParameters) {
        synchronized (this.selectedParameters) {
            this.selectedParameters.clear();
            if ((this.parameters != null) && !this.parameters.isEmpty()) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("selecting " + selectedParameters.size() + " of " + this.parameters.size()
                                + " parameters");
                }

                final HashSet selectedParameterPks = new HashSet<String>(selectedParameters.size());
                for (final Parameter selectedParameter : selectedParameters) {
                    selectedParameterPks.add(selectedParameter.getParameterPk());
                }

                for (final Parameter parameter : this.parameters) {
                    parameter.setSelected(selectedParameterPks.contains(parameter.getParameterPk()));
                }

                if (this.selectedParameters.size() != selectedParameters.size()) {
                    LOGGER.warn("only " + this.selectedParameters.size() + " of "
                                + selectedParameters.size() + " parameters selected!");
                }
            } else {
                LOGGER.warn("cannot select parameters, parameter list is empty!");
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param  exportAction  DOCUMENT ME!
     */
    public void setExportAction(final ExportAction exportAction) {
        btnExport.setAction(exportAction);
    }

    /**
     * DOCUMENT ME!
     *
     * @param  exportFormat  DOCUMENT ME!
     */
    public void setExportFormat(final String exportFormat) {
        if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_CSV)) {
            this.rbtnCsv.setSelected(true);
        } else if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_XLSX)) {
            this.rbtnXlsx.setSelected(true);
        } else if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_SHP)) {
            this.rbtnShp.setSelected(true);
        } else {
            LOGGER.warn("unsupported export format: " + exportFormat);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param  exportFormat  DOCUMENT ME!
     * @param  enabled       DOCUMENT ME!
     */
    public void setExportFormatEnabled(final String exportFormat, final boolean enabled) {
        if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_CSV)) {
            this.rbtnCsv.setEnabled(enabled);
        } else if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_XLSX)) {
            this.rbtnXlsx.setEnabled(enabled);
        } else if (exportFormat.equals(
                        de.cismet.cids.custom.udm2020di.serveractions.AbstractExportAction.PARAM_EXPORTFORMAT_SHP)) {
            this.rbtnShp.setEnabled(enabled);
        } else {
            LOGGER.warn("unsupported export format: " + exportFormat);
        }
    }

    /**
     * Get the value of exportAction.
     *
     * @return  the value of exportAction
     */
    public ExportAction getExportAction() {
        return ((btnExport.getAction() != null)
                        && ExportAction.class.isAssignableFrom(btnExport.getAction().getClass()))
            ? (ExportAction)btnExport.getAction() : null;
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {
        if (!this.disableEvents) {
            this.enableButtons();
        }
    }

    /**
     * DOCUMENT ME!
     */
    protected void enableButtons() {
        final Collection<Parameter> selParameters = this.getSelectedParameters();

        if (selParameters.isEmpty()) {
            this.btnExport.setEnabled(false);
            this.btnReset.setEnabled(false);
        } else {
            this.btnExport.setEnabled(true);
            this.btnReset.setEnabled(true);
        }

        if (selParameters.size() == this.parameters.size()) {
            this.btnSelectAll.setEnabled(false);
        } else {
            this.btnSelectAll.setEnabled(true);
        }
    }
}
