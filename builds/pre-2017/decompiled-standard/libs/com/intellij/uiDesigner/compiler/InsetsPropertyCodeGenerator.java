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
import java.awt.Insets;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class InsetsPropertyCodeGenerator
extends PropertyCodeGenerator {
    private final Type myInsetsType = Type.getType((Class)Insets.class);

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        Insets insets = (Insets)value;
        generator.newInstance(this.myInsetsType);
        generator.dup();
        generator.push(insets.top);
        generator.push(insets.left);
        generator.push(insets.bottom);
        generator.push(insets.right);
        generator.invokeConstructor(this.myInsetsType, Method.getMethod((String)"void <init>(int,int,int,int)"));
    }
}

