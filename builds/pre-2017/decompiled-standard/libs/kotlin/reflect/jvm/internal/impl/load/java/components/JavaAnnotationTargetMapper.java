/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationTargetMapper {
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists;
    private static final Map<String, KotlinRetention> retentionNameList;
    public static final JavaAnnotationTargetMapper INSTANCE;

    @NotNull
    public final Set<KotlinTarget> mapJavaTargetArgumentByName(@Nullable String argumentName) {
        Map<String, EnumSet<KotlinTarget>> map2;
        Map<String, EnumSet<KotlinTarget>> map3 = map2 = targetNameLists;
        if (map3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
        EnumSet<KotlinTarget> enumSet = map3.get(argumentName);
        return enumSet != null ? (Set<KotlinTarget>)enumSet : SetsKt.emptySet();
    }

    @Nullable
    public final ConstantValue<?> mapJavaTargetArguments(@NotNull List<? extends JavaAnnotationArgument> arguments2, @NotNull KotlinBuiltIns builtIns) {
        JavaEnumValueAnnotationArgument it;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        Iterable iterable = $receiver$iv = (Iterable)arguments2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof JavaEnumValueAnnotationArgument)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            it = (JavaEnumValueAnnotationArgument)element$iv$iv;
            Object object = it.resolve();
            Iterable list$iv$iv = INSTANCE.mapJavaTargetArgumentByName(object != null && (object = object.getName()) != null ? ((Name)object).asString() : null);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        Iterable $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            ClassDescriptor classDescriptor;
            Object element$iv$iv = element$iv$iv$iv;
            KotlinTarget it2 = (KotlinTarget)((Object)element$iv$iv);
            if (builtIns.getAnnotationTargetEnumEntry(it2) == null) continue;
            ClassDescriptor it$iv$iv = classDescriptor;
            destination$iv$iv.add(it$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            Object element$iv$iv$iv;
            element$iv$iv$iv = (ClassDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = it;
            Intrinsics.checkExpressionValueIsNotNull(javaEnumValueAnnotationArgument, "it");
            EnumValue enumValue = new EnumValue((ClassDescriptor)((Object)javaEnumValueAnnotationArgument));
            collection.add(enumValue);
        }
        List kotlinTargets = (List)destination$iv$iv;
        ValueParameterDescriptor parameterDescriptor = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$kotlin_core(), builtIns.getTargetAnnotation());
        Annotated annotated = parameterDescriptor;
        if (annotated == null || (annotated = annotated.getType()) == null) {
            SimpleType simpleType2 = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "ErrorUtils.createErrorTy\u2026ror: AnnotationTarget[]\")");
            annotated = simpleType2;
        }
        return new ArrayValue(kotlinTargets, (KotlinType)annotated, builtIns);
    }

    @Nullable
    public final ConstantValue<?> mapJavaRetentionArgument(@NotNull JavaAnnotationArgument element, @NotNull KotlinBuiltIns builtIns) {
        EnumValue enumValue;
        Intrinsics.checkParameterIsNotNull(element, "element");
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        JavaAnnotationArgument javaAnnotationArgument = element;
        if (!(javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument)) {
            javaAnnotationArgument = null;
        }
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument)javaAnnotationArgument;
        if (javaEnumValueAnnotationArgument != null) {
            EnumValue enumValue2;
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument2;
            JavaEnumValueAnnotationArgument it = javaEnumValueAnnotationArgument2 = javaEnumValueAnnotationArgument;
            Object object = retentionNameList;
            Object object2 = it.resolve();
            String string = object2 != null && (object2 = object2.getName()) != null ? ((Name)object2).asString() : null;
            Map<String, KotlinRetention> map2 = object;
            if (map2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            KotlinRetention kotlinRetention = map2.get(string);
            if (kotlinRetention != null) {
                EnumValue enumValue3;
                object = kotlinRetention;
                KotlinRetention it2 = (KotlinRetention)((Object)object);
                ClassDescriptor classDescriptor = builtIns.getAnnotationRetentionEnumEntry(it2);
                if (!(classDescriptor instanceof ClassDescriptor)) {
                    classDescriptor = null;
                }
                if (classDescriptor != null) {
                    ClassDescriptor classDescriptor2;
                    ClassDescriptor it3 = classDescriptor2 = classDescriptor;
                    enumValue3 = new EnumValue(it3);
                } else {
                    enumValue3 = null;
                }
                enumValue2 = enumValue3;
            } else {
                enumValue2 = null;
            }
            enumValue = enumValue2;
        } else {
            enumValue = null;
        }
        return enumValue;
    }

    private JavaAnnotationTargetMapper() {
        INSTANCE = this;
        targetNameLists = MapsKt.mapOf(TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of((Enum)KotlinTarget.CLASS, (Enum)KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of((Enum)KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of((Enum)KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of((Enum)KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of((Enum)KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of((Enum)KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of((Enum)KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of((Enum)KotlinTarget.FUNCTION, (Enum)KotlinTarget.PROPERTY_GETTER, (Enum)KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of((Enum)KotlinTarget.TYPE)));
        retentionNameList = MapsKt.mapOf(TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE));
    }

    static {
        new JavaAnnotationTargetMapper();
    }
}

