/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Multimap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;

public class vmpw
extends tgdv {
    public float field_77827_a;
    public final txfz field_77826_b;

    public vmpw(int n, txfz txfz2) {
        super(n);
        this.field_77826_b = txfz2;
        this.field_77777_bU = 1;
        this.func_77656_e(txfz2._a());
        this.func_77637_a(tgbl.field_78037_j);
        this.field_77827_a = 4.0f + txfz2._c();
    }

    public float func_82803_g() {
        return this.field_77826_b._c();
    }

    @Override
    public float func_77638_a(cvzo cvzo2, twgu twgu2) {
        if (twgu2.field_71990_ca == twgu.field_71955_W.field_71990_ca) {
            return 15.0f;
        }
        tflj tflj2 = twgu2.field_72018_cp;
        if (tflj2 == tflj._k || tflj2 == tflj._l || tflj2 == tflj._v || tflj2 == tflj._j || tflj2 == tflj._B) {
            return 1.5f;
        }
        return 1.0f;
    }

    @Override
    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        cvzo2._a(1, entityLivingBase2);
        return true;
    }

    @Override
    public boolean func_77660_a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if ((double)twgu.field_71973_m[n].func_71934_m(ozlu2, n2, n3, n4) != 0.0) {
            cvzo2._a(2, entityLivingBase);
        }
        return true;
    }

    @Override
    public boolean func_77662_d() {
        return true;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._d;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 72000;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public boolean func_77641_a(twgu twgu2) {
        return twgu2.field_71990_ca == twgu.field_71955_W.field_71990_ca;
    }

    @Override
    public int func_77619_b() {
        return this.field_77826_b._e();
    }

    public String func_77825_f() {
        return this.field_77826_b.toString();
    }

    @Override
    public boolean func_82789_a(cvzo cvzo2, cvzo cvzo3) {
        if (this.field_77826_b._f() == cvzo3._d) {
            return true;
        }
        return super.func_82789_a(cvzo2, cvzo3);
    }

    @Override
    public Multimap func_111205_h() {
        Multimap multimap = super.func_111205_h();
        multimap.put(sajz._e._a(), new xson(field_111210_e, "Weapon modifier", this.field_77827_a, 0));
        return multimap;
    }
}

