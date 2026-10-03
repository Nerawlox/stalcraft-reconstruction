/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwaw;

public class zyqw
extends ohnk {
    @Override
    public String func_71517_b() {
        return "spawnpoint";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.spawnpoint.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        EntityPlayerMP entityPlayerMP;
        EntityPlayerMP entityPlayerMP2 = entityPlayerMP = stringArray.length == 0 ? zyqw.func_71521_c(nemo2) : zyqw.func_82359_c(nemo2, stringArray[0]);
        if (stringArray.length == 4) {
            if (entityPlayerMP.field_70170_p != null) {
                int n = 1;
                int n2 = 30000000;
                int n3 = zyqw.func_71532_a(nemo2, stringArray[n++], -n2, n2);
                int n4 = zyqw.func_71532_a(nemo2, stringArray[n++], 0, 256);
                int n5 = zyqw.func_71532_a(nemo2, stringArray[n++], -n2, n2);
                entityPlayerMP.func_71063_a(new zwaw(n3, n4, n5), true);
                zyqw.func_71522_a(nemo2, "commands.spawnpoint.success", entityPlayerMP.func_70023_ak(), n3, n4, n5);
            }
        } else if (stringArray.length <= 1) {
            zwaw zwaw2 = entityPlayerMP.func_82114_b();
            entityPlayerMP.func_71063_a(zwaw2, true);
            zyqw.func_71522_a(nemo2, "commands.spawnpoint.success", entityPlayerMP.func_70023_ak(), zwaw2._a, zwaw2._b, zwaw2._c);
        } else {
            throw new pksd("commands.spawnpoint.usage", new Object[0]);
        }
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 || stringArray.length == 2) {
            return zyqw.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

