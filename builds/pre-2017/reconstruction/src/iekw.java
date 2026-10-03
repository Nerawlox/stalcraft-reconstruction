/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class iekw
extends tvlv {
    public Object particleSource;
    public double centerX;
    public double centerY;
    public double centerZ;
    public double renderDistanceSq;
    public double lastDistanceSq;
    protected AxisAlignedBB boundingBox;
    private List<AxisAlignedBB> collidingBoundingBoxes;
    private List<AxisAlignedBB> tempList;
    public boolean isValid;

    public iekw(World world, Object object) {
        super(world);
        this.renderDistanceSq = eidj._a._j;
        this.boundingBox = AxisAlignedBB._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.collidingBoundingBoxes = new ArrayList<AxisAlignedBB>();
        this.tempList = new ArrayList<AxisAlignedBB>();
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

    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    public boolean ignoreFrustrumRenderCheck() {
        return false;
    }

    public boolean ignoreFrustrumTickCheck() {
        return false;
    }

    @Override
    public List<AxisAlignedBB> getCollidingBoundingBoxes(AxisAlignedBB axisAlignedBB) {
        this.tempList.clear();
        for (AxisAlignedBB axisAlignedBB2 : this.collidingBoundingBoxes) {
            if (!axisAlignedBB._b(axisAlignedBB2)) continue;
            this.tempList.add(axisAlignedBB2);
        }
        return this.tempList;
    }

    @Override
    protected void updateParticleRenderPos(ncyh ncyh2, float f) {
        ncyh2.renderPosX = (float)(ncyh2.prevPosX + (ncyh2.posX - ncyh2.prevPosX) * (double)f - RenderManager._d);
        ncyh2.renderPosY = (float)(ncyh2.prevPosY + (ncyh2.posY - ncyh2.prevPosY) * (double)f - RenderManager._e);
        ncyh2.renderPosZ = (float)(ncyh2.prevPosZ + (ncyh2.posZ - ncyh2.prevPosZ) * (double)f - RenderManager._f);
        ncyh2.renderTextureSize = ncyh2.prevTextureSize + (ncyh2.textureSize - ncyh2.prevTextureSize) * f;
        ncyh2.updateDistance();
    }
}

