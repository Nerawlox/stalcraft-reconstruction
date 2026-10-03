/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFastFX;

@SideOnly(value=Side.CLIENT)
public class EntityMovingTallGrassFancyFX
extends EntityMovingTallGrassFastFX {
    protected Entity entity;
    protected float distanceWalked;
    protected int allowedBlockID;
    protected int color;
    protected int brightness;

    public EntityMovingTallGrassFancyFX(World world, double d, double d2, double d3, float f, int n, int n2, Icon icon, Entity entity, int n3) {
        super(world, d, d2, d3, f, n, n2, icon);
        this.particleMaxAge = 46;
        this.entity = entity;
        if (entity != null) {
            this.distanceWalked = entity.distanceWalkedOnStepModified + 0.5f;
            this.allowedBlockID = n3;
        }
        this.color = n2;
        this.brightness = n;
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.particleAge++ > this.particleMaxAge - 10) {
            this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) * 0.1f;
        }
        if (this.entity != null && this.entity.distanceWalkedOnStepModified > this.distanceWalked) {
            if (this.worldObj.getBlockId((int)this.entity.posX, (int)this.posY - 1, (int)this.entity.posZ) == this.allowedBlockID) {
                Minecraft._E()._w._a(new EntityMovingTallGrassFancyFX(this.worldObj, this.entity.posX, this.posY, this.entity.posZ, this.particleGravity, this.brightness, this.color, this.particleIcon, null, 0));
            }
            this.entity = null;
        }
    }
}

