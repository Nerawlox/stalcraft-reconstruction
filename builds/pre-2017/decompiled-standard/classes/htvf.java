/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import mcoptifine.ChunkTesselationParams;
import mcoptifine.ChunkVboTesselator;
import mcoptifine.Config;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class htvf {
    public static boolean field_78397_c;
    public ByteBuffer field_78394_d;
    public IntBuffer field_78395_e;
    public FloatBuffer field_78392_f;
    public ShortBuffer field_78393_g;
    public int[] field_78405_h;
    public int field_78406_i = 0;
    public double field_78403_j;
    public double field_78404_k;
    public int field_78401_l;
    public int field_78402_m;
    public boolean field_78399_n = false;
    public boolean field_78400_o = false;
    public boolean field_78414_p = false;
    public boolean field_78413_q = false;
    public int field_78412_r = 0;
    public int field_78411_s = 0;
    public boolean field_78410_t = false;
    public int field_78409_u;
    public double field_78408_v;
    public double field_78407_w;
    public double field_78417_x;
    public int field_78416_y;
    public static htvf field_78398_a;
    public boolean field_78415_z = false;
    public boolean field_78389_A = false;
    public IntBuffer field_78390_B;
    public int field_78391_C = 0;
    public int field_78387_D = 10;
    public int field_78388_E;
    public boolean renderingChunk = false;
    public static boolean littleEndianByteOrder;
    public static boolean renderingWorldRenderer;
    public boolean defaultTexture = true;
    public int textureID = 0;
    public final int DEFAULT_VERTEX_SIZE_BYTES = 32;
    public final int MAX_VERTEX_SIZE_BYTES = 32;
    public ChunkVboTesselator vboTesselator = null;
    public Thread ownerThread = null;

    public htvf() {
        this(65536);
        this.defaultTexture = false;
    }

    public void setOwnerThread(Thread thread) {
        this.ownerThread = thread;
    }

    public htvf(int n) {
        this.field_78388_E = n;
        this.field_78394_d = pklh._c(n * 4);
        this.field_78395_e = this.field_78394_d.asIntBuffer();
        this.field_78392_f = this.field_78394_d.asFloatBuffer();
        this.field_78393_g = this.field_78394_d.asShortBuffer();
        this.field_78405_h = new int[n];
        boolean bl = this.field_78389_A = field_78397_c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if (this.field_78389_A) {
            this.field_78390_B = pklh._d(this.field_78387_D);
            ARBVertexBufferObject.glGenBuffersARB(this.field_78390_B);
        }
    }

    public int func_78381_a() {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (!this.field_78415_z) {
            throw new IllegalStateException("Not tesselating!");
        }
        this.field_78415_z = false;
        if (this.useVboRendering()) {
            return this.vboTesselator.getBytesDrawn();
        }
        if (this.field_78406_i > 0) {
            this.field_78395_e.clear();
            this.field_78395_e.put(this.field_78405_h, 0, this.field_78412_r);
            this.field_78394_d.position(0);
            this.field_78394_d.limit(this.field_78412_r * 4);
            if (this.field_78389_A) {
                this.field_78391_C = (this.field_78391_C + 1) % this.field_78387_D;
                ARBVertexBufferObject.glBindBufferARB(34962, this.field_78390_B.get(this.field_78391_C));
                ARBVertexBufferObject.glBufferDataARB(34962, this.field_78394_d, 35040);
            }
            if (this.field_78400_o) {
                if (this.field_78389_A) {
                    GL11.glTexCoordPointer(2, 5126, 32, 12L);
                } else {
                    this.field_78392_f.position(3);
                    GL11.glTexCoordPointer(2, 32, this.field_78392_f);
                }
                GL11.glEnableClientState(32888);
            }
            if (this.field_78414_p) {
                iwya._b(iwya._b);
                if (this.field_78389_A) {
                    GL11.glTexCoordPointer(2, 5122, 32, 28L);
                } else {
                    this.field_78393_g.position(14);
                    GL11.glTexCoordPointer(2, 32, this.field_78393_g);
                }
                GL11.glEnableClientState(32888);
                iwya._b(iwya._a);
            }
            if (this.field_78399_n) {
                if (this.field_78389_A) {
                    GL11.glColorPointer(4, 5121, 32, 20L);
                } else {
                    this.field_78394_d.position(20);
                    GL11.glColorPointer(4, true, 32, this.field_78394_d);
                }
                GL11.glEnableClientState(32886);
            }
            if (this.field_78413_q) {
                if (this.field_78389_A) {
                    GL11.glNormalPointer(5121, 32, 24L);
                } else {
                    this.field_78394_d.position(24);
                    GL11.glNormalPointer(32, this.field_78394_d);
                }
                GL11.glEnableClientState(32885);
            }
            if (this.field_78389_A) {
                GL11.glVertexPointer(3, 5126, 32, 0L);
            } else {
                this.field_78392_f.position(0);
                GL11.glVertexPointer(3, 32, this.field_78392_f);
            }
            GL11.glEnableClientState(32884);
            GL11.glDrawArrays(this.field_78409_u, 0, this.field_78406_i);
            GL11.glDisableClientState(32884);
            if (this.field_78400_o) {
                GL11.glDisableClientState(32888);
            }
            if (this.field_78414_p) {
                iwya._b(iwya._b);
                GL11.glDisableClientState(32888);
                iwya._b(iwya._a);
            }
            if (this.field_78399_n) {
                GL11.glDisableClientState(32886);
            }
            if (this.field_78413_q) {
                GL11.glDisableClientState(32885);
            }
        }
        int n = this.field_78412_r * 4;
        this.func_78379_d();
        return n;
    }

    public void func_78379_d() {
        this.field_78406_i = 0;
        this.field_78394_d.clear();
        this.field_78412_r = 0;
        this.field_78411_s = 0;
        if (this.vboTesselator != null) {
            this.vboTesselator.reset();
        }
    }

    public void func_78382_b() {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        this.func_78371_b(7);
    }

    public void func_78371_b(int n) {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (this.field_78415_z) {
            throw new IllegalStateException("Af lready tesselating!");
        }
        this.field_78415_z = true;
        this.func_78379_d();
        this.field_78409_u = n;
        this.field_78413_q = false;
        this.field_78399_n = false;
        this.field_78400_o = false;
        this.field_78414_p = false;
        this.field_78410_t = false;
    }

    public void func_78385_a(double d, double d2) {
        this.field_78400_o = true;
        this.field_78403_j = d;
        this.field_78404_k = d2;
    }

    public void func_78380_c(int n) {
        this.field_78414_p = true;
        this.field_78401_l = n;
    }

    public void func_78386_a(float f, float f2, float f3) {
        this.func_78376_a((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f));
    }

    public void func_78369_a(float f, float f2, float f3, float f4) {
        this.func_78370_a((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f), (int)(f4 * 255.0f));
    }

    public void func_78376_a(int n, int n2, int n3) {
        this.func_78370_a(n, n2, n3, 255);
    }

    public void func_78370_a(int n, int n2, int n3, int n4) {
        if (!this.field_78410_t) {
            if (n > 255) {
                n = 255;
            }
            if (n2 > 255) {
                n2 = 255;
            }
            if (n3 > 255) {
                n3 = 255;
            }
            if (n4 > 255) {
                n4 = 255;
            }
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            if (n3 < 0) {
                n3 = 0;
            }
            if (n4 < 0) {
                n4 = 0;
            }
            this.field_78399_n = true;
            this.field_78402_m = littleEndianByteOrder ? n4 << 24 | n3 << 16 | n2 << 8 | n : n << 24 | n2 << 16 | n3 << 8 | n4;
        }
    }

    public void func_78374_a(double d, double d2, double d3, double d4, double d5) {
        this.func_78385_a(d4, d5);
        this.func_78377_a(d, d2, d3);
    }

    public void func_78377_a(double d, double d2, double d3) {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (this.field_78412_r >= this.field_78388_E - 32) {
            Config.dbg("Expand tessellator buffer, old: " + this.field_78388_E + ", new: " + this.field_78388_E * 2);
            this.field_78388_E *= 2;
            int[] nArray = new int[this.field_78388_E];
            System.arraycopy(this.field_78405_h, 0, nArray, 0, this.field_78405_h.length);
            this.field_78405_h = nArray;
            this.field_78394_d = pklh._c(this.field_78388_E * 4);
            this.field_78395_e = this.field_78394_d.asIntBuffer();
            this.field_78392_f = this.field_78394_d.asFloatBuffer();
            this.field_78393_g = this.field_78394_d.asShortBuffer();
        }
        if (this.useVboRendering()) {
            assert (this.field_78400_o);
            assert (this.field_78414_p);
            assert (this.field_78399_n);
            this.vboTesselator.addVertex((float)(d + this.field_78408_v), (float)(d2 + this.field_78407_w), (float)(d3 + this.field_78417_x), (float)this.field_78403_j, (float)this.field_78404_k, this.field_78401_l, this.field_78402_m);
        } else {
            if (this.field_78400_o) {
                this.field_78405_h[this.field_78412_r + 3] = Float.floatToRawIntBits((float)this.field_78403_j);
                this.field_78405_h[this.field_78412_r + 4] = Float.floatToRawIntBits((float)this.field_78404_k);
            }
            if (this.field_78414_p) {
                this.field_78405_h[this.field_78412_r + 7] = this.field_78401_l;
            }
            if (this.field_78399_n) {
                this.field_78405_h[this.field_78412_r + 5] = this.field_78402_m;
            }
            if (this.field_78413_q) {
                this.field_78405_h[this.field_78412_r + 6] = this.field_78416_y;
            }
            this.field_78405_h[this.field_78412_r + 0] = Float.floatToRawIntBits((float)(d + this.field_78408_v));
            this.field_78405_h[this.field_78412_r + 1] = Float.floatToRawIntBits((float)(d2 + this.field_78407_w));
            this.field_78405_h[this.field_78412_r + 2] = Float.floatToRawIntBits((float)(d3 + this.field_78417_x));
            this.field_78412_r += 8;
        }
        ++this.field_78411_s;
        ++this.field_78406_i;
    }

    public void func_78378_d(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        this.func_78376_a(n2, n3, n4);
    }

    public void func_78384_a(int n, int n2) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        this.func_78370_a(n3, n4, n5, n2);
    }

    public void func_78383_c() {
        this.field_78410_t = true;
    }

    public void func_78375_b(float f, float f2, float f3) {
        this.field_78413_q = true;
        byte by = (byte)(f * 127.0f);
        byte by2 = (byte)(f2 * 127.0f);
        byte by3 = (byte)(f3 * 127.0f);
        this.field_78416_y = by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16;
    }

    public void func_78373_b(double d, double d2, double d3) {
        this.field_78408_v = d;
        this.field_78407_w = d2;
        this.field_78417_x = d3;
    }

    public void func_78372_c(float f, float f2, float f3) {
        this.field_78408_v += (double)f;
        this.field_78407_w += (double)f2;
        this.field_78417_x += (double)f3;
    }

    public boolean useVboRendering() {
        return this.renderingChunk;
    }

    public void setRenderingChunk(boolean bl) {
        if (this.field_78415_z) {
            throw new IllegalStateException("Changing mode of tesselator is not supported while tesselating!");
        }
        this.renderingChunk = bl;
        if (this.useVboRendering()) {
            if (this.vboTesselator == null) {
                this.vboTesselator = new ChunkVboTesselator(this.field_78388_E / 4, ChunkTesselationParams.DEFAULT);
            }
        } else if (this.vboTesselator != null) {
            this.vboTesselator.reset();
        }
    }

    static {
        field_78398_a = new htvf(524288);
        littleEndianByteOrder = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        renderingWorldRenderer = false;
    }
}

