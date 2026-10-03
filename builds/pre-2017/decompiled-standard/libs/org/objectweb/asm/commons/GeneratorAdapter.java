/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public class GeneratorAdapter
extends LocalVariablesSorter {
    private static final String CLDESC = "Ljava/lang/Class;";
    private static final Type BYTE_TYPE = Type.getObjectType("java/lang/Byte");
    private static final Type BOOLEAN_TYPE = Type.getObjectType("java/lang/Boolean");
    private static final Type SHORT_TYPE = Type.getObjectType("java/lang/Short");
    private static final Type CHARACTER_TYPE = Type.getObjectType("java/lang/Character");
    private static final Type INTEGER_TYPE = Type.getObjectType("java/lang/Integer");
    private static final Type FLOAT_TYPE = Type.getObjectType("java/lang/Float");
    private static final Type LONG_TYPE = Type.getObjectType("java/lang/Long");
    private static final Type DOUBLE_TYPE = Type.getObjectType("java/lang/Double");
    private static final Type NUMBER_TYPE = Type.getObjectType("java/lang/Number");
    private static final Type OBJECT_TYPE = Type.getObjectType("java/lang/Object");
    private static final Method BOOLEAN_VALUE = Method.getMethod("boolean booleanValue()");
    private static final Method CHAR_VALUE = Method.getMethod("char charValue()");
    private static final Method INT_VALUE = Method.getMethod("int intValue()");
    private static final Method FLOAT_VALUE = Method.getMethod("float floatValue()");
    private static final Method LONG_VALUE = Method.getMethod("long longValue()");
    private static final Method DOUBLE_VALUE = Method.getMethod("double doubleValue()");
    public static final int ADD = 96;
    public static final int SUB = 100;
    public static final int MUL = 104;
    public static final int DIV = 108;
    public static final int REM = 112;
    public static final int NEG = 116;
    public static final int SHL = 120;
    public static final int SHR = 122;
    public static final int USHR = 124;
    public static final int AND = 126;
    public static final int OR = 128;
    public static final int XOR = 130;
    public static final int EQ = 153;
    public static final int NE = 154;
    public static final int LT = 155;
    public static final int GE = 156;
    public static final int GT = 157;
    public static final int LE = 158;
    private final int access;
    private final Type returnType;
    private final Type[] argumentTypes;
    private final List<Type> localTypes = new ArrayList<Type>();

    public GeneratorAdapter(MethodVisitor mv, int access, String name2, String desc) {
        this(393216, mv, access, name2, desc);
        if (this.getClass() != GeneratorAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected GeneratorAdapter(int api, MethodVisitor mv, int access, String name2, String desc) {
        super(api, access, desc, mv);
        this.access = access;
        this.returnType = Type.getReturnType(desc);
        this.argumentTypes = Type.getArgumentTypes(desc);
    }

    public GeneratorAdapter(int access, Method method, MethodVisitor mv) {
        this(mv, access, null, method.getDescriptor());
    }

    public GeneratorAdapter(int access, Method method, String signature2, Type[] exceptions, ClassVisitor cv) {
        this(access, method, cv.visitMethod(access, method.getName(), method.getDescriptor(), signature2, GeneratorAdapter.getInternalNames(exceptions)));
    }

    private static String[] getInternalNames(Type[] types) {
        if (types == null) {
            return null;
        }
        String[] names = new String[types.length];
        for (int i = 0; i < names.length; ++i) {
            names[i] = types[i].getInternalName();
        }
        return names;
    }

    public void push(boolean value) {
        this.push(value ? 1 : 0);
    }

    public void push(int value) {
        if (value >= -1 && value <= 5) {
            this.mv.visitInsn(3 + value);
        } else if (value >= -128 && value <= 127) {
            this.mv.visitIntInsn(16, value);
        } else if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
            this.mv.visitIntInsn(17, value);
        } else {
            this.mv.visitLdcInsn(value);
        }
    }

    public void push(long value) {
        if (value == 0L || value == 1L) {
            this.mv.visitInsn(9 + (int)value);
        } else {
            this.mv.visitLdcInsn(value);
        }
    }

    public void push(float value) {
        int bits = Float.floatToIntBits(value);
        if ((long)bits == 0L || bits == 1065353216 || bits == 0x40000000) {
            this.mv.visitInsn(11 + (int)value);
        } else {
            this.mv.visitLdcInsn(Float.valueOf(value));
        }
    }

    public void push(double value) {
        long bits = Double.doubleToLongBits(value);
        if (bits == 0L || bits == 0x3FF0000000000000L) {
            this.mv.visitInsn(14 + (int)value);
        } else {
            this.mv.visitLdcInsn(value);
        }
    }

    public void push(String value) {
        if (value == null) {
            this.mv.visitInsn(1);
        } else {
            this.mv.visitLdcInsn(value);
        }
    }

    public void push(Type value) {
        if (value == null) {
            this.mv.visitInsn(1);
        } else {
            switch (value.getSort()) {
                case 1: {
                    this.mv.visitFieldInsn(178, "java/lang/Boolean", "TYPE", CLDESC);
                    break;
                }
                case 2: {
                    this.mv.visitFieldInsn(178, "java/lang/Character", "TYPE", CLDESC);
                    break;
                }
                case 3: {
                    this.mv.visitFieldInsn(178, "java/lang/Byte", "TYPE", CLDESC);
                    break;
                }
                case 4: {
                    this.mv.visitFieldInsn(178, "java/lang/Short", "TYPE", CLDESC);
                    break;
                }
                case 5: {
                    this.mv.visitFieldInsn(178, "java/lang/Integer", "TYPE", CLDESC);
                    break;
                }
                case 6: {
                    this.mv.visitFieldInsn(178, "java/lang/Float", "TYPE", CLDESC);
                    break;
                }
                case 7: {
                    this.mv.visitFieldInsn(178, "java/lang/Long", "TYPE", CLDESC);
                    break;
                }
                case 8: {
                    this.mv.visitFieldInsn(178, "java/lang/Double", "TYPE", CLDESC);
                    break;
                }
                default: {
                    this.mv.visitLdcInsn(value);
                }
            }
        }
    }

    public void push(Handle handle) {
        this.mv.visitLdcInsn(handle);
    }

    private int getArgIndex(int arg) {
        int index = (this.access & 8) == 0 ? 1 : 0;
        for (int i = 0; i < arg; ++i) {
            index += this.argumentTypes[i].getSize();
        }
        return index;
    }

    private void loadInsn(Type type2, int index) {
        this.mv.visitVarInsn(type2.getOpcode(21), index);
    }

    private void storeInsn(Type type2, int index) {
        this.mv.visitVarInsn(type2.getOpcode(54), index);
    }

    public void loadThis() {
        if ((this.access & 8) != 0) {
            throw new IllegalStateException("no 'this' pointer within static method");
        }
        this.mv.visitVarInsn(25, 0);
    }

    public void loadArg(int arg) {
        this.loadInsn(this.argumentTypes[arg], this.getArgIndex(arg));
    }

    public void loadArgs(int arg, int count) {
        int index = this.getArgIndex(arg);
        for (int i = 0; i < count; ++i) {
            Type t = this.argumentTypes[arg + i];
            this.loadInsn(t, index);
            index += t.getSize();
        }
    }

    public void loadArgs() {
        this.loadArgs(0, this.argumentTypes.length);
    }

    public void loadArgArray() {
        this.push(this.argumentTypes.length);
        this.newArray(OBJECT_TYPE);
        for (int i = 0; i < this.argumentTypes.length; ++i) {
            this.dup();
            this.push(i);
            this.loadArg(i);
            this.box(this.argumentTypes[i]);
            this.arrayStore(OBJECT_TYPE);
        }
    }

    public void storeArg(int arg) {
        this.storeInsn(this.argumentTypes[arg], this.getArgIndex(arg));
    }

    public Type getLocalType(int local) {
        return this.localTypes.get(local - this.firstLocal);
    }

    @Override
    protected void setLocalType(int local, Type type2) {
        int index = local - this.firstLocal;
        while (this.localTypes.size() < index + 1) {
            this.localTypes.add(null);
        }
        this.localTypes.set(index, type2);
    }

    public void loadLocal(int local) {
        this.loadInsn(this.getLocalType(local), local);
    }

    public void loadLocal(int local, Type type2) {
        this.setLocalType(local, type2);
        this.loadInsn(type2, local);
    }

    public void storeLocal(int local) {
        this.storeInsn(this.getLocalType(local), local);
    }

    public void storeLocal(int local, Type type2) {
        this.setLocalType(local, type2);
        this.storeInsn(type2, local);
    }

    public void arrayLoad(Type type2) {
        this.mv.visitInsn(type2.getOpcode(46));
    }

    public void arrayStore(Type type2) {
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

    public void swap(Type prev, Type type2) {
        if (type2.getSize() == 1) {
            if (prev.getSize() == 1) {
                this.swap();
            } else {
                this.dupX2();
                this.pop();
            }
        } else if (prev.getSize() == 1) {
            this.dup2X1();
            this.pop2();
        } else {
            this.dup2X2();
            this.pop2();
        }
    }

    public void math(int op, Type type2) {
        this.mv.visitInsn(type2.getOpcode(op));
    }

    public void not() {
        this.mv.visitInsn(4);
        this.mv.visitInsn(130);
    }

    public void iinc(int local, int amount) {
        this.mv.visitIincInsn(local, amount);
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

    private static Type getBoxedType(Type type2) {
        switch (type2.getSort()) {
            case 3: {
                return BYTE_TYPE;
            }
            case 1: {
                return BOOLEAN_TYPE;
            }
            case 4: {
                return SHORT_TYPE;
            }
            case 2: {
                return CHARACTER_TYPE;
            }
            case 5: {
                return INTEGER_TYPE;
            }
            case 6: {
                return FLOAT_TYPE;
            }
            case 7: {
                return LONG_TYPE;
            }
            case 8: {
                return DOUBLE_TYPE;
            }
        }
        return type2;
    }

    public void box(Type type2) {
        if (type2.getSort() == 10 || type2.getSort() == 9) {
            return;
        }
        if (type2 == Type.VOID_TYPE) {
            this.push((String)null);
        } else {
            Type boxed = GeneratorAdapter.getBoxedType(type2);
            this.newInstance(boxed);
            if (type2.getSize() == 2) {
                this.dupX2();
                this.dupX2();
                this.pop();
            } else {
                this.dupX1();
                this.swap();
            }
            this.invokeConstructor(boxed, new Method("<init>", Type.VOID_TYPE, new Type[]{type2}));
        }
    }

    public void valueOf(Type type2) {
        if (type2.getSort() == 10 || type2.getSort() == 9) {
            return;
        }
        if (type2 == Type.VOID_TYPE) {
            this.push((String)null);
        } else {
            Type boxed = GeneratorAdapter.getBoxedType(type2);
            this.invokeStatic(boxed, new Method("valueOf", boxed, new Type[]{type2}));
        }
    }

    public void unbox(Type type2) {
        Type t = NUMBER_TYPE;
        Method sig = null;
        switch (type2.getSort()) {
            case 0: {
                return;
            }
            case 2: {
                t = CHARACTER_TYPE;
                sig = CHAR_VALUE;
                break;
            }
            case 1: {
                t = BOOLEAN_TYPE;
                sig = BOOLEAN_VALUE;
                break;
            }
            case 8: {
                sig = DOUBLE_VALUE;
                break;
            }
            case 6: {
                sig = FLOAT_VALUE;
                break;
            }
            case 7: {
                sig = LONG_VALUE;
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                sig = INT_VALUE;
            }
        }
        if (sig == null) {
            this.checkCast(type2);
        } else {
            this.checkCast(t);
            this.invokeVirtual(t, sig);
        }
    }

    public Label newLabel() {
        return new Label();
    }

    public void mark(Label label) {
        this.mv.visitLabel(label);
    }

    public Label mark() {
        Label label = new Label();
        this.mv.visitLabel(label);
        return label;
    }

    public void ifCmp(Type type2, int mode, Label label) {
        switch (type2.getSort()) {
            case 7: {
                this.mv.visitInsn(148);
                break;
            }
            case 8: {
                this.mv.visitInsn(mode == 156 || mode == 157 ? 151 : 152);
                break;
            }
            case 6: {
                this.mv.visitInsn(mode == 156 || mode == 157 ? 149 : 150);
                break;
            }
            case 9: 
            case 10: {
                switch (mode) {
                    case 153: {
                        this.mv.visitJumpInsn(165, label);
                        return;
                    }
                    case 154: {
                        this.mv.visitJumpInsn(166, label);
                        return;
                    }
                }
                throw new IllegalArgumentException("Bad comparison for type " + type2);
            }
            default: {
                int intOp = -1;
                switch (mode) {
                    case 153: {
                        intOp = 159;
                        break;
                    }
                    case 154: {
                        intOp = 160;
                        break;
                    }
                    case 156: {
                        intOp = 162;
                        break;
                    }
                    case 155: {
                        intOp = 161;
                        break;
                    }
                    case 158: {
                        intOp = 164;
                        break;
                    }
                    case 157: {
                        intOp = 163;
                    }
                }
                this.mv.visitJumpInsn(intOp, label);
                return;
            }
        }
        this.mv.visitJumpInsn(mode, label);
    }

    public void ifICmp(int mode, Label label) {
        this.ifCmp(Type.INT_TYPE, mode, label);
    }

    public void ifZCmp(int mode, Label label) {
        this.mv.visitJumpInsn(mode, label);
    }

    public void ifNull(Label label) {
        this.mv.visitJumpInsn(198, label);
    }

    public void ifNonNull(Label label) {
        this.mv.visitJumpInsn(199, label);
    }

    public void goTo(Label label) {
        this.mv.visitJumpInsn(167, label);
    }

    public void ret(int local) {
        this.mv.visitVarInsn(169, local);
    }

    public void tableSwitch(int[] keys2, TableSwitchGenerator generator) {
        float density = keys2.length == 0 ? 0.0f : (float)keys2.length / (float)(keys2[keys2.length - 1] - keys2[0] + 1);
        this.tableSwitch(keys2, generator, density >= 0.5f);
    }

    public void tableSwitch(int[] keys2, TableSwitchGenerator generator, boolean useTable) {
        for (int i = 1; i < keys2.length; ++i) {
            if (keys2[i] >= keys2[i - 1]) continue;
            throw new IllegalArgumentException("keys must be sorted ascending");
        }
        Label def = this.newLabel();
        Label end = this.newLabel();
        if (keys2.length > 0) {
            int len = keys2.length;
            int min = keys2[0];
            int max = keys2[len - 1];
            int range = max - min + 1;
            if (useTable) {
                int i;
                Object[] labels = new Label[range];
                Arrays.fill(labels, def);
                for (i = 0; i < len; ++i) {
                    labels[keys2[i] - min] = this.newLabel();
                }
                this.mv.visitTableSwitchInsn(min, max, def, (Label[])labels);
                for (i = 0; i < range; ++i) {
                    Object label = labels[i];
                    if (label == def) continue;
                    this.mark((Label)label);
                    generator.generateCase(i + min, end);
                }
            } else {
                int i;
                Label[] labels = new Label[len];
                for (i = 0; i < len; ++i) {
                    labels[i] = this.newLabel();
                }
                this.mv.visitLookupSwitchInsn(def, keys2, labels);
                for (i = 0; i < len; ++i) {
                    this.mark(labels[i]);
                    generator.generateCase(keys2[i], end);
                }
            }
        }
        this.mark(def);
        generator.generateDefault();
        this.mark(end);
    }

    public void returnValue() {
        this.mv.visitInsn(this.returnType.getOpcode(172));
    }

    private void fieldInsn(int opcode, Type ownerType, String name2, Type fieldType) {
        this.mv.visitFieldInsn(opcode, ownerType.getInternalName(), name2, fieldType.getDescriptor());
    }

    public void getStatic(Type owner, String name2, Type type2) {
        this.fieldInsn(178, owner, name2, type2);
    }

    public void putStatic(Type owner, String name2, Type type2) {
        this.fieldInsn(179, owner, name2, type2);
    }

    public void getField(Type owner, String name2, Type type2) {
        this.fieldInsn(180, owner, name2, type2);
    }

    public void putField(Type owner, String name2, Type type2) {
        this.fieldInsn(181, owner, name2, type2);
    }

    private void invokeInsn(int opcode, Type type2, Method method, boolean itf) {
        String owner = type2.getSort() == 9 ? type2.getDescriptor() : type2.getInternalName();
        this.mv.visitMethodInsn(opcode, owner, method.getName(), method.getDescriptor(), itf);
    }

    public void invokeVirtual(Type owner, Method method) {
        this.invokeInsn(182, owner, method, false);
    }

    public void invokeConstructor(Type type2, Method method) {
        this.invokeInsn(183, type2, method, false);
    }

    public void invokeStatic(Type owner, Method method) {
        this.invokeInsn(184, owner, method, false);
    }

    public void invokeInterface(Type owner, Method method) {
        this.invokeInsn(185, owner, method, true);
    }

    public void invokeDynamic(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        this.mv.visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs);
    }

    private void typeInsn(int opcode, Type type2) {
        this.mv.visitTypeInsn(opcode, type2.getInternalName());
    }

    public void newInstance(Type type2) {
        this.typeInsn(187, type2);
    }

    public void newArray(Type type2) {
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
                this.typeInsn(189, type2);
                return;
            }
        }
        this.mv.visitIntInsn(188, typ);
    }

    public void arrayLength() {
        this.mv.visitInsn(190);
    }

    public void throwException() {
        this.mv.visitInsn(191);
    }

    public void throwException(Type type2, String msg) {
        this.newInstance(type2);
        this.dup();
        this.push(msg);
        this.invokeConstructor(type2, Method.getMethod("void <init> (String)"));
        this.throwException();
    }

    public void checkCast(Type type2) {
        if (!type2.equals(OBJECT_TYPE)) {
            this.typeInsn(192, type2);
        }
    }

    public void instanceOf(Type type2) {
        this.typeInsn(193, type2);
    }

    public void monitorEnter() {
        this.mv.visitInsn(194);
    }

    public void monitorExit() {
        this.mv.visitInsn(195);
    }

    public void endMethod() {
        if ((this.access & 0x400) == 0) {
            this.mv.visitMaxs(0, 0);
        }
        this.mv.visitEnd();
    }

    public void catchException(Label start, Label end, Type exception) {
        Label doCatch = new Label();
        if (exception == null) {
            this.mv.visitTryCatchBlock(start, end, doCatch, null);
        } else {
            this.mv.visitTryCatchBlock(start, end, doCatch, exception.getInternalName());
        }
        this.mark(doCatch);
    }
}

