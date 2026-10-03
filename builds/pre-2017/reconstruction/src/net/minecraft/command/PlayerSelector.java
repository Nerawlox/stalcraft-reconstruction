/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

public class PlayerSelector {
    public static final Pattern _a = Pattern.compile("^@([parf])(?:\\[([\\w=,!-]*)\\])?$");
    public static final Pattern _b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
    public static final Pattern _c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");

    public static EntityPlayerMP _a(ICommandSender iCommandSender, String string) {
        EntityPlayerMP[] entityPlayerMPArray = PlayerSelector._c(iCommandSender, string);
        if (entityPlayerMPArray == null || entityPlayerMPArray.length != 1) {
            return null;
        }
        return entityPlayerMPArray[0];
    }

    public static String _b(ICommandSender iCommandSender, String string) {
        EntityPlayerMP[] entityPlayerMPArray = PlayerSelector._c(iCommandSender, string);
        if (entityPlayerMPArray == null || entityPlayerMPArray.length == 0) {
            return null;
        }
        Object[] objectArray = new String[entityPlayerMPArray.length];
        for (int i = 0; i < objectArray.length; ++i) {
            objectArray[i] = entityPlayerMPArray[i].getTranslatedEntityName();
        }
        return CommandBase.joinNiceString(objectArray);
    }

    public static EntityPlayerMP[] _c(ICommandSender iCommandSender, String string) {
        Matcher matcher = _a.matcher(string);
        if (matcher.matches()) {
            World world;
            Map map = PlayerSelector._h(matcher.group(2));
            String string2 = matcher.group(1);
            int n = PlayerSelector._c(string2);
            int n2 = PlayerSelector._d(string2);
            int n3 = PlayerSelector._f(string2);
            int n4 = PlayerSelector._e(string2);
            int n5 = PlayerSelector._g(string2);
            int n6 = EnumGameType._a._a();
            ChunkCoordinates chunkCoordinates = iCommandSender.func_82114_b();
            Map map2 = PlayerSelector._a(map);
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
                chunkCoordinates._a = sajh._a((String)map.get("x"), chunkCoordinates._a);
                bl = true;
            }
            if (map.containsKey("y")) {
                chunkCoordinates._b = sajh._a((String)map.get("y"), chunkCoordinates._b);
                bl = true;
            }
            if (map.containsKey("z")) {
                chunkCoordinates._c = sajh._a((String)map.get("z"), chunkCoordinates._c);
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
            World world2 = world = bl ? iCommandSender.getEntityWorld() : null;
            if (string2.equals("p") || string2.equals("a")) {
                List list2 = MinecraftServer._I().__ag()._a(chunkCoordinates, n, n2, n5, n6, n3, n4, map2, string3, string4, world);
                return list2 == null || list2.isEmpty() ? new EntityPlayerMP[]{} : list2.toArray(new EntityPlayerMP[0]);
            }
            if (string2.equals("r")) {
                List list3 = MinecraftServer._I().__ag()._a(chunkCoordinates, n, n2, 0, n6, n3, n4, map2, string3, string4, world);
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
            Map map = PlayerSelector._h(matcher.group(2));
            String string2 = matcher.group(1);
            int n = PlayerSelector._g(string2);
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
        return PlayerSelector._a(string, null);
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

