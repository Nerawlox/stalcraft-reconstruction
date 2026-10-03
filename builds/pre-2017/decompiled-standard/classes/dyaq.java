/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.settings.kjui;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class dyaq
extends jiok {
    public float field_73751_j = 1.0f;
    public boolean field_73752_k;
    public kjui field_73750_l;

    public dyaq(int n, int n2, int n3, kjui kjui2, String string, float f) {
        super(n, n2, n3, 150, 20, string);
        this.field_73750_l = kjui2;
        this.field_73751_j = f;
        GloomyHooks.onGuiSliderInit(this, n, n2, n3, kjui2, string, f);
    }

    @Override
    public int func_73738_a(boolean bl) {
        return 0;
    }

    @Override
    public void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        if (this.field_73752_k) {
            this.field_73751_j = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
            if (this.field_73751_j < 0.0f) {
                this.field_73751_j = 0.0f;
            }
            if (this.field_73751_j > 1.0f) {
                this.field_73751_j = 1.0f;
            }
            xpzm2._M.func_74304_a(this.field_73750_l, this.field_73751_j);
            this.field_73744_e = xpzm2._M.func_74297_c(this.field_73750_l);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, 20);
        this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, 20);
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (super.func_73736_c(xpzm2, n, n2)) {
            this.field_73751_j = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
            if (this.field_73751_j < 0.0f) {
                this.field_73751_j = 0.0f;
            }
            if (this.field_73751_j > 1.0f) {
                this.field_73751_j = 1.0f;
            }
            xpzm2._M.func_74304_a(this.field_73750_l, this.field_73751_j);
            this.field_73744_e = xpzm2._M.func_74297_c(this.field_73750_l);
            this.field_73752_k = true;
            return true;
        }
        return false;
    }

    @Override
    public void func_73740_a(int n, int n2) {
        this.field_73752_k = false;
    }
}

