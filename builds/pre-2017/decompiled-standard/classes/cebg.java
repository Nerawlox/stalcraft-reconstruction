/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class cebg
extends lpaq {
    public float _f;
    public float _g;

    public cebg(EntityPlayer entityPlayer) {
        super(entityPlayer.field_71069_bz);
        this.field_73885_j = true;
        entityPlayer.func_71064_a(sdqa._f, 1);
    }

    @Override
    public void func_73876_c() {
        if (GloomyHooks.getTrue()) {
            return;
        }
        super.func_73876_c();
        if (this.field_73882_e._j._i()) {
            this.field_73882_e._a(new qngy(this.field_73882_e._t));
        }
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        if (this.field_73882_e._j._i()) {
            this.field_73882_e._a(new qngy(this.field_73882_e._t));
        } else {
            super.func_73866_w_();
        }
    }

    @Override
    public void func_74189_g(int n, int n2) {
        this.field_73886_k._b(wpcz._a("container.crafting"), 86, 16, 0x404040);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this._f = n;
        this._g = n2;
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(field_110408_a);
        int n3 = this.field_74198_m;
        int n4 = this.field_74197_n;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        cebg._a(n3 + 51, n4 + 75, 30, (float)(n3 + 51) - this._f, (float)(n4 + 75 - 50) - this._g, this.field_73882_e._t);
    }

    public static void _a(int n, int n2, int n3, float f, float f2, EntityLivingBase entityLivingBase) {
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n, n2, 50.0f);
        GL11.glScalef(-n3, n3, n3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = entityLivingBase.field_70761_aq;
        float f4 = entityLivingBase.field_70177_z;
        float f5 = entityLivingBase.field_70125_A;
        float f6 = entityLivingBase.field_70758_at;
        float f7 = entityLivingBase.field_70759_as;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f2 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entityLivingBase.field_70761_aq = (float)Math.atan(f / 40.0f) * 20.0f;
        entityLivingBase.field_70177_z = (float)Math.atan(f / 40.0f) * 40.0f;
        entityLivingBase.field_70125_A = -((float)Math.atan(f2 / 40.0f)) * 20.0f;
        entityLivingBase.field_70759_as = entityLivingBase.field_70177_z;
        entityLivingBase.field_70758_at = entityLivingBase.field_70177_z;
        GL11.glTranslatef(0.0f, entityLivingBase.field_70129_M, 0.0f);
        gqqu._b._l = 180.0f;
        gqqu._b._a(entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        entityLivingBase.field_70761_aq = f3;
        entityLivingBase.field_70177_z = f4;
        entityLivingBase.field_70125_A = f5;
        entityLivingBase.field_70758_at = f6;
        entityLivingBase.field_70759_as = f7;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(new ohbq(this.field_73882_e._X));
        }
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(new uzta(this, this.field_73882_e._X));
        }
    }
}

