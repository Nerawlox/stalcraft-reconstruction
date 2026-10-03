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
import java.awt.Dimension;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class DimensionPropertyCodeGenerator
extends PropertyCodeGenerator {
    private static final Type myDimensionType = Type.getType((Class)Dimension.class);
    private static final Method myInitMethod = Method.getMethod((String)"void <init>(int,int)");

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        Dimension dimension = (Dimension)value;
        generator.newInstance(myDimensionType);
        generator.dup();
        generator.push(dimension.width);
        generator.push(dimension.height);
        generator.invokeConstructor(myDimensionType, myInitMethod);
    }
}

