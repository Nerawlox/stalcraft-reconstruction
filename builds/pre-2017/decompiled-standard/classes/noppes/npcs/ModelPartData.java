/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

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

    public qoac writeToNBT() {
        qoac qoac2 = new qoac();
        qoac2._a("Type", this.type);
        qoac2._a("Color", this.color);
        if (this.texture != null && !this.texture.isEmpty()) {
            qoac2._a("Texture", this.texture);
        }
        qoac2._a("PlayerTexture", this.playerTexture);
        return qoac2;
    }

    public void readFromNBT(qoac qoac2) {
        this.type = qoac2._d("Type");
        this.color = qoac2._f("Color");
        this.texture = qoac2._j("Texture");
        this.playerTexture = qoac2._o("PlayerTexture");
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

