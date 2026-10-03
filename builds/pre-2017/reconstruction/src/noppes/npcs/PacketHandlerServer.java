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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.village.MerchantRecipeList;
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
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        if (packet250CustomPayload.channel.equals("CNPCs Server")) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(packet250CustomPayload.data))));
                this.server(dataInputStream, (EntityPlayerMP)player, EnumPacketType.values()[dataInputStream.readInt()]);
                dataInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void server(DataInputStream dataInputStream, EntityPlayerMP entityPlayerMP, EnumPacketType enumPacketType) throws IOException {
        if (CustomNpcs.OpsOnly && !MinecraftServer._I().__ag()._p().contains(entityPlayerMP.username.toLowerCase())) {
            MinecraftServer._I()._c(entityPlayerMP.username + ": tried to use custom npcs without being an op");
        } else if (!enumPacketType.hasPermission() || CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP.username, enumPacketType.permission)) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (!enumPacketType.needsNpc || entityNPCInterface != null) {
                if (enumPacketType == EnumPacketType.Delete) {
                    if (!entityNPCInterface.status.canEdit(entityPlayerMP) && !CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP, "customnpcs.npc.deleteall")) {
                        return;
                    }
                    entityNPCInterface.delete();
                    CustomNpcs.npcsLog.info(entityPlayerMP.username + " removed npc with name " + entityNPCInterface.display.name + " at (" + entityNPCInterface.posX + ", " + entityNPCInterface.posY + ", " + entityNPCInterface.posZ + ")");
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
                    NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                    entityNPCInterface.status.writeToNBT(nBTTagCompound);
                    entityNPCInterface = (EntityNPCInterface)jgro._a(nBTTagCompound, entityPlayerMP.worldObj);
                    entityNPCInterface.sharedDataId = n;
                    entityNPCInterface.startPos = new int[]{n2, n3, n4};
                    entityNPCInterface.setPosition((float)n2 + 0.5f, entityNPCInterface.getStartYPos(), (float)n4 + 0.5f);
                    entityNPCInterface.setHealth(entityNPCInterface.getMaxHealth());
                    entityPlayerMP.worldObj.spawnEntityInWorld(entityNPCInterface);
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
                    NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                    entityNPCInterface.readFromNBT(nBTTagCompound);
                    entityNPCInterface.reset();
                    NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                } else if (enumPacketType == EnumPacketType.IsOp) {
                    NBTTagCompound nBTTagCompound = new NBTTagCompound();
                    nBTTagCompound._a("IsOp", ncwh._a(entityPlayerMP.username));
                    NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
                } else if (enumPacketType == EnumPacketType.RemoteMainMenu) {
                    Entity entity = entityPlayerMP.worldObj.getEntityByID(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    NoppesUtilServer.sendOpenGui(entityPlayerMP, EnumGuiType.MainMenuDisplay, (EntityNPCInterface)entity);
                } else if (enumPacketType == EnumPacketType.RemoteDelete) {
                    Entity entity = entityPlayerMP.worldObj.getEntityByID(dataInputStream.readInt());
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
                    Entity entity = entityPlayerMP.worldObj.getEntityByID(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    entityNPCInterface = (EntityNPCInterface)entity;
                    entityNPCInterface.reset();
                } else if (enumPacketType == EnumPacketType.RemoteTpToNpc) {
                    Entity entity = entityPlayerMP.worldObj.getEntityByID(dataInputStream.readInt());
                    if (entity == null || !(entity instanceof EntityNPCInterface)) {
                        return;
                    }
                    entityNPCInterface = (EntityNPCInterface)entity;
                    entityPlayerMP.playerNetServerHandler.setPlayerLocation(entityNPCInterface.posX, entityNPCInterface.posY, entityNPCInterface.posZ, 0.0f, 0.0f);
                } else if (enumPacketType == EnumPacketType.SpawnMob) {
                    Entity entity = jgro._a(bsvf._a(dataInputStream), entityPlayerMP.worldObj);
                    if (entity instanceof EntityNPCInterface) {
                        EntityNPCInterface entityNPCInterface2 = (EntityNPCInterface)entity;
                        if (entityNPCInterface2.roleInterface != null && !entityNPCInterface2.roleInterface.syncBetweenClones()) {
                            entityNPCInterface2.advanced.setRole(EnumRoleType.None.ordinal());
                        }
                        entityNPCInterface2.status.onCreation(entityPlayerMP);
                        entityNPCInterface2.shuffleEquipment();
                        System.out.println("Spawn with owner " + ((EntityNPCInterface)entity).getCurrentOwner());
                    }
                    entity.entityUniqueID = UUID.randomUUID();
                    entityPlayerMP.worldObj.spawnEntityInWorld(entity);
                } else if (enumPacketType == EnumPacketType.SpawnNpc) {
                    int n = dataInputStream.readInt();
                    int n5 = dataInputStream.readInt();
                    int n6 = dataInputStream.readInt();
                    entityNPCInterface = (EntityNPCInterface)jgro._a(bsvf._a(dataInputStream), entityPlayerMP.worldObj);
                    entityNPCInterface.entityUniqueID = UUID.randomUUID();
                    entityNPCInterface.shuffleEquipment();
                    entityNPCInterface.startPos = new int[]{n, n5, n6};
                    entityNPCInterface.setPosition((float)n + 0.5f, entityNPCInterface.getStartYPos(), (float)n6 + 0.5f);
                    entityNPCInterface.setHealth(entityNPCInterface.getMaxHealth());
                    entityNPCInterface.status.onCreation(entityPlayerMP);
                    entityPlayerMP.worldObj.spawnEntityInWorld(entityNPCInterface);
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
                        entityPlayerMP.addChatMessage((Object)((Object)EnumChatFormatting._m) + "No access to this dialog category");
                    }
                } else if (enumPacketType == EnumPacketType.DialogCategoryRemove) {
                    int n = dataInputStream.readInt();
                    DialogCategory dialogCategory = DialogController.instance.categories.get(n);
                    if (dialogCategory != null) {
                        if (dialogCategory.hasAccess(entityPlayerMP)) {
                            DialogController.instance.removeCategory(n, true);
                            NoppesUtilServer.sendDialogCategoryData(entityPlayerMP);
                        } else {
                            entityPlayerMP.addChatMessage((Object)((Object)EnumChatFormatting._m) + "No access to this dialog category");
                        }
                    }
                } else if (enumPacketType == EnumPacketType.DialogCategoryGet) {
                    DialogCategory dialogCategory = DialogController.instance.categories.get(dataInputStream.readInt());
                    if (dialogCategory != null) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, dialogCategory.writeNBT(new NBTTagCompound()));
                    }
                } else if (enumPacketType == EnumPacketType.LockDialogCategory) {
                    int n = dataInputStream.readInt();
                    boolean bl = dataInputStream.readBoolean();
                    boolean bl2 = ncwh._a(entityPlayerMP.username);
                    DialogCategory dialogCategory = DialogController.instance.categories.get(n);
                    if (dialogCategory != null && bl2) {
                        dialogCategory.locked = bl;
                    }
                } else if (enumPacketType == EnumPacketType.DialogsGet) {
                    NoppesUtilServer.sendDialogData(entityPlayerMP, DialogController.instance.categories.get(dataInputStream.readInt()));
                } else if (enumPacketType == EnumPacketType.DialogGet) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null) {
                        NBTTagCompound nBTTagCompound = dialog.writeToNBT(new NBTTagCompound());
                        Quest quest = QuestController.instance.quests.get(dialog.quest);
                        if (quest != null) {
                            nBTTagCompound._a("DialogQuestName", quest.title);
                        }
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
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
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        dialog.readNBT(nBTTagCompound);
                        Dialog dialog2 = DialogController.instance.dialogs.get(dialog.id);
                        if (dialog2 != null && !(object = NBTTags.nbtDiffLines(dialog2.writeToNBT(new NBTTagCompound()), nBTTagCompound)).isEmpty()) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.username + " updated dialog " + dialog2.title + "(" + dialog2.id + "):\n" + String.join((CharSequence)"\n", (Iterable<? extends CharSequence>)object));
                        }
                        if (!CustomNpcsPermissions.Instance.hasPermission(entityPlayerMP.username, "customnpcs.npc.command")) {
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
                        entityPlayerMP.addChatMessage((Object)((Object)EnumChatFormatting._m) + "No access to this dialog category");
                    }
                } else if (enumPacketType == EnumPacketType.QuestOpenGui) {
                    Quest quest = new Quest();
                    int n = dataInputStream.readInt();
                    quest.readNBT(bsvf._a(dataInputStream));
                    NoppesUtilServer.setEditingQuest(entityPlayerMP, quest);
                    entityPlayerMP.openGui(CustomNpcs.instance, n, entityPlayerMP.worldObj, 0, 0, 0);
                } else if (enumPacketType == EnumPacketType.DialogEdit) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, dialog.writeToNBT(new NBTTagCompound()));
                    }
                } else if (enumPacketType == EnumPacketType.DialogRemove) {
                    Dialog dialog = DialogController.instance.dialogs.get(dataInputStream.readInt());
                    if (dialog != null && dialog.category != null) {
                        if (dialog.category.hasAccess(entityPlayerMP)) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.username + " removed dialog " + dialog.title + "(" + dialog.id + ")");
                            DialogController.instance.removeDialog(dialog, true);
                            NoppesUtilServer.sendDialogData(entityPlayerMP, dialog.category);
                        } else {
                            entityPlayerMP.addChatMessage((Object)((Object)EnumChatFormatting._m) + "No access to this dialog category");
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
                        NBTTagCompound nBTTagCompound = dialogOption.writeNBT();
                        nBTTagCompound._a("Position", n);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
                    }
                    NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface, false);
                } else if (enumPacketType == EnumPacketType.DialogNpcRemove) {
                    entityNPCInterface.dialogs.remove(dataInputStream.readInt());
                    NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface, false);
                } else if (enumPacketType == EnumPacketType.QuestGet) {
                    Quest quest = QuestController.instance.quests.get(dataInputStream.readInt());
                    if (quest != null) {
                        NBTTagCompound nBTTagCompound = new NBTTagCompound();
                        if (quest.hasNewQuest()) {
                            nBTTagCompound._a("NextQuestTitle", quest.getNextQuest().title);
                        }
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, quest.writeToNBT(nBTTagCompound));
                    }
                } else {
                    if (enumPacketType == EnumPacketType.QuestCategoryGet) {
                        QuestCategory questCategory = QuestController.instance.categories.get(dataInputStream.readInt());
                        if (questCategory != null) {
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, questCategory.writeNBT(new NBTTagCompound()));
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
                            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, quest.writeToNBT(new NBTTagCompound()));
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
                            CustomNpcs.npcsLog.info(entityPlayerMP.username + " removed quest " + quest.title + "(" + quest.id + ")");
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
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        faction.readNBT(nBTTagCompound);
                        Faction faction2 = FactionController.getInstance().factions.get(faction.id);
                        if (faction2 != null && !(list = NBTTags.nbtDiffLines(faction2.writeNBT(new NBTTagCompound()), nBTTagCompound)).isEmpty()) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.username + " updated faction " + faction2.name + "(" + faction.id + "):\n" + String.join((CharSequence)"\n", list) + "\n");
                        }
                        FactionController.getInstance().saveFaction(faction);
                        NoppesUtilServer.sendFactionDataAll(entityPlayerMP);
                        NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                        faction.writeNBT(nBTTagCompound2);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound2);
                    } else if (enumPacketType == EnumPacketType.FactionRemove) {
                        int n = dataInputStream.readInt();
                        Faction faction = FactionController.getInstance().getFaction(n);
                        if (faction != null) {
                            CustomNpcs.npcsLog.info(entityPlayerMP.username + " removed faction " + faction.name + "(" + faction.id + ")");
                        }
                        FactionController.getInstance().removeFaction(n);
                        NoppesUtilServer.sendFactionDataAll(entityPlayerMP);
                        NBTTagCompound nBTTagCompound = new NBTTagCompound();
                        new Faction().writeNBT(nBTTagCompound);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
                    } else if (enumPacketType == EnumPacketType.FactionGet) {
                        NBTTagCompound nBTTagCompound = new NBTTagCompound();
                        Faction faction = FactionController.getInstance().getFaction(dataInputStream.readInt());
                        faction.writeNBT(nBTTagCompound);
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
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
                        NBTTagCompound nBTTagCompound = new NBTTagCompound();
                        nBTTagCompound._a("NpcAccess", PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, null));
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, nBTTagCompound);
                    } else if (enumPacketType == EnumPacketType.PlayerDataRemove) {
                        NoppesUtilServer.removePlayerData(dataInputStream, entityPlayerMP);
                    } else if (enumPacketType == EnumPacketType.MainmenuDisplayGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.display.writeToNBT(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.MainmenuDisplaySave) {
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("Display", entityPlayerMP, entityNPCInterface, entityNPCInterface.display.writeToNBT(new NBTTagCompound()), nBTTagCompound);
                        entityNPCInterface.display.readToNBT(nBTTagCompound);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuStatsGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.stats.writeToNBT(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.MainmenuStatsSave) {
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("Stats", entityPlayerMP, entityNPCInterface, entityNPCInterface.stats.writeToNBT(new NBTTagCompound()), nBTTagCompound);
                        entityNPCInterface.stats.readToNBT(nBTTagCompound);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuInvGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.inventory.writeEntityToNBT(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.MainmenuInvSave) {
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        entityNPCInterface.inventory.onUpdateByPlayer(entityPlayerMP, nBTTagCompound);
                        entityNPCInterface.inventory.readEntityFromNBT(nBTTagCompound);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuAIGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.aiData.writeToNBT(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.MainmenuAISave) {
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        this.logNbtDiff("AI", entityPlayerMP, entityNPCInterface, entityNPCInterface.aiData.writeToNBT(new NBTTagCompound()), nBTTagCompound);
                        entityNPCInterface.aiData.readToNBT(nBTTagCompound);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MainmenuAdvancedGet) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, entityNPCInterface.advanced.writeToNBT(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.MainmenuAdvancedSave) {
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        if (!PacketHandlerServer.checkNpcEdit(entityNPCInterface, entityPlayerMP, enumPacketType)) {
                            return;
                        }
                        if (entityNPCInterface.advanced.role == EnumRoleType.Trader) {
                            ((RoleTrader)entityNPCInterface.roleInterface).onUpdateByPlayer(entityNPCInterface, entityPlayerMP, nBTTagCompound);
                        }
                        this.logNbtDiff("Advanced", entityPlayerMP, entityNPCInterface, entityNPCInterface.advanced.writeToNBT(new NBTTagCompound()), nBTTagCompound);
                        entityNPCInterface.advanced.readToNBT(nBTTagCompound);
                        NoppesUtilServer.sendDataToAll(entityNPCInterface, EnumPacketType.UpdateNpc, entityNPCInterface.copy());
                        NpcSynchronizer.instance.onEntityUpdate(entityNPCInterface);
                    } else if (enumPacketType == EnumPacketType.MerchantUpdate) {
                        Entity entity = entityPlayerMP.worldObj.getEntityByID(dataInputStream.readInt());
                        if (entity == null || !(entity instanceof EntityVillager)) {
                            return;
                        }
                        MerchantRecipeList merchantRecipeList = MerchantRecipeList._a(dataInputStream);
                        ((EntityVillager)entity).setRecipes(merchantRecipeList);
                    } else if (enumPacketType == EnumPacketType.GetSoundPresets) {
                        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, SoundPresetsController.instance.saveToNbt(new NBTTagCompound()));
                    } else if (enumPacketType == EnumPacketType.SaveSoundPreset) {
                        int n = dataInputStream.readInt();
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        SoundPresetsController.SoundPreset soundPreset = new SoundPresetsController.SoundPreset();
                        soundPreset.readFromNbt(nBTTagCompound);
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
                        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
                        ReplicaSystem replicaSystem = new ReplicaSystem();
                        replicaSystem.readFromNbt(nBTTagCompound);
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
        boolean bl2 = ncwh._a(entityPlayer.username);
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
        return entityPlayer.username + " updated " + string + " of npc at (" + entityNPCInterface.posX + ", " + entityNPCInterface.posY + ", " + entityNPCInterface.posZ + ")";
    }

    private void logNbtDiff(String string, EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, NBTTagCompound nBTTagCompound, NBTTagCompound nBTTagCompound2) {
        List<String> list = NBTTags.nbtDiffLines(nBTTagCompound, nBTTagCompound2);
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
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("id", (int)entry.getKey());
            nBTTagCompound._a("value", entry.getValue());
            nBTTagList._a(nBTTagCompound);
        }
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a(string, nBTTagList);
        NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiData, nBTTagCompound);
    }
}

