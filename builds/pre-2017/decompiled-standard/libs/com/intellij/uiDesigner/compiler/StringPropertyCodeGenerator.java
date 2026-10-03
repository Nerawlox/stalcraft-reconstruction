/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.intellij.compiler.instrumentation.InstrumentationClassFinder
 *  com.intellij.compiler.instrumentation.InstrumentationClassFinder$PseudoClass
 *  org.jetbrains.org.objectweb.asm.Label
 *  org.jetbrains.org.objectweb.asm.MethodVisitor
 *  org.jetbrains.org.objectweb.asm.Opcodes
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.compiler.instrumentation.InstrumentationClassFinder;
import com.intellij.uiDesigner.compiler.AsmCodeGenerator;
import com.intellij.uiDesigner.compiler.PropertyCodeGenerator;
import com.intellij.uiDesigner.core.SupportCode;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.StringDescriptor;
import java.io.IOException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import org.jetbrains.org.objectweb.asm.Label;
import org.jetbrains.org.objectweb.asm.MethodVisitor;
import org.jetbrains.org.objectweb.asm.Opcodes;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class StringPropertyCodeGenerator
extends PropertyCodeGenerator
implements Opcodes {
    private static final Type myResourceBundleType = Type.getType((Class)ResourceBundle.class);
    private final Method myGetBundleMethod = Method.getMethod((String)"java.util.ResourceBundle getBundle(java.lang.String)");
    private final Method myGetStringMethod = Method.getMethod((String)"java.lang.String getString(java.lang.String)");
    private static final Method myLoadLabelTextMethod = new Method("$$$loadLabelText$$$", Type.VOID_TYPE, new Type[]{Type.getType((Class)JLabel.class), Type.getType((Class)String.class)});
    private static final Method myLoadButtonTextMethod = new Method("$$$loadButtonText$$$", Type.VOID_TYPE, new Type[]{Type.getType((Class)AbstractButton.class), Type.getType((Class)String.class)});
    private final Set myClassesRequiringLoadLabelText = new HashSet();
    private final Set myClassesRequiringLoadButtonText = new HashSet();
    private boolean myHaveSetDisplayedMnemonicIndex = false;

    public void generateClassStart(AsmCodeGenerator.FormClassVisitor visitor2, String name2, InstrumentationClassFinder classFinder) {
        this.myClassesRequiringLoadLabelText.remove(name2);
        this.myClassesRequiringLoadButtonText.remove(name2);
        try {
            InstrumentationClassFinder.PseudoClass pseudo = classFinder.loadClass(AbstractButton.class.getName());
            if (!pseudo.findMethods("getDisplayedMnemonicIndex").isEmpty()) {
                this.myHaveSetDisplayedMnemonicIndex = true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public boolean generateCustomSetValue(LwComponent lwComponent, InstrumentationClassFinder.PseudoClass componentClass, LwIntrospectedProperty property, GeneratorAdapter generator, int componentLocal, String formClassName) throws IOException, ClassNotFoundException {
        InstrumentationClassFinder.PseudoClass abstractButtonClass = componentClass.getFinder().loadClass(AbstractButton.class.getName());
        InstrumentationClassFinder.PseudoClass jLabelClass = componentClass.getFinder().loadClass(JLabel.class.getName());
        if ("text".equals(property.getName()) && (abstractButtonClass.isAssignableFrom(componentClass) || jLabelClass.isAssignableFrom(componentClass))) {
            StringDescriptor propertyValue = (StringDescriptor)lwComponent.getPropertyValue(property);
            if (propertyValue.getValue() != null) {
                SupportCode.TextWithMnemonic textWithMnemonic = SupportCode.parseText(propertyValue.getValue());
                if (textWithMnemonic.myMnemonicIndex >= 0) {
                    generator.loadLocal(componentLocal);
                    generator.push(textWithMnemonic.myText);
                    generator.invokeVirtual(Type.getType((String)componentClass.getDescriptor()), new Method(property.getWriteMethodName(), Type.VOID_TYPE, new Type[]{Type.getType((Class)String.class)}));
                    String setMnemonicMethodName = abstractButtonClass.isAssignableFrom(componentClass) ? "setMnemonic" : "setDisplayedMnemonic";
                    generator.loadLocal(componentLocal);
                    generator.push((int)textWithMnemonic.getMnemonicChar());
                    generator.invokeVirtual(Type.getType((String)componentClass.getDescriptor()), new Method(setMnemonicMethodName, Type.VOID_TYPE, new Type[]{Type.CHAR_TYPE}));
                    if (this.myHaveSetDisplayedMnemonicIndex) {
                        generator.loadLocal(componentLocal);
                        generator.push(textWithMnemonic.myMnemonicIndex);
                        generator.invokeVirtual(Type.getType((String)componentClass.getDescriptor()), new Method("setDisplayedMnemonicIndex", Type.VOID_TYPE, new Type[]{Type.INT_TYPE}));
                    }
                    return true;
                }
            } else {
                Method method;
                if (abstractButtonClass.isAssignableFrom(componentClass)) {
                    this.myClassesRequiringLoadButtonText.add(formClassName);
                    method = myLoadButtonTextMethod;
                } else {
                    this.myClassesRequiringLoadLabelText.add(formClassName);
                    method = myLoadLabelTextMethod;
                }
                generator.loadThis();
                generator.loadLocal(componentLocal);
                generator.push(propertyValue.getBundleName());
                generator.invokeStatic(myResourceBundleType, this.myGetBundleMethod);
                generator.push(propertyValue.getKey());
                generator.invokeVirtual(myResourceBundleType, this.myGetStringMethod);
                generator.invokeVirtual(Type.getType((String)("L" + formClassName + ";")), method);
                return true;
            }
        }
        return false;
    }

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        StringDescriptor descriptor2 = (StringDescriptor)value;
        if (descriptor2 == null) {
            generator.push((String)null);
        } else if (descriptor2.getValue() != null) {
            generator.push(descriptor2.getValue());
        } else {
            generator.push(descriptor2.getBundleName());
            generator.invokeStatic(myResourceBundleType, this.myGetBundleMethod);
            generator.push(descriptor2.getKey());
            generator.invokeVirtual(myResourceBundleType, this.myGetStringMethod);
        }
    }

    public void generateClassEnd(AsmCodeGenerator.FormClassVisitor visitor2) {
        if (this.myClassesRequiringLoadLabelText.contains(visitor2.getClassName())) {
            this.generateLoadTextMethod(visitor2, "$$$loadLabelText$$$", "javax/swing/JLabel", "setDisplayedMnemonic");
            this.myClassesRequiringLoadLabelText.remove(visitor2.getClassName());
        }
        if (this.myClassesRequiringLoadButtonText.contains(visitor2.getClassName())) {
            this.generateLoadTextMethod(visitor2, "$$$loadButtonText$$$", "javax/swing/AbstractButton", "setMnemonic");
            this.myClassesRequiringLoadButtonText.remove(visitor2.getClassName());
        }
    }

    private void generateLoadTextMethod(AsmCodeGenerator.FormClassVisitor visitor2, String methodName, String componentClass, String setMnemonicMethodName) {
        MethodVisitor mv = visitor2.visitNewMethod(4098, methodName, "(L" + componentClass + ";Ljava/lang/String;)V", null, null);
        mv.visitCode();
        mv.visitTypeInsn(187, "java/lang/StringBuffer");
        mv.visitInsn(89);
        mv.visitMethodInsn(183, "java/lang/StringBuffer", "<init>", "()V", false);
        mv.visitVarInsn(58, 3);
        mv.visitInsn(3);
        mv.visitVarInsn(54, 4);
        mv.visitInsn(3);
        mv.visitVarInsn(54, 5);
        mv.visitInsn(2);
        mv.visitVarInsn(54, 6);
        mv.visitInsn(3);
        mv.visitVarInsn(54, 7);
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitVarInsn(21, 7);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, "java/lang/String", "length", "()I", false);
        Label l1 = new Label();
        mv.visitJumpInsn(162, l1);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(21, 7);
        mv.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C", false);
        mv.visitIntInsn(16, 38);
        Label l2 = new Label();
        mv.visitJumpInsn(160, l2);
        mv.visitIincInsn(7, 1);
        mv.visitVarInsn(21, 7);
        mv.visitVarInsn(25, 2);
        mv.visitMethodInsn(182, "java/lang/String", "length", "()I", false);
        Label l3 = new Label();
        mv.visitJumpInsn(160, l3);
        mv.visitJumpInsn(167, l1);
        mv.visitLabel(l3);
        mv.visitVarInsn(21, 4);
        mv.visitJumpInsn(154, l2);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(21, 7);
        mv.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C", false);
        mv.visitIntInsn(16, 38);
        mv.visitJumpInsn(159, l2);
        mv.visitInsn(4);
        mv.visitVarInsn(54, 4);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(21, 7);
        mv.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C", false);
        mv.visitVarInsn(54, 5);
        mv.visitVarInsn(25, 3);
        mv.visitMethodInsn(182, "java/lang/StringBuffer", "length", "()I", false);
        mv.visitVarInsn(54, 6);
        mv.visitLabel(l2);
        mv.visitVarInsn(25, 3);
        mv.visitVarInsn(25, 2);
        mv.visitVarInsn(21, 7);
        mv.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C", false);
        mv.visitMethodInsn(182, "java/lang/StringBuffer", "append", "(C)Ljava/lang/StringBuffer;", false);
        mv.visitInsn(87);
        mv.visitIincInsn(7, 1);
        mv.visitJumpInsn(167, l0);
        mv.visitLabel(l1);
        mv.visitVarInsn(25, 1);
        mv.visitVarInsn(25, 3);
        mv.visitMethodInsn(182, "java/lang/StringBuffer", "toString", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(182, componentClass, "setText", "(Ljava/lang/String;)V", false);
        mv.visitVarInsn(21, 4);
        Label l4 = new Label();
        mv.visitJumpInsn(153, l4);
        mv.visitVarInsn(25, 1);
        mv.visitVarInsn(21, 5);
        mv.visitMethodInsn(182, componentClass, setMnemonicMethodName, "(C)V", false);
        if (this.myHaveSetDisplayedMnemonicIndex) {
            mv.visitVarInsn(25, 1);
            mv.visitVarInsn(21, 6);
            mv.visitMethodInsn(182, componentClass, "setDisplayedMnemonicIndex", "(I)V", false);
        }
        mv.visitLabel(l4);
        mv.visitInsn(177);
        mv.visitMaxs(3, 8);
        mv.visitEnd();
    }
}

