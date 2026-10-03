/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.Dialog;

public class DialogCategory {
    public int id = -1;
    public String title = "";
    public HashMap<Integer, Dialog> dialogs = new HashMap();
    public boolean locked = false;
    public boolean markedUnused;

    public boolean hasAccess(EntityPlayer entityPlayer) {
        return !this.locked || ncwh._a(entityPlayer.username);
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound._f("Slot");
        this.title = nBTTagCompound._j("Title");
        this.locked = nBTTagCompound._o("Locked");
        this.markedUnused = nBTTagCompound._o("unused");
        NBTTagList nBTTagList = nBTTagCompound._n("Dialogs");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                Dialog dialog = new Dialog();
                dialog.category = this;
                dialog.readNBT((NBTTagCompound)nBTTagList._b(i));
                this.dialogs.put(dialog.id, dialog);
            }
        }
    }

    public NBTTagCompound writeNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("Slot", this.id);
        nBTTagCompound._a("Title", this.title);
        nBTTagCompound._a("Locked", this.locked);
        nBTTagCompound._a("unused", this.markedUnused);
        NBTTagList nBTTagList = new NBTTagList();
        for (Dialog dialog : this.dialogs.values()) {
            nBTTagList._a(dialog.writeToNBT(new NBTTagCompound()));
        }
        nBTTagCompound._a("Dialogs", nBTTagList);
        return nBTTagCompound;
    }
}

