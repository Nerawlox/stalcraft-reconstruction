/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KotlinJvmBinaryClass {
    @NotNull
    public ClassId getClassId();

    @NotNull
    public String getLocation();

    public void loadClassAnnotations(@NotNull AnnotationVisitor var1);

    public void visitMembers(@NotNull MemberVisitor var1);

    @NotNull
    public KotlinClassHeader getClassHeader();

    public static interface MemberVisitor {
        @Nullable
        public MethodAnnotationVisitor visitMethod(@NotNull Name var1, @NotNull String var2);

        @Nullable
        public AnnotationVisitor visitField(@NotNull Name var1, @NotNull String var2, @Nullable Object var3);
    }

    public static interface AnnotationVisitor {
        @Nullable
        public AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId var1, @NotNull SourceElement var2);

        public void visitEnd();
    }

    public static interface MethodAnnotationVisitor
    extends AnnotationVisitor {
        @Nullable
        public AnnotationArgumentVisitor visitParameterAnnotation(int var1, @NotNull ClassId var2, @NotNull SourceElement var3);
    }

    public static interface AnnotationArgumentVisitor {
        public void visit(@Nullable Name var1, @Nullable Object var2);

        public void visitEnum(@NotNull Name var1, @NotNull ClassId var2, @NotNull Name var3);

        @Nullable
        public AnnotationArgumentVisitor visitAnnotation(@NotNull Name var1, @NotNull ClassId var2);

        @Nullable
        public AnnotationArrayArgumentVisitor visitArray(@NotNull Name var1);

        public void visitEnd();
    }

    public static interface AnnotationArrayArgumentVisitor {
        public void visit(@Nullable Object var1);

        public void visitEnum(@NotNull ClassId var1, @NotNull Name var2);

        public void visitEnd();
    }
}

