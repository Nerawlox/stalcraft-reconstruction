/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.smart.moving.IEntityPlayerSP;
import net.smart.moving.Orientation;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.config.SmartMovingOptions;

public abstract class SmartMovingBase
extends SmartMovingContext {
    public final EntityPlayer sp;
    public final EntityPlayerSP esp;
    public final IEntityPlayerSP isp;
    public static final int CollidedPositiveX = 1;
    public static final int CollidedNegativeX = 2;
    public static final int CollidedPositiveY = 4;
    public static final int CollidedNegativeY = 8;
    public static final int CollidedPositiveZ = 16;
    public static final int CollidedNegativeZ = 32;

    public SmartMovingBase(EntityPlayer entityPlayer, IEntityPlayerSP iEntityPlayerSP) {
        this.sp = entityPlayer;
        this.isp = iEntityPlayerSP;
        if (entityPlayer instanceof EntityPlayerSP) {
            this.esp = (EntityPlayerSP)entityPlayer;
            if (Minecraft._E()._t == null) {
                SmartMovingContext.Options.resetForNewGame();
                SmartMovingContext.Config = SmartMovingContext.Options;
            }
        } else {
            this.esp = null;
        }
    }

    protected boolean isLava(int n) {
        if (n != Block.lavaStill.blockID && n != Block.lavaMoving.blockID) {
            Block block = n > 0 ? Block.blocksList[n] : null;
            return block != null && block.blockMaterial == Material._i;
        }
        return true;
    }

    protected float getFiniteLiquidWaterBorder(int n, int n2, int n3, int n4) {
        int n5 = Orientation.getFiniteLiquidWater(n4);
        if (n5 > 0) {
            if (n5 == 2) {
                return 1.0f;
            }
            if (n5 == 1) {
                int n6 = this.sp.worldObj.getBlockId(n, n2 + 1, n3);
                if (Orientation.getFiniteLiquidWater(n6) > 0) {
                    return 1.0f;
                }
                return (float)(this.sp.worldObj.getBlockMetadata(n, n2, n3) + 1) / 16.0f;
            }
        }
        return 0.0f;
    }

    private List getPlayerSolidBetween(double d, double d2, double d3) {
        double d4 = this.sp.boundingBox._c;
        double d5 = this.sp.boundingBox._f;
        this.sp.boundingBox._c = d;
        this.sp.boundingBox._f = d2;
        List list = this.sp.worldObj.getCollidingBoundingBoxes(this.sp, d3 == 0.0 ? this.sp.boundingBox : this.sp.boundingBox._e(-d3, 0.0, -d3));
        this.sp.boundingBox._c = d4;
        this.sp.boundingBox._f = d5;
        return list;
    }

    protected double getMaxPlayerSolidBetween(double d, double d2, double d3) {
        List list = this.getPlayerSolidBetween(d, d2, d3);
        double d4 = d;
        for (int i = 0; i < list.size(); ++i) {
            AxisAlignedBB axisAlignedBB = (AxisAlignedBB)list.get(i);
            if (!this.isCollided(axisAlignedBB, d, d2, d3)) continue;
            d4 = Math.max(d4, axisAlignedBB._f);
        }
        return Math.min(d4, d2);
    }

    public boolean isCollided(AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        return axisAlignedBB._e >= this.sp.boundingBox._b - d3 && axisAlignedBB._b <= this.sp.boundingBox._e + d3 && axisAlignedBB._f >= d && axisAlignedBB._c <= d2 && axisAlignedBB._g >= this.sp.boundingBox._d - d3 && axisAlignedBB._d <= this.sp.boundingBox._g + d3;
    }

    public boolean isInsideOfMaterial(Material material) {
        if (SmartMovingOptions.hasFiniteLiquid && material == Material._h) {
            int n;
            int n2;
            double d = this.sp.posY + (double)this.sp.getEyeHeight();
            int n3 = sajh._c(this.sp.posX);
            int n4 = this.sp.worldObj.getBlockId(n3, n2 = sajh._d(sajh._c(d)), n = sajh._c(this.sp.posZ));
            if (n4 != 0) {
                float f;
                float f2 = this.getFiniteLiquidWaterBorder(n3, n2, n, n4);
                if (f > 0.0f) {
                    float f3 = 1.0f - f2 - 0.1111111f;
                    float f4 = (float)(n2 + 1) - f3;
                    return d < (double)f4;
                }
            }
            return false;
        }
        return this.isp.localIsInsideOfMaterial(material);
    }

    public boolean isSneaking() {
        return this.sp.isSneaking();
    }

    public double getOverGroundHeight(double d) {
        return this.esp != null ? this.sp.boundingBox._c - this.getMaxPlayerSolidBetween(this.sp.boundingBox._c - d, this.sp.boundingBox._c, 0.0) : this.sp.boundingBox._c + 1.0 - this.getMaxPlayerSolidBetween(this.sp.boundingBox._c - d + 1.0, this.sp.boundingBox._c + 1.0, 0.1);
    }

    public int getOverGroundBlockId(double d) {
        int n = sajh._c(this.sp.posX);
        int n2 = sajh._c(this.sp.boundingBox._c);
        int n3 = sajh._c(this.sp.posZ);
        int n4 = n2 - (int)Math.ceil(d);
        if (this.esp == null) {
            ++n2;
            ++n4;
        }
        while (n2 >= n4) {
            int n5 = this.sp.worldObj.getBlockId(n, n2, n3);
            if (n5 > 0) {
                return n5;
            }
            --n2;
        }
        return -1;
    }
}

