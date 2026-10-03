/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class McToolTip
extends GuiComponent {
    protected GuiComponent element;
    protected List<String> lines;
    private static xpzm mc = xpzm._E();

    public McToolTip(IAdvancedGui iAdvancedGui, List<String> list, GuiComponent guiComponent) {
        super(iAdvancedGui, Point.zeroPoint, Dimension.zeroDimension);
        this.element = guiComponent;
        this.lines = list;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.lines.isEmpty()) {
            return;
        }
        GuiComponent guiComponent = this.parent.getElementsList().getElementMouseOver();
        if (guiComponent == this.element) {
            this.forceDraw(point);
        }
    }

    protected void forceDraw(Point point) {
        GL11.glPushAttrib(1048575);
        this.drawHoveringText(this.lines, point);
        GL11.glPopAttrib();
    }

    protected void drawHoveringText(List<String> list, Point point) {
        if (!list.isEmpty()) {
            int n;
            GL11.glDisable(32826);
            qnon._a();
            GL11.glDisable(2896);
            int n2 = 0;
            for (String string : list) {
                n = this.renderer.getStringWidth(string);
                if (n <= n2) continue;
                n2 = n;
            }
            int n3 = point.x + 24;
            n = point.y - 24;
            int n4 = 16;
            if (list.size() > 1) {
                n4 += 4 + (list.size() - 1) * 20;
            }
            if (n3 + n2 > this.parent.getGui().field_73880_f * 2) {
                n3 -= 56 + n2;
            }
            if (n + n4 + 12 > this.parent.getGui().field_73881_g * 2) {
                n = this.parent.getGui().field_73881_g * 2 - n4 - 12;
            }
            int n5 = -267386864;
            this.renderer.drawGradientRect(n3 - 6, n - 8, n2 + 12, 2.0, n5, n5);
            this.renderer.drawGradientRect(n3 - 6, n + n4 + 6, n2 + 12, 2.0, n5, n5);
            this.renderer.drawGradientRect(n3 - 6, n - 6, n2 + 12, n4 + 14, n5, n5);
            this.renderer.drawGradientRect(n3 - 8, n - 6, 2.0, n4 + 12, n5, n5);
            this.renderer.drawGradientRect(n3 + n2 + 6, n - 6, 2.0, n4 + 12, n5, n5);
            int n6 = 0x505000FF;
            int n7 = (n6 & 0xFEFEFE) >> 1 | n6 & 0xFF000000;
            this.renderer.drawGradientRect(n3 - 6, n - 4, 2.0, n4 + 8, n6, n7);
            this.renderer.drawGradientRect(n3 + n2 + 4, n - 4, 2.0, n4 + 8, n6, n7);
            this.renderer.drawGradientRect(n3 - 6, n - 6, n2 + 12, 2.0, n6, n6);
            this.renderer.drawGradientRect(n3 - 6, n + n4 + 4, n2 + 12, 2.0, n7, n7);
            for (int i = 0; i < list.size(); ++i) {
                String string = list.get(i);
                this.renderer.drawString(string, n3, n, -1);
                if (i == 0) {
                    n += 4;
                }
                n += 20;
            }
            GL11.glEnable(2929);
            qnon._b();
            GL11.glEnable(32826);
        }
    }
}

