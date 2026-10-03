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
import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;

@Mod(modid="DynamicLights", name="Dynamic Lights", version="1.2.8")
public class DynamicLights {
    private xpzm mcinstance;
    private static DynamicLights instance;
    private sdrg lastWorld;
    private ConcurrentLinkedQueue<DynamicLightSourceContainer> lastList;
    private ConcurrentHashMap<ozlu, ConcurrentLinkedQueue<DynamicLightSourceContainer>> worldLightsMap;

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

    public static int getLightValue(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n5 = twgu.field_71973_m[n] != null ? twgu.field_71973_m[n].getLightValue(sdrg2, n2, n3, n4) : 0;
        if (instance == null || sdrg2 instanceof yfgy) {
            return n5;
        }
        if (!sdrg2.equals(DynamicLights.instance.lastWorld) || DynamicLights.instance.lastList == null) {
            DynamicLights.instance.lastWorld = sdrg2;
            DynamicLights.instance.lastList = DynamicLights.instance.worldLightsMap.get(sdrg2);
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
            if (iDynamicLightSource.getAttachmentEntity().func_70089_S()) {
                DynamicLightSourceContainer dynamicLightSourceContainer = new DynamicLightSourceContainer(iDynamicLightSource);
                ConcurrentLinkedQueue<DynamicLightSourceContainer> concurrentLinkedQueue = DynamicLights.instance.worldLightsMap.get(iDynamicLightSource.getAttachmentEntity().field_70170_p);
                if (concurrentLinkedQueue != null) {
                    if (!concurrentLinkedQueue.contains(dynamicLightSourceContainer)) {
                        concurrentLinkedQueue.add(dynamicLightSourceContainer);
                    } else {
                        System.out.println("Cannot add Dynamic Light: Attachment Entity is already registered!");
                    }
                } else {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    concurrentLinkedQueue.add(dynamicLightSourceContainer);
                    DynamicLights.instance.worldLightsMap.put(iDynamicLightSource.getAttachmentEntity().field_70170_p, concurrentLinkedQueue);
                }
            } else {
                System.err.println("Cannot add Dynamic Light: Attachment Entity is dead!");
            }
        } else {
            System.err.println("Cannot add Dynamic Light: Attachment Entity is null!");
        }
    }

    public static void removeLightSource(IDynamicLightSource iDynamicLightSource) {
        ozlu ozlu2;
        if (iDynamicLightSource != null && iDynamicLightSource.getAttachmentEntity() != null && (ozlu2 = iDynamicLightSource.getAttachmentEntity().field_70170_p) != null) {
            DynamicLightSourceContainer dynamicLightSourceContainer = null;
            ConcurrentLinkedQueue<DynamicLightSourceContainer> concurrentLinkedQueue = DynamicLights.instance.worldLightsMap.get(ozlu2);
            if (concurrentLinkedQueue != null) {
                Iterator<DynamicLightSourceContainer> iterator2 = concurrentLinkedQueue.iterator();
                while (iterator2.hasNext()) {
                    dynamicLightSourceContainer = iterator2.next();
                    if (!dynamicLightSourceContainer.getLightSource().equals(iDynamicLightSource)) continue;
                    iterator2.remove();
                    break;
                }
                if (dynamicLightSourceContainer != null) {
                    ozlu2.func_72936_c(rrqi._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
                }
            }
        }
    }

    private class LightsOnOffKey
    extends KeyBindingRegistry.KeyHandler {
        private EnumSet<TickType> tickTypes;

        public LightsOnOffKey(eidj[] eidjArray, boolean[] blArray) {
            super(eidjArray, blArray);
            this.tickTypes = EnumSet.of(TickType.CLIENT);
        }

        @Override
        public String getLabel() {
            return "DynamicLightsKey";
        }

        @Override
        public void keyDown(EnumSet<TickType> enumSet, eidj eidj2, boolean bl, boolean bl2) {
        }

        @Override
        public void keyUp(EnumSet<TickType> enumSet, eidj eidj2, boolean bl) {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            pkix pkix2;
            if (bl && ((DynamicLights)DynamicLights.this).mcinstance._B == null && (pkix2 = ((DynamicLights)DynamicLights.this).mcinstance._r) != null && (concurrentLinkedQueue = (ConcurrentLinkedQueue)DynamicLights.this.worldLightsMap.get(pkix2)) != null) {
                for (DynamicLightSourceContainer dynamicLightSourceContainer : concurrentLinkedQueue) {
                    pkix2.func_72936_c(rrqi._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
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
                    ((DynamicLights)DynamicLights.this).mcinstance._r.func_72936_c(rrqi._b, dynamicLightSourceContainer.getX(), dynamicLightSourceContainer.getY(), dynamicLightSourceContainer.getZ());
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

