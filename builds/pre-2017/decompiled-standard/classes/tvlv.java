/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public abstract class tvlv {
    public ozlu world;
    private Matrix4f matrix = new Matrix4f();
    private float renderScale;
    private static Vector4f vec = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
    public ArrayList<ncyh> particles = new ArrayList();
    private static final List<net.minecraft.util.eidj> dummyCollisionList = new ArrayList<net.minecraft.util.eidj>();
    HashMap<lnuq, float[]> blockBrightnessCache = new HashMap();
    private static FloatBuffer mdl = BufferUtils.createFloatBuffer(16);

    public tvlv(ozlu ozlu2) {
        this.world = ozlu2;
    }

    public void tick() {
        Iterator<ncyh> iterator2 = this.particles.iterator();
        while (iterator2.hasNext()) {
            ncyh ncyh2 = iterator2.next();
            if (ncyh2.isDead) {
                iterator2.remove();
                continue;
            }
            ncyh2.tick();
        }
        this.blockBrightnessCache.clear();
    }

    public List<net.minecraft.util.eidj> getCollidingBoundingBoxes(net.minecraft.util.eidj eidj2) {
        return dummyCollisionList;
    }

    public void reset() {
        this.particles.clear();
    }

    public float rescaleParticles(float f, float f2, float f3) {
        return (f + f2 + f3) / 3.0f;
    }

    public void updateParticlesRenderPos(float f) {
        for (ncyh ncyh2 : this.particles) {
            this.updateParticleRenderPos(ncyh2, f);
        }
    }

    public void loadTransformMatrix() {
        mdl.clear();
        GL11.glGetFloat(2982, mdl);
        this.matrix.load(mdl);
        Matrix4f.mul(eidj._a._w, this.matrix, this.matrix);
        float f = this.length(this.matrix.m00, this.matrix.m01, this.matrix.m02);
        float f2 = this.length(this.matrix.m10, this.matrix.m11, this.matrix.m12);
        float f3 = this.length(this.matrix.m20, this.matrix.m21, this.matrix.m22);
        this.renderScale = this.rescaleParticles(f, f2, f3);
    }

    public void setTransformMatrix(Matrix4f matrix4f) {
        this.matrix = matrix4f;
    }

    private float length(float f, float f2, float f3) {
        return (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
    }

    protected void updateParticleRenderPos(ncyh ncyh2, float f) {
        this.updateParticleRenderPosDefault(ncyh2, f);
    }

    public void updateParticleRenderPosDefault(ncyh ncyh2, float f) {
        tvlv.vec.x = (float)(ncyh2.prevPosX + (ncyh2.posX - ncyh2.prevPosX) * (double)f);
        tvlv.vec.y = (float)(ncyh2.prevPosY + (ncyh2.posY - ncyh2.prevPosY) * (double)f);
        tvlv.vec.z = (float)(ncyh2.prevPosZ + (ncyh2.posZ - ncyh2.prevPosZ) * (double)f);
        tvlv.vec.w = 1.0f;
        Matrix4f.transform(this.matrix, vec, vec);
        ncyh2.renderPosX = tvlv.vec.x;
        ncyh2.renderPosY = tvlv.vec.y;
        ncyh2.renderPosZ = tvlv.vec.z;
        ncyh2.renderTextureSize = (ncyh2.prevTextureSize + (ncyh2.textureSize - ncyh2.prevTextureSize) * f) * this.renderScale;
        ncyh2.updateDistance();
    }
}

