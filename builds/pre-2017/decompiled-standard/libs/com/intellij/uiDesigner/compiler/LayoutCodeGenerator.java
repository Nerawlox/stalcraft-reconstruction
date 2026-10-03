/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.AsmCodeGenerator;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwContainer;
import java.awt.Container;
import java.awt.Dimension;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public abstract class LayoutCodeGenerator {
    protected static final Method ourSetLayoutMethod = Method.getMethod((String)"void setLayout(java.awt.LayoutManager)");
    protected static final Type ourContainerType = Type.getType((Class)Container.class);
    protected static final Method ourAddMethod = Method.getMethod((String)"void add(java.awt.Component,java.lang.Object)");
    protected static final Method ourAddNoConstraintMethod = Method.getMethod((String)"java.awt.Component add(java.awt.Component)");

    public void generateContainerLayout(LwContainer lwContainer, GeneratorAdapter generator, int componentLocal) {
    }

    public abstract void generateComponentLayout(LwComponent var1, GeneratorAdapter var2, int var3, int var4);

    protected static void newDimensionOrNull(GeneratorAdapter generator, Dimension dimension) {
        if (dimension.width == -1 && dimension.height == -1) {
            generator.visitInsn(1);
        } else {
            AsmCodeGenerator.pushPropValue(generator, "java.awt.Dimension", dimension);
        }
    }

    public String mapComponentClass(String componentClassName) {
        return componentClassName;
    }
}

