/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.controllers.TimeRanges;

public class GuiTimeRangesField
extends GuiNpcTextField {
    private final TimeRanges timeRanges;

    public GuiTimeRangesField(int n, gqjz gqjz2, qncw qncw2, int n2, int n3, int n4, int n5, TimeRanges timeRanges) {
        super(n, gqjz2, qncw2, n2, n3, n4, n5, timeRanges.toDisplayString());
        this.timeRanges = timeRanges;
    }

    @Override
    public void unFocused() {
        super.unFocused();
        String string = this.func_73781_b();
        if (string.isEmpty()) {
            this.timeRanges.clear();
        } else {
            String[] stringArray;
            boolean bl = false;
            this.timeRanges.clear();
            for (String string2 : stringArray = string.split(";")) {
                String[] stringArray2 = string2.split("-");
                try {
                    int n = bqgh._a(stringArray2[0]);
                    int n2 = bqgh._a(stringArray2[1]);
                    this.timeRanges.add(n, n2);
                }
                catch (Exception exception) {
                    bl = true;
                }
            }
            if (bl) {
                this.func_73794_g(-65536);
            } else {
                this.func_73794_g(-2039584);
            }
        }
    }
}

