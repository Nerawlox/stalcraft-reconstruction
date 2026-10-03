/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.ICompatibilty;
import noppes.npcs.VersionCompatibility;
import noppes.npcs.constants.EnumDialogRepeat;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.controllers.Availability;
import noppes.npcs.controllers.DialogCategory;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.FactionOptions;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDialogData;
import noppes.npcs.controllers.PlayerMail;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestController;

public class Dialog
implements ICompatibilty {
    public int version = VersionCompatibility.ModRev;
    public int id = -1;
    public String title = "";
    public String statusTitle = "";
    public String text = "";
    public boolean impersonal = false;
    public int quest = -1;
    public DialogCategory category;
    public HashMap<Integer, DialogOption> options = new HashMap();
    public Availability availability = new Availability();
    public FactionOptions factionOptions = new FactionOptions();
    public String sound;
    public String command = "";
    public PlayerMail mail = new PlayerMail();
    public EnumDialogRepeat repeat = EnumDialogRepeat.Repeatable;
    public boolean markedUnused;

    public boolean hasDialogs(EntityPlayer entityPlayer) {
        DialogOption dialogOption;
        Iterator<DialogOption> iterator2 = this.options.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((dialogOption = iterator2.next()) == null || dialogOption.optionType != EnumOptionType.DialogOption || !dialogOption.hasDialog() || !dialogOption.isAvailable(entityPlayer));
        return true;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.version = nBTTagCompound._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, nBTTagCompound);
        this.id = nBTTagCompound._f("DialogId");
        this.title = nBTTagCompound._j("DialogTitle");
        this.text = nBTTagCompound._j("DialogText");
        this.quest = nBTTagCompound._f("DialogQuest");
        this.sound = nBTTagCompound._j("DialogSound");
        this.command = nBTTagCompound._j("DialogCommand");
        this.mail.readNBT(nBTTagCompound._m("DialogMail"));
        this.repeat = EnumDialogRepeat.values()[nBTTagCompound._c("repeat") ? nBTTagCompound._f("repeat") : 1];
        NBTTagList nBTTagList = nBTTagCompound._n("Options");
        HashMap<Integer, DialogOption> hashMap = new HashMap<Integer, DialogOption>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f("OptionSlot");
            DialogOption dialogOption = new DialogOption();
            dialogOption.readNBT(nBTTagCompound2._m("Option"));
            hashMap.put(n, dialogOption);
        }
        this.options = hashMap;
        this.availability.readFromNBT(nBTTagCompound);
        this.factionOptions.readFromNBT(nBTTagCompound);
        this.statusTitle = nBTTagCompound._j("statusTitle");
        this.markedUnused = nBTTagCompound._o("unused");
        this.impersonal = nBTTagCompound._o("impersonal");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("ModRev", this.version);
        nBTTagCompound._a("DialogId", this.id);
        nBTTagCompound._a("DialogTitle", this.title);
        nBTTagCompound._a("DialogText", this.text);
        nBTTagCompound._a("DialogQuest", this.quest);
        nBTTagCompound._a("DialogCommand", this.command);
        nBTTagCompound._a("DialogMail", this.mail.writeNBT());
        nBTTagCompound._a("repeat", this.repeat.ordinal());
        if (this.sound != null && !this.sound.isEmpty()) {
            nBTTagCompound._a("DialogSound", this.sound);
        }
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this.options.keySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("OptionSlot", n);
            nBTTagCompound2._a("Option", (NBTBase)this.options.get(n).writeNBT());
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Options", nBTTagList);
        this.availability.writeToNBT(nBTTagCompound);
        this.factionOptions.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("statusTitle", this.statusTitle);
        nBTTagCompound._a("unused", this.markedUnused);
        nBTTagCompound._a("impersonal", this.impersonal);
        return nBTTagCompound;
    }

    public boolean hasQuest() {
        return this.getQuest() != null;
    }

    public Quest getQuest() {
        return QuestController.instance.quests.get(this.quest);
    }

    public boolean hasOtherOptions() {
        DialogOption dialogOption;
        Iterator<DialogOption> iterator2 = this.options.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while ((dialogOption = iterator2.next()) == null || dialogOption.optionType == EnumOptionType.Disabled);
        return true;
    }

    public boolean isAvailable(EntityPlayer entityPlayer) {
        boolean bl;
        PlayerDialogData playerDialogData = PlayerData.getData((EntityPlayer)entityPlayer).dialogData;
        boolean bl2 = playerDialogData.lastRead.containsKey(this.id);
        boolean bl3 = bl = this.repeat == EnumDialogRepeat.Repeatable || !bl2;
        if (bl2 && !bl) {
            long l = System.currentTimeMillis();
            long l2 = playerDialogData.lastRead.get(this.id);
            bl = this.repeat == EnumDialogRepeat.Daily && l - l2 > TimeUnit.DAYS.toMillis(1L) || this.repeat == EnumDialogRepeat.Weekly && l - l2 > TimeUnit.DAYS.toMillis(7L) || this.repeat == EnumDialogRepeat.NextDay && !bqgh._a(6, l, l2) || this.repeat == EnumDialogRepeat.NextWeek && !bqgh._a(3, l, l2);
        }
        return bl && this.availability.isAvailable(entityPlayer);
    }

    public Dialog copy(EntityPlayer entityPlayer) {
        Dialog dialog = new Dialog();
        dialog.id = this.id;
        dialog.text = this.text;
        dialog.statusTitle = this.statusTitle;
        dialog.title = this.title;
        dialog.category = this.category;
        dialog.quest = this.quest;
        dialog.sound = this.sound;
        dialog.mail = this.mail;
        dialog.command = this.command;
        dialog.impersonal = this.impersonal;
        for (int n : this.options.keySet()) {
            DialogOption dialogOption = this.options.get(n);
            if (dialogOption.optionType == EnumOptionType.DialogOption && (!dialogOption.hasDialog() || !dialogOption.isAvailable(entityPlayer))) continue;
            dialog.options.put(n, dialogOption);
        }
        return dialog;
    }

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(int n) {
        this.version = n;
    }
}

