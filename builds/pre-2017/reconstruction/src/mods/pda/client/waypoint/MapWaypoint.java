/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.waypoint;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import org.lwjgl.util.vector.Vector3f;

public interface MapWaypoint {
    public static final Dimension SIZE_128 = new Dimension(128, 128);

    public String title();

    public Vector3f worldPos();

    public int color();

    public Point uv();

    public Dimension size();

    public Point worldUv();

    public Dimension worldSize();

    default public boolean enabled() {
        return true;
    }
}

