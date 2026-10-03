/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import cpw.mods.fml.common.discovery.asm.ASMModParser;
import cpw.mods.fml.common.discovery.asm.ModAnnotationVisitor;
import cpw.mods.fml.common.discovery.asm.ModFieldVisitor;
import cpw.mods.fml.common.discovery.asm.ModLoaderPropertiesMethodVisitor;
import cpw.mods.fml.common.discovery.asm.ModMethodVisitor;
import java.util.Collections;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ModClassVisitor
extends ClassVisitor {
    private ASMModParser discoverer;

    public ModClassVisitor(ASMModParser aSMModParser) {
        super(393216);
        this.discoverer = aSMModParser;
    }

    @Override
    public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
        this.discoverer.beginNewTypeName(string, n, string3);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String string, boolean bl) {
        this.discoverer.startClassAnnotation(string);
        return new ModAnnotationVisitor(this.discoverer);
    }

    @Override
    public FieldVisitor visitField(int n, String string, String string2, String string3, Object object) {
        return new ModFieldVisitor(string, this.discoverer);
    }

    @Override
    public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
        if (this.discoverer.isBaseMod(Collections.<String>emptyList()) && string.equals("getPriorities") && string2.equals(Type.getMethodDescriptor(Type.getType(String.class), new Type[0]))) {
            return new ModLoaderPropertiesMethodVisitor(string, this.discoverer);
        }
        return new ModMethodVisitor(string, string2, this.discoverer);
    }
}

