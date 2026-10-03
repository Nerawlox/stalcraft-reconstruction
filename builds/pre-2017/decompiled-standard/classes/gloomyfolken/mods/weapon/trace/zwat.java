/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.weapon.trace.ezey;
import gloomyfolken.mods.weapon.trace.ugqx;
import gloomyfolken.mods.weapon.trace.zwaw;
import java.io.DataInput;
import java.io.DataOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0017J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderBag;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderBiped;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBag;", "()V", "buildTraceResultInternal", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "entity", "read", "", "input", "Ljava/io/DataInput;", "setFromClientEntity", "write", "output", "Ljava/io/DataOutput;", "minecraft"})
public final class zwat
extends zwaw<EntityCorpseBag> {
    @Override
    public void _a(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
    }

    @Override
    public void _a(@NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
    }

    @NotNull
    protected ugqx _a(@NotNull EntityCorpseBag entityCorpseBag) {
        Intrinsics.checkParameterIsNotNull(entityCorpseBag, "entity");
        return ugqx._a._d();
    }

    @Override
    public /* synthetic */ ugqx _c(Entity entity) {
        return this._a((EntityCorpseBag)entity);
    }

    @gloomyfolken.bundle.common.core.ezey(_a={eidj.CLIENT})
    @NotNull
    public zwat _b(@NotNull EntityCorpseBag entityCorpseBag) {
        Intrinsics.checkParameterIsNotNull(entityCorpseBag, "entity");
        return this;
    }

    @Override
    public /* synthetic */ ezey _a(Entity entity) {
        return this._b((EntityCorpseBag)entity);
    }
}

