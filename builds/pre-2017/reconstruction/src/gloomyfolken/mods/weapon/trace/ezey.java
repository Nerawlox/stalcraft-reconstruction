/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.core.misc.samo;
import gloomyfolken.mods.effects.client.mcsa.xpzm;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.weapon.trace.eidj;
import gloomyfolken.mods.weapon.trace.jgro;
import gloomyfolken.mods.weapon.trace.jxtc;
import gloomyfolken.mods.weapon.trace.qlgf;
import gloomyfolken.mods.weapon.trace.tupg;
import gloomyfolken.mods.weapon.trace.ugqx;
import gloomyfolken.mods.weapon.trace.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.EntityNPCInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0013*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u0013\u0014B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00028\u0000H'\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "T", "Lnet/minecraft/entity/Entity;", "", "()V", "buildTraceResult", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "(Lnet/minecraft/entity/Entity;)Lgloomyfolken/mods/weapon/trace/TraceResult;", "buildTraceResultInternal", "read", "", "input", "Ljava/io/DataInput;", "setFromClientEntity", "(Lnet/minecraft/entity/Entity;)Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "write", "output", "Ljava/io/DataOutput;", "Companion", "NpcTraceMeshBuilder", "minecraft"})
public abstract class ezey<T extends Entity> {
    private static final samo<Entity, Class<ezey<Entity>>> _b;
    private static final HashMap<Class<? extends ezey<?>>, Integer> _c;
    private static final HashMap<Integer, Class<? extends ezey<?>>> _d;
    private static int _e;
    public static final kjui _a;

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @Nullable
    public abstract ezey<T> _a(@NotNull T var1);

    @NotNull
    public final ugqx _b(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "entity");
        ugqx ugqx2 = this._c(t);
        uigm uigm2 = new uigm(ugqx2, (Entity)t);
        MinecraftForge.EVENT_BUS.post(uigm2);
        if (uigm2._d != null) {
            ugqx ugqx3 = uigm2._d;
            Intrinsics.checkExpressionValueIsNotNull(ugqx3, "event.overrideResult");
            ugqx2 = ugqx3;
        }
        return ugqx2;
    }

    @NotNull
    protected abstract ugqx _c(@NotNull T var1);

    public void _a(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
    }

    public void _a(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
    }

    static {
        _a = new kjui(null);
        _b = new samo(Entity.class);
        _c = new HashMap();
        _d = new HashMap();
        _a._a(EntityPlayer.class, jxtc.class);
        _a._a(EntityMutant.class, tupg.class);
        _a._a(EntityRagdollCorpse.class, jgro.class);
        _a._a(EntityCorpseBag.class, zwat.class);
        if (ModLoader.isModLoaded("customnpcs")) {
            pidb._a._a();
        }
    }

    @JvmStatic
    public static final boolean _d(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return _a._a(entity);
    }

    @JvmStatic
    @Nullable
    public static final ezey<Entity> _e(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return _a._b(entity);
    }

    @JvmStatic
    @Nullable
    public static final ezey<?> _b(int n) {
        return _a._a(n);
    }

    @JvmStatic
    public static final int _a(@NotNull ezey<?> ezey2) {
        Intrinsics.checkParameterIsNotNull(ezey2, "traceMeshBuilder");
        return _a._a(ezey2);
    }

    @JvmStatic
    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public static final void _a(@NotNull Entity entity, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        _a._a(entity, d, d2, d3);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder$NpcTraceMeshBuilder;", "", "()V", "register", "", "minecraft"})
    public static final class pidb {
        public static final pidb _a;

        public final void _a() {
            _a._a(EntityNPCInterface.class, qlgf.class);
        }

        private pidb() {
            _a = this;
        }

        static {
            new pidb();
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u000bH\u0007J\u0014\u0010\u001b\u001a\u00020\u00042\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\rH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u000bH\u0007J*\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\f2\u0012\u0010\"\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\fJ(\u0010#\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\f0\nX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRH\u0010\u0010\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f0\u0011j\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f`\u0012X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014RH\u0010\u0015\u001a6\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\u0012\u0004\u0012\u00020\u00040\u0011j\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\u0012\u0004\u0012\u00020\u0004`\u0012X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006("}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder$Companion;", "", "()V", "BUILDER_ID", "", "getBUILDER_ID", "()I", "setBUILDER_ID", "(I)V", "entityToMeshBuilder", "Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "Lnet/minecraft/entity/Entity;", "Ljava/lang/Class;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "getEntityToMeshBuilder", "()Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "idToTraceMeshBuilder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getIdToTraceMeshBuilder", "()Ljava/util/HashMap;", "traceMeshBuilderToId", "getTraceMeshBuilderToId", "createBuilderById", "id", "createTraceMeshBuilder", "entity", "getBuilderId", "traceMeshBuilder", "hasEntityCustomTraceMesh", "", "registerMeshBuilder", "", "entityClz", "builderClz", "renderTraceMeshBounds", "dx", "", "dy", "dz", "minecraft"})
    public static final class kjui {
        private final samo<Entity, Class<ezey<Entity>>> _a() {
            return _b;
        }

        private final HashMap<Class<? extends ezey<?>>, Integer> _b() {
            return _c;
        }

        private final HashMap<Integer, Class<? extends ezey<?>>> _c() {
            return _d;
        }

        private final int _d() {
            return _e;
        }

        private final void _b(int n) {
            _e = n;
        }

        public final void _a(@NotNull Class<? extends Entity> clazz, @NotNull Class<? extends ezey<?>> clazz2) {
            Intrinsics.checkParameterIsNotNull(clazz, "entityClz");
            Intrinsics.checkParameterIsNotNull(clazz2, "builderClz");
            this._a()._a(clazz, clazz2);
            Map map = this._c();
            Pair<Serializable, Serializable> pair = TuplesKt.to(this._d(), clazz2);
            map.put(pair.getFirst(), pair.getSecond());
            map = this._b();
            pair = TuplesKt.to(clazz2, this._d());
            map.put(pair.getFirst(), pair.getSecond());
            kjui kjui2 = this;
            int n = kjui2._d();
            kjui2._b(n + 1);
        }

        @JvmStatic
        public final boolean _a(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return this._a()._a(entity.getClass()) != null;
        }

        @JvmStatic
        @Nullable
        public final ezey<Entity> _b(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            Class<ezey<Entity>> clazz = this._a()._a(entity.getClass());
            return clazz != null ? clazz.newInstance() : null;
        }

        @JvmStatic
        @Nullable
        public final ezey<?> _a(int n) {
            Class<ezey<?>> clazz = this._c().get(n);
            return clazz != null ? clazz.newInstance() : null;
        }

        @JvmStatic
        public final int _a(@NotNull ezey<?> ezey2) {
            Intrinsics.checkParameterIsNotNull(ezey2, "traceMeshBuilder");
            Integer n = this._b().get(ezey2.getClass());
            return n != null ? n : -1;
        }

        @JvmStatic
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        public final void _a(@NotNull Entity entity, double d, double d2, double d3) {
            Object object;
            ezey<Entity> ezey2;
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            GL11.glDepthMask(false);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
            GL11.glPushMatrix();
            GL11.glTranslated(d, d2, d3);
            GL11.glTranslated(-entity.posX, -entity.posY, -entity.posZ);
            ezey<Entity> ezey3 = ezey2 = this._b(entity);
            if (ezey3 != null) {
                ezey3._a(entity);
            }
            if ((object = ezey2) != null && (object = ((ezey)object)._b((Entity)entity)) != null && (object = ((ugqx)object)._d()) != null && (object = ((eidj)object)._b()) != null && (object = object.values()) != null) {
                Iterable iterable = (Iterable)object;
                for (Object t : iterable) {
                    eidj.kjui kjui2 = (eidj.kjui)t;
                    xpzm._a(kjui2._e());
                }
            }
            GL11.glPopMatrix();
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

