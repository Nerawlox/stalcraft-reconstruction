/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.tdpx;
import net.minecraft.village.MerchantRecipeList;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.QuestAchievement;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.IGuiClose;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IGuiError;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;
import noppes.npcs.events.ItemInteractEvent;

public class PacketHandlerClient
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        if (packet250CustomPayload.channel.equals("CNPCs Client")) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(packet250CustomPayload.data))));
                this.client(dataInputStream, (EntityPlayer)player, EnumPacketType.values()[dataInputStream.readInt()]);
                dataInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void client(DataInputStream dataInputStream, EntityPlayer entityPlayer, EnumPacketType enumPacketType) throws IOException {
        if (enumPacketType == EnumPacketType.Bank) {
            NoppesUtil.bankData(dataInputStream);
        } else if (enumPacketType == EnumPacketType.Chat) {
            String string = "";
            try {
                while (true) {
                    String string2 = dataInputStream.readUTF();
                    string = string + tdpx._a(string2);
                }
            }
            catch (EOFException eOFException) {
                entityPlayer.addChatMessage(string);
            }
        } else if (enumPacketType == EnumPacketType.Message) {
            String string = tdpx._a(dataInputStream.readUTF());
            String string3 = dataInputStream.readUTF();
            QuestAchievement questAchievement = new QuestAchievement(string3, string);
            Minecraft._E()._I._a(questAchievement);
            Minecraft._E()._I._e = questAchievement.getDescription();
        } else if (enumPacketType == EnumPacketType.SyncRecipes) {
            NBTTagList nBTTagList = bsvf._a(dataInputStream)._n("recipes");
            HashMap<Integer, RecipeCarpentry> hashMap = new HashMap<Integer, RecipeCarpentry>();
            if (nBTTagList == null) {
                return;
            }
            for (int i = 0; i < nBTTagList._d(); ++i) {
                RecipeCarpentry recipeCarpentry = new RecipeCarpentry();
                recipeCarpentry.readNBT((NBTTagCompound)nBTTagList._b(i));
                hashMap.put(recipeCarpentry.id, recipeCarpentry);
            }
            RecipeController.reloadGlobalRecipes(hashMap);
        } else if (enumPacketType == EnumPacketType.Dialog) {
            Entity entity = Minecraft._E()._r.getEntityByID(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            NoppesUtil.openDialog(dataInputStream, (EntityNPCInterface)entity, entityPlayer);
        } else if (enumPacketType == EnumPacketType.QuestCompletion) {
            NoppesUtil.guiQuestCompletion(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.EditingNpc) {
            Entity entity = Minecraft._E()._r.getEntityByID(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            NoppesUtil.setLastNpc((EntityNPCInterface)entity);
        } else if (enumPacketType == EnumPacketType.PlayMusic) {
            MusicController.Instance.playMusic("customnpcs:Failboat103 - Excalibuuur");
        } else if (enumPacketType == EnumPacketType.PlaySound) {
            MusicController.Instance.playSound(dataInputStream.readUTF(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat());
        } else if (enumPacketType == EnumPacketType.UpdateNpc) {
            NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
            Entity entity = Minecraft._E()._r.getEntityByID(nBTTagCompound._f("EntityId"));
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            entity.readFromNBT(nBTTagCompound);
        } else if (enumPacketType == EnumPacketType.SaveRole) {
            NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
            Entity entity = Minecraft._E()._r.getEntityByID(nBTTagCompound._f("EntityId"));
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            ((EntityNPCInterface)entity).advanced.setRole(nBTTagCompound._f("Role"));
            ((EntityNPCInterface)entity).roleInterface.readEntityFromNBT(nBTTagCompound);
            NoppesUtil.setLastNpc((EntityNPCInterface)entity);
        } else if (enumPacketType == EnumPacketType.Gui) {
            EnumGuiType enumGuiType = EnumGuiType.values()[dataInputStream.readInt()];
            CustomNpcs.proxy.openGui(NoppesUtil.getLastNpc(), enumGuiType);
        } else if (enumPacketType == EnumPacketType.Particle) {
            NoppesUtil.spawnParticle(dataInputStream);
        } else if (enumPacketType == EnumPacketType.Delete) {
            Entity entity = Minecraft._E()._r.getEntityByID(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            ((EntityNPCInterface)entity).delete();
        } else if (enumPacketType == EnumPacketType.ScrollList) {
            NoppesUtil.setScrollList(dataInputStream);
        } else if (enumPacketType == EnumPacketType.ScrollData) {
            NoppesUtil.setScrollData(dataInputStream);
        } else if (enumPacketType == EnumPacketType.ScrollSelected) {
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen == null || !(guiScreen instanceof IScrollData)) {
                return;
            }
            String string = dataInputStream.readUTF();
            ((IScrollData)((Object)guiScreen)).setSelected(string);
        } else if (enumPacketType == EnumPacketType.RedstoneBlockSave) {
            NoppesUtil.saveRedstoneBlock(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.WaypointSave) {
            NoppesUtil.saveWayPointBlock(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.GuiData) {
            Object object = Minecraft._E()._B;
            if (object == null) {
                return;
            }
            if (object instanceof GuiNPCInterface2 && ((GuiNPCInterface2)object).hasSubGui()) {
                object = ((GuiNPCInterface2)object).getSubGui();
            }
            if (object instanceof GuiPda && ((GuiPda)object).currentTab instanceof IGuiData) {
                object = ((GuiPda)object).currentTab;
            }
            if (object instanceof IGuiData) {
                ((IGuiData)object).setGuiData(bsvf._a(dataInputStream));
            }
        } else if (enumPacketType == EnumPacketType.GuiError) {
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen == null || !(guiScreen instanceof IGuiError)) {
                return;
            }
            int n = dataInputStream.readInt();
            NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
            ((IGuiError)((Object)guiScreen)).setError(n, nBTTagCompound);
        } else if (enumPacketType == EnumPacketType.GuiClose) {
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen == null) {
                return;
            }
            int n = dataInputStream.readInt();
            NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
            if (guiScreen instanceof IGuiClose) {
                ((IGuiClose)((Object)guiScreen)).setClose(n, nBTTagCompound);
            }
            Minecraft minecraft = Minecraft._E();
            minecraft._a((GuiScreen)null);
            minecraft._o();
        } else if (enumPacketType == EnumPacketType.MerchantAdd) {
            MerchantRecipeList merchantRecipeList = MerchantRecipeList._a(dataInputStream);
            ItemInteractEvent.Merchant.setRecipes(merchantRecipeList);
        }
    }
}

