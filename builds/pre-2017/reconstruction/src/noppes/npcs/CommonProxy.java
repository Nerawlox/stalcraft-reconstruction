/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.containers.ContainerCarpentryBench;
import noppes.npcs.containers.ContainerManageBanks;
import noppes.npcs.containers.ContainerManageRecipes;
import noppes.npcs.containers.ContainerMerchantAdd;
import noppes.npcs.containers.ContainerNPCBankLarge;
import noppes.npcs.containers.ContainerNPCBankSmall;
import noppes.npcs.containers.ContainerNPCBankUnlock;
import noppes.npcs.containers.ContainerNPCBankUpgrade;
import noppes.npcs.containers.ContainerNPCFollower;
import noppes.npcs.containers.ContainerNPCFollowerHire;
import noppes.npcs.containers.ContainerNPCFollowerSetup;
import noppes.npcs.containers.ContainerNPCInv;
import noppes.npcs.containers.ContainerNPCTrader;
import noppes.npcs.containers.ContainerNPCTraderSetup;
import noppes.npcs.containers.ContainerNpcExchanger;
import noppes.npcs.containers.ContainerNpcExchangerSetup;
import noppes.npcs.containers.ContainerNpcItemGiver;
import noppes.npcs.containers.ContainerNpcQuestReward;
import noppes.npcs.containers.ContainerNpcQuestTypeItem;
import noppes.npcs.containers.ContainerNpcResearcher;
import noppes.npcs.containers.ContainerRandomEquip;
import noppes.npcs.containers.ContainerSupplierSetup;
import noppes.npcs.events.ItemInteractEvent;

public class CommonProxy
implements IGuiHandler {
    public boolean newVersionAvailable = false;
    public int revision = 4;

    public void load() {
    }

    public Container getServerGuiElement(EnumGuiType enumGuiType, EntityPlayer entityPlayer, int n, int n2, int n3) {
        EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayer);
        return this.getContainer(enumGuiType, entityPlayer, n, n2, n3, entityNPCInterface);
    }

    @Override
    public Object getServerGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayer);
        return this.getContainer(EnumGuiType.values()[n], entityPlayer, n2, n3, n4, entityNPCInterface);
    }

    public Container getContainer(EnumGuiType enumGuiType, EntityPlayer entityPlayer, int n, int n2, int n3, EntityNPCInterface entityNPCInterface) {
        if (enumGuiType == EnumGuiType.MainMenuInv) {
            return new ContainerNPCInv(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerBankSmall) {
            return new ContainerNPCBankSmall(entityPlayer, n, n2);
        }
        if (enumGuiType == EnumGuiType.PlayerBankUnlock) {
            return new ContainerNPCBankUnlock(entityPlayer, n, n2);
        }
        if (enumGuiType == EnumGuiType.PlayerBankUprade) {
            return new ContainerNPCBankUpgrade(entityPlayer, n, n2);
        }
        if (enumGuiType == EnumGuiType.PlayerBankLarge) {
            return new ContainerNPCBankLarge(entityPlayer, n, n2);
        }
        if (enumGuiType == EnumGuiType.PlayerFollowerHire) {
            return new ContainerNPCFollowerHire(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerFollower) {
            return new ContainerNPCFollower(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerTrader) {
            return new ContainerNPCTrader(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerAnvil) {
            return new ContainerCarpentryBench(entityPlayer.inventory, entityPlayer.worldObj, n, n2, n3);
        }
        if (enumGuiType == EnumGuiType.SetupItemGiver) {
            return new ContainerNpcItemGiver(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.SetupTrader) {
            return new ContainerNPCTraderSetup(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.SetupFollower) {
            return new ContainerNPCFollowerSetup(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.QuestReward) {
            return new ContainerNpcQuestReward(entityPlayer);
        }
        if (enumGuiType == EnumGuiType.QuestItem) {
            return new ContainerNpcQuestTypeItem(entityPlayer);
        }
        if (enumGuiType == EnumGuiType.ManageRecipes) {
            return new ContainerManageRecipes(entityPlayer, n);
        }
        if (enumGuiType == EnumGuiType.ManageBanks) {
            return new ContainerManageBanks(entityPlayer);
        }
        if (enumGuiType == EnumGuiType.MerchantAdd) {
            return new ContainerMerchantAdd(entityPlayer.inventory, ItemInteractEvent.Merchant, entityPlayer.worldObj);
        }
        if (enumGuiType == EnumGuiType.SetupExchanger) {
            return new ContainerNpcExchangerSetup(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerExchanger) {
            return new ContainerNpcExchanger(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.RandomEquip) {
            return new ContainerRandomEquip(entityNPCInterface, entityPlayer);
        }
        if (enumGuiType == EnumGuiType.PlayerResearcher) {
            return new ContainerNpcResearcher(entityPlayer);
        }
        if (enumGuiType == EnumGuiType.SetupSupplier) {
            return new ContainerSupplierSetup(entityNPCInterface, entityPlayer);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int n, EntityPlayer entityPlayer, World world, int n2, int n3, int n4) {
        return null;
    }

    public void openGui(EntityNPCInterface entityNPCInterface, EnumGuiType enumGuiType) {
    }

    public void openGui(int n, int n2, int n3, EnumGuiType enumGuiType, EntityPlayer entityPlayer) {
    }

    public void openGui(EntityPlayer entityPlayer, Object object) {
    }

    public void spawnParticle(EntityLivingBase entityLivingBase, String string, Object ... objectArray) {
    }

    public boolean hasClient() {
        return false;
    }

    public EntityPlayer getPlayer() {
        return null;
    }

    public void registerItem(int n) {
    }

    public Object loadResource(String string) {
        return null;
    }
}

