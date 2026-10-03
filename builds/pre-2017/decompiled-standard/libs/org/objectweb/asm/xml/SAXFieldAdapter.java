/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.xml.SAXAdapter;
import org.objectweb.asm.xml.SAXAnnotationAdapter;
import org.xml.sax.Attributes;

public final class SAXFieldAdapter
extends FieldVisitor {
    SAXAdapter sa;

    public SAXFieldAdapter(SAXAdapter sa, Attributes att) {
        super(393216);
        this.sa = sa;
        sa.addStart("field", att);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "annotation", visible ? 1 : -1, null, desc);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "typeAnnotation", visible ? 1 : -1, null, desc, typeRef, typePath);
    }

    @Override
    public void visitEnd() {
        this.sa.addEnd("field");
    }
}

