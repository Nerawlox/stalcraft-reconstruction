/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.Widget;
import java.util.Comparator;

public class WidgetZOrder
implements Comparator<Widget> {
    boolean topfirst;

    public WidgetZOrder(boolean bl) {
        this.topfirst = bl;
    }

    @Override
    public int compare(Widget widget, Widget widget2) {
        return widget.z != widget2.z ? ((this.topfirst ? widget.z > widget2.z : widget.z < widget2.z) ? 1 : -1) : 1;
    }
}

