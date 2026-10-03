/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersBarrier;
import carpentersblocks.data.Barrier;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersBarrier
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0: {
                    htvc2._a(0.125, 0.0, 0.375, 0.375, 1.0, 0.625);
                    break;
                }
                case 1: {
                    htvc2._a(0.625, 0.0, 0.375, 0.875, 1.0, 0.625);
                    break;
                }
                case 2: {
                    htvc2._a(0.0, 0.8125, 0.4375, 1.0, 0.9375, 0.5625);
                    break;
                }
                case 3: {
                    htvc2._a(0.0, 0.4375, 0.4375, 1.0, 0.5625, 0.5625);
                }
            }
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            htvc2._a(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(0));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            htvc2._b(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(1));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            htvc2._c(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(2));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            htvc2._d(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(3));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            htvc2._e(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            htvc2._f(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(5));
            htvf2.func_78381_a();
        }
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        twgu twgu3 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Barrier.getType(n5);
        switch (n6) {
            case 4: {
                this.renderPicketFence(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 5: {
                this.renderVerticalPlankFence(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 6: {
                this.renderWall(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            default: {
                this.renderFence(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
            }
        }
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    private boolean isPostAt(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72798_a(n, n2, n3) != BlockHandler.blockCarpentersBarrierID) {
            return false;
        }
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, sdrg2, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, sdrg2, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, sdrg2, n, n2 + 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, sdrg2, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, sdrg2, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = bl && bl2;
        boolean bl7 = bl4 && bl5;
        return Barrier.getPost(BlockProperties.getData(tECarpentersBlock)) == 1 || bl6 == bl7 || bl3 || (bl || bl2) && (bl4 || bl5);
    }

    public boolean renderFence(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        float f;
        boolean bl;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n + 1, n2, n3, ForgeDirection.WEST);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        f6 = 0.375f;
        f7 = 0.625f;
        f5 = 1.0f;
        float f8 = (float)Barrier.getType(n4) * 0.0625f;
        boolean bl6 = bl = Barrier.getType(n4) == 3;
        if (this.isPostAt(htvc2._a, n, n2, n3) || this.isPostAt(htvc2._a, n, n2 + 1, n3)) {
            htvc2._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f5 = 0.9375f;
        f4 = 0.75f;
        f2 = bl2 ? 0.0f : f6;
        f3 = bl3 ? 1.0f : f7;
        float f9 = bl4 ? 0.0f : f6;
        float f10 = f = bl5 ? 1.0f : f7;
        if (bl2 || bl3) {
            htvc2._a(f2, bl ? 0.1875 : (double)(f4 - f8), (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl4 || bl5) {
            htvc2._a(f6, bl ? 0.1875 : (double)(f4 - f8), (double)f9, (double)f7, (double)f5, (double)f);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (!bl) {
            f4 = 0.375f;
            f5 = 0.5625f;
            if (bl2 || bl3) {
                htvc2._a(f2, f4 - f8, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (bl4 || bl5) {
                htvc2._a(f6, f4 - f8, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        blockCarpentersBarrier.func_71902_a(htvc2._a, n, n2, n3);
        return true;
    }

    public boolean renderPicketFence(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        float f;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl6 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl7 = htvc2._a.func_72798_a(n, n2 + 1, n3) == BlockHandler.blockCarpentersBarrierID;
        boolean bl8 = htvc2._a.func_72798_a(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
        f6 = 0.4375f;
        f7 = 0.5625f;
        float f8 = f5 = bl3 ? 1.0f : 0.6875f;
        if (this.isPostAt(htvc2._a, n, n2, n3)) {
            htvc2._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f5 = 0.6875f;
        f4 = 0.625f;
        f2 = bl ? 0.0f : f6;
        f3 = bl2 ? 1.0f : f7;
        float f9 = bl5 ? 0.0f : f6;
        float f10 = f = bl6 ? 1.0f : f7;
        if (!bl7) {
            if (bl || bl2) {
                htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (bl5 || bl6) {
                htvc2._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        if (!bl8) {
            f4 = 0.1875f;
            f5 = 0.25f;
            if (bl || bl2) {
                htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (bl5 || bl6) {
                htvc2._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        f4 = bl4 ? 0.0f : 0.0625f;
        f5 = 1.0f;
        f2 = 0.4375f;
        f3 = 0.5625f;
        f6 = 0.5625f;
        f7 = 0.625f;
        if (!bl6) {
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        f6 -= 0.1875f;
        f7 -= 0.1875f;
        if (!bl5) {
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        f2 = 0.5625f;
        f3 = 0.625f;
        if (!bl2) {
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        f2 -= 0.1875f;
        f3 -= 0.1875f;
        if (!bl) {
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl) {
            f5 = bl3 ? 1.0f : 0.875f;
            f3 = 0.3125f;
            f2 = 0.1875f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f3 = 0.0625f;
            f2 = 0.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl2) {
            f5 = bl3 ? 1.0f : 0.875f;
            f2 = 0.6875f;
            f3 = 0.8125f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f2 = 0.9375f;
            f3 = 1.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl5) {
            f5 = bl3 ? 1.0f : 0.875f;
            f7 = 0.3125f;
            f6 = 0.1875f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f7 = 0.0625f;
            f6 = 0.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl6) {
            f5 = bl3 ? 1.0f : 0.875f;
            f6 = 0.6875f;
            f7 = 0.8125f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f5 = bl3 ? 1.0f : 0.8125f;
            f6 = 0.9375f;
            f7 = 1.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        blockCarpentersBarrier.func_71902_a(htvc2._a, n, n2, n3);
        return true;
    }

    public boolean renderWall(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3 - 1, ForgeDirection.SOUTH);
        boolean bl7 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3 + 1, ForgeDirection.NORTH);
        boolean bl8 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n - 1, n2 + 1, n3, ForgeDirection.EAST);
        boolean bl9 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n + 1, n2 + 1, n3, ForgeDirection.WEST);
        if (this.isPostAt(htvc2._a, n, n2, n3) || this.isPostAt(htvc2._a, n, n2 + 1, n3)) {
            htvc2._a(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl) {
            htvc2._a(0.0, 0.0, 0.3125, 0.5, bl3 && bl8 ? 1.0 : 0.8125, 0.6875);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl2) {
            htvc2._a(0.5, 0.0, 0.3125, 1.0, bl3 && bl9 ? 1.0 : 0.8125, 0.6875);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl4) {
            htvc2._a(0.3125, 0.0, 0.0, 0.6875, bl3 && bl6 ? 1.0 : 0.8125, 0.5);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl5) {
            htvc2._a(0.3125, 0.0, 0.5, 0.6875, bl3 && bl7 ? 1.0 : 0.8125, 1.0);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        return true;
    }

    public boolean renderVerticalPlankFence(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        float f;
        BlockProperties.getData(tECarpentersBlock);
        BlockCarpentersBarrier blockCarpentersBarrier = (BlockCarpentersBarrier)BlockHandler.blockCarpentersBarrier;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean bl = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl2 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n + 1, n2, n3, ForgeDirection.WEST);
        boolean bl3 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 + 1, n3, ForgeDirection.DOWN);
        blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2 - 1, n3, ForgeDirection.UP);
        boolean bl4 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl5 = blockCarpentersBarrier.canConnectBarrierTo(tECarpentersBlock, htvc2._a, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl6 = htvc2._a.func_72798_a(n, n2 + 1, n3) == BlockHandler.blockCarpentersBarrierID;
        boolean bl7 = htvc2._a.func_72798_a(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
        f5 = 0.875f;
        if (bl3) {
            f5 = 1.0f;
        }
        f6 = 0.4375f;
        f7 = 0.5625f;
        if (this.isPostAt(htvc2._a, n, n2, n3)) {
            htvc2._a(f6, 0.0, (double)f6, (double)f7, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        float f8 = 1.0E-4f;
        f6 = 0.4375f + f8;
        f7 = 0.5625f - f8;
        f5 = 0.875f;
        f4 = 0.75f;
        f2 = bl ? 0.0f : f7;
        f3 = bl2 ? 1.0f : f6;
        float f9 = bl4 ? 0.0f : f6;
        float f10 = f = bl5 ? 1.0f : f7;
        if (!bl6) {
            if (bl || bl2) {
                htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (bl4 || bl5) {
                htvc2._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        if (!bl7) {
            f4 = 0.125f;
            f5 = 0.25f;
            if (bl || bl2) {
                htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (bl4 || bl5) {
                htvc2._a(f6, f4, (double)f9, (double)f7, (double)f5, (double)f);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        f4 = 0.0f;
        f5 = 1.0f;
        if (bl) {
            f3 = 0.5f;
            f2 = 0.3125f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f3 = 0.1875f;
            f2 = 0.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl2) {
            f2 = 0.5f;
            f3 = 0.6875f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f2 = 0.8125f;
            f3 = 1.0f;
            f7 = 0.625f;
            f6 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2, f4, (double)(f6 -= 0.1875f), (double)f3, (double)f5, (double)(f7 -= 0.1875f));
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl4) {
            f7 = 0.5f;
            f6 = 0.3125f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f7 = 0.1875f;
            f6 = 0.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl5) {
            f6 = 0.5f;
            f7 = 0.6875f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            f6 = 0.8125f;
            f7 = 1.0f;
            f3 = 0.625f;
            f2 = 0.5625f;
            htvc2._a(f2, f4, (double)f6, (double)f3, (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(f2 -= 0.1875f, f4, (double)f6, (double)(f3 -= 0.1875f), (double)f5, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        blockCarpentersBarrier.func_71902_a(htvc2._a, n, n2, n3);
        return true;
    }
}

