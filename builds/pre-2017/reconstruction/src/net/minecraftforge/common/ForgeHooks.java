/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.iurq;
import net.minecraft.util.piet;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class ForgeHooks {
    static final List<GrassEntry> grassList = new ArrayList<GrassEntry>();
    static final List<SeedEntry> seedList = new ArrayList<SeedEntry>();
    private static boolean toolInit = false;
    static HashMap<Item, List> toolClasses = new HashMap();
    static HashMap<List, Integer> toolHarvestLevels = new HashMap();
    static HashSet<List> toolEffectiveness = new HashSet();

    public static void plantGrass(World world, int n, int n2, int n3) {
        GrassEntry grassEntry = (GrassEntry)iurq._a(world.rand, grassList);
        if (grassEntry == null || grassEntry.block == null || !grassEntry.block.canBlockStay(world, n, n2, n3)) {
            return;
        }
        world.setBlock(n, n2, n3, grassEntry.block.blockID, grassEntry.metadata, 3);
    }

    public static ItemStack getGrassSeed(World world) {
        SeedEntry seedEntry = (SeedEntry)iurq._a(world.rand, seedList);
        if (seedEntry == null || seedEntry.seed == null) {
            return null;
        }
        return seedEntry.seed._l();
    }

    public static boolean canHarvestBlock(Block block, EntityPlayer entityPlayer, int n) {
        if (block.blockMaterial._l()) {
            return true;
        }
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack == null) {
            return entityPlayer.canHarvestBlock(block);
        }
        List list2 = toolClasses.get(itemStack._a());
        if (list2 == null) {
            return entityPlayer.canHarvestBlock(block);
        }
        Object[] objectArray = list2.toArray();
        String string = (String)objectArray[0];
        int n2 = (Integer)objectArray[1];
        Integer n3 = toolHarvestLevels.get(Arrays.asList(block, n, string));
        if (n3 == null) {
            return entityPlayer.canHarvestBlock(block);
        }
        return n3 <= n2;
    }

    public static boolean canToolHarvestBlock(Block block, int n, ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        List list2 = toolClasses.get(itemStack._a());
        if (list2 == null) {
            return false;
        }
        Object[] objectArray = list2.toArray();
        String string = (String)objectArray[0];
        int n2 = (Integer)objectArray[1];
        Integer n3 = toolHarvestLevels.get(Arrays.asList(block, n, string));
        return n3 != null && n3 <= n2;
    }

    public static float blockStrength(Block block, EntityPlayer entityPlayer, World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        float f = block.getBlockHardness(world, n, n2, n3);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!ForgeHooks.canHarvestBlock(block, entityPlayer, n4)) {
            float f2 = ForgeEventFactory.getBreakSpeed(entityPlayer, block, n4, 1.0f);
            return (f2 < 0.0f ? 0.0f : f2) / f / 100.0f;
        }
        return entityPlayer.getCurrentPlayerStrVsBlock(block, false, n4) / f / 30.0f;
    }

    public static boolean isToolEffective(ItemStack itemStack, Block block, int n) {
        List list2 = toolClasses.get(itemStack._a());
        return list2 != null && toolEffectiveness.contains(Arrays.asList(block, n, list2.get(0)));
    }

    static void initTools() {
        if (toolInit) {
            return;
        }
        toolInit = true;
        MinecraftForge.setToolClass(Item.pickaxeWood, "pickaxe", 0);
        MinecraftForge.setToolClass(Item.pickaxeStone, "pickaxe", 1);
        MinecraftForge.setToolClass(Item.pickaxeIron, "pickaxe", 2);
        MinecraftForge.setToolClass(Item.pickaxeGold, "pickaxe", 0);
        MinecraftForge.setToolClass(Item.pickaxeDiamond, "pickaxe", 3);
        MinecraftForge.setToolClass(Item.axeWood, "axe", 0);
        MinecraftForge.setToolClass(Item.axeStone, "axe", 1);
        MinecraftForge.setToolClass(Item.axeIron, "axe", 2);
        MinecraftForge.setToolClass(Item.axeGold, "axe", 0);
        MinecraftForge.setToolClass(Item.axeDiamond, "axe", 3);
        MinecraftForge.setToolClass(Item.shovelWood, "shovel", 0);
        MinecraftForge.setToolClass(Item.shovelStone, "shovel", 1);
        MinecraftForge.setToolClass(Item.shovelIron, "shovel", 2);
        MinecraftForge.setToolClass(Item.shovelGold, "shovel", 0);
        MinecraftForge.setToolClass(Item.shovelDiamond, "shovel", 3);
        for (Block block : hufu._a) {
            MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
        }
        for (Block block : bsws._a) {
            MinecraftForge.setBlockHarvestLevel(block, "shovel", 0);
        }
        for (Block block : bsrw._a) {
            MinecraftForge.setBlockHarvestLevel(block, "axe", 0);
        }
        MinecraftForge.setBlockHarvestLevel(Block.obsidian, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(Block.oreEmerald, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreDiamond, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.blockDiamond, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreGold, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.blockGold, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreIron, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.blockIron, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.oreLapis, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.blockLapis, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.oreRedstone, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreRedstoneGlowing, "pickaxe", 2);
        MinecraftForge.removeBlockEffectiveness(Block.oreRedstone, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(Block.obsidian, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(Block.oreRedstoneGlowing, "pickaxe");
    }

    public static int getTotalArmorValue(EntityPlayer entityPlayer) {
        int n = 0;
        for (int i = 0; i < entityPlayer.inventory._b.length; ++i) {
            ItemStack itemStack = entityPlayer.inventory._b[i];
            if (itemStack != null && itemStack._a() instanceof ISpecialArmor) {
                n += ((ISpecialArmor)((Object)itemStack._a())).getArmorDisplay(entityPlayer, itemStack, i);
                continue;
            }
            if (itemStack == null || !(itemStack._a() instanceof ItemArmor)) continue;
            n += ((ItemArmor)itemStack._a()).damageReduceAmount;
        }
        return n;
    }

    public static boolean onPickBlock(MovingObjectPosition movingObjectPosition, EntityPlayer entityPlayer, World world) {
        int n;
        ItemStack itemStack = null;
        boolean bl = entityPlayer.capabilities._d;
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
            if (block == null) {
                return false;
            }
            itemStack = block.getPickBlock(movingObjectPosition, world, n, n2, n3);
        } else {
            if (movingObjectPosition._c != EnumMovingObjectType._b || movingObjectPosition._i == null || !bl) {
                return false;
            }
            itemStack = movingObjectPosition._i.getPickedResult(movingObjectPosition);
        }
        if (itemStack == null) {
            return false;
        }
        for (n = 0; n < 9; ++n) {
            ItemStack itemStack2 = entityPlayer.inventory.getStackInSlot(n);
            if (itemStack2 == null || !itemStack2._b(itemStack) || !ItemStack._a(itemStack2, itemStack)) continue;
            entityPlayer.inventory._c = n;
            return true;
        }
        if (!bl) {
            return false;
        }
        n = entityPlayer.inventory._c();
        if (n < 0 || n >= 9) {
            n = entityPlayer.inventory._c;
        }
        entityPlayer.inventory.setInventorySlotContents(n, itemStack);
        entityPlayer.inventory._c = n;
        return true;
    }

    public static void onLivingSetAttackTarget(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        MinecraftForge.EVENT_BUS.post(new LivingSetAttackTargetEvent(entityLivingBase, entityLivingBase2));
    }

    public static boolean onLivingUpdate(EntityLivingBase entityLivingBase) {
        return MinecraftForge.EVENT_BUS.post(new LivingEvent.LivingUpdateEvent(entityLivingBase));
    }

    public static boolean onLivingAttack(EntityLivingBase entityLivingBase, DamageSource damageSource, float f) {
        return MinecraftForge.EVENT_BUS.post(new LivingAttackEvent(entityLivingBase, damageSource, f));
    }

    public static float onLivingHurt(EntityLivingBase entityLivingBase, DamageSource damageSource, float f) {
        LivingHurtEvent livingHurtEvent = new LivingHurtEvent(entityLivingBase, damageSource, f);
        return MinecraftForge.EVENT_BUS.post(livingHurtEvent) ? 0.0f : livingHurtEvent.ammount;
    }

    public static boolean onLivingDeath(EntityLivingBase entityLivingBase, DamageSource damageSource) {
        return MinecraftForge.EVENT_BUS.post(new LivingDeathEvent(entityLivingBase, damageSource));
    }

    public static boolean onLivingDrops(EntityLivingBase entityLivingBase, DamageSource damageSource, ArrayList<EntityItem> arrayList, int n, boolean bl, int n2) {
        return MinecraftForge.EVENT_BUS.post(new LivingDropsEvent(entityLivingBase, damageSource, arrayList, n, bl, n2));
    }

    public static float onLivingFall(EntityLivingBase entityLivingBase, float f) {
        LivingFallEvent livingFallEvent = new LivingFallEvent(entityLivingBase, f);
        return MinecraftForge.EVENT_BUS.post(livingFallEvent) ? 0.0f : livingFallEvent.distance;
    }

    public static boolean isLivingOnLadder(Block block, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase) {
        if (!ForgeDummyContainer.fullBoundingBoxLadders) {
            return block != null && block.isLadder(world, n, n2, n3, entityLivingBase);
        }
        AxisAlignedBB axisAlignedBB = entityLivingBase.boundingBox;
        int n4 = sajh._c(axisAlignedBB._b);
        int n5 = sajh._c(axisAlignedBB._c);
        int n6 = sajh._c(axisAlignedBB._d);
        int n7 = n5;
        while ((double)n7 < axisAlignedBB._f) {
            int n8 = n4;
            while ((double)n8 < axisAlignedBB._e) {
                int n9 = n6;
                while ((double)n9 < axisAlignedBB._g) {
                    block = Block.blocksList[world.getBlockId(n8, n7, n9)];
                    if (block != null && block.isLadder(world, n8, n7, n9, entityLivingBase)) {
                        return true;
                    }
                    ++n9;
                }
                ++n8;
            }
            ++n7;
        }
        return false;
    }

    public static void onLivingJump(EntityLivingBase entityLivingBase) {
        MinecraftForge.EVENT_BUS.post(new LivingEvent.LivingJumpEvent(entityLivingBase));
    }

    public static EntityItem onPlayerTossEvent(EntityPlayer entityPlayer, ItemStack itemStack) {
        entityPlayer.captureDrops = true;
        EntityItem entityItem = entityPlayer.dropPlayerItemWithRandomChoice(itemStack, false);
        entityPlayer.capturedDrops.clear();
        entityPlayer.captureDrops = false;
        if (entityItem == null) {
            return null;
        }
        ItemTossEvent itemTossEvent = new ItemTossEvent(entityItem, entityPlayer);
        if (MinecraftForge.EVENT_BUS.post(itemTossEvent)) {
            return null;
        }
        entityPlayer.joinEntityItemWithWorld(itemTossEvent.entityItem);
        return itemTossEvent.entityItem;
    }

    public static float getEnchantPower(World world, int n, int n2, int n3) {
        if (world.isAirBlock(n, n2, n3)) {
            return 0.0f;
        }
        Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
        return block == null ? 0.0f : block.getEnchantPowerBonus(world, n, n2, n3);
    }

    public static ChatMessageComponent onServerChatEvent(NetServerHandler netServerHandler, String string, ChatMessageComponent chatMessageComponent) {
        ServerChatEvent serverChatEvent = new ServerChatEvent(netServerHandler.playerEntity, string, chatMessageComponent);
        if (MinecraftForge.EVENT_BUS.post(serverChatEvent)) {
            return null;
        }
        return serverChatEvent.component;
    }

    public static boolean canInteractWith(EntityPlayer entityPlayer, Container container) {
        PlayerOpenContainerEvent playerOpenContainerEvent = new PlayerOpenContainerEvent(entityPlayer, container);
        MinecraftForge.EVENT_BUS.post(playerOpenContainerEvent);
        return playerOpenContainerEvent.getResult() == Event.Result.DEFAULT ? playerOpenContainerEvent.canInteractWith : playerOpenContainerEvent.getResult() == Event.Result.ALLOW;
    }

    public static BlockEvent.BreakEvent onBlockBreakEvent(World world, EnumGameType enumGameType, EntityPlayerMP entityPlayerMP, int n, int n2, int n3) {
        Object object;
        boolean bl = false;
        if (enumGameType._c() && !entityPlayerMP.isCurrentToolAdventureModeExempt(n, n2, n3)) {
            bl = true;
        } else if (enumGameType._d() && entityPlayerMP.getHeldItem() != null && entityPlayerMP.getHeldItem()._a() instanceof ItemSword) {
            bl = true;
        }
        if (world.getBlockTileEntity(n, n2, n3) == null) {
            object = new cwan(n, n2, n3, world);
            ((cwan)object)._d = 0;
            ((cwan)object)._e = 0;
            entityPlayerMP.playerNetServerHandler.func_72567_b((Packet)object);
        }
        object = Block.blocksList[world.getBlockId(n, n2, n3)];
        int n4 = world.getBlockMetadata(n, n2, n3);
        BlockEvent.BreakEvent breakEvent = new BlockEvent.BreakEvent(n, n2, n3, world, (Block)object, n4, entityPlayerMP);
        breakEvent.setCanceled(bl);
        MinecraftForge.EVENT_BUS.post(breakEvent);
        if (breakEvent.isCanceled()) {
            Packet packet;
            entityPlayerMP.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, world));
            TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
            if (tileEntity != null && (packet = tileEntity.getDescriptionPacket()) != null) {
                entityPlayerMP.playerNetServerHandler.func_72567_b(packet);
            }
        }
        return breakEvent;
    }

    static {
        grassList.add(new GrassEntry(Block.plantYellow, 0, 20));
        grassList.add(new GrassEntry(Block.plantRed, 0, 10));
        seedList.add(new SeedEntry(new ItemStack(Item.seeds), 10));
        ForgeHooks.initTools();
    }

    static class SeedEntry
    extends piet {
        public final ItemStack seed;

        public SeedEntry(ItemStack itemStack, int n) {
            super(n);
            this.seed = itemStack;
        }
    }

    static class GrassEntry
    extends piet {
        public final Block block;
        public final int metadata;

        public GrassEntry(Block block, int n, int n2) {
            super(n2);
            this.block = block;
            this.metadata = n;
        }
    }
}

