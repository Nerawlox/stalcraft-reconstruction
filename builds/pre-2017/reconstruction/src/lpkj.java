/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ezfa;
import net.minecraft.world.World;

public final class lpkj
extends bbmo {
    public final bbmo _a = new bbmo();

    @Override
    public ItemStack _b(ekuw ekuw2, ItemStack itemStack) {
        double d;
        int n;
        int n2;
        ezfa ezfa2 = BlockDispenser._a(ekuw2._h());
        World world = ekuw2._a();
        double d2 = ekuw2._b() + (double)((float)ezfa2._a() * 1.125f);
        double d3 = ekuw2._c() + (double)((float)ezfa2._b() * 1.125f);
        double d4 = ekuw2._d() + (double)((float)ezfa2._c() * 1.125f);
        int n3 = ekuw2._e() + ezfa2._a();
        Material material = world.getBlockMaterial(n3, n2 = ekuw2._f() + ezfa2._b(), n = ekuw2._g() + ezfa2._c());
        if (Material._h.equals(material)) {
            d = 1.0;
        } else if (Material._a.equals(material) && Material._h.equals(world.getBlockMaterial(n3, n2 - 1, n))) {
            d = 0.0;
        } else {
            return this._a._a(ekuw2, itemStack);
        }
        EntityBoat entityBoat = new EntityBoat(world, d2, d3 + d, d4);
        world.spawnEntityInWorld(entityBoat);
        itemStack._a(1);
        return itemStack;
    }

    @Override
    public void _a(ekuw ekuw2) {
        ekuw2._a().playAuxSFX(1000, ekuw2._e(), ekuw2._f(), ekuw2._g(), 0);
    }
}

