/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.xml.SAXCodeAdapter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ASMContentHandler
extends DefaultHandler
implements Opcodes {
    private final ArrayList<Object> stack = new ArrayList();
    String match = "";
    protected ClassVisitor cv;
    protected Map<Object, Label> labels;
    private static final String BASE = "class";
    private final RuleSet RULES = new RuleSet();
    static final HashMap<String, Opcode> OPCODES = new HashMap();
    static final HashMap<String, Integer> TYPES;

    private static void addOpcode(String operStr, int oper, int group) {
        OPCODES.put(operStr, new Opcode(oper, group));
    }

    public ASMContentHandler(ClassVisitor cv) {
        this.RULES.add(BASE, new ClassRule());
        this.RULES.add("class/interfaces/interface", new InterfaceRule());
        this.RULES.add("class/interfaces", new InterfacesRule());
        this.RULES.add("class/outerclass", new OuterClassRule());
        this.RULES.add("class/innerclass", new InnerClassRule());
        this.RULES.add("class/source", new SourceRule());
        ModuleRule moduleRule = new ModuleRule();
        this.RULES.add("class/module", moduleRule);
        this.RULES.add("class/module/main-class", moduleRule);
        this.RULES.add("class/module/target", moduleRule);
        this.RULES.add("class/module/packages", moduleRule);
        this.RULES.add("class/module/requires", moduleRule);
        this.RULES.add("class/module/exports", moduleRule);
        this.RULES.add("class/module/exports/to", moduleRule);
        this.RULES.add("class/module/uses", moduleRule);
        this.RULES.add("class/module/provides", moduleRule);
        this.RULES.add("class/field", new FieldRule());
        this.RULES.add("class/method", new MethodRule());
        this.RULES.add("class/method/exceptions/exception", new ExceptionRule());
        this.RULES.add("class/method/exceptions", new ExceptionsRule());
        this.RULES.add("class/method/parameter", new MethodParameterRule());
        this.RULES.add("class/method/annotationDefault", new AnnotationDefaultRule());
        this.RULES.add("class/method/code/*", new OpcodesRule());
        this.RULES.add("class/method/code/frame", new FrameRule());
        this.RULES.add("class/method/code/frame/local", new FrameTypeRule());
        this.RULES.add("class/method/code/frame/stack", new FrameTypeRule());
        this.RULES.add("class/method/code/TABLESWITCH", new TableSwitchRule());
        this.RULES.add("class/method/code/TABLESWITCH/label", new TableSwitchLabelRule());
        this.RULES.add("class/method/code/LOOKUPSWITCH", new LookupSwitchRule());
        this.RULES.add("class/method/code/LOOKUPSWITCH/label", new LookupSwitchLabelRule());
        this.RULES.add("class/method/code/INVOKEDYNAMIC", new InvokeDynamicRule());
        this.RULES.add("class/method/code/INVOKEDYNAMIC/bsmArg", new InvokeDynamicBsmArgumentsRule());
        this.RULES.add("class/method/code/Label", new LabelRule());
        this.RULES.add("class/method/code/TryCatch", new TryCatchRule());
        this.RULES.add("class/method/code/LineNumber", new LineNumberRule());
        this.RULES.add("class/method/code/LocalVar", new LocalVarRule());
        this.RULES.add("class/method/code/Max", new MaxRule());
        this.RULES.add("*/annotation", new AnnotationRule());
        this.RULES.add("*/typeAnnotation", new TypeAnnotationRule());
        this.RULES.add("*/parameterAnnotation", new AnnotationParameterRule());
        this.RULES.add("*/insnAnnotation", new InsnAnnotationRule());
        this.RULES.add("*/tryCatchAnnotation", new TryCatchAnnotationRule());
        this.RULES.add("*/localVariableAnnotation", new LocalVariableAnnotationRule());
        this.RULES.add("*/annotationValue", new AnnotationValueRule());
        this.RULES.add("*/annotationValueAnnotation", new AnnotationValueAnnotationRule());
        this.RULES.add("*/annotationValueEnum", new AnnotationValueEnumRule());
        this.RULES.add("*/annotationValueArray", new AnnotationValueArrayRule());
        this.cv = cv;
    }

    @Override
    public final void startElement(String ns, String lName, String qName, Attributes list) throws SAXException {
        String name2 = lName == null || lName.length() == 0 ? qName : lName;
        StringBuilder sb = new StringBuilder(this.match);
        if (this.match.length() > 0) {
            sb.append('/');
        }
        sb.append(name2);
        this.match = sb.toString();
        Rule r = (Rule)this.RULES.match(this.match);
        if (r != null) {
            r.begin(name2, list);
        }
    }

    @Override
    public final void endElement(String ns, String lName, String qName) throws SAXException {
        int slash;
        String name2 = lName == null || lName.length() == 0 ? qName : lName;
        Rule r = (Rule)this.RULES.match(this.match);
        if (r != null) {
            r.end(name2);
        }
        this.match = (slash = this.match.lastIndexOf(47)) >= 0 ? this.match.substring(0, slash) : "";
    }

    final Object peek() {
        int size = this.stack.size();
        return size == 0 ? null : this.stack.get(size - 1);
    }

    final Object pop() {
        int size = this.stack.size();
        return size == 0 ? null : this.stack.remove(size - 1);
    }

    final void push(Object object) {
        this.stack.add(object);
    }

    static {
        ASMContentHandler.addOpcode("NOP", 0, 0);
        ASMContentHandler.addOpcode("ACONST_NULL", 1, 0);
        ASMContentHandler.addOpcode("ICONST_M1", 2, 0);
        ASMContentHandler.addOpcode("ICONST_0", 3, 0);
        ASMContentHandler.addOpcode("ICONST_1", 4, 0);
        ASMContentHandler.addOpcode("ICONST_2", 5, 0);
        ASMContentHandler.addOpcode("ICONST_3", 6, 0);
        ASMContentHandler.addOpcode("ICONST_4", 7, 0);
        ASMContentHandler.addOpcode("ICONST_5", 8, 0);
        ASMContentHandler.addOpcode("LCONST_0", 9, 0);
        ASMContentHandler.addOpcode("LCONST_1", 10, 0);
        ASMContentHandler.addOpcode("FCONST_0", 11, 0);
        ASMContentHandler.addOpcode("FCONST_1", 12, 0);
        ASMContentHandler.addOpcode("FCONST_2", 13, 0);
        ASMContentHandler.addOpcode("DCONST_0", 14, 0);
        ASMContentHandler.addOpcode("DCONST_1", 15, 0);
        ASMContentHandler.addOpcode("BIPUSH", 16, 1);
        ASMContentHandler.addOpcode("SIPUSH", 17, 1);
        ASMContentHandler.addOpcode("LDC", 18, 7);
        ASMContentHandler.addOpcode("ILOAD", 21, 2);
        ASMContentHandler.addOpcode("LLOAD", 22, 2);
        ASMContentHandler.addOpcode("FLOAD", 23, 2);
        ASMContentHandler.addOpcode("DLOAD", 24, 2);
        ASMContentHandler.addOpcode("ALOAD", 25, 2);
        ASMContentHandler.addOpcode("IALOAD", 46, 0);
        ASMContentHandler.addOpcode("LALOAD", 47, 0);
        ASMContentHandler.addOpcode("FALOAD", 48, 0);
        ASMContentHandler.addOpcode("DALOAD", 49, 0);
        ASMContentHandler.addOpcode("AALOAD", 50, 0);
        ASMContentHandler.addOpcode("BALOAD", 51, 0);
        ASMContentHandler.addOpcode("CALOAD", 52, 0);
        ASMContentHandler.addOpcode("SALOAD", 53, 0);
        ASMContentHandler.addOpcode("ISTORE", 54, 2);
        ASMContentHandler.addOpcode("LSTORE", 55, 2);
        ASMContentHandler.addOpcode("FSTORE", 56, 2);
        ASMContentHandler.addOpcode("DSTORE", 57, 2);
        ASMContentHandler.addOpcode("ASTORE", 58, 2);
        ASMContentHandler.addOpcode("IASTORE", 79, 0);
        ASMContentHandler.addOpcode("LASTORE", 80, 0);
        ASMContentHandler.addOpcode("FASTORE", 81, 0);
        ASMContentHandler.addOpcode("DASTORE", 82, 0);
        ASMContentHandler.addOpcode("AASTORE", 83, 0);
        ASMContentHandler.addOpcode("BASTORE", 84, 0);
        ASMContentHandler.addOpcode("CASTORE", 85, 0);
        ASMContentHandler.addOpcode("SASTORE", 86, 0);
        ASMContentHandler.addOpcode("POP", 87, 0);
        ASMContentHandler.addOpcode("POP2", 88, 0);
        ASMContentHandler.addOpcode("DUP", 89, 0);
        ASMContentHandler.addOpcode("DUP_X1", 90, 0);
        ASMContentHandler.addOpcode("DUP_X2", 91, 0);
        ASMContentHandler.addOpcode("DUP2", 92, 0);
        ASMContentHandler.addOpcode("DUP2_X1", 93, 0);
        ASMContentHandler.addOpcode("DUP2_X2", 94, 0);
        ASMContentHandler.addOpcode("SWAP", 95, 0);
        ASMContentHandler.addOpcode("IADD", 96, 0);
        ASMContentHandler.addOpcode("LADD", 97, 0);
        ASMContentHandler.addOpcode("FADD", 98, 0);
        ASMContentHandler.addOpcode("DADD", 99, 0);
        ASMContentHandler.addOpcode("ISUB", 100, 0);
        ASMContentHandler.addOpcode("LSUB", 101, 0);
        ASMContentHandler.addOpcode("FSUB", 102, 0);
        ASMContentHandler.addOpcode("DSUB", 103, 0);
        ASMContentHandler.addOpcode("IMUL", 104, 0);
        ASMContentHandler.addOpcode("LMUL", 105, 0);
        ASMContentHandler.addOpcode("FMUL", 106, 0);
        ASMContentHandler.addOpcode("DMUL", 107, 0);
        ASMContentHandler.addOpcode("IDIV", 108, 0);
        ASMContentHandler.addOpcode("LDIV", 109, 0);
        ASMContentHandler.addOpcode("FDIV", 110, 0);
        ASMContentHandler.addOpcode("DDIV", 111, 0);
        ASMContentHandler.addOpcode("IREM", 112, 0);
        ASMContentHandler.addOpcode("LREM", 113, 0);
        ASMContentHandler.addOpcode("FREM", 114, 0);
        ASMContentHandler.addOpcode("DREM", 115, 0);
        ASMContentHandler.addOpcode("INEG", 116, 0);
        ASMContentHandler.addOpcode("LNEG", 117, 0);
        ASMContentHandler.addOpcode("FNEG", 118, 0);
        ASMContentHandler.addOpcode("DNEG", 119, 0);
        ASMContentHandler.addOpcode("ISHL", 120, 0);
        ASMContentHandler.addOpcode("LSHL", 121, 0);
        ASMContentHandler.addOpcode("ISHR", 122, 0);
        ASMContentHandler.addOpcode("LSHR", 123, 0);
        ASMContentHandler.addOpcode("IUSHR", 124, 0);
        ASMContentHandler.addOpcode("LUSHR", 125, 0);
        ASMContentHandler.addOpcode("IAND", 126, 0);
        ASMContentHandler.addOpcode("LAND", 127, 0);
        ASMContentHandler.addOpcode("IOR", 128, 0);
        ASMContentHandler.addOpcode("LOR", 129, 0);
        ASMContentHandler.addOpcode("IXOR", 130, 0);
        ASMContentHandler.addOpcode("LXOR", 131, 0);
        ASMContentHandler.addOpcode("IINC", 132, 8);
        ASMContentHandler.addOpcode("I2L", 133, 0);
        ASMContentHandler.addOpcode("I2F", 134, 0);
        ASMContentHandler.addOpcode("I2D", 135, 0);
        ASMContentHandler.addOpcode("L2I", 136, 0);
        ASMContentHandler.addOpcode("L2F", 137, 0);
        ASMContentHandler.addOpcode("L2D", 138, 0);
        ASMContentHandler.addOpcode("F2I", 139, 0);
        ASMContentHandler.addOpcode("F2L", 140, 0);
        ASMContentHandler.addOpcode("F2D", 141, 0);
        ASMContentHandler.addOpcode("D2I", 142, 0);
        ASMContentHandler.addOpcode("D2L", 143, 0);
        ASMContentHandler.addOpcode("D2F", 144, 0);
        ASMContentHandler.addOpcode("I2B", 145, 0);
        ASMContentHandler.addOpcode("I2C", 146, 0);
        ASMContentHandler.addOpcode("I2S", 147, 0);
        ASMContentHandler.addOpcode("LCMP", 148, 0);
        ASMContentHandler.addOpcode("FCMPL", 149, 0);
        ASMContentHandler.addOpcode("FCMPG", 150, 0);
        ASMContentHandler.addOpcode("DCMPL", 151, 0);
        ASMContentHandler.addOpcode("DCMPG", 152, 0);
        ASMContentHandler.addOpcode("IFEQ", 153, 6);
        ASMContentHandler.addOpcode("IFNE", 154, 6);
        ASMContentHandler.addOpcode("IFLT", 155, 6);
        ASMContentHandler.addOpcode("IFGE", 156, 6);
        ASMContentHandler.addOpcode("IFGT", 157, 6);
        ASMContentHandler.addOpcode("IFLE", 158, 6);
        ASMContentHandler.addOpcode("IF_ICMPEQ", 159, 6);
        ASMContentHandler.addOpcode("IF_ICMPNE", 160, 6);
        ASMContentHandler.addOpcode("IF_ICMPLT", 161, 6);
        ASMContentHandler.addOpcode("IF_ICMPGE", 162, 6);
        ASMContentHandler.addOpcode("IF_ICMPGT", 163, 6);
        ASMContentHandler.addOpcode("IF_ICMPLE", 164, 6);
        ASMContentHandler.addOpcode("IF_ACMPEQ", 165, 6);
        ASMContentHandler.addOpcode("IF_ACMPNE", 166, 6);
        ASMContentHandler.addOpcode("GOTO", 167, 6);
        ASMContentHandler.addOpcode("JSR", 168, 6);
        ASMContentHandler.addOpcode("RET", 169, 2);
        ASMContentHandler.addOpcode("IRETURN", 172, 0);
        ASMContentHandler.addOpcode("LRETURN", 173, 0);
        ASMContentHandler.addOpcode("FRETURN", 174, 0);
        ASMContentHandler.addOpcode("DRETURN", 175, 0);
        ASMContentHandler.addOpcode("ARETURN", 176, 0);
        ASMContentHandler.addOpcode("RETURN", 177, 0);
        ASMContentHandler.addOpcode("GETSTATIC", 178, 4);
        ASMContentHandler.addOpcode("PUTSTATIC", 179, 4);
        ASMContentHandler.addOpcode("GETFIELD", 180, 4);
        ASMContentHandler.addOpcode("PUTFIELD", 181, 4);
        ASMContentHandler.addOpcode("INVOKEVIRTUAL", 182, 5);
        ASMContentHandler.addOpcode("INVOKESPECIAL", 183, 5);
        ASMContentHandler.addOpcode("INVOKESTATIC", 184, 5);
        ASMContentHandler.addOpcode("INVOKEINTERFACE", 185, 5);
        ASMContentHandler.addOpcode("NEW", 187, 3);
        ASMContentHandler.addOpcode("NEWARRAY", 188, 1);
        ASMContentHandler.addOpcode("ANEWARRAY", 189, 3);
        ASMContentHandler.addOpcode("ARRAYLENGTH", 190, 0);
        ASMContentHandler.addOpcode("ATHROW", 191, 0);
        ASMContentHandler.addOpcode("CHECKCAST", 192, 3);
        ASMContentHandler.addOpcode("INSTANCEOF", 193, 3);
        ASMContentHandler.addOpcode("MONITORENTER", 194, 0);
        ASMContentHandler.addOpcode("MONITOREXIT", 195, 0);
        ASMContentHandler.addOpcode("MULTIANEWARRAY", 197, 9);
        ASMContentHandler.addOpcode("IFNULL", 198, 6);
        ASMContentHandler.addOpcode("IFNONNULL", 199, 6);
        TYPES = new HashMap();
        String[] types = SAXCodeAdapter.TYPES;
        for (int i = 0; i < types.length; ++i) {
            TYPES.put(types[i], i);
        }
    }

    static final class Opcode {
        public final int opcode;
        public final int type;

        Opcode(int opcode, int type2) {
            this.opcode = opcode;
            this.type = type2;
        }
    }

    final class AnnotationDefaultRule
    extends Rule {
        AnnotationDefaultRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) {
            MethodVisitor av = (MethodVisitor)ASMContentHandler.this.peek();
            ASMContentHandler.this.push(av == null ? null : av.visitAnnotationDefault());
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class AnnotationValueArrayRule
    extends Rule {
        AnnotationValueArrayRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.peek();
            ASMContentHandler.this.push(av == null ? null : av.visitArray(attrs.getValue("name")));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class AnnotationValueAnnotationRule
    extends Rule {
        AnnotationValueAnnotationRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.peek();
            ASMContentHandler.this.push(av == null ? null : av.visitAnnotation(attrs.getValue("name"), attrs.getValue("desc")));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class AnnotationValueEnumRule
    extends Rule {
        AnnotationValueEnumRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.peek();
            if (av != null) {
                av.visitEnum(attrs.getValue("name"), attrs.getValue("desc"), attrs.getValue("value"));
            }
        }
    }

    final class AnnotationValueRule
    extends Rule {
        AnnotationValueRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) throws SAXException {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.peek();
            if (av != null) {
                av.visit(attrs.getValue("name"), this.getValue(attrs.getValue("desc"), attrs.getValue("value")));
            }
        }
    }

    final class LocalVariableAnnotationRule
    extends Rule {
        LocalVariableAnnotationRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            int typeRef = Integer.parseInt(attrs.getValue("typeRef"));
            TypePath typePath = TypePath.fromString(attrs.getValue("typePath"));
            String[] s = attrs.getValue("start").split(" ");
            Label[] start = new Label[s.length];
            for (int i = 0; i < start.length; ++i) {
                start[i] = this.getLabel(s[i]);
            }
            String[] e = attrs.getValue("end").split(" ");
            Label[] end = new Label[e.length];
            for (int i = 0; i < end.length; ++i) {
                end[i] = this.getLabel(e[i]);
            }
            String[] v = attrs.getValue("index").split(" ");
            int[] index = new int[v.length];
            for (int i = 0; i < index.length; ++i) {
                index[i] = Integer.parseInt(v[i]);
            }
            ASMContentHandler.this.push(((MethodVisitor)ASMContentHandler.this.peek()).visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class TryCatchAnnotationRule
    extends Rule {
        TryCatchAnnotationRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            int typeRef = Integer.parseInt(attrs.getValue("typeRef"));
            TypePath typePath = TypePath.fromString(attrs.getValue("typePath"));
            ASMContentHandler.this.push(((MethodVisitor)ASMContentHandler.this.peek()).visitTryCatchAnnotation(typeRef, typePath, desc, visible));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class InsnAnnotationRule
    extends Rule {
        InsnAnnotationRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            int typeRef = Integer.parseInt(attrs.getValue("typeRef"));
            TypePath typePath = TypePath.fromString(attrs.getValue("typePath"));
            ASMContentHandler.this.push(((MethodVisitor)ASMContentHandler.this.peek()).visitInsnAnnotation(typeRef, typePath, desc, visible));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class AnnotationParameterRule
    extends Rule {
        AnnotationParameterRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            int parameter = Integer.parseInt(attrs.getValue("parameter"));
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            ASMContentHandler.this.push(((MethodVisitor)ASMContentHandler.this.peek()).visitParameterAnnotation(parameter, desc, visible));
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class TypeAnnotationRule
    extends Rule {
        TypeAnnotationRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            int typeRef = Integer.parseInt(attrs.getValue("typeRef"));
            TypePath typePath = TypePath.fromString(attrs.getValue("typePath"));
            Object v = ASMContentHandler.this.peek();
            if (v instanceof ClassVisitor) {
                ASMContentHandler.this.push(((ClassVisitor)v).visitTypeAnnotation(typeRef, typePath, desc, visible));
            } else if (v instanceof FieldVisitor) {
                ASMContentHandler.this.push(((FieldVisitor)v).visitTypeAnnotation(typeRef, typePath, desc, visible));
            } else if (v instanceof MethodVisitor) {
                ASMContentHandler.this.push(((MethodVisitor)v).visitTypeAnnotation(typeRef, typePath, desc, visible));
            }
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class AnnotationRule
    extends Rule {
        AnnotationRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String desc = attrs.getValue("desc");
            boolean visible = Boolean.valueOf(attrs.getValue("visible"));
            Object v = ASMContentHandler.this.peek();
            if (v instanceof ClassVisitor) {
                ASMContentHandler.this.push(((ClassVisitor)v).visitAnnotation(desc, visible));
            } else if (v instanceof FieldVisitor) {
                ASMContentHandler.this.push(((FieldVisitor)v).visitAnnotation(desc, visible));
            } else if (v instanceof MethodVisitor) {
                ASMContentHandler.this.push(((MethodVisitor)v).visitAnnotation(desc, visible));
            }
        }

        @Override
        public void end(String name2) {
            AnnotationVisitor av = (AnnotationVisitor)ASMContentHandler.this.pop();
            if (av != null) {
                av.visitEnd();
            }
        }
    }

    final class MaxRule
    extends Rule {
        MaxRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) {
            int maxStack = Integer.parseInt(attrs.getValue("maxStack"));
            int maxLocals = Integer.parseInt(attrs.getValue("maxLocals"));
            this.getCodeVisitor().visitMaxs(maxStack, maxLocals);
        }
    }

    final class OpcodesRule
    extends Rule {
        OpcodesRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) throws SAXException {
            Opcode o = OPCODES.get(element);
            if (o == null) {
                throw new SAXException("Invalid element: " + element + " at " + ASMContentHandler.this.match);
            }
            switch (o.type) {
                case 0: {
                    this.getCodeVisitor().visitInsn(o.opcode);
                    break;
                }
                case 4: {
                    this.getCodeVisitor().visitFieldInsn(o.opcode, attrs.getValue("owner"), attrs.getValue("name"), attrs.getValue("desc"));
                    break;
                }
                case 1: {
                    this.getCodeVisitor().visitIntInsn(o.opcode, Integer.parseInt(attrs.getValue("value")));
                    break;
                }
                case 6: {
                    this.getCodeVisitor().visitJumpInsn(o.opcode, this.getLabel(attrs.getValue("label")));
                    break;
                }
                case 5: {
                    this.getCodeVisitor().visitMethodInsn(o.opcode, attrs.getValue("owner"), attrs.getValue("name"), attrs.getValue("desc"), attrs.getValue("itf").equals("true"));
                    break;
                }
                case 3: {
                    this.getCodeVisitor().visitTypeInsn(o.opcode, attrs.getValue("desc"));
                    break;
                }
                case 2: {
                    this.getCodeVisitor().visitVarInsn(o.opcode, Integer.parseInt(attrs.getValue("var")));
                    break;
                }
                case 8: {
                    this.getCodeVisitor().visitIincInsn(Integer.parseInt(attrs.getValue("var")), Integer.parseInt(attrs.getValue("inc")));
                    break;
                }
                case 7: {
                    this.getCodeVisitor().visitLdcInsn(this.getValue(attrs.getValue("desc"), attrs.getValue("cst")));
                    break;
                }
                case 9: {
                    this.getCodeVisitor().visitMultiANewArrayInsn(attrs.getValue("desc"), Integer.parseInt(attrs.getValue("dims")));
                    break;
                }
                default: {
                    throw new Error("Internal error");
                }
            }
        }
    }

    final class InvokeDynamicBsmArgumentsRule
    extends Rule {
        InvokeDynamicBsmArgumentsRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) throws SAXException {
            ArrayList bsmArgs = (ArrayList)ASMContentHandler.this.peek();
            bsmArgs.add(this.getValue(attrs.getValue("desc"), attrs.getValue("cst")));
        }
    }

    final class InvokeDynamicRule
    extends Rule {
        InvokeDynamicRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) throws SAXException {
            ASMContentHandler.this.push(attrs.getValue("name"));
            ASMContentHandler.this.push(attrs.getValue("desc"));
            ASMContentHandler.this.push(this.decodeHandle(attrs.getValue("bsm")));
            ASMContentHandler.this.push(new ArrayList());
        }

        @Override
        public final void end(String element) {
            ArrayList bsmArgs = (ArrayList)ASMContentHandler.this.pop();
            Handle bsm = (Handle)ASMContentHandler.this.pop();
            String desc = (String)ASMContentHandler.this.pop();
            String name2 = (String)ASMContentHandler.this.pop();
            this.getCodeVisitor().visitInvokeDynamicInsn(name2, desc, bsm, bsmArgs.toArray());
        }
    }

    final class LocalVarRule
    extends Rule {
        LocalVarRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) {
            String name2 = attrs.getValue("name");
            String desc = attrs.getValue("desc");
            String signature2 = attrs.getValue("signature");
            Label start = this.getLabel(attrs.getValue("start"));
            Label end = this.getLabel(attrs.getValue("end"));
            int var = Integer.parseInt(attrs.getValue("var"));
            this.getCodeVisitor().visitLocalVariable(name2, desc, signature2, start, end, var);
        }
    }

    final class LineNumberRule
    extends Rule {
        LineNumberRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            int line = Integer.parseInt(attrs.getValue("line"));
            Label start = this.getLabel(attrs.getValue("start"));
            this.getCodeVisitor().visitLineNumber(line, start);
        }
    }

    final class TryCatchRule
    extends Rule {
        TryCatchRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            Label start = this.getLabel(attrs.getValue("start"));
            Label end = this.getLabel(attrs.getValue("end"));
            Label handler = this.getLabel(attrs.getValue("handler"));
            String type2 = attrs.getValue("type");
            this.getCodeVisitor().visitTryCatchBlock(start, end, handler, type2);
        }
    }

    final class LabelRule
    extends Rule {
        LabelRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            this.getCodeVisitor().visitLabel(this.getLabel(attrs.getValue("name")));
        }
    }

    final class FrameTypeRule
    extends Rule {
        FrameTypeRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            ArrayList types = (ArrayList)((HashMap)ASMContentHandler.this.peek()).get(name2);
            String type2 = attrs.getValue("type");
            if ("uninitialized".equals(type2)) {
                types.add(this.getLabel(attrs.getValue("label")));
            } else {
                Integer t = TYPES.get(type2);
                if (t == null) {
                    types.add(type2);
                } else {
                    types.add(t);
                }
            }
        }
    }

    final class FrameRule
    extends Rule {
        FrameRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            HashMap typeLists = new HashMap();
            typeLists.put("local", new ArrayList());
            typeLists.put("stack", new ArrayList());
            ASMContentHandler.this.push(attrs.getValue("type"));
            ASMContentHandler.this.push(attrs.getValue("count") == null ? "0" : attrs.getValue("count"));
            ASMContentHandler.this.push(typeLists);
        }

        @Override
        public void end(String name2) {
            HashMap typeLists = (HashMap)ASMContentHandler.this.pop();
            ArrayList locals = (ArrayList)typeLists.get("local");
            int nLocal = locals.size();
            Object[] local = locals.toArray();
            ArrayList stacks = (ArrayList)typeLists.get("stack");
            int nStack = stacks.size();
            Object[] stack = stacks.toArray();
            String count = (String)ASMContentHandler.this.pop();
            String type2 = (String)ASMContentHandler.this.pop();
            if ("NEW".equals(type2)) {
                this.getCodeVisitor().visitFrame(-1, nLocal, local, nStack, stack);
            } else if ("FULL".equals(type2)) {
                this.getCodeVisitor().visitFrame(0, nLocal, local, nStack, stack);
            } else if ("APPEND".equals(type2)) {
                this.getCodeVisitor().visitFrame(1, nLocal, local, 0, null);
            } else if ("CHOP".equals(type2)) {
                this.getCodeVisitor().visitFrame(2, Integer.parseInt(count), null, 0, null);
            } else if ("SAME".equals(type2)) {
                this.getCodeVisitor().visitFrame(3, 0, null, 0, null);
            } else if ("SAME1".equals(type2)) {
                this.getCodeVisitor().visitFrame(4, 0, null, nStack, stack);
            }
        }
    }

    final class LookupSwitchLabelRule
    extends Rule {
        LookupSwitchLabelRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            HashMap vals = (HashMap)ASMContentHandler.this.peek();
            ((ArrayList)vals.get("labels")).add(this.getLabel(attrs.getValue("name")));
            ((ArrayList)vals.get("keys")).add(attrs.getValue("key"));
        }
    }

    final class LookupSwitchRule
    extends Rule {
        LookupSwitchRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            HashMap<String, Object> vals = new HashMap<String, Object>();
            vals.put("dflt", attrs.getValue("dflt"));
            vals.put("labels", new ArrayList());
            vals.put("keys", new ArrayList());
            ASMContentHandler.this.push(vals);
        }

        @Override
        public final void end(String name2) {
            HashMap vals = (HashMap)ASMContentHandler.this.pop();
            Label dflt = this.getLabel(vals.get("dflt"));
            ArrayList keyList = (ArrayList)vals.get("keys");
            ArrayList lbls = (ArrayList)vals.get("labels");
            Label[] labels = lbls.toArray(new Label[lbls.size()]);
            int[] keys2 = new int[keyList.size()];
            for (int i = 0; i < keys2.length; ++i) {
                keys2[i] = Integer.parseInt((String)keyList.get(i));
            }
            this.getCodeVisitor().visitLookupSwitchInsn(dflt, keys2, labels);
        }
    }

    final class TableSwitchLabelRule
    extends Rule {
        TableSwitchLabelRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            ((ArrayList)((HashMap)ASMContentHandler.this.peek()).get("labels")).add(this.getLabel(attrs.getValue("name")));
        }
    }

    final class TableSwitchRule
    extends Rule {
        TableSwitchRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            HashMap<String, Object> vals = new HashMap<String, Object>();
            vals.put("min", attrs.getValue("min"));
            vals.put("max", attrs.getValue("max"));
            vals.put("dflt", attrs.getValue("dflt"));
            vals.put("labels", new ArrayList());
            ASMContentHandler.this.push(vals);
        }

        @Override
        public final void end(String name2) {
            HashMap vals = (HashMap)ASMContentHandler.this.pop();
            int min = Integer.parseInt((String)vals.get("min"));
            int max = Integer.parseInt((String)vals.get("max"));
            Label dflt = this.getLabel(vals.get("dflt"));
            ArrayList lbls = (ArrayList)vals.get("labels");
            Label[] labels = lbls.toArray(new Label[lbls.size()]);
            this.getCodeVisitor().visitTableSwitchInsn(min, max, dflt, labels);
        }
    }

    final class MethodParameterRule
    extends Rule {
        MethodParameterRule() {
        }

        @Override
        public void begin(String nm, Attributes attrs) {
            String name2 = attrs.getValue("name");
            int access = this.getAccess(attrs.getValue("access"));
            this.getCodeVisitor().visitParameter(name2, access);
        }
    }

    final class ExceptionsRule
    extends Rule {
        ExceptionsRule() {
        }

        @Override
        public final void end(String element) {
            HashMap vals = (HashMap)ASMContentHandler.this.pop();
            int access = this.getAccess((String)vals.get("access"));
            String name2 = (String)vals.get("name");
            String desc = (String)vals.get("desc");
            String signature2 = (String)vals.get("signature");
            ArrayList excs = (ArrayList)vals.get("exceptions");
            String[] exceptions = excs.toArray(new String[excs.size()]);
            ASMContentHandler.this.push(ASMContentHandler.this.cv.visitMethod(access, name2, desc, signature2, exceptions));
        }
    }

    final class ExceptionRule
    extends Rule {
        ExceptionRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            ((ArrayList)((HashMap)ASMContentHandler.this.peek()).get("exceptions")).add(attrs.getValue("name"));
        }
    }

    final class MethodRule
    extends Rule {
        MethodRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            ASMContentHandler.this.labels = new HashMap<Object, Label>();
            HashMap<String, Object> vals = new HashMap<String, Object>();
            vals.put("access", attrs.getValue("access"));
            vals.put("name", attrs.getValue("name"));
            vals.put("desc", attrs.getValue("desc"));
            vals.put("signature", attrs.getValue("signature"));
            vals.put("exceptions", new ArrayList());
            ASMContentHandler.this.push(vals);
        }

        @Override
        public final void end(String name2) {
            ((MethodVisitor)ASMContentHandler.this.pop()).visitEnd();
            ASMContentHandler.this.labels = null;
        }
    }

    final class FieldRule
    extends Rule {
        FieldRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) throws SAXException {
            int access = this.getAccess(attrs.getValue("access"));
            String name2 = attrs.getValue("name");
            String signature2 = attrs.getValue("signature");
            String desc = attrs.getValue("desc");
            Object value = this.getValue(desc, attrs.getValue("value"));
            ASMContentHandler.this.push(ASMContentHandler.this.cv.visitField(access, name2, desc, signature2, value));
        }

        @Override
        public void end(String name2) {
            ((FieldVisitor)ASMContentHandler.this.pop()).visitEnd();
        }
    }

    final class InnerClassRule
    extends Rule {
        InnerClassRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) {
            int access = this.getAccess(attrs.getValue("access"));
            String name2 = attrs.getValue("name");
            String outerName = attrs.getValue("outerName");
            String innerName = attrs.getValue("innerName");
            ASMContentHandler.this.cv.visitInnerClass(name2, outerName, innerName, access);
        }
    }

    final class OuterClassRule
    extends Rule {
        OuterClassRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) {
            String owner = attrs.getValue("owner");
            String name2 = attrs.getValue("name");
            String desc = attrs.getValue("desc");
            ASMContentHandler.this.cv.visitOuterClass(owner, name2, desc);
        }
    }

    final class ModuleRule
    extends Rule {
        ModuleRule() {
        }

        @Override
        public final void begin(String element, Attributes attrs) throws SAXException {
            if ("module".equals(element)) {
                ASMContentHandler.this.push(ASMContentHandler.this.cv.visitModule(attrs.getValue("name"), this.getAccess(attrs.getValue("access")), attrs.getValue("version")));
            } else if ("main-class".equals(element)) {
                ModuleVisitor mv = (ModuleVisitor)ASMContentHandler.this.peek();
                mv.visitMainClass(attrs.getValue("name"));
            } else if ("packages".equals(element)) {
                ModuleVisitor mv = (ModuleVisitor)ASMContentHandler.this.peek();
                mv.visitPackage(attrs.getValue("name"));
            } else if ("requires".equals(element)) {
                ModuleVisitor mv = (ModuleVisitor)ASMContentHandler.this.peek();
                int access = this.getAccess(attrs.getValue("access"));
                if ((access & 8) != 0) {
                    access = access & 0xFFFFFFF7 | 0x40;
                }
                mv.visitRequire(attrs.getValue("module"), access, attrs.getValue("version"));
            } else if ("exports".equals(element)) {
                ASMContentHandler.this.push(attrs.getValue("name"));
                ASMContentHandler.this.push(this.getAccess(attrs.getValue("access")));
                ArrayList list = new ArrayList();
                ASMContentHandler.this.push(list);
            } else if ("opens".equals(element)) {
                ASMContentHandler.this.push(attrs.getValue("name"));
                ASMContentHandler.this.push(this.getAccess(attrs.getValue("access")));
                ArrayList list = new ArrayList();
                ASMContentHandler.this.push(list);
            } else if ("to".equals(element)) {
                ArrayList list = (ArrayList)ASMContentHandler.this.peek();
                list.add(attrs.getValue("module"));
            } else if ("uses".equals(element)) {
                ModuleVisitor mv = (ModuleVisitor)ASMContentHandler.this.peek();
                mv.visitUse(attrs.getValue("service"));
            } else if ("provides".equals(element)) {
                ASMContentHandler.this.push(attrs.getValue("service"));
                ASMContentHandler.this.push(0);
                ArrayList list = new ArrayList();
                ASMContentHandler.this.push(list);
            } else if ("with".equals(element)) {
                ArrayList list = (ArrayList)ASMContentHandler.this.peek();
                list.add(attrs.getValue("provider"));
            }
        }

        @Override
        public void end(String element) {
            boolean provides;
            boolean opens;
            boolean exports = "exports".equals(element);
            if (exports | (opens = "opens".equals(element)) | (provides = "provides".equals(element))) {
                ArrayList list = (ArrayList)ASMContentHandler.this.pop();
                int access = (Integer)ASMContentHandler.this.pop();
                String name2 = (String)ASMContentHandler.this.pop();
                String[] tos = null;
                if (!list.isEmpty()) {
                    tos = list.toArray(new String[list.size()]);
                }
                ModuleVisitor mv = (ModuleVisitor)ASMContentHandler.this.peek();
                if (exports) {
                    mv.visitExport(name2, access, tos);
                } else if (opens) {
                    mv.visitOpen(name2, access, tos);
                } else {
                    mv.visitProvide(name2, tos);
                }
            } else if ("module".equals(element)) {
                ((ModuleVisitor)ASMContentHandler.this.pop()).visitEnd();
            }
        }
    }

    final class InterfacesRule
    extends Rule {
        InterfacesRule() {
        }

        @Override
        public final void end(String element) {
            HashMap vals = (HashMap)ASMContentHandler.this.pop();
            int version = (Integer)vals.get("version");
            int access = this.getAccess((String)vals.get("access"));
            String name2 = (String)vals.get("name");
            String signature2 = (String)vals.get("signature");
            String parent = (String)vals.get("parent");
            ArrayList infs = (ArrayList)vals.get("interfaces");
            String[] interfaces = infs.toArray(new String[infs.size()]);
            ASMContentHandler.this.cv.visit(version, access, name2, signature2, parent, interfaces);
            ASMContentHandler.this.push(ASMContentHandler.this.cv);
        }
    }

    final class InterfaceRule
    extends Rule {
        InterfaceRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            ((ArrayList)((HashMap)ASMContentHandler.this.peek()).get("interfaces")).add(attrs.getValue("name"));
        }
    }

    final class SourceRule
    extends Rule {
        SourceRule() {
        }

        @Override
        public void begin(String name2, Attributes attrs) {
            String file = attrs.getValue("file");
            String debug = attrs.getValue("debug");
            ASMContentHandler.this.cv.visitSource(file, debug);
        }
    }

    final class ClassRule
    extends Rule {
        ClassRule() {
        }

        @Override
        public final void begin(String name2, Attributes attrs) {
            int major = Integer.parseInt(attrs.getValue("major"));
            int minor = Integer.parseInt(attrs.getValue("minor"));
            HashMap<String, Object> vals = new HashMap<String, Object>();
            vals.put("version", minor << 16 | major);
            vals.put("access", attrs.getValue("access"));
            vals.put("name", attrs.getValue("name"));
            vals.put("parent", attrs.getValue("parent"));
            vals.put("source", attrs.getValue("source"));
            vals.put("signature", attrs.getValue("signature"));
            vals.put("interfaces", new ArrayList());
            ASMContentHandler.this.push(vals);
        }
    }

    protected abstract class Rule {
        protected Rule() {
        }

        public void begin(String name2, Attributes attrs) throws SAXException {
        }

        public void end(String name2) {
        }

        protected final Object getValue(String desc, String val) throws SAXException {
            Object value = null;
            if (val != null) {
                if ("Ljava/lang/String;".equals(desc)) {
                    value = this.decode(val);
                } else if ("Ljava/lang/Integer;".equals(desc) || "I".equals(desc) || "S".equals(desc) || "B".equals(desc) || "C".equals(desc) || "Z".equals(desc)) {
                    value = new Integer(val);
                } else if ("Ljava/lang/Short;".equals(desc)) {
                    value = new Short(val);
                } else if ("Ljava/lang/Byte;".equals(desc)) {
                    value = new Byte(val);
                } else if ("Ljava/lang/Character;".equals(desc)) {
                    value = new Character(this.decode(val).charAt(0));
                } else if ("Ljava/lang/Boolean;".equals(desc)) {
                    value = Boolean.valueOf(val);
                } else if ("Ljava/lang/Long;".equals(desc) || "J".equals(desc)) {
                    value = new Long(val);
                } else if ("Ljava/lang/Float;".equals(desc) || "F".equals(desc)) {
                    value = new Float(val);
                } else if ("Ljava/lang/Double;".equals(desc) || "D".equals(desc)) {
                    value = new Double(val);
                } else if (Type.getDescriptor(Type.class).equals(desc)) {
                    value = Type.getType(val);
                } else if (Type.getDescriptor(Handle.class).equals(desc)) {
                    value = this.decodeHandle(val);
                } else {
                    throw new SAXException("Invalid value:" + val + " desc:" + desc + " ctx:" + this);
                }
            }
            return value;
        }

        Handle decodeHandle(String val) throws SAXException {
            try {
                int dotIndex = val.indexOf(46);
                int descIndex = val.indexOf(40, dotIndex + 1);
                int tagIndex = val.lastIndexOf(40);
                int itfIndex = val.indexOf(32, tagIndex + 1);
                boolean itf = itfIndex != -1;
                int tag = Integer.parseInt(val.substring(tagIndex + 1, itf ? val.length() - 1 : itfIndex));
                String owner = val.substring(0, dotIndex);
                String name2 = val.substring(dotIndex + 1, descIndex);
                String desc = val.substring(descIndex, tagIndex - 1);
                return new Handle(tag, owner, name2, desc, itf);
            }
            catch (RuntimeException e) {
                throw new SAXException("Malformed handle " + val, e);
            }
        }

        private final String decode(String val) throws SAXException {
            StringBuilder sb = new StringBuilder(val.length());
            try {
                for (int n = 0; n < val.length(); ++n) {
                    char c = val.charAt(n);
                    if (c == '\\') {
                        if ((c = val.charAt(++n)) == '\\') {
                            sb.append('\\');
                            continue;
                        }
                        sb.append((char)Integer.parseInt(val.substring(++n, n + 4), 16));
                        n += 3;
                        continue;
                    }
                    sb.append(c);
                }
            }
            catch (RuntimeException ex) {
                throw new SAXException(ex);
            }
            return sb.toString();
        }

        protected final Label getLabel(Object label) {
            Label lbl = ASMContentHandler.this.labels.get(label);
            if (lbl == null) {
                lbl = new Label();
                ASMContentHandler.this.labels.put(label, lbl);
            }
            return lbl;
        }

        protected final MethodVisitor getCodeVisitor() {
            return (MethodVisitor)ASMContentHandler.this.peek();
        }

        protected final int getAccess(String s) {
            int access = 0;
            if (s.indexOf("public") != -1) {
                access |= 1;
            }
            if (s.indexOf("private") != -1) {
                access |= 2;
            }
            if (s.indexOf("protected") != -1) {
                access |= 4;
            }
            if (s.indexOf("static") != -1) {
                access |= 8;
            }
            if (s.indexOf("final") != -1) {
                access |= 0x10;
            }
            if (s.indexOf("super") != -1) {
                access |= 0x20;
            }
            if (s.indexOf("synchronized") != -1) {
                access |= 0x20;
            }
            if (s.indexOf("volatile") != -1) {
                access |= 0x40;
            }
            if (s.indexOf("bridge") != -1) {
                access |= 0x40;
            }
            if (s.indexOf("varargs") != -1) {
                access |= 0x80;
            }
            if (s.indexOf("transient") != -1) {
                access |= 0x80;
            }
            if (s.indexOf("native") != -1) {
                access |= 0x100;
            }
            if (s.indexOf("interface") != -1) {
                access |= 0x200;
            }
            if (s.indexOf("abstract") != -1) {
                access |= 0x400;
            }
            if (s.indexOf("strict") != -1) {
                access |= 0x800;
            }
            if (s.indexOf("synthetic") != -1) {
                access |= 0x1000;
            }
            if (s.indexOf("annotation") != -1) {
                access |= 0x2000;
            }
            if (s.indexOf("enum") != -1) {
                access |= 0x4000;
            }
            if (s.indexOf("deprecated") != -1) {
                access |= 0x20000;
            }
            if (s.indexOf("mandated") != -1) {
                access |= 0x8000;
            }
            if (s.indexOf("module") != -1) {
                access |= 0x8000;
            }
            if (s.indexOf("open") != -1) {
                access |= 0x20;
            }
            if (s.indexOf("transitive") != -1) {
                access |= 0x20;
            }
            return access;
        }
    }

    static final class RuleSet {
        private final HashMap<String, Object> rules = new HashMap();
        private final ArrayList<String> lpatterns = new ArrayList();
        private final ArrayList<String> rpatterns = new ArrayList();

        RuleSet() {
        }

        public void add(String path, Object rule) {
            String pattern = path;
            if (path.startsWith("*/")) {
                pattern = path.substring(1);
                this.lpatterns.add(pattern);
            } else if (path.endsWith("/*")) {
                pattern = path.substring(0, path.length() - 1);
                this.rpatterns.add(pattern);
            }
            this.rules.put(pattern, rule);
        }

        public Object match(String path) {
            if (this.rules.containsKey(path)) {
                return this.rules.get(path);
            }
            int n = path.lastIndexOf(47);
            for (String pattern : this.lpatterns) {
                if (!path.substring(n).endsWith(pattern)) continue;
                return this.rules.get(pattern);
            }
            for (String pattern : this.rpatterns) {
                if (!path.startsWith(pattern)) continue;
                return this.rules.get(pattern);
            }
            return null;
        }
    }

    private static interface OpcodeGroup {
        public static final int INSN = 0;
        public static final int INSN_INT = 1;
        public static final int INSN_VAR = 2;
        public static final int INSN_TYPE = 3;
        public static final int INSN_FIELD = 4;
        public static final int INSN_METHOD = 5;
        public static final int INSN_JUMP = 6;
        public static final int INSN_LDC = 7;
        public static final int INSN_IINC = 8;
        public static final int INSN_MULTIANEWARRAY = 9;
    }
}

