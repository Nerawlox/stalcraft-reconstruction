/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.entity;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.entity.EntityProjectile;

public class EntityMagicProjectile
extends EntityProjectile {
    private EntityPlayer player;
    private cvzo equiped;

    public EntityMagicProjectile(ozlu ozlu2, EntityPlayer entityPlayer, cvzo cvzo2, boolean bl) {
        super(ozlu2, entityPlayer, cvzo2, bl);
        this.player = entityPlayer;
        this.equiped = entityPlayer.field_71071_by._a();
    }

    @Override
    public void func_70071_h_() {
        if (this.player.field_71071_by._a() != this.equiped) {
            this.func_70106_y();
        }
        super.func_70071_h_();
    }
}

