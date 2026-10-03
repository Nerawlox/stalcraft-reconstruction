/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockComparator;
import net.minecraft.block.BlockDetectorRail;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockMushroomCap;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RotationHelper {
    private static final ForgeDirection[] UP_DOWN_AXES = new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.DOWN};
    private static final Map<BlockType, BiMap<Integer, ForgeDirection>> MAPPINGS = new HashMap<BlockType, BiMap<Integer, ForgeDirection>>();

    public static ForgeDirection[] getValidVanillaBlockRotations(Block block) {
        return block instanceof BlockBed || block instanceof BlockPumpkin || block instanceof BlockFenceGate || block instanceof BlockEndPortalFrame || block instanceof matf || block instanceof woni || block instanceof twlh || block instanceof BlockDetectorRail || block instanceof yuxu || block instanceof BlockChest || block instanceof BlockEnderChest || block instanceof BlockFurnace || block instanceof cuwq || block.blockID == Block.signWall.blockID || block.blockID == Block.signPost.blockID || block instanceof BlockDoor || block instanceof BlockRail || block instanceof scbx || block instanceof BlockRedstoneRepeater || block instanceof BlockComparator || block instanceof matg || block instanceof BlockMushroomCap || block instanceof lort || block instanceof uznu || block instanceof BlockAnvil ? UP_DOWN_AXES : ForgeDirection.VALID_DIRECTIONS;
    }

    public static boolean rotateVanillaBlock(Block block, World world, int n, int n2, int n3, ForgeDirection forgeDirection) {
        if (world.isRemote) {
            return false;
        }
        if (forgeDirection == ForgeDirection.UP || forgeDirection == ForgeDirection.DOWN) {
            if (block instanceof BlockBed || block instanceof BlockPumpkin || block instanceof BlockFenceGate || block instanceof BlockEndPortalFrame || block instanceof matf || block instanceof woni) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 3, BlockType.BED);
            }
            if (block instanceof BlockRail) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 15, BlockType.RAIL);
            }
            if (block instanceof twlh || block instanceof BlockDetectorRail) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.RAIL_POWERED);
            }
            if (block instanceof yuxu) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 3, BlockType.STAIR);
            }
            if (block instanceof BlockChest || block instanceof BlockEnderChest || block instanceof BlockFurnace || block instanceof cuwq || block.blockID == Block.signWall.blockID) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.CHEST);
            }
            if (block.blockID == Block.signPost.blockID) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 15, BlockType.SIGNPOST);
            }
            if (block instanceof BlockDoor) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 3, BlockType.DOOR);
            }
            if (block instanceof scbx) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.BUTTON);
            }
            if (block instanceof BlockRedstoneRepeater || block instanceof BlockComparator) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 3, BlockType.REDSTONE_REPEATER);
            }
            if (block instanceof matg) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 3, BlockType.TRAPDOOR);
            }
            if (block instanceof BlockMushroomCap) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 15, BlockType.MUSHROOM_CAP);
            }
            if (block instanceof lort) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 15, BlockType.VINE);
            }
            if (block instanceof uznu) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.SKULL);
            }
            if (block instanceof BlockAnvil) {
                return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 1, BlockType.ANVIL);
            }
        }
        if (block instanceof zxyw) {
            return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 12, BlockType.LOG);
        }
        if (block instanceof BlockDispenser || block instanceof BlockPistonBase || block instanceof BlockPistonExtension || block instanceof BlockHopper) {
            return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.DISPENSER);
        }
        if (block instanceof matb) {
            return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 15, BlockType.TORCH);
        }
        if (block instanceof tfgg) {
            return RotationHelper.rotateBlock(world, n, n2, n3, forgeDirection, 7, BlockType.LEVER);
        }
        return false;
    }

    private static boolean rotateBlock(World world, int n, int n2, int n3, ForgeDirection forgeDirection, int n4, BlockType blockType) {
        int n5 = world.getBlockMetadata(n, n2, n3);
        if (blockType == BlockType.DOOR && (n5 & 8) == 8) {
            return false;
        }
        int n6 = n5 & ~n4;
        int n7 = RotationHelper.rotateMetadata(forgeDirection, blockType, n5 & n4);
        if (n7 == -1) {
            return false;
        }
        world.func_72921_c(n, n2, n3, n7 & n4 | n6, 3);
        return true;
    }

    private static int rotateMetadata(ForgeDirection forgeDirection, BlockType blockType, int n) {
        if (blockType == BlockType.RAIL || blockType == BlockType.RAIL_POWERED) {
            if (n == 0 || n == 1) {
                return ~n & 1;
            }
            if (n >= 2 && n <= 5) {
                blockType = BlockType.RAIL_ASCENDING;
            }
            if (n >= 6 && n <= 9 && blockType == BlockType.RAIL) {
                blockType = BlockType.RAIL_CORNER;
            }
        }
        if (blockType == BlockType.SIGNPOST) {
            return forgeDirection == ForgeDirection.UP ? (n + 4) % 16 : (n + 12) % 16;
        }
        if (blockType == BlockType.LEVER && (forgeDirection == ForgeDirection.UP || forgeDirection == ForgeDirection.DOWN)) {
            switch (n) {
                case 5: {
                    return 6;
                }
                case 6: {
                    return 5;
                }
                case 7: {
                    return 0;
                }
                case 0: {
                    return 7;
                }
            }
        }
        if (blockType == BlockType.MUSHROOM_CAP) {
            blockType = n % 2 == 0 ? BlockType.MUSHROOM_CAP_SIDE : BlockType.MUSHROOM_CAP_CORNER;
        }
        if (blockType == BlockType.VINE) {
            return n << 1 | (n & 8) >> 3;
        }
        ForgeDirection forgeDirection2 = RotationHelper.metadataToDirection(blockType, n);
        ForgeDirection forgeDirection3 = forgeDirection2.getRotation(forgeDirection);
        return RotationHelper.directionToMetadata(blockType, forgeDirection3);
    }

    private static ForgeDirection metadataToDirection(BlockType blockType, int n) {
        BiMap<Integer, ForgeDirection> biMap;
        if (blockType == BlockType.LEVER) {
            if (n == 6) {
                n = 5;
            } else if (n == 0) {
                n = 7;
            }
        }
        if (MAPPINGS.containsKey((Object)blockType) && (biMap = MAPPINGS.get((Object)blockType)).containsKey(n)) {
            return (ForgeDirection)((Object)biMap.get(n));
        }
        if (blockType == BlockType.TORCH) {
            return ForgeDirection.getOrientation(6 - n);
        }
        if (blockType == BlockType.STAIR) {
            return ForgeDirection.getOrientation(5 - n);
        }
        if (blockType == BlockType.CHEST || blockType == BlockType.DISPENSER || blockType == BlockType.SKULL) {
            return ForgeDirection.getOrientation(n);
        }
        if (blockType == BlockType.BUTTON) {
            return ForgeDirection.getOrientation(6 - n);
        }
        if (blockType == BlockType.TRAPDOOR) {
            return ForgeDirection.getOrientation(n + 2).getOpposite();
        }
        return ForgeDirection.UNKNOWN;
    }

    private static int directionToMetadata(BlockType blockType, ForgeDirection forgeDirection) {
        BiMap<ForgeDirection, Integer> biMap;
        if ((blockType == BlockType.LOG || blockType == BlockType.ANVIL) && forgeDirection.offsetX + forgeDirection.offsetY + forgeDirection.offsetZ < 0) {
            forgeDirection = forgeDirection.getOpposite();
        }
        if (MAPPINGS.containsKey((Object)blockType) && (biMap = MAPPINGS.get((Object)blockType).inverse()).containsKey((Object)forgeDirection)) {
            return (Integer)biMap.get((Object)forgeDirection);
        }
        if (blockType == BlockType.TORCH && forgeDirection.ordinal() >= 1) {
            return 6 - forgeDirection.ordinal();
        }
        if (blockType == BlockType.STAIR) {
            return 5 - forgeDirection.ordinal();
        }
        if (blockType == BlockType.CHEST || blockType == BlockType.DISPENSER || blockType == BlockType.SKULL) {
            return forgeDirection.ordinal();
        }
        if (blockType == BlockType.BUTTON && forgeDirection.ordinal() >= 2) {
            return 6 - forgeDirection.ordinal();
        }
        if (blockType == BlockType.TRAPDOOR) {
            return forgeDirection.getOpposite().ordinal() - 2;
        }
        return -1;
    }

    static {
        HashBiMap<Integer, ForgeDirection> hashBiMap = HashBiMap.create(3);
        hashBiMap.put(0, ForgeDirection.UP);
        hashBiMap.put(4, ForgeDirection.EAST);
        hashBiMap.put(8, ForgeDirection.SOUTH);
        MAPPINGS.put(BlockType.LOG, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(0, ForgeDirection.SOUTH);
        hashBiMap.put(1, ForgeDirection.WEST);
        hashBiMap.put(2, ForgeDirection.NORTH);
        hashBiMap.put(3, ForgeDirection.EAST);
        MAPPINGS.put(BlockType.BED, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(2, ForgeDirection.EAST);
        hashBiMap.put(3, ForgeDirection.WEST);
        hashBiMap.put(4, ForgeDirection.NORTH);
        hashBiMap.put(5, ForgeDirection.SOUTH);
        MAPPINGS.put(BlockType.RAIL_ASCENDING, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(6, ForgeDirection.WEST);
        hashBiMap.put(7, ForgeDirection.NORTH);
        hashBiMap.put(8, ForgeDirection.EAST);
        hashBiMap.put(9, ForgeDirection.SOUTH);
        MAPPINGS.put(BlockType.RAIL_CORNER, hashBiMap);
        hashBiMap = HashBiMap.create(6);
        hashBiMap.put(1, ForgeDirection.EAST);
        hashBiMap.put(2, ForgeDirection.WEST);
        hashBiMap.put(3, ForgeDirection.SOUTH);
        hashBiMap.put(4, ForgeDirection.NORTH);
        hashBiMap.put(5, ForgeDirection.UP);
        hashBiMap.put(7, ForgeDirection.DOWN);
        MAPPINGS.put(BlockType.LEVER, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(0, ForgeDirection.WEST);
        hashBiMap.put(1, ForgeDirection.NORTH);
        hashBiMap.put(2, ForgeDirection.EAST);
        hashBiMap.put(3, ForgeDirection.SOUTH);
        MAPPINGS.put(BlockType.DOOR, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(0, ForgeDirection.NORTH);
        hashBiMap.put(1, ForgeDirection.EAST);
        hashBiMap.put(2, ForgeDirection.SOUTH);
        hashBiMap.put(3, ForgeDirection.WEST);
        MAPPINGS.put(BlockType.REDSTONE_REPEATER, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(1, ForgeDirection.EAST);
        hashBiMap.put(3, ForgeDirection.SOUTH);
        hashBiMap.put(7, ForgeDirection.NORTH);
        hashBiMap.put(9, ForgeDirection.WEST);
        MAPPINGS.put(BlockType.MUSHROOM_CAP_CORNER, hashBiMap);
        hashBiMap = HashBiMap.create(4);
        hashBiMap.put(2, ForgeDirection.NORTH);
        hashBiMap.put(4, ForgeDirection.WEST);
        hashBiMap.put(6, ForgeDirection.EAST);
        hashBiMap.put(8, ForgeDirection.SOUTH);
        MAPPINGS.put(BlockType.MUSHROOM_CAP_SIDE, hashBiMap);
        hashBiMap = HashBiMap.create(2);
        hashBiMap.put(0, ForgeDirection.SOUTH);
        hashBiMap.put(1, ForgeDirection.EAST);
        MAPPINGS.put(BlockType.ANVIL, hashBiMap);
    }

    private static enum BlockType {
        LOG,
        DISPENSER,
        BED,
        RAIL,
        RAIL_POWERED,
        RAIL_ASCENDING,
        RAIL_CORNER,
        TORCH,
        STAIR,
        CHEST,
        SIGNPOST,
        DOOR,
        LEVER,
        BUTTON,
        REDSTONE_REPEATER,
        TRAPDOOR,
        MUSHROOM_CAP,
        MUSHROOM_CAP_CORNER,
        MUSHROOM_CAP_SIDE,
        VINE,
        SKULL,
        ANVIL;

    }
}

