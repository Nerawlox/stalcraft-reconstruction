/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaArrayAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaArrayAnnotationArgument {
    private final Object[] values;

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaAnnotationArgument> getElements() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = this.values;
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void it;
            void item$iv$iv;
            void var6_6 = item$iv$iv = $receiver$iv$iv[i];
            Collection collection = destination$iv$iv;
            void v0 = it;
            if (v0 == null) {
                Intrinsics.throwNpe();
            }
            ReflectJavaAnnotationArgument reflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(v0, null);
            collection.add(reflectJavaAnnotationArgument);
        }
        return (List)var3_3;
    }

    public ReflectJavaArrayAnnotationArgument(@Nullable Name name2, @NotNull Object[] values2) {
        Intrinsics.checkParameterIsNotNull(values2, "values");
        super(name2);
        this.values = values2;
    }
}

