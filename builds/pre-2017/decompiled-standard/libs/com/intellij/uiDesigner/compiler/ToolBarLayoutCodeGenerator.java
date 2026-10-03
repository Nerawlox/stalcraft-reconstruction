/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.LayoutCodeGenerator;
import com.intellij.uiDesigner.lw.LwComponent;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class ToolBarLayoutCodeGenerator
extends LayoutCodeGenerator {
    private static final Method ourAddMethod = Method.getMethod((String)"java.awt.Component add(java.awt.Component)");

    public void generateComponentLayout(LwComponent lwComponent, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        generator.loadLocal(parentLocal);
        generator.loadLocal(componentLocal);
        generator.invokeVirtual(ourContainerType, ourAddMethod);
    }
}

