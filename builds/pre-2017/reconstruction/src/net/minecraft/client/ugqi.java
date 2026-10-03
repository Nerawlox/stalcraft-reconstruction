/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.client.Minecraft;

public class ugqi
extends Thread {
    public final /* synthetic */ Minecraft _a;

    public ugqi(Minecraft minecraft, String string) {
        this._a = minecraft;
        super(string);
    }

    @Override
    public void run() {
        while (this._a.__ap) {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

