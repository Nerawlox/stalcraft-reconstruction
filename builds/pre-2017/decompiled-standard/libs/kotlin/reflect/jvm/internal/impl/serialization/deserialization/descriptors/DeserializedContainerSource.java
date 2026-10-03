/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeserializedContainerSource
extends SourceElement {
    @Nullable
    public IncompatibleVersionErrorData<?> getIncompatibility();

    public boolean isPreReleaseInvisible();

    @NotNull
    public FqName getPresentableFqName();
}

