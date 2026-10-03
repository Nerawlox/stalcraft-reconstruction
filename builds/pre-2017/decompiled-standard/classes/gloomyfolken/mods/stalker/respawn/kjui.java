/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.respawn.jxtc;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;

public class kjui
extends twgu
implements stgn {
    private dwan _a;

    public kjui(int n) {
        super(n, GloomyCore.fakeAir);
        this.func_71864_b("block_savepoint");
        this.func_71849_a(GloomyCore.tab);
        this.func_71875_q();
        LanguageRegistry.addName(this, "\u0422\u043e\u0447\u043a\u0430 \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u044f");
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.func_71868_h(0);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (!ozlu2.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:transparent");
        this._a = nege2._b("anomalies:anomaly");
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this._a;
    }

    @Override
    public boolean addBlockDestroyEffects(ozlu ozlu2, int n, int n2, int n3, int n4, net.minecraft.client.particle.kjui kjui2) {
        return true;
    }

    @Override
    public boolean addBlockHitEffects(ozlu ozlu2, hank hank2, net.minecraft.client.particle.kjui kjui2) {
        return true;
    }

    @Override
    public boolean isAirBlock(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public int func_71857_b() {
        return GloomyCore.transparentsRenderType;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new jxtc();
    }
}

