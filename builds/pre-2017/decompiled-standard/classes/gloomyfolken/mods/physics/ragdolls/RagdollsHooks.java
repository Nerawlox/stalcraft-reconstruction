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
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import net.minecraftforge.common.IExtendedEntityProperties;

public class RagdollsHooks {
    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void onClientShot(pidb pidb2, Entity entity, EntityTracer.kjui kjui2, ofbx ofbx2, float f) {
        xpzm xpzm2 = xpzm._E();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        IExtendedEntityProperties iExtendedEntityProperties = entity.getExtendedProperties(EntityPhysicsState.Companion.getATTRIB());
        if (iExtendedEntityProperties instanceof CorpseRagdollState && entity instanceof EntityRagdollCorpse) {
            if (((EntityRagdollCorpse)entity).isLeftovers()) {
                return;
            }
            pidb._a(ofbx2, kjui2._h, entity, false, f);
            double d = kjui2._h._c - entityClientPlayerMP.field_70165_t;
            double d2 = kjui2._h._d - entityClientPlayerMP.field_70163_u;
            double d3 = kjui2._h._e - entityClientPlayerMP.field_70161_v;
            ofbx ofbx3 = entityClientPlayerMP.field_70170_p.func_82732_R()._a(d, d2, d3)._a();
            new PacketEntityImpulse(entity, kjui2._h._c, kjui2._h._d, kjui2._h._e, ofbx3._c, ofbx3._d, ofbx3._e).sendToServer();
        }
    }
}

