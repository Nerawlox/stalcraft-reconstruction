/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;

public class ntaf
extends zwat {
    public EntityVillager _a;

    public ntaf(EntityVillager entityVillager) {
        this._a = entityVillager;
        this.func_75248_a(5);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._a.func_70089_S()) {
            return false;
        }
        if (this._a.func_70090_H()) {
            return false;
        }
        if (!this._a.field_70122_E) {
            return false;
        }
        if (this._a.field_70133_I) {
            return false;
        }
        EntityPlayer entityPlayer = this._a.func_70931_l_();
        if (entityPlayer == null) {
            return false;
        }
        if (this._a.func_70068_e(entityPlayer) > 16.0) {
            return false;
        }
        return entityPlayer.field_71070_bA instanceof jjgc;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._h();
    }

    @Override
    public void func_75251_c() {
        this._a.func_70932_a_(null);
    }
}

