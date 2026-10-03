/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumModelType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerData;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogCategory;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestCategory;
import noppes.npcs.controllers.QuestController;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;
import noppes.npcs.controllers.SoundPresetsController;
import noppes.npcs.controllers.TransportController;
import noppes.npcs.controllers.TransportLocation;
import noppes.npcs.controllers.replica.ReplicaSystem;
import noppes.npcs.permissions.CustomNpcsPermissions;
import noppes.npcs.roles.RoleTrader;
import noppes.npcs.roles.RoleTransporter;

public class PacketHandlerServer
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
        if (jjqf2.field_73630_a.equals("CNPCs Server")) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(jjqf2.field_73629_c))));
                this.server(dataInputStream, (EntityPlayerMP)player, EnumPacketType.values()[dataInputStream.readInt()]);
                dataInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void server(DataInputStream dataInputStream, EntityPlayerMP entityPlayerMP, EnumPacketType enumPacketType) throws IOException {
        if (CustomNpcs.OpsOnly && !dzfd._I().__ag()._p().contains(entityPlayerMP.field_71092_bJ.toLowerCase())) {
            dzfd._I()._c(entityPlayerMP.field_71092_bJ + ": tried to use custom npcs without being an op");
        } else if (!enumPacketType.hasPermission() || CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP.field_71092_bJ, enumPacketType.permission)) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (!enumPacketType.needsNpc || entityNPCInterface != null) {
                if (enumPacketType == EnumPacketType.Delete) {
                    if (!entityNPCInterface.status.canEdit(entityPlayerMP) && !CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP, "customnpcs.npc.deleteall")) {
                        return;
                    }
                    entityNPCInterface.delete();
                    CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " removed npc with name " + entityNPCInterface.display.name + " at (" + entityNPCInterface.field_70165_t + ", " + entityNPCInterface.field_70163_u + ", " + entityNPCInterface.field_70161_v + ")");
                    NoppesUtilServer.deleteNpc(entityNPCInterface);
                    NpcSynchronizer.instance.onEntityDelete(entityNPCInterface);
                } else if (enumPacketType == EnumPacketType.ChangeModel) {
                    if (!entityNPCInterface.status.canEdit(entityPlayerMP)) {
                        return;
                    }
                    int n = entityNPCInterface.sharedDataId;
                    entityNPCInterface.delete();
                    NoppesUtilServer.deleteNpc(entityNPCInterface);
                    int n2 = dataInputStream.readInt();
                    int n3 = dataInputStream.readInt();
                    int n4 = dataInputStream.readInt();
                    EnumModelType enumModelType = entityNPCInterface.display.modelType;
                    qoac qoac2 = bsvf._a(dataInputStream);
                    entityNPCInterface.status.writeToNBT(qoac2);
                    entityNPCInterface = (EntityNPCInterface)jgro._a(qoac2, entityPlayerMP.field_70170_p);
                    entityNPCInterface.sharedDataId = n;
                    entityNPCInterface.startPos = new int[]{n2, n3, n4};
                    entityNPCInterface.func_70107_b((float)n2 + 0.5f, entityNPCInterface.getStartYPos(), (float)n4 + 0.5f);
                    entityNPCInterface.func_70606_j(entityNPCInterface.func_110138_aP());
                    entityPlayerMP.field_70170_p.func_72838_d(entityNPCInterface);
                    NoppesUtilServer.setEditingNpc(entityPlayerMP, entityNPCInterface);
                    CustomNpcs.npcsLog.info(this.logPreface("model", entityPlayerMP, entityNPCInterface) + ": " + enumModelType.toString() + " -> " + entityNPCInterface.display.modelType.toString());
                } else if (enumPacketType == EnumPacketType.Bank) {
                    BankController.getInstance().loadBanks(dataInputStream);
                    BankController.getInstance().saveBanks();
                } else if (enumPacketType == EnumPacketType.BanksGet) {
                    NoppesUtilServer.sendBankDataAll(entityPlayerMP);
                } else if (enumPacketType == EnumPacketType.BankGet) {
                    Bank bank = BankController.getInstance().getBank(dataInputStream.readInt());
                    NoppesUtilServer.sendBank(entityPlayerMP, bank);
                } else if (enumPacketType == EnumPacketType.BankSave) {
                    Bank bank = new Bank();
                    bank.readEntityFromNBT(bsvf._a(dataInputStream));
                    BankController.getInstance().saveBank(bank);
                    NoppesUtilServer.sendBankDataAll(entityPlayerMP);
                    NoppesUtilServer.sendBank(entityPlayerMP, bank);
                } else if (enumPacketType == EnumPacketType.BankRemove) {
                    BankController.getInstance().removeBank(dataInputStream.readInt());
                    NoppesUtilServer.sendBankDataAll(entityPlayerMP);
                    NoppesUtilServer.sendBank(entityPlayerMP, new Bank());
                } else if (enumPacketType == EnumPacketType.SaveNpc) {
                    if (!entityNPCInterface.status.canEdit(entityPlayerMP)) {
                        return;
                    }
                    qoac qoac3 = bsvf._a(dataInputStream);
                    entityNPCInterface.func_70020_e(qoac3);
                    entityNPCInterface.reset();
                    NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                } else if (enumPacketType == EnumPacketType.IsOp) {
                    qoac qoac4 = new qoac();
                    qoac4._a("IsOp", ncwh._a(entityPlayerMP.field_71092_bJ));
                    NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac4);
                } else if (enumPacketType == EnumPacketType.RemoteMainMenu) {
                    Entity entity = entityPlayerMP.field_70170_p.func_73045_a(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    NoppesUtilServer.sendOpenGui(entityPlayerMP, EnumGuiType.MainMenuDisplay, (EntityNPCInterface)entity);
                } else if (enumPacketType == EnumPacketType.RemoteDelete) {
                    Entity entity = entityPlayerMP.field_70170_p.func_73045_a(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    entityNPCInterface = (EntityNPCInterface)entity;
                    if (!entityNPCInterface.status.canEdit(entityPlayerMP)) {
                        return;
                    }
                    entityNPCInterface.delete();
                    NoppesUtilServer.deleteNpc(entityNPCInterface);
                    NoppesUtilServer.sendNearbyNpcs(entityPlayerMP);
                    NpcSynchronizer.instance.onEntityDelete(entityNPCInterface);
                } else if (enumPacketType == EnumPacketType.RemoteNpcsGet) {
                    NoppesUtilServer.sendNearbyNpcs(entityPlayerMP);
                    NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollSelected, CustomNpcs.FreezeNPCs ? "Unfreeze Npcs" : "Freeze Npcs");
                } else if (enumPacketType == EnumPacketType.RemoteFreeze) {
                    CustomNpcs.FreezeNPCs = !CustomNpcs.FreezeNPCs;
                    NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollSelected, CustomNpcs.FreezeNPCs ? "Unfreeze Npcs" : "Freeze Npcs");
                } else if (enumPacketType == EnumPacketType.RemoteReset) {
                    Entity entity = entityPlayerMP.field_70170_p.func_73045_a(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    entityNPCInterface = (EntityNPCInterface)entity;
                    entityNPCInterface.reset();
                } else if (enumPacketType == EnumPacketType.RemoteTpToNpc) {
                    Entity entity = entityPlayerMP.field_70170_p.func_73045_a(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    entityNPCInterface = (EntityNPCInterface)entity;
                    entityPlayerMP.field_71135_a.func_72569_a(entityNPCInterface.field_70165_t, entityNPCInterface.field_70163_u, entityNPCInterface.field_70161_v, 0.0f, 0.0f);
                } else if (enumPacketType == EnumPacketType.SpawnMob) {
                    Entity entity = jgro._a(bsvf._a(dataInputStream), entityPlayerMP.field_70170_p);
                    if (entity instanceof EntityNPCInterface) {
                        EntityNPCInterface entityNPCInterface2 = (EntityNPCInterface)entity;
                        if (entityNPCInterface2.roleInterface != null && !entityNPCInterface2.roleInterface.syncBetweenClones()) {
                            entityNPCInterface2.advanced.setRole(EnumRoleType.None.ordinal());
                        }
                        entityNPCInterface2.status.onCreation(entityPlayerMP);
                        entityNPCInterface2.shuffleEquipment();
                        System.out.println("Spawn with owner " + ((EntityNPCInterface)entity).getCurrentOwner());
                    }
                    entity.field_96093_i = UUID.randomUUID();
                    entityPlayerMP.field_70170_p.func_72838_d(entity);
                } else if (enumPacketType == EnumPacketType.SpawnNpc) {
                    int n = dataInputStream.readInt();
                    int n5 = dataInputStream.readInt();
                    int n6 = dataInputStream.readInt();
                    entityNPCInterface = (EntityNPCInterface)jgro._a(bsvf._a(dataInputStream), entityPlayerMP.field_70170_p);
                    entityNPCInterface.field_96093_i = UUID.randomUUID();
                    entityNPCInterface.shuffleEquipment();
                    entityNPCInterface.startPos = new int[]{n, n5, n6};
                    entityNPCInterface.func_70107_b((float)n + 0.5f, entityNPCInterface.getStartYPos(), (float)n6 + 0.5f);
                    entityNPCInterface.func_70606_j(entityNPCInterface.func_110138_aP());
                    entityNPCInterface.status.onCreation(entityPlayerMP);
                    entityPlayerMP.field_70170_p.func_72838_d(entityNPCInterface);
                    NoppesUtilServer.setEditingNpc(entityPlayerMP, entityNPCInterface);
                } else if (enumPacketType == EnumPacketType.MobSpawner) {
                    NoppesUtilServer.createMobSpawner(dataInputStream, entityPlayerMP);
                } else if (enumPacketType == EnumPacketType.Gui) {
                    EnumGuiType enumGuiType = EnumGuiType.values()[dataInputStream.readInt()];
                    int n = dataInputStream.readInt();
                    int n7 = dataInputStream.readInt();
                    int n8 = dataInputStream.readInt();
                    NoppesUtilServer.sendOpenGui(entityPlayerMP, enumGuiType, NoppesUtilServer.getEditingNpc(entityPlayerMP), n, n7, n8);
                } else if (enumPacketType == EnumPacketType.RecipesGet) {
                    NoppesUtilServer.sendRecipeData(entityPlayerMP, dataInputStream.readInt());
                } else if (enumPacketType == EnumPacketType.RecipeGet) {
                    RecipeCarpentry recipeCarpentry = RecipeController.instance.getRecipe(dataInputStream.readInt());
                    NoppesUtilServer.setRecipeGui(entityPlayerMP, recipeCarpentry);
                } else if (enumPacketType == EnumPacketType.RecipeRemove) {
                    RecipeCarpentry recipeCarpentry = RecipeController.instance.removeRecipe(dataInputStream.readInt());
                    NoppesUtilServer.sendRecipeData(entityPlayerMP, recipeCarpentry.isGlobal ? 3 : 4);
                    NoppesUtilServer.setRecipeGui(entityPlayerMP, new RecipeCarpentry());
                } else if (enumPacketType == EnumPacketType.RecipeSave) {
                    RecipeCarpentry recipeCarpentry = RecipeController.instance.saveRecipe(dataInputStream);
                    NoppesUtilServer.sendRecipeData(entityPlayerMP, recipeCarpentry.isGlobal ? 3 : 4);
                    NoppesUtilServer.setRecipeGui(entityPlayerMP, recipeCarpentry);
                } else if (enumPacketType == EnumPacketType.DialogCategoriesGet) {
                    NoppesUtilServer.sendDialogCategoryData(entityPlayerMP);
                } else if (enumPacketType == EnumPacketType.DialogCategorySave) {
                    DialogCategory dialogCategory = new DialogCategory();
                    dialogCategory.readNBT(bsvf._a(dataInputStream));
                    DialogCategory dialogCategory2 = DialogController.instance.categories.get(dialogCategory.id);
                    if (dialogCategory2 != null && dialogCategory.locked != dialogCategory2.locked) {
                        throw new IllegalArgumentException("Locked state should be changed directly using apropriate packet");
                    }
                    if (dialogCategory2 == null || dialogCategory2.hasAccess(entityPlayerMP)) {
                        DialogController.instance.saveCategory(dialogCategory);
                        NoppesUtilServer.sendDialogCategoryData(entityPlayerMP);
                    } else {
                        entityPlayerMP.func_71035_c((Object)((Object)ezfc._m) + "No access to this dialog category");
                    }
                } else if (enumPacketType == EnumPacketType.DialogCategoryRemove) {
                    int n = dataInputStream.readInt();
                    DialogCategory dialogCategory = DialogController.instance.categories.get(n);
                    if (dialogCategory != null) {
                        if (dialogCategory.hasAccess(entityPlayerMP)) {
                            DialogController.instance.removeCategory(n, true);
                            NoppesUtilServer.sendDialogCategoryData(entityPlayerMP);
                        } else {
                            entityPlayerMP.func_71035_c((Object)((Object)ezfc._m) + "No access to this dialog category");
                        }
                    }
                } else if (enumPacketType == EnumPacketType.DialogCategoryGet) {
                    DialogCategory dialogCategory = DialogController.instance.categories.get(dataInputStream.readInt());
                    if (dialogCategory != null) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, dialogCategory.writeNBT(new qoac()));
                    }
                } else if (enumPacketType == EnumPacketType.LockDialogCategory) {
                    int n = dataInputStream.readInt();
                    boolean bl = dataInputStream.readBoolean();
                    boolean bl2 = ncwh._a(entityPlayerMP.field_71092_bJ);
                    DialogCategory dialogCategory = DialogController.instance.categories.get(n);
                    if (dialogCategory != null && bl2) {
                        dialogCategory.locked = bl;
                    }
                } else if (enumPacketType == EnumPacketType.DialogsGet) {
                    NoppesUtilServer.sendDialogData(entityPlayerMP, DialogController.instance.categories.get(dataInputStream.readInt()));
                } else if (enumPacketType == EnumPacketType.DialogGet) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null) {
                        qoac qoac5 = dialog.writeToNBT(new qoac());
                        Quest quest = QuestController.instance.quests.get(dialog.quest);
                        if (quest != null) {
                            qoac5._a("DialogQuestName", quest.title);
                        }
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac5);
                    }
                } else if (enumPacketType == EnumPacketType.DialogsGetAll) {
                    int n = dataInputStream.readInt();
                    int[] nArray = new int[n];
                    for (int i = 0; i < n; ++i) {
                        nArray[i] = dataInputStream.readInt();
                    }
                    this.sendDialogsTitles(entityPlayerMP, nArray);
                } else if (enumPacketType == EnumPacketType.FactionsGetAll) {
                    int n = dataInputStream.readInt();
                    int[] nArray = new int[n];
                    for (int i = 0; i < n; ++i) {
                        nArray[i] = dataInputStream.readInt();
                    }
                    this.sendFactionsTitles(entityPlayerMP, nArray);
                } else if (enumPacketType == EnumPacketType.QuestsGetAll) {
                    int n = dataInputStream.readInt();
                    int[] nArray = new int[n];
                    for (int i = 0; i < n; ++i) {
                        nArray[i] = dataInputStream.readInt();
                    }
                    this.sendQuestsTitles(entityPlayerMP, nArray);
                } else if (enumPacketType == EnumPacketType.DialogsGetFromDialog) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog == null) {
                        return;
                    }
                    NoppesUtilServer.sendDialogData(entityPlayerMP, dialog.category);
                } else if (enumPacketType == EnumPacketType.DialogSave) {
                    int n = dataInputStream.readInt();
                    DialogCategory dialogCategory = DialogController.instance.categories.get(n);
                    if (dialogCategory != null && dialogCategory.hasAccess(entityPlayerMP)) {
                        Object object;
                        Dialog dialog = new Dialog();
                        qoac qoac6 = bsvf._a(dataInputStream);
                        dialog.readNBT(qoac6);
                        Dialog dialog2 = DialogController.instance.dialogs.get(dialog.id);
                        if (dialog2 != null && !(object = NBTTags.nbtDiffLines(dialog2.writeToNBT(new qoac()), qoac6)).isEmpty()) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " updated dialog " + dialog2.title + "(" + dialog2.id + "):\n" + String.join((CharSequence)"\n", (Iterable<? extends CharSequence>)object));
                        }
                        if (!CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP.field_71092_bJ, "customnpcs.npc.command")) {
                            if (!(this.isCommandAcceptable(dialog.command) || dialog2 != null && dialog.command.equals(dialog2.command))) {
                                dialog.command = "";
                            }
                            for (DialogOption dialogOption : dialog.options.values()) {
                                if (dialogOption.command == null || this.isCommandAcceptable(dialogOption.command) || dialog2 != null && !dialog2.options.values().stream().noneMatch(dialogOption2 -> dialogOption.command.equals(dialogOption2.command))) continue;
                                dialogOption.command = "";
                            }
                        }
                        DialogController.instance.saveDialog(n, dialog);
                        if (dialog.category != null) {
                            NoppesUtilServer.sendDialogData(entityPlayerMP, dialog.category);
                        }
                    } else {
                        entityPlayerMP.func_71035_c((Object)((Object)ezfc._m) + "No access to this dialog category");
                    }
                } else if (enumPacketType == EnumPacketType.QuestOpenGui) {
                    Quest quest = new Quest();
                    int n = dataInputStream.readInt();
                    quest.readNBT(bsvf._a(dataInputStream));
                    NoppesUtilServer.setEditingQuest(entityPlayerMP, quest);
                    entityPlayerMP.openGui(CustomNpcs.instance, n, entityPlayerMP.field_70170_p, 0, 0, 0);
                } else if (enumPacketType == EnumPacketType.DialogEdit) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, dialog.writeToNBT(new qoac()));
                    }
                } else if (enumPacketType == EnumPacketType.DialogRemove) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null && dialog.category != null) {
                        if (dialog.category.hasAccess(entityPlayerMP)) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " removed dialog " + dialog.title + "(" + dialog.id + ")");
                            DialogController.instance.removeDialog(dialog, true);
                            NoppesUtilServer.sendDialogData(entityPlayerMP, dialog.category);
                        } else {
                            entityPlayerMP.func_71035_c((Object)((Object)ezfc._m) + "No access to this dialog category");
                        }
                    }
                } else if (enumPacketType == EnumPacketType.DialogNpcGet) {
                    NoppesUtilServer.sendNpcDialogs(entityPlayerMP);
                } else if (enumPacketType == EnumPacketType.DialogNpcSet) {
                    int n = dataInputStream.readInt();
                    int n9 = dataInputStream.readInt();
                    if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, EnumPacketType.DialogNpcSet)) {
                        return;
                    }
                    DialogOption dialogOption = NoppesUtilServer.setNpcDialog(n, n9, entityPlayerMP);
                    if (dialogOption != null && dialogOption.hasDialog()) {
                        qoac qoac7 = dialogOption.writeNBT();
                        qoac7._a("Position", n);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac7);
                    }
                    NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface, false);
                } else if (enumPacketType == EnumPacketType.DialogNpcRemove) {
                    entityNPCInterface.dialogs.remove(dataInputStream.readInt());
                    NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface, false);
                } else if (enumPacketType == EnumPacketType.QuestGet) {
                    Quest quest = QuestController.instance.quests.get(dataInputStream.readInt());
                    if (quest != null) {
                        qoac qoac8 = new qoac();
                        if (quest.hasNewQuest()) {
                            qoac8._a("NextQuestTitle", quest.getNextQuest().title);
                        }
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, quest.writeToNBT(qoac8));
                    }
                } else {
                    if (enumPacketType == EnumPacketType.QuestCategoryGet) {
                        QuestCategory questCategory = QuestController.instance.categories.get(dataInputStream.readInt());
                        if (questCategory != null) {
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, questCategory.writeNBT(new qoac()));
                        }
                    } else if (enumPacketType == EnumPacketType.QuestCategorySave) {
                        QuestCategory questCategory = new QuestCategory();
                        questCategory.readNBT(bsvf._a(dataInputStream));
                        QuestController.instance.saveCategory(questCategory, entityPlayerMP);
                        NoppesUtilServer.sendQuestCategoryData(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.QuestCategoriesGet) {
                        NoppesUtilServer.sendQuestCategoryData(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.QuestCategoryRemove) {
                        QuestController.instance.removeCategory(dataInputStream.readInt(), true);
                        NoppesUtilServer.sendQuestCategoryData(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.QuestsGet) {
                        QuestCategory questCategory = QuestController.instance.categories.get(dataInputStream.readInt());
                        NoppesUtilServer.sendQuestData(entityPlayerMP, questCategory);
                    }
                    if (enumPacketType == EnumPacketType.QuestsGetFromQuest) {
                        Quest quest = QuestController.instance.quests.get(dataInputStream.readInt());
                        if (quest == null) {
                            return;
                        }
                        NoppesUtilServer.sendQuestData(entityPlayerMP, quest.category);
                    } else if (enumPacketType == EnumPacketType.QuestEdit) {
                        Quest quest = QuestController.instance.quests.get(dataInputStream.readInt());
                        if (quest != null) {
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, quest.writeToNBT(new qoac()));
                        }
                    } else if (enumPacketType == EnumPacketType.QuestSave) {
                        Quest quest = QuestController.instance.saveQuest(dataInputStream, entityPlayerMP);
                        if (quest.category != null) {
                            NoppesUtilServer.sendQuestData(entityPlayerMP, quest.category);
                        }
                    } else if (enumPacketType == EnumPacketType.QuestRemove) {
                        int n = dataInputStream.readInt();
                        Quest quest = QuestController.instance.quests.get(n);
                        if (quest != null) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " removed quest " + quest.title + "(" + quest.id + ")");
                            QuestController.instance.removeQuest(quest, true);
                            NoppesUtilServer.sendQuestData(entityPlayerMP, quest.category);
                        }
                    } else if (enumPacketType == EnumPacketType.TransportCategoriesGet) {
                        NoppesUtilServer.sendTransportCategoryData(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.TransportCategorySave) {
                        TransportController.getInstance().saveCategory(dataInputStream);
                    } else if (enumPacketType == EnumPacketType.TransportCategoryRemove) {
                        TransportController.getInstance().removeCategory(dataInputStream.readInt());
                        NoppesUtilServer.sendTransportCategoryData(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.TransportRemove) {
                        int n = dataInputStream.readInt();
                        TransportController.getInstance().removeLocation(n);
                        NoppesUtilServer.sendTransportData(entityPlayerMP, n);
                    } else if (enumPacketType == EnumPacketType.TransportsGet) {
                        NoppesUtilServer.sendTransportData(entityPlayerMP, dataInputStream.readInt());
                    } else if (enumPacketType == EnumPacketType.TransportSave) {
                        int n = dataInputStream.readInt();
                        TransportLocation transportLocation = TransportController.getInstance().saveLocation(n, dataInputStream, entityPlayerMP, NoppesUtilServer.getEditingNpc(entityPlayerMP));
                        if (transportLocation != null) {
                            if (entityNPCInterface.advanced.role != EnumRoleType.Transporter) {
                                return;
                            }
                            if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                                return;
                            }
                            ((RoleTransporter)entityNPCInterface.roleInterface).setTransport(transportLocation);
                            NoppesUtilServer.sendTransportData(entityPlayerMP, n);
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, transportLocation.writeNBT());
                        }
                    } else if (enumPacketType == EnumPacketType.SaveTileEntity) {
                        NoppesUtilServer.saveTileEntity(entityPlayerMP, dataInputStream);
                    } else if (enumPacketType == EnumPacketType.TransportGetLocation) {
                        if (entityNPCInterface.advanced.role != EnumRoleType.Transporter) {
                            return;
                        }
                        RoleTransporter roleTransporter = (RoleTransporter)entityNPCInterface.roleInterface;
                        if (roleTransporter.hasTransport()) {
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, roleTransporter.getLocation().writeNBT());
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollSelected, roleTransporter.getLocation().category.title);
                        }
                    } else if (enumPacketType == EnumPacketType.FactionsGet) {
                        NoppesUtilServer.sendFactionDataAll(entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.FactionSet) {
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        entityNPCInterface.setFaction(dataInputStream.readInt());
                    } else if (enumPacketType == EnumPacketType.FactionSave) {
                        List<String> list;
                        Faction faction = new Faction();
                        qoac qoac9 = bsvf._a(dataInputStream);
                        faction.readNBT(qoac9);
                        Faction faction2 = FactionController.getInstance().factions.get(faction.id);
                        if (faction2 != null && !(list = NBTTags.nbtDiffLines(faction2.writeNBT(new qoac()), qoac9)).isEmpty()) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " updated faction " + faction2.name + "(" + faction.id + "):\n" + String.join((CharSequence)"\n", list) + "\n");
                        }
                        FactionController.getInstance().saveFaction(faction);
                        NoppesUtilServer.sendFactionDataAll(entityPlayerMP);
                        qoac qoac10 = new qoac();
                        faction.writeNBT(qoac10);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac10);
                    } else if (enumPacketType == EnumPacketType.FactionRemove) {
                        int n = dataInputStream.readInt();
                        Faction faction = FactionController.getInstance().getFaction(n);
                        if (faction != null) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.field_71092_bJ + " removed faction " + faction.name + "(" + faction.id + ")");
                        }
                        FactionController.getInstance().removeFaction(n);
                        NoppesUtilServer.sendFactionDataAll(entityPlayerMP);
                        qoac qoac11 = new qoac();
                        new Faction().writeNBT(qoac11);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac11);
                    } else if (enumPacketType == EnumPacketType.FactionGet) {
                        qoac qoac12 = new qoac();
                        Faction faction = FactionController.getInstance().getFaction(dataInputStream.readInt());
                        faction.writeNBT(qoac12);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac12);
                    } else if (enumPacketType == EnumPacketType.PlayerDataGet) {
                        int n = dataInputStream.readInt();
                        if (EnumPlayerData.values().length <= n) {
                            return;
                        }
                        String string = null;
                        EnumPlayerData enumPlayerData = EnumPlayerData.values()[n];
                        if (enumPlayerData != EnumPlayerData.Players) {
                            string = dataInputStream.readUTF();
                        }
                        NoppesUtilServer.sendPlayerData(enumPlayerData, entityPlayerMP, string);
                    } else if (enumPacketType == EnumPacketType.NpcAccess) {
                        qoac qoac13 = new qoac();
                        qoac13._a("NpcAccess", PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, null));
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac13);
                    } else if (enumPacketType == EnumPacketType.PlayerDataRemove) {
                        NoppesUtilServer.removePlayerData(dataInputStream, entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.MainmenuDisplayGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.display.writeToNBT(new qoac()));
                    } else if (enumPacketType == EnumPacketType.MainmenuDisplaySave) {
                        qoac qoac14 = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("Display", entityPlayerMP, entityNPCInterface, entityNPCInterface.display.writeToNBT(new qoac()), qoac14);
                        entityNPCInterface.display.readToNBT(qoac14);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuStatsGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.stats.writeToNBT(new qoac()));
                    } else if (enumPacketType == EnumPacketType.MainmenuStatsSave) {
                        qoac qoac15 = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("Stats", entityPlayerMP, entityNPCInterface, entityNPCInterface.stats.writeToNBT(new qoac()), qoac15);
                        entityNPCInterface.stats.readToNBT(qoac15);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuInvGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.inventory.writeEntityToNBT(new qoac()));
                    } else if (enumPacketType == EnumPacketType.MainmenuInvSave) {
                        qoac qoac16 = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        entityNPCInterface.inventory.onUpdateByPlayer(entityPlayerMP, qoac16);
                        entityNPCInterface.inventory.readEntityFromNBT(qoac16);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuAIGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.aiData.writeToNBT(new qoac()));
                    } else if (enumPacketType == EnumPacketType.MainmenuAISave) {
                        qoac qoac17 = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("AI", entityPlayerMP, entityNPCInterface, entityNPCInterface.aiData.writeToNBT(new qoac()), qoac17);
                        entityNPCInterface.aiData.readToNBT(qoac17);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuAdvancedGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.advanced.writeToNBT(new qoac()));
                    } else if (enumPacketType == EnumPacketType.MainmenuAdvancedSave) {
                        qoac qoac18 = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        if (entityNPCInterface.advanced.role == EnumRoleType.Trader) {
                            ((RoleTrader)entityNPCInterface.roleInterface).onUpdateByPlayer(entityNPCInterface, entityPlayerMP, qoac18);
                        }
                        this.logNbtDiff("Advanced", entityPlayerMP, entityNPCInterface, entityNPCInterface.advanced.writeToNBT(new qoac()), qoac18);
                        entityNPCInterface.advanced.readToNBT(qoac18);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MerchantUpdate) {
                        Entity entity = entityPlayerMP.field_70170_p.func_73045_a(dataInputStream.readInt());
                        if (entity == null || !(entity instanceof EntityVillager)) {
                            return;
                        }
                        ywfi ywfi2 = ywfi._a(dataInputStream);
                        ((EntityVillager)entity).func_70930_a(ywfi2);
                    } else if (enumPacketType == EnumPacketType.GetSoundPresets) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, SoundPresetsController.instance.saveToNbt(new qoac()));
                    } else if (enumPacketType == EnumPacketType.SaveSoundPreset) {
                        int n = dataInputStream.readInt();
                        qoac qoac19 = bsvf._a(dataInputStream);
                        SoundPresetsController.SoundPreset soundPreset = new SoundPresetsController.SoundPreset();
                        soundPreset.readFromNbt(qoac19);
                        soundPreset.id = n;
                        SoundPresetsController.instance.getReplicas().put(n, soundPreset);
                        SoundPresetsController.instance.save();
                    } else if (enumPacketType == EnumPacketType.DeleteSoundPreset) {
                        int n = dataInputStream.readInt();
                        if (SoundPresetsController.instance.getReplicas().remove(n) != null) {
                            SoundPresetsController.instance.save();
                        }
                    } else if (enumPacketType == EnumPacketType.CreateSoundPreset) {
                        String string = dataInputStream.readUTF();
                        qoac qoac20 = bsvf._a(dataInputStream);
                        ReplicaSystem replicaSystem = new ReplicaSystem();
                        replicaSystem.readFromNbt(qoac20);
                        SoundPresetsController.instance.addPreset(string, replicaSystem);
                    } else if (enumPacketType == EnumPacketType.GetPresetTitle) {
                        int n = dataInputStream.readInt();
                        SoundPresetsController.SoundPreset soundPreset = SoundPresetsController.instance.getReplicas().get(n);
                        if (soundPreset != null) {
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, new dwly()._a("Title", soundPreset.title)._a());
                        }
                    } else if (enumPacketType == EnumPacketType.GetTradeLocations) {
                        InvokeSideOnly.frontend(() -> {});
                    } else if (enumPacketType == EnumPacketType.GetGuideLocations) {
                        InvokeSideOnly.frontend(() -> {});
                    }
                }
            }
        }
    }

    private void sendTradeLocations(EntityPlayerMP entityPlayerMP, Set<String> set) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static boolean checkNpcEdit(EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer, EnumPacketType enumPacketType) {
        if (!entityNPCInterface.status.canEdit(entityPlayer)) {
            return false;
        }
        boolean bl = NpcSynchronizer.instance.isShared(entityNPCInterface);
        boolean bl2 = ncwh._a(entityPlayer.field_71092_bJ);
        return !bl || bl2 || enumPacketType == EnumPacketType.MainmenuAISave;
    }

    private boolean isCommandAcceptable(String string) {
        if (string.startsWith("/")) {
            string = string.substring(1, string.length());
        }
        if (string.startsWith("tp")) {
            return true;
        }
        if (string.startsWith("tpcerf")) {
            return true;
        }
        return string.startsWith("kill");
    }

    private String logPreface(String string, EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        return entityPlayer.field_71092_bJ + " updated " + string + " of npc at (" + entityNPCInterface.field_70165_t + ", " + entityNPCInterface.field_70163_u + ", " + entityNPCInterface.field_70161_v + ")";
    }

    private void logNbtDiff(String string, EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, qoac qoac2, qoac qoac3) {
        List<String> list = NBTTags.nbtDiffLines(qoac2, qoac3);
        if (list.size() > 0) {
            CustomNpcs.npcsLog.info(this.logPreface(string, entityPlayer, entityNPCInterface) + ".\n" + String.join((CharSequence)"\n", list) + "\n");
        }
    }

    private void sendDialogsTitles(EntityPlayer entityPlayer, int[] nArray) {
        Map<Integer, String> map = Arrays.stream(nArray).mapToObj(DialogController.instance.dialogs::get).filter(Objects::nonNull).collect(Collectors.toMap(dialog -> dialog.id, dialog -> dialog.title));
        this.sendIntStringMap(entityPlayer, map, "dialogs");
    }

    private void sendFactionsTitles(EntityPlayer entityPlayer, int[] nArray) {
        Map<Integer, String> map = Arrays.stream(nArray).mapToObj(FactionController.getInstance()::getFaction).filter(Objects::nonNull).collect(Collectors.toMap(faction -> faction.id, faction -> faction.name, (string, string2) -> string));
        this.sendIntStringMap(entityPlayer, map, "factions");
    }

    private void sendQuestsTitles(EntityPlayer entityPlayer, int[] nArray) {
        Map<Integer, String> map = Arrays.stream(nArray).mapToObj(QuestController.instance.quests::get).filter(Objects::nonNull).collect(Collectors.toMap(quest -> quest.id, quest -> quest.title));
        this.sendIntStringMap(entityPlayer, map, "quests");
    }

    private void sendIntStringMap(EntityPlayer entityPlayer, Map<Integer, String> map, String string) {
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            qoac qoac2 = new qoac();
            qoac2._a("id", (int)entry.getKey());
            qoac2._a("value", entry.getValue());
            bsyv2._a(qoac2);
        }
        qoac qoac3 = new qoac();
        qoac3._a(string, bsyv2);
        NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiData, qoac3);
    }
}

