/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect;

import java.util.Collection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\")\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"%\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n\"-\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"-\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0010\"C\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00150\f\"\b\b\u0000\u0010\u0016*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00160\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0010\"-\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u0010\"?\u0010\u001c\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0016\u0012\u0002\b\u00030\u001d0\f\"\b\b\u0000\u0010\u0016*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00160\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u0010\"#\u0010 \u001a\u00020!*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010$\"-\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u0010\"-\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\u0010\"C\u0010+\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00150\f\"\b\b\u0000\u0010\u0016*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00160\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\u0010\"-\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010\u0003\u001a\u0004\b0\u0010\u0010\"?\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0016\u0012\u0002\b\u00030\u001d0\f\"\b\b\u0000\u0010\u0016*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00160\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010\u0010\"7\u00104\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\r\"\b\b\u0000\u0010\u0016*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00160\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010\u0003\u001a\u0004\b6\u00107\"-\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010\u0010\"-\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030<0\f*\u0006\u0012\u0002\b\u00030\u00018\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\u0010\u00a8\u0006?"}, d2={"companionObject", "Lkotlin/reflect/KClass;", "companionObject$annotations", "(Lkotlin/reflect/KClass;)V", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "companionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "", "Lkotlin/reflect/KFunction;", "declaredFunctions$annotations", "getDeclaredFunctions", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "declaredMemberExtensionFunctions", "declaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "declaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "declaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "declaredMemberProperties$annotations", "getDeclaredMemberProperties", "defaultType", "Lkotlin/reflect/KType;", "defaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "functions$annotations", "getFunctions", "memberExtensionFunctions", "memberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "memberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "memberFunctions$annotations", "getMemberFunctions", "memberProperties", "memberProperties$annotations", "getMemberProperties", "primaryConstructor", "primaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "staticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "staticProperties$annotations", "getStaticProperties", "kotlin-reflection"})
@JvmName(name="KClasses")
public final class KClasses {
    @Deprecated(message="Use 'primaryConstructor' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.primaryConstructor", imports={"kotlin.reflect.full.primaryConstructor"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void primaryConstructor$annotations(KClass kClass) {
    }

    @Nullable
    public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getPrimaryConstructor($receiver);
    }

    @Deprecated(message="Use 'companionObject' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.companionObject", imports={"kotlin.reflect.full.companionObject"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void companionObject$annotations(KClass kClass) {
    }

    @Nullable
    public static final KClass<?> getCompanionObject(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getCompanionObject($receiver);
    }

    @Deprecated(message="Use 'companionObjectInstance' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.companionObjectInstance", imports={"kotlin.reflect.full.companionObjectInstance"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void companionObjectInstance$annotations(KClass kClass) {
    }

    @Nullable
    public static final Object getCompanionObjectInstance(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getCompanionObjectInstance($receiver);
    }

    @Deprecated(message="Use 'defaultType' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.defaultType", imports={"kotlin.reflect.full.defaultType"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void defaultType$annotations(KClass kClass) {
    }

    @NotNull
    public static final KType getDefaultType(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDefaultType($receiver);
    }

    @Deprecated(message="Use 'functions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.functions", imports={"kotlin.reflect.full.functions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void functions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getFunctions($receiver);
    }

    @Deprecated(message="Use 'staticFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.staticFunctions", imports={"kotlin.reflect.full.staticFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void staticFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getStaticFunctions($receiver);
    }

    @Deprecated(message="Use 'memberFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.memberFunctions", imports={"kotlin.reflect.full.memberFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void memberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getMemberFunctions($receiver);
    }

    @Deprecated(message="Use 'memberExtensionFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.memberExtensionFunctions", imports={"kotlin.reflect.full.memberExtensionFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void memberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getMemberExtensionFunctions($receiver);
    }

    @Deprecated(message="Use 'declaredFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.declaredFunctions", imports={"kotlin.reflect.full.declaredFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void declaredFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDeclaredFunctions($receiver);
    }

    @Deprecated(message="Use 'declaredMemberFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.declaredMemberFunctions", imports={"kotlin.reflect.full.declaredMemberFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void declaredMemberFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDeclaredMemberFunctions($receiver);
    }

    @Deprecated(message="Use 'declaredMemberExtensionFunctions' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.declaredMemberExtensionFunctions", imports={"kotlin.reflect.full.declaredMemberExtensionFunctions"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void declaredMemberExtensionFunctions$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDeclaredMemberExtensionFunctions($receiver);
    }

    @Deprecated(message="Use 'staticProperties' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.staticProperties", imports={"kotlin.reflect.full.staticProperties"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void staticProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getStaticProperties($receiver);
    }

    @Deprecated(message="Use 'memberProperties' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.memberProperties", imports={"kotlin.reflect.full.memberProperties"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void memberProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getMemberProperties($receiver);
    }

    @Deprecated(message="Use 'memberExtensionProperties' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.memberExtensionProperties", imports={"kotlin.reflect.full.memberExtensionProperties"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void memberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getMemberExtensionProperties($receiver);
    }

    @Deprecated(message="Use 'declaredMemberProperties' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.declaredMemberProperties", imports={"kotlin.reflect.full.declaredMemberProperties"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void declaredMemberProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDeclaredMemberProperties($receiver);
    }

    @Deprecated(message="Use 'declaredMemberExtensionProperties' from kotlin.reflect.full package", replaceWith=@ReplaceWith(expression="this.declaredMemberExtensionProperties", imports={"kotlin.reflect.full.declaredMemberExtensionProperties"}), level=DeprecationLevel.WARNING)
    @LowPriorityInOverloadResolution
    private static /* synthetic */ void declaredMemberExtensionProperties$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.reflect.full.KClasses.getDeclaredMemberExtensionProperties($receiver);
    }
}

