/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class wpdq
extends TileEntitySpecialRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/sign.png");
    public final ModelSign _b = new ModelSign();

    public void _a(TileEntitySign tileEntitySign, double d, double d2, double d3, float f) {
        float f2;
        Block block = tileEntitySign.getBlockType();
        GL11.glPushMatrix();
        float f3 = 0.6666667f;
        if (block == Block.signPost) {
            GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            float f4 = (float)(tileEntitySign.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef(-f4, 0.0f, 1.0f, 0.0f);
            this._b.signStick.showModel = true;
        } else {
            int n = tileEntitySign.getBlockMetadata();
            f2 = 0.0f;
            if (n == 2) {
                f2 = 180.0f;
            }
            if (n == 4) {
                f2 = 90.0f;
            }
            if (n == 5) {
                f2 = -90.0f;
            }
            GL11.glTranslatef((float)d + 0.5f, (float)d2 + 0.75f * f3, (float)d3 + 0.5f);
            GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.3125f, -0.4375f);
            this._b.signStick.showModel = false;
        }
        this.bindTexture(_a);
        GL11.glPushMatrix();
        GL11.glScalef(f3, -f3, -f3);
        this._b.renderSign();
        GL11.glPopMatrix();
        FontRenderer fontRenderer = this.getFontRenderer();
        f2 = 0.016666668f * f3;
        GL11.glTranslatef(0.0f, 0.5f * f3, 0.07f * f3);
        GL11.glScalef(f2, -f2, f2);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f * f2);
        GL11.glDepthMask(false);
        int n = 0;
        for (int i = 0; i < tileEntitySign._a.length; ++i) {
            String string = tileEntitySign._a[i];
            if (i == tileEntitySign._b) {
                string = "> " + string + " <";
                fontRenderer._b(string, -fontRenderer._b(string) / 2, i * 10 - tileEntitySign._a.length * 5, n);
                continue;
            }
            fontRenderer._b(string, -fontRenderer._b(string) / 2, i * 10 - tileEntitySign._a.length * 5, n);
        }
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((TileEntitySign)tileEntity, d, d2, d3, f);
    }
}

