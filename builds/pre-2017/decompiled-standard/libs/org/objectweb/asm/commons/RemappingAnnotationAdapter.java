/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.commons.Remapper;

@Deprecated
public class RemappingAnnotationAdapter
extends AnnotationVisitor {
    protected final Remapper remapper;

    public RemappingAnnotationAdapter(AnnotationVisitor av, Remapper remapper) {
        this(393216, av, remapper);
    }

    protected RemappingAnnotationAdapter(int api, AnnotationVisitor av, Remapper remapper) {
        super(api, av);
        this.remapper = remapper;
    }

    @Override
    public void visit(String name2, Object value) {
        this.av.visit(name2, this.remapper.mapValue(value));
    }

    @Override
    public void visitEnum(String name2, String desc, String value) {
        this.av.visitEnum(name2, this.remapper.mapDesc(desc), value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name2, String desc) {
        AnnotationVisitor v = this.av.visitAnnotation(name2, this.remapper.mapDesc(desc));
        return v == null ? null : (v == this.av ? this : new RemappingAnnotationAdapter(v, this.remapper));
    }

    @Override
    public AnnotationVisitor visitArray(String name2) {
        AnnotationVisitor v = this.av.visitArray(name2);
        return v == null ? null : (v == this.av ? this : new RemappingAnnotationAdapter(v, this.remapper));
    }
}

