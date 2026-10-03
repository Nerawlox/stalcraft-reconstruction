/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.potion.Potion;

public class hdps
extends Potion {
    public hdps(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @Override
    public void _a(EntityLivingBase entityLivingBase, BaseAttributeMap baseAttributeMap, int n) {
        entityLivingBase.setAbsorptionAmount(entityLivingBase.getAbsorptionAmount() - (float)(4 * (n + 1)));
        super._a(entityLivingBase, baseAttributeMap, n);
    }

    @Override
    public void _b(EntityLivingBase entityLivingBase, BaseAttributeMap baseAttributeMap, int n) {
        entityLivingBase.setAbsorptionAmount(entityLivingBase.getAbsorptionAmount() + (float)(4 * (n + 1)));
        super._b(entityLivingBase, baseAttributeMap, n);
    }
}

