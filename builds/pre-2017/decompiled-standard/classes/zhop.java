/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public class zhop {
    public static final Pattern _a = Pattern.compile("^@([parf])(?:\\[([\\w=,!-]*)\\])?$");
    public static final Pattern _b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
    public static final Pattern _c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");

    public static EntityPlayerMP _a(nemo nemo2, String string) {
        EntityPlayerMP[] entityPlayerMPArray = zhop._c(nemo2, string);
        if (entityPlayerMPArray == null || entityPlayerMPArray.length != 1) {
            return null;
        }
        return entityPlayerMPArray[0];
    }

    public static String _b(nemo nemo2, String string) {
        EntityPlayerMP[] entityPlayerMPArray = zhop._c(nemo2, string);
        if (entityPlayerMPArray == null || entityPlayerMPArray.length == 0) {
            return null;
        }
        Object[] objectArray = new String[entityPlayerMPArray.length];
        for (int i = 0; i < objectArray.length; ++i) {
            objectArray[i] = entityPlayerMPArray[i].func_96090_ax();
        }
        return ohnk.func_71527_a(objectArray);
    }

    public static EntityPlayerMP[] _c(nemo nemo2, String string) {
        Matcher matcher = _a.matcher(string);
        if (matcher.matches()) {
            ozlu ozlu2;
            Map map = zhop._h(matcher.group(2));
            String string2 = matcher.group(1);
            int n = zhop._c(string2);
            int n2 = zhop._d(string2);
            int n3 = zhop._f(string2);
            int n4 = zhop._e(string2);
            int n5 = zhop._g(string2);
            int n6 = xtby._a._a();
            zwaw zwaw2 = nemo2.func_82114_b();
            Map map2 = zhop._a(map);
            String string3 = null;
            String string4 = null;
            boolean bl = false;
            if (map.containsKey("rm")) {
                n = sajh._a((String)map.get("rm"), n);
                bl = true;
            }
            if (map.containsKey("r")) {
                n2 = sajh._a((String)map.get("r"), n2);
                bl = true;
            }
            if (map.containsKey("lm")) {
                n3 = sajh._a((String)map.get("lm"), n3);
            }
            if (map.containsKey("l")) {
                n4 = sajh._a((String)map.get("l"), n4);
            }
            if (map.containsKey("x")) {
                zwaw2._a = sajh._a((String)map.get("x"), zwaw2._a);
                bl = true;
            }
            if (map.containsKey("y")) {
                zwaw2._b = sajh._a((String)map.get("y"), zwaw2._b);
                bl = true;
            }
            if (map.containsKey("z")) {
                zwaw2._c = sajh._a((String)map.get("z"), zwaw2._c);
                bl = true;
            }
            if (map.containsKey("m")) {
                n6 = sajh._a((String)map.get("m"), n6);
            }
            if (map.containsKey("c")) {
                n5 = sajh._a((String)map.get("c"), n5);
            }
            if (map.containsKey("team")) {
                string4 = (String)map.get("team");
            }
            if (map.containsKey("name")) {
                string3 = (String)map.get("name");
            }
            ozlu ozlu3 = ozlu2 = bl ? nemo2.func_130014_f_() : null;
            if (string2.equals("p") || string2.equals("a")) {
                List list2 = dzfd._I().__ag()._a(zwaw2, n, n2, n5, n6, n3, n4, map2, string3, string4, ozlu2);
                return list2 == null || list2.isEmpty() ? new EntityPlayerMP[]{} : list2.toArray(new EntityPlayerMP[0]);
            }
            if (string2.equals("r")) {
                List list3 = dzfd._I().__ag()._a(zwaw2, n, n2, 0, n6, n3, n4, map2, string3, string4, ozlu2);
                Collections.shuffle(list3);
                list3 = list3.subList(0, Math.min(n5, list3.size()));
                return list3 == null || list3.isEmpty() ? new EntityPlayerMP[]{} : list3.toArray(new EntityPlayerMP[0]);
            }
            return null;
        }
        return null;
    }

    public static Map _a(Map map) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String string : map.keySet()) {
            if (!string.startsWith("score_") || string.length() <= "score_".length()) continue;
            String string2 = string.substring("score_".length());
            hashMap.put(string2, sajh._a((String)map.get(string), 1));
        }
        return hashMap;
    }

    public static boolean _a(String string) {
        Matcher matcher = _a.matcher(string);
        if (matcher.matches()) {
            Map map = zhop._h(matcher.group(2));
            String string2 = matcher.group(1);
            int n = zhop._g(string2);
            if (map.containsKey("c")) {
                n = sajh._a((String)map.get("c"), n);
            }
            return n != 1;
        }
        return false;
    }

    public static boolean _a(String string, String string2) {
        Matcher matcher = _a.matcher(string);
        if (matcher.matches()) {
            String string3 = matcher.group(1);
            return string2 == null || string2.equals(string3);
        }
        return false;
    }

    public static boolean _b(String string) {
        return zhop._a(string, null);
    }

    public static final int _c(String string) {
        return 0;
    }

    public static final int _d(String string) {
        return 0;
    }

    public static final int _e(String string) {
        return Integer.MAX_VALUE;
    }

    public static final int _f(String string) {
        return 0;
    }

    public static final int _g(String string) {
        if (string.equals("a")) {
            return 0;
        }
        return 1;
    }

    public static Map _h(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (string == null) {
            return hashMap;
        }
        Matcher matcher = _b.matcher(string);
        int n = 0;
        int n2 = -1;
        while (matcher.find()) {
            String string2 = null;
            switch (n++) {
                case 0: {
                    string2 = "x";
                    break;
                }
                case 1: {
                    string2 = "y";
                    break;
                }
                case 2: {
                    string2 = "z";
                    break;
                }
                case 3: {
                    string2 = "r";
                }
            }
            if (string2 != null && matcher.group(1).length() > 0) {
                hashMap.put(string2, matcher.group(1));
            }
            n2 = matcher.end();
        }
        if (n2 < string.length()) {
            matcher = _c.matcher(n2 == -1 ? string : string.substring(n2));
            while (matcher.find()) {
                hashMap.put(matcher.group(1), matcher.group(2));
            }
        }
        return hashMap;
    }
}

