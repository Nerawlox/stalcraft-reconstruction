/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import net.minecraftforge.common.ForgeDirection;

public class RotationHelper {
    private static final ForgeDirection[] UP_DOWN_AXES = new ForgeDirection[]{ForgeDirection.UP, ForgeDirection.DOWN};
    private static final Map<BlockType, BiMap<Integer, ForgeDirection>> MAPPINGS = new HashMap<BlockType, BiMap<Integer, ForgeDirection>>();

    public static ForgeDirection[] getValidVanillaBlockRotations(twgu twgu2) {
        return twgu2 instanceof gqbt || twgu2 instanceof wosr || twgu2 instanceof kloa || twgu2 instanceof uigs || twgu2 instanceof matf || twgu2 instanceof woni || twgu2 instanceof twlh || twgu2 instanceof vlkn || twgu2 instanceof yuxu || twgu2 instanceof ydso || twgu2 instanceof mrqv || twgu2 instanceof nuxm || twgu2 instanceof cuwq || twgu2.field_71990_ca == twgu.field_72042_aI.field_71990_ca || twgu2.field_71990_ca == twgu.field_72053_aD.field_71990_ca || twgu2 instanceof nutn || twgu2 instanceof vlpj || twgu2 instanceof scbx || twgu2 instanceof hcgl || twgu2 instanceof aool || twgu2 instanceof matg || twgu2 instanceof wopv || twgu2 instanceof lort || twgu2 instanceof uznu || twgu2 instanceof scce ? UP_DOWN_AXES : ForgeDirection.VALID_DIRECTIONS;
    }

    public static boolean rotateVanillaBlock(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        if (ozlu2.field_72995_K) {
            return false;
        }
        if (forgeDirection == ForgeDirection.UP || forgeDirection == ForgeDirection.DOWN) {
            if (twgu2 instanceof gqbt || twgu2 instanceof wosr || twgu2 instanceof kloa || twgu2 instanceof uigs || twgu2 instanceof matf || twgu2 instanceof woni) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 3, BlockType.BED);
            }
            if (twgu2 instanceof vlpj) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 15, BlockType.RAIL);
            }
            if (twgu2 instanceof twlh || twgu2 instanceof vlkn) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.RAIL_POWERED);
            }
            if (twgu2 instanceof yuxu) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 3, BlockType.STAIR);
            }
            if (twgu2 instanceof ydso || twgu2 instanceof mrqv || twgu2 instanceof nuxm || twgu2 instanceof cuwq || twgu2.field_71990_ca == twgu.field_72042_aI.field_71990_ca) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.CHEST);
            }
            if (twgu2.field_71990_ca == twgu.field_72053_aD.field_71990_ca) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 15, BlockType.SIGNPOST);
            }
            if (twgu2 instanceof nutn) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 3, BlockType.DOOR);
            }
            if (twgu2 instanceof scbx) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.BUTTON);
            }
            if (twgu2 instanceof hcgl || twgu2 instanceof aool) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 3, BlockType.REDSTONE_REPEATER);
            }
            if (twgu2 instanceof matg) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 3, BlockType.TRAPDOOR);
            }
            if (twgu2 instanceof wopv) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 15, BlockType.MUSHROOM_CAP);
            }
            if (twgu2 instanceof lort) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 15, BlockType.VINE);
            }
            if (twgu2 instanceof uznu) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.SKULL);
            }
            if (twgu2 instanceof scce) {
                return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 1, BlockType.ANVIL);
            }
        }
        if (twgu2 instanceof zxyw) {
            return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 12, BlockType.LOG);
        }
        if (twgu2 instanceof ejzs || twgu2 instanceof cdvp || twgu2 instanceof hcdp || twgu2 instanceof ndvl) {
            return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.DISPENSER);
        }
        if (twgu2 instanceof matb) {
            return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 15, BlockType.TORCH);
        }
        if (twgu2 instanceof tfgg) {
            return RotationHelper.rotateBlock(ozlu2, n, n2, n3, forgeDirection, 7, BlockType.LEVER);
        }
        return false;
    }

    private static boolean rotateBlock(ozlu ozlu2, int n, int n2, int n3, ForgeDirection forgeDirection, int n4, BlockType blockType) {
        int n5 = ozlu2.func_72805_g(n, n2, n3);
        if (blockType == BlockType.DOOR && (n5 & 8) == 8) {
            return false;
        }
        int n6 = n5 & ~n4;
        int n7 = RotationHelper.rotateMetadata(forgeDirection, blockType, n5 & n4);
        if (n7 == -1) {
            return false;
        }
        ozlu2.func_72921_c(n, n2, n3, n7 & n4 | n6, 3);
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

