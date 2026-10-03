/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Widget;

public class Label
extends Widget {
    boolean centered;
    int colour;
    String text;

    public Label(String string, boolean bl, int n) {
        this.text = string;
        this.centered = bl;
        this.colour = n;
    }

    public Label(String string, boolean bl) {
        this(string, bl, -1);
    }

    @Override
    public void draw(int n, int n2) {
        if (this.centered) {
            GuiDraw.drawStringC(this.text, this.x, this.y, this.colour);
        } else {
            GuiDraw.drawString(this.text, this.x, this.y, this.colour);
        }
    }
}

