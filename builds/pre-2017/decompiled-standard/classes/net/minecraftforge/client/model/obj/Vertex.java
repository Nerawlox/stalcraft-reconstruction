/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class Vertex {
    public float x;
    public float y;
    public float z;

    public Vertex(float f, float f2) {
        this(f, f2, 0.0f);
    }

    public Vertex(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }
}

