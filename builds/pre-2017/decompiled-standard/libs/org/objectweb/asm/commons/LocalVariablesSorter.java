/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

public class LocalVariablesSorter
extends MethodVisitor {
    private static final Type OBJECT_TYPE = Type.getObjectType("java/lang/Object");
    private int[] mapping = new int[40];
    private Object[] newLocals = new Object[20];
    protected final int firstLocal;
    protected int nextLocal;

    public LocalVariablesSorter(int access, String desc, MethodVisitor mv) {
        this(393216, access, desc, mv);
        if (this.getClass() != LocalVariablesSorter.class) {
            throw new IllegalStateException();
        }
    }

    protected LocalVariablesSorter(int api, int access, String desc, MethodVisitor mv) {
        super(api, mv);
        Type[] args = Type.getArgumentTypes(desc);
        this.nextLocal = (8 & access) == 0 ? 1 : 0;
        for (int i = 0; i < args.length; ++i) {
            this.nextLocal += args[i].getSize();
        }
        this.firstLocal = this.nextLocal;
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        Type type2;
        switch (opcode) {
            case 22: 
            case 55: {
                type2 = Type.LONG_TYPE;
                break;
            }
            case 24: 
            case 57: {
                type2 = Type.DOUBLE_TYPE;
                break;
            }
            case 23: 
            case 56: {
                type2 = Type.FLOAT_TYPE;
                break;
            }
            case 21: 
            case 54: {
                type2 = Type.INT_TYPE;
                break;
            }
            default: {
                type2 = OBJECT_TYPE;
            }
        }
        this.mv.visitVarInsn(opcode, this.remap(var, type2));
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        this.mv.visitIincInsn(this.remap(var, Type.INT_TYPE), increment);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        this.mv.visitMaxs(maxStack, this.nextLocal);
    }

    @Override
    public void visitLocalVariable(String name2, String desc, String signature2, Label start, Label end, int index) {
        int newIndex = this.remap(index, Type.getType(desc));
        this.mv.visitLocalVariable(name2, desc, signature2, start, end, newIndex);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        Type t = Type.getType(desc);
        int[] newIndex = new int[index.length];
        for (int i = 0; i < newIndex.length; ++i) {
            newIndex[i] = this.remap(index[i], t);
        }
        return this.mv.visitLocalVariableAnnotation(typeRef, typePath, start, end, newIndex, desc, visible);
    }

    @Override
    public void visitFrame(int type2, int nLocal, Object[] local, int nStack, Object[] stack) {
        int number;
        if (type2 != -1) {
            throw new IllegalStateException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
        }
        Object[] oldLocals = new Object[this.newLocals.length];
        System.arraycopy(this.newLocals, 0, oldLocals, 0, oldLocals.length);
        this.updateNewLocals(this.newLocals);
        int index = 0;
        for (number = 0; number < nLocal; ++number) {
            int size;
            Object t = local[number];
            int n = size = t == Opcodes.LONG || t == Opcodes.DOUBLE ? 2 : 1;
            if (t != Opcodes.TOP) {
                Type typ = OBJECT_TYPE;
                if (t == Opcodes.INTEGER) {
                    typ = Type.INT_TYPE;
                } else if (t == Opcodes.FLOAT) {
                    typ = Type.FLOAT_TYPE;
                } else if (t == Opcodes.LONG) {
                    typ = Type.LONG_TYPE;
                } else if (t == Opcodes.DOUBLE) {
                    typ = Type.DOUBLE_TYPE;
                } else if (t instanceof String) {
                    typ = Type.getObjectType((String)t);
                }
                this.setFrameLocal(this.remap(index, typ), t);
            }
            index += size;
        }
        index = 0;
        number = 0;
        int i = 0;
        while (index < this.newLocals.length) {
            Object t;
            if ((t = this.newLocals[index++]) != null && t != Opcodes.TOP) {
                this.newLocals[i] = t;
                number = i + 1;
                if (t == Opcodes.LONG || t == Opcodes.DOUBLE) {
                    ++index;
                }
            } else {
                this.newLocals[i] = Opcodes.TOP;
            }
            ++i;
        }
        this.mv.visitFrame(type2, number, this.newLocals, nStack, stack);
        this.newLocals = oldLocals;
    }

    public int newLocal(Type type2) {
        Object t;
        switch (type2.getSort()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                t = Opcodes.INTEGER;
                break;
            }
            case 6: {
                t = Opcodes.FLOAT;
                break;
            }
            case 7: {
                t = Opcodes.LONG;
                break;
            }
            case 8: {
                t = Opcodes.DOUBLE;
                break;
            }
            case 9: {
                t = type2.getDescriptor();
                break;
            }
            default: {
                t = type2.getInternalName();
            }
        }
        int local = this.newLocalMapping(type2);
        this.setLocalType(local, type2);
        this.setFrameLocal(local, t);
        return local;
    }

    protected void updateNewLocals(Object[] newLocals) {
    }

    protected void setLocalType(int local, Type type2) {
    }

    private void setFrameLocal(int local, Object type2) {
        int l = this.newLocals.length;
        if (local >= l) {
            Object[] a = new Object[Math.max(2 * l, local + 1)];
            System.arraycopy(this.newLocals, 0, a, 0, l);
            this.newLocals = a;
        }
        this.newLocals[local] = type2;
    }

    private int remap(int var, Type type2) {
        int value;
        int size;
        if (var + type2.getSize() <= this.firstLocal) {
            return var;
        }
        int key = 2 * var + type2.getSize() - 1;
        if (key >= (size = this.mapping.length)) {
            int[] newMapping = new int[Math.max(2 * size, key + 1)];
            System.arraycopy(this.mapping, 0, newMapping, 0, size);
            this.mapping = newMapping;
        }
        if ((value = this.mapping[key]) == 0) {
            value = this.newLocalMapping(type2);
            this.setLocalType(value, type2);
            this.mapping[key] = value + 1;
        } else {
            --value;
        }
        return value;
    }

    protected int newLocalMapping(Type type2) {
        int local = this.nextLocal;
        this.nextLocal += type2.getSize();
        return local;
    }
}

