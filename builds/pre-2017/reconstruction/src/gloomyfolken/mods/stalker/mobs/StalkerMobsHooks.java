/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.stalker.mobs.IsEntityNpc;
import gloomyfolken.mods.stalker.mobs.client.MutantSoundManager;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.src.ModLoader;

public class StalkerMobsHooks {
    private static ItemStack lastItemStack = null;
    public static int INTERP_TICKS_REL = 2;
    public static int INTERP_TICKS_TP = 2;
    public static int TICKS_TP_PERIOD = 10;

    public static ItemStack getLastHoveredStack() {
        return lastItemStack;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void stopAllSounds(jzqf jzqf2) {
        MutantSoundManager.INSTANCE.stopAllSounds();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void drawScreen(GuiContainer guiContainer, int n, int n2, float f) {
        nuis nuis2;
        Slot slot;
        lastItemStack = null;
        if (guiContainer instanceof nuis && (slot = (nuis2 = (nuis)guiContainer)._a(n, n2)) != null) {
            lastItemStack = slot.getStack();
        }
    }

    private static boolean shouldOverrideEntitySync(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (ModLoader.isModLoaded("customnpcs") && IsEntityNpc.andIsMale(entity)) {
            return true;
        }
        return entity instanceof EntityMutant || entity instanceof EntityPlayer;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean handleEntityTeleport(bscn bscn2, txnr txnr2) {
        Entity entity = bscn2._a(txnr2._a);
        boolean bl = StalkerMobsHooks.shouldOverrideEntitySync(entity);
        if (entity != null && bl) {
            entity.serverPosX = txnr2._b;
            entity.serverPosY = txnr2._c;
            entity.serverPosZ = txnr2._d;
            double d = (double)entity.serverPosX / 32.0;
            double d2 = (double)entity.serverPosY / 32.0;
            double d3 = (double)entity.serverPosZ / 32.0;
            float f = (float)(txnr2._e * 360) / 256.0f;
            float f2 = (float)(txnr2._f * 360) / 256.0f;
            entity.setPositionAndRotation2(d, d2, d3, f, f2, INTERP_TICKS_TP);
            if (INTERP_TICKS_TP == 0 && entity instanceof EntityLivingBase) {
                entity.setPosition(d, d2, d3);
                entity.rotationYaw = f;
                entity.rotationPitch = f2;
            }
        }
        return bl;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean handleEntity(bscn bscn2, Packet30Entity packet30Entity) {
        Entity entity = bscn2._a(packet30Entity._a);
        boolean bl = StalkerMobsHooks.shouldOverrideEntitySync(entity);
        if (entity != null && bl) {
            entity.serverPosX += packet30Entity._b;
            entity.serverPosY += packet30Entity._c;
            entity.serverPosZ += packet30Entity._d;
            double d = (double)entity.serverPosX / 32.0;
            double d2 = (double)entity.serverPosY / 32.0;
            double d3 = (double)entity.serverPosZ / 32.0;
            float f = packet30Entity._g ? (float)(packet30Entity._e * 360) / 256.0f : entity.rotationYaw;
            float f2 = packet30Entity._g ? (float)(packet30Entity._f * 360) / 256.0f : entity.rotationPitch;
            entity.setPositionAndRotation2(d, d2, d3, f, f2, INTERP_TICKS_REL);
        }
        return bl;
    }
}

