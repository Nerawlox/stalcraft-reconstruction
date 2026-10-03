/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import noppes.npcs.EntityNPCInterface;

public class EntityAIOccupyBed
extends zwat {
    private final EntityNPCInterface npc;
    private int maxSleepingTicks = 0;
    private int bedX = 0;
    private int bedY = 0;
    private int bedZ = 0;

    public EntityAIOccupyBed(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.func_75248_a(5);
    }

    @Override
    public boolean func_75250_a() {
        return !this.npc.isSleeping() && this.getNearbyBedDistance() && !this.npc.field_70170_p.func_72935_r();
    }

    @Override
    public boolean func_75253_b() {
        return !this.npc.field_70170_p.func_72935_r() && this.isSittableBlock(this.npc.field_70170_p, this.bedX, this.bedY, this.bedZ);
    }

    @Override
    public void func_75249_e() {
        this.npc.func_70661_as()._a((double)this.bedX + 0.5, this.bedY + 1, (double)this.bedZ + 0.5, 1.0);
        this.npc.setSleeping(false);
    }

    @Override
    public void func_75251_c() {
        this.npc.setSleeping(false);
        this.occupyBed(this.npc.field_70170_p, this.bedX, this.bedY, this.bedZ, false);
    }

    @Override
    public void func_75246_d() {
        if (this.npc.func_70092_e(this.bedX, this.bedY + 1, this.bedZ) > 1.5) {
            this.npc.setSleeping(false);
            this.npc.func_70661_as()._a(this.bedX, this.bedY + 1, this.bedZ, 1.0);
        } else if (!this.npc.isSleeping()) {
            this.npc.field_70760_ar = this.npc.field_70761_aq = (float)this.getDirection(this.npc.field_70170_p, this.bedX, this.bedY, this.bedZ);
            this.npc.field_70177_z = this.npc.field_70761_aq;
            this.npc.field_70126_B = this.npc.field_70761_aq;
            this.npc.setSleeping(true);
            this.occupyBed(this.npc.field_70170_p, this.bedX, this.bedY, this.bedZ, true);
        }
    }

    protected boolean getNearbyBedDistance() {
        int n = (int)this.npc.field_70163_u;
        double d = 2.147483647E9;
        int n2 = (int)this.npc.field_70165_t - 8;
        while ((double)n2 < this.npc.field_70165_t + 8.0) {
            int n3 = (int)this.npc.field_70161_v - 8;
            while ((double)n3 < this.npc.field_70161_v + 8.0) {
                double d2;
                if (this.isSittableBlock(this.npc.field_70170_p, n2, n, n3) && this.npc.field_70170_p.func_72799_c(n2, n + 1, n3) && (d2 = this.npc.func_70092_e(n2, n, n3)) < d) {
                    this.bedX = n2;
                    this.bedY = n;
                    this.bedZ = n3;
                    d = d2;
                }
                ++n3;
            }
            ++n2;
        }
        return d < 2.147483647E9;
    }

    protected boolean isSittableBlock(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        return n4 == twgu.field_71959_S.field_71990_ca && !gqbt._a(n5);
    }

    protected int getDirection(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = -1;
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        int n6 = gqbt._d(n5);
        switch (n6) {
            case 0: {
                n4 = 180;
                break;
            }
            case 1: {
                n4 = 270;
                break;
            }
            case 2: {
                n4 = 0;
                break;
            }
            case 3: {
                n4 = 90;
            }
        }
        return n4;
    }

    protected void occupyBed(ozlu ozlu2, int n, int n2, int n3, boolean bl) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        if (n4 == twgu.field_71959_S.field_71990_ca) {
            gqbt._a(ozlu2, n, n2, n3, bl);
        }
    }
}

