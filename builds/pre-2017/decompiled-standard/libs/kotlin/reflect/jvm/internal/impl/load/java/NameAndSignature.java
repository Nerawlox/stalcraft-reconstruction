/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class NameAndSignature {
    @NotNull
    private final Name name;
    @NotNull
    private final String signature;

    @NotNull
    public final Name getName() {
        return this.name;
    }

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    public NameAndSignature(@NotNull Name name2, @NotNull String signature2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        this.name = name2;
        this.signature = signature2;
    }

    @NotNull
    public final Name component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.signature;
    }

    @NotNull
    public final NameAndSignature copy(@NotNull Name name2, @NotNull String signature2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        return new NameAndSignature(name2, signature2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ NameAndSignature copy$default(NameAndSignature nameAndSignature, Name name2, String string, int n, Object object) {
        if ((n & 1) != 0) {
            name2 = nameAndSignature.name;
        }
        if ((n & 2) != 0) {
            string = nameAndSignature.signature;
        }
        return nameAndSignature.copy(name2, string);
    }

    public String toString() {
        return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ")";
    }

    public int hashCode() {
        Name name2 = this.name;
        String string = this.signature;
        return (name2 != null ? ((Object)name2).hashCode() : 0) * 31 + (string != null ? string.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof NameAndSignature)) break block3;
                NameAndSignature nameAndSignature = (NameAndSignature)object;
                if (!Intrinsics.areEqual(this.name, nameAndSignature.name) || !Intrinsics.areEqual(this.signature, nameAndSignature.signature)) break block3;
            }
            return true;
        }
        return false;
    }
}

