/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.anomaly.kjui;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class goxw
extends BlockFluidClassic
implements flxv,
stgn {
    @ezey(_a={eidj.CLIENT})
    protected dwan _a;
    public qlgf _b;

    public goxw(int n, Fluid fluid) {
        super(n, fluid, new zwok());
        this.func_71864_b("kisselFluid");
        this.func_71849_a(GloomyCore.tab);
        this.quantaPerBlock = 0;
        this.field_72028_cf = true;
        this._b = new qlgf(kjui._q._k);
        LanguageRegistry.addName(this, "\u041a\u0438\u0441\u0435\u043b\u044c");
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public dwan func_71858_a(int n, int n2) {
        return this._a;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94332_a(nege nege2) {
        this._a = nege2._b("anomalies:kissel_still");
    }

    @Override
    public boolean canDisplace(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72803_f(n, n2, n3)._d()) {
            return false;
        }
        return super.canDisplace(sdrg2, n, n2, n3);
    }

    @Override
    public boolean displaceIfPossible(ozlu ozlu2, int n, int n2, int n3) {
        if (ozlu2.func_72803_f(n, n2, n3)._d()) {
            return false;
        }
        return super.displaceIfPossible(ozlu2, n, n2, n3);
    }

    @Override
    public int getQuantaValue(sdrg sdrg2, int n, int n2, int n3) {
        return 1;
    }

    @Override
    public int func_71857_b() {
        return AnomalyMod._C;
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if (!ozlu2.field_72995_K && entity instanceof EntityLivingBase && !entity.func_85032_ar()) {
            if (entity instanceof EntityPlayer) {
                gloomyfolken.mods.anomaly.ezey._a((EntityPlayer)((EntityPlayer)entity))._d = true;
            }
            if (ozlu2.field_73012_v.nextFloat() > 0.95f) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        if (ozlu2.field_72995_K && !entity.func_85032_ar() && entity instanceof EntityLivingBase) {
            InvokeSideOnly.client(() -> ((pztv)ozlu2.func_72796_p(n, n2, n3))._a());
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new pztv();
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_73012_v.nextFloat() < 0.005f) {
            ozlu2.func_72980_b(n, n2, n3, "anomalies:kissel", 0.5f + ozlu2.field_73012_v.nextFloat() * 0.5f, 0.9f + random.nextFloat() * 0.15f, false);
        }
    }

    @Override
    public int getLightValue(sdrg sdrg2, int n, int n2, int n3) {
        return 11;
    }
}

