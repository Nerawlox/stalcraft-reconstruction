/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.ArrayList;
import java.util.List;

public class iekw
extends tvlv {
    public Object particleSource;
    public double centerX;
    public double centerY;
    public double centerZ;
    public double renderDistanceSq;
    public double lastDistanceSq;
    protected net.minecraft.util.eidj boundingBox;
    private List<net.minecraft.util.eidj> collidingBoundingBoxes;
    private List<net.minecraft.util.eidj> tempList;
    public boolean isValid;

    public iekw(ozlu ozlu2, Object object) {
        super(ozlu2);
        this.renderDistanceSq = eidj._a._j;
        this.boundingBox = net.minecraft.util.eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.collidingBoundingBoxes = new ArrayList<net.minecraft.util.eidj>();
        this.tempList = new ArrayList<net.minecraft.util.eidj>();
        this.isValid = true;
        this.particleSource = object;
    }

    public void updateDistance(double d, double d2, double d3) {
        double d4 = this.centerX - d;
        double d5 = this.centerY - d2;
        double d6 = this.centerZ - d3;
        this.lastDistanceSq = d4 * d4 + d5 * d5 + d6 * d6;
    }

    protected void setCenter(double d, double d2, double d3) {
        this.centerX = d;
        this.centerY = d2;
        this.centerZ = d3;
    }

    protected void setSize(double d, double d2, double d3) {
        this.setBoundingBox(this.centerX - d, this.centerY - d2, this.centerZ - d, this.centerX + d, this.centerY + d3, this.centerZ + d);
    }

    protected void setBoundingBox(double d, double d2, double d3, double d4, double d5, double d6) {
        this.boundingBox._b(d, d2, d3, d4, d5, d6);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public net.minecraft.util.eidj getBoundingBox() {
        return this.boundingBox;
    }

    public boolean ignoreFrustrumRenderCheck() {
        return false;
    }

    public boolean ignoreFrustrumTickCheck() {
        return false;
    }

    @Override
    public List<net.minecraft.util.eidj> getCollidingBoundingBoxes(net.minecraft.util.eidj eidj2) {
        this.tempList.clear();
        for (net.minecraft.util.eidj eidj3 : this.collidingBoundingBoxes) {
            if (!eidj2._b(eidj3)) continue;
            this.tempList.add(eidj3);
        }
        return this.tempList;
    }

    @Override
    protected void updateParticleRenderPos(ncyh ncyh2, float f) {
        ncyh2.renderPosX = (float)(ncyh2.prevPosX + (ncyh2.posX - ncyh2.prevPosX) * (double)f - gqqu._d);
        ncyh2.renderPosY = (float)(ncyh2.prevPosY + (ncyh2.posY - ncyh2.prevPosY) * (double)f - gqqu._e);
        ncyh2.renderPosZ = (float)(ncyh2.prevPosZ + (ncyh2.posZ - ncyh2.prevPosZ) * (double)f - gqqu._f);
        ncyh2.renderTextureSize = ncyh2.prevTextureSize + (ncyh2.textureSize - ncyh2.prevTextureSize) * f;
        ncyh2.updateDistance();
    }
}

