/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

public final class PackageData {
    @NotNull
    private final NameResolver nameResolver;
    @NotNull
    private final ProtoBuf.Package packageProto;

    @NotNull
    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @NotNull
    public final ProtoBuf.Package getPackageProto() {
        return this.packageProto;
    }

    public PackageData(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Package packageProto) {
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(packageProto, "packageProto");
        this.nameResolver = nameResolver;
        this.packageProto = packageProto;
    }

    @NotNull
    public final NameResolver component1() {
        return this.nameResolver;
    }

    @NotNull
    public final ProtoBuf.Package component2() {
        return this.packageProto;
    }

    @NotNull
    public final PackageData copy(@NotNull NameResolver nameResolver, @NotNull ProtoBuf.Package packageProto) {
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(packageProto, "packageProto");
        return new PackageData(nameResolver, packageProto);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ PackageData copy$default(PackageData packageData, NameResolver nameResolver, ProtoBuf.Package package_, int n, Object object) {
        if ((n & 1) != 0) {
            nameResolver = packageData.nameResolver;
        }
        if ((n & 2) != 0) {
            package_ = packageData.packageProto;
        }
        return packageData.copy(nameResolver, package_);
    }

    public String toString() {
        return "PackageData(nameResolver=" + this.nameResolver + ", packageProto=" + this.packageProto + ")";
    }

    public int hashCode() {
        NameResolver nameResolver = this.nameResolver;
        ProtoBuf.Package package_ = this.packageProto;
        return (nameResolver != null ? nameResolver.hashCode() : 0) * 31 + (package_ != null ? package_.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof PackageData)) break block3;
                PackageData packageData = (PackageData)object;
                if (!Intrinsics.areEqual(this.nameResolver, packageData.nameResolver) || !Intrinsics.areEqual(this.packageProto, packageData.packageProto)) break block3;
            }
            return true;
        }
        return false;
    }
}

