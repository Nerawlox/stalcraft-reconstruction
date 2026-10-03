/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.CustomNpcs;

public class ModelPartData {
    public int color = 0xFFFFFF;
    public String texture;
    public byte type = 0;
    public boolean playerTexture;
    private Object location;

    public ModelPartData() {
        this.playerTexture = true;
    }

    public ModelPartData(String string) {
        this.texture = string;
        this.playerTexture = false;
    }

    public NBTTagCompound writeToNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("Type", this.type);
        nBTTagCompound._a("Color", this.color);
        if (this.texture != null && !this.texture.isEmpty()) {
            nBTTagCompound._a("Texture", this.texture);
        }
        nBTTagCompound._a("PlayerTexture", this.playerTexture);
        return nBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.type = nBTTagCompound._d("Type");
        this.color = nBTTagCompound._f("Color");
        this.texture = nBTTagCompound._j("Texture");
        this.playerTexture = nBTTagCompound._o("PlayerTexture");
        this.location = null;
    }

    public Object getResource() {
        if (this.location != null) {
            return this.location;
        }
        this.location = CustomNpcs.proxy.loadResource(this.texture);
        return this.location;
    }

    public void setTexture(String string, int n) {
        this.type = (byte)n;
        this.location = null;
        if (string.isEmpty()) {
            this.playerTexture = true;
            this.texture = string;
        } else {
            this.texture = "moreplayermodels:textures/" + string + ".png";
            this.playerTexture = false;
        }
    }

    public String toString() {
        return "Color: " + this.color + " Type: " + this.type;
    }

    public String getColor() {
        String string = Integer.toHexString(this.color);
        while (string.length() < 6) {
            string = "0" + string;
        }
        return string;
    }
}

