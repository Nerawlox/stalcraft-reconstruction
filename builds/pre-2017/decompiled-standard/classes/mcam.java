/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.TreeMap;

public class mcam {
    public TreeMap _a = new TreeMap();

    public mcam() {
        this._a("doFireTick", "true");
        this._a("mobGriefing", "true");
        this._a("keepInventory", "false");
        this._a("doMobSpawning", "true");
        this._a("doMobLoot", "true");
        this._a("doTileDrops", "true");
        this._a("commandBlockOutput", "true");
        this._a("naturalRegeneration", "true");
        this._a("doDaylightCycle", "true");
    }

    public void _a(String string, String string2) {
        this._a.put(string, new ixxg(string2));
    }

    public void _b(String string, String string2) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            ixxg2._a(string2);
        } else {
            this._a(string, string2);
        }
    }

    public String _a(String string) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            return ixxg2._a();
        }
        return "";
    }

    public boolean _b(String string) {
        ixxg ixxg2 = (ixxg)this._a.get(string);
        if (ixxg2 != null) {
            return ixxg2._b();
        }
        return false;
    }

    public qoac _a() {
        qoac qoac2 = new qoac("GameRules");
        for (String string : this._a.keySet()) {
            ixxg ixxg2 = (ixxg)this._a.get(string);
            qoac2._a(string, ixxg2._a());
        }
        return qoac2;
    }

    public void _a(qoac qoac2) {
        Collection collection = qoac2._d();
        for (huhy huhy2 : collection) {
            String string = huhy2._b();
            String string2 = qoac2._j(huhy2._b());
            this._b(string, string2);
        }
    }

    public String[] _b() {
        return this._a.keySet().toArray(new String[0]);
    }

    public boolean _c(String string) {
        return this._a.containsKey(string);
    }
}

