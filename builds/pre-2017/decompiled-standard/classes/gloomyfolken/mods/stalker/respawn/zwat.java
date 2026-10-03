/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.mods.core.client.gui.screens.GuiNotification;

public class zwat
extends GuiNotification {
    private final int _a;
    private final int _b;
    private final int _c;

    public zwat(String string, int n, int n2, int n3) {
        super("\u0425\u043e\u0442\u0438\u0442\u0435 \u043b\u0438 \u0432\u044b \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c", "\u0442\u043e\u0447\u043a\u0443 \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f \u043d\u0430 \u0431\u0430\u0437\u0435 \"" + string + "\"?");
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void fail() {
    }

    @Override
    public void success() {
        new loij(this._a, this._b, this._c).sendToServer();
    }
}

