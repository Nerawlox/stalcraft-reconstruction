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

public final class LwIntroInsetsProperty
extends LwIntrospectedProperty {
    public LwIntroInsetsProperty(String name2) {
        super(name2, "java.awt.Insets");
    }

    public Object read(Element element) throws Exception {
        return LwXmlReader.readInsets(element);
    }
}

