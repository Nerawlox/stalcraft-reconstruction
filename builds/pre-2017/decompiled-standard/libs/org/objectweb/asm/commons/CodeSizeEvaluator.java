/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CodeSizeEvaluator
extends MethodVisitor
implements Opcodes {
    private int minSize;
    private int maxSize;

    public CodeSizeEvaluator(MethodVisitor mv) {
        this(393216, mv);
    }

    protected CodeSizeEvaluator(int api, MethodVisitor mv) {
        super(api, mv);
    }

    public int getMinSize() {
        return this.minSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public void visitInsn(int opcode) {
        ++this.minSize;
        ++this.maxSize;
        if (this.mv != null) {
            this.mv.visitInsn(opcode);
        }
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        if (opcode == 17) {
            this.minSize += 3;
            this.maxSize += 3;
        } else {
            this.minSize += 2;
            this.maxSize += 2;
        }
        if (this.mv != null) {
            this.mv.visitIntInsn(opcode, operand);
        }
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        if (var < 4 && opcode != 169) {
            ++this.minSize;
            ++this.maxSize;
        } else if (var >= 256) {
            this.minSize += 4;
            this.maxSize += 4;
        } else {
            this.minSize += 2;
            this.maxSize += 2;
        }
        if (this.mv != null) {
            this.mv.visitVarInsn(opcode, var);
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type2) {
        this.minSize += 3;
        this.maxSize += 3;
        if (this.mv != null) {
            this.mv.visitTypeInsn(opcode, type2);
        }
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        this.minSize += 3;
        this.maxSize += 3;
        if (this.mv != null) {
            this.mv.visitFieldInsn(opcode, owner, name2, desc);
        }
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
        if (opcode == 185) {
            this.minSize += 5;
            this.maxSize += 5;
        } else {
            this.minSize += 3;
            this.maxSize += 3;
        }
        if (this.mv != null) {
            this.mv.visitMethodInsn(opcode, owner, name2, desc, itf);
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        this.minSize += 5;
        this.maxSize += 5;
        if (this.mv != null) {
            this.mv.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
        }
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        this.minSize += 3;
        this.maxSize = opcode == 167 || opcode == 168 ? (this.maxSize += 5) : (this.maxSize += 8);
        if (this.mv != null) {
            this.mv.visitJumpInsn(opcode, label);
        }
    }

    @Override
    public void visitLdcInsn(Object cst) {
        if (cst instanceof Long || cst instanceof Double) {
            this.minSize += 3;
            this.maxSize += 3;
        } else {
            this.minSize += 2;
            this.maxSize += 3;
        }
        if (this.mv != null) {
            this.mv.visitLdcInsn(cst);
        }
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        if (var > 255 || increment > 127 || increment < -128) {
            this.minSize += 6;
            this.maxSize += 6;
        } else {
            this.minSize += 3;
            this.maxSize += 3;
        }
        if (this.mv != null) {
            this.mv.visitIincInsn(var, increment);
        }
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.minSize += 13 + labels.length * 4;
        this.maxSize += 16 + labels.length * 4;
        if (this.mv != null) {
            this.mv.visitTableSwitchInsn(min, max, dflt, labels);
        }
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys2, Label[] labels) {
        this.minSize += 9 + keys2.length * 8;
        this.maxSize += 12 + keys2.length * 8;
        if (this.mv != null) {
            this.mv.visitLookupSwitchInsn(dflt, keys2, labels);
        }
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.minSize += 4;
        this.maxSize += 4;
        if (this.mv != null) {
            this.mv.visitMultiANewArrayInsn(desc, dims);
        }
    }
}

