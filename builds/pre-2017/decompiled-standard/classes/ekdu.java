/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ekdu
extends gqjz {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/demo_background.png");

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        int n = -16;
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 - 116, this.field_73881_g / 2 + 62 + n, 114, 20, wpcz._a("demo.help.buy")));
        this.field_73887_h.add(new jiok(2, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 62 + n, 114, 20, wpcz._a("demo.help.later")));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        switch (jiok2.field_73741_f) {
            case 2: {
                this.field_73882_e._a((gqjz)null);
                this.field_73882_e._o();
                break;
            }
            case 1: {
                jiok2.field_73742_g = false;
                try {
                    Class<?> clazz = Class.forName("java.awt.Desktop");
                    Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    clazz.getMethod("browse", URI.class).invoke(object, new URI("http://www.minecraft.net/store?source=demo"));
                    break;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
    }

    @Override
    public void func_73873_v_() {
        super.func_73873_v_();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n = (this.field_73880_f - 248) / 2;
        int n2 = (this.field_73881_g - 166) / 2;
        this.func_73729_b(n, n2, 0, 0, 248, 166);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        int n3 = (this.field_73880_f - 248) / 2 + 10;
        int n4 = (this.field_73881_g - 166) / 2 + 8;
        this.field_73886_k._b(wpcz._a("demo.help.title"), n3, n4, 0x1F1F1F);
        GameSettings gameSettings = this.field_73882_e._M;
        this.field_73886_k._b(wpcz._a("demo.help.movementShort", GameSettings.func_74298_c(gameSettings.field_74351_w._d), GameSettings.func_74298_c(gameSettings.field_74370_x._d), GameSettings.func_74298_c(gameSettings.field_74368_y._d), GameSettings.func_74298_c(gameSettings.field_74366_z._d)), n3, n4 += 12, 0x4F4F4F);
        this.field_73886_k._b(wpcz._a("demo.help.movementMouse"), n3, n4 + 12, 0x4F4F4F);
        this.field_73886_k._b(wpcz._a("demo.help.jump", GameSettings.func_74298_c(gameSettings.field_74314_A._d)), n3, n4 + 24, 0x4F4F4F);
        this.field_73886_k._b(wpcz._a("demo.help.inventory", GameSettings.func_74298_c(gameSettings.field_74315_B._d)), n3, n4 + 36, 0x4F4F4F);
        this.field_73886_k._a(wpcz._a("demo.help.fullWrapped"), n3, n4 + 68, 218, 0x1F1F1F);
        super.func_73863_a(n, n2, f);
    }
}

