/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class ItemMap
extends nvwc {
    public ItemMap(int n) {
        super(n);
        this.setHasSubtypes(true);
    }

    @SideOnly(value=Side.CLIENT)
    public static thdd _a(short s, World world) {
        String string = "map_" + s;
        thdd thdd2 = (thdd)world.loadItemData(thdd.class, string);
        if (thdd2 == null) {
            thdd2 = new thdd(string);
            world.setItemData(string, thdd2);
        }
        return thdd2;
    }

    public thdd _a(ItemStack itemStack, World world) {
        String string = "map_" + itemStack._j();
        thdd thdd2 = (thdd)world.loadItemData(thdd.class, string);
        if (thdd2 == null && !world.isRemote) {
            itemStack._b(world.getUniqueDataId("map"));
            string = "map_" + itemStack._j();
            thdd2 = new thdd(string);
            thdd2._d = (byte)3;
            int n = 128 * (1 << thdd2._d);
            thdd2._a = Math.round((float)world.getWorldInfo()._c() / (float)n) * n;
            thdd2._b = Math.round(world.getWorldInfo()._e() / n) * n;
            thdd2._c = world.provider._i;
            thdd2.markDirty();
            world.setItemData(string, thdd2);
        }
        return thdd2;
    }

    public void _a(World world, Entity entity, thdd thdd2) {
        if (world.provider._i == thdd2._c && entity instanceof EntityPlayer) {
            int n = 128;
            int n2 = 128;
            int n3 = 1 << thdd2._d;
            int n4 = thdd2._a;
            int n5 = thdd2._b;
            int n6 = sajh._c(entity.posX - (double)n4) / n3 + n / 2;
            int n7 = sajh._c(entity.posZ - (double)n5) / n3 + n2 / 2;
            int n8 = 128 / n3;
            if (world.provider._g) {
                n8 /= 2;
            }
            ihdx ihdx2 = thdd2._a((EntityPlayer)entity);
            ++ihdx2._g;
            for (int i = n6 - n8 + 1; i < n6 + n8; ++i) {
                if ((i & 0xF) != (ihdx2._g & 0xF)) continue;
                int n9 = 255;
                int n10 = 0;
                double d = 0.0;
                for (int j = n7 - n8 - 1; j < n7 + n8; ++j) {
                    byte by;
                    byte by2;
                    int n11;
                    int n12;
                    int n13;
                    int n14;
                    int n15;
                    if (i < 0 || j < -1 || i >= n || j >= n2) continue;
                    int n16 = i - n6;
                    int n17 = j - n7;
                    boolean bl = n16 * n16 + n17 * n17 > (n8 - 2) * (n8 - 2);
                    int n18 = (n4 / n3 + i - n / 2) * n3;
                    int n19 = (n5 / n3 + j - n2 / 2) * n3;
                    int[] nArray = new int[Block.blocksList.length];
                    Chunk chunk = world.getChunkFromBlockCoords(n18, n19);
                    if (chunk._i()) continue;
                    int n20 = n18 & 0xF;
                    int n21 = n19 & 0xF;
                    int n22 = 0;
                    double d2 = 0.0;
                    if (world.provider._g) {
                        n15 = n18 + n19 * 231871;
                        if (((n15 = n15 * n15 * 31287121 + n15 * 11) >> 20 & 1) == 0) {
                            int n23 = Block.dirt.blockID;
                            nArray[n23] = nArray[n23] + 10;
                        } else {
                            int n24 = Block.stone.blockID;
                            nArray[n24] = nArray[n24] + 10;
                        }
                        d2 = 100.0;
                    } else {
                        for (n15 = 0; n15 < n3; ++n15) {
                            for (n14 = 0; n14 < n3; ++n14) {
                                n13 = chunk._b(n15 + n20, n14 + n21) + 1;
                                int n25 = 0;
                                if (n13 > 1) {
                                    boolean bl2;
                                    do {
                                        bl2 = true;
                                        n25 = chunk._d(n15 + n20, n13 - 1, n14 + n21);
                                        if (n25 == 0) {
                                            bl2 = false;
                                        } else if (n13 > 0 && n25 > 0 && Block.blocksList[n25].blockMaterial._K == MapColor._b) {
                                            bl2 = false;
                                        }
                                        if (bl2) continue;
                                        if (--n13 <= 0) break;
                                        n25 = chunk._d(n15 + n20, n13 - 1, n14 + n21);
                                    } while (n13 > 0 && !bl2);
                                    if (n13 > 0 && n25 != 0 && Block.blocksList[n25].blockMaterial._d()) {
                                        int n26;
                                        n12 = n13 - 1;
                                        n11 = 0;
                                        do {
                                            n26 = chunk._d(n15 + n20, n12--, n14 + n21);
                                            ++n22;
                                        } while (n12 > 0 && n26 != 0 && Block.blocksList[n26].blockMaterial._d());
                                    }
                                }
                                d2 += (double)n13 / (double)(n3 * n3);
                                int n27 = n25;
                                nArray[n27] = nArray[n27] + 1;
                            }
                        }
                    }
                    n22 /= n3 * n3;
                    n15 = 0;
                    n14 = 0;
                    for (n13 = 0; n13 < Block.blocksList.length; ++n13) {
                        if (nArray[n13] <= n15) continue;
                        n14 = n13;
                        n15 = nArray[n13];
                    }
                    double d3 = (d2 - d) * 4.0 / (double)(n3 + 4) + ((double)(i + j & 1) - 0.5) * 0.4;
                    n11 = 1;
                    if (d3 > 0.6) {
                        n11 = 2;
                    }
                    if (d3 < -0.6) {
                        n11 = 0;
                    }
                    n12 = 0;
                    if (n14 > 0) {
                        MapColor mapColor = Block.blocksList[n14].blockMaterial._K;
                        if (mapColor == MapColor._n) {
                            d3 = (double)n22 * 0.1 + (double)(i + j & 1) * 0.2;
                            n11 = 1;
                            if (d3 < 0.5) {
                                n11 = 2;
                            }
                            if (d3 > 0.9) {
                                n11 = 0;
                            }
                        }
                        n12 = mapColor._q;
                    }
                    d = d2;
                    if (j < 0 || n16 * n16 + n17 * n17 >= n8 * n8 || bl && (i + j & 1) == 0 || (by2 = thdd2._e[i + j * n]) == (by = (byte)(n12 * 4 + n11))) continue;
                    if (n9 > j) {
                        n9 = j;
                    }
                    if (n10 < j) {
                        n10 = j;
                    }
                    thdd2._e[i + j * n] = by;
                }
                if (n9 > n10) continue;
                thdd2._a(i, n9, n10);
            }
        }
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int n, boolean bl) {
        if (!world.isRemote) {
            thdd thdd2 = this._a(itemStack, world);
            if (entity instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                thdd2._a(entityPlayer, itemStack);
            }
            if (bl) {
                this._a(world, entity, thdd2);
            }
        }
    }

    @Override
    public Packet _a(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        byte[] byArray = this._a(itemStack, world)._a(itemStack, world, entityPlayer);
        return byArray == null ? null : new yexp((short)Item.map.itemID, (short)itemStack._j(), byArray);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack._p() && itemStack._q()._o("map_is_scaling")) {
            thdd thdd2 = Item.map._a(itemStack, world);
            itemStack._b(world.getUniqueDataId("map"));
            thdd thdd3 = new thdd("map_" + itemStack._j());
            thdd3._d = (byte)(thdd2._d + 1);
            if (thdd3._d > 4) {
                thdd3._d = (byte)4;
            }
            thdd3._a = thdd2._a;
            thdd3._b = thdd2._b;
            thdd3._c = thdd2._c;
            thdd3.markDirty();
            world.setItemData("map_" + itemStack._j(), thdd3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        thdd thdd2 = this._a(itemStack, entityPlayer.worldObj);
        if (bl) {
            if (thdd2 == null) {
                list2.add("Unknown map");
            } else {
                list2.add("Scaling at 1:" + (1 << thdd2._d));
                list2.add("(Level " + thdd2._d + "/" + 4 + ")");
            }
        }
    }
}

