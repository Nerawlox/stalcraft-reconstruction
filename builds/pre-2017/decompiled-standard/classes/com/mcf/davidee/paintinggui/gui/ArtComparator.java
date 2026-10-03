/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui.gui;

import java.util.Comparator;
import net.minecraft.util.ugqi;

public class ArtComparator
implements Comparator<ugqi> {
    @Override
    public int compare(ugqi ugqi2, ugqi ugqi3) {
        if (ugqi2.__aM > ugqi3.__aM) {
            return -1;
        }
        if (ugqi2.__aM < ugqi3.__aM) {
            return 1;
        }
        return ugqi3.__aL - ugqi2.__aL;
    }
}

