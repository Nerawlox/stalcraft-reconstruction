/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class EffectRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/particle/particles.png");
    public World _b;
    public List[] _c = new List[4];
    public TextureManager _d;
    public Random _e = new Random();

    public EffectRenderer(World world, TextureManager textureManager) {
        if (world != null) {
            this._b = world;
        }
        this._d = textureManager;
        for (int i = 0; i < 4; ++i) {
            this._c[i] = new ArrayList();
        }
    }

    public void _a(EntityFX entityFX) {
        int n = entityFX.getFXLayer();
        if (this._c[n].size() >= 4000) {
            this._c[n].remove(0);
        }
        this._c[n].add(entityFX);
    }

    public void _a() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < this._c[i].size(); ++j) {
                EntityFX entityFX = (EntityFX)this._c[i].get(j);
                if (entityFX != null) {
                    entityFX.onUpdate();
                }
                if (entityFX != null && !entityFX.isDead) continue;
                this._c[i].remove(j--);
            }
        }
    }

    public void _a(Entity entity, float f) {
        float f2 = tfss._h;
        float f3 = tfss._j;
        float f4 = tfss._k;
        float f5 = tfss._l;
        float f6 = tfss._i;
        EntityFX.interpPosX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        EntityFX.interpPosY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        EntityFX.interpPosZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        for (int i = 0; i < 3; ++i) {
            if (this._c[i].isEmpty()) continue;
            switch (i) {
                default: {
                    this._d._a(_a);
                    break;
                }
                case 1: {
                    this._d._a(sctd._c);
                    break;
                }
                case 2: {
                    this._d._a(sctd._e);
                }
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569f);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            for (int j = 0; j < this._c[i].size(); ++j) {
                EntityFX entityFX = (EntityFX)this._c[i].get(j);
                if (entityFX == null) continue;
                tessellator.setBrightness(entityFX.getBrightnessForRender(f));
                entityFX.renderParticle(tessellator, f, f2, f6, f3, f4, f5);
            }
            tessellator.draw();
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glAlphaFunc(516, 0.1f);
        }
    }

    public void _b(Entity entity, float f) {
        float f2 = (float)Math.PI / 180;
        float f3 = sajh._b(entity.rotationYaw * ((float)Math.PI / 180));
        float f4 = sajh._a(entity.rotationYaw * ((float)Math.PI / 180));
        float f5 = -f4 * sajh._a(entity.rotationPitch * ((float)Math.PI / 180));
        float f6 = f3 * sajh._a(entity.rotationPitch * ((float)Math.PI / 180));
        float f7 = sajh._b(entity.rotationPitch * ((float)Math.PI / 180));
        int n = 3;
        List list = this._c[n];
        if (!list.isEmpty()) {
            Tessellator tessellator = Tessellator.instance;
            for (int i = 0; i < list.size(); ++i) {
                EntityFX entityFX = (EntityFX)list.get(i);
                if (entityFX == null) continue;
                tessellator.setBrightness(entityFX.getBrightnessForRender(f));
                entityFX.renderParticle(tessellator, f, f3, f7, f4, f5, f6);
            }
        }
    }

    public void _a(World world) {
        this._b = world;
        for (int i = 0; i < 4; ++i) {
            this._c[i].clear();
        }
    }

    public void _a(int n, int n2, int n3, int n4, int n5) {
        Block block = Block.blocksList[n4];
        if (block != null && !block.addBlockDestroyEffects(this._b, n, n2, n3, n5, this)) {
            int n6 = 4;
            for (int i = 0; i < n6; ++i) {
                for (int j = 0; j < n6; ++j) {
                    for (int k = 0; k < n6; ++k) {
                        double d = (double)n + ((double)i + 0.5) / (double)n6;
                        double d2 = (double)n2 + ((double)j + 0.5) / (double)n6;
                        double d3 = (double)n3 + ((double)k + 0.5) / (double)n6;
                        this._a(new EntityDiggingFX(this._b, d, d2, d3, d - (double)n - 0.5, d2 - (double)n2 - 0.5, d3 - (double)n3 - 0.5, block, n5).applyColourMultiplier(n, n2, n3));
                    }
                }
            }
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        int n5 = this._b.getBlockId(n, n2, n3);
        if (n5 != 0) {
            Block block = Block.blocksList[n5];
            float f = 0.1f;
            double d = (double)n + this._e.nextDouble() * (block.getBlockBoundsMaxX() - block.func_83009_v() - (double)(f * 2.0f)) + (double)f + block.func_83009_v();
            double d2 = (double)n2 + this._e.nextDouble() * (block.getBlockBoundsMaxY() - block.getBlockBoundsMinY() - (double)(f * 2.0f)) + (double)f + block.getBlockBoundsMinY();
            double d3 = (double)n3 + this._e.nextDouble() * (block.getBlockBoundsMaxZ() - block.getBlockBoundsMinZ() - (double)(f * 2.0f)) + (double)f + block.getBlockBoundsMinZ();
            if (n4 == 0) {
                d2 = (double)n2 + block.getBlockBoundsMinY() - (double)f;
            }
            if (n4 == 1) {
                d2 = (double)n2 + block.getBlockBoundsMaxY() + (double)f;
            }
            if (n4 == 2) {
                d3 = (double)n3 + block.getBlockBoundsMinZ() - (double)f;
            }
            if (n4 == 3) {
                d3 = (double)n3 + block.getBlockBoundsMaxZ() + (double)f;
            }
            if (n4 == 4) {
                d = (double)n + block.func_83009_v() - (double)f;
            }
            if (n4 == 5) {
                d = (double)n + block.getBlockBoundsMaxX() + (double)f;
            }
            this._a(new EntityDiggingFX(this._b, d, d2, d3, 0.0, 0.0, 0.0, block, this._b.getBlockMetadata(n, n2, n3)).applyColourMultiplier(n, n2, n3).multiplyVelocity(0.2f).multipleParticleScaleBy(0.6f));
        }
    }

    public String _b() {
        return "" + (this._c[0].size() + this._c[1].size() + this._c[2].size());
    }

    public void _a(int n, int n2, int n3, MovingObjectPosition movingObjectPosition) {
        Block block = Block.blocksList[this._b.getBlockId(n, n2, n3)];
        if (block != null && !block.addBlockHitEffects(this._b, movingObjectPosition, this)) {
            this._a(n, n2, n3, movingObjectPosition._g);
        }
    }
}

