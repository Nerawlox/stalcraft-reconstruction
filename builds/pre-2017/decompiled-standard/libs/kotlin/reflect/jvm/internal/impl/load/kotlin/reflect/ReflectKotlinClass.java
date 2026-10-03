/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectClassStructure;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectKotlinClass
implements KotlinJvmBinaryClass {
    @NotNull
    private final Class<?> klass;
    @NotNull
    private final KotlinClassHeader classHeader;
    public static final Factory Factory = new Factory(null);

    @Override
    @NotNull
    public String getLocation() {
        return StringsKt.replace$default(this.klass.getName(), '.', '/', false, 4, null) + ".class";
    }

    @Override
    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @Override
    public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor visitor2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, visitor2);
    }

    @Override
    public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor visitor2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, visitor2);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectKotlinClass && Intrinsics.areEqual(this.klass, ((ReflectKotlinClass)other).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.klass;
    }

    @NotNull
    public final Class<?> getKlass() {
        return this.klass;
    }

    @Override
    @NotNull
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    private ReflectKotlinClass(Class<?> klass, KotlinClassHeader classHeader) {
        this.klass = klass;
        this.classHeader = classHeader;
    }

    public /* synthetic */ ReflectKotlinClass(@NotNull Class klass, @NotNull KotlinClassHeader classHeader, DefaultConstructorMarker $constructor_marker) {
        this(klass, classHeader);
    }

    public static final class Factory {
        @Nullable
        public final ReflectKotlinClass create(@NotNull Class<?> klass) {
            Intrinsics.checkParameterIsNotNull(klass, "klass");
            ReadKotlinClassHeaderAnnotationVisitor headerReader = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(klass, headerReader);
            KotlinClassHeader kotlinClassHeader = headerReader.createHeader();
            if (kotlinClassHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(klass, kotlinClassHeader, null);
        }

        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

