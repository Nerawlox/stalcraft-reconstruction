/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.LayoutCodeGenerator;
import com.intellij.uiDesigner.lw.LwComponent;
import javax.swing.JSplitPane;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class SplitPaneLayoutCodeGenerator
extends LayoutCodeGenerator {
    private final Type mySplitPaneType = Type.getType((Class)JSplitPane.class);
    private final Method mySetLeftMethod = Method.getMethod((String)"void setLeftComponent(java.awt.Component)");
    private final Method mySetRightMethod = Method.getMethod((String)"void setRightComponent(java.awt.Component)");

    public void generateComponentLayout(LwComponent lwComponent, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        generator.loadLocal(parentLocal);
        generator.loadLocal(componentLocal);
        if ("left".equals(lwComponent.getCustomLayoutConstraints())) {
            generator.invokeVirtual(this.mySplitPaneType, this.mySetLeftMethod);
        } else {
            generator.invokeVirtual(this.mySplitPaneType, this.mySetRightMethod);
        }
    }
}

