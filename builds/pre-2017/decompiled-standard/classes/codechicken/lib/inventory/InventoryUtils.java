/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.inventory;

import codechicken.lib.inventory.InventoryRange;
import com.google.common.base.Objects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.ForgeDirection;

public class InventoryUtils {
    public static final ForgeDirection[] chestSides = new ForgeDirection[]{ForgeDirection.WEST, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH};

    public static cvzo decrStackSize(mssh mssh2, int n, int n2) {
        cvzo cvzo2 = mssh2.func_70301_a(n);
        if (cvzo2 != null) {
            if (cvzo2._b <= n2) {
                cvzo cvzo3 = cvzo2;
                mssh2.func_70299_a(n, null);
                mssh2.func_70296_d();
                return cvzo3;
            }
            cvzo cvzo4 = cvzo2._a(n2);
            if (cvzo2._b == 0) {
                mssh2.func_70299_a(n, null);
            }
            mssh2.func_70296_d();
            return cvzo4;
        }
        return null;
    }

    public static cvzo getStackInSlotOnClosing(mssh mssh2, int n) {
        cvzo cvzo2 = mssh2.func_70301_a(n);
        mssh2.func_70299_a(n, null);
        return cvzo2;
    }

    public static int incrStackSize(cvzo cvzo2, cvzo cvzo3) {
        if (InventoryUtils.canStack(cvzo2, cvzo3)) {
            return InventoryUtils.incrStackSize(cvzo2, cvzo3._b);
        }
        return 0;
    }

    public static int incrStackSize(cvzo cvzo2, int n) {
        int n2 = cvzo2._b + n;
        if (n2 <= cvzo2._d()) {
            return n;
        }
        if (cvzo2._b < cvzo2._d()) {
            return cvzo2._d() - cvzo2._b;
        }
        return 0;
    }

    public static bsyv writeItemStacksToTag(cvzo[] cvzoArray) {
        return InventoryUtils.writeItemStacksToTag(cvzoArray, 64);
    }

    public static bsyv writeItemStacksToTag(cvzo[] cvzoArray, int n) {
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < cvzoArray.length; ++i) {
            if (cvzoArray[i] == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (short)i);
            cvzoArray[i]._b(qoac2);
            if (n > Short.MAX_VALUE) {
                qoac2._a("Quantity", cvzoArray[i]._b);
            } else if (n > 127) {
                qoac2._a("Quantity", (short)cvzoArray[i]._b);
            }
            bsyv2._a(qoac2);
        }
        return bsyv2;
    }

    public static void readItemStacksFromTag(cvzo[] cvzoArray, bsyv bsyv2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            short s = qoac2._e("Slot");
            cvzoArray[s] = cvzo._a(qoac2);
            if (!qoac2._c("Quantity")) continue;
            huhy huhy2 = qoac2._b("Quantity");
            if (huhy2 instanceof hdfw) {
                cvzoArray[s]._b = ((hdfw)huhy2)._c;
                continue;
            }
            if (!(huhy2 instanceof ixnt)) continue;
            cvzoArray[s]._b = ((ixnt)huhy2)._c;
        }
    }

    public static cvzo copyStack(cvzo cvzo2, int n) {
        if (cvzo2 == null) {
            return null;
        }
        cvzo2 = cvzo2._l();
        cvzo2._b = n;
        return cvzo2;
    }

    public static int getInsertibleQuantity(InventoryRange inventoryRange, cvzo cvzo2) {
        int n = 0;
        cvzo2 = InventoryUtils.copyStack(cvzo2, Integer.MAX_VALUE);
        for (int n2 : inventoryRange.slots) {
            n += InventoryUtils.fitStackInSlot(inventoryRange, n2, cvzo2);
        }
        return n;
    }

    public static int getInsertibleQuantity(mssh mssh2, cvzo cvzo2) {
        return InventoryUtils.getInsertibleQuantity(new InventoryRange(mssh2), cvzo2);
    }

    public static int fitStackInSlot(InventoryRange inventoryRange, int n, cvzo cvzo2) {
        cvzo cvzo3 = inventoryRange.inv.func_70301_a(n);
        if (!InventoryUtils.canStack(cvzo3, cvzo2) || !inventoryRange.canInsertItem(n, cvzo2)) {
            return 0;
        }
        int n2 = cvzo3 != null ? InventoryUtils.incrStackSize(cvzo3, inventoryRange.inv.func_70297_j_() - cvzo3._b) : inventoryRange.inv.func_70297_j_();
        return Math.min(n2, cvzo2._b);
    }

    public static int fitStackInSlot(mssh mssh2, int n, cvzo cvzo2) {
        return InventoryUtils.fitStackInSlot(new InventoryRange(mssh2), n, cvzo2);
    }

    public static int insertItem(InventoryRange inventoryRange, cvzo cvzo2, boolean bl) {
        cvzo2 = cvzo2._l();
        for (int i = 0; i < 2; ++i) {
            for (int n : inventoryRange.slots) {
                cvzo cvzo3 = inventoryRange.inv.func_70301_a(n);
                int n2 = InventoryUtils.fitStackInSlot(inventoryRange, n, cvzo2);
                if (n2 == 0) continue;
                if (cvzo3 != null) {
                    cvzo2._b -= n2;
                    if (!bl) {
                        cvzo3._b += n2;
                        inventoryRange.inv.func_70299_a(n, cvzo3);
                    }
                } else if (i == 1) {
                    if (!bl) {
                        inventoryRange.inv.func_70299_a(n, InventoryUtils.copyStack(cvzo2, n2));
                    }
                    cvzo2._b -= n2;
                }
                if (cvzo2._b != 0) continue;
                return 0;
            }
        }
        return cvzo2._b;
    }

    public static int insertItem(mssh mssh2, cvzo cvzo2, boolean bl) {
        return InventoryUtils.insertItem(new InventoryRange(mssh2), cvzo2, bl);
    }

    public static cvzo getExtractableStack(InventoryRange inventoryRange, int n) {
        cvzo cvzo2 = inventoryRange.inv.func_70301_a(n);
        if (cvzo2 == null || !inventoryRange.canExtractItem(n, cvzo2)) {
            return null;
        }
        return cvzo2;
    }

    public static cvzo getExtractableStack(mssh mssh2, int n) {
        return InventoryUtils.getExtractableStack(new InventoryRange(mssh2), n);
    }

    public static boolean areStacksIdentical(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo2 == null || cvzo3 == null) {
            return cvzo2 == cvzo3;
        }
        return cvzo2._d == cvzo3._d && cvzo2._j() == cvzo3._j() && cvzo2._b == cvzo3._b && Objects.equal(cvzo2._q(), cvzo3._q());
    }

    public static mssh getInventory(ozlu ozlu2, int n, int n2, int n3) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (!(hurg2 instanceof mssh)) {
            return null;
        }
        if (hurg2 instanceof yfav) {
            return InventoryUtils.getChest((yfav)hurg2);
        }
        return (mssh)((Object)hurg2);
    }

    public static mssh getChest(yfav yfav2) {
        for (ForgeDirection forgeDirection : chestSides) {
            if (yfav2.field_70331_k.func_72798_a(yfav2.field_70329_l + forgeDirection.offsetX, yfav2.field_70330_m + forgeDirection.offsetY, yfav2.field_70327_n + forgeDirection.offsetZ) != yfav2.func_70311_o().field_71990_ca) continue;
            return new huew("container.chestDouble", (yfav)yfav2.field_70331_k.func_72796_p(yfav2.field_70329_l + forgeDirection.offsetX, yfav2.field_70330_m + forgeDirection.offsetY, yfav2.field_70327_n + forgeDirection.offsetZ), yfav2);
        }
        return yfav2;
    }

    public static boolean canStack(cvzo cvzo2, cvzo cvzo3) {
        return cvzo2 == null || cvzo3 == null || cvzo2._d == cvzo3._d && (!cvzo3._g() || cvzo3._j() == cvzo2._j()) && cvzo._a(cvzo3, cvzo2) && cvzo2._e();
    }

    public static void consumeItem(mssh mssh2, int n) {
        cvzo cvzo2 = mssh2.func_70301_a(n);
        tgdv tgdv2 = cvzo2._a();
        if (tgdv2.func_77634_r()) {
            cvzo cvzo3 = tgdv2.getContainerItemStack(cvzo2);
            mssh2.func_70299_a(n, cvzo3);
        } else {
            mssh2.func_70298_a(n, 1);
        }
    }

    public static int stackSize(mssh mssh2, int n) {
        cvzo cvzo2 = mssh2.func_70301_a(n);
        return cvzo2 == null ? 0 : cvzo2._b;
    }

    public static void dropOnClose(EntityPlayer entityPlayer, mssh mssh2) {
        for (int i = 0; i < mssh2.func_70302_i_(); ++i) {
            cvzo cvzo2 = mssh2.func_70304_b(i);
            if (cvzo2 == null) continue;
            entityPlayer.func_71021_b(cvzo2);
        }
    }

    public static int actualDamage(cvzo cvzo2) {
        return tgdv.field_77702_n.getDamage(cvzo2);
    }
}

