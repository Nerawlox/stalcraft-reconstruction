/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

final class EnhancedTypeAnnotationDescriptor
implements AnnotationDescriptor {
    public static final EnhancedTypeAnnotationDescriptor INSTANCE;

    private final Void throwError() {
        String string = "No methods should be called on this descriptor. Only its presence matters";
        throw (Throwable)new IllegalStateException(string.toString());
    }

    @NotNull
    public Void getType() {
        Void void_ = this.throwError();
        throw null;
    }

    @NotNull
    public Void getAllValueArguments() {
        Void void_ = this.throwError();
        throw null;
    }

    @NotNull
    public Void getSource() {
        Void void_ = this.throwError();
        throw null;
    }

    @NotNull
    public String toString() {
        return "[EnhancedType]";
    }

    private EnhancedTypeAnnotationDescriptor() {
        INSTANCE = this;
    }

    static {
        new EnhancedTypeAnnotationDescriptor();
    }
}

