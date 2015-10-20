/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.objectrenderer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.cismet.cids.custom.udm2020di.indeximport.OracleImport;
import de.cismet.cids.custom.udm2020di.types.wa.GwMessstelle;
import de.cismet.cids.custom.udm2020di.types.wa.Messstelle;
import de.cismet.cids.custom.udm2020di.types.wa.OwMessstelle;
import de.cismet.cids.custom.udm2020di.widgets.MaxParameterValueSelectionPanel;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
public class WaowStationRenderer extends WagwStationRenderer {

    //~ Methods ----------------------------------------------------------------

    @Override
    protected Messstelle deserializeStation() throws IOException {
        return OracleImport.JSON_MAPPER.readValue(WaowStationRenderer.this.getCidsBean().getProperty("src_content")
                        .toString(),
                OwMessstelle.class);
    }

    @Override
    protected void addCustomStationLabels(
            final GridBagConstraints gridBagConstraints,
            final Messstelle messstelle) {
        final OwMessstelle owMessstelle = (OwMessstelle)messstelle;
        JLabel label;

        if ((owMessstelle.getOperativ() != null)
                    && !owMessstelle.getOperativ().isEmpty()) {
            gridBagConstraints.gridy++;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.weightx = 0.0;
            label = new JLabel("Operativ:");
            label.setMaximumSize(new Dimension(150, 50));
            standortdatenPanel.add(label, gridBagConstraints);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.weightx = 1.0;
            label = new JLabel("<html>" + owMessstelle.getOperativ() + "</html>");
            label.setMaximumSize(new Dimension(200, 50));
            standortdatenPanel.add(label, gridBagConstraints);
        }

        if ((owMessstelle.getGewaessername() != null)
                    && !owMessstelle.getGewaessername().isEmpty()) {
            gridBagConstraints.gridy++;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.weightx = 0.0;
            label = new JLabel("Gewässername:");
            label.setMaximumSize(new Dimension(150, 50));
            standortdatenPanel.add(label, gridBagConstraints);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.weightx = 1.0;
            label = new JLabel("<html>" + owMessstelle.getGewaessername() + "</html>");
            label.setMaximumSize(new Dimension(200, 50));
            standortdatenPanel.add(label, gridBagConstraints);
        }

        if ((owMessstelle.getGewaesserEzk() != null)
                    && !owMessstelle.getGewaesserEzk().isEmpty()) {
            gridBagConstraints.gridy++;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.weightx = 0.0;
            label = new JLabel("Einzugsgebietsgrößenklasse:");
            label.setMaximumSize(new Dimension(150, 50));
            standortdatenPanel.add(label, gridBagConstraints);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            label = new JLabel("<html>" + owMessstelle.getGewaesserEzk() + "</html>");
            label.setMaximumSize(new Dimension(200, 50));
            standortdatenPanel.add(label, gridBagConstraints);
        }
    }
}
