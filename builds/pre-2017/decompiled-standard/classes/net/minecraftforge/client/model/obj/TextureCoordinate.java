/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class TextureCoordinate {
    public float u;
    public float v;
    public float w;

    public TextureCoordinate(float f, float f2) {
        this(f, f2, 0.0f);
    }

    public TextureCoordinate(float f, float f2, float f3) {
        this.u = f;
        this.v = f2;
        this.w = f3;
    }
}

