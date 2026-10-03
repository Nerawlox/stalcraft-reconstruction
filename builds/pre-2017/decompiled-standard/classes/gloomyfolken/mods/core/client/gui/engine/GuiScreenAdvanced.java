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
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiScreenAdvanced
extends gqjz
implements IAdvancedGui {
    protected GuiRenderer renderer;
    protected GuiComponentsList<GuiComponent> elementsList = new GuiComponentsList(this);
    protected ActionManager actionManager = new ActionManager(this);
    protected int screenWidth;
    protected int screenHeight;
    protected int guiTop;
    protected int guiLeft;
    protected int guiWidth;
    protected int guiHeight;
    protected gqjz parentScreen;
    protected boolean closeOnEsc = true;
    protected boolean drawParentScreen = true;

    public GuiScreenAdvanced() {
        this(GuiComponent.hdRenderer, 0, 0);
    }

    public GuiScreenAdvanced(GuiRenderer guiRenderer) {
        this(guiRenderer, 0, 0);
    }

    public GuiScreenAdvanced(GuiRenderer guiRenderer, int n, int n2) {
        this(guiRenderer, n, n2, null);
    }

    public GuiScreenAdvanced(GuiRenderer guiRenderer, int n, int n2, gqjz gqjz2) {
        this.renderer = guiRenderer;
        this.guiWidth = n;
        this.guiHeight = n2;
        Keyboard.enableRepeatEvents(true);
        this.parentScreen = gqjz2;
    }

    @Override
    public void func_73872_a(xpzm xpzm2, int n, int n2) {
        this.actionManager.setLoaded(false);
        this.screenWidth = n * 2;
        this.screenHeight = n2 * 2;
        this.guiLeft = this.screenWidth / 2 - this.guiWidth / 2;
        this.guiTop = this.screenHeight / 2 - this.guiHeight / 2;
        this.elementsList.clearElements();
        super.func_73872_a(xpzm2, n, n2);
        this.actionManager.setLoaded(true);
        if (this.parentScreen != null) {
            this.parentScreen.func_73872_a(xpzm2, n, n2);
        }
    }

    public void addElement(GuiComponent guiComponent) {
        this.elementsList.addElement(guiComponent);
    }

    public void removeElement(GuiComponent guiComponent) {
        this.elementsList.removeElement(guiComponent);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        if (this.drawParentScreen && this.parentScreen != null) {
            this.parentScreen.func_73863_a(-1000, -1000, 0.0f);
        }
        this.elementsList.drawComponent(new Point(n * 2, n2 * 2), f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73869_a(char c, int n) {
        if (this.closeOnEsc && n == 1) {
            this.closeScreen();
            return;
        }
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
    public GuiComponentsList<GuiComponent> getElementsList() {
        return this.elementsList;
    }

    @Override
    public ActionManager getActionManager() {
        return this.actionManager;
    }

    @Override
    public void func_73874_b() {
        this.elementsList.unfocuseAll();
        Keyboard.enableRepeatEvents(false);
    }

    public GuiScreenAdvanced setParentScreen(gqjz gqjz2) {
        this.parentScreen = gqjz2;
        return this;
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getGuiTop() {
        return this.guiTop;
    }

    public int getGuiLeft() {
        return this.guiLeft;
    }

    public int getGuiWidth() {
        return this.guiWidth;
    }

    public int getGuiHeight() {
        return this.guiHeight;
    }

    public void closeScreen() {
        this.elementsList.unfocuseAll();
        this.field_73882_e._a(this.parentScreen);
    }

    public gqjz getParentScreen() {
        return this.parentScreen;
    }
}

