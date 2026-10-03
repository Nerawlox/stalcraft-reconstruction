/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.lw;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.lw.ComponentVisitor;
import com.intellij.uiDesigner.lw.IContainer;
import com.intellij.uiDesigner.lw.IProperty;

public interface IComponent {
    public Object getClientProperty(Object var1);

    public void putClientProperty(Object var1, Object var2);

    public String getBinding();

    public String getComponentClassName();

    public String getId();

    public boolean isCustomCreate();

    public IProperty[] getModifiedProperties();

    public IContainer getParentContainer();

    public GridConstraints getConstraints();

    public Object getCustomLayoutConstraints();

    public boolean accept(ComponentVisitor var1);

    public boolean areChildrenExclusive();
}

