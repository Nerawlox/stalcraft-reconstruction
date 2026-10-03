/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  ats
 *  cpw.mods.fml.client.registry.KeyBindingRegistry$KeyHandler
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.TickType
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.registry.TickRegistry
 *  cpw.mods.fml.relauncher.Side
 */
package atomicstryker.dynamiclights.client;

import atomicstryker.dynamiclights.client.DynamicLightSourceContainer;
import atomicstryker.dynamiclights.client.IDynamicLightSource;
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

@Mod(modid="DynamicLights", name="Dynamic Lights", version="1.2.8")
public class DynamicLights {
    private static DynamicLights instance;
    private acf lastWorld;
    private ConcurrentLinkedQueue lastList;
    private ConcurrentHashMap worldLightsMap;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        instance = this;
        this.worldLightsMap = new ConcurrentHashMap();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent evt) {
        TickRegistry.registerTickHandler((ITickHandler)new TickHandler(), (Side)Side.CLIENT);
    }

    public static boolean globalLightsOff() {
        return false;
    }

    public static int getLightValue(acf world, int blockID, int x2, int y2, int z2) {
        int vanillaValue;
        aqz block = aqz.s[blockID];
        int n = vanillaValue = block != null ? block.getLightValue(world, x2, y2, z2) : 0;
        if (instance != null && !(world instanceof js)) {
            if (!world.equals(DynamicLights.instance.lastWorld) || DynamicLights.instance.lastList == null) {
                DynamicLights.instance.lastWorld = world;
                DynamicLights.instance.lastList = (ConcurrentLinkedQueue)DynamicLights.instance.worldLightsMap.get(world);
            }
            if (DynamicLights.instance.lastList != null && !DynamicLights.instance.lastList.isEmpty()) {
                Iterator i$ = DynamicLights.instance.lastList.iterator();
                DynamicLightSourceContainer light = null;
                int dynamicValue = 0;
                while (i$.hasNext()) {
                    light = (DynamicLightSourceContainer)i$.next();
                    if (light.getX() != x2 || light.getY() != y2 || light.getZ() != z2 || (dynamicValue = light.getLightSource().getLightLevel()) <= vanillaValue) continue;
                    return dynamicValue;
                }
            }
            return vanillaValue;
        }
        return vanillaValue;
    }

    public static void addLightSource(IDynamicLightSource lightToAdd) {
        nn attachmentEntity = lightToAdd.getAttachmentEntity();
        if (attachmentEntity != null) {
            if (attachmentEntity.T()) {
                DynamicLightSourceContainer newLightContainer = new DynamicLightSourceContainer(lightToAdd);
                ConcurrentLinkedQueue<DynamicLightSourceContainer> lightList = (ConcurrentLinkedQueue<DynamicLightSourceContainer>)DynamicLights.instance.worldLightsMap.get(attachmentEntity.q);
                if (lightList != null) {
                    if (!lightList.contains(newLightContainer)) {
                        lightList.add(newLightContainer);
                    } else {
                        System.out.println("Cannot add Dynamic Light: Attachment Entity is already registered!");
                    }
                } else {
                    lightList = new ConcurrentLinkedQueue<DynamicLightSourceContainer>();
                    lightList.add(newLightContainer);
                    DynamicLights.instance.worldLightsMap.put(attachmentEntity.q, lightList);
                }
            } else {
                System.err.println("Cannot add Dynamic Light: Attachment Entity is dead!");
            }
        } else {
            System.err.println("Cannot add Dynamic Light: Attachment Entity is null!");
        }
    }

    public static void removeLightSource(IDynamicLightSource lightToRemove) {
        ConcurrentLinkedQueue lightList;
        abw world;
        if (lightToRemove != null && lightToRemove.getAttachmentEntity() != null && (world = lightToRemove.getAttachmentEntity().q) != null && (lightList = (ConcurrentLinkedQueue)DynamicLights.instance.worldLightsMap.get(world)) != null) {
            Iterator iter = lightList.iterator();
            DynamicLightSourceContainer lightSourceContainer = null;
            while (iter.hasNext()) {
                lightSourceContainer = (DynamicLightSourceContainer)iter.next();
                if (!lightSourceContainer.getLightSource().equals(lightToRemove)) continue;
                iter.remove();
                break;
            }
            if (lightSourceContainer != null) {
                world.c(ach.b, lightSourceContainer.getX(), lightSourceContainer.getY(), lightSourceContainer.getZ());
            }
        }
    }

    private class TickHandler
    implements ITickHandler {
        private final EnumSet ticks = EnumSet.of(TickType.CLIENT);
        private int tickLight;

        public void tickStart(EnumSet type, Object ... tickData) {
        }

        public void tickEnd(EnumSet type, Object ... tickData) {
            atv mc = atv.w();
            if (mc.f != null) {
                DynamicLightSourceContainer tickedLightContainer = null;
                ConcurrentLinkedQueue worldLights = (ConcurrentLinkedQueue)DynamicLights.this.worldLightsMap.get(mc.f);
                if (worldLights != null) {
                    Iterator iter = worldLights.iterator();
                    while (iter.hasNext()) {
                        tickedLightContainer = (DynamicLightSourceContainer)iter.next();
                        if (tickedLightContainer == null || !tickedLightContainer.onUpdate()) continue;
                        iter.remove();
                        mc.f.c(ach.b, tickedLightContainer.getX(), tickedLightContainer.getY(), tickedLightContainer.getZ());
                    }
                }
            }
        }

        public EnumSet ticks() {
            return this.ticks;
        }

        public String getLabel() {
            return "DynamicLights";
        }
    }

    private class LightsOnOffKey
    extends KeyBindingRegistry.KeyHandler {
        private EnumSet tickTypes;

        public LightsOnOffKey(ats[] keyBindings, boolean[] repeatings) {
            super(keyBindings, repeatings);
            this.tickTypes = EnumSet.of(TickType.CLIENT);
        }

        public String getLabel() {
            return "DynamicLightsKey";
        }

        public void keyDown(EnumSet types, ats kb, boolean tickEnd, boolean isRepeat) {
        }

        public void keyUp(EnumSet types, ats kb, boolean tickEnd) {
            ConcurrentLinkedQueue worldLights;
            atv mc = atv.w();
            if (tickEnd && mc.n == null && mc.f != null && (worldLights = (ConcurrentLinkedQueue)DynamicLights.this.worldLightsMap.get(mc.f)) != null) {
                for (DynamicLightSourceContainer c : worldLights) {
                    mc.f.c(ach.b, c.getX(), c.getY(), c.getZ());
                }
            }
        }

        public EnumSet ticks() {
            return this.tickTypes;
        }
    }
}

