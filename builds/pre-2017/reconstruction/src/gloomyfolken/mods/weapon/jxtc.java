/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import com.google.common.collect.ImmutableMap;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.entity.pidb;
import gloomyfolken.mods.weapon.qlgf;
import gloomyfolken.mods.weapon.ugqx;
import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class jxtc {
    private static final Map<qlgf, srok> _a = ImmutableMap.builder().put(qlgf._a, WeaponMod._n).put(qlgf._b, WeaponMod._o).put(qlgf._c, WeaponMod._p).put(qlgf._d, WeaponMod._q).put(qlgf._e, WeaponMod._r).put(qlgf._f, WeaponMod._s).build();

    @ForgeSubscribe(priority=EventPriority.LOWEST)
    public void _a(LivingDeathEvent livingDeathEvent) {
        if (livingDeathEvent.entity.worldObj.isRemote || livingDeathEvent.entity.isDead) {
            return;
        }
        DamageSource damageSource = livingDeathEvent.source;
        if (livingDeathEvent.entityLiving instanceof EntityPlayer && damageSource.getEntity() instanceof EntityPlayer && damageSource.getEntity() != livingDeathEvent.entity) {
            EntityPlayer entityPlayer = (EntityPlayer)damageSource.getEntity();
            ccxr ccxr2 = ncwh._a(entityPlayer);
            if (entityPlayer.getHeldItem() != null && entityPlayer.getHeldItem()._a() instanceof cdse) {
                ccxr2._a(WeaponMod._k)._e();
            }
        }
    }

    @ForgeSubscribe
    public void _a(EntityEvent.EntityConstructing entityConstructing) {
        if (entityConstructing.entity instanceof EntityLivingBase) {
            entityConstructing.entity.registerExtendedProperties(gloomyfolken.mods.core.entity.jxtc._w(), new gloomyfolken.mods.core.entity.jxtc((EntityLivingBase)entityConstructing.entity));
        }
    }

    @ForgeSubscribe
    public void _a(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        IExtendedEntityProperties iExtendedEntityProperties = livingUpdateEvent.entity.getExtendedProperties(gloomyfolken.mods.core.entity.jxtc._w());
        if (iExtendedEntityProperties instanceof gloomyfolken.mods.core.entity.jxtc) {
            ((gloomyfolken.mods.core.entity.jxtc)iExtendedEntityProperties)._q();
        }
    }

    @ForgeSubscribe
    public void _a(ntxh ntxh2) {
        IExtendedEntityProperties iExtendedEntityProperties = ntxh2.entityLiving.getExtendedProperties("last_damage");
        if (iExtendedEntityProperties != null && ((pidb)iExtendedEntityProperties)._a) {
            ntxh2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void _b(LivingDeathEvent livingDeathEvent) {
        if (!(livingDeathEvent.entityLiving instanceof EntityPlayer) || !(livingDeathEvent.source.getEntity() instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)livingDeathEvent.source.getEntity();
        ItemStack itemStack = entityPlayer.getHeldItem();
        if (itemStack == null || !(itemStack._a() instanceof wolf)) {
            return;
        }
        qlgf qlgf2 = ((wolf)itemStack._a()).__aj;
        if (qlgf2 == null || !_a.containsKey((Object)qlgf2)) {
            return;
        }
        srok srok2 = _a.get((Object)qlgf2);
        ncwh._a(entityPlayer)._a(srok2)._e();
    }

    @ForgeSubscribe
    public void _a(jzaf jzaf2) {
        if (ugqx._a((EntityPlayer)jzaf2.entityPlayer)._o > 0.0f) {
            htcn._a()._e._a(jzaf2._a);
        }
    }

    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("weapon", new ugqx(mquk2._a));
    }
}

