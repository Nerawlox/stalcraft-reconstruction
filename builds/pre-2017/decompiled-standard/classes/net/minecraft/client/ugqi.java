/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.client.xpzm;

public class ugqi
extends Thread {
    public final /* synthetic */ xpzm _a;

    public ugqi(xpzm xpzm2, String string) {
        this._a = xpzm2;
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

