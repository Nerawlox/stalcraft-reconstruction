/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.intellij.compiler.instrumentation.InstrumentationClassFinder$PseudoClass
 *  org.jetbrains.org.objectweb.asm.Label
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.compiler.instrumentation.InstrumentationClassFinder;
import com.intellij.uiDesigner.compiler.AsmCodeGenerator;
import com.intellij.uiDesigner.compiler.PropertyCodeGenerator;
import com.intellij.uiDesigner.lw.FontDescriptor;
import com.intellij.uiDesigner.lw.LwComponent;
import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import java.awt.Font;
import org.jetbrains.org.objectweb.asm.Label;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class FontPropertyCodeGenerator
extends PropertyCodeGenerator {
    private static final Type ourFontType = Type.getType((Class)Font.class);
    private static final Type ourUIManagerType = Type.getType((String)"Ljavax/swing/UIManager;");
    private static final Type ourObjectType = Type.getType((Class)Object.class);
    private static final Type ourStringType = Type.getType((Class)String.class);
    private static final Method ourInitMethod = Method.getMethod((String)"void <init>(java.lang.String,int,int)");
    private static final Method ourUIManagerGetFontMethod = new Method("getFont", ourFontType, new Type[]{ourObjectType});
    private static final Method ourGetNameMethod = new Method("getName", ourStringType, new Type[0]);
    private static final Method ourGetSizeMethod = new Method("getSize", Type.INT_TYPE, new Type[0]);
    private static final Method ourGetStyleMethod = new Method("getStyle", Type.INT_TYPE, new Type[0]);

    public boolean generateCustomSetValue(LwComponent lwComponent, InstrumentationClassFinder.PseudoClass componentClass, LwIntrospectedProperty property, GeneratorAdapter generator, int componentLocal, String formClassName) {
        FontDescriptor descriptor2 = (FontDescriptor)property.getPropertyValue(lwComponent);
        if (descriptor2.isFixedFont() && !descriptor2.isFullyDefinedFont()) {
            Label fontNullLabel = generator.newLabel();
            FontPropertyCodeGenerator.generatePushFont(generator, componentLocal, lwComponent, descriptor2, property.getReadMethodName(), fontNullLabel);
            Method setFontMethod = new Method(property.getWriteMethodName(), Type.VOID_TYPE, new Type[]{ourFontType});
            Type componentType = AsmCodeGenerator.typeFromClassName(lwComponent.getComponentClassName());
            generator.invokeVirtual(componentType, setFontMethod);
            generator.mark(fontNullLabel);
            return true;
        }
        return false;
    }

    public static void generatePushFont(GeneratorAdapter generator, int componentLocal, LwComponent lwComponent, FontDescriptor descriptor2, String readMethodName, Label fontNullLabel) {
        int fontLocal = generator.newLocal(ourFontType);
        generator.loadLocal(componentLocal);
        Type componentType = AsmCodeGenerator.typeFromClassName(lwComponent.getComponentClassName());
        Method getFontMethod = new Method(readMethodName, ourFontType, new Type[0]);
        generator.invokeVirtual(componentType, getFontMethod);
        generator.storeLocal(fontLocal);
        if (fontNullLabel != null) {
            generator.loadLocal(fontLocal);
            generator.ifNull(fontNullLabel);
            generator.loadLocal(componentLocal);
        }
        generator.newInstance(ourFontType);
        generator.dup();
        if (descriptor2.getFontName() != null) {
            generator.push(descriptor2.getFontName());
        } else {
            generator.loadLocal(fontLocal);
            generator.invokeVirtual(ourFontType, ourGetNameMethod);
        }
        if (descriptor2.getFontStyle() >= 0) {
            generator.push(descriptor2.getFontStyle());
        } else {
            generator.loadLocal(fontLocal);
            generator.invokeVirtual(ourFontType, ourGetStyleMethod);
        }
        if (descriptor2.getFontSize() >= 0) {
            generator.push(descriptor2.getFontSize());
        } else {
            generator.loadLocal(fontLocal);
            generator.invokeVirtual(ourFontType, ourGetSizeMethod);
        }
        generator.invokeConstructor(ourFontType, ourInitMethod);
    }

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        FontDescriptor descriptor2 = (FontDescriptor)value;
        if (descriptor2.isFixedFont()) {
            if (!descriptor2.isFullyDefinedFont()) {
                throw new IllegalStateException("Unexpected font state");
            }
            generator.newInstance(ourFontType);
            generator.dup();
            generator.push(descriptor2.getFontName());
            generator.push(descriptor2.getFontStyle());
            generator.push(descriptor2.getFontSize());
            generator.invokeConstructor(ourFontType, ourInitMethod);
        } else if (descriptor2.getSwingFont() != null) {
            generator.push(descriptor2.getSwingFont());
            generator.invokeStatic(ourUIManagerType, ourUIManagerGetFontMethod);
        } else {
            throw new IllegalStateException("Unknown font type");
        }
    }
}

