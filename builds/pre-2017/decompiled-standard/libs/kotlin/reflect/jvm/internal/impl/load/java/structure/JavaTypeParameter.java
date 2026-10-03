/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import org.jetbrains.annotations.NotNull;

public interface JavaTypeParameter
extends JavaClassifier {
    @NotNull
    public Collection<JavaClassifierType> getUpperBounds();
}

