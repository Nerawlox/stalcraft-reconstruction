/*
 * Decompiled with CFR 0.152.
 */
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
import net.minecraft.util.dwbf;
import net.minecraft.util.hanr;

@ReobfuscationMarker
@SideOnly(value=Side.CLIENT)
public class nwek {
    public Map _a = new HashMap();
    public Map _b = new HashMap();
    public boolean _c;
    public jjwi _d;

    public nwek(hanr hanr2, File file) {
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
        this._d = new jjwi(hanr2, this, file2);
    }

    public void _a(rann rann2, int n) {
        this._a(this._b, rann2, n);
        this._a(this._a, rann2, n);
        this._c = true;
    }

    public void _a(Map map, rann rann2, int n) {
        Integer n2 = (Integer)map.get(rann2);
        int n3 = n2 == null ? 0 : n2;
        map.put(rann2, n3 + n);
    }

    public Map _a() {
        return new HashMap(this._b);
    }

    public void _a(Map map) {
        if (map != null) {
            this._c = true;
            for (rann rann2 : map.keySet()) {
                this._a(this._b, rann2, (Integer)map.get(rann2));
                this._a(this._a, rann2, (Integer)map.get(rann2));
            }
        }
    }

    public void _b(Map map) {
        if (map != null) {
            for (rann rann2 : map.keySet()) {
                Integer n = (Integer)this._b.get(rann2);
                int n2 = n == null ? 0 : n;
                this._a.put(rann2, (Integer)map.get(rann2) + n2);
            }
        }
    }

    public void _c(Map map) {
        if (map != null) {
            this._c = true;
            for (rann rann2 : map.keySet()) {
                this._a(this._b, rann2, (Integer)map.get(rann2));
            }
        }
    }

    public static Map _a(String string) {
        HashMap<rann, Integer> hashMap = new HashMap<rann, Integer>();
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
                rann rann2 = dzif._a(n);
                if (rann2 == null) {
                    bl = false;
                    rann2 = new xbgu(n).func_75971_g();
                }
                stringBuilder.append(dzif._a((int)n).field_75973_g).append(",");
                stringBuilder.append(n2).append(",");
                if (!bl) continue;
                hashMap.put(rann2, n2);
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
            stringBuilder.append("\r\n    {\"").append(((rann)object2).field_75975_e).append("\":").append(map.get(object2));
            stringBuilder2.append(((rann)object2).field_75973_g).append(",");
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

    public boolean _a(nfcl nfcl2) {
        return this._a.containsKey(nfcl2);
    }

    public boolean _b(nfcl nfcl2) {
        return nfcl2.field_75992_c == null || this._a(nfcl2.field_75992_c);
    }

    public int _a(rann rann2) {
        Integer n = (Integer)this._a.get(rann2);
        return n == null ? 0 : n;
    }

    public void _b() {
        this._d._b(this._a());
    }

    public void _c() {
        GloomyHooks.func_77449_e(this);
    }
}

