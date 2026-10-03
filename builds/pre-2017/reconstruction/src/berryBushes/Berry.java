/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import berryBushes.Base;
import berryBushes.te.BushTE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class Berry
extends ItemFood {
    private int Meta;

    public Berry(int n, int n2, float f, int n3) {
        super(n, n2, f, false);
        this.Meta = n3;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        switch (this.Meta) {
            case 0: {
                this.itemIcon = iconRegister._b("berries:berryI");
                break;
            }
            case 1: {
                this.itemIcon = iconRegister._b("berries:berry");
                break;
            }
            case 2: {
                this.itemIcon = iconRegister._b("berries:berryIII");
                break;
            }
            case 3: {
                this.itemIcon = iconRegister._b("berries:berryIV");
                break;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        switch (this.Meta) {
            case 0: {
                list2.add(tdpx._a("A small juicy berry"));
                list2.add(tdpx._a("1.5/10"));
                break;
            }
            case 1: {
                list2.add(tdpx._a("A sweet small tasty berry"));
                list2.add(tdpx._a("2/10"));
                break;
            }
            case 2: {
                list2.add(tdpx._a("A juicy, tasty, big berry"));
                list2.add(tdpx._a("3/10"));
                break;
            }
            case 3: {
                list2.add(tdpx._a("A giant sweet and juicy berry"));
                list2.add(tdpx._a("4/10"));
                break;
            }
        }
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (this.Meta == 0 && (world.getBlockId(n, n2, n3) == Block.grass.blockID || world.getBlockId(n, n2, n3) == Block.dirt.blockID)) {
            world.setBlock(n, n2 + 1, n3, Base.berryCrop.blockID);
            BushTE bushTE = new BushTE();
            bushTE.isCrop = true;
            world.setBlockTileEntity(n, n2 + 1, n3, bushTE);
            --entityPlayer.getCurrentEquippedItem()._b;
        }
        return false;
    }
}

