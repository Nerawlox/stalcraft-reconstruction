// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.Nullable;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

public class JavaAnnotationDescriptor implements AnnotationDescriptor
{
    private final SourceElement source;
    @Nullable
    private final JavaAnnotationArgument firstArgument;
    private final ClassDescriptor kotlinAnnotationClassDescriptor;
    
    @NotNull
    public SimpleType getType() {
        return this.kotlinAnnotationClassDescriptor.getDefaultType();
    }
    
    public SourceElement getSource() {
        return this.source;
    }
    
    @NotNull
    protected final List<ValueParameterDescriptor> getValueParameters() {
        final List valueParameters = ((ClassConstructorDescriptor)CollectionsKt.single((Iterable)this.kotlinAnnotationClassDescriptor.getConstructors())).getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull((Object)valueParameters, "kotlinAnnotationClassDes\u2026.single().valueParameters");
        return valueParameters;
    }
    
    @Nullable
    protected final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }
    
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }
    
    public JavaAnnotationDescriptor(@NotNull final LazyJavaResolverContext c, @Nullable final JavaAnnotation annotation, @NotNull final ClassDescriptor kotlinAnnotationClassDescriptor) {
        Intrinsics.checkParameterIsNotNull((Object)c, "c");
        Intrinsics.checkParameterIsNotNull((Object)kotlinAnnotationClassDescriptor, "kotlinAnnotationClassDescriptor");
        this.kotlinAnnotationClassDescriptor = kotlinAnnotationClassDescriptor;
        JavaAnnotationDescriptor javaAnnotationDescriptor = this;
        SourceElement no_SOURCE = null;
        Label_0078: {
            if (annotation != null) {
                final JavaAnnotation it = annotation;
                final JavaSourceElement source = c.getComponents().getSourceElementFactory().source((JavaElement)it);
                javaAnnotationDescriptor = this;
                final JavaSourceElement javaSourceElement = source;
                if (javaSourceElement != null) {
                    no_SOURCE = (SourceElement)javaSourceElement;
                    break Label_0078;
                }
            }
            no_SOURCE = SourceElement.NO_SOURCE;
        }
        javaAnnotationDescriptor.source = no_SOURCE;
        JavaAnnotationArgument firstArgument = null;
        Label_0110: {
            if (annotation != null) {
                final Collection arguments = annotation.getArguments();
                if (arguments != null) {
                    firstArgument = (JavaAnnotationArgument)CollectionsKt.firstOrNull((Iterable)arguments);
                    break Label_0110;
                }
            }
            firstArgument = null;
        }
        this.firstArgument = firstArgument;
    }
}
