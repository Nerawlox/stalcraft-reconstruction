/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IPickupNotifier;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.BaseModTicker;
import cpw.mods.fml.common.modloader.IModLoaderSidedHelper;
import cpw.mods.fml.common.modloader.ModLoaderChatListener;
import cpw.mods.fml.common.modloader.ModLoaderConnectionHandler;
import cpw.mods.fml.common.modloader.ModLoaderCraftingHelper;
import cpw.mods.fml.common.modloader.ModLoaderEntitySpawnCallback;
import cpw.mods.fml.common.modloader.ModLoaderFuelHelper;
import cpw.mods.fml.common.modloader.ModLoaderGuiHelper;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.modloader.ModLoaderPacketHandler;
import cpw.mods.fml.common.modloader.ModLoaderPickupNotifier;
import cpw.mods.fml.common.modloader.ModLoaderVillageTradeHandler;
import cpw.mods.fml.common.modloader.ModLoaderWorldGenerator;
import cpw.mods.fml.common.network.IChatListener;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import java.util.EnumSet;
import java.util.Map;
import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.src.TradeEntry;

public class ModLoaderHelper {
    public static IModLoaderSidedHelper sidedHelper;
    private static Map<BaseModProxy, ModLoaderGuiHelper> guiHelpers;
    private static Map<Integer, ModLoaderGuiHelper> guiIDs;
    private static ModLoaderVillageTradeHandler[] tradeHelpers;

    public static void updateStandardTicks(BaseModProxy baseModProxy, boolean bl, boolean bl2) {
        ModLoaderModContainer modLoaderModContainer = (ModLoaderModContainer)Loader.instance().getReversedModObjectList().get(baseModProxy);
        if (modLoaderModContainer == null) {
            modLoaderModContainer = (ModLoaderModContainer)Loader.instance().activeModContainer();
        }
        if (modLoaderModContainer == null) {
            FMLLog.severe("Attempted to register ModLoader ticking for invalid BaseMod %s", baseModProxy);
            return;
        }
        BaseModTicker baseModTicker = modLoaderModContainer.getGameTickHandler();
        EnumSet<TickType> enumSet = baseModTicker.ticks();
        if (bl && !bl2) {
            enumSet.add(TickType.RENDER);
        } else {
            enumSet.remove((Object)TickType.RENDER);
        }
        if (bl && (bl2 || FMLCommonHandler.instance().getSide().isServer())) {
            enumSet.add(TickType.CLIENT);
            enumSet.add(TickType.WORLDLOAD);
        } else {
            enumSet.remove((Object)TickType.CLIENT);
            enumSet.remove((Object)TickType.WORLDLOAD);
        }
    }

    public static void updateGUITicks(BaseModProxy baseModProxy, boolean bl, boolean bl2) {
        ModLoaderModContainer modLoaderModContainer = (ModLoaderModContainer)Loader.instance().getReversedModObjectList().get(baseModProxy);
        if (modLoaderModContainer == null) {
            modLoaderModContainer = (ModLoaderModContainer)Loader.instance().activeModContainer();
        }
        if (modLoaderModContainer == null) {
            FMLLog.severe("Attempted to register ModLoader ticking for invalid BaseMod %s", baseModProxy);
            return;
        }
        EnumSet<TickType> enumSet = modLoaderModContainer.getGUITickHandler().ticks();
        if (bl && !bl2) {
            enumSet.add(TickType.RENDER);
        } else {
            enumSet.remove((Object)TickType.RENDER);
        }
        if (bl && bl2) {
            enumSet.add(TickType.CLIENT);
            enumSet.add(TickType.WORLDLOAD);
        } else {
            enumSet.remove((Object)TickType.CLIENT);
            enumSet.remove((Object)TickType.WORLDLOAD);
        }
    }

    public static IPacketHandler buildPacketHandlerFor(BaseModProxy baseModProxy) {
        return new ModLoaderPacketHandler(baseModProxy);
    }

    public static IWorldGenerator buildWorldGenHelper(BaseModProxy baseModProxy) {
        return new ModLoaderWorldGenerator(baseModProxy);
    }

    public static IFuelHandler buildFuelHelper(BaseModProxy baseModProxy) {
        return new ModLoaderFuelHelper(baseModProxy);
    }

    public static ICraftingHandler buildCraftingHelper(BaseModProxy baseModProxy) {
        return new ModLoaderCraftingHelper(baseModProxy);
    }

    public static void finishModLoading(ModLoaderModContainer modLoaderModContainer) {
        if (sidedHelper != null) {
            sidedHelper.finishModLoading(modLoaderModContainer);
        }
    }

    public static IConnectionHandler buildConnectionHelper(BaseModProxy baseModProxy) {
        return new ModLoaderConnectionHandler(baseModProxy);
    }

    public static IPickupNotifier buildPickupHelper(BaseModProxy baseModProxy) {
        return new ModLoaderPickupNotifier(baseModProxy);
    }

    public static void buildGuiHelper(BaseModProxy baseModProxy, int n) {
        ModLoaderGuiHelper modLoaderGuiHelper = guiHelpers.get(baseModProxy);
        if (modLoaderGuiHelper == null) {
            modLoaderGuiHelper = new ModLoaderGuiHelper(baseModProxy);
            guiHelpers.put(baseModProxy, modLoaderGuiHelper);
            NetworkRegistry.instance().registerGuiHandler(baseModProxy, modLoaderGuiHelper);
        }
        modLoaderGuiHelper.associateId(n);
        guiIDs.put(n, modLoaderGuiHelper);
    }

    public static void openGui(int n, EntityPlayer entityPlayer, Container container, int n2, int n3, int n4) {
        ModLoaderGuiHelper modLoaderGuiHelper = guiIDs.get(n);
        modLoaderGuiHelper.injectContainerAndID(container, n);
        entityPlayer.openGui(modLoaderGuiHelper.getMod(), n, entityPlayer.worldObj, n2, n3, n4);
    }

    public static Object getClientSideGui(BaseModProxy baseModProxy, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (sidedHelper != null) {
            return sidedHelper.getClientGui(baseModProxy, entityPlayer, n, n2, n3, n4);
        }
        return null;
    }

    public static void buildEntityTracker(BaseModProxy baseModProxy, Class<? extends Entity> clazz, int n, int n2, int n3, boolean bl) {
        EntityRegistry.EntityRegistration entityRegistration = EntityRegistry.registerModLoaderEntity(baseModProxy, clazz, n, n2, n3, bl);
        entityRegistration.setCustomSpawning(new ModLoaderEntitySpawnCallback(baseModProxy, entityRegistration), EntityDragon.class.isAssignableFrom(clazz) || ezey.class.isAssignableFrom(clazz));
    }

    public static void registerTrade(int n, TradeEntry tradeEntry) {
        assert (n < tradeHelpers.length) : "The profession is out of bounds";
        if (tradeHelpers[n] == null) {
            ModLoaderHelper.tradeHelpers[n] = new ModLoaderVillageTradeHandler();
            VillagerRegistry.instance().registerVillageTradeHandler(n, tradeHelpers[n]);
        }
        tradeHelpers[n].addTrade(tradeEntry);
    }

    public static void addCommand(ICommand iCommand) {
        ModLoaderModContainer modLoaderModContainer = (ModLoaderModContainer)Loader.instance().activeModContainer();
        if (modLoaderModContainer != null) {
            modLoaderModContainer.addServerCommand(iCommand);
        }
    }

    public static IChatListener buildChatListener(BaseModProxy baseModProxy) {
        return new ModLoaderChatListener(baseModProxy);
    }

    static {
        guiHelpers = Maps.newHashMap();
        guiIDs = Maps.newHashMap();
        tradeHelpers = new ModLoaderVillageTradeHandler[6];
    }
}

