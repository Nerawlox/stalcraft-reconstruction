/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class htnm
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/crafting_table.png");

    public htnm(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        super(new xsrv(eidj2, ozlu2, n, n2, n3));
    }

    @Override
    public void func_74189_g(int n, int n2) {
        this.field_73886_k._b(wpcz._a("container.crafting"), 28, 6, 0x404040);
        this.field_73886_k._b(wpcz._a("container.inventory"), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
    }
}

