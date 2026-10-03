/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  ms
 *  we
 *  wh
 */
package ru.stalcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.inventory.ICustomContainer;
import ru.stalcraft.inventory.StalkerSlot;
import ru.stalcraft.items.IStalkerArmor;

class SlotArmor
extends StalkerSlot {
    final int armorType;

    SlotArmor(uy parent, ICustomContainer customContainer, mo par2IInventory, int par3, int par4, int par5, int par6) {
        super(parent, customContainer, par2IInventory, par3, par4, par5);
        this.armorType = par6;
    }

    public int a() {
        return 1;
    }

    public boolean a(ye par1ItemStack) {
        yc item = par1ItemStack == null ? null : par1ItemStack.b();
        boolean isValidArmor = item != null && item.isValidArmor(par1ItemStack, this.armorType, this.customContainer.getOwner());
        boolean isSuitable = true;
        if (item instanceof IStalkerArmor && ((IStalkerArmor)((Object)item)).getSetID() != null) {
            IStalkerArmor newArmor = (IStalkerArmor)((Object)item);
            for (we slot : this.customContainer.getArmorSlots()) {
                IStalkerArmor armor;
                if (!slot.e() || !(slot.d().b() instanceof IStalkerArmor) || (armor = (IStalkerArmor)((Object)slot.d().b())).getSetID() == null || armor.getSetID().equals(newArmor.getSetID()) || newArmor.getArmorType() == armor.getArmorType()) continue;
                isSuitable = false;
                break;
            }
        }
        return isValidArmor && isSuitable;
    }

    @SideOnly(value=Side.CLIENT)
    public ms c() {
        return wh.b((int)this.armorType);
    }
}

