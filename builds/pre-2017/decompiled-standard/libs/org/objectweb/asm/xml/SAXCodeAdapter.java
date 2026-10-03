/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.xml.SAXAdapter;
import org.objectweb.asm.xml.SAXAnnotationAdapter;
import org.objectweb.asm.xml.SAXClassAdapter;
import org.xml.sax.helpers.AttributesImpl;

public final class SAXCodeAdapter
extends MethodVisitor {
    static final String[] TYPES = new String[]{"top", "int", "float", "double", "long", "null", "uninitializedThis"};
    SAXAdapter sa;
    int access;
    private final Map<Label, String> labelNames;

    public SAXCodeAdapter(SAXAdapter sa, int access) {
        super(393216);
        this.sa = sa;
        this.access = access;
        this.labelNames = new HashMap<Label, String>();
    }

    @Override
    public void visitParameter(String name2, int access) {
        AttributesImpl attrs = new AttributesImpl();
        if (name2 != null) {
            attrs.addAttribute("", "name", "name", "", name2);
        }
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access, sb);
        attrs.addAttribute("", "access", "access", "", sb.toString());
        this.sa.addElement("parameter", attrs);
    }

    @Override
    public final void visitCode() {
        if ((this.access & 0x700) == 0) {
            this.sa.addStart("code", new AttributesImpl());
        }
    }

    @Override
    public void visitFrame(int type2, int nLocal, Object[] local, int nStack, Object[] stack) {
        AttributesImpl attrs = new AttributesImpl();
        switch (type2) {
            case -1: 
            case 0: {
                if (type2 == -1) {
                    attrs.addAttribute("", "type", "type", "", "NEW");
                } else {
                    attrs.addAttribute("", "type", "type", "", "FULL");
                }
                this.sa.addStart("frame", attrs);
                this.appendFrameTypes(true, nLocal, local);
                this.appendFrameTypes(false, nStack, stack);
                break;
            }
            case 1: {
                attrs.addAttribute("", "type", "type", "", "APPEND");
                this.sa.addStart("frame", attrs);
                this.appendFrameTypes(true, nLocal, local);
                break;
            }
            case 2: {
                attrs.addAttribute("", "type", "type", "", "CHOP");
                attrs.addAttribute("", "count", "count", "", Integer.toString(nLocal));
                this.sa.addStart("frame", attrs);
                break;
            }
            case 3: {
                attrs.addAttribute("", "type", "type", "", "SAME");
                this.sa.addStart("frame", attrs);
                break;
            }
            case 4: {
                attrs.addAttribute("", "type", "type", "", "SAME1");
                this.sa.addStart("frame", attrs);
                this.appendFrameTypes(false, 1, stack);
            }
        }
        this.sa.addEnd("frame");
    }

    private void appendFrameTypes(boolean local, int n, Object[] types) {
        for (int i = 0; i < n; ++i) {
            Object type2 = types[i];
            AttributesImpl attrs = new AttributesImpl();
            if (type2 instanceof String) {
                attrs.addAttribute("", "type", "type", "", (String)type2);
            } else if (type2 instanceof Integer) {
                attrs.addAttribute("", "type", "type", "", TYPES[(Integer)type2]);
            } else {
                attrs.addAttribute("", "type", "type", "", "uninitialized");
                attrs.addAttribute("", "label", "label", "", this.getLabel((Label)type2));
            }
            this.sa.addElement(local ? "local" : "stack", attrs);
        }
    }

    @Override
    public final void visitInsn(int opcode) {
        this.sa.addElement(Printer.OPCODES[opcode], new AttributesImpl());
    }

    @Override
    public final void visitIntInsn(int opcode, int operand) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "value", "value", "", Integer.toString(operand));
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public final void visitVarInsn(int opcode, int var) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "var", "var", "", Integer.toString(var));
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public final void visitTypeInsn(int opcode, String type2) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "desc", "desc", "", type2);
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public final void visitFieldInsn(int opcode, String owner, String name2, String desc) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "owner", "owner", "", owner);
        attrs.addAttribute("", "name", "name", "", name2);
        attrs.addAttribute("", "desc", "desc", "", desc);
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public final void visitMethodInsn(int opcode, String owner, String name2, String desc, boolean itf) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "owner", "owner", "", owner);
        attrs.addAttribute("", "name", "name", "", name2);
        attrs.addAttribute("", "desc", "desc", "", desc);
        attrs.addAttribute("", "itf", "itf", "", itf ? "true" : "false");
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public void visitInvokeDynamicInsn(String name2, String desc, Handle bsm, Object ... bsmArgs) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "name", "name", "", name2);
        attrs.addAttribute("", "desc", "desc", "", desc);
        attrs.addAttribute("", "bsm", "bsm", "", SAXClassAdapter.encode(bsm.toString()));
        this.sa.addStart("INVOKEDYNAMIC", attrs);
        for (int i = 0; i < bsmArgs.length; ++i) {
            this.sa.addElement("bsmArg", SAXCodeAdapter.getConstantAttribute(bsmArgs[i]));
        }
        this.sa.addEnd("INVOKEDYNAMIC");
    }

    @Override
    public final void visitJumpInsn(int opcode, Label label) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "label", "label", "", this.getLabel(label));
        this.sa.addElement(Printer.OPCODES[opcode], attrs);
    }

    @Override
    public final void visitLabel(Label label) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "name", "name", "", this.getLabel(label));
        this.sa.addElement("Label", attrs);
    }

    @Override
    public final void visitLdcInsn(Object cst) {
        this.sa.addElement(Printer.OPCODES[18], SAXCodeAdapter.getConstantAttribute(cst));
    }

    private static AttributesImpl getConstantAttribute(Object cst) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "cst", "cst", "", SAXClassAdapter.encode(cst.toString()));
        attrs.addAttribute("", "desc", "desc", "", Type.getDescriptor(cst.getClass()));
        return attrs;
    }

    @Override
    public final void visitIincInsn(int var, int increment) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "var", "var", "", Integer.toString(var));
        attrs.addAttribute("", "inc", "inc", "", Integer.toString(increment));
        this.sa.addElement(Printer.OPCODES[132], attrs);
    }

    @Override
    public final void visitTableSwitchInsn(int min, int max, Label dflt, Label ... labels) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "min", "min", "", Integer.toString(min));
        attrs.addAttribute("", "max", "max", "", Integer.toString(max));
        attrs.addAttribute("", "dflt", "dflt", "", this.getLabel(dflt));
        String o = Printer.OPCODES[170];
        this.sa.addStart(o, attrs);
        for (int i = 0; i < labels.length; ++i) {
            AttributesImpl att2 = new AttributesImpl();
            att2.addAttribute("", "name", "name", "", this.getLabel(labels[i]));
            this.sa.addElement("label", att2);
        }
        this.sa.addEnd(o);
    }

    @Override
    public final void visitLookupSwitchInsn(Label dflt, int[] keys2, Label[] labels) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "dflt", "dflt", "", this.getLabel(dflt));
        String o = Printer.OPCODES[171];
        this.sa.addStart(o, att);
        for (int i = 0; i < labels.length; ++i) {
            AttributesImpl att2 = new AttributesImpl();
            att2.addAttribute("", "name", "name", "", this.getLabel(labels[i]));
            att2.addAttribute("", "key", "key", "", Integer.toString(keys2[i]));
            this.sa.addElement("label", att2);
        }
        this.sa.addEnd(o);
    }

    @Override
    public final void visitMultiANewArrayInsn(String desc, int dims) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "desc", "desc", "", desc);
        attrs.addAttribute("", "dims", "dims", "", Integer.toString(dims));
        this.sa.addElement(Printer.OPCODES[197], attrs);
    }

    @Override
    public final void visitTryCatchBlock(Label start, Label end, Label handler, String type2) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "start", "start", "", this.getLabel(start));
        attrs.addAttribute("", "end", "end", "", this.getLabel(end));
        attrs.addAttribute("", "handler", "handler", "", this.getLabel(handler));
        if (type2 != null) {
            attrs.addAttribute("", "type", "type", "", type2);
        }
        this.sa.addElement("TryCatch", attrs);
    }

    @Override
    public final void visitMaxs(int maxStack, int maxLocals) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "maxStack", "maxStack", "", Integer.toString(maxStack));
        attrs.addAttribute("", "maxLocals", "maxLocals", "", Integer.toString(maxLocals));
        this.sa.addElement("Max", attrs);
        this.sa.addEnd("code");
    }

    @Override
    public void visitLocalVariable(String name2, String desc, String signature2, Label start, Label end, int index) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "name", "name", "", name2);
        attrs.addAttribute("", "desc", "desc", "", desc);
        if (signature2 != null) {
            attrs.addAttribute("", "signature", "signature", "", SAXClassAdapter.encode(signature2));
        }
        attrs.addAttribute("", "start", "start", "", this.getLabel(start));
        attrs.addAttribute("", "end", "end", "", this.getLabel(end));
        attrs.addAttribute("", "var", "var", "", Integer.toString(index));
        this.sa.addElement("LocalVar", attrs);
    }

    @Override
    public final void visitLineNumber(int line, Label start) {
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "line", "line", "", Integer.toString(line));
        attrs.addAttribute("", "start", "start", "", this.getLabel(start));
        this.sa.addElement("LineNumber", attrs);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        return new SAXAnnotationAdapter(this.sa, "annotationDefault", 0, null, null);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "annotation", visible ? 1 : -1, null, desc);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "typeAnnotation", visible ? 1 : -1, null, desc, typeRef, typePath);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "parameterAnnotation", visible ? 1 : -1, parameter, desc);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "insnAnnotation", visible ? 1 : -1, null, desc, typeRef, typePath);
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return new SAXAnnotationAdapter(this.sa, "tryCatchAnnotation", visible ? 1 : -1, null, desc, typeRef, typePath);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        int i;
        String[] s = new String[start.length];
        String[] e = new String[end.length];
        for (i = 0; i < s.length; ++i) {
            s[i] = this.getLabel(start[i]);
        }
        for (i = 0; i < e.length; ++i) {
            e[i] = this.getLabel(end[i]);
        }
        return new SAXAnnotationAdapter(this.sa, "localVariableAnnotation", visible ? 1 : -1, null, desc, typeRef, typePath, s, e, index);
    }

    @Override
    public void visitEnd() {
        this.sa.addEnd("method");
    }

    private final String getLabel(Label label) {
        String name2 = this.labelNames.get(label);
        if (name2 == null) {
            name2 = Integer.toString(this.labelNames.size());
            this.labelNames.put(label, name2);
        }
        return name2;
    }
}

