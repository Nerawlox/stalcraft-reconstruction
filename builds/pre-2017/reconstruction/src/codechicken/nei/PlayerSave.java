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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class PlayerSave {
    public String username;
    private File saveFile;
    private NBTTagCompound nbt;
    public ItemStack[] creativeInv;
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
        this.nbt = new NBTTagCompound();
        try {
            if (!this.saveFile.exists()) {
                this.saveFile.createNewFile();
            }
            if (this.saveFile.length() > 0L) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.saveFile));
                this.nbt = (NBTTagCompound)NBTBase._a(dataInputStream);
                dataInputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.loadCreativeInv();
    }

    private void loadCreativeInv() {
        this.creativeInv = new ItemStack[54];
        NBTTagList nBTTagList = this.nbt._n("creativeitems");
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
                this.creativeInv[nBTTagCompound._d((String)"Slot") & 0xFF] = ItemStack._a(nBTTagCompound);
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
            NBTBase._a(this.nbt, dataOutputStream);
            dataOutputStream.close();
            this.isDirty = false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void saveCreativeInv() {
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.creativeInv.length; ++i) {
            if (this.creativeInv[i] == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)i);
            this.creativeInv[i]._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        this.nbt._a("creativeitems", nBTTagList);
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

    private NBTTagCompound getEnabledActions() {
        NBTTagCompound nBTTagCompound = this.nbt._m("enabledActions");
        if (!this.nbt._c("enabledActions")) {
            this.nbt._a("enabledActions", nBTTagCompound);
        }
        return nBTTagCompound;
    }

    public void enableAction(String string, boolean bl) {
        this.getEnabledActions()._a(string, bl);
        NEISPH.sendActionEnabled(ServerUtils.getPlayer(this.username), string, bl);
        this.setDirty();
    }
}

