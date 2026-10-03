/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.asm.PathModifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class gpaw
extends ccsw {
    public HashMap<Integer, rpaa> _a = new HashMap();
    private HashMap<String, mqrl> _b = new HashMap();
    private int _c;
    private boolean _d;
    private Map<String, Class> _e;

    public gpaw(Map<String, Class> map) {
        this._e = map;
    }

    public void _b() {
        this._c();
    }

    public void _e() {
        this._d = true;
        this._a.clear();
        try {
            this._c();
        }
        finally {
            this._d = false;
        }
    }

    public void _a(mqrl mqrl2) {
        this._b.put(mqrl2._a(), mqrl2);
    }

    public mqrl _b(String string) {
        return this._b.get(string);
    }

    public String _a(int n) {
        rpaa rpaa2 = this._a.get(n);
        return rpaa2 != null ? rpaa2._f : null;
    }

    @Override
    protected boolean _a(ResourceLocation resourceLocation) {
        return PathModifier._b;
    }

    @Override
    protected List<String> _a(List<ResourceLocation> list2) throws Exception {
        List<String> list3 = super._a(list2);
        this._c = list3.hashCode();
        return list3;
    }

    public int _f() {
        return this._c;
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        for (Map.Entry<String, Class> entry : this._e.entrySet()) {
            String string = entry.getKey();
            String string2 = "/assets/" + string + "/";
            String string3 = string2 + "items/";
            List<String> list2 = srxe._a(string3);
            for (String string4 : list2) {
                String string5 = string4.substring(string2.length());
                if (string4.endsWith(".txt") && PathModifier._b) {
                    string5 = string5.substring(0, string5.lastIndexOf(".")) + ".t";
                }
                arrayList.add(new ResourceLocation(string, string5));
            }
        }
        arrayList.sort(Comparator.comparing(ResourceLocation::toString));
        return arrayList;
    }

    @Override
    protected void _a(anof anof2) {
        int n = 0;
        try {
            rpaa rpaa2 = (rpaa)anof2;
            n = rpaa2._e;
            mqrl mqrl2 = this._b.get(rpaa2._f);
            if (mqrl2 != null) {
                if (mqrl2._b()) {
                    if (n <= 0 || n >= tgdv.field_77698_e.length) {
                        throw new RuntimeException("Invalid item id: " + n);
                    }
                    if (tgdv.field_77698_e[n] != null) {
                        if (this._d) {
                            tgdv.field_77698_e[n] = null;
                            if (n < twgu.field_71973_m.length) {
                                twgu.field_71973_m[n] = null;
                            }
                        } else {
                            throw new RuntimeException("Duplicate item id: " + n);
                        }
                    }
                }
                mqrl2._a(rpaa2);
            } else {
                Logger.warning("There is no item type \"" + rpaa2._f + "\"! (item " + rpaa2._e + ")", new Object[0]);
            }
        }
        catch (Exception exception) {
            if (n == 0) {
                Logger.warning("Error occurred during adding unknown item", new Object[0]);
            } else {
                Logger.warning("Error occurred during adding item " + n, new Object[0]);
            }
            exception.printStackTrace();
        }
    }

    @Override
    protected void _a(String string, HashMap<String, String> hashMap) {
        rpaa rpaa2 = new rpaa(this, string, hashMap);
        if (this._a.containsKey(rpaa2._e)) {
            Logger.finest("Duplicate id: " + rpaa2._e, new Object[0]);
            try {
                Logger.finest("Item names: " + this._a.get(rpaa2._e)._a("name") + ", " + rpaa2._a("name"), new Object[0]);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            if (rpaa2._e != 0) {
                this._a.put(rpaa2._e, rpaa2);
            }
            this._r.add(rpaa2);
        }
    }
}

