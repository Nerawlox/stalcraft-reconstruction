/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jdom.Element
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.LwXmlReader;
import java.util.List;
import org.jdom.Element;

public class LwIntroListModelProperty
extends LwIntrospectedProperty {
    public LwIntroListModelProperty(String name2, String propertyClassName) {
        super(name2, propertyClassName);
    }

    public Object read(Element element) throws Exception {
        List list = element.getChildren("item", element.getNamespace());
        String[] result2 = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            Element itemElement = (Element)list.get(i);
            result2[i] = LwXmlReader.getRequiredString(itemElement, "value");
        }
        return result2;
    }
}

