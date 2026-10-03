/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.controllers.Dialog;

public class DialogCategory {
    public int id = -1;
    public String title = "";
    public HashMap<Integer, Dialog> dialogs = new HashMap();
    public boolean locked = false;
    public boolean markedUnused;

    public boolean hasAccess(EntityPlayer entityPlayer) {
        return !this.locked || ncwh._a(entityPlayer.field_71092_bJ);
    }

    public void readNBT(qoac qoac2) {
        this.id = qoac2._f("Slot");
        this.title = qoac2._j("Title");
        this.locked = qoac2._o("Locked");
        this.markedUnused = qoac2._o("unused");
        bsyv bsyv2 = qoac2._n("Dialogs");
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                Dialog dialog = new Dialog();
                dialog.category = this;
                dialog.readNBT((qoac)bsyv2._b(i));
                this.dialogs.put(dialog.id, dialog);
            }
        }
    }

    public qoac writeNBT(qoac qoac2) {
        qoac2._a("Slot", this.id);
        qoac2._a("Title", this.title);
        qoac2._a("Locked", this.locked);
        qoac2._a("unused", this.markedUnused);
        bsyv bsyv2 = new bsyv();
        for (Dialog dialog : this.dialogs.values()) {
            bsyv2._a(dialog.writeToNBT(new qoac()));
        }
        qoac2._a("Dialogs", bsyv2);
        return qoac2;
    }
}

