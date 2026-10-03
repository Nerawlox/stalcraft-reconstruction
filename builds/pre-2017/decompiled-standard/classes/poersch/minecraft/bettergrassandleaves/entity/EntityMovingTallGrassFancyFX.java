/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFastFX;

@SideOnly(value=Side.CLIENT)
public class EntityMovingTallGrassFancyFX
extends EntityMovingTallGrassFastFX {
    protected Entity entity;
    protected float distanceWalked;
    protected int allowedBlockID;
    protected int color;
    protected int brightness;

    public EntityMovingTallGrassFancyFX(ozlu ozlu2, double d, double d2, double d3, float f, int n, int n2, dwan dwan2, Entity entity, int n3) {
        super(ozlu2, d, d2, d3, f, n, n2, dwan2);
        this.field_70547_e = 46;
        this.entity = entity;
        if (entity != null) {
            this.distanceWalked = entity.field_82151_R + 0.5f;
            this.allowedBlockID = n3;
        }
        this.color = n2;
        this.brightness = n;
    }

    @Override
    public int func_70537_b() {
        return 1;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70546_d++ > this.field_70547_e - 10) {
            this.field_82339_as = (float)(this.field_70547_e - this.field_70546_d) * 0.1f;
        }
        if (this.entity != null && this.entity.field_82151_R > this.distanceWalked) {
            if (this.field_70170_p.func_72798_a((int)this.entity.field_70165_t, (int)this.field_70163_u - 1, (int)this.entity.field_70161_v) == this.allowedBlockID) {
                xpzm._E()._w._a(new EntityMovingTallGrassFancyFX(this.field_70170_p, this.entity.field_70165_t, this.field_70163_u, this.entity.field_70161_v, this.field_70545_g, this.brightness, this.color, this.field_70550_a, null, 0));
            }
            this.entity = null;
        }
    }
}

