/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

public class pkzb
extends yeso {
    public final mssh _a;
    public EntityPlayer _b;
    public int _c;

    public pkzb(EntityPlayer entityPlayer, mssh mssh2, mssh mssh3, int n, int n2, int n3) {
        super(mssh3, n, n2, n3);
        this._b = entityPlayer;
        this._a = mssh2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return false;
    }

    @Override
    public cvzo func_75209_a(int n) {
        if (this.func_75216_d()) {
            this._c += Math.min(n, this.func_75211_c()._b);
        }
        return super.func_75209_a(n);
    }

    @Override
    public void func_75210_a(cvzo cvzo2, int n) {
        this._c += n;
        this.func_75208_c(cvzo2);
    }

    @Override
    public void func_75208_c(cvzo cvzo2) {
        cvzo2._a(this._b.field_70170_p, this._b, this._c);
        this._c = 0;
        if (cvzo2._d == twgu.field_72060_ay.field_71990_ca) {
            this._b.func_71064_a(sdqa._h, 1);
        } else if (cvzo2._d == tgdv.field_77713_t.field_77779_bT) {
            this._b.func_71064_a(sdqa._i, 1);
        } else if (cvzo2._d == twgu.field_72051_aB.field_71990_ca) {
            this._b.func_71064_a(sdqa._j, 1);
        } else if (cvzo2._d == tgdv.field_77678_N.field_77779_bT) {
            this._b.func_71064_a(sdqa._l, 1);
        } else if (cvzo2._d == tgdv.field_77684_U.field_77779_bT) {
            this._b.func_71064_a(sdqa._m, 1);
        } else if (cvzo2._d == tgdv.field_77746_aZ.field_77779_bT) {
            this._b.func_71064_a(sdqa._n, 1);
        } else if (cvzo2._d == tgdv.field_77720_x.field_77779_bT) {
            this._b.func_71064_a(sdqa._o, 1);
        } else if (cvzo2._d == tgdv.field_77715_r.field_77779_bT) {
            this._b.func_71064_a(sdqa._r, 1);
        } else if (cvzo2._d == twgu.field_72096_bE.field_71990_ca) {
            this._b.func_71064_a(sdqa._D, 1);
        } else if (cvzo2._d == twgu.field_72093_an.field_71990_ca) {
            this._b.func_71064_a(sdqa._F, 1);
        }
    }

    @Override
    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        GameRegistry.onItemCrafted(entityPlayer, cvzo2, this._a);
        this.func_75208_c(cvzo2);
        for (int i = 0; i < this._a.func_70302_i_(); ++i) {
            cvzo cvzo3 = this._a.func_70301_a(i);
            if (cvzo3 == null) continue;
            this._a.func_70298_a(i, 1);
            if (!cvzo3._a().func_77634_r()) continue;
            cvzo cvzo4 = cvzo3._a().getContainerItemStack(cvzo3);
            if (cvzo4._f() && cvzo4._j() > cvzo4._k()) {
                MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this._b, cvzo4));
                cvzo4 = null;
            }
            if (cvzo4 == null || cvzo3._a().func_77630_h(cvzo3) && this._b.field_71071_by._c(cvzo4)) continue;
            if (this._a.func_70301_a(i) == null) {
                this._a.func_70299_a(i, cvzo4);
                continue;
            }
            this._b.func_71021_b(cvzo4);
        }
    }
}

