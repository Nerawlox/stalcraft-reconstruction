/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

final class Vec {
    private float x;
    private float y;
    private float z;

    Vec() {
    }

    Vec(float a) {
        this(a, a, a);
    }

    Vec(Vec v) {
        this(v.x, v.y, v.z);
    }

    Vec(float a, float b, float c) {
        this.x = a;
        this.y = b;
        this.z = c;
    }

    float x() {
        return this.x;
    }

    float y() {
        return this.y;
    }

    float z() {
        return this.z;
    }

    Vec set(float a) {
        this.x = a;
        this.y = a;
        this.z = a;
        return this;
    }

    Vec set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    Vec set(Vec v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    Vec add(Vec v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    Vec add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    Vec sub(Vec v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }

    Vec mul(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
        return this;
    }

    Vec mul(Vec v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
        return this;
    }

    Vec div(float s) {
        float t = 1.0f / s;
        this.x *= t;
        this.y *= t;
        this.z *= t;
        return this;
    }

    float lengthSQ() {
        return this.dot(this);
    }

    float dot(Vec v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }
}

