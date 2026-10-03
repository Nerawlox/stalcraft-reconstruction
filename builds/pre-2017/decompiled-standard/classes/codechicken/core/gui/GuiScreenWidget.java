/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.core.gui.GuiDraw;
import codechicken.core.gui.GuiWidget;
import codechicken.core.gui.IGuiActionListener;
import java.awt.Point;
import java.util.ArrayList;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreenWidget
extends gqjz
implements IGuiActionListener {
    public ArrayList<GuiWidget> widgets = new ArrayList();
    public int xSize;
    public int ySize;
    public int guiTop;
    public int guiLeft;

    public GuiScreenWidget() {
        this(176, 166);
    }

    public GuiScreenWidget(int n, int n2) {
        this.xSize = n;
        this.ySize = n2;
    }

    @Override
    public void func_73866_w_() {
        this.guiTop = (this.field_73881_g - this.ySize) / 2;
        this.guiLeft = (this.field_73880_f - this.xSize) / 2;
    }

    public void reset() {
        this.func_73866_w_();
        this.widgets.clear();
        this.addWidgets();
    }

    @Override
    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        boolean bl = this.field_73882_e == null;
        super.func_73872_a(xpzm2, n, n2);
        if (bl) {
            this.addWidgets();
        }
    }

    public void add(GuiWidget guiWidget) {
        this.widgets.add(guiWidget);
        guiWidget.onAdded(this);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        GL11.glTranslated(this.guiLeft, this.guiTop, 0.0);
        this.drawBackground();
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.draw(n - this.guiLeft, n2 - this.guiTop, f);
        }
        this.drawForeground();
        GL11.glTranslated(-this.guiLeft, -this.guiTop, 0.0);
    }

    public void drawBackground() {
    }

    public void drawForeground() {
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseClicked(n - this.guiLeft, n2 - this.guiTop, n3);
        }
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseMovedOrUp(n - this.guiLeft, n2 - this.guiTop, n3);
        }
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        super.func_85041_a(n, n2, n3, l);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseDragged(n - this.guiLeft, n2 - this.guiTop, n3, l);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this.field_73882_e._B == this) {
            for (GuiWidget guiWidget : this.widgets) {
                guiWidget.update();
            }
        }
    }

    @Override
    public void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.keyTyped(c, n);
        }
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            Point point = GuiDraw.getMousePosition();
            int n2 = n > 0 ? 1 : -1;
            for (GuiWidget guiWidget : this.widgets) {
                guiWidget.mouseScrolled(point.x, point.y, n2);
            }
        }
    }

    @Override
    public void actionPerformed(String string, Object ... objectArray) {
    }

    public void addWidgets() {
    }
}

