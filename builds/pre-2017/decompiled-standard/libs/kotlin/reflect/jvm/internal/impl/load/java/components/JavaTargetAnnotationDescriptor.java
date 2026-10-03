/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;

public final class JavaTargetAnnotationDescriptor
extends JavaAnnotationDescriptor {
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> valueArguments;

    @Override
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        return (Map)this.valueArguments.invoke();
    }

    public JavaTargetAnnotationDescriptor(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        Intrinsics.checkParameterIsNotNull(c, "c");
        ClassDescriptor classDescriptor = c.getModule().getBuiltIns().getTargetAnnotation();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "c.module.builtIns.targetAnnotation");
        super(c, annotation, classDescriptor);
        this.valueArguments = c.getStorageManager().createLazyValue(new Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>>(this, c){
            final /* synthetic */ JavaTargetAnnotationDescriptor this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @NotNull
            public final Map<ValueParameterDescriptor, ConstantValue<?>> invoke() {
                ConstantValue<?> constantValue;
                JavaAnnotationArgument javaAnnotationArgument = this.this$0.getFirstArgument();
                if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
                    constantValue = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments(((JavaArrayAnnotationArgument)this.this$0.getFirstArgument()).getElements(), this.$c.getModule().getBuiltIns());
                } else if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
                    constantValue = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments(CollectionsKt.listOf(this.this$0.getFirstArgument()), this.$c.getModule().getBuiltIns());
                } else {
                    return MapsKt.emptyMap();
                }
                ConstantValue<?> targetArgument = constantValue;
                return MapsKt.mapOf(TuplesKt.to(CollectionsKt.single(this.this$0.getValueParameters()), targetArgument));
            }
            {
                this.this$0 = javaTargetAnnotationDescriptor;
                this.$c = lazyJavaResolverContext;
                super(0);
            }
        });
    }
}

