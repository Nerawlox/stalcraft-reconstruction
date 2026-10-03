/*
 * Decompiled with CFR 0.152.
 */
public class rqzd
extends ohnk {
    @Override
    public String func_71517_b() {
        return "setidletimeout";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.setidletimeout.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            int n = rqzd.func_71528_a(nemo2, stringArray[0], 0);
            dzfd._I()._e(n);
            rqzd.func_71522_a(nemo2, "commands.setidletimeout.success", n);
            return;
        }
        throw new pksd("commands.setidletimeout.usage", new Object[0]);
    }
}

