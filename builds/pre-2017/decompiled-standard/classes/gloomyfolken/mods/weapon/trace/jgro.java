/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.misc.samo;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.entity.EntityNPCHumanMale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0017J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderCorpse;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "()V", "buildTraceResultInternal", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "read", "", "input", "Ljava/io/DataInput;", "setFromClientEntity", "write", "output", "Ljava/io/DataOutput;", "Companion", "NpcMeshRegister", "TraceMeshCorpse", "minecraft"})
public final class jgro
extends ezey<EntityRagdollCorpse> {
    @NotNull
    private static final samo<Entity, eidj> _c;
    public static final kjui _b;

    @Override
    public void _a(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
    }

    @Override
    public void _a(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @Nullable
    public jgro _a(@NotNull EntityRagdollCorpse entityRagdollCorpse) {
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "entity");
        return this;
    }

    @Override
    @NotNull
    protected ugqx _b(final @NotNull EntityRagdollCorpse entityRagdollCorpse) {
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "entity");
        if (!entityRagdollCorpse.field_70170_p.field_72995_K) {
            return ugqx._a._d();
        }
        Object t = InvokeWithResult.client(new InvokeWithResult.InvokeClientOnly<T>(){

            @Override
            public /* synthetic */ Object run() {
                return this._a();
            }

            @NotNull
            public final ugqx _a() {
                nuct nuct2;
                eidj eidj2 = _b._a()._a(entityRagdollCorpse.getCorpseOwnerClass());
                if (eidj2 == null) {
                    throw (Throwable)new IllegalStateException("No trace skin helper found for corpse class " + entityRagdollCorpse.getClass() + " with name " + entityRagdollCorpse.func_70023_ak() + '!');
                }
                eidj eidj3 = eidj2;
                CorpseAnimationHandler corpseAnimationHandler = entityRagdollCorpse.getAnimationHandler();
                nuct nuct3 = nuct2 = corpseAnimationHandler != null ? corpseAnimationHandler.getCtx() : null;
                if (nuct2 != null) {
                    uhrn uhrn2 = nuct2._a(CorpseAnimationHandler.Companion.getAnimationLayer()).get(0);
                    Intrinsics.checkExpressionValueIsNotNull(uhrn2, "ctx.getPlayingAnimations\u2026andler.animationLayer)[0]");
                    eidj3._a(uhrn2);
                }
                eidj3._a((float)entityRagdollCorpse.field_70165_t, (float)entityRagdollCorpse.field_70163_u, (float)entityRagdollCorpse.field_70161_v, 0.0f, entityRagdollCorpse.getOwnerScale());
                return ugqx._a._a(eidj3);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(t, "InvokeWithResult.client \u2026HIT(traceModel)\n        }");
        return (ugqx)t;
    }

    @Override
    public /* synthetic */ ugqx _c(Entity entity) {
        return this._b((EntityRagdollCorpse)entity);
    }

    static {
        Iterable iterable;
        _b = new kjui(null);
        _c = new samo(Entity.class);
        Iterable iterable2 = iterable = (Iterable)MutantRegistry.INSTANCE.getRegisteredMobs().entrySet();
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object t : iterable2) {
            Map.Entry entry = (Map.Entry)t;
            Collection collection2 = collection;
            Map.Entry entry2 = entry;
            String string = (String)entry2.getKey();
            entry2 = entry;
            Class clazz = (Class)entry2.getValue();
            samo<Entity, eidj> samo2 = _b._a();
            String string2 = string;
            Intrinsics.checkExpressionValueIsNotNull(string2, "name");
            samo2._a(clazz, new eidj(string2));
            Unit unit = Unit.INSTANCE;
            collection2.add(unit);
        }
        List cfr_ignored_0 = (List)collection;
        _b._a()._a(EntityPlayer.class, new eidj("steve"));
        if (ModLoader.isModLoaded("customnpcs")) {
            pidb._a._a();
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderCorpse$TraceMeshCorpse;", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "entityId", "", "(Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "createModel", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "minecraft"})
    private static final class eidj
    extends gloomyfolken.mods.weapon.trace.eidj {
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

        public eidj(@NotNull String string) {
            Intrinsics.checkParameterIsNotNull(string, "entityId");
            this._b = string;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderCorpse$NpcMeshRegister;", "", "()V", "register", "", "minecraft"})
    public static final class pidb {
        public static final pidb _a;

        public final void _a() {
            _b._a()._a(EntityNPCHumanMale.class, new eidj("steve"));
        }

        private pidb() {
            _a = this;
        }

        static {
            new pidb();
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderCorpse$Companion;", "", "()V", "traceModels", "Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "Lnet/minecraft/entity/Entity;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderCorpse$TraceMeshCorpse;", "getTraceModels", "()Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "minecraft"})
    private static final class kjui {
        @NotNull
        public final samo<Entity, eidj> _a() {
            return _c;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

