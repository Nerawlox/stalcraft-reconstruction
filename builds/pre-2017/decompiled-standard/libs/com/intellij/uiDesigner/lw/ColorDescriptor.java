/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.lw;

import java.awt.Color;
import java.awt.SystemColor;
import java.lang.reflect.Field;
import javax.swing.UIManager;

public class ColorDescriptor {
    private final Color myColor;
    private String mySwingColor;
    private String mySystemColor;
    private String myAWTColor;

    public ColorDescriptor(Color color) {
        this.myColor = color;
    }

    public static ColorDescriptor fromSwingColor(String swingColor) {
        ColorDescriptor result2 = new ColorDescriptor(null);
        result2.mySwingColor = swingColor;
        return result2;
    }

    public static ColorDescriptor fromSystemColor(String systemColor) {
        ColorDescriptor result2 = new ColorDescriptor(null);
        result2.mySystemColor = systemColor;
        return result2;
    }

    public static ColorDescriptor fromAWTColor(String awtColor) {
        ColorDescriptor result2 = new ColorDescriptor(null);
        result2.myAWTColor = awtColor;
        return result2;
    }

    private static Color getColorField(Class aClass, String fieldName) {
        try {
            Field field = aClass.getDeclaredField(fieldName);
            return (Color)field.get(null);
        }
        catch (NoSuchFieldException e) {
            return Color.black;
        }
        catch (IllegalAccessException e) {
            return Color.black;
        }
    }

    public Color getResolvedColor() {
        if (this.myColor != null) {
            return this.myColor;
        }
        if (this.mySwingColor != null) {
            return UIManager.getColor(this.mySwingColor);
        }
        if (this.mySystemColor != null) {
            return ColorDescriptor.getColorField(SystemColor.class, this.mySystemColor);
        }
        if (this.myAWTColor != null) {
            return ColorDescriptor.getColorField(Color.class, this.myAWTColor);
        }
        return null;
    }

    public Color getColor() {
        return this.myColor;
    }

    public String getSwingColor() {
        return this.mySwingColor;
    }

    public String getSystemColor() {
        return this.mySystemColor;
    }

    public String getAWTColor() {
        return this.myAWTColor;
    }

    public String toString() {
        if (this.mySwingColor != null) {
            return this.mySwingColor;
        }
        if (this.mySystemColor != null) {
            return this.mySystemColor;
        }
        if (this.myAWTColor != null) {
            return this.myAWTColor;
        }
        if (this.myColor != null) {
            return "[" + this.myColor.getRed() + "," + this.myColor.getGreen() + "," + this.myColor.getBlue() + "]";
        }
        return "null";
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ColorDescriptor)) {
            return false;
        }
        ColorDescriptor rhs = (ColorDescriptor)obj;
        if (this.myColor != null) {
            return this.myColor.equals(rhs.myColor);
        }
        if (this.mySwingColor != null) {
            return this.mySwingColor.equals(rhs.mySwingColor);
        }
        if (this.mySystemColor != null) {
            return this.mySystemColor.equals(rhs.mySystemColor);
        }
        if (this.myAWTColor != null) {
            return this.myAWTColor.equals(rhs.myAWTColor);
        }
        return false;
    }

    public boolean isColorSet() {
        return this.myColor != null || this.mySwingColor != null || this.mySystemColor != null || this.myAWTColor != null;
    }
}

