/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.helper;

public class BedDesignHelper {
    public final byte SIDE1 = 0;
    public final byte SIDE2 = 1;
    public final byte END = (byte)2;
    public final byte SIDE4 = (byte)3;
    public final byte SIDE5 = (byte)4;
    public final byte HEAD = (byte)5;
    public final byte FOOT = (byte)6;
    private double offset1 = 0.3333333333333333;
    private double offset2 = 0.6666666666666666;
    private double offset3 = 0.16666666666666666;
    private double offset4 = 0.22916666666666666;
    private double offset5 = 0.7708333333333334;
    private double[][][] designUV = new double[][][]{new double[][]{{this.offset1, this.offset3}, {this.offset1, this.offset1}, {this.offset4, this.offset1}, {this.offset4, this.offset3}}, new double[][]{{this.offset1, this.offset1}, {this.offset1, this.offset2}, {this.offset4, this.offset2}, {this.offset4, this.offset1}}, new double[][]{{this.offset1, this.offset2}, {this.offset2, this.offset2}, {this.offset2, this.offset5}, {this.offset1, this.offset5}}, new double[][]{{this.offset2, this.offset2}, {this.offset2, this.offset1}, {this.offset5, this.offset1}, {this.offset5, this.offset2}}, new double[][]{{this.offset2, this.offset1}, {this.offset2, this.offset3}, {this.offset5, this.offset3}, {this.offset5, this.offset1}}, new double[][]{{this.offset1, this.offset3}, {this.offset2, this.offset3}, {this.offset2, this.offset1}, {this.offset1, this.offset1}}, new double[][]{{this.offset1, this.offset1}, {this.offset2, this.offset1}, {this.offset2, this.offset2}, {this.offset1, this.offset2}}};

    public void renderFaceYPos(htvc htvc2, int n, double d, double d2, double d3) {
        htvc2.__aF.func_78386_a(1.0f, 1.0f, 1.0f);
        double[] dArray = new double[]{this.designUV[n][0][0], this.designUV[n][0][1]};
        double[] dArray2 = new double[]{this.designUV[n][3][0], this.designUV[n][3][1]};
        double[] dArray3 = new double[]{this.designUV[n][2][0], this.designUV[n][2][1]};
        double[] dArray4 = new double[]{this.designUV[n][1][0], this.designUV[n][1][1]};
        double[] dArray5 = dArray;
        double[] dArray6 = dArray2;
        double[] dArray7 = dArray3;
        double[] dArray8 = dArray4;
        switch (htvc2._u) {
            case 1: {
                dArray5 = dArray2;
                dArray6 = dArray3;
                dArray7 = dArray4;
                dArray8 = dArray;
                break;
            }
            case 2: {
                dArray5 = dArray3;
                dArray6 = dArray4;
                dArray7 = dArray;
                dArray8 = dArray2;
                break;
            }
            case 3: {
                dArray5 = dArray4;
                dArray6 = dArray;
                dArray7 = dArray2;
                dArray8 = dArray3;
            }
        }
        double d4 = d + htvc2._h;
        double d5 = d + htvc2._i;
        double d6 = d2 + htvc2._k;
        double d7 = d3 + htvc2._l;
        double d8 = d3 + htvc2._m;
        htvc2.__aE.setupVertex(htvc2, d5, d6, d8, dArray5[0], dArray5[1], 0);
        htvc2.__aE.setupVertex(htvc2, d5, d6, d7, dArray6[0], dArray6[1], 1);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d7, dArray7[0], dArray7[1], 2);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d8, dArray8[0], dArray8[1], 3);
    }

    public void renderFaceZNeg(htvc htvc2, int n, double d, double d2, double d3) {
        htvc2.__aF.func_78386_a(0.8f, 0.8f, 0.8f);
        double d4 = d + htvc2._h;
        double d5 = d + htvc2._i;
        double d6 = d2 + htvc2._j;
        double d7 = d2 + htvc2._k;
        double d8 = d3 + htvc2._l;
        htvc2.__aE.setupVertex(htvc2, d4, d7, d8, this.designUV[n][1][0], this.designUV[n][1][1], 0);
        htvc2.__aE.setupVertex(htvc2, d5, d7, d8, this.designUV[n][0][0], this.designUV[n][0][1], 1);
        htvc2.__aE.setupVertex(htvc2, d5, d6, d8, this.designUV[n][3][0], this.designUV[n][3][1], 2);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d8, this.designUV[n][2][0], this.designUV[n][2][1], 3);
    }

    public void renderFaceZPos(htvc htvc2, int n, double d, double d2, double d3) {
        htvc2.__aF.func_78386_a(0.8f, 0.8f, 0.8f);
        double d4 = d + htvc2._h;
        double d5 = d + htvc2._i;
        double d6 = d2 + htvc2._j;
        double d7 = d2 + htvc2._k;
        double d8 = d3 + htvc2._m;
        htvc2.__aE.setupVertex(htvc2, d4, d7, d8, this.designUV[n][0][0], this.designUV[n][0][1], 0);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d8, this.designUV[n][3][0], this.designUV[n][3][1], 1);
        htvc2.__aE.setupVertex(htvc2, d5, d6, d8, this.designUV[n][2][0], this.designUV[n][2][1], 2);
        htvc2.__aE.setupVertex(htvc2, d5, d7, d8, this.designUV[n][1][0], this.designUV[n][1][1], 3);
    }

    public void renderFaceXNeg(htvc htvc2, int n, double d, double d2, double d3) {
        htvc2.__aF.func_78386_a(0.6f, 0.6f, 0.6f);
        double d4 = d + htvc2._h;
        double d5 = d2 + htvc2._j;
        double d6 = d2 + htvc2._k;
        double d7 = d3 + htvc2._l;
        double d8 = d3 + htvc2._m;
        htvc2.__aE.setupVertex(htvc2, d4, d6, d8, this.designUV[n][1][0], this.designUV[n][1][1], 0);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d7, this.designUV[n][0][0], this.designUV[n][0][1], 1);
        htvc2.__aE.setupVertex(htvc2, d4, d5, d7, this.designUV[n][3][0], this.designUV[n][3][1], 2);
        htvc2.__aE.setupVertex(htvc2, d4, d5, d8, this.designUV[n][2][0], this.designUV[n][2][1], 3);
    }

    public void renderFaceXPos(htvc htvc2, int n, double d, double d2, double d3) {
        htvc2.__aF.func_78386_a(0.6f, 0.6f, 0.6f);
        double d4 = d + htvc2._i;
        double d5 = d2 + htvc2._j;
        double d6 = d2 + htvc2._k;
        double d7 = d3 + htvc2._l;
        double d8 = d3 + htvc2._m;
        htvc2.__aE.setupVertex(htvc2, d4, d5, d8, this.designUV[n][3][0], this.designUV[n][3][1], 0);
        htvc2.__aE.setupVertex(htvc2, d4, d5, d7, this.designUV[n][2][0], this.designUV[n][2][1], 1);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d7, this.designUV[n][1][0], this.designUV[n][1][1], 2);
        htvc2.__aE.setupVertex(htvc2, d4, d6, d8, this.designUV[n][0][0], this.designUV[n][0][1], 3);
    }
}

