/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.pda;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class ExpandableScrollList<T extends vjsq>
extends McScrollList<T> {
    private List<ExpandedIndices<T>> expands = new ArrayList<ExpandedIndices<T>>();

    public ExpandableScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<T> list2, Point point, Dimension dimension) {
        super(iAdvancedGui, componentButtonStyle, list2, point, dimension);
    }

    @Override
    public void setSelectedLineId(int n) {
        super.setSelectedLineId(n);
        this.onLineSelected();
    }

    private void onLineSelected() {
        boolean bl = true;
        ExpandedIndices<T> expandedIndices = this.findSelectedExpand();
        if (expandedIndices != null) {
            for (int i = ((ExpandedIndices)expandedIndices).expandSize - 1; i >= 0; --i) {
                this.lines.remove(this.lines.indexOf(((ExpandedIndices)expandedIndices).expandable) + 1 + i);
            }
            this.expands.remove(expandedIndices);
            if (this.selectedLineId >= this.lines.size()) {
                this.selectedLineId = -1;
            }
            bl = false;
        }
        expandedIndices = this.findSelectedExpand();
        Object t = this.getSelectedLine();
        if (bl && t instanceof IExpandable && expandedIndices == null) {
            List list2 = ((IExpandable)t).expand();
            ExpandedIndices expandedIndices2 = new ExpandedIndices(t, list2.size());
            this.expands.add(expandedIndices2);
            this.lines.addAll(this.selectedLineId + 1, list2);
        }
    }

    private ExpandedIndices<T> findSelectedExpand() {
        return this.expands.stream().filter(expandedIndices -> this.lines.indexOf(((ExpandedIndices)expandedIndices).expandable) == this.selectedLineId).findFirst().orElse(null);
    }

    private static class ExpandedIndices<T> {
        private T expandable;
        private int expandSize;

        public ExpandedIndices(T t, int n) {
            this.expandable = t;
            this.expandSize = n;
        }
    }

    public static interface IExpandable<T>
    extends vjsq {
        public List<T> expand();
    }
}

