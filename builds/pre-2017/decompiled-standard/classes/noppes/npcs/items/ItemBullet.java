/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import noppes.npcs.CustomItems;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemNpcInterface;

public class ItemBullet
extends ItemNpcInterface {
    private EnumNpcToolMaterial material;

    public ItemBullet(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.material = enumNpcToolMaterial;
        this.func_77637_a(CustomItems.tabWeapon);
    }

    public int getBulletDamage() {
        return this.material.getDamageVsEntity();
    }
}

