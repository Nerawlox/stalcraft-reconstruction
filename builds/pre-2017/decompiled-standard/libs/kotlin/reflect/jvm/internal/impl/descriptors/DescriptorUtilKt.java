/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilKt {
    @Nullable
    public static final ClassDescriptor resolveClassByFqName(@NotNull ModuleDescriptor $receiver, @NotNull FqName fqName2, @NotNull LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        ClassifierDescriptor classifierDescriptor2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "lookupLocation");
        if (fqName2.isRoot()) {
            return null;
        }
        FqName fqName3 = fqName2.parent();
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "fqName.parent()");
        MemberScope memberScope2 = $receiver.getPackage(fqName3).getMemberScope();
        Name name2 = fqName2.shortName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "fqName.shortName()");
        ClassifierDescriptor classifierDescriptor3 = memberScope2.getContributedClassifier(name2, lookupLocation);
        if (!(classifierDescriptor3 instanceof ClassDescriptor)) {
            classifierDescriptor3 = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor3;
        if (classDescriptor != null) {
            ClassDescriptor classDescriptor2;
            ClassDescriptor it = classDescriptor2 = classDescriptor;
            return it;
        }
        FqName fqName4 = fqName2.parent();
        Intrinsics.checkExpressionValueIsNotNull(fqName4, "fqName.parent()");
        Object object = DescriptorUtilKt.resolveClassByFqName($receiver, fqName4, lookupLocation);
        if (object != null && (object = object.getUnsubstitutedInnerClassesScope()) != null) {
            Name name3 = fqName2.shortName();
            Intrinsics.checkExpressionValueIsNotNull(name3, "fqName.shortName()");
            classifierDescriptor2 = object.getContributedClassifier(name3, lookupLocation);
        } else {
            classifierDescriptor2 = classifierDescriptor = null;
        }
        if (!(classifierDescriptor2 instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        return (ClassDescriptor)classifierDescriptor;
    }

    @Nullable
    public static final ClassDescriptor findContinuationClassDescriptorOrNull(@NotNull ModuleDescriptor $receiver, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "lookupLocation");
        FqName fqName2 = DescriptorUtils.CONTINUATION_INTERFACE_FQ_NAME;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "DescriptorUtils.CONTINUATION_INTERFACE_FQ_NAME");
        return DescriptorUtilKt.resolveClassByFqName($receiver, fqName2, lookupLocation);
    }

    @NotNull
    public static final ClassDescriptor findContinuationClassDescriptor(@NotNull ModuleDescriptor $receiver, @NotNull LookupLocation lookupLocation) {
        ClassDescriptor $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(lookupLocation, "lookupLocation");
        ClassDescriptor classDescriptor = $receiver$iv = DescriptorUtilKt.findContinuationClassDescriptorOrNull($receiver, lookupLocation);
        if (classDescriptor == null) {
            AssertionError assertionError;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = assertionError;
            String string = "Continuation interface is not found";
            assertionError2((Object)string);
            throw (Throwable)((Object)assertionError3);
        }
        return classDescriptor;
    }
}

