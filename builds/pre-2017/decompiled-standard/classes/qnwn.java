/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class qnwn
extends ohnk {
    @Override
    public String func_71517_b() {
        return "deop";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.deop.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            dzfd._I().__ag()._b(stringArray[0]);
            qnwn.func_71522_a(nemo2, "commands.deop.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.deop.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return qnwn.func_71531_a(stringArray, dzfd._I().__ag()._p());
        }
        return null;
    }
}

