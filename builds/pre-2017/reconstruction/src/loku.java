/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class loku {
    private ResourceLocation _a = new ResourceLocation("weapons", "textures/light1.png");
    private ResourceLocation _b = new ResourceLocation("weapons", "textures/light2.png");

    public loku() {
        fmib._b(this._a);
        fmib._b(this._b);
    }

    public void _a(lohe lohe2) {
        GL11.glPushMatrix();
        float f = lohe2._a;
        GL11.glDepthMask(false);
        GL11.glEnable(3553);
        GL11.glEnable(3042);
        GL11.glAlphaFunc(516, 0.1f);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2896);
        Minecraft._E()._D.disableLightmap(0.0);
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(2884);
        Minecraft._E()._h._a(this._a);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, -0.5 * (double)f, 0.2 * (double)f, 1.0, 1.0);
        tessellator.addVertexWithUV(0.0, 0.5 * (double)f, 0.2 * (double)f, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.5 * (double)f, -0.8 * (double)f, 0.0, 0.0);
        tessellator.addVertexWithUV(0.0, -0.5 * (double)f, -0.8 * (double)f, 0.0, 1.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-0.5 * (double)f, 0.0, 0.2 * (double)f, 1.0, 1.0);
        tessellator.addVertexWithUV(0.5 * (double)f, 0.0, 0.2 * (double)f, 1.0, 0.0);
        tessellator.addVertexWithUV(0.5 * (double)f, 0.0, -0.8 * (double)f, 0.0, 0.0);
        tessellator.addVertexWithUV(-0.5 * (double)f, 0.0, -0.8 * (double)f, 0.0, 1.0);
        tessellator.draw();
        Minecraft._E()._h._a(this._b);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-0.5 * (double)f, -0.5 * (double)f, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(-0.5 * (double)f, 0.5 * (double)f, 0.0, 0.0, 0.0);
        tessellator.addVertexWithUV(0.5 * (double)f, 0.5 * (double)f, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.5 * (double)f, -0.5 * (double)f, 0.0, 1.0, 1.0);
        tessellator.draw();
        Minecraft._E()._D.enableLightmap(0.0);
        GL11.glEnable(2884);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glAlphaFunc(516, 0.1f);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
    }
}

