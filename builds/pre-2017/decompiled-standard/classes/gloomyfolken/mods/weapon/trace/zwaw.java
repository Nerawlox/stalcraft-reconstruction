/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.weapon.trace.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderBiped;", "T", "Lnet/minecraft/entity/Entity;", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilder;", "()V", "PACK_TO_BYTES", "", "PI2", "", "offsetX", "", "getOffsetX", "()F", "setOffsetX", "(F)V", "offsetY", "getOffsetY", "setOffsetY", "offsetZ", "getOffsetZ", "setOffsetZ", "readUnpackAngle", "input", "Ljava/io/DataInput;", "writePackAngle", "", "f", "output", "Ljava/io/DataOutput;", "minecraft"})
public abstract class zwaw<T extends Entity>
extends ezey<T> {
    private final double _b = Math.PI * 2;
    private final boolean _c = true;
    private float _d;
    private float _e;
    private float _f;

    protected final float _e() {
        return this._d;
    }

    protected final void _a(float f) {
        this._d = f;
    }

    protected final float _f() {
        return this._e;
    }

    protected final void _b(float f) {
        this._e = f;
    }

    protected final float _g() {
        return this._f;
    }

    protected final void _c(float f) {
        this._f = f;
    }

    protected final void _a(float f, @NotNull DataOutput dataOutput) {
        Intrinsics.checkParameterIsNotNull(dataOutput, "output");
        if (this._c) {
            double d = (double)f % this._b;
            if (d > (double)owkq._a()) {
                d -= this._b;
            } else if (d < (double)owkq._a()) {
                d += this._b;
            }
            dataOutput.writeByte((int)(d / this._b * (double)255 - (double)128));
        } else {
            dataOutput.writeFloat(f);
        }
    }

    protected final float _b(@NotNull DataInput dataInput) {
        Intrinsics.checkParameterIsNotNull(dataInput, "input");
        return this._c ? (float)((double)(dataInput.readByte() + 128) / 255.0 * this._b) : dataInput.readFloat();
    }
}

