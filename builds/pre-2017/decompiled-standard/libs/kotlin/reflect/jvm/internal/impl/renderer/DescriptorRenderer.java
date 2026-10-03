/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$WhenMappings;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DescriptorRenderer {
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer DEBUG_TEXT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer HTML;
    public static final Companion Companion;

    @NotNull
    public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
        Intrinsics.checkParameterIsNotNull(changeOptions, "changeOptions");
        DescriptorRenderer descriptorRenderer2 = this;
        if (descriptorRenderer2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        }
        DescriptorRendererOptionsImpl options = ((DescriptorRendererImpl)descriptorRenderer2).getOptions().copy();
        changeOptions.invoke(options);
        options.lock();
        return new DescriptorRendererImpl(options);
    }

    @NotNull
    public abstract String renderMessage(@NotNull String var1);

    @NotNull
    public abstract String renderType(@NotNull KotlinType var1);

    @NotNull
    public abstract String renderFlexibleType(@NotNull String var1, @NotNull String var2, @NotNull KotlinBuiltIns var3);

    @NotNull
    public abstract String renderTypeArguments(@NotNull List<? extends TypeProjection> var1);

    @NotNull
    public abstract String renderTypeProjection(@NotNull TypeProjection var1);

    @NotNull
    public abstract String renderTypeConstructor(@NotNull TypeConstructor var1);

    @NotNull
    public abstract String renderClassifierName(@NotNull ClassifierDescriptor var1);

    @NotNull
    public abstract String renderAnnotation(@NotNull AnnotationDescriptor var1, @Nullable AnnotationUseSiteTarget var2);

    @NotNull
    public static /* bridge */ /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer2, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((n & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer2.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    @NotNull
    public abstract String render(@NotNull DeclarationDescriptor var1);

    @NotNull
    public abstract String renderValueParameters(@NotNull Collection<? extends ValueParameterDescriptor> var1, boolean var2);

    @NotNull
    public final String renderFunctionParameters(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        List<ValueParameterDescriptor> list = functionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "functionDescriptor.valueParameters");
        return this.renderValueParameters((Collection<? extends ValueParameterDescriptor>)list, functionDescriptor.hasSynthesizedParameterNames());
    }

    @NotNull
    public abstract String renderName(@NotNull Name var1);

    @NotNull
    public abstract String renderFqName(@NotNull FqNameUnsafe var1);

    static {
        Companion = new Companion(null);
        COMPACT_WITH_MODIFIERS = Companion.withOptions(Companion.COMPACT_WITH_MODIFIERS.1.INSTANCE);
        COMPACT = Companion.withOptions(Companion.COMPACT.1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = Companion.withOptions(Companion.COMPACT_WITH_SHORT_TYPES.1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = Companion.withOptions(Companion.ONLY_NAMES_WITH_SHORT_TYPES.1.INSTANCE);
        FQ_NAMES_IN_TYPES = Companion.withOptions(Companion.FQ_NAMES_IN_TYPES.1.INSTANCE);
        SHORT_NAMES_IN_TYPES = Companion.withOptions(Companion.SHORT_NAMES_IN_TYPES.1.INSTANCE);
        DEBUG_TEXT = Companion.withOptions(Companion.DEBUG_TEXT.1.INSTANCE);
        HTML = Companion.withOptions(Companion.HTML.1.INSTANCE);
    }

    public static interface ValueParametersHandler {
        public void appendBeforeValueParameters(int var1, @NotNull StringBuilder var2);

        public void appendAfterValueParameters(int var1, @NotNull StringBuilder var2);

        public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor var1, int var2, int var3, @NotNull StringBuilder var4);

        public void appendAfterValueParameter(@NotNull ValueParameterDescriptor var1, int var2, int var3, @NotNull StringBuilder var4);

        public static final class DEFAULT
        implements ValueParametersHandler {
            public static final DEFAULT INSTANCE;

            @Override
            public void appendBeforeValueParameters(int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkParameterIsNotNull(builder, "builder");
                builder.append("(");
            }

            @Override
            public void appendAfterValueParameters(int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkParameterIsNotNull(builder, "builder");
                builder.append(")");
            }

            @Override
            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkParameterIsNotNull(parameter, "parameter");
                Intrinsics.checkParameterIsNotNull(builder, "builder");
            }

            @Override
            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, @NotNull StringBuilder builder) {
                Intrinsics.checkParameterIsNotNull(parameter, "parameter");
                Intrinsics.checkParameterIsNotNull(builder, "builder");
                if (parameterIndex != parameterCount - 1) {
                    builder.append(", ");
                }
            }

            private DEFAULT() {
                INSTANCE = this;
            }

            static {
                new DEFAULT();
            }
        }
    }

    public static final class Companion {
        @NotNull
        public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
            Intrinsics.checkParameterIsNotNull(changeOptions, "changeOptions");
            DescriptorRendererOptionsImpl options = new DescriptorRendererOptionsImpl();
            changeOptions.invoke(options);
            options.lock();
            return new DescriptorRendererImpl(options);
        }

        @NotNull
        public final String getClassifierKindPrefix(@NotNull ClassifierDescriptorWithTypeParameters classifier2) {
            String string;
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classifier2;
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                string = "typealias";
            } else if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                if (((ClassDescriptor)classifier2).isCompanionObject()) {
                    string = "companion object";
                } else {
                    switch (DescriptorRenderer$Companion$WhenMappings.$EnumSwitchMapping$0[((ClassDescriptor)classifier2).getKind().ordinal()]) {
                        case 1: {
                            string = "class";
                            break;
                        }
                        case 2: {
                            string = "interface";
                            break;
                        }
                        case 3: {
                            string = "enum class";
                            break;
                        }
                        case 4: {
                            string = "object";
                            break;
                        }
                        case 5: {
                            string = "annotation class";
                            break;
                        }
                        case 6: {
                            string = "enum entry";
                            break;
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            } else {
                throw (Throwable)((Object)new AssertionError((Object)("Unexpected classifier: " + classifier2)));
            }
            return string;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

