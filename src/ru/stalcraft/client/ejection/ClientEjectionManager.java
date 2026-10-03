/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.ejection;

import ru.stalcraft.client.ejection.ClientEjection;
import ru.stalcraft.ejection.Ejection;
import ru.stalcraft.ejection.IEjectionManager;

public final class ClientEjectionManager
implements IEjectionManager {
    private ClientEjection ejection = null;
    private int lastEjectionId = -1;
    private int lastLightning = 0;
    private float xMaxTranslate = 0.0f;
    private float zMaxTranslate = 0.0f;
    private float amplitude = 0.0f;
    private boolean checkEjection;
    public atv mc = atv.w();
    public float translateY;
    public float prevTranslateY;
    public float translateX;
    public float translateZ;
    public float prevTranslateX;
    public float prevTranslateZ;

    @Override
    public void tick() {
        this.amplitude = 0.25f;
        this.xMaxTranslate = (float)Math.random() / 1.5f;
        this.zMaxTranslate = (float)Math.random() / 1.5f;
        if (this.mc.f.q == 2) {
            this.lastLightning = 0;
            this.xMaxTranslate = (float)Math.random() / 2.0f;
            this.zMaxTranslate = (float)Math.random() / 2.0f;
            this.amplitude = 0.11f;
        }
        ++this.lastLightning;
        this.amplitude = (float)((double)this.amplitude * 0.97);
        this.prevTranslateY = this.translateY;
        this.prevTranslateX = this.translateX;
        this.prevTranslateZ = this.translateZ;
        this.translateY = this.amplitude * (float)(this.lastLightning % 4 < 2 ? 1 : -1);
        this.translateX = this.amplitude * this.xMaxTranslate * (float)(this.lastLightning % 4 < 2 ? 1 : -1);
        this.translateZ = this.amplitude * this.zMaxTranslate * (float)(this.lastLightning % 4 < 2 ? 1 : -1);
        if (this.ejection != null) {
            this.ejection.tick();
        }
    }

    @Override
    public int getLastEjectionId() {
        return this.lastEjectionId;
    }

    @Override
    public boolean hasEjection() {
        return this.ejection != null;
    }

    @Override
    public Ejection getEjection() {
        return this.ejection;
    }

    @Override
    public void setEjection(Ejection par1) {
        this.ejection = (ClientEjection)par1;
    }

    @Override
    public void setLastEjectionId(int par1) {
        this.lastEjectionId = par1;
    }
}

