/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

public interface JavaMethod
extends JavaMember,
JavaTypeParameterListOwner {
    @NotNull
    public List<JavaValueParameter> getValueParameters();

    @NotNull
    public JavaType getReturnType();

    public boolean getHasAnnotationParameterDefaultValue();
}

