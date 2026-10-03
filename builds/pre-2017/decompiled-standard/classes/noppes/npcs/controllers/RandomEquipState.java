/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

public class RandomEquipState {
    public boolean applied = false;
    public String skin;
    public cvzo weapon;
    public cvzo armor;

    public qoac writeToNbt(qoac qoac2) {
        qoac qoac3;
        qoac qoac4 = new qoac();
        qoac4._a("Applied", this.applied);
        if (this.skin != null) {
            qoac4._a("Skin", this.skin);
        }
        if (this.weapon != null) {
            qoac3 = new qoac();
            this.weapon._b(qoac3);
            qoac4._a("Weapon", qoac3);
        }
        if (this.armor != null) {
            qoac3 = new qoac();
            this.armor._b(qoac3);
            qoac4._a("Armor", qoac3);
        }
        qoac2._a("RandomEquipState", (huhy)qoac4);
        return qoac2;
    }

    public void readFromNbt(qoac qoac2) {
        qoac qoac3;
        qoac qoac4 = qoac2._m("RandomEquipState");
        this.applied = qoac4._o("Applied");
        this.skin = qoac4._j("Skin");
        if (qoac4._c("Weapon")) {
            qoac3 = qoac4._m("Weapon");
            this.weapon = cvzo._a(qoac3);
        } else {
            this.weapon = null;
        }
        if (qoac4._c("Armor")) {
            qoac3 = qoac4._m("Armor");
            this.armor = cvzo._a(qoac3);
        } else {
            this.armor = null;
        }
    }
}

