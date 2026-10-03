/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class McPlayerIcon
extends McGuiPlayer {
    private static final ResourceLocation BACKGROUNDS_AVATARS = new ResourceLocation("pda", "textures/gui/av_background.png");
    private Point bgUv;

    public McPlayerIcon(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Point point2) {
        super(iAdvancedGui, point, dimension, 50.0f);
        this.bgUv = point2;
    }

    @Override
    protected void drawEntity(float f) {
        Minecraft._E()._R()._a(BACKGROUNDS_AVATARS);
        this.renderer.drawTexturedModalRect(this.getLocation(), this.bgUv, this.getSize());
        super.drawEntity(f);
    }

    @Override
    protected void transformAndRenderEntity(float f) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glAlphaFunc(515, 0.1f);
        ejef._c();
        ejef.kjui._c._a();
        GL11.glDepthMask(false);
        this.renderer.drawTexturedModalRect(this.getLocation(), new Point(0, 384), this.getSize());
        ejef.kjui._c._c();
        GL11.glAlphaFunc(516, 0.0f);
        GL11.glColorMask(true, true, true, true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderer.scaledScissor(this.getLocation(), this.getSize());
        double d = 25.0;
        GL11.glTranslated(0.0, d, 0.0);
        super.transformAndRenderEntity(f);
        GL11.glTranslated(0.0, -d, 0.0);
        ScissorHelper.popScissor();
        ejef.kjui._c._d();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
}

