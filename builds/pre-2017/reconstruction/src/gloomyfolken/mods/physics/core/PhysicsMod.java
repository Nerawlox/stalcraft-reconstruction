/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.turb;
import gloomyfolken.mods.physics.core.EntityPhysicsState;
import gloomyfolken.mods.physics.core.client.PhysicsThread;
import gloomyfolken.mods.physics.core.client.world.DefaultWorldSettings;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import org.lwjgl.opengl.GL11;

@Mod(modid="Physics", name="ZnW's Physics Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore")
@NetworkMod(clientSideRequired=true)
public class PhysicsMod {
    public static final String modid = "Physics";
    @Mod.Instance(value="Physics")
    public static PhysicsMod instance;
    private turb<Entity, EntityPhysicsState> stateFactory = new turb(Entity.class);

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        if (fMLInitializationEvent.getSide() == Side.CLIENT) {
            InvokeSideOnly.client(() -> {
                if (PhysicsThread.INSTANCE.getMULTITHREAD()) {
                    PhysicsThread.INSTANCE.start();
                }
                MinecraftForge.EVENT_BUS.register(this);
                this.initClient();
            });
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void initClient() {
        DynamicsWorldRef dynamicsWorldRef = new DefaultWorldSettings().createNewWorld();
        dynamicsWorldRef.getDynamicsWorld().stepSimulation(1.0f);
        dynamicsWorldRef.getDynamicsWorld().destroy();
    }

    public void registerStateFactory(Class<? extends Entity> clazz, Supplier<EntityPhysicsState> supplier) {
        this.stateFactory._a(clazz, supplier);
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void tick(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._a) {
            PhysicsThread.INSTANCE.updateMcClientState();
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void renderBulletWorlds(RenderWorldLastEvent renderWorldLastEvent) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP != null && PhysicsThread.INSTANCE.getRENDER()) {
            double d = entityClientPlayerMP.lastTickPosX + (entityClientPlayerMP.posX - entityClientPlayerMP.lastTickPosX) * (double)renderWorldLastEvent.partialTicks;
            double d2 = entityClientPlayerMP.lastTickPosY + (entityClientPlayerMP.posY - entityClientPlayerMP.lastTickPosY) * (double)renderWorldLastEvent.partialTicks;
            double d3 = entityClientPlayerMP.lastTickPosZ + (entityClientPlayerMP.posZ - entityClientPlayerMP.lastTickPosZ) * (double)renderWorldLastEvent.partialTicks;
            GL11.glPushMatrix();
            GL11.glTranslated(-d, -d2, -d3);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glDisable(2896);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            PhysicsThread.INSTANCE.renderTickBullet(renderWorldLastEvent.partialTicks);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
        }
    }

    @ForgeSubscribe
    public void attachPhysicsState(EntityEvent.EntityConstructing entityConstructing) {
        EntityPhysicsState entityPhysicsState;
        Supplier supplier = (Supplier)this.stateFactory._a(entityConstructing.entity.getClass());
        if (supplier != null && (entityPhysicsState = (EntityPhysicsState)supplier.get()) != null) {
            entityConstructing.entity.registerExtendedProperties(EntityPhysicsState.Companion.getATTRIB(), entityPhysicsState);
        }
    }

    @ForgeSubscribe
    public void entityJoinedWorld(EntityJoinWorldEvent entityJoinWorldEvent) {
        IExtendedEntityProperties iExtendedEntityProperties = entityJoinWorldEvent.entity.getExtendedProperties(EntityPhysicsState.Companion.getATTRIB());
        if (iExtendedEntityProperties instanceof EntityPhysicsState) {
            ((EntityPhysicsState)iExtendedEntityProperties).onEntityJoinedWorld(entityJoinWorldEvent.world);
        }
    }
}

