/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.commons.LocalVariablesSorter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingAnnotationAdapter;

@Deprecated
public class RemappingMethodAdapter
extends LocalVariablesSorter {
    protected final Remapper remapper;

    public RemappingMethodAdapter(int access, String desc, MethodVisitor mv, Remapper remapper) {
        this(393216, access, desc, mv, remapper);
    }

    protected RemappingMethodAdapter(int api, int access, String desc, MethodVisitor mv, Remapper remapper) {
        super(api, access, desc, mv);
        this.remapper = remapper;
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        AnnotationVisitor av = super.visitAnnotationDefault();
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationVisitor av = super.visitAnnotation(this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        AnnotationVisitor av = super.visitParameterAnnotation(parameter, this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public void visitFrame(int type2, int nLocal, Object[] local, int nStack, Object[] stack) {
        super.visitFrame(type2, nLocal, this.remapEntries(nLocal, local), nStack, this.remapEntries(nStack, stack));
    }

    private Object[] remapEntries(int n, Object[] entries) {
        if (entries != null) {
            for (int i = 0; i < n; ++i) {
                if (!(entries[i] instanceof String)) continue;
                Object[] newEntries = new Object[n];
                if (i > 0) {
                    System.arraycopy(entries, 0, newEntries, 0, i);
                }
                do {
                    Object t = entries[i];
                    Object object = newEntries[i++] = t instanceof String ? this.remapper.mapType((String)t) : t;
                } while (i < n);
                return newEntries;
            }
        }
        return entries;
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        super.visitFieldInsn(opcode, this.remapper.mapType(owner), this.remapper.mapFieldName(owner, name2, desc), this.remapper.mapDesc(desc));
    }

    @Override
    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name2, String desc) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc);
            return;
        }
        this.doVisitMethodInsn(opcode, owner, name2, desc, opcode == 185);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name2, String desc, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner, name2, desc, itf);
            return;
        }
        this.doVisitMethodInsn(opcode, owner, name2, desc, itf);
    }

    private void doVisitMethodInsn(int opcode, String owner, String name2, String desc, boolean itf) {
        if (this.mv != null) {
            this.mv.visitMethodInsn(opcode, this.remapper.mapType(owner), this.remapper.mapMethodName(owner, name2, desc), this.remapper.mapMethodDesc(desc), itf);
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        for (int i = 0; i < bsmArgs.length; ++i) {
            bsmArgs[i] = this.remapper.mapValue(bsmArgs[i]);
        }
        super.visitInvokeDynamicInsn(this.remapper.mapInvokeDynamicMethodName(name2, desc), this.remapper.mapMethodDesc(desc), (Handle)this.remapper.mapValue(bsm), bsmArgs);
    }

    @Override
    public void visitTypeInsn(int opcode, String type2) {
        super.visitTypeInsn(opcode, this.remapper.mapType(type2));
    }

    @Override
    public void visitLdcInsn(Object cst) {
        super.visitLdcInsn(this.remapper.mapValue(cst));
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        super.visitMultiANewArrayInsn(this.remapper.mapDesc(desc), dims);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av = super.visitInsnAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type2) {
        super.visitTryCatchBlock(start, end, handler, type2 == null ? null : this.remapper.mapType(type2));
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AnnotationVisitor av = super.visitTryCatchAnnotation(typeRef, typePath, this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }

    @Override
    public void visitLocalVariable(String name2, String desc, String signature2, Label start, Label end, int index) {
        super.visitLocalVariable(name2, this.remapper.mapDesc(desc), this.remapper.mapSignature(signature2, true), start, end, index);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        AnnotationVisitor av = super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, this.remapper.mapDesc(desc), visible);
        return av == null ? av : new RemappingAnnotationAdapter(av, this.remapper);
    }
}

