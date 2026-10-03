/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import ru.stalcraft.StalkerMain;

public class Config {
    public static int carouselDamage;
    public static int electraDamage;
    public static int kisselDamage;
    public static int coachDamage;
    public static int steamDamage;
    public static int trampolineDamage;
    public static int webDamage;
    public static int ejectionDamage;
    public static String blackHoleDrop;
    public static String carouselDrop;
    public static String coachDrop;
    public static String electraDrop;
    public static String kisselDrop;
    public static String lighterDrop;
    public static String steamDrop;
    public static String trampolineDrop;
    public static int turrel1Damage;
    public static int turrel1Cooldown;
    public static int turrel1Health;
    public static int turrel2Damage;
    public static int turrel2Cooldown;
    public static int turrel2Health;
    public static int turrel3Damage;
    public static int turrel3Cooldown;
    public static int turrel3Health;
    public static String proxyDir;
    public static boolean isServer;

    public static void readConfigProxy() {
        try {
            BufferedReader e2 = new BufferedReader(new InputStreamReader(StalkerMain.class.getResourceAsStream("/assets/stalker/proxy.txt"), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            Object parSplitter = null;
            while (!flag) {
                proxyDir = e2.readLine();
                flag = true;
            }
            e2.close();
        }
        catch (Exception var14) {
            var14.printStackTrace();
        }
    }

    public static void readConfig() {
        try {
            String parSplitter;
            BufferedReader e2 = new BufferedReader(new InputStreamReader(StalkerMain.class.getResourceAsStream("/assets/stalker/config.txt"), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            while (!flag) {
                parSplitter = e2.readLine();
                if (parSplitter == null) {
                    flag = true;
                    continue;
                }
                if ((parSplitter = parSplitter.trim()).startsWith("//")) continue;
                buffer.append(parSplitter.split("//", 2)[0]);
            }
            parSplitter = "[\\s]*;[\\s]*";
            String config = buffer.toString().replaceAll("\n|\r", "");
            try {
                String str;
                int i$;
                int len$;
                String[] arr$;
                String[] splittedHStr;
                String[] e1 = config.split(parSplitter);
                carouselDamage = Config.getInt(e1, "carousel_damage");
                electraDamage = Config.getInt(e1, "electra_damage");
                kisselDamage = Config.getInt(e1, "kissel_damage");
                coachDamage = Config.getInt(e1, "coach_damage");
                steamDamage = Config.getInt(e1, "steam_damage");
                trampolineDamage = Config.getInt(e1, "trampoline_damage");
                webDamage = Config.getInt(e1, "web_damage");
                ejectionDamage = Config.getInt(e1, "ejection_damage");
                blackHoleDrop = Config.getString(e1, "blackhole_drop");
                carouselDrop = Config.getString(e1, "carousel_drop");
                coachDrop = Config.getString(e1, "coach_drop");
                electraDrop = Config.getString(e1, "electra_drop");
                kisselDrop = Config.getString(e1, "kissel_drop");
                lighterDrop = Config.getString(e1, "lighter_drop");
                steamDrop = Config.getString(e1, "steam_drop");
                trampolineDrop = Config.getString(e1, "trampoline_drop");
                turrel1Damage = Config.getInt(e1, "turrel1_damage");
                turrel1Cooldown = Config.getInt(e1, "turrel1_cooldown");
                turrel1Health = Config.getInt(e1, "turrel1_health");
                turrel2Damage = Config.getInt(e1, "turrel2_damage");
                turrel2Cooldown = Config.getInt(e1, "turrel2_cooldown");
                turrel2Health = Config.getInt(e1, "turrel2_health");
                turrel3Damage = Config.getInt(e1, "turrel3_damage");
                turrel3Cooldown = Config.getInt(e1, "turrel3_cooldown");
                turrel3Health = Config.getInt(e1, "turrel3_health");
                String ejectionSaversStr = Config.getString(e1, "ejection_savers");
                String destroyable = Config.getString(e1, "destroyable_blocks");
                if (!destroyable.isEmpty()) {
                    arr$ = splittedHStr = destroyable.split(",");
                    len$ = splittedHStr.length;
                    for (i$ = 0; i$ < len$; ++i$) {
                        str = arr$[i$];
                        StalkerMain.destroyableBlocks.add(Integer.parseInt(str));
                    }
                }
                if (!ejectionSaversStr.isEmpty()) {
                    arr$ = splittedHStr = ejectionSaversStr.split(",");
                    len$ = splittedHStr.length;
                    for (i$ = 0; i$ < len$; ++i$) {
                        str = arr$[i$];
                    }
                }
                e2.close();
            }
            catch (Exception var13) {
                var13.printStackTrace();
            }
        }
        catch (Exception var14) {
            var14.printStackTrace();
        }
    }

    private static int getInt(String[] parameters, String name) {
        String str = Config.getParStr(parameters, name);
        return str == null ? 0 : Integer.parseInt(str.split(":")[1].trim());
    }

    private static String getString(String[] parameters, String name) {
        String str = Config.getParStr(parameters, name);
        if (str == null) {
            return "";
        }
        String value = str.split(":", 2)[1].trim();
        return value.equals("\"\"") ? "" : value.split("\"")[1];
    }

    private static String getParStr(String[] parameters, String name) {
        String toFound = name + ":";
        String[] arr$ = parameters;
        int len$ = parameters.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            String str = arr$[i$];
            if (!str.startsWith(toFound)) continue;
            return str;
        }
        return null;
    }
}

