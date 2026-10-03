/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.block;

import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class BlockPreset
extends twgu {
    private dwan creativeIcon;

    public BlockPreset(int n) {
        super(n, GloomyCore.fakeAir);
        this.func_71864_b("preset");
        LanguageRegistry.addName(this, "\u0411\u043b\u043e\u043a-\u043f\u0440\u0435\u0441\u0435\u0442");
        GloomyCore.instance.airBlocks.add(this.field_71990_ca);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.field_111026_f);
        this.creativeIcon = nege2._b("stalker:transparent");
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.creativeIcon;
        }
        return this.field_94336_cN;
    }

    @Override
    public boolean func_71926_d() {
        return false;
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
}

