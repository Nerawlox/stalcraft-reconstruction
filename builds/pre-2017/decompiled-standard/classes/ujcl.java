/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ujcl
extends ohnk {
    @Override
    public String func_71517_b() {
        return "op";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.op.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 0) {
            dzfd._I().__ag()._a(stringArray[0]);
            ujcl.func_71522_a(nemo2, "commands.op.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.op.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            String string = stringArray[stringArray.length - 1];
            ArrayList<String> arrayList = new ArrayList<String>();
            for (String string2 : dzfd._I()._i()) {
                if (dzfd._I().__ag()._g(string2) || !ujcl.func_71523_a(string, string2)) continue;
                arrayList.add(string2);
            }
            return arrayList;
        }
        return null;
    }
}

