/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;

public abstract class kkdx
extends twgu
implements flxv,
stgn {
    private qlgf _c;
    public String _a;
    protected dwan _b;
    private float _d;

    public kkdx(int n, tflj tflj2, qlgf qlgf2, String string, float f) {
        super(n, tflj2);
        this.func_71849_a(GloomyCore.tab);
        this.func_71875_q();
        this.field_72028_cf = true;
        this._c = qlgf2;
        this._a = string;
        this._d = f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_73012_v.nextFloat() < this._d) {
            ozlu2.func_72980_b(n, n2, n3, this._a, 0.5f + ozlu2.field_73012_v.nextFloat() * 0.5f, 0.9f + random.nextFloat() * 0.15f, false);
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
        this._b = nege2._b("anomalies:anomaly");
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this._b;
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

