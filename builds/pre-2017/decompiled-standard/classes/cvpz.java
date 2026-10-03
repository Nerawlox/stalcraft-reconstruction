/*
 * Decompiled with CFR 0.152.
 */
public class cvpz
extends ohnk {
    @Override
    public String func_71517_b() {
        return "save-on";
    }

    @Override
    public int func_82362_a() {
        return 4;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.save-on.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        dzfd dzfd2 = dzfd._I();
        boolean bl = false;
        for (int i = 0; i < dzfd2._j.length; ++i) {
            if (dzfd2._j[i] == null) continue;
            yfgy yfgy2 = dzfd2._j[i];
            if (!yfgy2.field_73058_d) continue;
            yfgy2.field_73058_d = false;
            bl = true;
        }
        if (!bl) {
            throw new cekk("commands.save-on.alreadyOn", new Object[0]);
        }
        cvpz.func_71522_a(nemo2, "commands.save.enabled", new Object[0]);
    }
}

