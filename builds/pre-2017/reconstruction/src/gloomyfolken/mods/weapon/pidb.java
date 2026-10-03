/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.tdpf;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.RagdollsHooks;
import gloomyfolken.mods.stalker.mobs.packet.PacketClientNoise;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.entity.EntityBulletHole;
import gloomyfolken.mods.weapon.jgro;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import gloomyfolken.mods.weapon.ugqx;
import gloomyfolken.mods.weapon.zwat;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;

public class pidb {
    private static final boolean _a = false;
    private static boolean _b;

    public static float _a(Entity entity, float f, float f2) {
        float f3 = f + (1.0f - f2) * 30.0f;
        if (entity != null) {
            float f4 = (entity.distanceWalkedModified - entity.prevDistanceWalkedModified) / 0.6f;
            f3 += f4 * (1.0f - f2) * 200.0f;
        }
        return f3;
    }

    private static double _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d7 - d4;
        double d11 = d8 - d5;
        double d12 = d9 - d6;
        double d13 = d - d4;
        double d14 = d2 - d5;
        double d15 = d3 - d6;
        double d16 = (d13 * d10 + d14 * d11 + d15 * d12) / (d10 * d10 + d11 * d11 + d12 * d12);
        double d17 = d13 - d16 * d10;
        double d18 = d14 - d16 * d11;
        double d19 = d15 - d16 * d12;
        return Math.sqrt(d17 * d17 + d18 * d18 + d19 * d19);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @ezey(_a={eidj.CLIENT})
    public static void _a(Entity entity, float f) {
        zwat zwat2;
        if (entity instanceof zwat) {
            zwat2 = (zwat)((Object)entity);
        } else if (entity instanceof EntityPlayer && ugqx._a((EntityPlayer)((EntityPlayer)entity))._f != null) {
            zwat2 = ugqx._a((EntityPlayer)((EntityPlayer)entity))._f;
        } else {
            if (!(entity instanceof EntityLivingBase)) return;
            ItemStack itemStack = ((EntityLivingBase)entity).getHeldItem();
            if (itemStack == null || !(itemStack._a() instanceof wolf)) return;
            zwat2 = (wolf)itemStack._a();
        }
        if (sbzn._g.enabled && Minecraft._E()._t.getDistanceToEntity(entity) < 16.0f) {
            zwat2.spawnShell(entity);
        }
        pidb._a(entity, zwat2.getShootSoundName(entity), 8.0f, f);
        zwat2.onShootClient(entity);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(Entity entity, String string, float f, float f2) {
        boolean bl = entity == Minecraft._E()._t;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (!bl) {
            Vec3 vec3 = entity.getLookVec();
            tdpf._a(vec3, 0.3);
            f3 = (float)vec3._c;
            f4 = (float)vec3._d;
            f5 = (float)vec3._e;
        }
        dwwh._a._a(f2, entity.posX + (double)f3, entity.posY + (double)f4, entity.posZ + (double)f5, string, f, entity.worldObj.rand.nextFloat() * 0.1f + 0.9f, bl);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(Vec3 vec3, Vec3 vec32, int n, byte by, boolean bl, float f) {
        Object object;
        if (by == -1) {
            return;
        }
        Minecraft minecraft = Minecraft._E();
        Block block = Block.blocksList[n];
        Vec3 vec33 = Vec3._a(vec32._c, vec32._d, vec32._e);
        switch (by) {
            case 0: {
                vec33._d += 0.1;
                break;
            }
            case 1: {
                vec33._d -= 0.1;
                break;
            }
            case 2: {
                vec33._e += 0.1;
                break;
            }
            case 3: {
                vec33._e -= 0.1;
                break;
            }
            case 4: {
                vec33._c += 0.1;
                break;
            }
            case 5: {
                vec33._c -= 0.1;
            }
        }
        int n2 = sajh._c(vec33._c);
        int n3 = sajh._c(vec33._d);
        int n4 = sajh._c(vec33._e);
        ndrq.kjui kjui2 = sbzn._c._a(minecraft._r, n2, n3, n4);
        if (kjui2 != null && sbzn._i.enabled) {
            if (minecraft._t.getDistance(vec32._c, vec32._d, vec32._e) < 32.0) {
                object = new EntityBulletHole(minecraft._r, vec32._c, vec32._d, vec32._e, by, kjui2._b);
                if (block == null || !block.isOpaqueCube() && block != Block.glass) {
                    ((EntityBulletHole)object).sideHit = -1;
                }
                ((EntityBulletHole)object).isKnifeHole = bl;
                minecraft._r.spawnEntityInWorld((Entity)object);
            }
            gloomyfolken.mods.effects.client.main.pidb._a(new broz(minecraft._r, null, false, by, vec3, vec32));
        }
        if (kjui2 != null) {
            object = bl ? kjui2._d : kjui2._c;
            dwwh._a._a(f, vec32._c, vec32._d, vec32._e, (String)object, 1.0f, minecraft._r.rand.nextFloat() * 0.1f + 0.9f, false);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(Vec3 vec3, Vec3 vec32, Entity entity, boolean bl, float f) {
        Minecraft minecraft = Minecraft._E();
        if (entity instanceof EntityLivingBase && (entity != minecraft._t || minecraft._M.thirdPersonView != 0)) {
            gloomyfolken.mods.effects.client.main.pidb._a(new broz(minecraft._r, entity, true, -1, vec3, vec32));
        }
        String string = bl ? "weapons:melee.hit" : "weapons:bullet.hit";
        dwwh._a._a(f, vec32._c, vec32._d, vec32._e, string, 1.0f, minecraft._r.rand.nextFloat() * 0.1f + 0.9f, false);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(Vec3 vec3, Vec3 vec32, float f) {
        Minecraft minecraft = Minecraft._E();
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        if (((Entity)entityClientPlayerMP).getDistanceSq(vec3._c, vec3._d, vec3._e) > 256.0 && ((Entity)entityClientPlayerMP).getDistanceSq(vec32._c, vec32._d, vec32._e) > 256.0) {
            Vec3 vec33 = Vec3._a(entityClientPlayerMP.posX - vec3._c, entityClientPlayerMP.posY - vec3._d, entityClientPlayerMP.posZ - vec3._e);
            Vec3 vec34 = vec3._a(vec32);
            Vec3 vec35 = Vec3._a(entityClientPlayerMP.posX - vec32._c, entityClientPlayerMP.posY - vec32._d, entityClientPlayerMP.posZ - vec32._e);
            Vec3 vec36 = vec33._c(vec34);
            Vec3 vec37 = vec36._c(vec34)._a();
            double d = vec33._c(vec35)._b() / vec34._b();
            double d2 = entityClientPlayerMP.posX + vec37._c * d;
            double d3 = entityClientPlayerMP.posY + vec37._d * d;
            double d4 = entityClientPlayerMP.posZ + vec37._e * d;
            if (d2 > Math.min(vec3._c, vec32._c) && d2 < Math.max(vec3._c, vec32._c) && d3 > Math.min(vec3._d, vec32._d) && d3 < Math.max(vec3._d, vec32._d) && d4 > Math.min(vec3._e, vec32._e) && d4 < Math.max(vec3._e, vec32._e)) {
                dwwh._a._a(f, d2, d3, d4, "weapons:bullet.whine", 1.0f, minecraft._r.rand.nextFloat() * 0.1f + 0.9f, false);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static ugqx.pidb _a(boolean bl) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        ugqx ugqx2 = ugqx._a(entityClientPlayerMP);
        if (ugqx2._f != null) {
            pidb._a(entityClientPlayerMP, ugqx2._f, 0.0f);
            return ugqx.pidb._a;
        }
        ItemStack itemStack = entityClientPlayerMP.getCurrentEquippedItem();
        if (itemStack == null || !(itemStack._a() instanceof wolf)) {
            return ugqx.pidb._b;
        }
        wolf wolf2 = (wolf)itemStack._a();
        ugqx.pidb pidb2 = ugqx2._b(itemStack);
        switch (pidb2) {
            case _a: {
                MinecraftForge.EVENT_BUS.post(new yund.jgro.pidb(entityClientPlayerMP));
                float f = ugqx2._q();
                pidb._a(entityClientPlayerMP, (wolf)itemStack._a(), f);
                ugqx2._a(itemStack, f);
                pidb._a(entityClientPlayerMP, f);
                itemStack._a(1, (EntityLivingBase)entityClientPlayerMP);
                return pidb2;
            }
            case _c: {
                if (bl) {
                    pidb._a((Entity)entityClientPlayerMP, wolf2._a(wolf2._N, (EntityLivingBase)entityClientPlayerMP, itemStack), 1.0f, 0.0f);
                }
                return pidb2;
            }
            case _d: {
                ugqx2._a((Object)((Object)EnumChatFormatting._m) + "\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u043b\u043e, \u043d\u0430\u0436\u043c\u0438\u0442\u0435 " + GameSettings.getKeyDisplayString(WeaponMod.instance._y._d));
                if (bl) {
                    new PacketClientNoise(30.0f).sendToServer();
                    pidb._a((Entity)entityClientPlayerMP, wolf2._a(wolf2._M, (EntityLivingBase)entityClientPlayerMP, itemStack), 1.0f, 0.0f);
                }
                return pidb2;
            }
        }
        return pidb2;
    }

    @ezey(_a={eidj.CLIENT})
    private static void _a(EntityPlayer entityPlayer, zwat zwat2, float f) {
        ugqx ugqx2 = ugqx._a(entityPlayer);
        float f2 = zwat2.getMaxDistance(entityPlayer);
        int n = zwat2.getNumBullets(entityPlayer);
        Vec3 vec3 = Vec3._a(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        Vec3 vec32 = VecExtensionsKt.addVector(vec3, EntityTracer._a(entityPlayer.rotationYawHead, entityPlayer.rotationPitch, 0.0f, f2));
        List<Entity> list2 = EntityTracer._a(entityPlayer.worldObj, vec3, vec32, (float)(Math.toRadians(zwat2.getSpread(entityPlayer)) * 3.0), entityPlayer);
        for (int i = 0; i < n; ++i) {
            EntityTracer.kjui kjui2 = EntityTracer._a(entityPlayer.worldObj, vec3, vec32, (Entity)entityPlayer, null, true);
            if (kjui2 == null || kjui2._i == null) continue;
            pidb._a(kjui2._i, kjui2, vec3, f);
        }
        ugqx ugqx3 = ugqx._a(entityPlayer);
        if (ugqx3 != null) {
            new xams(new jgro(vec3, vec32, n, list2, ugqx3._m(), ugqx3._q(), pidb._a(zwat2))).sendToServer();
        }
    }

    @ezey(_a={eidj.CLIENT})
    private static int _a(zwat zwat2) {
        if (_b) {
            // empty if block
        }
        int n = 0;
        n |= Minecraft._E()._t.capabilities._d ? 1 : 0;
        n |= Minecraft._E()._M.gammaSetting != 0.0f ? 2 : 0;
        if (zwat2 instanceof wolf) {
            wolf wolf2 = (wolf)zwat2;
            if (wolf2.__an != (Float.floatToIntBits(wolf2._h) ^ Float.floatToIntBits(wolf2._i) ^ 0x936A2B0E)) {
                n |= 4;
            }
        }
        if (wnja._a()) {
            n |= 8;
        }
        if (n != 0) {
            _b = true;
        }
        return n;
    }

    @ezey(_a={eidj.CLIENT})
    private static void _a(Entity entity, EntityTracer.kjui kjui2, Vec3 vec3, float f) {
        znw.mods.stalkerguide.pidb._a(null, entity, kjui2, vec3, f);
        RagdollsHooks.onClientShot(null, entity, kjui2, vec3, f);
    }
}

