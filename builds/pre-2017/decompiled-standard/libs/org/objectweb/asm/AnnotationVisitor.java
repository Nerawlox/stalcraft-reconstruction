/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm;

public abstract class AnnotationVisitor {
    protected final int api;
    protected AnnotationVisitor av;

    public AnnotationVisitor(int api) {
        this(api, null);
    }

    public AnnotationVisitor(int api, AnnotationVisitor av) {
        if (api < 262144 || api > 393216) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.av = av;
    }

    public void visit(String name2, Object value) {
        if (this.av != null) {
            this.av.visit(name2, value);
        }
    }

    public void visitEnum(String name2, String desc, String value) {
        if (this.av != null) {
            this.av.visitEnum(name2, desc, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name2, String desc) {
        if (this.av != null) {
            return this.av.visitAnnotation(name2, desc);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name2) {
        if (this.av != null) {
            return this.av.visitArray(name2);
        }
        return null;
    }

    public void visitEnd() {
        if (this.av != null) {
            this.av.visitEnd();
        }
    }
}

