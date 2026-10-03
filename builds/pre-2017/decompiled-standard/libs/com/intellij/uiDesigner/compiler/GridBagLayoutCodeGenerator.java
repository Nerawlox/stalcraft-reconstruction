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
import com.intellij.uiDesigner.compiler.GridBagConverter;
import com.intellij.uiDesigner.compiler.LayoutCodeGenerator;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwContainer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class GridBagLayoutCodeGenerator
extends LayoutCodeGenerator {
    private static final Type ourGridBagLayoutType = Type.getType((Class)GridBagLayout.class);
    private static final Type ourGridBagConstraintsType = Type.getType((Class)GridBagConstraints.class);
    private static final Method ourDefaultConstructor = Method.getMethod((String)"void <init> ()");
    private static final Type myPanelType = Type.getType((Class)JPanel.class);

    public String mapComponentClass(String componentClassName) {
        if (componentClassName.equals(Spacer.class.getName())) {
            return JPanel.class.getName();
        }
        return super.mapComponentClass(componentClassName);
    }

    public void generateContainerLayout(LwContainer lwContainer, GeneratorAdapter generator, int componentLocal) {
        generator.loadLocal(componentLocal);
        generator.newInstance(ourGridBagLayoutType);
        generator.dup();
        generator.invokeConstructor(ourGridBagLayoutType, ourDefaultConstructor);
        generator.invokeVirtual(ourContainerType, ourSetLayoutMethod);
    }

    private void generateFillerPanel(GeneratorAdapter generator, int parentLocal, GridBagConverter.Result result2) {
        int panelLocal = generator.newLocal(myPanelType);
        generator.newInstance(myPanelType);
        generator.dup();
        generator.invokeConstructor(myPanelType, ourDefaultConstructor);
        generator.storeLocal(panelLocal);
        GridBagLayoutCodeGenerator.generateConversionResult(generator, result2, panelLocal, parentLocal);
    }

    public void generateComponentLayout(LwComponent component, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        GridBagConstraints gbc = component.getCustomLayoutConstraints() instanceof GridBagConstraints ? (GridBagConstraints)component.getCustomLayoutConstraints() : new GridBagConstraints();
        GridBagConverter.constraintsToGridBag(component.getConstraints(), gbc);
        GridBagLayoutCodeGenerator.generateGridBagConstraints(generator, gbc, componentLocal, parentLocal);
    }

    private static void generateConversionResult(GeneratorAdapter generator, GridBagConverter.Result result2, int componentLocal, int parentLocal) {
        GridBagLayoutCodeGenerator.checkSetSize(generator, componentLocal, "setMinimumSize", result2.minimumSize);
        GridBagLayoutCodeGenerator.checkSetSize(generator, componentLocal, "setPreferredSize", result2.preferredSize);
        GridBagLayoutCodeGenerator.checkSetSize(generator, componentLocal, "setMaximumSize", result2.maximumSize);
        GridBagLayoutCodeGenerator.generateGridBagConstraints(generator, result2.constraints, componentLocal, parentLocal);
    }

    private static void generateGridBagConstraints(GeneratorAdapter generator, GridBagConstraints constraints, int componentLocal, int parentLocal) {
        int gbcLocal = generator.newLocal(ourGridBagConstraintsType);
        generator.newInstance(ourGridBagConstraintsType);
        generator.dup();
        generator.invokeConstructor(ourGridBagConstraintsType, ourDefaultConstructor);
        generator.storeLocal(gbcLocal);
        GridBagConstraints defaults = new GridBagConstraints();
        if (defaults.gridx != constraints.gridx) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "gridx", constraints.gridx);
        }
        if (defaults.gridy != constraints.gridy) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "gridy", constraints.gridy);
        }
        if (defaults.gridwidth != constraints.gridwidth) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "gridwidth", constraints.gridwidth);
        }
        if (defaults.gridheight != constraints.gridheight) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "gridheight", constraints.gridheight);
        }
        if (defaults.weightx != constraints.weightx) {
            GridBagLayoutCodeGenerator.setDoubleField(generator, gbcLocal, "weightx", constraints.weightx);
        }
        if (defaults.weighty != constraints.weighty) {
            GridBagLayoutCodeGenerator.setDoubleField(generator, gbcLocal, "weighty", constraints.weighty);
        }
        if (defaults.anchor != constraints.anchor) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "anchor", constraints.anchor);
        }
        if (defaults.fill != constraints.fill) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "fill", constraints.fill);
        }
        if (defaults.ipadx != constraints.ipadx) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "ipadx", constraints.ipadx);
        }
        if (defaults.ipady != constraints.ipady) {
            GridBagLayoutCodeGenerator.setIntField(generator, gbcLocal, "ipady", constraints.ipady);
        }
        if (!defaults.insets.equals(constraints.insets)) {
            generator.loadLocal(gbcLocal);
            AsmCodeGenerator.pushPropValue(generator, Insets.class.getName(), constraints.insets);
            generator.putField(ourGridBagConstraintsType, "insets", Type.getType((Class)Insets.class));
        }
        generator.loadLocal(parentLocal);
        generator.loadLocal(componentLocal);
        generator.loadLocal(gbcLocal);
        generator.invokeVirtual(ourContainerType, ourAddMethod);
    }

    private static void checkSetSize(GeneratorAdapter generator, int componentLocal, String methodName, Dimension dimension) {
        if (dimension != null) {
            generator.loadLocal(componentLocal);
            AsmCodeGenerator.pushPropValue(generator, "java.awt.Dimension", dimension);
            generator.invokeVirtual(Type.getType((Class)Component.class), new Method(methodName, Type.VOID_TYPE, new Type[]{Type.getType((Class)Dimension.class)}));
        }
    }

    private static void setIntField(GeneratorAdapter generator, int local, String fieldName, int value) {
        generator.loadLocal(local);
        generator.push(value);
        generator.putField(ourGridBagConstraintsType, fieldName, Type.INT_TYPE);
    }

    private static void setDoubleField(GeneratorAdapter generator, int local, String fieldName, double value) {
        generator.loadLocal(local);
        generator.push(value);
        generator.putField(ourGridBagConstraintsType, fieldName, Type.DOUBLE_TYPE);
    }
}

