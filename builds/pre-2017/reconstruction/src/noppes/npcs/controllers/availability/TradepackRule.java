/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.availability;

import gloomyfolken.mods.stalker.misc.tupg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
    public void save(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ShouldHaveTradepack", this.shouldHaveTradepack);
    }

    @Override
    public void load(NBTTagCompound nBTTagCompound) {
        this.shouldHaveTradepack = nBTTagCompound._o("ShouldHaveTradepack");
    }
}

