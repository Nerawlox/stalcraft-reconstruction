/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import net.minecraft.util.amxi;

public class bahe {
    public static float _a = 60.0f;
    public static amxi _b = new amxi();
    public static HashMap<Class<? extends tgdv>, woej> _c = new HashMap();

    public static void _a() {
        BufferedReader bufferedReader = null;
        try {
            String string = "/assets/stalker/weight.txt";
            bufferedReader = new BufferedReader(new InputStreamReader(GloomyCore.class.getResourceAsStream(string), "UTF-8"));
            boolean bl = false;
            while (!bl) {
                String string2 = bufferedReader.readLine();
                if (string2 == null) {
                    bl = true;
                    continue;
                }
                if ((string2 = string2.trim()).startsWith("#") || string2.startsWith("//") || string2.isEmpty()) continue;
                String[] stringArray = string2.split("-");
                String string3 = stringArray[0];
                float f = Float.parseFloat(stringArray[1].replace(",", "."));
                if (string3.equalsIgnoreCase("character_max")) {
                    _a = f;
                    continue;
                }
                _b._a(Integer.parseInt(stringArray[0]), Float.valueOf(f));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        _c.put(wolf.class, new briu());
    }

    public static float _a(int n) {
        return _b._c(n) ? ((Float)_b._b(n)).floatValue() : 0.1f;
    }

    public static float _a(int n, int n2) {
        return bahe._a(n) * (float)n2;
    }

    public static float _a(cvzo cvzo2) {
        if (cvzo2 == null) {
            return 0.0f;
        }
        woej woej2 = null;
        if (cvzo2._a() instanceof woej) {
            woej2 = (woej)((Object)cvzo2._a());
        }
        if (_c.containsKey(cvzo2._a().getClass())) {
            woej2 = _c.get(cvzo2._a().getClass());
        }
        if (woej2 != null) {
            return woej2._a(cvzo2);
        }
        if (cvzo2._e != null && cvzo2._e._c("weight")) {
            return cvzo2._e._h("weight");
        }
        return bahe._a(cvzo2._d, cvzo2._b);
    }
}

