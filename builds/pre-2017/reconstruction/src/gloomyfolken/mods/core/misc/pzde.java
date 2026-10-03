/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.weapon.ezey;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EntityDamageSource;

public class pzde
extends EntityDamageSource
implements ezey {
    private float _a = 0.0f;

    public pzde(float f, Entity entity) {
        super("melee", entity);
        this._a = f;
    }

    @Override
    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        return new ChatMessageComponent()._a(entityLivingBase.getEntityName() + " \u0431\u044b\u043b \u0437\u0430\u0440\u0435\u0437\u0430\u043d " + (this.getEntity() == null ? "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u043c" : this.getEntity().getEntityName()));
    }

    @Override
    public float getBleedingChance() {
        return this._a;
    }
}

