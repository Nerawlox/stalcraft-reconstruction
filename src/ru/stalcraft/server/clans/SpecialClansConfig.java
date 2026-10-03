/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server.clans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.server.clans.SpecialClanFields;

public class SpecialClansConfig {
    public HashMap specialClans = new HashMap();

    public void readConfig() {
        try {
            String[] splitted;
            String itemsSplitter;
            BufferedReader e2 = new BufferedReader(new InputStreamReader(StalkerMain.class.getResourceAsStream("/assets/stalker/special_clans.txt"), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            while (!flag) {
                itemsSplitter = e2.readLine();
                if (itemsSplitter == null) {
                    flag = true;
                    continue;
                }
                if ((itemsSplitter = itemsSplitter.trim()).startsWith("//")) continue;
                buffer.append(itemsSplitter.split("//", 2)[0]);
            }
            itemsSplitter = "\\{";
            String parSplitter = "[\\s]*;[\\s]*";
            String config = buffer.toString().replaceAll("\n|\r", "");
            String[] arr$ = splitted = config.split("\\}");
            int len$ = splitted.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String str = arr$[i$];
                try {
                    String[] e1 = str.split(itemsSplitter)[1].split(parSplitter);
                    String name = SpecialClansConfig.getString(e1, "name");
                    int minX = SpecialClansConfig.getInt(e1, "minX");
                    int minZ = SpecialClansConfig.getInt(e1, "minZ");
                    int maxX = SpecialClansConfig.getInt(e1, "maxX");
                    int maxZ = SpecialClansConfig.getInt(e1, "maxZ");
                    int maxRepTimer = SpecialClansConfig.getInt(e1, "max_reputation_timer");
                    int baseSalary = SpecialClansConfig.getInt(e1, "base_salary");
                    int salaryReputationFactor = SpecialClansConfig.getInt(e1, "salary_reputation_factor");
                    this.specialClans.put(name, new SpecialClanFields(name, minX, minZ, maxX, maxZ, maxRepTimer, baseSalary, salaryReputationFactor));
                    continue;
                }
                catch (Exception var21) {
                    var21.printStackTrace();
                }
            }
        }
        catch (Exception var22) {
            var22.printStackTrace();
        }
    }

    private static int getInt(String[] parameters, String name) {
        String str = SpecialClansConfig.getParStr(parameters, name);
        return str == null ? 0 : Integer.parseInt(str.split(":")[1].trim());
    }

    private static String getString(String[] parameters, String name) {
        String str = SpecialClansConfig.getParStr(parameters, name);
        if (str == null) {
            return "";
        }
        String value = str.split(":", 2)[1].trim();
        return value.equals("\"\"") ? "" : value.split("\"")[1];
    }

    private static String getParStr(String[] parameters, String name) {
        for (int i$ = 0; i$ < parameters.length; ++i$) {
            if (!parameters[i$].startsWith(name + ":")) continue;
            return parameters[i$];
        }
        return null;
    }
}

