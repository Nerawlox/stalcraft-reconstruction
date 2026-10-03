/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwnerKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaValueParameter
extends ReflectJavaElement
implements JavaValueParameter {
    @NotNull
    private final ReflectJavaType type;
    private final Annotation[] reflectAnnotations;
    private final String reflectName;
    private final boolean isVararg;

    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwnerKt.getAnnotations(this.reflectAnnotations);
    }

    @Override
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return ReflectJavaAnnotationOwnerKt.findAnnotation(this.reflectAnnotations, fqName2);
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override
    @Nullable
    public Name getName() {
        Name name2;
        String string = this.reflectName;
        if (string != null) {
            String string2;
            String p1 = string2 = string;
            name2 = Name.guessByFirstCharacter(p1);
        } else {
            name2 = null;
        }
        return name2;
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + (this.isVararg() ? "vararg " : "") + this.getName() + ": " + this.getType();
    }

    @Override
    @NotNull
    public ReflectJavaType getType() {
        return this.type;
    }

    @Override
    public boolean isVararg() {
        return this.isVararg;
    }

    public ReflectJavaValueParameter(@NotNull ReflectJavaType type2, @NotNull Annotation[] reflectAnnotations, @Nullable String reflectName, boolean isVararg) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(reflectAnnotations, "reflectAnnotations");
        this.type = type2;
        this.reflectAnnotations = reflectAnnotations;
        this.reflectName = reflectName;
        this.isVararg = isVararg;
    }
}

