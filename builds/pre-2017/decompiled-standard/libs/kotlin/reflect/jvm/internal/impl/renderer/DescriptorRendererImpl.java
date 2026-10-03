/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScriptDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$WhenMappings;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorRendererImpl
extends DescriptorRenderer
implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final Lazy functionTypeParameterTypesRenderer$delegate;
    @NotNull
    private final DescriptorRendererOptionsImpl options;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        Lazy lazy = this.functionTypeAnnotationsRenderer$delegate;
        DescriptorRendererImpl descriptorRendererImpl = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (DescriptorRendererImpl)lazy.getValue();
    }

    private final DescriptorRenderer getFunctionTypeParameterTypesRenderer() {
        Lazy lazy = this.functionTypeParameterTypesRenderer$delegate;
        DescriptorRendererImpl descriptorRendererImpl = this;
        KProperty kProperty = $$delegatedProperties[1];
        return (DescriptorRenderer)lazy.getValue();
    }

    private final String renderKeyword(String keyword) {
        switch (DescriptorRendererImpl$WhenMappings.$EnumSwitchMapping$0[this.getTextFormat().ordinal()]) {
            case 1: {
                return keyword;
            }
            case 2: {
                return "<b>" + keyword + "</b>";
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String renderError(String keyword) {
        switch (DescriptorRendererImpl$WhenMappings.$EnumSwitchMapping$1[this.getTextFormat().ordinal()]) {
            case 1: {
                return keyword;
            }
            case 2: {
                return "<font color=red><b>" + keyword + "</b></font>";
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String escape(String string) {
        return this.getTextFormat().escape(string);
    }

    private final String lt() {
        return this.escape("<");
    }

    private final String gt() {
        return this.escape(">");
    }

    private final String arrow() {
        String string;
        switch (DescriptorRendererImpl$WhenMappings.$EnumSwitchMapping$2[this.getTextFormat().ordinal()]) {
            case 1: {
                string = this.escape("->");
                break;
            }
            case 2: {
                string = "&rarr;";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    @Override
    @NotNull
    public String renderMessage(@NotNull String message) {
        String string;
        Intrinsics.checkParameterIsNotNull(message, "message");
        switch (DescriptorRendererImpl$WhenMappings.$EnumSwitchMapping$3[this.getTextFormat().ordinal()]) {
            case 1: {
                string = message;
                break;
            }
            case 2: {
                string = "<i>" + message + "</i>";
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return string;
    }

    @Override
    @NotNull
    public String renderName(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.escape(RenderingUtilsKt.render(name2));
    }

    private final void renderName(DeclarationDescriptor descriptor2, StringBuilder builder) {
        Name name2 = descriptor2.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "descriptor.name");
        builder.append(this.renderName(name2));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor descriptor2, StringBuilder builder) {
        if (this.getRenderCompanionObjectName()) {
            if (this.getStartFromName()) {
                builder.append("companion object");
            }
            this.renderSpaceIfNeeded(builder);
            DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
            if (containingDeclaration != null) {
                builder.append("of ");
                Name name2 = containingDeclaration.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "containingDeclaration.name");
                builder.append(this.renderName(name2));
            }
        }
        if (this.getVerbose() || Intrinsics.areEqual(descriptor2.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) ^ true) {
            if (!this.getStartFromName()) {
                this.renderSpaceIfNeeded(builder);
            }
            Name name3 = descriptor2.getName();
            Intrinsics.checkExpressionValueIsNotNull(name3, "descriptor.name");
            builder.append(this.renderName(name3));
        }
    }

    @Override
    @NotNull
    public String renderFqName(@NotNull FqNameUnsafe fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        List<Name> list = fqName2.pathSegments();
        Intrinsics.checkExpressionValueIsNotNull(list, "fqName.pathSegments()");
        return this.renderFqName(list);
    }

    private final String renderFqName(List<Name> pathSegments) {
        return this.escape(RenderingUtilsKt.renderFqName(pathSegments));
    }

    @Override
    @NotNull
    public String renderClassifierName(@NotNull ClassifierDescriptor klass) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        if (ErrorUtils.isError(klass)) {
            return klass.getTypeConstructor().toString();
        }
        return this.getClassifierNamePolicy().renderClassifier(klass, this);
    }

    @Override
    @NotNull
    public String renderType(@NotNull KotlinType type2) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(type2, "type");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        this.renderNormalizedType($receiver, this.getTypeNormalizer().invoke(type2));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final void renderNormalizedType(@NotNull StringBuilder $receiver, KotlinType type2) {
        AbbreviatedType abbreviated;
        UnwrappedType unwrappedType = type2.unwrap();
        if (!(unwrappedType instanceof AbbreviatedType)) {
            unwrappedType = null;
        }
        if ((abbreviated = (AbbreviatedType)unwrappedType) != null) {
            this.renderNormalizedTypeAsIs($receiver, abbreviated.getAbbreviation());
            if (this.getRenderUnabbreviatedType()) {
                this.renderAbbreviatedTypeExpansion($receiver, abbreviated);
            }
            return;
        }
        this.renderNormalizedTypeAsIs($receiver, type2);
    }

    private final void renderAbbreviatedTypeExpansion(@NotNull StringBuilder $receiver, AbbreviatedType abbreviated) {
        if (Intrinsics.areEqual((Object)this.getTextFormat(), (Object)RenderingFormat.HTML)) {
            $receiver.append("<font color=\"808080\"><i>");
        }
        $receiver.append(" /* = ");
        this.renderNormalizedTypeAsIs($receiver, abbreviated.getExpandedType());
        $receiver.append(" */");
        if (Intrinsics.areEqual((Object)this.getTextFormat(), (Object)RenderingFormat.HTML)) {
            $receiver.append("</i></font>");
        }
    }

    private final void renderNormalizedTypeAsIs(@NotNull StringBuilder $receiver, KotlinType type2) {
        if (type2 instanceof WrappedType && this.getDebugMode() && !((WrappedType)type2).isComputed()) {
            $receiver.append("<Not computed yet>");
            return;
        }
        UnwrappedType unwrappedType = type2.unwrap();
        UnwrappedType unwrappedType2 = unwrappedType;
        if (unwrappedType2 instanceof FlexibleType) {
            $receiver.append(((FlexibleType)unwrappedType).render(this, this));
        } else if (unwrappedType2 instanceof SimpleType) {
            this.renderSimpleType($receiver, (SimpleType)unwrappedType);
        }
    }

    private final void renderSimpleType(@NotNull StringBuilder $receiver, SimpleType type2) {
        if (Intrinsics.areEqual(type2, TypeUtils.CANT_INFER_FUNCTION_PARAM_TYPE) || TypeUtils.isDontCarePlaceholder(type2)) {
            $receiver.append("???");
            return;
        }
        if (ErrorUtils.isUninferredParameter(type2)) {
            if (this.getUninferredTypeParameterAsName()) {
                TypeConstructor typeConstructor2 = type2.getConstructor();
                if (typeConstructor2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                }
                String string = ((ErrorUtils.UninferredParameterTypeConstructor)typeConstructor2).getTypeParameterDescriptor().getName().toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "(type.constructor as Uni\u2026escriptor.name.toString()");
                $receiver.append(this.renderError(string));
            } else {
                $receiver.append("???");
            }
            return;
        }
        if (type2.isError()) {
            this.renderDefaultType($receiver, type2);
            return;
        }
        if (this.shouldRenderAsPrettyFunctionType(type2)) {
            this.renderFunctionType($receiver, type2);
        } else {
            this.renderDefaultType($receiver, type2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean shouldRenderAsPrettyFunctionType(KotlinType type2) {
        Object element$iv;
        TypeProjection it;
        if (!FunctionTypesKt.isBuiltinFunctionalType(type2)) return false;
        Iterable $receiver$iv = type2.getArguments();
        Iterator iterator2 = $receiver$iv.iterator();
        do {
            if (!iterator2.hasNext()) return true;
        } while (!(it = (TypeProjection)(element$iv = iterator2.next())).isStarProjection());
        return false;
    }

    @Override
    @NotNull
    public String renderFlexibleType(@NotNull String lowerRendered, @NotNull String upperRendered, @NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(lowerRendered, "lowerRendered");
        Intrinsics.checkParameterIsNotNull(upperRendered, "upperRendered");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        if (this.differsOnlyInNullability(lowerRendered, upperRendered)) {
            if (StringsKt.startsWith$default(upperRendered, "(", false, 2, null)) {
                return "(" + lowerRendered + ")!";
            }
            return lowerRendered + "!";
        }
        ClassifierNamePolicy classifierNamePolicy = this.getClassifierNamePolicy();
        ClassDescriptor classDescriptor = builtIns.getCollection();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "builtIns.collection");
        String kotlinCollectionsPrefix = StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(classDescriptor, this), "Collection", null, 2, null);
        String mutablePrefix = "Mutable";
        String simpleCollection = this.replacePrefixes(lowerRendered, kotlinCollectionsPrefix + mutablePrefix, upperRendered, kotlinCollectionsPrefix, kotlinCollectionsPrefix + "(" + mutablePrefix + ")");
        if (simpleCollection != null) {
            return simpleCollection;
        }
        String mutableEntry = this.replacePrefixes(lowerRendered, kotlinCollectionsPrefix + "MutableMap.MutableEntry", upperRendered, kotlinCollectionsPrefix + "Map.Entry", kotlinCollectionsPrefix + "(Mutable)Map.(Mutable)Entry");
        if (mutableEntry != null) {
            return mutableEntry;
        }
        ClassifierNamePolicy classifierNamePolicy2 = this.getClassifierNamePolicy();
        ClassDescriptor classDescriptor2 = builtIns.getArray();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptor2, "builtIns.array");
        String kotlinPrefix = StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(classDescriptor2, this), "Array", null, 2, null);
        String array = this.replacePrefixes(lowerRendered, kotlinPrefix + this.escape("Array<"), upperRendered, kotlinPrefix + this.escape("Array<out "), kotlinPrefix + this.escape("Array<(out) "));
        if (array != null) {
            return array;
        }
        return "(" + lowerRendered + ".." + upperRendered + ")";
    }

    @Override
    @NotNull
    public String renderTypeArguments(@NotNull List<? extends TypeProjection> typeArguments) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        $receiver.append(this.lt());
        this.appendTypeProjections($receiver, typeArguments);
        $receiver.append(this.gt());
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final void renderDefaultType(@NotNull StringBuilder $receiver, KotlinType type2) {
        this.renderAnnotations($receiver, type2);
        if (type2.isError()) {
            $receiver.append(type2.getConstructor().toString());
            $receiver.append(this.renderTypeArguments(type2.getArguments()));
        } else {
            DescriptorRendererImpl.renderTypeConstructorAndArguments$default(this, $receiver, type2, null, 2, null);
        }
        if (type2.isMarkedNullable()) {
            $receiver.append("?");
        }
    }

    private final void renderTypeConstructorAndArguments(@NotNull StringBuilder $receiver, KotlinType type2, TypeConstructor typeConstructor2) {
        PossiblyInnerType possiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(type2);
        if (possiblyInnerType == null) {
            $receiver.append(this.renderTypeConstructor(typeConstructor2));
            $receiver.append(this.renderTypeArguments(type2.getArguments()));
            return;
        }
        this.renderPossiblyInnerType($receiver, possiblyInnerType);
    }

    static /* bridge */ /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder stringBuilder, KotlinType kotlinType, TypeConstructor typeConstructor2, int n, Object object) {
        if ((n & 2) != 0) {
            typeConstructor2 = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(stringBuilder, kotlinType, typeConstructor2);
    }

    private final void renderPossiblyInnerType(@NotNull StringBuilder $receiver, PossiblyInnerType possiblyInnerType) {
        block3: {
            Object object;
            block2: {
                PossiblyInnerType possiblyInnerType2;
                object = possiblyInnerType.getOuterType();
                if (object == null) break block2;
                PossiblyInnerType it = possiblyInnerType2 = object;
                this.renderPossiblyInnerType($receiver, it);
                $receiver.append('.');
                Name name2 = possiblyInnerType.getClassifierDescriptor().getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "possiblyInnerType.classifierDescriptor.name");
                object = $receiver.append(this.renderName(name2));
                if (object != null) break block3;
            }
            TypeConstructor typeConstructor2 = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "possiblyInnerType.classi\u2026escriptor.typeConstructor");
            object = $receiver.append(this.renderTypeConstructor(typeConstructor2));
        }
        $receiver.append(this.renderTypeArguments(possiblyInnerType.getArguments()));
    }

    @Override
    @NotNull
    public String renderTypeConstructor(@NotNull TypeConstructor typeConstructor2) {
        String string;
        ClassifierDescriptor cd;
        Intrinsics.checkParameterIsNotNull(typeConstructor2, "typeConstructor");
        ClassifierDescriptor classifierDescriptor = cd = typeConstructor2.getDeclarationDescriptor();
        if (classifierDescriptor instanceof TypeParameterDescriptor || classifierDescriptor instanceof ClassDescriptor || classifierDescriptor instanceof TypeAliasDescriptor) {
            string = this.renderClassifierName(cd);
        } else if (Intrinsics.areEqual(classifierDescriptor, null)) {
            string = typeConstructor2.toString();
        } else {
            String string2 = "Unexpected classifier: " + cd.getClass();
            throw (Throwable)new IllegalStateException(string2.toString());
        }
        return string;
    }

    @Override
    @NotNull
    public String renderTypeProjection(@NotNull TypeProjection typeProjection) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(typeProjection, "typeProjection");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        this.appendTypeProjections($receiver, CollectionsKt.listOf(typeProjection));
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    private final void appendTypeProjections(@NotNull StringBuilder $receiver, List<? extends TypeProjection> typeProjections) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)typeProjections;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            String string;
            void it;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            Collection collection = destination$iv$iv;
            if (it.isStarProjection()) {
                string = "*";
            } else {
                KotlinType kotlinType = it.getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it.type");
                String type2 = this.renderType(kotlinType);
                string = Intrinsics.areEqual((Object)it.getProjectionKind(), (Object)Variance.INVARIANT) ? type2 : (Object)((Object)it.getProjectionKind()) + " " + type2;
            }
            String string2 = string;
            collection.add(string2);
        }
        CollectionsKt.joinTo$default((List)destination$iv$iv, $receiver, ", ", null, null, 0, null, null, 124, null);
    }

    private final void renderFunctionType(@NotNull StringBuilder $receiver, KotlinType type2) {
        boolean needParenthesis;
        DescriptorRendererImpl descriptorRendererImpl;
        int lengthBefore = $receiver.length();
        DescriptorRendererImpl $receiver2 = descriptorRendererImpl = this.getFunctionTypeAnnotationsRenderer();
        $receiver2.renderAnnotations($receiver, type2);
        boolean hasAnnotations = $receiver.length() != lengthBefore;
        boolean isNullable = type2.isMarkedNullable();
        KotlinType receiverType = FunctionTypesKt.getReceiverTypeFromFunctionType(type2);
        boolean bl = needParenthesis = isNullable || hasAnnotations && receiverType != null;
        if (needParenthesis && hasAnnotations) {
            boolean bl2;
            boolean bl3 = bl2 = StringsKt.last($receiver) == ' ';
            if (_Assertions.ENABLED && !bl2) {
                String string = "Assertion failed";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            if ($receiver.charAt(StringsKt.getLastIndex($receiver) - 1) != ')') {
                $receiver.insert(StringsKt.getLastIndex($receiver), "()");
            }
        }
        if (needParenthesis) {
            $receiver.append("(");
        }
        if (FunctionTypesKt.isSuspendFunctionType(type2)) {
            $receiver.append("suspend ");
        }
        if (receiverType != null) {
            boolean surroundReceiver;
            boolean bl4 = surroundReceiver = this.shouldRenderAsPrettyFunctionType(receiverType) && !receiverType.isMarkedNullable() || this.hasModifiersOrAnnotations(receiverType);
            if (surroundReceiver) {
                $receiver.append("(");
            }
            this.renderNormalizedType($receiver, receiverType);
            if (surroundReceiver) {
                $receiver.append(")");
            }
            $receiver.append(".");
        }
        $receiver.append("(");
        List<TypeProjection> parameterTypes = FunctionTypesKt.getValueParameterTypesFromFunctionType(type2);
        for (IndexedValue indexedValue : CollectionsKt.withIndex((Iterable)parameterTypes)) {
            Name name2;
            int index = indexedValue.component1();
            TypeProjection typeProjection = (TypeProjection)indexedValue.component2();
            if (index > 0) {
                $receiver.append(", ");
            }
            Name name3 = name2 = this.getParameterNamesInFunctionalTypes() ? FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(typeProjection.getType()) : null;
            if (name2 != null) {
                $receiver.append(this.renderName(name2));
                $receiver.append(": ");
            }
            $receiver.append(this.getFunctionTypeParameterTypesRenderer().renderTypeProjection(typeProjection));
        }
        $receiver.append(") ").append(this.arrow()).append(" ");
        this.renderNormalizedType($receiver, FunctionTypesKt.getReturnTypeFromFunctionType(type2));
        if (needParenthesis) {
            $receiver.append(")");
        }
        if (isNullable) {
            $receiver.append("?");
        }
    }

    private final boolean hasModifiersOrAnnotations(@NotNull KotlinType $receiver) {
        return FunctionTypesKt.isSuspendFunctionType($receiver) || !$receiver.getAnnotations().isEmpty();
    }

    private final void appendDefinedIn(@NotNull StringBuilder $receiver, DeclarationDescriptor descriptor2) {
        if (descriptor2 instanceof PackageFragmentDescriptor || descriptor2 instanceof PackageViewDescriptor) {
            return;
        }
        if (descriptor2 instanceof ModuleDescriptor) {
            $receiver.append(" is a module");
            return;
        }
        DeclarationDescriptor containingDeclaration = descriptor2.getContainingDeclaration();
        if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            String string;
            $receiver.append(" ").append(this.renderMessage("defined in")).append(" ");
            FqNameUnsafe fqName2 = DescriptorUtils.getFqName(containingDeclaration);
            if (fqName2.isRoot()) {
                string = "root package";
            } else {
                FqNameUnsafe fqNameUnsafe = fqName2;
                Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "fqName");
                string = this.renderFqName(fqNameUnsafe);
            }
            $receiver.append(string);
        }
    }

    private final void renderAnnotations(@NotNull StringBuilder $receiver, Annotated annotated) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.ANNOTATIONS) ^ true) {
            return;
        }
        Set<FqName> excluded = annotated instanceof KotlinType ? this.getExcludedTypeAnnotationClasses() : this.getExcludedAnnotationClasses();
        List<AnnotationWithTarget> sortedAnnotations = annotated.getAnnotations().getAllAnnotations();
        for (AnnotationWithTarget annotationWithTarget : sortedAnnotations) {
            AnnotationDescriptor annotation = annotationWithTarget.component1();
            AnnotationUseSiteTarget target = annotationWithTarget.component2();
            ClassifierDescriptor classifierDescriptor = annotation.getType().getConstructor().getDeclarationDescriptor();
            if (classifierDescriptor == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            ClassDescriptor annotationClass = (ClassDescriptor)classifierDescriptor;
            if (excluded.contains(DescriptorUtils.getFqNameSafe(annotationClass))) continue;
            $receiver.append(this.renderAnnotation(annotation, target)).append(" ");
        }
    }

    @Override
    @NotNull
    public String renderAnnotation(@NotNull AnnotationDescriptor annotation, @Nullable AnnotationUseSiteTarget target) {
        KotlinType annotationType;
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        $receiver.append('@');
        if (target != null) {
            $receiver.append(target.getRenderName() + ":");
        }
        KotlinType kotlinType = annotationType = annotation.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "annotationType");
        $receiver.append(this.renderType(kotlinType));
        if (this.getIncludeAnnotationArguments()) {
            Collection collection;
            List<String> arguments2 = this.renderAndSortAnnotationArguments(annotation);
            if (this.getIncludeEmptyAnnotationArguments() || !(collection = (Collection)arguments2).isEmpty()) {
                CollectionsKt.joinTo$default(arguments2, $receiver, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (this.getVerbose() && (annotationType.isError() || annotationType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor)) {
            $receiver.append(" /* annotation class not found */");
        }
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /*
     * WARNING - void declaration
     */
    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor descriptor2) {
        void $receiver$iv$iv;
        void $receiver$iv;
        String string;
        Collection collection;
        ValueParameterDescriptor it;
        Iterable $receiver$iv$iv2;
        Iterable $receiver$iv2;
        List list;
        Iterable destination$iv$iv;
        Map<ValueParameterDescriptor, ConstantValue<?>> allValueArguments2 = descriptor2.getAllValueArguments();
        ClassDescriptor classDescriptor = this.getRenderDefaultAnnotationArguments() ? TypeUtils.getClassDescriptor(descriptor2.getType()) : null;
        Object object = classDescriptor;
        if (object != null && (object = object.getUnsubstitutedPrimaryConstructor()) != null && (object = object.getValueParameters()) != null) {
            void $receiver$iv$iv3;
            Iterable $receiver$iv3;
            Iterable iterable = $receiver$iv3 = (Iterable)object;
            destination$iv$iv = new ArrayList();
            for (Iterator element$iv$iv : $receiver$iv$iv3) {
                ValueParameterDescriptor it2 = (ValueParameterDescriptor)((Object)element$iv$iv);
                if (!it2.declaresDefaultValue()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list = (List)destination$iv$iv;
        } else {
            list = CollectionsKt.emptyList();
        }
        List parameterDescriptorsWithDefaultValue = list;
        destination$iv$iv = $receiver$iv2 = (Iterable)parameterDescriptorsWithDefaultValue;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv2) {
            it = (ValueParameterDescriptor)element$iv$iv;
            if (!(!allValueArguments2.containsKey(it))) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        $receiver$iv2 = (List)destination$iv$iv2;
        $receiver$iv$iv2 = $receiver$iv2;
        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv : $receiver$iv$iv2) {
            it = (ValueParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv2;
            string = it.getName().asString() + " = ...";
            collection.add(string);
        }
        List defaultList = (List)destination$iv$iv2;
        $receiver$iv$iv2 = allValueArguments2.entrySet();
        destination$iv$iv2 = $receiver$iv;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            String string2;
            void entry;
            Map.Entry $i$a$2$map = (Map.Entry)item$iv$iv;
            collection = destination$iv$iv3;
            String name2 = ((ValueParameterDescriptor)entry.getKey()).getName().asString();
            if (!parameterDescriptorsWithDefaultValue.contains(entry.getKey())) {
                Object v = entry.getValue();
                Intrinsics.checkExpressionValueIsNotNull(v, "entry.value");
                string2 = this.renderConstant((ConstantValue)v);
            } else {
                string2 = "...";
            }
            String value = string2;
            string = name2 + " = " + value;
            collection.add(string);
        }
        List argumentList = (List)destination$iv$iv3;
        return CollectionsKt.sorted(CollectionsKt.plus((Collection)defaultList, (Iterable)argumentList));
    }

    /*
     * WARNING - void declaration
     */
    private final String renderConstant(ConstantValue<?> value) {
        String string;
        ConstantValue<?> constantValue = value;
        if (constantValue instanceof ArrayValue) {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)((ArrayValue)value).getValue();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                ConstantValue constantValue2 = (ConstantValue)item$iv$iv;
                Collection collection = destination$iv$iv;
                String string2 = this.renderConstant((ConstantValue<?>)it);
                collection.add(string2);
            }
            string = CollectionsKt.joinToString$default((List)destination$iv$iv, ", ", "{", "}", 0, null, null, 56, null);
        } else {
            string = constantValue instanceof AnnotationValue ? StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor)((AnnotationValue)value).getValue(), null, 2, null), (CharSequence)"@") : (constantValue instanceof KClassValue ? this.renderType(((KClassValue)value).getValue()) + "::class" : value.toString());
        }
        return string;
    }

    private final void renderVisibility(Visibility visibility, StringBuilder builder) {
        Visibility visibility2 = visibility;
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.VISIBILITY) ^ true) {
            return;
        }
        if (this.getNormalizedVisibilities()) {
            visibility2 = visibility2.normalize();
        }
        if (!this.getShowInternalKeyword() && Intrinsics.areEqual(visibility2, Visibilities.DEFAULT_VISIBILITY)) {
            return;
        }
        builder.append(this.renderKeyword(visibility2.getDisplayName())).append(" ");
    }

    private final void renderModality(Modality modality, StringBuilder builder) {
        String string;
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.MODALITY) ^ true) {
            return;
        }
        String string2 = string = modality.name();
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
        String keyword = string3;
        builder.append(this.renderKeyword(keyword)).append(" ");
    }

    private final void renderHeader(boolean isHeader, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.HEADER) ^ true) {
            return;
        }
        if (isHeader) {
            builder.append(this.renderKeyword("header")).append(" ");
        }
    }

    private final void renderImpl(boolean isImpl, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.IMPL) ^ true) {
            return;
        }
        if (isImpl) {
            builder.append(this.renderKeyword("impl")).append(" ");
        }
    }

    private final void renderInner(boolean isInner2, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.INNER) ^ true) {
            return;
        }
        if (isInner2) {
            builder.append(this.renderKeyword("inner")).append(" ");
        }
    }

    private final void renderData(boolean isData, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.DATA) ^ true || !isData) {
            return;
        }
        builder.append(this.renderKeyword("data")).append(" ");
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callable, StringBuilder builder) {
        if (!DescriptorUtils.isTopLevelDeclaration(callable) || Intrinsics.areEqual((Object)callable.getModality(), (Object)Modality.FINAL) ^ true) {
            if (this.overridesSomething(callable) && Intrinsics.areEqual((Object)this.getOverrideRenderingPolicy(), (Object)OverrideRenderingPolicy.RENDER_OVERRIDE) && Intrinsics.areEqual((Object)callable.getModality(), (Object)Modality.OPEN)) {
                return;
            }
            Modality modality = callable.getModality();
            Intrinsics.checkExpressionValueIsNotNull((Object)modality, "callable.modality");
            this.renderModality(modality, builder);
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.OVERRIDE) ^ true) {
            return;
        }
        if (this.overridesSomething(callableMember) && Intrinsics.areEqual((Object)this.getOverrideRenderingPolicy(), (Object)OverrideRenderingPolicy.RENDER_OPEN) ^ true) {
            builder.append("override ");
            if (this.getVerbose()) {
                builder.append("/*").append(callableMember.getOverriddenDescriptors().size()).append("*/ ");
            }
        }
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (this.getModifiers().contains((Object)DescriptorRendererModifier.MEMBER_KIND) ^ true) {
            return;
        }
        if (this.getVerbose() && Intrinsics.areEqual((Object)callableMember.getKind(), (Object)CallableMemberDescriptor.Kind.DECLARATION) ^ true) {
            String string = callableMember.getKind().name();
            StringBuilder stringBuilder = builder.append("/*");
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).toLowerCase()");
            String string4 = string3;
            stringBuilder.append(string4).append("*/ ");
        }
    }

    private final void renderCallableModifiers(CallableMemberDescriptor descriptor2, StringBuilder builder) {
        this.renderExternal(descriptor2, builder);
        if (descriptor2.isHeader()) {
            builder.append("header ");
        }
        if (descriptor2.isImpl()) {
            builder.append("impl ");
        }
    }

    private final void renderExternal(MemberDescriptor memberDescriptor, StringBuilder builder) {
        if (memberDescriptor.isExternal()) {
            builder.append("external ");
        }
    }

    private final void renderLateInit(PropertyDescriptor propertyDescriptor, StringBuilder builder) {
        if (propertyDescriptor.isLateInit()) {
            builder.append("lateinit ");
        }
    }

    private final void renderAdditionalModifiers(FunctionDescriptor functionDescriptor, StringBuilder builder) {
        FunctionDescriptor it;
        Iterable $receiver$iv;
        if (functionDescriptor.isOperator()) {
            boolean bl;
            block9: {
                $receiver$iv = functionDescriptor.getOverriddenDescriptors();
                for (Object element$iv : $receiver$iv) {
                    it = (FunctionDescriptor)element$iv;
                    if (!it.isOperator()) continue;
                    bl = false;
                    break block9;
                }
                bl = true;
            }
            if (bl || this.getAlwaysRenderModifiers()) {
                builder.append("operator ");
            }
        }
        if (functionDescriptor.isInfix()) {
            boolean bl;
            block10: {
                $receiver$iv = functionDescriptor.getOverriddenDescriptors();
                for (Object element$iv : $receiver$iv) {
                    it = (FunctionDescriptor)element$iv;
                    if (!it.isInfix()) continue;
                    bl = false;
                    break block10;
                }
                bl = true;
            }
            if (bl || this.getAlwaysRenderModifiers()) {
                builder.append("infix ");
            }
        }
        this.renderCallableModifiers(functionDescriptor, builder);
        if (functionDescriptor.isInline()) {
            builder.append("inline ");
        }
        if (functionDescriptor.isTailrec()) {
            builder.append("tailrec ");
        }
        if (functionDescriptor.isSuspend()) {
            builder.append("suspend ");
        }
    }

    @Override
    @NotNull
    public String render(@NotNull DeclarationDescriptor declarationDescriptor) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "declarationDescriptor");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), $receiver);
        if (this.getWithDefinedIn()) {
            this.appendDefinedIn($receiver, declarationDescriptor);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final void renderTypeParameter(TypeParameterDescriptor typeParameter, StringBuilder builder, boolean topLevel) {
        String variance;
        CharSequence charSequence;
        if (topLevel) {
            builder.append(this.lt());
        }
        if (this.getVerbose()) {
            builder.append("/*").append(typeParameter.getIndex()).append("*/ ");
        }
        if (typeParameter.isReified()) {
            builder.append(this.renderKeyword("reified")).append(" ");
        }
        if (!((charSequence = (CharSequence)(variance = typeParameter.getVariance().getLabel())).length() == 0)) {
            builder.append(this.renderKeyword(variance)).append(" ");
        }
        this.renderAnnotations(builder, typeParameter);
        this.renderName(typeParameter, builder);
        int upperBoundsCount = typeParameter.getUpperBounds().size();
        if (upperBoundsCount > 1 && !topLevel || upperBoundsCount == 1) {
            KotlinType upperBound = typeParameter.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(upperBound)) {
                StringBuilder stringBuilder = builder.append(" : ");
                KotlinType kotlinType = upperBound;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "upperBound");
                stringBuilder.append(this.renderType(kotlinType));
            }
        } else if (topLevel) {
            boolean first = true;
            for (KotlinType upperBound : typeParameter.getUpperBounds()) {
                if (KotlinBuiltIns.isDefaultBound(upperBound)) continue;
                if (first) {
                    builder.append(" : ");
                } else {
                    builder.append(" & ");
                }
                KotlinType kotlinType = upperBound;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "upperBound");
                builder.append(this.renderType(kotlinType));
                first = false;
            }
        }
        if (topLevel) {
            builder.append(this.gt());
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> typeParameters2, StringBuilder builder, boolean withSpace) {
        if (this.getWithoutTypeParameters()) {
            return;
        }
        if (!typeParameters2.isEmpty()) {
            builder.append(this.lt());
            this.renderTypeParameterList(builder, typeParameters2);
            builder.append(this.gt());
            if (withSpace) {
                builder.append(" ");
            }
        }
    }

    private final void renderTypeParameterList(StringBuilder builder, List<? extends TypeParameterDescriptor> typeParameters2) {
        Iterator<? extends TypeParameterDescriptor> iterator2 = typeParameters2.iterator();
        while (iterator2.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptor = iterator2.next();
            this.renderTypeParameter(typeParameterDescriptor, builder, false);
            if (!iterator2.hasNext()) continue;
            builder.append(", ");
        }
    }

    private final void renderFunction(FunctionDescriptor function, StringBuilder builder) {
        if (!this.getStartFromName()) {
            if (!this.getStartFromDeclarationKeyword()) {
                this.renderAnnotations(builder, function);
                Visibility visibility = function.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "function.visibility");
                this.renderVisibility(visibility, builder);
                this.renderModalityForCallable(function, builder);
                if (this.getIncludeAdditionalModifiers()) {
                    this.renderAdditionalModifiers(function, builder);
                }
                this.renderOverride(function, builder);
                this.renderMemberKind(function, builder);
                if (this.getVerbose()) {
                    if (function.isHiddenToOvercomeSignatureClash()) {
                        builder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (function.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        builder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            builder.append(this.renderKeyword("fun")).append(" ");
            List<TypeParameterDescriptor> list = function.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "function.typeParameters");
            this.renderTypeParameters(list, builder, true);
            this.renderReceiver(function, builder);
        }
        this.renderName(function, builder);
        List<ValueParameterDescriptor> list = function.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "function.valueParameters");
        this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list, function.hasSynthesizedParameterNames(), builder);
        this.renderReceiverAfterName(function, builder);
        KotlinType returnType = function.getReturnType();
        if (!(this.getWithoutReturnType() || !this.getUnitReturnType() && returnType != null && KotlinBuiltIns.isUnit(returnType))) {
            builder.append(": ").append(returnType == null ? "[NULL]" : this.renderType(returnType));
        }
        List<TypeParameterDescriptor> list2 = function.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(list2, "function.typeParameters");
        this.renderWhereSuffix(list2, builder);
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder builder) {
        if (!this.getReceiverAfterName()) {
            return;
        }
        ReceiverParameterDescriptor receiver = callableDescriptor.getExtensionReceiverParameter();
        if (receiver != null) {
            StringBuilder stringBuilder = builder.append(" on ");
            KotlinType kotlinType = receiver.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "receiver.type");
            stringBuilder.append(this.renderType(kotlinType));
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder builder) {
        ReceiverParameterDescriptor receiver = callableDescriptor.getExtensionReceiverParameter();
        if (receiver != null) {
            KotlinType type2;
            KotlinType kotlinType = type2 = receiver.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
            String result2 = this.renderType(kotlinType);
            KotlinType kotlinType2 = type2;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "type");
            if (this.shouldRenderAsPrettyFunctionType(kotlinType2) && !TypeUtils.isNullableType(type2)) {
                result2 = "(" + result2 + ")";
            }
            builder.append(result2).append(".");
        }
    }

    private final void renderConstructor(ConstructorDescriptor constructor, StringBuilder builder) {
        this.renderAnnotations(builder, constructor);
        Visibility visibility = constructor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "constructor.visibility");
        this.renderVisibility(visibility, builder);
        this.renderMemberKind(constructor, builder);
        if (this.getRenderConstructorKeyword()) {
            builder.append(this.renderKeyword("constructor"));
        }
        if (this.getSecondaryConstructorsAsPrimary()) {
            ClassifierDescriptorWithTypeParameters classDescriptor = constructor.getContainingDeclaration();
            if (this.getRenderConstructorKeyword()) {
                builder.append(" ");
            }
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classDescriptor;
            Intrinsics.checkExpressionValueIsNotNull(classifierDescriptorWithTypeParameters, "classDescriptor");
            this.renderName(classifierDescriptorWithTypeParameters, builder);
            List<TypeParameterDescriptor> list = constructor.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "constructor.typeParameters");
            this.renderTypeParameters(list, builder, false);
        }
        List<ValueParameterDescriptor> list = constructor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "constructor.valueParameters");
        this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list, constructor.hasSynthesizedParameterNames(), builder);
        if (this.getSecondaryConstructorsAsPrimary()) {
            List<TypeParameterDescriptor> list2 = constructor.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(list2, "constructor.typeParameters");
            this.renderWhereSuffix(list2, builder);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> typeParameters2, StringBuilder builder) {
        if (this.getWithoutTypeParameters()) {
            return;
        }
        ArrayList upperBoundStrings = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : typeParameters2) {
            void $receiver$iv;
            Iterable iterable = CollectionsKt.drop((Iterable)typeParameterDescriptor.getUpperBounds(), 1);
            for (Object item$iv : $receiver$iv) {
                void it;
                KotlinType kotlinType = (KotlinType)item$iv;
                Collection collection = upperBoundStrings;
                StringBuilder stringBuilder = new StringBuilder();
                Name name2 = typeParameterDescriptor.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "typeParameter.name");
                StringBuilder stringBuilder2 = stringBuilder.append(this.renderName(name2)).append(" : ");
                void v3 = it;
                Intrinsics.checkExpressionValueIsNotNull(v3, "it");
                String string = stringBuilder2.append(this.renderType((KotlinType)v3)).toString();
                collection.add(string);
            }
        }
        if (!upperBoundStrings.isEmpty()) {
            builder.append(" ").append(this.renderKeyword("where")).append(" ");
            CollectionsKt.joinTo$default(upperBoundStrings, builder, ", ", null, null, 0, null, null, 124, null);
        }
    }

    @Override
    @NotNull
    public String renderValueParameters(@NotNull Collection<? extends ValueParameterDescriptor> parameters2, boolean synthesizedParameterNames) {
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull(parameters2, "parameters");
        StringBuilder $receiver = stringBuilder = new StringBuilder();
        this.renderValueParameters(parameters2, synthesizedParameterNames, $receiver);
        String string = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> parameters2, boolean synthesizedParameterNames, StringBuilder builder) {
        boolean includeNames = this.shouldRenderParameterNames(synthesizedParameterNames);
        int parameterCount = parameters2.size();
        this.getValueParametersHandler().appendBeforeValueParameters(parameterCount, builder);
        for (IndexedValue indexedValue : CollectionsKt.withIndex((Iterable)parameters2)) {
            int index = indexedValue.component1();
            ValueParameterDescriptor parameter = (ValueParameterDescriptor)indexedValue.component2();
            this.getValueParametersHandler().appendBeforeValueParameter(parameter, index, parameterCount, builder);
            this.renderValueParameter(parameter, includeNames, builder, false);
            this.getValueParametersHandler().appendAfterValueParameter(parameter, index, parameterCount, builder);
        }
        this.getValueParametersHandler().appendAfterValueParameters(parameterCount, builder);
    }

    private final boolean shouldRenderParameterNames(boolean synthesizedParameterNames) {
        switch (DescriptorRendererImpl$WhenMappings.$EnumSwitchMapping$4[this.getParameterNameRenderingPolicy().ordinal()]) {
            case 1: {
                return true;
            }
            case 2: {
                return !synthesizedParameterNames;
            }
            case 3: {
                return false;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void renderValueParameter(ValueParameterDescriptor valueParameter, boolean includeName, StringBuilder builder, boolean topLevel) {
        boolean withDefaultValue;
        if (topLevel) {
            builder.append(this.renderKeyword("value-parameter")).append(" ");
        }
        if (this.getVerbose()) {
            builder.append("/*").append(valueParameter.getIndex()).append("*/ ");
        }
        this.renderAnnotations(builder, valueParameter);
        if (valueParameter.isCrossinline()) {
            builder.append("crossinline ");
        }
        if (valueParameter.isNoinline()) {
            builder.append("noinline ");
        }
        this.renderVariable(valueParameter, includeName, builder, topLevel);
        boolean bl = this.getRenderDefaultValues() && (this.getDebugMode() ? valueParameter.declaresDefaultValue() : DescriptorUtilsKt.hasDefaultValue(valueParameter)) ? true : (withDefaultValue = false);
        if (withDefaultValue) {
            builder.append(" = ...");
        }
    }

    private final void renderValVarPrefix(VariableDescriptor variable, StringBuilder builder) {
        if (!(variable instanceof ValueParameterDescriptor)) {
            builder.append(this.renderKeyword(variable.isVar() ? "var" : "val")).append(" ");
        }
    }

    private final void renderVariable(VariableDescriptor variable, boolean includeName, StringBuilder builder, boolean topLevel) {
        KotlinType realType = variable.getType();
        VariableDescriptor variableDescriptor = variable;
        if (!(variableDescriptor instanceof ValueParameterDescriptor)) {
            variableDescriptor = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)variableDescriptor;
        KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        KotlinType kotlinType = varargElementType;
        if (kotlinType == null) {
            KotlinType kotlinType2 = realType;
            kotlinType = kotlinType2;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "realType");
        }
        KotlinType typeToRender = kotlinType;
        if (varargElementType != null) {
            builder.append(this.renderKeyword("vararg")).append(" ");
        }
        if (topLevel && !this.getStartFromName()) {
            this.renderValVarPrefix(variable, builder);
        }
        if (includeName) {
            this.renderName(variable, builder);
            builder.append(": ");
        }
        builder.append(this.renderType(typeToRender));
        this.renderInitializer(variable, builder);
        if (this.getVerbose() && varargElementType != null) {
            StringBuilder stringBuilder = builder.append(" /*");
            KotlinType kotlinType3 = realType;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "realType");
            stringBuilder.append(this.renderType(kotlinType3)).append("*/");
        }
    }

    private final void renderProperty(PropertyDescriptor property, StringBuilder builder) {
        if (!this.getStartFromName()) {
            if (!this.getStartFromDeclarationKeyword()) {
                this.renderAnnotations(builder, property);
                Visibility visibility = property.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "property.visibility");
                this.renderVisibility(visibility, builder);
                if (property.isConst()) {
                    builder.append("const ");
                }
                this.renderCallableModifiers(property, builder);
                this.renderModalityForCallable(property, builder);
                this.renderOverride(property, builder);
                this.renderLateInit(property, builder);
                this.renderMemberKind(property, builder);
            }
            this.renderValVarPrefix(property, builder);
            List<TypeParameterDescriptor> list = property.getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "property.typeParameters");
            this.renderTypeParameters(list, builder, true);
            this.renderReceiver(property, builder);
        }
        this.renderName(property, builder);
        StringBuilder stringBuilder = builder.append(": ");
        KotlinType kotlinType = property.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "property.type");
        stringBuilder.append(this.renderType(kotlinType));
        this.renderReceiverAfterName(property, builder);
        this.renderInitializer(property, builder);
        List<TypeParameterDescriptor> list = property.getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "property.typeParameters");
        this.renderWhereSuffix(list, builder);
    }

    private final void renderInitializer(VariableDescriptor variable, StringBuilder builder) {
        block1: {
            if (!this.getIncludePropertyConstant()) break block1;
            ConstantValue<?> constantValue = variable.getCompileTimeInitializer();
            if (constantValue != null) {
                ConstantValue<?> constantValue2;
                ConstantValue<?> constant = constantValue2 = constantValue;
                StringBuilder stringBuilder = builder.append(" = ");
                ConstantValue<?> constantValue3 = constant;
                Intrinsics.checkExpressionValueIsNotNull(constantValue3, "constant");
                stringBuilder.append(this.escape(this.renderConstant(constantValue3)));
            }
        }
    }

    private final void renderTypeAlias(TypeAliasDescriptor typeAlias, StringBuilder builder) {
        this.renderAnnotations(builder, typeAlias);
        Visibility visibility = typeAlias.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(visibility, "typeAlias.visibility");
        this.renderVisibility(visibility, builder);
        builder.append(this.renderKeyword("typealias")).append(" ");
        this.renderName(typeAlias, builder);
        List<TypeParameterDescriptor> list = typeAlias.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "typeAlias.declaredTypeParameters");
        this.renderTypeParameters(list, builder, true);
        this.renderCapturedTypeParametersIfRequired(typeAlias, builder);
        builder.append(" = ").append(this.renderType(typeAlias.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifier2, StringBuilder builder) {
        List<TypeParameterDescriptor> typeParameters2 = classifier2.getDeclaredTypeParameters();
        List<TypeParameterDescriptor> typeConstructorParameters = classifier2.getTypeConstructor().getParameters();
        if (this.getVerbose() && classifier2.isInner() && typeConstructorParameters.size() > typeParameters2.size()) {
            builder.append(" /*captured type parameters: ");
            this.renderTypeParameterList(builder, typeConstructorParameters.subList(typeParameters2.size(), typeConstructorParameters.size()));
            builder.append("*/");
        }
    }

    private final void renderClass(ClassDescriptor klass, StringBuilder builder) {
        ClassConstructorDescriptor primaryConstructor2;
        List<TypeParameterDescriptor> typeParameters2;
        boolean isEnumEntry = Intrinsics.areEqual((Object)klass.getKind(), (Object)ClassKind.ENUM_ENTRY);
        if (!this.getStartFromName()) {
            this.renderAnnotations(builder, klass);
            if (!isEnumEntry) {
                Visibility visibility = klass.getVisibility();
                Intrinsics.checkExpressionValueIsNotNull(visibility, "klass.visibility");
                this.renderVisibility(visibility, builder);
            }
            this.renderExternal(klass, builder);
            if (!(Intrinsics.areEqual((Object)klass.getKind(), (Object)ClassKind.INTERFACE) && Intrinsics.areEqual((Object)klass.getModality(), (Object)Modality.ABSTRACT) || klass.getKind().isSingleton() && Intrinsics.areEqual((Object)klass.getModality(), (Object)Modality.FINAL))) {
                Modality modality = klass.getModality();
                Intrinsics.checkExpressionValueIsNotNull((Object)modality, "klass.modality");
                this.renderModality(modality, builder);
            }
            this.renderHeader(klass.isHeader(), builder);
            this.renderImpl(klass.isImpl(), builder);
            this.renderInner(klass.isInner(), builder);
            this.renderData(klass.isData(), builder);
            this.renderClassKindPrefix(klass, builder);
        }
        if (!DescriptorUtils.isCompanionObject(klass)) {
            if (!this.getStartFromName()) {
                this.renderSpaceIfNeeded(builder);
            }
            this.renderName(klass, builder);
        } else {
            this.renderCompanionObjectName(klass, builder);
        }
        if (isEnumEntry) {
            return;
        }
        List<TypeParameterDescriptor> list = typeParameters2 = klass.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "typeParameters");
        this.renderTypeParameters(list, builder, false);
        this.renderCapturedTypeParametersIfRequired(klass, builder);
        if (!klass.getKind().isSingleton() && this.getClassWithPrimaryConstructor() && (primaryConstructor2 = klass.getUnsubstitutedPrimaryConstructor()) != null) {
            builder.append(" ");
            this.renderAnnotations(builder, primaryConstructor2);
            Visibility visibility = primaryConstructor2.getVisibility();
            Intrinsics.checkExpressionValueIsNotNull(visibility, "primaryConstructor.visibility");
            this.renderVisibility(visibility, builder);
            builder.append("constructor");
            List<ValueParameterDescriptor> list2 = primaryConstructor2.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(list2, "primaryConstructor.valueParameters");
            this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list2, primaryConstructor2.hasSynthesizedParameterNames(), builder);
        }
        this.renderSuperTypes(klass, builder);
        List<TypeParameterDescriptor> list3 = typeParameters2;
        Intrinsics.checkExpressionValueIsNotNull(list3, "typeParameters");
        this.renderWhereSuffix(list3, builder);
    }

    /*
     * WARNING - void declaration
     */
    private final void renderSuperTypes(ClassDescriptor klass, StringBuilder builder) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if (this.getWithoutSuperTypes()) {
            return;
        }
        if (KotlinBuiltIns.isNothing(klass.getDefaultType())) {
            return;
        }
        Collection<KotlinType> supertypes2 = klass.getTypeConstructor().getSupertypes();
        if (supertypes2.isEmpty() || supertypes2.size() == 1 && KotlinBuiltIns.isAnyOrNullableAny(supertypes2.iterator().next())) {
            return;
        }
        this.renderSpaceIfNeeded(builder);
        builder.append(": ");
        Iterable iterable = $receiver$iv = (Iterable)supertypes2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            KotlinType kotlinType = (KotlinType)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = it;
            Intrinsics.checkExpressionValueIsNotNull(v0, "it");
            String string = this.renderType((KotlinType)v0);
            collection.add(string);
        }
        CollectionsKt.joinTo$default((List)destination$iv$iv, builder, ", ", null, null, 0, null, null, 124, null);
    }

    private final void renderClassKindPrefix(ClassDescriptor klass, StringBuilder builder) {
        builder.append(this.renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(klass)));
    }

    private final void renderPackageView(PackageViewDescriptor packageView, StringBuilder builder) {
        this.renderPackageHeader(packageView.getFqName(), "package", builder);
        if (this.getDebugMode()) {
            builder.append(" in context of ");
            this.renderName(packageView.getModule(), builder);
        }
    }

    private final void renderPackageFragment(PackageFragmentDescriptor fragment, StringBuilder builder) {
        this.renderPackageHeader(fragment.getFqName(), "package-fragment", builder);
        if (this.getDebugMode()) {
            builder.append(" in ");
            this.renderName(fragment.getContainingDeclaration(), builder);
        }
    }

    private final void renderPackageHeader(FqName fqName2, String fragmentOrView, StringBuilder builder) {
        builder.append(this.renderKeyword(fragmentOrView));
        FqNameUnsafe fqNameUnsafe = fqName2.toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "fqName.toUnsafe()");
        String fqNameString = this.renderFqName(fqNameUnsafe);
        CharSequence charSequence = fqNameString;
        if (charSequence.length() > 0) {
            builder.append(" ");
            builder.append(fqNameString);
        }
    }

    private final void renderAccessorModifiers(PropertyAccessorDescriptor descriptor2, StringBuilder builder) {
        this.renderCallableModifiers(descriptor2, builder);
    }

    private final void renderSpaceIfNeeded(StringBuilder builder) {
        int length = builder.length();
        if (length == 0 || builder.charAt(length - 1) != ' ') {
            builder.append(' ');
        }
    }

    private final String replacePrefixes(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, null)) {
            String string = lowerRendered;
            int n = lowerPrefix.length();
            String string2 = string;
            if (string2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string3 = string2.substring(n);
            Intrinsics.checkExpressionValueIsNotNull(string3, "(this as java.lang.String).substring(startIndex)");
            String lowerWithoutPrefix = string3;
            String string4 = upperRendered;
            int n2 = upperPrefix.length();
            String string5 = string4;
            if (string5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string6 = string5.substring(n2);
            Intrinsics.checkExpressionValueIsNotNull(string6, "(this as java.lang.String).substring(startIndex)");
            String upperWithoutPrefix = string6;
            String flexibleCollectionName = foldedPrefix + lowerWithoutPrefix;
            if (Intrinsics.areEqual(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName;
            }
            if (this.differsOnlyInNullability(lowerWithoutPrefix, upperWithoutPrefix)) {
                return flexibleCollectionName + "!";
            }
        }
        return null;
    }

    private final boolean differsOnlyInNullability(String lower, String upper) {
        return Intrinsics.areEqual(lower, StringsKt.replace$default(upper, "?", "", false, 4, null)) || StringsKt.endsWith$default(upper, "?", false, 2, null) && Intrinsics.areEqual(lower + "?", upper) || Intrinsics.areEqual("(" + lower + ")?", upper);
    }

    private final boolean overridesSomething(CallableMemberDescriptor callable) {
        return !callable.getOverriddenDescriptors().isEmpty();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl options) {
        Intrinsics.checkParameterIsNotNull(options, "options");
        this.options = options;
        boolean bl = this.options.isLocked();
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy((Function0)new Function0<DescriptorRendererImpl>(this){
            final /* synthetic */ DescriptorRendererImpl this$0;

            @NotNull
            public final DescriptorRendererImpl invoke() {
                DescriptorRenderer descriptorRenderer2 = this.this$0.withOptions(functionTypeAnnotationsRenderer.1.INSTANCE);
                if (descriptorRenderer2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
                }
                return (DescriptorRendererImpl)descriptorRenderer2;
            }
            {
                this.this$0 = descriptorRendererImpl;
                super(0);
            }
        });
        this.functionTypeParameterTypesRenderer$delegate = LazyKt.lazy((Function0)new Function0<DescriptorRenderer>(this){
            final /* synthetic */ DescriptorRendererImpl this$0;

            @NotNull
            public final DescriptorRenderer invoke() {
                return this.this$0.withOptions(functionTypeParameterTypesRenderer.1.INSTANCE);
            }
            {
                this.this$0 = descriptorRendererImpl;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererImpl.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DescriptorRendererImpl.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;"))};
    }

    @Override
    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override
    public void setAlwaysRenderModifiers(boolean bl) {
        this.options.setAlwaysRenderModifiers(bl);
    }

    @Override
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    @Override
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override
    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    @Override
    public void setClassWithPrimaryConstructor(boolean bl) {
        this.options.setClassWithPrimaryConstructor(bl);
    }

    @Override
    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkParameterIsNotNull(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    @Override
    public void setDebugMode(boolean bl) {
        this.options.setDebugMode(bl);
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override
    public void setExcludedAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.options.setExcludedAnnotationClasses(set);
    }

    @Override
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    @Override
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Override
    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    @Override
    public void setIncludeAdditionalModifiers(boolean bl) {
        this.options.setIncludeAdditionalModifiers(bl);
    }

    @Override
    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    @Override
    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    @Override
    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    @Override
    public void setIncludePropertyConstant(boolean bl) {
        this.options.setIncludePropertyConstant(bl);
    }

    @Override
    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    @Override
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkParameterIsNotNull(set, "<set-?>");
        this.options.setModifiers(set);
    }

    @Override
    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    @Override
    public void setNormalizedVisibilities(boolean bl) {
        this.options.setNormalizedVisibilities(bl);
    }

    @Override
    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    @Override
    public void setOverrideRenderingPolicy(@NotNull OverrideRenderingPolicy overrideRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)overrideRenderingPolicy, "<set-?>");
        this.options.setOverrideRenderingPolicy(overrideRenderingPolicy);
    }

    @Override
    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    @Override
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkParameterIsNotNull((Object)parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override
    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    @Override
    public void setParameterNamesInFunctionalTypes(boolean bl) {
        this.options.setParameterNamesInFunctionalTypes(bl);
    }

    @Override
    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    @Override
    public void setReceiverAfterName(boolean bl) {
        this.options.setReceiverAfterName(bl);
    }

    @Override
    public boolean getRenderAccessors() {
        return this.options.getRenderAccessors();
    }

    @Override
    public void setRenderAccessors(boolean bl) {
        this.options.setRenderAccessors(bl);
    }

    @Override
    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    @Override
    public void setRenderCompanionObjectName(boolean bl) {
        this.options.setRenderCompanionObjectName(bl);
    }

    @Override
    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    @Override
    public void setRenderConstructorKeyword(boolean bl) {
        this.options.setRenderConstructorKeyword(bl);
    }

    @Override
    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    @Override
    public void setRenderDefaultAnnotationArguments(boolean bl) {
        this.options.setRenderDefaultAnnotationArguments(bl);
    }

    @Override
    public boolean getRenderDefaultValues() {
        return this.options.getRenderDefaultValues();
    }

    @Override
    public void setRenderDefaultValues(boolean bl) {
        this.options.setRenderDefaultValues(bl);
    }

    @Override
    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    @Override
    public void setRenderUnabbreviatedType(boolean bl) {
        this.options.setRenderUnabbreviatedType(bl);
    }

    @Override
    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    @Override
    public void setSecondaryConstructorsAsPrimary(boolean bl) {
        this.options.setSecondaryConstructorsAsPrimary(bl);
    }

    @Override
    public boolean getShowInternalKeyword() {
        return this.options.getShowInternalKeyword();
    }

    @Override
    public void setShowInternalKeyword(boolean bl) {
        this.options.setShowInternalKeyword(bl);
    }

    @Override
    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    @Override
    public void setStartFromDeclarationKeyword(boolean bl) {
        this.options.setStartFromDeclarationKeyword(bl);
    }

    @Override
    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    @Override
    public void setStartFromName(boolean bl) {
        this.options.setStartFromName(bl);
    }

    @Override
    @NotNull
    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    @Override
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkParameterIsNotNull((Object)renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    @Override
    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    @Override
    public void setTypeNormalizer(@NotNull Function1<? super KotlinType, ? extends KotlinType> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.options.setTypeNormalizer(function1);
    }

    @Override
    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    @Override
    public void setUninferredTypeParameterAsName(boolean bl) {
        this.options.setUninferredTypeParameterAsName(bl);
    }

    @Override
    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    @Override
    public void setUnitReturnType(boolean bl) {
        this.options.setUnitReturnType(bl);
    }

    @Override
    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    @Override
    public void setValueParametersHandler(@NotNull DescriptorRenderer.ValueParametersHandler valueParametersHandler) {
        Intrinsics.checkParameterIsNotNull(valueParametersHandler, "<set-?>");
        this.options.setValueParametersHandler(valueParametersHandler);
    }

    @Override
    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    @Override
    public void setVerbose(boolean bl) {
        this.options.setVerbose(bl);
    }

    @Override
    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    @Override
    public void setWithDefinedIn(boolean bl) {
        this.options.setWithDefinedIn(bl);
    }

    @Override
    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    @Override
    public void setWithoutReturnType(boolean bl) {
        this.options.setWithoutReturnType(bl);
    }

    @Override
    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    @Override
    public void setWithoutSuperTypes(boolean bl) {
        this.options.setWithoutSuperTypes(bl);
    }

    @Override
    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override
    public void setWithoutTypeParameters(boolean bl) {
        this.options.setWithoutTypeParameters(bl);
    }

    private final class RenderDeclarationDescriptorVisitor
    implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        @Override
        public void visitValueParameterDescriptor(@NotNull ValueParameterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderValueParameter(descriptor2, true, builder, true);
        }

        @Override
        public void visitVariableDescriptor(@NotNull VariableDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderVariable(descriptor2, true, builder, true);
        }

        @Override
        public void visitPropertyDescriptor(@NotNull PropertyDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderProperty(descriptor2, builder);
        }

        @Override
        public void visitPropertyGetterDescriptor(@NotNull PropertyGetterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            if (DescriptorRendererImpl.this.getRenderAccessors()) {
                DescriptorRendererImpl.this.renderAccessorModifiers(descriptor2, builder);
                builder.append("getter for ");
                PropertyDescriptor propertyDescriptor = descriptor2.getCorrespondingProperty();
                Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "descriptor.correspondingProperty");
                DescriptorRendererImpl.this.renderProperty(propertyDescriptor, builder);
            } else {
                this.visitFunctionDescriptor((FunctionDescriptor)descriptor2, builder);
            }
        }

        @Override
        public void visitPropertySetterDescriptor(@NotNull PropertySetterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            if (DescriptorRendererImpl.this.getRenderAccessors()) {
                DescriptorRendererImpl.this.renderAccessorModifiers(descriptor2, builder);
                builder.append("setter for ");
                PropertyDescriptor propertyDescriptor = descriptor2.getCorrespondingProperty();
                Intrinsics.checkExpressionValueIsNotNull(propertyDescriptor, "descriptor.correspondingProperty");
                DescriptorRendererImpl.this.renderProperty(propertyDescriptor, builder);
            } else {
                this.visitFunctionDescriptor((FunctionDescriptor)descriptor2, builder);
            }
        }

        @Override
        public void visitFunctionDescriptor(@NotNull FunctionDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderFunction(descriptor2, builder);
        }

        @Override
        public void visitReceiverParameterDescriptor(@NotNull ReceiverParameterDescriptor descriptor2, @NotNull StringBuilder data2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(data2, "data");
            throw (Throwable)new UnsupportedOperationException("Don't render receiver parameters");
        }

        @Override
        public void visitConstructorDescriptor(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, builder);
        }

        @Override
        public void visitTypeParameterDescriptor(@NotNull TypeParameterDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(descriptor2, builder, true);
        }

        @Override
        public void visitPackageFragmentDescriptor(@NotNull PackageFragmentDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(descriptor2, builder);
        }

        @Override
        public void visitPackageViewDescriptor(@NotNull PackageViewDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderPackageView(descriptor2, builder);
        }

        @Override
        public void visitModuleDeclaration(@NotNull ModuleDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderName(descriptor2, builder);
        }

        @Override
        public void visitScriptDescriptor(@NotNull ScriptDescriptor scriptDescriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(scriptDescriptor, "scriptDescriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            this.visitClassDescriptor((ClassDescriptor)scriptDescriptor, builder);
        }

        @Override
        public void visitClassDescriptor(@NotNull ClassDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderClass(descriptor2, builder);
        }

        @Override
        public void visitTypeAliasDescriptor(@NotNull TypeAliasDescriptor descriptor2, @NotNull StringBuilder builder) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(descriptor2, builder);
        }
    }
}

