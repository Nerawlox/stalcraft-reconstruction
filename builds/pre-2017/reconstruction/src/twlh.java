/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class twlh
extends BlockRailBase {
    public Icon _a;

    public twlh(int n) {
        super(n, true);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if ((n2 & 8) == 0) {
            return this.blockIcon;
        }
        return this._a;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._a = iconRegister._b(this.getTextureName() + "_powered");
    }

    public boolean _a(World world, int n, int n2, int n3, int n4, boolean bl, int n5) {
        if (n5 >= 8) {
            return false;
        }
        int n6 = n4 & 7;
        boolean bl2 = true;
        switch (n6) {
            case 0: {
                if (bl) {
                    ++n3;
                    break;
                }
                --n3;
                break;
            }
            case 1: {
                if (bl) {
                    --n;
                    break;
                }
                ++n;
                break;
            }
            case 2: {
                if (bl) {
                    --n;
                } else {
                    ++n;
                    ++n2;
                    bl2 = false;
                }
                n6 = 1;
                break;
            }
            case 3: {
                if (bl) {
                    --n;
                    ++n2;
                    bl2 = false;
                } else {
                    ++n;
                }
                n6 = 1;
                break;
            }
            case 4: {
                if (bl) {
                    ++n3;
                } else {
                    --n3;
                    ++n2;
                    bl2 = false;
                }
                n6 = 0;
                break;
            }
            case 5: {
                if (bl) {
                    ++n3;
                    ++n2;
                    bl2 = false;
                } else {
                    --n3;
                }
                n6 = 0;
            }
        }
        if (this._a(world, n, n2, n3, bl, n5, n6)) {
            return true;
        }
        return bl2 && this._a(world, n, n2 - 1, n3, bl, n5, n6);
    }

    public boolean _a(World world, int n, int n2, int n3, boolean bl, int n4, int n5) {
        int n6 = world.getBlockId(n, n2, n3);
        if (n6 == this.blockID) {
            int n7 = world.getBlockMetadata(n, n2, n3);
            int n8 = n7 & 7;
            if (n5 == 1 && (n8 == 0 || n8 == 4 || n8 == 5)) {
                return false;
            }
            if (n5 == 0 && (n8 == 1 || n8 == 2 || n8 == 3)) {
                return false;
            }
            if ((n7 & 8) != 0) {
                if (world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
                    return true;
                }
                return this._a(world, n, n2, n3, n7, bl, n4 + 1);
            }
        }
        return false;
    }

    @Override
    public void _a(World world, int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = world.isBlockIndirectlyGettingPowered(n, n2, n3);
        bl = bl || this._a(world, n, n2, n3, n4, true, 0) || this._a(world, n, n2, n3, n4, false, 0);
        boolean bl2 = false;
        if (bl && (n4 & 8) == 0) {
            world.func_72921_c(n, n2, n3, n5 | 8, 3);
            bl2 = true;
        } else if (!bl && (n4 & 8) != 0) {
            world.func_72921_c(n, n2, n3, n5, 3);
            bl2 = true;
        }
        if (bl2) {
            world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
            if (n5 == 2 || n5 == 3 || n5 == 4 || n5 == 5) {
                world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
            }
        }
    }
}

