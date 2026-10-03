/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.mods.stalker.clans.pidb;
import gloomyfolken.mods.stalker.clans.zwaw;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class kjui {
    public Instant _a;
    public String _b;
    public String _c;
    public List<zwaw> _d = new ArrayList<zwaw>();
    public List<kjui> _e = new ArrayList<kjui>();

    public kjui(Instant instant, String string, String string2, List<zwaw> list2, List<kjui> list3) {
        this._a = instant;
        this._b = string;
        this._c = string2;
        this._d = list2;
        this._e = list3;
    }

    public kjui(qoac qoac2) {
        this._b(qoac2);
    }

    public qoac _a(qoac qoac2) {
        qoac2._a("time", this._a.toEpochMilli());
        qoac2._a("battleId", this._b);
        qoac2._a("winner", this._c);
        bsyv bsyv2 = new bsyv();
        for (zwaw object : this._d) {
            qoac qoac3 = new qoac();
            qoac3._a("username", object._a());
            qoac3._a("clan", object._b());
            qoac3._a("stat", (short)object._c().ordinal());
            qoac3._a("value", object._d());
            if (object._e() != null) {
                qoac3._a("armor", object._e());
            }
            bsyv2._a(qoac3);
        }
        qoac2._a("featured_players", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (kjui kjui2 : this._e) {
            qoac qoac4 = new qoac();
            qoac4._a("clanname", kjui2._a);
            qoac4._a("tickets", kjui2._b);
            bsyv bsyv4 = new bsyv();
            for (pidb pidb2 : kjui2._c) {
                qoac qoac5 = new qoac();
                qoac5._a("username", pidb2._a());
                qoac5._a("k", pidb2._b());
                qoac5._a("d", pidb2._d());
                qoac5._a("a", pidb2._c());
                qoac5._a("s", pidb2._e());
                bsyv4._a(qoac5);
            }
            qoac4._a("stats", bsyv4);
            bsyv3._a(qoac4);
        }
        qoac2._a("participants", bsyv3);
        return qoac2;
    }

    public void _b(qoac qoac2) {
        Object object;
        String string;
        Object object2;
        this._a = Instant.ofEpochMilli(qoac2._g("time"));
        this._b = qoac2._j("battleId");
        this._c = qoac2._j("winner");
        bsyv bsyv2 = qoac2._n("featured_players");
        this._d.clear();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            object2 = qoac3._j("username");
            string = qoac3._j("clan");
            pidb.zwat zwat2 = pidb.zwat.values()[qoac3._e("stat")];
            double d = qoac3._i("value");
            object = null;
            if (qoac3._c("armor")) {
                object = qoac3._m("armor");
            }
            this._d.add(new zwaw((String)object2, string, zwat2, d, (qoac)object));
        }
        bsyv bsyv3 = qoac2._n("participants");
        this._e.clear();
        for (int i = 0; i < bsyv3._d(); ++i) {
            object2 = (qoac)bsyv3._b(i);
            string = ((qoac)object2)._j("clanname");
            double d = ((qoac)object2)._i("tickets");
            bsyv bsyv4 = ((qoac)object2)._n("stats");
            object = new ArrayList();
            for (int j = 0; j < bsyv4._d(); ++j) {
                qoac qoac4 = (qoac)bsyv4._b(j);
                String string2 = qoac4._j("username");
                int n = qoac4._f("k");
                int n2 = qoac4._f("d");
                int n3 = qoac4._f("a");
                int n4 = qoac4._f("s");
                object.add(new pidb(string2, n, n2, n3, n4));
            }
            this._e.add(new kjui(string, d, (List<pidb>)object));
        }
    }

    public static class pidb {
        private String _a;
        private int _b;
        private int _c;
        private int _d;
        private int _e;

        public pidb(String string, int n, int n2, int n3, int n4) {
            this._a = string;
            this._b = n;
            this._c = n2;
            this._d = n3;
            this._e = n4;
        }

        public String _a() {
            return this._a;
        }

        public int _b() {
            return this._b;
        }

        public int _c() {
            return this._c;
        }

        public int _d() {
            return this._d;
        }

        public int _e() {
            return this._e;
        }
    }

    public static class kjui {
        public String _a;
        public double _b;
        public List<pidb> _c = new ArrayList<pidb>();

        public kjui(String string, double d, List<pidb> list2) {
            this._a = string;
            this._b = d;
            this._c = list2;
        }
    }
}

