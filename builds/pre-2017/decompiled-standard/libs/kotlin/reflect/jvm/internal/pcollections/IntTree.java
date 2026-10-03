/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.pcollections;

final class IntTree<V> {
    static final IntTree<Object> EMPTYNODE = new IntTree();
    private final long key;
    private final V value;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private static final int OMEGA = 5;
    private static final int ALPHA = 2;

    private IntTree() {
        this.size = 0;
        this.key = 0L;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private IntTree(long key, V value, IntTree<V> left, IntTree<V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.size = 1 + left.size + right.size;
    }

    private IntTree<V> withKey(long newKey) {
        if (this.size == 0 || newKey == this.key) {
            return this;
        }
        return new IntTree<V>(newKey, this.value, this.left, this.right);
    }

    boolean containsKey(long key) {
        if (this.size == 0) {
            return false;
        }
        if (key < this.key) {
            return this.left.containsKey(key - this.key);
        }
        if (key > this.key) {
            return this.right.containsKey(key - this.key);
        }
        return true;
    }

    V get(long key) {
        if (this.size == 0) {
            return null;
        }
        if (key < this.key) {
            return this.left.get(key - this.key);
        }
        if (key > this.key) {
            return this.right.get(key - this.key);
        }
        return this.value;
    }

    IntTree<V> plus(long key, V value) {
        if (this.size == 0) {
            return new IntTree<V>(key, value, this, this);
        }
        if (key < this.key) {
            return this.rebalanced(this.left.plus(key - this.key, value), this.right);
        }
        if (key > this.key) {
            return this.rebalanced(this.left, this.right.plus(key - this.key, value));
        }
        if (value == this.value) {
            return this;
        }
        return new IntTree<V>(key, value, this.left, this.right);
    }

    IntTree<V> minus(long key) {
        if (this.size == 0) {
            return this;
        }
        if (key < this.key) {
            return this.rebalanced(this.left.minus(key - this.key), this.right);
        }
        if (key > this.key) {
            return this.rebalanced(this.left, this.right.minus(key - this.key));
        }
        if (this.left.size == 0) {
            return super.withKey(this.right.key + this.key);
        }
        if (this.right.size == 0) {
            return super.withKey(this.left.key + this.key);
        }
        long newKey = super.minKey() + this.key;
        V newValue = this.right.get(newKey - this.key);
        IntTree<V> newRight = this.right.minus(newKey - this.key);
        newRight = super.withKey(newRight.key + this.key - newKey);
        IntTree<V> newLeft = super.withKey(this.left.key + this.key - newKey);
        return IntTree.rebalanced(newKey, newValue, newLeft, newRight);
    }

    IntTree<V> changeKeysAbove(long key, int delta) {
        if (this.size == 0 || delta == 0) {
            return this;
        }
        if (this.key >= key) {
            return new IntTree<V>(this.key + (long)delta, this.value, this.left.changeKeysBelow(key - this.key, -delta), this.right);
        }
        IntTree<V> newRight = this.right.changeKeysAbove(key - this.key, delta);
        if (newRight == this.right) {
            return this;
        }
        return new IntTree<V>(this.key, this.value, this.left, newRight);
    }

    IntTree<V> changeKeysBelow(long key, int delta) {
        if (this.size == 0 || delta == 0) {
            return this;
        }
        if (this.key < key) {
            return new IntTree<V>(this.key + (long)delta, this.value, this.left, this.right.changeKeysAbove(key - this.key, -delta));
        }
        IntTree<V> newLeft = this.left.changeKeysBelow(key - this.key, delta);
        if (newLeft == this.left) {
            return this;
        }
        return new IntTree<V>(this.key, this.value, newLeft, this.right);
    }

    private long minKey() {
        if (this.left.size == 0) {
            return this.key;
        }
        return super.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> newLeft, IntTree<V> newRight) {
        if (newLeft == this.left && newRight == this.right) {
            return this;
        }
        return IntTree.rebalanced(this.key, this.value, newLeft, newRight);
    }

    private static <V> IntTree<V> rebalanced(long key, V value, IntTree<V> left, IntTree<V> right) {
        if (left.size + right.size > 1) {
            if (left.size >= 5 * right.size) {
                IntTree<V> ll = left.left;
                IntTree<V> lr = left.right;
                if (lr.size < 2 * ll.size) {
                    return new IntTree<V>(left.key + key, left.value, ll, new IntTree<V>(-left.key, value, super.withKey(lr.key + left.key), right));
                }
                IntTree<V> lrl = lr.left;
                IntTree<V> lrr = lr.right;
                return new IntTree<V>(lr.key + left.key + key, lr.value, new IntTree<V>(-lr.key, left.value, ll, super.withKey(lrl.key + lr.key)), new IntTree<V>(-left.key - lr.key, value, super.withKey(lrr.key + lr.key + left.key), right));
            }
            if (right.size >= 5 * left.size) {
                IntTree<V> rl = right.left;
                IntTree<V> rr = right.right;
                if (rl.size < 2 * rr.size) {
                    return new IntTree<V>(right.key + key, right.value, new IntTree<V>(-right.key, value, left, super.withKey(rl.key + right.key)), rr);
                }
                IntTree<V> rll = rl.left;
                IntTree<V> rlr = rl.right;
                return new IntTree<V>(rl.key + right.key + key, rl.value, new IntTree<V>(-right.key - rl.key, value, left, super.withKey(rll.key + rl.key + right.key)), new IntTree<V>(-rl.key, right.value, super.withKey(rlr.key + rl.key), rr));
            }
        }
        return new IntTree<V>(key, value, left, right);
    }
}

