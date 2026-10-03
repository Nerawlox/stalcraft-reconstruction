/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import org.jetbrains.annotations.NotNull;

public final class RuntimeSourceElementFactory
implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE;

    @Override
    @NotNull
    public JavaSourceElement source(@NotNull JavaElement javaElement) {
        Intrinsics.checkParameterIsNotNull(javaElement, "javaElement");
        JavaElement javaElement2 = javaElement;
        if (javaElement2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.reflect.ReflectJavaElement");
        }
        return new RuntimeSourceElement((ReflectJavaElement)javaElement2);
    }

    private RuntimeSourceElementFactory() {
        INSTANCE = this;
    }

    static {
        new RuntimeSourceElementFactory();
    }

    public static final class RuntimeSourceElement
    implements JavaSourceElement {
        @NotNull
        private final ReflectJavaElement javaElement;

        @NotNull
        public String toString() {
            return this.getClass().getName() + ": " + this.getJavaElement().toString();
        }

        @Override
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
            return sourceFile;
        }

        @Override
        @NotNull
        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public RuntimeSourceElement(@NotNull ReflectJavaElement javaElement) {
            Intrinsics.checkParameterIsNotNull(javaElement, "javaElement");
            this.javaElement = javaElement;
        }
    }
}

