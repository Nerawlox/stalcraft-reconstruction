/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import net.minecraftforge.common.DimensionManager;

public class ezey {
    private HashMap<Integer, Integer> _a = new HashMap();
    private HashMap<Integer, Integer> _b = new HashMap();
    private final int _c;
    private static HashSet<Integer> _d = Sets.newHashSet(-1, 0, 1);
    private final int[] _e;

    public ezey(int n) {
        this._c = n;
        Integer[] integerArray = DimensionManager.getStaticDimensionIDs();
        for (int i = 0; i < n; ++i) {
            Integer[] integerArray2 = integerArray;
            int n2 = integerArray2.length;
            for (int j = 0; j < n2; ++j) {
                int n3 = integerArray2[j];
                if (!_d.contains(n3)) continue;
                int n4 = this._a(n3, i);
                this._a.put(n4, n3);
                this._b.put(n4, i);
            }
        }
        this._e = new int[n];
    }

    public void _a() {
        for (Map.Entry<Integer, Integer> entry : this._a.entrySet()) {
            int n = entry.getKey();
            int n2 = entry.getValue();
            if (DimensionManager.isDimensionRegistered(n)) continue;
            DimensionManager.registerDimension(n, DimensionManager.getProviderType(n2));
            DimensionManager.initDimension(n);
        }
    }

    public int _a(int n, int n2) {
        if (n2 < 0 || n2 >= this._c) {
            throw new IllegalArgumentException("Invalid instance id: " + n2);
        }
        if (n < -500 || n > 500) {
            throw new IllegalArgumentException("Invalid base dimension id: " + n);
        }
        return n + 1000 * n2;
    }

    public int _a(int n) {
        Integer n2 = this._a.get(n);
        if (n2 == null) {
            throw new IllegalArgumentException("Cloned dimension id " + n + " is not registered!");
        }
        return n2;
    }

    public int _b(int n) {
        Integer n2 = this._b.get(n);
        if (n2 == null) {
            throw new IllegalArgumentException("Cloned dimension id " + n + " is not registered!");
        }
        return n2;
    }

    public void _b(int n, int n2) {
        if (n < this._e.length) {
            this._e[n] = n2;
        }
    }

    public int _c(int n) {
        if (n < this._e.length) {
            return this._e[n];
        }
        return 0;
    }
}

