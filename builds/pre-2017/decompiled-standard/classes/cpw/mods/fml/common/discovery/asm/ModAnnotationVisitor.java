/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import cpw.mods.fml.common.discovery.asm.ASMModParser;
import org.objectweb.asm.AnnotationVisitor;

public class ModAnnotationVisitor
extends AnnotationVisitor {
    private ASMModParser discoverer;
    private boolean array;
    private String name;
    private boolean isSubAnnotation;

    public ModAnnotationVisitor(ASMModParser aSMModParser) {
        super(393216);
        this.discoverer = aSMModParser;
    }

    public ModAnnotationVisitor(ASMModParser aSMModParser, String string) {
        this(aSMModParser);
        this.array = true;
        this.name = string;
        aSMModParser.addAnnotationArray(string);
    }

    public ModAnnotationVisitor(ASMModParser aSMModParser, boolean bl) {
        this(aSMModParser);
        this.isSubAnnotation = true;
    }

    @Override
    public void visit(String string, Object object) {
        this.discoverer.addAnnotationProperty(string, object);
    }

    @Override
    public void visitEnum(String string, String string2, String string3) {
        this.discoverer.addAnnotationEnumProperty(string, string2, string3);
    }

    @Override
    public AnnotationVisitor visitArray(String string) {
        return new ModAnnotationVisitor(this.discoverer, string);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String string, String string2) {
        this.discoverer.addSubAnnotation(string, string2);
        return new ModAnnotationVisitor(this.discoverer, true);
    }

    @Override
    public void visitEnd() {
        if (this.array) {
            this.discoverer.endArray();
        }
        if (this.isSubAnnotation) {
            this.discoverer.endSubAnnotation();
        }
    }
}

