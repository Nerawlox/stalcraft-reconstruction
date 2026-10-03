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
import net.minecraft.client.xpzm;
import org.lwjgl.input.Mouse;

public class GuiContainerAdvanced
extends zybc
implements IAdvancedGui {
    public GuiRenderer renderer;
    public GuiComponentsList elementsList = new GuiComponentsList(this);
    public ActionManager actionManager = new ActionManager(this);
    public int screenWidth;
    public int screenHeight;

    public GuiContainerAdvanced(jjgc jjgc2) {
        this(jjgc2, GuiComponent.hdRenderer);
    }

    public GuiContainerAdvanced(jjgc jjgc2, GuiRenderer guiRenderer) {
        super(jjgc2);
        this.renderer = guiRenderer;
    }

    @Override
    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        this.actionManager.setLoaded(false);
        this.screenWidth = n * 2;
        this.screenHeight = n2 * 2;
        this.elementsList.clearElements();
        super.func_73872_a(xpzm2, n, n2);
        this.actionManager.setLoaded(true);
    }

    public void addElement(GuiComponent guiComponent) {
        this.elementsList.addElement(guiComponent);
    }

    public void removeElement(GuiComponent guiComponent) {
        this.elementsList.removeElement(guiComponent);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        this.elementsList.drawComponent(new Point(n * 2, n2 * 2), f);
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        this.elementsList.keyTyped(c, n);
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.elementsList.mouseClicked(n3);
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        super.func_73879_b(n, n2, n3);
        if (n3 == -1) {
            this.elementsList.mouseDrag(-1);
        } else {
            this.elementsList.mouseUp(n3);
        }
    }

    @Override
    protected void func_85041_a(int n, int n2, int n3, long l) {
        super.func_85041_a(n, n2, n3, l);
        this.elementsList.mouseDrag(n3);
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        this.elementsList.handleWheel(Mouse.getEventDWheel());
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this.elementsList.tick();
    }

    @Override
    public gqjz getGui() {
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

