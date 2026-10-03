/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.amww;
import net.minecraft.entity.player.EntityPlayer;

public class srli
implements amww {
    public sdcl _a;
    public EntityPlayer _b;
    public ywfi _c;

    public srli(EntityPlayer entityPlayer) {
        this._b = entityPlayer;
        this._a = new sdcl(entityPlayer, this);
    }

    @Override
    public EntityPlayer func_70931_l_() {
        return this._b;
    }

    @Override
    public void func_70932_a_(EntityPlayer entityPlayer) {
    }

    @Override
    public ywfi func_70934_b(EntityPlayer entityPlayer) {
        return this._c;
    }

    @Override
    public void func_70930_a(ywfi ywfi2) {
        this._c = ywfi2;
    }

    @Override
    public void func_70933_a(ozjk ozjk2) {
    }

    @Override
    public void func_110297_a_(cvzo cvzo2) {
    }
}

