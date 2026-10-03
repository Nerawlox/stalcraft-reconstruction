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
import net.minecraft.util.owak;

public class ndvl
extends iwgt {
    public final Random _a = new Random();
    public dwan _b;
    public dwan _c;
    public dwan _d;

    public ndvl(int n) {
        super(n, tflj._f);
        this.func_71849_a(tgbl.field_78028_d);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        float f = 0.125f;
        this.func_71905_a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        this.func_71905_a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        this.func_71905_a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = owak._a[n4];
        if (n6 == 1) {
            n6 = 0;
        }
        return n6;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new cffd();
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        if (cvzo2._u()) {
            cffd cffd2 = ndvl._a(ozlu2, n, n2, n3);
            cffd2._a(cvzo2._s());
        }
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        this._a(ozlu2, n, n2, n3);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        cffd cffd2 = ndvl._a(ozlu2, n, n2, n3);
        if (cffd2 != null) {
            entityPlayer.func_94064_a(cffd2);
        }
        return true;
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3) {
        boolean bl;
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        int n5 = ndvl._a(n4);
        boolean bl2 = !ozlu2.func_72864_z(n, n2, n3);
        if (bl2 != (bl = ndvl._b(n4))) {
            ozlu2.func_72921_c(n, n2, n3, n5 | (bl2 ? 0 : 8), 4);
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        cffd cffd2 = (cffd)ozlu2.func_72796_p(n, n2, n3);
        if (cffd2 != null) {
            for (int i = 0; i < cffd2.func_70302_i_(); ++i) {
                cvzo cvzo2 = cffd2.func_70301_a(i);
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
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this._a.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this._a.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this._a.nextGaussian() * f4;
                    ozlu2.func_72838_d(entityItem);
                }
            }
            ozlu2.func_96440_m(n, n2, n3, n4);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public int func_71857_b() {
        return 38;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._c;
        }
        return this._b;
    }

    public static int _a(int n) {
        return n & 7;
    }

    public static boolean _b(int n) {
        return (n & 8) != 8;
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return jjgc.func_94526_b(ndvl._a(ozlu2, n, n2, n3));
    }

    @Override
    public void func_94332_a(nege nege2) {
        this._b = nege2._b("hopper_outside");
        this._c = nege2._b("hopper_top");
        this._d = nege2._b("hopper_inside");
    }

    public static dwan _a(String string) {
        if (string.equals("hopper_outside")) {
            return twgu.field_94340_cs._b;
        }
        if (string.equals("hopper_inside")) {
            return twgu.field_94340_cs._d;
        }
        return null;
    }

    @Override
    public String func_94327_t_() {
        return "hopper";
    }

    public static cffd _a(sdrg sdrg2, int n, int n2, int n3) {
        return (cffd)sdrg2.func_72796_p(n, n2, n3);
    }
}

