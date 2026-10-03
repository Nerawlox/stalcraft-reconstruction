/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor $receiver, @NotNull ClassId classId) {
        ClassDescriptor topLevelClass;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FqName fqName2 = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.packageFqName");
        PackageViewDescriptor packageViewDescriptor = $receiver.getPackage(fqName2);
        List<Name> segments = classId.getRelativeClassName().pathSegments();
        MemberScope memberScope2 = packageViewDescriptor.getMemberScope();
        Name name2 = CollectionsKt.first(segments);
        Intrinsics.checkExpressionValueIsNotNull(name2, "segments.first()");
        ClassifierDescriptor classifierDescriptor = memberScope2.getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor result2 = topLevelClass = classDescriptor;
        for (Name name3 : segments.subList(1, segments.size())) {
            MemberScope memberScope3 = result2.getUnsubstitutedInnerClassesScope();
            Name name4 = name3;
            Intrinsics.checkExpressionValueIsNotNull(name4, "name");
            ClassifierDescriptor classifierDescriptor2 = memberScope3.getContributedClassifier(name4, NoLookupLocation.FROM_DESERIALIZATION);
            if (!(classifierDescriptor2 instanceof ClassDescriptor)) {
                classifierDescriptor2 = null;
            }
            if ((ClassDescriptor)classifierDescriptor2 != null) continue;
            return null;
        }
        return result2;
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor $receiver, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        ClassDescriptor existingClass = FindClassInModuleKt.findClassAcrossModuleDependencies($receiver, classId);
        if (existingClass != null) {
            return existingClass;
        }
        List<Integer> typeParametersCount2 = SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, (Function1)findNonGenericClassAcrossDependencies.typeParametersCount.1.INSTANCE), findNonGenericClassAcrossDependencies.typeParametersCount.2.INSTANCE));
        ClassifierDescriptor classifierDescriptor = notFoundClasses.getClass(classId, typeParametersCount2).getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        return (ClassDescriptor)classifierDescriptor;
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor $receiver, @NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FqName fqName2 = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.packageFqName");
        PackageViewDescriptor packageViewDescriptor = $receiver.getPackage(fqName2);
        List<Name> segments = classId.getRelativeClassName().pathSegments();
        int lastNameIndex = segments.size() - 1;
        MemberScope memberScope2 = packageViewDescriptor.getMemberScope();
        Name name2 = CollectionsKt.first(segments);
        Intrinsics.checkExpressionValueIsNotNull(name2, "segments.first()");
        ClassifierDescriptor topLevelClassifier = memberScope2.getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
        if (lastNameIndex == 0) {
            ClassifierDescriptor classifierDescriptor = topLevelClassifier;
            if (!(classifierDescriptor instanceof TypeAliasDescriptor)) {
                classifierDescriptor = null;
            }
            return (TypeAliasDescriptor)classifierDescriptor;
        }
        ClassifierDescriptor classifierDescriptor = topLevelClassifier;
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor currentClass = classDescriptor;
        for (Name name3 : segments.subList(1, lastNameIndex)) {
            MemberScope memberScope3 = currentClass.getUnsubstitutedInnerClassesScope();
            Name name4 = name3;
            Intrinsics.checkExpressionValueIsNotNull(name4, "name");
            ClassifierDescriptor classifierDescriptor2 = memberScope3.getContributedClassifier(name4, NoLookupLocation.FROM_DESERIALIZATION);
            if (!(classifierDescriptor2 instanceof ClassDescriptor)) {
                classifierDescriptor2 = null;
            }
            if ((ClassDescriptor)classifierDescriptor2 != null) continue;
            return null;
        }
        Name lastName = segments.get(lastNameIndex);
        MemberScope memberScope4 = currentClass.getUnsubstitutedMemberScope();
        Name name5 = lastName;
        Intrinsics.checkExpressionValueIsNotNull(name5, "lastName");
        ClassifierDescriptor classifierDescriptor3 = memberScope4.getContributedClassifier(name5, NoLookupLocation.FROM_DESERIALIZATION);
        if (!(classifierDescriptor3 instanceof TypeAliasDescriptor)) {
            classifierDescriptor3 = null;
        }
        return (TypeAliasDescriptor)classifierDescriptor3;
    }
}

