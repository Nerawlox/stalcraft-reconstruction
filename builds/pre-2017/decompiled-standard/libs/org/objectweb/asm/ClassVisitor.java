/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.TypePath;

public abstract class ClassVisitor {
    protected final int api;
    protected ClassVisitor cv;

    public ClassVisitor(int api) {
        this(api, null);
    }

    public ClassVisitor(int api, ClassVisitor cv) {
        if (api < 262144 || api > 393216) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.cv = cv;
    }

    public void visit(int version, int access, String name2, String signature2, String superName, String[] interfaces) {
        if (this.cv != null) {
            this.cv.visit(version, access, name2, signature2, superName, interfaces);
        }
    }

    public void visitSource(String source, String debug) {
        if (this.cv != null) {
            this.cv.visitSource(source, debug);
        }
    }

    public ModuleVisitor visitModule(String name2, int access, String version) {
        if (this.api < 393216) {
            throw new RuntimeException();
        }
        if (this.cv != null) {
            return this.cv.visitModule(name2, access, version);
        }
        return null;
    }

    public void visitOuterClass(String owner, String name2, String desc) {
        if (this.cv != null) {
            this.cv.visitOuterClass(owner, name2, desc);
        }
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (this.cv != null) {
            return this.cv.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api < 327680) {
            throw new RuntimeException();
        }
        if (this.cv != null) {
            return this.cv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attr) {
        if (this.cv != null) {
            this.cv.visitAttribute(attr);
        }
    }

    public void visitInnerClass(String name2, String outerName, String innerName, int access) {
        if (this.cv != null) {
            this.cv.visitInnerClass(name2, outerName, innerName, access);
        }
    }

    public FieldVisitor visitField(int access, String name2, String desc, String signature2, Object value) {
        if (this.cv != null) {
            return this.cv.visitField(access, name2, desc, signature2, value);
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name2, String desc, String signature2, String[] exceptions) {
        if (this.cv != null) {
            return this.cv.visitMethod(access, name2, desc, signature2, exceptions);
        }
        return null;
    }

    public void visitEnd() {
        if (this.cv != null) {
            this.cv.visitEnd();
        }
    }
}

