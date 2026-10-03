/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class cejo
extends TileEntitySpecialRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/chest/ender.png");
    public ModelChest _b = new ModelChest();

    public void _a(gaqr gaqr2, double d, double d2, double d3, float f) {
        int n = 0;
        if (gaqr2.hasWorldObj()) {
            n = gaqr2.getBlockMetadata();
        }
        this.bindTexture(_a);
        GL11.glPushMatrix();
        GL11.glEnable(32826);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glTranslatef((float)d, (float)d2 + 1.0f, (float)d3 + 1.0f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        int n2 = 0;
        if (n == 2) {
            n2 = 180;
        }
        if (n == 3) {
            n2 = 0;
        }
        if (n == 4) {
            n2 = 90;
        }
        if (n == 5) {
            n2 = -90;
        }
        GL11.glRotatef(n2, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        float f2 = gaqr2._b + (gaqr2._a - gaqr2._b) * f;
        f2 = 1.0f - f2;
        f2 = 1.0f - f2 * f2 * f2;
        this._b.chestLid.rotateAngleX = -(f2 * (float)Math.PI / 2.0f);
        this._b.renderAll();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((gaqr)tileEntity, d, d2, d3, f);
    }
}

