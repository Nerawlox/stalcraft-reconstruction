/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.CheckMethodAdapter;

public class CheckAnnotationAdapter
extends AnnotationVisitor {
    private final boolean named;
    private boolean end;

    public CheckAnnotationAdapter(AnnotationVisitor av) {
        this(av, true);
    }

    CheckAnnotationAdapter(AnnotationVisitor av, boolean named) {
        super(393216, av);
        this.named = named;
    }

    @Override
    public void visit(String name2, Object value) {
        int sort;
        this.checkEnd();
        this.checkName(name2);
        if (!(value instanceof Byte || value instanceof Boolean || value instanceof Character || value instanceof Short || value instanceof Integer || value instanceof Long || value instanceof Float || value instanceof Double || value instanceof String || value instanceof Type || value instanceof byte[] || value instanceof boolean[] || value instanceof char[] || value instanceof short[] || value instanceof int[] || value instanceof long[] || value instanceof float[] || value instanceof double[])) {
            throw new IllegalArgumentException("Invalid annotation value");
        }
        if (value instanceof Type && (sort = ((Type)value).getSort()) == 11) {
            throw new IllegalArgumentException("Invalid annotation value");
        }
        if (this.av != null) {
            this.av.visit(name2, value);
        }
    }

    @Override
    public void visitEnum(String name2, String desc, String value) {
        this.checkEnd();
        this.checkName(name2);
        CheckMethodAdapter.checkDesc(desc, false);
        if (value == null) {
            throw new IllegalArgumentException("Invalid enum value");
        }
        if (this.av != null) {
            this.av.visitEnum(name2, desc, value);
        }
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name2, String desc) {
        this.checkEnd();
        this.checkName(name2);
        CheckMethodAdapter.checkDesc(desc, false);
        return new CheckAnnotationAdapter(this.av == null ? null : this.av.visitAnnotation(name2, desc));
    }

    @Override
    public AnnotationVisitor visitArray(String name2) {
        this.checkEnd();
        this.checkName(name2);
        return new CheckAnnotationAdapter(this.av == null ? null : this.av.visitArray(name2), false);
    }

    @Override
    public void visitEnd() {
        this.checkEnd();
        this.end = true;
        if (this.av != null) {
            this.av.visitEnd();
        }
    }

    private void checkEnd() {
        if (this.end) {
            throw new IllegalStateException("Cannot call a visit method after visitEnd has been called");
        }
    }

    private void checkName(String name2) {
        if (this.named && name2 == null) {
            throw new IllegalArgumentException("Annotation value name must not be null");
        }
    }
}

