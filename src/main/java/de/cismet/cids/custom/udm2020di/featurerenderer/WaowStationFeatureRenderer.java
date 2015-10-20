/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.featurerenderer;

import org.apache.log4j.Logger;

import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import de.cismet.cids.featurerenderer.CustomCidsFeatureRenderer;

import de.cismet.cismap.commons.gui.piccolo.FeatureAnnotationSymbol;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  0.1
 */
public class WaowStationFeatureRenderer extends CustomCidsFeatureRenderer {

    //~ Static fields/initializers ---------------------------------------------

    private static final transient Logger LOG = Logger.getLogger(WaowStationFeatureRenderer.class);

    //~ Instance fields --------------------------------------------------------

    private final transient Image wagwStationPointSymbolUnselected;

    //~ Constructors -----------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TimeseriesFeatureRenderer.
     */
    public WaowStationFeatureRenderer() {
        initComponents();
        BufferedImage image = null;
        try {
            final InputStream is = getClass().getResourceAsStream("waves_16.png"); // NOI18N
            image = ImageIO.read(is);
        } catch (final IOException ex) {
            LOG.warn("cannot load wagwStation feature icon", ex);                  // NOI18N
        }

        wagwStationPointSymbolUnselected = image;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setMaximumSize(new java.awt.Dimension(300, 200));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setPreferredSize(new java.awt.Dimension(300, 200));
        setLayout(new java.awt.BorderLayout());
    } // </editor-fold>//GEN-END:initComponents

    /**
     * DOCUMENT ME!
     */
    @Override
    public void assign() {
    }

    // TODO: not necessarily only rain symbol, symbol selection must be cidsbean dependent
    @Override
    public FeatureAnnotationSymbol getPointSymbol() {
        if (wagwStationPointSymbolUnselected == null) {
            return super.getPointSymbol();
        } else {
            return FeatureAnnotationSymbol.newCustomSweetSpotFeatureAnnotationSymbol(
                    wagwStationPointSymbolUnselected,
                    null,
                    0.5,
                    0.9);
        }
    }

    @Override
    public float getTransparency() {
        return 0.9f;
    }
}
