/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client;

import ru.stalcraft.Logger;

public class SmartMovingHelper {
    public final boolean isSmartmovingEnabled;

    public SmartMovingHelper() {
        boolean classNotFound = false;
        try {
            Class.forName("net.smart.render.Info", true, this.getClass().getClassLoader());
            Logger.console("SmartMoving found");
        }
        catch (Exception var3) {
            classNotFound = true;
            Logger.console("SmartMoving not found");
        }
        this.isSmartmovingEnabled = !classNotFound;
    }
}

