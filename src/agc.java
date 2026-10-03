/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agd
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class agc {
    private final List a = new ArrayList();
    private final Map b = new HashMap();
    private int c;

    public int a() {
        return this.c;
    }

    public void a(int par1) {
        this.c = par1;
    }

    public Map b() {
        return this.b;
    }

    public List c() {
        return this.a;
    }

    public void d() {
        int i = 0;
        for (agd flatlayerinfo : this.a) {
            flatlayerinfo.d(i);
            i += flatlayerinfo.a();
        }
    }

    public String toString() {
        int i;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(2);
        stringbuilder.append(";");
        for (i = 0; i < this.a.size(); ++i) {
            if (i > 0) {
                stringbuilder.append(",");
            }
            stringbuilder.append(((agd)this.a.get(i)).toString());
        }
        stringbuilder.append(";");
        stringbuilder.append(this.c);
        if (!this.b.isEmpty()) {
            stringbuilder.append(";");
            i = 0;
            for (Map.Entry entry : this.b.entrySet()) {
                if (i++ > 0) {
                    stringbuilder.append(",");
                }
                stringbuilder.append(((String)entry.getKey()).toLowerCase());
                Map map = (Map)entry.getValue();
                if (map.isEmpty()) continue;
                stringbuilder.append("(");
                int j2 = 0;
                for (Map.Entry entry1 : map.entrySet()) {
                    if (j2++ > 0) {
                        stringbuilder.append(" ");
                    }
                    stringbuilder.append((String)entry1.getKey());
                    stringbuilder.append("=");
                    stringbuilder.append((String)entry1.getValue());
                }
                stringbuilder.append(")");
            }
        } else {
            stringbuilder.append(";");
        }
        return stringbuilder.toString();
    }

    private static agd a(String par0Str, int par1) {
        int l;
        String[] astring = par0Str.split("x", 2);
        int j2 = 1;
        int k = 0;
        if (astring.length == 2) {
            try {
                j2 = Integer.parseInt(astring[0]);
                if (par1 + j2 >= 256) {
                    j2 = 256 - par1;
                }
                if (j2 < 0) {
                    j2 = 0;
                }
            }
            catch (Throwable throwable) {
                return null;
            }
        }
        try {
            String s1 = astring[astring.length - 1];
            astring = s1.split(":", 2);
            l = Integer.parseInt(astring[0]);
            if (astring.length > 1) {
                k = Integer.parseInt(astring[1]);
            }
            if (aqz.s[l] == null) {
                l = 0;
                k = 0;
            }
            if (k < 0 || k > 15) {
                k = 0;
            }
        }
        catch (Throwable throwable1) {
            return null;
        }
        agd flatlayerinfo = new agd(j2, l, k);
        flatlayerinfo.d(par1);
        return flatlayerinfo;
    }

    private static List b(String par0Str) {
        if (par0Str != null && par0Str.length() >= 1) {
            ArrayList<agd> arraylist = new ArrayList<agd>();
            String[] astring = par0Str.split(",");
            int i = 0;
            String[] astring1 = astring;
            int j2 = astring.length;
            for (int k = 0; k < j2; ++k) {
                String s1 = astring1[k];
                agd flatlayerinfo = agc.a(s1, i);
                if (flatlayerinfo == null) {
                    return null;
                }
                arraylist.add(flatlayerinfo);
                i += flatlayerinfo.a();
            }
            return arraylist;
        }
        return null;
    }

    public static agc a(String par0Str) {
        int i;
        if (par0Str == null) {
            return agc.e();
        }
        String[] astring = par0Str.split(";", -1);
        int n = i = astring.length == 1 ? 0 : ls.a(astring[0], 0);
        if (i >= 0 && i <= 2) {
            List list;
            agc flatgeneratorinfo = new agc();
            int j2 = astring.length == 1 ? 0 : 1;
            if ((list = agc.b(astring[j2++])) != null && !list.isEmpty()) {
                flatgeneratorinfo.c().addAll(list);
                flatgeneratorinfo.d();
                int k = acq.c.N;
                if (i > 0 && astring.length > j2) {
                    k = ls.a(astring[j2++], k);
                }
                flatgeneratorinfo.a(k);
                if (i > 0 && astring.length > j2) {
                    String[] astring1;
                    String[] astring2 = astring1 = astring[j2++].toLowerCase().split(",");
                    int l = astring1.length;
                    for (int i1 = 0; i1 < l; ++i1) {
                        String s1 = astring2[i1];
                        String[] astring3 = s1.split("\\(", 2);
                        HashMap<String, String> hashmap = new HashMap<String, String>();
                        if (astring3[0].length() <= 0) continue;
                        flatgeneratorinfo.b().put(astring3[0], hashmap);
                        if (astring3.length <= 1 || !astring3[1].endsWith(")") || astring3[1].length() <= 1) continue;
                        String[] astring4 = astring3[1].substring(0, astring3[1].length() - 1).split(" ");
                        for (int j1 = 0; j1 < astring4.length; ++j1) {
                            String[] astring5 = astring4[j1].split("=", 2);
                            if (astring5.length != 2) continue;
                            hashmap.put(astring5[0], astring5[1]);
                        }
                    }
                } else {
                    flatgeneratorinfo.b().put("village", new HashMap());
                }
                return flatgeneratorinfo;
            }
            return agc.e();
        }
        return agc.e();
    }

    public static agc e() {
        agc flatgeneratorinfo = new agc();
        flatgeneratorinfo.a(acq.c.N);
        flatgeneratorinfo.c().add(new agd(1, aqz.E.cF));
        flatgeneratorinfo.c().add(new agd(2, aqz.A.cF));
        flatgeneratorinfo.c().add(new agd(1, aqz.z.cF));
        flatgeneratorinfo.d();
        flatgeneratorinfo.b().put("village", new HashMap());
        return flatgeneratorinfo;
    }
}

