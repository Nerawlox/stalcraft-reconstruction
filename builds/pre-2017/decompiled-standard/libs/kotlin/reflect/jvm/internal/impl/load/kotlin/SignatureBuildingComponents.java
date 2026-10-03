/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;

public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE;

    @NotNull
    public final String javaLang(@NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return "java/lang/" + name2;
    }

    @NotNull
    public final String javaUtil(@NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return "java/util/" + name2;
    }

    @NotNull
    public final String javaFunction(@NotNull String name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return "java/util/function/" + name2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String[] constructors(String ... signatures) {
        void $receiver$iv$iv;
        Object $receiver$iv;
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        Object[] objectArray = $receiver$iv = (Object[])signatures;
        Collection destination$iv$iv = new ArrayList(((Object[])$receiver$iv).length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void it;
            void item$iv$iv = $receiver$iv$iv[i];
            String string = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            String string2 = "<init>(" + (String)it + ")V";
            collection.add(string2);
        }
        $receiver$iv = (List)destination$iv$iv;
        Collection thisCollection$iv = (Collection)$receiver$iv;
        String[] stringArray = thisCollection$iv.toArray(new String[thisCollection$iv.size()]);
        if (stringArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return (String[])((Object[])stringArray);
    }

    @NotNull
    public final LinkedHashSet<String> inJavaLang(@NotNull String name2, String ... signatures) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        return this.inClass(this.javaLang(name2), Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final LinkedHashSet<String> inJavaUtil(@NotNull String name2, String ... signatures) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        return this.inClass(this.javaUtil(name2), Arrays.copyOf(signatures, signatures.length));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final LinkedHashSet<String> inClass(@NotNull String internalName, String ... signatures) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(internalName, "internalName");
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        Object[] objectArray = signatures;
        Collection destination$iv = new LinkedHashSet();
        for (int i = 0; i < ((void)$receiver$iv).length; ++i) {
            void it;
            void item$iv = $receiver$iv[i];
            String string = (String)item$iv;
            Collection collection = destination$iv;
            String string2 = internalName + "." + (String)it;
            collection.add(string2);
        }
        return (LinkedHashSet)destination$iv;
    }

    @NotNull
    public final String signature(@NotNull ClassDescriptor classDescriptor, @NotNull String jvmDescriptor2) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        Intrinsics.checkParameterIsNotNull(jvmDescriptor2, "jvmDescriptor");
        return this.signature(MethodSignatureMappingKt.getInternalName(classDescriptor), jvmDescriptor2);
    }

    @NotNull
    public final String signature(@NotNull ClassId classId, @NotNull String jvmDescriptor2) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        Intrinsics.checkParameterIsNotNull(jvmDescriptor2, "jvmDescriptor");
        return this.signature(MethodSignatureMappingKt.getInternalName(classId), jvmDescriptor2);
    }

    @NotNull
    public final String signature(@NotNull String internalName, @NotNull String jvmDescriptor2) {
        Intrinsics.checkParameterIsNotNull(internalName, "internalName");
        Intrinsics.checkParameterIsNotNull(jvmDescriptor2, "jvmDescriptor");
        return internalName + "." + jvmDescriptor2;
    }

    @NotNull
    public final String jvmDescriptor(@NotNull String name2, @NotNull String[] parameters2, @NotNull String ret) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        Intrinsics.checkParameterIsNotNull(ret, "ret");
        return this.jvmDescriptor(name2, ArraysKt.asList((Object[])parameters2), ret);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String jvmDescriptor$default(SignatureBuildingComponents signatureBuildingComponents, String string, String[] stringArray, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = "V";
        }
        return signatureBuildingComponents.jvmDescriptor(string, stringArray, string2);
    }

    @NotNull
    public final String jvmDescriptor(@NotNull String name2, @NotNull List<String> parameters2, @NotNull String ret) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        Intrinsics.checkParameterIsNotNull(ret, "ret");
        return name2 + "(" + CollectionsKt.joinToString$default(parameters2, "", null, null, 0, null, jvmDescriptor.1.INSTANCE, 30, null) + ")" + this.escapeClassName(ret);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String jvmDescriptor$default(SignatureBuildingComponents signatureBuildingComponents, String string, List list, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = "V";
        }
        return signatureBuildingComponents.jvmDescriptor(string, list, string2);
    }

    private final String escapeClassName(String internalName) {
        return internalName.length() > 1 ? "L" + internalName + ";" : internalName;
    }

    private SignatureBuildingComponents() {
        INSTANCE = this;
    }

    static {
        new SignatureBuildingComponents();
    }

    @NotNull
    public static final /* synthetic */ String access$escapeClassName(SignatureBuildingComponents $this, @NotNull String internalName) {
        return $this.escapeClassName(internalName);
    }
}

