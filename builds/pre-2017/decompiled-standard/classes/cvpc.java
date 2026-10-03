/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class cvpc
extends ohnk {
    @Override
    public String func_71517_b() {
        return "pardon";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.unban.usage";
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return dzfd._I().__ag()._l()._a() && super.func_71519_b(nemo2);
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            dzfd._I().__ag()._l()._b(stringArray[0]);
            cvpc.func_71522_a(nemo2, "commands.unban.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.unban.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return cvpc.func_71531_a(stringArray, dzfd._I().__ag()._l()._b().keySet());
        }
        return null;
    }
}

