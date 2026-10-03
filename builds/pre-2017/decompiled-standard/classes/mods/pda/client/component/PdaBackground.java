/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class PdaBackground
extends GuiComponent {
    private static final Point headerUv = new Point(64, 768);
    private static final Dimension headerTexSize = new Dimension(64, 27);
    private static final Point bgUv = new Point(24, 832);
    private static final Dimension bgTexSize = new Dimension(15, 64);
    public final boolean header;
    public final boolean background;

    public PdaBackground(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl) {
        this(iAdvancedGui, point, dimension, bl, true);
    }

    public PdaBackground(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl, boolean bl2) {
        super(iAdvancedGui, point, dimension);
        this.header = bl;
        this.background = bl2;
    }

    @Override
    public void drawComponent(Point point, float f) {
        Point point2 = this.getLocation();
        Dimension dimension = this.getSize();
        GL11.glEnable(3042);
        xpzm._E()._R()._a(iedw._a);
        if (this.background) {
            this.renderer.drawTiledRect(point2, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        }
        if (this.header) {
            this.renderer.drawTiledRect(point2.add(5, 5), headerUv, new Dimension(dimension.width - 18, 27), headerTexSize, 23, 0);
        }
        this.renderer.drawTiledRect(point2.add(dimension.width - 18, 20), bgUv, new Dimension(15, dimension.height - 30), bgTexSize, 2);
        this.renderer.drawRect(point2.x + 10, point2.y + 27 + 8 + 2, dimension.width - 35, 1.0, 0x64646464);
        this.renderer.drawRect(point2.x + 10, point2.y + dimension.height - 8, dimension.width - 35, 1.0, 0x64646464);
        xpzm._E()._R()._a(iedw._b);
        this.renderer.drawTiledRect(point2.add(5, 35), Point.zeroPoint, dimension.add(-25, -40), new Dimension(718, 450), 5, 0);
        GL11.glDisable(3042);
    }
}

