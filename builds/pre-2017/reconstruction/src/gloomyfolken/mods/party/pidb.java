/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.client.waypoint.MapWaypoint;
import org.lwjgl.util.vector.Vector3f;

@ezey(_a={eidj.CLIENT})
public class pidb
implements MapWaypoint {
    private static final Point _b = new Point(435, 878);
    private static final Point _c = new Point(256, 0);
    private static final Dimension _d = new Dimension(23, 23);
    public final qlqj _a;
    private Vector3f _e;

    public pidb(qlqj qlqj2) {
        this._a = qlqj2;
        this._e = new Vector3f(qlqj2._c().x, qlqj2._c().y, qlqj2._c().z);
    }

    @Override
    public String title() {
        return this._a._d() + (this._a._b().isEmpty() ? "" : ": " + this._a._b());
    }

    @Override
    public Vector3f worldPos() {
        return this._e;
    }

    @Override
    public int color() {
        return -16716289;
    }

    @Override
    public Point uv() {
        return _b;
    }

    @Override
    public Dimension size() {
        return _d;
    }

    @Override
    public Point worldUv() {
        return _c;
    }

    @Override
    public Dimension worldSize() {
        return MapWaypoint.SIZE_128;
    }
}

