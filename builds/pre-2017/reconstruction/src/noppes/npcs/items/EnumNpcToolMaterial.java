/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

public enum EnumNpcToolMaterial {
    WOOD("WOOD", 0, 0, 59, 2.0f, 0, 15),
    STONE("STONE", 1, 1, 131, 4.0f, 1, 5),
    BRONZE("BRONZE", 2, 2, 170, 5.0f, 2, 15),
    IRON("IRON", 3, 2, 250, 6.0f, 2, 14),
    DIA("DIA", 4, 3, 1561, 8.0f, 3, 10),
    EMERALD("EMERALD", 5, 3, 1000, 8.0f, 4, 10),
    GOLD("GOLD", 6, 0, 32, 12.0f, 1, 22);

    private static final EnumNpcToolMaterial[] $VALUES;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;

    private EnumNpcToolMaterial(String string2, int n2, int n3, int n4, float f, int n5, int n6) {
        this.harvestLevel = n3;
        this.maxUses = n4;
        this.efficiencyOnProperMaterial = f;
        this.damageVsEntity = n5;
        this.enchantability = n6;
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiencyOnProperMaterial() {
        return this.efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity() {
        return this.damageVsEntity;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    static {
        $VALUES = new EnumNpcToolMaterial[]{WOOD, STONE, BRONZE, IRON, DIA, EMERALD, GOLD};
    }
}

