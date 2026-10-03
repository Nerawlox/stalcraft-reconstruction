/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package ru.stalcraft.items;

import org.lwjgl.input.Mouse;

public enum FireMode {
    AUTO,
    SEMIAUTO,
    BOLT;

    private static boolean isShootPermament;
    private static boolean isShootIndiviual;

    public boolean isShoot(boolean par1) {
        isShootIndiviual = isShootPermament;
        isShootPermament = Mouse.isButtonDown((int)0);
        switch (this) {
            case AUTO: {
                if (!isShootPermament || par1) break;
                return true;
            }
            case SEMIAUTO: {
                if (!isShootPermament) break;
                if (isShootIndiviual || par1) break;
                return true;
            }
            case BOLT: {
                if (!isShootPermament) break;
                if (isShootIndiviual) break;
                return true;
            }
        }
        return false;
    }

    static {
        isShootIndiviual = isShootPermament;
    }
}

