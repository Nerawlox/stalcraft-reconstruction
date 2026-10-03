/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KClassImpl$WhenMappings;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.RuntimeTypeMapper;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001]B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u0013\u0010N\u001a\u00020&2\b\u0010O\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00132\u0006\u0010R\u001a\u00020SH\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u00132\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010V\u001a\u00020WH\u0016J\u0012\u0010X\u001a\u00020&2\b\u0010Y\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u00020=H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R8\u0010\u001a\u001a)\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b\u00a2\u0006\u0002\b\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010'R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u001e\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u0016R\u0016\u00109\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u00010=8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010=8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010B\u001a\u0002018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u00103R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010\rR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010\rR\u0016\u0010J\u001a\u0004\u0018\u00010K8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006^"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lorg/jetbrains/kotlin/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "getProperties", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "hashCode", "", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class KClassImpl<T>
extends KDeclarationContainerImpl
implements KClass<T>,
KClassifierImpl {
    @NotNull
    private final ReflectProperties.LazyVal<Data> data;
    @NotNull
    private final Class<T> jClass;

    @NotNull
    public final ReflectProperties.LazyVal<Data> getData() {
        return this.data;
    }

    @Override
    @NotNull
    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    private final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(this.getJClass());
    }

    @NotNull
    public final MemberScope getMemberScope$kotlin_reflection() {
        return this.getDescriptor().getDefaultType().getMemberScope();
    }

    @NotNull
    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope memberScope2 = this.getDescriptor().getStaticScope();
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "descriptor.staticScope");
        return memberScope2;
    }

    @Override
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    @Override
    @NotNull
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor2 = this.getDescriptor();
        if (Intrinsics.areEqual((Object)descriptor2.getKind(), (Object)ClassKind.INTERFACE) || Intrinsics.areEqual((Object)descriptor2.getKind(), (Object)ClassKind.OBJECT)) {
            return CollectionsKt.emptyList();
        }
        Collection<ConstructorDescriptor> collection = descriptor2.getConstructors();
        Intrinsics.checkExpressionValueIsNotNull(collection, "descriptor.constructors");
        return collection;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getProperties(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return CollectionsKt.plus(this.getMemberScope$kotlin_reflection().getContributedVariables(name2, NoLookupLocation.FROM_REFLECTION), (Iterable)this.getStaticScope$kotlin_reflection().getContributedVariables(name2, NoLookupLocation.FROM_REFLECTION));
    }

    @Override
    @NotNull
    public Collection<FunctionDescriptor> getFunctions(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return CollectionsKt.plus(this.getMemberScope$kotlin_reflection().getContributedFunctions(name2, NoLookupLocation.FROM_REFLECTION), (Iterable)this.getStaticScope$kotlin_reflection().getContributedFunctions(name2, NoLookupLocation.FROM_REFLECTION));
    }

    @Override
    @Nullable
    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    @Override
    @Nullable
    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    @Override
    @NotNull
    public Collection<KFunction<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    @Override
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    @Override
    @Nullable
    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    @Override
    public boolean isInstance(@Nullable Object value) {
        Integer n = ReflectClassUtilKt.getFunctionClassArity(this.getJClass());
        if (n != null) {
            Integer n2 = n;
            int arity = ((Number)n2).intValue();
            return TypeIntrinsics.isFunctionOfArity(value, arity);
        }
        Class<?> clazz = ReflectClassUtilKt.getWrapperByPrimitive(this.getJClass());
        if (clazz == null) {
            clazz = this.getJClass();
        }
        return clazz.isInstance(value);
    }

    @Override
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    @Override
    @NotNull
    public List<KType> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    @Override
    @Nullable
    public KVisibility getVisibility() {
        return UtilKt.toKVisibility(this.getDescriptor().getVisibility());
    }

    @Override
    public boolean isFinal() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.FINAL);
    }

    @Override
    public boolean isOpen() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.OPEN);
    }

    @Override
    public boolean isAbstract() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.ABSTRACT);
    }

    @Override
    public boolean isSealed() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.SEALED);
    }

    @Override
    public boolean isData() {
        return this.getDescriptor().isData();
    }

    @Override
    public boolean isInner() {
        return this.getDescriptor().isInner();
    }

    @Override
    public boolean isCompanion() {
        return this.getDescriptor().isCompanionObject();
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return other instanceof KClassImpl && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)other));
    }

    @Override
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @NotNull
    public String toString() {
        ClassId classId = this.getClassId();
        StringBuilder stringBuilder = new StringBuilder().append("class ");
        ClassId classId2 = classId;
        FqName packageFqName = classId2.getPackageFqName();
        String packagePrefix = packageFqName.isRoot() ? "" : packageFqName.asString() + ".";
        String classSuffix = StringsKt.replace$default(classId2.getRelativeClassName().asString(), '.', '$', false, 4, null);
        String string = packagePrefix + classSuffix;
        return stringBuilder.append(string).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Void reportUnresolvedClass() {
        KotlinClassHeader.Kind kind;
        Object object = ReflectKotlinClass.Factory.create(this.getJClass());
        KotlinClassHeader.Kind kind2 = kind = object != null && (object = ((ReflectKotlinClass)object).getClassHeader()) != null ? ((KotlinClassHeader)object).getKind() : null;
        if (kind2 == null) throw (Throwable)new KotlinReflectionInternalError("Unresolved class: " + this.getJClass());
        switch (KClassImpl$WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                throw (Throwable)new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. " + ("Meanwhile please use Java reflection to inspect this class: " + this.getJClass()));
            }
            case 4: {
                throw (Throwable)new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection " + ("library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + this.getJClass()));
            }
            case 5: {
                throw (Throwable)new KotlinReflectionInternalError("Unknown class: " + this.getJClass() + " (kind = " + (Object)((Object)kind) + ")");
            }
            case 6: {
                throw (Throwable)new KotlinReflectionInternalError("Unresolved class: " + this.getJClass());
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Class<T> getJClass() {
        return this.jClass;
    }

    public KClassImpl(@NotNull Class<T> jClass) {
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        this.jClass = jClass;
        this.data = ReflectProperties.lazy((Function0)new Function0<Data>(this){
            final /* synthetic */ KClassImpl this$0;

            @NotNull
            public final Data invoke() {
                return this.this$0.new Data();
            }
            {
                this.this$0 = kClassImpl;
                super(0);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ ClassId access$getClassId$p(KClassImpl $this) {
        return $this.getClassId();
    }

    @NotNull
    public static final /* synthetic */ Void access$reportUnresolvedClass(KClassImpl $this) {
        return $this.reportUnresolvedClass();
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010K\u001a\u00020<2\n\u0010L\u001a\u0006\u0012\u0002\b\u00030MH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bE\u0010\u0015R!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bI\u0010\u0015\u00a8\u0006N"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
    public final class Data
    extends KDeclarationContainerImpl.Data {
        @NotNull
        private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft((Function0)new Function0<ClassDescriptor>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final ClassDescriptor invoke() {
                ClassDescriptor descriptor2;
                ClassId classId = KClassImpl.access$getClassId$p(this.this$0.KClassImpl.this);
                RuntimeModuleData moduleData2 = this.this$0.KClassImpl.this.getData().invoke().getModuleData();
                ClassDescriptor classDescriptor = descriptor2 = classId.isLocal() ? moduleData2.getDeserialization().deserializeClass(classId) : FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData2.getModule(), classId);
                if (classDescriptor == null) {
                    Void void_ = KClassImpl.access$reportUnresolvedClass(this.this$0.KClassImpl.this);
                    throw null;
                }
                return classDescriptor;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal annotations$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends Annotation>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final List<Annotation> invoke() {
                return UtilKt.computeAnnotations(this.this$0.getDescriptor());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @Nullable
        private final ReflectProperties.LazySoftVal simpleName$delegate = ReflectProperties.lazySoft((Function0)new Function0<String>(this){
            final /* synthetic */ Data this$0;

            @Nullable
            public final String invoke() {
                String string;
                if (this.this$0.KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classId = KClassImpl.access$getClassId$p(this.this$0.KClassImpl.this);
                if (classId.isLocal()) {
                    string = Data.access$calculateLocalClassName(this.this$0, this.this$0.KClassImpl.this.getJClass());
                } else {
                    String string2 = classId.getShortClassName().asString();
                    string = string2;
                    Intrinsics.checkExpressionValueIsNotNull(string2, "classId.shortClassName.asString()");
                }
                return string;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @Nullable
        private final ReflectProperties.LazySoftVal qualifiedName$delegate = ReflectProperties.lazySoft((Function0)new Function0<String>(this){
            final /* synthetic */ Data this$0;

            @Nullable
            public final String invoke() {
                if (this.this$0.KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classId = KClassImpl.access$getClassId$p(this.this$0.KClassImpl.this);
                return classId.isLocal() ? null : classId.asSingleFqName().asString();
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal constructors$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KFunction<? extends T>>>(this){
            final /* synthetic */ Data this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KFunction<T>> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)this.this$0.KClassImpl.this.getConstructorDescriptors();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void descriptor2;
                    ConstructorDescriptor constructorDescriptor = (ConstructorDescriptor)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    KFunction kFunction = new KFunctionImpl(this.this$0.KClassImpl.this, (FunctionDescriptor)descriptor2);
                    collection.add(kFunction);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal nestedClasses$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KClassImpl<? extends Object>>>(this){
            final /* synthetic */ Data this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KClassImpl<? extends Object>> invoke() {
                void var3_3;
                Iterable $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)ResolutionScope.DefaultImpls.getContributedDescriptors$default(this.this$0.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                Collection destination$iv$iv = new ArrayList<E>();
                for (T element$iv$iv : $receiver$iv$iv) {
                    DeclarationDescriptor p1 = (DeclarationDescriptor)element$iv$iv;
                    if (DescriptorUtils.isEnumEntry(p1)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $receiver$iv = (List)destination$iv$iv;
                $receiver$iv$iv = $receiver$iv;
                destination$iv$iv = new ArrayList<E>();
                Iterable $receiver$iv$iv$iv = $receiver$iv$iv;
                Iterator<T> iterator2 = $receiver$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    KClassImpl<?> kClassImpl;
                    KClassImpl<?> kClassImpl2;
                    DeclarationDescriptor nestedClass;
                    T element$iv$iv$iv;
                    T element$iv$iv = element$iv$iv$iv = iterator2.next();
                    DeclarationDescriptor declarationDescriptor = nestedClass = (DeclarationDescriptor)element$iv$iv;
                    if (declarationDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    Class<?> jClass = UtilKt.toJavaClass((ClassDescriptor)declarationDescriptor);
                    if (jClass != null) {
                        Class<?> clazz;
                        Class<?> it = clazz;
                        kClassImpl2 = new KClassImpl<?>(it);
                    } else {
                        kClassImpl2 = null;
                    }
                    if (kClassImpl2 == null) continue;
                    KClassImpl<?> it$iv$iv = kClassImpl = kClassImpl2;
                    destination$iv$iv.add(it$iv$iv);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @Nullable
        private final ReflectProperties.LazyVal objectInstance$delegate = ReflectProperties.lazy(new Function0<T>(this){
            final /* synthetic */ Data this$0;

            @Nullable
            public final T invoke() {
                ClassDescriptor descriptor2 = this.this$0.getDescriptor();
                if (Intrinsics.areEqual((Object)((Object)descriptor2.getKind()), (Object)((Object)ClassKind.OBJECT)) ^ true) {
                    return null;
                }
                Field field = descriptor2.isCompanionObject() && !CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject(descriptor2) ? this.this$0.KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(descriptor2.getName().asString()) : this.this$0.KClassImpl.this.getJClass().getDeclaredField("INSTANCE");
                Object object = field.get(null);
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type T");
                }
                return (T)object;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal typeParameters$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KTypeParameterImpl>>(this){
            final /* synthetic */ Data this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KTypeParameterImpl> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)this.this$0.getDescriptor().getDeclaredTypeParameters();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void p1;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    KTypeParameterImpl kTypeParameterImpl = new KTypeParameterImpl((TypeParameterDescriptor)p1);
                    collection.add(kTypeParameterImpl);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal supertypes$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KTypeImpl>>(this){
            final /* synthetic */ Data this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KTypeImpl> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)this.this$0.getDescriptor().getTypeConstructor().getSupertypes();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void kotlinType;
                    KotlinType kotlinType2 = (KotlinType)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    void v0 = kotlinType;
                    Intrinsics.checkExpressionValueIsNotNull(v0, "kotlinType");
                    KTypeImpl kTypeImpl = new KTypeImpl((KotlinType)v0, (Function0<? extends Type>)new Function0<Type>((KotlinType)kotlinType, this){
                        final /* synthetic */ KotlinType $kotlinType;
                        final /* synthetic */ supertypes.2 this$0;
                        {
                            this.$kotlinType = kotlinType;
                            this.this$0 = var2_2;
                            super(0);
                        }

                        public final Type invoke() {
                            Type type2;
                            ClassifierDescriptor superClass = this.$kotlinType.getConstructor().getDeclarationDescriptor();
                            if (!(superClass instanceof ClassDescriptor)) {
                                throw (Throwable)new KotlinReflectionInternalError("Supertype not a class: " + superClass);
                            }
                            Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)superClass);
                            if (clazz == null) {
                                throw (Throwable)new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0.this$0 + ": " + superClass);
                            }
                            Class<?> superJavaClass = clazz;
                            if (Intrinsics.areEqual(this.this$0.this$0.KClassImpl.this.getJClass().getSuperclass(), superJavaClass)) {
                                Type type3 = this.this$0.this$0.KClassImpl.this.getJClass().getGenericSuperclass();
                                type2 = type3;
                                Intrinsics.checkExpressionValueIsNotNull(type3, "jClass.genericSuperclass");
                            } else {
                                int index = ArraysKt.indexOf((Object[])this.this$0.this$0.KClassImpl.this.getJClass().getInterfaces(), superJavaClass);
                                if (index < 0) {
                                    throw (Throwable)new KotlinReflectionInternalError("No superclass of " + this.this$0.this$0 + " in Java reflection for " + superClass);
                                }
                                Type type4 = this.this$0.this$0.KClassImpl.this.getJClass().getGenericInterfaces()[index];
                                type2 = type4;
                                Intrinsics.checkExpressionValueIsNotNull(type4, "jClass.genericInterfaces[index]");
                            }
                            return type2;
                        }
                    });
                    collection.add(kTypeImpl);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final Collection<KCallableImpl<?>> invoke() {
                return this.this$0.KClassImpl.this.getMembers(this.this$0.KClassImpl.this.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final Collection<KCallableImpl<?>> invoke() {
                return this.this$0.KClassImpl.this.getMembers(this.this$0.KClassImpl.this.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final Collection<KCallableImpl<?>> invoke() {
                return this.this$0.KClassImpl.this.getMembers(this.this$0.KClassImpl.this.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final Collection<KCallableImpl<?>> invoke() {
                return this.this$0.KClassImpl.this.getMembers(this.this$0.KClassImpl.this.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final List<KCallableImpl<?>> invoke() {
                return CollectionsKt.plus(this.this$0.getDeclaredNonStaticMembers(), (Iterable)this.this$0.getInheritedNonStaticMembers());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal allStaticMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final List<KCallableImpl<?>> invoke() {
                return CollectionsKt.plus(this.this$0.getDeclaredStaticMembers(), (Iterable)this.this$0.getInheritedStaticMembers());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal declaredMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final List<KCallableImpl<?>> invoke() {
                return CollectionsKt.plus(this.this$0.getDeclaredNonStaticMembers(), (Iterable)this.this$0.getDeclaredStaticMembers());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        @NotNull
        private final ReflectProperties.LazySoftVal allMembers$delegate = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this){
            final /* synthetic */ Data this$0;

            @NotNull
            public final List<KCallableImpl<?>> invoke() {
                return CollectionsKt.plus(this.this$0.getAllNonStaticMembers(), (Iterable)this.this$0.getAllStaticMembers());
            }
            {
                this.this$0 = data2;
                super(0);
            }
        });
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        @NotNull
        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        }

        @NotNull
        public final List<Annotation> getAnnotations() {
            return (List)this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        }

        @Nullable
        public final String getSimpleName() {
            return (String)this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
        }

        @Nullable
        public final String getQualifiedName() {
            return (String)this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
        }

        private final String calculateLocalClassName(Class<?> jClass) {
            String name2 = jClass.getSimpleName();
            Method method = jClass.getEnclosingMethod();
            if (method != null) {
                Method method2;
                Method method3 = method2 = method;
                return StringsKt.substringAfter$default(name2, method3.getName() + "$", null, 2, null);
            }
            Constructor<?> constructor = jClass.getEnclosingConstructor();
            if (constructor != null) {
                Constructor<?> constructor2;
                Constructor<?> constructor3 = constructor2 = constructor;
                return StringsKt.substringAfter$default(name2, constructor3.getName() + "$", null, 2, null);
            }
            return StringsKt.substringAfter$default(name2, '$', null, 2, null);
        }

        private static /* synthetic */ void constructors$annotations() {
        }

        @NotNull
        public final Collection<KFunction<T>> getConstructors() {
            return (Collection)this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
        }

        @NotNull
        public final Collection<KClass<?>> getNestedClasses() {
            return (Collection)this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
        }

        private static /* synthetic */ void objectInstance$annotations() {
        }

        @Nullable
        public final T getObjectInstance() {
            return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
        }

        @NotNull
        public final List<KTypeParameter> getTypeParameters() {
            return (List)this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
        }

        @NotNull
        public final List<KType> getSupertypes() {
            return (List)this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection)this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[9]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            return (Collection)this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            return (Collection)this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            return (Collection)this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection)this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection)this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            return (Collection)this.declaredMembers$delegate.getValue(this, $$delegatedProperties[15]);
        }

        @NotNull
        public final Collection<KCallableImpl<?>> getAllMembers() {
            return (Collection)this.allMembers$delegate.getValue(this, $$delegatedProperties[16]);
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        @NotNull
        public static final /* synthetic */ String access$calculateLocalClassName(Data $this, @NotNull Class jClass) {
            return $this.calculateLocalClassName(jClass);
        }
    }
}

