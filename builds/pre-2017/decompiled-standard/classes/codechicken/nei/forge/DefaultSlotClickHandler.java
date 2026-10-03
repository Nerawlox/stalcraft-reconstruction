/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

import codechicken.nei.forge.IContainerSlotClickHandler;

public class DefaultSlotClickHandler
implements IContainerSlotClickHandler {
    @Override
    public void beforeSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3) {
    }

    @Override
    public boolean handleSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3, boolean bl) {
        if (!bl) {
            zybc2.sendMouseClick(yeso2, n, n2, n != -999 ? n3 : 0);
        }
        return true;
    }

    @Override
    public void afterSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3) {
    }
}

