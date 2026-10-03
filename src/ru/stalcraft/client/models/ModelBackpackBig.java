/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 */
package ru.stalcraft.client.models;

public class ModelBackpackBig
extends bbo {
    bcu Main_Bag;
    bcu Small_bag_1;
    bcu Small_bag_2;
    bcu Shape1;
    bcu Shape2;
    bcu Shape3;
    bcu Shape4;
    bcu Shape5;
    bcu Shape6;
    bcu Shape9;
    bcu Shape7;
    bcu Shape12;
    bcu Shape10;
    bcu Shape11;
    bcu Shape8;

    public ModelBackpackBig() {
        this.t = 64;
        this.u = 32;
        this.Main_Bag = new bcu(this, 0, 18);
        this.Main_Bag.a(0.0f, 0.0f, 0.0f, 7, 10, 4);
        this.Main_Bag.a(-3.5f, 0.0f, 2.0f);
        this.Main_Bag.b(64, 32);
        this.Main_Bag.i = true;
        this.setRotation(this.Main_Bag, 0.0f, 0.0f, 0.0f);
        this.Small_bag_1 = new bcu(this, 27, 0);
        this.Small_bag_1.a(0.0f, 0.0f, 0.0f, 1, 4, 3);
        this.Small_bag_1.a(3.5f, 5.0f, 2.5f);
        this.Small_bag_1.b(64, 32);
        this.Small_bag_1.i = true;
        this.setRotation(this.Small_bag_1, 0.0f, 0.0f, 0.0f);
        this.Small_bag_2 = new bcu(this, 27, 0);
        this.Small_bag_2.a(0.0f, 0.0f, 0.0f, 1, 4, 3);
        this.Small_bag_2.a(-4.5f, 4.7f, 2.5f);
        this.Small_bag_2.b(64, 32);
        this.Small_bag_2.i = true;
        this.setRotation(this.Small_bag_2, 0.0f, 0.0f, 0.0f);
        this.Shape1 = new bcu(this, 15, 0);
        this.Shape1.a(0.0f, 0.0f, 0.0f, 4, 2, 1);
        this.Shape1.a(-2.0f, 1.5f, 5.8f);
        this.Shape1.b(64, 32);
        this.Shape1.i = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new bcu(this, 15, 3);
        this.Shape2.a(0.0f, 0.0f, 1.0f, 4, 4, 1);
        this.Shape2.a(-2.0f, 4.7f, 5.2f);
        this.Shape2.b(64, 32);
        this.Shape2.i = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new bcu(this, 21, 9);
        this.Shape3.a(0.0f, 0.0f, 0.0f, 6, 8, 1);
        this.Shape3.a(-3.0f, 1.0f, 5.3f);
        this.Shape3.b(64, 32);
        this.Shape3.i = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new bcu(this, 7, 10);
        this.Shape4.a(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape4.a(-2.0f, 0.6f, 5.3f);
        this.Shape4.b(64, 32);
        this.Shape4.i = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new bcu(this, 7, 10);
        this.Shape5.a(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.Shape5.a(-2.0f, 8.5f, 5.3f);
        this.Shape5.b(64, 32);
        this.Shape5.i = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape6 = new bcu(this, 0, 0);
        this.Shape6.a(0.0f, 0.0f, 0.0f, 1, 0, 5);
        this.Shape6.a(2.5f, 0.0f, -3.0f);
        this.Shape6.b(64, 32);
        this.Shape6.i = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        this.Shape9 = new bcu(this, 0, 0);
        this.Shape9.a(0.0f, 0.0f, 0.0f, 1, 0, 5);
        this.Shape9.a(-3.5f, 0.0f, -3.0f);
        this.Shape9.b(64, 32);
        this.Shape9.i = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        this.Shape7 = new bcu(this, 36, 0);
        this.Shape7.a(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.Shape7.a(2.5f, 0.0f, -3.0f);
        this.Shape7.b(64, 32);
        this.Shape7.i = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        this.Shape12 = new bcu(this, 36, 0);
        this.Shape12.a(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.Shape12.a(-3.5f, 0.0f, -3.0f);
        this.Shape12.b(64, 32);
        this.Shape12.i = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        this.Shape10 = new bcu(this, 0, 0);
        this.Shape10.a(0.0f, 0.0f, 0.0f, 1, 0, 5);
        this.Shape10.a(-3.5f, 10.0f, -3.0f);
        this.Shape10.b(64, 32);
        this.Shape10.i = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        this.Shape11 = new bcu(this, 0, 0);
        this.Shape11.a(0.0f, 0.0f, 0.0f, 1, 0, 5);
        this.Shape11.a(2.5f, 10.0f, -3.0f);
        this.Shape11.b(64, 32);
        this.Shape11.i = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        this.Shape8 = new bcu(this, 0, 13);
        this.Shape8.a(0.0f, 0.0f, 0.0f, 4, 1, 4);
        this.Shape8.a(-2.0f, -0.5f, 2.0f);
        this.Shape8.b(64, 32);
        this.Shape8.i = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
    }

    public void a(nn entity, float f2, float f1, float f22, float f3, float f4, float f5) {
        super.a(entity, f2, f1, f22, f3, f4, f5);
        this.a(f2, f1, f22, f3, f4, f5, entity);
        this.Main_Bag.a(f5);
        this.Small_bag_1.a(f5);
        this.Small_bag_2.a(f5);
        this.Shape1.a(f5);
        this.Shape2.a(f5);
        this.Shape3.a(f5);
        this.Shape4.a(f5);
        this.Shape5.a(f5);
        this.Shape6.a(f5);
        this.Shape9.a(f5);
        this.Shape7.a(f5);
        this.Shape12.a(f5);
        this.Shape10.a(f5);
        this.Shape11.a(f5);
        this.Shape8.a(f5);
    }

    private void setRotation(bcu model, float x2, float y2, float z2) {
        model.f = x2;
        model.g = y2;
        model.h = z2;
    }
}

