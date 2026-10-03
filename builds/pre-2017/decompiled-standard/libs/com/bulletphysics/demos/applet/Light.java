/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import javax.vecmath.Vector4f;

public class Light {
    public boolean enabled = false;
    public final Vector4f ambient = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
    public final Vector4f diffuse = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
    public final Vector4f specular = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
    public final Vector4f position = new Vector4f(0.0f, 0.0f, 1.0f, 0.0f);
}

