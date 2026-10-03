/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.availability.AvailabilityRule;

public class TradepackRule
extends AvailabilityRule {
    public boolean shouldHaveTradepack = false;

    public TradepackRule(boolean bl) {
        super(AvailabilityRule.RuleType.TRADEPACK_CHECK);
        this.shouldHaveTradepack = bl;
    }

    @Override
    public boolean available(EntityPlayer entityPlayer) {
        boolean bl = tupg._a(entityPlayer)._g();
        return this.shouldHaveTradepack == bl;
    }

    @Override
    public void save(qoac qoac2) {
        qoac2._a("ShouldHaveTradepack", this.shouldHaveTradepack);
    }

    @Override
    public void load(qoac qoac2) {
        this.shouldHaveTradepack = qoac2._o("ShouldHaveTradepack");
    }
}

