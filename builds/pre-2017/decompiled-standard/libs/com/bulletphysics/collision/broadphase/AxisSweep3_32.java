/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.AxisSweep3Internal;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import javax.vecmath.Vector3f;

public class AxisSweep3_32
extends AxisSweep3Internal {
    public AxisSweep3_32(Vector3f worldAabbMin, Vector3f worldAabbMax) {
        this(worldAabbMin, worldAabbMax, 1500000, null);
    }

    public AxisSweep3_32(Vector3f worldAabbMin, Vector3f worldAabbMax, int maxHandles) {
        this(worldAabbMin, worldAabbMax, maxHandles, null);
    }

    public AxisSweep3_32(Vector3f worldAabbMin, Vector3f worldAabbMax, int maxHandles, OverlappingPairCache pairCache) {
        super(worldAabbMin, worldAabbMax, -2, Integer.MAX_VALUE, maxHandles, pairCache);
        assert (maxHandles > 1 && maxHandles < Integer.MAX_VALUE);
    }

    @Override
    protected AxisSweep3Internal.EdgeArray createEdgeArray(int size) {
        return new EdgeArrayImpl(size);
    }

    @Override
    protected AxisSweep3Internal.Handle createHandle() {
        return new HandleImpl();
    }

    @Override
    protected int getMask() {
        return -1;
    }

    protected static class HandleImpl
    extends AxisSweep3Internal.Handle {
        private int minEdges0;
        private int minEdges1;
        private int minEdges2;
        private int maxEdges0;
        private int maxEdges1;
        private int maxEdges2;

        protected HandleImpl() {
        }

        @Override
        public int getMinEdges(int edgeIndex) {
            switch (edgeIndex) {
                default: {
                    return this.minEdges0;
                }
                case 1: {
                    return this.minEdges1;
                }
                case 2: 
            }
            return this.minEdges2;
        }

        @Override
        public void setMinEdges(int edgeIndex, int value) {
            switch (edgeIndex) {
                case 0: {
                    this.minEdges0 = value;
                    break;
                }
                case 1: {
                    this.minEdges1 = value;
                    break;
                }
                case 2: {
                    this.minEdges2 = value;
                }
            }
        }

        @Override
        public int getMaxEdges(int edgeIndex) {
            switch (edgeIndex) {
                default: {
                    return this.maxEdges0;
                }
                case 1: {
                    return this.maxEdges1;
                }
                case 2: 
            }
            return this.maxEdges2;
        }

        @Override
        public void setMaxEdges(int edgeIndex, int value) {
            switch (edgeIndex) {
                case 0: {
                    this.maxEdges0 = value;
                    break;
                }
                case 1: {
                    this.maxEdges1 = value;
                    break;
                }
                case 2: {
                    this.maxEdges2 = value;
                }
            }
        }
    }

    protected static class EdgeArrayImpl
    extends AxisSweep3Internal.EdgeArray {
        private int[] pos;
        private int[] handle;

        public EdgeArrayImpl(int size) {
            this.pos = new int[size];
            this.handle = new int[size];
        }

        @Override
        public void swap(int idx1, int idx2) {
            int tmpPos = this.pos[idx1];
            int tmpHandle = this.handle[idx1];
            this.pos[idx1] = this.pos[idx2];
            this.handle[idx1] = this.handle[idx2];
            this.pos[idx2] = tmpPos;
            this.handle[idx2] = tmpHandle;
        }

        @Override
        public void set(int dest, int src) {
            this.pos[dest] = this.pos[src];
            this.handle[dest] = this.handle[src];
        }

        @Override
        public int getPos(int index) {
            return this.pos[index];
        }

        @Override
        public void setPos(int index, int value) {
            this.pos[index] = value;
        }

        @Override
        public int getHandle(int index) {
            return this.handle[index];
        }

        @Override
        public void setHandle(int index, int value) {
            this.handle[index] = value;
        }
    }
}

