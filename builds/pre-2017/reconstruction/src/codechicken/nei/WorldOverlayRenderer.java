/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.lib.math.MathHelper;
import codechicken.lib.render.RenderUtils;
import codechicken.nei.KeyManager;
import codechicken.nei.NEIClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class WorldOverlayRenderer
implements KeyManager.IKeyStateTracker {
    public static int mobOverlay = 0;
    public static int chunkOverlay = 0;

    public WorldOverlayRenderer() {
        KeyManager.trackers.add(this);
    }

    public static void reset() {
        mobOverlay = 0;
        chunkOverlay = 0;
    }

    @Override
    public void tickKeyStates() {
        if (Minecraft._E()._B != null) {
            return;
        }
        if (KeyManager.keyStates.get((Object)"world.moboverlay").down) {
            mobOverlay = (mobOverlay + 1) % 2;
        }
        if (KeyManager.keyStates.get((Object)"world.chunkoverlay").down) {
            chunkOverlay = (chunkOverlay + 1) % 3;
        }
    }

    @ForgeSubscribe
    public void onWorldRenderLast(RenderWorldLastEvent renderWorldLastEvent) {
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        GL11.glPushMatrix();
        EntityLivingBase entityLivingBase = renderWorldLastEvent.context._r._u;
        RenderUtils.translateToWorldCoords(entityLivingBase, renderWorldLastEvent.partialTicks);
        this.renderChunkBounds(entityLivingBase);
        this.renderMobSpawnOverlay(entityLivingBase);
        GL11.glPopMatrix();
    }

    private void renderMobSpawnOverlay(Entity entity) {
        if (mobOverlay == 0) {
            return;
        }
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2896);
        GL11.glLineWidth(1.5f);
        GL11.glBegin(1);
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        int n = 2;
        World world = entity.worldObj;
        int n2 = (int)entity.posX;
        int n3 = (int)entity.posZ;
        int n4 = (int)MathHelper.clip(entity.posY, 16.0, world.getHeight() - 16);
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        for (int i = n2 - 16; i <= n2 + 16; ++i) {
            for (int j = n3 - 16; j <= n3 + 16; ++j) {
                Chunk chunk = world.getChunkFromBlockCoords(i, j);
                BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(i, j);
                if (biomeGenBase._a(EnumCreatureType._a).isEmpty() || biomeGenBase._g() <= 0.0f) continue;
                for (int k = n4 - 16; k < n4 + 16; ++k) {
                    int n5 = this.getSpawnMode(chunk, axisAlignedBB, i, k, j);
                    if (n5 == 0) continue;
                    if (n5 != n) {
                        if (n5 == 1) {
                            GL11.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);
                        } else {
                            GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
                        }
                        n = n5;
                    }
                    GL11.glVertex3d(i, (double)k + 0.004, j);
                    GL11.glVertex3d(i + 1, (double)k + 0.004, j + 1);
                    GL11.glVertex3d(i + 1, (double)k + 0.004, j);
                    GL11.glVertex3d(i, (double)k + 0.004, j + 1);
                }
            }
        }
        GL11.glEnd();
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    private int getSpawnMode(Chunk chunk, AxisAlignedBB axisAlignedBB, int n, int n2, int n3) {
        if (!xtbl._a(EnumCreatureType._a, chunk._g, n, n2, n3) || chunk._a(EnumSkyBlock._b, n & 0xF, n2, n3 & 0xF) >= 8) {
            return 0;
        }
        axisAlignedBB._b = (double)n + 0.2;
        axisAlignedBB._e = (double)n + 0.8;
        axisAlignedBB._c = (double)n2 + 0.01;
        axisAlignedBB._f = (double)n2 + 1.8;
        axisAlignedBB._d = (double)n3 + 0.2;
        axisAlignedBB._g = (double)n3 + 0.8;
        if (!chunk._g.checkNoEntityCollision(axisAlignedBB) || !chunk._g.getCollidingBlockBounds(axisAlignedBB).isEmpty() || chunk._g.isAnyLiquid(axisAlignedBB)) {
            return 0;
        }
        if (chunk._a(EnumSkyBlock._a, n & 0xF, n2, n3 & 0xF) >= 8) {
            return 1;
        }
        return 2;
    }

    private void renderChunkBounds(Entity entity) {
        if (chunkOverlay == 0) {
            return;
        }
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2896);
        GL11.glLineWidth(1.5f);
        GL11.glBegin(1);
        for (int i = -4; i <= 4; ++i) {
            for (int j = -4; j <= 4; ++j) {
                double d;
                double d2 = entity.chunkCoordX + i << 4;
                double d3 = entity.chunkCoordZ + j << 4;
                double d4 = d2 + 16.0;
                double d5 = d3 + 16.0;
                double d6 = 128.0;
                double d7 = Math.floor(entity.posY - d6 / 2.0);
                double d8 = d7 + d6;
                if (d7 < 0.0) {
                    d7 = 0.0;
                    d8 = d6;
                }
                if (d7 > (double)entity.worldObj.getHeight()) {
                    d8 = entity.worldObj.getHeight();
                    d7 = d8 - d6;
                }
                double d9 = Math.pow(1.5, -(i * i + j * j));
                GL11.glColor4d(0.9, 0.0, 0.0, d9);
                if (i >= 0 && j >= 0) {
                    GL11.glVertex3d(d4, d7, d5);
                    GL11.glVertex3d(d4, d8, d5);
                }
                if (i >= 0 && j <= 0) {
                    GL11.glVertex3d(d4, d7, d3);
                    GL11.glVertex3d(d4, d8, d3);
                }
                if (i <= 0 && j >= 0) {
                    GL11.glVertex3d(d2, d7, d5);
                    GL11.glVertex3d(d2, d8, d5);
                }
                if (i <= 0 && j <= 0) {
                    GL11.glVertex3d(d2, d7, d3);
                    GL11.glVertex3d(d2, d8, d3);
                }
                if (chunkOverlay != 2 || i != 0 || j != 0) continue;
                d6 = 32.0;
                d7 = Math.floor(entity.posY - d6 / 2.0);
                d8 = d7 + d6;
                if (d7 < 0.0) {
                    d7 = 0.0;
                    d8 = d6;
                }
                if (d7 > (double)entity.worldObj.getHeight()) {
                    d8 = entity.worldObj.getHeight();
                    d7 = d8 - d6;
                }
                GL11.glColor4d(0.0, 0.9, 0.0, 0.4);
                for (d = (double)((int)d7); d <= d8; d += 1.0) {
                    GL11.glVertex3d(d4, d, d3);
                    GL11.glVertex3d(d4, d, d5);
                    GL11.glVertex3d(d2, d, d3);
                    GL11.glVertex3d(d2, d, d5);
                    GL11.glVertex3d(d2, d, d5);
                    GL11.glVertex3d(d4, d, d5);
                    GL11.glVertex3d(d2, d, d3);
                    GL11.glVertex3d(d4, d, d3);
                }
                for (d = 1.0; d <= 15.0; d += 1.0) {
                    GL11.glVertex3d(d2 + d, d7, d3);
                    GL11.glVertex3d(d2 + d, d8, d3);
                    GL11.glVertex3d(d2 + d, d7, d5);
                    GL11.glVertex3d(d2 + d, d8, d5);
                    GL11.glVertex3d(d2, d7, d3 + d);
                    GL11.glVertex3d(d2, d8, d3 + d);
                    GL11.glVertex3d(d4, d7, d3 + d);
                    GL11.glVertex3d(d4, d8, d3 + d);
                }
            }
        }
        GL11.glEnd();
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
}

