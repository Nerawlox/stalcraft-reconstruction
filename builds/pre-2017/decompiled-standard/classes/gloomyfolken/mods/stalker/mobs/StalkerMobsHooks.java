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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;

public class StalkerMobsHooks {
    private static cvzo lastItemStack = null;
    public static int INTERP_TICKS_REL = 2;
    public static int INTERP_TICKS_TP = 2;
    public static int TICKS_TP_PERIOD = 10;

    public static cvzo getLastHoveredStack() {
        return lastItemStack;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void stopAllSounds(jzqf jzqf2) {
        MutantSoundManager.INSTANCE.stopAllSounds();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(injectOnExit=true)
    public static void drawScreen(zybc zybc2, int n, int n2, float f) {
        nuis nuis2;
        yeso yeso2;
        lastItemStack = null;
        if (zybc2 instanceof nuis && (yeso2 = (nuis2 = (nuis)zybc2)._a(n, n2)) != null) {
            lastItemStack = yeso2.func_75211_c();
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
            entity.field_70118_ct = txnr2._b;
            entity.field_70117_cu = txnr2._c;
            entity.field_70116_cv = txnr2._d;
            double d = (double)entity.field_70118_ct / 32.0;
            double d2 = (double)entity.field_70117_cu / 32.0;
            double d3 = (double)entity.field_70116_cv / 32.0;
            float f = (float)(txnr2._e * 360) / 256.0f;
            float f2 = (float)(txnr2._f * 360) / 256.0f;
            entity.func_70056_a(d, d2, d3, f, f2, INTERP_TICKS_TP);
            if (INTERP_TICKS_TP == 0 && entity instanceof EntityLivingBase) {
                entity.func_70107_b(d, d2, d3);
                entity.field_70177_z = f;
                entity.field_70125_A = f2;
            }
        }
        return bl;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean handleEntity(bscn bscn2, vmsk vmsk2) {
        Entity entity = bscn2._a(vmsk2._a);
        boolean bl = StalkerMobsHooks.shouldOverrideEntitySync(entity);
        if (entity != null && bl) {
            entity.field_70118_ct += vmsk2._b;
            entity.field_70117_cu += vmsk2._c;
            entity.field_70116_cv += vmsk2._d;
            double d = (double)entity.field_70118_ct / 32.0;
            double d2 = (double)entity.field_70117_cu / 32.0;
            double d3 = (double)entity.field_70116_cv / 32.0;
            float f = vmsk2._g ? (float)(vmsk2._e * 360) / 256.0f : entity.field_70177_z;
            float f2 = vmsk2._g ? (float)(vmsk2._f * 360) / 256.0f : entity.field_70125_A;
            entity.func_70056_a(d, d2, d3, f, f2, INTERP_TICKS_REL);
        }
        return bl;
    }
}

