/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.money.zwat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;

public class hszb {
    public static final hszb _a = new hszb();
    private Map<Integer, hsvw> _b = new HashMap<Integer, hsvw>();

    public hsvw _a(int n) {
        return this._b.get(n);
    }

    public void _a(hsvw hsvw2) {
        if (this._b.put(hsvw2._d(), hsvw2) != null) {
            throw new IllegalArgumentException("Duplicating recipe with id " + hsvw2._d() + ": " + hsvw2);
        }
    }

    private List<Float> _c(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (int i = 0; i < n; ++i) {
            float f = 0.0f;
            float f2 = 0.0f;
            for (cvzo cvzo2 : hsvw2._i()) {
                int n2 = cvzo2._b;
                for (yeso yeso2 : zwyn2.getOwnedSlots()) {
                    cvzo cvzo3 = yeso2.func_75211_c();
                    if (cvzo3 == null || cvzo3._d != cvzo2._d) continue;
                    f += cvzo3._f() ? (float)cvzo3._j() : 1.0f;
                    f2 += cvzo3._f() ? (float)cvzo3._k() : 1.0f;
                    if (cvzo3._b < n2) {
                        n2 -= cvzo3._b;
                        cvzo3._b = 0;
                        yeso2.func_75215_d(null);
                        continue;
                    }
                    cvzo3._b -= n2;
                    n2 = 0;
                }
                if (n2 <= 0) continue;
                throw new IllegalStateException("Unable to consume sufficient amount of items");
            }
            arrayList.add(Float.valueOf(f / f2));
        }
        zwyn2.func_75142_b();
        return arrayList;
    }

    public boolean _a(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        if (!magc._a(entityPlayer)._a(hsvw2)) {
            return false;
        }
        if (!this._b(entityPlayer, hsvw2, n)) {
            return false;
        }
        long l = hsvw2._b();
        return l <= 0L || zwat._a(entityPlayer)._a() >= l;
    }

    public boolean _b(EntityPlayer entityPlayer, hsvw hsvw2, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Ingredients multiplier can't be lower than 1");
        }
        List<cvzo> list = hsvw2._i();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        zwyn zwyn2 = (zwyn)entityPlayer.field_71069_bz;
        for (cvzo cvzo2 : list) {
            int n2 = cvzo2._b * n;
            for (yeso yeso2 : zwyn2.getOwnedSlots()) {
                cvzo cvzo3 = yeso2.func_75211_c();
                if (cvzo3 == null || cvzo3._d != cvzo2._d) continue;
                int n3 = hashMap.getOrDefault(yeso2.getSlotIndex(), cvzo3._b);
                if (n3 < n2) {
                    n2 -= n3;
                    hashMap.put(yeso2.getSlotIndex(), 0);
                    continue;
                }
                hashMap.put(yeso2.getSlotIndex(), n3 - n2);
                n2 = 0;
            }
            if (n2 <= 0) continue;
            return false;
        }
        return true;
    }

    public Map<Integer, hsvw> _a() {
        return this._b;
    }
}

