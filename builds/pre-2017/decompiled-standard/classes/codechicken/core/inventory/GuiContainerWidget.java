/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.gui.GuiDraw;
import codechicken.core.gui.GuiWidget;
import codechicken.core.gui.IGuiActionListener;
import java.awt.Point;
import java.util.ArrayList;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiContainerWidget
extends zybc
implements IGuiActionListener {
    public ArrayList<GuiWidget> widgets = new ArrayList();

    public GuiContainerWidget(jjgc jjgc2) {
        this(jjgc2, 176, 166);
    }

    public GuiContainerWidget(jjgc jjgc2, int n, int n2) {
        super(jjgc2);
        this.field_74194_b = n;
        this.field_74195_c = n2;
    }

    public void reset() {
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
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glTranslated(this.field_74198_m, this.field_74197_n, 0.0);
        this.drawBackground();
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.draw(n - this.field_74198_m, n2 - this.field_74197_n, f);
        }
        GL11.glTranslated(-this.field_74198_m, -this.field_74197_n, 0.0);
    }

    public void drawBackground() {
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseClicked(n - this.field_74198_m, n2 - this.field_74197_n, n3);
        }
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseMovedOrUp(n - this.field_74198_m, n2 - this.field_74197_n, n3);
        }
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        super.func_85041_a(n, n2, n3, l);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseDragged(n - this.field_74198_m, n2 - this.field_74197_n, n3, l);
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

