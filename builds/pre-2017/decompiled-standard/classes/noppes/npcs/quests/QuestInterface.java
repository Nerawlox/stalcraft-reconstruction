/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;

public abstract class QuestInterface {
    public int questId;

    public abstract void writeEntityToNBT(qoac var1);

    public abstract void readEntityFromNBT(qoac var1);

    public abstract boolean isCompleted(EntityPlayer var1);

    public abstract void handleComplete(EntityPlayer var1);

    public abstract Vector getQuestLogStatus(EntityPlayer var1);
}

