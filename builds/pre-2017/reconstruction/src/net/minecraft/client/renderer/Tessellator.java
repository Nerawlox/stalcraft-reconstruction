/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

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

public class Tessellator {
    public static boolean tryVBO;
    public ByteBuffer byteBuffer;
    public IntBuffer intBuffer;
    public FloatBuffer floatBuffer;
    public ShortBuffer shortBuffer;
    public int[] rawBuffer;
    public int vertexCount = 0;
    public double textureU;
    public double textureV;
    public int brightness;
    public int color;
    public boolean hasColor = false;
    public boolean hasTexture = false;
    public boolean hasBrightness = false;
    public boolean hasNormals = false;
    public int rawBufferIndex = 0;
    public int addedVertices = 0;
    public boolean isColorDisabled = false;
    public int drawMode;
    public double xOffset;
    public double yOffset;
    public double zOffset;
    public int normal;
    public static Tessellator instance;
    public boolean isDrawing = false;
    public boolean useVBO = false;
    public IntBuffer vertexBuffers;
    public int vboIndex = 0;
    public int vboCount = 10;
    public int bufferSize;
    public boolean renderingChunk = false;
    public static boolean littleEndianByteOrder;
    public static boolean renderingWorldRenderer;
    public boolean defaultTexture = true;
    public int textureID = 0;
    public final int DEFAULT_VERTEX_SIZE_BYTES = 32;
    public final int MAX_VERTEX_SIZE_BYTES = 32;
    public ChunkVboTesselator vboTesselator = null;
    public Thread ownerThread = null;

    public Tessellator() {
        this(65536);
        this.defaultTexture = false;
    }

    public void setOwnerThread(Thread thread) {
        this.ownerThread = thread;
    }

    public Tessellator(int n) {
        this.bufferSize = n;
        this.byteBuffer = pklh._c(n * 4);
        this.intBuffer = this.byteBuffer.asIntBuffer();
        this.floatBuffer = this.byteBuffer.asFloatBuffer();
        this.shortBuffer = this.byteBuffer.asShortBuffer();
        this.rawBuffer = new int[n];
        boolean bl = this.useVBO = tryVBO && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if (this.useVBO) {
            this.vertexBuffers = pklh._d(this.vboCount);
            ARBVertexBufferObject.glGenBuffersARB(this.vertexBuffers);
        }
    }

    public int draw() {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (!this.isDrawing) {
            throw new IllegalStateException("Not tesselating!");
        }
        this.isDrawing = false;
        if (this.useVboRendering()) {
            return this.vboTesselator.getBytesDrawn();
        }
        if (this.vertexCount > 0) {
            this.intBuffer.clear();
            this.intBuffer.put(this.rawBuffer, 0, this.rawBufferIndex);
            this.byteBuffer.position(0);
            this.byteBuffer.limit(this.rawBufferIndex * 4);
            if (this.useVBO) {
                this.vboIndex = (this.vboIndex + 1) % this.vboCount;
                ARBVertexBufferObject.glBindBufferARB(34962, this.vertexBuffers.get(this.vboIndex));
                ARBVertexBufferObject.glBufferDataARB(34962, this.byteBuffer, 35040);
            }
            if (this.hasTexture) {
                if (this.useVBO) {
                    GL11.glTexCoordPointer(2, 5126, 32, 12L);
                } else {
                    this.floatBuffer.position(3);
                    GL11.glTexCoordPointer(2, 32, this.floatBuffer);
                }
                GL11.glEnableClientState(32888);
            }
            if (this.hasBrightness) {
                iwya._b(iwya._b);
                if (this.useVBO) {
                    GL11.glTexCoordPointer(2, 5122, 32, 28L);
                } else {
                    this.shortBuffer.position(14);
                    GL11.glTexCoordPointer(2, 32, this.shortBuffer);
                }
                GL11.glEnableClientState(32888);
                iwya._b(iwya._a);
            }
            if (this.hasColor) {
                if (this.useVBO) {
                    GL11.glColorPointer(4, 5121, 32, 20L);
                } else {
                    this.byteBuffer.position(20);
                    GL11.glColorPointer(4, true, 32, this.byteBuffer);
                }
                GL11.glEnableClientState(32886);
            }
            if (this.hasNormals) {
                if (this.useVBO) {
                    GL11.glNormalPointer(5121, 32, 24L);
                } else {
                    this.byteBuffer.position(24);
                    GL11.glNormalPointer(32, this.byteBuffer);
                }
                GL11.glEnableClientState(32885);
            }
            if (this.useVBO) {
                GL11.glVertexPointer(3, 5126, 32, 0L);
            } else {
                this.floatBuffer.position(0);
                GL11.glVertexPointer(3, 32, this.floatBuffer);
            }
            GL11.glEnableClientState(32884);
            GL11.glDrawArrays(this.drawMode, 0, this.vertexCount);
            GL11.glDisableClientState(32884);
            if (this.hasTexture) {
                GL11.glDisableClientState(32888);
            }
            if (this.hasBrightness) {
                iwya._b(iwya._b);
                GL11.glDisableClientState(32888);
                iwya._b(iwya._a);
            }
            if (this.hasColor) {
                GL11.glDisableClientState(32886);
            }
            if (this.hasNormals) {
                GL11.glDisableClientState(32885);
            }
        }
        int n = this.rawBufferIndex * 4;
        this.reset();
        return n;
    }

    public void reset() {
        this.vertexCount = 0;
        this.byteBuffer.clear();
        this.rawBufferIndex = 0;
        this.addedVertices = 0;
        if (this.vboTesselator != null) {
            this.vboTesselator.reset();
        }
    }

    public void startDrawingQuads() {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        this.startDrawing(7);
    }

    public void startDrawing(int n) {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (this.isDrawing) {
            throw new IllegalStateException("Af lready tesselating!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = n;
        this.hasNormals = false;
        this.hasColor = false;
        this.hasTexture = false;
        this.hasBrightness = false;
        this.isColorDisabled = false;
    }

    public void setTextureUV(double d, double d2) {
        this.hasTexture = true;
        this.textureU = d;
        this.textureV = d2;
    }

    public void setBrightness(int n) {
        this.hasBrightness = true;
        this.brightness = n;
    }

    public void setColorOpaque_F(float f, float f2, float f3) {
        this.setColorOpaque((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f));
    }

    public void setColorRGBA_F(float f, float f2, float f3, float f4) {
        this.setColorRGBA((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f), (int)(f4 * 255.0f));
    }

    public void setColorOpaque(int n, int n2, int n3) {
        this.setColorRGBA(n, n2, n3, 255);
    }

    public void setColorRGBA(int n, int n2, int n3, int n4) {
        if (!this.isColorDisabled) {
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
            this.hasColor = true;
            this.color = littleEndianByteOrder ? n4 << 24 | n3 << 16 | n2 << 8 | n : n << 24 | n2 << 16 | n3 << 8 | n4;
        }
    }

    public void addVertexWithUV(double d, double d2, double d3, double d4, double d5) {
        this.setTextureUV(d4, d5);
        this.addVertex(d, d2, d3);
    }

    public void addVertex(double d, double d2, double d3) {
        assert (this.ownerThread == null || this.ownerThread == Thread.currentThread());
        if (this.rawBufferIndex >= this.bufferSize - 32) {
            Config.dbg("Expand tessellator buffer, old: " + this.bufferSize + ", new: " + this.bufferSize * 2);
            this.bufferSize *= 2;
            int[] nArray = new int[this.bufferSize];
            System.arraycopy(this.rawBuffer, 0, nArray, 0, this.rawBuffer.length);
            this.rawBuffer = nArray;
            this.byteBuffer = pklh._c(this.bufferSize * 4);
            this.intBuffer = this.byteBuffer.asIntBuffer();
            this.floatBuffer = this.byteBuffer.asFloatBuffer();
            this.shortBuffer = this.byteBuffer.asShortBuffer();
        }
        if (this.useVboRendering()) {
            assert (this.hasTexture);
            assert (this.hasBrightness);
            assert (this.hasColor);
            this.vboTesselator.addVertex((float)(d + this.xOffset), (float)(d2 + this.yOffset), (float)(d3 + this.zOffset), (float)this.textureU, (float)this.textureV, this.brightness, this.color);
        } else {
            if (this.hasTexture) {
                this.rawBuffer[this.rawBufferIndex + 3] = Float.floatToRawIntBits((float)this.textureU);
                this.rawBuffer[this.rawBufferIndex + 4] = Float.floatToRawIntBits((float)this.textureV);
            }
            if (this.hasBrightness) {
                this.rawBuffer[this.rawBufferIndex + 7] = this.brightness;
            }
            if (this.hasColor) {
                this.rawBuffer[this.rawBufferIndex + 5] = this.color;
            }
            if (this.hasNormals) {
                this.rawBuffer[this.rawBufferIndex + 6] = this.normal;
            }
            this.rawBuffer[this.rawBufferIndex + 0] = Float.floatToRawIntBits((float)(d + this.xOffset));
            this.rawBuffer[this.rawBufferIndex + 1] = Float.floatToRawIntBits((float)(d2 + this.yOffset));
            this.rawBuffer[this.rawBufferIndex + 2] = Float.floatToRawIntBits((float)(d3 + this.zOffset));
            this.rawBufferIndex += 8;
        }
        ++this.addedVertices;
        ++this.vertexCount;
    }

    public void setColorOpaque_I(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        this.setColorOpaque(n2, n3, n4);
    }

    public void setColorRGBA_I(int n, int n2) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        this.setColorRGBA(n3, n4, n5, n2);
    }

    public void disableColor() {
        this.isColorDisabled = true;
    }

    public void setNormal(float f, float f2, float f3) {
        this.hasNormals = true;
        byte by = (byte)(f * 127.0f);
        byte by2 = (byte)(f2 * 127.0f);
        byte by3 = (byte)(f3 * 127.0f);
        this.normal = by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16;
    }

    public void setTranslation(double d, double d2, double d3) {
        this.xOffset = d;
        this.yOffset = d2;
        this.zOffset = d3;
    }

    public void addTranslation(float f, float f2, float f3) {
        this.xOffset += (double)f;
        this.yOffset += (double)f2;
        this.zOffset += (double)f3;
    }

    public boolean useVboRendering() {
        return this.renderingChunk;
    }

    public void setRenderingChunk(boolean bl) {
        if (this.isDrawing) {
            throw new IllegalStateException("Changing mode of tesselator is not supported while tesselating!");
        }
        this.renderingChunk = bl;
        if (this.useVboRendering()) {
            if (this.vboTesselator == null) {
                this.vboTesselator = new ChunkVboTesselator(this.bufferSize / 4, ChunkTesselationParams.DEFAULT);
            }
        } else if (this.vboTesselator != null) {
            this.vboTesselator.reset();
        }
    }

    static {
        instance = new Tessellator(524288);
        littleEndianByteOrder = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        renderingWorldRenderer = false;
    }
}

