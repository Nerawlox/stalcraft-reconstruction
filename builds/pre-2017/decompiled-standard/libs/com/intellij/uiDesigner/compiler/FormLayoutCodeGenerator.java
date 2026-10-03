/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jgoodies.forms.layout.CellConstraints
 *  com.jgoodies.forms.layout.CellConstraints$Alignment
 *  com.jgoodies.forms.layout.FormLayout
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.AsmCodeGenerator;
import com.intellij.uiDesigner.compiler.FormLayoutUtils;
import com.intellij.uiDesigner.compiler.LayoutCodeGenerator;
import com.intellij.uiDesigner.compiler.Utils;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwContainer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Insets;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class FormLayoutCodeGenerator
extends LayoutCodeGenerator {
    private static final Type ourFormLayoutType = Type.getType((Class)FormLayout.class);
    private static final Type ourCellConstraintsType = Type.getType((Class)CellConstraints.class);
    private static final Type ourCellAlignmentType = Type.getType((Class)CellConstraints.Alignment.class);
    private static final Method ourFormLayoutConstructor = Method.getMethod((String)"void <init>(java.lang.String,java.lang.String)");
    private static final Method ourCellConstraintsConstructor = Method.getMethod((String)"void <init>(int,int,int,int,com.jgoodies.forms.layout.CellConstraints$Alignment,com.jgoodies.forms.layout.CellConstraints$Alignment,java.awt.Insets)");
    private static final Method ourSetRowGroupsMethod = Method.getMethod((String)"void setRowGroups(int[][])");
    private static final Method ourSetColumnGroupsMethod = Method.getMethod((String)"void setColumnGroups(int[][])");
    public static String[] HORZ_ALIGN_FIELDS = new String[]{"LEFT", "CENTER", "RIGHT", "FILL"};
    public static String[] VERT_ALIGN_FIELDS = new String[]{"TOP", "CENTER", "BOTTOM", "FILL"};

    public void generateContainerLayout(LwContainer lwContainer, GeneratorAdapter generator, int componentLocal) {
        FormLayout formLayout = (FormLayout)lwContainer.getLayout();
        generator.loadLocal(componentLocal);
        generator.newInstance(ourFormLayoutType);
        generator.dup();
        generator.push(FormLayoutUtils.getEncodedColumnSpecs(formLayout));
        generator.push(FormLayoutUtils.getEncodedRowSpecs(formLayout));
        generator.invokeConstructor(ourFormLayoutType, ourFormLayoutConstructor);
        FormLayoutCodeGenerator.generateGroups(generator, formLayout.getRowGroups(), ourSetRowGroupsMethod);
        FormLayoutCodeGenerator.generateGroups(generator, formLayout.getColumnGroups(), ourSetColumnGroupsMethod);
        generator.invokeVirtual(ourContainerType, ourSetLayoutMethod);
    }

    private static void generateGroups(GeneratorAdapter generator, int[][] groups2, Method setGroupsMethod) {
        if (groups2.length == 0) {
            return;
        }
        int groupLocal = generator.newLocal(Type.getType((String)"[I"));
        generator.dup();
        generator.push(groups2.length);
        generator.newArray(Type.getType((String)"[I"));
        for (int i = 0; i < groups2.length; ++i) {
            generator.dup();
            generator.push(groups2[i].length);
            generator.newArray(Type.INT_TYPE);
            generator.storeLocal(groupLocal);
            for (int j = 0; j < groups2[i].length; ++j) {
                generator.loadLocal(groupLocal);
                generator.push(j);
                generator.push(groups2[i][j]);
                generator.visitInsn(79);
            }
            generator.push(i);
            generator.loadLocal(groupLocal);
            generator.visitInsn(83);
        }
        generator.invokeVirtual(ourFormLayoutType, setGroupsMethod);
    }

    public void generateComponentLayout(LwComponent lwComponent, GeneratorAdapter generator, int componentLocal, int parentLocal) {
        generator.loadLocal(parentLocal);
        generator.loadLocal(componentLocal);
        FormLayoutCodeGenerator.addNewCellConstraints(generator, lwComponent);
        generator.invokeVirtual(ourContainerType, ourAddMethod);
    }

    private static void addNewCellConstraints(GeneratorAdapter generator, LwComponent lwComponent) {
        GridConstraints constraints = lwComponent.getConstraints();
        CellConstraints cc = (CellConstraints)lwComponent.getCustomLayoutConstraints();
        generator.newInstance(ourCellConstraintsType);
        generator.dup();
        generator.push(constraints.getColumn() + 1);
        generator.push(constraints.getRow() + 1);
        generator.push(constraints.getColSpan());
        generator.push(constraints.getRowSpan());
        if (cc.hAlign == CellConstraints.DEFAULT) {
            generator.getStatic(ourCellConstraintsType, "DEFAULT", ourCellAlignmentType);
        } else {
            int hAlign = Utils.alignFromConstraints(constraints, true);
            generator.getStatic(ourCellConstraintsType, HORZ_ALIGN_FIELDS[hAlign], ourCellAlignmentType);
        }
        if (cc.vAlign == CellConstraints.DEFAULT) {
            generator.getStatic(ourCellConstraintsType, "DEFAULT", ourCellAlignmentType);
        } else {
            int vAlign = Utils.alignFromConstraints(constraints, false);
            generator.getStatic(ourCellConstraintsType, VERT_ALIGN_FIELDS[vAlign], ourCellAlignmentType);
        }
        AsmCodeGenerator.pushPropValue(generator, Insets.class.getName(), cc.insets);
        generator.invokeConstructor(ourCellConstraintsType, ourCellConstraintsConstructor);
    }
}

