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
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("body.body", 0, 0);
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("rearleg.main", 0, 0);
        this.setTextureOffset("rearfoot.main", 112, 0);
        this.setTextureOffset("rearlegtip.main", 196, 0);
        this.setTextureOffset("head.upperhead", 112, 30);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("head.upperlip", 176, 44);
        this.setTextureOffset("jaw.jaw", 176, 65);
        this.setTextureOffset("frontleg.main", 112, 104);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.setTextureOffset("frontfoot.main", 144, 104);
        this.setTextureOffset("neck.box", 192, 104);
        this.setTextureOffset("frontlegtip.main", 226, 138);
        this.setTextureOffset("body.iconScale", 220, 53);
        this.setTextureOffset("head.iconScale", 0, 0);
        this.setTextureOffset("neck.iconScale", 48, 0);
        this.setTextureOffset("head.nostril", 112, 0);
        float f2 = -16.0f;
        this.head = new ModelRenderer(this, "head");
        this.head.addBox("upperlip", -6.0f, -1.0f, -8.0f + f2, 12, 5, 16);
        this.head.addBox("upperhead", -8.0f, -8.0f, 6.0f + f2, 16, 16, 16);
        this.head.mirror = true;
        this.head.addBox("iconScale", -5.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.head.addBox("nostril", -5.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.head.mirror = false;
        this.head.addBox("iconScale", 3.0f, -12.0f, 12.0f + f2, 2, 4, 6);
        this.head.addBox("nostril", 3.0f, -3.0f, -6.0f + f2, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.setRotationPoint(0.0f, 4.0f, 8.0f + f2);
        this.jaw.addBox("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.addChild(this.jaw);
        this.neck = new ModelRenderer(this, "neck");
        this.neck.addBox("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.neck.addBox("iconScale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.body = new ModelRenderer(this, "body");
        this.body.setRotationPoint(0.0f, 4.0f, 8.0f);
        this.body.addBox("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.body.addBox("iconScale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.body.addBox("iconScale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.body.addBox("iconScale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.setRotationPoint(-12.0f, 5.0f, 2.0f);
        this.wing.addBox("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.setRotationPoint(-56.0f, 0.0f, 0.0f);
        this.wingTip.addBox("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.addChild(this.wingTip);
        this.frontLeg = new ModelRenderer(this, "frontleg");
        this.frontLeg.setRotationPoint(-12.0f, 20.0f, 2.0f);
        this.frontLeg.addBox("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.frontLegTip = new ModelRenderer(this, "frontlegtip");
        this.frontLegTip.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.frontLegTip.addBox("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.frontLeg.addChild(this.frontLegTip);
        this.frontFoot = new ModelRenderer(this, "frontfoot");
        this.frontFoot.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.frontFoot.addBox("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.frontLegTip.addChild(this.frontFoot);
        this.rearLeg = new ModelRenderer(this, "rearleg");
        this.rearLeg.setRotationPoint(-16.0f, 16.0f, 42.0f);
        this.rearLeg.addBox("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.rearLegTip = new ModelRenderer(this, "rearlegtip");
        this.rearLegTip.setRotationPoint(0.0f, 32.0f, -4.0f);
        this.rearLegTip.addBox("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.rearLeg.addChild(this.rearLegTip);
        this.rearFoot = new ModelRenderer(this, "rearfoot");
        this.rearFoot.setRotationPoint(0.0f, 31.0f, 4.0f);
        this.rearFoot.addBox("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.rearLegTip.addChild(this.rearFoot);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this.field_40317_s = f3;
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        EntityNpcDragon entityNpcDragon = (EntityNpcDragon)entity;
        GL11.glPushMatrix();
        float f7 = entityNpcDragon.field_40173_aw + (entityNpcDragon.field_40172_ax - entityNpcDragon.field_40173_aw) * this.field_40317_s;
        this.jaw.rotateAngleX = (float)(Math.sin(f7 * (float)Math.PI * 2.0f) + 1.0) * 0.2f;
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
            this.neck.rotateAngleY = this.func_40307_a(dArray2[0] - dArray[0]) * (float)Math.PI / 180.0f * f12;
            this.neck.rotateAngleX = f15 + (float)(dArray2[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.neck.rotateAngleZ = -this.func_40307_a(dArray2[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.neck.rotationPointY = f9;
            this.neck.rotationPointZ = f10;
            this.neck.rotationPointX = f11;
            f9 = (float)((double)f9 + Math.sin(this.neck.rotateAngleX) * 10.0);
            f10 = (float)((double)f10 - Math.cos(this.neck.rotateAngleY) * Math.cos(this.neck.rotateAngleX) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.neck.rotateAngleY) * Math.cos(this.neck.rotateAngleX) * 10.0);
            this.neck.render(f6);
        }
        this.head.rotationPointY = f9;
        this.head.rotationPointZ = f10;
        this.head.rotationPointX = f11;
        double[] dArray3 = entityNpcDragon.func_40160_a(0, this.field_40317_s);
        this.head.rotateAngleY = this.func_40307_a(dArray3[0] - dArray[0]) * (float)Math.PI / 180.0f * 1.0f;
        this.head.rotateAngleZ = -this.func_40307_a(dArray3[0] - (double)f14) * (float)Math.PI / 180.0f * 1.0f;
        this.head.render(f6);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        if (entityNpcDragon.onGround) {
            GL11.glRotatef(-f13 * f12 * 0.3f, 0.0f, 0.0f, 1.0f);
        } else {
            GL11.glRotatef(-f13 * f12 * 1.0f, 0.0f, 0.0f, 1.0f);
        }
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        this.body.rotateAngleZ = 0.0f;
        this.body.render(f6);
        if (entityNpcDragon.onGround) {
            for (n = 0; n < 2; ++n) {
                GL11.glEnable(2884);
                this.wing.rotateAngleX = 0.25f;
                this.wing.rotateAngleY = 0.95f;
                this.wing.rotateAngleZ = -0.5f;
                this.wingTip.rotateAngleZ = -0.4f;
                this.frontLeg.rotateAngleX = sajh._b((float)((double)(f * 0.6662f) + (n == 0 ? 0.0 : Math.PI))) * 0.6f * f2 + 0.45f + f8 * 0.5f;
                this.frontLegTip.rotateAngleX = -1.3f - f8 * 1.2f;
                this.frontFoot.rotateAngleX = 0.85f + f8 * 0.5f;
                this.frontLeg.render(f6);
                this.rearLeg.rotateAngleX = sajh._b((float)((double)(f * 0.6662f) + (n == 0 ? Math.PI : 0.0))) * 0.6f * f2 + 0.75f + f8 * 0.5f;
                this.rearLegTip.rotateAngleX = -1.6f - f8 * 0.8f;
                this.rearLegTip.rotationPointY = 20.0f;
                this.rearLegTip.rotationPointZ = 2.0f;
                this.rearFoot.rotateAngleX = 0.85f + f8 * 0.2f;
                this.rearLeg.render(f6);
                this.wing.render(f6);
                GL11.glScalef(-1.0f, 1.0f, 1.0f);
                if (n != 0) continue;
                GL11.glCullFace(1028);
            }
        } else {
            for (n = 0; n < 2; ++n) {
                GL11.glEnable(2884);
                float f17 = f7 * (float)Math.PI * 2.0f;
                this.wing.rotateAngleX = 0.125f - (float)Math.cos(f17) * 0.2f;
                this.wing.rotateAngleY = 0.25f;
                this.wing.rotateAngleZ = (float)(Math.sin(f17) + 0.125) * 0.8f;
                this.wingTip.rotateAngleZ = -((float)(Math.sin(f17 + 2.0f) + 0.5)) * 0.75f;
                this.rearLegTip.rotationPointY = 32.0f;
                this.rearLegTip.rotationPointZ = -2.0f;
                this.rearLeg.rotateAngleX = 1.0f + f8 * 0.1f;
                this.rearLegTip.rotateAngleX = 0.5f + f8 * 0.1f;
                this.rearFoot.rotateAngleX = 0.75f + f8 * 0.1f;
                this.frontLeg.rotateAngleX = 1.3f + f8 * 0.1f;
                this.frontLegTip.rotateAngleX = -0.5f - f8 * 0.1f;
                this.frontFoot.rotateAngleX = 0.75f + f8 * 0.1f;
                this.wing.render(f6);
                this.frontLeg.render(f6);
                this.rearLeg.render(f6);
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
            this.neck.rotateAngleY = (this.func_40307_a(dArray4[0] - dArray[0]) * f12 + 180.0f) * (float)Math.PI / 180.0f;
            this.neck.rotateAngleX = f15 + (float)(dArray4[1] - dArray[1]) * (float)Math.PI / 180.0f * f12 * 5.0f;
            this.neck.rotateAngleZ = this.func_40307_a(dArray4[0] - (double)f14) * (float)Math.PI / 180.0f * f12;
            this.neck.rotationPointY = f9;
            this.neck.rotationPointZ = f10;
            this.neck.rotationPointX = f11;
            f9 = (float)((double)f9 + Math.sin(this.neck.rotateAngleX) * 10.0);
            f10 = (float)((double)f10 - Math.cos(this.neck.rotateAngleY) * Math.cos(this.neck.rotateAngleX) * 10.0);
            f11 = (float)((double)f11 - Math.sin(this.neck.rotateAngleY) * Math.cos(this.neck.rotateAngleX) * 10.0);
            this.neck.render(f6);
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

