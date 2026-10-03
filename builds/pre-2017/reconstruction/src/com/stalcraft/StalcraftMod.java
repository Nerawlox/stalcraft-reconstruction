/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft;

import com.stalcraft.ServerProxy;
import com.stalcraft.blocks.BlockBarricade;
import com.stalcraft.blocks.BlockBlueShelf;
import com.stalcraft.blocks.BlockBottles;
import com.stalcraft.blocks.BlockCabinet;
import com.stalcraft.blocks.BlockCash;
import com.stalcraft.blocks.BlockConcreteWall;
import com.stalcraft.blocks.BlockFence;
import com.stalcraft.blocks.BlockFenceBroken;
import com.stalcraft.blocks.BlockFenceCorner;
import com.stalcraft.blocks.BlockFenceFallen;
import com.stalcraft.blocks.BlockInvisible;
import com.stalcraft.blocks.BlockMetalShelf;
import com.stalcraft.blocks.BlockStellage;
import com.stalcraft.blocks.BlockTallGrass;
import com.stalcraft.blocks.BlockUrn;
import com.stalcraft.entity.mob.EntityTuchkan;
import com.stalcraft.entity.mob.EntityVorona;
import com.stalcraft.entity.mob.EntityWolf;
import com.stalcraft.tile.TileEntityBarricade;
import com.stalcraft.tile.TileEntityBlueShelf;
import com.stalcraft.tile.TileEntityBottles;
import com.stalcraft.tile.TileEntityCabinet;
import com.stalcraft.tile.TileEntityCash;
import com.stalcraft.tile.TileEntityConcreteWall;
import com.stalcraft.tile.TileEntityMetalShelf;
import com.stalcraft.tile.TileEntityStellage;
import com.stalcraft.tile.TileEntityUrn;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid="STALCRAFT", name="STALCRAFT", version="1.1", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true, serverSideRequired=true, versionBounds="1.1.0")
public class StalcraftMod {
    @Mod.Instance(value="STALCRAFT")
    public static StalcraftMod instance;
    @Mod.Metadata(value="STALCRAFT")
    public static ModMetadata meta;
    private static StalcraftMod theSTALCRAFT;
    @SidedProxy(modId="STALCRAFT", clientSide="com.stalcraft.ClientProxy", serverSide="com.stalcraft.ServerProxy")
    public static ServerProxy proxy;
    public static Block brokenFence;
    public static Block fallenFence;
    public static Block fenceCorner;
    public static Block fence;
    public static Block barricade;
    public static Block cash;
    public static Block metalShelf;
    public static Block blueShelf;
    public static Block stellage;
    public static Block invisibleBlock;
    public static Block cabinet;
    public static Block urn;
    public static Block bottles;
    public static Block concreteWall;
    public static BlockTallGrass tallGrass;
    public static int grassRenderId;
    public static int fenceRenderId;
    public static int fenceFallenRenderId;
    public static int fenceBrokenRenderId;
    public static int fenceCornerRenderId;
    public static int mineRenderId;

    public static StalcraftMod getSTALCRAFT() {
        return theSTALCRAFT;
    }

    @Mod.PreInit
    public void preLoad(FMLPreInitializationEvent fMLPreInitializationEvent) {
    }

    @Mod.Init
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        proxy.preload();
        EntityRegistry.registerGlobalEntityID(EntityTuchkan.class, "EntityTuchkan", 106, 0, 512);
        EntityRegistry.registerGlobalEntityID(EntityVorona.class, "EntityVorona", 107, 8, 128);
        EntityRegistry.registerGlobalEntityID(EntityWolf.class, "EntityWolf", 108, 16, 64);
        GameRegistry.registerBlock(brokenFence);
        GameRegistry.registerBlock(fallenFence);
        GameRegistry.registerBlock(fenceCorner);
        GameRegistry.registerBlock(fence);
        GameRegistry.registerBlock(barricade);
        GameRegistry.registerTileEntity(TileEntityBarricade.class, "PBarricade");
        GameRegistry.registerBlock(cash);
        GameRegistry.registerTileEntity(TileEntityCash.class, "Apparat");
        GameRegistry.registerBlock(metalShelf);
        GameRegistry.registerTileEntity(TileEntityMetalShelf.class, "SShelf");
        GameRegistry.registerBlock(blueShelf);
        GameRegistry.registerTileEntity(TileEntityBlueShelf.class, "BShelf");
        GameRegistry.registerBlock(stellage);
        GameRegistry.registerTileEntity(TileEntityStellage.class, "Stellage");
        GameRegistry.registerBlock(cabinet);
        GameRegistry.registerTileEntity(TileEntityCabinet.class, "Cabinet");
        GameRegistry.registerBlock(invisibleBlock);
        GameRegistry.registerTileEntity(TileEntityUrn.class, "TBin");
        GameRegistry.registerBlock(urn);
        GameRegistry.registerTileEntity(TileEntityBottles.class, "Other");
        GameRegistry.registerBlock(bottles);
        GameRegistry.registerTileEntity(TileEntityConcreteWall.class, "CWall");
        GameRegistry.registerBlock(concreteWall);
        GameRegistry.registerBlock(tallGrass);
        LanguageRegistry.addName(brokenFence, "\u0421\u0438\u043b\u044c\u043d\u043e \u041f\u043e\u043b\u043e\u043c\u0430\u043d\u043d\u044b\u0439 \u0417\u0430\u0431\u043e\u0440");
        LanguageRegistry.addName(fallenFence, "\u0423\u043f\u0430\u0432\u0448\u0438\u0439 \u0417\u0430\u0431\u043e\u0440");
        LanguageRegistry.addName(fenceCorner, "\u0423\u0433\u043b\u043e\u0432\u043e\u0439 \u0417\u0430\u0431\u043e\u0440");
        LanguageRegistry.addName(fence, "\u0417\u0430\u0431\u043e\u0440");
        LanguageRegistry.addName(barricade, "\u0414\u0435\u0440\u0435\u0432\u044f\u043d\u043d\u0430\u044f \u0411\u0430\u0440\u0438\u043a\u0430\u0434\u0430");
        LanguageRegistry.addName(cash, "\u041a\u0430\u0441\u0441\u043e\u0432\u044b\u0439 \u0410\u043f\u043f\u0430\u0440\u0430\u0442");
        LanguageRegistry.addName(metalShelf, "\u041c\u0430\u0433\u0430\u0437\u0438\u043d\u044b\u0435 \u041f\u043e\u043b\u043a\u0438");
        LanguageRegistry.addName(blueShelf, "\u0413\u043e\u043b\u0443\u0431\u043e\u0439 \u0428\u043a\u0430\u0444\u0447\u0438\u043a");
        LanguageRegistry.addName(stellage, "\u0421\u0442\u0435\u043b\u043b\u0430\u0436");
        LanguageRegistry.addName(invisibleBlock, "\u041d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0439 \u0411\u043b\u043e\u043a");
        LanguageRegistry.addName(cabinet, "\u0416\u0435\u043b\u0435\u0437\u043d\u044b\u0439 \u0428\u043a\u0430\u0444");
        LanguageRegistry.addName(urn, "\u0423\u0440\u043d\u0430");
        LanguageRegistry.addName(bottles, "\u0411\u0443\u0442\u044b\u043b\u043a\u0438 \u0441 \u041f\u0430\u0441\u0445\u0430\u043b\u043a\u0430\u043c\u0438");
        LanguageRegistry.addName(concreteWall, "\u0411\u0435\u0442\u043e\u043d\u043d\u0430\u044f \u0441\u0442\u0435\u043d\u0430");
        LanguageRegistry.addName(tallGrass, "\u0422\u0440\u0430\u0432\u0430");
        proxy.load(fMLInitializationEvent);
    }

    @Mod.PostInit
    public void postLoad(FMLPostInitializationEvent fMLPostInitializationEvent) {
        proxy.postload(fMLPostInitializationEvent);
    }

    static {
        brokenFence = new BlockFenceBroken(4001, Material._d).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.hfence");
        fallenFence = new BlockFenceFallen(4002, Material._d).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.hfence2");
        fenceCorner = new BlockFenceCorner(4003, Material._d).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.hfcorner");
        fence = new BlockFence(4004, Material._d).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.fence");
        barricade = new BlockBarricade(4005, Material._d).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.barricade");
        cash = new BlockCash(4007, 0).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.apparat");
        metalShelf = new BlockMetalShelf(4009, 0).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.sshelf");
        blueShelf = new BlockBlueShelf(4010, 0).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.bshelf");
        stellage = new BlockStellage(4011, 0).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.stellage");
        invisibleBlock = new BlockInvisible(4012, Material._c).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.invblock");
        cabinet = new BlockCabinet(4013, 0).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.cabinet");
        urn = new BlockUrn(4014, Material._f).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.tbin");
        bottles = new BlockBottles(4015, Material._s).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.other");
        concreteWall = new BlockConcreteWall(4016, Material._c).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.cwall");
        tallGrass = (BlockTallGrass)new BlockTallGrass(4017, Material._l).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("stalcraft.block.grass");
    }
}

