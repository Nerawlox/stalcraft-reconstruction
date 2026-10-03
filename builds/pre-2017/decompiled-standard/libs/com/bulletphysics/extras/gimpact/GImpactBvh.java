/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.BvhDataArray;
import com.bulletphysics.extras.gimpact.BvhTree;
import com.bulletphysics.extras.gimpact.BvhTreeNodeArray;
import com.bulletphysics.extras.gimpact.PairSet;
import com.bulletphysics.extras.gimpact.PrimitiveManagerBase;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.IntArrayList;
import javax.vecmath.Vector3f;

class GImpactBvh {
    protected BvhTree box_tree = new BvhTree();
    protected PrimitiveManagerBase primitive_manager;

    public GImpactBvh() {
        this.primitive_manager = null;
    }

    public GImpactBvh(PrimitiveManagerBase primitive_manager) {
        this.primitive_manager = primitive_manager;
    }

    public BoxCollision.AABB getGlobalBox(BoxCollision.AABB out) {
        this.getNodeBound(0, out);
        return out;
    }

    public void setPrimitiveManager(PrimitiveManagerBase primitive_manager) {
        this.primitive_manager = primitive_manager;
    }

    public PrimitiveManagerBase getPrimitiveManager() {
        return this.primitive_manager;
    }

    protected void refit() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB leafbox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB bound = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB temp_box = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            int nodecount = this.getNodeCount();
            while (nodecount-- != 0) {
                if (this.isLeafNode(nodecount)) {
                    this.primitive_manager.get_primitive_box(this.getNodeData(nodecount), leafbox);
                    this.setNodeBound(nodecount, leafbox);
                    continue;
                }
                bound.invalidate();
                int child_node = this.getLeftNode(nodecount);
                if (child_node != 0) {
                    this.getNodeBound(child_node, temp_box);
                    bound.merge(temp_box);
                }
                if ((child_node = this.getRightNode(nodecount)) != 0) {
                    this.getNodeBound(child_node, temp_box);
                    bound.merge(temp_box);
                }
                this.setNodeBound(nodecount, bound);
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    public void update() {
        this.refit();
    }

    public void buildSet() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BvhDataArray primitive_boxes = new BvhDataArray();
            primitive_boxes.resize(this.primitive_manager.get_primitive_count());
            BoxCollision.AABB tmpAABB = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            for (int i = 0; i < primitive_boxes.size(); ++i) {
                this.primitive_manager.get_primitive_box(i, tmpAABB);
                primitive_boxes.setBound(i, tmpAABB);
                primitive_boxes.setData(i, i);
            }
            this.box_tree.build_tree(primitive_boxes);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean boxQuery(BoxCollision.AABB aABB, IntArrayList intArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            void collided_results;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            int curIndex = 0;
            int numNodes = this.getNodeCount();
            BoxCollision.AABB bound = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            while (curIndex < numNodes) {
                void box;
                this.getNodeBound(curIndex, bound);
                boolean aabbOverlap = bound.has_collision((BoxCollision.AABB)box);
                boolean isleafnode = this.isLeafNode(curIndex);
                if (isleafnode && aabbOverlap) {
                    collided_results.add(this.getNodeData(curIndex));
                }
                if (aabbOverlap || isleafnode) {
                    ++curIndex;
                    continue;
                }
                curIndex += this.getEscapeNodeIndex(curIndex);
            }
            if (collided_results.size() > 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                return true;
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return false;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean boxQueryTrans(BoxCollision.AABB aABB, Transform transform, IntArrayList intArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            void collided_results;
            void transform2;
            void box;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB transbox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB((BoxCollision.AABB)box);
            transbox.appy_transform((Transform)transform2);
            boolean bl = this.boxQuery(transbox, (IntArrayList)collided_results);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return bl;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean rayQuery(Vector3f vector3f, Vector3f vector3f2, IntArrayList intArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            void collided_results;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            int curIndex = 0;
            int numNodes = this.getNodeCount();
            BoxCollision.AABB bound = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            while (curIndex < numNodes) {
                void ray_dir;
                void ray_origin;
                this.getNodeBound(curIndex, bound);
                boolean aabbOverlap = bound.collide_ray((Vector3f)ray_origin, (Vector3f)ray_dir);
                boolean isleafnode = this.isLeafNode(curIndex);
                if (isleafnode && aabbOverlap) {
                    collided_results.add(this.getNodeData(curIndex));
                }
                if (aabbOverlap || isleafnode) {
                    ++curIndex;
                    continue;
                }
                curIndex += this.getEscapeNodeIndex(curIndex);
            }
            if (collided_results.size() > 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                return true;
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return false;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    public boolean hasHierarchy() {
        return true;
    }

    public boolean isTrimesh() {
        return this.primitive_manager.is_trimesh();
    }

    public int getNodeCount() {
        return this.box_tree.getNodeCount();
    }

    public boolean isLeafNode(int nodeindex) {
        return this.box_tree.isLeafNode(nodeindex);
    }

    public int getNodeData(int nodeindex) {
        return this.box_tree.getNodeData(nodeindex);
    }

    public void getNodeBound(int nodeindex, BoxCollision.AABB bound) {
        this.box_tree.getNodeBound(nodeindex, bound);
    }

    public void setNodeBound(int nodeindex, BoxCollision.AABB bound) {
        this.box_tree.setNodeBound(nodeindex, bound);
    }

    public int getLeftNode(int nodeindex) {
        return this.box_tree.getLeftNode(nodeindex);
    }

    public int getRightNode(int nodeindex) {
        return this.box_tree.getRightNode(nodeindex);
    }

    public int getEscapeNodeIndex(int nodeindex) {
        return this.box_tree.getEscapeNodeIndex(nodeindex);
    }

    public void getNodeTriangle(int nodeindex, PrimitiveTriangle triangle) {
        this.primitive_manager.get_primitive_triangle(this.getNodeData(nodeindex), triangle);
    }

    public BvhTreeNodeArray get_node_pointer() {
        return this.box_tree.get_node_pointer();
    }

    /*
     * WARNING - void declaration
     */
    private static boolean _node_collision(GImpactBvh gImpactBvh, GImpactBvh gImpactBvh2, BoxCollision.BoxBoxTransformCache boxBoxTransformCache, int n, int n2, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void complete_primitive_tests;
            void trans_cache_1to0;
            void node1;
            void boxset1;
            void node0;
            GImpactBvh boxset0;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB box0 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            boxset0.getNodeBound((int)node0, box0);
            BoxCollision.AABB box1 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            boxset1.getNodeBound((int)node1, box1);
            boolean bl2 = box0.overlapping_trans_cache(box1, (BoxCollision.BoxBoxTransformCache)trans_cache_1to0, (boolean)complete_primitive_tests);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return bl2;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    private static void _find_collision_pairs_recursive(GImpactBvh boxset0, GImpactBvh boxset1, PairSet collision_pairs, BoxCollision.BoxBoxTransformCache trans_cache_1to0, int node0, int node1, boolean complete_primitive_tests) {
        if (!GImpactBvh._node_collision(boxset0, boxset1, trans_cache_1to0, node0, node1, complete_primitive_tests)) {
            return;
        }
        if (boxset0.isLeafNode(node0)) {
            if (boxset1.isLeafNode(node1)) {
                collision_pairs.push_pair(boxset0.getNodeData(node0), boxset1.getNodeData(node1));
                return;
            }
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, node0, boxset1.getLeftNode(node1), false);
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, node0, boxset1.getRightNode(node1), false);
        } else if (boxset1.isLeafNode(node1)) {
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getLeftNode(node0), node1, false);
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getRightNode(node0), node1, false);
        } else {
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getLeftNode(node0), boxset1.getLeftNode(node1), false);
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getLeftNode(node0), boxset1.getRightNode(node1), false);
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getRightNode(node0), boxset1.getLeftNode(node1), false);
            GImpactBvh._find_collision_pairs_recursive(boxset0, boxset1, collision_pairs, trans_cache_1to0, boxset0.getRightNode(node0), boxset1.getRightNode(node1), false);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void find_collision(GImpactBvh gImpactBvh, Transform transform, GImpactBvh gImpactBvh2, Transform transform2, PairSet pairSet) {
        $Stack $Stack = $Stack.get();
        try {
            void collision_pairs;
            void trans1;
            void trans0;
            void boxset1;
            GImpactBvh boxset0;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$BoxBoxTransformCache();
            if (boxset0.getNodeCount() == 0 || boxset1.getNodeCount() == 0) {
                $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$BoxBoxTransformCache();
                return;
            }
            BoxCollision.BoxBoxTransformCache trans_cache_1to0 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$BoxBoxTransformCache();
            trans_cache_1to0.calc_from_homogenic((Transform)trans0, (Transform)trans1);
            GImpactBvh._find_collision_pairs_recursive(boxset0, (GImpactBvh)boxset1, (PairSet)collision_pairs, trans_cache_1to0, 0, 0, true);
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$BoxBoxTransformCache();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$BoxBoxTransformCache();
            throw throwable;
        }
    }
}

