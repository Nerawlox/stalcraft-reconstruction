/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import cpw.mods.fml.common.discovery.asm.ASMModParser;
import cpw.mods.fml.common.discovery.asm.ModAnnotationVisitor;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

public class ModMethodVisitor
extends MethodVisitor {
    private String methodName;
    private String methodDescriptor;
    private ASMModParser discoverer;

    public ModMethodVisitor(String string, String string2, ASMModParser aSMModParser) {
        super(393216);
        this.methodName = string;
        this.methodDescriptor = string2;
        this.discoverer = aSMModParser;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String string, boolean bl) {
        this.discoverer.startMethodAnnotation(this.methodName, this.methodDescriptor, string);
        return new ModAnnotationVisitor(this.discoverer);
    }
}

