/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens;

import gloomyfolken.mods.core.client.gui.screens.GuiNotification;

public class GuiFriendInvite
extends GuiNotification {
    private String from;

    public GuiFriendInvite(String string) {
        super("\u0418\u0433\u0440\u043e\u043a " + string, " \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u043b \u0437\u0430\u043f\u0440\u043e\u0441 \u043d\u0430 \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u0432 \u0434\u0440\u0443\u0437\u044c\u044f");
        this.from = string;
    }

    @Override
    public void fail() {
        new eikj(this.from, false).sendClientToBackend();
    }

    @Override
    public void success() {
        new eikj(this.from, true).sendClientToBackend();
    }
}

