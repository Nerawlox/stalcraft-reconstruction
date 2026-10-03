/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map.icon;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import org.lwjgl.util.vector.Vector2f;

public class MapIcon {
    private final MapIconType type;
    private final String name;
    private final String displayedString;
    private final Vector2f loc;

    public MapIcon(MapIconType mapIconType, String string, Vector2f vector2f) {
        this.type = mapIconType;
        this.name = string;
        this.loc = vector2f;
        this.displayedString = this.getName();
    }

    public MapIconType getType() {
        return this.type;
    }

    private String getName() {
        switch (this.type) {
            case TELEPORTATION: {
                return "\u041f\u0435\u0440\u0435\u0445\u043e\u0434: " + this.name;
            }
        }
        return this.name;
    }

    public String getDisplayedString() {
        return this.displayedString;
    }

    public Vector2f getLoc() {
        return this.loc;
    }

    public static enum MapIconType {
        TEXT,
        TELEPORTATION(new Point(276, 768), new Dimension(19, 21));

        public final Point uv;
        public final Dimension size;
        public final boolean drawIcon;

        private MapIconType(Point point, Dimension dimension) {
            this.uv = point;
            this.size = dimension;
            this.drawIcon = true;
        }

        private MapIconType() {
            this.uv = new Point(0, 0);
            this.size = new Dimension(0, 0);
            this.drawIcon = false;
        }
    }
}

