/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.jgro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.util.vector.Vector3f;

public class anof {
    public final String _a;
    public HashMap<String, String> _b;

    public anof(String string, HashMap<String, String> hashMap) {
        this._a = string;
        this._b = hashMap;
    }

    protected String _a(String string) {
        return this._b.get(string);
    }

    public boolean _b(String string) {
        return this._a(string) != null;
    }

    public Collection<String> _a() {
        return new ArrayList<String>(this._b.keySet());
    }

    public List<String> _a(String string, ArrayList<String> arrayList) {
        return Arrays.asList(this._a(string, arrayList.toArray(new String[0])));
    }

    public List<String> _c(String string) {
        return this._a(string, new ArrayList<String>(0));
    }

    public String[] _a(String string, String[] stringArray) {
        String string2 = this._a(string);
        if (string2 == null) {
            return stringArray;
        }
        return StringUtils.split(string2, '@');
    }

    public String[] _d(String string) {
        return this._a(string, new String[0]);
    }

    public int[] _a(String string, int[] nArray) {
        String string2 = this._a(string);
        if (string2 != null) {
            String[] stringArray = string2.split("@");
            int[] nArray2 = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                nArray2[i] = Integer.parseInt(stringArray[i]);
            }
            return nArray2;
        }
        return nArray;
    }

    public HashMap<Integer, Integer> _e(String string) {
        String[] stringArray = this._d(string);
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(stringArray.length);
        try {
            for (String string2 : stringArray) {
                String[] stringArray2 = StringUtils.split(string2, "->");
                hashMap.put(Integer.parseInt(stringArray2[0]), Integer.parseInt(stringArray2[1]));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return hashMap;
    }

    public int[] _f(String string) {
        return this._a(string, new int[0]);
    }

    public int _a(String string, int n) {
        String string2 = this._a(string);
        return string2 == null ? n : Integer.parseInt(string2);
    }

    public int _g(String string) {
        return this._a(string, 0);
    }

    public String _a(String string, String string2) {
        String string3 = this._a(string);
        return string3 == null ? string2 : string3;
    }

    public String _h(String string) {
        return this._a(string, "");
    }

    public boolean _a(String string, boolean bl) {
        String string2 = this._a(string);
        return string2 == null ? bl : string2.equals("true");
    }

    public boolean _i(String string) {
        return this._a(string, false);
    }

    public float _a(String string, float f) {
        String string2 = this._a(string);
        return string2 == null ? f : Float.parseFloat(string2.replace(',', '.'));
    }

    public float _j(String string) {
        return this._a(string, 0.0f);
    }

    public float _k(String string) {
        return jgro._b(this._j(string));
    }

    public float _l(String string) {
        return this._j(string) / 100.0f;
    }

    public float[] _a(String string, float[] fArray) {
        String string2 = this._a(string);
        if (string2 != null) {
            String[] stringArray = string2.split("@");
            float[] fArray2 = new float[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                fArray2[i] = Float.parseFloat(stringArray[i]);
            }
            return fArray2;
        }
        return fArray;
    }

    public float[] _m(String string) {
        return this._a(string, new float[0]);
    }

    @ezey(_a={eidj.CLIENT})
    public Vector3f _n(String string) {
        float[] fArray = this._m(string);
        Vector3f vector3f = new Vector3f();
        if (fArray.length == 3) {
            vector3f.set(fArray[0], fArray[1], fArray[2]);
        }
        return vector3f;
    }

    public ItemStack _o(String string) {
        return this._a(string, (ItemStack)null);
    }

    public ItemStack _a(String string, ItemStack itemStack) {
        String string2 = this._a(string);
        return string2 == null ? itemStack : this._q(string2);
    }

    public ItemStack[] _p(String string) {
        String string2 = this._a(string);
        if (string2 == null) {
            return new ItemStack[0];
        }
        String[] stringArray = string2.split("@");
        ItemStack[] itemStackArray = new ItemStack[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            itemStackArray[i] = this._q(stringArray[i]);
        }
        return itemStackArray;
    }

    private ItemStack _q(String string) {
        try {
            int n = string.indexOf(58);
            int n2 = string.indexOf(120);
            if (n2 == -1) {
                n2 = string.indexOf(1093);
            }
            int n3 = n == -1 && n2 == -1 ? Integer.parseInt(string) : (n == -1 != (n2 == -1) ? Integer.parseInt(string.substring(0, Math.max(n, n2))) : Integer.parseInt(string.substring(0, Math.min(n, n2))));
            int n4 = n == -1 ? 0 : (n > n2 ? Integer.parseInt(string.substring(n + 1)) : Integer.parseInt(string.substring(n + 1, n2)));
            int n5 = n2 == -1 ? 1 : (n2 > n ? Integer.parseInt(string.substring(n2 + 1)) : Integer.parseInt(string.substring(n2 + 1, n)));
            return new ItemStack(n3, n5, n4);
        }
        catch (Exception exception) {
            throw new RuntimeException("Invalid item stack string: " + string);
        }
    }
}

