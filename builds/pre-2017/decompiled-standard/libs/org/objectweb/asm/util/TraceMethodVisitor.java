/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.TraceAnnotationVisitor;

public final class TraceMethodVisitor
extends MethodVisitor {
    public final Printer p;

    public TraceMethodVisitor(Printer p) {
        this(null, p);
    }

    public TraceMethodVisitor(MethodVisitor mv, Printer p) {
        super(393216, mv);
        this.p = p;
    }

    @Override
    public void visitParameter(String name2, int access) {
        this.p.visitParameter(name2, access);
        super.visitParameter(name2, access);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        Printer p = this.p.visitMethodAnnotation(desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitAnnotation(desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        Printer p = this.p.visitMethodTypeAnnotation(typeRef, typePath, desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        this.p.visitMethodAttribute(attr);
        super.visitAttribute(attr);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        Printer p = this.p.visitAnnotationDefault();
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitAnnotationDefault();
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        Printer p = this.p.visitParameterAnnotation(parameter, desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitParameterAnnotation(parameter, desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitCode() {
        this.p.visitCode();
        super.visitCode();
    }

    @Override
    public void visitFrame(int type2, int nLocal, Object[] local, int nStack, Object[] stack) {
        this.p.visitFrame(type2, nLocal, local, nStack, stack);
        super.visitFrame(type2, nLocal, local, nStack, stack);
    }

    @Override
    public void visitInsn(int opcode) {
        this.p.visitInsn(opcode);
        super.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        this.p.visitIntInsn(opcode, operand);
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        this.p.visitVarInsn(opcode, var);
        super.visitVarInsn(opcode, var);
    }

    @Override
    public void visitTypeInsn(int opcode, String type2) {
        this.p.visitTypeInsn(opcode, type2);
        super.visitTypeInsn(opcode, type2);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        this.p.visitFieldInsn(opcode, owner, name2, desc);
        super.visitFieldInsn(opcode, owner, name2, desc);
    }

    @Override
    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name2, String desc) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc);
            return;
        }
        this.p.visitMethodInsn(opcode, owner, name2, desc);
        if (this.mv != null) {
            this.mv.visitMethodInsn(opcode, owner, name2, desc);
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name2, String desc, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc, itf);
            return;
        }
        this.p.visitMethodInsn(opcode, owner, name2, desc, itf);
        if (this.mv != null) {
            this.mv.visitMethodInsn(opcode, owner, name2, desc, itf);
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        this.p.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
        super.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        this.p.visitJumpInsn(opcode, label);
        super.visitJumpInsn(opcode, label);
    }

    @Override
    public void visitLabel(Label label) {
        this.p.visitLabel(label);
        super.visitLabel(label);
    }

    @Override
    public void visitLdcInsn(Object cst) {
        this.p.visitLdcInsn(cst);
        super.visitLdcInsn(cst);
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        this.p.visitIincInsn(var, increment);
        super.visitIincInsn(var, increment);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.p.visitTableSwitchInsn(min, max, dflt, labels);
        super.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys2, Label[] labels) {
        this.p.visitLookupSwitchInsn(dflt, keys2, labels);
        super.visitLookupSwitchInsn(dflt, keys2, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.p.visitMultiANewArrayInsn(desc, dims);
        super.visitMultiANewArrayInsn(desc, dims);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        Printer p = this.p.visitInsnAnnotation(typeRef, typePath, desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitInsnAnnotation(typeRef, typePath, desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type2) {
        this.p.visitTryCatchBlock(start, end, handler, type2);
        super.visitTryCatchBlock(start, end, handler, type2);
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        Printer p = this.p.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitLocalVariable(String name2, String desc, String signature2, Label start, Label end, int index) {
        this.p.visitLocalVariable(name2, desc, signature2, start, end, index);
        super.visitLocalVariable(name2, desc, signature2, start, end, index);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        Printer p = this.p.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
        AnnotationVisitor av = this.mv == null ? null : this.mv.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
        return new TraceAnnotationVisitor(av, p);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        this.p.visitLineNumber(line, start);
        super.visitLineNumber(line, start);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        this.p.visitMaxs(maxStack, maxLocals);
        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        this.p.visitMethodEnd();
        super.visitEnd();
    }
}

