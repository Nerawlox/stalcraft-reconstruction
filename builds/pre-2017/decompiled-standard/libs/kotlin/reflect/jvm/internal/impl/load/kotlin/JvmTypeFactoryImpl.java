/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class JvmTypeFactoryImpl
implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE;

    @Override
    @NotNull
    public JvmType boxType(@NotNull JvmType possiblyPrimitiveType) {
        JvmType jvmType;
        Intrinsics.checkParameterIsNotNull(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof JvmType.Primitive && ((JvmType.Primitive)possiblyPrimitiveType).getJvmPrimitiveType() != null) {
            String string = JvmClassName.byFqNameWithoutInnerClasses(((JvmType.Primitive)possiblyPrimitiveType).getJvmPrimitiveType().getWrapperFqName()).getInternalName();
            Intrinsics.checkExpressionValueIsNotNull(string, "JvmClassName.byFqNameWit\u2026apperFqName).internalName");
            jvmType = this.createObjectType(string);
        } else {
            jvmType = possiblyPrimitiveType;
        }
        return jvmType;
    }

    @Override
    @NotNull
    public JvmType createFromString(@NotNull String representation) {
        JvmType jvmType;
        Object object;
        Object object2;
        int n;
        char firstChar;
        block10: {
            boolean bl;
            Intrinsics.checkParameterIsNotNull(representation, "representation");
            boolean bl2 = bl = representation.length() > 0;
            if (_Assertions.ENABLED && !bl) {
                String string = "empty string as JvmType";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            firstChar = representation.charAt(0);
            Object[] $receiver$iv = (Object[])JvmPrimitiveType.values();
            for (n = 0; n < $receiver$iv.length; ++n) {
                Object element$iv = $receiver$iv[n];
                JvmPrimitiveType it = (JvmPrimitiveType)((Object)element$iv);
                if (!(it.getDesc().charAt(0) == firstChar)) continue;
                object2 = element$iv;
                break block10;
            }
            object2 = null;
        }
        JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType)((Object)object2);
        if (jvmPrimitiveType != null) {
            JvmPrimitiveType it = object = jvmPrimitiveType;
            return new JvmType.Primitive(it);
        }
        switch (firstChar) {
            case 'V': {
                jvmType = new JvmType.Primitive(null);
                break;
            }
            case '[': {
                JvmType.Array array;
                object = representation;
                int it = 1;
                JvmTypeFactoryImpl jvmTypeFactoryImpl = this;
                JvmType.Array array2 = array;
                JvmType.Array array3 = array;
                Object object3 = object;
                if (object3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String string = ((String)object3).substring(it);
                Intrinsics.checkExpressionValueIsNotNull(string, "(this as java.lang.String).substring(startIndex)");
                String string2 = string;
                array2(jvmTypeFactoryImpl.createFromString(string2));
                jvmType = array3;
                break;
            }
            default: {
                JvmType.Object object4;
                boolean bl;
                boolean bl3 = bl = firstChar == 'L' && StringsKt.endsWith$default((CharSequence)representation, ';', false, 2, null);
                if (_Assertions.ENABLED && !bl) {
                    String string = "Type that is not primitive nor array should be Object, but '" + representation + "' was found";
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
                String string = representation;
                n = 1;
                int n2 = representation.length() - 1;
                JvmType.Object object5 = object4;
                JvmType.Object object6 = object4;
                String string3 = string;
                if (string3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String string4 = string3.substring(n, n2);
                Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                String string5 = string4;
                object5(string5);
                jvmType = object6;
            }
        }
        return jvmType;
    }

    @Override
    @NotNull
    public JvmType.Object createObjectType(@NotNull String internalName) {
        Intrinsics.checkParameterIsNotNull(internalName, "internalName");
        return new JvmType.Object(internalName);
    }

    @Override
    @NotNull
    public String toString(@NotNull JvmType type2) {
        Object object;
        Intrinsics.checkParameterIsNotNull(type2, "type");
        JvmType jvmType = type2;
        if (jvmType instanceof JvmType.Array) {
            object = "[" + this.toString(((JvmType.Array)type2).getElementType());
        } else if (jvmType instanceof JvmType.Primitive) {
            object = ((JvmType.Primitive)type2).getJvmPrimitiveType();
            if (object == null || (object = object.getDesc()) == null) {
                object = "V";
            }
        } else if (jvmType instanceof JvmType.Object) {
            object = "L" + ((JvmType.Object)type2).getInternalName() + ";";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return object;
    }

    @Override
    @NotNull
    public JvmType getJavaLangClassType() {
        return this.createObjectType("java/lang/Class");
    }

    private JvmTypeFactoryImpl() {
        INSTANCE = this;
    }

    static {
        new JvmTypeFactoryImpl();
    }
}

