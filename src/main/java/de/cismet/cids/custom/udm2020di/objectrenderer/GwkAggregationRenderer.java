/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.objectrenderer;

import java.util.Collection;

import de.cismet.cids.dynamics.CidsBean;

import de.cismet.cids.tools.metaobjectrenderer.CidsBeanAggregationRendererPanel;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé <pascal.dihe@cismet.de>
 * @version  $Revision$, $Date$
 */
public class GwkAggregationRenderer extends CidsBeanAggregationRendererPanel {

    //~ Instance fields --------------------------------------------------------

    private transient Collection<CidsBean> cidsBeans;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.cismet.cids.custom.udm2020di.widgets.MapPanel mapPanel;
    // End of variables declaration//GEN-END:variables

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates new form NamedAreaRenderer.
     */
    public GwkAggregationRenderer() {
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
        mapPanel = new de.cismet.cids.custom.udm2020di.widgets.MapPanel();

        setLayout(new java.awt.BorderLayout());
        add(mapPanel, java.awt.BorderLayout.CENTER);
    } // </editor-fold>//GEN-END:initComponents

    @Override
    public void setCidsBeans(final Collection<CidsBean> cidsBeans) {
        this.cidsBeans = cidsBeans;
        this.init();
    }

    /**
     * DOCUMENT ME!
     */
    protected void init() {
        mapPanel.setCidsBeans(cidsBeans);
    }

    @Override
    public Collection<CidsBean> getCidsBeans() {
        return this.cidsBeans;
    }

    @Override
    public void dispose() {
        // ignore
    }

    @Override
    public String getTitle() {
        String desc = "";
        final Collection<CidsBean> beans = cidsBeans;
        if ((beans != null) && (beans.size() > 0)) {
            desc += beans.size()
                        + " Bundesländer ausgewählt";
        }
        return desc;
    }

    @Override
    public void setTitle(final String title) {
        // ignore
    }
}
