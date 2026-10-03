/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.util.Printer;

public final class TraceAnnotationVisitor
extends AnnotationVisitor {
    private final Printer p;

    public TraceAnnotationVisitor(Printer p) {
        this(null, p);
    }

    public TraceAnnotationVisitor(AnnotationVisitor av, Printer p) {
        super(393216, av);
        this.p = p;
    }

    @Override
    public void visit(String name2, Object value) {
        this.p.visit(name2, value);
        super.visit(name2, value);
    }

    @Override
    public void visitEnum(String name2, String desc, String value) {
        this.p.visitEnum(name2, desc, value);
        super.visitEnum(name2, desc, value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name2, String desc) {
        Printer p = this.p.visitAnnotation(name2, desc);
        AnnotationVisitor av = this.av == null ? null : this.av.visitAnnotation(name2, desc);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public AnnotationVisitor visitArray(String name2) {
        Printer p = this.p.visitArray(name2);
        AnnotationVisitor av = this.av == null ? null : this.av.visitArray(name2);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitEnd() {
        this.p.visitAnnotationEnd();
        super.visitEnd();
    }
}

