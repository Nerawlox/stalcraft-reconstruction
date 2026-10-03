/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mt
 *  org.lwjgl.util.vector.Matrix3f
 *  org.lwjgl.util.vector.Vector3f
 */
package ru.stalcraft.client.particles;

import java.util.Random;
import org.lwjgl.util.vector.Matrix3f;
import org.lwjgl.util.vector.Vector3f;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.effects.particles.ParticleIcon;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.particles.ShotLightParticle;
import ru.stalcraft.client.particles.ShotSmokeParticle;
import ru.stalcraft.entity.EntityShot;

public class ShotParticleEmitter
extends ParticleEmitter {
    private static ParticleIcon lightIcon;
    private static ParticleIcon[] smokeIcons;

    public ShotParticleEmitter(EntityShot entity) {
        super(entity);
        float particle;
        float rotationMatrix;
        float pitch;
        int i2;
        super.setCenter(entity.u, entity.v - 0.15, entity.w);
        super.setSize(-2.0, -2.0, -2.0, 2.0, 2.0, 2.0);
        float distance = entity.distance;
        Random rand = entity.q.s;
        float s2 = entity.size / 2.0f;
        ShotLightParticle shotLightParticle = null;
        ShotSmokeParticle shotSmokeParticle = null;
        for (i2 = 0; i2 < 5; ++i2) {
            shotLightParticle = new ShotLightParticle(this, lightIcon);
            pitch = rand.nextFloat() * 0.9f * s2;
            rotationMatrix = entity.A + (rand.nextFloat() - 0.5f) * 10.0f;
            particle = entity.B + (rand.nextFloat() - 0.5f) * 10.0f;
            shotLightParticle.motionX = -ls.a(rotationMatrix / 180.0f * (float)Math.PI) * ls.b(particle / 180.0f * (float)Math.PI) * pitch;
            shotLightParticle.motionZ = ls.b(rotationMatrix / 180.0f * (float)Math.PI) * ls.b(particle / 180.0f * (float)Math.PI) * pitch;
            shotLightParticle.motionY = -ls.a(particle / 180.0f * (float)Math.PI) * pitch;
            shotLightParticle.setPosition(shotLightParticle.posX + (double)shotLightParticle.motionX * 0.04, shotLightParticle.posY + (double)shotLightParticle.motionY * 0.04, shotLightParticle.posZ + (double)shotLightParticle.motionZ * 0.04);
            shotLightParticle.textureSize *= s2;
            shotLightParticle.textureSize *= 2.0f;
            this.particles.add(shotLightParticle);
        }
        for (i2 = 0; i2 < 10; ++i2) {
            shotSmokeParticle = new ShotSmokeParticle(this, smokeIcons[rand.nextInt(smokeIcons.length)]);
            pitch = rand.nextFloat() * 0.9f * s2;
            rotationMatrix = entity.A + (rand.nextFloat() - 0.5f) * 10.0f;
            particle = entity.B + (rand.nextFloat() - 0.5f) * 10.0f;
            shotSmokeParticle.motionX = -ls.a(rotationMatrix / 180.0f * (float)Math.PI) * ls.b(particle / 180.0f * (float)Math.PI) * pitch;
            shotSmokeParticle.motionZ = ls.b(rotationMatrix / 180.0f * (float)Math.PI) * ls.b(particle / 180.0f * (float)Math.PI) * pitch;
            shotSmokeParticle.motionY = -ls.a(particle / 180.0f * (float)Math.PI) * pitch;
            shotSmokeParticle.setPosition(shotSmokeParticle.posX + (double)shotSmokeParticle.motionX * 0.04, shotSmokeParticle.posY + (double)shotSmokeParticle.motionY * 0.04, shotSmokeParticle.posZ + (double)shotSmokeParticle.motionZ * 0.04);
            shotSmokeParticle.textureSize *= s2;
            this.particles.add(shotSmokeParticle);
        }
        float speed = 0.0f;
        float angle = 0.0f;
        float cos = 0.0f;
        float sin = 0.0f;
        float var16 = 0.0f;
        Matrix3f var17 = null;
        Vector3f vec1 = null;
        float vec = 0.0f;
        for (i2 = 0; i2 < 50; ++i2) {
            var16 = entity.A + (rand.nextFloat() - 0.5f) * 10.0f;
            pitch = entity.B + (rand.nextFloat() - 0.5f) * 10.0f;
            var17 = Matrix3f.mul((Matrix3f)EffectsEngine.rotationMatrix(var16, 0.0f, 1.0f, 0.0f), (Matrix3f)EffectsEngine.rotationMatrix(-pitch, 1.0f, 0.0f, 0.0f), (Matrix3f)null);
            shotLightParticle = new ShotLightParticle(this, lightIcon);
            shotLightParticle.textureSize = 0.4f;
            speed = rand.nextFloat();
            angle = (1.0f - speed * speed) * 0.5f * s2;
            cos = rand.nextFloat() * 2.0f * (float)Math.PI;
            sin = ls.b(cos);
            vec = ls.a(cos);
            vec1 = Matrix3f.transform((Matrix3f)var17, (Vector3f)new Vector3f(vec * angle, sin * angle, 0.0f), (Vector3f)null);
            shotLightParticle.motionX = vec1.x;
            shotLightParticle.motionZ = vec1.z;
            shotLightParticle.motionY = vec1.y;
            shotLightParticle.motionX += -ls.a(var16 / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * angle * 0.35f;
            shotLightParticle.motionZ += ls.b(var16 / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * angle * 0.35f;
            shotLightParticle.motionY += -ls.a(pitch / 180.0f * (float)Math.PI) * angle * 0.35f;
            shotLightParticle.setPosition(shotLightParticle.posX + (double)shotLightParticle.motionX * 0.04, shotLightParticle.posY + (double)shotLightParticle.motionY * 0.04, shotLightParticle.posZ + (double)shotLightParticle.motionZ * 0.04);
            shotLightParticle.textureSize *= s2;
            this.particles.add(shotLightParticle);
        }
        for (i2 = 0; i2 < 25; ++i2) {
            var16 = entity.A + (rand.nextFloat() - 0.5f) * 10.0f;
            pitch = entity.B + (rand.nextFloat() - 0.5f) * 10.0f;
            var17 = Matrix3f.mul((Matrix3f)EffectsEngine.rotationMatrix(var16, 0.0f, 1.0f, 0.0f), (Matrix3f)EffectsEngine.rotationMatrix(-pitch, 1.0f, 0.0f, 0.0f), (Matrix3f)null);
            shotSmokeParticle = new ShotSmokeParticle(this, smokeIcons[rand.nextInt(smokeIcons.length)]);
            shotSmokeParticle.textureSize = 0.25f;
            speed = rand.nextFloat() * 0.5f * s2;
            angle = rand.nextFloat() * 2.0f * (float)Math.PI;
            cos = ls.b(angle);
            sin = ls.a(angle);
            Vector3f var20 = Matrix3f.transform((Matrix3f)var17, (Vector3f)new Vector3f(sin * speed, cos * speed, 0.0f), (Vector3f)null);
            shotSmokeParticle.motionX = var20.x;
            shotSmokeParticle.motionZ = var20.z;
            shotSmokeParticle.motionY = var20.y;
            shotSmokeParticle.motionX += -ls.a(var16 / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * speed * 0.35f;
            shotSmokeParticle.motionZ += ls.b(var16 / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * speed * 0.35f;
            shotSmokeParticle.motionY += -ls.a(pitch / 180.0f * (float)Math.PI) * speed * 0.35f;
            shotSmokeParticle.setPosition(shotSmokeParticle.posX + (double)shotSmokeParticle.motionX * 0.04, shotSmokeParticle.posY + (double)shotSmokeParticle.motionY * 0.04, shotSmokeParticle.posZ + (double)shotSmokeParticle.motionZ * 0.04);
            shotSmokeParticle.textureSize *= s2;
            this.particles.add(shotSmokeParticle);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.renderDistanceSq = GuiSettingsStalker.particleRenderDistance * GuiSettingsStalker.particleRenderDistance;
    }

    @Override
    public boolean isValid() {
        return !((nn)((Object)this.emmiter)).M;
    }

    public static void registerIcons(mt ir2) {
        lightIcon = (ParticleIcon)ir2.a("stalker:shotlight");
        smokeIcons = new ParticleIcon[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            ShotParticleEmitter.smokeIcons[i2] = (ParticleIcon)ir2.a("stalker:smoke/smoke" + (i2 + 1));
        }
    }
}

