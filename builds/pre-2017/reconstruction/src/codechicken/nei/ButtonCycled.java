/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.Button;
import codechicken.nei.Image;

public abstract class ButtonCycled
extends Button {
    public int index;
    public Image[] icons;

    @Override
    public Image getRenderIcon() {
        return this.icons[this.index];
    }
}

