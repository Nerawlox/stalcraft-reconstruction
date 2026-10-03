/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public abstract class ncyh {
    public final eidj boundingBox;
    public boolean isDistortionParticle = false;
    protected tvlv parent;
    public double posX;
    public double posY;
    public double posZ;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;
    public float motionX;
    public float motionY;
    public float motionZ;
    public float speedFactor = 1.0f;
    public float rotation;
    public float prevRotation;
    public float rotationSpeed;
    protected boolean clip = false;
    public boolean onGround;
    public boolean isCollided;
    public int ticksExisted;
    public boolean isDead;
    private int posVboId = 0;
    public float alpha = 1.0f;
    public float prevAlpha = 1.0f;
    protected ejcz icon;
    public float textureSize;
    public float prevTextureSize;
    public float collisionSize;
    protected float halfCollisionSize;
    public float stretchX = 1.0f;
    public float stretchY = 1.0f;
    public float stretchZ = 1.0f;
    public float prevStretchX = 1.0f;
    public float prevStretchY = 1.0f;
    public float prevStretchZ = 1.0f;
    public float burn = 0.0f;
    public float prevBurn = 0.0f;
    public float red = 1.0f;
    public float green = 1.0f;
    public float blue = 1.0f;
    public float prevRed = 1.0f;
    public float prevGreen = 1.0f;
    public float prevBlue = 1.0f;
    public float renderPosX;
    public float renderPosY;
    public float renderPosZ;
    public float renderTextureSize;
    public float distanceSq;
    public static final int FULL_BRIGHTNESS = 0xF000F0;
    private static lnuq tempBlockLocation = new lnuq();

    public ncyh(tvlv tvlv2, float f, float f2, ejcz ejcz2) {
        this.parent = tvlv2;
        this.boundingBox = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.setCollisionSize(f);
        this.textureSize = f2;
        this.icon = ejcz2;
    }

    public void tick() {
        ++this.ticksExisted;
        this.prevAlpha = this.alpha;
        this.prevBurn = this.burn;
        this.prevTextureSize = this.textureSize;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevStretchX = this.stretchX;
        this.prevStretchY = this.stretchY;
        this.prevStretchZ = this.stretchZ;
        this.prevRotation = this.rotation;
        this.motionX *= this.speedFactor;
        this.motionY *= this.speedFactor;
        this.motionZ *= this.speedFactor;
        this.rotation += this.rotationSpeed;
        this.move(this.motionX, this.motionY, this.motionZ);
    }

    public void move(double d, double d2, double d3) {
        if (this.clip) {
            this.clippedMove(this.motionX, this.motionY, this.motionZ);
        } else {
            this.simpleMove(this.motionX, this.motionY, this.motionZ);
        }
        this.updateBounds();
    }

    public void setCollisionSize(float f) {
        if (f != this.collisionSize) {
            this.collisionSize = f;
            this.boundingBox._e = this.boundingBox._b + (double)this.collisionSize;
            this.boundingBox._g = this.boundingBox._d + (double)this.collisionSize;
            this.boundingBox._f = this.boundingBox._c + (double)this.collisionSize;
            this.halfCollisionSize = this.collisionSize / 2.0f;
        }
    }

    public float getAlphaForRender(float f) {
        return this.prevAlpha + (this.alpha - this.prevAlpha) * f;
    }

    public void setPosition(double d, double d2, double d3) {
        this.prevPosX = this.posX = d;
        this.prevPosY = this.posY = d2;
        this.prevPosZ = this.posZ = d3;
        this.updateBounds();
    }

    public void setPosition(ofbx ofbx2) {
        this.setPosition(ofbx2._c, ofbx2._d, ofbx2._e);
    }

    public void moveTo(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
        this.updateBounds();
    }

    protected void simpleMove(double d, double d2, double d3) {
        this.posX += d;
        this.posY += d2;
        this.posZ += d3;
    }

    protected void updateBounds() {
        this.boundingBox._b(this.posX - (double)this.halfCollisionSize, this.posY - (double)this.halfCollisionSize, this.posZ - (double)this.halfCollisionSize, this.posX + (double)this.halfCollisionSize, this.posY + (double)this.halfCollisionSize, this.posZ + (double)this.halfCollisionSize);
    }

    protected void clippedMove(double d, double d2, double d3) {
        int n;
        double d4 = this.posX;
        double d5 = this.posY;
        double d6 = this.posZ;
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        eidj eidj2 = this.boundingBox._c();
        List<eidj> list = this.parent.getCollidingBoundingBoxes(this.boundingBox._a(d, d2, d3));
        for (n = 0; n < list.size(); ++n) {
            d2 = list.get(n)._b(this.boundingBox, d2);
        }
        this.boundingBox._d(0.0, d2, 0.0);
        for (n = 0; n < list.size(); ++n) {
            d = list.get(n)._a(this.boundingBox, d);
        }
        this.boundingBox._d(d, 0.0, 0.0);
        for (n = 0; n < list.size(); ++n) {
            d3 = list.get(n)._c(this.boundingBox, d3);
        }
        this.boundingBox._d(0.0, 0.0, d3);
        this.posX = (float)((this.boundingBox._b + this.boundingBox._e) / 2.0);
        this.posY = (float)(this.boundingBox._c + (double)this.collisionSize / 2.0);
        this.posZ = (float)((this.boundingBox._d + this.boundingBox._g) / 2.0);
        this.onGround = d8 != d2 && d8 < 0.0;
        this.isCollided = false;
        if (d7 != d) {
            this.motionX = 0.0f;
            this.isCollided = true;
        }
        if (d8 != d2) {
            this.motionY = 0.0f;
            this.isCollided = true;
        }
        if (d9 != d3) {
            this.motionZ = 0.0f;
            this.isCollided = true;
        }
    }

    public void writeBrightness(FloatBuffer floatBuffer) {
        double d = gqqu._d + (double)this.renderPosX;
        double d2 = gqqu._e + (double)this.renderPosY;
        double d3 = gqqu._f + (double)this.renderPosZ;
        this.writeBrightness(floatBuffer, d, d2, d3);
    }

    public void writeBrightness(FloatBuffer floatBuffer, double d, double d2, double d3) {
        ncyh.tempBlockLocation._a = sajh._c(d);
        ncyh.tempBlockLocation._b = sajh._c(d2);
        ncyh.tempBlockLocation._c = sajh._c(d3);
        if (this.parent.blockBrightnessCache.containsKey(tempBlockLocation)) {
            floatBuffer.put(this.parent.blockBrightnessCache.get(tempBlockLocation));
        } else {
            int n = this.getBrightness(ncyh.tempBlockLocation._a, ncyh.tempBlockLocation._b, ncyh.tempBlockLocation._c);
            int n2 = xpzm._E()._D.field_78504_Q[n / 65536 + n % 65536 / 16];
            float[] fArray = new float[]{(float)(n2 >> 16 & 0xFF) / 255.0f, (float)(n2 >> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f};
            this.parent.blockBrightnessCache.put(tempBlockLocation._a(), fArray);
            floatBuffer.put(fArray);
        }
    }

    public int getBrightness() {
        int n = sajh._c(gqqu._d + (double)this.renderPosX);
        int n2 = sajh._c(gqqu._e + (double)this.renderPosY);
        int n3 = sajh._c(gqqu._f + (double)this.renderPosZ);
        return this.getBrightness(n, n2, n3);
    }

    public int getBrightness(int n, int n2, int n3) {
        return this.parent.world.func_72802_i(n, n2, n3, 0);
    }

    public ejcz getIcon(int n) {
        return this.icon;
    }

    public boolean shouldRenderInPass(int n) {
        return n == 0;
    }

    public void updateDistance() {
        this.distanceSq = this.renderPosX * this.renderPosX + this.renderPosY * this.renderPosY + this.renderPosZ * this.renderPosZ;
    }

    public tvlv getParent() {
        return this.parent;
    }
}

