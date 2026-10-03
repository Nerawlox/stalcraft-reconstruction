/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourBlock;
import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.CompressorColourFit;
import gr.zdimensions.jsquish.Matrix;
import gr.zdimensions.jsquish.Squish;
import gr.zdimensions.jsquish.Vec;

final class CompressorCluster
extends CompressorColourFit {
    private static final int MAX_ITERATIONS = 8;
    private static final float TWO_THIRDS = 0.6666667f;
    private static final float ONE_THIRD = 0.33333334f;
    private static final float HALF = 0.5f;
    private static final float ZERO = 0.0f;
    private static Vec principle;
    private static final float[] dps;
    private static final float[] weighted;
    private static final float[] weights;
    private static Squish.CompressionMetric metric;
    private static final int[] indices;
    private static final int[] bestIndices;
    private static final float[] alpha;
    private static final float[] beta;
    private static final int[] unordered;
    private static final Vec xxSum;
    private static float bestError;
    private static final int[] orders;

    static {
        dps = new float[16];
        weighted = new float[48];
        weights = new float[16];
        indices = new int[16];
        bestIndices = new int[16];
        alpha = new float[16];
        beta = new float[16];
        unordered = new int[16];
        xxSum = new Vec();
        orders = new int[128];
    }

    CompressorCluster(ColourSet colours, Squish.CompressionType type2, Squish.CompressionMetric metric) {
        super(colours, type2);
        bestError = Float.MAX_VALUE;
        CompressorCluster.metric = metric;
        Matrix covariance = Matrix.computeWeightedCovariance(colours, CompressorColourFit.covariance);
        principle = Matrix.computePrincipleComponent(covariance);
    }

    void compress3(byte[] block, int offset) {
        int count = this.colours.getCount();
        Vec bestStart = new Vec(0.0f);
        Vec bestEnd = new Vec(0.0f);
        float bestError = CompressorCluster.bestError;
        Vec a = new Vec();
        Vec b = new Vec();
        this.constructOrdering(principle, 0);
        int[] indices = CompressorCluster.indices;
        int[] bestIndices = CompressorCluster.bestIndices;
        float[] alpha = CompressorCluster.alpha;
        float[] beta = CompressorCluster.beta;
        float[] weights = CompressorCluster.weights;
        int bestIteration = 0;
        int iteration = 0;
        do {
            int m = 0;
            while (m < count) {
                indices[m] = 0;
                alpha[m] = weights[m];
                beta[m] = 0.0f;
                ++m;
            }
            int i = count;
            while (i >= 0) {
                int m2 = i;
                while (m2 < count) {
                    indices[m2] = 2;
                    alpha[m2] = beta[m2] = 0.5f * weights[m2];
                    ++m2;
                }
                int j = count;
                while (j >= i) {
                    float error;
                    if (j < count) {
                        indices[j] = 1;
                        alpha[j] = 0.0f;
                        beta[j] = weights[j];
                    }
                    if ((error = this.solveLeastSquares(a, b)) < bestError) {
                        bestStart.set(a);
                        bestEnd.set(b);
                        System.arraycopy(indices, 0, bestIndices, 0, 16);
                        bestError = error;
                        bestIteration = iteration;
                    }
                    --j;
                }
                --i;
            }
        } while (bestIteration == iteration && ++iteration != 8 && this.constructOrdering(a.set(bestEnd).sub(bestStart), iteration));
        if (bestError < CompressorCluster.bestError) {
            int[] orders = CompressorCluster.orders;
            int[] unordered = CompressorCluster.unordered;
            int order = 16 * bestIteration;
            int i = 0;
            while (i < count) {
                unordered[orders[order + i]] = bestIndices[i];
                ++i;
            }
            this.colours.remapIndices(unordered, bestIndices);
            ColourBlock.writeColourBlock3(bestStart, bestEnd, bestIndices, block, offset);
            CompressorCluster.bestError = bestError;
        }
    }

    void compress4(byte[] block, int offset) {
        int count = this.colours.getCount();
        Vec bestStart = new Vec(0.0f);
        Vec bestEnd = new Vec(0.0f);
        float bestError = CompressorCluster.bestError;
        Vec start = new Vec();
        Vec end = new Vec();
        this.constructOrdering(principle, 0);
        int[] indices = CompressorCluster.indices;
        int[] bestIndices = CompressorCluster.bestIndices;
        float[] alpha = CompressorCluster.alpha;
        float[] beta = CompressorCluster.beta;
        float[] weights = CompressorCluster.weights;
        int bestIteration = 0;
        int iteration = 0;
        do {
            int m = 0;
            while (m < count) {
                indices[m] = 0;
                alpha[m] = weights[m];
                beta[m] = 0.0f;
                ++m;
            }
            int i = count;
            while (i >= 0) {
                int m2 = i;
                while (m2 < count) {
                    indices[m2] = 2;
                    alpha[m2] = 0.6666667f * weights[m2];
                    beta[m2] = 0.33333334f * weights[m2];
                    ++m2;
                }
                int j = count;
                while (j >= i) {
                    int m3 = j;
                    while (m3 < count) {
                        indices[m3] = 3;
                        alpha[m3] = 0.33333334f * weights[m3];
                        beta[m3] = 0.6666667f * weights[m3];
                        ++m3;
                    }
                    int k = count;
                    while (k >= j) {
                        float error;
                        if (k < count) {
                            indices[k] = 1;
                            alpha[k] = 0.0f;
                            beta[k] = weights[k];
                        }
                        if ((error = this.solveLeastSquares(start, end)) < bestError) {
                            bestStart.set(start);
                            bestEnd.set(end);
                            System.arraycopy(indices, 0, bestIndices, 0, 16);
                            bestError = error;
                            bestIteration = iteration;
                        }
                        --k;
                    }
                    --j;
                }
                --i;
            }
        } while (bestIteration == iteration && ++iteration != 8 && this.constructOrdering(start.set(bestEnd).sub(bestStart), iteration));
        if (bestError < CompressorCluster.bestError) {
            int[] orders = CompressorCluster.orders;
            int[] unordered = CompressorCluster.unordered;
            int order = 16 * bestIteration;
            int i = 0;
            while (i < count) {
                unordered[orders[order + i]] = bestIndices[i];
                ++i;
            }
            this.colours.remapIndices(unordered, bestIndices);
            ColourBlock.writeColourBlock4(bestStart, bestEnd, bestIndices, block, offset);
            CompressorCluster.bestError = bestError;
        }
    }

    private boolean constructOrdering(Vec axis, int iteration) {
        int i;
        int count = this.colours.getCount();
        Vec[] values2 = this.colours.getPoints();
        int[] orders = CompressorCluster.orders;
        float[] dps = CompressorCluster.dps;
        int order = 16 * iteration;
        int i2 = 0;
        while (i2 < count) {
            dps[i2] = values2[i2].dot(axis);
            orders[order + i2] = i2;
            ++i2;
        }
        i2 = 0;
        while (i2 < count) {
            int j = i2;
            while (j > 0 && dps[j] < dps[j - 1]) {
                float tmpF = dps[j];
                dps[j] = dps[j - 1];
                dps[j - 1] = tmpF;
                int tmpI = orders[order + j];
                orders[order + j] = orders[order + j - 1];
                orders[order + j - 1] = tmpI;
                --j;
            }
            ++i2;
        }
        int it = 0;
        while (it < iteration) {
            int prev = 16 * it;
            boolean same = true;
            i = 0;
            while (i < count) {
                if (orders[order + i] != orders[prev + i]) {
                    same = false;
                    break;
                }
                ++i;
            }
            if (same) {
                return false;
            }
            ++it;
        }
        Vec[] points = this.colours.getPoints();
        float[] cWeights = this.colours.getWeights();
        xxSum.set(0.0f);
        float[] weighted = CompressorCluster.weighted;
        i = 0;
        int j = 0;
        while (i < count) {
            int p = orders[order + i];
            float weight = cWeights[p];
            Vec point = points[p];
            CompressorCluster.weights[i] = weight;
            float wX = weight * point.x();
            float wY = weight * point.y();
            float wZ = weight * point.z();
            xxSum.add(wX * wX, wY * wY, wZ * wZ);
            weighted[j + 0] = wX;
            weighted[j + 1] = wY;
            weighted[j + 2] = wZ;
            ++i;
            j += 3;
        }
        return true;
    }

    private float solveLeastSquares(Vec start, Vec end) {
        float bX;
        float bY;
        float bZ;
        float aZ;
        float aY;
        float aX;
        float rcp;
        int count = this.colours.getCount();
        float alpha2_sum = 0.0f;
        float beta2_sum = 0.0f;
        float alphabeta_sum = 0.0f;
        float alphax_sumX = 0.0f;
        float alphax_sumY = 0.0f;
        float alphax_sumZ = 0.0f;
        float betax_sumX = 0.0f;
        float betax_sumY = 0.0f;
        float betax_sumZ = 0.0f;
        float[] alpha = CompressorCluster.alpha;
        float[] beta = CompressorCluster.beta;
        float[] weighted = CompressorCluster.weighted;
        int i = 0;
        int j = 0;
        while (i < count) {
            float a = alpha[i];
            float b = beta[i];
            alpha2_sum += a * a;
            beta2_sum += b * b;
            alphabeta_sum += a * b;
            alphax_sumX += weighted[j + 0] * a;
            alphax_sumY += weighted[j + 1] * a;
            alphax_sumZ += weighted[j + 2] * a;
            betax_sumX += weighted[j + 0] * b;
            betax_sumY += weighted[j + 1] * b;
            betax_sumZ += weighted[j + 2] * b;
            ++i;
            j += 3;
        }
        if (beta2_sum == 0.0f) {
            rcp = 1.0f / alpha2_sum;
            aX = alphax_sumX * rcp;
            aY = alphax_sumY * rcp;
            aZ = alphax_sumZ * rcp;
            bZ = 0.0f;
            bY = 0.0f;
            bX = 0.0f;
        } else if (alpha2_sum == 0.0f) {
            rcp = 1.0f / beta2_sum;
            aZ = 0.0f;
            aY = 0.0f;
            aX = 0.0f;
            bX = betax_sumX * rcp;
            bY = betax_sumY * rcp;
            bZ = betax_sumZ * rcp;
        } else {
            rcp = 1.0f / (alpha2_sum * beta2_sum - alphabeta_sum * alphabeta_sum);
            if (rcp == Float.POSITIVE_INFINITY) {
                return Float.MAX_VALUE;
            }
            aX = (alphax_sumX * beta2_sum - betax_sumX * alphabeta_sum) * rcp;
            aY = (alphax_sumY * beta2_sum - betax_sumY * alphabeta_sum) * rcp;
            aZ = (alphax_sumZ * beta2_sum - betax_sumZ * alphabeta_sum) * rcp;
            bX = (betax_sumX * alpha2_sum - alphax_sumX * alphabeta_sum) * rcp;
            bY = (betax_sumY * alpha2_sum - alphax_sumY * alphabeta_sum) * rcp;
            bZ = (betax_sumZ * alpha2_sum - alphax_sumZ * alphabeta_sum) * rcp;
        }
        aX = CompressorCluster.clamp(aX, 31.0f, 0.032258064f);
        aY = CompressorCluster.clamp(aY, 63.0f, 0.015873017f);
        aZ = CompressorCluster.clamp(aZ, 31.0f, 0.032258064f);
        start.set(aX, aY, aZ);
        bX = CompressorCluster.clamp(bX, 31.0f, 0.032258064f);
        bY = CompressorCluster.clamp(bY, 63.0f, 0.015873017f);
        bZ = CompressorCluster.clamp(bZ, 31.0f, 0.032258064f);
        end.set(bX, bY, bZ);
        float eX = aX * aX * alpha2_sum + bX * bX * beta2_sum + xxSum.x() + 2.0f * (aX * bX * alphabeta_sum - aX * alphax_sumX - bX * betax_sumX);
        float eY = aY * aY * alpha2_sum + bY * bY * beta2_sum + xxSum.y() + 2.0f * (aY * bY * alphabeta_sum - aY * alphax_sumY - bY * betax_sumY);
        float eZ = aZ * aZ * alpha2_sum + bZ * bZ * beta2_sum + xxSum.z() + 2.0f * (aZ * bZ * alphabeta_sum - aZ * alphax_sumZ - bZ * betax_sumZ);
        return metric.dot(eX, eY, eZ);
    }
}

