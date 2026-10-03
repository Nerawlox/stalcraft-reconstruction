/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bfv
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.ARBShaderObjects
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 *  org.lwjgl.opengl.GL31
 *  org.lwjgl.opengl.GL33
 *  org.lwjgl.util.vector.Matrix3f
 *  org.lwjgl.util.vector.Matrix4f
 */
package ru.stalcraft.client.effects.particles;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL33;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Matrix4f;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.client.effects.particles.Particle;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.effects.particles.ParticlesTextureMap;
import ru.stalcraft.client.effects.particles.attributes.AlphaAttribute;
import ru.stalcraft.client.effects.particles.attributes.Attribute;
import ru.stalcraft.client.effects.particles.attributes.BurnAttribute;
import ru.stalcraft.client.effects.particles.attributes.LightmaskCoordAttribute;
import ru.stalcraft.client.effects.particles.attributes.PositionAttribute;
import ru.stalcraft.client.effects.particles.attributes.RotationAttribute;
import ru.stalcraft.client.effects.particles.attributes.SizeAttribute;
import ru.stalcraft.client.effects.particles.attributes.TextureCoordsIdAttribute;

public class ParticlesRenderer {
    private boolean isTessellatorRenderingEnabled = false;
    private FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer((int)16).put(new float[]{-0.5f, 0.5f, 0.0f, 0.0f, -0.5f, -0.5f, 0.0f, 0.0f, 0.5f, -0.5f, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f, 0.0f});
    private final float PI = (float)Math.PI;
    private final float sin45 = (float)Math.sin(0.7853981633974483);
    private final String rotVecUniform = "rotationVec";
    private final String billboardRotMatUniform = "billboardRotMatrix";
    private final String textureCoordsUniform = "textureCoords";
    private final String textureUniform = "texture";
    private final String vertexPosAttrib = "vertexPosition";
    private int vaoId;
    private int vertexVboId;
    private int vertexPosLocation;
    private FloatBuffer coordsListBuffer;
    private int rotationVecLocation;
    private int billboardRotMatLocation;
    private int textureCoordsLocation;
    private int textureLocation;
    private int energyEffectLocation;
    private List attributes = new ArrayList();
    private Matrix4f billboardRotationMatrix = new Matrix4f();
    private bfv frustrum = new bfv();
    private FloatBuffer brmBuffer = BufferUtils.createFloatBuffer((int)16);

    public ParticlesRenderer() {
        this.verticesBuffer.flip();
        this.attributes.add(new PositionAttribute());
        this.attributes.add(new RotationAttribute());
        this.attributes.add(new TextureCoordsIdAttribute());
        this.attributes.add(new LightmaskCoordAttribute());
        this.attributes.add(new AlphaAttribute());
        this.attributes.add(new SizeAttribute());
        this.attributes.add(new BurnAttribute());
        this.billboardRotationMatrix.m33 = 1.0f;
    }

    public void render(float frame) {
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)1, (int)771);
        ParticlesTextureMap var10001 = EffectsEngine.instance.particlesTextureMap;
        atv.w().N.a(ParticlesTextureMap.particlesTexture);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2896);
        GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        DoubleBuffer mdl = BufferUtils.createDoubleBuffer((int)16);
        GL11.glGetDouble((int)2982, (DoubleBuffer)mdl);
        double cameraX = -(mdl.get(0) * mdl.get(12) + mdl.get(1) * mdl.get(13) + mdl.get(2) * mdl.get(14)) + bgl.b;
        double cameraY = -(mdl.get(4) * mdl.get(12) + mdl.get(5) * mdl.get(13) + mdl.get(6) * mdl.get(14)) + bgl.c;
        double cameraZ = -(mdl.get(8) * mdl.get(12) + mdl.get(9) * mdl.get(13) + mdl.get(10) * mdl.get(14)) + bgl.d;
        boolean invertXParticleRotation = atv.w().u.aa == 2;
        Matrix3f rotationMatrixY = EffectsEngine.rotationMatrix(-180.0f + bgl.a.j, 0.0f, 1.0f, 0.0f);
        Matrix3f rotationMatrixX = EffectsEngine.rotationMatrix(invertXParticleRotation ? -bgl.a.k : bgl.a.k, 1.0f, 0.0f, 0.0f);
        Matrix3f matrix = Matrix3f.mul((Matrix3f)rotationMatrixY, (Matrix3f)rotationMatrixX, (Matrix3f)null);
        this.billboardRotationMatrix.m00 = matrix.m00;
        this.billboardRotationMatrix.m01 = matrix.m01;
        this.billboardRotationMatrix.m02 = matrix.m02;
        this.billboardRotationMatrix.m10 = matrix.m10;
        this.billboardRotationMatrix.m11 = matrix.m11;
        this.billboardRotationMatrix.m12 = matrix.m12;
        this.billboardRotationMatrix.m20 = matrix.m20;
        this.billboardRotationMatrix.m21 = matrix.m21;
        this.billboardRotationMatrix.m22 = matrix.m22;
        this.brmBuffer.clear();
        this.billboardRotationMatrix.store(this.brmBuffer);
        this.brmBuffer.flip();
        ArrayList<ParticleEmitter> systemsToRender = new ArrayList<ParticleEmitter>();
        int particlesNumber = 0;
        this.frustrum.a(cameraX, cameraY, cameraZ);
        Iterator it2 = EffectsEngine.instance.particleEmitters.iterator();
        ParticleEmitter particleEmitter = null;
        Particle particle2 = null;
        while (it2.hasNext()) {
            particleEmitter = (ParticleEmitter)it2.next();
            particleEmitter.updateDistance(cameraX, cameraY, cameraZ);
            if (!(particleEmitter.lastDistanceSq < particleEmitter.renderDistanceSq) || !particleEmitter.ignoreFrustrumCheck() && !this.frustrum.a(particleEmitter.getBoundingBox())) continue;
            systemsToRender.add(particleEmitter);
            particlesNumber += particleEmitter.particles.size();
        }
        EffectsEngine.instance.particlesRendered = particlesNumber;
        EffectsEngine.instance.emittersRendered = systemsToRender.size();
        ArrayList<Particle> particles1 = new ArrayList<Particle>(particlesNumber);
        it2 = systemsToRender.iterator();
        Iterator it22 = null;
        while (it2.hasNext()) {
            particleEmitter = (ParticleEmitter)it2.next();
            for (Particle particle2 : particleEmitter.particles) {
                particle2.updateDistance(cameraX, cameraY, cameraZ, frame);
                particles1.add(particle2);
            }
        }
        if (EffectsEngine.instance.canRenderOnGPU && EffectsEngine.instance.shouldUseShaders) {
            if (!this.isTessellatorRenderingEnabled) {
                this.switchToShaderRendering();
            }
            this.renderWithShader(particles1, frame);
        } else {
            if (this.isTessellatorRenderingEnabled) {
                this.switchToTessellatorRendering();
            }
            this.renderWithTessellator(particles1, frame);
        }
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)3008);
        GL11.glDisable((int)3042);
        ARBShaderObjects.glUseProgramObjectARB((int)0);
    }

    private void switchToShaderRendering() {
        if (!this.isTessellatorRenderingEnabled) {
            this.isTessellatorRenderingEnabled = true;
            this.vaoId = GL30.glGenVertexArrays();
            GL30.glBindVertexArray((int)this.vaoId);
            this.vertexVboId = GL15.glGenBuffers();
            this.vertexPosLocation = GL20.glGetAttribLocation((int)EffectsEngine.instance.programId, (CharSequence)"vertexPosition");
            this.rotationVecLocation = GL20.glGetUniformLocation((int)EffectsEngine.instance.programId, (CharSequence)"rotationVec");
            this.billboardRotMatLocation = GL20.glGetUniformLocation((int)EffectsEngine.instance.programId, (CharSequence)"billboardRotMatrix");
            this.textureCoordsLocation = GL20.glGetUniformLocation((int)EffectsEngine.instance.programId, (CharSequence)"textureCoords");
            this.textureLocation = GL20.glGetUniformLocation((int)EffectsEngine.instance.programId, (CharSequence)"texture");
            GL15.glBindBuffer((int)34962, (int)this.vertexVboId);
            GL15.glBufferData((int)34962, (FloatBuffer)this.verticesBuffer, (int)35044);
            GL20.glVertexAttribPointer((int)this.vertexPosLocation, (int)4, (int)5126, (boolean)false, (int)0, (long)0L);
            Iterator it2 = this.attributes.iterator();
            Attribute attribute = null;
            while (it2.hasNext()) {
                attribute = (Attribute)it2.next();
                attribute.location = GL20.glGetAttribLocation((int)EffectsEngine.instance.programId, (CharSequence)attribute.name);
                attribute.vboId = GL15.glGenBuffers();
                GL15.glBindBuffer((int)34962, (int)attribute.vboId);
                GL20.glVertexAttribPointer((int)attribute.location, (int)attribute.floatsPerParticle, (int)5126, (boolean)false, (int)0, (long)0L);
            }
            GL15.glBindBuffer((int)34962, (int)0);
            GL30.glBindVertexArray((int)0);
        }
    }

    private void switchToTessellatorRendering() {
        if (this.isTessellatorRenderingEnabled) {
            this.isTessellatorRenderingEnabled = false;
            this.coordsListBuffer = null;
            for (Attribute attribute : this.attributes) {
                attribute.buffer = null;
                GL15.glDeleteBuffers((int)attribute.vboId);
                attribute.location = 0;
                attribute.vboId = 0;
            }
            GL15.glDeleteBuffers((int)this.vertexVboId);
            GL30.glDeleteVertexArrays((int)this.vaoId);
        }
    }

    protected void renderWithTessellator(List particles, float frame) {
        bfq t2 = bfq.a;
        atv.w().p.b((double)frame);
        float par3 = atp.d;
        float par5 = atp.f;
        float par6 = atp.g;
        float par7 = atp.h;
        float par4 = atp.e;
        float alpha = 0.0f;
        float alphac = 0.0f;
        float xSize = 0.0f;
        float ySize = 0.0f;
        double x2 = 0.0;
        double y2 = 0.0;
        double z2 = 0.0;
        float rotation = 0.0f;
        float rotSin = 0.0f;
        float rotCos = 0.0f;
        t2.b();
        Iterator it2 = particles.iterator();
        Particle particle = null;
        while (it2.hasNext()) {
            particle = (Particle)it2.next();
            if (!particle.shouldRender(frame)) continue;
            alpha = particle.prevAlpha + (particle.alpha - particle.prevAlpha) * frame;
            alphac = alpha * (1.0f - (particle.prevBurn + (particle.burn - particle.prevBurn) * frame));
            t2.a(alpha, alpha, alpha, alphac);
            t2.c(particle.getTessellatorBrightness());
            xSize = (particle.prevTextureSize + (particle.textureSize - particle.prevTextureSize) * frame) * this.sin45;
            ySize = (particle.prevTextureSize + (particle.textureSize - particle.prevTextureSize) * frame) * this.sin45;
            x2 = particle.prevPosX + (particle.posX - particle.prevPosX) * (double)frame - bgl.b;
            y2 = particle.prevPosY + (particle.posY - particle.prevPosY) * (double)frame - bgl.c;
            z2 = particle.prevPosZ + (particle.posZ - particle.prevPosZ) * (double)frame - bgl.d;
            rotation = (45.0f - particle.prevRotation - (particle.rotation - particle.prevRotation) * frame) * (float)Math.PI / 180.0f;
            rotSin = ls.a(rotation);
            rotCos = ls.b(rotation);
            t2.a(x2 + (double)(par3 * xSize * rotSin) + (double)(par6 * ySize * rotCos), y2 + (double)(par4 * ySize * rotCos), z2 + (double)(par5 * xSize * rotSin) + (double)(par7 * ySize * rotCos), particle.icon.c(), particle.icon.e());
            t2.a(x2 + (double)(par3 * xSize * rotCos) - (double)(par6 * ySize * rotSin), y2 - (double)(par4 * ySize * rotSin), z2 + (double)(par5 * xSize * rotCos) - (double)(par7 * ySize * rotSin), particle.icon.c(), particle.icon.f());
            t2.a(x2 - (double)(par3 * xSize * rotSin) - (double)(par6 * ySize * rotCos), y2 - (double)(par4 * ySize * rotCos), z2 - (double)(par5 * xSize * rotSin) - (double)(par7 * ySize * rotCos), particle.icon.d(), particle.icon.f());
            t2.a(x2 - (double)(par3 * xSize * rotCos) + (double)(par6 * ySize * rotSin), y2 + (double)(par4 * ySize * rotSin), z2 - (double)(par5 * xSize * rotCos) + (double)(par7 * ySize * rotSin), particle.icon.d(), particle.icon.e());
        }
        t2.a();
        atv.w().p.a((double)frame);
    }

    protected void renderWithShader(List particles, float frame) {
        ARBShaderObjects.glUseProgramObjectARB((int)EffectsEngine.instance.programId);
        Iterator it2 = this.attributes.iterator();
        Attribute attribute2 = null;
        Particle particle = null;
        Object particleEmitter = null;
        ParticleIcon particleIcon2 = null;
        while (it2.hasNext()) {
            attribute2 = (Attribute)it2.next();
            attribute2.prepareBuffer(particles.size());
        }
        it2 = particles.iterator();
        Iterator it22 = null;
        while (it2.hasNext()) {
            particle = (Particle)it2.next();
            if (!particle.shouldRender(frame)) continue;
            for (Attribute attribute2 : this.attributes) {
                attribute2.writeToBuffer(particle, frame);
            }
        }
        for (Attribute attribute2 : this.attributes) {
            attribute2.buffer.flip();
        }
        GL30.glBindVertexArray((int)this.vaoId);
        GL20.glUniform3f((int)this.rotationVecLocation, (float)0.0f, (float)0.0f, (float)1.0f);
        GL20.glUniformMatrix4((int)this.billboardRotMatLocation, (boolean)false, (FloatBuffer)this.brmBuffer);
        GL20.glUniform1i((int)this.textureLocation, (int)0);
        if (this.coordsListBuffer == null) {
            this.coordsListBuffer = BufferUtils.createFloatBuffer((int)(EffectsEngine.instance.particlesTextureMap.icons.size() * 4));
            for (ParticleIcon particleIcon2 : EffectsEngine.instance.particlesTextureMap.icons) {
                this.coordsListBuffer.put(particleIcon2.c());
                this.coordsListBuffer.put(particleIcon2.e());
                this.coordsListBuffer.put(particleIcon2.d());
                this.coordsListBuffer.put(particleIcon2.f());
            }
            this.coordsListBuffer.flip();
        }
        GL20.glUniform1((int)this.textureCoordsLocation, (FloatBuffer)this.coordsListBuffer);
        for (Attribute attribute2 : this.attributes) {
            GL15.glBindBuffer((int)34962, (int)attribute2.vboId);
            GL15.glBufferData((int)34962, (FloatBuffer)attribute2.buffer, (int)35048);
            GL20.glEnableVertexAttribArray((int)attribute2.location);
            GL33.glVertexAttribDivisor((int)attribute2.location, (int)1);
        }
        GL20.glEnableVertexAttribArray((int)this.vertexPosLocation);
        GL33.glVertexAttribDivisor((int)this.vertexPosLocation, (int)0);
        GL31.glDrawArraysInstanced((int)7, (int)0, (int)4, (int)particles.size());
        GL20.glDisableVertexAttribArray((int)this.vertexPosLocation);
        for (Attribute attribute2 : this.attributes) {
            GL20.glDisableVertexAttribArray((int)attribute2.location);
        }
        GL15.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
        ARBShaderObjects.glUseProgramObjectARB((int)0);
    }

    public static float interpolateRotation(float prev, float current, float frame) {
        float f3;
        for (f3 = current - prev; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        return prev + frame * f3;
    }
}

