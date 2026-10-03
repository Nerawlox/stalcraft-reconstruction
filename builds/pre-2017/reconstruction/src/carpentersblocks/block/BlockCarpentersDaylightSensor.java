/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.DaylightSensor;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.tileentity.TECarpentersBlockExt;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpentersDaylightSensor
extends BlockBase {
    public BlockCarpentersDaylightSensor(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersDaylightSensor");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.375f, 1.0f);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return n4 == 1 ? Block.daylightSensor.getBlockTextureFromSide(1) : super.getBlockTexture(iBlockAccess, n, n2, n3, n4);
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = DaylightSensor.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.worldObj.isRemote) {
            DaylightSensor.setPolarity(tECarpentersBlock, n);
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.activation_day.name"));
                    break;
                }
                case 1: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.activation_night.name"));
                }
            }
        }
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        boolean bl;
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = DaylightSensor.getType(n5);
        boolean bl2 = n6 > 2;
        boolean bl3 = bl = DaylightSensor.getPolarity(n5) == 0;
        return bl2 ? (bl ? n6 : 0) : (!bl ? 15 : 0);
    }

    public void updateLightLevel(World world, int n, int n2, int n3) {
        if (!world.provider._g) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = DaylightSensor.getType(n4);
            int n6 = world.getSavedLightValue(EnumSkyBlock._a, n, n2, n3) - world.skylightSubtracted;
            float f = world.getCelestialAngleRadians(1.0f);
            f = f < (float)Math.PI ? (f += (0.0f - f) * 0.2f) : (f += ((float)Math.PI * 2 - f) * 0.2f);
            n6 = Math.round((float)n6 * sajh._b(f));
            if (n6 < 0) {
                n6 = 0;
            } else if (n6 > 15) {
                n6 = 15;
            }
            if (n5 != n6) {
                DaylightSensor.setType(tECarpentersBlock, n6);
                world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
            }
        }
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TECarpentersBlockExt();
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersDaylightSensorRenderID;
    }
}

