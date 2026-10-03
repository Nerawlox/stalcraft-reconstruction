/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;

@ezey(_a={eidj.CLIENT})
public class EntityFlashlight
extends Entity {
    private EntityPlayer player;

    public EntityFlashlight(EntityPlayer entityPlayer) {
        super(entityPlayer.field_70170_p);
        this.player = entityPlayer;
        this.func_70105_a(0.0f, 0.0f);
        this.field_70145_X = true;
        ugqx._a((EntityPlayer)entityPlayer)._m = true;
        this.updatePos();
        DynamicLights.addLightSource(new gpzl(this));
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        ugqx ugqx2 = ugqx._a(this.player);
        if (this.player.field_70128_L || this.player.func_110143_aJ() <= 0.0f || !ClientProxy.dynamicLights.enabled || !ugqx2._s()) {
            this.func_70106_y();
        } else {
            this.updatePos();
        }
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        ugqx._a((EntityPlayer)this.player)._m = false;
    }

    private void updatePos() {
        hank hank2 = ugqx._a(this.player)._h();
        if (hank2 != null) {
            int n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            if (hank2._g == 0) {
                --n2;
            }
            if (hank2._g == 1) {
                ++n2;
            }
            if (hank2._g == 2) {
                --n3;
            }
            if (hank2._g == 3) {
                ++n3;
            }
            if (hank2._g == 4) {
                --n;
            }
            if (hank2._g == 5) {
                ++n;
            }
            this.func_70107_b((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
        } else {
            this.func_70106_y();
        }
    }

    @Override
    protected void func_70088_a() {
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
    }
}

