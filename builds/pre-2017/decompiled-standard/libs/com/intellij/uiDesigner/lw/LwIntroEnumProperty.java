/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Element
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import java.lang.reflect.Method;
import org.jdom.Element;

public class LwIntroEnumProperty
extends LwIntrospectedProperty {
    private final Class myEnumClass;

    public LwIntroEnumProperty(String name2, Class enumClass) {
        super(name2, enumClass.getName());
        this.myEnumClass = enumClass;
    }

    public Object read(Element element) throws Exception {
        String value = element.getAttributeValue("value");
        Method method = this.myEnumClass.getMethod("valueOf", String.class);
        return method.invoke(null, value);
    }

    public String getCodeGenPropertyClassName() {
        return "java.lang.Enum";
    }
}

