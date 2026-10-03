/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.Nullable;

public final class NoLookupLocation
extends Enum<NoLookupLocation>
implements LookupLocation {
    public static final /* enum */ NoLookupLocation FROM_IDE;
    public static final /* enum */ NoLookupLocation FROM_BACKEND;
    public static final /* enum */ NoLookupLocation FROM_TEST;
    public static final /* enum */ NoLookupLocation FROM_BUILTINS;
    public static final /* enum */ NoLookupLocation WHEN_CHECK_DECLARATION_CONFLICTS;
    public static final /* enum */ NoLookupLocation WHEN_CHECK_OVERRIDES;
    public static final /* enum */ NoLookupLocation FOR_SCRIPT;
    public static final /* enum */ NoLookupLocation FROM_REFLECTION;
    public static final /* enum */ NoLookupLocation WHEN_RESOLVE_DECLARATION;
    public static final /* enum */ NoLookupLocation WHEN_GET_DECLARATION_SCOPE;
    public static final /* enum */ NoLookupLocation WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS;
    public static final /* enum */ NoLookupLocation FOR_ALREADY_TRACKED;
    public static final /* enum */ NoLookupLocation WHEN_GET_ALL_DESCRIPTORS;
    public static final /* enum */ NoLookupLocation WHEN_TYPING;
    public static final /* enum */ NoLookupLocation WHEN_GET_SUPER_MEMBERS;
    public static final /* enum */ NoLookupLocation FOR_NON_TRACKED_SCOPE;
    public static final /* enum */ NoLookupLocation FROM_SYNTHETIC_SCOPE;
    public static final /* enum */ NoLookupLocation FROM_DESERIALIZATION;
    public static final /* enum */ NoLookupLocation FROM_JAVA_LOADER;
    public static final /* enum */ NoLookupLocation WHEN_GET_LOCAL_VARIABLE;
    public static final /* enum */ NoLookupLocation WHEN_FIND_BY_FQNAME;
    public static final /* enum */ NoLookupLocation WHEN_GET_COMPANION_OBJECT;
    private static final /* synthetic */ NoLookupLocation[] $VALUES;

    static {
        NoLookupLocation[] noLookupLocationArray = new NoLookupLocation[22];
        NoLookupLocation[] noLookupLocationArray2 = noLookupLocationArray;
        noLookupLocationArray[0] = FROM_IDE = new NoLookupLocation();
        noLookupLocationArray[1] = FROM_BACKEND = new NoLookupLocation();
        noLookupLocationArray[2] = FROM_TEST = new NoLookupLocation();
        noLookupLocationArray[3] = FROM_BUILTINS = new NoLookupLocation();
        noLookupLocationArray[4] = WHEN_CHECK_DECLARATION_CONFLICTS = new NoLookupLocation();
        noLookupLocationArray[5] = WHEN_CHECK_OVERRIDES = new NoLookupLocation();
        noLookupLocationArray[6] = FOR_SCRIPT = new NoLookupLocation();
        noLookupLocationArray[7] = FROM_REFLECTION = new NoLookupLocation();
        noLookupLocationArray[8] = WHEN_RESOLVE_DECLARATION = new NoLookupLocation();
        noLookupLocationArray[9] = WHEN_GET_DECLARATION_SCOPE = new NoLookupLocation();
        noLookupLocationArray[10] = WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS = new NoLookupLocation();
        noLookupLocationArray[11] = FOR_ALREADY_TRACKED = new NoLookupLocation();
        noLookupLocationArray[12] = WHEN_GET_ALL_DESCRIPTORS = new NoLookupLocation();
        noLookupLocationArray[13] = WHEN_TYPING = new NoLookupLocation();
        noLookupLocationArray[14] = WHEN_GET_SUPER_MEMBERS = new NoLookupLocation();
        noLookupLocationArray[15] = FOR_NON_TRACKED_SCOPE = new NoLookupLocation();
        noLookupLocationArray[16] = FROM_SYNTHETIC_SCOPE = new NoLookupLocation();
        noLookupLocationArray[17] = FROM_DESERIALIZATION = new NoLookupLocation();
        noLookupLocationArray[18] = FROM_JAVA_LOADER = new NoLookupLocation();
        noLookupLocationArray[19] = WHEN_GET_LOCAL_VARIABLE = new NoLookupLocation();
        noLookupLocationArray[20] = WHEN_FIND_BY_FQNAME = new NoLookupLocation();
        noLookupLocationArray[21] = WHEN_GET_COMPANION_OBJECT = new NoLookupLocation();
        $VALUES = noLookupLocationArray;
    }

    @Override
    @Nullable
    public LocationInfo getLocation() {
        return null;
    }

    public static NoLookupLocation[] values() {
        return (NoLookupLocation[])$VALUES.clone();
    }

    public static NoLookupLocation valueOf(String string) {
        return Enum.valueOf(NoLookupLocation.class, string);
    }
}

