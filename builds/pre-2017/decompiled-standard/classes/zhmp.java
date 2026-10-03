/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.util.zwat;

public class zhmp
extends ohnk {
    public static final String[] _a = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};

    @Override
    public String func_71517_b() {
        return "difficulty";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.difficulty.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0) {
            int n = this._a(nemo2, stringArray[0]);
            dzfd._I()._c(n);
            zhmp.func_71522_a(nemo2, "commands.difficulty.success", zwat._e(_a[n]));
            return;
        }
        throw new pksd("commands.difficulty.usage", new Object[0]);
    }

    public int _a(nemo nemo2, String string) {
        if (string.equalsIgnoreCase("peaceful") || string.equalsIgnoreCase("p")) {
            return 0;
        }
        if (string.equalsIgnoreCase("easy") || string.equalsIgnoreCase("e")) {
            return 1;
        }
        if (string.equalsIgnoreCase("normal") || string.equalsIgnoreCase("n")) {
            return 2;
        }
        if (string.equalsIgnoreCase("hard") || string.equalsIgnoreCase("h")) {
            return 3;
        }
        return zhmp.func_71532_a(nemo2, string, 0, 3);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return zhmp.func_71530_a(stringArray, "peaceful", "easy", "normal", "hard");
        }
        return null;
    }
}

