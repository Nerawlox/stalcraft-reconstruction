/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiNotification;
import net.minecraft.entity.player.EntityPlayer;

@ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
public class eidj
extends GuiNotification {
    public eidj(EntityPlayer entityPlayer) {
        super("\u0418\u0433\u0440\u043e\u043a " + entityPlayer.username, "\u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u0435\u0442 \u0432\u0430\u043c \u043e\u0431\u043c\u0435\u043d.");
    }

    @Override
    public void fail() {
        new jibv(false).sendToServer();
    }

    @Override
    public void success() {
        new jibv(true).sendToServer();
    }
}

