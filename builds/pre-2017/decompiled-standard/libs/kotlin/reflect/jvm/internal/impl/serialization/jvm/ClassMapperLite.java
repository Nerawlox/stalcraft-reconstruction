/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE;

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull ClassId classId) {
        ClassId javaClassId;
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        String internalName = StringsKt.replace$default(classId.asString(), '.', '$', false, 4, null);
        String simpleName2 = StringsKt.removePrefix(internalName, (CharSequence)"kotlin/");
        if (Intrinsics.areEqual(simpleName2, internalName) ^ true) {
            JvmPrimitiveType[] jvmPrimitiveTypeArray = JvmPrimitiveType.values();
            for (int i = 0; i < jvmPrimitiveTypeArray.length; ++i) {
                JvmPrimitiveType jvmPrimitive = jvmPrimitiveTypeArray[i];
                PrimitiveType primitiveType = jvmPrimitive.getPrimitiveType();
                if (Intrinsics.areEqual(simpleName2, primitiveType.getTypeName().asString())) {
                    String string = jvmPrimitive.getDesc();
                    Intrinsics.checkExpressionValueIsNotNull(string, "jvmPrimitive.desc");
                    return string;
                }
                if (!Intrinsics.areEqual(simpleName2, primitiveType.getArrayTypeName().asString())) continue;
                return "[" + jvmPrimitive.getDesc();
            }
            if (Intrinsics.areEqual(simpleName2, KotlinBuiltIns.FQ_NAMES.unit.shortName().asString())) {
                return "V";
            }
        }
        if ((javaClassId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classId.asSingleFqName().toUnsafe())) != null) {
            return "L" + StringsKt.replace$default(javaClassId.asString(), '.', '$', false, 4, null) + ";";
        }
        return "L" + internalName + ";";
    }

    private ClassMapperLite() {
        INSTANCE = this;
    }

    static {
        new ClassMapperLite();
    }
}

