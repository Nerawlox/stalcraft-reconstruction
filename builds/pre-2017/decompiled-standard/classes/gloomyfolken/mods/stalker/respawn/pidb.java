/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.stalker.respawn.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;
import org.apache.commons.lang3.StringUtils;

public class pidb
extends ohnk {
    @Override
    public String func_71517_b() {
        return "savepoint";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 0) {
            throw new pksd(this.func_71518_a(nemo2), new Object[0]);
        }
        if (!(nemo2 instanceof EntityPlayer)) {
            throw new cekk("Only players can use this command", new Object[0]);
        }
        jgro jgro2 = jgro._a((EntityPlayer)nemo2);
        if (jgro2._i == null) {
            jgro2._i = new jgro.kjui();
        }
        jgro.kjui kjui2 = jgro2._i;
        if (stringArray[0].equals("name")) {
            kjui2._a = StringUtils.join((Object[])stringArray, ' ', 1, stringArray.length);
            nemo2.func_70006_a(new zwat()._a("\u0418\u043c\u044f \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e."));
        }
        if (stringArray[0].equals("radius")) {
            kjui2._c = Integer.parseInt(stringArray[1]);
            nemo2.func_70006_a(new zwat()._a("\u0420\u0430\u0434\u0438\u0443\u0441 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d."));
        }
        if (stringArray[0].equals("force")) {
            kjui2._d = Boolean.parseBoolean(stringArray[1]);
            nemo2.func_70006_a(new zwat()._a("\u041f\u0440\u0438\u043d\u0443\u0434\u0435\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430."));
        }
        if (stringArray[0].equals("icon")) {
            kjui2._e = Boolean.parseBoolean(stringArray[1]);
            nemo2.func_70006_a(new zwat()._a("\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0438\u043a\u043e\u043d\u043a\u0438 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e."));
        }
        if (stringArray[0].equals("factions")) {
            kjui2._f.clear();
            for (int i = 1; i < stringArray.length; ++i) {
                kjui2._f.add(tupg.valueOf(stringArray[i].toUpperCase()));
            }
            nemo2.func_70006_a(new zwat()._a("\u0424\u0440\u0430\u043a\u0446\u0438\u0438 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u044b."));
        }
        if (stringArray[0].equals("pos")) {
            einh einh2 = new einh(jgro2.player.field_70170_p, (double)Integer.parseInt(stringArray[1]), (double)Integer.parseInt(stringArray[2]), (double)Integer.parseInt(stringArray[3]));
            satm satm2 = stringArray.length >= 5 ? new satm(Integer.parseInt(stringArray[4]), Integer.parseInt(stringArray[5])) : satm._a;
            kjui2._b = new hrvl(einh2, satm2);
            nemo2.func_70006_a(new zwat()._a("\u041f\u043e\u0437\u0438\u0446\u0438\u044f \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430."));
        }
        if (stringArray[0].equals("reset")) {
            jgro2._i = null;
            nemo2.func_70006_a(new zwat()._a("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0441\u0435\u0439\u0432\u043f\u043e\u0438\u043d\u0442\u0430 \u0441\u0431\u0440\u043e\u0448\u0435\u043d\u044b."));
        }
        if (stringArray[0].equals("check")) {
            nemo2.func_70006_a(new zwat()._a(kjui2.toString()));
        }
    }
}

