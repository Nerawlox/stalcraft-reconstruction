/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class InstructionAdapter
extends MethodVisitor {
    public static final Type OBJECT_TYPE = Type.getType("Ljava/lang/Object;");

    public InstructionAdapter(MethodVisitor mv) {
        this(393216, mv);
        if (this.getClass() != InstructionAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected InstructionAdapter(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case 0: {
                this.nop();
                break;
            }
            case 1: {
                this.aconst(null);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                this.iconst(opcode - 3);
                break;
            }
            case 9: 
            case 10: {
                this.lconst(opcode - 9);
                break;
            }
            case 11: 
            case 12: 
            case 13: {
                this.fconst(opcode - 11);
                break;
            }
            case 14: 
            case 15: {
                this.dconst(opcode - 14);
                break;
            }
            case 46: {
                this.aload(Type.INT_TYPE);
                break;
            }
            case 47: {
                this.aload(Type.LONG_TYPE);
                break;
            }
            case 48: {
                this.aload(Type.FLOAT_TYPE);
                break;
            }
            case 49: {
                this.aload(Type.DOUBLE_TYPE);
                break;
            }
            case 50: {
                this.aload(OBJECT_TYPE);
                break;
            }
            case 51: {
                this.aload(Type.BYTE_TYPE);
                break;
            }
            case 52: {
                this.aload(Type.CHAR_TYPE);
                break;
            }
            case 53: {
                this.aload(Type.SHORT_TYPE);
                break;
            }
            case 79: {
                this.astore(Type.INT_TYPE);
                break;
            }
            case 80: {
                this.astore(Type.LONG_TYPE);
                break;
            }
            case 81: {
                this.astore(Type.FLOAT_TYPE);
                break;
            }
            case 82: {
                this.astore(Type.DOUBLE_TYPE);
                break;
            }
            case 83: {
                this.astore(OBJECT_TYPE);
                break;
            }
            case 84: {
                this.astore(Type.BYTE_TYPE);
                break;
            }
            case 85: {
                this.astore(Type.CHAR_TYPE);
                break;
            }
            case 86: {
                this.astore(Type.SHORT_TYPE);
                break;
            }
            case 87: {
                this.pop();
                break;
            }
            case 88: {
                this.pop2();
                break;
            }
            case 89: {
                this.dup();
                break;
            }
            case 90: {
                this.dupX1();
                break;
            }
            case 91: {
                this.dupX2();
                break;
            }
            case 92: {
                this.dup2();
                break;
            }
            case 93: {
                this.dup2X1();
                break;
            }
            case 94: {
                this.dup2X2();
                break;
            }
            case 95: {
                this.swap();
                break;
            }
            case 96: {
                this.add(Type.INT_TYPE);
                break;
            }
            case 97: {
                this.add(Type.LONG_TYPE);
                break;
            }
            case 98: {
                this.add(Type.FLOAT_TYPE);
                break;
            }
            case 99: {
                this.add(Type.DOUBLE_TYPE);
                break;
            }
            case 100: {
                this.sub(Type.INT_TYPE);
                break;
            }
            case 101: {
                this.sub(Type.LONG_TYPE);
                break;
            }
            case 102: {
                this.sub(Type.FLOAT_TYPE);
                break;
            }
            case 103: {
                this.sub(Type.DOUBLE_TYPE);
                break;
            }
            case 104: {
                this.mul(Type.INT_TYPE);
                break;
            }
            case 105: {
                this.mul(Type.LONG_TYPE);
                break;
            }
            case 106: {
                this.mul(Type.FLOAT_TYPE);
                break;
            }
            case 107: {
                this.mul(Type.DOUBLE_TYPE);
                break;
            }
            case 108: {
                this.div(Type.INT_TYPE);
                break;
            }
            case 109: {
                this.div(Type.LONG_TYPE);
                break;
            }
            case 110: {
                this.div(Type.FLOAT_TYPE);
                break;
            }
            case 111: {
                this.div(Type.DOUBLE_TYPE);
                break;
            }
            case 112: {
                this.rem(Type.INT_TYPE);
                break;
            }
            case 113: {
                this.rem(Type.LONG_TYPE);
                break;
            }
            case 114: {
                this.rem(Type.FLOAT_TYPE);
                break;
            }
            case 115: {
                this.rem(Type.DOUBLE_TYPE);
                break;
            }
            case 116: {
                this.neg(Type.INT_TYPE);
                break;
            }
            case 117: {
                this.neg(Type.LONG_TYPE);
                break;
            }
            case 118: {
                this.neg(Type.FLOAT_TYPE);
                break;
            }
            case 119: {
                this.neg(Type.DOUBLE_TYPE);
                break;
            }
            case 120: {
                this.shl(Type.INT_TYPE);
                break;
            }
            case 121: {
                this.shl(Type.LONG_TYPE);
                break;
            }
            case 122: {
                this.shr(Type.INT_TYPE);
                break;
            }
            case 123: {
                this.shr(Type.LONG_TYPE);
                break;
            }
            case 124: {
                this.ushr(Type.INT_TYPE);
                break;
            }
            case 125: {
                this.ushr(Type.LONG_TYPE);
                break;
            }
            case 126: {
                this.and(Type.INT_TYPE);
                break;
            }
            case 127: {
                this.and(Type.LONG_TYPE);
                break;
            }
            case 128: {
                this.or(Type.INT_TYPE);
                break;
            }
            case 129: {
                this.or(Type.LONG_TYPE);
                break;
            }
            case 130: {
                this.xor(Type.INT_TYPE);
                break;
            }
            case 131: {
                this.xor(Type.LONG_TYPE);
                break;
            }
            case 133: {
                this.cast(Type.INT_TYPE, Type.LONG_TYPE);
                break;
            }
            case 134: {
                this.cast(Type.INT_TYPE, Type.FLOAT_TYPE);
                break;
            }
            case 135: {
                this.cast(Type.INT_TYPE, Type.DOUBLE_TYPE);
                break;
            }
            case 136: {
                this.cast(Type.LONG_TYPE, Type.INT_TYPE);
                break;
            }
            case 137: {
                this.cast(Type.LONG_TYPE, Type.FLOAT_TYPE);
                break;
            }
            case 138: {
                this.cast(Type.LONG_TYPE, Type.DOUBLE_TYPE);
                break;
            }
            case 139: {
                this.cast(Type.FLOAT_TYPE, Type.INT_TYPE);
                break;
            }
            case 140: {
                this.cast(Type.FLOAT_TYPE, Type.LONG_TYPE);
                break;
            }
            case 141: {
                this.cast(Type.FLOAT_TYPE, Type.DOUBLE_TYPE);
                break;
            }
            case 142: {
                this.cast(Type.DOUBLE_TYPE, Type.INT_TYPE);
                break;
            }
            case 143: {
                this.cast(Type.DOUBLE_TYPE, Type.LONG_TYPE);
                break;
            }
            case 144: {
                this.cast(Type.DOUBLE_TYPE, Type.FLOAT_TYPE);
                break;
            }
            case 145: {
                this.cast(Type.INT_TYPE, Type.BYTE_TYPE);
                break;
            }
            case 146: {
                this.cast(Type.INT_TYPE, Type.CHAR_TYPE);
                break;
            }
            case 147: {
                this.cast(Type.INT_TYPE, Type.SHORT_TYPE);
                break;
            }
            case 148: {
                this.lcmp();
                break;
            }
            case 149: {
                this.cmpl(Type.FLOAT_TYPE);
                break;
            }
            case 150: {
                this.cmpg(Type.FLOAT_TYPE);
                break;
            }
            case 151: {
                this.cmpl(Type.DOUBLE_TYPE);
                break;
            }
            case 152: {
                this.cmpg(Type.DOUBLE_TYPE);
                break;
            }
            case 172: {
                this.areturn(Type.INT_TYPE);
                break;
            }
            case 173: {
                this.areturn(Type.LONG_TYPE);
                break;
            }
            case 174: {
                this.areturn(Type.FLOAT_TYPE);
                break;
            }
            case 175: {
                this.areturn(Type.DOUBLE_TYPE);
                break;
            }
            case 176: {
                this.areturn(OBJECT_TYPE);
                break;
            }
            case 177: {
                this.areturn(Type.VOID_TYPE);
                break;
            }
            case 190: {
                this.arraylength();
                break;
            }
            case 191: {
                this.athrow();
                break;
            }
            case 194: {
                this.monitorenter();
                break;
            }
            case 195: {
                this.monitorexit();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        block0 : switch (opcode) {
            case 16: {
                this.iconst(operand);
                break;
            }
            case 17: {
                this.iconst(operand);
                break;
            }
            case 188: {
                switch (operand) {
                    case 4: {
                        this.newarray(Type.BOOLEAN_TYPE);
                        break block0;
                    }
                    case 5: {
                        this.newarray(Type.CHAR_TYPE);
                        break block0;
                    }
                    case 8: {
                        this.newarray(Type.BYTE_TYPE);
                        break block0;
                    }
                    case 9: {
                        this.newarray(Type.SHORT_TYPE);
                        break block0;
                    }
                    case 10: {
                        this.newarray(Type.INT_TYPE);
                        break block0;
                    }
                    case 6: {
                        this.newarray(Type.FLOAT_TYPE);
                        break block0;
                    }
                    case 11: {
                        this.newarray(Type.LONG_TYPE);
                        break block0;
                    }
                    case 7: {
                        this.newarray(Type.DOUBLE_TYPE);
                        break block0;
                    }
                }
                throw new IllegalArgumentException();
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        switch (opcode) {
            case 21: {
                this.load(var, Type.INT_TYPE);
                break;
            }
            case 22: {
                this.load(var, Type.LONG_TYPE);
                break;
            }
            case 23: {
                this.load(var, Type.FLOAT_TYPE);
                break;
            }
            case 24: {
                this.load(var, Type.DOUBLE_TYPE);
                break;
            }
            case 25: {
                this.load(var, OBJECT_TYPE);
                break;
            }
            case 54: {
                this.store(var, Type.INT_TYPE);
                break;
            }
            case 55: {
                this.store(var, Type.LONG_TYPE);
                break;
            }
            case 56: {
                this.store(var, Type.FLOAT_TYPE);
                break;
            }
            case 57: {
                this.store(var, Type.DOUBLE_TYPE);
                break;
            }
            case 58: {
                this.store(var, OBJECT_TYPE);
                break;
            }
            case 169: {
                this.ret(var);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type2) {
        Type t = Type.getObjectType(type2);
        switch (opcode) {
            case 187: {
                this.anew(t);
                break;
            }
            case 189: {
                this.newarray(t);
                break;
            }
            case 192: {
                this.checkcast(t);
                break;
            }
            case 193: {
                this.instanceOf(t);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        switch (opcode) {
            case 178: {
                this.getstatic(owner, name2, desc);
                break;
            }
            case 179: {
                this.putstatic(owner, name2, desc);
                break;
            }
            case 180: {
                this.getfield(owner, name2, desc);
                break;
            }
            case 181: {
                this.putfield(owner, name2, desc);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
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
        switch (opcode) {
            case 183: {
                this.invokespecial(owner, name2, desc, itf);
                break;
            }
            case 182: {
                this.invokevirtual(owner, name2, desc, itf);
                break;
            }
            case 184: {
                this.invokestatic(owner, name2, desc, itf);
                break;
            }
            case 185: {
                this.invokeinterface(owner, name2, desc);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        this.invokedynamic(name2, desc, bsm, bsmArgs);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        switch (opcode) {
            case 153: {
                this.ifeq(label);
                break;
            }
            case 154: {
                this.ifne(label);
                break;
            }
            case 155: {
                this.iflt(label);
                break;
            }
            case 156: {
                this.ifge(label);
                break;
            }
            case 157: {
                this.ifgt(label);
                break;
            }
            case 158: {
                this.ifle(label);
                break;
            }
            case 159: {
                this.ificmpeq(label);
                break;
            }
            case 160: {
                this.ificmpne(label);
                break;
            }
            case 161: {
                this.ificmplt(label);
                break;
            }
            case 162: {
                this.ificmpge(label);
                break;
            }
            case 163: {
                this.ificmpgt(label);
                break;
            }
            case 164: {
                this.ificmple(label);
                break;
            }
            case 165: {
                this.ifacmpeq(label);
                break;
            }
            case 166: {
                this.ifacmpne(label);
                break;
            }
            case 167: {
                this.goTo(label);
                break;
            }
            case 168: {
                this.jsr(label);
                break;
            }
            case 198: {
                this.ifnull(label);
                break;
            }
            case 199: {
                this.ifnonnull(label);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void visitLabel(Label label) {
        this.mark(label);
    }

    @Override
    public void visitLdcInsn(Object cst) {
        if (cst instanceof Integer) {
            int val = (Integer)cst;
            this.iconst(val);
        } else if (cst instanceof Byte) {
            int val = ((Byte)cst).intValue();
            this.iconst(val);
        } else if (cst instanceof Character) {
            char val = ((Character)cst).charValue();
            this.iconst(val);
        } else if (cst instanceof Short) {
            int val = ((Short)cst).intValue();
            this.iconst(val);
        } else if (cst instanceof Boolean) {
            int val = (Boolean)cst != false ? 1 : 0;
            this.iconst(val);
        } else if (cst instanceof Float) {
            float val = ((Float)cst).floatValue();
            this.fconst(val);
        } else if (cst instanceof Long) {
            long val = (Long)cst;
            this.lconst(val);
        } else if (cst instanceof Double) {
            double val = (Double)cst;
            this.dconst(val);
        } else if (cst instanceof String) {
            this.aconst(cst);
        } else if (cst instanceof Type) {
            this.tconst((Type)cst);
        } else if (cst instanceof Handle) {
            this.hconst((Handle)cst);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        this.iinc(var, increment);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.tableswitch(min, max, dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys2, Label[] labels) {
        this.lookupswitch(dflt, keys2, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.multianewarray(desc, dims);
    }

    public void nop() {
        this.mv.visitInsn(0);
    }

    public void aconst(Object cst) {
        if (cst == null) {
            this.mv.visitInsn(1);
        } else {
            this.mv.visitLdcInsn(cst);
        }
    }

    public void iconst(int cst) {
        if (cst >= -1 && cst <= 5) {
            this.mv.visitInsn(3 + cst);
        } else if (cst >= -128 && cst <= 127) {
            this.mv.visitIntInsn(16, cst);
        } else if (cst >= Short.MIN_VALUE && cst <= Short.MAX_VALUE) {
            this.mv.visitIntInsn(17, cst);
        } else {
            this.mv.visitLdcInsn(cst);
        }
    }

    public void lconst(long cst) {
        if (cst == 0L || cst == 1L) {
            this.mv.visitInsn(9 + (int)cst);
        } else {
            this.mv.visitLdcInsn(cst);
        }
    }

    public void fconst(float cst) {
        int bits = Float.floatToIntBits(cst);
        if ((long)bits == 0L || bits == 1065353216 || bits == 0x40000000) {
            this.mv.visitInsn(11 + (int)cst);
        } else {
            this.mv.visitLdcInsn(Float.valueOf(cst));
        }
    }

    public void dconst(double cst) {
        long bits = Double.doubleToLongBits(cst);
        if (bits == 0L || bits == 0x3FF0000000000000L) {
            this.mv.visitInsn(14 + (int)cst);
        } else {
            this.mv.visitLdcInsn(cst);
        }
    }

    public void tconst(Type type2) {
        this.mv.visitLdcInsn(type2);
    }

    public void hconst(Handle handle) {
        this.mv.visitLdcInsn(handle);
    }

    public void load(int var, Type type2) {
        this.mv.visitVarInsn(type2.getOpcode(21), var);
    }

    public void aload(Type type2) {
        this.mv.visitInsn(type2.getOpcode(46));
    }

    public void store(int var, Type type2) {
        this.mv.visitVarInsn(type2.getOpcode(54), var);
    }

    public void astore(Type type2) {
        this.mv.visitInsn(type2.getOpcode(79));
    }

    public void pop() {
        this.mv.visitInsn(87);
    }

    public void pop2() {
        this.mv.visitInsn(88);
    }

    public void dup() {
        this.mv.visitInsn(89);
    }

    public void dup2() {
        this.mv.visitInsn(92);
    }

    public void dupX1() {
        this.mv.visitInsn(90);
    }

    public void dupX2() {
        this.mv.visitInsn(91);
    }

    public void dup2X1() {
        this.mv.visitInsn(93);
    }

    public void dup2X2() {
        this.mv.visitInsn(94);
    }

    public void swap() {
        this.mv.visitInsn(95);
    }

    public void add(Type type2) {
        this.mv.visitInsn(type2.getOpcode(96));
    }

    public void sub(Type type2) {
        this.mv.visitInsn(type2.getOpcode(100));
    }

    public void mul(Type type2) {
        this.mv.visitInsn(type2.getOpcode(104));
    }

    public void div(Type type2) {
        this.mv.visitInsn(type2.getOpcode(108));
    }

    public void rem(Type type2) {
        this.mv.visitInsn(type2.getOpcode(112));
    }

    public void neg(Type type2) {
        this.mv.visitInsn(type2.getOpcode(116));
    }

    public void shl(Type type2) {
        this.mv.visitInsn(type2.getOpcode(120));
    }

    public void shr(Type type2) {
        this.mv.visitInsn(type2.getOpcode(122));
    }

    public void ushr(Type type2) {
        this.mv.visitInsn(type2.getOpcode(124));
    }

    public void and(Type type2) {
        this.mv.visitInsn(type2.getOpcode(126));
    }

    public void or(Type type2) {
        this.mv.visitInsn(type2.getOpcode(128));
    }

    public void xor(Type type2) {
        this.mv.visitInsn(type2.getOpcode(130));
    }

    public void iinc(int var, int increment) {
        this.mv.visitIincInsn(var, increment);
    }

    public void cast(Type from, Type to) {
        if (from != to) {
            if (from == Type.DOUBLE_TYPE) {
                if (to == Type.FLOAT_TYPE) {
                    this.mv.visitInsn(144);
                } else if (to == Type.LONG_TYPE) {
                    this.mv.visitInsn(143);
                } else {
                    this.mv.visitInsn(142);
                    this.cast(Type.INT_TYPE, to);
                }
            } else if (from == Type.FLOAT_TYPE) {
                if (to == Type.DOUBLE_TYPE) {
                    this.mv.visitInsn(141);
                } else if (to == Type.LONG_TYPE) {
                    this.mv.visitInsn(140);
                } else {
                    this.mv.visitInsn(139);
                    this.cast(Type.INT_TYPE, to);
                }
            } else if (from == Type.LONG_TYPE) {
                if (to == Type.DOUBLE_TYPE) {
                    this.mv.visitInsn(138);
                } else if (to == Type.FLOAT_TYPE) {
                    this.mv.visitInsn(137);
                } else {
                    this.mv.visitInsn(136);
                    this.cast(Type.INT_TYPE, to);
                }
            } else if (to == Type.BYTE_TYPE) {
                this.mv.visitInsn(145);
            } else if (to == Type.CHAR_TYPE) {
                this.mv.visitInsn(146);
            } else if (to == Type.DOUBLE_TYPE) {
                this.mv.visitInsn(135);
            } else if (to == Type.FLOAT_TYPE) {
                this.mv.visitInsn(134);
            } else if (to == Type.LONG_TYPE) {
                this.mv.visitInsn(133);
            } else if (to == Type.SHORT_TYPE) {
                this.mv.visitInsn(147);
            }
        }
    }

    public void lcmp() {
        this.mv.visitInsn(148);
    }

    public void cmpl(Type type2) {
        this.mv.visitInsn(type2 == Type.FLOAT_TYPE ? 149 : 151);
    }

    public void cmpg(Type type2) {
        this.mv.visitInsn(type2 == Type.FLOAT_TYPE ? 150 : 152);
    }

    public void ifeq(Label label) {
        this.mv.visitJumpInsn(153, label);
    }

    public void ifne(Label label) {
        this.mv.visitJumpInsn(154, label);
    }

    public void iflt(Label label) {
        this.mv.visitJumpInsn(155, label);
    }

    public void ifge(Label label) {
        this.mv.visitJumpInsn(156, label);
    }

    public void ifgt(Label label) {
        this.mv.visitJumpInsn(157, label);
    }

    public void ifle(Label label) {
        this.mv.visitJumpInsn(158, label);
    }

    public void ificmpeq(Label label) {
        this.mv.visitJumpInsn(159, label);
    }

    public void ificmpne(Label label) {
        this.mv.visitJumpInsn(160, label);
    }

    public void ificmplt(Label label) {
        this.mv.visitJumpInsn(161, label);
    }

    public void ificmpge(Label label) {
        this.mv.visitJumpInsn(162, label);
    }

    public void ificmpgt(Label label) {
        this.mv.visitJumpInsn(163, label);
    }

    public void ificmple(Label label) {
        this.mv.visitJumpInsn(164, label);
    }

    public void ifacmpeq(Label label) {
        this.mv.visitJumpInsn(165, label);
    }

    public void ifacmpne(Label label) {
        this.mv.visitJumpInsn(166, label);
    }

    public void goTo(Label label) {
        this.mv.visitJumpInsn(167, label);
    }

    public void jsr(Label label) {
        this.mv.visitJumpInsn(168, label);
    }

    public void ret(int var) {
        this.mv.visitVarInsn(169, var);
    }

    public void tableswitch(int min, int max, Label dflt, Label ... labels) {
        this.mv.visitTableSwitchInsn(min, max, dflt, labels);
    }

    public void lookupswitch(Label dflt, int[] keys2, Label[] labels) {
        this.mv.visitLookupSwitchInsn(dflt, keys2, labels);
    }

    public void areturn(Type t) {
        this.mv.visitInsn(t.getOpcode(172));
    }

    public void getstatic(String owner, String name2, String desc) {
        this.mv.visitFieldInsn(178, owner, name2, desc);
    }

    public void putstatic(String owner, String name2, String desc) {
        this.mv.visitFieldInsn(179, owner, name2, desc);
    }

    public void getfield(String owner, String name2, String desc) {
        this.mv.visitFieldInsn(180, owner, name2, desc);
    }

    public void putfield(String owner, String name2, String desc) {
        this.mv.visitFieldInsn(181, owner, name2, desc);
    }

    @Deprecated
    public void invokevirtual(String owner, String name2, String desc) {
        if (this.api >= 327680) {
            this.invokevirtual(owner, name2, desc, false);
            return;
        }
        this.mv.visitMethodInsn(182, owner, name2, desc);
    }

    public void invokevirtual(String owner, String name2, String desc, boolean itf) {
        if (this.api < 327680) {
            if (itf) {
                throw new IllegalArgumentException("INVOKEVIRTUAL on interfaces require ASM 5");
            }
            this.invokevirtual(owner, name2, desc);
            return;
        }
        this.mv.visitMethodInsn(182, owner, name2, desc, itf);
    }

    @Deprecated
    public void invokespecial(String owner, String name2, String desc) {
        if (this.api >= 327680) {
            this.invokespecial(owner, name2, desc, false);
            return;
        }
        this.mv.visitMethodInsn(183, owner, name2, desc, false);
    }

    public void invokespecial(String owner, String name2, String desc, boolean itf) {
        if (this.api < 327680) {
            if (itf) {
                throw new IllegalArgumentException("INVOKESPECIAL on interfaces require ASM 5");
            }
            this.invokespecial(owner, name2, desc);
            return;
        }
        this.mv.visitMethodInsn(183, owner, name2, desc, itf);
    }

    @Deprecated
    public void invokestatic(String owner, String name2, String desc) {
        if (this.api >= 327680) {
            this.invokestatic(owner, name2, desc, false);
            return;
        }
        this.mv.visitMethodInsn(184, owner, name2, desc, false);
    }

    public void invokestatic(String owner, String name2, String desc, boolean itf) {
        if (this.api < 327680) {
            if (itf) {
                throw new IllegalArgumentException("INVOKESTATIC on interfaces require ASM 5");
            }
            this.invokestatic(owner, name2, desc);
            return;
        }
        this.mv.visitMethodInsn(184, owner, name2, desc, itf);
    }

    public void invokeinterface(String owner, String name2, String desc) {
        this.mv.visitMethodInsn(185, owner, name2, desc, true);
    }

    public void invokedynamic(String name2, String desc, Handle bsm, Object[] bsmArgs) {
        this.mv.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
    }

    public void anew(Type type2) {
        this.mv.visitTypeInsn(187, type2.getInternalName());
    }

    public void newarray(Type type2) {
        int typ;
        switch (type2.getSort()) {
            case 1: {
                typ = 4;
                break;
            }
            case 2: {
                typ = 5;
                break;
            }
            case 3: {
                typ = 8;
                break;
            }
            case 4: {
                typ = 9;
                break;
            }
            case 5: {
                typ = 10;
                break;
            }
            case 6: {
                typ = 6;
                break;
            }
            case 7: {
                typ = 11;
                break;
            }
            case 8: {
                typ = 7;
                break;
            }
            default: {
                this.mv.visitTypeInsn(189, type2.getInternalName());
                return;
            }
        }
        this.mv.visitIntInsn(188, typ);
    }

    public void arraylength() {
        this.mv.visitInsn(190);
    }

    public void athrow() {
        this.mv.visitInsn(191);
    }

    public void checkcast(Type type2) {
        this.mv.visitTypeInsn(192, type2.getInternalName());
    }

    public void instanceOf(Type type2) {
        this.mv.visitTypeInsn(193, type2.getInternalName());
    }

    public void monitorenter() {
        this.mv.visitInsn(194);
    }

    public void monitorexit() {
        this.mv.visitInsn(195);
    }

    public void multianewarray(String desc, int dims) {
        this.mv.visitMultiANewArrayInsn(desc, dims);
    }

    public void ifnull(Label label) {
        this.mv.visitJumpInsn(198, label);
    }

    public void ifnonnull(Label label) {
        this.mv.visitJumpInsn(199, label);
    }

    public void mark(Label label) {
        this.mv.visitLabel(label);
    }
}

