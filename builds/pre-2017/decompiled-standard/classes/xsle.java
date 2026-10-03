/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.zwat;

public class xsle
extends ohnk {
    @Override
    public String func_71517_b() {
        return "save-all";
    }

    @Override
    public int func_82362_a() {
        return 4;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.save.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        dzfd dzfd2 = dzfd._I();
        nemo2.func_70006_a(zwat._e("commands.save.start"));
        if (dzfd2.__ag() != null) {
            dzfd2.__ag()._n();
        }
        try {
            boolean bl;
            yfgy yfgy2;
            int n;
            for (n = 0; n < dzfd2._j.length; ++n) {
                if (dzfd2._j[n] == null) continue;
                yfgy2 = dzfd2._j[n];
                bl = yfgy2.field_73058_d;
                yfgy2.field_73058_d = false;
                yfgy2.func_73044_a(true, null);
                yfgy2.field_73058_d = bl;
            }
            if (stringArray.length > 0 && "flush".equals(stringArray[0])) {
                nemo2.func_70006_a(zwat._e("commands.save.flushStart"));
                for (n = 0; n < dzfd2._j.length; ++n) {
                    if (dzfd2._j[n] == null) continue;
                    yfgy2 = dzfd2._j[n];
                    bl = yfgy2.field_73058_d;
                    yfgy2.field_73058_d = false;
                    yfgy2.func_104140_m();
                    yfgy2.field_73058_d = bl;
                }
                nemo2.func_70006_a(zwat._e("commands.save.flushEnd"));
            }
        }
        catch (xcad xcad2) {
            xsle.func_71522_a(nemo2, "commands.save.failed", xcad2.getMessage());
            return;
        }
        xsle.func_71522_a(nemo2, "commands.save.success", new Object[0]);
    }
}

