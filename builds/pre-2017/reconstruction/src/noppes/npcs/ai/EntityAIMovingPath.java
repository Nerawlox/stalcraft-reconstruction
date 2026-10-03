/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.ai;

import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumMovingType;

public class EntityAIMovingPath
extends EntityAIBase {
    private EntityNPCInterface npc;
    private int[] pos;

    public EntityAIMovingPath(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (!(this.npc.aiData.movingType != EnumMovingType.MovingPath || this.npc.isAttacking() || this.npc.getRNG().nextInt(40) != 0 && this.npc.aiData.movingPause)) {
            List list2 = this.npc.aiData.getMovingPath();
            if (list2.size() < 2) {
                return false;
            }
            this.npc.aiData.incrementMovingPath();
            this.pos = this.npc.aiData.getCurrentMovingPath();
            return true;
        }
        return false;
    }

    @Override
    public boolean continueExecuting() {
        if (this.npc.isAttacking()) {
            this.npc.aiData.decreaseMovingPath();
            return false;
        }
        return !this.npc.getNavigator()._g();
    }

    @Override
    public void startExecuting() {
        this.npc.getNavigator()._a((double)this.pos[0] + 0.5, this.pos[1], (double)this.pos[2] + 0.5, 1.0);
    }
}

