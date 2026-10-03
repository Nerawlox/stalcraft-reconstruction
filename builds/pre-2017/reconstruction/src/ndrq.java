/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

@ezey(_a={eidj.CLIENT})
public class ndrq
extends ccsw {
    private HashMap<pidb, kjui> _a = new HashMap();
    private pidb _b = new pidb(0, 0);
    private kjui _c;

    public kjui _a(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4;
        int n5;
        short s = ClientProxy.carpenterHelper._a(iBlockAccess, n, n2, n3);
        if (s != 0) {
            n5 = ClientProxy.carpenterHelper._a(s);
            n4 = ClientProxy.carpenterHelper._b(s);
        } else {
            n5 = iBlockAccess.getBlockId(n, n2, n3);
            n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        }
        return this._a(n5, n4);
    }

    public kjui _a(int n, int n2) {
        if (n == 0) {
            return null;
        }
        this._b._a = n;
        this._b._b = n2;
        kjui kjui2 = this._a.get(this._b);
        if (kjui2 != null) {
            return kjui2;
        }
        this._b._b = -1;
        kjui2 = this._a.get(this._b);
        if (kjui2 != null) {
            return kjui2;
        }
        return this._c;
    }

    @Override
    protected void _a(anof anof2) {
        this._c = this._a("default", anof2, 2, 0.5f, 0.2f);
        this._a("grass", anof2, 2, 0.5f, 0.2f);
        this._a("concrete", anof2, 0, 0.75f, 0.75f);
        this._a("metal", anof2, 3, 1.0f, 0.7f);
        this._a("sand", anof2, 2, 0.2f, 0.2f);
        this._a("wood", anof2, 4, 0.4f, 0.2f);
        this._a("water", anof2, 2, 0.0f, 0.0f);
        this._a("glass", anof2, 1, 0.5f, 0.03f);
    }

    private kjui _a(String string, anof anof2, int n, float f, float f2) {
        kjui kjui2 = new kjui(string, n, f, f2);
        kjui2._c = "weapons:bullet.collide_" + string;
        kjui2._d = "weapons:melee.collide_" + string;
        this._a(kjui2, anof2._d(string));
        return kjui2;
    }

    private void _a(kjui kjui2, String[] stringArray) {
        for (String string : stringArray) {
            int n = string.indexOf(":");
            pidb pidb2 = n == -1 ? new pidb(Integer.parseInt(string)) : new pidb(Integer.parseInt(string.substring(0, n)), Integer.parseInt(string.substring(n + 1)));
            this._a.put(pidb2, kjui2);
        }
    }

    @Override
    protected List<ResourceLocation> _a() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        ResourceLocation resourceLocation = new ResourceLocation("weapons", "sound_material.txt");
        arrayList.add(resourceLocation);
        return arrayList;
    }

    private static class pidb {
        public int _a;
        public int _b;

        public pidb(int n) {
            this._a = n;
            this._b = -1;
        }

        public pidb(int n, int n2) {
            this._a = n;
            this._b = n2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            pidb pidb2 = (pidb)object;
            if (this._a != pidb2._a) {
                return false;
            }
            return this._b == pidb2._b;
        }

        public int hashCode() {
            int n = this._a;
            n = 31 * n + this._b;
            return n;
        }
    }

    public static class kjui {
        public final String _a;
        public final int _b;
        public String _c;
        public String _d;
        public float _e;
        public float _f;

        public kjui(String string, int n, float f, float f2) {
            this._a = string;
            this._b = n;
            this._e = f;
            this._f = f2;
        }
    }
}

