/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.core;

import com.intellij.uiDesigner.core.DimensionInfo;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.LayoutState;

final class HorizontalInfo
extends DimensionInfo {
    public HorizontalInfo(LayoutState layoutState, int gap) {
        super(layoutState, gap);
    }

    protected int getOriginalCell(GridConstraints constraints) {
        return constraints.getColumn();
    }

    protected int getOriginalSpan(GridConstraints constraints) {
        return constraints.getColSpan();
    }

    int getSizePolicy(int componentIndex) {
        return this.myLayoutState.getConstraints(componentIndex).getHSizePolicy();
    }

    int getChildLayoutCellCount(GridLayoutManager childLayout) {
        return childLayout.getColumnCount();
    }

    public int getMinimumWidth(int componentIndex) {
        return this.getMinimumSize((int)componentIndex).width;
    }

    public DimensionInfo getDimensionInfo(GridLayoutManager grid) {
        return grid.myHorizontalInfo;
    }

    public int getCellCount() {
        return this.myLayoutState.getColumnCount();
    }

    public int getPreferredWidth(int componentIndex) {
        return this.getPreferredSize((int)componentIndex).width;
    }
}

