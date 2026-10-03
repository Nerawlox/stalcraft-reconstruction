/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 *  t
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class ae {
    private static final Pattern a = Pattern.compile("^@([parf])(?:\\[([\\w=,!-]*)\\])?$");
    private static final Pattern b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
    private static final Pattern c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");

    public static jv a(ad par0ICommandSender, String par1Str) {
        jv[] aentityplayermp = ae.c(par0ICommandSender, par1Str);
        return aentityplayermp != null && aentityplayermp.length == 1 ? aentityplayermp[0] : null;
    }

    public static String b(ad par0ICommandSender, String par1Str) {
        jv[] aentityplayermp = ae.c(par0ICommandSender, par1Str);
        if (aentityplayermp != null && aentityplayermp.length != 0) {
            Object[] astring = new String[aentityplayermp.length];
            for (int i = 0; i < astring.length; ++i) {
                astring[i] = aentityplayermp[i].ay();
            }
            return z.a(astring);
        }
        return null;
    }

    public static jv[] c(ad par0ICommandSender, String par1Str) {
        abw world;
        Matcher matcher = a.matcher(par1Str);
        if (!matcher.matches()) {
            return null;
        }
        Map map = ae.h(matcher.group(2));
        String s1 = matcher.group(1);
        int i = ae.c(s1);
        int j2 = ae.d(s1);
        int k = ae.f(s1);
        int l = ae.e(s1);
        int i1 = ae.g(s1);
        int j1 = ace.a.a();
        t chunkcoordinates = par0ICommandSender.b();
        Map map1 = ae.a(map);
        String s2 = null;
        String s3 = null;
        boolean flag = false;
        if (map.containsKey("rm")) {
            i = ls.a((String)map.get("rm"), i);
            flag = true;
        }
        if (map.containsKey("r")) {
            j2 = ls.a((String)map.get("r"), j2);
            flag = true;
        }
        if (map.containsKey("lm")) {
            k = ls.a((String)map.get("lm"), k);
        }
        if (map.containsKey("l")) {
            l = ls.a((String)map.get("l"), l);
        }
        if (map.containsKey("x")) {
            chunkcoordinates.a = ls.a((String)map.get("x"), chunkcoordinates.a);
            flag = true;
        }
        if (map.containsKey("y")) {
            chunkcoordinates.b = ls.a((String)map.get("y"), chunkcoordinates.b);
            flag = true;
        }
        if (map.containsKey("z")) {
            chunkcoordinates.c = ls.a((String)map.get("z"), chunkcoordinates.c);
            flag = true;
        }
        if (map.containsKey("m")) {
            j1 = ls.a((String)map.get("m"), j1);
        }
        if (map.containsKey("c")) {
            i1 = ls.a((String)map.get("c"), i1);
        }
        if (map.containsKey("team")) {
            s3 = (String)map.get("team");
        }
        if (map.containsKey("name")) {
            s2 = (String)map.get("name");
        }
        abw abw2 = world = flag ? par0ICommandSender.f_() : null;
        if (!s1.equals("p") && !s1.equals("a")) {
            if (!s1.equals("r")) {
                return null;
            }
            List list = MinecraftServer.F().af().a(chunkcoordinates, i, j2, 0, j1, k, l, map1, s2, s3, world);
            Collections.shuffle(list);
            list = list.subList(0, Math.min(i1, list.size()));
            return list != null && !list.isEmpty() ? list.toArray(new jv[0]) : new jv[]{};
        }
        List list = MinecraftServer.F().af().a(chunkcoordinates, i, j2, i1, j1, k, l, map1, s2, s3, world);
        return list != null && !list.isEmpty() ? list.toArray(new jv[0]) : new jv[]{};
    }

    public static Map a(Map par0Map) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (String s2 : par0Map.keySet()) {
            if (!s2.startsWith("score_") || s2.length() <= "score_".length()) continue;
            String s1 = s2.substring("score_".length());
            hashmap.put(s1, ls.a((String)par0Map.get(s2), 1));
        }
        return hashmap;
    }

    public static boolean a(String par0Str) {
        Matcher matcher = a.matcher(par0Str);
        if (matcher.matches()) {
            Map map = ae.h(matcher.group(2));
            String s1 = matcher.group(1);
            int i = ae.g(s1);
            if (map.containsKey("c")) {
                i = ls.a((String)map.get("c"), i);
            }
            return i != 1;
        }
        return false;
    }

    public static boolean a(String par0Str, String par1Str) {
        Matcher matcher = a.matcher(par0Str);
        if (matcher.matches()) {
            String s2 = matcher.group(1);
            return par1Str == null || par1Str.equals(s2);
        }
        return false;
    }

    public static boolean b(String par0Str) {
        return ae.a(par0Str, (String)null);
    }

    private static final int c(String par0Str) {
        return 0;
    }

    private static final int d(String par0Str) {
        return 0;
    }

    private static final int e(String par0Str) {
        return Integer.MAX_VALUE;
    }

    private static final int f(String par0Str) {
        return 0;
    }

    private static final int g(String par0Str) {
        return par0Str.equals("a") ? 0 : 1;
    }

    private static Map h(String par0Str) {
        HashMap<String, String> hashmap = new HashMap<String, String>();
        if (par0Str == null) {
            return hashmap;
        }
        Matcher matcher = b.matcher(par0Str);
        int i = 0;
        int j2 = -1;
        while (matcher.find()) {
            String s1 = null;
            switch (i++) {
                case 0: {
                    s1 = "x";
                    break;
                }
                case 1: {
                    s1 = "y";
                    break;
                }
                case 2: {
                    s1 = "z";
                    break;
                }
                case 3: {
                    s1 = "r";
                }
            }
            if (s1 != null && matcher.group(1).length() > 0) {
                hashmap.put(s1, matcher.group(1));
            }
            j2 = matcher.end();
        }
        if (j2 < par0Str.length()) {
            matcher = c.matcher(j2 == -1 ? par0Str : par0Str.substring(j2));
            while (matcher.find()) {
                hashmap.put(matcher.group(1), matcher.group(2));
            }
        }
        return hashmap;
    }
}

