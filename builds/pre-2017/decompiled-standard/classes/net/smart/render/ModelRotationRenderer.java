/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import gloomyfolken.mods.stalker.player.zwaw;
import gloomyfolken.mods.stalker.smplayer.eidj;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.FloatBuffer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.smart.render.RendererData;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ModelRotationRenderer
extends ModelRenderer
implements zwaw,
eidj {
    protected static final float RadiantToAngle = 57.295776f;
    protected static final float Whole = (float)Math.PI * 2;
    protected static final float Half = (float)Math.PI;
    private static Field _compiled = Reflect.GetField(ModelRenderer.class, Install.ModelRenderer_compiled);
    private static Method _compileDisplayList = Reflect.GetMethod(ModelRenderer.class, Install.ModelRenderer_compileDisplayList, Float.TYPE);
    private static Field _displayList = Reflect.GetField(ModelRenderer.class, Install.ModelRenderer_displayList);
    public ModelRotationRenderer base;
    public boolean ignoreRender;
    public boolean forceRender;
    public boolean field_78812_q = false;
    public int field_78811_r;
    public int rotationOrder = 0;
    public float scaleX;
    public float scaleY;
    public float scaleZ;
    public boolean ignoreBase;
    public boolean ignoreSuperRotation;
    public float smOffsetX;
    public float smOffsetY;
    public float smOffsetZ;
    public static final int XYZ = 0;
    public static final int XZY = 1;
    public static final int YXZ = 2;
    public static final int YZX = 3;
    public static final int ZXY = 4;
    public static final int ZYX = 5;
    public boolean fadeEnabled;
    public boolean fadeOffsetX;
    public boolean fadeOffsetY;
    public boolean fadeOffsetZ;
    public boolean fadeRotateAngleX;
    public boolean fadeRotateAngleY;
    public boolean fadeRotateAngleZ;
    public boolean fadeRotationPointX;
    public boolean fadeRotationPointY;
    public boolean fadeRotationPointZ;
    public RendererData previous;
    private static FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
    private static float[] array = new float[16];

    public ModelRotationRenderer(ModelBase modelBase, int n, int n2, ModelRotationRenderer modelRotationRenderer) {
        super(modelBase, n, n2);
        this.base = modelRotationRenderer;
        if (this.base != null) {
            this.base.func_78792_a(this);
        }
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.fadeEnabled = false;
    }

    @Override
    public void func_78785_a(float f) {
        if (!this.ignoreRender && !this.ignoreBase || this.forceRender) {
            this.doRender(f, this.ignoreBase);
        }
    }

    public void renderIgnoreBase(float f) {
        if (this.ignoreBase) {
            this.doRender(f, false);
        }
    }

    public void doRender(float f, boolean bl) {
        if (this.preRender(f)) {
            this.preTransforms(f, true, bl);
            GL11.glCallList(this.field_78811_r);
            if (this.field_78805_m != null) {
                for (int i = 0; i < this.field_78805_m.size(); ++i) {
                    ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(f);
                }
            }
            this.postTransforms(f, true, bl);
        }
    }

    public boolean preRender(float f) {
        if (this.field_78807_k) {
            return false;
        }
        if (!this.field_78806_j) {
            return false;
        }
        if (!this.field_78812_q) {
            this.UpdateCompiled();
        }
        if (!this.field_78812_q) {
            Reflect.Invoke(_compileDisplayList, this, Float.valueOf(f));
            this.UpdateDisplayList();
            this.field_78812_q = true;
        }
        return true;
    }

    public void preTransforms(float f, boolean bl, boolean bl2) {
        if (this.base != null && !this.ignoreBase && bl2) {
            this.base.preTransforms(f, bl, true);
        }
        this.preTransform(f, bl);
    }

    public void preTransform(float f, boolean bl) {
        if (this.field_78795_f == 0.0f && this.field_78796_g == 0.0f && this.field_78808_h == 0.0f && !this.ignoreSuperRotation) {
            if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f || this.smOffsetX != 0.0f || this.smOffsetY != 0.0f || this.smOffsetZ != 0.0f) {
                GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
                GL11.glScalef(this.scaleX, this.scaleY, this.scaleZ);
                GL11.glTranslatef(this.smOffsetX, this.smOffsetY, this.smOffsetZ);
            }
        } else {
            if (bl) {
                GL11.glPushMatrix();
            }
            GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
            if (this.ignoreSuperRotation) {
                buffer.rewind();
                GL11.glGetFloat(2982, buffer);
                buffer.get(array);
                GL11.glLoadIdentity();
                GL11.glTranslatef(array[12] / array[15], array[13] / array[15], array[14] / array[15]);
            }
            ModelRotationRenderer.rotate(this.rotationOrder, this.field_78795_f, this.field_78796_g, this.field_78808_h);
            GL11.glScalef(this.scaleX, this.scaleY, this.scaleZ);
            GL11.glTranslatef(this.smOffsetX, this.smOffsetY, this.smOffsetZ);
        }
    }

    private static void rotate(int n, float f, float f2, float f3) {
        if (n == 4 && f2 != 0.0f) {
            GL11.glRotatef(f2 * 57.295776f, 0.0f, 1.0f, 0.0f);
        }
        if (n == 2 && f3 != 0.0f) {
            GL11.glRotatef(f3 * 57.295776f, 0.0f, 0.0f, 1.0f);
        }
        if ((n == 3 || n == 2 || n == 4 || n == 5) && f != 0.0f) {
            GL11.glRotatef(f * 57.295776f, 1.0f, 0.0f, 0.0f);
        }
        if ((n == 1 || n == 5) && f2 != 0.0f) {
            GL11.glRotatef(f2 * 57.295776f, 0.0f, 1.0f, 0.0f);
        }
        if ((n == 0 || n == 1 || n == 3 || n == 4 || n == 5) && f3 != 0.0f) {
            GL11.glRotatef(f3 * 57.295776f, 0.0f, 0.0f, 1.0f);
        }
        if ((n == 0 || n == 2 || n == 3) && f2 != 0.0f) {
            GL11.glRotatef(f2 * 57.295776f, 0.0f, 1.0f, 0.0f);
        }
        if ((n == 0 || n == 1) && f != 0.0f) {
            GL11.glRotatef(f * 57.295776f, 1.0f, 0.0f, 0.0f);
        }
    }

    public void postTransform(float f, boolean bl) {
        if (this.field_78795_f == 0.0f && this.field_78796_g == 0.0f && this.field_78808_h == 0.0f && !this.ignoreSuperRotation) {
            if (this.field_78800_c != 0.0f || this.field_78797_d != 0.0f || this.field_78798_e != 0.0f || this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f || this.smOffsetX != 0.0f || this.smOffsetY != 0.0f || this.smOffsetZ != 0.0f) {
                GL11.glTranslatef(-this.smOffsetX, -this.smOffsetY, -this.smOffsetZ);
                GL11.glScalef(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                GL11.glTranslatef(-this.field_78800_c * f, -this.field_78797_d * f, -this.field_78798_e * f);
            }
        } else if (bl) {
            GL11.glPopMatrix();
        }
    }

    public void postTransforms(float f, boolean bl, boolean bl2) {
        this.postTransform(f, bl);
        if (this.base != null && !this.ignoreBase && bl2) {
            this.base.postTransforms(f, bl, true);
        }
    }

    public void reset() {
        this.rotationOrder = 0;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.field_78800_c = 0.0f;
        this.field_78797_d = 0.0f;
        this.field_78798_e = 0.0f;
        this.field_78795_f = 0.0f;
        this.field_78796_g = 0.0f;
        this.field_78808_h = 0.0f;
        this.ignoreBase = false;
        this.ignoreSuperRotation = false;
        this.forceRender = false;
        this.smOffsetX = 0.0f;
        this.smOffsetY = 0.0f;
        this.smOffsetZ = 0.0f;
        this.fadeOffsetX = false;
        this.fadeOffsetY = false;
        this.fadeOffsetZ = false;
        this.fadeRotateAngleX = false;
        this.fadeRotateAngleY = false;
        this.fadeRotateAngleZ = false;
        this.fadeRotationPointX = false;
        this.fadeRotationPointY = false;
        this.fadeRotationPointZ = false;
        this.previous = null;
    }

    @Override
    public void func_78791_b(float f) {
        boolean bl = !this.field_78812_q;
        super.func_78791_b(f);
        if (bl) {
            this.UpdateLocals();
        }
    }

    @Override
    public void func_78794_c(float f) {
        boolean bl;
        boolean bl2 = bl = !this.field_78812_q;
        if (this.preRender(f)) {
            if (bl) {
                this.UpdateLocals();
            }
            this.preTransforms(f, false, true);
        }
    }

    private void UpdateLocals() {
        this.UpdateCompiled();
        if (this.field_78812_q) {
            this.UpdateDisplayList();
        }
    }

    private void UpdateCompiled() {
        this.field_78812_q = (Boolean)Reflect.GetField(_compiled, this);
    }

    private void UpdateDisplayList() {
        this.field_78811_r = (Integer)Reflect.GetField(_displayList, this);
    }

    public void fadeStore(float f) {
        if (this.previous != null) {
            this.previous.offsetX = this.smOffsetX;
            this.previous.offsetY = this.smOffsetY;
            this.previous.offsetZ = this.smOffsetZ;
            this.previous.rotateAngleX = this.field_78795_f;
            this.previous.rotateAngleY = this.field_78796_g;
            this.previous.rotateAngleZ = this.field_78808_h;
            this.previous.rotationPointX = this.field_78800_c;
            this.previous.rotationPointY = this.field_78797_d;
            this.previous.rotationPointZ = this.field_78798_e;
            this.previous.totalTime = f;
        }
    }

    public void fadeIntermediate(float f) {
        if (this.previous != null && f - this.previous.totalTime <= 2.0f) {
            this.smOffsetX = this.GetIntermediatePosition(this.previous.offsetX, this.smOffsetX, this.fadeOffsetX, this.previous.totalTime, f);
            this.smOffsetY = this.GetIntermediatePosition(this.previous.offsetY, this.smOffsetY, this.fadeOffsetY, this.previous.totalTime, f);
            this.smOffsetZ = this.GetIntermediatePosition(this.previous.offsetZ, this.smOffsetZ, this.fadeOffsetZ, this.previous.totalTime, f);
            this.field_78795_f = this.GetIntermediateAngle(this.previous.rotateAngleX, this.field_78795_f, this.fadeRotateAngleX, this.previous.totalTime, f);
            this.field_78796_g = this.GetIntermediateAngle(this.previous.rotateAngleY, this.field_78796_g, this.fadeRotateAngleY, this.previous.totalTime, f);
            this.field_78808_h = this.GetIntermediateAngle(this.previous.rotateAngleZ, this.field_78808_h, this.fadeRotateAngleZ, this.previous.totalTime, f);
            this.field_78800_c = this.GetIntermediatePosition(this.previous.rotationPointX, this.field_78800_c, this.fadeRotationPointX, this.previous.totalTime, f);
            this.field_78797_d = this.GetIntermediatePosition(this.previous.rotationPointY, this.field_78797_d, this.fadeRotationPointY, this.previous.totalTime, f);
            this.field_78798_e = this.GetIntermediatePosition(this.previous.rotationPointZ, this.field_78798_e, this.fadeRotationPointZ, this.previous.totalTime, f);
        }
    }

    public boolean canBeRandomBoxSource() {
        return true;
    }

    private float GetIntermediatePosition(float f, float f2, boolean bl, float f3, float f4) {
        return bl && f2 != f ? f + (f2 - f) * (f4 - f3) * 0.2f : f2;
    }

    private float GetIntermediateAngle(float f, float f2, boolean bl, float f3, float f4) {
        if (bl && f2 != f) {
            while (f >= (float)Math.PI * 2) {
                f -= (float)Math.PI * 2;
            }
            while (f < 0.0f) {
                f += (float)Math.PI * 2;
            }
            while (f2 >= (float)Math.PI * 2) {
                f2 -= (float)Math.PI * 2;
            }
            while (f2 < 0.0f) {
                f2 += (float)Math.PI * 2;
            }
            if (f2 > f && f2 - f > (float)Math.PI) {
                f += (float)Math.PI * 2;
            }
            if (f2 < f && f - f2 > (float)Math.PI) {
                f2 += (float)Math.PI * 2;
            }
            return f + (f2 - f) * (f4 - f3) * 0.2f;
        }
        return f2;
    }

    @Override
    public float getScaleY() {
        return this.scaleY;
    }

    @Override
    public void setScaleY(float f) {
        this.scaleY = f;
    }

    @Override
    public float rotateAngleZ() {
        return this.field_78808_h;
    }

    @Override
    public float rotateAngleY() {
        return this.field_78796_g;
    }

    @Override
    public float rotateAngleX() {
        return this.field_78795_f;
    }

    @Override
    public boolean ignoreSuperRotation() {
        return this.ignoreSuperRotation;
    }

    @Override
    public boolean ignoreBase() {
        return this.ignoreBase;
    }

    @Override
    public int rotationOrder() {
        return this.rotationOrder;
    }

    @Override
    public float rotationPointX() {
        return this.field_78800_c;
    }

    @Override
    public float rotationPointY() {
        return this.field_78797_d;
    }

    @Override
    public float rotationPointZ() {
        return this.field_78798_e;
    }

    @Override
    public float translationOffsetX() {
        if (this.base != null) {
            return this.base.smOffsetX;
        }
        return 0.0f;
    }

    @Override
    public float translationOffsetY() {
        if (this.base != null) {
            return this.base.smOffsetY;
        }
        return 0.0f;
    }

    @Override
    public float translationOffsetZ() {
        if (this.base != null) {
            return this.base.smOffsetZ;
        }
        return 0.0f;
    }
}

