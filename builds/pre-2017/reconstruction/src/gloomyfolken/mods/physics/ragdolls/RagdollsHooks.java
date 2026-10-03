/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.mods.physics.core.EntityPhysicsState;
import gloomyfolken.mods.physics.core.packet.PacketEntityImpulse;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.weapon.pidb;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraftforge.common.IExtendedEntityProperties;

public class RagdollsHooks {
    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void onClientShot(pidb pidb2, Entity entity, EntityTracer.kjui kjui2, Vec3 vec3, float f) {
        Minecraft minecraft = Minecraft._E();
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        IExtendedEntityProperties iExtendedEntityProperties = entity.getExtendedProperties(EntityPhysicsState.Companion.getATTRIB());
        if (iExtendedEntityProperties instanceof CorpseRagdollState && entity instanceof EntityRagdollCorpse) {
            if (((EntityRagdollCorpse)entity).isLeftovers()) {
                return;
            }
            pidb._a(vec3, kjui2._h, entity, false, f);
            double d = kjui2._h._c - entityClientPlayerMP.posX;
            double d2 = kjui2._h._d - entityClientPlayerMP.posY;
            double d3 = kjui2._h._e - entityClientPlayerMP.posZ;
            Vec3 vec32 = entityClientPlayerMP.worldObj.getWorldVec3Pool()._a(d, d2, d3)._a();
            new PacketEntityImpulse(entity, kjui2._h._c, kjui2._h._d, kjui2._h._e, vec32._c, vec32._d, vec32._e).sendToServer();
        }
    }
}

