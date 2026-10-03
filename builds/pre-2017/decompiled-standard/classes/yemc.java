/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.util.zwat;

public class yemc
extends ohnk {
    @Override
    public String func_71517_b() {
        return "whitelist";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.whitelist.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1) {
            if (stringArray[0].equals("on")) {
                dzfd._I().__ag()._a(true);
                yemc.func_71522_a(nemo2, "commands.whitelist.enabled", new Object[0]);
                return;
            }
            if (stringArray[0].equals("off")) {
                dzfd._I().__ag()._a(false);
                yemc.func_71522_a(nemo2, "commands.whitelist.disabled", new Object[0]);
                return;
            }
            if (stringArray[0].equals("list")) {
                nemo2.func_70006_a(zwat._b("commands.whitelist.list", dzfd._I().__ag()._o().size(), dzfd._I().__ag()._s().length));
                Set set = dzfd._I().__ag()._o();
                nemo2.func_70006_a(zwat._d(yemc.func_71527_a(set.toArray(new String[set.size()]))));
                return;
            }
            if (stringArray[0].equals("add")) {
                if (stringArray.length < 2) {
                    throw new pksd("commands.whitelist.add.usage", new Object[0]);
                }
                dzfd._I().__ag()._d(stringArray[1]);
                yemc.func_71522_a(nemo2, "commands.whitelist.add.success", stringArray[1]);
                return;
            }
            if (stringArray[0].equals("remove")) {
                if (stringArray.length < 2) {
                    throw new pksd("commands.whitelist.remove.usage", new Object[0]);
                }
                dzfd._I().__ag()._c(stringArray[1]);
                yemc.func_71522_a(nemo2, "commands.whitelist.remove.success", stringArray[1]);
                return;
            }
            if (stringArray[0].equals("reload")) {
                dzfd._I().__ag()._a();
                yemc.func_71522_a(nemo2, "commands.whitelist.reloaded", new Object[0]);
                return;
            }
        }
        throw new pksd("commands.whitelist.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return yemc.func_71530_a(stringArray, "on", "off", "list", "add", "remove", "reload");
        }
        if (stringArray.length == 2) {
            if (stringArray[0].equals("add")) {
                String[] stringArray2 = dzfd._I().__ag()._s();
                ArrayList<String> arrayList = new ArrayList<String>();
                String string = stringArray[stringArray.length - 1];
                for (String string2 : stringArray2) {
                    if (!yemc.func_71523_a(string, string2) || dzfd._I().__ag()._o().contains(string2)) continue;
                    arrayList.add(string2);
                }
                return arrayList;
            }
            if (stringArray[0].equals("remove")) {
                return yemc.func_71531_a(stringArray, dzfd._I().__ag()._o());
            }
        }
        return null;
    }
}

