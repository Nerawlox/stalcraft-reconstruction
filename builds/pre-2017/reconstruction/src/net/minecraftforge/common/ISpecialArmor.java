/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public interface ISpecialArmor {
    public ArmorProperties getProperties(EntityLivingBase var1, ItemStack var2, DamageSource var3, double var4, int var6);

    public int getArmorDisplay(EntityPlayer var1, ItemStack var2, int var3);

    public void damageArmor(EntityLivingBase var1, ItemStack var2, DamageSource var3, int var4, int var5);

    public static class ArmorProperties
    implements Comparable<ArmorProperties> {
        public int Priority = 0;
        public int AbsorbMax = Integer.MAX_VALUE;
        public double AbsorbRatio = 0.0;
        public int Slot = 0;
        private static final boolean DEBUG = false;

        public ArmorProperties(int n, double d, int n2) {
            this.Priority = n;
            this.AbsorbRatio = d;
            this.AbsorbMax = n2;
        }

        public static float ApplyArmor(EntityLivingBase entityLivingBase, ItemStack[] itemStackArray, DamageSource damageSource, double d) {
            d *= 25.0;
            ArrayList<ArmorProperties> arrayList = new ArrayList<ArmorProperties>();
            for (int i = 0; i < itemStackArray.length; ++i) {
                Object object;
                ItemStack itemStack = itemStackArray[i];
                if (itemStack == null) continue;
                ArmorProperties armorProperties = null;
                if (itemStack._a() instanceof ISpecialArmor) {
                    object = (ISpecialArmor)((Object)itemStack._a());
                    armorProperties = object.getProperties(entityLivingBase, itemStack, damageSource, d / 25.0, i).copy();
                } else if (itemStack._a() instanceof ItemArmor && !damageSource.isUnblockable()) {
                    object = (ItemArmor)itemStack._a();
                    armorProperties = new ArmorProperties(0, (double)((ItemArmor)object).damageReduceAmount / 25.0, ((Item)object).getMaxDamage() + 1 - itemStack._j());
                }
                if (armorProperties == null) continue;
                armorProperties.Slot = i;
                arrayList.add(armorProperties);
            }
            if (arrayList.size() > 0) {
                ArmorProperties[] armorPropertiesArray = arrayList.toArray(new ArmorProperties[arrayList.size()]);
                ArmorProperties.StandardizeList(armorPropertiesArray, d);
                int n = armorPropertiesArray[0].Priority;
                double d2 = 0.0;
                for (ArmorProperties armorProperties : armorPropertiesArray) {
                    if (n != armorProperties.Priority) {
                        d -= d * d2;
                        d2 = 0.0;
                        n = armorProperties.Priority;
                    }
                    d2 += armorProperties.AbsorbRatio;
                    double d3 = d * armorProperties.AbsorbRatio;
                    if (!(d3 > 0.0)) continue;
                    ItemStack itemStack = itemStackArray[armorProperties.Slot];
                    int n2 = (int)(d3 / 25.0 < 1.0 ? 1.0 : d3 / 25.0);
                    if (itemStack._a() instanceof ISpecialArmor) {
                        ((ISpecialArmor)((Object)itemStack._a())).damageArmor(entityLivingBase, itemStack, damageSource, n2, armorProperties.Slot);
                    } else {
                        itemStack._a(n2, entityLivingBase);
                    }
                    if (itemStack._b > 0) continue;
                    itemStackArray[armorProperties.Slot] = null;
                }
                d -= d * d2;
            }
            return (float)(d / 25.0);
        }

        private static void StandardizeList(ArmorProperties[] armorPropertiesArray, double d) {
            Arrays.sort(armorPropertiesArray);
            int n = 0;
            double d2 = 0.0;
            int n2 = armorPropertiesArray[0].Priority;
            int n3 = 0;
            boolean bl = false;
            boolean bl2 = false;
            for (int i = 0; i < armorPropertiesArray.length; ++i) {
                int n4;
                d2 += armorPropertiesArray[i].AbsorbRatio;
                if (i != armorPropertiesArray.length - 1 && armorPropertiesArray[i].Priority == n2) continue;
                if (armorPropertiesArray[i].Priority != n2) {
                    d2 -= armorPropertiesArray[i].AbsorbRatio;
                    --i;
                    bl = true;
                }
                if (d2 > 1.0) {
                    for (n4 = n; n4 <= i; ++n4) {
                        double d3 = armorPropertiesArray[n4].AbsorbRatio / d2;
                        if (d3 * d > (double)armorPropertiesArray[n4].AbsorbMax) {
                            armorPropertiesArray[n4].AbsorbRatio = (double)armorPropertiesArray[n4].AbsorbMax / d;
                            d2 = 0.0;
                            for (int j = n3; j <= n4; ++j) {
                                d2 += armorPropertiesArray[j].AbsorbRatio;
                            }
                            n = n4 + 1;
                            i = n4;
                            break;
                        }
                        armorPropertiesArray[n4].AbsorbRatio = d3;
                        bl2 = true;
                    }
                    if (!bl || !bl2) continue;
                    d -= d * d2;
                    d2 = 0.0;
                    n = i + 1;
                    n2 = armorPropertiesArray[n].Priority;
                    n3 = n;
                    bl = false;
                    bl2 = false;
                    if (!(d <= 0.0)) continue;
                    for (n4 = i + 1; n4 < armorPropertiesArray.length; ++n4) {
                        armorPropertiesArray[n4].AbsorbRatio = 0.0;
                    }
                } else {
                    for (n4 = n; n4 <= i; ++n4) {
                        d2 -= armorPropertiesArray[n4].AbsorbRatio;
                        if (d * armorPropertiesArray[n4].AbsorbRatio > (double)armorPropertiesArray[n4].AbsorbMax) {
                            armorPropertiesArray[n4].AbsorbRatio = (double)armorPropertiesArray[n4].AbsorbMax / d;
                        }
                        d2 += armorPropertiesArray[n4].AbsorbRatio;
                    }
                    d -= d * d2;
                    d2 = 0.0;
                    if (i == armorPropertiesArray.length - 1) continue;
                    n = i + 1;
                    n2 = armorPropertiesArray[n].Priority;
                    n3 = n;
                    bl = false;
                    if (!(d <= 0.0)) continue;
                    for (n4 = i + 1; n4 < armorPropertiesArray.length; ++n4) {
                        armorPropertiesArray[n4].AbsorbRatio = 0.0;
                    }
                }
                break;
            }
        }

        @Override
        public int compareTo(ArmorProperties armorProperties) {
            if (armorProperties.Priority != this.Priority) {
                return armorProperties.Priority - this.Priority;
            }
            double d = this.AbsorbRatio == 0.0 ? 0.0 : (double)this.AbsorbMax * 100.0 / this.AbsorbRatio;
            double d2 = armorProperties.AbsorbRatio == 0.0 ? 0.0 : (double)armorProperties.AbsorbMax * 100.0 / armorProperties.AbsorbRatio;
            return (int)(d - d2);
        }

        public String toString() {
            return String.format("%d, %d, %f, %d", this.Priority, this.AbsorbMax, this.AbsorbRatio, this.AbsorbRatio == 0.0 ? 0 : (int)((double)this.AbsorbMax * 100.0 / this.AbsorbRatio));
        }

        public ArmorProperties copy() {
            return new ArmorProperties(this.Priority, this.AbsorbRatio, this.AbsorbMax);
        }
    }
}

