/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

public abstract class AdviceAdapter
extends GeneratorAdapter
implements Opcodes {
    private static final Object THIS = new Object();
    private static final Object OTHER = new Object();
    protected int methodAccess;
    protected String methodDesc;
    private boolean constructor;
    private boolean superInitialized;
    private List<Object> stackFrame;
    private Map<Label, List<Object>> branches;

    protected AdviceAdapter(int api, MethodVisitor mv, int access, String name2, String desc) {
        super(api, mv, access, name2, desc);
        this.methodAccess = access;
        this.methodDesc = desc;
        this.constructor = "<init>".equals(name2);
    }

    @Override
    public void visitCode() {
        this.mv.visitCode();
        if (this.constructor) {
            this.stackFrame = new ArrayList<Object>();
            this.branches = new HashMap<Label, List<Object>>();
        } else {
            this.superInitialized = true;
            this.onMethodEnter();
        }
    }

    @Override
    public void visitLabel(Label label) {
        List<Object> frame;
        this.mv.visitLabel(label);
        if (this.constructor && this.branches != null && (frame = this.branches.get(label)) != null) {
            this.stackFrame = frame;
            this.branches.remove(label);
        }
    }

    @Override
    public void visitInsn(int opcode) {
        if (this.constructor) {
            switch (opcode) {
                case 177: {
                    this.onMethodExit(opcode);
                    break;
                }
                case 172: 
                case 174: 
                case 176: 
                case 191: {
                    this.popValue();
                    this.onMethodExit(opcode);
                    break;
                }
                case 173: 
                case 175: {
                    this.popValue();
                    this.popValue();
                    this.onMethodExit(opcode);
                    break;
                }
                case 0: 
                case 47: 
                case 49: 
                case 116: 
                case 117: 
                case 118: 
                case 119: 
                case 134: 
                case 138: 
                case 139: 
                case 143: 
                case 145: 
                case 146: 
                case 147: 
                case 190: {
                    break;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 11: 
                case 12: 
                case 13: 
                case 133: 
                case 135: 
                case 140: 
                case 141: {
                    this.pushValue(OTHER);
                    break;
                }
                case 9: 
                case 10: 
                case 14: 
                case 15: {
                    this.pushValue(OTHER);
                    this.pushValue(OTHER);
                    break;
                }
                case 46: 
                case 48: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 87: 
                case 96: 
                case 98: 
                case 100: 
                case 102: 
                case 104: 
                case 106: 
                case 108: 
                case 110: 
                case 112: 
                case 114: 
                case 120: 
                case 121: 
                case 122: 
                case 123: 
                case 124: 
                case 125: 
                case 126: 
                case 128: 
                case 130: 
                case 136: 
                case 137: 
                case 142: 
                case 144: 
                case 149: 
                case 150: 
                case 194: 
                case 195: {
                    this.popValue();
                    break;
                }
                case 88: 
                case 97: 
                case 99: 
                case 101: 
                case 103: 
                case 105: 
                case 107: 
                case 109: 
                case 111: 
                case 113: 
                case 115: 
                case 127: 
                case 129: 
                case 131: {
                    this.popValue();
                    this.popValue();
                    break;
                }
                case 79: 
                case 81: 
                case 83: 
                case 84: 
                case 85: 
                case 86: 
                case 148: 
                case 151: 
                case 152: {
                    this.popValue();
                    this.popValue();
                    this.popValue();
                    break;
                }
                case 80: 
                case 82: {
                    this.popValue();
                    this.popValue();
                    this.popValue();
                    this.popValue();
                    break;
                }
                case 89: {
                    this.pushValue(this.peekValue());
                    break;
                }
                case 90: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 2, this.stackFrame.get(s - 1));
                    break;
                }
                case 91: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 3, this.stackFrame.get(s - 1));
                    break;
                }
                case 92: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 2, this.stackFrame.get(s - 1));
                    this.stackFrame.add(s - 2, this.stackFrame.get(s - 1));
                    break;
                }
                case 93: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 3, this.stackFrame.get(s - 1));
                    this.stackFrame.add(s - 3, this.stackFrame.get(s - 1));
                    break;
                }
                case 94: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 4, this.stackFrame.get(s - 1));
                    this.stackFrame.add(s - 4, this.stackFrame.get(s - 1));
                    break;
                }
                case 95: {
                    int s = this.stackFrame.size();
                    this.stackFrame.add(s - 2, this.stackFrame.get(s - 1));
                    this.stackFrame.remove(s);
                }
            }
        } else {
            switch (opcode) {
                case 172: 
                case 173: 
                case 174: 
                case 175: 
                case 176: 
                case 177: 
                case 191: {
                    this.onMethodExit(opcode);
                }
            }
        }
        this.mv.visitInsn(opcode);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);
        if (this.constructor) {
            switch (opcode) {
                case 21: 
                case 23: {
                    this.pushValue(OTHER);
                    break;
                }
                case 22: 
                case 24: {
                    this.pushValue(OTHER);
                    this.pushValue(OTHER);
                    break;
                }
                case 25: {
                    this.pushValue(var == 0 ? THIS : OTHER);
                    break;
                }
                case 54: 
                case 56: 
                case 58: {
                    this.popValue();
                    break;
                }
                case 55: 
                case 57: {
                    this.popValue();
                    this.popValue();
                }
            }
        }
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        this.mv.visitFieldInsn(opcode, owner, name2, desc);
        if (this.constructor) {
            char c = desc.charAt(0);
            boolean longOrDouble = c == 'J' || c == 'D';
            switch (opcode) {
                case 178: {
                    this.pushValue(OTHER);
                    if (!longOrDouble) break;
                    this.pushValue(OTHER);
                    break;
                }
                case 179: {
                    this.popValue();
                    if (!longOrDouble) break;
                    this.popValue();
                    break;
                }
                case 181: {
                    this.popValue();
                    this.popValue();
                    if (!longOrDouble) break;
                    this.popValue();
                    break;
                }
                default: {
                    if (!longOrDouble) break;
                    this.pushValue(OTHER);
                }
            }
        }
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        this.mv.visitIntInsn(opcode, operand);
        if (this.constructor && opcode != 188) {
            this.pushValue(OTHER);
        }
    }

    @Override
    public void visitLdcInsn(Object cst) {
        this.mv.visitLdcInsn(cst);
        if (this.constructor) {
            this.pushValue(OTHER);
            if (cst instanceof Double || cst instanceof Long) {
                this.pushValue(OTHER);
            }
        }
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.mv.visitMultiANewArrayInsn(desc, dims);
        if (this.constructor) {
            for (int i = 0; i < dims; ++i) {
                this.popValue();
            }
            this.pushValue(OTHER);
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type2) {
        this.mv.visitTypeInsn(opcode, type2);
        if (this.constructor && opcode == 187) {
            this.pushValue(OTHER);
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
        this.mv.visitMethodInsn(opcode, owner, name2, desc, itf);
        if (this.constructor) {
            Type[] types = Type.getArgumentTypes(desc);
            for (int i = 0; i < types.length; ++i) {
                this.popValue();
                if (types[i].getSize() != 2) continue;
                this.popValue();
            }
            switch (opcode) {
                case 182: 
                case 185: {
                    this.popValue();
                    break;
                }
                case 183: {
                    Object type2 = this.popValue();
                    if (type2 != THIS || this.superInitialized) break;
                    this.onMethodEnter();
                    this.superInitialized = true;
                    this.constructor = false;
                }
            }
            Type returnType = Type.getReturnType(desc);
            if (returnType != Type.VOID_TYPE) {
                this.pushValue(OTHER);
                if (returnType.getSize() == 2) {
                    this.pushValue(OTHER);
                }
            }
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        this.mv.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
        if (this.constructor) {
            Type[] types = Type.getArgumentTypes(desc);
            for (int i = 0; i < types.length; ++i) {
                this.popValue();
                if (types[i].getSize() != 2) continue;
                this.popValue();
            }
            Type returnType = Type.getReturnType(desc);
            if (returnType != Type.VOID_TYPE) {
                this.pushValue(OTHER);
                if (returnType.getSize() == 2) {
                    this.pushValue(OTHER);
                }
            }
        }
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        this.mv.visitJumpInsn(opcode, label);
        if (this.constructor) {
            switch (opcode) {
                case 153: 
                case 154: 
                case 155: 
                case 156: 
                case 157: 
                case 158: 
                case 198: 
                case 199: {
                    this.popValue();
                    break;
                }
                case 159: 
                case 160: 
                case 161: 
                case 162: 
                case 163: 
                case 164: 
                case 165: 
                case 166: {
                    this.popValue();
                    this.popValue();
                    break;
                }
                case 168: {
                    this.pushValue(OTHER);
                }
            }
            this.addBranch(label);
        }
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys2, Label[] labels) {
        this.mv.visitLookupSwitchInsn(dflt, keys2, labels);
        if (this.constructor) {
            this.popValue();
            this.addBranches(dflt, labels);
        }
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        this.mv.visitTableSwitchInsn(min, max, dflt, labels);
        if (this.constructor) {
            this.popValue();
            this.addBranches(dflt, labels);
        }
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type2) {
        super.visitTryCatchBlock(start, end, handler, type2);
        if (this.constructor && !this.branches.containsKey(handler)) {
            ArrayList<Object> stackFrame = new ArrayList<Object>();
            stackFrame.add(OTHER);
            this.branches.put(handler, stackFrame);
        }
    }

    private void addBranches(Label dflt, Label[] labels) {
        this.addBranch(dflt);
        for (int i = 0; i < labels.length; ++i) {
            this.addBranch(labels[i]);
        }
    }

    private void addBranch(Label label) {
        if (this.branches.containsKey(label)) {
            return;
        }
        this.branches.put(label, new ArrayList<Object>(this.stackFrame));
    }

    private Object popValue() {
        return this.stackFrame.remove(this.stackFrame.size() - 1);
    }

    private Object peekValue() {
        return this.stackFrame.get(this.stackFrame.size() - 1);
    }

    private void pushValue(Object o) {
        this.stackFrame.add(o);
    }

    protected void onMethodEnter() {
    }

    protected void onMethodExit(int opcode) {
    }
}

