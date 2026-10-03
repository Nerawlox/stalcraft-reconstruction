/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.TextureOffset;
import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    public float field_78801_a = 64.0f;
    public float field_78799_b = 32.0f;
    public int field_78803_o;
    public int field_78813_p;
    public float field_78800_c;
    public float field_78797_d;
    public float field_78798_e;
    public float field_78795_f;
    public float field_78796_g;
    public float field_78808_h;
    public boolean field_78812_q;
    public int field_78811_r;
    public boolean field_78809_i;
    public boolean field_78806_j = true;
    public boolean field_78807_k;
    public List field_78804_l = new ArrayList();
    public List field_78805_m;
    public final String field_78802_n;
    public ModelBase field_78810_s;
    public float field_82906_o;
    public float field_82908_p;
    public float field_82907_q;

    public ModelRenderer(ModelBase modelBase, String string) {
        this.field_78810_s = modelBase;
        modelBase.field_78092_r.add(this);
        this.field_78802_n = string;
        this.func_78787_b(modelBase.field_78090_t, modelBase.field_78089_u);
    }

    public ModelRenderer(ModelBase modelBase) {
        this(modelBase, null);
    }

    public ModelRenderer(ModelBase modelBase, int n, int n2) {
        this(modelBase);
        this.func_78784_a(n, n2);
    }

    public void func_78792_a(ModelRenderer modelRenderer) {
        if (this.field_78805_m == null) {
            this.field_78805_m = new ArrayList();
        }
        this.field_78805_m.add(modelRenderer);
    }

    public ModelRenderer func_78784_a(int n, int n2) {
        this.field_78803_o = n;
        this.field_78813_p = n2;
        return this;
    }

    public ModelRenderer func_78786_a(String string, float f, float f2, float f3, int n, int n2, int n3) {
        string = this.field_78802_n + "." + string;
        TextureOffset textureOffset = this.field_78810_s.func_78084_a(string);
        this.func_78784_a(textureOffset.field_78783_a, textureOffset.field_78782_b);
        this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, f, f2, f3, n, n2, n3, 0.0f).func_78244_a(string));
        return this;
    }

    public ModelRenderer func_78789_a(float f, float f2, float f3, int n, int n2, int n3) {
        this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, f, f2, f3, n, n2, n3, 0.0f));
        return this;
    }

    public void func_78790_a(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, f, f2, f3, n, n2, n3, f4));
    }

    public void func_78793_a(float f, float f2, float f3) {
        this.field_78800_c = f;
        this.field_78797_d = f2;
        this.field_78798_e = f3;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78785_a(float f) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.field_78812_q) {
                this.func_78788_d(f);
            }
            GL11.glTranslatef(this.field_82906_o, this.field_82908_p, this.field_82907_q);
            if (this.field_78795_f == 0.0f && this.field_78796_g == 0.0f && this.field_78808_h == 0.0f) {
                if (this.field_78800_c == 0.0f && this.field_78797_d == 0.0f && this.field_78798_e == 0.0f) {
                    GL11.glCallList(this.field_78811_r);
                    if (this.field_78805_m != null) {
                        for (int i = 0; i < this.field_78805_m.size(); ++i) {
                            ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                        }
                    }
                } else {
                    GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
                    GL11.glCallList(this.field_78811_r);
                    if (this.field_78805_m != null) {
                        for (int i = 0; i < this.field_78805_m.size(); ++i) {
                            ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                        }
                    }
                    GL11.glTranslatef(-this.field_78800_c * f, -this.field_78797_d * f, -this.field_78798_e * f);
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
                if (this.field_78808_h != 0.0f) {
                    GL11.glRotatef(this.field_78808_h * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.field_78796_g != 0.0f) {
                    GL11.glRotatef(this.field_78796_g * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.field_78795_f != 0.0f) {
                    GL11.glRotatef(this.field_78795_f * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                GL11.glCallList(this.field_78811_r);
                if (this.field_78805_m != null) {
                    for (int i = 0; i < this.field_78805_m.size(); ++i) {
                        ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                    }
                }
                GL11.glPopMatrix();
            }
            GL11.glTranslatef(-this.field_82906_o, -this.field_82908_p, -this.field_82907_q);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78791_b(float f) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.field_78812_q) {
                this.func_78788_d(f);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
            if (this.field_78796_g != 0.0f) {
                GL11.glRotatef(this.field_78796_g * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.field_78795_f != 0.0f) {
                GL11.glRotatef(this.field_78795_f * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.field_78808_h != 0.0f) {
                GL11.glRotatef(this.field_78808_h * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            GL11.glCallList(this.field_78811_r);
            GL11.glPopMatrix();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78794_c(float f) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.field_78812_q) {
                this.func_78788_d(f);
            }
            if (this.field_78795_f == 0.0f && this.field_78796_g == 0.0f && this.field_78808_h == 0.0f) {
                if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f) {
                    GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
                }
            } else {
                GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
                if (this.field_78808_h != 0.0f) {
                    GL11.glRotatef(this.field_78808_h * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.field_78796_g != 0.0f) {
                    GL11.glRotatef(this.field_78796_g * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.field_78795_f != 0.0f) {
                    GL11.glRotatef(this.field_78795_f * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_78788_d(float f) {
        this.field_78811_r = pklh._a(1);
        GL11.glNewList(this.field_78811_r, 4864);
        htvf htvf2 = htvf.field_78398_a;
        for (int i = 0; i < this.field_78804_l.size(); ++i) {
            ((ModelBox)this.field_78804_l.get(i)).func_78245_a(htvf2, f);
        }
        GL11.glEndList();
        this.field_78812_q = true;
    }

    public ModelRenderer func_78787_b(int n, int n2) {
        this.field_78801_a = n;
        this.field_78799_b = n2;
        return this;
    }
}

