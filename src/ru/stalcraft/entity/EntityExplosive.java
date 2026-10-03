/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 */
package ru.stalcraft.entity;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.items.ItemExplosive;

public class EntityExplosive
extends nn {
    private static final int SIDE_PLACED = 28;
    private static final int LIFETIME = 200;
    private static final int BLOCK_X = 29;
    private static final int BLOCK_Y = 30;
    private static final int BLOCK_Z = 31;
    private int prevBlockId;
    private int prevBlockMetadata;
    private int prevDownBlockMetadata;
    private boolean hasReadPrevValues = false;

    public EntityExplosive(abw par1World) {
        super(par1World);
        this.Z = true;
        this.a(0.001f, 0.001f);
        this.N = 0.0f;
        this.P = 0.007f;
        this.O = 0.001f;
        this.l = Double.MAX_VALUE;
        this.ah.a(28, new Integer(0));
        this.ah.a(29, new Integer(0));
        this.ah.a(30, new Integer(0));
        this.ah.a(31, new Integer(0));
    }

    @Override
    public void l_() {
        super.l_();
        if (!this.q.I) {
            int x2 = this.ah.c(29);
            int y2 = this.ah.c(30);
            int z2 = this.ah.c(31);
            int blockId = this.q.a(x2, y2, z2);
            int blockData = this.q.h(x2, y2, z2);
            int downBlockData = this.q.h(x2, y2 - 1, z2);
            if (!this.hasReadPrevValues) {
                this.hasReadPrevValues = true;
                this.prevBlockId = blockId;
                this.prevBlockMetadata = blockData;
                this.prevDownBlockMetadata = downBlockData;
            }
            if (blockId != this.prevBlockId || !ItemExplosive.isBlockExplosible(blockId)) {
                this.x();
                return;
            }
            this.prevBlockId = blockId;
            if (blockId == StalkerMain.stalkerDoor.cF && (blockData != this.prevBlockMetadata || downBlockData != this.prevDownBlockMetadata && this.q.a(x2, y2 - 1, z2) == StalkerMain.stalkerDoor.cF)) {
                this.doExplosion(x2, y2, z2);
            }
            this.prevBlockMetadata = blockData;
            this.prevDownBlockMetadata = downBlockData;
            if (this.ac >= 200) {
                this.doExplosion(x2, y2, z2);
            }
        }
    }

    private void doExplosion(int x2, int y2, int z2) {
        if (!this.M) {
            this.q.a(x2, y2, z2, false);
            this.q.a(this, this.u, this.v, this.w, 1.0f, false);
            this.x();
        }
    }

    public void applyAttributes(int sidePlaced, int blockX, int blockY, int blockZ) {
        this.ah.b(28, sidePlaced);
        this.ah.b(29, blockX);
        this.ah.b(30, blockY);
        this.ah.b(31, blockZ);
    }

    @Override
    protected void a() {
    }

    @Override
    protected void a(by tag) {
        this.applyAttributes(tag.e("sidePlaced"), tag.e("blockX"), tag.e("blockY"), tag.e("blockZ"));
    }

    @Override
    protected void b(by tag) {
        tag.a("sidePlaced", this.ah.c(28));
        tag.a("blockX", this.ah.c(29));
        tag.a("blockY", this.ah.c(30));
        tag.a("blockZ", this.ah.c(31));
    }

    public int getSidePlaced() {
        return this.ah.c(28);
    }

    @Override
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        this.b(par1, par3, par5);
        this.b(par7, par8);
    }

    @Override
    public boolean a(nb par1DamageSource, float par2) {
        if (this.ar()) {
            return false;
        }
        this.x();
        float f2 = 0.1f;
        ss entityitem = new ss(this.q, this.u, this.v, this.w, new ye(StalkerMain.explosive.cv, 1, 0));
        entityitem.g((this.ab.nextFloat() - 0.5f) * f2, this.ab.nextFloat() * f2 / 2.0f, (this.ab.nextFloat() - 0.5f) * f2);
        entityitem.b = 10;
        this.q.d(entityitem);
        return true;
    }
}

