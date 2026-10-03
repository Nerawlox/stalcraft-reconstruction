/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.compiler.Utils;
import com.intellij.uiDesigner.lw.LwIntroBooleanProperty;
import com.intellij.uiDesigner.lw.LwIntroCharProperty;
import com.intellij.uiDesigner.lw.LwIntroColorProperty;
import com.intellij.uiDesigner.lw.LwIntroComponentProperty;
import com.intellij.uiDesigner.lw.LwIntroDimensionProperty;
import com.intellij.uiDesigner.lw.LwIntroEnumProperty;
import com.intellij.uiDesigner.lw.LwIntroFontProperty;
import com.intellij.uiDesigner.lw.LwIntroIconProperty;
import com.intellij.uiDesigner.lw.LwIntroInsetsProperty;
import com.intellij.uiDesigner.lw.LwIntroIntProperty;
import com.intellij.uiDesigner.lw.LwIntroListModelProperty;
import com.intellij.uiDesigner.lw.LwIntroPrimitiveTypeProperty;
import com.intellij.uiDesigner.lw.LwIntroRectangleProperty;
import com.intellij.uiDesigner.lw.LwIntrospectedProperty;
import com.intellij.uiDesigner.lw.LwRbIntroStringProperty;
import com.intellij.uiDesigner.lw.PropertiesProvider;
import java.awt.Component;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import javax.swing.ListModel;

public final class CompiledClassPropertiesProvider
implements PropertiesProvider {
    private final ClassLoader myLoader;
    private final HashMap myCache;

    public CompiledClassPropertiesProvider(ClassLoader loader) {
        if (loader == null) {
            throw new IllegalArgumentException("loader cannot be null");
        }
        this.myLoader = loader;
        this.myCache = new HashMap();
    }

    public HashMap getLwProperties(String className) {
        BeanInfo beanInfo;
        Class<?> aClass;
        if (this.myCache.containsKey(className)) {
            return (HashMap)this.myCache.get(className);
        }
        if (Utils.validateJComponentClass(this.myLoader, className, false) != null) {
            return null;
        }
        try {
            aClass = Class.forName(className, false, this.myLoader);
        }
        catch (ClassNotFoundException exc) {
            throw new RuntimeException(exc.toString());
        }
        try {
            beanInfo = Introspector.getBeanInfo(aClass);
        }
        catch (Throwable e) {
            return null;
        }
        HashMap<String, LwIntrospectedProperty> result2 = new HashMap<String, LwIntrospectedProperty>();
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < descriptors.length; ++i) {
            String name2;
            LwIntrospectedProperty property;
            PropertyDescriptor descriptor2 = descriptors[i];
            Method readMethod = descriptor2.getReadMethod();
            Method writeMethod = descriptor2.getWriteMethod();
            Class<?> propertyType = descriptor2.getPropertyType();
            if (writeMethod == null || readMethod == null || propertyType == null || (property = CompiledClassPropertiesProvider.propertyFromClass(propertyType, name2 = descriptor2.getName())) == null) continue;
            property.setDeclaringClassName(descriptor2.getReadMethod().getDeclaringClass().getName());
            result2.put(name2, property);
        }
        this.myCache.put(className, result2);
        return result2;
    }

    public static LwIntrospectedProperty propertyFromClass(Class propertyType, String name2) {
        LwIntrospectedProperty property = CompiledClassPropertiesProvider.propertyFromClassName(propertyType.getName(), name2);
        if (property == null) {
            if (Component.class.isAssignableFrom(propertyType)) {
                property = new LwIntroComponentProperty(name2, propertyType.getName());
            } else if (ListModel.class.isAssignableFrom(propertyType)) {
                property = new LwIntroListModelProperty(name2, propertyType.getName());
            } else if (propertyType.getSuperclass() != null && "java.lang.Enum".equals(propertyType.getSuperclass().getName())) {
                property = new LwIntroEnumProperty(name2, propertyType);
            }
        }
        return property;
    }

    public static LwIntrospectedProperty propertyFromClassName(String propertyClassName, String name2) {
        LwIntrospectedProperty property = Integer.TYPE.getName().equals(propertyClassName) ? new LwIntroIntProperty(name2) : (Boolean.TYPE.getName().equals(propertyClassName) ? new LwIntroBooleanProperty(name2) : (Double.TYPE.getName().equals(propertyClassName) ? new LwIntroPrimitiveTypeProperty(name2, Double.class) : (Float.TYPE.getName().equals(propertyClassName) ? new LwIntroPrimitiveTypeProperty(name2, Float.class) : (Long.TYPE.getName().equals(propertyClassName) ? new LwIntroPrimitiveTypeProperty(name2, Long.class) : (Byte.TYPE.getName().equals(propertyClassName) ? new LwIntroPrimitiveTypeProperty(name2, Byte.class) : (Short.TYPE.getName().equals(propertyClassName) ? new LwIntroPrimitiveTypeProperty(name2, Short.class) : (Character.TYPE.getName().equals(propertyClassName) ? new LwIntroCharProperty(name2) : (String.class.getName().equals(propertyClassName) ? new LwRbIntroStringProperty(name2) : ("java.awt.Insets".equals(propertyClassName) ? new LwIntroInsetsProperty(name2) : ("java.awt.Dimension".equals(propertyClassName) ? new LwIntroDimensionProperty(name2) : ("java.awt.Rectangle".equals(propertyClassName) ? new LwIntroRectangleProperty(name2) : ("java.awt.Color".equals(propertyClassName) ? new LwIntroColorProperty(name2) : ("java.awt.Font".equals(propertyClassName) ? new LwIntroFontProperty(name2) : ("javax.swing.Icon".equals(propertyClassName) ? new LwIntroIconProperty(name2) : null))))))))))))));
        return property;
    }
}

