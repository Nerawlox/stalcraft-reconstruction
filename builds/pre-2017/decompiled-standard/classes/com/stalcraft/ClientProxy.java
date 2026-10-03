/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft;

import com.stalcraft.ClientEvents;
import com.stalcraft.ServerProxy;
import com.stalcraft.StalcraftMod;
import com.stalcraft.entity.mob.EntityTuchkan;
import com.stalcraft.entity.mob.EntityVorona;
import com.stalcraft.entity.mob.EntityWolf;
import com.stalcraft.renderer.RenderStalcraftBlock;
import com.stalcraft.renderer.RenderTallGrass;
import com.stalcraft.renderer.RendererBarricade;
import com.stalcraft.renderer.RendererBlueShelf;
import com.stalcraft.renderer.RendererBottles;
import com.stalcraft.renderer.RendererCabinet;
import com.stalcraft.renderer.RendererCash;
import com.stalcraft.renderer.RendererConcreteWall;
import com.stalcraft.renderer.RendererMetalShelf;
import com.stalcraft.renderer.RendererStellage;
import com.stalcraft.renderer.RendererUrn;
import com.stalcraft.renderer.mobs.RendererTuchkan;
import com.stalcraft.renderer.mobs.RendererVorona;
import com.stalcraft.renderer.mobs.RendererWolf;
import com.stalcraft.tile.TileEntityBarricade;
import com.stalcraft.tile.TileEntityBlueShelf;
import com.stalcraft.tile.TileEntityBottles;
import com.stalcraft.tile.TileEntityCabinet;
import com.stalcraft.tile.TileEntityCash;
import com.stalcraft.tile.TileEntityConcreteWall;
import com.stalcraft.tile.TileEntityMetalShelf;
import com.stalcraft.tile.TileEntityStellage;
import com.stalcraft.tile.TileEntityUrn;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraftforge.common.MinecraftForge;

@ezey(_a={eidj.CLIENT})
public class ClientProxy
extends ServerProxy {
    @Override
    public void preload() {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        RenderingRegistry.registerEntityRenderingHandler(EntityVorona.class, new RendererVorona());
        RenderingRegistry.registerEntityRenderingHandler(EntityTuchkan.class, new RendererTuchkan());
        RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, new RendererWolf());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricade.class, new RendererBarricade());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCash.class, new RendererCash());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetalShelf.class, new RendererMetalShelf());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueShelf.class, new RendererBlueShelf());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStellage.class, new RendererStellage());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCabinet.class, new RendererCabinet());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUrn.class, new RendererUrn());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBottles.class, new RendererBottles());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConcreteWall.class, new RendererConcreteWall());
        StalcraftMod.grassRenderId = 265;
        RenderingRegistry.registerBlockHandler(265, RenderTallGrass.instance);
        RenderStalcraftBlock renderStalcraftBlock = new RenderStalcraftBlock("/assets/stalcraft/models/fence.obj", 1.0f, 1.5f, 1.0f);
        RenderingRegistry.registerBlockHandler(renderStalcraftBlock.getRenderId(), renderStalcraftBlock);
        StalcraftMod.fenceRenderId = renderStalcraftBlock.getRenderId();
        RenderStalcraftBlock renderStalcraftBlock2 = new RenderStalcraftBlock("/assets/stalcraft/models/fence_broken.obj", 1.0f, 1.5f, 1.0f);
        RenderingRegistry.registerBlockHandler(renderStalcraftBlock2.getRenderId(), renderStalcraftBlock2);
        StalcraftMod.fenceBrokenRenderId = renderStalcraftBlock2.getRenderId();
        RenderStalcraftBlock renderStalcraftBlock3 = new RenderStalcraftBlock("/assets/stalcraft/models/fence_fallen.obj", 1.0f, 1.0f, 1.5f);
        RenderingRegistry.registerBlockHandler(renderStalcraftBlock3.getRenderId(), renderStalcraftBlock3);
        StalcraftMod.fenceFallenRenderId = renderStalcraftBlock3.getRenderId();
        RenderStalcraftBlock renderStalcraftBlock4 = new RenderStalcraftBlock("/assets/stalcraft/models/fence_corner.obj", 1.0f, 1.5f, 1.0f);
        RenderingRegistry.registerBlockHandler(renderStalcraftBlock4.getRenderId(), renderStalcraftBlock4);
        StalcraftMod.fenceCornerRenderId = renderStalcraftBlock4.getRenderId();
        renderStalcraftBlock4.uFactor = 2.0f;
        renderStalcraftBlock3.uFactor = 2.0f;
        renderStalcraftBlock2.uFactor = 2.0f;
        renderStalcraftBlock.uFactor = 2.0f;
        RenderStalcraftBlock renderStalcraftBlock5 = new RenderStalcraftBlock("/assets/stalcraft/models/mine.obj", 1.0f, 1.0f, 1.0f);
        RenderingRegistry.registerBlockHandler(renderStalcraftBlock5.getRenderId(), renderStalcraftBlock5);
        StalcraftMod.mineRenderId = renderStalcraftBlock5.getRenderId();
    }

    @Override
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        super.load(fMLInitializationEvent);
    }

    @Override
    public void postload(FMLPostInitializationEvent fMLPostInitializationEvent) {
        super.postload(fMLPostInitializationEvent);
    }
}

