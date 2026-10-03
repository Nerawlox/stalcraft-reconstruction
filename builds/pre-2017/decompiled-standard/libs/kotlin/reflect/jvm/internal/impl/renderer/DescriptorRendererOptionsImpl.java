/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;
import kotlin.reflect.jvm.internal.impl.renderer.ExcludedTypeAnnotations;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererOptionsImpl
implements DescriptorRendererOptions {
    private boolean isLocked;
    @NotNull
    private final ReadWriteProperty classifierNamePolicy$delegate = this.property(ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);
    @NotNull
    private final ReadWriteProperty withDefinedIn$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty modifiers$delegate = this.property(DescriptorRendererModifier.DEFAULTS);
    @NotNull
    private final ReadWriteProperty startFromName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty startFromDeclarationKeyword$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty debugMode$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty classWithPrimaryConstructor$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty verbose$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty unitReturnType$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty withoutReturnType$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty normalizedVisibilities$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty showInternalKeyword$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty uninferredTypeParameterAsName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty includePropertyConstant$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty withoutTypeParameters$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty withoutSuperTypes$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty typeNormalizer$delegate = this.property(typeNormalizer.2.INSTANCE);
    @NotNull
    private final ReadWriteProperty renderDefaultValues$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty secondaryConstructorsAsPrimary$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty overrideRenderingPolicy$delegate = this.property(OverrideRenderingPolicy.RENDER_OPEN);
    @NotNull
    private final ReadWriteProperty valueParametersHandler$delegate = this.property(DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);
    @NotNull
    private final ReadWriteProperty textFormat$delegate = this.property(RenderingFormat.PLAIN);
    @NotNull
    private final ReadWriteProperty parameterNameRenderingPolicy$delegate = this.property(ParameterNameRenderingPolicy.ALL);
    @NotNull
    private final ReadWriteProperty receiverAfterName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderCompanionObjectName$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderAccessors$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderDefaultAnnotationArguments$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty excludedAnnotationClasses$delegate = this.property(SetsKt.emptySet());
    @NotNull
    private final ReadWriteProperty excludedTypeAnnotationClasses$delegate = this.property(SetsKt.plus(ExcludedTypeAnnotations.INSTANCE.getAnnotationsForNullabilityAndMutability(), (Iterable)ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve()));
    @NotNull
    private final ReadWriteProperty annotationArgumentsRenderingPolicy$delegate = this.property(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
    @NotNull
    private final ReadWriteProperty alwaysRenderModifiers$delegate = this.property(false);
    @NotNull
    private final ReadWriteProperty renderConstructorKeyword$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty renderUnabbreviatedType$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty includeAdditionalModifiers$delegate = this.property(true);
    @NotNull
    private final ReadWriteProperty parameterNamesInFunctionalTypes$delegate = this.property(true);
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    public final boolean isLocked() {
        return this.isLocked;
    }

    private final void setLocked(boolean bl) {
        this.isLocked = bl;
    }

    public final void lock() {
        boolean bl;
        boolean bl2 = bl = !this.isLocked;
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.isLocked = true;
    }

    @NotNull
    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl copy = new DescriptorRendererOptionsImpl();
        Field[] fieldArray = this.getClass().getDeclaredFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            ObservableProperty property;
            Object value;
            boolean bl;
            Field field = fieldArray[i];
            if ((field.getModifiers() & 8) != 0) continue;
            field.setAccessible(true);
            Object object = field.get(this);
            if (!(object instanceof ObservableProperty)) {
                object = null;
            }
            if ((ObservableProperty)object == null) {
                continue;
            }
            boolean bl2 = bl = !StringsKt.startsWith$default(field.getName(), "is", false, 2, null);
            if (_Assertions.ENABLED && !bl) {
                String string = "Fields named is* are not supported here yet";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            Object t = value = property.getValue(this, (KProperty<?>)new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), field.getName(), "get" + StringsKt.capitalize(field.getName())));
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
            }
            field.set(copy, copy.property(t));
        }
        return copy;
    }

    private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> property(T initialValue) {
        Delegates this_$iv = Delegates.INSTANCE;
        return new ObservableProperty<T>(initialValue, initialValue, this){
            final /* synthetic */ Object $initialValue;
            final /* synthetic */ DescriptorRendererOptionsImpl this$0;
            {
                this.$initialValue = $captured_local_variable$1;
                this.this$0 = descriptorRendererOptionsImpl;
                super($super_call_param$2);
            }

            protected boolean beforeChange(KProperty<?> property, T oldValue, T newValue) {
                T t = newValue;
                T t2 = oldValue;
                KProperty<?> property2 = property;
                if (this.this$0.isLocked()) {
                    throw (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
                }
                return true;
            }
        };
    }

    @Override
    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy)this.classifierNamePolicy$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkParameterIsNotNull(classifierNamePolicy, "<set-?>");
        this.classifierNamePolicy$delegate.setValue(this, $$delegatedProperties[0], classifierNamePolicy);
    }

    @Override
    public boolean getWithDefinedIn() {
        return (Boolean)this.withDefinedIn$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override
    public void setWithDefinedIn(boolean bl) {
        this.withDefinedIn$delegate.setValue(this, $$delegatedProperties[1], bl);
    }

    @Override
    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return (Set)this.modifiers$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.modifiers$delegate.setValue(this, $$delegatedProperties[2], set);
    }

    @Override
    public boolean getStartFromName() {
        return (Boolean)this.startFromName$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Override
    public void setStartFromName(boolean bl) {
        this.startFromName$delegate.setValue(this, $$delegatedProperties[3], bl);
    }

    @Override
    public boolean getStartFromDeclarationKeyword() {
        return (Boolean)this.startFromDeclarationKeyword$delegate.getValue(this, $$delegatedProperties[4]);
    }

    @Override
    public void setStartFromDeclarationKeyword(boolean bl) {
        this.startFromDeclarationKeyword$delegate.setValue(this, $$delegatedProperties[4], bl);
    }

    @Override
    public boolean getDebugMode() {
        return (Boolean)this.debugMode$delegate.getValue(this, $$delegatedProperties[5]);
    }

    @Override
    public void setDebugMode(boolean bl) {
        this.debugMode$delegate.setValue(this, $$delegatedProperties[5], bl);
    }

    @Override
    public boolean getClassWithPrimaryConstructor() {
        return (Boolean)this.classWithPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[6]);
    }

    @Override
    public void setClassWithPrimaryConstructor(boolean bl) {
        this.classWithPrimaryConstructor$delegate.setValue(this, $$delegatedProperties[6], bl);
    }

    @Override
    public boolean getVerbose() {
        return (Boolean)this.verbose$delegate.getValue(this, $$delegatedProperties[7]);
    }

    @Override
    public void setVerbose(boolean bl) {
        this.verbose$delegate.setValue(this, $$delegatedProperties[7], bl);
    }

    @Override
    public boolean getUnitReturnType() {
        return (Boolean)this.unitReturnType$delegate.getValue(this, $$delegatedProperties[8]);
    }

    @Override
    public void setUnitReturnType(boolean bl) {
        this.unitReturnType$delegate.setValue(this, $$delegatedProperties[8], bl);
    }

    @Override
    public boolean getWithoutReturnType() {
        return (Boolean)this.withoutReturnType$delegate.getValue(this, $$delegatedProperties[9]);
    }

    @Override
    public void setWithoutReturnType(boolean bl) {
        this.withoutReturnType$delegate.setValue(this, $$delegatedProperties[9], bl);
    }

    @Override
    public boolean getNormalizedVisibilities() {
        return (Boolean)this.normalizedVisibilities$delegate.getValue(this, $$delegatedProperties[10]);
    }

    @Override
    public void setNormalizedVisibilities(boolean bl) {
        this.normalizedVisibilities$delegate.setValue(this, $$delegatedProperties[10], bl);
    }

    @Override
    public boolean getShowInternalKeyword() {
        return (Boolean)this.showInternalKeyword$delegate.getValue(this, $$delegatedProperties[11]);
    }

    @Override
    public void setShowInternalKeyword(boolean bl) {
        this.showInternalKeyword$delegate.setValue(this, $$delegatedProperties[11], bl);
    }

    @Override
    public boolean getUninferredTypeParameterAsName() {
        return (Boolean)this.uninferredTypeParameterAsName$delegate.getValue(this, $$delegatedProperties[12]);
    }

    @Override
    public void setUninferredTypeParameterAsName(boolean bl) {
        this.uninferredTypeParameterAsName$delegate.setValue(this, $$delegatedProperties[12], bl);
    }

    @Override
    public boolean getIncludePropertyConstant() {
        return (Boolean)this.includePropertyConstant$delegate.getValue(this, $$delegatedProperties[13]);
    }

    @Override
    public void setIncludePropertyConstant(boolean bl) {
        this.includePropertyConstant$delegate.setValue(this, $$delegatedProperties[13], bl);
    }

    @Override
    public boolean getWithoutTypeParameters() {
        return (Boolean)this.withoutTypeParameters$delegate.getValue(this, $$delegatedProperties[14]);
    }

    @Override
    public void setWithoutTypeParameters(boolean bl) {
        this.withoutTypeParameters$delegate.setValue(this, $$delegatedProperties[14], bl);
    }

    @Override
    public boolean getWithoutSuperTypes() {
        return (Boolean)this.withoutSuperTypes$delegate.getValue(this, $$delegatedProperties[15]);
    }

    @Override
    public void setWithoutSuperTypes(boolean bl) {
        this.withoutSuperTypes$delegate.setValue(this, $$delegatedProperties[15], bl);
    }

    @Override
    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1)this.typeNormalizer$delegate.getValue(this, $$delegatedProperties[16]);
    }

    @Override
    public void setTypeNormalizer(@NotNull Function1<? super KotlinType, ? extends KotlinType> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.typeNormalizer$delegate.setValue(this, $$delegatedProperties[16], function1);
    }

    @Override
    public boolean getRenderDefaultValues() {
        return (Boolean)this.renderDefaultValues$delegate.getValue(this, $$delegatedProperties[17]);
    }

    @Override
    public void setRenderDefaultValues(boolean bl) {
        this.renderDefaultValues$delegate.setValue(this, $$delegatedProperties[17], bl);
    }

    @Override
    public boolean getSecondaryConstructorsAsPrimary() {
        return (Boolean)this.secondaryConstructorsAsPrimary$delegate.getValue(this, $$delegatedProperties[18]);
    }

    @Override
    public void setSecondaryConstructorsAsPrimary(boolean bl) {
        this.secondaryConstructorsAsPrimary$delegate.setValue(this, $$delegatedProperties[18], bl);
    }

    @Override
    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return (OverrideRenderingPolicy)((Object)this.overrideRenderingPolicy$delegate.getValue(this, $$delegatedProperties[19]));
    }

    @Override
    public void setOverrideRenderingPolicy(@NotNull OverrideRenderingPolicy overrideRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)overrideRenderingPolicy, "<set-?>");
        this.overrideRenderingPolicy$delegate.setValue(this, $$delegatedProperties[19], overrideRenderingPolicy);
    }

    @Override
    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return (DescriptorRenderer.ValueParametersHandler)this.valueParametersHandler$delegate.getValue(this, $$delegatedProperties[20]);
    }

    @Override
    public void setValueParametersHandler(@NotNull DescriptorRenderer.ValueParametersHandler valueParametersHandler) {
        Intrinsics.checkParameterIsNotNull(valueParametersHandler, "<set-?>");
        this.valueParametersHandler$delegate.setValue(this, $$delegatedProperties[20], valueParametersHandler);
    }

    @Override
    @NotNull
    public RenderingFormat getTextFormat() {
        return (RenderingFormat)((Object)this.textFormat$delegate.getValue(this, $$delegatedProperties[21]));
    }

    @Override
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkParameterIsNotNull((Object)renderingFormat, "<set-?>");
        this.textFormat$delegate.setValue(this, $$delegatedProperties[21], renderingFormat);
    }

    @Override
    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return (ParameterNameRenderingPolicy)((Object)this.parameterNameRenderingPolicy$delegate.getValue(this, $$delegatedProperties[22]));
    }

    @Override
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)parameterNameRenderingPolicy, "<set-?>");
        this.parameterNameRenderingPolicy$delegate.setValue(this, $$delegatedProperties[22], parameterNameRenderingPolicy);
    }

    @Override
    public boolean getReceiverAfterName() {
        return (Boolean)this.receiverAfterName$delegate.getValue(this, $$delegatedProperties[23]);
    }

    @Override
    public void setReceiverAfterName(boolean bl) {
        this.receiverAfterName$delegate.setValue(this, $$delegatedProperties[23], bl);
    }

    @Override
    public boolean getRenderCompanionObjectName() {
        return (Boolean)this.renderCompanionObjectName$delegate.getValue(this, $$delegatedProperties[24]);
    }

    @Override
    public void setRenderCompanionObjectName(boolean bl) {
        this.renderCompanionObjectName$delegate.setValue(this, $$delegatedProperties[24], bl);
    }

    @Override
    public boolean getRenderAccessors() {
        return (Boolean)this.renderAccessors$delegate.getValue(this, $$delegatedProperties[25]);
    }

    @Override
    public void setRenderAccessors(boolean bl) {
        this.renderAccessors$delegate.setValue(this, $$delegatedProperties[25], bl);
    }

    @Override
    public boolean getRenderDefaultAnnotationArguments() {
        return (Boolean)this.renderDefaultAnnotationArguments$delegate.getValue(this, $$delegatedProperties[26]);
    }

    @Override
    public void setRenderDefaultAnnotationArguments(boolean bl) {
        this.renderDefaultAnnotationArguments$delegate.setValue(this, $$delegatedProperties[26], bl);
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set)this.excludedAnnotationClasses$delegate.getValue(this, $$delegatedProperties[27]);
    }

    @Override
    public void setExcludedAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.excludedAnnotationClasses$delegate.setValue(this, $$delegatedProperties[27], set);
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set)this.excludedTypeAnnotationClasses$delegate.getValue(this, $$delegatedProperties[28]);
    }

    @Override
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.excludedTypeAnnotationClasses$delegate.setValue(this, $$delegatedProperties[28], set);
    }

    @Override
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy)((Object)this.annotationArgumentsRenderingPolicy$delegate.getValue(this, $$delegatedProperties[29]));
    }

    @Override
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)annotationArgumentsRenderingPolicy, "<set-?>");
        this.annotationArgumentsRenderingPolicy$delegate.setValue(this, $$delegatedProperties[29], annotationArgumentsRenderingPolicy);
    }

    @Override
    public boolean getAlwaysRenderModifiers() {
        return (Boolean)this.alwaysRenderModifiers$delegate.getValue(this, $$delegatedProperties[30]);
    }

    @Override
    public void setAlwaysRenderModifiers(boolean bl) {
        this.alwaysRenderModifiers$delegate.setValue(this, $$delegatedProperties[30], bl);
    }

    @Override
    public boolean getRenderConstructorKeyword() {
        return (Boolean)this.renderConstructorKeyword$delegate.getValue(this, $$delegatedProperties[31]);
    }

    @Override
    public void setRenderConstructorKeyword(boolean bl) {
        this.renderConstructorKeyword$delegate.setValue(this, $$delegatedProperties[31], bl);
    }

    @Override
    public boolean getRenderUnabbreviatedType() {
        return (Boolean)this.renderUnabbreviatedType$delegate.getValue(this, $$delegatedProperties[32]);
    }

    @Override
    public void setRenderUnabbreviatedType(boolean bl) {
        this.renderUnabbreviatedType$delegate.setValue(this, $$delegatedProperties[32], bl);
    }

    @Override
    public boolean getIncludeAdditionalModifiers() {
        return (Boolean)this.includeAdditionalModifiers$delegate.getValue(this, $$delegatedProperties[33]);
    }

    @Override
    public void setIncludeAdditionalModifiers(boolean bl) {
        this.includeAdditionalModifiers$delegate.setValue(this, $$delegatedProperties[33], bl);
    }

    @Override
    public boolean getParameterNamesInFunctionalTypes() {
        return (Boolean)this.parameterNamesInFunctionalTypes$delegate.getValue(this, $$delegatedProperties[34]);
    }

    @Override
    public void setParameterNamesInFunctionalTypes(boolean bl) {
        this.parameterNamesInFunctionalTypes$delegate.setValue(this, $$delegatedProperties[34], bl);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "debugMode", "getDebugMode()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "showInternalKeyword", "getShowInternalKeyword()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultValues", "getRenderDefaultValues()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderAccessors", "getRenderAccessors()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z"))};
    }

    @Override
    public boolean getIncludeAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
    }

    @Override
    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
    }

    public static final /* synthetic */ boolean access$isLocked$p(DescriptorRendererOptionsImpl $this) {
        return $this.isLocked;
    }

    public static final /* synthetic */ void access$setLocked$p(DescriptorRendererOptionsImpl $this, boolean bl) {
        $this.isLocked = bl;
    }
}

