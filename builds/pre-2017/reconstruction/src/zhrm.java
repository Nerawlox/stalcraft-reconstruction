/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.owak;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public abstract class zhrm
extends bbmo {
    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        World world = ekuw2._a();
        yent yent2 = BlockDispenser._a(ekuw2);
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        owak owak2 = this._a(world, yent2);
        owak2.setThrowableHeading(ezfa2._a(), (float)ezfa2._b() + 0.1f, ezfa2._c(), this._b(), this._a());
        world.spawnEntityInWorld((Entity)((Object)owak2));
        itemStack._a(1);
        return itemStack;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().playAuxSFX(1002, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }

    public abstract owak _a(World var1, yent var2);

    public float _a() {
        return 6.0f;
    }

    public float _b() {
        return 1.1f;
    }
}

