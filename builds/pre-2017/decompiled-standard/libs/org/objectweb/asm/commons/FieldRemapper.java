/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.commons.AnnotationRemapper;
import org.objectweb.asm.commons.Remapper;

public class FieldRemapper
extends FieldVisitor {
    private final Remapper remapper;

    public FieldRemapper(FieldVisitor fv, Remapper remapper) {
        this(393216, fv, remapper);
    }

    protected FieldRemapper(int api, FieldVisitor fv, Remapper remapper) {
        super(api, fv);
        this.remapper = remapper;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationVisitor av = this.fv.visitAnnotation(this.remapper.mapDesc(desc), visible);
        return av == null ? null : new AnnotationRemapper(av, this.remapper);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av == null ? null : new AnnotationRemapper(av, this.remapper);
    }
}

