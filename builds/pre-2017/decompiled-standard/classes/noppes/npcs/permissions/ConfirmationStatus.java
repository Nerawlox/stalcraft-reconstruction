/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.permissions;

import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.permissions.CustomNpcsPermissions;

public class ConfirmationStatus {
    private String creator = "";
    private String currentOwner = "";
    private String approver = "";

    public void writeToNBT(qoac qoac2) {
        qoac2._a("creator", this.creator);
        qoac2._a("current_owner", this.currentOwner);
        qoac2._a("approver", this.approver);
    }

    public void readFromNBT(qoac qoac2) {
        if (qoac2._c("owner")) {
            String string = qoac2._j("owner");
            if (string.isEmpty()) {
                this.currentOwner = "old_confirmed";
                this.creator = "old_confirmed";
            } else if ("Helper".equalsIgnoreCase(string) || "Myzikant".equalsIgnoreCase(string)) {
                this.creator = this.currentOwner = "old_" + string;
                this.approver = string;
            } else {
                this.creator = this.currentOwner = string;
            }
        } else if (qoac2._c("confirmed")) {
            this.creator = "old_confirmed";
        } else if (!qoac2._c("creator")) {
            this.creator = "unknown";
        } else {
            this.creator = qoac2._j("creator");
            this.currentOwner = qoac2._j("current_owner");
            this.approver = qoac2._j("approver");
        }
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String string) {
        this.creator = string;
    }

    public String getCurrentOwner() {
        return this.currentOwner;
    }

    public void setCurrentOwner(String string) {
        this.currentOwner = string;
    }

    public String getApprover() {
        return this.approver;
    }

    public void setApprover(String string) {
        this.approver = string;
    }

    public void onCreation(EntityPlayer entityPlayer) {
        this.creator = this.currentOwner = entityPlayer.field_71092_bJ;
        if (CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.approve")) {
            this.approver = entityPlayer.field_71092_bJ;
        }
    }

    public void setOwner(EntityPlayer entityPlayer, boolean bl) {
        if (!this.isFree() && !CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.approve")) {
            entityPlayer.func_71035_c("\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432 \u043d\u0430 \u043f\u0440\u0438\u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435 NPC");
        } else if (this.isApproved() && !this.approver.equalsIgnoreCase(entityPlayer.field_71092_bJ) && !CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.reapprove")) {
            entityPlayer.func_71035_c("\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432 \u043d\u0430 \u043f\u0435\u0440\u0435\u043f\u0440\u0438\u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435 NPC");
        } else {
            if (bl) {
                this.currentOwner = "";
                this.approver = "";
            } else {
                this.currentOwner = entityPlayer.field_71092_bJ;
            }
            entityPlayer.func_71035_c("\u0421\u0442\u0430\u0442\u0443\u0441 \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d");
        }
    }

    public void setApprove(EntityPlayer entityPlayer, boolean bl) {
        if (!CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.approve")) {
            entityPlayer.func_71035_c("\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432 \u043d\u0430 \u043f\u0440\u0438\u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435 NPC");
        } else if (this.isApproved() && !this.approver.equalsIgnoreCase(entityPlayer.field_71092_bJ) && !CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.reapprove")) {
            entityPlayer.func_71035_c("\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432 \u043d\u0430 \u043f\u0435\u0440\u0435\u043f\u0440\u0438\u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435 NPC");
        } else {
            this.approver = bl ? entityPlayer.field_71092_bJ : "";
            entityPlayer.func_71035_c("\u0421\u0442\u0430\u0442\u0443\u0441 \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d");
        }
    }

    public boolean canEdit(EntityPlayer entityPlayer) {
        boolean bl = CustomNpcsPermissions.Instance.hasPermission(entityPlayer.field_71092_bJ, "customnpcs.npc.approve");
        if (!entityPlayer.field_71092_bJ.equalsIgnoreCase(this.currentOwner)) {
            return false;
        }
        if (this.isApproved()) {
            return bl && entityPlayer.field_71092_bJ.equalsIgnoreCase(this.approver);
        }
        return true;
    }

    public boolean isApprovementBlockedFor(EntityPlayer entityPlayer) {
        return this.isApproved() && !this.approver.equalsIgnoreCase(entityPlayer.field_71092_bJ);
    }

    public void cloneFrom(ConfirmationStatus confirmationStatus) {
        qoac qoac2 = new qoac();
        confirmationStatus.writeToNBT(qoac2);
        this.readFromNBT(qoac2);
    }

    public boolean isApproved() {
        return !this.approver.isEmpty();
    }

    public boolean hasOwner() {
        return !this.currentOwner.isEmpty();
    }

    public boolean isFree() {
        return !this.isApproved() && !this.hasOwner();
    }

    public String getDesc() {
        if (this.isApproved()) {
            return "\u0423\u0442\u0432\u0435\u0440\u0434\u0438\u043b: " + this.approver;
        }
        if (this.hasOwner()) {
            return "\u0412\u043b\u0430\u0434\u0435\u0435\u0442: " + this.currentOwner;
        }
        return "\u0421\u0432\u043e\u0431\u043e\u0434\u043d\u043e";
    }
}

