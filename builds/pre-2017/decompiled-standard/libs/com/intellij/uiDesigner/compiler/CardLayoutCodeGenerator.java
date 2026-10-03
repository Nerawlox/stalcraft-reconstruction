/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.SimpleLayoutCodeGenerator;
import com.intellij.uiDesigner.lw.LwComponent;
import java.awt.CardLayout;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class CardLayoutCodeGenerator
extends SimpleLayoutCodeGenerator {
    private static final Method ourGetLayoutMethod = Method.getMethod((String)"java.awt.LayoutManager getLayout()");
    private static final Method ourShowMethod = Method.getMethod((String)"void show(java.awt.Container,java.lang.String)");

    public CardLayoutCodeGenerator() {
        super(Type.getType((Class)CardLayout.class));
    }

    public void generateComponentLayout(LwComponent lwComponent, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        super.generateComponentLayout(lwComponent, generator, componentLocal, parentLocal);
        String defaultCard = (String)lwComponent.getParent().getClientProperty("CardLayout");
        if (lwComponent.getId().equals(defaultCard)) {
            generator.loadLocal(parentLocal);
            generator.invokeVirtual(ourContainerType, ourGetLayoutMethod);
            generator.checkCast(this.myLayoutType);
            generator.loadLocal(parentLocal);
            generator.push((String)lwComponent.getCustomLayoutConstraints());
            generator.invokeVirtual(this.myLayoutType, ourShowMethod);
        }
    }
}

