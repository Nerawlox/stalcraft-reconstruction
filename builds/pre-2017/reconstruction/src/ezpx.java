/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u001d\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fH\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0010H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0011H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0012H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0013H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0014H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0086\u0002\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0086\u0002\u00a8\u0006\u0015"}, d2={"contains", "", "Lnet/minecraft/nbt/NBTTagCompound;", "name", "", "get", "Lnet/minecraft/nbt/NBTBase;", "kotlin.jvm.PlatformType", "Lnet/minecraft/nbt/NBTTagList;", "i", "", "set", "", "value", "", "", "", "", "", "", "", "minecraft"})
public final class ezpx {
    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull NBTBase nBTBase) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(nBTBase, "value");
        nBTTagCompound._a(string, nBTBase);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, byte by) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, by);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, short s) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, s);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, int n) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, n);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, long l) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, l);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, float f) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, f);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, double d) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, d);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "value");
        nBTTagCompound._a(string, string2);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull byte[] byArray) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(byArray, "value");
        nBTTagCompound._a(string, byArray);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull int[] nArray) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(nArray, "value");
        nBTTagCompound._a(string, nArray);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull NBTTagCompound nBTTagCompound2) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(nBTTagCompound2, "value");
        nBTTagCompound._a(string, nBTTagCompound2);
    }

    public static final void _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, boolean bl) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        nBTTagCompound._a(string, bl);
    }

    public static final boolean _a(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "name");
        return nBTTagCompound._c(string);
    }

    public static final NBTBase _a(@NotNull NBTTagList nBTTagList, int n) {
        Intrinsics.checkParameterIsNotNull(nBTTagList, "$receiver");
        return nBTTagList._b(n);
    }
}

