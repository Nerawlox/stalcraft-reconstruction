/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.xml.SAXAdapter;
import org.objectweb.asm.xml.SAXAnnotationAdapter;
import org.objectweb.asm.xml.SAXCodeAdapter;
import org.objectweb.asm.xml.SAXFieldAdapter;
import org.objectweb.asm.xml.SAXModuleAdapter;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

public final class SAXClassAdapter
extends ClassVisitor {
    SAXAdapter sa;
    private final boolean singleDocument;
    private static final int ACCESS_CLASS = 262144;
    private static final int ACCESS_FIELD = 524288;
    private static final int ACCESS_INNER = 0x100000;
    static final int ACCESS_MODULE = 0x200000;
    static final int ACCESS_MODULE_REQUIRES = 0x400000;

    public SAXClassAdapter(ContentHandler h, boolean singleDocument) {
        super(393216);
        this.sa = new SAXAdapter(h);
        this.singleDocument = singleDocument;
        if (!singleDocument) {
            this.sa.addDocumentStart();
        }
    }

    @Override
    public void visitSource(String source, String debug) {
        AttributesImpl att = new AttributesImpl();
        if (source != null) {
            att.addAttribute("", "file", "file", "", SAXClassAdapter.encode(source));
        }
        if (debug != null) {
            att.addAttribute("", "debug", "debug", "", SAXClassAdapter.encode(debug));
        }
        this.sa.addElement("source", att);
    }

    @Override
    public ModuleVisitor visitModule(String name2, int access, String version) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "name", "name", "", name2);
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x200000, sb);
        att.addAttribute("", "access", "access", "", sb.toString());
        if (version != null) {
            att.addAttribute("", "version", "version", "", SAXClassAdapter.encode(version));
        }
        this.sa.addStart("module", att);
        return new SAXModuleAdapter(this.sa);
    }

    @Override
    public void visitOuterClass(String owner, String name2, String desc) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "owner", "owner", "", owner);
        if (name2 != null) {
            att.addAttribute("", "name", "name", "", name2);
        }
        if (desc != null) {
            att.addAttribute("", "desc", "desc", "", desc);
        }
        this.sa.addElement("outerclass", att);
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
    public void visit(int version, int access, String name2, String signature2, String superName, String[] interfaces) {
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x40000, sb);
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "access", "access", "", sb.toString());
        if (name2 != null) {
            att.addAttribute("", "name", "name", "", name2);
        }
        if (signature2 != null) {
            att.addAttribute("", "signature", "signature", "", SAXClassAdapter.encode(signature2));
        }
        if (superName != null) {
            att.addAttribute("", "parent", "parent", "", superName);
        }
        att.addAttribute("", "major", "major", "", Integer.toString(version & 0xFFFF));
        att.addAttribute("", "minor", "minor", "", Integer.toString(version >>> 16));
        this.sa.addStart("class", att);
        this.sa.addStart("interfaces", new AttributesImpl());
        if (interfaces != null && interfaces.length > 0) {
            for (int i = 0; i < interfaces.length; ++i) {
                AttributesImpl att2 = new AttributesImpl();
                att2.addAttribute("", "name", "name", "", interfaces[i]);
                this.sa.addElement("interface", att2);
            }
        }
        this.sa.addEnd("interfaces");
    }

    @Override
    public FieldVisitor visitField(int access, String name2, String desc, String signature2, Object value) {
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x80000, sb);
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "access", "access", "", sb.toString());
        att.addAttribute("", "name", "name", "", name2);
        att.addAttribute("", "desc", "desc", "", desc);
        if (signature2 != null) {
            att.addAttribute("", "signature", "signature", "", SAXClassAdapter.encode(signature2));
        }
        if (value != null) {
            att.addAttribute("", "value", "value", "", SAXClassAdapter.encode(value.toString()));
        }
        return new SAXFieldAdapter(this.sa, att);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name2, String desc, String signature2, String[] exceptions) {
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access, sb);
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "access", "access", "", sb.toString());
        att.addAttribute("", "name", "name", "", name2);
        att.addAttribute("", "desc", "desc", "", desc);
        if (signature2 != null) {
            att.addAttribute("", "signature", "signature", "", signature2);
        }
        this.sa.addStart("method", att);
        this.sa.addStart("exceptions", new AttributesImpl());
        if (exceptions != null && exceptions.length > 0) {
            for (int i = 0; i < exceptions.length; ++i) {
                AttributesImpl att2 = new AttributesImpl();
                att2.addAttribute("", "name", "name", "", exceptions[i]);
                this.sa.addElement("exception", att2);
            }
        }
        this.sa.addEnd("exceptions");
        return new SAXCodeAdapter(this.sa, access);
    }

    @Override
    public final void visitInnerClass(String name2, String outerName, String innerName, int access) {
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x100000, sb);
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "access", "access", "", sb.toString());
        if (name2 != null) {
            att.addAttribute("", "name", "name", "", name2);
        }
        if (outerName != null) {
            att.addAttribute("", "outerName", "outerName", "", outerName);
        }
        if (innerName != null) {
            att.addAttribute("", "innerName", "innerName", "", innerName);
        }
        this.sa.addElement("innerclass", att);
    }

    @Override
    public final void visitEnd() {
        this.sa.addEnd("class");
        if (!this.singleDocument) {
            this.sa.addDocumentEnd();
        }
    }

    static final String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '\\') {
                sb.append("\\\\");
                continue;
            }
            if (c < ' ' || c > '\u007f') {
                sb.append("\\u");
                if (c < '\u0010') {
                    sb.append("000");
                } else if (c < '\u0100') {
                    sb.append("00");
                } else if (c < '\u1000') {
                    sb.append('0');
                }
                sb.append(Integer.toString(c, 16));
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    static void appendAccess(int access, StringBuilder sb) {
        if ((access & 1) != 0) {
            sb.append("public ");
        }
        if ((access & 2) != 0) {
            sb.append("private ");
        }
        if ((access & 4) != 0) {
            sb.append("protected ");
        }
        if ((access & 0x10) != 0) {
            if ((access & 0x200000) == 0) {
                sb.append("final ");
            } else {
                sb.append("transitive ");
            }
        }
        if ((access & 8) != 0) {
            sb.append("static ");
        }
        if ((access & 0x20) != 0) {
            if ((access & 0x40000) == 0) {
                if ((access & 0x400000) != 0) {
                    sb.append("transitive ");
                } else if ((access & 0x200000) == 0) {
                    sb.append("synchronized ");
                } else {
                    sb.append("open ");
                }
            } else {
                sb.append("super ");
            }
        }
        if ((access & 0x40) != 0) {
            if ((access & 0x80000) == 0) {
                sb.append("bridge ");
            } else if ((access & 0x400000) == 0) {
                sb.append("volatile ");
            } else {
                sb.append("static ");
            }
        }
        if ((access & 0x80) != 0) {
            if ((access & 0x80000) == 0) {
                sb.append("varargs ");
            } else {
                sb.append("transient ");
            }
        }
        if ((access & 0x100) != 0) {
            sb.append("native ");
        }
        if ((access & 0x800) != 0) {
            sb.append("strict ");
        }
        if ((access & 0x200) != 0) {
            sb.append("interface ");
        }
        if ((access & 0x400) != 0) {
            sb.append("abstract ");
        }
        if ((access & 0x1000) != 0) {
            sb.append("synthetic ");
        }
        if ((access & 0x2000) != 0) {
            sb.append("annotation ");
        }
        if ((access & 0x4000) != 0) {
            sb.append("enum ");
        }
        if ((access & 0x20000) != 0) {
            sb.append("deprecated ");
        }
        if ((access & 0x8000) != 0) {
            if ((access & 0x40000) == 0) {
                sb.append("module ");
            } else {
                sb.append("mandated ");
            }
        }
    }
}

