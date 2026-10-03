/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import java.util.LinkedList;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class ModLoaderPropertiesMethodVisitor
extends MethodVisitor {
    private ASMModParser discoverer;
    private boolean inCode;
    private LinkedList<Label> labels = Lists.newLinkedList();
    private String foundProperties;
    private boolean validProperties;

    public ModLoaderPropertiesMethodVisitor(String string, ASMModParser aSMModParser) {
        super(393216);
        this.discoverer = aSMModParser;
    }

    @Override
    public void visitCode() {
        this.labels.clear();
    }

    @Override
    public void visitLdcInsn(Object object) {
        if (object instanceof String && this.labels.size() == 1) {
            this.foundProperties = (String)object;
        }
    }

    @Override
    public void visitInsn(int n) {
        if (176 == n && this.labels.size() == 1 && this.foundProperties != null) {
            this.validProperties = true;
        }
    }

    @Override
    public void visitLabel(Label label) {
        this.labels.push(label);
    }

    @Override
    public void visitEnd() {
        if (this.validProperties) {
            this.discoverer.setBaseModProperties(this.foundProperties);
        }
    }
}

