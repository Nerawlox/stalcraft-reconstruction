/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.vec;

public class BlockCoord
implements Comparable<BlockCoord> {
    public int x;
    public int y;
    public int z;
    public static final BlockCoord[] sideOffsets = new BlockCoord[]{new BlockCoord(0, -1, 0), new BlockCoord(0, 1, 0), new BlockCoord(0, 0, -1), new BlockCoord(0, 0, 1), new BlockCoord(-1, 0, 0), new BlockCoord(1, 0, 0)};

    public BlockCoord(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public BlockCoord(hurg hurg2) {
        this(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n);
    }

    public BlockCoord(int[] nArray) {
        this(nArray[0], nArray[1], nArray[2]);
    }

    public BlockCoord() {
    }

    public static BlockCoord fromAxes(int[] nArray) {
        return new BlockCoord(nArray[2], nArray[0], nArray[1]);
    }

    public boolean equals(Object object) {
        if (!(object instanceof BlockCoord)) {
            return false;
        }
        BlockCoord blockCoord = (BlockCoord)object;
        return this.x == blockCoord.x && this.y == blockCoord.y && this.z == blockCoord.z;
    }

    public int hashCode() {
        return (this.x ^ this.z) * 31 + this.y;
    }

    @Override
    public int compareTo(BlockCoord blockCoord) {
        if (this.x != blockCoord.x) {
            return this.x < blockCoord.x ? 1 : -1;
        }
        if (this.y != blockCoord.y) {
            return this.y < blockCoord.y ? 1 : -1;
        }
        if (this.z != blockCoord.z) {
            return this.z < blockCoord.z ? 1 : -1;
        }
        return 0;
    }

    public BlockCoord multiply(int n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        return this;
    }

    public double mag() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public int mag2() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public boolean isZero() {
        return this.x == 0 && this.y == 0 && this.z == 0;
    }

    public boolean isAxial() {
        return this.x == 0 ? this.y == 0 || this.z == 0 : this.y == 0 && this.z == 0;
    }

    public BlockCoord add(BlockCoord blockCoord) {
        this.x += blockCoord.x;
        this.y += blockCoord.y;
        this.z += blockCoord.z;
        return this;
    }

    public BlockCoord add(int n, int n2, int n3) {
        this.x += n;
        this.y += n2;
        this.z += n3;
        return this;
    }

    public BlockCoord sub(BlockCoord blockCoord) {
        this.x -= blockCoord.x;
        this.y -= blockCoord.y;
        this.z -= blockCoord.z;
        return this;
    }

    public BlockCoord sub(int n, int n2, int n3) {
        this.x -= n;
        this.y -= n2;
        this.z -= n3;
        return this;
    }

    public BlockCoord offset(int n) {
        return this.offset(n, 1);
    }

    public BlockCoord offset(int n, int n2) {
        BlockCoord blockCoord = sideOffsets[n];
        this.x += blockCoord.x * n2;
        this.y += blockCoord.y * n2;
        this.z += blockCoord.z * n2;
        return this;
    }

    public BlockCoord inset(int n) {
        return this.inset(n, 1);
    }

    public BlockCoord inset(int n, int n2) {
        return this.offset(n, -n2);
    }

    public int getSide(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return this.y;
            }
            case 2: 
            case 3: {
                return this.z;
            }
            case 4: 
            case 5: {
                return this.x;
            }
        }
        throw new IndexOutOfBoundsException("Switch Falloff");
    }

    public BlockCoord setSide(int n, int n2) {
        switch (n) {
            case 0: 
            case 1: {
                this.y = n2;
                break;
            }
            case 2: 
            case 3: {
                this.z = n2;
                break;
            }
            case 4: 
            case 5: {
                this.x = n2;
                break;
            }
            default: {
                throw new IndexOutOfBoundsException("Switch Falloff");
            }
        }
        return this;
    }

    public int[] intArray() {
        return new int[]{this.x, this.y, this.z};
    }

    public BlockCoord copy() {
        return new BlockCoord(this.x, this.y, this.z);
    }

    public BlockCoord set(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        return this;
    }

    public BlockCoord set(BlockCoord blockCoord) {
        return this.set(blockCoord.x, blockCoord.y, blockCoord.z);
    }

    public BlockCoord set(int[] nArray) {
        return this.set(nArray[0], nArray[1], nArray[2]);
    }

    public int toSide() {
        if (!this.isAxial()) {
            return -1;
        }
        if (this.y < 0) {
            return 0;
        }
        if (this.y > 0) {
            return 1;
        }
        if (this.z < 0) {
            return 2;
        }
        if (this.z > 0) {
            return 3;
        }
        if (this.x < 0) {
            return 4;
        }
        if (this.x > 0) {
            return 5;
        }
        return -1;
    }

    public int absSum() {
        return (this.x < 0 ? -this.x : this.x) + (this.y < 0 ? -this.y : this.y) + (this.z < 0 ? -this.z : this.z);
    }
}

