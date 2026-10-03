/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.stalker.mobs.client.render.MutantAnimationHandler;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.weapon.trace.eidj;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0002H\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderMutant;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "()V", "animationName", "", "getAnimationName", "()Ljava/lang/String;", "setAnimationName", "(Ljava/lang/String;)V", "clipProgress", "", "getClipProgress", "()F", "setClipProgress", "(F)V", "buildTraceResultInternal", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "read", "", "input", "Ljava/io/DataInput;", "setFromClientEntity", "write", "output", "Ljava/io/DataOutput;", "Companion", "TraceMeshMutant", "minecraft"})
public final class tupg
extends ezey<EntityMutant> {
    private float _c;
    @NotNull
    private String _d = "";
    @NotNull
    private static final Map<Class<? extends EntityMutant>, pidb> _e;
    public static final kjui _b;

    public final float _e() {
        return this._c;
    }

    public final void _a(float f) {
        this._c = f;
    }

    @NotNull
    public final String _f() {
        return this._d;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._d = string;
    }

    @Override
    public void _a(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        dataOutput.writeByte((int)(this._c * (float)255 - (float)128));
        Packet.writeString(this._d, dataOutput);
    }

    @Override
    public void _a(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        this._c = (float)(dataInput.readByte() + 128) / 255.0f;
        String string = Packet.readString(dataInput, 256);
        Intrinsics.checkExpressionValueIsNotNull(string, "Packet.readString(input, 256)");
        this._d = string;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @Nullable
    public tupg _a(@NotNull EntityMutant entityMutant) {
        jytp jytp2;
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        zxbe zxbe2 = (zxbe)entityMutant.getAnimationHandler().ctx._u_();
        if (zxbe2 == null) {
            return null;
        }
        zxbe zxbe3 = zxbe2;
        uhrn uhrn2 = zxbe3._a(MutantAnimationHandler.clipLayer).get(0);
        if (!(uhrn2 instanceof jytp)) {
            uhrn2 = null;
        }
        jytp jytp3 = jytp2 = (jytp)uhrn2;
        this._c = jytp3 != null ? jytp3._c : 0.0f;
        Object object = jytp2;
        if (object == null || (object = ((jytp)object)._a) == null) {
            object = "";
        }
        this._d = object;
        return this;
    }

    @Override
    @NotNull
    protected ugqx _b(@NotNull EntityMutant entityMutant) {
        Intrinsics.checkParameterIsNotNull(entityMutant, "entity");
        String string = owkq._a(this._d);
        pidb pidb2 = _b._a().get(entityMutant.getClass());
        if (pidb2 == null) {
            throw (Throwable)new IllegalStateException("No trace skin helper found for mutant class " + entityMutant.getClass() + " with name " + entityMutant.getEntityName() + '!');
        }
        pidb pidb3 = pidb2;
        if (string != null) {
            jytp jytp2 = new jytp(pidb3._a(), string);
            jytp2._c = owkq._b(this._c, 0.0f, 1.0f);
            pidb3._a(jytp2);
        }
        pidb3._a((float)entityMutant.posX, (float)entityMutant.posY, (float)entityMutant.posZ, entityMutant.rotationYaw, entityMutant.getProperties().getCommon().getScale());
        return ugqx._a._a(pidb3);
    }

    @Override
    public /* synthetic */ ugqx _c(Entity entity) {
        return this._b((EntityMutant)entity);
    }

    static {
        Iterable iterable;
        _b = new kjui(null);
        Iterable iterable2 = iterable = (Iterable)MutantRegistry.INSTANCE.getRegisteredMobs().entrySet();
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            Map.Entry entry = (Map.Entry)t;
            Collection collection2 = collection;
            Map.Entry entry2 = entry;
            String string = (String)entry2.getKey();
            entry2 = entry;
            Class clazz = (Class)entry2.getValue();
            String string2 = string;
            Intrinsics.checkExpressionValueIsNotNull(string2, "name");
            Pair<Class, pidb> pair = TuplesKt.to(clazz, new pidb(string2));
            collection2.add(pair);
        }
        _e = MapsKt.toMap((List)collection);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderMutant$TraceMeshMutant;", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "mutantId", "", "(Ljava/lang/String;)V", "getMutantId", "()Ljava/lang/String;", "createModel", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "minecraft"})
    private static final class pidb
    extends eidj {
        @NotNull
        private final String _b;

        @Override
        @NotNull
        public rpms _c() {
            return new rpms(new ResourceLocation("gloomycore", "colliders/" + this._b + "/collider.mcvd"));
        }

        @NotNull
        public final String _d() {
            return this._b;
        }

        public pidb(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "mutantId");
            this._b = string;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderMutant$Companion;", "", "()V", "traceModels", "", "Ljava/lang/Class;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderMutant$TraceMeshMutant;", "getTraceModels", "()Ljava/util/Map;", "minecraft"})
    private static final class kjui {
        @NotNull
        public final Map<Class<? extends EntityMutant>, pidb> _a() {
            return _e;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

