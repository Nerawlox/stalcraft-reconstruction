/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jgoodies.forms.layout.FormLayout
 *  com.jgoodies.forms.layout.FormSpec
 */
package com.intellij.uiDesigner.compiler;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpec;

public class FormLayoutUtils {
    private FormLayoutUtils() {
    }

    public static String getEncodedRowSpecs(FormLayout formLayout) {
        StringBuffer result2 = new StringBuffer();
        for (int i = 1; i <= formLayout.getRowCount(); ++i) {
            if (result2.length() > 0) {
                result2.append(",");
            }
            result2.append(FormLayoutUtils.getEncodedSpec((FormSpec)formLayout.getRowSpec(i)));
        }
        return result2.toString();
    }

    public static String getEncodedColumnSpecs(FormLayout formLayout) {
        StringBuffer result2 = new StringBuffer();
        for (int i = 1; i <= formLayout.getColumnCount(); ++i) {
            if (result2.length() > 0) {
                result2.append(",");
            }
            result2.append(FormLayoutUtils.getEncodedSpec((FormSpec)formLayout.getColumnSpec(i)));
        }
        return result2.toString();
    }

    public static String getEncodedSpec(FormSpec formSpec) {
        String result2 = formSpec.toString();
        while (true) {
            int pos;
            if ((pos = result2.indexOf("dluX")) < 0) {
                pos = result2.indexOf("dluY");
            }
            if (pos < 0) break;
            result2 = result2.substring(0, pos + 3) + result2.substring(pos + 4);
        }
        return result2;
    }
}

