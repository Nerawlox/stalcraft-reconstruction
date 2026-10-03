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
import java.awt.Rectangle;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class RectanglePropertyCodeGenerator
extends PropertyCodeGenerator {
    private static final Type myRectangleType = Type.getType((Class)Rectangle.class);
    private static final Method myInitMethod = Method.getMethod((String)"void <init>(int,int,int,int)");

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        Rectangle rc = (Rectangle)value;
        generator.newInstance(myRectangleType);
        generator.dup();
        generator.push(rc.x);
        generator.push(rc.y);
        generator.push(rc.width);
        generator.push(rc.height);
        generator.invokeConstructor(myRectangleType, myInitMethod);
    }
}

