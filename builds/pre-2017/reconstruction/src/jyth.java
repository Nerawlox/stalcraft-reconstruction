/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class jyth<T extends uytm>
extends hsnd<T> {
    public final ResourceLocation _b;

    public jyth(@NotNull ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            jyth._a(0);
        }
        this._b = resourceLocation;
    }

    public static jyth _a(@NotNull ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            jyth._a(1);
        }
        return uhrd._a()._a(resourceLocation);
    }

    public boolean _p() {
        return uyvo._d(this._b);
    }

    @Override
    protected void _d() {
        T t = this._f();
        ((uytm)t).onLoaded(() -> this._a(t, oxca.kjui._c));
        ((uytm)t).onBroken(() -> this._a(null, oxca.kjui._d));
        this._a(t);
    }

    protected T _f() {
        return (T)uhrd._a()._b(this._b);
    }

    @Override
    protected void _a(T t) {
        ((uytm)t).load(true);
    }

    protected void _b(T t) {
        ((uytm)t).release();
    }

    public String toString() {
        return "{DynamicResourceReference to " + this._b + "}";
    }

    @Override
    protected /* synthetic */ void _a(Object object) {
        this._b((uytm)object);
    }

    private static /* synthetic */ void _a(int n) {
        Object[] objectArray;
        Object[] objectArray2 = new Object[3];
        objectArray2[0] = "resourceLocation";
        objectArray2[1] = "gloomyfolken/mods/effects/common/loaders/DynamicResourceReference";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "<init>";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "create";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

