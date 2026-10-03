/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.sajh;

public class elpk {
    public final List _a = new ArrayList();
    public final Map _b = new HashMap();
    public int _c;

    public int _a() {
        return this._c;
    }

    public void _a(int n) {
        this._c = n;
    }

    public Map _b() {
        return this._b;
    }

    public List _c() {
        return this._a;
    }

    public void _d() {
        int n = 0;
        for (suyo suyo2 : this._a) {
            suyo2._a(n);
            n += suyo2._a();
        }
    }

    public String toString() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(2);
        stringBuilder.append(";");
        for (n = 0; n < this._a.size(); ++n) {
            if (n > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((suyo)this._a.get(n)).toString());
        }
        stringBuilder.append(";");
        stringBuilder.append(this._c);
        if (!this._b.isEmpty()) {
            stringBuilder.append(";");
            n = 0;
            for (Map.Entry entry : this._b.entrySet()) {
                if (n++ > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(((String)entry.getKey()).toLowerCase());
                Map map = (Map)entry.getValue();
                if (map.isEmpty()) continue;
                stringBuilder.append("(");
                int n2 = 0;
                for (Map.Entry entry2 : map.entrySet()) {
                    if (n2++ > 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append((String)entry2.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String)entry2.getValue());
                }
                stringBuilder.append(")");
            }
        } else {
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

    public static suyo _a(String string, int n) {
        int n2;
        Object object;
        String[] stringArray = string.split("x", 2);
        int n3 = 1;
        int n4 = 0;
        if (stringArray.length == 2) {
            try {
                n3 = Integer.parseInt(stringArray[0]);
                if (n + n3 >= 256) {
                    n3 = 256 - n;
                }
                if (n3 < 0) {
                    n3 = 0;
                }
            }
            catch (Throwable throwable) {
                return null;
            }
        }
        try {
            object = stringArray[stringArray.length - 1];
            stringArray = ((String)object).split(":", 2);
            n2 = Integer.parseInt(stringArray[0]);
            if (stringArray.length > 1) {
                n4 = Integer.parseInt(stringArray[1]);
            }
            if (twgu.field_71973_m[n2] == null) {
                n2 = 0;
                n4 = 0;
            }
            if (n4 < 0 || n4 > 15) {
                n4 = 0;
            }
        }
        catch (Throwable throwable) {
            return null;
        }
        object = new suyo(n3, n2, n4);
        ((suyo)object)._a(n);
        return object;
    }

    public static List _a(String string) {
        if (string == null || string.length() < 1) {
            return null;
        }
        ArrayList<suyo> arrayList = new ArrayList<suyo>();
        String[] stringArray = string.split(",");
        int n = 0;
        for (String string2 : stringArray) {
            suyo suyo2 = elpk._a(string2, n);
            if (suyo2 == null) {
                return null;
            }
            arrayList.add(suyo2);
            n += suyo2._a();
        }
        return arrayList;
    }

    public static elpk _b(String string) {
        List list;
        int n;
        if (string == null) {
            return elpk._e();
        }
        String[] stringArray = string.split(";", -1);
        int n2 = n = stringArray.length == 1 ? 0 : sajh._a(stringArray[0], 0);
        if (n < 0 || n > 2) {
            return elpk._e();
        }
        elpk elpk2 = new elpk();
        int n3 = stringArray.length == 1 ? 0 : 1;
        if ((list = elpk._a(stringArray[n3++])) == null || list.isEmpty()) {
            return elpk._e();
        }
        elpk2._c().addAll(list);
        elpk2._d();
        int n4 = foqh._c._P;
        if (n > 0 && stringArray.length > n3) {
            n4 = sajh._a(stringArray[n3++], n4);
        }
        elpk2._a(n4);
        if (n > 0 && stringArray.length > n3) {
            String[] stringArray2;
            for (String string2 : stringArray2 = stringArray[n3++].toLowerCase().split(",")) {
                String[] stringArray3 = string2.split("\\(", 2);
                HashMap<String, String> hashMap = new HashMap<String, String>();
                if (stringArray3[0].length() <= 0) continue;
                elpk2._b().put(stringArray3[0], hashMap);
                if (stringArray3.length <= 1 || !stringArray3[1].endsWith(")") || stringArray3[1].length() <= 1) continue;
                String[] stringArray4 = stringArray3[1].substring(0, stringArray3[1].length() - 1).split(" ");
                for (int i = 0; i < stringArray4.length; ++i) {
                    String[] stringArray5 = stringArray4[i].split("=", 2);
                    if (stringArray5.length != 2) continue;
                    hashMap.put(stringArray5[0], stringArray5[1]);
                }
            }
        } else {
            elpk2._b().put("village", new HashMap());
        }
        return elpk2;
    }

    public static elpk _e() {
        elpk elpk2 = new elpk();
        elpk2._a(foqh._c._P);
        elpk2._c().add(new suyo(1, twgu.field_71986_z.field_71990_ca));
        elpk2._c().add(new suyo(2, twgu.field_71979_v.field_71990_ca));
        elpk2._c().add(new suyo(1, twgu.field_71980_u.field_71990_ca));
        elpk2._d();
        elpk2._b().put("village", new HashMap());
        return elpk2;
    }
}

