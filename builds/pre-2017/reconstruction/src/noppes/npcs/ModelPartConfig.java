/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.nbt.NBTTagCompound;

public class ModelPartConfig {
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float scaleZ = 1.0f;
    public float transX = 0.0f;
    public float transY = 0.0f;
    public float transZ = 0.0f;

    public NBTTagCompound writeToNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("ScaleX", this.scaleX);
        nBTTagCompound._a("ScaleY", this.scaleY);
        nBTTagCompound._a("ScaleZ", this.scaleZ);
        nBTTagCompound._a("TransX", this.transX);
        nBTTagCompound._a("TransY", this.transY);
        nBTTagCompound._a("TransZ", this.transZ);
        return nBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.scaleX = nBTTagCompound._h("ScaleX");
        this.scaleY = nBTTagCompound._h("ScaleY");
        this.scaleZ = nBTTagCompound._h("ScaleZ");
        this.transX = nBTTagCompound._h("TransX");
        this.transY = nBTTagCompound._h("TransY");
        this.transZ = nBTTagCompound._h("TransZ");
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

