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
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFastFX;

@SideOnly(value=Side.CLIENT)
public class EntityMovingGrassFancyFX
extends EntityMovingGrassFastFX {
    protected Entity entity;
    protected float distanceWalked;
    protected int allowedBlockID;
    protected int color;
    protected int brightness;
    protected float brightnessMultiplier;

    public EntityMovingGrassFancyFX(World world, double d, double d2, double d3, float f, int n, int n2, float f2, int n3, Icon icon, boolean bl, Entity entity, int n4) {
        super(world, d, d2, d3, f, n, n2, f2, n3, icon, bl);
        this.particleMaxAge = 46;
        this.entity = entity;
        if (entity != null) {
            this.distanceWalked = entity.distanceWalkedOnStepModified + 0.5f;
            this.allowedBlockID = n4;
        }
        this.color = n3;
        this.brightness = n2;
        this.brightnessMultiplier = f2;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.particleAge++ > this.particleMaxAge - 10) {
            this.particleAlpha = (float)(this.particleMaxAge - this.particleAge) * 0.1f;
        }
        if (this.entity != null && this.entity.distanceWalkedOnStepModified > this.distanceWalked) {
            if (this.worldObj.getBlockId((int)this.entity.posX, (int)this.posY - 1, (int)this.entity.posZ) == this.allowedBlockID) {
                Minecraft._E()._w._a(new EntityMovingGrassFancyFX(this.worldObj, this.entity.posX, this.posY, this.entity.posZ, this.particleGravity, this.offsetIndex - 1, this.brightness, this.brightnessMultiplier, this.color, this.particleIcon, this.flipU, null, 0));
            }
            this.entity = null;
        }
    }
}

