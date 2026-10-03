/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageScope
extends LazyJavaStaticScope {
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    @NotNull
    private final LazyJavaPackageFragment ownerDescriptor;

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinClass) {
        ClassDescriptor descriptor2;
        KotlinClassLookupResult kotlinClassLookupResult = kotlinClass == null ? (KotlinClassLookupResult)KotlinClassLookupResult.NotFound.INSTANCE : (Intrinsics.areEqual((Object)kotlinClass.getClassHeader().getKind(), (Object)KotlinClassHeader.Kind.CLASS) ? ((descriptor2 = this.getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinClass)) != null ? (KotlinClassLookupResult)new KotlinClassLookupResult.Found(descriptor2) : (KotlinClassLookupResult)KotlinClassLookupResult.NotFound.INSTANCE) : (KotlinClassLookupResult)KotlinClassLookupResult.SyntheticClass.INSTANCE);
        return kotlinClassLookupResult;
    }

    @Override
    @Nullable
    public ClassDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.findClassifier(name2, null);
    }

    private final ClassDescriptor findClassifier(Name name2, JavaClass javaClass) {
        if (!SpecialNames.isSafeIdentifier(name2)) {
            return null;
        }
        Set knownClassNamesInPackage2 = (Set)this.knownClassNamesInPackage.invoke();
        if (javaClass == null && knownClassNamesInPackage2 != null && knownClassNamesInPackage2.contains(name2.asString()) ^ true) {
            return null;
        }
        return (ClassDescriptor)this.classes.invoke(new FindClassRequest(name2, javaClass));
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$kotlin_core(@NotNull JavaClass javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        return this.findClassifier(javaClass.getName(), javaClass);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    protected DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return SetsKt.emptySet();
        }
        Set knownClassNamesInPackage2 = (Set)this.knownClassNamesInPackage.invoke();
        if (knownClassNamesInPackage2 != null) {
            void $receiver$iv;
            Iterable iterable = knownClassNamesInPackage2;
            Collection destination$iv = new HashSet();
            for (Object item$iv : $receiver$iv) {
                void it;
                String string = (String)item$iv;
                Collection collection = destination$iv;
                Name name2 = Name.identifier((String)it);
                collection.add(name2);
            }
            return (Set)destination$iv;
        }
        Function1<Name, Boolean> function1 = nameFilter;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        Iterable $receiver$iv = this.jPackage.getClasses(function1);
        Collection destination$iv = new LinkedHashSet();
        Iterable $receiver$iv$iv = $receiver$iv;
        for (Object element$iv$iv : $receiver$iv$iv) {
            Name name3;
            Object element$iv = element$iv$iv;
            JavaClass klass = (JavaClass)element$iv;
            Name name4 = Intrinsics.areEqual((Object)klass.getLightClassOriginKind(), (Object)LightClassOriginKind.SOURCE) ? null : klass.getName();
            if (name4 == null) continue;
            Name it$iv = name3 = name4;
            destination$iv.add(it$iv);
        }
        return (Set)destination$iv;
    }

    @Override
    @NotNull
    protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        if (kindFilter.getExcludes().contains(SamConstructorDescriptorKindExclude.INSTANCE)) {
            return SetsKt.emptySet();
        }
        return this.computeClassNames(DescriptorKindFilter.CLASSIFIERS, nameFilter);
    }

    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result2, @NotNull Name name2) {
        block0: {
            SamConstructorDescriptor samConstructorDescriptor;
            Intrinsics.checkParameterIsNotNull(result2, "result");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            SamConstructorDescriptor samConstructorDescriptor2 = this.getC().getComponents().getSamConversionResolver().resolveSamConstructor(this.getOwnerDescriptor(), (Function0<? extends ClassifierDescriptor>)new Function0<ClassDescriptor>(this, name2){
                final /* synthetic */ LazyJavaPackageScope this$0;
                final /* synthetic */ Name $name;

                @Nullable
                public final ClassDescriptor invoke() {
                    return this.this$0.getContributedClassifier(this.$name, NoLookupLocation.FOR_ALREADY_TRACKED);
                }
                {
                    this.this$0 = lazyJavaPackageScope;
                    this.$name = name2;
                    super(0);
                }
            });
            if (samConstructorDescriptor2 == null) break block0;
            SamConstructorDescriptor it = samConstructorDescriptor = samConstructorDescriptor2;
            result2.add(it);
        }
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return this.computeDescriptors(kindFilter, nameFilter, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }

    @Override
    @NotNull
    protected LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaPackageScope(@NotNull LazyJavaResolverContext c, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment ownerDescriptor) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(jPackage, "jPackage");
        Intrinsics.checkParameterIsNotNull(ownerDescriptor, "ownerDescriptor");
        super(c);
        this.jPackage = jPackage;
        this.ownerDescriptor = ownerDescriptor;
        this.knownClassNamesInPackage = c.getStorageManager().createNullableLazyValue((Function0)new Function0<Set<? extends String>>(this, c){
            final /* synthetic */ LazyJavaPackageScope this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @Nullable
            public final Set<String> invoke() {
                return this.$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.getOwnerDescriptor().getFqName());
            }
            {
                this.this$0 = lazyJavaPackageScope;
                this.$c = lazyJavaResolverContext;
                super(0);
            }
        });
        this.classes = c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<FindClassRequest, ClassDescriptor>(this, c){
            final /* synthetic */ LazyJavaPackageScope this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @Nullable
            public final ClassDescriptor invoke(@NotNull FindClassRequest request) {
                ClassDescriptor classDescriptor;
                ClassId classId;
                KotlinJvmBinaryClass kotlinBinaryClass;
                Intrinsics.checkParameterIsNotNull(request, "request");
                ClassId requestClassId = new ClassId(this.this$0.getOwnerDescriptor().getFqName(), request.getName());
                KotlinJvmBinaryClass kotlinJvmBinaryClass = kotlinBinaryClass = request.getJavaClass() != null ? this.$c.getComponents().getKotlinClassFinder().findKotlinClass(request.getJavaClass()) : this.$c.getComponents().getKotlinClassFinder().findKotlinClass(requestClassId);
                ClassId classId2 = classId = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
                if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
                    return null;
                }
                KotlinClassLookupResult kotlinResult = LazyJavaPackageScope.access$resolveKotlinBinaryClass(this.this$0, kotlinBinaryClass);
                KotlinClassLookupResult kotlinClassLookupResult = kotlinResult;
                if (kotlinClassLookupResult instanceof KotlinClassLookupResult.Found) {
                    classDescriptor = ((KotlinClassLookupResult.Found)kotlinResult).getDescriptor();
                } else if (kotlinClassLookupResult instanceof KotlinClassLookupResult.SyntheticClass) {
                    classDescriptor = null;
                } else if (kotlinClassLookupResult instanceof KotlinClassLookupResult.NotFound) {
                    boolean bl;
                    JavaClass javaClass;
                    JavaClass javaClass2 = request.getJavaClass();
                    if (javaClass2 == null) {
                        javaClass2 = this.$c.getComponents().getFinder().findClass(requestClassId);
                    }
                    JavaClass javaClass3 = javaClass = javaClass2;
                    if (Intrinsics.areEqual((Object)((Object)(javaClass3 != null ? javaClass3.getLightClassOriginKind() : null)), (Object)((Object)LightClassOriginKind.BINARY))) {
                        throw (Throwable)new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\n" + ("JavaClass: " + javaClass + "\n") + ("ClassId: " + requestClassId + "\n") + ("findKotlinClass(JavaClass) = " + this.$c.getComponents().getKotlinClassFinder().findKotlinClass(javaClass) + "\n") + ("findKotlinClass(ClassId) = " + this.$c.getComponents().getKotlinClassFinder().findKotlinClass(requestClassId) + "\n"));
                    }
                    Object object = javaClass;
                    if (object == null || (object = object.getFqName()) == null) {
                        return null;
                    }
                    Object javaClassFqName = object;
                    boolean bl2 = bl = !((FqName)javaClassFqName).isRoot() && Intrinsics.areEqual(((FqName)javaClassFqName).parent(), this.this$0.getOwnerDescriptor().getFqName());
                    if (_Assertions.ENABLED && !bl) {
                        String string = "Java class by request " + requestClassId + " should be contained in package " + this.this$0.getOwnerDescriptor().getFqName() + ", but it's fq-name: " + javaClassFqName;
                        throw (Throwable)((Object)new AssertionError((Object)string));
                    }
                    classDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.getOwnerDescriptor(), javaClass, null, 8, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return classDescriptor;
            }
            {
                this.this$0 = lazyJavaPackageScope;
                this.$c = lazyJavaResolverContext;
                super(1);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ KotlinClassLookupResult access$resolveKotlinBinaryClass(LazyJavaPackageScope $this, @Nullable KotlinJvmBinaryClass kotlinClass) {
        return $this.resolveKotlinBinaryClass(kotlinClass);
    }

    private static abstract class KotlinClassLookupResult {
        private KotlinClassLookupResult() {
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class Found
        extends KotlinClassLookupResult {
            @NotNull
            private final ClassDescriptor descriptor;

            @NotNull
            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }

            public Found(@NotNull ClassDescriptor descriptor2) {
                Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
                super(null);
                this.descriptor = descriptor2;
            }
        }

        public static final class NotFound
        extends KotlinClassLookupResult {
            public static final NotFound INSTANCE;

            private NotFound() {
                super(null);
                INSTANCE = this;
            }

            static {
                new NotFound();
            }
        }

        public static final class SyntheticClass
        extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE;

            private SyntheticClass() {
                super(null);
                INSTANCE = this;
            }

            static {
                new SyntheticClass();
            }
        }
    }

    private static final class FindClassRequest {
        @NotNull
        private final Name name;
        @Nullable
        private final JavaClass javaClass;

        public boolean equals(@Nullable Object other) {
            return other instanceof FindClassRequest && Intrinsics.areEqual(this.name, ((FindClassRequest)other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        @NotNull
        public final Name getName() {
            return this.name;
        }

        @Nullable
        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public FindClassRequest(@NotNull Name name2, @Nullable JavaClass javaClass) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            this.name = name2;
            this.javaClass = javaClass;
        }
    }
}

