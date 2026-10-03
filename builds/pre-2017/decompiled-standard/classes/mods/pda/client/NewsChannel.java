/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import mods.pda.client.screens.GuiPda;

public class NewsChannel
extends iuww {
    public NewsChannel() {
        super("\u041d\u043e\u0432\u043e\u0441\u0442\u0438", "news");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        return "\"" + bqdo2._d()._j("Title") + "\"";
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return iuww.kjui._b;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        GuiPda.openPda("news");
    }
}

