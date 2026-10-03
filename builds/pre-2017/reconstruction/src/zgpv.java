/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;
import noppes.npcs.EntityNPCInterface;

public class zgpv {
    public static final double _a = 112.0;
    public static final List<DamageSource> _b = Arrays.asList(gloomyfolken.mods.core.misc.ezey._m, gloomyfolken.mods.core.misc.ezey._o, gloomyfolken.mods.core.misc.ezey._l, gloomyfolken.mods.core.misc.ezey._n, gloomyfolken.mods.core.misc.ezey._p);

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("lifetime", new oxsg(mquk2._a));
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(GuiOpenEvent guiOpenEvent) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._t == null) {
            return;
        }
        if (guiOpenEvent.gui instanceof jzpo) {
            vlfg vlfg2 = RespawnMod.instance._e;
            jzaw jzaw2 = vlfg2 == null ? new jzaw() : (vlfg2._a == ndni._a ? new qmsy() : new cumr());
            guiOpenEvent.gui = jzaw2;
        }
    }

    @ForgeSubscribe
    @ezey(_a={eidj.CLIENT})
    public void _a(zxrk zxrk2) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof jzaw) {
            minecraft._a((GuiScreen)null);
        }
        if (RespawnMod.instance._e != null) {
            RespawnMod.instance._e = null;
        }
    }

    private String _a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayer) {
            return ((EntityPlayer)entityLivingBase).getCommandSenderName();
        }
        if (entityLivingBase != null) {
            return "@" + entityLivingBase.entityId;
        }
        return null;
    }

    public static boolean _a(Entity entity) {
        return entity instanceof EntityNPCInterface && ((EntityNPCInterface)entity).isHuman();
    }

    private int[] _a(double d, double d2, double d3, double d4, boolean bl) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        double d7 = Math.sqrt(d5 * d5 + d6 * d6);
        if (!bl && d7 <= 18.666666666666668) {
            return new int[0];
        }
        double d8 = Math.atan2(d5, d6) + 1.5707963267948966;
        if (d8 < 0.0) {
            d8 += Math.PI * 2;
        }
        int n = (int)(d8 / 0.39269908169872414);
        if (!bl && d7 > 18.666666666666668 && d7 < 67.2) {
            return new int[]{n};
        }
        return new int[]{n, (n + 1) % 16};
    }

    private ndni _a(EntityPlayer entityPlayer, DamageSource damageSource) {
        if (damageSource.getEntity() != null && damageSource.getEntity() != entityPlayer) {
            return ndni._a;
        }
        if (_b.contains(damageSource)) {
            return ndni._c;
        }
        if (damageSource instanceof pidb) {
            return ndni._b;
        }
        return ndni._d;
    }
}

