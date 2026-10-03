/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NEIActions {
    public static final int protocol = 0;
    public static HashMap<String, NEIActions> nameActionMap = new HashMap();
    public static HashSet<String> canDisable = new HashSet();
    public static final String[] timeZones = new String[]{"dawn", "noon", "dusk", "midnight"};
    public static final String[] gameModes = new String[]{"survival", "creative", "creative+", "adventure"};
    public String name;
    public String base;
    public boolean smpreq;

    public static void addAction(String string, String string2, boolean bl) {
        NEIActions nEIActions = new NEIActions(string, string2, bl);
        nameActionMap.put(string, nEIActions);
    }

    private static void addAction(String string, String string2) {
        NEIActions.addAction(string, string2, false);
    }

    public static void addAction(String string) {
        NEIActions.addAction(string, string);
    }

    private static void addAction(String string, boolean bl) {
        NEIActions.addAction(string, string, bl);
    }

    public static String base(String string) {
        NEIActions nEIActions = nameActionMap.get(string);
        return nEIActions == null ? string : nEIActions.base;
    }

    public static boolean smpRequired(String string) {
        return NEIActions.nameActionMap.get((Object)string).smpreq;
    }

    public static void init() {
        NEIActions.addAction("time");
        NEIActions.addAction("dawn", "time");
        NEIActions.addAction("noon", "time");
        NEIActions.addAction("dusk", "time");
        NEIActions.addAction("midnight", "time");
        NEIActions.addAction("creative");
        NEIActions.addAction("creative+", true);
        NEIActions.addAction("adventure", "creative");
        NEIActions.addAction("rain");
        NEIActions.addAction("item");
        NEIActions.addAction("heal");
        NEIActions.addAction("delete", true);
        NEIActions.addAction("magnet", true);
        NEIActions.addAction("enchant", true);
        NEIActions.addAction("potion", true);
        NEIActions.addAction("itemnbt", "item", true);
        canDisable.add("dawn");
        canDisable.add("noon");
        canDisable.add("dusk");
        canDisable.add("midnight");
        canDisable.add("rain");
    }

    public NEIActions(String string, String string2, boolean bl) {
        this.name = string;
        this.base = string2;
        this.smpreq = bl;
    }

    public static List<String> baseActions() {
        LinkedList<String> linkedList = new LinkedList<String>();
        for (NEIActions nEIActions : nameActionMap.values()) {
            if (!nEIActions.base.equals(nEIActions.name)) continue;
            linkedList.add(nEIActions.name);
        }
        return linkedList;
    }
}

