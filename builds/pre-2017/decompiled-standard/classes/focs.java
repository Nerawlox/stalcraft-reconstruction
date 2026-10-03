/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.sajz;
import net.minecraftforge.common.ForgeHooks;

public class focs
extends tgdv {
    public twgu[] _b;
    public float _c = 4.0f;
    public float _d;
    public txfz _e;

    public focs(int n, float f, txfz txfz2, twgu[] twguArray) {
        super(n);
        this._e = txfz2;
        this._b = twguArray;
        this.field_77777_bU = 1;
        this.func_77656_e(txfz2._a());
        this._c = txfz2._b();
        this._d = f + txfz2._c();
        this.func_77637_a(tgbl.field_78040_i);
    }

    @Override
    public float func_77638_a(cvzo cvzo2, twgu twgu2) {
        for (int i = 0; i < this._b.length; ++i) {
            if (this._b[i] != twgu2) continue;
            return this._c;
        }
        return 1.0f;
    }

    @Override
    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        cvzo2._a(2, entityLivingBase2);
        return true;
    }

    @Override
    public boolean func_77660_a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if ((double)twgu.field_71973_m[n].func_71934_m(ozlu2, n2, n3, n4) != 0.0) {
            cvzo2._a(1, entityLivingBase);
        }
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_77662_d() {
        return true;
    }

    @Override
    public int func_77619_b() {
        return this._e._e();
    }

    public String _a() {
        return this._e.toString();
    }

    @Override
    public boolean func_82789_a(cvzo cvzo2, cvzo cvzo3) {
        return this._e._f() == cvzo3._d ? true : super.func_82789_a(cvzo2, cvzo3);
    }

    @Override
    public Multimap func_111205_h() {
        Multimap multimap = super.func_111205_h();
        multimap.put(sajz._e._a(), new xson(field_111210_e, "Tool modifier", this._d, 0));
        return multimap;
    }

    @Override
    public float getStrVsBlock(cvzo cvzo2, twgu twgu2, int n) {
        if (ForgeHooks.isToolEffective(cvzo2, twgu2, n)) {
            return this._c;
        }
        return this.func_77638_a(cvzo2, twgu2);
    }
}

