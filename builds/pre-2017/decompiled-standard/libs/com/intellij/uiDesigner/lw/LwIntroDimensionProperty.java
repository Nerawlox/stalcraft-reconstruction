/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Element
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.LwXmlReader;
import java.awt.Dimension;
import org.jdom.Element;

public final class LwIntroDimensionProperty
extends LwIntrospectedProperty {
    public LwIntroDimensionProperty(String name2) {
        super(name2, "java.awt.Dimension");
    }

    public Object read(Element element) throws Exception {
        int width = LwXmlReader.getRequiredInt(element, "width");
        int height = LwXmlReader.getRequiredInt(element, "height");
        return new Dimension(width, height);
    }
}

