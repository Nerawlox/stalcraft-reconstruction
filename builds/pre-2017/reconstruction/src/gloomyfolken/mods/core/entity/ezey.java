/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.mods.core.misc.pibn;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/core/entity/EntityBasicStateHolder;", "T", "Lnet/minecraft/entity/EntityLivingBase;", "Lgloomyfolken/mods/core/misc/IWorldStatePart;", "entity", "(Lnet/minecraft/entity/EntityLivingBase;)V", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "Lnet/minecraft/entity/EntityLivingBase;", "pitch", "", "pos", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "yaw", "apply", "", "save", "minecraft"})
public class ezey<T extends EntityLivingBase>
implements pibn {
    private final Vec3 _a;
    private float _b;
    private float _c;
    @NotNull
    private final T _d;

    @Override
    public void _a() {
        VecExtensionsKt.set(this._a, McExtensionsKt.getPos((Entity)this._d));
        this._b = ((Entity)this._d).rotationYaw;
        this._c = ((Entity)this._d).rotationPitch;
    }

    @Override
    public void _b() {
        ((Entity)this._d).setPositionAndRotation(this._a._c, this._a._d, this._a._e, this._b, this._c);
    }

    @NotNull
    public final T _c() {
        return this._d;
    }

    public ezey(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "entity");
        this._d = t;
        this._a = VecExtensionsKt.vec3();
    }
}

