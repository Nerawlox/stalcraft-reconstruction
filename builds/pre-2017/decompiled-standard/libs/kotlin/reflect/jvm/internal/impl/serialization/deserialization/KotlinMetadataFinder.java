/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KotlinMetadataFinder {
    @Nullable
    public InputStream findMetadata(@NotNull ClassId var1);

    public boolean hasMetadataPackage(@NotNull FqName var1);

    @Nullable
    public InputStream findBuiltInsData(@NotNull FqName var1);
}

