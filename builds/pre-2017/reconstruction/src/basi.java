/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class basi
extends nduf {
    public basi(int n) {
        super(n);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return 15;
    }
}

