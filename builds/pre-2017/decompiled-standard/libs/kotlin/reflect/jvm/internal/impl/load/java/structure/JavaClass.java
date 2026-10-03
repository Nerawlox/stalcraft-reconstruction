/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaClass
extends JavaClassifier,
JavaTypeParameterListOwner,
JavaModifierListOwner {
    @Nullable
    public FqName getFqName();

    @NotNull
    public Collection<JavaClassifierType> getSupertypes();

    @NotNull
    public Collection<JavaClass> getInnerClasses();

    @Nullable
    public JavaClass getOuterClass();

    public boolean isInterface();

    public boolean isAnnotationType();

    public boolean isEnum();

    @Nullable
    public LightClassOriginKind getLightClassOriginKind();

    @NotNull
    public Collection<JavaMethod> getMethods();

    @NotNull
    public Collection<JavaField> getFields();

    @NotNull
    public Collection<JavaConstructor> getConstructors();
}

