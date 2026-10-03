/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.bulletoverride;

import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import gloomyfolken.mods.physics.core.client.bulletoverride.JAxisSweep3Internal;
import javax.vecmath.Vector3f;

public class JAxisSweep3
extends JAxisSweep3Internal {
    public JAxisSweep3(Vector3f vector3f, Vector3f vector3f2) {
        this(vector3f, vector3f2, 16384, null);
    }

    public JAxisSweep3(Vector3f vector3f, Vector3f vector3f2, int n) {
        this(vector3f, vector3f2, n, null);
    }

    public JAxisSweep3(Vector3f vector3f, Vector3f vector3f2, int n, OverlappingPairCache overlappingPairCache) {
        super(vector3f, vector3f2, 65534, 65535, n, overlappingPairCache);
        assert (n > 1 && n < Short.MAX_VALUE);
    }

    @Override
    protected JAxisSweep3Internal.EdgeArray createEdgeArray(int n) {
        return new EdgeArrayImpl(n);
    }

    @Override
    protected JAxisSweep3Internal.Handle createHandle() {
        return new HandleImpl();
    }

    @Override
    protected int getMask() {
        return 65535;
    }

    protected static class EdgeArrayImpl
    extends JAxisSweep3Internal.EdgeArray {
        private short[] pos;
        private short[] handle;

        public EdgeArrayImpl(int n) {
            this.pos = new short[n];
            this.handle = new short[n];
        }

        @Override
        public void swap(int n, int n2) {
            short s = this.pos[n];
            short s2 = this.handle[n];
            this.pos[n] = this.pos[n2];
            this.handle[n] = this.handle[n2];
            this.pos[n2] = s;
            this.handle[n2] = s2;
        }

        @Override
        public void set(int n, int n2) {
            this.pos[n] = this.pos[n2];
            this.handle[n] = this.handle[n2];
        }

        @Override
        public int getPos(int n) {
            return this.pos[n] & 0xFFFF;
        }

        @Override
        public void setPos(int n, int n2) {
            this.pos[n] = (short)n2;
        }

        @Override
        public int getHandle(int n) {
            return this.handle[n] & 0xFFFF;
        }

        @Override
        public void setHandle(int n, int n2) {
            this.handle[n] = (short)n2;
        }
    }

    protected static class HandleImpl
    extends JAxisSweep3Internal.Handle {
        private short minEdges0;
        private short minEdges1;
        private short minEdges2;
        private short maxEdges0;
        private short maxEdges1;
        private short maxEdges2;

        protected HandleImpl() {
        }

        @Override
        public int getMinEdges(int n) {
            switch (n) {
                default: {
                    return this.minEdges0 & 0xFFFF;
                }
                case 1: {
                    return this.minEdges1 & 0xFFFF;
                }
                case 2: 
            }
            return this.minEdges2 & 0xFFFF;
        }

        @Override
        public void setMinEdges(int n, int n2) {
            switch (n) {
                case 0: {
                    this.minEdges0 = (short)n2;
                    break;
                }
                case 1: {
                    this.minEdges1 = (short)n2;
                    break;
                }
                case 2: {
                    this.minEdges2 = (short)n2;
                }
            }
        }

        @Override
        public int getMaxEdges(int n) {
            switch (n) {
                default: {
                    return this.maxEdges0 & 0xFFFF;
                }
                case 1: {
                    return this.maxEdges1 & 0xFFFF;
                }
                case 2: 
            }
            return this.maxEdges2 & 0xFFFF;
        }

        @Override
        public void setMaxEdges(int n, int n2) {
            switch (n) {
                case 0: {
                    this.maxEdges0 = (short)n2;
                    break;
                }
                case 1: {
                    this.maxEdges1 = (short)n2;
                    break;
                }
                case 2: {
                    this.maxEdges2 = (short)n2;
                }
            }
        }
    }
}

