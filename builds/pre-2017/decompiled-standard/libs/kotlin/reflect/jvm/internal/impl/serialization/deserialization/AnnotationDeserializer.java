/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer$WhenMappings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class AnnotationDeserializer {
    private final ConstantValueFactory factory;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation proto, @NotNull NameResolver nameResolver) {
        ClassConstructorDescriptor constructor;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        ClassId classId = nameResolver.getClassId(proto.getId());
        Intrinsics.checkExpressionValueIsNotNull(classId, "nameResolver.getClassId(proto.id)");
        ClassDescriptor annotationClass = this.resolveClass(classId);
        Map<ValueParameterDescriptor, ConstantValue<Object>> arguments2 = MapsKt.emptyMap();
        if (proto.getArgumentCount() != 0 && !ErrorUtils.isError(annotationClass) && DescriptorUtils.isAnnotationClass(annotationClass) && (constructor = (ClassConstructorDescriptor)CollectionsKt.singleOrNull((Iterable)annotationClass.getConstructors())) != null) {
            void $receiver$iv$iv;
            void $receiver$iv$iv2;
            Iterable $receiver$iv = constructor.getValueParameters();
            int capacity$iv22 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
            Iterable iterable = $receiver$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv22);
            for (Object element$iv$iv : $receiver$iv$iv2) {
                void it;
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)element$iv$iv;
                Map map2 = destination$iv$iv;
                Name name2 = it.getName();
                map2.put(name2, element$iv$iv);
            }
            Map parameterByName = destination$iv$iv;
            Iterable capacity$iv22 = $receiver$iv = (Iterable)proto.getArgumentList();
            Collection destination$iv$iv2 = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            Iterator iterator2 = $receiver$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                Pair<ValueParameterDescriptor, ConstantValue<?>> pair;
                ProtoBuf.Annotation.Argument it;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                ProtoBuf.Annotation.Argument argument = it = (ProtoBuf.Annotation.Argument)element$iv$iv;
                Intrinsics.checkExpressionValueIsNotNull(argument, "it");
                if (this.resolveArgument(argument, parameterByName, nameResolver) == null) continue;
                Pair<ValueParameterDescriptor, ConstantValue<?>> it$iv$iv = pair;
                destination$iv$iv2.add(it$iv$iv);
            }
            arguments2 = MapsKt.toMap((List)destination$iv$iv2);
        }
        return new AnnotationDescriptorImpl(annotationClass.getDefaultType(), arguments2, SourceElement.NO_SOURCE);
    }

    private final Pair<ValueParameterDescriptor, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument proto, Map<Name, ? extends ValueParameterDescriptor> parameterByName, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = parameterByName.get(nameResolver.getName(proto.getNameId()));
        if (valueParameterDescriptor == null) {
            return null;
        }
        ValueParameterDescriptor parameter = valueParameterDescriptor;
        KotlinType kotlinType = parameter.getType();
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = proto.getValue();
        Intrinsics.checkExpressionValueIsNotNull(value, "proto.value");
        return new Pair(parameter, this.resolveValue(kotlinType, value, nameResolver));
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType expectedType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        v0 = value.getType();
        if (v0 == null) ** GOTO lbl-1000
        switch (AnnotationDeserializer$WhenMappings.$EnumSwitchMapping$0[v0.ordinal()]) {
            case 1: {
                v1 = this.factory.createByteValue((byte)value.getIntValue());
                break;
            }
            case 2: {
                v1 = this.factory.createCharValue((char)value.getIntValue());
                break;
            }
            case 3: {
                v1 = this.factory.createShortValue((short)value.getIntValue());
                break;
            }
            case 4: {
                v1 = this.factory.createIntValue((int)value.getIntValue());
                break;
            }
            case 5: {
                v1 = this.factory.createLongValue(value.getIntValue());
                break;
            }
            case 6: {
                v1 = this.factory.createFloatValue(value.getFloatValue());
                break;
            }
            case 7: {
                v1 = this.factory.createDoubleValue(value.getDoubleValue());
                break;
            }
            case 8: {
                v1 = this.factory.createBooleanValue(value.getIntValue() != 0L);
                break;
            }
            case 9: {
                v2 = nameResolver.getString(value.getStringValue());
                Intrinsics.checkExpressionValueIsNotNull(v2, "nameResolver.getString(value.stringValue)");
                v1 = this.factory.createStringValue(v2);
                break;
            }
            case 10: {
                var4_4 = "Class literal annotation arguments are not supported yet (" + nameResolver.getClassId(value.getClassId()) + ")";
                throw (Throwable)new IllegalStateException(var4_4.toString());
            }
            case 11: {
                v3 = nameResolver.getClassId(value.getClassId());
                Intrinsics.checkExpressionValueIsNotNull(v3, "nameResolver.getClassId(value.classId)");
                v4 = nameResolver.getName(value.getEnumValueId());
                Intrinsics.checkExpressionValueIsNotNull(v4, "nameResolver.getName(value.enumValueId)");
                v1 = this.resolveEnumValue(v3, v4);
                break;
            }
            case 12: {
                v5 = value.getAnnotation();
                Intrinsics.checkExpressionValueIsNotNull(v5, "value.annotation");
                v1 = new AnnotationValue(this.deserializeAnnotation(v5, nameResolver));
                break;
            }
            case 13: {
                expectedIsArray = KotlinBuiltIns.isArray(expectedType) != false || KotlinBuiltIns.isPrimitiveArray(expectedType) != false;
                arrayElements = value.getArrayElementList();
                var6_8 = arrayElements;
                if (var6_8.isEmpty() == false) {
                    v6 = CollectionsKt.first(arrayElements);
                    Intrinsics.checkExpressionValueIsNotNull(v6, "arrayElements.first()");
                    actualElementType = this.resolveArrayElementType(v6, nameResolver);
                    v7 = this.getBuiltIns().getPrimitiveArrayKotlinTypeByPrimitiveKotlinType(actualElementType);
                    if (v7 != null) {
                        v8 = v7;
                    } else {
                        v9 = this.getBuiltIns().getArrayType(Variance.INVARIANT, actualElementType);
                        Intrinsics.checkExpressionValueIsNotNull(v9, "builtIns.getArrayType(Va\u2026RIANT, actualElementType)");
                        v8 = v9;
                    }
                } else if (expectedIsArray) {
                    v8 = expectedType;
                } else {
                    v10 = this.getBuiltIns().getArrayType(Variance.INVARIANT, this.getBuiltIns().getAnyType());
                    Intrinsics.checkExpressionValueIsNotNull(v10, "builtIns.getArrayType(Va\u2026T, builtIns.getAnyType())");
                    v8 = v10;
                }
                actualArrayType = v8;
                expectedElementType = this.getBuiltIns().getArrayElementType(expectedIsArray != false ? expectedType : actualArrayType);
                var8_10 = arrayElements;
                var9_11 = this.factory;
                var10_12 = $receiver$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    var14_16 = (ProtoBuf.Annotation.Argument.Value)item$iv$iv;
                    var15_17 = destination$iv$iv;
                    v11 = expectedElementType;
                    Intrinsics.checkExpressionValueIsNotNull(v11, "expectedElementType");
                    v12 = it;
                    Intrinsics.checkExpressionValueIsNotNull(v12, "it");
                    var16_18 = this.resolveValue(v11, (ProtoBuf.Annotation.Argument.Value)v12, nameResolver);
                    var15_17.add(var16_18);
                }
                var15_17 = (List)destination$iv$iv;
                v1 = var9_11.createArrayValue((List<? extends ConstantValue<?>>)var15_17, actualArrayType);
                break;
            }
            default: lbl-1000:
            // 2 sources

            {
                var4_6 = "Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ")";
                throw (Throwable)new IllegalStateException(var4_6.toString());
            }
        }
        result = v1;
        if (TypeUtilsKt.isSubtypeOf(result.getType(), expectedType)) {
            return result;
        }
        return this.factory.createErrorValue("Unexpected argument value");
    }

    private final ConstantValue<?> resolveEnumValue(ClassId enumClassId, Name enumEntryName) {
        ClassifierDescriptor enumEntry;
        ClassDescriptor enumClass = this.resolveClass(enumClassId);
        if (Intrinsics.areEqual((Object)enumClass.getKind(), (Object)ClassKind.ENUM_CLASS) && (enumEntry = enumClass.getUnsubstitutedInnerClassesScope().getContributedClassifier(enumEntryName, NoLookupLocation.FROM_DESERIALIZATION)) instanceof ClassDescriptor) {
            return this.factory.createEnumValue((ClassDescriptor)enumEntry);
        }
        return this.factory.createErrorValue("Unresolved enum entry: " + enumClassId + "." + enumEntryName);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final SimpleType resolveArrayElementType(ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        KotlinBuiltIns kotlinBuiltIns;
        KotlinBuiltIns $receiver = kotlinBuiltIns = this.getBuiltIns();
        ProtoBuf.Annotation.Argument.Value.Type type2 = value.getType();
        if (type2 != null) {
            switch (AnnotationDeserializer$WhenMappings.$EnumSwitchMapping$1[type2.ordinal()]) {
                case 1: {
                    SimpleType simpleType2 = $receiver.getByteType();
                    SimpleType simpleType3 = simpleType2;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType2, "getByteType()");
                    return simpleType3;
                }
                case 2: {
                    SimpleType simpleType4 = $receiver.getCharType();
                    SimpleType simpleType3 = simpleType4;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType4, "getCharType()");
                    return simpleType3;
                }
                case 3: {
                    SimpleType simpleType5 = $receiver.getShortType();
                    SimpleType simpleType3 = simpleType5;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType5, "getShortType()");
                    return simpleType3;
                }
                case 4: {
                    SimpleType simpleType6 = $receiver.getIntType();
                    SimpleType simpleType3 = simpleType6;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType6, "getIntType()");
                    return simpleType3;
                }
                case 5: {
                    SimpleType simpleType7 = $receiver.getLongType();
                    SimpleType simpleType3 = simpleType7;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType7, "getLongType()");
                    return simpleType3;
                }
                case 6: {
                    SimpleType simpleType8 = $receiver.getFloatType();
                    SimpleType simpleType3 = simpleType8;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType8, "getFloatType()");
                    return simpleType3;
                }
                case 7: {
                    SimpleType simpleType9 = $receiver.getDoubleType();
                    SimpleType simpleType3 = simpleType9;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType9, "getDoubleType()");
                    return simpleType3;
                }
                case 8: {
                    SimpleType simpleType10 = $receiver.getBooleanType();
                    SimpleType simpleType3 = simpleType10;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType10, "getBooleanType()");
                    return simpleType3;
                }
                case 9: {
                    SimpleType simpleType11 = $receiver.getStringType();
                    SimpleType simpleType3 = simpleType11;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType11, "getStringType()");
                    return simpleType3;
                }
                case 10: {
                    String string = "Arrays of class literals are not supported yet";
                    throw (Throwable)new IllegalStateException(string.toString());
                }
                case 11: {
                    ClassId classId = nameResolver.getClassId(value.getClassId());
                    Intrinsics.checkExpressionValueIsNotNull(classId, "nameResolver.getClassId(value.classId)");
                    SimpleType simpleType12 = this.resolveClass(classId).getDefaultType();
                    SimpleType simpleType3 = simpleType12;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType12, "resolveClass(nameResolve\u2026lue.classId)).defaultType");
                    return simpleType3;
                }
                case 12: {
                    ClassId classId = nameResolver.getClassId(value.getAnnotation().getId());
                    Intrinsics.checkExpressionValueIsNotNull(classId, "nameResolver.getClassId(value.annotation.id)");
                    SimpleType simpleType13 = this.resolveClass(classId).getDefaultType();
                    SimpleType simpleType3 = simpleType13;
                    Intrinsics.checkExpressionValueIsNotNull(simpleType13, "resolveClass(nameResolve\u2026notation.id)).defaultType");
                    return simpleType3;
                }
                case 13: {
                    String string = "Array of arrays is impossible";
                    throw (Throwable)new IllegalStateException(string.toString());
                }
            }
        }
        String string = "Unknown type: " + value.getType();
        throw (Throwable)new IllegalStateException(string.toString());
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    public AnnotationDeserializer(@NotNull ModuleDescriptor module, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(notFoundClasses, "notFoundClasses");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.factory = new ConstantValueFactory(this.getBuiltIns());
    }
}

