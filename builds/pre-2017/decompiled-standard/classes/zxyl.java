/*
 * Decompiled with CFR 0.152.
 */
import codechicken.nei.ItemMobSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;

public class zxyl
extends iwgt {
    public zxyl(int n) {
        super(n, tflj._e);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new xtcq();
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(ozlu ozlu2, int n, int n2) {
        return 15 + ozlu2.field_73012_v.nextInt(15) + ozlu2.field_73012_v.nextInt(15);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        ItemMobSpawner.placedX = n;
        ItemMobSpawner.placedY = n2;
        ItemMobSpawner.placedZ = n3;
    }
}

