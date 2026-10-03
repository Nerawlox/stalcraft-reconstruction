/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  beu
 *  bim
 */
package ru.stalcraft.client.models;

public class ModelHand
extends bbo {
    public bcu RightArm = new bcu(this, 40, 16);
    public bcu LeftArm;

    public ModelHand() {
        this.RightArm.a(0.0f, 0.0f, 0.0f, 4, 12, 4);
        this.LeftArm = new bcu(this, 40, 16);
        this.LeftArm.i = true;
        this.LeftArm.a(0.0f, 0.0f, 0.0f, 4, 12, 4);
    }

    public void render(beu p2, int f2) {
        bim renderengine = atv.w().N;
        renderengine.a(p2.r());
        super.a((nn)null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        if ((float)f2 == 2.0f) {
            this.RightArm.a(0.0625f);
        }
        if ((float)f2 == 1.0f) {
            this.LeftArm.a(0.0625f);
        }
    }

    private void setRotation(bcu model, float x2, float y2, float z2) {
        model.f = x2;
        model.g = y2;
        model.h = z2;
    }

    public void a(float f2, float f1, float f22, float f3, float f4, float f5, nn e2) {
        super.a(f2, f1, f22, f3, f4, f5, e2);
    }
}

