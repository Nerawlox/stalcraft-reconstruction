/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.zwat;

public class cvpi
extends ohnk {
    @Override
    public String func_71517_b() {
        return "me";
    }

    @Override
    public int func_82362_a() {
        return 0;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.me.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0) {
            String string = cvpi.func_82361_a(nemo2, stringArray, 0, nemo2.func_70003_b(1, "me"));
            dzfd._I().__ag()._a(zwat._b("chat.type.emote", nemo2.func_70005_c_(), string));
            return;
        }
        throw new pksd("commands.me.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        return cvpi.func_71530_a(stringArray, dzfd._I()._i());
    }
}

