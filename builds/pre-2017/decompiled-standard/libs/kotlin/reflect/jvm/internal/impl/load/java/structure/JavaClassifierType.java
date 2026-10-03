/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaClassifierType
extends JavaType,
JavaAnnotationOwner {
    @Nullable
    public JavaClassifier getClassifier();

    @NotNull
    public List<JavaType> getTypeArguments();

    public boolean isRaw();

    @NotNull
    public String getCanonicalText();

    @NotNull
    public String getPresentableText();
}

