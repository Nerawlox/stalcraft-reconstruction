/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class StaticInitMerger
extends ClassVisitor {
    private String name;
    private MethodVisitor clinit;
    private final String prefix;
    private int counter;

    public StaticInitMerger(String prefix, ClassVisitor cv) {
        this(393216, prefix, cv);
    }

    protected StaticInitMerger(int api, String prefix, ClassVisitor cv) {
        super(api, cv);
        this.prefix = prefix;
    }

    @Override
    public void visit(int version, int access, String name2, String signature2, String superName, String[] interfaces) {
        this.cv.visit(version, access, name2, signature2, superName, interfaces);
        this.name = name2;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name2, String desc, String signature2, String[] exceptions) {
        MethodVisitor mv;
        if ("<clinit>".equals(name2)) {
            int a = 10;
            String n = this.prefix + this.counter++;
            mv = this.cv.visitMethod(a, n, desc, signature2, exceptions);
            if (this.clinit == null) {
                this.clinit = this.cv.visitMethod(a, name2, desc, null, null);
            }
            this.clinit.visitMethodInsn(184, this.name, n, desc, false);
        } else {
            mv = this.cv.visitMethod(access, name2, desc, signature2, exceptions);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        if (this.clinit != null) {
            this.clinit.visitInsn(177);
            this.clinit.visitMaxs(0, 0);
        }
        this.cv.visitEnd();
    }
}

