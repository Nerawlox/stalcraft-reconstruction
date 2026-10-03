/*
 * Decompiled with CFR 0.152.
 */
public class tgqv
extends ohnk {
    @Override
    public String func_71517_b() {
        return "testfor";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.testfor.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length != 1) {
            throw new pksd("commands.testfor.usage", new Object[0]);
        }
        if (!(nemo2 instanceof oiid)) {
            throw new cekk("commands.testfor.failed", new Object[0]);
        }
        tgqv.func_82359_c(nemo2, stringArray[0]);
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

