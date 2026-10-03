/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;
import noppes.npcs.entity.EntityNpcDragon;
import org.lwjgl.opengl.GL11;

public class ModelNpcDragon
extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer neck;
    private ModelRenderer jaw;
    private ModelRenderer body;
    private ModelRenderer rearLeg;
    private ModelRenderer frontLeg;
    private ModelRenderer rearLegTip;
    private ModelRenderer frontLegTip;
    private ModelRenderer rearFoot;
    private ModelRenderer frontFoot;
    private ModelRenderer wing;
    private ModelRenderer wingTip;
    private float field_40317_s;

    public ModelNpcDragon(float f) {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.func_78085_a("body.body", 0, 0);
        this.func_78085_a("wing.skin", -56, 88);
        this.func_78085_a("wingtip.skin", -56, 144);
        this.func_78085_a("rearleg.main", 0, 0);
        this.func_78085_a("rearfoot.main", 112, 0);
        this.func_78085_a("rearlegtip.main", 196, 0);
        this.func_78085_a("head.upperhead", 112, 30);
        this.func_78085_a("wing.bone", 112, 88);
        this.func_78085_a("head.upperlip", 176, 44);
        this.func_78085_a("jaw.jaw", 176, 65);
        this.func_78085_a("frontleg.main", 112, 104);
        this.func_78085_a("wingtip.bone", 112, 136);
        this.func_78085_a("frontfoot.main", 144, 104);
        this.func_78085_a("neck.box", 192, 104);
        this.func_78085_a("frontlegtip.main", 226, 138);
        this.func_78085_a("body.iconScale", 220, 53);
        this.func_78085_a("head.iconScale", 0, 0);
        this.func_78085_a("neck.iconScale", 48, 0);
        this.func_78085_a("head.nostril", 112, 0);
        float f2 = -16.0f;
        this.head = new ModelRenderer(this, "head");
        this.head.func_78786_a("upperlip", -6.0f, -1.0f, -8.0f + f2, 12, 5, 16);
        this.head.func_78786_a("upperhead", -8.0f, -8.0f, 6.0f + f2, 16, 16, 16);
        this.head.field_78809_i = true;
        this.head.func_78786_a("iconScale", -5.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.head.func_78786_a("nostril", -5.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.head.field_78809_i = false;
        this.head.func_78786_a("iconScale", 3.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.head.func_78786_a("nostril", 3.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.func_78793_a(0.0f, 4.0f, 8.0f + f2);
        this.jaw.func_78786_a("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.func_78792_a(this.jaw);
        this.neck = new ModelRenderer(this, "neck");
        this.neck.func_78786_a("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.neck.func_78786_a("iconScale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.body = new ModelRenderer(this, "body");
        this.body.func_78793_a(0.0f, 4.0f, 8.0f);
        this.body.func_78786_a("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.body.func_78786_a("iconScale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.body.func_78786_a("iconScale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.body.func_78786_a("iconScale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.func_78793_a(-12.0f, 5.0f, 2.0f);
        this.wing.func_78786_a("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.func_78786_a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.func_78793_a(-56.0f, 0.0f, 0.0f);
        this.wingTip.func_78786_a("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.func_78786_a("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.func_78792_a(this.wingTip);
        this.frontLeg = new ModelRenderer(this, "frontleg");
        this.frontLeg.func_78793_a(-12.0f, 20.0f, 2.0f);
        this.frontLeg.func_78786_a("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.frontLegTip = new ModelRenderer(this, "frontlegtip");
        this.frontLegTip.func_78793_a(0.0f, 20.0f, -1.0f);
        this.frontLegTip.func_78786_a("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.frontLeg.func_78792_a(this.frontLegTip);
        this.frontFoot = new ModelRenderer(this, "frontfoot");
        this.frontFoot.func_78793_a(0.0f, 23.0f, 0.0f);
        this.frontFoot.func_78786_a("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.frontLegTip.func_78792_a(this.frontFoot);
        this.rearLeg = new ModelRenderer(this, "rearleg");
        this.rearLeg.func_78793_a(-16.0f, 16.0f, 42.0f);
        this.rearLeg.func_78786_a("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.rearLegTip = new ModelRenderer(this, "rearlegtip");
        this.rearLegTip.func_78793_a(0.0f, 32.0f, -4.0f);
        this.rearLegTip.func_78786_a("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.rearLeg.func_78792_a(this.rearLegTip);
        this.rearFoot = new ModelRenderer(this, "rearfoot");
        this.rearFoot.func_78793_a(0.0f, 31.0f, 4.0f);
        this.rearFoot.func_78786_a("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.rearLegTip.func_78792_a(this.rearFoot);
    }

    @Override
    public void func_78086_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.field_40317_s = f3;
    }

    @Override
    public void func_78088_a(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        EntityNpcDragon entityNpcDragon = (EntityNpcDragon)entity;
        GL11.glPushMatrix();
        float f7 = entityNpcDragon.field_40173_aw + (entityNpcDragon.field_40172_ax - entityNpcDragon.field_40173_aw) * this.field_40317_s;
        this.jaw.field_78795_f = (float)(Math.sin(f7 * (float)Math.PI * 2.0f) + 1.0) * 0.2f;
        float f8 = (float)(Math.sin(f7 * (float)Math.PI * 2.0f - 1.0f) + 1.0);
        f8 = (f8 * f8 * 1.0f + f8 * 2.0f) * 0.05f;
        GL11.glTranslatef(0.0f, f8 - 2.0f, -3.0f);
        GL11.glRotatef(f8 * 2.0f, 1.0f, 0.0f, 0.0f);
        float f9 = -30.0f;
        float f10 = 22.0f;
        float f11 = 0.0f;
        float f12 = 1.5f;
        double[] dArray = entityNpcDragon.func_40160_a(6, this.field_40317_s);
        float f13 = this.func_40307_a(entityNpcDragon.func_40160_a(5, this.field_40317_s)[0] - entityNpcDragon.func_40160_a(10, this.field_40317_s)[0]);
        float f14 = this.func_40307_a(entityNpcDragon.func_40160_a(5, this.field_40317_s)[0] + (double)(f13 / 2.0f));
        f9 += 2.0f;
        float f15 = 0.0f;
        float f16 = f7 * 3.141593f * 2.0f;
        f9 = 20.0f;
        f10 = -12.0f;
        for (int i = 0; i < 5; ++i) {
            double[] dArray2 = entityNpcDragon.func_40160_a(5 - i, this.field_40317_s);
            f15 = (float)Math.cos((float)i * 0.45f + f16) * 0.15f;
            this.neck.field_78796_g = this.func_40307_a(dArray2[0] - dArray[0]) * (float)Math.PI / 180.0f * f12;
            this.neck.field_78795_f = f15 + (float)(dArray2[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.neck.field_78808_h = -this.func_40307_a(dArray2[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.neck.field_78797_d = f9;
            this.neck.field_78798_e = f10;
            this.neck.field_78800_c = f11;
            f9 = (float)((double)f9 + Math.sin(this.neck.field_78795_f) * 10.0);
            f10 = (float)((double)f10 - Math.cos(this.neck.field_78796_g) * Math.cos(this.neck.field_78795_f) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.neck.field_78796_g) * Math.cos(this.neck.field_78795_f) * 10.0);
            this.neck.func_78785_a(f6);
        }
        this.head.field_78797_d = f9;
        this.head.field_78798_e = f10;
        this.head.field_78800_c = f11;
        double[] dArray3 = entityNpcDragon.func_40160_a(0, this.field_40317_s);
        this.head.field_78796_g = this.func_40307_a(dArray3[0] - dArray[0]) * (float)Math.PI / 180.0f * 1.0f;
        this.head.field_78808_h = -this.func_40307_a(dArray3[0] - (double)f14) * (float)Math.PI / 180.0f * 1.0f;
        this.head.func_78785_a(f6);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        if (entityNpcDragon.field_70122_E) {
            GL11.glRotatef(-f13 * f12 * 0.3f, 0.0f, 0.0f, 1.0f);
        } else {
            GL11.glRotatef(-f13 * f12 * 1.0f, 0.0f, 0.0f, 1.0f);
        }
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        this.body.field_78808_h = 0.0f;
        this.body.func_78785_a(f6);
        if (entityNpcDragon.field_70122_E) {
            for (n = 0; n < 2; ++n) {
                GL11.glEnable(2884);
                this.wing.field_78795_f = 0.25f;
                this.wing.field_78796_g = 0.95f;
                this.wing.field_78808_h = -0.5f;
                this.wingTip.field_78808_h = -0.4f;
                this.frontLeg.field_78795_f = sajh._b((float)((double)(f * 0.6662f) + (n == 0 ? 0.0 : Math.PI))) * 0.6f * f2 + 0.45f + f8 * 0.5f;
                this.frontLegTip.field_78795_f = -1.3f - f8 * 1.2f;
                this.frontFoot.field_78795_f = 0.85f + f8 * 0.5f;
                this.frontLeg.func_78785_a(f6);
                this.rearLeg.field_78795_f = sajh._b((float)((double)(f * 0.6662f) + (n == 0 ? Math.PI : 0.0))) * 0.6f * f2 + 0.75f + f8 * 0.5f;
                this.rearLegTip.field_78795_f = -1.6f - f8 * 0.8f;
                this.rearLegTip.field_78797_d = 20.0f;
                this.rearLegTip.field_78798_e = 2.0f;
                this.rearFoot.field_78795_f = 0.85f + f8 * 0.2f;
                this.rearLeg.func_78785_a(f6);
                this.wing.func_78785_a(f6);
                GL11.glScalef(-1.0f, 1.0f, 1.0f);
                if (n != 0) continue;
                GL11.glCullFace(1028);
            }
        } else {
            for (n = 0; n < 2; ++n) {
                GL11.glEnable(2884);
                float f17 = f7 * (float)Math.PI * 2.0f;
                this.wing.field_78795_f = 0.125f - (float)Math.cos(f17) * 0.2f;
                this.wing.field_78796_g = 0.25f;
                this.wing.field_78808_h = (float)(Math.sin(f17) + 0.125) * 0.8f;
                this.wingTip.field_78808_h = -((float)(Math.sin(f17 + 2.0f) + 0.5)) * 0.75f;
                this.rearLegTip.field_78797_d = 32.0f;
                this.rearLegTip.field_78798_e = -2.0f;
                this.rearLeg.field_78795_f = 1.0f + f8 * 0.1f;
                this.rearLegTip.field_78795_f = 0.5f + f8 * 0.1f;
                this.rearFoot.field_78795_f = 0.75f + f8 * 0.1f;
                this.frontLeg.field_78795_f = 1.3f + f8 * 0.1f;
                this.frontLegTip.field_78795_f = -0.5f - f8 * 0.1f;
                this.frontFoot.field_78795_f = 0.75f + f8 * 0.1f;
                this.wing.func_78785_a(f6);
                this.frontLeg.func_78785_a(f6);
                this.rearLeg.func_78785_a(f6);
                GL11.glScalef(-1.0f, 1.0f, 1.0f);
                if (n != 0) continue;
                GL11.glCullFace(1028);
            }
        }
        GL11.glPopMatrix();
        GL11.glCullFace(1029);
        GL11.glDisable(2884);
        f15 = -((float)Math.sin(f7 * 3.141593f * 2.0f)) * 0.0f;
        f16 = f7 * (float)Math.PI * 2.0f;
        f9 = 10.0f;
        f10 = 60.0f;
        f11 = 0.0f;
        dArray = entityNpcDragon.func_40160_a(11, this.field_40317_s);
        for (n = 0; n < 12; ++n) {
            double[] dArray4 = entityNpcDragon.func_40160_a(12 + n, this.field_40317_s);
            f15 = (float)((double)f15 + Math.sin((float)n * 0.45f + f16) * (double)0.05f);
            this.neck.field_78796_g = (this.func_40307_a(dArray4[0] - dArray[0]) * f12 + 180.0f) * (float)Math.PI / 180.0f;
            this.neck.field_78795_f = f15 + (float)(dArray4[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.neck.field_78808_h = this.func_40307_a(dArray4[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.neck.field_78797_d = f9;
            this.neck.field_78798_e = f10;
            this.neck.field_78800_c = f11;
            f9 = (float)((double)f9 + Math.sin(this.neck.field_78795_f) * 10.0);
            f10 = (float)((double)f10 - Math.cos(this.neck.field_78796_g) * Math.cos(this.neck.field_78795_f) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.neck.field_78796_g) * Math.cos(this.neck.field_78795_f) * 10.0);
            this.neck.func_78785_a(f6);
        }
        GL11.glPopMatrix();
    }

    private float func_40307_a(double d) {
        while (d >= 180.0) {
            d -= 360.0;
        }
        while (d < -180.0) {
            d += 360.0;
        }
        return (float)d;
    }
}

