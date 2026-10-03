/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDeprecatedAnnotationDescriptor
extends JavaAnnotationDescriptor {
    private final NotNullLazyValue<Map<ValueParameterDescriptor, ConstantValue<?>>> valueArguments;

    @Override
    @NotNull
    public Map<ValueParameterDescriptor, ConstantValue<?>> getAllValueArguments() {
        return (Map)this.valueArguments.invoke();
    }

    public JavaDeprecatedAnnotationDescriptor(@Nullable JavaAnnotation annotation, @NotNull LazyJavaResolverContext c) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        ClassDescriptor classDescriptor = c.getModule().getBuiltIns().getDeprecatedAnnotation();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "c.module.builtIns.deprecatedAnnotation");
        super(c, annotation, classDescriptor);
        this.valueArguments = c.getStorageManager().createLazyValue(new Function0<Map<ValueParameterDescriptor, ? extends ConstantValue<?>>>(this, c){
            final /* synthetic */ JavaDeprecatedAnnotationDescriptor this$0;
            final /* synthetic */ LazyJavaResolverContext $c;

            @NotNull
            public final Map<ValueParameterDescriptor, ConstantValue<?>> invoke() {
                ValueParameterDescriptor valueParameterDescriptor;
                ValueParameterDescriptor it;
                ValueParameterDescriptor parameterDescriptor;
                Map<ValueParameterDescriptor, ConstantValue<?>> map2;
                Object v0;
                block2: {
                    Iterable $receiver$iv = this.this$0.getValueParameters();
                    for (T element$iv : $receiver$iv) {
                        ValueParameterDescriptor it2 = (ValueParameterDescriptor)element$iv;
                        if (!Intrinsics.areEqual(it2.getName(), JavaAnnotationMapper.INSTANCE.getDEPRECATED_ANNOTATION_MESSAGE$kotlin_core())) continue;
                        v0 = element$iv;
                        break block2;
                    }
                    v0 = null;
                }
                if ((map2 = (parameterDescriptor = (ValueParameterDescriptor)v0)) == null || (map2 = MapsKt.mapOf(TuplesKt.to(it = (valueParameterDescriptor = map2), new ConstantValueFactory(this.$c.getModule().getBuiltIns()).createConstantValue("Deprecated in Java")))) == null) {
                    map2 = MapsKt.emptyMap();
                }
                return map2;
            }
            {
                this.this$0 = javaDeprecatedAnnotationDescriptor;
                this.$c = lazyJavaResolverContext;
                super(0);
            }
        });
    }
}

