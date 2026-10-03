/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersStairs;
import carpentersblocks.data.Stairs;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersStairs
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        for (int i = 0; i < 2; ++i) {
            switch (i) {
                case 0: {
                    htvc2._a(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
                    break;
                }
                case 1: {
                    htvc2._a(0.5, 0.5, 0.0, 1.0, 1.0, 1.0);
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
        Stairs stairs = Stairs.stairsList[n5];
        BlockCarpentersStairs blockCarpentersStairs = (BlockCarpentersStairs)BlockHandler.blockCarpentersStairs;
        for (int i = 0; i < 3; ++i) {
            float[] fArray = blockCarpentersStairs.genBounds(i, stairs);
            if (fArray == null) continue;
            blockCarpentersStairs.func_71905_a(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
            htvc2._a(fArray[0], fArray[1], (double)fArray[2], (double)fArray[3], (double)fArray[4], (double)fArray[5]);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
        }
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    @Override
    protected boolean renderSideCovers(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        boolean bl = false;
        this.isSideCover = true;
        htvc2._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n5];
        BlockCarpentersStairs blockCarpentersStairs = (BlockCarpentersStairs)BlockHandler.blockCarpentersStairs;
        for (int i = 0; i < 3; ++i) {
            float[] fArray = blockCarpentersStairs.genBounds(i, stairs);
            if (fArray == null) continue;
            for (int j = 0; j < 6; ++j) {
                twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, j);
                this.coverRendering = j;
                if (!BlockProperties.hasCover(tECarpentersBlock, j) || !this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n) && !this.shouldRenderPattern(tECarpentersBlock, n)) continue;
                htvc2._a(fArray[0], fArray[1], (double)fArray[2], (double)fArray[3], (double)fArray[4], (double)fArray[5]);
                int[] nArray = this.setSideCoverRenderBounds(BlockHandlerBase.tempRenderOffset, tECarpentersBlock, htvc2, n2, n3, n4, j);
                if (!this.clipSideCoverBoundsBasedOnState(htvc2, n5, i, j)) continue;
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, nArray[0], nArray[1], nArray[2]);
                bl = true;
            }
        }
        htvc2._d = false;
        this.coverRendering = 6;
        this.isSideCover = false;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean clipSideCoverBoundsBasedOnState(htvc htvc2, int n, int n2, int n3) {
        block177: {
            ++n2;
            switch (n) {
                case 0: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._l += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 1: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._m -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 2: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._m -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 3: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._l += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 4: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 3;
                        }
                    }
                    return true;
                }
                case 5: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 2;
                        }
                    }
                    return true;
                }
                case 6: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 7: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 8: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 3;
                        }
                    }
                    return true;
                }
                case 9: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 2;
                        }
                    }
                    return true;
                }
                case 10: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                    }
                    return true;
                }
                case 11: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                    }
                    return true;
                }
                case 12: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._m -= 0.5;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                htvc2._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 13: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._m -= 0.5;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                htvc2._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 14: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._m -= 0.5;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                htvc2._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 15: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._m -= 0.5;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 2) {
                                htvc2._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 16: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._l += 0.5;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                htvc2._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 17: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 4) return true;
                            htvc2._l += 0.5;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                htvc2._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 5) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 18: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._l += 0.5;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                htvc2._j += 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 19: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 5) return true;
                            htvc2._l += 0.5;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            if (n3 == 3) {
                                htvc2._k -= 0.5;
                                return true;
                            } else {
                                if (n3 != 4) return true;
                                return false;
                            }
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 20: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 4) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 21: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 4) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 22: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 5) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 23: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 3 && n3 != 5) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 2 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 24: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 5) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 25: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 5) return true;
                            htvc2._k -= 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 4;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 5;
                        }
                    }
                    return true;
                }
                case 26: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 4) return true;
                            htvc2._j += 0.5;
                            return true;
                        }
                        case 2: {
                            return n3 != 5;
                        }
                        case 3: {
                            return n3 != 3 && n3 != 4;
                        }
                    }
                    return true;
                }
                case 27: {
                    switch (n2) {
                        case 1: {
                            if (n3 != 2 && n3 != 4) return true;
                            htvc2._k -= 0.5;
                            break block177;
                        }
                        case 2: {
                            if (n3 != 5) return true;
                            return false;
                        }
                        case 3: {
                            if (n3 != 3 && n3 != 4) return true;
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

