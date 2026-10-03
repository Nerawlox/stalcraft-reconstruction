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

public final class LwIntroCharProperty
extends LwIntrospectedProperty {
    public LwIntroCharProperty(String name2) {
        super(name2, Character.class.getName());
    }

    public Object read(Element element) throws Exception {
        return Character.valueOf(LwXmlReader.getRequiredString(element, "value").charAt(0));
    }
}

