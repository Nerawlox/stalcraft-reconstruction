/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.regex.Matcher;

public class fnxi
extends ohnk {
    @Override
    public String func_71517_b() {
        return "pardon-ip";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return dzfd._I().__ag()._m()._a() && super.func_71519_b(nemo2);
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.unbanip.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1 && stringArray[0].length() > 1) {
            Matcher matcher = bsjk._a.matcher(stringArray[0]);
            if (matcher.matches()) {
                dzfd._I().__ag()._m()._b(stringArray[0]);
                fnxi.func_71522_a(nemo2, "commands.unbanip.success", stringArray[0]);
                return;
            }
            throw new cene("commands.unbanip.invalid", new Object[0]);
        }
        throw new pksd("commands.unbanip.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return fnxi.func_71531_a(stringArray, dzfd._I().__ag()._m()._b().keySet());
        }
        return null;
    }
}

