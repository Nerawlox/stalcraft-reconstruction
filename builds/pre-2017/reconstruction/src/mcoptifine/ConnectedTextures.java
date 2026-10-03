/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import gloomyfolken.mods.asm.GloomyStartHooks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mcoptifine.Config;
import mcoptifine.ConnectedProperties;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;

public class ConnectedTextures {
    private static ConnectedProperties[][] blockProperties = null;
    private static ConnectedProperties[][] tileProperties = null;
    private static boolean multipass = false;
    private static boolean defaultGlassTexture = false;
    private static final int BOTTOM = 0;
    private static final int TOP = 1;
    private static final int EAST = 2;
    private static final int WEST = 3;
    private static final int NORTH = 4;
    private static final int SOUTH = 5;
    private static final String[] propSuffixes = new String[]{"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int[] ctmIndexes = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 0, 0, 0, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 0, 0, 0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 0, 0, 0, 0, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0, 0, 0, 0, 0};

    public static Icon getConnectedTexture(IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon) {
        Icon icon2;
        if (iBlockAccess == null) {
            return icon;
        }
        Icon icon3 = ConnectedTextures.getConnectedTextureSingle(iBlockAccess, block, n, n2, n3, n4, icon, true);
        if (!multipass) {
            return icon3;
        }
        if (icon3 == icon) {
            return icon3;
        }
        Icon icon4 = icon3;
        for (int i = 0; i < 3 && (icon2 = ConnectedTextures.getConnectedTextureSingle(iBlockAccess, block, n, n2, n3, n4, icon4, false)) != icon4; ++i) {
            icon4 = icon2;
        }
        return icon4;
    }

    public static Icon getConnectedTextureSingle(IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, boolean bl) {
        int n5;
        Object object;
        ConnectedProperties[] connectedPropertiesArray;
        if (!(icon instanceof TextureAtlasSprite)) {
            return icon;
        }
        TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)icon;
        int n6 = textureAtlasSprite.getIndexInMap();
        int n7 = -1;
        if (tileProperties != null && Tessellator.instance.defaultTexture && n6 >= 0 && n6 < tileProperties.length && (connectedPropertiesArray = tileProperties[n6]) != null) {
            if (n7 < 0) {
                n7 = iBlockAccess.getBlockMetadata(n, n2, n3);
            }
            if ((object = ConnectedTextures.getConnectedTexture(connectedPropertiesArray, iBlockAccess, block, n, n2, n3, n4, (Icon)textureAtlasSprite, n7)) != null) {
                return object;
            }
        }
        if (blockProperties != null && bl && (n5 = block.blockID) >= 0 && n5 < blockProperties.length && (object = blockProperties[n5]) != null) {
            Icon icon2;
            if (n7 < 0) {
                n7 = iBlockAccess.getBlockMetadata(n, n2, n3);
            }
            if ((icon2 = ConnectedTextures.getConnectedTexture(object, iBlockAccess, block, n, n2, n3, n4, (Icon)textureAtlasSprite, n7)) != null) {
                return icon2;
            }
        }
        return icon;
    }

    public static ConnectedProperties getConnectedProperties(IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon) {
        int n5;
        Object object;
        ConnectedProperties[] connectedPropertiesArray;
        if (iBlockAccess == null) {
            return null;
        }
        if (!(icon instanceof TextureAtlasSprite)) {
            return null;
        }
        TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)icon;
        int n6 = textureAtlasSprite.getIndexInMap();
        int n7 = -1;
        if (tileProperties != null && Tessellator.instance.defaultTexture && n6 >= 0 && n6 < tileProperties.length && (connectedPropertiesArray = tileProperties[n6]) != null) {
            if (n7 < 0) {
                n7 = iBlockAccess.getBlockMetadata(n, n2, n3);
            }
            if ((object = ConnectedTextures.getConnectedProperties(connectedPropertiesArray, iBlockAccess, block, n, n2, n3, n4, textureAtlasSprite, n7)) != null) {
                return object;
            }
        }
        if (blockProperties != null && (n5 = block.blockID) >= 0 && n5 < blockProperties.length && (object = blockProperties[n5]) != null) {
            ConnectedProperties connectedProperties;
            if (n7 < 0) {
                n7 = iBlockAccess.getBlockMetadata(n, n2, n3);
            }
            if ((connectedProperties = ConnectedTextures.getConnectedProperties(object, iBlockAccess, block, n, n2, n3, n4, textureAtlasSprite, n7)) != null) {
                return connectedProperties;
            }
        }
        return null;
    }

    private static Icon getConnectedTexture(ConnectedProperties[] connectedPropertiesArray, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        for (int i = 0; i < connectedPropertiesArray.length; ++i) {
            Icon icon2;
            ConnectedProperties connectedProperties = connectedPropertiesArray[i];
            if (connectedProperties == null || (icon2 = ConnectedTextures.getConnectedTexture(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5)) == null) continue;
            return icon2;
        }
        return null;
    }

    private static ConnectedProperties getConnectedProperties(ConnectedProperties[] connectedPropertiesArray, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        for (int i = 0; i < connectedPropertiesArray.length; ++i) {
            Icon icon2;
            ConnectedProperties connectedProperties = connectedPropertiesArray[i];
            if (connectedProperties == null || (icon2 = ConnectedTextures.getConnectedTexture(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5)) == null) continue;
            return connectedProperties;
        }
        return null;
    }

    private static Icon getConnectedTexture(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        if (n2 >= connectedProperties.minHeight && n2 <= connectedProperties.maxHeight) {
            int n6;
            if (connectedProperties.biomes != null) {
                BiomeGenBase biomeGenBase = iBlockAccess.getBiomeGenForCoords(n, n3);
                n6 = 0;
                for (int i = 0; i < connectedProperties.biomes.length; ++i) {
                    BiomeGenBase biomeGenBase2 = connectedProperties.biomes[i];
                    if (biomeGenBase != biomeGenBase2) continue;
                    n6 = 1;
                    break;
                }
                if (n6 == 0) {
                    return null;
                }
            }
            boolean bl = block instanceof zxyw;
            if (n4 >= 0 && connectedProperties.faces != 63) {
                n6 = n4;
                if (bl) {
                    n6 = ConnectedTextures.fixWoodSide(iBlockAccess, n, n2, n3, n4, n5);
                }
                if ((1 << n6 & connectedProperties.faces) == 0) {
                    return null;
                }
            }
            n6 = n5;
            if (bl) {
                n6 = n5 & 3;
            }
            if (connectedProperties.metadatas != null) {
                int[] nArray = connectedProperties.metadatas;
                boolean bl2 = false;
                for (int i = 0; i < nArray.length; ++i) {
                    if (nArray[i] != n6) continue;
                    bl2 = true;
                    break;
                }
                if (!bl2) {
                    return null;
                }
            }
            switch (connectedProperties.method) {
                case 1: {
                    return ConnectedTextures.getConnectedTextureCtm(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5);
                }
                case 2: {
                    return ConnectedTextures.getConnectedTextureHorizontal(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5);
                }
                case 3: {
                    return ConnectedTextures.getConnectedTextureTop(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5);
                }
                case 4: {
                    return ConnectedTextures.getConnectedTextureRandom(connectedProperties, n, n2, n3, n4);
                }
                case 5: {
                    return ConnectedTextures.getConnectedTextureRepeat(connectedProperties, n, n2, n3, n4);
                }
                case 6: {
                    return ConnectedTextures.getConnectedTextureVertical(connectedProperties, iBlockAccess, block, n, n2, n3, n4, icon, n5);
                }
                case 7: {
                    return ConnectedTextures.getConnectedTextureFixed(connectedProperties);
                }
            }
            return null;
        }
        return null;
    }

    private static int fixWoodSide(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, int n5) {
        int n6 = (n5 & 0xC) >> 2;
        switch (n6) {
            case 0: {
                return n4;
            }
            case 1: {
                switch (n4) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 5;
                    }
                    default: {
                        return n4;
                    }
                    case 4: {
                        return 1;
                    }
                    case 5: 
                }
                return 0;
            }
            case 2: {
                switch (n4) {
                    case 0: {
                        return 2;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 1;
                    }
                    case 3: {
                        return 0;
                    }
                }
                return n4;
            }
            case 3: {
                return 2;
            }
        }
        return n4;
    }

    private static Icon getConnectedTextureRandom(ConnectedProperties connectedProperties, int n, int n2, int n3, int n4) {
        if (connectedProperties.tileIcons.length == 1) {
            return connectedProperties.tileIcons[0];
        }
        int n5 = n4 / connectedProperties.symmetry * connectedProperties.symmetry;
        int n6 = Config.getRandom(n, n2, n3, n5) & Integer.MAX_VALUE;
        int n7 = 0;
        if (connectedProperties.weights == null) {
            n7 = n6 % connectedProperties.tileIcons.length;
        } else {
            int n8 = n6 % connectedProperties.sumAllWeights;
            int[] nArray = connectedProperties.sumWeights;
            for (int i = 0; i < nArray.length; ++i) {
                if (n8 >= nArray[i]) continue;
                n7 = i;
                break;
            }
        }
        return connectedProperties.tileIcons[n7];
    }

    private static Icon getConnectedTextureFixed(ConnectedProperties connectedProperties) {
        return connectedProperties.tileIcons[0];
    }

    private static Icon getConnectedTextureRepeat(ConnectedProperties connectedProperties, int n, int n2, int n3, int n4) {
        if (connectedProperties.tileIcons.length == 1) {
            return connectedProperties.tileIcons[0];
        }
        int n5 = 0;
        int n6 = 0;
        switch (n4) {
            case 0: {
                n5 = n;
                n6 = n3;
                break;
            }
            case 1: {
                n5 = n;
                n6 = n3;
                break;
            }
            case 2: {
                n5 = -n - 1;
                n6 = -n2;
                break;
            }
            case 3: {
                n5 = n;
                n6 = -n2;
                break;
            }
            case 4: {
                n5 = n3;
                n6 = -n2;
                break;
            }
            case 5: {
                n5 = -n3 - 1;
                n6 = -n2;
            }
        }
        n6 %= connectedProperties.height;
        if ((n5 %= connectedProperties.width) < 0) {
            n5 += connectedProperties.width;
        }
        if (n6 < 0) {
            n6 += connectedProperties.height;
        }
        int n7 = n6 * connectedProperties.width + n5;
        return connectedProperties.tileIcons[n7];
    }

    private static Icon getConnectedTextureCtm(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        boolean[] blArray = new boolean[6];
        switch (n4) {
            case 0: 
            case 1: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3, n4, icon, n5);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3, n4, icon, n5);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 + 1, n4, icon, n5);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 - 1, n4, icon, n5);
                break;
            }
            case 2: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3, n4, icon, n5);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3, n4, icon, n5);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3, n4, icon, n5);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5);
                break;
            }
            case 3: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3, n4, icon, n5);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3, n4, icon, n5);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3, n4, icon, n5);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5);
                break;
            }
            case 4: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 - 1, n4, icon, n5);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 + 1, n4, icon, n5);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3, n4, icon, n5);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5);
                break;
            }
            case 5: {
                blArray[0] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 + 1, n4, icon, n5);
                blArray[1] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 - 1, n4, icon, n5);
                blArray[2] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3, n4, icon, n5);
                blArray[3] = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5);
            }
        }
        int n6 = 0;
        if (blArray[0] & !blArray[1] & !blArray[2] & !blArray[3]) {
            n6 = 3;
        } else if (!blArray[0] & blArray[1] & !blArray[2] & !blArray[3]) {
            n6 = 1;
        } else if (!blArray[0] & !blArray[1] & blArray[2] & !blArray[3]) {
            n6 = 12;
        } else if (!blArray[0] & !blArray[1] & !blArray[2] & blArray[3]) {
            n6 = 36;
        } else if (blArray[0] & blArray[1] & !blArray[2] & !blArray[3]) {
            n6 = 2;
        } else if (!blArray[0] & !blArray[1] & blArray[2] & blArray[3]) {
            n6 = 24;
        } else if (blArray[0] & !blArray[1] & blArray[2] & !blArray[3]) {
            n6 = 15;
        } else if (blArray[0] & !blArray[1] & !blArray[2] & blArray[3]) {
            n6 = 39;
        } else if (!blArray[0] & blArray[1] & blArray[2] & !blArray[3]) {
            n6 = 13;
        } else if (!blArray[0] & blArray[1] & !blArray[2] & blArray[3]) {
            n6 = 37;
        } else if (!blArray[0] & blArray[1] & blArray[2] & blArray[3]) {
            n6 = 25;
        } else if (blArray[0] & !blArray[1] & blArray[2] & blArray[3]) {
            n6 = 27;
        } else if (blArray[0] & blArray[1] & !blArray[2] & blArray[3]) {
            n6 = 38;
        } else if (blArray[0] & blArray[1] & blArray[2] & !blArray[3]) {
            n6 = 14;
        } else if (blArray[0] & blArray[1] & blArray[2] & blArray[3]) {
            n6 = 26;
        }
        if (!Config.isConnectedTexturesFancy()) {
            return connectedProperties.tileIcons[n6];
        }
        boolean[] blArray2 = new boolean[6];
        switch (n4) {
            case 0: 
            case 1: {
                blArray2[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3 + 1, n4, icon, n5);
                blArray2[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3 + 1, n4, icon, n5);
                blArray2[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3 - 1, n4, icon, n5);
                blArray2[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3 - 1, n4, icon, n5);
                break;
            }
            case 2: {
                blArray2[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2 - 1, n3, n4, icon, n5);
                blArray2[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2 - 1, n3, n4, icon, n5);
                blArray2[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2 + 1, n3, n4, icon, n5);
                blArray2[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2 + 1, n3, n4, icon, n5);
                break;
            }
            case 3: {
                blArray2[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2 - 1, n3, n4, icon, n5);
                blArray2[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2 - 1, n3, n4, icon, n5);
                blArray2[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2 + 1, n3, n4, icon, n5);
                blArray2[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2 + 1, n3, n4, icon, n5);
                break;
            }
            case 4: {
                blArray2[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3 + 1, n4, icon, n5);
                blArray2[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3 - 1, n4, icon, n5);
                blArray2[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3 + 1, n4, icon, n5);
                blArray2[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3 - 1, n4, icon, n5);
                break;
            }
            case 5: {
                blArray2[0] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3 - 1, n4, icon, n5);
                blArray2[1] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3 + 1, n4, icon, n5);
                blArray2[2] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3 - 1, n4, icon, n5);
                boolean bl = blArray2[3] = !ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3 + 1, n4, icon, n5);
            }
        }
        if (n6 == 13 && blArray2[0]) {
            n6 = 4;
        }
        if (n6 == 15 && blArray2[1]) {
            n6 = 5;
        }
        if (n6 == 37 && blArray2[2]) {
            n6 = 16;
        }
        if (n6 == 39 && blArray2[3]) {
            n6 = 17;
        }
        if (n6 == 14 && blArray2[0] && blArray2[1]) {
            n6 = 7;
        }
        if (n6 == 25 && blArray2[0] && blArray2[2]) {
            n6 = 6;
        }
        if (n6 == 27 && blArray2[3] && blArray2[1]) {
            n6 = 19;
        }
        if (n6 == 38 && blArray2[3] && blArray2[2]) {
            n6 = 18;
        }
        if (n6 == 14 && !blArray2[0] && blArray2[1]) {
            n6 = 31;
        }
        if (n6 == 25 && blArray2[0] && !blArray2[2]) {
            n6 = 30;
        }
        if (n6 == 27 && !blArray2[3] && blArray2[1]) {
            n6 = 41;
        }
        if (n6 == 38 && blArray2[3] && !blArray2[2]) {
            n6 = 40;
        }
        if (n6 == 14 && blArray2[0] && !blArray2[1]) {
            n6 = 29;
        }
        if (n6 == 25 && !blArray2[0] && blArray2[2]) {
            n6 = 28;
        }
        if (n6 == 27 && blArray2[3] && !blArray2[1]) {
            n6 = 43;
        }
        if (n6 == 38 && !blArray2[3] && blArray2[2]) {
            n6 = 42;
        }
        if (n6 == 26 && blArray2[0] && blArray2[1] && blArray2[2] && blArray2[3]) {
            n6 = 46;
        }
        if (n6 == 26 && !blArray2[0] && blArray2[1] && blArray2[2] && blArray2[3]) {
            n6 = 9;
        }
        if (n6 == 26 && blArray2[0] && !blArray2[1] && blArray2[2] && blArray2[3]) {
            n6 = 21;
        }
        if (n6 == 26 && blArray2[0] && blArray2[1] && !blArray2[2] && blArray2[3]) {
            n6 = 8;
        }
        if (n6 == 26 && blArray2[0] && blArray2[1] && blArray2[2] && !blArray2[3]) {
            n6 = 20;
        }
        if (n6 == 26 && blArray2[0] && blArray2[1] && !blArray2[2] && !blArray2[3]) {
            n6 = 11;
        }
        if (n6 == 26 && !blArray2[0] && !blArray2[1] && blArray2[2] && blArray2[3]) {
            n6 = 22;
        }
        if (n6 == 26 && !blArray2[0] && blArray2[1] && !blArray2[2] && blArray2[3]) {
            n6 = 23;
        }
        if (n6 == 26 && blArray2[0] && !blArray2[1] && blArray2[2] && !blArray2[3]) {
            n6 = 10;
        }
        if (n6 == 26 && blArray2[0] && !blArray2[1] && !blArray2[2] && blArray2[3]) {
            n6 = 34;
        }
        if (n6 == 26 && !blArray2[0] && blArray2[1] && blArray2[2] && !blArray2[3]) {
            n6 = 35;
        }
        if (n6 == 26 && blArray2[0] && !blArray2[1] && !blArray2[2] && !blArray2[3]) {
            n6 = 32;
        }
        if (n6 == 26 && !blArray2[0] && blArray2[1] && !blArray2[2] && !blArray2[3]) {
            n6 = 33;
        }
        if (n6 == 26 && !blArray2[0] && !blArray2[1] && blArray2[2] && !blArray2[3]) {
            n6 = 44;
        }
        if (n6 == 26 && !blArray2[0] && !blArray2[1] && !blArray2[2] && blArray2[3]) {
            n6 = 45;
        }
        return connectedProperties.tileIcons[n6];
    }

    private static boolean isNeighbour(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        int n6 = iBlockAccess.getBlockId(n, n2, n3);
        if (connectedProperties.connect == 2) {
            Block block2 = Block.blocksList[n6];
            if (block2 == null) {
                return false;
            }
            Icon icon2 = n4 >= 0 ? block2.getBlockTexture(iBlockAccess, n, n2, n3, n4) : block2.getBlockTexture(iBlockAccess, n, n2, n3, 1);
            return icon2 == icon;
        }
        if (connectedProperties.connect == 3) {
            Block block3 = Block.blocksList[n6];
            return block3 == null ? false : block3.blockMaterial == block.blockMaterial;
        }
        return n6 == block.blockID && iBlockAccess.getBlockMetadata(n, n2, n3) == n5;
    }

    private static Icon getConnectedTextureHorizontal(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        if (n4 != 0 && n4 != 1) {
            boolean bl = false;
            boolean bl2 = false;
            switch (n4) {
                case 2: {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3, n4, icon, n5);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3, n4, icon, n5);
                    break;
                }
                case 3: {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n - 1, n2, n3, n4, icon, n5);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n + 1, n2, n3, n4, icon, n5);
                    break;
                }
                case 4: {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 - 1, n4, icon, n5);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 + 1, n4, icon, n5);
                    break;
                }
                case 5: {
                    bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 + 1, n4, icon, n5);
                    bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2, n3 - 1, n4, icon, n5);
                }
            }
            boolean bl3 = true;
            int n6 = bl ? (bl2 ? 1 : 2) : (bl2 ? 0 : 3);
            return connectedProperties.tileIcons[n6];
        }
        return null;
    }

    private static Icon getConnectedTextureVertical(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        if (n4 != 0 && n4 != 1) {
            boolean bl = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 - 1, n3, n4, icon, n5);
            boolean bl2 = ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5);
            boolean bl3 = true;
            int n6 = bl ? (bl2 ? 1 : 2) : (bl2 ? 0 : 3);
            return connectedProperties.tileIcons[n6];
        }
        return null;
    }

    private static Icon getConnectedTextureTop(ConnectedProperties connectedProperties, IBlockAccess iBlockAccess, Block block, int n, int n2, int n3, int n4, Icon icon, int n5) {
        return n4 != 0 && n4 != 1 ? (ConnectedTextures.isNeighbour(connectedProperties, iBlockAccess, block, n, n2 + 1, n3, n4, icon, n5) ? connectedProperties.tileIcons[0] : null) : null;
    }

    public static boolean isConnectedGlassPanes() {
        return Config.isConnectedTextures() && defaultGlassTexture;
    }

    public static void updateIcons(sctd sctd2) {
        blockProperties = null;
        tileProperties = null;
        defaultGlassTexture = false;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Optional<Object> optional = Minecraft._E().__al.stream().filter(object -> object instanceof yvjs).filter(object -> ((yvjs)object).resourcePackFile == GloomyStartHooks._a).findFirst();
        if (optional.isPresent()) {
            ResourceLocation resourceLocation;
            yvjs yvjs2 = (yvjs)optional.get();
            yvjs yvjs3 = yvjs2;
            boolean bl = yvjs3.resourceExists(resourceLocation = new ResourceLocation("textures/blocks/glass.png"));
            defaultGlassTexture = !bl;
            Object[] objectArray = ConnectedTextures.collectFiles(yvjs3, "ctm/", ".properties");
            Arrays.sort(objectArray);
            for (int i = 0; i < objectArray.length; ++i) {
                String string = "mcpatcher/" + (String)objectArray[i];
                Config.dbg("ConnectedTextures: " + string);
                try {
                    ResourceLocation resourceLocation2 = new ResourceLocation(string);
                    InputStream inputStream = yvjs3.getInputStream(resourceLocation2);
                    if (inputStream == null) {
                        Config.warn("ConnectedTextures file not found: " + string);
                        continue;
                    }
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    ConnectedProperties connectedProperties = new ConnectedProperties(properties, string);
                    if (!connectedProperties.isValid(string)) continue;
                    connectedProperties.updateIcons(sctd2);
                    ConnectedTextures.addToTileList(connectedProperties, arrayList);
                    ConnectedTextures.addToBlockList(connectedProperties, arrayList2);
                    continue;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    Config.warn("ConnectedTextures file not found: " + string);
                    continue;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        blockProperties = ConnectedTextures.propertyListToArray(arrayList2);
        tileProperties = ConnectedTextures.propertyListToArray(arrayList);
        multipass = ConnectedTextures.detectMultipass();
        Config.dbg("Multipass connected textures: " + multipass);
    }

    private static boolean detectMultipass() {
        ConnectedProperties[] connectedPropertiesArray;
        int n;
        ArrayList<ConnectedProperties> arrayList = new ArrayList<ConnectedProperties>();
        for (n = 0; n < tileProperties.length; ++n) {
            connectedPropertiesArray = tileProperties[n];
            if (connectedPropertiesArray == null) continue;
            arrayList.addAll(Arrays.asList(connectedPropertiesArray));
        }
        for (n = 0; n < blockProperties.length; ++n) {
            connectedPropertiesArray = blockProperties[n];
            if (connectedPropertiesArray == null) continue;
            arrayList.addAll(Arrays.asList(connectedPropertiesArray));
        }
        ConnectedProperties[] connectedPropertiesArray2 = arrayList.toArray(new ConnectedProperties[arrayList.size()]);
        HashSet<Icon> hashSet = new HashSet<Icon>();
        HashSet<Icon> hashSet2 = new HashSet<Icon>();
        for (int i = 0; i < connectedPropertiesArray2.length; ++i) {
            ConnectedProperties connectedProperties = connectedPropertiesArray2[i];
            if (connectedProperties.matchTileIcons != null) {
                hashSet.addAll(Arrays.asList(connectedProperties.matchTileIcons));
            }
            if (connectedProperties.tileIcons == null) continue;
            hashSet2.addAll(Arrays.asList(connectedProperties.tileIcons));
        }
        hashSet.retainAll(hashSet2);
        return !hashSet.isEmpty();
    }

    private static ConnectedProperties[][] propertyListToArray(List list2) {
        ConnectedProperties[][] connectedPropertiesArray = new ConnectedProperties[list2.size()][];
        for (int i = 0; i < list2.size(); ++i) {
            List list3 = (List)list2.get(i);
            if (list3 == null) continue;
            ConnectedProperties[] connectedPropertiesArray2 = list3.toArray(new ConnectedProperties[list3.size()]);
            connectedPropertiesArray[i] = connectedPropertiesArray2;
        }
        return connectedPropertiesArray;
    }

    private static void addToTileList(ConnectedProperties connectedProperties, List list2) {
        if (connectedProperties.matchTileIcons != null) {
            for (int i = 0; i < connectedProperties.matchTileIcons.length; ++i) {
                Icon icon = connectedProperties.matchTileIcons[i];
                if (!(icon instanceof TextureAtlasSprite)) {
                    Config.warn("Icon is not TextureAtlasSprite: " + icon + ", name: " + icon.getIconName());
                    continue;
                }
                TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)icon;
                int n = textureAtlasSprite.getIndexInMap();
                if (n < 0) {
                    Config.warn("Invalid tile ID: " + n + ", icon: " + textureAtlasSprite.getIconName());
                    continue;
                }
                ConnectedTextures.addToList(connectedProperties, list2, n);
            }
        }
    }

    private static void addToBlockList(ConnectedProperties connectedProperties, List list2) {
        if (connectedProperties.matchBlocks != null) {
            for (int i = 0; i < connectedProperties.matchBlocks.length; ++i) {
                int n = connectedProperties.matchBlocks[i];
                if (n < 0) {
                    Config.warn("Invalid block ID: " + n);
                    continue;
                }
                ConnectedTextures.addToList(connectedProperties, list2, n);
            }
        }
    }

    private static void addToList(ConnectedProperties connectedProperties, List list2, int n) {
        while (n >= list2.size()) {
            list2.add(null);
        }
        ArrayList<ConnectedProperties> arrayList = (ArrayList<ConnectedProperties>)list2.get(n);
        if (arrayList == null) {
            arrayList = new ArrayList<ConnectedProperties>();
            list2.set(n, arrayList);
        }
        arrayList.add(connectedProperties);
    }

    private static String[] collectFiles(fnrl fnrl2, String string, String string2) {
        if (fnrl2 instanceof DefaultResourcePack) {
            return ConnectedTextures.collectFilesDefault(fnrl2);
        }
        if (!(fnrl2 instanceof AbstractResourcePack)) {
            return new String[0];
        }
        AbstractResourcePack abstractResourcePack = (AbstractResourcePack)fnrl2;
        File file = new File(abstractResourcePack.resourcePackFile, "assets/minecraft/mcpatcher/");
        return file == null ? new String[]{} : (file.isDirectory() ? ConnectedTextures.collectFilesFolder(file, "", string, string2) : (file.isFile() ? ConnectedTextures.collectFilesZIP(file, string, string2) : new String[]{}));
    }

    private static String[] collectFilesDefault(fnrl fnrl2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"mcpatcher/ctm/default/bookshelf.properties", "mcpatcher/ctm/default/glass.properties", "mcpatcher/ctm/default/glasspane.properties", "mcpatcher/ctm/default/sandstone.properties"};
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (!fnrl2.resourceExists(resourceLocation)) continue;
            arrayList.add(string);
        }
        String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
        return stringArray2;
    }

    private static String[] collectFilesFolder(File file, String string, String string2, String string3) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string4 = "assets/minecraft/";
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return new String[0];
        }
        for (int i = 0; i < fileArray.length; ++i) {
            String string5;
            File file2 = fileArray[i];
            if (file2.isFile()) {
                string5 = string + file2.getName();
                if (!string5.startsWith(string2) || !string5.endsWith(string3)) continue;
                arrayList.add(string5);
                continue;
            }
            if (!file2.isDirectory()) continue;
            string5 = string + file2.getName() + "/";
            String[] stringArray = ConnectedTextures.collectFilesFolder(file2, string5, string2, string3);
            for (int j = 0; j < stringArray.length; ++j) {
                String string6 = stringArray[j];
                arrayList.add(string6);
            }
        }
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    private static String[] collectFilesZIP(File file, String string, String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = "assets/minecraft/";
        try {
            String[] stringArray;
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                stringArray = enumeration.nextElement();
                String string4 = stringArray.getName();
                if (!string4.startsWith(string3) || !(string4 = string4.substring(string3.length())).startsWith(string) || !string4.endsWith(string2)) continue;
                arrayList.add(string4);
            }
            zipFile.close();
            stringArray = arrayList.toArray(new String[arrayList.size()]);
            return stringArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return new String[0];
        }
    }

    public static int getPaneTextureIndex(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return bl2 && bl ? (bl3 ? (bl4 ? 34 : 50) : (bl4 ? 18 : 2)) : (bl2 && !bl ? (bl3 ? (bl4 ? 35 : 51) : (bl4 ? 19 : 3)) : (!bl2 && bl ? (bl3 ? (bl4 ? 33 : 49) : (bl4 ? 17 : 1)) : (bl3 ? (bl4 ? 32 : 48) : (bl4 ? 16 : 0))));
    }

    public static int getReversePaneTextureIndex(int n) {
        int n2 = n % 16;
        return n2 == 1 ? n + 2 : (n2 == 3 ? n - 2 : n);
    }

    public static Icon getCtmTexture(ConnectedProperties connectedProperties, int n, Icon icon) {
        if (connectedProperties.method != 1) {
            return icon;
        }
        if (n >= 0 && n < ctmIndexes.length) {
            int n2 = ctmIndexes[n];
            Icon[] iconArray = connectedProperties.tileIcons;
            return n2 >= 0 && n2 < iconArray.length ? iconArray[n2] : icon;
        }
        return icon;
    }
}

