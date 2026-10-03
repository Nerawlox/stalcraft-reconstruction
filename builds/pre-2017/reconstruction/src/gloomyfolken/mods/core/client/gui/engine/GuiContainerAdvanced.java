/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import org.lwjgl.input.Mouse;

public class GuiContainerAdvanced
extends GuiContainer
implements IAdvancedGui {
    public GuiRenderer renderer;
    public GuiComponentsList elementsList = new GuiComponentsList(this);
    public ActionManager actionManager = new ActionManager(this);
    public int screenWidth;
    public int screenHeight;

    public GuiContainerAdvanced(Container container) {
        this(container, GuiComponent.hdRenderer);
    }

    public GuiContainerAdvanced(Container container, GuiRenderer guiRenderer) {
        super(container);
        this.renderer = guiRenderer;
    }

    @Override
    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        this.actionManager.setLoaded(false);
        this.screenWidth = n * 2;
        this.screenHeight = n2 * 2;
        this.elementsList.clearElements();
        super.setWorldAndResolution(minecraft, n, n2);
        this.actionManager.setLoaded(true);
    }

    public void addElement(GuiComponent guiComponent) {
        this.elementsList.addElement(guiComponent);
    }

    public void removeElement(GuiComponent guiComponent) {
        this.elementsList.removeElement(guiComponent);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        this.elementsList.drawComponent(new Point(n * 2, n2 * 2), f);
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        this.elementsList.keyTyped(c, n);
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.elementsList.mouseClicked(n3);
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        super.mouseMovedOrUp(n, n2, n3);
        if (n3 == -1) {
            this.elementsList.mouseDrag(-1);
        } else {
            this.elementsList.mouseUp(n3);
        }
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        super.mouseClickMove(n, n2, n3, l);
        this.elementsList.mouseDrag(n3);
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        this.elementsList.handleWheel(Mouse.getEventDWheel());
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.elementsList.tick();
    }

    @Override
    public GuiScreen getGui() {
        return this;
    }

    @Override
    public GuiRenderer getRenderer() {
        return this.renderer;
    }

    @Override
    public GuiComponentsList getElementsList() {
        return this.elementsList;
    }

    @Override
    public ActionManager getActionManager() {
        return this.actionManager;
    }
}

