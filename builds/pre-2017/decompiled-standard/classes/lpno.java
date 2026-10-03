/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class lpno
extends tgdv {
    public static final int[] field_77882_bY = new int[]{11, 16, 15, 13};
    public static final String[] field_94606_cu = new String[]{"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};
    public static final String[] field_94603_a = new String[]{"empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots"};
    public static final vmgb field_96605_cw = new pkyq();
    public final int field_77881_a;
    public final int field_77879_b;
    public final int field_77880_c;
    public final yery field_77878_bZ;
    @SideOnly(value=Side.CLIENT)
    public dwan field_94605_cw;
    @SideOnly(value=Side.CLIENT)
    public dwan field_94604_cx;

    public lpno(int n, yery yery2, int n2, int n3) {
        super(n);
        this.field_77878_bZ = yery2;
        this.field_77881_a = n3;
        this.field_77880_c = n2;
        this.field_77879_b = yery2._b(n3);
        this.func_77656_e(yery2._a(n3));
        this.field_77777_bU = 1;
        this.func_77637_a(tgbl.field_78037_j);
        ejzs._a._a(this, field_96605_cw);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_82790_a(cvzo cvzo2, int n) {
        if (n > 0) {
            return 0xFFFFFF;
        }
        int n2 = this.func_82814_b(cvzo2);
        if (n2 < 0) {
            n2 = 0xFFFFFF;
        }
        return n2;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_77623_v() {
        return this.field_77878_bZ == yery._a;
    }

    @Override
    public int func_77619_b() {
        return this.field_77878_bZ._a();
    }

    public yery func_82812_d() {
        return this.field_77878_bZ;
    }

    public boolean func_82816_b_(cvzo cvzo2) {
        return this.field_77878_bZ != yery._a ? false : (!cvzo2._p() ? false : (!cvzo2._q()._c("display") ? false : cvzo2._q()._m("display")._c("color")));
    }

    public int func_82814_b(cvzo cvzo2) {
        if (this.field_77878_bZ != yery._a) {
            return -1;
        }
        qoac qoac2 = cvzo2._q();
        if (qoac2 == null) {
            return 10511680;
        }
        qoac qoac3 = qoac2._m("display");
        return qoac3 == null ? 10511680 : (qoac3._c("color") ? qoac3._f("color") : 10511680);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_77618_c(int n, int n2) {
        return n2 == 1 ? this.field_94605_cw : super.func_77618_c(n, n2);
    }

    public void func_82815_c(cvzo cvzo2) {
        qoac qoac2;
        qoac qoac3;
        if (this.field_77878_bZ == yery._a && (qoac3 = cvzo2._q()) != null && (qoac2 = qoac3._m("display"))._c("color")) {
            qoac2._p("color");
        }
    }

    public void func_82813_b(cvzo cvzo2, int n) {
        if (this.field_77878_bZ != yery._a) {
            throw new UnsupportedOperationException("Can't dye non-leather!");
        }
        qoac qoac2 = cvzo2._q();
        if (qoac2 == null) {
            qoac2 = new qoac();
            cvzo2._d(qoac2);
        }
        qoac qoac3 = qoac2._m("display");
        if (!qoac2._c("display")) {
            qoac2._a("display", qoac3);
        }
        qoac3._a("color", n);
    }

    @Override
    public boolean func_82789_a(cvzo cvzo2, cvzo cvzo3) {
        return this.field_77878_bZ._b() == cvzo3._d ? true : super.func_82789_a(cvzo2, cvzo3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        super.func_94581_a(nege2);
        if (this.field_77878_bZ == yery._a) {
            this.field_94605_cw = nege2._b(field_94606_cu[this.field_77881_a]);
        }
        this.field_94604_cx = nege2._b(field_94603_a[this.field_77881_a]);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        int n = EntityLiving.func_82159_b(cvzo2) - 1;
        cvzo cvzo3 = entityPlayer.func_82169_q(n);
        if (cvzo3 == null) {
            entityPlayer.func_70062_b(n + 1, cvzo2._l());
            cvzo2._b = 0;
        }
        return cvzo2;
    }

    @SideOnly(value=Side.CLIENT)
    public static dwan func_94602_b(int n) {
        switch (n) {
            case 0: {
                return tgdv.field_77820_ah.field_94604_cx;
            }
            case 1: {
                return tgdv.field_77798_ai.field_94604_cx;
            }
            case 2: {
                return tgdv.field_77800_aj.field_94604_cx;
            }
            case 3: {
                return tgdv.field_77794_ak.field_94604_cx;
            }
        }
        return null;
    }

    public static int[] func_77877_c() {
        return field_77882_bY;
    }
}

