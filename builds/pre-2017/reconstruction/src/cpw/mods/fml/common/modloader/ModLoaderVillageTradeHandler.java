/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.VillagerRegistry;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.src.TradeEntry;
import net.minecraft.village.MerchantRecipeList;

public class ModLoaderVillageTradeHandler
implements VillagerRegistry.IVillageTradeHandler {
    private List<TradeEntry> trades = Lists.newArrayList();

    @Override
    public void manipulateTradesForVillager(EntityVillager entityVillager, MerchantRecipeList merchantRecipeList, Random random) {
        for (TradeEntry tradeEntry : this.trades) {
            if (tradeEntry.buying) {
                VillagerRegistry.addEmeraldBuyRecipe(entityVillager, merchantRecipeList, random, Item.itemsList[tradeEntry.id], tradeEntry.chance, tradeEntry.min, tradeEntry.max);
                continue;
            }
            VillagerRegistry.addEmeraldSellRecipe(entityVillager, merchantRecipeList, random, Item.itemsList[tradeEntry.id], tradeEntry.chance, tradeEntry.min, tradeEntry.max);
        }
    }

    public void addTrade(TradeEntry tradeEntry) {
        this.trades.add(tradeEntry);
    }
}

