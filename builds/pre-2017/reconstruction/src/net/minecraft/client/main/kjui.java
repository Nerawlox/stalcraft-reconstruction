/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.main;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public final class kjui
extends Authenticator {
    public final /* synthetic */ String _a;
    public final /* synthetic */ String _b;

    public kjui(String string, String string2) {
        this._a = string;
        this._b = string2;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this._a, this._b.toCharArray());
    }
}

