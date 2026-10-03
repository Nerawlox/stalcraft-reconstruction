/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft.client.ejection;

import cpw.mods.fml.relauncher.ReflectionHelper;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ejection.ClientEjectionManager;
import ru.stalcraft.ejection.Ejection;

public class ClientEjection
extends Ejection {
    private String sound_id = null;
    private final ClientEjectionManager clientEjectionManager;
    public atv mc = atv.w();

    public ClientEjection(int id, int par2) {
        super(id, par2);
        this.clientEjectionManager = (ClientEjectionManager)StalkerMain.getProxy().getEjectionManager();
    }

    @Override
    public void tick() {
        super.tick();
        this.mc.u.l = false;
        float soundVolume = this.age >= 4000 && this.age < 8000 ? 1.0f : (this.age >= 8000 ? Math.max(0.0f, (float)(12000 - this.age) / 4000.0f) : Math.max(0.0f, (float)this.age / 4000.0f));
        this.mc.v.b.setVolume(this.sound_id, soundVolume * 0.25f * this.mc.u.b);
    }

    public float getColorWeight() {
        return this.age < 4000 ? (float)this.age / 4000.0f : (this.age > 8000 ? (float)(12000 - this.age) / 4000.0f : 1.0f);
    }

    public float[] getSkyColor() {
        int renderAge;
        if (this.age >= 4000 && this.age < 8000) {
            return new float[]{0.65f, 0.0f, 0.0f, 1.0f};
        }
        int n2 = renderAge = this.age > 4000 ? 12000 - this.age : this.age;
        if (renderAge < 2000) {
            float progress = (float)renderAge / 2000.0f;
            return new float[]{0.5f + 0.5f * progress, 0.5f - 0.15f * progress, 0.5f - 0.5f * progress, 1.0f};
        }
        float progress = (float)(renderAge - 2000) / 2000.0f;
        return new float[]{1.0f - 0.35f * progress, 0.35f - 0.35f * progress, 0.0f, 1.0f};
    }

    @Override
    public void start() {
        if (this.clientEjectionManager.hasEjection()) {
            this.clientEjectionManager.getEjection().end();
        }
        this.clientEjectionManager.setEjection(this);
        int latestSoundID = (Integer)ReflectionHelper.getPrivateValue(bln.class, (Object)this.mc.v, (String[])new String[]{"latestSoundID", "field_77378_e", "g"});
        this.sound_id = "sound_" + (latestSoundID + 1) % 256;
        this.mc.v.a("stalker:ejection", 0.01f, 1.0f);
        this.mc.v.b.setLooping(this.sound_id, true);
    }

    @Override
    public void end() {
        this.mc.u.l = true;
        this.clientEjectionManager.setLastEjectionId(this.id);
        this.clientEjectionManager.setEjection(null);
        this.mc.v.b.stop(this.sound_id);
    }
}

