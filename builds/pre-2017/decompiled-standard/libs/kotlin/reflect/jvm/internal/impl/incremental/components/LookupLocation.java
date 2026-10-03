/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import org.jetbrains.annotations.Nullable;

public interface LookupLocation {
    @Nullable
    public LocationInfo getLocation();
}

