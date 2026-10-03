/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyAPI;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.hank;
import gloomyfolken.mods.physics.core.PhysicsMod;
import gloomyfolken.mods.physics.core.client.world.PhysicsManager;
import gloomyfolken.mods.physics.ragdolls.NpcsRagdolls;
import gloomyfolken.mods.physics.ragdolls.client.RagdollsClient;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SavedAnimationStateEntry;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseAnimal;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBagAnimal;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpsePlayer;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.inventory.ContainerCorpse;
import gloomyfolken.mods.physics.ragdolls.items.ItemCorpseRemover;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.player.qlgf;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

@Mod(modid="Ragdolls", name="ZnW's Ragdoll Corpses Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyPlayer;required-after:Physics;required-after:StalkerMobs")
@NetworkMod(clientSideRequired=true)
public class RagdollsMod {
    public static final String modid = "Ragdolls";
    @Mod.Instance(value="Ragdolls")
    public static RagdollsMod instance;
    public static final String CORPSE_BAG_SPAWN_DELAY = "corpse_bag_spawn_delay";
    public static final String CORPSE_BAG_EMPTY_LIFETIME = "corpse_bag_empty_lifetime";
    public static final String CORPSE_BAG_LOOTED_LIFETIME = "corpse_bag_looted_lifetime";
    public static final String CORPSE_BAG_UNLOOTED_LIFETIME = "corpse_bag_unlooted_lifetime";
    public static double LOOT_PICKUP_DISTANCE;
    public static int CORPSE_REMOVER_ID;
    private static int TICKS_CACHE_RAGDOLL_STATE;
    @ezey(_a={eidj.CLIENT})
    private HashMap<Integer, SavedAnimationStateEntry> savedRagdollStates;
    private hank<Entity, EntityRagdollCorpse> corpseFactory = new hank(Entity.class);
    private int typeEntityId = 0;
    @ezey(_a={eidj.CLIENT})
    public RagdollsClient ragdollsClient;
    public boolean tracingCorpses = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        GloomyAPI.registerAssetsDir("ragdolls", this.getClass());
        Configuration configuration = new Configuration(fMLPreInitializationEvent.getSuggestedConfigurationFile());
        this.putIntModOption(configuration, CORPSE_BAG_SPAWN_DELAY, 30000);
        this.putIntModOption(configuration, CORPSE_BAG_EMPTY_LIFETIME, 10000);
        this.putIntModOption(configuration, CORPSE_BAG_LOOTED_LIFETIME, 600000);
        this.putIntModOption(configuration, CORPSE_BAG_UNLOOTED_LIFETIME, 1800000);
        configuration.save();
    }

    private void putIntModOption(Configuration configuration, String string, int n) {
        int n2 = configuration.get("general", string, n).getInt(n);
        GloomyCore.instance.modOptions.put(string, n2);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this);
        EntityRegistry.registerModEntity(EntityCorpseBag.class, "EntityCorpseBag", this.typeEntityId++, this, 64, 100000000, false);
        EntityRegistry.registerModEntity(EntityCorpseBagAnimal.class, "EntityCorpseBagAnimal", this.typeEntityId++, this, 64, 100000000, false);
        EntityRegistry.registerModEntity(EntityCorpseAnimal.class, "EntityCorpseAnimal", this.typeEntityId++, this, 64, 20, false);
        EntityRegistry.registerModEntity(EntityCorpsePlayer.class, "EntityCorpsePlayer", this.typeEntityId++, this, 64, 20, false);
        PhysicsMod.instance.registerStateFactory(EntityCorpseAnimal.class, CorpseRagdollState::new);
        PhysicsMod.instance.registerStateFactory(EntityCorpsePlayer.class, CorpseRagdollState::new);
        GameRegistry.registerItem(new ItemCorpseRemover(), "corpseremover");
        this.corpseFactory._a(EntityMutant.class, entityMutant -> {
            if (!entityMutant.spawnsCorpse()) {
                return null;
            }
            return new EntityCorpseAnimal(entityMutant.worldObj).init((EntityLivingBase)entityMutant, entityMutant.getProperties().getDroppedStuff((EntityMutant)entityMutant));
        });
        if (ModLoader.isModLoaded("customnpcs")) {
            this.typeEntityId = NpcsRagdolls.INSTANCE.registerCustomNpcStuff(fMLInitializationEvent, this.typeEntityId, this.corpseFactory);
        }
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> {
            this.initClient();
            this.savedRagdollStates = new HashMap();
        });
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent fMLServerStartingEvent) {
        fMLServerStartingEvent.registerServerCommand(new ICommand(){

            @Override
            public String getCommandName() {
                return "despawn";
            }

            @Override
            public String getCommandUsage(ICommandSender iCommandSender) {
                return "type in /despawn [corpse/bag/mutant] [radius]";
            }

            @Override
            public List getCommandAliases() {
                return null;
            }

            @Override
            public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
                if (iCommandSender instanceof EntityPlayer) {
                    EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
                    if (stringArray != null && stringArray.length >= 2) {
                        Class clazz;
                        String string;
                        switch (string = stringArray[0].toLowerCase()) {
                            case "corpse": {
                                clazz = EntityRagdollCorpse.class;
                                break;
                            }
                            case "bag": {
                                clazz = EntityCorpseBag.class;
                                break;
                            }
                            case "mutant": {
                                clazz = EntityMutant.class;
                                break;
                            }
                            default: {
                                clazz = null;
                            }
                        }
                        if (clazz != null) {
                            double d = Integer.parseInt(stringArray[1]);
                            if (d < 0.0) {
                                d = 0.0;
                            }
                            if (d > 256.0) {
                                d = 256.0;
                            }
                            List list2 = entityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity((EntityPlayer)iCommandSender, ((EntityPlayer)iCommandSender).boundingBox._b(d, d, d));
                            for (Entity entity : list2) {
                                if (!clazz.isAssignableFrom(entity.getClass())) continue;
                                entity.isDead = true;
                            }
                        }
                    } else {
                        iCommandSender.sendChatToPlayer(new ChatMessageComponent()._a(this.getCommandUsage(iCommandSender)));
                    }
                }
            }

            @Override
            public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
                return MinecraftServer._I().__ag()._g(iCommandSender.getCommandSenderName());
            }

            @Override
            public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
                if (stringArray.length == 1) {
                    return CommandBase.getListOfStringsMatchingLastWord(stringArray, "corpse", "bag", "mutant");
                }
                return null;
            }

            @Override
            public boolean isUsernameIndex(String[] stringArray, int n) {
                return false;
            }

            public int compareTo(Object object) {
                return 0;
            }
        });
    }

    @ezey(_a={eidj.CLIENT})
    private void initClient() {
        this.ragdollsClient = new RagdollsClient();
        this.ragdollsClient.init();
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void clientTick(WorldEvent.Unload unload) {
        if (unload.world.isRemote) {
            PhysicsManager.INSTANCE.clearAll();
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void enableShotCorpseTrace(yund.jgro.pidb pidb2) {
        this.tracingCorpses = true;
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void disableShotCorpseTrace(yund.jgro.kjui kjui2) {
        this.tracingCorpses = false;
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void onCorpseInteract(piyh piyh2) {
        World world = piyh2.entityPlayer.worldObj;
        if (world.isRemote) {
            this.tracingCorpses = true;
            MovingObjectPosition movingObjectPosition = Minecraft._E()._L;
            Minecraft._E()._D.getMouseOver(Minecraft._E()._p._d);
            MovingObjectPosition movingObjectPosition2 = Minecraft._E()._L;
            if (movingObjectPosition2 != null && movingObjectPosition2._c == EnumMovingObjectType._b && movingObjectPosition2._i instanceof EntityRagdollCorpse && movingObjectPosition2._i.interactFirst(Minecraft._E()._t)) {
                piyh2.setCanceled(true);
            }
            Minecraft._E()._L = movingObjectPosition;
            this.tracingCorpses = false;
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void clientTick(lnrm.kjui kjui2) {
        pkix pkix2 = Minecraft._E()._r;
        if (kjui2._c == lnrm.pidb._a && pkix2 != null && pkix2.getTotalWorldTime() % 100L == 0L) {
            this.savedRagdollStates.entrySet().removeIf(entry -> pkix2.getTotalWorldTime() > ((SavedAnimationStateEntry)entry.getValue()).getTickSavedAt() + (long)TICKS_CACHE_RAGDOLL_STATE);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public ivtm saveRagdollState(int n, ivtm ivtm2, Vec3 vec3, AxisAlignedBB axisAlignedBB) {
        SavedAnimationStateEntry savedAnimationStateEntry = new SavedAnimationStateEntry(n, Minecraft._E()._r.getTotalWorldTime(), ivtm2, vec3, axisAlignedBB);
        this.savedRagdollStates.put(n, savedAnimationStateEntry);
        return null;
    }

    @ezey(_a={eidj.CLIENT})
    public SavedAnimationStateEntry getSavedRagdollState(int n) {
        return this.savedRagdollStates.get(n);
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    @ezey(_a={eidj.CLIENT})
    public void onRenderPlayerPre(RenderPlayerEvent.Pre pre) {
        if (pre.entity.isDead || pre.entityPlayer.getHealth() <= 0.0f) {
            pre.setCanceled(true);
        }
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    @ezey(_a={eidj.CLIENT})
    public void onRenderPlayerPre1(qlgf.pidb pidb2) {
        if (pidb2._a.isDead || pidb2._a.getHealth() <= 0.0f) {
            pidb2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void canInteract(jhla.kjui kjui2) {
        double d = Math.hypot(kjui2._a.owner.posX - kjui2._b.posX, kjui2._a.owner.posZ - kjui2._b.posZ);
        if (kjui2._a.containerData._o("corpse") && d < LOOT_PICKUP_DISTANCE) {
            kjui2.setResult(Event.Result.ALLOW);
        }
    }

    @ForgeSubscribe
    public void onSlotClick(jhla.ezey ezey2) {
        if (ezey2._a.containerData._o("corpse") && ezey2._c >= 0 && ezey2._d == 1 && ezey2._a.getSlot(ezey2._c) != null && ezey2._a.getSlot(ezey2._c).getHasStack()) {
            if (!ezey2.entity.worldObj.isRemote) {
                InvokeSideOnly.frontend(() -> {});
            }
            ezey2.setCanceled(true);
        }
    }

    public static ContainerCorpse createCorpseContainer(CorpseInventoryProvider corpseInventoryProvider) {
        ContainerCorpse containerCorpse = new ContainerCorpse(corpseInventoryProvider, corpseInventoryProvider.getCorpseInventory());
        containerCorpse.containerData._a("corpse", true);
        if (corpseInventoryProvider.isServer()) {
            InvokeSideOnly.frontend(() -> {});
        }
        return containerCorpse;
    }

    public static boolean getNoCorpses() {
        return GloomyCore.getBooleanOption("no_corpses");
    }

    static {
        LOOT_PICKUP_DISTANCE = 20.0;
        CORPSE_REMOVER_ID = 14995;
        TICKS_CACHE_RAGDOLL_STATE = 6000;
    }
}

