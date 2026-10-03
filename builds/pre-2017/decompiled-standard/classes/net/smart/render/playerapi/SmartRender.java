/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.playerapi;

import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerAPI;
import api.player.render.RenderPlayerAPI;
import net.smart.render.playerapi.SmartRenderModelPlayerBase;
import net.smart.render.playerapi.SmartRenderRenderPlayerBase;

public abstract class SmartRender {
    public static final String ID = "Smart Render";

    public static void register() {
        RenderPlayerAPI.register(ID, SmartRenderRenderPlayerBase.class);
        ModelPlayerAPI.register(ID, SmartRenderModelPlayerBase.class);
    }

    public static SmartRenderRenderPlayerBase getPlayerBase(xbdy xbdy2) {
        return (SmartRenderRenderPlayerBase)xbdy2.getRenderPlayerBase(ID);
    }

    public static SmartRenderModelPlayerBase getPlayerBase(ModelPlayer modelPlayer) {
        return (SmartRenderModelPlayerBase)modelPlayer.getModelPlayerBase(ID);
    }
}

