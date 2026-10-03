/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.CommonProxy;
import noppes.npcs.CustomItems;
import noppes.npcs.EntityCustomNpc;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.blocks.BlockMailbox;
import noppes.npcs.blocks.TileBlockAnvil;
import noppes.npcs.blocks.TileMailbox;
import noppes.npcs.client.ClientTickHandler;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.events.TextureLoadEvent;
import noppes.npcs.client.gui.GuiMerchantAdd;
import noppes.npcs.client.gui.GuiNpcMobSpawner;
import noppes.npcs.client.gui.GuiNpcMobSpawnerAdd;
import noppes.npcs.client.gui.GuiNpcPather;
import noppes.npcs.client.gui.GuiNpcRedstoneBlock;
import noppes.npcs.client.gui.GuiNpcRemoteEditor;
import noppes.npcs.client.gui.GuiNpcWaypoint;
import noppes.npcs.client.gui.global.GuiNPCManageBanks;
import noppes.npcs.client.gui.global.GuiNPCManageDialogs;
import noppes.npcs.client.gui.global.GuiNPCManageFactions;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.client.gui.global.GuiNPCManageTransporters;
import noppes.npcs.client.gui.global.GuiNpcManageRecipes;
import noppes.npcs.client.gui.global.GuiNpcRandomItems;
import noppes.npcs.client.gui.global.GuiQuestReward;
import noppes.npcs.client.gui.mainmenu.GuiNPCGlobalMainMenu;
import noppes.npcs.client.gui.mainmenu.GuiNPCInv;
import noppes.npcs.client.gui.mainmenu.GuiNpcAI;
import noppes.npcs.client.gui.mainmenu.GuiNpcAdvanced;
import noppes.npcs.client.gui.mainmenu.GuiNpcDisplay;
import noppes.npcs.client.gui.mainmenu.GuiNpcStats;
import noppes.npcs.client.gui.player.GuiMailbox;
import noppes.npcs.client.gui.player.GuiMailmanSend;
import noppes.npcs.client.gui.player.GuiNPCBankChest;
import noppes.npcs.client.gui.player.GuiNPCTrader;
import noppes.npcs.client.gui.player.GuiNpcCarpentryBench;
import noppes.npcs.client.gui.player.GuiNpcExchanger;
import noppes.npcs.client.gui.player.GuiNpcFollower;
import noppes.npcs.client.gui.player.GuiNpcFollowerHire;
import noppes.npcs.client.gui.player.GuiNpcResearcher;
import noppes.npcs.client.gui.player.GuiTransportSelection;
import noppes.npcs.client.gui.questtypes.GuiNpcQuestTypeItem;
import noppes.npcs.client.gui.roles.GuiGuideSetup;
import noppes.npcs.client.gui.roles.GuiNpcBankSetup;
import noppes.npcs.client.gui.roles.GuiNpcExchangerSetup;
import noppes.npcs.client.gui.roles.GuiNpcFollowerSetup;
import noppes.npcs.client.gui.roles.GuiNpcItemGiver;
import noppes.npcs.client.gui.roles.GuiNpcTraderSetup;
import noppes.npcs.client.gui.roles.GuiNpcTransporter;
import noppes.npcs.client.gui.roles.GuiSetupWorkbench;
import noppes.npcs.client.gui.roles.GuiSupplierSetup;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.model.ModelDwarfFemale;
import noppes.npcs.client.model.ModelDwarfMale;
import noppes.npcs.client.model.ModelElfFemale;
import noppes.npcs.client.model.ModelElfMale;
import noppes.npcs.client.model.ModelEnderChibi;
import noppes.npcs.client.model.ModelFurryFemale;
import noppes.npcs.client.model.ModelFurryMale;
import noppes.npcs.client.model.ModelNPCEnderman;
import noppes.npcs.client.model.ModelNPCFemale;
import noppes.npcs.client.model.ModelNPCGolem;
import noppes.npcs.client.model.ModelNPCMale;
import noppes.npcs.client.model.ModelNagaFemale;
import noppes.npcs.client.model.ModelNagaMale;
import noppes.npcs.client.model.ModelNpcCrystal;
import noppes.npcs.client.model.ModelNpcDragon;
import noppes.npcs.client.model.ModelNpcSkeleton;
import noppes.npcs.client.model.ModelNpcSlime;
import noppes.npcs.client.model.ModelOrcFemale;
import noppes.npcs.client.model.ModelOrcMale;
import noppes.npcs.client.model.ModelZombieFemale;
import noppes.npcs.client.model.ModelZombieMale;
import noppes.npcs.client.renderer.BlockCarpentryBenchRenderer;
import noppes.npcs.client.renderer.BlockMailboxRenderer;
import noppes.npcs.client.renderer.NpcItemRenderer;
import noppes.npcs.client.renderer.RenderCustomNpc;
import noppes.npcs.client.renderer.RenderNPCHumanFemale;
import noppes.npcs.client.renderer.RenderNPCHumanMale;
import noppes.npcs.client.renderer.RenderNPCHumanMaleOptimized;
import noppes.npcs.client.renderer.RenderNPCPony;
import noppes.npcs.client.renderer.RenderNpcCrystal;
import noppes.npcs.client.renderer.RenderNpcDragon;
import noppes.npcs.client.renderer.RenderNpcSlime;
import noppes.npcs.client.renderer.RenderNpcVillager;
import noppes.npcs.client.renderer.RenderProjectile;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.containers.ContainerCarpentryBench;
import noppes.npcs.containers.ContainerManageBanks;
import noppes.npcs.containers.ContainerManageRecipes;
import noppes.npcs.containers.ContainerNPCBankInterface;
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
import noppes.npcs.entity.EntityElementalStaffFX;
import noppes.npcs.entity.EntityNPCDwarfFemale;
import noppes.npcs.entity.EntityNPCDwarfMale;
import noppes.npcs.entity.EntityNPCElfFemale;
import noppes.npcs.entity.EntityNPCElfMale;
import noppes.npcs.entity.EntityNPCEnderman;
import noppes.npcs.entity.EntityNPCFurryFemale;
import noppes.npcs.entity.EntityNPCFurryMale;
import noppes.npcs.entity.EntityNPCGolem;
import noppes.npcs.entity.EntityNPCHumanFemale;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.entity.EntityNPCOrcFemale;
import noppes.npcs.entity.EntityNPCOrcMale;
import noppes.npcs.entity.EntityNPCPony;
import noppes.npcs.entity.EntityNPCVillager;
import noppes.npcs.entity.EntityNpcCrystal;
import noppes.npcs.entity.EntityNpcDragon;
import noppes.npcs.entity.EntityNpcEnderchibi;
import noppes.npcs.entity.EntityNpcMonsterFemale;
import noppes.npcs.entity.EntityNpcMonsterMale;
import noppes.npcs.entity.EntityNpcNagaFemale;
import noppes.npcs.entity.EntityNpcNagaMale;
import noppes.npcs.entity.EntityNpcSkeleton;
import noppes.npcs.entity.EntityNpcSlime;
import noppes.npcs.entity.EntityProjectile;

public class ClientProxy
extends CommonProxy {
    public static void bindTexture(ResourceLocation resourceLocation) {
        try {
            if (resourceLocation == null) {
                return;
            }
            apbu apbu2 = xpzm._E()._R();
            apbu2._a(resourceLocation);
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    @Override
    public void load() {
        super.load();
        new MusicController();
        if (Loader.isModLoaded("GloomyPlayer")) {
            RenderingRegistry.registerEntityRenderingHandler(EntityNPCHumanMale.class, new RenderNPCHumanMaleOptimized());
        } else {
            RenderingRegistry.registerEntityRenderingHandler(EntityNPCHumanMale.class, new RenderNPCHumanMale(new ModelNPCMale(0.0f), new ModelNPCMale(1.0f), new ModelNPCMale(0.5f)));
        }
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCElfMale.class, new RenderNPCHumanMale(new ModelElfMale(0.0f), new ModelElfMale(1.0f), new ModelElfMale(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCOrcMale.class, new RenderNPCHumanMale(new ModelOrcMale(0.0f), new ModelOrcMale(1.0f), new ModelOrcMale(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcMonsterMale.class, new RenderNPCHumanMale(new ModelZombieMale(0.0f), new ModelZombieMale(1.0f), new ModelZombieMale(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcSkeleton.class, new RenderNPCHumanMale(new ModelNpcSkeleton(0.0f), new ModelNpcSkeleton(1.0f), new ModelNpcSkeleton(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCDwarfMale.class, new RenderNPCHumanMale(new ModelDwarfMale(0.0f), new ModelDwarfMale(0.6f), new ModelDwarfMale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcNagaMale.class, new RenderNPCHumanMale(new ModelNagaMale(64, 64, 0.0f), new ModelNagaMale(64, 32, 1.0f), new ModelNagaMale(64, 32, 0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcEnderchibi.class, new RenderNPCHumanMale(new ModelEnderChibi(0.0f), new ModelEnderChibi(0.6f), new ModelEnderChibi(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCEnderman.class, new RenderNPCHumanMale(new ModelNPCEnderman(0.0f), new ModelNPCEnderman(0.6f), new ModelNPCEnderman(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCGolem.class, new RenderNPCHumanMale(new ModelNPCGolem(0.0f), new ModelNPCGolem(1.0f), new ModelNPCGolem(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCHumanFemale.class, new RenderNPCHumanFemale(new ModelNPCFemale(0.0f), new ModelNPCFemale(0.6f), new ModelNPCFemale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCElfFemale.class, new RenderNPCHumanFemale(new ModelElfFemale(0.0f), new ModelElfFemale(0.6f), new ModelElfFemale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCOrcFemale.class, new RenderNPCHumanFemale(new ModelOrcFemale(0.0f), new ModelOrcFemale(0.6f), new ModelOrcFemale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCDwarfFemale.class, new RenderNPCHumanFemale(new ModelDwarfFemale(0.0f), new ModelDwarfFemale(0.6f), new ModelDwarfFemale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcMonsterFemale.class, new RenderNPCHumanFemale(new ModelZombieFemale(0.0f), new ModelZombieFemale(0.6f), new ModelZombieFemale(0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcNagaFemale.class, new RenderNPCHumanFemale(new ModelNagaFemale(64, 64, 0.0f), new ModelNagaFemale(64, 32, 0.6f), new ModelNagaFemale(64, 32, 0.3f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCFurryMale.class, new RenderNPCHumanMale(new ModelFurryMale(64, 64, 0.0f), new ModelNPCMale(64, 32, 1.0f), new ModelNPCMale(64, 32, 0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCFurryFemale.class, new RenderNPCHumanFemale(new ModelFurryFemale(64, 64, 0.0f), new ModelNPCFemale(64, 32, 1.0f), new ModelNPCFemale(64, 32, 0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCVillager.class, new RenderNpcVillager());
        RenderingRegistry.registerEntityRenderingHandler(EntityNPCPony.class, new RenderNPCPony());
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcCrystal.class, new RenderNpcCrystal(new ModelNpcCrystal(0.5f)));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcDragon.class, new RenderNpcDragon(new ModelNpcDragon(0.0f), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(EntityNpcSlime.class, new RenderNpcSlime(new ModelNpcSlime(16), new ModelNpcSlime(0), 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectile.class, new RenderProjectile());
        RenderingRegistry.registerEntityRenderingHandler(EntityCustomNpc.class, new RenderCustomNpc());
        TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBlockAnvil.class, new BlockCarpentryBenchRenderer());
        BlockMailboxRenderer blockMailboxRenderer = new BlockMailboxRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(TileMailbox.class, blockMailboxRenderer);
        ((BlockMailbox)CustomItems.mailbox).renderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(blockMailboxRenderer);
        xpzm xpzm2 = xpzm._E();
        MinecraftForge.EVENT_BUS.register(new TextureLoadEvent());
    }

    @Override
    public Object getClientGuiElement(int n, EntityPlayer entityPlayer, ozlu ozlu2, int n2, int n3, int n4) {
        if (n > EnumGuiType.values().length) {
            return null;
        }
        EnumGuiType enumGuiType = EnumGuiType.values()[n];
        EntityNPCInterface entityNPCInterface = NoppesUtil.getLastNpc();
        jjgc jjgc2 = this.getContainer(enumGuiType, entityPlayer, n2, n3, n4, entityNPCInterface);
        return this.getGui(entityNPCInterface, enumGuiType, jjgc2);
    }

    private gqjz getGui(EntityNPCInterface entityNPCInterface, EnumGuiType enumGuiType, jjgc jjgc2) {
        if (enumGuiType == EnumGuiType.MainMenuDisplay) {
            if (entityNPCInterface != null) {
                return new GuiNpcDisplay(entityNPCInterface);
            }
            System.out.println("Unable to find spawned npc");
        } else {
            if (enumGuiType == EnumGuiType.MainMenuStats) {
                return new GuiNpcStats(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.MainMenuInv) {
                return new GuiNPCInv(entityNPCInterface, (ContainerNPCInv)jjgc2);
            }
            if (enumGuiType == EnumGuiType.MainMenuAdvanced) {
                return new GuiNpcAdvanced(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.QuestReward) {
                return new GuiQuestReward(entityNPCInterface, (ContainerNpcQuestReward)jjgc2);
            }
            if (enumGuiType == EnumGuiType.QuestItem) {
                return new GuiNpcQuestTypeItem(entityNPCInterface, (ContainerNpcQuestTypeItem)jjgc2);
            }
            if (enumGuiType == EnumGuiType.MovingPath) {
                return new GuiNpcPather(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.ManageFactions) {
                return new GuiNPCManageFactions(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.ManageTransport) {
                return new GuiNPCManageTransporters(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.ManageRecipes) {
                return new GuiNpcManageRecipes(entityNPCInterface, (ContainerManageRecipes)jjgc2);
            }
            if (enumGuiType == EnumGuiType.ManageDialogs) {
                return new GuiNPCManageDialogs(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.ManageQuests) {
                return new GuiNPCManageQuest(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.ManageBanks) {
                return new GuiNPCManageBanks(entityNPCInterface, (ContainerManageBanks)jjgc2);
            }
            if (enumGuiType == EnumGuiType.MainMenuGlobal) {
                return new GuiNPCGlobalMainMenu(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.MainMenuAI) {
                return new GuiNpcAI(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.PlayerFollowerHire) {
                return new GuiNpcFollowerHire(entityNPCInterface, (ContainerNPCFollowerHire)jjgc2);
            }
            if (enumGuiType == EnumGuiType.PlayerFollower) {
                return new GuiNpcFollower(entityNPCInterface, (ContainerNPCFollower)jjgc2);
            }
            if (enumGuiType == EnumGuiType.PlayerTrader) {
                return new GuiNPCTrader(entityNPCInterface, (ContainerNPCTrader)jjgc2);
            }
            if (enumGuiType == EnumGuiType.PlayerBankSmall || enumGuiType == EnumGuiType.PlayerBankUnlock || enumGuiType == EnumGuiType.PlayerBankUprade || enumGuiType == EnumGuiType.PlayerBankLarge) {
                return new GuiNPCBankChest(entityNPCInterface, (ContainerNPCBankInterface)jjgc2);
            }
            if (enumGuiType == EnumGuiType.PlayerTransporter) {
                return new GuiTransportSelection(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.PlayerAnvil) {
                return new GuiNpcCarpentryBench((ContainerCarpentryBench)jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupFollower) {
                return new GuiNpcFollowerSetup(entityNPCInterface, (ContainerNPCFollowerSetup)jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupItemGiver) {
                return new GuiNpcItemGiver(entityNPCInterface, (ContainerNpcItemGiver)jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupTrader) {
                return new GuiNpcTraderSetup(entityNPCInterface, (ContainerNPCTraderSetup)jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupExchanger) {
                return new GuiNpcExchangerSetup(entityNPCInterface, (ContainerNpcExchangerSetup)jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupSupplier) {
                return new GuiSupplierSetup(entityNPCInterface, jjgc2);
            }
            if (enumGuiType == EnumGuiType.SetupWorkbench) {
                return new GuiSetupWorkbench(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.SetupGuide) {
                return new GuiGuideSetup(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.SetupTransporter) {
                return new GuiNpcTransporter(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.SetupBank) {
                return new GuiNpcBankSetup(entityNPCInterface);
            }
            if (enumGuiType == EnumGuiType.NpcRemote && xpzm._E()._B == null) {
                return new GuiNpcRemoteEditor();
            }
            if (enumGuiType == EnumGuiType.PlayerMailman) {
                return new GuiMailmanSend();
            }
            if (enumGuiType == EnumGuiType.PlayerMailbox) {
                return new GuiMailbox();
            }
            if (enumGuiType == EnumGuiType.MerchantAdd) {
                return new GuiMerchantAdd();
            }
            if (enumGuiType == EnumGuiType.PlayerExchanger) {
                return new GuiNpcExchanger(entityNPCInterface, (ContainerNpcExchanger)jjgc2);
            }
            if (enumGuiType == EnumGuiType.RandomEquip) {
                return new GuiNpcRandomItems(entityNPCInterface, (ContainerRandomEquip)jjgc2);
            }
            if (enumGuiType == EnumGuiType.PlayerResearcher) {
                return new GuiNpcResearcher((ContainerNpcResearcher)jjgc2);
            }
        }
        return null;
    }

    @Override
    public void openGui(int n, int n2, int n3, EnumGuiType enumGuiType, EntityPlayer entityPlayer) {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._t == entityPlayer) {
            GuiNPCInterface guiNPCInterface = null;
            if (enumGuiType == EnumGuiType.RedstoneBlock) {
                guiNPCInterface = new GuiNpcRedstoneBlock(n, n2, n3);
            }
            if (enumGuiType == EnumGuiType.MobSpawner) {
                guiNPCInterface = new GuiNpcMobSpawner(n, n2, n3);
            }
            if (enumGuiType == EnumGuiType.MobSpawnerAdd) {
                guiNPCInterface = new GuiNpcMobSpawnerAdd();
            }
            if (enumGuiType == EnumGuiType.Waypoint) {
                guiNPCInterface = new GuiNpcWaypoint(n, n2, n3);
            }
            if (guiNPCInterface != null) {
                xpzm2._a(guiNPCInterface);
            }
        }
    }

    @Override
    public void openGui(EntityNPCInterface entityNPCInterface, EnumGuiType enumGuiType) {
        xpzm xpzm2 = xpzm._E();
        jjgc jjgc2 = this.getContainer(enumGuiType, xpzm2._t, 0, 0, 0, entityNPCInterface);
        gqjz gqjz2 = this.getGui(entityNPCInterface, enumGuiType, jjgc2);
        if (gqjz2 != null) {
            xpzm2._a(gqjz2);
        }
    }

    @Override
    public void openGui(EntityPlayer entityPlayer, Object object) {
        xpzm xpzm2 = xpzm._E();
        if (entityPlayer.field_70170_p.field_72995_K && object instanceof gqjz && object != null) {
            xpzm2._a((gqjz)object);
        }
    }

    @Override
    public void spawnParticle(EntityLivingBase entityLivingBase, String string, Object ... objectArray) {
        if (string.equals("Spell")) {
            int n = (Integer)objectArray[0];
            int n2 = (Integer)objectArray[1];
            for (int i = 0; i < n2; ++i) {
                Random random = entityLivingBase.field_70170_p.field_73012_v;
                double d = (random.nextDouble() - 0.5) * (double)entityLivingBase.field_70130_N;
                double d2 = entityLivingBase.func_70047_e();
                double d3 = (random.nextDouble() - 0.5) * (double)entityLivingBase.field_70130_N;
                double d4 = (random.nextDouble() - 0.5) * 2.0;
                double d5 = -random.nextDouble();
                double d6 = (random.nextDouble() - 0.5) * 2.0;
                xpzm._E()._w._a(new EntityElementalStaffFX(entityLivingBase, d, d2, d3, d4, d5, d6, n));
            }
        }
    }

    @Override
    public boolean hasClient() {
        return true;
    }

    @Override
    public EntityPlayer getPlayer() {
        return xpzm._E()._t;
    }

    @Override
    public void registerItem(int n) {
        MinecraftForgeClient.registerItemRenderer(n, new NpcItemRenderer());
    }

    @Override
    public Object loadResource(String string) {
        return new ResourceLocation(string);
    }
}

