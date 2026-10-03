/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.zwat;

public class wpes
extends ohnk {
    @Override
    public String func_71517_b() {
        return "gamerule";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.gamerule.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[0];
            String string2 = stringArray[1];
            mcam mcam2 = this._a();
            if (mcam2._c(string)) {
                mcam2._b(string, string2);
                wpes.func_71522_a(nemo2, "commands.gamerule.success", new Object[0]);
            } else {
                wpes.func_71522_a(nemo2, "commands.gamerule.norule", string);
            }
            return;
        }
        if (stringArray.length == 1) {
            String string = stringArray[0];
            mcam mcam3 = this._a();
            if (mcam3._c(string)) {
                String string3 = mcam3._a(string);
                nemo2.func_70006_a(zwat._d(string)._a(" = ")._a(string3));
            } else {
                wpes.func_71522_a(nemo2, "commands.gamerule.norule", string);
            }
            return;
        }
        if (stringArray.length == 0) {
            mcam mcam4 = this._a();
            nemo2.func_70006_a(zwat._d(wpes.func_71527_a(mcam4._b())));
            return;
        }
        throw new pksd("commands.gamerule.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return wpes.func_71530_a(stringArray, this._a()._b());
        }
        if (stringArray.length == 2) {
            return wpes.func_71530_a(stringArray, "true", "false");
        }
        return null;
    }

    public mcam _a() {
        return dzfd._I()._a(0).func_82736_K();
    }
}

