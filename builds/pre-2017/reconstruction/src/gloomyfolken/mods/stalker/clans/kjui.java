/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.mods.stalker.clans.pidb;
import gloomyfolken.mods.stalker.clans.zwaw;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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

    public kjui(NBTTagCompound nBTTagCompound) {
        this._b(nBTTagCompound);
    }

    public NBTTagCompound _a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("time", this._a.toEpochMilli());
        nBTTagCompound._a("battleId", this._b);
        nBTTagCompound._a("winner", this._c);
        NBTTagList nBTTagList = new NBTTagList();
        for (zwaw object : this._d) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("username", object._a());
            nBTTagCompound2._a("clan", object._b());
            nBTTagCompound2._a("stat", (short)object._c().ordinal());
            nBTTagCompound2._a("value", object._d());
            if (object._e() != null) {
                nBTTagCompound2._a("armor", object._e());
            }
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("featured_players", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (kjui kjui2 : this._e) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a("clanname", kjui2._a);
            nBTTagCompound3._a("tickets", kjui2._b);
            NBTTagList nBTTagList3 = new NBTTagList();
            for (pidb pidb2 : kjui2._c) {
                NBTTagCompound nBTTagCompound4 = new NBTTagCompound();
                nBTTagCompound4._a("username", pidb2._a());
                nBTTagCompound4._a("k", pidb2._b());
                nBTTagCompound4._a("d", pidb2._d());
                nBTTagCompound4._a("a", pidb2._c());
                nBTTagCompound4._a("s", pidb2._e());
                nBTTagList3._a(nBTTagCompound4);
            }
            nBTTagCompound3._a("stats", nBTTagList3);
            nBTTagList2._a(nBTTagCompound3);
        }
        nBTTagCompound._a("participants", nBTTagList2);
        return nBTTagCompound;
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        Object object;
        String string;
        Object object2;
        this._a = Instant.ofEpochMilli(nBTTagCompound._g("time"));
        this._b = nBTTagCompound._j("battleId");
        this._c = nBTTagCompound._j("winner");
        NBTTagList nBTTagList = nBTTagCompound._n("featured_players");
        this._d.clear();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            object2 = nBTTagCompound2._j("username");
            string = nBTTagCompound2._j("clan");
            pidb.zwat zwat2 = pidb.zwat.values()[nBTTagCompound2._e("stat")];
            double d = nBTTagCompound2._i("value");
            object = null;
            if (nBTTagCompound2._c("armor")) {
                object = nBTTagCompound2._m("armor");
            }
            this._d.add(new zwaw((String)object2, string, zwat2, d, (NBTTagCompound)object));
        }
        NBTTagList nBTTagList2 = nBTTagCompound._n("participants");
        this._e.clear();
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            object2 = (NBTTagCompound)nBTTagList2._b(i);
            string = ((NBTTagCompound)object2)._j("clanname");
            double d = ((NBTTagCompound)object2)._i("tickets");
            NBTTagList nBTTagList3 = ((NBTTagCompound)object2)._n("stats");
            object = new ArrayList();
            for (int j = 0; j < nBTTagList3._d(); ++j) {
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagList3._b(j);
                String string2 = nBTTagCompound3._j("username");
                int n = nBTTagCompound3._f("k");
                int n2 = nBTTagCompound3._f("d");
                int n3 = nBTTagCompound3._f("a");
                int n4 = nBTTagCompound3._f("s");
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

