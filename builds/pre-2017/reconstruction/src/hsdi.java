/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import java.util.Random;
import mcoptifine.CustomColorizer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Vector3f;

public class hsdi
implements ISimpleBlockRenderingHandler {
    private static final Vector3f lightDir1 = new Vector3f(0.16169f, 0.808452f, -0.565916f);
    private static final Vector3f lightDir2 = new Vector3f(-0.16169f, 0.808452f, 0.565916f);
    private static Vector3f tempVector = new Vector3f();
    public float uFactor = 1.0f;
    public float vFactor = 1.0f;
    public static int nextRenderId = 270;
    protected static Matrix3f rotation0 = new Matrix3f();
    protected static Matrix3f rotation90 = jywc._a(90.0f, 0.0f, 1.0f, 0.0f);
    protected static Matrix3f rotation180 = jywc._a(180.0f, 0.0f, 1.0f, 0.0f);
    protected static Matrix3f rotation270 = jywc._a(270.0f, 0.0f, 1.0f, 0.0f);
    public final int renderId;
    public WavefrontObject model;
    public final boolean randomPos;
    public final boolean randomRot;
    public final boolean randomScale;
    public final boolean colorMultiplier;
    public final float maxOffset;
    public final float minScale;
    public final float maxScale;
    public final int minInstances;
    public final int maxInstances;
    public final float[] ambientColor;
    public final float[] diffuseColor;
    private final float[] ambientColorTemp = new float[3];
    private final float[] diffuseColorTemp = new float[3];
    private Random rng = new Random();
    private Matrix3f tempMat1 = new Matrix3f();
    private Matrix3f tempMat2 = new Matrix3f();

    public hsdi(String string) {
        this(string, new float[]{0.4f, 0.4f, 0.4f}, new float[]{0.6f, 0.6f, 0.6f});
    }

    public hsdi(String string, float[] fArray, float[] fArray2) {
        this(string, false, false, 0.0f, 1.0f, 1.0f, 1, 1, fArray, fArray2);
    }

    public hsdi(String string, boolean bl, boolean bl2, float f, float f2, float f3, int n, int n2, float[] fArray, float[] fArray2) {
        this.renderId = nextRenderId++;
        this.model = (WavefrontObject)AdvancedModelLoader.loadModel(string);
        this.randomPos = f != 0.0f;
        this.randomRot = bl;
        this.colorMultiplier = bl2;
        this.maxOffset = f;
        this.minScale = f2;
        this.maxScale = f3;
        this.minInstances = n;
        this.maxInstances = n2;
        this.ambientColor = fArray;
        this.diffuseColor = fArray2;
        this.randomScale = f2 != 1.0f || f3 != 1.0f;
        this.setColor(1.0f, 1.0f, 1.0f);
    }

    public void setColor(float f, float f2, float f3) {
        this.ambientColorTemp[0] = this.ambientColor[0] * f;
        this.ambientColorTemp[1] = this.ambientColor[1] * f2;
        this.ambientColorTemp[2] = this.ambientColor[2] * f3;
        this.diffuseColorTemp[0] = this.diffuseColor[0] * f;
        this.diffuseColorTemp[1] = this.diffuseColor[1] * f2;
        this.diffuseColorTemp[2] = this.diffuseColor[2] * f3;
    }

    public void renderWithTessellator(Icon icon, Matrix3f matrix3f, Tessellator tessellator) {
        for (GroupObject groupObject : this.model.groupObjects) {
            for (Face face : groupObject.faces) {
                this.renderFace(face, icon, matrix3f, tessellator);
            }
        }
    }

    private void renderFace(Face face, Icon icon, Matrix3f matrix3f, Tessellator tessellator) {
        float f;
        int n;
        float f2 = 1.0E-6f;
        if (face.faceNormal == null) {
            face.faceNormal = face.calculateFaceNormal();
        }
        tempVector.set(face.faceNormal.x, face.faceNormal.y, face.faceNormal.z);
        if (matrix3f != null) {
            Matrix3f.transform(matrix3f, tempVector, tempVector);
        }
        float f3 = sajh._a(Vector3f.dot(tempVector, lightDir1), 0.0f, 1.0f) + sajh._a(Vector3f.dot(tempVector, lightDir2), 0.0f, 1.0f);
        float f4 = this.ambientColorTemp[0] + this.diffuseColorTemp[0] * f3;
        float f5 = this.ambientColorTemp[1] + this.diffuseColorTemp[1] * f3;
        float f6 = this.ambientColorTemp[2] + this.diffuseColorTemp[2] * f3;
        tessellator.setColorRGBA_F(f4, f5, f6, 1.0f);
        float f7 = 0.0f;
        float f8 = 0.0f;
        if (face.textureCoordinates != null && face.textureCoordinates.length > 0) {
            for (int i = 0; i < face.textureCoordinates.length; ++i) {
                f7 += face.textureCoordinates[i].u;
                f8 += face.textureCoordinates[i].v;
            }
            f7 /= (float)face.textureCoordinates.length;
            f8 /= (float)face.textureCoordinates.length;
        }
        for (n = 0; n < face.vertices.length; ++n) {
            tempVector.set(face.vertices[n].x, face.vertices[n].y, face.vertices[n].z);
            if (matrix3f != null) {
                Matrix3f.transform(matrix3f, tempVector, tempVector);
            }
            if (face.textureCoordinates != null && face.textureCoordinates.length > 0) {
                float f9 = f2;
                f = f2;
                if (face.textureCoordinates[n].u > f7) {
                    f9 = -f9;
                }
                if (face.textureCoordinates[n].v > f8) {
                    f = -f;
                }
                tessellator.addVertexWithUV(hsdi.tempVector.x, hsdi.tempVector.y, hsdi.tempVector.z, icon.getMinU() + face.textureCoordinates[n].u * this.uFactor * (icon.getMaxU() - icon.getMinU()) + f9, icon.getMinV() + face.textureCoordinates[n].v * this.vFactor * (icon.getMaxV() - icon.getMinV()) + f);
                continue;
            }
            tessellator.addVertex(face.vertices[n].x, face.vertices[n].y, face.vertices[n].z);
        }
        if (face.vertices.length == 3) {
            n = 2;
            tempVector.set(face.vertices[n].x, face.vertices[n].y, face.vertices[n].z);
            if (matrix3f != null) {
                Matrix3f.transform(matrix3f, tempVector, tempVector);
            }
            if (face.textureCoordinates != null && face.textureCoordinates.length > 0) {
                float f10 = f2;
                f = f2;
                if (face.textureCoordinates[n].u > f7) {
                    f10 = -f10;
                }
                if (face.textureCoordinates[n].v > f8) {
                    f = -f;
                }
                tessellator.addVertexWithUV(hsdi.tempVector.x, hsdi.tempVector.y, hsdi.tempVector.z, icon.getMinU() + face.textureCoordinates[n].u * this.uFactor * (icon.getMaxU() - icon.getMinU()) + f10, icon.getMinV() + face.textureCoordinates[n].v * this.vFactor * (icon.getMaxV() - icon.getMinV()) + f);
            } else {
                tessellator.addVertex(face.vertices[n].x, face.vertices[n].y, face.vertices[n].z);
            }
        }
    }

    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess iBlockAccess, int n, int n2, int n3, Block block, int n4, RenderBlocks renderBlocks) {
        int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
        int n6 = block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3);
        Icon icon = block.getIcon(0, n5);
        int n7 = n * 31 + n2 * 23 + n3 * 37;
        int n8 = CustomColorizer.getColorMultiplier(block, iBlockAccess, n, n2, n3);
        float f = (float)(n8 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n8 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n8 & 0xFF) / 255.0f;
        this.setColor(f, f2, f3);
        this.renderBlock(n, n2, n3, n7, n6, n5, icon, renderBlocks);
        return true;
    }

    public void renderBlock(int n, int n2, int n3, int n4, int n5, int n6, Icon icon, RenderBlocks renderBlocks) {
        this.rng.setSeed(n4);
        this.rng.setSeed(this.rng.nextLong());
        int n7 = this.minInstances + this.rng.nextInt(this.maxInstances - this.minInstances + 1);
        for (int i = 0; i < n7; ++i) {
            Matrix3f matrix3f;
            float f = (float)n + 0.5f;
            float f2 = (float)n3 + 0.5f;
            if (this.randomPos) {
                f += (this.rng.nextFloat() - 0.5f) * this.maxOffset * 2.0f;
                f2 += (this.rng.nextFloat() - 0.5f) * this.maxOffset * 2.0f;
            }
            if (this.randomScale || this.randomRot) {
                float f3;
                matrix3f = this.tempMat1;
                matrix3f.setIdentity();
                if (this.randomScale) {
                    f3 = this.minScale + this.rng.nextFloat() * (this.maxScale - this.minScale);
                    matrix3f = jywc._a(f3, f3, f3, this.tempMat1);
                }
                if (this.randomRot) {
                    f3 = this.rng.nextFloat() * 360.0f;
                    jywc._a(f3, 0.0f, 1.0f, 0.0f, this.tempMat2);
                    Matrix3f.mul(matrix3f, this.tempMat2, matrix3f);
                }
            } else {
                matrix3f = this.getRotationMatrixFromMetadata(n6);
            }
            Tessellator tessellator = renderBlocks.__aF;
            tessellator.addTranslation(f, n2, f2);
            tessellator.setBrightness(n5);
            this.renderWithTessellator(icon, matrix3f, tessellator);
            tessellator.addTranslation(-f, -n2, -f2);
        }
    }

    private Matrix3f getRotationMatrixFromMetadata(int n) {
        switch (n) {
            case 1: {
                return rotation270;
            }
            case 2: {
                return rotation180;
            }
            case 3: {
                return rotation90;
            }
        }
        return rotation0;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return this.renderId;
    }
}

