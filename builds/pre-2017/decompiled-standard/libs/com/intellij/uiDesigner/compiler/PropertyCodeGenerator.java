/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.intellij.compiler.instrumentation.InstrumentationClassFinder
 *  com.intellij.compiler.instrumentation.InstrumentationClassFinder$PseudoClass
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.compiler.instrumentation.InstrumentationClassFinder;
import com.intellij.uiDesigner.compiler.AsmCodeGenerator;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import java.io.IOException;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;

public abstract class PropertyCodeGenerator {
    public abstract void generatePushValue(GeneratorAdapter var1, Object var2);

    public boolean generateCustomSetValue(LwComponent lwComponent, InstrumentationClassFinder.PseudoClass componentClass, LwIntrospectedProperty property, GeneratorAdapter generator, int componentLocal, String formClassName) throws IOException, ClassNotFoundException {
        return false;
    }

    public void generateClassStart(AsmCodeGenerator.FormClassVisitor visitor2, String name2, InstrumentationClassFinder classFinder) {
    }

    public void generateClassEnd(AsmCodeGenerator.FormClassVisitor visitor2) {
    }
}

