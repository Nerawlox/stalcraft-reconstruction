/*
 * Decompiled with CFR 0.152.
 */
public class dykk {
    public float[][] _a = new float[16][16];
    public float[] _b = new float[16];
    public float[] _c = new float[16];
    public float[] _d = new float[16];

    public boolean _a(double d, double d2, double d3, double d4, double d5, double d6) {
        for (int i = 0; i < 6; ++i) {
            boolean bl;
            boolean bl2;
            float[] fArray;
            float f = (float)d;
            float f2 = (float)d2;
            float f3 = (float)d3;
            float f4 = (float)d4;
            float f5 = (float)d5;
            float f6 = (float)d6;
            boolean bl3 = (fArray = this._a[i])[0] > 0.0f;
            float f7 = fArray[0] * (bl3 ? f4 : f) + fArray[1] * ((bl2 = fArray[1] > 0.0f) ? f5 : f2) + fArray[2] * ((bl = fArray[2] > 0.0f) ? f6 : f3);
            if (!(f7 < -fArray[3])) continue;
            return false;
        }
        return true;
    }

    public boolean _b(double d, double d2, double d3, double d4, double d5, double d6) {
        for (int i = 0; i < 6; ++i) {
            float f = (float)d;
            float f2 = (float)d2;
            float f3 = (float)d3;
            float f4 = (float)d4;
            float f5 = (float)d5;
            float f6 = (float)d6;
            if (!(i < 4 ? this._a[i][0] * f + this._a[i][1] * f2 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f || this._a[i][0] * f4 + this._a[i][1] * f2 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f || this._a[i][0] * f + this._a[i][1] * f5 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f || this._a[i][0] * f4 + this._a[i][1] * f5 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f || this._a[i][0] * f + this._a[i][1] * f2 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f || this._a[i][0] * f4 + this._a[i][1] * f2 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f || this._a[i][0] * f + this._a[i][1] * f5 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f || this._a[i][0] * f4 + this._a[i][1] * f5 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f : this._a[i][0] * f + this._a[i][1] * f2 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f && this._a[i][0] * f4 + this._a[i][1] * f2 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f && this._a[i][0] * f + this._a[i][1] * f5 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f && this._a[i][0] * f4 + this._a[i][1] * f5 + this._a[i][2] * f3 + this._a[i][3] <= 0.0f && this._a[i][0] * f + this._a[i][1] * f2 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f && this._a[i][0] * f4 + this._a[i][1] * f2 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f && this._a[i][0] * f + this._a[i][1] * f5 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f && this._a[i][0] * f4 + this._a[i][1] * f5 + this._a[i][2] * f6 + this._a[i][3] <= 0.0f)) continue;
            return false;
        }
        return true;
    }
}

