/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;
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

    public void readNBT(qoac qoac2) {
        this.version = qoac2._f("ModRev");
        VersionCompatibility.CheckAvailabilityCompatibility(this, qoac2);
        this.id = qoac2._f("DialogId");
        this.title = qoac2._j("DialogTitle");
        this.text = qoac2._j("DialogText");
        this.quest = qoac2._f("DialogQuest");
        this.sound = qoac2._j("DialogSound");
        this.command = qoac2._j("DialogCommand");
        this.mail.readNBT(qoac2._m("DialogMail"));
        this.repeat = EnumDialogRepeat.values()[qoac2._c("repeat") ? qoac2._f("repeat") : 1];
        bsyv bsyv2 = qoac2._n("Options");
        HashMap<Integer, DialogOption> hashMap = new HashMap<Integer, DialogOption>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f("OptionSlot");
            DialogOption dialogOption = new DialogOption();
            dialogOption.readNBT(qoac3._m("Option"));
            hashMap.put(n, dialogOption);
        }
        this.options = hashMap;
        this.availability.readFromNBT(qoac2);
        this.factionOptions.readFromNBT(qoac2);
        this.statusTitle = qoac2._j("statusTitle");
        this.markedUnused = qoac2._o("unused");
        this.impersonal = qoac2._o("impersonal");
    }

    @Override
    public qoac writeToNBT(qoac qoac2) {
        qoac2._a("ModRev", this.version);
        qoac2._a("DialogId", this.id);
        qoac2._a("DialogTitle", this.title);
        qoac2._a("DialogText", this.text);
        qoac2._a("DialogQuest", this.quest);
        qoac2._a("DialogCommand", this.command);
        qoac2._a("DialogMail", this.mail.writeNBT());
        qoac2._a("repeat", this.repeat.ordinal());
        if (this.sound != null && !this.sound.isEmpty()) {
            qoac2._a("DialogSound", this.sound);
        }
        bsyv bsyv2 = new bsyv();
        for (int n : this.options.keySet()) {
            qoac qoac3 = new qoac();
            qoac3._a("OptionSlot", n);
            qoac3._a("Option", (huhy)this.options.get(n).writeNBT());
            bsyv2._a(qoac3);
        }
        qoac2._a("Options", bsyv2);
        this.availability.writeToNBT(qoac2);
        this.factionOptions.writeToNBT(qoac2);
        qoac2._a("statusTitle", this.statusTitle);
        qoac2._a("unused", this.markedUnused);
        qoac2._a("impersonal", this.impersonal);
        return qoac2;
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

