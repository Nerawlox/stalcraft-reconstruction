/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.zwat;

public class cvmk
extends ohnk {
    @Override
    public String func_71517_b() {
        return "banlist";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return (dzfd._I().__ag()._m()._a() || dzfd._I().__ag()._l()._a()) && super.func_71519_b(nemo2);
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.banlist.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].equalsIgnoreCase("ips")) {
            nemo2.func_70006_a(zwat._b("commands.banlist.ips", dzfd._I().__ag()._m()._b().size()));
            nemo2.func_70006_a(zwat._d(cvmk.func_71527_a(dzfd._I().__ag()._m()._b().keySet().toArray())));
        } else {
            nemo2.func_70006_a(zwat._b("commands.banlist.players", dzfd._I().__ag()._l()._b().size()));
            nemo2.func_70006_a(zwat._d(cvmk.func_71527_a(dzfd._I().__ag()._l()._b().keySet().toArray())));
        }
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return cvmk.func_71530_a(stringArray, "players", "ips");
        }
        return null;
    }
}

