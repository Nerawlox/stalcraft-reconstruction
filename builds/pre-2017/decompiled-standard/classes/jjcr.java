/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class jjcr
extends ohnk {
    @Override
    public String func_71517_b() {
        return "time";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.time.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 1) {
            if (stringArray[0].equals("set")) {
                int n = stringArray[1].equals("day") ? 0 : (stringArray[1].equals("night") ? 12500 : jjcr.func_71528_a(nemo2, stringArray[1], 0));
                this._a(nemo2, n);
                jjcr.func_71522_a(nemo2, "commands.time.set", n);
                return;
            }
            if (stringArray[0].equals("add")) {
                int n = jjcr.func_71528_a(nemo2, stringArray[1], 0);
                this._b(nemo2, n);
                jjcr.func_71522_a(nemo2, "commands.time.added", n);
                return;
            }
        }
        throw new pksd("commands.time.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return jjcr.func_71530_a(stringArray, "set", "add");
        }
        if (stringArray.length == 2 && stringArray[0].equals("set")) {
            return jjcr.func_71530_a(stringArray, "day", "night");
        }
        return null;
    }

    public void _a(nemo nemo2, int n) {
        for (int i = 0; i < dzfd._I()._j.length; ++i) {
            dzfd._I()._j[i].func_72877_b(n);
        }
    }

    public void _b(nemo nemo2, int n) {
        for (int i = 0; i < dzfd._I()._j.length; ++i) {
            yfgy yfgy2 = dzfd._I()._j[i];
            yfgy2.func_72877_b(yfgy2.func_72820_D() + (long)n);
        }
    }
}

