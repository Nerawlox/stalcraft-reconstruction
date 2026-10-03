/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bir
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.ARBShaderObjects
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.util.vector.Matrix3f
 *  org.lwjgl.util.vector.Vector2f
 *  org.lwjgl.util.vector.Vector3f
 */
package ru.stalcraft.client.effects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import ru.stalcraft.Logger;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticlesRenderer;
import ru.stalcraft.client.effects.particles.ParticlesTextureMap;

public final class EffectsEngine {
    private Random rand = new Random();
    public static EffectsEngine instance;
    public List particleEmitters = new ArrayList();
    public int particlesRendered;
    public int emittersRendered;
    private List emitterClasses = new ArrayList();
    public int programId;
    public boolean invertXParticleRotation;
    public boolean canRenderOnGPU;
    public ParticlesTextureMap particlesTextureMap;
    private ParticlesRenderer particlesRenderer;
    public boolean shouldUseShaders;
    private static final float degToRad = (float)Math.PI / 180;
    public float xWind;
    public float zWind;
    private int windChangeTimer = 0;

    public EffectsEngine() throws Exception {
        this.canRenderOnGPU = GLContext.getCapabilities().OpenGL33;
        System.out.println("[Effects API] OpenGL version is " + GL11.glGetString((int)7938) + " " + (this.canRenderOnGPU ? "(supports OpenGL 3.3.0)" : "(does not support OpenGL 3.3.0)"));
        boolean vertShader = false;
        boolean fragShader = false;
        int vertShader1 = this.createShader("/assets/effects/shaders/particle.vsh", 35633);
        int fragShader1 = this.createShader("/assets/effects/shaders/particle.fsh", 35632);
        if (vertShader1 != 0 && fragShader1 != 0) {
            this.programId = ARBShaderObjects.glCreateProgramObjectARB();
            if (this.programId == 0) {
                throw new Exception("[ERR][Effects API] Can't setup particle engine! (creating program)");
            }
            ARBShaderObjects.glAttachObjectARB((int)this.programId, (int)vertShader1);
            ARBShaderObjects.glAttachObjectARB((int)this.programId, (int)fragShader1);
            ARBShaderObjects.glLinkProgramARB((int)this.programId);
            if (ARBShaderObjects.glGetObjectParameteriARB((int)this.programId, (int)35714) == 0) {
                Logger.console(EffectsEngine.getLogInfo(this.programId));
                throw new Exception("[ERR][Effects API] Can't setup particle engine! (linking program)");
            }
            ARBShaderObjects.glValidateProgramARB((int)this.programId);
            if (ARBShaderObjects.glGetObjectParameteriARB((int)this.programId, (int)35715) == 0) {
                Logger.console(EffectsEngine.getLogInfo(this.programId));
                throw new Exception("[ERR][Effects API] Can't setup particle engine! (validating program)");
            }
        } else {
            throw new Exception("[ERR][Effects API] Can't setup particle engine! (loading shaders)");
        }
        this.particlesRenderer = new ParticlesRenderer();
        Logger.console("[Effects API] Shaders have been loaded");
        instance = this;
    }

    public static void renderStatic(float frame) {
        if (instance != null) {
            instance.render(frame);
        }
    }

    public void render(float frame) {
        this.particlesRenderer.render(frame);
    }

    public void tick() {
        this.tickParticles();
    }

    public void addParticleEmitter(ParticleEmitter s2) {
        this.particleEmitters.add(s2);
    }

    private void tickParticles() {
        Iterator it2 = this.particleEmitters.iterator();
        ParticleEmitter particleEmitter = null;
        while (it2.hasNext()) {
            particleEmitter = (ParticleEmitter)it2.next();
            if (!particleEmitter.isValid()) {
                it2.remove();
                continue;
            }
            particleEmitter.updateDistance(bgl.b, bgl.c, bgl.d);
            if (!(particleEmitter.lastDistanceSq < (particleEmitter.renderDistanceSq + 16.0) * (particleEmitter.renderDistanceSq + 16.0))) continue;
            particleEmitter.tick();
        }
        if (--this.windChangeTimer <= 0) {
            this.windChangeTimer = 40 + this.rand.nextInt(60);
            Vector2f var5 = new Vector2f(this.rand.nextFloat() - 0.5f, this.rand.nextFloat() - 0.5f);
            var5.normalise();
            float var6 = this.rand.nextFloat() * 0.01f;
            this.xWind = var5.x * var6;
            this.zWind = var5.y * var6;
        }
    }

    private int createShader(String filename, int shaderType) throws Exception {
        int shader = 0;
        try {
            int shader1 = ARBShaderObjects.glCreateShaderObjectARB((int)shaderType);
            if (shader1 == 0) {
                return 0;
            }
            ARBShaderObjects.glShaderSourceARB((int)shader1, (CharSequence)this.readResourceAsString(filename));
            ARBShaderObjects.glCompileShaderARB((int)shader1);
            if (ARBShaderObjects.glGetObjectParameteriARB((int)shader1, (int)35713) == 0) {
                throw new RuntimeException("Error creating shader: " + EffectsEngine.getLogInfo(shader1));
            }
            return shader1;
        }
        catch (Exception var5) {
            ARBShaderObjects.glDeleteObjectARB((int)shader);
            throw var5;
        }
    }

    private static String getLogInfo(int obj) {
        return ARBShaderObjects.glGetInfoLogARB((int)obj, (int)ARBShaderObjects.glGetObjectParameteriARB((int)obj, (int)35716));
    }

    private String readResourceAsString(String filename) throws Exception {
        try {
            BufferedReader e2 = new BufferedReader(new InputStreamReader(EffectsEngine.class.getResourceAsStream(filename), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            boolean flag = false;
            while (!flag) {
                String str = e2.readLine();
                if (str == null) {
                    flag = true;
                    continue;
                }
                buffer.append(str).append("\n");
            }
            return buffer.toString();
        }
        catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public void registerEmitter(Class emitterClass) {
        this.emitterClasses.add(emitterClass);
    }

    public void loadIcons() {
        ParticlesTextureMap var10001 = this.particlesTextureMap = new ParticlesTextureMap(this.emitterClasses);
        atv.w().N.a(ParticlesTextureMap.particlesTexture, (bir)this.particlesTextureMap);
    }

    public static Matrix3f rotationMatrix(float angle, float x2, float y2, float z2) {
        Vector3f axis = new Vector3f(x2, y2, z2);
        axis.normalise();
        float s2 = ls.a(angle *= (float)Math.PI / 180);
        float c2 = ls.b(angle);
        float oc2 = 1.0f - c2;
        Matrix3f mat = new Matrix3f();
        FloatBuffer buff = BufferUtils.createFloatBuffer((int)9);
        buff.put(new float[]{oc2 * axis.x * axis.x + c2, oc2 * axis.x * axis.y - axis.z * s2, oc2 * axis.z * axis.x + axis.y * s2, oc2 * axis.x * axis.y + axis.z * s2, oc2 * axis.y * axis.y + c2, oc2 * axis.y * axis.z - axis.x * s2, oc2 * axis.z * axis.x - axis.y * s2, oc2 * axis.y * axis.z + axis.x * s2, oc2 * axis.z * axis.z + c2});
        buff.flip();
        mat.load(buff);
        return mat;
    }
}

