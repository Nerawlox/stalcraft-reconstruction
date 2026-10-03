/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class nudk
extends TileEntitySpecialRenderer {
    private IModelCustom _a = AdvancedModelLoader.loadModel("/assets/stalkerclans/models/flag.mcsa");
    private ResourceLocation _b = new ResourceLocation("stalkerclans", "models/flag_down.dds");
    private ResourceLocation _c = new ResourceLocation("stalkerclans", "models/flag_up.dds");

    public nudk() {
        fmib._b(this._b);
        fmib._b(this._c);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        Tessellator tessellator = Tessellator.instance;
        fmle fmle2 = (fmle)tileEntity;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
        Minecraft._E()._h._a(this._b);
        this._a.renderPart("palka");
        Minecraft._E()._h._a(this._c);
        this._a.renderPart("flag");
        float f2 = fmle2.worldObj.getHeightValue(fmle2.xCoord, fmle2.zCoord) - fmle2.yCoord + 10;
        GL11.glTranslatef(0.0f, f2, 0.0f);
        float f3 = 1.0f;
        double d4 = -90.0 - Math.toDegrees(Math.atan2(-d3 - 0.5, -d - 0.5));
        GL11.glRotated(d4, 0.0, 1.0, 0.0);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDepthMask(false);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(0.0f, 0.0f, 0.0f, 0.5f);
        tessellator.addVertexWithUV(-f3, -f3, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(-f3, f3, 0.0, 0.0, 0.0);
        tessellator.addVertexWithUV(f3, f3, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(f3, -f3, 0.0, 1.0, 1.0);
        tessellator.draw();
        mcmy mcmy2 = yfpk._i;
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glScalef(0.03f, 0.03f, 0.03f);
        GL11.glRotated(180.0, 0.0, 0.0, 1.0);
        if (fmle2._a != null) {
            mcmy2._b(fmle2._a, 0.0, -10.0, -1, 1.0f);
        }
        if (fmle2._b != null) {
            mcmy2._b(fmle2._b, 0.0, 10.0, -1, 1.0f);
        }
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        if (Minecraft._E()._t.capabilities._d || fmle2._i) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glTranslated(d + (double)(fmle2._c - fmle2.xCoord), d2 + (double)(fmle2._d - fmle2.yCoord), d3 + (double)(fmle2._e - fmle2.zCoord));
            GL11.glLineWidth(3.0f);
            tessellator.startDrawing(1);
            tessellator.setColorRGBA_F(0.0f, 0.75f, 0.0f, 0.25f);
            double d5 = fmle2._f - fmle2._c;
            double d6 = fmle2._g - fmle2._d;
            double d7 = fmle2._h - fmle2._e;
            owxf._a(0.0, 0.0, 0.0, 0.0, d6, d7);
            owxf._a(0.0 + d5, 0.0, 0.0, 0.0, d6, d7);
            owxf._a(0.0, 0.0, 0.0, d5, d6, 0.0);
            owxf._a(0.0, 0.0, 0.0 + d7, d5, d6, 0.0);
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }
}

