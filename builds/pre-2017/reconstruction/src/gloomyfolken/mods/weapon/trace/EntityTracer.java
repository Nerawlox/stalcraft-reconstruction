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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EntityTracer {
    private static final float _a = (float)Math.PI / 180;
    private static final float _b = 0.5f;

    public static kjui _a(World world, Vec3 vec3, float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        Vec3 vec32 = EntityTracer._a(f, f2, f3, 1.0f);
        return EntityTracer._a(world, vec3, vec32, f4, f5, f6, entity);
    }

    public static kjui _a(World world, Vec3 vec3, Vec3 vec32, float f, float f2, float f3, Entity entity) {
        double d = f * f;
        double d2 = 0.0;
        vec32._a();
        vec32._c *= (double)f2;
        vec32._d *= (double)f2;
        vec32._e *= (double)f2;
        Vec3 vec33 = Vec3._a(vec3._c + vec32._c, vec3._d + vec32._d, vec3._e + vec32._e);
        while (d2 < d) {
            kjui kjui2 = EntityTracer._a(world, vec3, vec33, entity);
            if (kjui2._c == EnumMovingObjectType._b || kjui2._g != -1) {
                return kjui2;
            }
            d2 += vec32._c * vec32._c + vec32._d * vec32._d + vec32._e * vec32._e;
            vec32._d -= (double)f3;
            tdpf._b(vec3, vec33._c, vec33._d, vec33._e);
            tdpf._a(vec33, vec32);
        }
        return null;
    }

    public static kjui _a(World world, Vec3 vec3, float f, float f2, float f3, float f4, Entity entity) {
        Vec3 vec32 = EntityTracer._a(f, f2, f3, f4);
        Vec3 vec33 = Vec3._a(vec3._c + vec32._c, vec3._d + vec32._d, vec3._e + vec32._e);
        return EntityTracer._a(world, vec3, vec33, entity);
    }

    public static kjui _a(World world, Vec3 vec3, Vec3 vec32, Entity entity) {
        return EntityTracer._a(world, vec3, vec32, entity, null, false);
    }

    public static kjui _a(World world, Vec3 vec3, Vec3 vec32, Entity entity, @Nullable Function<Entity, ugqx> function, boolean bl) {
        Vec3 vec33;
        Vec3 vec34 = Vec3._a(vec3._c, vec3._d, vec3._e);
        MovingObjectPosition movingObjectPosition = world.func_72831_a(vec34, vec33 = Vec3._a(vec32._c, vec32._d, vec32._e), false, true);
        kjui kjui2 = movingObjectPosition != null ? new kjui(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f, movingObjectPosition._g, movingObjectPosition._h) : new kjui((int)vec32._c, (int)vec32._d, (int)vec32._e, -1, vec32);
        Vec3 vec35 = kjui2._h;
        HashMap<Entity, Vec3> hashMap = EntityTracer._a(world, vec3, vec35, entity, world.isRemote || bl);
        kjui kjui3 = hashMap.size() != 0 ? (world.isRemote || bl ? EntityTracer._a(hashMap, vec3, vec35, kjui2, function) : EntityTracer._a(hashMap, vec3, kjui2)) : kjui2;
        return kjui3;
    }

    public static MovingObjectPosition _a(World world, Vec3 vec3, Vec3 vec32, Entity entity, MovingObjectPosition movingObjectPosition, boolean bl) {
        Entity entity2;
        if (movingObjectPosition != null) {
            vec32 = movingObjectPosition._h;
        }
        HashMap<Entity, Vec3> hashMap = EntityTracer._a(world, vec3, vec32, entity, false);
        Entity entity3 = entity2 = bl ? EntityTracer._b(hashMap, vec3) : EntityTracer._a(hashMap, vec3);
        if (entity2 == null) {
            return movingObjectPosition;
        }
        MovingObjectPosition movingObjectPosition2 = new MovingObjectPosition(entity2);
        movingObjectPosition2._h = hashMap.get(entity2);
        return movingObjectPosition2;
    }

    public static List<Entity> _a(World world, AxisAlignedBB axisAlignedBB, Entity entity) {
        List list = world.getEntitiesWithinAABBExcludingEntity(entity, axisAlignedBB._b(1.5, 1.5, 1.5));
        list.removeIf(entity2 -> !entity2.isEntityAlive() || !entity2.canBeCollidedWith() || entity != null && entity2 == entity.ridingEntity);
        return list;
    }

    public static AxisAlignedBB _a(Vec3 vec3, Vec3 vec32) {
        return AxisAlignedBB._a(Math.min(vec3._c, vec32._c), Math.min(vec3._d, vec32._d), Math.min(vec3._e, vec32._e), Math.max(vec3._c, vec32._c), Math.max(vec3._d, vec32._d), Math.max(vec3._e, vec32._e));
    }

    public static List<Entity> _a(World world, Vec3 vec3, Vec3 vec32, float f, Entity entity) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        AxisAlignedBB axisAlignedBB = EntityTracer._a(vec3, vec32)._b(20.0, 20.0, 20.0);
        Vec3 vec33 = VecExtensionsKt.subVector(vec32, vec3)._a();
        Vec3 vec34 = VecExtensionsKt.vec3(vec3);
        Vec3 vec35 = VecExtensionsKt.vec3(vec32);
        for (Entity entity2 : EntityTracer._a(world, axisAlignedBB, entity)) {
            double d;
            AxisAlignedBB axisAlignedBB2 = EntityTracer._a(entity2, true);
            float f2 = (float)Math.max((double)(entity2.width / 2.0f), Math.max(axisAlignedBB2._e - axisAlignedBB2._b, axisAlignedBB2._g - axisAlignedBB2._d));
            float f3 = (float)Math.max((double)(entity2.height / 2.0f), axisAlignedBB2._f - axisAlignedBB2._c);
            float f4 = (float)Math.sqrt(f2 * f2 + f3 * f3 + f2 * f2);
            Vec3 vec36 = VecExtensionsKt.vec3(McExtensionsKt.getPos(entity2));
            VecExtensionsKt.addl(vec36, 0.0, (double)entity2.height / 2.0, 0.0);
            Vec3 vec37 = EntityTracer._a(vec36, vec34, vec35);
            Vec3 vec38 = VecExtensionsKt.subVector(vec37, vec36);
            double d2 = Math.min((double)f4, vec38._b());
            vec38 = vec38._a();
            VecExtensionsKt.mull(vec38, d2);
            Vec3 vec39 = VecExtensionsKt.addVector(vec36, vec38);
            Vec3 vec310 = VecExtensionsKt.subVector(vec39, vec3);
            double d3 = vec33._b(VecExtensionsKt.normalized(vec310));
            if (!(d3 > (d = Math.cos(f))) && !(vec3._d(vec36) < 1.0) && !axisAlignedBB2._a(vec3)) continue;
            arrayList.add(entity2);
        }
        return arrayList;
    }

    private static AxisAlignedBB _a(Entity entity, boolean bl) {
        float f = entity.getCollisionBorderSize();
        if (gloomyfolken.mods.weapon.trace.ezey._d(entity) && bl) {
            f += 0.5f;
            if (entity instanceof EntityPlayer && (double)entity.height < 1.0) {
                f += 1.5f;
            }
        }
        return entity.boundingBox._b(f, f, f);
    }

    public static Vec3 _a(Vec3 vec3, Vec3 vec32, Vec3 vec33) {
        Vec3 vec34 = VecExtensionsKt.subVector(vec3, vec32);
        Vec3 vec35 = VecExtensionsKt.subVector(vec33, vec32);
        return VecExtensionsKt.addVector(vec32, VecExtensionsKt.mul(vec35, VecExtensionsKt.dot(vec34, vec35) / VecExtensionsKt.dot(vec35, vec35)));
    }

    public static void main(String[] stringArray) {
        Vec3 vec3 = VecExtensionsKt.vec3(0.0, 0.0, 0.0);
        Vec3 vec32 = VecExtensionsKt.vec3(10.0, 5.0, 15.0);
        Vec3 vec33 = VecExtensionsKt.vec3(5.0, 0.0, 0.0);
        System.out.println(EntityTracer._a(vec33, vec3, vec32));
    }

    public static HashMap<Entity, Vec3> _a(World world, Vec3 vec3, Vec3 vec32, Entity entity, boolean bl) {
        AxisAlignedBB axisAlignedBB = EntityTracer._a(vec3, vec32);
        HashMap<Entity, Vec3> hashMap = new HashMap<Entity, Vec3>();
        for (Entity entity2 : EntityTracer._a(world, axisAlignedBB, entity)) {
            AxisAlignedBB axisAlignedBB2 = EntityTracer._a(entity2, bl);
            if (axisAlignedBB2._a(vec3)) {
                hashMap.put(entity2, vec3);
                continue;
            }
            MovingObjectPosition movingObjectPosition = axisAlignedBB2._a(vec3, vec32);
            if (movingObjectPosition == null) continue;
            hashMap.put(entity2, movingObjectPosition._h);
        }
        return hashMap;
    }

    public static Vec3 _a(float f, float f2, float f3, float f4) {
        float f5 = sajh._b(-f * ((float)Math.PI / 180) - (float)Math.PI);
        float f6 = sajh._a(-f * ((float)Math.PI / 180) - (float)Math.PI);
        float f7 = -sajh._b(-f2 * ((float)Math.PI / 180));
        float f8 = sajh._a(-f2 * ((float)Math.PI / 180));
        Vec3 vec3 = Vec3._a(f6 * f7 * f4, f8 * f4, f5 * f7 * f4);
        if (f3 > 0.0f) {
            EntityTracer._a(vec3, f3);
        }
        return vec3;
    }

    private static Vec3 _b(Vec3 vec3, Vec3 vec32) {
        return Vec3._a(vec3._d * vec32._e - vec3._e * vec32._d, vec3._e * vec32._c - vec3._c * vec32._e, vec3._c * vec32._d - vec3._d * vec32._c);
    }

    public static void _a(Vec3 vec3, float f) {
        Random random = new Random();
        float f2 = f * (float)random.nextGaussian() * 0.5f;
        Vec3 vec32 = EntityTracer._b(vec3, Vec3._a(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f, random.nextFloat() - 0.5f))._a();
        Vec3 vec33 = EntityTracer._b(vec3, vec32)._a();
        float f3 = random.nextFloat();
        float f4 = 0.0f;
        float f5 = sajh._b(f2 * ((float)Math.PI / 180));
        float f6 = (float)Math.PI * 2 * f3;
        float f7 = f5 + (1.0f - f5) * f4;
        float f8 = sajh._c(1.0f - f7 * f7);
        float f9 = sajh._b(f6) * f8;
        float f10 = sajh._a(f6) * f8;
        float f11 = (float)vec3._b();
        Vec3 vec34 = vec3._a();
        Vec3 vec35 = Vec3._a(vec32._c * (double)f9, vec32._d * (double)f9, vec32._e * (double)f9);
        Vec3 vec36 = Vec3._a(vec33._c * (double)f10, vec33._d * (double)f10, vec33._e * (double)f10);
        Vec3 vec37 = Vec3._a(vec34._c * (double)f7, vec34._d * (double)f7, vec34._e * (double)f7);
        vec3._c = (vec35._c + vec36._c + vec37._c) * (double)f11;
        vec3._d = (vec35._d + vec36._d + vec37._d) * (double)f11;
        vec3._e = (vec35._e + vec36._e + vec37._e) * (double)f11;
    }

    private static Entity _a(Map<Entity, Vec3> map, Vec3 vec3) {
        Entity entity = null;
        Object var3_3 = null;
        double d = Double.MAX_VALUE;
        for (Map.Entry<Entity, Vec3> entry : map.entrySet()) {
            double d2 = vec3._e(entry.getValue());
            if (!(d2 < d)) continue;
            entity = entry.getKey();
            d = d2;
        }
        return entity;
    }

    private static Entity _b(Map<Entity, Vec3> map, Vec3 vec3) {
        Entity entity = null;
        double d = Double.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        for (Map.Entry<Entity, Vec3> entry : map.entrySet()) {
            Entity entity2 = entry.getKey();
            double d3 = entity2 instanceof ezey ? (double)((ezey)((Object)entity2)).getTraceWeight() : 1.0;
            double d4 = vec3._e(entry.getValue());
            if (!(d2 <= d3) && !(d4 < d)) continue;
            entity = entry.getKey();
            d = d4;
            d2 = d3;
        }
        return entity;
    }

    @Nullable
    public static kjui _a(HashMap<Entity, Vec3> hashMap, Vec3 vec3, Vec3 vec32, @Nullable kjui kjui2, @Nullable Function<Entity, ugqx> function) {
        TreeMap<Entity, Vec3> treeMap = EntityTracer._a(vec3, hashMap);
        for (Map.Entry<Entity, Vec3> entry : treeMap.entrySet()) {
            gloomyfolken.mods.weapon.trace.ezey<Entity> ezey2;
            Entity entity = entry.getKey();
            Vec3 vec33 = entry.getValue();
            ugqx ugqx2 = null;
            if (function != null) {
                ugqx2 = function.apply(entity);
            }
            if (ugqx2 == null && (ezey2 = gloomyfolken.mods.weapon.trace.ezey._e(entity)) != null) {
                InvokeSideOnly.client(entity.worldObj.isRemote, () -> ezey2._a(entity));
                ugqx2 = ezey2._b(entity);
            }
            boolean bl = false;
            String string = "";
            if (ugqx2 != null) {
                ugqx2._a(vec3, vec32);
                bl = ugqx2._a();
                if (ugqx2._b() != null) {
                    vec33 = ugqx2._b();
                }
                if (ugqx2._c() != null) {
                    string = ugqx2._c();
                }
            } else {
                bl = true;
                string = "body";
            }
            if (!bl) continue;
            return new kjui(entity, eidj._a(string), vec33);
        }
        return kjui2;
    }

    private static kjui _a(HashMap<Entity, Vec3> hashMap, Vec3 vec3, kjui kjui2) {
        Entity entity = EntityTracer._a(hashMap, vec3);
        if (entity == null) {
            return kjui2;
        }
        return new kjui(entity, eidj._d, hashMap.get(entity));
    }

    private static TreeMap<Entity, Vec3> _a(Vec3 vec3, HashMap<Entity, Vec3> hashMap) {
        pidb pidb2 = new pidb(vec3, hashMap);
        TreeMap<Entity, Vec3> treeMap = new TreeMap<Entity, Vec3>(pidb2);
        treeMap.putAll(hashMap);
        return treeMap;
    }

    public static interface ezey {
        public int getTraceWeight();
    }

    private static class pidb
    implements Comparator<Entity> {
        private Vec3 _a;
        private Map<Entity, Vec3> _b;

        public pidb(Vec3 vec3, Map<Entity, Vec3> map) {
            this._a = vec3;
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
    extends MovingObjectPosition {
        public eidj _a;
        public float _b;

        public kjui(int n, int n2, int n3, int n4, Vec3 vec3) {
            super(n, n2, n3, n4, vec3);
        }

        public kjui(Entity entity, eidj eidj2, Vec3 vec3) {
            super(entity);
            this._a = eidj2;
            this._h = vec3;
        }

        public String toString() {
            if (this._c == EnumMovingObjectType._b) {
                return "EntityHit: " + this._i + " (" + (Object)((Object)this._a) + ")";
            }
            return "TileHit: x=" + this._d + ", y=" + this._e + ", z=" + this._f + ", side=" + this._g;
        }
    }
}

