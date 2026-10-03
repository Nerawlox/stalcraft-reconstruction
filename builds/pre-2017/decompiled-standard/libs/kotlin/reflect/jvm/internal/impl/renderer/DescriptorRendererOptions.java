/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface DescriptorRendererOptions {
    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy();

    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy var1);

    public boolean getWithDefinedIn();

    public void setWithDefinedIn(boolean var1);

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers();

    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> var1);

    public boolean getStartFromName();

    public void setStartFromName(boolean var1);

    public boolean getStartFromDeclarationKeyword();

    public void setStartFromDeclarationKeyword(boolean var1);

    public boolean getDebugMode();

    public void setDebugMode(boolean var1);

    public boolean getClassWithPrimaryConstructor();

    public void setClassWithPrimaryConstructor(boolean var1);

    public boolean getVerbose();

    public void setVerbose(boolean var1);

    public boolean getUnitReturnType();

    public void setUnitReturnType(boolean var1);

    public boolean getWithoutReturnType();

    public void setWithoutReturnType(boolean var1);

    public boolean getNormalizedVisibilities();

    public void setNormalizedVisibilities(boolean var1);

    public boolean getShowInternalKeyword();

    public void setShowInternalKeyword(boolean var1);

    public boolean getUninferredTypeParameterAsName();

    public void setUninferredTypeParameterAsName(boolean var1);

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy();

    public void setOverrideRenderingPolicy(@NotNull OverrideRenderingPolicy var1);

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler();

    public void setValueParametersHandler(@NotNull DescriptorRenderer.ValueParametersHandler var1);

    @NotNull
    public RenderingFormat getTextFormat();

    public void setTextFormat(@NotNull RenderingFormat var1);

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses();

    public void setExcludedAnnotationClasses(@NotNull Set<FqName> var1);

    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses();

    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> var1);

    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy var1);

    public boolean getIncludeAnnotationArguments();

    public boolean getIncludeEmptyAnnotationArguments();

    public boolean getIncludePropertyConstant();

    public void setIncludePropertyConstant(boolean var1);

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy();

    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy var1);

    public boolean getWithoutTypeParameters();

    public void setWithoutTypeParameters(boolean var1);

    public boolean getReceiverAfterName();

    public void setReceiverAfterName(boolean var1);

    public boolean getRenderCompanionObjectName();

    public void setRenderCompanionObjectName(boolean var1);

    public boolean getWithoutSuperTypes();

    public void setWithoutSuperTypes(boolean var1);

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer();

    public void setTypeNormalizer(@NotNull Function1<? super KotlinType, ? extends KotlinType> var1);

    public boolean getRenderDefaultValues();

    public void setRenderDefaultValues(boolean var1);

    public boolean getSecondaryConstructorsAsPrimary();

    public void setSecondaryConstructorsAsPrimary(boolean var1);

    public boolean getRenderAccessors();

    public void setRenderAccessors(boolean var1);

    public boolean getRenderDefaultAnnotationArguments();

    public void setRenderDefaultAnnotationArguments(boolean var1);

    public boolean getAlwaysRenderModifiers();

    public void setAlwaysRenderModifiers(boolean var1);

    public boolean getRenderConstructorKeyword();

    public void setRenderConstructorKeyword(boolean var1);

    public boolean getRenderUnabbreviatedType();

    public void setRenderUnabbreviatedType(boolean var1);

    public boolean getIncludeAdditionalModifiers();

    public void setIncludeAdditionalModifiers(boolean var1);

    public boolean getParameterNamesInFunctionalTypes();

    public void setParameterNamesInFunctionalTypes(boolean var1);

    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions $this) {
            return $this.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions $this) {
            return $this.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }
}

