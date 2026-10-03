/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class rrbo
extends ItemFood
implements IPlantable {
    public int _a;
    public int _b;

    public rrbo(int n, int n2, float f, int n3, int n4) {
        super(n, n2, f, false);
        this._a = n3;
        this._b = n4;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 != 1) {
            return false;
        }
        if (entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack) && entityPlayer.canPlayerEdit(n, n2 + 1, n3, n4, itemStack)) {
            int n5 = world.getBlockId(n, n2, n3);
            Block block = Block.blocksList[n5];
            if (block != null && block.canSustainPlant(world, n, n2, n3, ForgeDirection.UP, this) && world.isAirBlock(n, n2 + 1, n3)) {
                world.setBlock(n, n2 + 1, n3, this._a);
                --itemStack._b;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public EnumPlantType getPlantType(World world, int n, int n2, int n3) {
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(World world, int n, int n2, int n3) {
        return this._a;
    }

    @Override
    public int getPlantMetadata(World world, int n, int n2, int n3) {
        return 0;
    }
}

