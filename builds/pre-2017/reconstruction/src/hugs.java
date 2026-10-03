/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayerFactory;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class hugs
extends Item {
    public static final String[] _a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final String[] _b = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    public static final int[] _c = new int[]{0x1E1B1B, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 0xABABAB, 0x434343, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 0xF0F0F0};
    @SideOnly(value=Side.CLIENT)
    public Icon[] _d;

    public hugs(int n) {
        super(n);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIconFromDamage(int n) {
        int n2 = sajh._a(n, 0, 15);
        return this._d[n2];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int n = sajh._a(itemStack._j(), 0, 15);
        return super.getUnlocalizedName() + "." + _a[n];
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!entityPlayer.canPlayerEdit(n, n2, n3, n4, itemStack)) {
            return false;
        }
        if (itemStack._j() == 15) {
            if (hugs._a(itemStack, world, n, n2, n3, entityPlayer)) {
                if (!world.isRemote) {
                    world.playAuxSFX(2005, n, n2, n3, 0);
                }
                return true;
            }
        } else if (itemStack._j() == 3) {
            int n5 = world.getBlockId(n, n2, n3);
            int n6 = world.getBlockMetadata(n, n2, n3);
            if (n5 == Block.wood.blockID && zxyw._c(n6) == 3) {
                if (n4 == 0) {
                    return false;
                }
                if (n4 == 1) {
                    return false;
                }
                if (n4 == 2) {
                    --n3;
                }
                if (n4 == 3) {
                    ++n3;
                }
                if (n4 == 4) {
                    --n;
                }
                if (n4 == 5) {
                    ++n;
                }
                if (world.isAirBlock(n, n2, n3)) {
                    int n7 = Block.blocksList[Block.cocoaPlant.blockID].onBlockPlaced(world, n, n2, n3, n4, f, f2, f3, 0);
                    world.setBlock(n, n2, n3, Block.cocoaPlant.blockID, n7, 2);
                    if (!entityPlayer.capabilities._d) {
                        --itemStack._b;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean _a(ItemStack itemStack, World world, int n, int n2, int n3) {
        return hugs._a(itemStack, world, n, n2, n3, FakePlayerFactory.getMinecraft(world));
    }

    public static boolean _a(ItemStack itemStack, World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4 = world.getBlockId(n, n2, n3);
        BonemealEvent bonemealEvent = new BonemealEvent(entityPlayer, world, n4, n, n2, n3);
        if (MinecraftForge.EVENT_BUS.post(bonemealEvent)) {
            return false;
        }
        if (bonemealEvent.getResult() == Event.Result.ALLOW) {
            if (!world.isRemote) {
                --itemStack._b;
            }
            return true;
        }
        if (n4 == Block.sapling.blockID) {
            if (!world.isRemote) {
                if ((double)world.rand.nextFloat() < 0.45) {
                    ((rqeh)Block.sapling)._a(world, n, n2, n3, world.rand);
                }
                --itemStack._b;
            }
            return true;
        }
        if (n4 != Block.mushroomBrown.blockID && n4 != Block.mushroomRed.blockID) {
            if (n4 != Block.melonStem.blockID && n4 != Block.pumpkinStem.blockID) {
                if (n4 > 0 && Block.blocksList[n4] instanceof nuuf) {
                    if (world.getBlockMetadata(n, n2, n3) == 7) {
                        return false;
                    }
                    if (!world.isRemote) {
                        ((nuuf)Block.blocksList[n4])._a(world, n, n2, n3);
                        --itemStack._b;
                    }
                    return true;
                }
                if (n4 == Block.cocoaPlant.blockID) {
                    int n5 = world.getBlockMetadata(n, n2, n3);
                    int n6 = BlockDirectional._d(n5);
                    int n7 = woni._b(n5);
                    if (n7 >= 2) {
                        return false;
                    }
                    if (!world.isRemote) {
                        world.func_72921_c(n, n2, n3, ++n7 << 2 | n6, 2);
                        --itemStack._b;
                    }
                    return true;
                }
                if (n4 != Block.grass.blockID) {
                    return false;
                }
                if (!world.isRemote) {
                    --itemStack._b;
                    block0: for (int i = 0; i < 128; ++i) {
                        int n8 = n;
                        int n9 = n2 + 1;
                        int n10 = n3;
                        for (int j = 0; j < i / 16; ++j) {
                            if (world.getBlockId(n8 += itemRand.nextInt(3) - 1, (n9 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2) - 1, n10 += itemRand.nextInt(3) - 1) != Block.grass.blockID || world.isBlockNormalCube(n8, n9, n10)) continue block0;
                        }
                        if (world.getBlockId(n8, n9, n10) != 0) continue;
                        if (itemRand.nextInt(10) != 0) {
                            if (!Block.tallGrass.canBlockStay(world, n8, n9, n10)) continue;
                            world.setBlock(n8, n9, n10, Block.tallGrass.blockID, 1, 3);
                            continue;
                        }
                        ForgeHooks.plantGrass(world, n8, n9, n10);
                    }
                }
                return true;
            }
            if (world.getBlockMetadata(n, n2, n3) == 7) {
                return false;
            }
            if (!world.isRemote) {
                ((xati)Block.blocksList[n4])._a(world, n, n2, n3);
                --itemStack._b;
            }
            return true;
        }
        if (!world.isRemote) {
            if ((double)world.rand.nextFloat() < 0.4) {
                ((rqca)Block.blocksList[n4])._a(world, n, n2, n3, world.rand);
            }
            --itemStack._b;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public static void _a(World world, int n, int n2, int n3, int n4) {
        Block block;
        int n5 = world.getBlockId(n, n2, n3);
        if (n4 == 0) {
            n4 = 15;
        }
        Block block2 = block = n5 > 0 && n5 < Block.blocksList.length ? Block.blocksList[n5] : null;
        if (block != null) {
            block.setBlockBoundsBasedOnState(world, n, n2, n3);
            for (int i = 0; i < n4; ++i) {
                double d = itemRand.nextGaussian() * 0.02;
                double d2 = itemRand.nextGaussian() * 0.02;
                double d3 = itemRand.nextGaussian() * 0.02;
                world.spawnParticle("happyVillager", (float)n + itemRand.nextFloat(), (double)n2 + (double)itemRand.nextFloat() * block.getBlockBoundsMaxY(), (float)n3 + itemRand.nextFloat(), d, d2, d3);
            }
        } else {
            for (int i = 0; i < n4; ++i) {
                double d = itemRand.nextGaussian() * 0.02;
                double d4 = itemRand.nextGaussian() * 0.02;
                double d5 = itemRand.nextGaussian() * 0.02;
                world.spawnParticle("happyVillager", (float)n + itemRand.nextFloat(), (double)n2 + (double)itemRand.nextFloat() * 1.0, (float)n3 + itemRand.nextFloat(), d, d4, d5);
            }
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntitySheep) {
            EntitySheep entitySheep = (EntitySheep)entityLivingBase;
            int n = uziv._a(itemStack._j());
            if (!entitySheep.getSheared() && entitySheep.getFleeceColor() != n) {
                entitySheep.setFleeceColor(n);
                --itemStack._b;
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new ItemStack(n, 1, i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this._d = new Icon[_b.length];
        for (int i = 0; i < _b.length; ++i) {
            this._d[i] = iconRegister._b(this.getIconString() + "_" + _b[i]);
        }
    }
}

