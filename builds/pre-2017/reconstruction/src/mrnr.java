/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.entity.EntityBulletHole;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class mrnr
extends Render {
    private ResourceLocation _a = new ResourceLocation("weapons", "textures/dirochki.dds");
    private TextureAtlasSprite[] _b = new TextureAtlasSprite[40];

    public mrnr() {
        fmib._b(this._a);
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = new TextureAtlasSprite("bullet_hole_" + i);
            this._b[i].setIconWidth(64);
            this._b[i].setIconHeight(64);
            this._b[i].initSprite(256, 640, i % 4 * 64, i / 4 * 64, false);
        }
    }

    public void _a(EntityBulletHole entityBulletHole, double d, double d2, double d3, float f, float f2) {
        int n = entityBulletHole.sideHit;
        World world = entityBulletHole.worldObj;
        float f3 = 0.04f;
        int n2 = sajh._c(entityBulletHole.posX - (double)f3);
        int n3 = sajh._c(entityBulletHole.posX + (double)f3);
        int n4 = sajh._c(entityBulletHole.posY - (double)f3);
        int n5 = sajh._c(entityBulletHole.posY + (double)f3);
        int n6 = sajh._c(entityBulletHole.posZ - (double)f3);
        int n7 = sajh._c(entityBulletHole.posZ + (double)f3);
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        switch (n) {
            case 0: 
            case 1: {
                n9 = n == 0 ? 0 : -1;
                n4 = n5 = sajh._c(entityBulletHole.posY);
                break;
            }
            case 2: 
            case 3: {
                n10 = n == 3 ? -1 : 0;
                n6 = n7 = sajh._c(entityBulletHole.posZ);
                break;
            }
            case 4: 
            case 5: {
                n8 = n == 5 ? -1 : 0;
                n2 = n3 = sajh._c(entityBulletHole.posX);
                break;
            }
            default: {
                return;
            }
        }
        GL11.glEnable(3042);
        GL11.glPolygonOffset(-5.0f, -5.0f);
        GL11.glEnable(32823);
        iwya._a(iwya._b, 240.0f, 0.0f);
        GL11.glBlendFunc(774, 768);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        Minecraft._E()._h._a(this._a);
        GL11.glPushMatrix();
        GL11.glTranslated(d, d2, d3);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int i = n2; i <= n3; ++i) {
            for (int j = n4; j <= n5; ++j) {
                for (int k = n6; k <= n7; ++k) {
                    int n11 = world.getBlockId(i + n8, j + n9, k + n10);
                    if (n11 == 0) continue;
                    int n12 = entityBulletHole.atlasRow * 4 + entityBulletHole.entityId % 4;
                    if (entityBulletHole.isKnifeHole) {
                        n12 += 20;
                    }
                    TextureAtlasSprite textureAtlasSprite = this._b[n12];
                    this._a(Block.blocksList[n11], entityBulletHole.posX, entityBulletHole.posY, entityBulletHole.posZ, i, j, k, f3, textureAtlasSprite, entityBulletHole.sideHit);
                }
            }
        }
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        GL11.glBlendFunc(770, 771);
        GL11.glPolygonOffset(0.0f, 0.0f);
        GL11.glDisable(32823);
        GL11.glDisable(3042);
        entityBulletHole.lastRenderedFrame = piuf._c;
    }

    private void _a(Block block, double d, double d2, double d3, int n, int n2, int n3, float f, Icon icon, int n4) {
        Tessellator tessellator = Tessellator.instance;
        if (block.renderAsNormalBlock() || block == Block.glass) {
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = 0.0;
            float f2 = 0.5f;
            float f3 = 0.5f;
            switch (n4) {
                case 0: {
                    d4 = Math.max((double)n + block.func_83009_v() - d, (double)(-f));
                    d6 = Math.max((double)n3 + block.getBlockBoundsMinZ() - d3, (double)(-f));
                    d7 = Math.min((double)n + block.getBlockBoundsMaxX() - d, (double)f);
                    d9 = Math.min((double)n3 + block.getBlockBoundsMaxZ() - d3, (double)f);
                    float f4 = 0.5f + f2 * (float)d4 / f;
                    float f5 = 0.5f + f2 * (float)d7 / f;
                    float f6 = 0.5f + f3 * (float)d6 / f;
                    float f7 = 0.5f + f3 * (float)d9 / f;
                    f4 = icon.getInterpolatedU(f4 * 16.0f);
                    f5 = icon.getInterpolatedU(f5 * 16.0f);
                    f6 = icon.getInterpolatedV(f6 * 16.0f);
                    f7 = icon.getInterpolatedV(f7 * 16.0f);
                    tessellator.addVertexWithUV(d7, 0.0, d6, f5, f6);
                    tessellator.addVertexWithUV(d7, 0.0, d9, f5, f7);
                    tessellator.addVertexWithUV(d4, 0.0, d9, f4, f7);
                    tessellator.addVertexWithUV(d4, 0.0, d6, f4, f6);
                    break;
                }
                case 1: {
                    d4 = Math.max((double)n + block.func_83009_v() - d, (double)(-f));
                    d6 = Math.max((double)n3 + block.getBlockBoundsMinZ() - d3, (double)(-f));
                    d7 = Math.min((double)n + block.getBlockBoundsMaxX() - d, (double)f);
                    d9 = Math.min((double)n3 + block.getBlockBoundsMaxZ() - d3, (double)f);
                    float f8 = 0.5f + f2 * (float)d4 / f;
                    float f9 = 0.5f + f2 * (float)d7 / f;
                    float f10 = 0.5f + f3 * (float)d6 / f;
                    float f11 = 0.5f + f3 * (float)d9 / f;
                    f8 = icon.getInterpolatedU(f8 * 16.0f);
                    f9 = icon.getInterpolatedU(f9 * 16.0f);
                    f10 = icon.getInterpolatedV(f10 * 16.0f);
                    f11 = icon.getInterpolatedV(f11 * 16.0f);
                    tessellator.addVertexWithUV(d7, 0.0, d6, f9, f10);
                    tessellator.addVertexWithUV(d4, 0.0, d6, f8, f10);
                    tessellator.addVertexWithUV(d4, 0.0, d9, f8, f11);
                    tessellator.addVertexWithUV(d7, 0.0, d9, f9, f11);
                    break;
                }
                case 2: {
                    d4 = Math.max((double)n + block.func_83009_v() - d, (double)(-f));
                    d5 = Math.max((double)n2 + block.getBlockBoundsMinY() - d2, (double)(-f));
                    d7 = Math.min((double)n + block.getBlockBoundsMaxX() - d, (double)f);
                    d8 = Math.min((double)n2 + block.getBlockBoundsMaxY() - d2, (double)f);
                    float f12 = 0.5f + f2 * (float)d4 / f;
                    float f13 = 0.5f + f2 * (float)d7 / f;
                    float f14 = 0.5f + f3 * (float)d5 / f;
                    float f15 = 0.5f + f3 * (float)d8 / f;
                    f12 = icon.getInterpolatedU(f12 * 16.0f);
                    f13 = icon.getInterpolatedU(f13 * 16.0f);
                    f14 = icon.getInterpolatedV(f14 * 16.0f);
                    f15 = icon.getInterpolatedV(f15 * 16.0f);
                    tessellator.addVertexWithUV(d4, d8, 0.0, f12, f15);
                    tessellator.addVertexWithUV(d7, d8, 0.0, f13, f15);
                    tessellator.addVertexWithUV(d7, d5, 0.0, f13, f14);
                    tessellator.addVertexWithUV(d4, d5, 0.0, f12, f14);
                    break;
                }
                case 3: {
                    d4 = Math.max((double)n + block.func_83009_v() - d, (double)(-f));
                    d5 = Math.max((double)n2 + block.getBlockBoundsMinY() - d2, (double)(-f));
                    d7 = Math.min((double)n + block.getBlockBoundsMaxX() - d, (double)f);
                    d8 = Math.min((double)n2 + block.getBlockBoundsMaxY() - d2, (double)f);
                    float f16 = 0.5f + f2 * (float)d4 / f;
                    float f17 = 0.5f + f2 * (float)d7 / f;
                    float f18 = 0.5f + f3 * (float)d5 / f;
                    float f19 = 0.5f + f3 * (float)d8 / f;
                    f16 = icon.getInterpolatedU(f16 * 16.0f);
                    f17 = icon.getInterpolatedU(f17 * 16.0f);
                    f18 = icon.getInterpolatedV(f18 * 16.0f);
                    f19 = icon.getInterpolatedV(f19 * 16.0f);
                    tessellator.addVertexWithUV(d4, d8, 0.0, f16, f19);
                    tessellator.addVertexWithUV(d4, d5, 0.0, f16, f18);
                    tessellator.addVertexWithUV(d7, d5, 0.0, f17, f18);
                    tessellator.addVertexWithUV(d7, d8, 0.0, f17, f19);
                    break;
                }
                case 5: {
                    d5 = Math.max((double)n2 + block.getBlockBoundsMinY() - d2, (double)(-f));
                    d6 = Math.max((double)n3 + block.getBlockBoundsMinZ() - d3, (double)(-f));
                    d8 = Math.min((double)n2 + block.getBlockBoundsMaxY() - d2, (double)f);
                    d9 = Math.min((double)n3 + block.getBlockBoundsMaxZ() - d3, (double)f);
                    float f20 = 0.5f + f2 * (float)d9 / f;
                    float f21 = 0.5f + f2 * (float)d6 / f;
                    float f22 = 0.5f + f3 * (float)d5 / f;
                    float f23 = 0.5f + f3 * (float)d8 / f;
                    f20 = icon.getInterpolatedU(f20 * 16.0f);
                    f21 = icon.getInterpolatedU(f21 * 16.0f);
                    f22 = icon.getInterpolatedV(f22 * 16.0f);
                    f23 = icon.getInterpolatedV(f23 * 16.0f);
                    tessellator.addVertexWithUV(0.0, d8, d9, f20, f23);
                    tessellator.addVertexWithUV(0.0, d5, d9, f20, f22);
                    tessellator.addVertexWithUV(0.0, d5, d6, f21, f22);
                    tessellator.addVertexWithUV(0.0, d8, d6, f21, f23);
                    break;
                }
                case 4: {
                    d5 = Math.max((double)n2 + block.getBlockBoundsMinY() - d2, (double)(-f));
                    d6 = Math.max((double)n3 + block.getBlockBoundsMinZ() - d3, (double)(-f));
                    d8 = Math.min((double)n2 + block.getBlockBoundsMaxY() - d2, (double)f);
                    d9 = Math.min((double)n3 + block.getBlockBoundsMaxZ() - d3, (double)f);
                    float f24 = 0.5f + f2 * (float)d9 / f;
                    float f25 = 0.5f + f2 * (float)d6 / f;
                    float f26 = 0.5f + f3 * (float)d5 / f;
                    float f27 = 0.5f + f3 * (float)d8 / f;
                    f24 = icon.getInterpolatedU(f24 * 16.0f);
                    f25 = icon.getInterpolatedU(f25 * 16.0f);
                    f26 = icon.getInterpolatedV(f26 * 16.0f);
                    f27 = icon.getInterpolatedV(f27 * 16.0f);
                    tessellator.addVertexWithUV(0.0, d8, d9, f24, f27);
                    tessellator.addVertexWithUV(0.0, d8, d6, f25, f27);
                    tessellator.addVertexWithUV(0.0, d5, d6, f25, f26);
                    tessellator.addVertexWithUV(0.0, d5, d9, f24, f26);
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid side!");
                }
            }
        }
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityBulletHole)entity, d, d2, d3, f, f2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return null;
    }
}

