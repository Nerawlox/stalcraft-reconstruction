/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ezey {
    private Map<String, kjui> _a = new HashMap<String, kjui>();
    private Table<String, String, Double> _b = HashBasedTable.create();
    private int _c = 0;

    public void _a(String string2, String string3, double d) {
        kjui kjui2 = this._a.computeIfAbsent(string2, string -> new kjui((String)string));
        kjui kjui3 = this._a.computeIfAbsent(string3, string -> new kjui((String)string));
        kjui2._a(string3, d);
        kjui3._a(string2, d);
        this._c = 0;
    }

    public boolean _a() {
        if (this._c != 0) {
            return this._c == 1;
        }
        if (this._a.isEmpty()) {
            return true;
        }
        LinkedList<kjui> linkedList = new LinkedList<kjui>();
        HashSet<String> hashSet = new HashSet<String>();
        kjui kjui2 = this._a.values().iterator().next();
        linkedList.add(kjui2);
        hashSet.add(kjui2._b);
        while (!linkedList.isEmpty()) {
            kjui kjui3 = (kjui)linkedList.poll();
            for (String string : kjui3._c.keySet()) {
                if (hashSet.contains(string)) continue;
                hashSet.add(string);
                linkedList.add(this._a.get(string));
            }
        }
        boolean bl = hashSet.size() == this._a.size();
        this._c = bl ? 1 : 2;
        return bl;
    }

    public void _b() {
        for (kjui kjui2 : this._a.values()) {
            this._a(kjui2);
        }
    }

    private void _a(kjui kjui3) {
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        ArrayList<kjui> arrayList = new ArrayList<kjui>();
        for (kjui iterator2 : this._a.values()) {
            hashMap.put(iterator2._b, iterator2 == kjui3 ? 0.0 : Double.MAX_VALUE);
            arrayList.add(iterator2);
        }
        while (!arrayList.isEmpty()) {
            kjui kjui4 = arrayList.stream().min(Comparator.comparing(kjui2 -> (Double)hashMap.get(((kjui)kjui2)._b))).get();
            arrayList.remove(kjui4);
            for (String string : kjui4._c.keySet()) {
                double d = (Double)hashMap.get(kjui4._b) + (Double)kjui4._c.get(string);
                if (!(d < (Double)hashMap.get(string))) continue;
                hashMap.put(string, d);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this._b.put(kjui3._b, (String)entry.getKey(), (Double)entry.getValue());
        }
    }

    public void _c() {
        this._a.clear();
        this._b.clear();
    }

    public Set<String> _d() {
        return this._a.keySet();
    }

    public double _a(String string, String string2) {
        if (!this._b.contains(string, string2)) {
            this._a(this._a.get(string));
        }
        return this._b.get(string, string2);
    }

    public boolean _b(String string, String string2) {
        return this._b.contains(string, string2) && this._b.get(string, string2) != Double.MAX_VALUE;
    }

    private class kjui {
        private String _b;
        private Map<String, Double> _c = new HashMap<String, Double>();

        public kjui(String string) {
            this._b = string;
        }

        public void _a(String string, double d) {
            this._c.put(string, d);
        }
    }
}

