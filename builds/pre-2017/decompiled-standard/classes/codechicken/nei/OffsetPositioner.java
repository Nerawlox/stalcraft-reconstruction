/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IStackPositioner;
import java.util.ArrayList;

public class OffsetPositioner
implements IStackPositioner {
    public int offsetx;
    public int offsety;

    public OffsetPositioner(int n, int n2) {
        this.offsetx = n;
        this.offsety = n2;
    }

    @Override
    public ArrayList<PositionedStack> positionStacks(ArrayList<PositionedStack> arrayList) {
        for (PositionedStack positionedStack : arrayList) {
            positionedStack.relx += this.offsetx;
            positionedStack.rely += this.offsety;
        }
        return arrayList;
    }
}

