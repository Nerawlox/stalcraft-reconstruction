/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anticheat;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.util.sajh;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public class pidb {
    private static boolean _b;
    private static final int _c = 10000;
    private static final int _d = 2;
    private static final int _e = 20;
    private static boolean _f;
    public static int _a;
    private static double _g;

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(bscn bscn2, Packet10Flying packet10Flying) {
        EntityPlayer entityPlayer = bscn2.getPlayer();
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(entityPlayer);
        new ncpw(System.currentTimeMillis(), _a).sendToServer();
        EntityClientPlayerMP entityClientPlayerMP = bscn2._d._t;
        double d = entityClientPlayerMP.posX;
        double d2 = entityClientPlayerMP.posY;
        double d3 = entityClientPlayerMP.posZ;
        float f = entityClientPlayerMP.rotationYaw;
        float f2 = entityClientPlayerMP.rotationPitch;
        if (packet10Flying._h) {
            d = packet10Flying._a;
            d2 = packet10Flying._b;
            d3 = packet10Flying._c;
        }
        if (packet10Flying._i) {
            f = packet10Flying._e;
            f2 = packet10Flying._f;
        }
        entityClientPlayerMP.ySize = 0.0f;
        entityClientPlayerMP.motionZ = 0.0;
        entityClientPlayerMP.motionY = 0.0;
        entityClientPlayerMP.motionX = 0.0;
        entityClientPlayerMP.setPositionAndRotation(d, d2, d3, f, f2);
        entityPlayer.boundingBox._c = packet10Flying._b - (double)entityPlayer.yOffset - (double)smartMovingSelf.heightOffset;
        entityPlayer.boundingBox._f = entityPlayer.boundingBox._c + (double)entityPlayer.height;
        packet10Flying._a = entityClientPlayerMP.posX;
        packet10Flying._b = entityClientPlayerMP.boundingBox._c;
        packet10Flying._c = entityClientPlayerMP.posZ;
        packet10Flying._d = entityClientPlayerMP.posY;
        bscn2._b._a(packet10Flying);
        if (!bscn2._f) {
            bscn2._d._t.prevPosX = bscn2._d._t.posX;
            bscn2._d._t.prevPosY = bscn2._d._t.posY;
            bscn2._d._t.prevPosZ = bscn2._d._t.posZ;
            bscn2._f = true;
            bscn2._d._a((GuiScreen)null);
        }
        entityPlayer.onGround = packet10Flying._g;
        smartMovingSelf.anticheat.__aU._a(entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ);
        smartMovingSelf.anticheat.__aU._B = f;
        smartMovingSelf.anticheat.__aU._C = f2;
    }

    @Hook(targetMethod="handleFlying", injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _b(bscn bscn2, Packet10Flying packet10Flying) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(Entity entity, Entity entity2) {
        double d;
        double d2;
        double d3;
        if (entity2.riddenByEntity != entity && entity2.ridingEntity != entity && (d3 = sajh._a(d2 = entity2.posX - entity.posX, d = entity2.posZ - entity.posZ)) >= 0.01) {
            double d4;
            double d5;
            d3 = sajh._a(d3);
            d2 /= d3;
            d /= d3;
            double d6 = 1.0 / d3;
            if (d6 > 1.0) {
                d6 = 1.0;
            }
            d2 *= d6;
            d *= d6;
            d2 *= 0.05;
            d *= 0.05;
            if (entity.entityCollisionReduction < 1.0f) {
                d5 = -d2 * (double)(1.0f - entity.entityCollisionReduction);
                d4 = -d * (double)(1.0f - entity.entityCollisionReduction);
                entity.addVelocity(d5, 0.0, d4);
            }
            if (entity2.entityCollisionReduction < 1.0f) {
                d5 = d2 * (double)(1.0f - entity2.entityCollisionReduction);
                d4 = d * (double)(1.0f - entity2.entityCollisionReduction);
                entity2.addVelocity(d5, 0.0, d4);
            }
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(Packet10Flying packet10Flying, Packet packet) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS, booleanReturnConstant=false)
    public static void _a(fofa fofa2, Packet packet) {
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityClientPlayerMP entityClientPlayerMP) {
        boolean bl;
        boolean bl2;
        new ncpw(System.currentTimeMillis(), _a).sendToServer();
        boolean bl3 = entityClientPlayerMP.isSprinting();
        if (bl3 != entityClientPlayerMP.wasSneaking) {
            if (bl3) {
                entityClientPlayerMP.sendQueue._b(new Packet19EntityAction(entityClientPlayerMP, 4));
            } else {
                entityClientPlayerMP.sendQueue._b(new Packet19EntityAction(entityClientPlayerMP, 5));
            }
            entityClientPlayerMP.wasSneaking = bl3;
        }
        if ((bl2 = entityClientPlayerMP.isSneaking()) != entityClientPlayerMP.shouldStopSneaking) {
            if (bl2) {
                entityClientPlayerMP.sendQueue._b(new Packet19EntityAction(entityClientPlayerMP, 1));
            } else {
                entityClientPlayerMP.sendQueue._b(new Packet19EntityAction(entityClientPlayerMP, 2));
            }
            entityClientPlayerMP.shouldStopSneaking = bl2;
        }
        boolean bl4 = entityClientPlayerMP.posX != entityClientPlayerMP.oldPosX || entityClientPlayerMP.boundingBox._c != entityClientPlayerMP.oldMinY || entityClientPlayerMP.posZ != entityClientPlayerMP.oldPosZ;
        boolean bl5 = bl = entityClientPlayerMP.rotationYaw != entityClientPlayerMP.oldRotationYaw || entityClientPlayerMP.rotationPitch != entityClientPlayerMP.oldRotationPitch || bl4;
        if (entityClientPlayerMP.ridingEntity != null) {
            entityClientPlayerMP.sendQueue._b(new xszx(entityClientPlayerMP.motionX, -999.0, -999.0, entityClientPlayerMP.motionZ, entityClientPlayerMP.rotationYaw, entityClientPlayerMP.rotationPitch, entityClientPlayerMP.onGround));
            bl4 = false;
        } else if (bl4) {
            entityClientPlayerMP.sendQueue._b(new xszx(entityClientPlayerMP.posX, entityClientPlayerMP.boundingBox._c, entityClientPlayerMP.posY, entityClientPlayerMP.posZ, entityClientPlayerMP.rotationYaw, entityClientPlayerMP.rotationPitch, entityClientPlayerMP.onGround));
        } else if (bl) {
            entityClientPlayerMP.sendQueue._b(new ixmg(entityClientPlayerMP.rotationYaw, entityClientPlayerMP.rotationPitch, entityClientPlayerMP.onGround));
        } else {
            entityClientPlayerMP.sendQueue._b(new Packet10Flying(entityClientPlayerMP.onGround));
        }
        ++entityClientPlayerMP.field_71168_co;
        entityClientPlayerMP.wasOnGround = entityClientPlayerMP.onGround;
        if (bl4) {
            entityClientPlayerMP.oldPosX = entityClientPlayerMP.posX;
            entityClientPlayerMP.oldMinY = entityClientPlayerMP.boundingBox._c;
            entityClientPlayerMP.oldPosY = entityClientPlayerMP.posY;
            entityClientPlayerMP.oldPosZ = entityClientPlayerMP.posZ;
            entityClientPlayerMP.field_71168_co = 0;
        }
        if (bl) {
            entityClientPlayerMP.oldRotationYaw = entityClientPlayerMP.rotationYaw;
            entityClientPlayerMP.oldRotationPitch = entityClientPlayerMP.rotationPitch;
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(sajh sajh2, float f) {
        return sajh._n[(int)(f * 10430.378f) & 0xFFFF];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _b(sajh sajh2, float f) {
        return sajh._n[(int)(f * 10430.378f + 16384.0f) & 0xFFFF];
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="renderWorld")
    public static void _a(EntityRenderer entityRenderer, float f, long l) {
        _g = 0.0;
        Minecraft minecraft = Minecraft._E();
        if (minecraft._M.thirdPersonView > 0) {
            return;
        }
        float f2 = tvcu._a;
        float f3 = tvcu._b;
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        tvcu tvcu2 = ((SmartMovingSelf)SmartMovingFactory.getInstance((EntityPlayer)entityClientPlayerMP)).anticheat;
        float f4 = Math.max(0.0f, (float)tvcu2.__aF - f);
        double d = tvcu2._t != tvcu2.__aC ? (entityClientPlayerMP.posY - entityClientPlayerMP.prevPosY) * (double)(1.0f - f) : 0.0;
        double d2 = (double)tvcu2._z - d;
        float f5 = tvcu2._t && f4 <= f2 ? 1.0f - Math.min(1.0f, f4 / f2) : Math.min(1.0f, f4 / f3);
        if (f5 == 0.0f) {
            return;
        }
        double d3 = 4.5;
        double d4 = 0.5 * Math.pow(2.0f * ((double)f5 < 0.5 ? f5 : 1.0f - f5), d3);
        f5 = (float)(f5 < 0.5f ? d4 : 1.0 - d4);
        _g = -(d2 + (double)f5);
        entityClientPlayerMP.posY += _g;
        entityClientPlayerMP.prevPosY += _g;
        entityClientPlayerMP.lastTickPosY += _g;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="renderWorld", injectOnExit=true)
    public static void _b(EntityRenderer entityRenderer, float f, long l) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        entityClientPlayerMP.posY -= _g;
        entityClientPlayerMP.prevPosY -= _g;
        entityClientPlayerMP.lastTickPosY -= _g;
    }

    static {
        _g = 0.0;
    }
}

