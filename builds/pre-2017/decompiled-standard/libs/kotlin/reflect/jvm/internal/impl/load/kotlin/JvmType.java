/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class JvmType {
    @NotNull
    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    private JvmType() {
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Primitive
    extends JvmType {
        @Nullable
        private final JvmPrimitiveType jvmPrimitiveType;

        @Nullable
        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }

        public Primitive(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }
    }

    public static final class Object
    extends JvmType {
        @NotNull
        private final String internalName;

        @NotNull
        public final String getInternalName() {
            return this.internalName;
        }

        public Object(@NotNull String internalName) {
            Intrinsics.checkParameterIsNotNull(internalName, "internalName");
            super(null);
            this.internalName = internalName;
        }
    }

    public static final class Array
    extends JvmType {
        @NotNull
        private final JvmType elementType;

        @NotNull
        public final JvmType getElementType() {
            return this.elementType;
        }

        public Array(@NotNull JvmType elementType) {
            Intrinsics.checkParameterIsNotNull(elementType, "elementType");
            super(null);
            this.elementType = elementType;
        }
    }
}

