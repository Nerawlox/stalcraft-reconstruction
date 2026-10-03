/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B/\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0006\u0010\u0018\u001a\u00020\u0000J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00d6\u0001J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2={"Lgloomyfolken/bundle/common/utils/ItemStackData;", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "itemStack", "Lnet/minecraft/item/ItemStack;", "(Lnet/minecraft/item/ItemStack;)V", "itemID", "", "stackSize", "itemDamage", "stackTagCompound", "(IIILnet/minecraft/nbt/NBTTagCompound;)V", "getItemDamage", "()I", "getItemID", "getStackSize", "getStackTagCompound", "()Lnet/minecraft/nbt/NBTTagCompound;", "component1", "component2", "component3", "component4", "copy", "copyWithStackSize", "equals", "", "other", "hashCode", "toItemStack", "toString", "", "writeToNBT", "minecraft"})
public final class wnce {
    private final int _a;
    private final int _b;
    private final int _c;
    @Nullable
    private final qoac _d;

    @NotNull
    public final qoac _a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        qoac2._a("id", (short)this._a);
        qoac2._a("Count", (byte)this._b);
        qoac2._a("Count_i", this._b);
        qoac2._a("Damage", (short)this._c);
        if (this._d != null) {
            qoac2._a("tag", (huhy)this._d);
        }
        qoac2._a("Count", (byte)this._b);
        return qoac2;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    @Nullable
    public final cvzo _a() {
        cvzo cvzo2 = new cvzo(this._a, this._b, this._c);
        if (cvzo2._a() == null) {
            return null;
        }
        cvzo2._e = this._d;
        return cvzo2;
    }

    @NotNull
    public final wnce _b() {
        return wnce._a(this, this._a, 0, 0, null, 14, null);
    }

    @NotNull
    public final wnce _a(int n) {
        return wnce._a(this, 0, n, 0, null, 13, null);
    }

    @NotNull
    public String toString() {
        return String.valueOf(this._b) + "x" + this._a + "@" + this._c;
    }

    public final int _c() {
        return this._a;
    }

    public final int _d() {
        return this._b;
    }

    public final int _e() {
        return this._c;
    }

    @Nullable
    public final qoac _f() {
        return this._d;
    }

    @JvmOverloads
    public wnce(int n, int n2, int n3, @Nullable qoac qoac2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = qoac2;
    }

    @JvmOverloads
    public /* synthetic */ wnce(int n, int n2, int n3, qoac qoac2, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 2) != 0) {
            n2 = 1;
        }
        if ((n4 & 4) != 0) {
            n3 = 0;
        }
        if ((n4 & 8) != 0) {
            qoac2 = null;
        }
        this(n, n2, n3, qoac2);
    }

    @JvmOverloads
    public wnce(int n, int n2, int n3) {
        this(n, n2, n3, null, 8, null);
    }

    @JvmOverloads
    public wnce(int n, int n2) {
        this(n, n2, 0, null, 12, null);
    }

    @JvmOverloads
    public wnce(int n) {
        this(n, 0, 0, null, 14, null);
    }

    public wnce(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        this(qoac2._e("id"), qoac2._c("Count_i") ? qoac2._f("Count_i") : (int)qoac2._d("Count"), Math.max(0, qoac2._e("Damage")), qoac2._c("tag") ? qoac2._m("tag") : null);
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public wnce(@NotNull cvzo cvzo2) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "itemStack");
        this(cvzo2._d, cvzo2._b, cvzo2._f, cvzo2._e);
    }

    public final int _g() {
        return this._a;
    }

    public final int _h() {
        return this._b;
    }

    public final int _i() {
        return this._c;
    }

    @Nullable
    public final qoac _j() {
        return this._d;
    }

    @NotNull
    public final wnce _a(int n, int n2, int n3, @Nullable qoac qoac2) {
        return new wnce(n, n2, n3, qoac2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ wnce _a(wnce wnce2, int n, int n2, int n3, qoac qoac2, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n = wnce2._a;
        }
        if ((n4 & 2) != 0) {
            n2 = wnce2._b;
        }
        if ((n4 & 4) != 0) {
            n3 = wnce2._c;
        }
        if ((n4 & 8) != 0) {
            qoac2 = wnce2._d;
        }
        return wnce2._a(n, n2, n3, qoac2);
    }

    public int hashCode() {
        qoac qoac2 = this._d;
        return ((Integer.hashCode(this._a) * 31 + Integer.hashCode(this._b)) * 31 + Integer.hashCode(this._c)) * 31 + (qoac2 != null ? ((Object)qoac2).hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof wnce)) break block3;
                wnce wnce2 = (wnce)object;
                if (!(this._a == wnce2._a) || !(this._b == wnce2._b) || !(this._c == wnce2._c) || !Intrinsics.areEqual(this._d, wnce2._d)) break block3;
            }
            return true;
        }
        return false;
    }
}

