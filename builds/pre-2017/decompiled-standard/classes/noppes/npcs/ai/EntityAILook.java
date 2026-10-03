/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumStandingType;

public class EntityAILook
extends zwat {
    private final EntityNPCInterface npc;
    boolean rotatebody;
    private int idle = 0;
    private double lookX;
    private double lookZ;

    public EntityAILook(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        return !this.npc.isAttacking() && this.npc.func_70661_as()._g() && !this.npc.func_70608_bn() && !this.npc.isKilled();
    }

    @Override
    public void func_75249_e() {
        this.rotatebody = this.npc.aiData.standingType == EnumStandingType.RotateBody || this.npc.aiData.standingType == EnumStandingType.HeadRotation;
    }

    @Override
    public void func_75251_c() {
        this.rotatebody = false;
    }

    @Override
    public void func_75246_d() {
        if (this.npc.aiData.standingType == EnumStandingType.Stalking) {
            EntityPlayer entityPlayer = this.npc.field_70170_p.func_72890_a(this.npc, 16.0);
            if (entityPlayer == null) {
                this.rotatebody = true;
            } else {
                this.npc.func_70671_ap()._a(entityPlayer, 10.0f, (float)this.npc.func_70646_bf());
            }
        }
        if (this.rotatebody) {
            if (this.idle == 0 && this.npc.func_70681_au().nextFloat() < 0.02f) {
                double d = Math.PI * 2 * this.npc.func_70681_au().nextDouble();
                if (this.npc.aiData.standingType == EnumStandingType.HeadRotation) {
                    d = Math.PI / 180 * (double)this.npc.aiData.orientation + 0.6283185307179586 + 1.8849555921538759 * this.npc.func_70681_au().nextDouble();
                }
                this.lookX = Math.cos(d);
                this.lookZ = Math.sin(d);
                this.idle = 20 + this.npc.func_70681_au().nextInt(20);
            }
            if (this.idle > 0) {
                --this.idle;
                this.npc.func_70671_ap()._a(this.npc.field_70165_t + this.lookX, this.npc.field_70163_u + (double)this.npc.func_70047_e(), this.npc.field_70161_v + this.lookZ, 10.0f, this.npc.func_70646_bf());
            }
        }
        if (this.npc.aiData.standingType == EnumStandingType.NoRotation) {
            this.npc.field_70177_z = this.npc.field_70761_aq = (float)this.npc.aiData.orientation;
            this.npc.field_70759_as = this.npc.field_70761_aq;
        }
    }
}

