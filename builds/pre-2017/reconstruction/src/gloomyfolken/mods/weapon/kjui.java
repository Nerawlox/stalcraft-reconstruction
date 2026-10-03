/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.mods.weapon.ezey;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class kjui
extends EntityDamageSource
implements ezey {
    public float _a;
    public float _b;
    public float _c;
    public final EntityTracer.eidj _d;
    public final boolean _e;

    public static DamageSource _a(Entity entity, boolean bl, float f, float f2, float f3, EntityTracer.eidj eidj2) {
        return new kjui(entity instanceof EntityPlayer ? "player" : "bullet", entity, bl, f, f2, f3, eidj2);
    }

    public kjui(String string, Entity entity, boolean bl, float f, float f2, float f3, EntityTracer.eidj eidj2) {
        super(string, entity);
        this._e = bl;
        this._a = f;
        this._b = f2;
        this._c = f3;
        this._d = eidj2;
    }

    @Override
    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        return new ChatMessageComponent()._a(entityLivingBase.getEntityName() + " \u0431\u044b\u043b \u0437\u0430\u0441\u0442\u0440\u0435\u043b\u0435\u043d " + (this.getEntity() == null ? "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u043c" : this.getEntity().getEntityName()));
    }

    @Override
    public float getBleedingChance() {
        return this._c;
    }
}

