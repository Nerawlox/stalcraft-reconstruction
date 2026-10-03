/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McItemToolTip;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import java.util.HashMap;
import java.util.function.Consumer;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class McDummySlot
extends GuiComponent {
    private static final int BASE_SIZE = 32;
    private static xpzm mc = xpzm._E();
    private static HashMap<Class<? extends tgdv>, Consumer<cvzo>> clickListeners = new HashMap();
    public final float scale;
    public cvzo stack;
    private GuiRenderer.RenderItemHD itemRenderer;

    public McDummySlot(IAdvancedGui iAdvancedGui, cvzo cvzo2, int n, int n2, float f) {
        this(iAdvancedGui, cvzo2, new Point(n, n2), f);
    }

    public McDummySlot(IAdvancedGui iAdvancedGui, cvzo cvzo2, Point point, float f) {
        super(iAdvancedGui, point, new Dimension((int)(32.0f * f), (int)(32.0f * f)));
        this.scale = f;
        this.stack = cvzo2;
        this.createItemRenderer();
    }

    @Override
    public GuiComponent setRenderer(GuiRenderer guiRenderer) {
        super.setRenderer(guiRenderer);
        this.itemRenderer = guiRenderer.createItemRender(this.scale / guiRenderer.scale);
        return this;
    }

    private void createItemRenderer() {
        this.itemRenderer = this.renderer.createItemRender(this.scale / this.renderer.scale);
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.stack != null) {
            this.drawItemStack(this.stack, this.getLocation());
        }
        if (this.getEnabled() && this.isMouseOver()) {
            this.renderer.drawRect(this.getLocation(), this.getSize(), -2130706433);
        }
    }

    public McToolTip createToolTip() {
        cvzo cvzo2 = this.stack;
        McItemToolTip mcItemToolTip = new McItemToolTip(this.parent, this, cvzo2);
        mcItemToolTip.setRenderer(this.renderer);
        return mcItemToolTip;
    }

    protected void drawItemStack(cvzo cvzo2, Point point) {
        GL11.glPushAttrib(1048575);
        this.itemRenderer.renderStack(cvzo2, point.x, point.y);
        GL11.glPopAttrib();
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.getEnabled() && n == 1 && this.getElementMouseOver(point) == this) {
            this.runClickListener();
        }
    }

    public void runClickListener() {
        if (this.stack == null || this.stack._a() == null) {
            return;
        }
        clickListeners.entrySet().stream().filter(entry -> ((Class)entry.getKey()).isAssignableFrom(this.stack._a().getClass())).forEach(entry -> ((Consumer)entry.getValue()).accept(this.stack));
    }

    public boolean hasClickAction() {
        if (this.stack == null || this.stack._a() == null) {
            return false;
        }
        return clickListeners.keySet().stream().anyMatch(clazz -> clazz.isAssignableFrom(this.stack._a().getClass()));
    }

    public static void registerClickListener(Class<? extends tgdv> clazz, Consumer<cvzo> consumer) {
        clickListeners.put(clazz, consumer);
    }
}

