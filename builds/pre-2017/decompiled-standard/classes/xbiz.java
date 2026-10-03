/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class xbiz
extends ohnk {
    @Override
    public String func_71517_b() {
        return "weather";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.weather.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 1 || stringArray.length > 2) {
            throw new pksd("commands.weather.usage", new Object[0]);
        }
        int n = (300 + new Random().nextInt(600)) * 20;
        if (stringArray.length >= 2) {
            n = xbiz.func_71532_a(nemo2, stringArray[1], 1, 1000000) * 20;
        }
        yfgy yfgy2 = dzfd._I()._j[0];
        iyev iyev2 = yfgy2.func_72912_H();
        iyev2._f(n);
        iyev2._e(n);
        if ("clear".equalsIgnoreCase(stringArray[0])) {
            iyev2._b(false);
            iyev2._a(false);
            xbiz.func_71522_a(nemo2, "commands.weather.clear", new Object[0]);
        } else if ("rain".equalsIgnoreCase(stringArray[0])) {
            iyev2._b(true);
            iyev2._a(false);
            xbiz.func_71522_a(nemo2, "commands.weather.rain", new Object[0]);
        } else if ("thunder".equalsIgnoreCase(stringArray[0])) {
            iyev2._b(true);
            iyev2._a(true);
            xbiz.func_71522_a(nemo2, "commands.weather.thunder", new Object[0]);
        } else {
            throw new pksd("commands.weather.usage", new Object[0]);
        }
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return xbiz.func_71530_a(stringArray, "clear", "rain", "thunder");
        }
        return null;
    }
}

