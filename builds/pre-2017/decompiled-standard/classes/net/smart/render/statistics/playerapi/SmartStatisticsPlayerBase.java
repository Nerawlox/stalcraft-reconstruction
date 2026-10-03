/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics.playerapi;

import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import net.smart.render.statistics.IEntityPlayerSP;
import net.smart.render.statistics.SmartStatistics;

public class SmartStatisticsPlayerBase
extends ClientPlayerBase
implements IEntityPlayerSP {
    public SmartStatistics statistics;

    public SmartStatisticsPlayerBase(ClientPlayerAPI clientPlayerAPI) {
        super(clientPlayerAPI);
        this.statistics = new SmartStatistics(this.player);
    }

    @Override
    public void afterMoveEntityWithHeading(float f, float f2) {
        this.statistics.calculateAllStats();
    }

    @Override
    public void afterUpdateRidden() {
        this.statistics.calculateRiddenStats();
    }

    @Override
    public SmartStatistics getStatistics() {
        return this.statistics;
    }
}

