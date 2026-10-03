/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.xml.SAXAdapter;
import org.objectweb.asm.xml.SAXClassAdapter;
import org.xml.sax.helpers.AttributesImpl;

public final class SAXModuleAdapter
extends ModuleVisitor {
    private final SAXAdapter sa;

    public SAXModuleAdapter(SAXAdapter sa) {
        super(393216);
        this.sa = sa;
    }

    @Override
    public void visitMainClass(String mainClass) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "name", "name", "", mainClass);
        this.sa.addElement("main-class", att);
    }

    @Override
    public void visitPackage(String packaze) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "name", "name", "", packaze);
        this.sa.addElement("packages", att);
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        AttributesImpl att = new AttributesImpl();
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x200000, sb);
        att.addAttribute("", "module", "module", "", module);
        att.addAttribute("", "access", "access", "", sb.toString());
        if (version != null) {
            att.addAttribute("", "access", "access", "", version);
        }
        this.sa.addElement("requires", att);
    }

    @Override
    public void visitExport(String packaze, int access, String ... modules) {
        AttributesImpl att = new AttributesImpl();
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x200000, sb);
        att.addAttribute("", "name", "name", "", packaze);
        att.addAttribute("", "access", "access", "", sb.toString());
        this.sa.addStart("exports", att);
        if (modules != null && modules.length > 0) {
            for (String to : modules) {
                AttributesImpl atts = new AttributesImpl();
                atts.addAttribute("", "module", "module", "", to);
                this.sa.addElement("to", atts);
            }
        }
        this.sa.addEnd("exports");
    }

    @Override
    public void visitOpen(String packaze, int access, String ... modules) {
        AttributesImpl att = new AttributesImpl();
        StringBuilder sb = new StringBuilder();
        SAXClassAdapter.appendAccess(access | 0x200000, sb);
        att.addAttribute("", "name", "name", "", packaze);
        att.addAttribute("", "access", "access", "", sb.toString());
        this.sa.addStart("opens", att);
        if (modules != null && modules.length > 0) {
            for (String to : modules) {
                AttributesImpl atts = new AttributesImpl();
                atts.addAttribute("", "module", "module", "", to);
                this.sa.addElement("to", atts);
            }
        }
        this.sa.addEnd("opens");
    }

    @Override
    public void visitUse(String service) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "service", "service", "", service);
        this.sa.addElement("uses", att);
    }

    @Override
    public void visitProvide(String service, String ... providers) {
        AttributesImpl att = new AttributesImpl();
        att.addAttribute("", "service", "service", "", service);
        this.sa.addStart("provides", att);
        for (String provider : providers) {
            AttributesImpl atts = new AttributesImpl();
            atts.addAttribute("", "provider", "provider", "", provider);
            this.sa.addElement("with", atts);
        }
        this.sa.addEnd("provides");
    }

    @Override
    public void visitEnd() {
        this.sa.addEnd("module");
    }
}

