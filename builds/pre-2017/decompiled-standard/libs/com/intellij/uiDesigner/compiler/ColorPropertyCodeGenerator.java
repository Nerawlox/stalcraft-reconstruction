/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.PropertyCodeGenerator;
import com.intellij.uiDesigner.lw.ColorDescriptor;
import java.awt.Color;
import java.awt.SystemColor;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class ColorPropertyCodeGenerator
extends PropertyCodeGenerator {
    private static final Type ourColorType = Type.getType((Class)Color.class);
    private static final Type ourObjectType = Type.getType((Class)Object.class);
    private static final Type ourUIManagerType = Type.getType((String)"Ljavax/swing/UIManager;");
    private static final Type ourSystemColorType = Type.getType((Class)SystemColor.class);
    private static final Method ourInitMethod = Method.getMethod((String)"void <init>(int)");
    private static final Method ourGetColorMethod = new Method("getColor", ourColorType, new Type[]{ourObjectType});

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        ColorDescriptor descriptor2 = (ColorDescriptor)value;
        if (descriptor2.getColor() != null) {
            generator.newInstance(ourColorType);
            generator.dup();
            generator.push(descriptor2.getColor().getRGB());
            generator.invokeConstructor(ourColorType, ourInitMethod);
        } else if (descriptor2.getSwingColor() != null) {
            generator.push(descriptor2.getSwingColor());
            generator.invokeStatic(ourUIManagerType, ourGetColorMethod);
        } else if (descriptor2.getSystemColor() != null) {
            generator.getStatic(ourSystemColorType, descriptor2.getSystemColor(), ourSystemColorType);
        } else if (descriptor2.getAWTColor() != null) {
            generator.getStatic(ourColorType, descriptor2.getAWTColor(), ourColorType);
        } else if (descriptor2.isColorSet()) {
            throw new IllegalStateException("Unknown color type");
        }
    }
}

