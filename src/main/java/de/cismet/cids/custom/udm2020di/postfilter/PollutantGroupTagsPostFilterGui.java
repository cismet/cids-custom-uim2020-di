/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.postfilter;

import Sirius.navigator.ui.tree.postfilter.PostFilterGUI;

import org.apache.log4j.Logger;

import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

import javax.swing.ImageIcon;

/**
 * DOCUMENT ME!
 *
 * @author   Pascal Dihé
 * @version  $Revision$, $Date$
 */
@ServiceProvider(service = PostFilterGUI.class)
public class PollutantGroupTagsPostFilterGui extends CommonTagsPostFilterGui {

    //~ Static fields/initializers ---------------------------------------------

    public static final String TAG_GROUP = "POLLUTANTGROUP";

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new PollutantGroupTagsPostFilterGui object.
     */
    public PollutantGroupTagsPostFilterGui() {
        super();
        LOGGER = Logger.getLogger(PollutantGroupTagsPostFilterGui.class);
        icon = new ImageIcon(getClass().getResource(
                    NbBundle.getMessage(
                        CommonTagsPostFilterGui.class,
                        "PollutantGroupTagsPostFilterGui.icon")));
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    @Override
    public String getTitle() {
        return org.openide.util.NbBundle.getMessage(
                CommonTagsPostFilterGui.class,
                "PollutantGroupTagsPostFilterGui.title");
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    @Override
    public Integer getDisplayOrderKeyPrio() {
        return super.getDisplayOrderKeyPrio() - 20;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    @Override
    protected String getFilterTagGroup() {
        return TAG_GROUP;
    }
}
