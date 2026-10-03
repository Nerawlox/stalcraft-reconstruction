/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.Dimension;
import java.nio.IntBuffer;
import java.util.ArrayList;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import org.lwjgl.opengl.GL11;

public class Mipmaps {
    private final String iconName;
    private final int width;
    private final int height;
    private final int[] data;
    private final boolean direct;
    private int[][] mipmapDatas;
    private IntBuffer[] mipmapBuffers;
    private Dimension[] mipmapDimensions;

    public Mipmaps(String string, int n, int n2, int[] nArray, boolean bl) {
        this.iconName = string;
        this.width = n;
        this.height = n2;
        this.data = nArray;
        this.direct = bl;
        this.mipmapDimensions = Mipmaps.makeMipmapDimensions(n, n2, string);
        this.mipmapDatas = Mipmaps.generateMipMapData(nArray, n, n2, this.mipmapDimensions);
        if (bl) {
            this.mipmapBuffers = Mipmaps.makeMipmapBuffers(this.mipmapDimensions, this.mipmapDatas);
        }
    }

    public static Dimension[] makeMipmapDimensions(int n, int n2, String string) {
        if (n % 2 == 0 && n2 % 2 == 0) {
            ArrayList<Dimension[]> arrayList = new ArrayList<Dimension[]>();
            int n3 = n;
            int n4 = n2;
            while (true) {
                Dimension[] dimensionArray;
                if ((n3 /= 2) <= 0 && (n4 /= 2) <= 0) {
                    dimensionArray = arrayList.toArray(new Dimension[arrayList.size()]);
                    return dimensionArray;
                }
                if (n3 <= 0) {
                    n3 = 1;
                }
                if (n4 <= 0) {
                    n4 = 1;
                }
                dimensionArray = new Dimension(n3, n4);
                arrayList.add(dimensionArray);
            }
        }
        Config.warn("Mipmaps not possible (mod of 2 dimensions needed), texture: " + string + ", dim: " + n + "x" + n2);
        return new Dimension[0];
    }

    public static int[][] generateMipMapData(int[] nArray, int n, int n2, Dimension[] dimensionArray) {
        int[] nArray2 = nArray;
        int n3 = n;
        boolean bl = true;
        int[][] nArrayArray = new int[dimensionArray.length][];
        for (int i = 0; i < dimensionArray.length; ++i) {
            Dimension dimension = dimensionArray[i];
            int n4 = dimension.width;
            int n5 = dimension.height;
            int[] nArray3 = new int[n4 * n5];
            nArrayArray[i] = nArray3;
            int n6 = i + 1;
            if (bl) {
                for (int j = 0; j < n4; ++j) {
                    for (int k = 0; k < n5; ++k) {
                        int n7;
                        int n8 = nArray2[j * 2 + 0 + (k * 2 + 0) * n3];
                        int n9 = nArray2[j * 2 + 1 + (k * 2 + 0) * n3];
                        int n10 = nArray2[j * 2 + 1 + (k * 2 + 1) * n3];
                        int n11 = nArray2[j * 2 + 0 + (k * 2 + 1) * n3];
                        nArray3[j + k * n4] = n7 = Mipmaps.alphaBlend(n8, n9, n10, n11);
                    }
                }
            }
            nArray2 = nArray3;
            n3 = n4;
            if (n4 > 1 && n5 > 1) continue;
            bl = false;
        }
        return nArrayArray;
    }

    private static int alphaBlend(int n, int n2, int n3, int n4) {
        int n5 = Mipmaps.alphaBlend(n, n2);
        int n6 = Mipmaps.alphaBlend(n3, n4);
        int n7 = Mipmaps.alphaBlend(n5, n6);
        return n7;
    }

    private static int alphaBlend(int n, int n2) {
        int n3 = (n & 0xFF000000) >> 24 & 0xFF;
        int n4 = (n2 & 0xFF000000) >> 24 & 0xFF;
        int n5 = (n3 + n4) / 2;
        if (n3 == 0 && n4 == 0) {
            n3 = 1;
            n4 = 1;
        } else {
            if (n3 == 0) {
                n = n2;
                n5 /= 2;
            }
            if (n4 == 0) {
                n2 = n;
                n5 /= 2;
            }
        }
        int n6 = (n >> 16 & 0xFF) * n3;
        int n7 = (n >> 8 & 0xFF) * n3;
        int n8 = (n & 0xFF) * n3;
        int n9 = (n2 >> 16 & 0xFF) * n4;
        int n10 = (n2 >> 8 & 0xFF) * n4;
        int n11 = (n2 & 0xFF) * n4;
        int n12 = (n6 + n9) / (n3 + n4);
        int n13 = (n7 + n10) / (n3 + n4);
        int n14 = (n8 + n11) / (n3 + n4);
        return n5 << 24 | n12 << 16 | n13 << 8 | n14;
    }

    private int averageColor(int n, int n2) {
        int n3 = (n & 0xFF000000) >> 24 & 0xFF;
        int n4 = (n2 & 0xFF000000) >> 24 & 0xFF;
        return (n3 + n4 >> 1 << 24) + ((n & 0xFEFEFE) + (n2 & 0xFEFEFE) >> 1);
    }

    public static IntBuffer[] makeMipmapBuffers(Dimension[] dimensionArray, int[][] nArray) {
        if (dimensionArray == null) {
            return null;
        }
        IntBuffer[] intBufferArray = new IntBuffer[dimensionArray.length];
        for (int i = 0; i < dimensionArray.length; ++i) {
            Dimension dimension = dimensionArray[i];
            int n = dimension.width * dimension.height;
            IntBuffer intBuffer = pklh._d(n);
            int[] nArray2 = nArray[i];
            intBuffer.clear();
            intBuffer.put(nArray2);
            intBuffer.clear();
            intBufferArray[i] = intBuffer;
        }
        return intBufferArray;
    }

    public void uploadMipmaps(int n, int n2) {
        IntBuffer intBuffer = TextureUtils.getStaticBufferNpot(this.width, this.height);
        int n3 = n / 2;
        int n4 = n2 / 2;
        for (int i = 0; i < this.mipmapDimensions.length; ++i) {
            Dimension dimension = this.mipmapDimensions[i];
            IntBuffer intBuffer2 = intBuffer;
            if (this.mipmapBuffers == null) {
                intBuffer.clear();
                intBuffer.put(this.mipmapDatas[i]);
            } else {
                intBuffer2 = this.mipmapBuffers[i];
            }
            intBuffer2.clear();
            int n5 = i + 1;
            int n6 = dimension.width;
            int n7 = dimension.height;
            GL11.glTexSubImage2D(3553, n5, n3, n4, n6, n7, 32993, 33639, intBuffer2);
            n3 /= 2;
            n4 /= 2;
        }
    }

    public static void allocateMipmapTextures(int n, int n2, String string) {
        Dimension[] dimensionArray = Mipmaps.makeMipmapDimensions(n, n2, string);
        for (int i = 0; i < dimensionArray.length; ++i) {
            Dimension dimension = dimensionArray[i];
            int n3 = dimension.width;
            int n4 = dimension.height;
            int n5 = i + 1;
            GL11.glTexImage2D(3553, n5, 6408, n3, n4, 0, 32993, 33639, (IntBuffer)null);
        }
    }
}

