/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

public class ModelPartConfig {
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float scaleZ = 1.0f;
    public float transX = 0.0f;
    public float transY = 0.0f;
    public float transZ = 0.0f;

    public qoac writeToNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("ScaleX", this.scaleX);
        qoac2._a("ScaleY", this.scaleY);
        qoac2._a("ScaleZ", this.scaleZ);
        qoac2._a("TransX", this.transX);
        qoac2._a("TransY", this.transY);
        qoac2._a("TransZ", this.transZ);
        return qoac2;
    }

    public void readFromNBT(qoac qoac2) {
        this.scaleX = qoac2._h("ScaleX");
        this.scaleY = qoac2._h("ScaleY");
        this.scaleZ = qoac2._h("ScaleZ");
        this.transX = qoac2._h("TransX");
        this.transY = qoac2._h("TransY");
        this.transZ = qoac2._h("TransZ");
    }

    public String toString() {
        return "ScaleX: " + this.scaleX + " - ScaleY: " + this.scaleY + " - ScaleZ: " + this.scaleZ;
    }

    public void setScale(float f, float f2, float f3) {
        this.scaleX = f;
        this.scaleY = f2;
        this.scaleZ = f3;
    }

    public void setScale(float f, float f2) {
        this.scaleZ = this.scaleX = f;
        this.scaleY = f2;
    }
}

