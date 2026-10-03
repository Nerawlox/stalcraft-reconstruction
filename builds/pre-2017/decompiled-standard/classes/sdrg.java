/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.iurn;
import net.minecraftforge.common.ForgeDirection;

public interface sdrg {
    public int func_72798_a(int var1, int var2, int var3);

    public hurg func_72796_p(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public int func_72802_i(int var1, int var2, int var3, int var4);

    public int func_72805_g(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public float func_72808_j(int var1, int var2, int var3, int var4);

    @SideOnly(value=Side.CLIENT)
    public float func_72801_o(int var1, int var2, int var3);

    public tflj func_72803_f(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public boolean func_72804_r(int var1, int var2, int var3);

    public boolean func_72809_s(int var1, int var2, int var3);

    public boolean func_72799_c(int var1, int var2, int var3);

    @SideOnly(value=Side.CLIENT)
    public foqh func_72807_a(int var1, int var2);

    @SideOnly(value=Side.CLIENT)
    public int func_72800_K();

    @SideOnly(value=Side.CLIENT)
    public boolean func_72806_N();

    @SideOnly(value=Side.CLIENT)
    public boolean func_72797_t(int var1, int var2, int var3);

    public iurn func_82732_R();

    public int func_72879_k(int var1, int var2, int var3, int var4);

    public boolean isBlockSolidOnSide(int var1, int var2, int var3, ForgeDirection var4, boolean var5);
}

