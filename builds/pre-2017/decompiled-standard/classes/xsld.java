/*
 * Decompiled with CFR 0.152.
 */
public class xsld
extends ohnk {
    @Override
    public String func_71517_b() {
        return "publish";
    }

    @Override
    public int func_82362_a() {
        return 4;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.publish.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        String string = dzfd._I()._a(xtby._b, false);
        if (string != null) {
            xsld.func_71522_a(nemo2, "commands.publish.started", string);
        } else {
            xsld.func_71522_a(nemo2, "commands.publish.failed", new Object[0]);
        }
    }
}

