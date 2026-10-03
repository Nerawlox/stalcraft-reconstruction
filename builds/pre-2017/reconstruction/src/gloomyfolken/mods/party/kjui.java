/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.party.pidb;
import gloomyfolken.mods.party.tupg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.vecmath.Vector2f;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

@ezey(_a={eidj.CLIENT})
public class kjui {
    public LinkedHashMap<String, kjui> _a = new LinkedHashMap();
    public Set<pidb> _b = new HashSet<pidb>();

    public void _a(List<String> list2, List<String> list3, List<String> list4) {
        LinkedHashMap<String, kjui> linkedHashMap = this._a;
        LinkedHashMap<String, kjui> linkedHashMap2 = new LinkedHashMap<String, kjui>(list2.size() + list4.size());
        int n = list2.size();
        for (int i = 0; i < n; ++i) {
            kjui object = new kjui(list2.get(i), list3.get(i), true);
            kjui kjui2 = linkedHashMap.get(object._a);
            if (kjui2 != null) {
                object._g = kjui2._g;
                object._d = kjui2._d;
            }
            linkedHashMap2.put(object._a, object);
        }
        for (String string : list4) {
            linkedHashMap2.put(string, new kjui(string, "", false));
        }
        this._a = linkedHashMap2;
        this._b();
        Logger.finest("Updated client party state: ", new Object[0]);
        for (kjui kjui3 : this._a.values()) {
            Logger.finest(kjui3._a + "@" + kjui3._b + ": " + kjui3._c, new Object[0]);
        }
    }

    private void _b() {
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen instanceof GuiPda && ((GuiPda)guiScreen).currentTab instanceof tupg) {
            ((tupg)((GuiPda)guiScreen).currentTab)._a(new ArrayList<kjui>(this._a.values()));
        }
    }

    public void _a() {
        this._a.clear();
        this._b.clear();
        Logger.finest("Cleared client party state", new Object[0]);
        this._b();
    }

    public boolean _a(String string) {
        ArrayList<kjui> arrayList = new ArrayList<kjui>(this._a.values());
        return arrayList.isEmpty() || ((kjui)arrayList.get((int)0))._a.equals(Minecraft._E()._t.username) && arrayList.size() < 5 && arrayList.stream().noneMatch(kjui2 -> kjui2._a.equals(string));
    }

    public void _a(List<qlqj> list2) {
        this._b = list2.stream().map(pidb::new).collect(Collectors.toSet());
    }

    public static class kjui {
        public String _a;
        public String _b;
        public boolean _c;
        public Vector2f _d = new Vector2f();
        public Vector2f _e = new Vector2f();
        public int _f = 0;
        public float _g = Float.NaN;

        public kjui(String string, String string2, boolean bl) {
            this._a = string;
            this._b = string2;
            this._c = bl;
        }

        public boolean _a() {
            return this._b == null || this._b.isEmpty();
        }

        public void _a(Vector2f vector2f) {
            this._e = this._d != null ? this._d : vector2f;
            this._d = vector2f;
            this._f = 10;
        }

        public void _b() {
            if (this._f > 0) {
                --this._f;
            }
        }
    }
}

