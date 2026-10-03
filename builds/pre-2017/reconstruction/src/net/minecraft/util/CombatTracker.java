/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.jgro;
import net.minecraft.util.sajh;

public class CombatTracker {
    public final List _a = new ArrayList();
    public final EntityLivingBase _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public String _f;

    public CombatTracker(EntityLivingBase entityLivingBase) {
        this._b = entityLivingBase;
    }

    public void _a() {
        this._e();
        if (this._b.isOnLadder()) {
            int n = this._b.worldObj.getBlockId(sajh._c(this._b.posX), sajh._c(this._b.boundingBox._c), sajh._c(this._b.posZ));
            if (n == Block.ladder.blockID) {
                this._f = "ladder";
            } else if (n == Block.vine.blockID) {
                this._f = "vines";
            }
        } else if (this._b.isInWater()) {
            this._f = "water";
        }
    }

    public void _a(DamageSource damageSource, float f, float f2) {
        this._f();
        this._a();
        jgro jgro2 = new jgro(damageSource, this._b.ticksExisted, f, f2, this._f, this._b.fallDistance);
        this._a.add(jgro2);
        this._c = this._b.ticksExisted;
        this._e = true;
        this._d |= jgro2._c();
    }

    public ChatMessageComponent _b() {
        ChatMessageComponent chatMessageComponent;
        if (this._a.size() == 0) {
            return ChatMessageComponent._b("death.attack.generic", this._b.getTranslatedEntityName());
        }
        jgro jgro2 = this._d();
        jgro jgro3 = (jgro)this._a.get(this._a.size() - 1);
        String string = jgro3._e();
        Entity entity = jgro3._a().getEntity();
        if (jgro2 != null && jgro3._a() == DamageSource.fall) {
            String string2 = jgro2._e();
            if (jgro2._a() == DamageSource.fall || jgro2._a() == DamageSource.outOfWorld) {
                chatMessageComponent = ChatMessageComponent._b("death.fell.accident." + this._a(jgro2), this._b.getTranslatedEntityName());
            } else if (!(string2 == null || string != null && string2.equals(string))) {
                ItemStack itemStack;
                Entity entity2 = jgro2._a().getEntity();
                ItemStack itemStack2 = itemStack = entity2 instanceof EntityLivingBase ? ((EntityLivingBase)entity2).getHeldItem() : null;
                chatMessageComponent = itemStack != null && itemStack._u() ? ChatMessageComponent._b("death.fell.assist.item", this._b.getTranslatedEntityName(), string2, itemStack._s()) : ChatMessageComponent._b("death.fell.assist", this._b.getTranslatedEntityName(), string2);
            } else if (string != null) {
                ItemStack itemStack;
                ItemStack itemStack3 = itemStack = entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).getHeldItem() : null;
                chatMessageComponent = itemStack != null && itemStack._u() ? ChatMessageComponent._b("death.fell.finish.item", this._b.getTranslatedEntityName(), string, itemStack._s()) : ChatMessageComponent._b("death.fell.finish", this._b.getTranslatedEntityName(), string);
            } else {
                chatMessageComponent = ChatMessageComponent._b("death.fell.killer", this._b.getTranslatedEntityName());
            }
        } else {
            chatMessageComponent = jgro3._a().getDeathMessage(this._b);
        }
        return chatMessageComponent;
    }

    public EntityLivingBase _c() {
        EntityLivingBase entityLivingBase = null;
        EntityPlayer entityPlayer = null;
        float f = 0.0f;
        float f2 = 0.0f;
        for (jgro jgro2 : this._a) {
            if (jgro2._a().getEntity() instanceof EntityPlayer && (entityPlayer == null || jgro2._b() > f2)) {
                f2 = jgro2._b();
                entityPlayer = (EntityPlayer)jgro2._a().getEntity();
            }
            if (!(jgro2._a().getEntity() instanceof EntityLivingBase) || entityLivingBase != null && !(jgro2._b() > f)) continue;
            f = jgro2._b();
            entityLivingBase = (EntityLivingBase)jgro2._a().getEntity();
        }
        if (entityPlayer != null && f2 >= f / 3.0f) {
            return entityPlayer;
        }
        return entityLivingBase;
    }

    public jgro _d() {
        jgro jgro2 = null;
        jgro jgro3 = null;
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < this._a.size(); ++i) {
            jgro jgro4;
            jgro jgro5 = (jgro)this._a.get(i);
            jgro jgro6 = jgro4 = i > 0 ? (jgro)this._a.get(i - 1) : null;
            if ((jgro5._a() == DamageSource.fall || jgro5._a() == DamageSource.outOfWorld) && jgro5._f() > 0.0f && (jgro2 == null || jgro5._f() > f)) {
                jgro2 = i > 0 ? jgro4 : jgro5;
                f = jgro5._f();
            }
            if (jgro5._d() == null || jgro3 != null && !(jgro5._b() > (float)n)) continue;
            jgro3 = jgro5;
        }
        if (f > 5.0f && jgro2 != null) {
            return jgro2;
        }
        if (n > 5 && jgro3 != null) {
            return jgro3;
        }
        return null;
    }

    public String _a(jgro jgro2) {
        return jgro2._d() == null ? "generic" : jgro2._d();
    }

    public void _e() {
        this._f = null;
    }

    public void _f() {
        int n;
        int n2 = n = this._d ? 300 : 100;
        if (this._e && this._b.ticksExisted - this._c > n) {
            this._a.clear();
            this._e = false;
            this._d = false;
        }
    }
}

