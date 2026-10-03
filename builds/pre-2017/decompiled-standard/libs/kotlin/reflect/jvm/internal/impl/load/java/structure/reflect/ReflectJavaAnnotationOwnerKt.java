/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationOwnerKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ReflectJavaAnnotation> getAnnotations(@NotNull Annotation[] $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Object[] objectArray = $receiver$iv = (Object[])$receiver;
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void it;
            void item$iv$iv = $receiver$iv$iv[i];
            Annotation annotation = (Annotation)item$iv$iv;
            Collection collection = destination$iv$iv;
            ReflectJavaAnnotation reflectJavaAnnotation = new ReflectJavaAnnotation((Annotation)it);
            collection.add(reflectJavaAnnotation);
        }
        return (List)var3_3;
    }

    @Nullable
    public static final ReflectJavaAnnotation findAnnotation(@NotNull Annotation[] $receiver, @NotNull FqName fqName2) {
        ReflectJavaAnnotation reflectJavaAnnotation;
        Object object;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Object[] $receiver$iv = $receiver;
            for (int i = 0; i < $receiver$iv.length; ++i) {
                Object element$iv = $receiver$iv[i];
                Annotation it = (Annotation)element$iv;
                if (!Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it))).asSingleFqName(), fqName2)) continue;
                object = element$iv;
                break block3;
            }
            object = null;
        }
        Annotation annotation = (Annotation)object;
        if (annotation != null) {
            Annotation annotation2;
            Annotation it = annotation2 = annotation;
            reflectJavaAnnotation = new ReflectJavaAnnotation(it);
        } else {
            reflectJavaAnnotation = null;
        }
        return reflectJavaAnnotation;
    }
}

