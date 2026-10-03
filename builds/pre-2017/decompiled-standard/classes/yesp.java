/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.dwan;

public class yesp
extends yeso {
    public final int field_75236_a;
    public final ohws field_75235_b;

    public yesp(ohws ohws2, mssh mssh2, int n, int n2, int n3, int n4) {
        super(mssh2, n, n2, n3);
        this.field_75235_b = ohws2;
        this.field_75236_a = n4;
    }

    @Override
    public int func_75219_a() {
        return 1;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        tgdv tgdv2 = cvzo2 == null ? null : cvzo2._a();
        return tgdv2 != null && tgdv2.isValidArmor(cvzo2, this.field_75236_a, this.field_75235_b._d);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_75212_b() {
        return lpno.func_94602_b(this.field_75236_a);
    }
}

