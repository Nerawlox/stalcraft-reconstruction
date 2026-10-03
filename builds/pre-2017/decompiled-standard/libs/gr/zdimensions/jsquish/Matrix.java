/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.Vec;
import java.util.Arrays;

final class Matrix {
    private static final float FLT_EPSILON = 1.0E-5f;
    private static float[] m = new float[6];
    private static float[] u = new float[6];
    private float[] values = new float[6];

    Matrix() {
    }

    Matrix(float a) {
        int i = 0;
        while (i < 6) {
            this.values[i] = a;
            ++i;
        }
    }

    float get(int index) {
        return this.values[index];
    }

    static Matrix computeWeightedCovariance(ColourSet m_colours, Matrix covariance) {
        int count = m_colours.getCount();
        Vec[] points = m_colours.getPoints();
        float[] weights = m_colours.getWeights();
        Vec centroid = new Vec();
        Vec a = new Vec();
        Vec b = new Vec();
        float total = 0.0f;
        int i = 0;
        while (i < count) {
            total += weights[i];
            centroid.add(a.set(points[i]).mul(weights[i]));
            ++i;
        }
        centroid.div(total);
        if (covariance == null) {
            covariance = new Matrix();
        } else {
            Arrays.fill(covariance.values, 0.0f);
        }
        float[] values2 = covariance.values;
        int i2 = 0;
        while (i2 < count) {
            a.set(points[i2]).sub(centroid);
            b.set(a).mul(weights[i2]);
            values2[0] = values2[0] + a.x() * b.x();
            values2[1] = values2[1] + a.x() * b.y();
            values2[2] = values2[2] + a.x() * b.z();
            values2[3] = values2[3] + a.y() * b.y();
            values2[4] = values2[4] + a.y() * b.z();
            values2[5] = values2[5] + a.z() * b.z();
            ++i2;
        }
        return covariance;
    }

    private static Vec getMultiplicity1Evector(Matrix matrix, float evalue) {
        float[] values2 = matrix.values;
        float[] m = Matrix.m;
        m[0] = values2[0] - evalue;
        m[1] = values2[1];
        m[2] = values2[2];
        m[3] = values2[3] - evalue;
        m[4] = values2[4];
        m[5] = values2[5] - evalue;
        float[] u = Matrix.u;
        u[0] = m[3] * m[5] - m[4] * m[4];
        u[1] = m[2] * m[4] - m[1] * m[5];
        u[2] = m[1] * m[4] - m[2] * m[3];
        u[3] = m[0] * m[5] - m[2] * m[2];
        u[4] = m[1] * m[2] - m[4] * m[0];
        u[5] = m[0] * m[3] - m[1] * m[1];
        float mc = Math.abs(u[0]);
        int mi = 0;
        int i = 1;
        while (i < 6) {
            float c = Math.abs(u[i]);
            if (c > mc) {
                mc = c;
                mi = i;
            }
            ++i;
        }
        switch (mi) {
            case 0: {
                return new Vec(u[0], u[1], u[2]);
            }
            case 1: 
            case 3: {
                return new Vec(u[1], u[3], u[4]);
            }
        }
        return new Vec(u[2], u[4], u[5]);
    }

    private static Vec getMultiplicity2Evector(Matrix matrix, float evalue) {
        float[] values2 = matrix.values;
        float[] m = Matrix.m;
        m[0] = values2[0] - evalue;
        m[1] = values2[1];
        m[2] = values2[2];
        m[3] = values2[3] - evalue;
        m[4] = values2[4];
        m[5] = values2[5] - evalue;
        float mc = Math.abs(m[0]);
        int mi = 0;
        int i = 1;
        while (i < 6) {
            float c = Math.abs(m[i]);
            if (c > mc) {
                mc = c;
                mi = i;
            }
            ++i;
        }
        switch (mi) {
            case 0: 
            case 1: {
                return new Vec(-m[1], m[0], 0.0f);
            }
            case 2: {
                return new Vec(m[2], 0.0f, -m[0]);
            }
            case 3: 
            case 4: {
                return new Vec(0.0f, -m[4], m[3]);
            }
        }
        return new Vec(0.0f, -m[5], m[4]);
    }

    static Vec computePrincipleComponent(Matrix matrix) {
        float[] m = matrix.values;
        float c2 = m[0] + m[3] + m[5];
        float c1 = m[0] * m[3] + m[0] * m[5] + m[3] * m[5] - m[1] * m[1] - m[2] * m[2] - m[4] * m[4];
        float c0 = m[0] * m[3] * m[5] + 2.0f * m[1] * m[2] * m[4] - m[0] * m[4] * m[4] - m[3] * m[2] * m[2] - m[5] * m[1] * m[1];
        float b = -0.074074075f * c2 * c2 * c2 + 0.33333334f * c1 * c2 - c0;
        float a = c1 - 0.33333334f * c2 * c2;
        float Q = 0.25f * b * b + 0.037037037f * a * a * a;
        if (1.0E-5f < Q) {
            return new Vec(1.0f);
        }
        if (Q < -1.0E-5f) {
            float theta = (float)Math.atan2(Math.sqrt(-Q), -0.5f * b);
            float rho = (float)Math.sqrt(0.25f * b * b - Q);
            float rt = (float)Math.pow(rho, 0.3333333432674408);
            float ct = (float)Math.cos(theta / 3.0f);
            float st = (float)Math.sin(theta / 3.0f);
            float l1 = 0.33333334f * c2 + 2.0f * rt * ct;
            float l2 = 0.33333334f * c2 - rt * (ct + (float)Math.sqrt(3.0) * st);
            float l3 = 0.33333334f * c2 - rt * (ct - (float)Math.sqrt(3.0) * st);
            if (Math.abs(l2) > Math.abs(l1)) {
                l1 = l2;
            }
            if (Math.abs(l3) > Math.abs(l1)) {
                l1 = l3;
            }
            return Matrix.getMultiplicity1Evector(matrix, l1);
        }
        float rt = b < 0.0f ? (float)(-Math.pow(-0.5f * b, 0.3333333432674408)) : (float)Math.pow(0.5f * b, 0.3333333432674408);
        float l1 = 0.33333334f * c2 + rt;
        float l2 = 0.33333334f * c2 - 2.0f * rt;
        if (Math.abs(l1) > Math.abs(l2)) {
            return Matrix.getMultiplicity2Evector(matrix, l1);
        }
        return Matrix.getMultiplicity1Evector(matrix, l2);
    }
}

