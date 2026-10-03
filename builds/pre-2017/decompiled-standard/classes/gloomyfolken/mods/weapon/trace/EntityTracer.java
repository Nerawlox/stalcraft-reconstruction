/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import com.google.common.collect.Lists;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.tdpf;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.weapon.trace.ugqx;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.Function;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.Nullable;

public class EntityTracer {
    private static final float _a = (float)Math.PI / 180;
    private static final float _b = 0.5f;

    public static kjui _a(ozlu ozlu2, ofbx ofbx2, float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        ofbx ofbx3 = EntityTracer._a(f, f2, f3, 1.0f);
        return EntityTracer._a(ozlu2, ofbx2, ofbx3, f4, f5, f6, entity);
    }

    public static kjui _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, float f, float f2, float f3, Entity entity) {
        double d = f * f;
        double d2 = 0.0;
        ofbx3._a();
        ofbx3._c *= (double)f2;
        ofbx3._d *= (double)f2;
        ofbx3._e *= (double)f2;
        ofbx ofbx4 = ofbx._a(ofbx2._c + ofbx3._c, ofbx2._d + ofbx3._d, ofbx2._e + ofbx3._e);
        while (d2 < d) {
            kjui kjui2 = EntityTracer._a(ozlu2, ofbx2, ofbx4, entity);
            if (kjui2._c == amww._b || kjui2._g != -1) {
                return kjui2;
            }
            d2 += ofbx3._c * ofbx3._c + ofbx3._d * ofbx3._d + ofbx3._e * ofbx3._e;
            ofbx3._d -= (double)f3;
            tdpf._b(ofbx2, ofbx4._c, ofbx4._d, ofbx4._e);
            tdpf._a(ofbx4, ofbx3);
        }
        return null;
    }

    public static kjui _a(ozlu ozlu2, ofbx ofbx2, float f, float f2, float f3, float f4, Entity entity) {
        ofbx ofbx3 = EntityTracer._a(f, f2, f3, f4);
        ofbx ofbx4 = ofbx._a(ofbx2._c + ofbx3._c, ofbx2._d + ofbx3._d, ofbx2._e + ofbx3._e);
        return EntityTracer._a(ozlu2, ofbx2, ofbx4, entity);
    }

    public static kjui _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, Entity entity) {
        return EntityTracer._a(ozlu2, ofbx2, ofbx3, entity, null, false);
    }

    public static kjui _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, Entity entity, @Nullable Function<Entity, ugqx> function, boolean bl) {
        ofbx ofbx4;
        ofbx ofbx5 = ofbx._a(ofbx2._c, ofbx2._d, ofbx2._e);
        hank hank2 = ozlu2.func_72831_a(ofbx5, ofbx4 = ofbx._a(ofbx3._c, ofbx3._d, ofbx3._e), false, true);
        kjui kjui2 = hank2 != null ? new kjui(hank2._d, hank2._e, hank2._f, hank2._g, hank2._h) : new kjui((int)ofbx3._c, (int)ofbx3._d, (int)ofbx3._e, -1, ofbx3);
        ofbx ofbx6 = kjui2._h;
        HashMap<Entity, ofbx> hashMap = EntityTracer._a(ozlu2, ofbx2, ofbx6, entity, ozlu2.field_72995_K || bl);
        kjui kjui3 = hashMap.size() != 0 ? (ozlu2.field_72995_K || bl ? EntityTracer._a(hashMap, ofbx2, ofbx6, kjui2, function) : EntityTracer._a(hashMap, ofbx2, kjui2)) : kjui2;
        return kjui3;
    }

    public static hank _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, Entity entity, hank hank2, boolean bl) {
        Entity entity2;
        if (hank2 != null) {
            ofbx3 = hank2._h;
        }
        HashMap<Entity, ofbx> hashMap = EntityTracer._a(ozlu2, ofbx2, ofbx3, entity, false);
        Entity entity3 = entity2 = bl ? EntityTracer._b(hashMap, ofbx2) : EntityTracer._a(hashMap, ofbx2);
        if (entity2 == null) {
            return hank2;
        }
        hank hank3 = new hank(entity2);
        hank3._h = hashMap.get(entity2);
        return hank3;
    }

    public static List<Entity> _a(ozlu ozlu2, net.minecraft.util.eidj eidj2, Entity entity) {
        List list = ozlu2.func_72839_b(entity, eidj2._b(1.5, 1.5, 1.5));
        list.removeIf(entity2 -> !entity2.func_70089_S() || !entity2.func_70067_L() || entity != null && entity2 == entity.field_70154_o);
        return list;
    }

    public static net.minecraft.util.eidj _a(ofbx ofbx2, ofbx ofbx3) {
        return net.minecraft.util.eidj._a(Math.min(ofbx2._c, ofbx3._c), Math.min(ofbx2._d, ofbx3._d), Math.min(ofbx2._e, ofbx3._e), Math.max(ofbx2._c, ofbx3._c), Math.max(ofbx2._d, ofbx3._d), Math.max(ofbx2._e, ofbx3._e));
    }

    public static List<Entity> _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, float f, Entity entity) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        net.minecraft.util.eidj eidj2 = EntityTracer._a(ofbx2, ofbx3)._b(20.0, 20.0, 20.0);
        ofbx ofbx4 = VecExtensionsKt.subVector(ofbx3, ofbx2)._a();
        ofbx ofbx5 = VecExtensionsKt.vec3(ofbx2);
        ofbx ofbx6 = VecExtensionsKt.vec3(ofbx3);
        for (Entity entity2 : EntityTracer._a(ozlu2, eidj2, entity)) {
            double d;
            net.minecraft.util.eidj eidj3 = EntityTracer._a(entity2, true);
            float f2 = (float)Math.max((double)(entity2.field_70130_N / 2.0f), Math.max(eidj3._e - eidj3._b, eidj3._g - eidj3._d));
            float f3 = (float)Math.max((double)(entity2.field_70131_O / 2.0f), eidj3._f - eidj3._c);
            float f4 = (float)Math.sqrt(f2 * f2 + f3 * f3 + f2 * f2);
            ofbx ofbx7 = VecExtensionsKt.vec3(McExtensionsKt.getPos(entity2));
            VecExtensionsKt.addl(ofbx7, 0.0, (double)entity2.field_70131_O / 2.0, 0.0);
            ofbx ofbx8 = EntityTracer._a(ofbx7, ofbx5, ofbx6);
            ofbx ofbx9 = VecExtensionsKt.subVector(ofbx8, ofbx7);
            double d2 = Math.min((double)f4, ofbx9._b());
            ofbx9 = ofbx9._a();
            VecExtensionsKt.mull(ofbx9, d2);
            ofbx ofbx10 = VecExtensionsKt.addVector(ofbx7, ofbx9);
            ofbx ofbx11 = VecExtensionsKt.subVector(ofbx10, ofbx2);
            double d3 = ofbx4._b(VecExtensionsKt.normalized(ofbx11));
            if (!(d3 > (d = Math.cos(f))) && !(ofbx2._d(ofbx7) < 1.0) && !eidj3._a(ofbx2)) continue;
            arrayList.add(entity2);
        }
        return arrayList;
    }

    private static net.minecraft.util.eidj _a(Entity entity, boolean bl) {
        float f = entity.func_70111_Y();
        if (gloomyfolken.mods.weapon.trace.ezey._d(entity) && bl) {
            f += 0.5f;
            if (entity instanceof EntityPlayer && (double)entity.field_70131_O < 1.0) {
                f += 1.5f;
            }
        }
        return entity.field_70121_D._b(f, f, f);
    }

    public static ofbx _a(ofbx ofbx2, ofbx ofbx3, ofbx ofbx4) {
        ofbx ofbx5 = VecExtensionsKt.subVector(ofbx2, ofbx3);
        ofbx ofbx6 = VecExtensionsKt.subVector(ofbx4, ofbx3);
        return VecExtensionsKt.addVector(ofbx3, VecExtensionsKt.mul(ofbx6, VecExtensionsKt.dot(ofbx5, ofbx6) / VecExtensionsKt.dot(ofbx6, ofbx6)));
    }

    public static void main(String[] stringArray) {
        ofbx ofbx2 = VecExtensionsKt.vec3(0.0, 0.0, 0.0);
        ofbx ofbx3 = VecExtensionsKt.vec3(10.0, 5.0, 15.0);
        ofbx ofbx4 = VecExtensionsKt.vec3(5.0, 0.0, 0.0);
        System.out.println(EntityTracer._a(ofbx4, ofbx2, ofbx3));
    }

    public static HashMap<Entity, ofbx> _a(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, Entity entity, boolean bl) {
        net.minecraft.util.eidj eidj2 = EntityTracer._a(ofbx2, ofbx3);
        HashMap<Entity, ofbx> hashMap = new HashMap<Entity, ofbx>();
        for (Entity entity2 : EntityTracer._a(ozlu2, eidj2, entity)) {
            net.minecraft.util.eidj eidj3 = EntityTracer._a(entity2, bl);
            if (eidj3._a(ofbx2)) {
                hashMap.put(entity2, ofbx2);
                continue;
            }
            hank hank2 = eidj3._a(ofbx2, ofbx3);
            if (hank2 == null) continue;
            hashMap.put(entity2, hank2._h);
        }
        return hashMap;
    }

    public static ofbx _a(float f, float f2, float f3, float f4) {
        float f5 = sajh._b(-f * ((float)Math.PI / 180) - (float)Math.PI);
        float f6 = sajh._a(-f * ((float)Math.PI / 180) - (float)Math.PI);
        float f7 = -sajh._b(-f2 * ((float)Math.PI / 180));
        float f8 = sajh._a(-f2 * ((float)Math.PI / 180));
        ofbx ofbx2 = ofbx._a(f6 * f7 * f4, f8 * f4, f5 * f7 * f4);
        if (f3 > 0.0f) {
            EntityTracer._a(ofbx2, f3);
        }
        return ofbx2;
    }

    private static ofbx _b(ofbx ofbx2, ofbx ofbx3) {
        return ofbx._a(ofbx2._d * ofbx3._e - ofbx2._e * ofbx3._d, ofbx2._e * ofbx3._c - ofbx2._c * ofbx3._e, ofbx2._c * ofbx3._d - ofbx2._d * ofbx3._c);
    }

    public static void _a(ofbx ofbx2, float f) {
        Random random = new Random();
        float f2 = f * (float)random.nextGaussian() * 0.5f;
        ofbx ofbx3 = EntityTracer._b(ofbx2, ofbx._a(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f, random.nextFloat() - 0.5f))._a();
        ofbx ofbx4 = EntityTracer._b(ofbx2, ofbx3)._a();
        float f3 = random.nextFloat();
        float f4 = 0.0f;
        float f5 = sajh._b(f2 * ((float)Math.PI / 180));
        float f6 = (float)Math.PI * 2 * f3;
        float f7 = f5 + (1.0f - f5) * f4;
        float f8 = sajh._c(1.0f - f7 * f7);
        float f9 = sajh._b(f6) * f8;
        float f10 = sajh._a(f6) * f8;
        float f11 = (float)ofbx2._b();
        ofbx ofbx5 = ofbx2._a();
        ofbx ofbx6 = ofbx._a(ofbx3._c * (double)f9, ofbx3._d * (double)f9, ofbx3._e * (double)f9);
        ofbx ofbx7 = ofbx._a(ofbx4._c * (double)f10, ofbx4._d * (double)f10, ofbx4._e * (double)f10);
        ofbx ofbx8 = ofbx._a(ofbx5._c * (double)f7, ofbx5._d * (double)f7, ofbx5._e * (double)f7);
        ofbx2._c = (ofbx6._c + ofbx7._c + ofbx8._c) * (double)f11;
        ofbx2._d = (ofbx6._d + ofbx7._d + ofbx8._d) * (double)f11;
        ofbx2._e = (ofbx6._e + ofbx7._e + ofbx8._e) * (double)f11;
    }

    private static Entity _a(Map<Entity, ofbx> map, ofbx ofbx2) {
        Entity entity = null;
        Object var3_3 = null;
        double d = Double.MAX_VALUE;
        for (Map.Entry<Entity, ofbx> entry : map.entrySet()) {
            double d2 = ofbx2._e(entry.getValue());
            if (!(d2 < d)) continue;
            entity = entry.getKey();
            d = d2;
        }
        return entity;
    }

    private static Entity _b(Map<Entity, ofbx> map, ofbx ofbx2) {
        Entity entity = null;
        double d = Double.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        for (Map.Entry<Entity, ofbx> entry : map.entrySet()) {
            Entity entity2 = entry.getKey();
            double d3 = entity2 instanceof ezey ? (double)((ezey)((Object)entity2)).getTraceWeight() : 1.0;
            double d4 = ofbx2._e(entry.getValue());
            if (!(d2 <= d3) && !(d4 < d)) continue;
            entity = entry.getKey();
            d = d4;
            d2 = d3;
        }
        return entity;
    }

    @Nullable
    public static kjui _a(HashMap<Entity, ofbx> hashMap, ofbx ofbx2, ofbx ofbx3, @Nullable kjui kjui2, @Nullable Function<Entity, ugqx> function) {
        TreeMap<Entity, ofbx> treeMap = EntityTracer._a(ofbx2, hashMap);
        for (Map.Entry<Entity, ofbx> entry : treeMap.entrySet()) {
            gloomyfolken.mods.weapon.trace.ezey<Entity> ezey2;
            Entity entity = entry.getKey();
            ofbx ofbx4 = entry.getValue();
            ugqx ugqx2 = null;
            if (function != null) {
                ugqx2 = function.apply(entity);
            }
            if (ugqx2 == null && (ezey2 = gloomyfolken.mods.weapon.trace.ezey._e(entity)) != null) {
                InvokeSideOnly.client(entity.field_70170_p.field_72995_K, () -> ezey2._a(entity));
                ugqx2 = ezey2._b(entity);
            }
            boolean bl = false;
            String string = "";
            if (ugqx2 != null) {
                ugqx2._a(ofbx2, ofbx3);
                bl = ugqx2._a();
                if (ugqx2._b() != null) {
                    ofbx4 = ugqx2._b();
                }
                if (ugqx2._c() != null) {
                    string = ugqx2._c();
                }
            } else {
                bl = true;
                string = "body";
            }
            if (!bl) continue;
            return new kjui(entity, eidj._a(string), ofbx4);
        }
        return kjui2;
    }

    private static kjui _a(HashMap<Entity, ofbx> hashMap, ofbx ofbx2, kjui kjui2) {
        Entity entity = EntityTracer._a(hashMap, ofbx2);
        if (entity == null) {
            return kjui2;
        }
        return new kjui(entity, eidj._d, hashMap.get(entity));
    }

    private static TreeMap<Entity, ofbx> _a(ofbx ofbx2, HashMap<Entity, ofbx> hashMap) {
        pidb pidb2 = new pidb(ofbx2, hashMap);
        TreeMap<Entity, ofbx> treeMap = new TreeMap<Entity, ofbx>(pidb2);
        treeMap.putAll(hashMap);
        return treeMap;
    }

    public static interface ezey {
        public int getTraceWeight();
    }

    private static class pidb
    implements Comparator<Entity> {
        private ofbx _a;
        private Map<Entity, ofbx> _b;

        public pidb(ofbx ofbx2, Map<Entity, ofbx> map) {
            this._a = ofbx2;
            this._b = map;
        }

        public int _a(Entity entity, Entity entity2) {
            if (this._a._e(this._b.get(entity)) >= this._a._e(this._b.get(entity2))) {
                return 1;
            }
            return -1;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this._a((Entity)object, (Entity)object2);
        }
    }

    public static enum eidj {
        _a(0.0f),
        _b(0.0f),
        _c(0.5f),
        _d(1.0f),
        _e(1.5f);

        public float _f;
        public static final List<String> _g;
        public static final List<String> _h;

        private eidj(float f) {
            this._f = f;
        }

        public static eidj _a(@Nullable String string) {
            if (string == null || string.isEmpty()) {
                return _a;
            }
            String string2 = string.toLowerCase();
            if (_h.stream().anyMatch(string2::contains)) {
                return _e;
            }
            if (_g.stream().anyMatch(string2::contains)) {
                return _c;
            }
            return _d;
        }

        static {
            _g = new ArrayList<String>();
            _h = new ArrayList<String>();
            _h.add("head");
            _g.add("arm");
            _g.add("leg");
            _g.add("_calf");
            _g.add("_thigh");
            _g.add("_foot");
            _g.add("_clavicle");
            _g.add("_hand");
            _g.add("_finger");
            _g.add("_toe");
        }
    }

    public static class kjui
    extends hank {
        public eidj _a;
        public float _b;

        public kjui(int n, int n2, int n3, int n4, ofbx ofbx2) {
            super(n, n2, n3, n4, ofbx2);
        }

        public kjui(Entity entity, eidj eidj2, ofbx ofbx2) {
            super(entity);
            this._a = eidj2;
            this._h = ofbx2;
        }

        public String toString() {
            if (this._c == amww._b) {
                return "EntityHit: " + this._i + " (" + (Object)((Object)this._a) + ")";
            }
            return "TileHit: x=" + this._d + ", y=" + this._e + ", z=" + this._f + ", side=" + this._g;
        }
    }
}

