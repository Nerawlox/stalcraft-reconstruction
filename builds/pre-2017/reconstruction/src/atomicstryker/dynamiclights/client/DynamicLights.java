/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.client;

import atomicstryker.dynamiclights.client.DynamicLightSourceContainer;
import atomicstryker.dynamiclights.client.IDynamicLightSource;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

@Mod(modid="DynamicLights", name="Dynamic Lights", version="1.2.8")
public class DynamicLights {
    private Minecraft mcinstance;
    private static DynamicLights instance;
    private IBlockAccess lastWorld;
    private ConcurrentLinkedQueue<DynamicLightSourceContainer> lastList;
    private ConcurrentHashMap<World, ConcurrentLinkedQueue<DynamicLightSourceContainer>> worldLightsMap;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        instance = this;
        this.mcinstance = FMLClientHandler.instance().getClient();
        this.worldLightsMap = new ConcurrentHashMap();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent fMLInitializationEvent) {
        TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
    }

    public static boolean globalLightsOff() {
        return false;
    }

    public static int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n5 = Block.blocksList[n] != null ? Block.blocksList[n].getLightValue(iBlockAccess, n2, n3, n4) : 0;
        if (instance == null || iBlockAccess instanceof WorldServer) {
            return n5;
        }
        if (!iBlockAccess.equals(DynamicLights.instance.lastWorld) || DynamicLights.instance.lastList == null) {
            DynamicLights.instance.lastWorld = iBlockAccess;
            DynamicLights.instance.lastList = DynamicLights.instance.worldLightsMap.get(iBlockAccess);
        }
        if (DynamicLights.instance.lastList != null && !DynamicLights.instance.lastList.isEmpty()) {
            for (DynamicLightSourceContainer dynamicLightSourceContainer : DynamicLights.instance.lastList) {
                int n7;
                if (dynamicLightSourceContainer.getX() != n2 || dynamicLightSourceContainer.getY() != n3 || dynamicLightSourceContainer.getZ() != n4 || (n7 = dynamicLightSourceContainer.getLightSource().getLightLevel()) <= n5) continue;
                return n7;
            }
        }
        return n5;
    }

    public static void addLightSource(IDynamicLightSource iDynamicLightSource) {
        if (iDynamicLightSource.getAttachmentEntity() != null) {
            if (iDynamicLightSource.getAttachmentEntity().isEntityAlive()) {
                DynamicLightSourceContainer dynamicLightSourceContainer = new DynamicLightSourceContainer(iDynamicLightSource);
                ConcurrentLinkedQueue<DynamicLightSourceContainer> concurrentLinkedQueue = DynamicLights.instance.worldLightsMap.get(iDynamicLightSource.getAttachmentEntity().worldObj);
                if (concurrentLinkedQueue != null) {
                    if (!concurrentLinkedQueue.contains(dynamicLightSourceContainer)) {
                        concurrentLinkedQueue.add(dynamicLightSourceContainer);
                    } else {
                        System.out.println("Cannot add Dynamic Light: Attachment Entity is already registered!");
                    }
                } else {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    concurrentLinkedQueue.add(dynamicLightSourceContainer);
                    DynamicLights.instance.worldLightsMap.put(iDynamicLightSource.getAttachmentEntity().worldObj, concurrentLinkedQueue);
                }
            } else {
                System.err.println("Cannot add Dynamic Light: Attachment Entity is dead!");
            }
        } else {
            System.err.println("Cannot add Dynamic Light: Attachment Entity is null!");
        }
    }

    public static void removeLightSource(IDynamicLightSource iDynamicLightSource) {
        World world;
        if (iDynamicLightSource != null && iDynamicLightSource.getAttachmentEntity() != null && (world = iDynamicLightSource.getAttachmentEntity().worldObj) != null) {
            DynamicLightSourceContainer dynamicLightSourceContainer = null;
            ConcurrentLinkedQueue<DynamicLightSourceContainer> concurrentLinkedQueue = DynamicLights.instance.worldLightsMap.get(world);
            if (concurrentLinkedQueue != null) {
                Iterator<DynamicLightSourceContainer> iterator2 = concurrentLinkedQueue.iterator();
                while (iterator2.hasNext()) {
                    dynamicLightSourceContainer = iterator2.next();
                    if (!dynamicLightSourceContainer.getLightSource().equals(iDynamicLightSource)) continue;
                    iterator2.remove();
                    break;
                }
                if (dynamicLightSourceContainer != null) {
                    world.updateLightByType(EnumSkyBlock._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
                }
            }
        }
    }

    private class LightsOnOffKey
    extends KeyBindingRegistry.KeyHandler {
        private EnumSet<TickType> tickTypes;

        public LightsOnOffKey(KeyBinding[] keyBindingArray, boolean[] blArray) {
            super(keyBindingArray, blArray);
            this.tickTypes = EnumSet.of(TickType.CLIENT);
        }

        @Override
        public String getLabel() {
            return "DynamicLightsKey";
        }

        @Override
        public void keyDown(EnumSet<TickType> enumSet, KeyBinding keyBinding, boolean bl, boolean bl2) {
        }

        @Override
        public void keyUp(EnumSet<TickType> enumSet, KeyBinding keyBinding, boolean bl) {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            pkix pkix2;
            if (bl && ((DynamicLights)DynamicLights.this).mcinstance._B == null && (pkix2 = ((DynamicLights)DynamicLights.this).mcinstance._r) != null && (concurrentLinkedQueue = (ConcurrentLinkedQueue)DynamicLights.this.worldLightsMap.get(pkix2)) != null) {
                for (DynamicLightSourceContainer dynamicLightSourceContainer : concurrentLinkedQueue) {
                    pkix2.updateLightByType(EnumSkyBlock._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
                }
            }
        }

        @Override
        public EnumSet<TickType> ticks() {
            return this.tickTypes;
        }
    }

    private class TickHandler
    implements ITickHandler {
        private final EnumSet<TickType> ticks = EnumSet.of(TickType.CLIENT);

        @Override
        public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        }

        @Override
        public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            if (((DynamicLights)DynamicLights.this).mcinstance._r != null && (concurrentLinkedQueue = (ConcurrentLinkedQueue)DynamicLights.this.worldLightsMap.get(((DynamicLights)DynamicLights.this).mcinstance._r)) != null) {
                Iterator iterator2 = concurrentLinkedQueue.iterator();
                while (iterator2.hasNext()) {
                    DynamicLightSourceContainer dynamicLightSourceContainer = (DynamicLightSourceContainer)iterator2.next();
                    if (dynamicLightSourceContainer == null || !dynamicLightSourceContainer.onUpdate()) continue;
                    iterator2.remove();
                    ((DynamicLights)DynamicLights.this).mcinstance._r.updateLightByType(EnumSkyBlock._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
                }
            }
        }

        @Override
        public EnumSet<TickType> ticks() {
            return this.ticks;
        }

        @Override
        public String getLabel() {
            return "DynamicLights";
        }
    }
}

