/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import org.jetbrains.annotations.NotNull;

public interface LocationInfo {
    @NotNull
    public String getFilePath();

    @NotNull
    public Position getPosition();
}

