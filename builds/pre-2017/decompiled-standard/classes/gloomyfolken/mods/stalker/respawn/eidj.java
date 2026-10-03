/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import net.minecraft.util.zwat;
import net.minecraft.util.zwaw;

public class eidj
extends ohnk {
    @Override
    public String func_71517_b() {
        return "setspawn";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "/setspawn <x> <y> <z>";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        try {
            int n;
            int n2;
            int n3;
            if (stringArray.length > 0) {
                n3 = Integer.parseInt(stringArray[0]);
                n2 = Integer.parseInt(stringArray[1]);
                n = Integer.parseInt(stringArray[2]);
            } else {
                zwaw zwaw2 = nemo2.func_82114_b();
                n3 = zwaw2._a;
                n2 = zwaw2._b;
                n = zwaw2._c;
            }
            nemo2.func_130014_f_().field_73011_w._b(n3, n2, n);
            nemo2.func_70006_a(new zwat()._a("\u0421\u043f\u0430\u0432\u043d\u043f\u043e\u0438\u043d\u0442 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d."));
            if (nemo2.func_130014_f_().func_72912_H()._r() != xtby._d) {
                nemo2.func_70006_a(new zwat()._a("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u0435 \u0438\u0433\u0440\u043e\u0432\u043e\u0439 \u0440\u0435\u0436\u0438\u043c \u043d\u0430 2!"));
            }
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException runtimeException) {
            throw new cene(this.func_71518_a(nemo2), new Object[0]);
        }
    }
}

