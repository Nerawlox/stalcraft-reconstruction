/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks;

import carpentersblocks.block.BlockCarpentersSlope;
import carpentersblocks.data.Slope;
import carpentersblocks.util.handler.FeatureHandler;
import java.util.List;
import net.minecraft.util.AxisAlignedBB;

public interface SlopeBlock {
    default public int getHitboxPrecision() {
        return FeatureHandler.hitboxPrecision;
    }

    default public int getNumBoxesPerPass(Slope slope) {
        switch (slope.slopeType.ordinal() + 1) {
            case 7: {
                return this.getHitboxPrecision() / 2;
            }
        }
        return this.getHitboxPrecision();
    }

    default public int getNumPasses(Slope slope) {
        switch (slope.slopeType.ordinal() + 1) {
            case 3: {
                return 2;
            }
            default: {
                return 1;
            }
            case 5: {
                return 3;
            }
            case 6: 
        }
        return this.getNumBoxesPerPass(slope);
    }

    default public void addSlopeCollision(Slope slope, int n, int n2, int n3, List list2) {
        AxisAlignedBB axisAlignedBB = null;
        int n4 = this.getNumBoxesPerPass(slope);
        int n5 = this.getNumPasses(slope);
        for (int i = 0; i < n5; ++i) {
            for (int j = 0; j < n4; ++j) {
                float[] fArray = this.genBounds(slope, j, n4, i);
                if (fArray != null) {
                    axisAlignedBB = AxisAlignedBB._a()._a((float)n + fArray[0], (float)n2 + fArray[1], (float)n3 + fArray[2], (float)n + fArray[3], (float)n2 + fArray[4], (float)n3 + fArray[5]);
                }
                if (axisAlignedBB == null || !axisAlignedBB._b(axisAlignedBB)) continue;
                axisAlignedBB._e(0.11, 0.11, 0.11);
                list2.add(axisAlignedBB);
            }
            if (!slope.slopeType.equals((Object)Slope.SlopeType.OBLIQUE_EXT)) continue;
            --n4;
        }
    }

    default public float[] genBounds(Slope slope, int n, int n2, int n3) {
        float f = (float)(++n3 - 1) / (float)this.getNumPasses(slope);
        float f2 = (float)n3 / (float)this.getNumPasses(slope);
        float f3 = (float)n / (float)n2;
        float f4 = (float)(n + 1) / (float)n2;
        switch (slope.slopeID) {
            case 0: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f, 1.0f - f3);
            }
            case 1: {
                return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 1.0f - f4, 1.0f, 1.0f, 1.0f);
            }
            case 2: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, f4, 1.0f, 1.0f);
            }
            case 3: {
                return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, 1.0f, f4);
            }
            case 4: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
            }
            case 5: {
                return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, 1.0f, 1.0f, f4);
            }
            case 6: {
                return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            case 7: {
                return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, f4, 1.0f, 1.0f);
            }
            case 8: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f, f4, 1.0f);
            }
            case 9: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f - f3, f4);
            }
            case 10: {
                return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f);
            }
            case 11: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f - f3, 1.0f);
            }
            case 14: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f, f4, 1.0f);
                    }
                }
            }
            case 16: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f - f3, f4);
                    }
                }
            }
            case 12: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f - f3, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f, f4, 1.0f);
                    }
                }
            }
            case 18: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f - f3, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f - f3, f4);
                    }
                }
            }
            case 15: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            case 17: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, 1.0f, 1.0f, f4);
                    }
                }
            }
            case 13: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, f4, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            case 19: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, f4, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, 1.0f, 1.0f, f4);
                    }
                }
            }
            case 20: {
                return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f - f3);
            }
            case 21: {
                return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f - f3);
            }
            case 22: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f - f3, f4, 1.0f - f3);
            }
            case 23: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, 0.0f, 1.0f - f3, 1.0f, 1.0f - f3);
            }
            case 24: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f - f3, f4, 1.0f);
            }
            case 25: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f - f3, 1.0f, 1.0f);
            }
            case 26: {
                return BlockCarpentersSlope.getTempBounds(f3, 0.0f, f3, 1.0f, f4, 1.0f);
            }
            case 27: {
                return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
            }
            case 30: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 1.0f - f4, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f, f4, 1.0f);
                    }
                }
            }
            case 31: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 1.0f - f4, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            case 32: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, 1.0f, f4);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, f4, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f - f3, f4);
                    }
                }
            }
            case 28: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, f4, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f - f3, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, 1.0f, f4, 1.0f);
                    }
                }
            }
            case 33: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(f3, 0.0f, 0.0f, 1.0f, 1.0f, f4);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(f3, 1.0f - f4, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, 1.0f, 1.0f, f4);
                    }
                }
            }
            case 29: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f3, f4, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, f4, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f4, f3, 1.0f, 1.0f, 1.0f);
                    }
                }
            }
            case 34: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f, 1.0f - f3);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f - f3, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f - f3, f4);
                    }
                }
            }
            case 35: {
                switch (n3) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4, 1.0f, 1.0f - f3);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, f4, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, f3, 0.0f, 1.0f, 1.0f, f4);
                    }
                }
            }
            case 36: {
                return BlockCarpentersSlope.getTempBounds(f + f3 * (1.0f - f), 0.0f, 0.0f, 1.0f, f2, f4 * (1.0f - f));
            }
            case 37: {
                return BlockCarpentersSlope.getTempBounds(f + f3 * (1.0f - f), 1.0f - f2, 0.0f, 1.0f, 1.0f, f4 * (1.0f - f));
            }
            case 38: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, f4 * (1.0f - f), f2, 1.0f - f - f3 * (1.0f - f));
            }
            case 39: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f2, 0.0f, f4 * (1.0f - f), 1.0f, 1.0f - f - f3 * (1.0f - f));
            }
            case 40: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, f + f3 * (1.0f - f), f4 * (1.0f - f), f2, 1.0f);
            }
            case 41: {
                return BlockCarpentersSlope.getTempBounds(0.0f, 1.0f - f2, f + f3 * (1.0f - f), f4 * (1.0f - f), 1.0f, 1.0f);
            }
            case 42: {
                return BlockCarpentersSlope.getTempBounds(f + f3 * (1.0f - f), 0.0f, 1.0f - f4 * (1.0f - f), 1.0f, f2, 1.0f);
            }
            case 43: {
                return BlockCarpentersSlope.getTempBounds(f + f3 * (1.0f - f), 1.0f - f2, 1.0f - f4 * (1.0f - f), 1.0f, 1.0f, 1.0f);
            }
            case 44: {
                return BlockCarpentersSlope.getTempBounds(0.5f * f3, 0.0f, 0.5f * f3, 1.0f - 0.5f * f3, f4 * 0.5f, 1.0f - 0.5f * f3);
            }
        }
        return BlockCarpentersSlope.getTempBounds(0.5f * f3, 1.0f - f4 * 0.5f, 0.5f * f3, 1.0f - 0.5f * f3, 1.0f, 1.0f - 0.5f * f3);
    }
}

