/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.waypoint;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.concurrent.TimeUnit;
import mods.pda.client.PdaClient;
import mods.pda.client.waypoint.MapWaypoint;
import mods.pda.client.waypoint.UserWaypoint;
import org.lwjgl.util.vector.Vector3f;

public class DeathWaypoint
extends UserWaypoint {
    private static final Point uv = new Point(350, 801);
    private static final Dimension size = new Dimension(23, 23);

    public DeathWaypoint(Vector3f vector3f, int n) {
        super("", vector3f, n);
    }

    public DeathWaypoint(Vector3f vector3f, int n, long l) {
        super("", vector3f, n, l);
    }

    @Override
    public String title() {
        return "";
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
    public Dimension worldSize() {
        return MapWaypoint.SIZE_128;
    }

    @Override
    public Point worldUv() {
        return Point.zeroPoint;
    }

    @Override
    public boolean enabled() {
        long l = TimeUnit.MINUTES.toMillis(PdaClient.deathPointsTime.value);
        return PdaClient.enableDeathPoints.enabled && System.currentTimeMillis() - this.getTime() < l;
    }
}

