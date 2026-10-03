/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.effects.client.main.jxtc;
import mods.regions.RegionsEventHandler;
import mods.regions.block.BlockPreset;
import mods.regions.client.RegionsGameHandler;
import mods.regions.client.RegionsRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="RegionsMod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
public class RegionsMod {
    public static Item flagAxe;
    @ezey(_a={eidj.CLIENT})
    public static RegionsGameHandler regionsClient;
    @Mod.Instance(value="RegionsMod")
    public static RegionsMod instance;
    public static Block presetBlock;
    @ezey(_a={eidj.CLIENT})
    public static jxtc noPvpShader;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        presetBlock = new BlockPreset(3778);
        GameRegistry.registerBlock(presetBlock);
        flagAxe = new Item(14722).setUnlocalizedName("flag_axe").setMaxStackSize(1).setTextureName("wood_axe").setFull3D();
        LanguageRegistry.addName(flagAxe, "\u0422\u043e\u043f\u043e\u0440 \u0434\u043b\u044f \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u0438\u044f");
        InvokeSideOnly.frontend(fMLInitializationEvent.getSide().isServer() || GloomyLoadingPlugin._a, () -> {});
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> this.initClient());
        MinecraftForge.EVENT_BUS.register(new RegionsEventHandler());
        InvokeSideOnly.frontend(fMLInitializationEvent.getSide().isServer(), () -> {});
    }

    @ezey(_a={eidj.CLIENT})
    private void initClient() {
        noPvpShader = new jxtc("pda", "nopvp");
        regionsClient = new RegionsGameHandler();
        GloomyAPI.registerGameHandler(regionsClient);
        MinecraftForge.EVENT_BUS.register(new RegionsRenderer());
    }
}

