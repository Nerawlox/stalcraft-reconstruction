/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.gui.GuiDraw;
import codechicken.core.gui.GuiWidget;
import codechicken.core.gui.IGuiActionListener;
import java.awt.Point;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiContainerWidget
extends GuiContainer
implements IGuiActionListener {
    public ArrayList<GuiWidget> widgets = new ArrayList();

    public GuiContainerWidget(Container container) {
        this(container, 176, 166);
    }

    public GuiContainerWidget(Container container, int n, int n2) {
        super(container);
        this.xSize = n;
        this.ySize = n2;
    }

    public void reset() {
        this.widgets.clear();
        this.addWidgets();
    }

    @Override
    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        boolean bl = this.mc == null;
        super.setWorldAndResolution(minecraft, n, n2);
        if (bl) {
            this.addWidgets();
        }
    }

    public void add(GuiWidget guiWidget) {
        this.widgets.add(guiWidget);
        guiWidget.onAdded(this);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glTranslated(this.guiLeft, this.guiTop, 0.0);
        this.drawBackground();
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.draw(n - this.guiLeft, n2 - this.guiTop, f);
        }
        GL11.glTranslated(-this.guiLeft, -this.guiTop, 0.0);
    }

    public void drawBackground() {
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseClicked(n - this.guiLeft, n2 - this.guiTop, n3);
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        super.mouseMovedOrUp(n, n2, n3);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseMovedOrUp(n - this.guiLeft, n2 - this.guiTop, n3);
        }
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        super.mouseClickMove(n, n2, n3, l);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.mouseDragged(n - this.guiLeft, n2 - this.guiTop, n3, l);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.mc._B == this) {
            for (GuiWidget guiWidget : this.widgets) {
                guiWidget.update();
            }
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        for (GuiWidget guiWidget : this.widgets) {
            guiWidget.keyTyped(c, n);
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
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

