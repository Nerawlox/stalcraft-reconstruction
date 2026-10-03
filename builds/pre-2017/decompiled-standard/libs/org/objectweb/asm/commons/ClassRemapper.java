/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.List;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.commons.AnnotationRemapper;
import org.objectweb.asm.commons.FieldRemapper;
import org.objectweb.asm.commons.MethodRemapper;
import org.objectweb.asm.commons.ModuleHashesAttribute;
import org.objectweb.asm.commons.ModuleRemapper;
import org.objectweb.asm.commons.Remapper;

public class ClassRemapper
extends ClassVisitor {
    protected final Remapper remapper;
    protected String className;

    public ClassRemapper(ClassVisitor cv, Remapper remapper) {
        this(393216, cv, remapper);
    }

    protected ClassRemapper(int api, ClassVisitor cv, Remapper remapper) {
        super(api, cv);
        this.remapper = remapper;
    }

    @Override
    public void visit(int version, int access, String name2, String signature2, String superName, String[] interfaces) {
        this.className = name2;
        super.visit(version, access, this.remapper.mapType(name2), this.remapper.mapSignature(signature2, false), this.remapper.mapType(superName), interfaces == null ? null : this.remapper.mapTypes(interfaces));
    }

    @Override
    public ModuleVisitor visitModule(String name2, int flags, String version) {
        ModuleVisitor mv = super.visitModule(this.remapper.mapModuleName(name2), flags, version);
        return mv == null ? null : this.createModuleRemapper(mv);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationVisitor av = super.visitAnnotation(this.remapper.mapDesc(desc), visible);
        return av == null ? null : this.createAnnotationRemapper(av);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av == null ? null : this.createAnnotationRemapper(av);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        if (attr instanceof ModuleHashesAttribute) {
            ModuleHashesAttribute hashesAttr = new ModuleHashesAttribute();
            List<String> modules = hashesAttr.modules;
            for (int i = 0; i < modules.size(); ++i) {
                modules.set(i, this.remapper.mapModuleName(modules.get(i)));
            }
        }
        super.visitAttribute(attr);
    }

    @Override
    public FieldVisitor visitField(int access, String name2, String desc, String signature2, Object value) {
        FieldVisitor fv = super.visitField(access, this.remapper.mapFieldName(this.className, name2, desc), this.remapper.mapDesc(desc), this.remapper.mapSignature(signature2, true), this.remapper.mapValue(value));
        return fv == null ? null : this.createFieldRemapper(fv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name2, String desc, String signature2, String[] exceptions) {
        String newDesc = this.remapper.mapMethodDesc(desc);
        MethodVisitor mv = super.visitMethod(access, this.remapper.mapMethodName(this.className, name2, desc), newDesc, this.remapper.mapSignature(signature2, false), exceptions == null ? null : this.remapper.mapTypes(exceptions));
        return mv == null ? null : this.createMethodRemapper(mv);
    }

    @Override
    public void visitInnerClass(String name2, String outerName, String innerName, int access) {
        super.visitInnerClass(this.remapper.mapType(name2), outerName == null ? null : this.remapper.mapType(outerName), innerName, access);
    }

    @Override
    public void visitOuterClass(String owner, String name2, String desc) {
        super.visitOuterClass(this.remapper.mapType(owner), name2 == null ? null : this.remapper.mapMethodName(owner, name2, desc), desc == null ? null : this.remapper.mapMethodDesc(desc));
    }

    protected FieldVisitor createFieldRemapper(FieldVisitor fv) {
        return new FieldRemapper(fv, this.remapper);
    }

    protected MethodVisitor createMethodRemapper(MethodVisitor mv) {
        return new MethodRemapper(mv, this.remapper);
    }

    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor av) {
        return new AnnotationRemapper(av, this.remapper);
    }

    protected ModuleVisitor createModuleRemapper(ModuleVisitor mv) {
        return new ModuleRemapper(mv, this.remapper);
    }
}

