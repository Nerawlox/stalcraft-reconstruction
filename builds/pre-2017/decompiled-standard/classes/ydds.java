/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.client.particle.kjui;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;

public class ydds
extends twgu
implements stgn {
    public ydds(int n) {
        super(n, tflj._a);
        this.func_111022_d("stalker:psycho1");
        this.func_71864_b("distortionBlock");
        LanguageRegistry.addName(this, "\u0411\u043b\u043e\u043a \u0438\u0441\u043a\u0430\u0436\u0435\u043d\u0438\u0439");
        GloomyCore.instance.airBlocks.add(this.field_71990_ca);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new mrca();
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

