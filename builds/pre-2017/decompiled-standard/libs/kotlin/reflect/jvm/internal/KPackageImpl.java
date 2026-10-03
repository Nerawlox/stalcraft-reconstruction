/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001+B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\b2\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\b2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u001d\u0012\u0014\u0012\u0012 \u000f*\b\u0018\u00010\u000eR\u00020\u00000\u000eR\u00020\u00000\r\u00a2\u0006\u0002\b\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00038TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006,"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "getModuleName", "()Ljava/lang/String;", "scope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "equals", "", "other", "", "getFunctions", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "getProperties", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "hashCode", "", "toString", "Data", "kotlin-reflection"})
public final class KPackageImpl
extends KDeclarationContainerImpl {
    private final ReflectProperties.LazyVal<Data> data;
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private final String moduleName;

    @Override
    @NotNull
    protected Class<?> getMethodOwner() {
        return this.data.invoke().getMethodOwner();
    }

    private final MemberScope getScope() {
        return this.data.invoke().getDescriptor().getMemberScope();
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getMembers();
    }

    @Override
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.getScope().getContributedVariables(name2, NoLookupLocation.FROM_REFLECTION);
    }

    @Override
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.getScope().getContributedFunctions(name2, NoLookupLocation.FROM_REFLECTION);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KPackageImpl && Intrinsics.areEqual(this.getJClass(), ((KPackageImpl)other).getJClass());
    }

    public int hashCode() {
        return this.getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        String string;
        FqName fqName2 = ReflectClassUtilKt.getClassId(this.getJClass()).getPackageFqName();
        StringBuilder stringBuilder = new StringBuilder().append("package ");
        if (fqName2.isRoot()) {
            string = "<default>";
        } else {
            String string2 = fqName2.asString();
            string = string2;
            Intrinsics.checkExpressionValueIsNotNull(string2, "fqName.asString()");
        }
        return stringBuilder.append(string).toString();
    }

    @Override
    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @NotNull
    public final String getModuleName() {
        return this.moduleName;
    }

    public KPackageImpl(@NotNull Class<?> jClass, @NotNull String moduleName) {
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
        this.jClass = jClass;
        this.moduleName = moduleName;
        this.data = ReflectProperties.lazy((Function0)new Function0<Data>(this){
            final /* synthetic */ KPackageImpl this$0;

            @NotNull
            public final Data invoke() {
                return this.this$0.new Data();
            }
            {
                this.this$0 = kPackageImpl;
                super(0);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ MemberScope access$getScope$p(KPackageImpl $this) {
        return $this.getScope();
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin-reflection"})
    private final class Data
    extends KDeclarationContainerImpl.Data {
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate;
        @NotNull
        private final ReflectProperties.LazyVal methodOwner$delegate;
        @NotNull
        private final ReflectProperties.LazySoftVal members$delegate;
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @NotNull
        public final PackageViewDescriptor getDescriptor() {
            return (PackageViewDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @NotNull
        public final Class<?> getMethodOwner() {
            return (Class)this.methodOwner$delegate.getValue(this, $$delegatedProperties[1]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getMembers() {
            return (Collection)this.members$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public Data() {
            super(KPackageImpl.this);
            this.descriptor$delegate = ReflectProperties.lazySoft((Function0)new Function0<PackageViewDescriptor>(this){
                final /* synthetic */ Data this$0;

                @NotNull
                public final PackageViewDescriptor invoke() {
                    RuntimeModuleData runtimeModuleData;
                    RuntimeModuleData $receiver = runtimeModuleData = this.this$0.getModuleData();
                    $receiver.getPackageFacadeProvider().registerModule(this.this$0.KPackageImpl.this.getModuleName());
                    ModuleDescriptor moduleDescriptor = $receiver.getModule();
                    FqName fqName2 = ReflectClassUtilKt.getClassId(this.this$0.KPackageImpl.this.getJClass()).getPackageFqName();
                    Intrinsics.checkExpressionValueIsNotNull(fqName2, "jClass.classId.packageFqName");
                    return moduleDescriptor.getPackage(fqName2);
                }
                {
                    this.this$0 = data2;
                    super(0);
                }
            });
            this.methodOwner$delegate = ReflectProperties.lazy(new Function0<Class<?>>(this){
                final /* synthetic */ Data this$0;

                public final Class<?> invoke() {
                    CharSequence charSequence;
                    String facadeName;
                    Object object = ReflectKotlinClass.Factory.create(this.this$0.KPackageImpl.this.getJClass());
                    String string = object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null ? ((KotlinClassHeader)object).getMultifileClassName() : (facadeName = null);
                    return facadeName != null && (charSequence = (CharSequence)facadeName).length() > 0 ? this.this$0.KPackageImpl.this.getJClass().getClassLoader().loadClass(StringsKt.replace$default(facadeName, '/', '.', false, 4, null)) : this.this$0.KPackageImpl.this.getJClass();
                }
                {
                    this.this$0 = data2;
                    super(0);
                }
            });
            this.members$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this){
                final /* synthetic */ Data this$0;

                /*
                 * WARNING - void declaration
                 */
                @NotNull
                public final List<KCallableImpl<?>> invoke() {
                    void var3_3;
                    void $receiver$iv$iv;
                    Iterable $receiver$iv;
                    Iterable iterable = $receiver$iv = (Iterable)this.this$0.KPackageImpl.this.getMembers(KPackageImpl.access$getScope$p(this.this$0.KPackageImpl.this), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                    Collection destination$iv$iv = new ArrayList<E>();
                    for (T element$iv$iv : $receiver$iv$iv) {
                        KotlinJvmBinaryPackageSourceElement source;
                        KCallableImpl member = (KCallableImpl)element$iv$iv;
                        CallableMemberDescriptor callableMemberDescriptor = member.getDescriptor();
                        if (callableMemberDescriptor == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor");
                        }
                        DeserializedCallableMemberDescriptor callableDescriptor = (DeserializedCallableMemberDescriptor)callableMemberDescriptor;
                        DeclarationDescriptor declarationDescriptor = callableDescriptor.getContainingDeclaration();
                        if (declarationDescriptor == null) {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor");
                        }
                        PackageFragmentDescriptor packageFragment = (PackageFragmentDescriptor)declarationDescriptor;
                        PackageFragmentDescriptor packageFragmentDescriptor = packageFragment;
                        if (!(packageFragmentDescriptor instanceof LazyJavaPackageFragment)) {
                            packageFragmentDescriptor = null;
                        }
                        LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment)packageFragmentDescriptor;
                        SourceElement sourceElement = lazyJavaPackageFragment != null ? lazyJavaPackageFragment.getSource() : null;
                        if (!(sourceElement instanceof KotlinJvmBinaryPackageSourceElement)) {
                            sourceElement = null;
                        }
                        KotlinJvmBinaryPackageSourceElement kotlinJvmBinaryPackageSourceElement = source = (KotlinJvmBinaryPackageSourceElement)sourceElement;
                        KotlinJvmBinaryClass kotlinJvmBinaryClass = kotlinJvmBinaryPackageSourceElement != null ? kotlinJvmBinaryPackageSourceElement.getContainingBinaryClass(callableDescriptor) : null;
                        if (!(kotlinJvmBinaryClass instanceof ReflectKotlinClass)) {
                            kotlinJvmBinaryClass = null;
                        }
                        ReflectKotlinClass reflectKotlinClass = (ReflectKotlinClass)kotlinJvmBinaryClass;
                        if (!Intrinsics.areEqual(reflectKotlinClass != null ? reflectKotlinClass.getKlass() : null, this.this$0.KPackageImpl.this.getJClass())) continue;
                        destination$iv$iv.add(element$iv$iv);
                    }
                    return (List)var3_3;
                }
                {
                    this.this$0 = data2;
                    super(0);
                }
            });
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "methodOwner", "getMethodOwner()Ljava/lang/Class;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        }
    }
}

