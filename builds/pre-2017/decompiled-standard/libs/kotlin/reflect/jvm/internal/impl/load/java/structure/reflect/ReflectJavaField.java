/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaField
extends ReflectJavaMember
implements JavaField {
    @NotNull
    private final Field member;

    @Override
    public boolean isEnumEntry() {
        return this.getMember().isEnumConstant();
    }

    @Override
    @NotNull
    public ReflectJavaType getType() {
        Type type2 = this.getMember().getGenericType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "member.genericType");
        return ReflectJavaType.Factory.create(type2);
    }

    @Override
    @NotNull
    public Field getMember() {
        return this.member;
    }

    public ReflectJavaField(@NotNull Field member) {
        Intrinsics.checkParameterIsNotNull(member, "member");
        this.member = member;
    }
}

