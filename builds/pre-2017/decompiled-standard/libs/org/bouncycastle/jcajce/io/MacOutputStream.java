/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

public class MacOutputStream
extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac) {
        this.mac = mac;
    }

    public void write(int n) throws IOException {
        this.mac.update((byte)n);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.mac.update(byArray, n, n2);
    }

    public byte[] getMac() {
        return this.mac.doFinal();
    }
}

