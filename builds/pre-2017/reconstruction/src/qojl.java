/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.potion.Potion;

public class qojl
extends Potion {
    public qojl(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @Override
    public void _a(EntityLivingBase entityLivingBase, BaseAttributeMap baseAttributeMap, int n) {
        super._a(entityLivingBase, baseAttributeMap, n);
        if (entityLivingBase.getHealth() > entityLivingBase.getMaxHealth()) {
            entityLivingBase.setHealth(entityLivingBase.getMaxHealth());
        }
    }
}

