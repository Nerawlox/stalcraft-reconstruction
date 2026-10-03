/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Element
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.LwXmlReader;
import com.intellij.uiDesigner.lw.StringDescriptor;
import org.jdom.Element;

public final class LwRbIntroStringProperty
extends LwIntrospectedProperty {
    public LwRbIntroStringProperty(String name2) {
        super(name2, String.class.getName());
    }

    public Object read(Element element) throws Exception {
        StringDescriptor descriptor2 = LwXmlReader.getStringDescriptor(element, "value", "resource-bundle", "key");
        if (descriptor2 == null) {
            throw new IllegalArgumentException("String descriptor value required");
        }
        return descriptor2;
    }
}

