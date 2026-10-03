/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerDialogData;
import noppes.npcs.quests.QuestInterface;

public class QuestDialog
extends QuestInterface {
    public HashMap<Integer, Integer> dialogs = new HashMap();

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.dialogs = NBTTags.getIntegerIntegerMap(nBTTagCompound._n("QuestDialogs"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("QuestDialogs", NBTTags.nbtIntegerIntegerMap(this.dialogs));
    }

    @Override
    public boolean isCompleted(EntityPlayer entityPlayer) {
        PlayerDialogData playerDialogData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).dialogData;
        return this.dialogs.values().stream().allMatch(n -> playerDialogData.dialogsRead.contains(n));
    }

    @Override
    public void handleComplete(EntityPlayer entityPlayer) {
    }

    @Override
    public Vector getQuestLogStatus(EntityPlayer entityPlayer) {
        Vector<String> vector = new Vector<String>();
        Iterator<Integer> iterator2 = this.dialogs.values().iterator();
        PlayerDialogData playerDialogData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).dialogData;
        while (iterator2.hasNext()) {
            String string;
            int n = iterator2.next();
            Dialog dialog = DialogController.instance.dialogs.get(n);
            if (dialog == null) continue;
            String string2 = string = dialog.statusTitle.isEmpty() ? dialog.title : dialog.statusTitle;
            if (playerDialogData.dialogsRead.contains(n)) {
                string = string + " (\u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u043e)";
            }
            vector.add(string);
        }
        return vector;
    }
}

