/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.ServerUtils;
import codechicken.nei.NEISPH;
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerSave {
    public String username;
    private File saveFile;
    private qoac nbt;
    public cvzo[] creativeInv;
    private boolean creativeInvDirty;
    private boolean isDirty;
    private boolean wasOp;

    public PlayerSave(String string, File file) {
        this.username = string;
        this.wasOp = ServerUtils.isPlayerOP(string);
        this.saveFile = new File(file, this.username + ".dat");
        if (!this.saveFile.getParentFile().exists()) {
            this.saveFile.getParentFile().mkdirs();
        }
        this.load();
    }

    private void load() {
        this.nbt = new qoac();
        try {
            if (!this.saveFile.exists()) {
                this.saveFile.createNewFile();
            }
            if (this.saveFile.length() > 0L) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.saveFile));
                this.nbt = (qoac)huhy._a(dataInputStream);
                dataInputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.loadCreativeInv();
    }

    private void loadCreativeInv() {
        this.creativeInv = new cvzo[54];
        bsyv bsyv2 = this.nbt._n("creativeitems");
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac2 = (qoac)bsyv2._b(i);
                this.creativeInv[qoac2._d((String)"Slot") & 0xFF] = cvzo._a(qoac2);
            }
        }
    }

    public void save() {
        boolean bl = FileWriteBlocker.getBlockFileWrite();
        if (bl) {
            return;
        }
        if (!this.isDirty) {
            return;
        }
        if (this.creativeInvDirty) {
            this.saveCreativeInv();
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.saveFile));
            huhy._a(this.nbt, dataOutputStream);
            dataOutputStream.close();
            this.isDirty = false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void saveCreativeInv() {
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this.creativeInv.length; ++i) {
            if (this.creativeInv[i] == null) continue;
            qoac qoac2 = new qoac();
            qoac2._a("Slot", (byte)i);
            this.creativeInv[i]._b(qoac2);
            bsyv2._a(qoac2);
        }
        this.nbt._a("creativeitems", bsyv2);
        this.creativeInvDirty = false;
    }

    public void setCreativeDirty() {
        this.isDirty = true;
        this.creativeInvDirty = true;
    }

    public void setDirty() {
        this.isDirty = true;
    }

    public void updateOpChange(EntityPlayerMP entityPlayerMP) {
        boolean bl = ServerUtils.isPlayerOP(this.username);
        if (bl != this.wasOp) {
            NEISPH.sendHasServerSideTo(entityPlayerMP);
            this.wasOp = bl;
        }
    }

    public boolean isActionEnabled(String string) {
        return this.getEnabledActions()._o(string);
    }

    private qoac getEnabledActions() {
        qoac qoac2 = this.nbt._m("enabledActions");
        if (!this.nbt._c("enabledActions")) {
            this.nbt._a("enabledActions", qoac2);
        }
        return qoac2;
    }

    public void enableAction(String string, boolean bl) {
        this.getEnabledActions()._a(string, bl);
        NEISPH.sendActionEnabled(ServerUtils.getPlayer(this.username), string, bl);
        this.setDirty();
    }
}

