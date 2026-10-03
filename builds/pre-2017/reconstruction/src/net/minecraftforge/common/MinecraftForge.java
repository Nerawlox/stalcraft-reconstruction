/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.event.EventBus;
import net.minecraftforge.oredict.OreDictionary;

public class MinecraftForge {
    public static final EventBus EVENT_BUS = new EventBus();
    public static final EventBus TERRAIN_GEN_BUS = new EventBus();
    public static final EventBus ORE_GEN_BUS = new EventBus();
    private static final ForgeInternalHandler INTERNAL_HANDLER = new ForgeInternalHandler();

    public static void addGrassPlant(Block block, int n, int n2) {
        ForgeHooks.grassList.add(new ForgeHooks.GrassEntry(block, n, n2));
    }

    public static void addGrassSeed(ItemStack itemStack, int n) {
        ForgeHooks.seedList.add(new ForgeHooks.SeedEntry(itemStack, n));
    }

    public static void setToolClass(Item item, String string, int n) {
        ForgeHooks.toolClasses.put(item, Arrays.asList(string, n));
    }

    public static void setBlockHarvestLevel(Block block, int n, String string, int n2) {
        List<Object> list = Arrays.asList(block, n, string);
        ForgeHooks.toolHarvestLevels.put(list, n2);
        ForgeHooks.toolEffectiveness.add(list);
    }

    public static void removeBlockEffectiveness(Block block, int n, String string) {
        List<Object> list = Arrays.asList(block, n, string);
        ForgeHooks.toolEffectiveness.remove(list);
    }

    public static void setBlockHarvestLevel(Block block, String string, int n) {
        for (int i = 0; i < 16; ++i) {
            List<Object> list = Arrays.asList(block, i, string);
            ForgeHooks.toolHarvestLevels.put(list, n);
            ForgeHooks.toolEffectiveness.add(list);
        }
    }

    public static int getBlockHarvestLevel(Block block, int n, String string) {
        ForgeHooks.initTools();
        List<Object> list = Arrays.asList(block, n, string);
        Integer n2 = ForgeHooks.toolHarvestLevels.get(list);
        return n2 == null ? -1 : n2;
    }

    public static void removeBlockEffectiveness(Block block, String string) {
        for (int i = 0; i < 16; ++i) {
            List<Object> list = Arrays.asList(block, i, string);
            ForgeHooks.toolEffectiveness.remove(list);
        }
    }

    public static void initialize() {
        System.out.printf("MinecraftForge v%s Initialized\n", ForgeVersion.getVersion());
        FMLLog.info("MinecraftForge v%s Initialized", ForgeVersion.getVersion());
        Block block = new Block(0, Material._a){

            @Override
            @SideOnly(value=Side.CLIENT)
            public void registerIcons(IconRegister iconRegister) {
            }
        };
        Block.blocksList[0] = null;
        Block.opaqueCubeLookup[0] = false;
        Block.lightOpacity[0] = 0;
        block.setUnlocalizedName("ForgeFiller");
        for (int i = 256; i < 4096; ++i) {
            if (Item.itemsList[i] == null) continue;
            Block.blocksList[i] = block;
        }
        boolean[] blArray = new boolean[4096];
        System.arraycopy(EntityEnderman.carriableBlocks, 0, blArray, 0, EntityEnderman.carriableBlocks.length);
        EntityEnderman.carriableBlocks = blArray;
        EVENT_BUS.register(INTERNAL_HANDLER);
        OreDictionary.getOreName(0);
        new CrashReport("ThisIsFake", new Exception("Not real"));
    }

    public static String getBrandingVersion() {
        return "Minecraft Forge " + ForgeVersion.getVersion();
    }
}

