/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.BvhSubtreeInfo;
import com.bulletphysics.collision.shapes.InternalTriangleIndexCallback;
import com.bulletphysics.collision.shapes.NodeOverlapCallback;
import com.bulletphysics.collision.shapes.OptimizedBvhNode;
import com.bulletphysics.collision.shapes.QuantizedBvhNodes;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.TraversalMode;
import com.bulletphysics.collision.shapes.VertexData;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import java.io.Serializable;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class OptimizedBvh
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final boolean DEBUG_TREE_BUILDING = false;
    private static int gStackDepth = 0;
    private static int gMaxStackDepth = 0;
    private static int maxIterations = 0;
    public static final int MAX_SUBTREE_SIZE_IN_BYTES = 2048;
    public static final int MAX_NUM_PARTS_IN_BITS = 10;
    private final ObjectArrayList<OptimizedBvhNode> leafNodes = new ObjectArrayList();
    private final ObjectArrayList<OptimizedBvhNode> contiguousNodes = new ObjectArrayList();
    private QuantizedBvhNodes quantizedLeafNodes = new QuantizedBvhNodes();
    private QuantizedBvhNodes quantizedContiguousNodes = new QuantizedBvhNodes();
    private int curNodeIndex;
    private boolean useQuantization;
    private final Vector3f bvhAabbMin = new Vector3f();
    private final Vector3f bvhAabbMax = new Vector3f();
    private final Vector3f bvhQuantization = new Vector3f();
    protected TraversalMode traversalMode = TraversalMode.STACKLESS;
    protected final ObjectArrayList<BvhSubtreeInfo> SubtreeHeaders = new ObjectArrayList();
    protected int subtreeHeaderCount;

    public void setInternalNodeAabbMin(int nodeIndex, Vector3f aabbMin) {
        if (this.useQuantization) {
            this.quantizedContiguousNodes.setQuantizedAabbMin(nodeIndex, this.quantizeWithClamp(aabbMin));
        } else {
            this.contiguousNodes.getQuick((int)nodeIndex).aabbMinOrg.set(aabbMin);
        }
    }

    public void setInternalNodeAabbMax(int nodeIndex, Vector3f aabbMax) {
        if (this.useQuantization) {
            this.quantizedContiguousNodes.setQuantizedAabbMax(nodeIndex, this.quantizeWithClamp(aabbMax));
        } else {
            this.contiguousNodes.getQuick((int)nodeIndex).aabbMaxOrg.set(aabbMax);
        }
    }

    public Vector3f getAabbMin(int nodeIndex) {
        if (this.useQuantization) {
            Vector3f tmp = new Vector3f();
            this.unQuantize(tmp, this.quantizedLeafNodes.getQuantizedAabbMin(nodeIndex));
            return tmp;
        }
        return this.leafNodes.getQuick((int)nodeIndex).aabbMinOrg;
    }

    public Vector3f getAabbMax(int nodeIndex) {
        if (this.useQuantization) {
            Vector3f tmp = new Vector3f();
            this.unQuantize(tmp, this.quantizedLeafNodes.getQuantizedAabbMax(nodeIndex));
            return tmp;
        }
        return this.leafNodes.getQuick((int)nodeIndex).aabbMaxOrg;
    }

    public void setQuantizationValues(Vector3f aabbMin, Vector3f aabbMax) {
        this.setQuantizationValues(aabbMin, aabbMax, 1.0f);
    }

    /*
     * WARNING - void declaration
     */
    public void setQuantizationValues(Vector3f vector3f, Vector3f vector3f2, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void quantizationMargin;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f clampValue = $Stack.get$javax$vecmath$Vector3f();
            clampValue.set((float)quantizationMargin, (float)quantizationMargin, (float)quantizationMargin);
            this.bvhAabbMin.sub((Tuple3f)aabbMin, clampValue);
            this.bvhAabbMax.add((Tuple3f)aabbMax, clampValue);
            Vector3f aabbSize = $Stack.get$javax$vecmath$Vector3f();
            aabbSize.sub(this.bvhAabbMax, this.bvhAabbMin);
            this.bvhQuantization.set(65535.0f, 65535.0f, 65535.0f);
            VectorUtil.div(this.bvhQuantization, this.bvhQuantization, aabbSize);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void setInternalNodeEscapeIndex(int nodeIndex, int escapeIndex) {
        if (this.useQuantization) {
            this.quantizedContiguousNodes.setEscapeIndexOrTriangleIndex(nodeIndex, -escapeIndex);
        } else {
            this.contiguousNodes.getQuick((int)nodeIndex).escapeIndex = escapeIndex;
        }
    }

    public void mergeInternalNodeAabb(int nodeIndex, Vector3f newAabbMin, Vector3f newAabbMax) {
        if (this.useQuantization) {
            long quantizedAabbMin = this.quantizeWithClamp(newAabbMin);
            long quantizedAabbMax = this.quantizeWithClamp(newAabbMax);
            for (int i = 0; i < 3; ++i) {
                if (this.quantizedContiguousNodes.getQuantizedAabbMin(nodeIndex, i) > QuantizedBvhNodes.getCoord(quantizedAabbMin, i)) {
                    this.quantizedContiguousNodes.setQuantizedAabbMin(nodeIndex, i, QuantizedBvhNodes.getCoord(quantizedAabbMin, i));
                }
                if (this.quantizedContiguousNodes.getQuantizedAabbMax(nodeIndex, i) >= QuantizedBvhNodes.getCoord(quantizedAabbMax, i)) continue;
                this.quantizedContiguousNodes.setQuantizedAabbMax(nodeIndex, i, QuantizedBvhNodes.getCoord(quantizedAabbMax, i));
            }
        } else {
            VectorUtil.setMin(this.contiguousNodes.getQuick((int)nodeIndex).aabbMinOrg, newAabbMin);
            VectorUtil.setMax(this.contiguousNodes.getQuick((int)nodeIndex).aabbMaxOrg, newAabbMax);
        }
    }

    public void swapLeafNodes(int i, int splitIndex) {
        if (this.useQuantization) {
            this.quantizedLeafNodes.swap(i, splitIndex);
        } else {
            OptimizedBvhNode tmp = this.leafNodes.getQuick(i);
            this.leafNodes.setQuick(i, this.leafNodes.getQuick(splitIndex));
            this.leafNodes.setQuick(splitIndex, tmp);
        }
    }

    public void assignInternalNodeFromLeafNode(int internalNode, int leafNodeIndex) {
        if (this.useQuantization) {
            this.quantizedContiguousNodes.set(internalNode, this.quantizedLeafNodes, leafNodeIndex);
        } else {
            this.contiguousNodes.getQuick(internalNode).set(this.leafNodes.getQuick(leafNodeIndex));
        }
    }

    /*
     * WARNING - void declaration
     */
    public void build(StridingMeshInterface stridingMeshInterface, boolean bl, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void triangles;
            InternalTriangleIndexCallback callback;
            void useQuantizedAabbCompression;
            $Stack.push$javax$vecmath$Vector3f();
            this.useQuantization = useQuantizedAabbCompression;
            int numLeafNodes = 0;
            if (this.useQuantization) {
                void _aabbMax;
                void _aabbMin;
                this.setQuantizationValues((Vector3f)_aabbMin, (Vector3f)_aabbMax);
                callback = new QuantizedNodeTriangleCallback(this.quantizedLeafNodes, this);
                triangles.internalProcessAllTriangles(callback, this.bvhAabbMin, this.bvhAabbMax);
                numLeafNodes = this.quantizedLeafNodes.size();
                this.quantizedContiguousNodes.resize(2 * numLeafNodes);
            } else {
                callback = new NodeTriangleCallback(this.leafNodes);
                Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
                aabbMin.set(-1.0E30f, -1.0E30f, -1.0E30f);
                Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
                aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
                triangles.internalProcessAllTriangles(callback, aabbMin, aabbMax);
                numLeafNodes = this.leafNodes.size();
                MiscUtil.resize(this.contiguousNodes, 2 * numLeafNodes, OptimizedBvhNode.class);
            }
            this.curNodeIndex = 0;
            this.buildTree(0, numLeafNodes);
            if (this.useQuantization && this.SubtreeHeaders.size() == 0) {
                BvhSubtreeInfo subtree = new BvhSubtreeInfo();
                this.SubtreeHeaders.add(subtree);
                subtree.setAabbFromQuantizeNode(this.quantizedContiguousNodes, 0);
                subtree.rootNodeIndex = 0;
                subtree.subtreeSize = this.quantizedContiguousNodes.isLeafNode(0) ? 1 : this.quantizedContiguousNodes.getEscapeIndex(0);
            }
            this.subtreeHeaderCount = this.SubtreeHeaders.size();
            this.quantizedLeafNodes.clear();
            this.leafNodes.clear();
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void refit(StridingMeshInterface stridingMeshInterface) {
        $Stack $Stack = $Stack.get();
        try {
            void meshInterface;
            $Stack.push$javax$vecmath$Vector3f();
            if (this.useQuantization) {
                Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
                Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
                meshInterface.calculateAabbBruteForce(aabbMin, aabbMax);
                this.setQuantizationValues(aabbMin, aabbMax);
                this.updateBvhNodes((StridingMeshInterface)meshInterface, 0, this.curNodeIndex, 0);
                for (int i = 0; i < this.SubtreeHeaders.size(); ++i) {
                    BvhSubtreeInfo subtree = this.SubtreeHeaders.getQuick(i);
                    subtree.setAabbFromQuantizeNode(this.quantizedContiguousNodes, subtree.rootNodeIndex);
                }
            } else {
                this.build((StridingMeshInterface)meshInterface, false, null, null);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void refitPartial(StridingMeshInterface meshInterface, Vector3f aabbMin, Vector3f aabbMax) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - void declaration
     */
    public void updateBvhNodes(StridingMeshInterface stridingMeshInterface, int n, int n2, int n3) {
        $Stack $Stack = $Stack.get();
        try {
            void firstNode;
            void meshInterface;
            $Stack.push$javax$vecmath$Vector3f();
            assert (this.useQuantization);
            int curNodeSubPart = -1;
            Vector3f[] triangleVerts = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
            Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
            Vector3f meshScaling = meshInterface.getScaling($Stack.get$javax$vecmath$Vector3f());
            VertexData data2 = null;
            for (void i = endNode - true; i >= firstNode; --i) {
                QuantizedBvhNodes curNodes = this.quantizedContiguousNodes;
                void curNodeId = i;
                if (curNodes.isLeafNode((int)curNodeId)) {
                    int nodeSubPart = curNodes.getPartId((int)curNodeId);
                    int nodeTriangleIndex = curNodes.getTriangleIndex((int)curNodeId);
                    if (nodeSubPart != curNodeSubPart) {
                        if (curNodeSubPart >= 0) {
                            meshInterface.unLockReadOnlyVertexBase(curNodeSubPart);
                        }
                        data2 = meshInterface.getLockedReadOnlyVertexIndexBase(nodeSubPart);
                    }
                    data2.getTriangle(nodeTriangleIndex * 3, meshScaling, triangleVerts);
                    aabbMin.set(1.0E30f, 1.0E30f, 1.0E30f);
                    aabbMax.set(-1.0E30f, -1.0E30f, -1.0E30f);
                    VectorUtil.setMin(aabbMin, triangleVerts[0]);
                    VectorUtil.setMax(aabbMax, triangleVerts[0]);
                    VectorUtil.setMin(aabbMin, triangleVerts[1]);
                    VectorUtil.setMax(aabbMax, triangleVerts[1]);
                    VectorUtil.setMin(aabbMin, triangleVerts[2]);
                    VectorUtil.setMax(aabbMax, triangleVerts[2]);
                    curNodes.setQuantizedAabbMin((int)curNodeId, this.quantizeWithClamp(aabbMin));
                    curNodes.setQuantizedAabbMax((int)curNodeId, this.quantizeWithClamp(aabbMax));
                    continue;
                }
                void leftChildNodeId = i + true;
                void rightChildNodeId = this.quantizedContiguousNodes.isLeafNode((int)leftChildNodeId) ? i + 2 : i + true + this.quantizedContiguousNodes.getEscapeIndex((int)leftChildNodeId);
                for (int i2 = 0; i2 < 3; ++i2) {
                    curNodes.setQuantizedAabbMin((int)curNodeId, i2, this.quantizedContiguousNodes.getQuantizedAabbMin((int)leftChildNodeId, i2));
                    if (curNodes.getQuantizedAabbMin((int)curNodeId, i2) > this.quantizedContiguousNodes.getQuantizedAabbMin((int)rightChildNodeId, i2)) {
                        curNodes.setQuantizedAabbMin((int)curNodeId, i2, this.quantizedContiguousNodes.getQuantizedAabbMin((int)rightChildNodeId, i2));
                    }
                    curNodes.setQuantizedAabbMax((int)curNodeId, i2, this.quantizedContiguousNodes.getQuantizedAabbMax((int)leftChildNodeId, i2));
                    if (curNodes.getQuantizedAabbMax((int)curNodeId, i2) >= this.quantizedContiguousNodes.getQuantizedAabbMax((int)rightChildNodeId, i2)) continue;
                    curNodes.setQuantizedAabbMax((int)curNodeId, i2, this.quantizedContiguousNodes.getQuantizedAabbMax((int)rightChildNodeId, i2));
                }
            }
            if (curNodeSubPart >= 0) {
                meshInterface.unLockReadOnlyVertexBase(curNodeSubPart);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void buildTree(int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            int sizeQuantizedNode;
            int treeSizeInBytes;
            void startIndex;
            void endIndex;
            $Stack.push$javax$vecmath$Vector3f();
            void numIndices = endIndex - startIndex;
            int curIndex = this.curNodeIndex;
            assert (numIndices > 0);
            if (numIndices == true) {
                this.assignInternalNodeFromLeafNode(this.curNodeIndex, (int)startIndex);
                ++this.curNodeIndex;
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            int splitAxis = this.calcSplittingAxis((int)startIndex, (int)endIndex);
            int splitIndex = this.sortAndCalcSplittingIndex((int)startIndex, (int)endIndex, splitAxis);
            int internalNodeIndex = this.curNodeIndex;
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.set(-1.0E30f, -1.0E30f, -1.0E30f);
            this.setInternalNodeAabbMax(this.curNodeIndex, tmp1);
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp2.set(1.0E30f, 1.0E30f, 1.0E30f);
            this.setInternalNodeAabbMin(this.curNodeIndex, tmp2);
            for (void i = startIndex; i < endIndex; ++i) {
                this.mergeInternalNodeAabb(this.curNodeIndex, this.getAabbMin((int)i), this.getAabbMax((int)i));
            }
            ++this.curNodeIndex;
            int leftChildNodexIndex = this.curNodeIndex;
            this.buildTree((int)startIndex, splitIndex);
            int rightChildNodexIndex = this.curNodeIndex;
            this.buildTree(splitIndex, (int)endIndex);
            int escapeIndex = this.curNodeIndex - curIndex;
            if (this.useQuantization && (treeSizeInBytes = escapeIndex * (sizeQuantizedNode = QuantizedBvhNodes.getNodeSize())) > 2048) {
                this.updateSubtreeHeaders(leftChildNodexIndex, rightChildNodexIndex);
            }
            this.setInternalNodeEscapeIndex(internalNodeIndex, escapeIndex);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected boolean testQuantizedAabbAgainstQuantizedAabb(long aabbMin1, long aabbMax1, long aabbMin2, long aabbMax2) {
        int aabbMin1_0 = QuantizedBvhNodes.getCoord(aabbMin1, 0);
        int aabbMin1_1 = QuantizedBvhNodes.getCoord(aabbMin1, 1);
        int aabbMin1_2 = QuantizedBvhNodes.getCoord(aabbMin1, 2);
        int aabbMax1_0 = QuantizedBvhNodes.getCoord(aabbMax1, 0);
        int aabbMax1_1 = QuantizedBvhNodes.getCoord(aabbMax1, 1);
        int aabbMax1_2 = QuantizedBvhNodes.getCoord(aabbMax1, 2);
        int aabbMin2_0 = QuantizedBvhNodes.getCoord(aabbMin2, 0);
        int aabbMin2_1 = QuantizedBvhNodes.getCoord(aabbMin2, 1);
        int aabbMin2_2 = QuantizedBvhNodes.getCoord(aabbMin2, 2);
        int aabbMax2_0 = QuantizedBvhNodes.getCoord(aabbMax2, 0);
        int aabbMax2_1 = QuantizedBvhNodes.getCoord(aabbMax2, 1);
        int aabbMax2_2 = QuantizedBvhNodes.getCoord(aabbMax2, 2);
        boolean overlap = true;
        overlap = aabbMin1_0 > aabbMax2_0 || aabbMax1_0 < aabbMin2_0 ? false : overlap;
        overlap = aabbMin1_2 > aabbMax2_2 || aabbMax1_2 < aabbMin2_2 ? false : overlap;
        overlap = aabbMin1_1 > aabbMax2_1 || aabbMax1_1 < aabbMin2_1 ? false : overlap;
        return overlap;
    }

    protected void updateSubtreeHeaders(int leftChildNodexIndex, int rightChildNodexIndex) {
        BvhSubtreeInfo subtree;
        assert (this.useQuantization);
        int leftSubTreeSize = this.quantizedContiguousNodes.isLeafNode(leftChildNodexIndex) ? 1 : this.quantizedContiguousNodes.getEscapeIndex(leftChildNodexIndex);
        int leftSubTreeSizeInBytes = leftSubTreeSize * QuantizedBvhNodes.getNodeSize();
        int rightSubTreeSize = this.quantizedContiguousNodes.isLeafNode(rightChildNodexIndex) ? 1 : this.quantizedContiguousNodes.getEscapeIndex(rightChildNodexIndex);
        int rightSubTreeSizeInBytes = rightSubTreeSize * QuantizedBvhNodes.getNodeSize();
        if (leftSubTreeSizeInBytes <= 2048) {
            subtree = new BvhSubtreeInfo();
            this.SubtreeHeaders.add(subtree);
            subtree.setAabbFromQuantizeNode(this.quantizedContiguousNodes, leftChildNodexIndex);
            subtree.rootNodeIndex = leftChildNodexIndex;
            subtree.subtreeSize = leftSubTreeSize;
        }
        if (rightSubTreeSizeInBytes <= 2048) {
            subtree = new BvhSubtreeInfo();
            this.SubtreeHeaders.add(subtree);
            subtree.setAabbFromQuantizeNode(this.quantizedContiguousNodes, rightChildNodexIndex);
            subtree.rootNodeIndex = rightChildNodexIndex;
            subtree.subtreeSize = rightSubTreeSize;
        }
        this.subtreeHeaderCount = this.SubtreeHeaders.size();
    }

    /*
     * WARNING - void declaration
     */
    protected int sortAndCalcSplittingIndex(int n, int n2, int n3) {
        $Stack $Stack = $Stack.get();
        try {
            boolean unbal;
            boolean unbalanced;
            void splitAxis;
            void i;
            void endIndex;
            void startIndex;
            $Stack.push$javax$vecmath$Vector3f();
            void splitIndex = startIndex;
            void numIndices = endIndex - startIndex;
            Vector3f means = $Stack.get$javax$vecmath$Vector3f();
            means.set(0.0f, 0.0f, 0.0f);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            for (i = startIndex; i < endIndex; ++i) {
                center.add(this.getAabbMax((int)i), this.getAabbMin((int)i));
                center.scale(0.5f);
                means.add(center);
            }
            means.scale(1.0f / (float)numIndices);
            float splitValue = VectorUtil.getCoord(means, (int)splitAxis);
            for (i = startIndex; i < endIndex; ++i) {
                center.add(this.getAabbMax((int)i), this.getAabbMin((int)i));
                center.scale(0.5f);
                if (!(VectorUtil.getCoord(center, (int)splitAxis) > splitValue)) continue;
                this.swapLeafNodes((int)i, (int)splitIndex);
                ++splitIndex;
            }
            void rangeBalancedIndices = numIndices / 3;
            boolean bl = unbalanced = splitIndex <= startIndex + rangeBalancedIndices || splitIndex >= endIndex - true - rangeBalancedIndices;
            if (unbalanced) {
                splitIndex = startIndex + (numIndices >> 1);
            }
            boolean bl2 = unbal = splitIndex == startIndex || splitIndex == endIndex;
            assert (!unbal);
            $Stack.pop$javax$vecmath$Vector3f();
            return (int)splitIndex;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected int calcSplittingAxis(int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void i;
            void startIndex;
            void endIndex;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f means = $Stack.get$javax$vecmath$Vector3f();
            means.set(0.0f, 0.0f, 0.0f);
            Vector3f variance = $Stack.get$javax$vecmath$Vector3f();
            variance.set(0.0f, 0.0f, 0.0f);
            void numIndices = endIndex - startIndex;
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            for (i = startIndex; i < endIndex; ++i) {
                center.add(this.getAabbMax((int)i), this.getAabbMin((int)i));
                center.scale(0.5f);
                means.add(center);
            }
            means.scale(1.0f / (float)numIndices);
            Vector3f diff2 = $Stack.get$javax$vecmath$Vector3f();
            for (i = startIndex; i < endIndex; ++i) {
                center.add(this.getAabbMax((int)i), this.getAabbMin((int)i));
                center.scale(0.5f);
                diff2.sub(center, means);
                VectorUtil.mul(diff2, diff2, diff2);
                variance.add(diff2);
            }
            variance.scale(1.0f / ((float)numIndices - 1.0f));
            int n3 = VectorUtil.maxAxis(variance);
            $Stack.pop$javax$vecmath$Vector3f();
            return n3;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void reportAabbOverlappingNodex(NodeOverlapCallback nodeCallback, Vector3f aabbMin, Vector3f aabbMax) {
        if (this.useQuantization) {
            long quantizedQueryAabbMin = this.quantizeWithClamp(aabbMin);
            long quantizedQueryAabbMax = this.quantizeWithClamp(aabbMax);
            switch (this.traversalMode) {
                case STACKLESS: {
                    this.walkStacklessQuantizedTree(nodeCallback, quantizedQueryAabbMin, quantizedQueryAabbMax, 0, this.curNodeIndex);
                    break;
                }
                case RECURSIVE: {
                    this.walkRecursiveQuantizedTreeAgainstQueryAabb(this.quantizedContiguousNodes, 0, nodeCallback, quantizedQueryAabbMin, quantizedQueryAabbMax);
                    break;
                }
                default: {
                    assert (false);
                    {
                        break;
                    }
                }
            }
        } else {
            this.walkStacklessTree(nodeCallback, aabbMin, aabbMax);
        }
    }

    protected void walkStacklessTree(NodeOverlapCallback nodeCallback, Vector3f aabbMin, Vector3f aabbMax) {
        assert (!this.useQuantization);
        OptimizedBvhNode rootNode = null;
        int rootNode_index = 0;
        int curIndex = 0;
        int walkIterations = 0;
        while (curIndex < this.curNodeIndex) {
            boolean isLeafNode;
            assert (walkIterations < this.curNodeIndex);
            ++walkIterations;
            rootNode = this.contiguousNodes.getQuick(rootNode_index);
            boolean aabbOverlap = AabbUtil2.testAabbAgainstAabb2(aabbMin, aabbMax, rootNode.aabbMinOrg, rootNode.aabbMaxOrg);
            boolean bl = isLeafNode = rootNode.escapeIndex == -1;
            if (isLeafNode && aabbOverlap) {
                nodeCallback.processNode(rootNode.subPart, rootNode.triangleIndex);
            }
            rootNode = null;
            if (aabbOverlap || isLeafNode) {
                ++rootNode_index;
                ++curIndex;
                continue;
            }
            int escapeIndex = this.contiguousNodes.getQuick((int)rootNode_index).escapeIndex;
            rootNode_index += escapeIndex;
            curIndex += escapeIndex;
        }
        if (maxIterations < walkIterations) {
            maxIterations = walkIterations;
        }
    }

    protected void walkRecursiveQuantizedTreeAgainstQueryAabb(QuantizedBvhNodes currentNodes, int currentNodeId, NodeOverlapCallback nodeCallback, long quantizedQueryAabbMin, long quantizedQueryAabbMax) {
        assert (this.useQuantization);
        boolean aabbOverlap = this.testQuantizedAabbAgainstQuantizedAabb(quantizedQueryAabbMin, quantizedQueryAabbMax, currentNodes.getQuantizedAabbMin(currentNodeId), currentNodes.getQuantizedAabbMax(currentNodeId));
        boolean isLeafNode = currentNodes.isLeafNode(currentNodeId);
        if (aabbOverlap) {
            if (isLeafNode) {
                nodeCallback.processNode(currentNodes.getPartId(currentNodeId), currentNodes.getTriangleIndex(currentNodeId));
            } else {
                int leftChildNodeId = currentNodeId + 1;
                this.walkRecursiveQuantizedTreeAgainstQueryAabb(currentNodes, leftChildNodeId, nodeCallback, quantizedQueryAabbMin, quantizedQueryAabbMax);
                int rightChildNodeId = currentNodes.isLeafNode(leftChildNodeId) ? leftChildNodeId + 1 : leftChildNodeId + currentNodes.getEscapeIndex(leftChildNodeId);
                this.walkRecursiveQuantizedTreeAgainstQueryAabb(currentNodes, rightChildNodeId, nodeCallback, quantizedQueryAabbMin, quantizedQueryAabbMax);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void walkStacklessQuantizedTreeAgainstRay(NodeOverlapCallback nodeOverlapCallback, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void rayTarget;
            void raySource;
            void endNodeIndex;
            void startNodeIndex;
            $Stack.push$javax$vecmath$Vector3f();
            assert (this.useQuantization);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            void curIndex = startNodeIndex;
            int walkIterations = 0;
            void subTreeSize = endNodeIndex - startNodeIndex;
            QuantizedBvhNodes rootNode = this.quantizedContiguousNodes;
            void rootNode_idx = startNodeIndex;
            boolean boxBoxOverlap = false;
            boolean rayBoxOverlap = false;
            float lambda_max = 1.0f;
            Vector3f rayFrom = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
            Vector3f rayDirection = $Stack.get$javax$vecmath$Vector3f();
            tmp.sub((Tuple3f)rayTarget, (Tuple3f)raySource);
            rayDirection.normalize(tmp);
            lambda_max = rayDirection.dot(tmp);
            rayDirection.x = 1.0f / rayDirection.x;
            rayDirection.y = 1.0f / rayDirection.y;
            rayDirection.z = 1.0f / rayDirection.z;
            Vector3f rayAabbMin = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
            Vector3f rayAabbMax = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
            VectorUtil.setMin(rayAabbMin, (Vector3f)rayTarget);
            VectorUtil.setMax(rayAabbMax, (Vector3f)rayTarget);
            rayAabbMin.add((Tuple3f)aabbMin);
            rayAabbMax.add((Tuple3f)aabbMax);
            long quantizedQueryAabbMin = this.quantizeWithClamp(rayAabbMin);
            long quantizedQueryAabbMax = this.quantizeWithClamp(rayAabbMax);
            Vector3f bounds_0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f bounds_1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            float[] param = new float[1];
            while (curIndex < endNodeIndex) {
                assert (walkIterations < subTreeSize);
                ++walkIterations;
                param[0] = 1.0f;
                rayBoxOverlap = false;
                boxBoxOverlap = this.testQuantizedAabbAgainstQuantizedAabb(quantizedQueryAabbMin, quantizedQueryAabbMax, rootNode.getQuantizedAabbMin((int)rootNode_idx), rootNode.getQuantizedAabbMax((int)rootNode_idx));
                boolean isLeafNode = rootNode.isLeafNode((int)rootNode_idx);
                if (boxBoxOverlap) {
                    this.unQuantize(bounds_0, rootNode.getQuantizedAabbMin((int)rootNode_idx));
                    this.unQuantize(bounds_1, rootNode.getQuantizedAabbMax((int)rootNode_idx));
                    bounds_0.add((Tuple3f)aabbMin);
                    bounds_1.add((Tuple3f)aabbMax);
                    rayBoxOverlap = AabbUtil2.rayAabb((Vector3f)raySource, (Vector3f)rayTarget, bounds_0, bounds_1, param, normal);
                }
                if (isLeafNode && rayBoxOverlap) {
                    void nodeCallback;
                    nodeCallback.processNode(rootNode.getPartId((int)rootNode_idx), rootNode.getTriangleIndex((int)rootNode_idx));
                }
                if (rayBoxOverlap || isLeafNode) {
                    ++rootNode_idx;
                    ++curIndex;
                    continue;
                }
                int escapeIndex = rootNode.getEscapeIndex((int)rootNode_idx);
                rootNode_idx += escapeIndex;
                curIndex += escapeIndex;
            }
            if (maxIterations < walkIterations) {
                maxIterations = walkIterations;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected void walkStacklessQuantizedTree(NodeOverlapCallback nodeCallback, long quantizedQueryAabbMin, long quantizedQueryAabbMax, int startNodeIndex, int endNodeIndex) {
        assert (this.useQuantization);
        int curIndex = startNodeIndex;
        int walkIterations = 0;
        int subTreeSize = endNodeIndex - startNodeIndex;
        QuantizedBvhNodes rootNode = this.quantizedContiguousNodes;
        int rootNode_idx = startNodeIndex;
        while (curIndex < endNodeIndex) {
            assert (walkIterations < subTreeSize);
            ++walkIterations;
            boolean aabbOverlap = this.testQuantizedAabbAgainstQuantizedAabb(quantizedQueryAabbMin, quantizedQueryAabbMax, rootNode.getQuantizedAabbMin(rootNode_idx), rootNode.getQuantizedAabbMax(rootNode_idx));
            boolean isLeafNode = rootNode.isLeafNode(rootNode_idx);
            if (isLeafNode && aabbOverlap) {
                nodeCallback.processNode(rootNode.getPartId(rootNode_idx), rootNode.getTriangleIndex(rootNode_idx));
            }
            if (aabbOverlap || isLeafNode) {
                ++rootNode_idx;
                ++curIndex;
                continue;
            }
            int escapeIndex = rootNode.getEscapeIndex(rootNode_idx);
            rootNode_idx += escapeIndex;
            curIndex += escapeIndex;
        }
        if (maxIterations < walkIterations) {
            maxIterations = walkIterations;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void reportRayOverlappingNodex(NodeOverlapCallback nodeOverlapCallback, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void rayTarget;
            void raySource;
            void nodeCallback;
            boolean fast_path;
            $Stack.push$javax$vecmath$Vector3f();
            boolean bl = fast_path = this.useQuantization && this.traversalMode == TraversalMode.STACKLESS;
            if (fast_path) {
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.set(0.0f, 0.0f, 0.0f);
                this.walkStacklessQuantizedTreeAgainstRay((NodeOverlapCallback)nodeCallback, (Vector3f)raySource, (Vector3f)rayTarget, tmp, tmp, 0, this.curNodeIndex);
            } else {
                Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
                Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
                VectorUtil.setMin(aabbMin, (Vector3f)rayTarget);
                VectorUtil.setMax(aabbMax, (Vector3f)rayTarget);
                this.reportAabbOverlappingNodex((NodeOverlapCallback)nodeCallback, aabbMin, aabbMax);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void reportBoxCastOverlappingNodex(NodeOverlapCallback nodeOverlapCallback, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            void rayTarget;
            void raySource;
            void nodeCallback;
            boolean fast_path;
            $Stack.push$javax$vecmath$Vector3f();
            boolean bl = fast_path = this.useQuantization && this.traversalMode == TraversalMode.STACKLESS;
            if (fast_path) {
                this.walkStacklessQuantizedTreeAgainstRay((NodeOverlapCallback)nodeCallback, (Vector3f)raySource, (Vector3f)rayTarget, (Vector3f)aabbMin, (Vector3f)aabbMax, 0, this.curNodeIndex);
            } else {
                Vector3f qaabbMin = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
                Vector3f qaabbMax = $Stack.get$javax$vecmath$Vector3f((Vector3f)raySource);
                VectorUtil.setMin(qaabbMin, (Vector3f)rayTarget);
                VectorUtil.setMax(qaabbMax, (Vector3f)rayTarget);
                qaabbMin.add((Tuple3f)aabbMin);
                qaabbMax.add((Tuple3f)aabbMax);
                this.reportAabbOverlappingNodex((NodeOverlapCallback)nodeCallback, qaabbMin, qaabbMax);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public long quantizeWithClamp(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void point;
            $Stack.push$javax$vecmath$Vector3f();
            assert (this.useQuantization);
            Vector3f clampedPoint = $Stack.get$javax$vecmath$Vector3f((Vector3f)point);
            VectorUtil.setMax(clampedPoint, this.bvhAabbMin);
            VectorUtil.setMin(clampedPoint, this.bvhAabbMax);
            Vector3f v = $Stack.get$javax$vecmath$Vector3f();
            v.sub(clampedPoint, this.bvhAabbMin);
            VectorUtil.mul(v, v, this.bvhQuantization);
            int out0 = (int)(v.x + 0.5f) & 0xFFFF;
            int out1 = (int)(v.y + 0.5f) & 0xFFFF;
            int out2 = (int)(v.z + 0.5f) & 0xFFFF;
            long l = (long)out0 | (long)out1 << 16 | (long)out2 << 32;
            $Stack.pop$javax$vecmath$Vector3f();
            return l;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void unQuantize(Vector3f vecOut, long vecIn) {
        int vecIn0 = (int)(vecIn & 0xFFFFL);
        int vecIn1 = (int)((vecIn & 0xFFFF0000L) >>> 16);
        int vecIn2 = (int)((vecIn & 0xFFFF00000000L) >>> 32);
        vecOut.x = (float)vecIn0 / this.bvhQuantization.x;
        vecOut.y = (float)vecIn1 / this.bvhQuantization.y;
        vecOut.z = (float)vecIn2 / this.bvhQuantization.z;
        vecOut.add(this.bvhAabbMin);
    }

    private static class QuantizedNodeTriangleCallback
    extends InternalTriangleIndexCallback {
        public QuantizedBvhNodes triangleNodes;
        public OptimizedBvh optimizedTree;

        public QuantizedNodeTriangleCallback(QuantizedBvhNodes triangleNodes, OptimizedBvh tree) {
            this.triangleNodes = triangleNodes;
            this.optimizedTree = tree;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void internalProcessTriangleIndex(Vector3f[] vector3fArray, int n, int n2) {
            $Stack $Stack = $Stack.get();
            try {
                void triangle;
                void triangleIndex;
                void partId;
                $Stack.push$javax$vecmath$Vector3f();
                assert (partId < 1024);
                assert (triangleIndex < 0x200000);
                assert (triangleIndex >= 0);
                int nodeId = this.triangleNodes.add();
                Vector3f aabbMin = $Stack.get$javax$vecmath$Vector3f();
                Vector3f aabbMax = $Stack.get$javax$vecmath$Vector3f();
                aabbMin.set(1.0E30f, 1.0E30f, 1.0E30f);
                aabbMax.set(-1.0E30f, -1.0E30f, -1.0E30f);
                VectorUtil.setMin(aabbMin, (Vector3f)triangle[0]);
                VectorUtil.setMax(aabbMax, (Vector3f)triangle[0]);
                VectorUtil.setMin(aabbMin, (Vector3f)triangle[1]);
                VectorUtil.setMax(aabbMax, (Vector3f)triangle[1]);
                VectorUtil.setMin(aabbMin, (Vector3f)triangle[2]);
                VectorUtil.setMax(aabbMax, (Vector3f)triangle[2]);
                float MIN_AABB_DIMENSION = 0.002f;
                float MIN_AABB_HALF_DIMENSION = 0.001f;
                if (aabbMax.x - aabbMin.x < 0.002f) {
                    aabbMax.x += 0.001f;
                    aabbMin.x -= 0.001f;
                }
                if (aabbMax.y - aabbMin.y < 0.002f) {
                    aabbMax.y += 0.001f;
                    aabbMin.y -= 0.001f;
                }
                if (aabbMax.z - aabbMin.z < 0.002f) {
                    aabbMax.z += 0.001f;
                    aabbMin.z -= 0.001f;
                }
                this.triangleNodes.setQuantizedAabbMin(nodeId, this.optimizedTree.quantizeWithClamp(aabbMin));
                this.triangleNodes.setQuantizedAabbMax(nodeId, this.optimizedTree.quantizeWithClamp(aabbMax));
                this.triangleNodes.setEscapeIndexOrTriangleIndex(nodeId, partId << 21 | triangleIndex);
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }

    private static class NodeTriangleCallback
    extends InternalTriangleIndexCallback {
        public ObjectArrayList<OptimizedBvhNode> triangleNodes;
        private final Vector3f aabbMin = new Vector3f();
        private final Vector3f aabbMax = new Vector3f();

        public NodeTriangleCallback(ObjectArrayList<OptimizedBvhNode> triangleNodes) {
            this.triangleNodes = triangleNodes;
        }

        @Override
        public void internalProcessTriangleIndex(Vector3f[] triangle, int partId, int triangleIndex) {
            OptimizedBvhNode node = new OptimizedBvhNode();
            this.aabbMin.set(1.0E30f, 1.0E30f, 1.0E30f);
            this.aabbMax.set(-1.0E30f, -1.0E30f, -1.0E30f);
            VectorUtil.setMin(this.aabbMin, triangle[0]);
            VectorUtil.setMax(this.aabbMax, triangle[0]);
            VectorUtil.setMin(this.aabbMin, triangle[1]);
            VectorUtil.setMax(this.aabbMax, triangle[1]);
            VectorUtil.setMin(this.aabbMin, triangle[2]);
            VectorUtil.setMax(this.aabbMax, triangle[2]);
            node.aabbMinOrg.set(this.aabbMin);
            node.aabbMaxOrg.set(this.aabbMax);
            node.escapeIndex = -1;
            node.subPart = partId;
            node.triangleIndex = triangleIndex;
            this.triangleNodes.add(node);
        }
    }
}

