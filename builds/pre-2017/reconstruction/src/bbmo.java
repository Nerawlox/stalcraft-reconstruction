/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public class bbmo
implements vmgb {
    @Override
    public final ItemStack _a(ekuw ekuw2, ItemStack itemStack) {
        ItemStack itemStack2 = this._b(ekuw2, itemStack);
        this._a(ekuw2);
        this._a(ekuw2, BlockDispenser._a(ekuw2._h()));
        return itemStack2;
    }

    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        yent yent2 = BlockDispenser._a(ekuw2);
        ItemStack itemStack2 = itemStack._a(1);
        bbmo._a(ekuw2._a(), itemStack2, 6, ezfa2, yent2);
        return itemStack;
    }

    public static void _a(World world, ItemStack itemStack, int n, ezfa ezfa2, yent yent2) {
        double d = yent2._b();
        double d2 = yent2._c();
        double d3 = yent2._d();
        EntityItem entityItem = new EntityItem(world, d, d2 - 0.3, d3, itemStack);
        double d4 = world.rand.nextDouble() * 0.1 + 0.2;
        entityItem.motionX = (double)ezfa2._a() * d4;
        entityItem.motionY = 0.2f;
        entityItem.motionZ = (double)ezfa2._c() * d4;
        entityItem.motionX += world.rand.nextGaussian() * (double)0.0075f * (double)n;
        entityItem.motionY += world.rand.nextGaussian() * (double)0.0075f * (double)n;
        entityItem.motionZ += world.rand.nextGaussian() * (double)0.0075f * (double)n;
        world.spawnEntityInWorld(entityItem);
    }

    public void _a(ekuw ekuw2) {
        ekuw2._a().playAuxSFX(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }

    public void _a(ekuw ekuw2, ezfa ezfa2) {
        ekuw2._a().playAuxSFX(2000, ekuw2._e(), ekuw2._f(), ekuw2._g(), this._a(ezfa2));
    }

    public int _a(ezfa ezfa2) {
        return ezfa2._a() + 1 + (ezfa2._c() + 1) * 3;
    }
}

