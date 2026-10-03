/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.BvhDataArray;
import com.bulletphysics.extras.gimpact.BvhTreeNodeArray;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

class BvhTree {
    protected int num_nodes = 0;
    protected BvhTreeNodeArray node_array = new BvhTreeNodeArray();

    BvhTree() {
    }

    /*
     * WARNING - void declaration
     */
    protected int _calc_splitting_axis(BvhDataArray bvhDataArray, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void primitive_boxes;
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
            Vector3f diff2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            for (i = startIndex; i < endIndex; ++i) {
                primitive_boxes.getBoundMax((int)i, tmp1);
                primitive_boxes.getBoundMin((int)i, tmp2);
                center.add(tmp1, tmp2);
                center.scale(0.5f);
                means.add(center);
            }
            means.scale(1.0f / (float)numIndices);
            for (i = startIndex; i < endIndex; ++i) {
                primitive_boxes.getBoundMax((int)i, tmp1);
                primitive_boxes.getBoundMin((int)i, tmp2);
                center.add(tmp1, tmp2);
                center.scale(0.5f);
                diff2.sub(center, means);
                VectorUtil.mul(diff2, diff2, diff2);
                variance.add(diff2);
            }
            variance.scale(1.0f / (float)(numIndices - true));
            int n3 = VectorUtil.maxAxis(variance);
            $Stack.pop$javax$vecmath$Vector3f();
            return n3;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected int _sort_and_calc_splitting_index(BvhDataArray bvhDataArray, int n, int n2, int n3) {
        $Stack $Stack = $Stack.get();
        try {
            boolean unbal;
            boolean unbalanced;
            void splitAxis;
            void primitive_boxes;
            void i;
            void endIndex;
            void startIndex;
            $Stack.push$javax$vecmath$Vector3f();
            void splitIndex = startIndex;
            void numIndices = endIndex - startIndex;
            float splitValue = 0.0f;
            Vector3f means = $Stack.get$javax$vecmath$Vector3f();
            means.set(0.0f, 0.0f, 0.0f);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            for (i = startIndex; i < endIndex; ++i) {
                primitive_boxes.getBoundMax((int)i, tmp1);
                primitive_boxes.getBoundMin((int)i, tmp2);
                center.add(tmp1, tmp2);
                center.scale(0.5f);
                means.add(center);
            }
            means.scale(1.0f / (float)numIndices);
            splitValue = VectorUtil.getCoord(means, (int)splitAxis);
            for (i = startIndex; i < endIndex; ++i) {
                primitive_boxes.getBoundMax((int)i, tmp1);
                primitive_boxes.getBoundMin((int)i, tmp2);
                center.add(tmp1, tmp2);
                center.scale(0.5f);
                if (!(VectorUtil.getCoord(center, (int)splitAxis) > splitValue)) continue;
                primitive_boxes.swap((int)i, (int)splitIndex);
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
    protected void _build_sub_tree(BvhDataArray bvhDataArray, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void primitive_boxes;
            void startIndex;
            void endIndex;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            int curIndex = this.num_nodes++;
            assert (endIndex - startIndex > 0);
            if (endIndex - startIndex == true) {
                this.node_array.set(curIndex, (BvhDataArray)primitive_boxes, (int)startIndex);
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                return;
            }
            int splitIndex = this._calc_splitting_axis((BvhDataArray)primitive_boxes, (int)startIndex, (int)endIndex);
            splitIndex = this._sort_and_calc_splitting_index((BvhDataArray)primitive_boxes, (int)startIndex, (int)endIndex, splitIndex);
            BoxCollision.AABB node_bound = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB tmpAABB = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            node_bound.invalidate();
            for (void i = startIndex; i < endIndex; ++i) {
                primitive_boxes.getBound((int)i, tmpAABB);
                node_bound.merge(tmpAABB);
            }
            this.setNodeBound(curIndex, node_bound);
            this._build_sub_tree((BvhDataArray)primitive_boxes, (int)startIndex, splitIndex);
            this._build_sub_tree((BvhDataArray)primitive_boxes, splitIndex, (int)endIndex);
            this.node_array.setEscapeIndex(curIndex, this.num_nodes - curIndex);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    public void build_tree(BvhDataArray primitive_boxes) {
        this.num_nodes = 0;
        this.node_array.resize(primitive_boxes.size() * 2);
        this._build_sub_tree(primitive_boxes, 0, primitive_boxes.size());
    }

    public void clearNodes() {
        this.node_array.clear();
        this.num_nodes = 0;
    }

    public int getNodeCount() {
        return this.num_nodes;
    }

    public boolean isLeafNode(int nodeindex) {
        return this.node_array.isLeafNode(nodeindex);
    }

    public int getNodeData(int nodeindex) {
        return this.node_array.getDataIndex(nodeindex);
    }

    public void getNodeBound(int nodeindex, BoxCollision.AABB bound) {
        this.node_array.getBound(nodeindex, bound);
    }

    public void setNodeBound(int nodeindex, BoxCollision.AABB bound) {
        this.node_array.setBound(nodeindex, bound);
    }

    public int getLeftNode(int nodeindex) {
        return nodeindex + 1;
    }

    public int getRightNode(int nodeindex) {
        if (this.node_array.isLeafNode(nodeindex + 1)) {
            return nodeindex + 2;
        }
        return nodeindex + 1 + this.node_array.getEscapeIndex(nodeindex + 1);
    }

    public int getEscapeNodeIndex(int nodeindex) {
        return this.node_array.getEscapeIndex(nodeindex);
    }

    public BvhTreeNodeArray get_node_pointer() {
        return this.node_array;
    }
}

