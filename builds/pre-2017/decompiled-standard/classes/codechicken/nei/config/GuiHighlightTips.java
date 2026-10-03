/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiCCButton;
import codechicken.core.gui.GuiDraw;
import codechicken.core.gui.GuiScreenWidget;
import codechicken.lib.lang.LangUtil;
import codechicken.lib.math.MathHelper;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.HUDRenderer;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.config.OptionHighlightTips;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

public class GuiHighlightTips
extends GuiScreenWidget {
    private String name;
    private GuiCCButton toggleButton;
    private OptionHighlightTips opt;
    private Point dragDown;

    public GuiHighlightTips(OptionHighlightTips optionHighlightTips) {
        super(80, 20);
        this.opt = optionHighlightTips;
        this.name = optionHighlightTips.name;
    }

    @Override
    public boolean func_73868_f() {
        return true;
    }

    @Override
    public void addWidgets() {
        this.toggleButton = new GuiCCButton(0, 0, 80, 20, "").setActionCommand("show");
        this.add(this.toggleButton);
        this.updateNames();
    }

    @Override
    public void actionPerformed(String string, Object ... objectArray) {
        if (string.equals("show")) {
            this.opt.getTag(this.name).setBooleanValue(!this.show());
            this.updateNames();
        }
    }

    private void updateNames() {
        this.toggleButton.text = LangUtil.translateG("nei.options." + this.name + "." + (this.show() ? "show" : "hide"), new Object[0]);
    }

    private boolean show() {
        return this.opt.getTag(this.name).getBooleanValue();
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1 || n == 14) {
            GuiInfo.switchGui(this.opt.slot.getGui());
            return;
        }
        super.func_73869_a(c, n);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (this.show()) {
            HUDRenderer.renderOverlay(new cvzo(twgu.field_94341_cq), Arrays.asList("RedstoneBlock", "\u00a7cSample"), this.renderPos());
        }
    }

    public Point getPos() {
        return new Point(this.opt.getTag(this.name + ".x").getIntValue(), this.opt.getTag(this.name + ".y").getIntValue());
    }

    public Dimension sampleSize() {
        return new Dimension(101, 30);
    }

    public Point getDrag() {
        Point point = GuiDraw.getMousePosition();
        Point point2 = new Point(point.x - this.dragDown.x, point.y - this.dragDown.y);
        Dimension dimension = GuiDraw.displaySize();
        Dimension dimension2 = this.sampleSize();
        point2.x *= 10000;
        point2.y *= 10000;
        point2.x /= dimension.width - dimension2.width;
        point2.y /= dimension.height - dimension2.height;
        Point point3 = this.getPos();
        point2.x = (int)MathHelper.clip(point2.x, -point3.x, 10000 - point3.x);
        point2.y = (int)MathHelper.clip(point2.y, -point3.y, 10000 - point3.y);
        return point2;
    }

    public Point renderPos() {
        Point point = this.getPos();
        if (this.dragDown != null) {
            Point point2 = this.getDrag();
            point.x += point2.x;
            point.y += point2.y;
        }
        for (int i = 25; i < 100; i += 25) {
            if (point.x / 100 == i) {
                point.x = i * 100;
            }
            if (point.y / 100 != i) continue;
            point.y = i * 100;
        }
        return point;
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        if (n3 == 0 && this.dragDown != null) {
            this.setPos(this.renderPos());
            this.dragDown = null;
        }
    }

    public Rectangle4i selectionBox() {
        Point point = this.renderPos();
        Dimension dimension = GuiDraw.displaySize();
        Dimension dimension2 = this.sampleSize();
        return new Rectangle4i((dimension.width - dimension2.width) * point.x / 10000, (dimension.height - dimension2.height) * point.y / 10000, dimension2.width, dimension2.height);
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (n3 == 0 && this.selectionBox().contains(n, n2)) {
            this.dragDown = GuiDraw.getMousePosition();
        } else {
            super.func_73864_a(n, n2, n3);
        }
    }

    private void setPos(Point point) {
        this.opt.getTag(this.name + ".x").setIntValue(point.x);
        this.opt.getTag(this.name + ".y").setIntValue(point.y);
    }
}

