/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class UtilsKt {
    public static final void record(@NotNull LookupTracker $receiver, @NotNull LookupLocation from, @NotNull ClassDescriptor scopeOwner, @NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(from, "from");
        Intrinsics.checkParameterIsNotNull(scopeOwner, "scopeOwner");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        if ($receiver == LookupTracker.Companion.getDO_NOTHING()) {
            return;
        }
        LocationInfo locationInfo = from.getLocation();
        if (locationInfo == null) {
            return;
        }
        LocationInfo location = locationInfo;
        Position position = $receiver.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
        String string = location.getFilePath();
        String string2 = DescriptorUtils.getFqName(scopeOwner).asString();
        Intrinsics.checkExpressionValueIsNotNull(string2, "DescriptorUtils.getFqName(scopeOwner).asString()");
        String string3 = name2.asString();
        Intrinsics.checkExpressionValueIsNotNull(string3, "name.asString()");
        $receiver.record(string, position, string2, ScopeKind.CLASSIFIER, string3);
    }

    public static final void record(@NotNull LookupTracker $receiver, @NotNull LookupLocation from, @NotNull PackageFragmentDescriptor scopeOwner, @NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(from, "from");
        Intrinsics.checkParameterIsNotNull(scopeOwner, "scopeOwner");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        if ($receiver == LookupTracker.Companion.getDO_NOTHING()) {
            return;
        }
        LocationInfo locationInfo = from.getLocation();
        if (locationInfo == null) {
            return;
        }
        LocationInfo location = locationInfo;
        Position position = $receiver.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
        String string = location.getFilePath();
        String string2 = scopeOwner.getFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string2, "scopeOwner.fqName.asString()");
        String string3 = name2.asString();
        Intrinsics.checkExpressionValueIsNotNull(string3, "name.asString()");
        $receiver.record(string, position, string2, ScopeKind.PACKAGE, string3);
    }
}

