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
import com.intellij.uiDesigner.lw.LwContainer;
import java.awt.FlowLayout;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class FlowLayoutCodeGenerator
extends LayoutCodeGenerator {
    private static final Type ourFlowLayoutType = Type.getType((Class)FlowLayout.class);
    private static final Method ourConstructor = Method.getMethod((String)"void <init>(int,int,int)");

    public void generateContainerLayout(LwContainer lwContainer, GeneratorAdapter generator, int componentLocal) {
        generator.loadLocal(componentLocal);
        FlowLayout flowLayout = (FlowLayout)lwContainer.getLayout();
        generator.newInstance(ourFlowLayoutType);
        generator.dup();
        generator.push(flowLayout.getAlignment());
        generator.push(flowLayout.getHgap());
        generator.push(flowLayout.getVgap());
        generator.invokeConstructor(ourFlowLayoutType, ourConstructor);
        generator.invokeVirtual(ourContainerType, ourSetLayoutMethod);
    }

    public void generateComponentLayout(LwComponent lwComponent, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        generator.loadLocal(parentLocal);
        generator.loadLocal(componentLocal);
        generator.invokeVirtual(ourContainerType, ourAddNoConstraintMethod);
    }
}

