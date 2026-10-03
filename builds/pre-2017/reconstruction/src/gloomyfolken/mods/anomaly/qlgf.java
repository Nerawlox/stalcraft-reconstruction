/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.asm.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.sajh;

public class qlgf {
    private List<kjui> _a = new ArrayList<kjui>();
    private int _b = 0;
    private float _c;

    public qlgf(String string) {
        if (!string.isEmpty()) {
            String[] stringArray = string.split(",");
            for (int i = 0; i < stringArray.length; ++i) {
                String string2 = stringArray[i];
                kjui kjui2 = new kjui(string2);
                if (kjui2._a <= 0 || kjui2._a >= 32000) {
                    this._c += kjui2._d;
                    continue;
                }
                this._b = (int)((float)this._b + kjui2._d);
                this._a.add(kjui2);
            }
        }
    }

    public void _a(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int n2;
            ItemStack object = this._a(random);
            int n3 = n2 = object == null ? 0 : object._d;
            if (!hashMap.containsKey(n2)) {
                hashMap.put(n2, 1);
                continue;
            }
            hashMap.put(n2, (Integer)hashMap.get(n2) + 1);
        }
        Logger.finest("Drops test:", new Object[0]);
        for (Map.Entry entry : hashMap.entrySet()) {
            Logger.finest(entry.getKey() + ": " + entry.getValue() + " results", new Object[0]);
        }
    }

    public ItemStack _a(Random random) {
        int n;
        int n2 = MinecraftServer._I()._g();
        if (this._b <= 0 || n2 <= 0 || AnomalyMod._a() <= 0.0) {
            return null;
        }
        double d = random.nextDouble() * ((double)this._b + (double)this._c / (Math.sqrt(n2) * AnomalyMod._a()));
        float f = 0.0f;
        for (n = 0; n < this._a.size() && (double)f < d; ++n) {
            f += this._a.get((int)n)._d;
        }
        if (n == this._a.size() && (double)f < d) {
            return null;
        }
        kjui kjui2 = this._a.get(n - 1);
        return this._a(kjui2._a, kjui2._c, kjui2._b);
    }

    public ItemStack _b(Random random) {
        float f;
        if (this._b <= 0) {
            return null;
        }
        float f2 = random.nextFloat() * ((float)this._b + this._c);
        int n = 0;
        for (f = 0.0f; n < this._a.size() && f < f2; f += this._a.get((int)n)._d, ++n) {
        }
        if (n == this._a.size() && f < f2) {
            return null;
        }
        kjui kjui2 = this._a.get(n - 1);
        return this._a(kjui2._a, kjui2._c, kjui2._b);
    }

    private ItemStack _a(int n, int n2, int n3) {
        if (n <= 0 || n >= 32000) {
            return null;
        }
        if (Item.itemsList[n] == null) {
            Logger.info("[WARNING] Item " + n + " doesn't exist, can't create random stack!", new Object[0]);
            return null;
        }
        return new ItemStack(n, sajh._a(n2, 1, 64), n3);
    }

    private static class kjui {
        public final int _a;
        public final int _b;
        public final int _c;
        public final float _d;

        public kjui(int n, int n2, int n3, float f) {
            this._a = n;
            this._b = n2;
            this._c = n3;
            this._d = f;
        }

        public kjui(String string) {
            String[] stringArray = string.split("-");
            this._d = Float.parseFloat(stringArray[1]);
            String string2 = stringArray[0];
            String[] stringArray2 = string2.split("x");
            String string3 = stringArray2[0];
            this._c = stringArray2.length == 1 ? 1 : Integer.parseInt(stringArray2[1]);
            String[] stringArray3 = string3.split(":");
            this._b = stringArray3.length == 1 ? 0 : Integer.parseInt(stringArray3[1]);
            this._a = Integer.parseInt(stringArray3[0]);
        }
    }
}

