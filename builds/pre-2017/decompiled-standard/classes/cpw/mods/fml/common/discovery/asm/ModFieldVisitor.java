/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import cpw.mods.fml.common.discovery.asm.ASMModParser;
import cpw.mods.fml.common.discovery.asm.ModAnnotationVisitor;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;

public class ModFieldVisitor
extends FieldVisitor {
    private String fieldName;
    private ASMModParser discoverer;

    public ModFieldVisitor(String string, ASMModParser aSMModParser) {
        super(393216);
        this.fieldName = string;
        this.discoverer = aSMModParser;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String string, boolean bl) {
        this.discoverer.startFieldAnnotation(this.fieldName, string);
        return new ModAnnotationVisitor(this.discoverer);
    }
}

