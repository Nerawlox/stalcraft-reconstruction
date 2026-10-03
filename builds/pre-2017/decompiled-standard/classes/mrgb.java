/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.entity.player.EntityPlayer;

public class mrgb
extends tgha {
    public mrgb(int n) {
        super(n - 256, 0, false);
        this.func_77637_a(GloomyCore.tab);
        this.func_77655_b("vodka");
        LanguageRegistry.addName(this, "\u0412\u043e\u0434\u043a\u0430");
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 32;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._c;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!entityPlayer.field_71075_bZ._d) {
            --cvzo2._b;
        }
        if (!ozlu2.field_72995_K) {
            tupg._a((EntityPlayer)entityPlayer)._b._b()._b(-20.0f);
            entityPlayer.func_70690_d(new supr(9, 400));
        }
        ncwh._a(entityPlayer)._a(StalkerMiscMod._C)._e();
        return cvzo2._b <= 0 ? new cvzo(StalkerMiscMod.__ao) : cvzo2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalker:vodka");
    }
}

