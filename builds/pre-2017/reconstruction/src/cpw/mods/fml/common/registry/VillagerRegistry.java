/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.idpz;
import net.minecraft.village.MerchantRecipeList;

public class VillagerRegistry {
    private static final VillagerRegistry INSTANCE = new VillagerRegistry();
    private Multimap<Integer, IVillageTradeHandler> tradeHandlers = ArrayListMultimap.create();
    private Map<Class<?>, IVillageCreationHandler> villageCreationHandlers = Maps.newHashMap();
    private List<Integer> newVillagerIds = Lists.newArrayList();
    @SideOnly(value=Side.CLIENT)
    private Map<Integer, ResourceLocation> newVillagers;

    public static VillagerRegistry instance() {
        return INSTANCE;
    }

    public void registerVillagerId(int n) {
        if (this.newVillagerIds.contains(n)) {
            FMLLog.severe("Attempt to register duplicate villager id %d", n);
            throw new RuntimeException();
        }
        this.newVillagerIds.add(n);
    }

    @SideOnly(value=Side.CLIENT)
    public void registerVillagerSkin(int n, ResourceLocation resourceLocation) {
        if (this.newVillagers == null) {
            this.newVillagers = Maps.newHashMap();
        }
        this.newVillagers.put(n, resourceLocation);
    }

    public void registerVillageCreationHandler(IVillageCreationHandler iVillageCreationHandler) {
        this.villageCreationHandlers.put(iVillageCreationHandler.getComponentClass(), iVillageCreationHandler);
    }

    public void registerVillageTradeHandler(int n, IVillageTradeHandler iVillageTradeHandler) {
        this.tradeHandlers.put(n, iVillageTradeHandler);
    }

    @SideOnly(value=Side.CLIENT)
    public static ResourceLocation getVillagerSkin(int n, ResourceLocation resourceLocation) {
        if (VillagerRegistry.instance().newVillagers != null && VillagerRegistry.instance().newVillagers.containsKey(n)) {
            return VillagerRegistry.instance().newVillagers.get(n);
        }
        return resourceLocation;
    }

    public static Collection<Integer> getRegisteredVillagers() {
        return Collections.unmodifiableCollection(VillagerRegistry.instance().newVillagerIds);
    }

    public static void manageVillagerTrades(MerchantRecipeList merchantRecipeList, EntityVillager entityVillager, int n, Random random) {
        for (IVillageTradeHandler iVillageTradeHandler : VillagerRegistry.instance().tradeHandlers.get(n)) {
            iVillageTradeHandler.manipulateTradesForVillager(entityVillager, merchantRecipeList, random);
        }
    }

    public static void addExtraVillageComponents(ArrayList arrayList, Random random, int n) {
        ArrayList arrayList2 = arrayList;
        for (IVillageCreationHandler iVillageCreationHandler : VillagerRegistry.instance().villageCreationHandlers.values()) {
            arrayList2.add(iVillageCreationHandler.getVillagePieceWeight(random, n));
        }
    }

    public static Object getVillageComponent(ihas ihas2, fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return VillagerRegistry.instance().villageCreationHandlers.get(ihas2._a).buildComponent(ihas2, fovt2, list, random, n, n2, n3, n4, n5);
    }

    public static void addEmeraldBuyRecipe(EntityVillager entityVillager, MerchantRecipeList merchantRecipeList, Random random, Item item, float f, int n, int n2) {
        if (n > 0 && n2 > 0) {
            EntityVillager.field_70958_bB.put(item.itemID, new idpz(n, n2));
        }
        EntityVillager.addMerchantItem(merchantRecipeList, item.getMaxDamage(), random, f);
    }

    public static void addEmeraldSellRecipe(EntityVillager entityVillager, MerchantRecipeList merchantRecipeList, Random random, Item item, float f, int n, int n2) {
        if (n > 0 && n2 > 0) {
            EntityVillager.blacksmithSellingList.put(item.itemID, new idpz(n, n2));
        }
        EntityVillager.addBlacksmithItem(merchantRecipeList, item.getMaxDamage(), random, f);
    }

    public static void applyRandomTrade(EntityVillager entityVillager, Random random) {
        int n = VillagerRegistry.instance().newVillagerIds.size();
        int n2 = random.nextInt(5 + n);
        entityVillager.setProfession(n2 < 5 ? n2 : VillagerRegistry.instance().newVillagerIds.get(n2 - 5));
    }

    public static interface IVillageTradeHandler {
        public void manipulateTradesForVillager(EntityVillager var1, MerchantRecipeList var2, Random var3);
    }

    public static interface IVillageCreationHandler {
        public ihas getVillagePieceWeight(Random var1, int var2);

        public Class<?> getComponentClass();

        public Object buildComponent(ihas var1, fovt var2, List var3, Random var4, int var5, int var6, int var7, int var8, int var9);
    }
}

