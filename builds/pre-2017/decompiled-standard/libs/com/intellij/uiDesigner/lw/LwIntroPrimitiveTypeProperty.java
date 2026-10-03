/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Element
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.LwXmlReader;
import org.jdom.Element;

public final class LwIntroPrimitiveTypeProperty
extends LwIntrospectedProperty {
    private final Class myValueClass;

    public LwIntroPrimitiveTypeProperty(String name2, Class valueClass) {
        super(name2, valueClass.getName());
        this.myValueClass = valueClass;
    }

    public Object read(Element element) throws Exception {
        return LwXmlReader.getRequiredPrimitiveTypeValue(element, "value", this.myValueClass);
    }
}

