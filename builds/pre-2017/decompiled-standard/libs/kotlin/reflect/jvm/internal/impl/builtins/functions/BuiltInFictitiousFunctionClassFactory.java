/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInFictitiousFunctionClassFactory
implements ClassDescriptorFactory {
    private final StorageManager storageManager;
    private final ModuleDescriptor module;
    public static final Companion Companion = new Companion(null);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        String string = name2.asString();
        if (!StringsKt.startsWith$default(string, "Function", false, 2, null)) {
            if (!StringsKt.startsWith$default(string, "KFunction", false, 2, null)) return false;
        }
        String string2 = string;
        Intrinsics.checkExpressionValueIsNotNull(string2, "string");
        if (BuiltInFictitiousFunctionClassFactory.Companion.parseClassName(string2, packageFqName) == null) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        void arity;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        void kind;
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String className = classId.getRelativeClassName().asString();
        if (StringsKt.contains$default((CharSequence)className, "Function", false, 2, null) ^ true) {
            return null;
        }
        FqName packageFqName = classId.getPackageFqName();
        String string = className;
        Intrinsics.checkExpressionValueIsNotNull(string, "className");
        FqName fqName2 = packageFqName;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "packageFqName");
        KindWithArity kindWithArity = BuiltInFictitiousFunctionClassFactory.Companion.parseClassName(string, fqName2);
        if (kindWithArity == null) {
            return null;
        }
        KindWithArity kindWithArity2 = kindWithArity;
        FunctionClassDescriptor.Kind kind2 = kindWithArity2.component1();
        int n = kindWithArity2.component2();
        kindWithArity2 = null;
        if (Intrinsics.areEqual(kind, (Object)FunctionClassDescriptor.Kind.SuspendFunction)) {
            return null;
        }
        FqName fqName3 = packageFqName;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "packageFqName");
        Iterable iterable = $receiver$iv = (Iterable)this.module.getPackage(fqName3).getFragments();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof BuiltInsPackageFragment)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        BuiltInsPackageFragment containingPackageFragment = (BuiltInsPackageFragment)CollectionsKt.first((List)destination$iv$iv);
        return new FunctionClassDescriptor(this.storageManager, containingPackageFragment, (FunctionClassDescriptor.Kind)kind, (int)arity);
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return SetsKt.emptySet();
    }

    public BuiltInFictitiousFunctionClassFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @JvmStatic
    @Nullable
    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull String className, @NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return Companion.getFunctionalClassKind(className, packageFqName);
    }

    @JvmStatic
    @Nullable
    public static final Integer getFunctionalClassArity(@NotNull String className, @NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return Companion.getFunctionalClassArity(className, packageFqName);
    }

    @JvmStatic
    public static final boolean isFunctionClassName(@NotNull String className, @NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return Companion.isFunctionClassName(className, packageFqName);
    }

    @JvmStatic
    public static final boolean isSuspendFunctionClassName(@NotNull String className, @NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        return Companion.isSuspendFunctionClassName(className, packageFqName);
    }

    private static final class KindWithArity {
        @NotNull
        private final FunctionClassDescriptor.Kind kind;
        private final int arity;

        @NotNull
        public final FunctionClassDescriptor.Kind getKind() {
            return this.kind;
        }

        public final int getArity() {
            return this.arity;
        }

        public KindWithArity(@NotNull FunctionClassDescriptor.Kind kind, int arity) {
            Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
            this.kind = kind;
            this.arity = arity;
        }

        @NotNull
        public final FunctionClassDescriptor.Kind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        @NotNull
        public final KindWithArity copy(@NotNull FunctionClassDescriptor.Kind kind, int arity) {
            Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
            return new KindWithArity(kind, arity);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ KindWithArity copy$default(KindWithArity kindWithArity, FunctionClassDescriptor.Kind kind, int n, int n2, Object object) {
            if ((n2 & 1) != 0) {
                kind = kindWithArity.kind;
            }
            if ((n2 & 2) != 0) {
                n = kindWithArity.arity;
            }
            return kindWithArity.copy(kind, n);
        }

        public String toString() {
            return "KindWithArity(kind=" + (Object)((Object)this.kind) + ", arity=" + this.arity + ")";
        }

        public int hashCode() {
            FunctionClassDescriptor.Kind kind = this.kind;
            return (kind != null ? ((Object)((Object)kind)).hashCode() : 0) * 31 + this.arity;
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof KindWithArity)) break block3;
                    KindWithArity kindWithArity = (KindWithArity)object;
                    if (!Intrinsics.areEqual((Object)this.kind, (Object)kindWithArity.kind) || !(this.arity == kindWithArity.arity)) break block3;
                }
                return true;
            }
            return false;
        }
    }

    public static final class Companion {
        private final KindWithArity parseClassName(String className, FqName packageFqName) {
            FunctionClassDescriptor.Kind kind = FunctionClassDescriptor.Kind.Companion.byClassNamePrefix(packageFqName, className);
            if (kind == null) {
                return null;
            }
            FunctionClassDescriptor.Kind kind2 = kind;
            String prefix = kind2.getClassNamePrefix();
            String string = className;
            int n = prefix.length();
            Companion companion = this;
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            String string4 = string3;
            Integer n2 = companion.toInt(string4);
            if (n2 == null) {
                return null;
            }
            int arity = n2;
            return new KindWithArity(kind2, arity);
        }

        @JvmStatic
        @Nullable
        public final FunctionClassDescriptor.Kind getFunctionalClassKind(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            KindWithArity kindWithArity = this.parseClassName(className, packageFqName);
            return kindWithArity != null ? kindWithArity.getKind() : null;
        }

        @JvmStatic
        @Nullable
        public final Integer getFunctionalClassArity(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            KindWithArity kindWithArity = this.parseClassName(className, packageFqName);
            return kindWithArity != null ? Integer.valueOf(kindWithArity.getArity()) : null;
        }

        @JvmStatic
        public final boolean isFunctionClassName(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            return Intrinsics.areEqual((Object)this.getFunctionalClassKind(className, packageFqName), (Object)FunctionClassDescriptor.Kind.Function);
        }

        @JvmStatic
        public final boolean isSuspendFunctionClassName(@NotNull String className, @NotNull FqName packageFqName) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            return Intrinsics.areEqual((Object)this.getFunctionalClassKind(className, packageFqName), (Object)FunctionClassDescriptor.Kind.SuspendFunction);
        }

        private final Integer toInt(String s) {
            CharSequence charSequence = s;
            if (charSequence.length() == 0) {
                return null;
            }
            int result2 = 0;
            CharIterator charIterator = StringsKt.iterator(s);
            while (charIterator.hasNext()) {
                char c = charIterator.nextChar();
                int d = c - 48;
                int n = d;
                if (0 > n || n > 9) {
                    return null;
                }
                result2 = result2 * 10 + d;
            }
            return result2;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

