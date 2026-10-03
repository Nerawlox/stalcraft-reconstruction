/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.waypoint;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.PdaMod;
import mods.pda.client.waypoint.MapWaypoint;
import org.lwjgl.util.vector.Vector3f;

public class QuestWaypoint
implements MapWaypoint {
    private static final Point worldUvActive = new Point(128, 0);
    private static final Point worldUv = new Point(128, 128);
    private static final Point uv = new Point(201, 769);
    private static final Dimension size = new Dimension(23, 23);
    private int id;
    private String name;
    private Vector3f pos;
    private float areaRadius;

    public QuestWaypoint(int n, String string, Vector3f vector3f) {
        this(n, string, vector3f, 0.0f);
    }

    public QuestWaypoint(int n, String string, Vector3f vector3f, float f) {
        this.id = n;
        this.name = string;
        this.pos = vector3f;
        this.areaRadius = f;
    }

    public boolean hasArea() {
        return this.areaRadius > 0.0f;
    }

    public float getAreaRadius() {
        return this.areaRadius;
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
        if (PdaMod.getClientPda().primaryQuests.contains(this.id)) {
            return -10496;
        }
        if (this.id == PdaMod.instance.quests.getActiveQuest()) {
            return -16711936;
        }
        return -1;
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
        return this.id == PdaMod.instance.quests.getActiveQuest() ? worldUvActive : worldUv;
    }

    @Override
    public Dimension worldSize() {
        return MapWaypoint.SIZE_128;
    }

    public int getId() {
        return this.id;
    }
}

