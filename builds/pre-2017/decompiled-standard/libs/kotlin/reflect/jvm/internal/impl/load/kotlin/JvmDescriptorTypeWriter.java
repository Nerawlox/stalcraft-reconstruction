/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmDescriptorTypeWriter<T> {
    private int jvmCurrentTypeArrayLevel;
    @Nullable
    private T jvmCurrentType;
    private final JvmTypeFactory<T> jvmTypeFactory;

    @Nullable
    protected final T getJvmCurrentType() {
        return this.jvmCurrentType;
    }

    private final void setJvmCurrentType(T t) {
        this.jvmCurrentType = t;
    }

    protected final void clearCurrentType() {
        this.jvmCurrentType = null;
        this.jvmCurrentTypeArrayLevel = 0;
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            JvmDescriptorTypeWriter jvmDescriptorTypeWriter = this;
            ++jvmDescriptorTypeWriter.jvmCurrentTypeArrayLevel;
            int cfr_ignored_0 = jvmDescriptorTypeWriter.jvmCurrentTypeArrayLevel;
        }
    }

    public void writeArrayEnd() {
    }

    public void writeClass(@NotNull T objectType) {
        Intrinsics.checkParameterIsNotNull(objectType, "objectType");
        this.writeJvmTypeAsIs(objectType);
    }

    protected final void writeJvmTypeAsIs(@NotNull T type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        if (this.jvmCurrentType == null) {
            this.jvmCurrentType = this.jvmTypeFactory.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(type2));
        }
    }

    public void writeTypeVariable(@NotNull Name name2, @NotNull T type2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(type2, "type");
        this.writeJvmTypeAsIs(type2);
    }

    public JvmDescriptorTypeWriter(@NotNull JvmTypeFactory<T> jvmTypeFactory) {
        Intrinsics.checkParameterIsNotNull(jvmTypeFactory, "jvmTypeFactory");
        this.jvmTypeFactory = jvmTypeFactory;
    }
}

