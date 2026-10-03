/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class MemberSignature {
    @NotNull
    private final String signature;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final String getSignature$kotlin_core() {
        return this.signature;
    }

    private MemberSignature(String signature2) {
        this.signature = signature2;
    }

    public /* synthetic */ MemberSignature(@NotNull String signature2, DefaultConstructorMarker $constructor_marker) {
        this(signature2);
    }

    @NotNull
    public final String component1$kotlin_core() {
        return this.signature;
    }

    @NotNull
    public final MemberSignature copy(@NotNull String signature2) {
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        return new MemberSignature(signature2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ MemberSignature copy$default(MemberSignature memberSignature, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = memberSignature.signature;
        }
        return memberSignature.copy(string);
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ")";
    }

    public int hashCode() {
        String string = this.signature;
        return string != null ? string.hashCode() : 0;
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof MemberSignature)) break block3;
                MemberSignature memberSignature = (MemberSignature)object;
                if (!Intrinsics.areEqual(this.signature, memberSignature.signature)) break block3;
            }
            return true;
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final MemberSignature fromMethod(@NotNull NameResolver nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature signature2) {
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        return Companion.fromMethod(nameResolver, signature2);
    }

    @JvmStatic
    @NotNull
    public static final MemberSignature fromMethodNameAndDesc(@NotNull String name2, @NotNull String desc) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return Companion.fromMethodNameAndDesc(name2, desc);
    }

    @JvmStatic
    @NotNull
    public static final MemberSignature fromMethodNameAndDesc(@NotNull String namePlusDesc) {
        Intrinsics.checkParameterIsNotNull(namePlusDesc, "namePlusDesc");
        return Companion.fromMethodNameAndDesc(namePlusDesc);
    }

    @JvmStatic
    @NotNull
    public static final MemberSignature fromFieldNameAndDesc(@NotNull String name2, @NotNull String desc) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return Companion.fromFieldNameAndDesc(name2, desc);
    }

    @JvmStatic
    @NotNull
    public static final MemberSignature fromMethodSignatureAndParameterIndex(@NotNull MemberSignature signature2, int index) {
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        return Companion.fromMethodSignatureAndParameterIndex(signature2, index);
    }

    public static final class Companion {
        @JvmStatic
        @NotNull
        public final MemberSignature fromMethod(@NotNull NameResolver nameResolver, @NotNull JvmProtoBuf.JvmMethodSignature signature2) {
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            String string = nameResolver.getString(signature2.getName());
            Intrinsics.checkExpressionValueIsNotNull(string, "nameResolver.getString(signature.name)");
            String string2 = nameResolver.getString(signature2.getDesc());
            Intrinsics.checkExpressionValueIsNotNull(string2, "nameResolver.getString(signature.desc)");
            return this.fromMethodNameAndDesc(string, string2);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethodNameAndDesc(@NotNull String name2, @NotNull String desc) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(desc, "desc");
            return new MemberSignature(name2 + desc, null);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethodNameAndDesc(@NotNull String namePlusDesc) {
            Intrinsics.checkParameterIsNotNull(namePlusDesc, "namePlusDesc");
            return new MemberSignature(namePlusDesc, null);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromFieldNameAndDesc(@NotNull String name2, @NotNull String desc) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(desc, "desc");
            return new MemberSignature(name2 + "#" + desc, null);
        }

        @JvmStatic
        @NotNull
        public final MemberSignature fromMethodSignatureAndParameterIndex(@NotNull MemberSignature signature2, int index) {
            Intrinsics.checkParameterIsNotNull(signature2, "signature");
            return new MemberSignature(signature2.getSignature$kotlin_core() + "@" + index, null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

