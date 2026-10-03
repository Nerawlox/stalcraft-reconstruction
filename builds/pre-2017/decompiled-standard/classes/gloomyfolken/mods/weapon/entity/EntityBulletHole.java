/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;

@ezey(_a={eidj.CLIENT})
public class EntityBulletHole
extends Entity {
    public static final int LIFETIME = 200;
    protected static final float ENTITY_SIZE = 0.1f;
    public int sideHit = -1;
    public long lastRenderedFrame;
    public int atlasRow;
    public boolean isKnifeHole = false;

    public EntityBulletHole(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.1f, 0.1f);
    }

    public EntityBulletHole(ozlu ozlu2, double d, double d2, double d3, int n, int n2) {
        super(ozlu2);
        this.func_70107_b(d, d2, d3);
        this.sideHit = n;
        this.func_70105_a(0.6f, 0.6f);
        this.atlasRow = n2;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa >= 200 && piuf._c > this.lastRenderedFrame + 15L) {
            this.func_70106_y();
        }
    }

    @Override
    protected void func_70088_a() {
    }

    @Override
    protected void func_70037_a(qoac qoac2) {
        this.sideHit = qoac2._f("side_hit");
    }

    @Override
    protected void func_70014_b(qoac qoac2) {
        qoac2._a("side_hit", this.sideHit);
    }
}

