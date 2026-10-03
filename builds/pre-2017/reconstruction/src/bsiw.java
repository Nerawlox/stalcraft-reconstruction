/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class bsiw
extends TileEntitySpecialRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/creeper/creeper.png");
    public static bsiw _e;
    public ModelSkeletonHead _f = new ModelSkeletonHead(0, 0, 64, 32);
    public ModelSkeletonHead _g = new ModelSkeletonHead(0, 0, 64, 64);

    public void _a(TileEntitySkull tileEntitySkull, double d, double d2, double d3, float f) {
        this._a((float)d, (float)d2, (float)d3, tileEntitySkull.getBlockMetadata() & 7, (float)(tileEntitySkull._b() * 360) / 16.0f, tileEntitySkull._a(), tileEntitySkull._c());
    }

    @Override
    public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer) {
        super.setTileEntityRenderer(tileEntityRenderer);
        _e = this;
    }

    public void _a(float f, float f2, float f3, int n, float f4, int n2, String string) {
        ModelSkeletonHead modelSkeletonHead = this._f;
        switch (n2) {
            default: {
                this.bindTexture(_a);
                break;
            }
            case 1: {
                this.bindTexture(_b);
                break;
            }
            case 2: {
                this.bindTexture(_c);
                modelSkeletonHead = this._g;
                break;
            }
            case 3: {
                ResourceLocation resourceLocation = AbstractClientPlayer.locationStevePng;
                if (string != null && string.length() > 0) {
                    resourceLocation = AbstractClientPlayer.getLocationSkull(string);
                    AbstractClientPlayer.getDownloadImageSkin(resourceLocation, string);
                }
                this.bindTexture(resourceLocation);
                break;
            }
            case 4: {
                this.bindTexture(_d);
            }
        }
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        if (n != 1) {
            switch (n) {
                case 2: {
                    GL11.glTranslatef(f + 0.5f, f2 + 0.25f, f3 + 0.74f);
                    break;
                }
                case 3: {
                    GL11.glTranslatef(f + 0.5f, f2 + 0.25f, f3 + 0.26f);
                    f4 = 180.0f;
                    break;
                }
                case 4: {
                    GL11.glTranslatef(f + 0.74f, f2 + 0.25f, f3 + 0.5f);
                    f4 = 270.0f;
                    break;
                }
                default: {
                    GL11.glTranslatef(f + 0.26f, f2 + 0.25f, f3 + 0.5f);
                    f4 = 90.0f;
                    break;
                }
            }
        } else {
            GL11.glTranslatef(f + 0.5f, f2, f3 + 0.5f);
        }
        float f5 = 0.0625f;
        GL11.glEnable(32826);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glEnable(3008);
        ((ModelBase)modelSkeletonHead).render(null, 0.0f, 0.0f, 0.0f, f4, 0.0f, f5);
        GL11.glPopMatrix();
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((TileEntitySkull)tileEntity, d, d2, d3, f);
    }
}

