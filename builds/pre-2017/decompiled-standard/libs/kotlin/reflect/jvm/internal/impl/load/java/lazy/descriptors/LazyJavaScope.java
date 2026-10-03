/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.LazyJavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LazyJavaScope
extends MemberScopeImpl {
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    @NotNull
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final NotNullLazyValue propertyNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    @NotNull
    private final LazyJavaResolverContext c;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @NotNull
    protected abstract DeclarationDescriptor getOwnerDescriptor();

    @NotNull
    protected final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    @NotNull
    protected abstract DeclaredMemberIndex computeMemberIndex();

    protected abstract void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> var1, @NotNull Name var2);

    @Nullable
    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    protected boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return true;
    }

    @NotNull
    protected abstract MethodSignatureData resolveMethodSignature(@NotNull JavaMethod var1, @NotNull List<? extends TypeParameterDescriptor> var2, @NotNull KotlinType var3, @NotNull List<? extends ValueParameterDescriptor> var4);

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final JavaMethodDescriptor resolveMethodToFunctionDescriptor(@NotNull JavaMethod method) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        JavaMethodDescriptor functionDescriptorImpl;
        Intrinsics.checkParameterIsNotNull(method, "method");
        Annotations annotations2 = LazyJavaAnnotationsKt.resolveAnnotations(this.c, method);
        JavaMethodDescriptor javaMethodDescriptor = functionDescriptorImpl = JavaMethodDescriptor.createJavaMethod(this.getOwnerDescriptor(), annotations2, method.getName(), this.c.getComponents().getSourceElementFactory().source(method));
        Intrinsics.checkExpressionValueIsNotNull(javaMethodDescriptor, "functionDescriptorImpl");
        LazyJavaResolverContext c = ContextKt.child$default(this.c, javaMethodDescriptor, method, 0, 4, null);
        Iterable iterable = $receiver$iv = (Iterable)method.getTypeParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor;
            void p;
            JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
            Collection collection = destination$iv$iv;
            if (c.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p) == null) {
                Intrinsics.throwNpe();
            }
            collection.add(typeParameterDescriptor);
        }
        List methodTypeParameters = (List)destination$iv$iv;
        JavaMethodDescriptor javaMethodDescriptor2 = functionDescriptorImpl;
        Intrinsics.checkExpressionValueIsNotNull(javaMethodDescriptor2, "functionDescriptorImpl");
        ResolvedValueParameters valueParameters = this.resolveValueParameters(c, javaMethodDescriptor2, method.getValueParameters());
        KotlinType returnType = this.computeMethodReturnType(method, annotations2, c);
        MethodSignatureData effectiveSignature = this.resolveMethodSignature(method, methodTypeParameters, returnType, valueParameters.getDescriptors());
        functionDescriptorImpl.initialize(effectiveSignature.getReceiverType(), this.getDispatchReceiverParameter(), effectiveSignature.getTypeParameters(), (List)effectiveSignature.getValueParameters(), effectiveSignature.getReturnType(), Modality.Companion.convertFromFlags(method.isAbstract(), !method.isFinal()), method.getVisibility());
        functionDescriptorImpl.setParameterNamesStatus(effectiveSignature.getHasStableParameterNames(), valueParameters.getHasSynthesizedNames());
        Collection collection = effectiveSignature.getErrors();
        if (!collection.isEmpty()) {
            c.getComponents().getSignaturePropagator().reportSignatureErrors(functionDescriptorImpl, effectiveSignature.getErrors());
        }
        JavaMethodDescriptor javaMethodDescriptor3 = functionDescriptorImpl;
        Intrinsics.checkExpressionValueIsNotNull(javaMethodDescriptor3, "functionDescriptorImpl");
        return javaMethodDescriptor3;
    }

    @NotNull
    protected final KotlinType computeMethodReturnType(@NotNull JavaMethod method, @NotNull Annotations annotations2, @NotNull LazyJavaResolverContext c) {
        KotlinType kotlinType;
        KotlinType kotlinType2;
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(c, "c");
        boolean annotationMethod = method.getContainingClass().isAnnotationType();
        LazyJavaTypeAttributes returnTypeAttrs = new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_COVARIANT, annotations2, !annotationMethod, annotationMethod);
        KotlinType it = kotlinType2 = c.getTypeResolver().transformJavaType(method.getReturnType(), returnTypeAttrs);
        if (annotationMethod) {
            KotlinType kotlinType3 = TypeUtils.makeNotNullable(it);
            kotlinType = kotlinType3;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "TypeUtils.makeNotNullable(it)");
        } else {
            kotlinType = it;
        }
        return kotlinType;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final ResolvedValueParameters resolveValueParameters(@NotNull LazyJavaResolverContext c, @NotNull FunctionDescriptor function, @NotNull List<? extends JavaValueParameter> jValueParameters) {
        void synthesizedNames;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(function, "function");
        Intrinsics.checkParameterIsNotNull(jValueParameters, "jValueParameters");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Iterable iterable = $receiver$iv = CollectionsKt.withIndex((Iterable)jValueParameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void varargElementType;
            void index;
            Name name2;
            void outType;
            Pair<KotlinType, Object> pair;
            void javaParameter;
            void pair2;
            IndexedValue indexedValue = (IndexedValue)item$iv$iv;
            Collection collection = destination$iv$iv;
            Object var12_12 = pair2;
            int n = var12_12.component1();
            JavaValueParameter javaValueParameter = (JavaValueParameter)var12_12.component2();
            var12_12 = null;
            Annotations annotations2 = LazyJavaAnnotationsKt.resolveAnnotations(c, (JavaAnnotationOwner)javaParameter);
            LazyJavaTypeAttributes typeUsage = new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT, annotations2, false, false, 12, null);
            if (javaParameter.isVararg()) {
                JavaArrayType paramType;
                JavaType javaType = javaParameter.getType();
                if (!(javaType instanceof JavaArrayType)) {
                    javaType = null;
                }
                if ((JavaArrayType)javaType == null) {
                    throw (Throwable)((Object)new AssertionError((Object)("Vararg parameter should be an array: " + javaParameter)));
                }
                KotlinType outType2 = c.getTypeResolver().transformArrayType(paramType, typeUsage, true);
                pair = TuplesKt.to(outType2, c.getModule().getBuiltIns().getArrayElementType(outType2));
            } else {
                pair = TuplesKt.to(c.getTypeResolver().transformJavaType(javaParameter.getType(), typeUsage), null);
            }
            Pair<KotlinType, Object> pair3 = pair;
            KotlinType kotlinType = pair3.component1();
            KotlinType kotlinType2 = pair3.component2();
            pair3 = null;
            if (Intrinsics.areEqual(function.getName().asString(), "equals") && jValueParameters.size() == 1 && Intrinsics.areEqual(c.getModule().getBuiltIns().getNullableAnyType(), outType)) {
                name2 = Name.identifier("other");
            } else {
                Name javaName = javaParameter.getName();
                if (javaName == null) {
                    synthesizedNames.element = true;
                }
                if ((name2 = javaName) == null) {
                    name2 = Name.identifier("p" + (int)index);
                }
            }
            Name name3 = name2;
            CallableDescriptor callableDescriptor = function;
            Name name4 = name3;
            Intrinsics.checkExpressionValueIsNotNull(name4, "name");
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(callableDescriptor, null, (int)index, annotations2, name4, (KotlinType)outType, false, false, false, (KotlinType)varargElementType, c.getComponents().getSourceElementFactory().source((JavaElement)javaParameter));
            collection.add(valueParameterDescriptorImpl);
        }
        List descriptors = CollectionsKt.toList((List)destination$iv$iv);
        return new ResolvedValueParameters(descriptors, synthesizedNames.element);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set)StorageKt.getValue(this.functionNamesLazy$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set)StorageKt.getValue(this.propertyNamesLazy$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.getFunctionNamesLazy();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.getPropertyNamesLazy();
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        if (this.getFunctionNames().contains(name2) ^ true) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.functions.invoke(name2);
    }

    @NotNull
    protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        return ((DeclaredMemberIndex)this.declaredMemberIndex.invoke()).getMethodNames();
    }

    protected abstract void computeNonDeclaredProperties(@NotNull Name var1, @NotNull Collection<PropertyDescriptor> var2);

    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        return ((DeclaredMemberIndex)this.declaredMemberIndex.invoke()).getFieldNames();
    }

    private final PropertyDescriptor resolveProperty(JavaField field) {
        KotlinType propertyType;
        PropertyDescriptorImpl propertyDescriptor = this.createPropertyDescriptor(field);
        propertyDescriptor.initialize(null, null);
        Annotations annotations2 = propertyDescriptor.getAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(annotations2, "propertyDescriptor.annotations");
        KotlinType kotlinType = propertyType = this.getPropertyType(field, annotations2);
        PropertyDescriptorImpl propertyDescriptorImpl = propertyDescriptor;
        List list = CollectionsKt.emptyList();
        propertyDescriptorImpl.setType(kotlinType, list, this.getDispatchReceiverParameter(), (KotlinType)null);
        if (DescriptorUtils.shouldRecordInitializerForProperty(propertyDescriptor, propertyDescriptor.getType())) {
            propertyDescriptor.setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue(new Function0<ConstantValue<?>>(this, field, propertyDescriptor){
                final /* synthetic */ LazyJavaScope this$0;
                final /* synthetic */ JavaField $field;
                final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;

                @Nullable
                public final ConstantValue<?> invoke() {
                    return this.this$0.getC().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
                }
                {
                    this.this$0 = lazyJavaScope;
                    this.$field = javaField;
                    this.$propertyDescriptor = propertyDescriptorImpl;
                    super(0);
                }
            }));
        }
        this.c.getComponents().getJavaResolverCache().recordField(field, propertyDescriptor);
        return propertyDescriptor;
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField field) {
        boolean isVar = !field.isFinal();
        Annotations annotations2 = LazyJavaAnnotationsKt.resolveAnnotations(this.c, field);
        JavaPropertyDescriptor javaPropertyDescriptor = JavaPropertyDescriptor.create(this.getOwnerDescriptor(), annotations2, Modality.FINAL, field.getVisibility(), isVar, field.getName(), this.c.getComponents().getSourceElementFactory().source(field), this.isFinalStatic(field));
        Intrinsics.checkExpressionValueIsNotNull(javaPropertyDescriptor, "JavaPropertyDescriptor.c\u2026d.isFinalStatic\n        )");
        return javaPropertyDescriptor;
    }

    private final boolean isFinalStatic(@NotNull JavaField $receiver) {
        return $receiver.isFinal() && $receiver.isStatic();
    }

    private final KotlinType getPropertyType(JavaField field, Annotations annotations2) {
        boolean allowFlexible = !this.isFinalStatic(field) || !this.c.getComponents().getJavaPropertyInitializerEvaluator().isNotNullCompileTimeConstant(field);
        KotlinType propertyType = this.c.getTypeResolver().transformJavaType(field.getType(), new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_INVARIANT, annotations2, allowFlexible, false, 8, null));
        if (!allowFlexible) {
            KotlinType kotlinType = TypeUtils.makeNotNullable(propertyType);
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "TypeUtils.makeNotNullable(propertyType)");
            return kotlinType;
        }
        return propertyType;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        if (this.getVariableNames().contains(name2) ^ true) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.properties.invoke(name2);
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return (Collection)this.allDescriptors.invoke();
    }

    @NotNull
    protected final List<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        Intrinsics.checkParameterIsNotNull(location, "location");
        LinkedHashSet<CallableMemberDescriptor> result2 = new LinkedHashSet<CallableMemberDescriptor>();
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name2 : this.computeClassNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name2).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result2, this.getContributedClassifier(name2, location));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name2 : this.computeFunctionNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name2).booleanValue()) continue;
                result2.addAll(this.getContributedFunctions(name2, location));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !kindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name2 : this.computePropertyNames(kindFilter, nameFilter)) {
                if (!nameFilter.invoke(name2).booleanValue()) continue;
                result2.addAll(this.getContributedVariables(name2, location));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)result2);
    }

    @NotNull
    protected abstract Set<Name> computeClassNames(@NotNull DescriptorKindFilter var1, @Nullable Function1<? super Name, Boolean> var2);

    @NotNull
    public String toString() {
        return "Lazy scope for " + this.getOwnerDescriptor();
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.println("containingDeclaration: " + this.getOwnerDescriptor());
        p.popIndent();
        p.println("}");
    }

    @NotNull
    protected final LazyJavaResolverContext getC() {
        return this.c;
    }

    public LazyJavaScope(@NotNull LazyJavaResolverContext c) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        this.c = c;
        Function0 function0 = new Function0<List<? extends DeclarationDescriptor>>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final List<DeclarationDescriptor> invoke() {
                return this.this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
            }
            {
                this.this$0 = lazyJavaScope;
                super(0);
            }
        };
        StorageManager storageManager = this.c.getStorageManager();
        LazyJavaScope lazyJavaScope = this;
        List list = CollectionsKt.emptyList();
        lazyJavaScope.allDescriptors = storageManager.createRecursionTolerantLazyValue(function0, list);
        this.declaredMemberIndex = this.c.getStorageManager().createLazyValue((Function0)new Function0<DeclaredMemberIndex>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final DeclaredMemberIndex invoke() {
                return this.this$0.computeMemberIndex();
            }
            {
                this.this$0 = lazyJavaScope;
                super(0);
            }
        });
        this.functions = this.c.getStorageManager().createMemoizedFunction((Function1)new Function1<Name, List<? extends SimpleFunctionDescriptor>>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final List<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                LinkedHashSet<JavaMethodDescriptor> result2 = new LinkedHashSet<JavaMethodDescriptor>();
                for (JavaMethod method : ((DeclaredMemberIndex)this.this$0.getDeclaredMemberIndex().invoke()).findMethodsByName(name2)) {
                    JavaMethodDescriptor descriptor2 = this.this$0.resolveMethodToFunctionDescriptor(method);
                    if (!this.this$0.isVisibleAsFunction(descriptor2)) continue;
                    this.this$0.getC().getComponents().getJavaResolverCache().recordMethod(method, descriptor2);
                    result2.add(descriptor2);
                    if (!method.isStatic()) continue;
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result2, this.this$0.getC().getComponents().getSamConversionResolver().resolveSamAdapter((FunctionDescriptor)descriptor2));
                }
                this.this$0.computeNonDeclaredFunctions((Collection<SimpleFunctionDescriptor>)result2, name2);
                return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(SignatureEnhancementKt.enhanceSignatures((Collection)result2));
            }
            {
                this.this$0 = lazyJavaScope;
                super(1);
            }
        });
        this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final Set<Name> invoke() {
                return this.this$0.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
            }
            {
                this.this$0 = lazyJavaScope;
                super(0);
            }
        });
        this.propertyNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final Set<Name> invoke() {
                return this.this$0.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
            }
            {
                this.this$0 = lazyJavaScope;
                super(0);
            }
        });
        this.properties = this.c.getStorageManager().createMemoizedFunction((Function1)new Function1<Name, List<? extends PropertyDescriptor>>(this){
            final /* synthetic */ LazyJavaScope this$0;

            @NotNull
            public final List<PropertyDescriptor> invoke(@NotNull Name name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                ArrayList<PropertyDescriptor> properties2 = new ArrayList<PropertyDescriptor>();
                JavaField field = ((DeclaredMemberIndex)this.this$0.getDeclaredMemberIndex().invoke()).findFieldByName(name2);
                if (field != null && !field.isEnumEntry()) {
                    properties2.add(LazyJavaScope.access$resolveProperty(this.this$0, field));
                }
                this.this$0.computeNonDeclaredProperties(name2, (Collection<PropertyDescriptor>)properties2);
                return DescriptorUtils.isAnnotationClass(this.this$0.getOwnerDescriptor()) ? kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)properties2) : kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(SignatureEnhancementKt.enhanceSignatures((Collection)properties2));
            }
            {
                this.this$0 = lazyJavaScope;
                super(1);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;"))};
    }

    @NotNull
    public static final /* synthetic */ PropertyDescriptor access$resolveProperty(LazyJavaScope $this, @NotNull JavaField field) {
        return $this.resolveProperty(field);
    }

    protected static final class MethodSignatureData {
        @NotNull
        private final KotlinType returnType;
        @Nullable
        private final KotlinType receiverType;
        @NotNull
        private final List<ValueParameterDescriptor> valueParameters;
        @NotNull
        private final List<TypeParameterDescriptor> typeParameters;
        private final boolean hasStableParameterNames;
        @NotNull
        private final List<String> errors;

        @NotNull
        public final KotlinType getReturnType() {
            return this.returnType;
        }

        @Nullable
        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        @NotNull
        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        @NotNull
        public final List<String> getErrors() {
            return this.errors;
        }

        public MethodSignatureData(@NotNull KotlinType returnType, @Nullable KotlinType receiverType, @NotNull List<? extends ValueParameterDescriptor> valueParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, boolean hasStableParameterNames, @NotNull List<String> errors) {
            Intrinsics.checkParameterIsNotNull(returnType, "returnType");
            Intrinsics.checkParameterIsNotNull(valueParameters, "valueParameters");
            Intrinsics.checkParameterIsNotNull(typeParameters2, "typeParameters");
            Intrinsics.checkParameterIsNotNull(errors, "errors");
            this.returnType = returnType;
            this.receiverType = receiverType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters2;
            this.hasStableParameterNames = hasStableParameterNames;
            this.errors = errors;
        }

        @NotNull
        public final KotlinType component1() {
            return this.returnType;
        }

        @Nullable
        public final KotlinType component2() {
            return this.receiverType;
        }

        @NotNull
        public final List<ValueParameterDescriptor> component3() {
            return this.valueParameters;
        }

        @NotNull
        public final List<TypeParameterDescriptor> component4() {
            return this.typeParameters;
        }

        public final boolean component5() {
            return this.hasStableParameterNames;
        }

        @NotNull
        public final List<String> component6() {
            return this.errors;
        }

        @NotNull
        public final MethodSignatureData copy(@NotNull KotlinType returnType, @Nullable KotlinType receiverType, @NotNull List<? extends ValueParameterDescriptor> valueParameters, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, boolean hasStableParameterNames, @NotNull List<String> errors) {
            Intrinsics.checkParameterIsNotNull(returnType, "returnType");
            Intrinsics.checkParameterIsNotNull(valueParameters, "valueParameters");
            Intrinsics.checkParameterIsNotNull(typeParameters2, "typeParameters");
            Intrinsics.checkParameterIsNotNull(errors, "errors");
            return new MethodSignatureData(returnType, receiverType, valueParameters, typeParameters2, hasStableParameterNames, errors);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ MethodSignatureData copy$default(MethodSignatureData methodSignatureData, KotlinType kotlinType, KotlinType kotlinType2, List list, List list2, boolean bl, List list3, int n, Object object) {
            if ((n & 1) != 0) {
                kotlinType = methodSignatureData.returnType;
            }
            if ((n & 2) != 0) {
                kotlinType2 = methodSignatureData.receiverType;
            }
            if ((n & 4) != 0) {
                list = methodSignatureData.valueParameters;
            }
            if ((n & 8) != 0) {
                list2 = methodSignatureData.typeParameters;
            }
            if ((n & 0x10) != 0) {
                bl = methodSignatureData.hasStableParameterNames;
            }
            if ((n & 0x20) != 0) {
                list3 = methodSignatureData.errors;
            }
            return methodSignatureData.copy(kotlinType, kotlinType2, list, list2, bl, list3);
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ")";
        }

        public int hashCode() {
            KotlinType kotlinType = this.returnType;
            KotlinType kotlinType2 = this.receiverType;
            List<ValueParameterDescriptor> list = this.valueParameters;
            List<TypeParameterDescriptor> list2 = this.typeParameters;
            int n = ((((kotlinType != null ? ((Object)kotlinType).hashCode() : 0) * 31 + (kotlinType2 != null ? ((Object)kotlinType2).hashCode() : 0)) * 31 + (list != null ? ((Object)list).hashCode() : 0)) * 31 + (list2 != null ? ((Object)list2).hashCode() : 0)) * 31;
            int n2 = this.hasStableParameterNames ? 1 : 0;
            if (n2 != 0) {
                n2 = 1;
            }
            List<String> list3 = this.errors;
            return (n + n2) * 31 + (list3 != null ? ((Object)list3).hashCode() : 0);
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof MethodSignatureData)) break block3;
                    MethodSignatureData methodSignatureData = (MethodSignatureData)object;
                    if (!Intrinsics.areEqual(this.returnType, methodSignatureData.returnType) || !Intrinsics.areEqual(this.receiverType, methodSignatureData.receiverType) || !Intrinsics.areEqual(this.valueParameters, methodSignatureData.valueParameters) || !Intrinsics.areEqual(this.typeParameters, methodSignatureData.typeParameters) || !(this.hasStableParameterNames == methodSignatureData.hasStableParameterNames) || !Intrinsics.areEqual(this.errors, methodSignatureData.errors)) break block3;
                }
                return true;
            }
            return false;
        }
    }

    protected static final class ResolvedValueParameters {
        @NotNull
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        @NotNull
        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }

        public ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> descriptors, boolean hasSynthesizedNames) {
            Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
            this.descriptors = descriptors;
            this.hasSynthesizedNames = hasSynthesizedNames;
        }
    }
}

