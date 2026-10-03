/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public interface NameResolver {
    @NotNull
    public String getString(int var1);

    @NotNull
    public Name getName(int var1);

    @NotNull
    public ClassId getClassId(int var1);
}

