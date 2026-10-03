/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.eidj;
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class ncos
extends ohnk {
    private static final int _a = 1000000;
    private static eidj _b = new eidj(0, 0, null);

    @Override
    public String func_71517_b() {
        return "setblocks";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        int n;
        if (!(nemo2 instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)nemo2;
        pidb pidb2 = pidb._a(entityPlayer);
        einh einh2 = pidb2._d;
        einh einh3 = pidb2._e;
        if (einh2 == null || einh3 == null) {
            entityPlayer.func_71035_c("\u041e\u0431\u043b\u0430\u0441\u0442\u044c \u043d\u0435 \u0432\u044b\u0431\u0440\u0430\u043d\u0430");
            return;
        }
        if (einh2._a(einh3) > 1000000L) {
            entityPlayer.func_71035_c("\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0437\u0430 \u0440\u0430\u0437 \u0431\u043e\u043b\u044c\u0448\u0435, \u0447\u0435\u043c 1000000 \u0431\u043b\u043e\u043a\u043e\u0432.");
        }
        if (stringArray.length == 0) {
            entityPlayer.func_71035_c("Usage: /setblocks 1234:3%30 brush1%70");
        }
        float[] fArray = new float[stringArray.length];
        eidj[] eidjArray = new eidj[stringArray.length];
        float f = 0.0f;
        for (n = 0; n < stringArray.length; ++n) {
            Object object;
            float f2;
            String string;
            String string2 = stringArray[n];
            int n2 = string2.indexOf("%");
            if (n2 == -1) {
                string = string2;
                f2 = 1.0f;
            } else {
                string = string2.substring(0, n2);
                try {
                    object = string2.substring(n2 + 1);
                    f2 = sajh._a(Float.parseFloat((String)object) / 100.0f, 0.0f, 1.0f);
                }
                catch (Exception exception) {
                    entityPlayer.func_71035_c("Usage: /setblocks 1234:3%30 brush1%70");
                    return;
                }
            }
            fArray[n] = f2;
            f += f2;
            if (string.matches("\\d+(:\\d+)?")) {
                int n3;
                int n4 = string.indexOf(":");
                int n5 = 0;
                if (n4 == -1) {
                    n3 = Integer.parseInt(string);
                } else {
                    String string3 = string.substring(0, n4);
                    String string4 = string.substring(n4 + 1);
                    n3 = Integer.parseInt(string3);
                    n5 = Integer.parseInt(string4);
                }
                if (n3 >= 4096 || n5 >= 16) {
                    entityPlayer.func_71035_c("Max id is 4095, max meta is 15");
                    return;
                }
                object = new eidj(n3, n5, null);
            } else {
                object = pidb2._b.get(string);
                if (object == null) {
                    entityPlayer.func_71035_c("Brush " + string + " not found!");
                    return;
                }
            }
            eidjArray[n] = object;
        }
        if (f > 1.0f) {
            n = 0;
            while (n < fArray.length) {
                int n6 = n++;
                fArray[n6] = fArray[n6] / f;
            }
        }
        ncos._a(einh2, einh3, eidjArray, fArray);
    }

    public static void _a(einh einh2, einh einh3, eidj[] eidjArray, float[] fArray) {
        einh einh4 = einh2._b(einh3);
        einh einh5 = einh2._c(einh3);
        yfgy yfgy2 = dzfd._I()._a(einh2._b);
        for (int i = einh4._c(); i <= einh5._c(); ++i) {
            for (int j = einh4._d(); j <= einh5._d(); ++j) {
                for (int k = einh4._e(); k <= einh5._e(); ++k) {
                    eidj eidj2 = ncos._a(eidjArray, fArray);
                    yfgy2.func_72832_d(i, j, k, eidj2._a, eidj2._b, 3);
                    if (eidj2._c == null) continue;
                    hurg hurg2 = yfgy2.func_72796_p(i, j, k);
                    hurg2.func_70307_a(eidj2._c);
                    hurg2.field_70329_l = i;
                    hurg2.field_70330_m = j;
                    hurg2.field_70327_n = k;
                }
            }
        }
    }

    private static eidj _a(eidj[] eidjArray, float[] fArray) {
        float f;
        float f2 = (float)Math.random();
        int n = -1;
        for (f = 0.0f; f <= f2 && n + 1 < fArray.length; f += fArray[++n]) {
        }
        if (f < f2) {
            return _b;
        }
        return eidjArray[n];
    }
}

