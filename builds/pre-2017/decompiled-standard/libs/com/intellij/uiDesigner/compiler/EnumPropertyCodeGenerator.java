/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.PropertyCodeGenerator;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;

public class EnumPropertyCodeGenerator
extends PropertyCodeGenerator {
    public void generatePushValue(GeneratorAdapter generator, Object value) {
        Type enumType = Type.getType(value.getClass());
        generator.getStatic(enumType, value.toString(), enumType);
    }
}

