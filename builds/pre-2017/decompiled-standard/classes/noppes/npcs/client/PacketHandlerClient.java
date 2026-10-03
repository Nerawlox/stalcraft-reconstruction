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
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.tdpx;
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
    public void onPacketData(jjpj jjpj2, jjqf jjqf2, Player player) {
        if (jjqf2.field_73630_a.equals("CNPCs Client")) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(jjqf2.field_73629_c))));
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
                entityPlayer.func_71035_c(string);
            }
        } else if (enumPacketType == EnumPacketType.Message) {
            String string = tdpx._a(dataInputStream.readUTF());
            String string3 = dataInputStream.readUTF();
            QuestAchievement questAchievement = new QuestAchievement(string3, string);
            xpzm._E()._I._a(questAchievement);
            xpzm._E()._I._e = questAchievement.func_75989_e();
        } else if (enumPacketType == EnumPacketType.SyncRecipes) {
            bsyv bsyv2 = bsvf._a(dataInputStream)._n("recipes");
            HashMap<Integer, RecipeCarpentry> hashMap = new HashMap<Integer, RecipeCarpentry>();
            if (bsyv2 == null) {
                return;
            }
            for (int i = 0; i < bsyv2._d(); ++i) {
                RecipeCarpentry recipeCarpentry = new RecipeCarpentry();
                recipeCarpentry.readNBT((qoac)bsyv2._b(i));
                hashMap.put(recipeCarpentry.id, recipeCarpentry);
            }
            RecipeController.reloadGlobalRecipes(hashMap);
        } else if (enumPacketType == EnumPacketType.Dialog) {
            Entity entity = xpzm._E()._r.func_73045_a(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            NoppesUtil.openDialog(dataInputStream, (EntityNPCInterface)entity, entityPlayer);
        } else if (enumPacketType == EnumPacketType.QuestCompletion) {
            NoppesUtil.guiQuestCompletion(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.EditingNpc) {
            Entity entity = xpzm._E()._r.func_73045_a(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            NoppesUtil.setLastNpc((EntityNPCInterface)entity);
        } else if (enumPacketType == EnumPacketType.PlayMusic) {
            MusicController.Instance.playMusic("customnpcs:Failboat103 - Excalibuuur");
        } else if (enumPacketType == EnumPacketType.PlaySound) {
            MusicController.Instance.playSound(dataInputStream.readUTF(), dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readFloat());
        } else if (enumPacketType == EnumPacketType.UpdateNpc) {
            qoac qoac2 = bsvf._a(dataInputStream);
            Entity entity = xpzm._E()._r.func_73045_a(qoac2._f("EntityId"));
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            entity.func_70020_e(qoac2);
        } else if (enumPacketType == EnumPacketType.SaveRole) {
            qoac qoac3 = bsvf._a(dataInputStream);
            Entity entity = xpzm._E()._r.func_73045_a(qoac3._f("EntityId"));
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            ((EntityNPCInterface)entity).advanced.setRole(qoac3._f("Role"));
            ((EntityNPCInterface)entity).roleInterface.readEntityFromNBT(qoac3);
            NoppesUtil.setLastNpc((EntityNPCInterface)entity);
        } else if (enumPacketType == EnumPacketType.Gui) {
            EnumGuiType enumGuiType = EnumGuiType.values()[dataInputStream.readInt()];
            CustomNpcs.proxy.openGui(NoppesUtil.getLastNpc(), enumGuiType);
        } else if (enumPacketType == EnumPacketType.Particle) {
            NoppesUtil.spawnParticle(dataInputStream);
        } else if (enumPacketType == EnumPacketType.Delete) {
            Entity entity = xpzm._E()._r.func_73045_a(dataInputStream.readInt());
            if (entity == null || !(entity instanceof EntityNPCInterface)) {
                return;
            }
            ((EntityNPCInterface)entity).delete();
        } else if (enumPacketType == EnumPacketType.ScrollList) {
            NoppesUtil.setScrollList(dataInputStream);
        } else if (enumPacketType == EnumPacketType.ScrollData) {
            NoppesUtil.setScrollData(dataInputStream);
        } else if (enumPacketType == EnumPacketType.ScrollSelected) {
            gqjz gqjz2 = xpzm._E()._B;
            if (gqjz2 == null || !(gqjz2 instanceof IScrollData)) {
                return;
            }
            String string = dataInputStream.readUTF();
            ((IScrollData)((Object)gqjz2)).setSelected(string);
        } else if (enumPacketType == EnumPacketType.RedstoneBlockSave) {
            NoppesUtil.saveRedstoneBlock(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.WaypointSave) {
            NoppesUtil.saveWayPointBlock(entityPlayer, dataInputStream);
        } else if (enumPacketType == EnumPacketType.GuiData) {
            Object object = xpzm._E()._B;
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
            gqjz gqjz3 = xpzm._E()._B;
            if (gqjz3 == null || !(gqjz3 instanceof IGuiError)) {
                return;
            }
            int n = dataInputStream.readInt();
            qoac qoac4 = bsvf._a(dataInputStream);
            ((IGuiError)((Object)gqjz3)).setError(n, qoac4);
        } else if (enumPacketType == EnumPacketType.GuiClose) {
            gqjz gqjz4 = xpzm._E()._B;
            if (gqjz4 == null) {
                return;
            }
            int n = dataInputStream.readInt();
            qoac qoac5 = bsvf._a(dataInputStream);
            if (gqjz4 instanceof IGuiClose) {
                ((IGuiClose)((Object)gqjz4)).setClose(n, qoac5);
            }
            xpzm xpzm2 = xpzm._E();
            xpzm2._a((gqjz)null);
            xpzm2._o();
        } else if (enumPacketType == EnumPacketType.MerchantAdd) {
            ywfi ywfi2 = ywfi._a(dataInputStream);
            ItemInteractEvent.Merchant.func_70930_a(ywfi2);
        }
    }
}

