/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class baro
extends iwgt {
    public Random _a = new Random();
    public dwan _b;

    public baro(int n) {
        super(n, tflj._f);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 25;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new nfbs();
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this.func_71905_a(0.4375f, 0.0f, 0.4375f, 0.5625f, 0.875f, 0.5625f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        this.func_71919_f();
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
    }

    @Override
    public void func_71919_f() {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        nfbs nfbs2 = (nfbs)ozlu2.func_72796_p(n, n2, n3);
        if (nfbs2 != null) {
            entityPlayer.func_71017_a(nfbs2);
        }
        return true;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (cvzo2._u()) {
            ((nfbs)ozlu2.func_72796_p(n, n2, n3))._a(cvzo2._s());
        }
    }

    @Override
    public void func_71862_a(ozlu ozlu2, int n, int n2, int n3, Random random) {
        double d = (float)n + 0.4f + random.nextFloat() * 0.2f;
        double d2 = (float)n2 + 0.7f + random.nextFloat() * 0.3f;
        double d3 = (float)n3 + 0.4f + random.nextFloat() * 0.2f;
        ozlu2.func_72869_a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof nfbs) {
            nfbs nfbs2 = (nfbs)hurg2;
            for (int i = 0; i < nfbs2.func_70302_i_(); ++i) {
                cvzo cvzo2 = nfbs2.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this._a.nextFloat() * 0.8f + 0.1f;
                float f2 = this._a.nextFloat() * 0.8f + 0.1f;
                float f3 = this._a.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n6 = this._a.nextInt(21) + 10;
                    if (n6 > cvzo2._b) {
                        n6 = cvzo2._b;
                    }
                    cvzo2._b -= n6;
                    EntityItem entityItem = new EntityItem(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, new cvzo(cvzo2._d, n6, cvzo2._j()));
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this._a.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this._a.nextGaussian() * f4;
                    ozlu2.func_72838_d(entityItem);
                }
            }
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return tgdv.field_77724_by.field_77779_bT;
    }

    @Override
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77724_by.field_77779_bT;
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return jjgc.func_94526_b((mssh)((Object)ozlu2.func_72796_p(n, n2, n3)));
    }

    @Override
    public void func_94332_a(nege nege2) {
        super.func_94332_a(nege2);
        this._b = nege2._b(this.func_111023_E() + "_base");
    }

    public dwan _a() {
        return this._b;
    }
}

