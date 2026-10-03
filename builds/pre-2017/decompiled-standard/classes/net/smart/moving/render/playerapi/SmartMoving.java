/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render.playerapi;

import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBaseSorting;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBaseSorting;
import net.smart.moving.render.playerapi.SmartMovingModelPlayerBase;
import net.smart.moving.render.playerapi.SmartMovingRenderPlayerBase;

public abstract class SmartMoving {
    public static final String ID = "Smart Moving";

    public static void register() {
        String[] stringArray = new String[]{"Smart Render"};
        RenderPlayerBaseSorting renderPlayerBaseSorting = new RenderPlayerBaseSorting();
        renderPlayerBaseSorting.setAfterLocalConstructingInferiors(stringArray);
        renderPlayerBaseSorting.setOverrideRenderPlayerInferiors(stringArray);
        renderPlayerBaseSorting.setOverrideRotatePlayerInferiors(stringArray);
        renderPlayerBaseSorting.setOverrideRenderPlayerSleepInferiors(stringArray);
        RenderPlayerAPI.register(ID, SmartMovingRenderPlayerBase.class, renderPlayerBaseSorting);
        ModelPlayerBaseSorting modelPlayerBaseSorting = new ModelPlayerBaseSorting();
        modelPlayerBaseSorting.setAfterLocalConstructingInferiors(stringArray);
        ModelPlayerAPI.register(ID, SmartMovingModelPlayerBase.class, modelPlayerBaseSorting);
    }

    public static SmartMovingRenderPlayerBase getPlayerBase(xbdy xbdy2) {
        return (SmartMovingRenderPlayerBase)xbdy2.getRenderPlayerBase(ID);
    }

    public static SmartMovingModelPlayerBase getPlayerBase(ModelPlayer modelPlayer) {
        return (SmartMovingModelPlayerBase)modelPlayer.getModelPlayerBase(ID);
    }
}

