/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;
import noppes.npcs.client.model.util.ModelPlaneRenderer;
import org.lwjgl.opengl.GL11;

public class ModelPony
extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer[] Headpiece;
    public ModelRenderer Helmet;
    public ModelRenderer Body;
    public ModelPlaneRenderer[] Bodypiece;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer unicornarm;
    public ModelPlaneRenderer[] Tail;
    public ModelRenderer[] LeftWing;
    public ModelRenderer[] RightWing;
    public ModelRenderer[] LeftWingExt;
    public ModelRenderer[] RightWingExt;
    public boolean isPegasus;
    public boolean isUnicorn;
    public boolean isFlying;
    public boolean isGlow;
    public boolean isSleeping;
    public boolean isSneak;
    public boolean aimedBow;
    public int heldItemRight;
    private boolean rainboom;
    private float WingRotateAngleX;
    private float WingRotateAngleY;
    private float WingRotateAngleZ;
    private float TailRotateAngleY;

    public ModelPony(float f) {
        this.init(f, 0.0f);
    }

    public void init(float f, float f2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0f, -4.0f, -6.0f, 8, 8, 8, f);
        this.Head.setRotationPoint(f3, f4 + f2, f5);
        this.Headpiece = new ModelRenderer[3];
        this.Headpiece[0] = new ModelRenderer(this, 12, 16);
        this.Headpiece[0].addBox(-4.0f, -6.0f, -1.0f, 2, 2, 2, f);
        this.Headpiece[0].setRotationPoint(f3, f4 + f2, f5);
        this.Headpiece[1] = new ModelRenderer(this, 12, 16);
        this.Headpiece[1].addBox(2.0f, -6.0f, -1.0f, 2, 2, 2, f);
        this.Headpiece[1].setRotationPoint(f3, f4 + f2, f5);
        this.Headpiece[2] = new ModelRenderer(this, 56, 0);
        this.Headpiece[2].addBox(-0.5f, -10.0f, -4.0f, 1, 4, 1, f);
        this.Headpiece[2].setRotationPoint(f3, f4 + f2, f5);
        this.Helmet = new ModelRenderer(this, 32, 0);
        this.Helmet.addBox(-4.0f, -4.0f, -6.0f, 8, 8, 8, f + 0.5f);
        this.Helmet.setRotationPoint(f3, f4, f5);
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.addBox(-4.0f, 4.0f, -2.0f, 8, 8, 4, f);
        this.Body.setRotationPoint(f6, f7 + f2, f8);
        this.Bodypiece = new ModelPlaneRenderer[13];
        this.Bodypiece[0] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[0].addSidePlane(-4.0f, 4.0f, 2.0f, 8, 8, f);
        this.Bodypiece[0].setRotationPoint(f6, f7 + f2, f8);
        this.Bodypiece[1] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[1].addSidePlane(4.0f, 4.0f, 2.0f, 8, 8, f);
        this.Bodypiece[1].setRotationPoint(f6, f7 + f2, f8);
        this.Bodypiece[2] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[2].addTopPlane(-4.0f, 4.0f, 2.0f, 8, 8, f);
        this.Bodypiece[2].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[3] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[3].addTopPlane(-4.0f, 12.0f, 2.0f, 8, 8, f);
        this.Bodypiece[3].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[4] = new ModelPlaneRenderer(this, 0, 20);
        this.Bodypiece[4].addSidePlane(-4.0f, 4.0f, 10.0f, 8, 4, f);
        this.Bodypiece[4].setRotationPoint(f6, f7 + f2, f8);
        this.Bodypiece[5] = new ModelPlaneRenderer(this, 0, 20);
        this.Bodypiece[5].addSidePlane(4.0f, 4.0f, 10.0f, 8, 4, f);
        this.Bodypiece[5].setRotationPoint(f6, f7 + f2, f8);
        this.Bodypiece[6] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[6].addTopPlane(-4.0f, 4.0f, 10.0f, 8, 4, f);
        this.Bodypiece[6].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[7] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[7].addTopPlane(-4.0f, 12.0f, 10.0f, 8, 4, f);
        this.Bodypiece[7].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[8] = new ModelPlaneRenderer(this, 24, 0);
        this.Bodypiece[8].addBackPlane(-4.0f, 4.0f, 14.0f, 8, 8, f);
        this.Bodypiece[8].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[9] = new ModelPlaneRenderer(this, 32, 0);
        this.Bodypiece[9].addTopPlane(-1.0f, 10.0f, 8.0f, 2, 6, f);
        this.Bodypiece[9].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[10] = new ModelPlaneRenderer(this, 32, 0);
        this.Bodypiece[10].addTopPlane(-1.0f, 12.0f, 8.0f, 2, 6, f);
        this.Bodypiece[10].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[11] = new ModelPlaneRenderer(this, 32, 0);
        this.Bodypiece[11].mirror = true;
        this.Bodypiece[11].addSidePlane(-1.0f, 10.0f, 8.0f, 2, 6, f);
        this.Bodypiece[11].setRotationPoint(f3, f4 + f2, f5);
        this.Bodypiece[12] = new ModelPlaneRenderer(this, 32, 0);
        this.Bodypiece[12].addSidePlane(1.0f, 10.0f, 8.0f, 2, 6, f);
        this.Bodypiece[12].setRotationPoint(f3, f4 + f2, f5);
        this.RightArm = new ModelRenderer(this, 40, 16);
        this.RightArm.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.RightArm.setRotationPoint(-3.0f, 8.0f + f2, 0.0f);
        this.LeftArm = new ModelRenderer(this, 40, 16);
        this.LeftArm.mirror = true;
        this.LeftArm.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftArm.setRotationPoint(3.0f, 8.0f + f2, 0.0f);
        this.RightLeg = new ModelRenderer(this, 40, 16);
        this.RightLeg.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.RightLeg.setRotationPoint(-3.0f, 0.0f + f2, 0.0f);
        this.LeftLeg = new ModelRenderer(this, 40, 16);
        this.LeftLeg.mirror = true;
        this.LeftLeg.addBox(-2.0f, 4.0f, -2.0f, 4, 12, 4, f);
        this.LeftLeg.setRotationPoint(3.0f, 0.0f + f2, 0.0f);
        this.unicornarm = new ModelRenderer(this, 40, 16);
        this.unicornarm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.unicornarm.setRotationPoint(-5.0f, 2.0f + f2, 0.0f);
        float f9 = 0.0f;
        float f10 = 8.0f;
        float f11 = -14.0f;
        float f12 = 0.0f - f9;
        float f13 = 10.0f - f10;
        float f14 = 0.0f;
        this.Tail = new ModelPlaneRenderer[10];
        this.Tail[0] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[0].addTopPlane(-2.0f + f9, -7.0f + f10, 16.0f + f11, 4, 4, f);
        this.Tail[0].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[1] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[1].addTopPlane(-2.0f + f9, 9.0f + f10, 16.0f + f11, 4, 4, f);
        this.Tail[1].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[2] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[2].addBackPlane(-2.0f + f9, -7.0f + f10, 16.0f + f11, 4, 8, f);
        this.Tail[2].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[3] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[3].addBackPlane(-2.0f + f9, -7.0f + f10, 20.0f + f11, 4, 8, f);
        this.Tail[3].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[4] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[4].addBackPlane(-2.0f + f9, 1.0f + f10, 16.0f + f11, 4, 8, f);
        this.Tail[4].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[5] = new ModelPlaneRenderer(this, 32, 0);
        this.Tail[5].addBackPlane(-2.0f + f9, 1.0f + f10, 20.0f + f11, 4, 8, f);
        this.Tail[5].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[6] = new ModelPlaneRenderer(this, 36, 0);
        this.Tail[6].mirror = true;
        this.Tail[6].addSidePlane(2.0f + f9, -7.0f + f10, 16.0f + f11, 8, 4, f);
        this.Tail[6].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[7] = new ModelPlaneRenderer(this, 36, 0);
        this.Tail[7].addSidePlane(-2.0f + f9, -7.0f + f10, 16.0f + f11, 8, 4, f);
        this.Tail[7].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[8] = new ModelPlaneRenderer(this, 36, 0);
        this.Tail[8].mirror = true;
        this.Tail[8].addSidePlane(2.0f + f9, 1.0f + f10, 16.0f + f11, 8, 4, f);
        this.Tail[8].setRotationPoint(f12, f13 + f2, f14);
        this.Tail[9] = new ModelPlaneRenderer(this, 36, 0);
        this.Tail[9].addSidePlane(-2.0f + f9, 1.0f + f10, 16.0f + f11, 8, 4, f);
        this.Tail[9].setRotationPoint(f12, f13 + f2, f14);
        this.TailRotateAngleY = this.Tail[0].rotateAngleY;
        this.TailRotateAngleY = this.Tail[0].rotateAngleY;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        this.LeftWing = new ModelRenderer[3];
        this.LeftWing[0] = new ModelRenderer(this, 56, 16);
        this.LeftWing[0].mirror = true;
        this.LeftWing[0].addBox(4.0f, 5.0f, 2.0f, 2, 6, 2, f);
        this.LeftWing[0].setRotationPoint(f15, f16 + f2, f17);
        this.LeftWing[1] = new ModelRenderer(this, 56, 16);
        this.LeftWing[1].mirror = true;
        this.LeftWing[1].addBox(4.0f, 5.0f, 4.0f, 2, 8, 2, f);
        this.LeftWing[1].setRotationPoint(f15, f16 + f2, f17);
        this.LeftWing[2] = new ModelRenderer(this, 56, 16);
        this.LeftWing[2].mirror = true;
        this.LeftWing[2].addBox(4.0f, 5.0f, 6.0f, 2, 6, 2, f);
        this.LeftWing[2].setRotationPoint(f15, f16 + f2, f17);
        this.RightWing = new ModelRenderer[3];
        this.RightWing[0] = new ModelRenderer(this, 56, 16);
        this.RightWing[0].addBox(-6.0f, 5.0f, 2.0f, 2, 6, 2, f);
        this.RightWing[0].setRotationPoint(f15, f16 + f2, f17);
        this.RightWing[1] = new ModelRenderer(this, 56, 16);
        this.RightWing[1].addBox(-6.0f, 5.0f, 4.0f, 2, 8, 2, f);
        this.RightWing[1].setRotationPoint(f15, f16 + f2, f17);
        this.RightWing[2] = new ModelRenderer(this, 56, 16);
        this.RightWing[2].addBox(-6.0f, 5.0f, 6.0f, 2, 6, 2, f);
        this.RightWing[2].setRotationPoint(f15, f16 + f2, f17);
        float f18 = f3 + 4.5f;
        float f19 = f4 + 5.0f;
        float f20 = f5 + 6.0f;
        this.LeftWingExt = new ModelRenderer[7];
        this.LeftWingExt[0] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[0].mirror = true;
        this.LeftWingExt[0].addBox(0.0f, 0.0f, 0.0f, 1, 8, 2, f + 0.1f);
        this.LeftWingExt[0].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[1] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[1].mirror = true;
        this.LeftWingExt[1].addBox(0.0f, 8.0f, 0.0f, 1, 6, 2, f + 0.1f);
        this.LeftWingExt[1].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[2] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[2].mirror = true;
        this.LeftWingExt[2].addBox(0.0f, -1.2f, -0.2f, 1, 8, 2, f - 0.2f);
        this.LeftWingExt[2].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[3] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[3].mirror = true;
        this.LeftWingExt[3].addBox(0.0f, 1.8f, 1.3f, 1, 8, 2, f - 0.1f);
        this.LeftWingExt[3].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[4] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[4].mirror = true;
        this.LeftWingExt[4].addBox(0.0f, 5.0f, 2.0f, 1, 8, 2, f);
        this.LeftWingExt[4].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[5] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[5].mirror = true;
        this.LeftWingExt[5].addBox(0.0f, 0.0f, -0.2f, 1, 6, 2, f + 0.3f);
        this.LeftWingExt[5].setRotationPoint(f18, f19 + f2, f20);
        this.LeftWingExt[6] = new ModelRenderer(this, 56, 19);
        this.LeftWingExt[6].mirror = true;
        this.LeftWingExt[6].addBox(0.0f, 0.0f, 0.2f, 1, 3, 2, f + 0.2f);
        this.LeftWingExt[6].setRotationPoint(f18, f19 + f2, f20);
        float f21 = f3 - 4.5f;
        float f22 = f4 + 5.0f;
        float f23 = f5 + 6.0f;
        this.RightWingExt = new ModelRenderer[7];
        this.RightWingExt[0] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[0].mirror = true;
        this.RightWingExt[0].addBox(0.0f, 0.0f, 0.0f, 1, 8, 2, f + 0.1f);
        this.RightWingExt[0].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[1] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[1].mirror = true;
        this.RightWingExt[1].addBox(0.0f, 8.0f, 0.0f, 1, 6, 2, f + 0.1f);
        this.RightWingExt[1].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[2] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[2].mirror = true;
        this.RightWingExt[2].addBox(0.0f, -1.2f, -0.2f, 1, 8, 2, f - 0.2f);
        this.RightWingExt[2].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[3] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[3].mirror = true;
        this.RightWingExt[3].addBox(0.0f, 1.8f, 1.3f, 1, 8, 2, f - 0.1f);
        this.RightWingExt[3].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[4] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[4].mirror = true;
        this.RightWingExt[4].addBox(0.0f, 5.0f, 2.0f, 1, 8, 2, f);
        this.RightWingExt[4].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[5] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[5].mirror = true;
        this.RightWingExt[5].addBox(0.0f, 0.0f, -0.2f, 1, 6, 2, f + 0.3f);
        this.RightWingExt[5].setRotationPoint(f21, f22 + f2, f23);
        this.RightWingExt[6] = new ModelRenderer(this, 56, 19);
        this.RightWingExt[6].mirror = true;
        this.RightWingExt[6].addBox(0.0f, 0.0f, 0.2f, 1, 3, 2, f + 0.2f);
        this.RightWingExt[6].setRotationPoint(f21, f22 + f2, f23);
        this.WingRotateAngleX = this.LeftWingExt[0].rotateAngleX;
        this.WingRotateAngleY = this.LeftWingExt[0].rotateAngleY;
        this.WingRotateAngleZ = this.LeftWingExt[0].rotateAngleZ;
    }

    public void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        int n;
        float f15;
        float f16;
        int n2;
        float f17;
        int n3;
        float f18;
        float f19;
        float f20;
        float f21;
        int n4;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        this.rainboom = false;
        if (this.isSleeping) {
            f27 = 1.4f;
            f26 = 0.1f;
        } else {
            f27 = f4 / 57.29578f;
            f26 = f5 / 57.29578f;
        }
        this.Head.rotateAngleY = f27;
        this.Head.rotateAngleX = f26;
        this.Headpiece[0].rotateAngleY = f27;
        this.Headpiece[0].rotateAngleX = f26;
        this.Headpiece[1].rotateAngleY = f27;
        this.Headpiece[1].rotateAngleX = f26;
        this.Headpiece[2].rotateAngleY = f27;
        this.Headpiece[2].rotateAngleX = f26;
        this.Helmet.rotateAngleY = f27;
        this.Helmet.rotateAngleX = f26;
        this.Headpiece[2].rotateAngleX = f26 + 0.5f;
        if (this.isFlying && this.isPegasus) {
            if (f2 < 0.9999f) {
                this.rainboom = false;
                f25 = sajh._a(0.0f - f2 * 0.5f);
                f24 = sajh._a(0.0f - f2 * 0.5f);
                f23 = sajh._a(f2 * 0.5f);
                f22 = sajh._a(f2 * 0.5f);
            } else {
                this.rainboom = true;
                f25 = 4.712f;
                f24 = 4.712f;
                f23 = 1.571f;
                f22 = 1.571f;
            }
            this.RightArm.rotateAngleY = 0.2f;
            this.LeftArm.rotateAngleY = -0.2f;
            this.RightLeg.rotateAngleY = -0.2f;
            this.LeftLeg.rotateAngleY = 0.2f;
        } else {
            f25 = sajh._b(f * 0.6662f + 3.141593f) * 0.6f * f2;
            f24 = sajh._b(f * 0.6662f) * 0.6f * f2;
            f23 = sajh._b(f * 0.6662f) * 0.3f * f2;
            f22 = sajh._b(f * 0.6662f + 3.141593f) * 0.3f * f2;
            this.RightArm.rotateAngleY = 0.0f;
            this.unicornarm.rotateAngleY = 0.0f;
            this.LeftArm.rotateAngleY = 0.0f;
            this.RightLeg.rotateAngleY = 0.0f;
            this.LeftLeg.rotateAngleY = 0.0f;
        }
        if (this.isSleeping) {
            f25 = 4.712f;
            f24 = 4.712f;
            f23 = 1.571f;
            f22 = 1.571f;
        }
        this.RightArm.rotateAngleX = f25;
        this.unicornarm.rotateAngleX = 0.0f;
        this.LeftArm.rotateAngleX = f24;
        this.RightLeg.rotateAngleX = f23;
        this.LeftLeg.rotateAngleX = f22;
        this.RightArm.rotateAngleZ = 0.0f;
        this.unicornarm.rotateAngleZ = 0.0f;
        this.LeftArm.rotateAngleZ = 0.0f;
        for (int i = 0; i < this.Tail.length; ++i) {
            this.Tail[i].rotateAngleZ = this.rainboom ? 0.0f : sajh._b(f * 0.8f) * 0.2f * f2;
        }
        if (this.heldItemRight != 0 && !this.rainboom && !this.isUnicorn) {
            this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5f - 0.3141593f;
        }
        float f28 = 0.0f;
        if (f6 > -9990.0f && !this.isUnicorn) {
            f28 = sajh._a(sajh._c(f6) * 3.141593f * 2.0f) * 0.2f;
        }
        this.Body.rotateAngleY = (float)((double)f28 * 0.2);
        for (n4 = 0; n4 < this.Bodypiece.length; ++n4) {
            this.Bodypiece[n4].rotateAngleY = (float)((double)f28 * 0.2);
        }
        for (n4 = 0; n4 < this.LeftWing.length; ++n4) {
            this.LeftWing[n4].rotateAngleY = (float)((double)f28 * 0.2);
        }
        for (n4 = 0; n4 < this.RightWing.length; ++n4) {
            this.RightWing[n4].rotateAngleY = (float)((double)f28 * 0.2);
        }
        for (n4 = 0; n4 < this.Tail.length; ++n4) {
            this.Tail[n4].rotateAngleY = f28;
        }
        float f29 = sajh._a(this.Body.rotateAngleY) * 5.0f;
        float f30 = sajh._b(this.Body.rotateAngleY) * 5.0f;
        float f31 = 4.0f;
        if (this.isSneak && !this.isFlying) {
            f31 = 0.0f;
        }
        if (this.isSleeping) {
            f31 = 2.6f;
        }
        if (this.rainboom) {
            this.RightArm.rotationPointZ = f29 + 2.0f;
            this.LeftArm.rotationPointZ = 0.0f - f29 + 2.0f;
        } else {
            this.RightArm.rotationPointZ = f29 + 1.0f;
            this.LeftArm.rotationPointZ = 0.0f - f29 + 1.0f;
        }
        this.RightArm.rotationPointX = 0.0f - f30 - 1.0f + f31;
        this.LeftArm.rotationPointX = f30 + 1.0f - f31;
        this.RightLeg.rotationPointX = 0.0f - f30 - 1.0f + f31;
        this.LeftLeg.rotationPointX = f30 + 1.0f - f31;
        this.RightArm.rotateAngleY += this.Body.rotateAngleY;
        this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
        this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
        this.RightArm.rotationPointY = 8.0f;
        this.LeftArm.rotationPointY = 8.0f;
        this.RightLeg.rotationPointY = 4.0f;
        this.LeftLeg.rotationPointY = 4.0f;
        if (f6 > -9990.0f) {
            f21 = 1.0f - f6;
            f21 *= f21 * f21;
            f21 = 1.0f - f21;
            f20 = sajh._a(f21 * 3.141593f);
            f19 = sajh._a(f6 * 3.141593f);
            f18 = f19 * -(this.Head.rotateAngleX - 0.7f) * 0.75f;
            if (this.isUnicorn) {
                this.unicornarm.rotateAngleX = (float)((double)this.unicornarm.rotateAngleX - ((double)f20 * 1.2 + (double)f18));
                this.unicornarm.rotateAngleY += this.Body.rotateAngleY * 2.0f;
                this.unicornarm.rotateAngleZ = f19 * -0.4f;
            } else {
                this.unicornarm.rotateAngleX = (float)((double)this.unicornarm.rotateAngleX - ((double)f20 * 1.2 + (double)f18));
                this.unicornarm.rotateAngleY += this.Body.rotateAngleY * 2.0f;
                this.unicornarm.rotateAngleZ = f19 * -0.4f;
            }
        }
        if (this.isSneak && !this.isFlying) {
            f21 = 0.4f;
            f20 = 7.0f;
            f19 = -4.0f;
            this.Body.rotateAngleX = f21;
            this.Body.rotationPointY = f20;
            this.Body.rotationPointZ = f19;
            for (n3 = 0; n3 < this.Bodypiece.length; ++n3) {
                this.Bodypiece[n3].rotateAngleX = f21;
                this.Bodypiece[n3].rotationPointY = f20;
                this.Bodypiece[n3].rotationPointZ = f19;
            }
            f18 = 3.5f;
            f17 = 6.0f;
            for (n2 = 0; n2 < this.LeftWingExt.length; ++n2) {
                this.LeftWingExt[n2].rotateAngleX = (float)((double)f21 + 2.3561947345733643);
                this.LeftWingExt[n2].rotationPointY = f20 + f18;
                this.LeftWingExt[n2].rotationPointZ = f19 + f17;
                this.LeftWingExt[n2].rotateAngleX = 2.5f;
                this.LeftWingExt[n2].rotateAngleZ = -6.0f;
            }
            f16 = 4.5f;
            f15 = 6.0f;
            for (n = 0; n < this.LeftWingExt.length; ++n) {
                this.RightWingExt[n].rotateAngleX = (float)((double)f21 + 2.3561947345733643);
                this.RightWingExt[n].rotationPointY = f20 + f16;
                this.RightWingExt[n].rotationPointZ = f19 + f15;
                this.RightWingExt[n].rotateAngleX = 2.5f;
                this.RightWingExt[n].rotateAngleZ = 6.0f;
            }
            this.RightLeg.rotateAngleX -= 0.0f;
            this.LeftLeg.rotateAngleX -= 0.0f;
            this.RightArm.rotateAngleX -= 0.4f;
            this.unicornarm.rotateAngleX += 0.4f;
            this.LeftArm.rotateAngleX -= 0.4f;
            this.RightLeg.rotationPointZ = 10.0f;
            this.LeftLeg.rotationPointZ = 10.0f;
            this.RightLeg.rotationPointY = 7.0f;
            this.LeftLeg.rotationPointY = 7.0f;
            if (this.isSleeping) {
                f14 = 2.0f;
                f13 = -1.0f;
                f12 = 1.0f;
            } else {
                f14 = 6.0f;
                f13 = -2.0f;
                f12 = 0.0f;
            }
            this.Head.rotationPointY = f14;
            this.Head.rotationPointZ = f13;
            this.Head.rotationPointX = f12;
            this.Helmet.rotationPointY = f14;
            this.Helmet.rotationPointZ = f13;
            this.Helmet.rotationPointX = f12;
            this.Headpiece[0].rotationPointY = f14;
            this.Headpiece[0].rotationPointZ = f13;
            this.Headpiece[0].rotationPointX = f12;
            this.Headpiece[1].rotationPointY = f14;
            this.Headpiece[1].rotationPointZ = f13;
            this.Headpiece[1].rotationPointX = f12;
            this.Headpiece[2].rotationPointY = f14;
            this.Headpiece[2].rotationPointZ = f13;
            this.Headpiece[2].rotationPointX = f12;
            f11 = 0.0f;
            f10 = 8.0f;
            f9 = -14.0f;
            f8 = 0.0f - f11;
            f7 = 9.0f - f10;
            float f32 = -4.0f - f9;
            float f33 = 0.0f;
            for (int i = 0; i < this.Tail.length; ++i) {
                this.Tail[i].rotationPointX = f8;
                this.Tail[i].rotationPointY = f7;
                this.Tail[i].rotationPointZ = f32;
                this.Tail[i].rotateAngleX = f33;
            }
        } else {
            int n5;
            f21 = 0.0f;
            f20 = 0.0f;
            f19 = 0.0f;
            this.Body.rotateAngleX = f21;
            this.Body.rotationPointY = f20;
            this.Body.rotationPointZ = f19;
            for (n3 = 0; n3 < this.Bodypiece.length; ++n3) {
                this.Bodypiece[n3].rotateAngleX = f21;
                this.Bodypiece[n3].rotationPointY = f20;
                this.Bodypiece[n3].rotationPointZ = f19;
            }
            if (this.isPegasus) {
                if (!this.isFlying) {
                    for (n3 = 0; n3 < this.LeftWing.length; ++n3) {
                        this.LeftWing[n3].rotateAngleX = (float)((double)f21 + 1.5707964897155762);
                        this.LeftWing[n3].rotationPointY = f20 + 13.0f;
                        this.LeftWing[n3].rotationPointZ = f19 - 3.0f;
                    }
                    for (n3 = 0; n3 < this.RightWing.length; ++n3) {
                        this.RightWing[n3].rotateAngleX = (float)((double)f21 + 1.5707964897155762);
                        this.RightWing[n3].rotationPointY = f20 + 13.0f;
                        this.RightWing[n3].rotationPointZ = f19 - 3.0f;
                    }
                } else {
                    f18 = 5.5f;
                    f17 = 3.0f;
                    for (n2 = 0; n2 < this.LeftWingExt.length; ++n2) {
                        this.LeftWingExt[n2].rotateAngleX = (float)((double)f21 + 1.5707964897155762);
                        this.LeftWingExt[n2].rotationPointY = f20 + f18;
                        this.LeftWingExt[n2].rotationPointZ = f19 + f17;
                    }
                    f16 = 6.5f;
                    f15 = 3.0f;
                    for (n = 0; n < this.RightWingExt.length; ++n) {
                        this.RightWingExt[n].rotateAngleX = (float)((double)f21 + 1.5707964897155762);
                        this.RightWingExt[n].rotationPointY = f20 + f16;
                        this.RightWingExt[n].rotationPointZ = f19 + f15;
                    }
                }
            }
            this.RightLeg.rotationPointZ = 10.0f;
            this.LeftLeg.rotationPointZ = 10.0f;
            this.RightLeg.rotationPointY = 8.0f;
            this.LeftLeg.rotationPointY = 8.0f;
            f18 = sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
            f17 = sajh._a(f3 * 0.067f) * 0.05f;
            this.unicornarm.rotateAngleZ += f18;
            this.unicornarm.rotateAngleX += f17;
            if (this.isPegasus && this.isFlying) {
                this.WingRotateAngleY = sajh._a(f3 * 0.067f * 8.0f) * 1.0f;
                this.WingRotateAngleZ = sajh._a(f3 * 0.067f * 8.0f) * 1.0f;
                for (n2 = 0; n2 < this.LeftWingExt.length; ++n2) {
                    this.LeftWingExt[n2].rotateAngleX = 2.5f;
                    this.LeftWingExt[n2].rotateAngleZ = -this.WingRotateAngleZ - 4.712f - 0.4f;
                }
                for (n2 = 0; n2 < this.RightWingExt.length; ++n2) {
                    this.RightWingExt[n2].rotateAngleX = 2.5f;
                    this.RightWingExt[n2].rotateAngleZ = this.WingRotateAngleZ + 4.712f + 0.4f;
                }
            }
            if (this.isSleeping) {
                f16 = 2.0f;
                f15 = 1.0f;
                f14 = 1.0f;
            } else {
                f16 = 0.0f;
                f15 = 0.0f;
                f14 = 0.0f;
            }
            this.Head.rotationPointY = f16;
            this.Head.rotationPointZ = f15;
            this.Head.rotationPointX = f14;
            this.Helmet.rotationPointY = f16;
            this.Helmet.rotationPointZ = f15;
            this.Helmet.rotationPointX = f14;
            this.Headpiece[0].rotationPointY = f16;
            this.Headpiece[0].rotationPointZ = f15;
            this.Headpiece[0].rotationPointX = f14;
            this.Headpiece[1].rotationPointY = f16;
            this.Headpiece[1].rotationPointZ = f15;
            this.Headpiece[1].rotationPointX = f14;
            this.Headpiece[2].rotationPointY = f16;
            this.Headpiece[2].rotationPointZ = f15;
            this.Headpiece[2].rotationPointX = f14;
            f13 = 0.0f;
            f12 = 8.0f;
            f11 = -14.0f;
            f10 = 0.0f - f13;
            f9 = 9.0f - f12;
            f8 = 0.0f - f11;
            f7 = 0.5f * f2;
            for (n5 = 0; n5 < this.Tail.length; ++n5) {
                this.Tail[n5].rotationPointX = f10;
                this.Tail[n5].rotationPointY = f9;
                this.Tail[n5].rotationPointZ = f8;
                this.Tail[n5].rotateAngleX = this.rainboom ? 1.571f + 0.1f * sajh._a(f) : f7;
            }
            for (n5 = 0; n5 < this.Tail.length; ++n5) {
                if (this.rainboom) continue;
                this.Tail[n5].rotateAngleX += f17;
            }
        }
        this.LeftWingExt[2].rotateAngleX -= 0.85f;
        this.LeftWingExt[3].rotateAngleX -= 0.75f;
        this.LeftWingExt[4].rotateAngleX -= 0.5f;
        this.LeftWingExt[6].rotateAngleX -= 0.85f;
        this.RightWingExt[2].rotateAngleX -= 0.85f;
        this.RightWingExt[3].rotateAngleX -= 0.75f;
        this.RightWingExt[4].rotateAngleX -= 0.5f;
        this.RightWingExt[6].rotateAngleX -= 0.85f;
        this.Bodypiece[9].rotateAngleX += 0.5f;
        this.Bodypiece[10].rotateAngleX += 0.5f;
        this.Bodypiece[11].rotateAngleX += 0.5f;
        this.Bodypiece[12].rotateAngleX += 0.5f;
        if (this.rainboom) {
            for (int i = 0; i < this.Tail.length; ++i) {
                this.Tail[i].rotationPointY += 6.0f;
                this.Tail[i].rotationPointZ += 1.0f;
            }
        }
        if (this.isSleeping) {
            this.RightArm.rotationPointZ += 6.0f;
            this.LeftArm.rotationPointZ += 6.0f;
            this.RightLeg.rotationPointZ -= 8.0f;
            this.LeftLeg.rotationPointZ -= 8.0f;
            this.RightArm.rotationPointY += 2.0f;
            this.LeftArm.rotationPointY += 2.0f;
            this.RightLeg.rotationPointY += 2.0f;
            this.LeftLeg.rotationPointY += 2.0f;
        }
        if (this.aimedBow) {
            if (this.isUnicorn) {
                f21 = 0.0f;
                f20 = 0.0f;
                this.unicornarm.rotateAngleZ = 0.0f;
                this.unicornarm.rotateAngleY = -(0.1f - f21 * 0.6f) + this.Head.rotateAngleY;
                this.unicornarm.rotateAngleX = 4.712f + this.Head.rotateAngleX;
                this.unicornarm.rotateAngleX -= f21 * 1.2f - f20 * 0.4f;
                this.unicornarm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
                this.unicornarm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
            } else {
                f21 = 0.0f;
                f20 = 0.0f;
                this.RightArm.rotateAngleZ = 0.0f;
                this.RightArm.rotateAngleY = -(0.1f - f21 * 0.6f) + this.Head.rotateAngleY;
                this.RightArm.rotateAngleX = 4.712f + this.Head.rotateAngleX;
                this.RightArm.rotateAngleX -= f21 * 1.2f - f20 * 0.4f;
                this.RightArm.rotateAngleZ += sajh._b(f3 * 0.09f) * 0.05f + 0.05f;
                this.RightArm.rotateAngleX += sajh._a(f3 * 0.067f) * 0.05f;
                this.RightArm.rotationPointZ += 1.0f;
            }
        }
    }

    @Override
    public void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        this.setRotationAngles(f, f2, f3, f4, f5, f6);
        GL11.glPushMatrix();
        if (this.isSleeping) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.5f, -0.9f);
        }
        float f7 = f6;
        this.Head.render(f6);
        this.Headpiece[0].render(f6);
        this.Headpiece[1].render(f6);
        if (this.isUnicorn) {
            this.Headpiece[2].render(f6);
        }
        this.Helmet.render(f6);
        this.Body.render(f6);
        for (n = 0; n < this.Bodypiece.length; ++n) {
            this.Bodypiece[n].render(f7);
        }
        this.LeftArm.render(f7);
        this.RightArm.render(f7);
        this.LeftLeg.render(f7);
        this.RightLeg.render(f7);
        for (n = 0; n < this.Tail.length; ++n) {
            this.Tail[n].render(f7);
        }
        if (this.isPegasus) {
            if (!this.isFlying && !this.isSneak) {
                for (n = 0; n < this.LeftWing.length; ++n) {
                    this.LeftWing[n].render(f7);
                }
                for (n = 0; n < this.RightWing.length; ++n) {
                    this.RightWing[n].render(f7);
                }
            } else {
                for (n = 0; n < this.LeftWingExt.length; ++n) {
                    this.LeftWingExt[n].render(f7);
                }
                for (n = 0; n < this.RightWingExt.length; ++n) {
                    this.RightWingExt[n].render(f7);
                }
            }
        }
        GL11.glPopMatrix();
    }

    protected void renderGlow(RenderManager renderManager, EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null) {
            GL11.glPushMatrix();
            double d = entityPlayer.posX;
            double d2 = entityPlayer.posY;
            double d3 = entityPlayer.posZ;
            GL11.glEnable(32826);
            GL11.glTranslatef((float)d + 0.0f, (float)d2 + 2.3f, (float)d3);
            GL11.glScalef(5.0f, 5.0f, 5.0f);
            GL11.glRotatef(-renderManager._l, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(renderManager._m, 1.0f, 0.0f, 0.0f);
            Tessellator tessellator = Tessellator.instance;
            float f = 0.0f;
            float f2 = 0.25f;
            float f3 = 0.0f;
            float f4 = 0.25f;
            float f5 = 1.0f;
            float f6 = 0.5f;
            float f7 = 0.25f;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            tessellator.addVertexWithUV(-1.0, -1.0, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(-1.0, 1.0, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(1.0, 1.0, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(1.0, -1.0, 0.0, 0.0, 0.0);
            tessellator.draw();
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }
}

