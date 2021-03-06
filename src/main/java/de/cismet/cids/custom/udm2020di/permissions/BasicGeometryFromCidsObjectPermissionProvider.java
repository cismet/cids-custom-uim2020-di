/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.udm2020di.permissions;

import Sirius.navigator.connection.SessionManager;

import Sirius.server.newuser.User;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.index.strtree.STRtree;

import java.util.List;

import de.cismet.cids.dynamics.AbstractCustomBeanPermissionProvider;

import de.cismet.cismap.navigatorplugin.CidsFeature;

import static de.cismet.cids.custom.udm2020di.permissions.CidsRestrictionGeometryStore.GEOMETRY_PERMISSION_ATTR;

/**
 * DOCUMENT ME!
 *
 * @author   thorsten
 * @version  $Revision$, $Date$
 */
public abstract class BasicGeometryFromCidsObjectPermissionProvider extends AbstractCustomBeanPermissionProvider {

    //~ Instance fields --------------------------------------------------------

    protected transient org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(
            BasicGeometryFromCidsObjectPermissionProvider.class);

    //~ Methods ----------------------------------------------------------------

    @Override
    public boolean getCustomReadPermissionDecisionforUser(final User user) {
        if (user.getUserGroup().getName().equalsIgnoreCase("administratoren")
                    || user.getUserGroup().getName().equalsIgnoreCase("UDM2020")) {
//            if (LOGGER.isDebugEnabled()) {
//                LOGGER.debug("member of admin group. access is granted");
//            }
            return true;
        }

        final Geometry objectGeom = this.getGeometry();
        if (objectGeom == null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("getGeometry() delivered a null value. access is granted");
            }
            return true;
        }

        try {
            if (SessionManager.getProxy().hasConfigAttr(user, GEOMETRY_PERMISSION_ATTR)) {
                final String geometryPermission = SessionManager.getProxy()
                            .getConfigAttr(user, GEOMETRY_PERMISSION_ATTR);
                if ((geometryPermission != null) && !geometryPermission.isEmpty()) {
                    if (CidsRestrictionGeometryStore.getRestrictions().containsKey(geometryPermission)) {
                        final STRtree restrictionfeatures = CidsRestrictionGeometryStore.getRestrictions()
                                    .get(geometryPermission);

                        final List<CidsFeature> restrictionFeatures = restrictionfeatures.query(
                                objectGeom.getEnvelopeInternal());
                        if (!restrictionFeatures.isEmpty()) {
                            if (LOGGER.isDebugEnabled()) {
                                LOGGER.debug("Geometry (partially) intersects with " + restrictionFeatures.size()
                                            + " restriction geometries of '" + geometryPermission
                                            + "', checking features");
                            }
                            int i = 0;
                            for (final CidsFeature feature : restrictionFeatures) {
                                if (objectGeom.coveredBy(feature.getGeometry())) {
                                    if (LOGGER.isDebugEnabled()) {
                                        LOGGER.info("Geometry intersects with restriction geometry "
                                                    + i + " (" + geometryPermission + "), access is granted!");
                                    }
                                    return true;
                                } else {
                                    if (LOGGER.isDebugEnabled()) {
                                        LOGGER.debug("Geometry does not intersect with restriction geometry " + i);
                                    }
                                }
                                i++;
                            }

                            if (LOGGER.isDebugEnabled()) {
                                LOGGER.debug("Geometry does not intersect with restriction geometry '"
                                            + geometryPermission + "', access is denied.");
                            }
                            return false;
                        } else {
                            if (LOGGER.isDebugEnabled()) {
                                LOGGER.debug("Geometry does not intersect with restriction geometry '"
                                            + geometryPermission + "', access is denied.");
                            }
                            return false;
                        }
                    } else if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("user restriction geometry '"
                                    + geometryPermission
                                    + "' not available in loaded restriction geometries, access is granted.");
                    }
                } else if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Config attribute '" + GEOMETRY_PERMISSION_ATTR + "' empty for user '"
                                + user.getKey() + ", access is granted.");
                }
            } else if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Config attribute '" + GEOMETRY_PERMISSION_ATTR + "' not set for user '"
                            + user.getKey() + ", access is granted.");
            }
        } catch (Exception ex) {
            LOGGER.warn("could not check Geometry Permission, access denied: " + ex.getMessage(), ex);
            return false;
        }

        return true;
    }

    @Override
    public boolean getCustomWritePermissionDecisionforUser(final User user) {
        if (user.getUserGroup().getName().equalsIgnoreCase("administratoren")) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("member of admin group. permission is granted");
            }
            return true;
        }

        return false;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public abstract Geometry getGeometry();
}
