/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.modloader;

import com.google.common.base.Equivalence;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import cpw.mods.fml.client.modloader.ModLoaderBlockRendererHandler;
import cpw.mods.fml.client.modloader.ModLoaderKeyBindingHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.IModLoaderSidedHelper;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.BaseMod;

public class ModLoaderClientHelper
implements IModLoaderSidedHelper {
    private Minecraft client;
    private static Multimap<ModLoaderModContainer, ModLoaderKeyBindingHandler> keyBindingContainers;
    private Map<jjpj, NetHandler> managerLookups = new MapMaker().weakKeys().weakValues().makeMap();

    public static int obtainBlockModelIdFor(BaseMod baseMod, boolean bl) {
        int n = RenderingRegistry.getNextAvailableRenderId();
        ModLoaderBlockRendererHandler modLoaderBlockRendererHandler = new ModLoaderBlockRendererHandler(n, bl, baseMod);
        RenderingRegistry.registerBlockHandler(modLoaderBlockRendererHandler);
        return n;
    }

    public static void handleFinishLoadingFor(ModLoaderModContainer modLoaderModContainer, Minecraft minecraft) {
        FMLLog.log(modLoaderModContainer.getModId(), Level.FINE, "Handling post startup activities for ModLoader mod %s", modLoaderModContainer.getModId());
        BaseMod baseMod = (BaseMod)modLoaderModContainer.getMod();
        HashMap<Class<? extends Entity>, Render> hashMap = Maps.newHashMap(RenderManager._b._a);
        try {
            FMLLog.log(modLoaderModContainer.getModId(), Level.FINEST, "Requesting renderers from basemod %s", modLoaderModContainer.getModId());
            baseMod.addRenderer(hashMap);
            FMLLog.log(modLoaderModContainer.getModId(), Level.FINEST, "Received %d renderers from basemod %s", hashMap.size(), modLoaderModContainer.getModId());
        }
        catch (Exception exception) {
            FMLLog.log(modLoaderModContainer.getModId(), Level.SEVERE, exception, "A severe problem was detected with the mod %s during the addRenderer call. Continuing, but expect odd results", modLoaderModContainer.getModId());
        }
        MapDifference<Class<? extends Entity>, Object> mapDifference = Maps.difference(RenderManager._b._a, hashMap, Equivalence.identity());
        for (Map.Entry<Class<? extends Entity>, Object> entry : mapDifference.entriesOnlyOnLeft().entrySet()) {
            FMLLog.log(modLoaderModContainer.getModId(), Level.WARNING, "The mod %s attempted to remove an entity renderer %s from the entity map. This will be ignored.", modLoaderModContainer.getModId(), entry.getKey().getName());
        }
        for (Map.Entry<Class<? extends Entity>, Object> entry : mapDifference.entriesOnlyOnRight().entrySet()) {
            FMLLog.log(modLoaderModContainer.getModId(), Level.FINEST, "Registering ModLoader entity renderer %s as instance of %s", entry.getKey().getName(), ((Render)entry.getValue()).getClass().getName());
            RenderingRegistry.registerEntityRenderingHandler(entry.getKey(), (Render)entry.getValue());
        }
        for (Map.Entry<Class<? extends Entity>, Object> entry : mapDifference.entriesDiffering().entrySet()) {
            FMLLog.log(modLoaderModContainer.getModId(), Level.FINEST, "Registering ModLoader entity rendering override for %s as instance of %s", entry.getKey().getName(), ((Render)((MapDifference.ValueDifference)entry.getValue()).rightValue()).getClass().getName());
            RenderingRegistry.registerEntityRenderingHandler(entry.getKey(), (Render)((MapDifference.ValueDifference)entry.getValue()).rightValue());
        }
        try {
            baseMod.registerAnimation(minecraft);
        }
        catch (Exception exception) {
            FMLLog.log(modLoaderModContainer.getModId(), Level.SEVERE, exception, "A severe problem was detected with the mod %s during the registerAnimation call. Continuing, but expect odd results", modLoaderModContainer.getModId());
        }
    }

    public ModLoaderClientHelper(Minecraft minecraft) {
        this.client = minecraft;
        ModLoaderHelper.sidedHelper = this;
        keyBindingContainers = Multimaps.newMultimap(Maps.newHashMap(), new Supplier<Collection<ModLoaderKeyBindingHandler>>(){

            @Override
            public Collection<ModLoaderKeyBindingHandler> get() {
                return Collections.singleton(new ModLoaderKeyBindingHandler());
            }
        });
    }

    @Override
    public void finishModLoading(ModLoaderModContainer modLoaderModContainer) {
        ModLoaderClientHelper.handleFinishLoadingFor(modLoaderModContainer, this.client);
    }

    public static void registerKeyBinding(BaseModProxy baseModProxy, KeyBinding keyBinding, boolean bl) {
        ModLoaderModContainer modLoaderModContainer = (ModLoaderModContainer)Loader.instance().activeModContainer();
        ModLoaderKeyBindingHandler modLoaderKeyBindingHandler = Iterables.getOnlyElement(keyBindingContainers.get(modLoaderModContainer));
        modLoaderKeyBindingHandler.setModContainer(modLoaderModContainer);
        modLoaderKeyBindingHandler.addKeyBinding(keyBinding, bl);
        KeyBindingRegistry.registerKeyBinding(modLoaderKeyBindingHandler);
    }

    @Override
    public Object getClientGui(BaseModProxy baseModProxy, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        return ((BaseMod)baseModProxy).getContainerGUI((EntityClientPlayerMP)entityPlayer, n, n2, n3, n4);
    }

    @Override
    public Entity spawnEntity(BaseModProxy baseModProxy, EntitySpawnPacket entitySpawnPacket, EntityRegistry.EntityRegistration entityRegistration) {
        return ((BaseMod)baseModProxy).spawnEntity(entityRegistration.getModEntityId(), this.client._r, entitySpawnPacket.scaledX, entitySpawnPacket.scaledY, entitySpawnPacket.scaledZ);
    }

    @Override
    public void sendClientPacket(BaseModProxy baseModProxy, Packet250CustomPayload packet250CustomPayload) {
        ((BaseMod)baseModProxy).clientCustomPayload(this.client._t.sendQueue, packet250CustomPayload);
    }

    @Override
    public void clientConnectionOpened(NetHandler netHandler, jjpj jjpj2, BaseModProxy baseModProxy) {
        this.managerLookups.put(jjpj2, netHandler);
        ((BaseMod)baseModProxy).clientConnect((bscn)netHandler);
    }

    @Override
    public boolean clientConnectionClosed(jjpj jjpj2, BaseModProxy baseModProxy) {
        if (this.managerLookups.containsKey(jjpj2)) {
            ((BaseMod)baseModProxy).clientDisconnect((bscn)this.managerLookups.get(jjpj2));
            return true;
        }
        return false;
    }
}

