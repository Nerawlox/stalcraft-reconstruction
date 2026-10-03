/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import java.util.stream.Stream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogNpcOptions;
import noppes.npcs.client.gui.GuiNPCFactionSetup;
import noppes.npcs.client.gui.GuiNPCSoundsMenu;
import noppes.npcs.client.gui.replica.GuiNpcReplicas;
import noppes.npcs.client.gui.roles.GuiNpcBard;
import noppes.npcs.client.gui.roles.GuiNpcBoss;
import noppes.npcs.client.gui.roles.GuiNpcConversation;
import noppes.npcs.client.gui.roles.GuiNpcGuard;
import noppes.npcs.client.gui.roles.GuiNpcHealer;
import noppes.npcs.client.gui.roles.GuiNpcSpawner;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumRoleType;

public class GuiNpcAdvanced
extends GuiNPCInterface2
implements IGuiData {
    private boolean hasChanges = false;
    protected boolean npcAccess = false;

    public GuiNpcAdvanced(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 4);
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.NpcAccess, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(3, this.guiLeft + 85 + 160, this.guiTop + 20, 52, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 85, this.guiTop + 20, 155, 20, (String[])Stream.of(EnumRoleType.values()).map(EnumRoleType::getTitle).toArray(String[]::new), this.npc.advanced.role.ordinal()));
        this.getButton((int)3).enabled = this.npc.advanced.role.isCustomizable();
        this.addButton(new GuiNpcButton(4, this.guiLeft + 85 + 160, this.guiTop + 43, 52, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 85, this.guiTop + 43, 155, 20, new String[]{"job.none", "job.bard", "job.healer", "job.guard", "job.itemgiver", "Boss(WIP)", "job.spawner", "job.conversation"}, this.npc.advanced.job.ordinal()));
        this.getButton((int)4).enabled = this.npc.advanced.job != EnumJobType.None;
        this.addButton(new GuiNpcButton(7, this.guiLeft + 85, this.guiTop + 66, 214, 20, "\u0420\u0435\u043f\u043b\u0438\u043a\u0438"));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 85, this.guiTop + 89, 214, 20, "menu.factions"));
        this.addButton(new GuiNpcButton(10, this.guiLeft + 85, this.guiTop + 112, 214, 20, "dialog.dialogs"));
        this.addButton(new GuiNpcButton(11, this.guiLeft + 85, this.guiTop + 135, 214, 20, "advanced.sounds"));
        if (!this.npcAccess) {
            this.disableAll(guiButton -> guiButton.id == 8 || guiButton.id == 5);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiButton.id == 3) {
            switch (this.npc.advanced.role) {
                case Trader: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupTrader);
                    break;
                }
                case Follower: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupFollower);
                    break;
                }
                case Bank: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupBank);
                    break;
                }
                case Transporter: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupTransporter);
                    break;
                }
                case Exchanger: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupExchanger);
                    break;
                }
                case Supplier: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupSupplier);
                    break;
                }
                case Workbench: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupWorkbench);
                    break;
                }
                case Guide: {
                    this.save();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupGuide);
                }
            }
        }
        if (guiButton.id == 8) {
            this.hasChanges = true;
            this.npc.advanced.setRole(guiNpcButton.getValue());
            boolean bl = this.getButton((int)3).enabled = this.npc.advanced.role != EnumRoleType.None && this.npc.advanced.role != EnumRoleType.Postman && this.npc.advanced.role != EnumRoleType.Auctioneer && this.npc.advanced.role != EnumRoleType.Researcher;
        }
        if (guiButton.id == 4) {
            switch (NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[this.npc.advanced.job.ordinal()]) {
                case 1: {
                    NoppesUtil.openGUI(this.player, new GuiNpcBard(this.npc));
                    break;
                }
                case 2: {
                    this.save();
                    NoppesUtil.openGUI(this.player, new GuiNpcHealer(this.npc));
                    break;
                }
                case 3: {
                    this.save();
                    NoppesUtil.openGUI(this.player, new GuiNpcGuard(this.npc));
                    break;
                }
                case 4: {
                    this.close();
                    NoppesUtil.requestOpenGUI(EnumGuiType.SetupItemGiver);
                    break;
                }
                case 5: {
                    this.close();
                    NoppesUtil.openGUI(this.player, new GuiNpcBoss(this.npc));
                    break;
                }
                case 6: {
                    this.close();
                    NoppesUtil.openGUI(this.player, new GuiNpcSpawner(this.npc));
                    break;
                }
                case 7: {
                    this.close();
                    NoppesUtil.openGUI(this.player, new GuiNpcConversation(this.npc));
                }
            }
        }
        if (guiButton.id == 5) {
            this.hasChanges = true;
            this.npc.advanced.setJob(guiNpcButton.getValue());
            boolean bl = this.getButton((int)4).enabled = this.npc.advanced.job != EnumJobType.None;
        }
        if (guiButton.id == 9) {
            NoppesUtil.openGUI(this.player, new GuiNPCFactionSetup(this.npc));
        }
        if (guiButton.id == 10) {
            NoppesUtil.openGUI(this.player, new GuiNPCDialogNpcOptions(this.npc, this));
        }
        if (guiButton.id == 11) {
            NoppesUtil.openGUI(this.player, new GuiNPCSoundsMenu(this.npc));
        }
        if (guiButton.id == 7) {
            NoppesUtil.openGUI(this.player, new GuiNpcReplicas((GuiScreen)this, this.npc.advanced.replicas));
            this.hasChanges = true;
        }
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("NpcAccess")) {
            this.npcAccess = nBTTagCompound._o("NpcAccess");
        } else {
            this.npc.advanced.readToNBT(nBTTagCompound);
        }
        this.initGui();
    }

    @Override
    public void save() {
        if (this.hasChanges) {
            NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
            this.hasChanges = false;
        }
    }

    static class NamelessClass173512177 {
        static final int[] $SwitchMap$noppes$npcs$constants$EnumJobType = new int[EnumJobType.values().length];

        NamelessClass173512177() {
        }

        static {
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Bard.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Healer.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Guard.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.ItemGiver.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Boss.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Spawner.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass173512177.$SwitchMap$noppes$npcs$constants$EnumJobType[EnumJobType.Conversation.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

