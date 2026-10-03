/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map.icon;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import org.lwjgl.util.vector.Vector2f;

public class MapSavezone {
    public static final Point UV = new Point(328, 768);
    public static final Dimension SIZE = new Dimension(29, 29);
    private String id;
    private String name;
    private IconFaction faction;
    private Vector2f pos;

    public MapSavezone(String string, String string2, IconFaction iconFaction, Vector2f vector2f) {
        this.id = string;
        this.name = string2;
        this.faction = iconFaction;
        this.pos = vector2f;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public IconFaction getFaction() {
        return this.faction;
    }

    public Vector2f getPos() {
        return this.pos;
    }

    public int getColor(tupg tupg2) {
        if (this.faction == IconFaction.ALL) {
            return -256;
        }
        if (this.faction.playerFaction == tupg2) {
            return -16711936;
        }
        return -65536;
    }

    public static enum IconFaction {
        ALL(null),
        BANDITS(tupg._c),
        STALKERS(tupg._b);

        public final tupg playerFaction;

        private IconFaction(tupg tupg2) {
            this.playerFaction = tupg2;
        }
    }
}

