/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.zwat;

public class ceoe
extends ohnk {
    @Override
    public String func_71517_b() {
        return "say";
    }

    @Override
    public int func_82362_a() {
        return 1;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.say.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0 && stringArray[0].length() > 0) {
            String string = ceoe.func_82361_a(nemo2, stringArray, 0, true);
            dzfd._I().__ag()._a(zwat._b("chat.type.announcement", nemo2.func_70005_c_(), string));
            return;
        }
        throw new pksd("commands.say.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1) {
            return ceoe.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }
}

