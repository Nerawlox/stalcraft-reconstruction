/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import argo.saj.InvalidSyntaxException;
import cpw.mods.fml.common.asm.ReobfuscationMarker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatsSyncher;
import net.minecraft.util.dwbf;
import net.minecraft.util.hanr;

@ReobfuscationMarker
@SideOnly(value=Side.CLIENT)
public class StatFileWriter {
    public Map _a = new HashMap();
    public Map _b = new HashMap();
    public boolean _c;
    public StatsSyncher _d;

    public StatFileWriter(hanr hanr2, File file) {
        File file2 = new File(file, "stats");
        if (!file2.exists()) {
            file2.mkdir();
        }
        for (File file3 : file.listFiles()) {
            File file4;
            if (!file3.getName().startsWith("stats_") || !file3.getName().endsWith(".dat") || (file4 = new File(file2, file3.getName())).exists()) continue;
            System.out.println("Relocating " + file3.getName());
            file3.renameTo(file4);
        }
        this._d = new StatsSyncher(hanr2, this, file2);
    }

    public void _a(StatBase statBase, int n) {
        this._a(this._b, statBase, n);
        this._a(this._a, statBase, n);
        this._c = true;
    }

    public void _a(Map map, StatBase statBase, int n) {
        Integer n2 = (Integer)map.get(statBase);
        int n3 = n2 == null ? 0 : n2;
        map.put(statBase, n3 + n);
    }

    public Map _a() {
        return new HashMap(this._b);
    }

    public void _a(Map map) {
        if (map != null) {
            this._c = true;
            for (StatBase statBase : map.keySet()) {
                this._a(this._b, statBase, (Integer)map.get(statBase));
                this._a(this._a, statBase, (Integer)map.get(statBase));
            }
        }
    }

    public void _b(Map map) {
        if (map != null) {
            for (StatBase statBase : map.keySet()) {
                Integer n = (Integer)this._b.get(statBase);
                int n2 = n == null ? 0 : n;
                this._a.put(statBase, (Integer)map.get(statBase) + n2);
            }
        }
    }

    public void _c(Map map) {
        if (map != null) {
            this._c = true;
            for (StatBase statBase : map.keySet()) {
                this._a(this._b, statBase, (Integer)map.get(statBase));
            }
        }
    }

    public static Map _a(String string) {
        HashMap<StatBase, Integer> hashMap = new HashMap<StatBase, Integer>();
        try {
            Object object;
            String string2 = "local";
            StringBuilder stringBuilder = new StringBuilder();
            JsonRootNode jsonRootNode = new JdomParser().parse(string);
            List<JsonNode> list2 = jsonRootNode.getArrayNode("stats-change");
            for (JsonNode object22 : list2) {
                object = object22.getFields();
                Map.Entry<JsonStringNode, JsonNode> entry = object.entrySet().iterator().next();
                int n = Integer.parseInt(entry.getKey().getText());
                int n2 = Integer.parseInt(entry.getValue().getText());
                boolean bl = true;
                StatBase statBase = dzif._a(n);
                if (statBase == null) {
                    bl = false;
                    statBase = new xbgu(n).registerStat();
                }
                stringBuilder.append(dzif._a((int)n).statGuid).append(",");
                stringBuilder.append(n2).append(",");
                if (!bl) continue;
                hashMap.put(statBase, n2);
            }
            dwbf dwbf2 = new dwbf(string2);
            object = dwbf2._a(stringBuilder.toString());
            if (!((String)object).equals(jsonRootNode.getStringValue("checksum"))) {
                System.out.println("CHECKSUM MISMATCH");
                return null;
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            invalidSyntaxException.printStackTrace();
        }
        return hashMap;
    }

    public static String _a(String string, String string2, Map map) {
        Object object2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean bl = true;
        stringBuilder.append("{\r\n");
        if (string != null && string2 != null) {
            stringBuilder.append("  \"user\":{\r\n");
            stringBuilder.append("    \"name\":\"").append(string).append("\",\r\n");
            stringBuilder.append("    \"sessionid\":\"").append(string2).append("\"\r\n");
            stringBuilder.append("  },\r\n");
        }
        stringBuilder.append("  \"stats-change\":[");
        for (Object object2 : map.keySet()) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append("},");
            }
            stringBuilder.append("\r\n    {\"").append(((StatBase)object2).statId).append("\":").append(map.get(object2));
            stringBuilder2.append(((StatBase)object2).statGuid).append(",");
            stringBuilder2.append(map.get(object2)).append(",");
        }
        if (!bl) {
            stringBuilder.append("}");
        }
        object2 = new dwbf(string2);
        stringBuilder.append("\r\n  ],\r\n");
        stringBuilder.append("  \"checksum\":\"").append(((dwbf)object2)._a(stringBuilder2.toString())).append("\"\r\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean _a(Achievement achievement) {
        return this._a.containsKey(achievement);
    }

    public boolean _b(Achievement achievement) {
        return achievement.parentAchievement == null || this._a(achievement.parentAchievement);
    }

    public int _a(StatBase statBase) {
        Integer n = (Integer)this._a.get(statBase);
        return n == null ? 0 : n;
    }

    public void _b() {
        this._d._b(this._a());
    }

    public void _c() {
        GloomyHooks.func_77449_e(this);
    }
}

