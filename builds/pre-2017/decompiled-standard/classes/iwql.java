/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class iwql
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/brewing_stand.png");
    public nfbs _b;

    public iwql(eidj eidj2, nfbs nfbs2) {
        super(new tgbu(eidj2, nfbs2));
        this._b = nfbs2;
    }

    @Override
    public void func_74189_g(int n, int n2) {
        String string = this._b.func_94042_c() ? this._b.func_70303_b() : wpcz._a(this._b.func_70303_b());
        this.field_73886_k._b(string, this.field_74194_b / 2 - this.field_73886_k._b(string) / 2, 6, 0x404040);
        this.field_73886_k._b(wpcz._a("container.inventory"), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        int n5 = this._b._a();
        if (n5 > 0) {
            int n6 = (int)(28.0f * (1.0f - (float)n5 / 400.0f));
            if (n6 > 0) {
                this.func_73729_b(n3 + 97, n4 + 16, 176, 0, 9, n6);
            }
            int n7 = n5 / 2 % 7;
            switch (n7) {
                case 6: {
                    n6 = 0;
                    break;
                }
                case 5: {
                    n6 = 6;
                    break;
                }
                case 4: {
                    n6 = 11;
                    break;
                }
                case 3: {
                    n6 = 16;
                    break;
                }
                case 2: {
                    n6 = 20;
                    break;
                }
                case 1: {
                    n6 = 24;
                    break;
                }
                case 0: {
                    n6 = 29;
                }
            }
            if (n6 > 0) {
                this.func_73729_b(n3 + 65, n4 + 14 + 29 - n6, 185, 29 - n6, 12, n6);
            }
        }
    }
}

