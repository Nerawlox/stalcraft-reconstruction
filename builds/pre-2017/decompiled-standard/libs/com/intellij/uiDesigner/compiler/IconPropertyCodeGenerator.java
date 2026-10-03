/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.org.objectweb.asm.Type
 *  org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter
 *  org.jetbrains.org.objectweb.asm.commons.Method
 */
package com.intellij.uiDesigner.compiler;

import com.intellij.uiDesigner.compiler.PropertyCodeGenerator;
import com.intellij.uiDesigner.lw.IconDescriptor;
import javax.swing.ImageIcon;
import org.jetbrains.org.objectweb.asm.Type;
import org.jetbrains.org.objectweb.asm.commons.GeneratorAdapter;
import org.jetbrains.org.objectweb.asm.commons.Method;

public class IconPropertyCodeGenerator
extends PropertyCodeGenerator {
    private static final Type ourImageIconType = Type.getType((Class)ImageIcon.class);
    private static final Method ourInitMethod = Method.getMethod((String)"void <init>(java.net.URL)");
    private static final Method ourGetResourceMethod = Method.getMethod((String)"java.net.URL getResource(java.lang.String)");
    private static final Method ourGetClassMethod = new Method("getClass", "()Ljava/lang/Class;");
    private static final Type ourObjectType = Type.getType((Class)Object.class);
    private static final Type ourClassType = Type.getType((Class)Class.class);

    public void generatePushValue(GeneratorAdapter generator, Object value) {
        IconDescriptor descriptor2 = (IconDescriptor)value;
        generator.newInstance(ourImageIconType);
        generator.dup();
        generator.loadThis();
        generator.invokeVirtual(ourObjectType, ourGetClassMethod);
        generator.push("/" + descriptor2.getIconPath());
        generator.invokeVirtual(ourClassType, ourGetResourceMethod);
        generator.invokeConstructor(ourImageIconType, ourInitMethod);
    }
}

