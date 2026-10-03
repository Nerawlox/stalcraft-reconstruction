/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.waypoint;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.client.waypoint.MapWaypoint;
import org.lwjgl.util.vector.Vector3f;

public class UserWaypoint
implements MapWaypoint {
    private static final Point uv = new Point(273, 797);
    private static final Point worldUv = new Point(0, 128);
    private static final Dimension size = new Dimension(23, 18);
    @SerializedName(value="name")
    private final String name;
    @SerializedName(value="pos")
    private final Vector3f pos;
    @SerializedName(value="color")
    private final int color;
    @SerializedName(value="time")
    private final long time;

    public UserWaypoint(String string, Vector3f vector3f, int n) {
        this.name = string;
        this.pos = vector3f;
        this.color = n;
        this.time = System.currentTimeMillis();
    }

    public UserWaypoint(String string, Vector3f vector3f, int n, long l) {
        this.name = string;
        this.pos = vector3f;
        this.color = n;
        this.time = l;
    }

    @Override
    public String title() {
        return this.name;
    }

    @Override
    public Vector3f worldPos() {
        return this.pos;
    }

    @Override
    public int color() {
        return this.color;
    }

    @Override
    public Point uv() {
        return uv;
    }

    @Override
    public Dimension size() {
        return size;
    }

    @Override
    public Point worldUv() {
        return worldUv;
    }

    @Override
    public Dimension worldSize() {
        return MapWaypoint.SIZE_128;
    }

    public long getTime() {
        return this.time;
    }
}

