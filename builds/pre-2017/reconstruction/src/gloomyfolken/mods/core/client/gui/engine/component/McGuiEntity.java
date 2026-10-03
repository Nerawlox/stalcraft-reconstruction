/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class McGuiEntity<T extends Entity>
extends GuiComponent {
    protected float prevRotation = 0.0f;
    protected float rotation = 0.0f;
    private boolean mouseDown;
    private float mouseDownRotation;
    private int mouseDownX;
    public float scale;
    protected T entity;
    protected boolean disableDelayedRendering = false;

    public McGuiEntity(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, T t, float f) {
        super(iAdvancedGui, point, dimension);
        this.entity = t;
        this.scale = f;
    }

    public McGuiEntity(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, float f) {
        super(iAdvancedGui, point, dimension);
        this.scale = f;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.mouseDown) {
            int n = point.x - this.mouseDownX;
            this.rotation = this.mouseDownRotation - (float)n;
        }
        this.drawEntity(f);
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.parent.getElementsList().getElementMouseOver() == this) {
            this.mouseDown = true;
            this.mouseDownX = point.x;
            this.mouseDownRotation = this.rotation;
            Mouse.setGrabbed(true);
            Mouse.setClipMouseCoordinatesToWindow(false);
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        this.mouseDown = false;
        Mouse.setGrabbed(false);
        Mouse.setClipMouseCoordinatesToWindow(true);
    }

    @Override
    public void tick() {
        super.tick();
        this.prevRotation = this.rotation;
        ++((Entity)this.entity).ticksExisted;
    }

    protected void drawEntity(float f) {
        boolean bl = kkwv._a;
        kkwv._a = false;
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        GL11.glEnable(2903);
        RenderManager._b._l = 180.0f;
        float f2 = iwya._d;
        float f3 = iwya._e;
        iwya._a(iwya._b, 240.0f, 0.0f);
        if (zwaw._a(17408)) {
            GL11.glClear(256);
        }
        this.transformAndRenderEntity(f);
        zwaw._a(16384, true);
        iwya._a(iwya._b, f2, f3);
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        kkwv._a = bl;
    }

    protected void transformAndRenderEntity(float f) {
        float f2 = (float)this.getLocation().x + (float)this.getSize().width / 2.0f;
        float f3 = (float)this.getLocation().y + (float)this.getSize().height / 2.0f + this.scale * ((Entity)this.entity).height;
        GL11.glPushMatrix();
        GL11.glTranslatef(f2 * this.renderer.scale, f3 * this.renderer.scale, 50.0f);
        GL11.glScalef(-this.scale, this.scale, this.scale);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-jywc._a(this.prevRotation, this.rotation, f), 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, ((Entity)this.entity).yOffset, 0.0f);
        if (this.disableDelayedRendering) {
            ezfc._a();
            ezfc._d();
        }
        RenderManager._b._a((Entity)this.entity, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        if (this.disableDelayedRendering) {
            ezfa._a._a();
            ezfc._b();
        }
        GL11.glPopMatrix();
    }

    public T getEntity() {
        return this.entity;
    }

    public boolean isDisableDelayedRendering() {
        return this.disableDelayedRendering;
    }

    public McGuiEntity setDisableDelayedRendering(boolean bl) {
        this.disableDelayedRendering = bl;
        return this;
    }

    public void setRotation(float f) {
        this.prevRotation = this.rotation = f;
    }
}

