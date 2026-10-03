/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;

public class scce
extends uilx {
    public static final String[] _a = new String[]{"intact", "slightlyDamaged", "veryDamaged"};
    public static final String[] _b = new String[]{"anvil_top_damaged_0", "anvil_top_damaged_1", "anvil_top_damaged_2"};
    public int _c;
    public dwan[] _d;

    public scce(int n) {
        super(n, tflj._g);
        this.func_71868_h(0);
        this.func_71849_a(tgbl.field_78031_c);
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
    public dwan func_71858_a(int n, int n2) {
        if (this._c == 3 && n == 1) {
            int n3 = (n2 >> 2) % this._d.length;
            return this._d[n3];
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("anvil_base");
        this._d = new dwan[_b.length];
        for (int i = 0; i < this._d.length; ++i) {
            this._d[i] = nege2._b(_b[i]);
        }
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
        int n5 = ozlu2.func_72805_g(n, n2, n3) >> 2;
        ++n4;
        if ((n4 %= 4) == 0) {
            ozlu2.func_72921_c(n, n2, n3, 2 | n5 << 2, 2);
        }
        if (n4 == 1) {
            ozlu2.func_72921_c(n, n2, n3, 3 | n5 << 2, 2);
        }
        if (n4 == 2) {
            ozlu2.func_72921_c(n, n2, n3, 0 | n5 << 2, 2);
        }
        if (n4 == 3) {
            ozlu2.func_72921_c(n, n2, n3, 1 | n5 << 2, 2);
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        qlgf._a(this, ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
        return false;
    }

    @Override
    public int func_71857_b() {
        return 35;
    }

    @Override
    public int func_71899_b(int n) {
        return n >> 2;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3) & 3;
        if (n4 == 3 || n4 == 1) {
            this.func_71905_a(0.0f, 0.0f, 0.125f, 1.0f, 1.0f, 0.875f);
        } else {
            this.func_71905_a(0.125f, 0.0f, 0.0f, 0.875f, 1.0f, 1.0f);
        }
    }

    @Override
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        list2.add(new cvzo(n, 1, 0));
        list2.add(new cvzo(n, 1, 1));
        list2.add(new cvzo(n, 1, 2));
    }

    @Override
    public void _a(EntityFallingSand entityFallingSand) {
        entityFallingSand.func_82154_e(true);
    }

    @Override
    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72926_e(1022, n, n2, n3, 0);
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }
}

