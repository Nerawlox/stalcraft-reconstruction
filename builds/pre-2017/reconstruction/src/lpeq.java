/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class lpeq
extends TileEntitySpecialRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/beacon_beam.png");

    public void _a(TileEntityBeacon tileEntityBeacon, double d, double d2, double d3, float f) {
        float f2 = tileEntityBeacon._c();
        if (f2 > 0.0f) {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(_a);
            GL11.glTexParameterf(3553, 10242, 10497.0f);
            GL11.glTexParameterf(3553, 10243, 10497.0f);
            GL11.glDisable(2896);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glBlendFunc(770, 1);
            float f3 = (float)tileEntityBeacon.getWorldObj().getTotalWorldTime() + f;
            float f4 = -f3 * 0.2f - (float)sajh._d(-f3 * 0.1f);
            boolean bl = true;
            double d4 = (double)f3 * 0.025 * (1.0 - (double)(bl & true) * 2.5);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d5 = (double)bl * 0.2;
            double d6 = 0.5 + Math.cos(d4 + 2.356194490192345) * d5;
            double d7 = 0.5 + Math.sin(d4 + 2.356194490192345) * d5;
            double d8 = 0.5 + Math.cos(d4 + 0.7853981633974483) * d5;
            double d9 = 0.5 + Math.sin(d4 + 0.7853981633974483) * d5;
            double d10 = 0.5 + Math.cos(d4 + 3.9269908169872414) * d5;
            double d11 = 0.5 + Math.sin(d4 + 3.9269908169872414) * d5;
            double d12 = 0.5 + Math.cos(d4 + 5.497787143782138) * d5;
            double d13 = 0.5 + Math.sin(d4 + 5.497787143782138) * d5;
            double d14 = 256.0f * f2;
            double d15 = 0.0;
            double d16 = 1.0;
            double d17 = -1.0f + f4;
            double d18 = (double)(256.0f * f2) * (0.5 / d5) + d17;
            tessellator.addVertexWithUV(d + d6, d2 + d14, d3 + d7, d16, d18);
            tessellator.addVertexWithUV(d + d6, d2, d3 + d7, d16, d17);
            tessellator.addVertexWithUV(d + d8, d2, d3 + d9, d15, d17);
            tessellator.addVertexWithUV(d + d8, d2 + d14, d3 + d9, d15, d18);
            tessellator.addVertexWithUV(d + d12, d2 + d14, d3 + d13, d16, d18);
            tessellator.addVertexWithUV(d + d12, d2, d3 + d13, d16, d17);
            tessellator.addVertexWithUV(d + d10, d2, d3 + d11, d15, d17);
            tessellator.addVertexWithUV(d + d10, d2 + d14, d3 + d11, d15, d18);
            tessellator.addVertexWithUV(d + d8, d2 + d14, d3 + d9, d16, d18);
            tessellator.addVertexWithUV(d + d8, d2, d3 + d9, d16, d17);
            tessellator.addVertexWithUV(d + d12, d2, d3 + d13, d15, d17);
            tessellator.addVertexWithUV(d + d12, d2 + d14, d3 + d13, d15, d18);
            tessellator.addVertexWithUV(d + d10, d2 + d14, d3 + d11, d16, d18);
            tessellator.addVertexWithUV(d + d10, d2, d3 + d11, d16, d17);
            tessellator.addVertexWithUV(d + d6, d2, d3 + d7, d15, d17);
            tessellator.addVertexWithUV(d + d6, d2 + d14, d3 + d7, d15, d18);
            tessellator.draw();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthMask(false);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d19 = 0.2;
            double d20 = 0.2;
            double d21 = 0.8;
            double d22 = 0.2;
            double d23 = 0.2;
            double d24 = 0.8;
            double d25 = 0.8;
            double d26 = 0.8;
            double d27 = 256.0f * f2;
            double d28 = 0.0;
            double d29 = 1.0;
            double d30 = -1.0f + f4;
            double d31 = (double)(256.0f * f2) + d30;
            tessellator.addVertexWithUV(d + d19, d2 + d27, d3 + d20, d29, d31);
            tessellator.addVertexWithUV(d + d19, d2, d3 + d20, d29, d30);
            tessellator.addVertexWithUV(d + d21, d2, d3 + d22, d28, d30);
            tessellator.addVertexWithUV(d + d21, d2 + d27, d3 + d22, d28, d31);
            tessellator.addVertexWithUV(d + d25, d2 + d27, d3 + d26, d29, d31);
            tessellator.addVertexWithUV(d + d25, d2, d3 + d26, d29, d30);
            tessellator.addVertexWithUV(d + d23, d2, d3 + d24, d28, d30);
            tessellator.addVertexWithUV(d + d23, d2 + d27, d3 + d24, d28, d31);
            tessellator.addVertexWithUV(d + d21, d2 + d27, d3 + d22, d29, d31);
            tessellator.addVertexWithUV(d + d21, d2, d3 + d22, d29, d30);
            tessellator.addVertexWithUV(d + d25, d2, d3 + d26, d28, d30);
            tessellator.addVertexWithUV(d + d25, d2 + d27, d3 + d26, d28, d31);
            tessellator.addVertexWithUV(d + d23, d2 + d27, d3 + d24, d29, d31);
            tessellator.addVertexWithUV(d + d23, d2, d3 + d24, d29, d30);
            tessellator.addVertexWithUV(d + d19, d2, d3 + d20, d28, d30);
            tessellator.addVertexWithUV(d + d19, d2 + d27, d3 + d20, d28, d31);
            tessellator.draw();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
        }
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((TileEntityBeacon)tileEntity, d, d2, d3, f);
    }
}

