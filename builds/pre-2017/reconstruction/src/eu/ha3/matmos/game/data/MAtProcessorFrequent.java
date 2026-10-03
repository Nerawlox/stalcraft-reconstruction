/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtAccessors;
import eu.ha3.matmos.game.data.MAtProcessorModel;
import eu.ha3.matmos.game.system.MAtMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.storage.WorldInfo;

public class MAtProcessorFrequent
extends MAtProcessorModel {
    public MAtProcessorFrequent(MAtMod mAtMod, IntegerData integerData, String string, String string2) {
        super(mAtMod, integerData, string, string2);
    }

    @Override
    protected void doProcess() {
        Minecraft minecraft = Minecraft._E();
        pkix pkix2 = minecraft._r;
        WorldInfo worldInfo = MAtAccessors.getWorldInfoOf(pkix2);
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        int n = (int)Math.floor(entityClientPlayerMP.posX);
        int n2 = (int)Math.floor(entityClientPlayerMP.posY);
        int n3 = (int)Math.floor(entityClientPlayerMP.posZ);
        boolean bl = minecraft._L != null && minecraft._L._c == EnumMovingObjectType._a;
        for (Integer n4 : this.getRequired()) {
            switch (n4) {
                case 0: {
                    this.setValue(0, pkix2.getSavedLightValue(EnumSkyBlock._a, n, n2, n3));
                    break;
                }
                case 1: {
                    this.setValue(1, pkix2.getSavedLightValue(EnumSkyBlock._b, n, n2, n3));
                    break;
                }
                case 2: {
                    this.setValue(2, pkix2.getBlockLightValue(n, n2, n3));
                    break;
                }
                case 3: {
                    this.setValue(3, (int)(worldInfo._g() % 160000L));
                    break;
                }
                case 4: {
                    this.setValue(4, n2);
                    break;
                }
                case 6: {
                    this.setValue(6, entityClientPlayerMP.isInWater() ? 1 : 0);
                    break;
                }
                case 7: {
                    this.setValue(7, worldInfo._p() ? 1 : 0);
                    break;
                }
                case 8: {
                    this.setValue(8, worldInfo._n() ? 1 : 0);
                    break;
                }
                case 9: {
                    this.setValue(9, pkix2.canBlockSeeTheSky(n, n2, n3) ? 1 : 0);
                    break;
                }
                case 10: {
                    this.setValue(10, entityClientPlayerMP.dimension == -1 ? 1 : 0);
                    break;
                }
                case 11: {
                    this.setValue(11, pkix2.skylightSubtracted);
                    break;
                }
                case 19: {
                    this.setValue(19, entityClientPlayerMP.isWet() ? 1 : 0);
                    break;
                }
                case 20: {
                    this.setValue(20, n);
                    break;
                }
                case 21: {
                    this.setValue(21, n3);
                    break;
                }
                case 22: {
                    this.setValue(22, entityClientPlayerMP.onGround ? 1 : 0);
                    break;
                }
                case 23: {
                    this.setValue(23, entityClientPlayerMP.getAir());
                    break;
                }
                case 24: {
                    this.setValue(24, (int)Math.ceil(entityClientPlayerMP.getHealth()));
                    break;
                }
                case 25: {
                    this.setValue(25, entityClientPlayerMP.dimension);
                    break;
                }
                case 26: {
                    this.setValue(26, pkix2.canBlockSeeTheSky(n, n2, n3) && pkix2.getTopSolidOrLiquidBlock(n, n3) <= n2 ? 1 : 0);
                    break;
                }
                case 27: {
                    this.setValue(27, pkix2.getTopSolidOrLiquidBlock(n, n3));
                    break;
                }
                case 28: {
                    this.setValue(28, pkix2.getTopSolidOrLiquidBlock(n, n3) - n2);
                    break;
                }
                case 32: {
                    this.setValue(32, entityClientPlayerMP.inventory._a() != null ? entityClientPlayerMP.inventory._a()._d : -1);
                    break;
                }
                case 33: {
                    this.setValue(33, (int)Math.round(entityClientPlayerMP.motionX * 1000.0));
                    break;
                }
                case 34: {
                    this.setValue(34, (int)Math.round(entityClientPlayerMP.motionY * 1000.0));
                    break;
                }
                case 35: {
                    this.setValue(35, (int)Math.round(entityClientPlayerMP.motionZ * 1000.0));
                    break;
                }
                case 36: {
                    this.setValue(36, n2 >= 1 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(minecraft._r.getBlockId(n, n2 - 1, n3)) : -1);
                    break;
                }
                case 37: {
                    this.setValue(37, n2 >= 2 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(minecraft._r.getBlockId(n, n2 - 2, n3)) : -1);
                    break;
                }
                case 38: {
                    this.setValue(38, (int)this.mod().util().getClientTick());
                    break;
                }
                case 39: {
                    this.setValue(39, entityClientPlayerMP.isBurning() ? 1 : 0);
                    break;
                }
                case 40: {
                    this.setValue(40, (int)Math.floor(entityClientPlayerMP.swingProgress * 16.0f));
                    break;
                }
                case 41: {
                    this.setValue(41, entityClientPlayerMP.swingProgress != 0.0f ? 1 : 0);
                    break;
                }
                case 42: {
                    this.setValue(42, MAtAccessors.getIsJumpingOf(this.mod().util(), entityClientPlayerMP) ? 1 : 0);
                    break;
                }
                case 43: {
                    this.setValue(43, (int)(entityClientPlayerMP.fallDistance * 1000.0f));
                    break;
                }
                case 44: {
                    this.setValue(44, MAtAccessors.getIsInWebOf(this.mod().util(), entityClientPlayerMP) ? 1 : 0);
                    break;
                }
                case 45: {
                    int n5 = (int)Math.round(entityClientPlayerMP.motionX * 1000.0);
                    int n6 = (int)Math.round(entityClientPlayerMP.motionZ * 1000.0);
                    this.setValue(45, (int)Math.floor(Math.sqrt(n5 * n5 + n6 * n6)));
                    break;
                }
                case 46: {
                    this.setValue(46, entityClientPlayerMP.inventory._c);
                    break;
                }
                case 47: {
                    this.setValue(47, minecraft._L != null ? 1 : 0);
                    break;
                }
                case 48: {
                    this.setValue(48, minecraft._L != null ? minecraft._L._c.ordinal() : -1);
                    break;
                }
                case 49: {
                    this.setValue(49, entityClientPlayerMP.isBurning() ? 1 : 0);
                    break;
                }
                case 50: {
                    this.setValue(50, entityClientPlayerMP.getTotalArmorValue());
                    break;
                }
                case 51: {
                    this.setValue(51, MAtAccessors.getFoodStatsOf(entityClientPlayerMP)._a());
                    break;
                }
                case 52: {
                    this.setValue(52, (int)(MAtAccessors.getFoodStatsOf(entityClientPlayerMP)._d() * 1000.0f));
                    break;
                }
                case 53: {
                    this.setValue(53, 0);
                    break;
                }
                case 54: {
                    this.setValue(54, (int)(entityClientPlayerMP.experience * 1000.0f));
                    break;
                }
                case 55: {
                    this.setValue(55, entityClientPlayerMP.experienceLevel);
                    break;
                }
                case 56: {
                    this.setValue(56, entityClientPlayerMP.experienceTotal);
                    break;
                }
                case 57: {
                    this.setValue(57, entityClientPlayerMP.isOnLadder() ? 1 : 0);
                    break;
                }
                case 58: {
                    this.setValue(58, entityClientPlayerMP.getItemInUseDuration());
                    break;
                }
                case 59: {
                    this.setValue(59, 0);
                    break;
                }
                case 60: {
                    this.setValue(60, entityClientPlayerMP.isBlocking() ? 1 : 0);
                    break;
                }
                case 61: {
                    this.setValue(61, 72000 - entityClientPlayerMP.getItemInUseDuration());
                    break;
                }
                case 62: {
                    this.setValue(62, entityClientPlayerMP.inventory._a() == null ? -1 : entityClientPlayerMP.inventory._a()._j());
                    break;
                }
                case 63: {
                    this.setValue(63, entityClientPlayerMP.isSprinting() ? 1 : 0);
                    break;
                }
                case 64: {
                    this.setValue(64, entityClientPlayerMP.isSneaking() ? 1 : 0);
                    break;
                }
                case 65: {
                    this.setValue(65, entityClientPlayerMP.isAirBorne ? 1 : 0);
                    break;
                }
                case 66: {
                    this.setValue(66, entityClientPlayerMP.isUsingItem() ? 1 : 0);
                    break;
                }
                case 67: {
                    this.setValue(67, entityClientPlayerMP.isRiding() ? 1 : 0);
                    break;
                }
                case 68: {
                    this.setValue(68, entityClientPlayerMP.ridingEntity != null && entityClientPlayerMP.ridingEntity.getClass() == EntityMinecartEmpty.class ? 1 : 0);
                    break;
                }
                case 69: {
                    this.setValue(69, entityClientPlayerMP.ridingEntity != null && entityClientPlayerMP.ridingEntity.getClass() == EntityBoat.class ? 1 : 0);
                    break;
                }
                case 70: {
                    this.setValue(70, minecraft._j != null && minecraft._j._i() ? 1 : 0);
                    break;
                }
                case 71: {
                    int n7 = entityClientPlayerMP.ridingEntity != null ? (int)Math.round(entityClientPlayerMP.ridingEntity.motionX * 1000.0) : 0;
                    this.setValue(71, n7);
                    break;
                }
                case 72: {
                    int n8 = entityClientPlayerMP.ridingEntity != null ? (int)Math.round(entityClientPlayerMP.ridingEntity.motionY * 1000.0) : 0;
                    this.setValue(72, n8);
                    break;
                }
                case 73: {
                    int n9 = entityClientPlayerMP.ridingEntity != null ? (int)Math.round(entityClientPlayerMP.ridingEntity.motionZ * 1000.0) : 0;
                    this.setValue(73, n9);
                    break;
                }
                case 74: {
                    int n10 = entityClientPlayerMP.ridingEntity != null ? (int)Math.round(entityClientPlayerMP.ridingEntity.motionX * 1000.0) : 0;
                    int n11 = entityClientPlayerMP.ridingEntity != null ? (int)Math.round(entityClientPlayerMP.ridingEntity.motionZ * 1000.0) : 0;
                    this.setValue(74, entityClientPlayerMP.ridingEntity != null ? (int)Math.floor(Math.sqrt(n10 * n10 + n11 * n11)) : 0);
                    break;
                }
                case 86: {
                    this.setValue(86, bl ? pkix2.getBlockId(minecraft._L._d, minecraft._L._e, minecraft._L._f) : 0);
                    break;
                }
                case 87: {
                    this.setValue(87, bl ? pkix2.getBlockMetadata(minecraft._L._d, minecraft._L._e, minecraft._L._f) : 0);
                    break;
                }
                case 89: {
                    this.setValue(89, entityClientPlayerMP.inventory._b[0] != null ? entityClientPlayerMP.inventory._b[0]._d : -1);
                    break;
                }
                case 90: {
                    this.setValue(90, entityClientPlayerMP.inventory._b[1] != null ? entityClientPlayerMP.inventory._b[1]._d : -1);
                    break;
                }
                case 91: {
                    this.setValue(91, entityClientPlayerMP.inventory._b[2] != null ? entityClientPlayerMP.inventory._b[2]._d : -1);
                    break;
                }
                case 92: {
                    this.setValue(92, entityClientPlayerMP.inventory._b[3] != null ? entityClientPlayerMP.inventory._b[3]._d : -1);
                    break;
                }
                case 94: {
                    this.setValue(94, n2 >= 0 && n2 < this.mod().util().getWorldHeight() ? this.getTranslatedBlockId(minecraft._r.getBlockId(n, n2, n3)) : -1);
                    break;
                }
                case 95: {
                    this.setValue(95, n2 >= 0 && n2 < this.mod().util().getWorldHeight() - 1 ? this.getTranslatedBlockId(minecraft._r.getBlockId(n, n2 + 1, n3)) : -1);
                    break;
                }
                case 96: {
                    ItemStack itemStack = entityClientPlayerMP.inventory._a();
                    this.setValue(96, itemStack != null ? itemStack._d : -1);
                    break;
                }
                case 97: {
                    this.setValue(97, minecraft._B != null && minecraft._B instanceof GuiContainer ? 1 : 0);
                    break;
                }
                case 100: {
                    this.setValue(100, entityClientPlayerMP.ridingEntity != null && entityClientPlayerMP.ridingEntity instanceof EntityHorse ? 1 : 0);
                    break;
                }
            }
        }
    }

    private int getTranslatedBlockId(int n) {
        if (n < 0) {
            return 0;
        }
        if (n >= 4096) {
            return 0;
        }
        return n;
    }
}

