/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.client.particle.kjui;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;

public class ivxd
extends twgu {
    public ivxd(int n) {
        super(n, GloomyCore.fakeAir);
        this.func_111022_d("stalker:interference");
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean addBlockDestroyEffects(ozlu ozlu2, int n, int n2, int n3, int n4, kjui kjui2) {
        return true;
    }

    @Override
    public boolean addBlockHitEffects(ozlu ozlu2, hank hank2, kjui kjui2) {
        return true;
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
}

