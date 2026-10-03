/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.DbvtAabbMm;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import java.util.Collections;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class Dbvt {
    public static final int SIMPLE_STACKSIZE = 64;
    public static final int DOUBLE_STACKSIZE = 128;
    public Node root = null;
    public Node free = null;
    public int lkhd = -1;
    public int leaves = 0;
    public int opath = 0;
    private static Vector3f[] axis = new Vector3f[]{new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 1.0f, 0.0f), new Vector3f(0.0f, 0.0f, 1.0f)};

    public void clear() {
        if (this.root != null) {
            Dbvt.recursedeletenode(this, this.root);
        }
        this.free = null;
    }

    public boolean empty() {
        return this.root == null;
    }

    public void optimizeBottomUp() {
        if (this.root != null) {
            ObjectArrayList<Node> leaves = new ObjectArrayList<Node>(this.leaves);
            Dbvt.fetchleaves(this, this.root, leaves);
            Dbvt.bottomup(this, leaves);
            this.root = leaves.getQuick(0);
        }
    }

    public void optimizeTopDown() {
        this.optimizeTopDown(128);
    }

    public void optimizeTopDown(int bu_treshold) {
        if (this.root != null) {
            ObjectArrayList<Node> leaves = new ObjectArrayList<Node>(this.leaves);
            Dbvt.fetchleaves(this, this.root, leaves);
            this.root = Dbvt.topdown(this, leaves, bu_treshold);
        }
    }

    public void optimizeIncremental(int passes) {
        if (passes < 0) {
            passes = this.leaves;
        }
        if (this.root != null && passes > 0) {
            Node[] root_ref = new Node[1];
            do {
                Node node = this.root;
                int bit = 0;
                while (node.isinternal()) {
                    root_ref[0] = this.root;
                    node = Dbvt.sort((Node)node, (Node[])root_ref).childs[this.opath >>> bit & 1];
                    this.root = root_ref[0];
                    bit = bit + 1 & 0x1F;
                }
                this.update(node);
                ++this.opath;
            } while (--passes != 0);
        }
    }

    public Node insert(DbvtAabbMm box, Object data2) {
        Node leaf = Dbvt.createnode(this, null, box, data2);
        Dbvt.insertleaf(this, this.root, leaf);
        ++this.leaves;
        return leaf;
    }

    public void update(Node leaf) {
        this.update(leaf, -1);
    }

    public void update(Node leaf, int lookahead) {
        Node root = Dbvt.removeleaf(this, leaf);
        if (root != null) {
            if (lookahead >= 0) {
                for (int i = 0; i < lookahead && root.parent != null; ++i) {
                    root = root.parent;
                }
            } else {
                root = this.root;
            }
        }
        Dbvt.insertleaf(this, root, leaf);
    }

    public void update(Node leaf, DbvtAabbMm volume) {
        Node root = Dbvt.removeleaf(this, leaf);
        if (root != null) {
            if (this.lkhd >= 0) {
                for (int i = 0; i < this.lkhd && root.parent != null; ++i) {
                    root = root.parent;
                }
            } else {
                root = this.root;
            }
        }
        leaf.volume.set(volume);
        Dbvt.insertleaf(this, root, leaf);
    }

    /*
     * WARNING - void declaration
     */
    public boolean update(Node node, DbvtAabbMm dbvtAabbMm, Vector3f vector3f, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void velocity;
            void margin;
            void volume;
            void leaf;
            $Stack.push$javax$vecmath$Vector3f();
            if (leaf.volume.Contain((DbvtAabbMm)volume)) {
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.set((float)margin, (float)margin, (float)margin);
            volume.Expand(tmp);
            volume.SignedExpand((Vector3f)velocity);
            this.update((Node)leaf, (DbvtAabbMm)volume);
            $Stack.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean update(Node leaf, DbvtAabbMm volume, Vector3f velocity) {
        if (leaf.volume.Contain(volume)) {
            return false;
        }
        volume.SignedExpand(velocity);
        this.update(leaf, volume);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public boolean update(Node node, DbvtAabbMm dbvtAabbMm, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void margin;
            void volume;
            void leaf;
            $Stack.push$javax$vecmath$Vector3f();
            if (leaf.volume.Contain((DbvtAabbMm)volume)) {
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.set((float)margin, (float)margin, (float)margin);
            volume.Expand(tmp);
            this.update((Node)leaf, (DbvtAabbMm)volume);
            $Stack.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void remove(Node leaf) {
        Dbvt.removeleaf(this, leaf);
        Dbvt.deletenode(this, leaf);
        --this.leaves;
    }

    public void write(IWriter iwriter) {
        throw new UnsupportedOperationException();
    }

    public void clone(Dbvt dest) {
        this.clone(dest, null);
    }

    public void clone(Dbvt dest, IClone iclone) {
        throw new UnsupportedOperationException();
    }

    public static int countLeaves(Node node) {
        if (node.isinternal()) {
            return Dbvt.countLeaves(node.childs[0]) + Dbvt.countLeaves(node.childs[1]);
        }
        return 1;
    }

    public static void extractLeaves(Node node, ObjectArrayList<Node> leaves) {
        if (node.isinternal()) {
            Dbvt.extractLeaves(node.childs[0], leaves);
            Dbvt.extractLeaves(node.childs[1], leaves);
        } else {
            leaves.add(node);
        }
    }

    public static void enumNodes(Node root, ICollide policy2) {
        policy2.Process(root);
        if (root.isinternal()) {
            Dbvt.enumNodes(root.childs[0], policy2);
            Dbvt.enumNodes(root.childs[1], policy2);
        }
    }

    public static void enumLeaves(Node root, ICollide policy2) {
        if (root.isinternal()) {
            Dbvt.enumLeaves(root.childs[0], policy2);
            Dbvt.enumLeaves(root.childs[1], policy2);
        } else {
            policy2.Process(root);
        }
    }

    public static void collideTT(Node root0, Node root1, ICollide policy2) {
        if (root0 != null && root1 != null) {
            ObjectArrayList<sStkNN> stack = new ObjectArrayList<sStkNN>(128);
            stack.add(new sStkNN(root0, root1));
            do {
                sStkNN p = (sStkNN)stack.remove(stack.size() - 1);
                if (p.a == p.b) {
                    if (!p.a.isinternal()) continue;
                    stack.add(new sStkNN(p.a.childs[0], p.a.childs[0]));
                    stack.add(new sStkNN(p.a.childs[1], p.a.childs[1]));
                    stack.add(new sStkNN(p.a.childs[0], p.a.childs[1]));
                    continue;
                }
                if (!DbvtAabbMm.Intersect(p.a.volume, p.b.volume)) continue;
                if (p.a.isinternal()) {
                    if (p.b.isinternal()) {
                        stack.add(new sStkNN(p.a.childs[0], p.b.childs[0]));
                        stack.add(new sStkNN(p.a.childs[1], p.b.childs[0]));
                        stack.add(new sStkNN(p.a.childs[0], p.b.childs[1]));
                        stack.add(new sStkNN(p.a.childs[1], p.b.childs[1]));
                        continue;
                    }
                    stack.add(new sStkNN(p.a.childs[0], p.b));
                    stack.add(new sStkNN(p.a.childs[1], p.b));
                    continue;
                }
                if (p.b.isinternal()) {
                    stack.add(new sStkNN(p.a, p.b.childs[0]));
                    stack.add(new sStkNN(p.a, p.b.childs[1]));
                    continue;
                }
                policy2.Process(p.a, p.b);
            } while (stack.size() > 0);
        }
    }

    public static void collideTT(Node root0, Node root1, Transform xform, ICollide policy2) {
        if (root0 != null && root1 != null) {
            ObjectArrayList<sStkNN> stack = new ObjectArrayList<sStkNN>(128);
            stack.add(new sStkNN(root0, root1));
            do {
                sStkNN p = (sStkNN)stack.remove(stack.size() - 1);
                if (p.a == p.b) {
                    if (!p.a.isinternal()) continue;
                    stack.add(new sStkNN(p.a.childs[0], p.a.childs[0]));
                    stack.add(new sStkNN(p.a.childs[1], p.a.childs[1]));
                    stack.add(new sStkNN(p.a.childs[0], p.a.childs[1]));
                    continue;
                }
                if (!DbvtAabbMm.Intersect(p.a.volume, p.b.volume, xform)) continue;
                if (p.a.isinternal()) {
                    if (p.b.isinternal()) {
                        stack.add(new sStkNN(p.a.childs[0], p.b.childs[0]));
                        stack.add(new sStkNN(p.a.childs[1], p.b.childs[0]));
                        stack.add(new sStkNN(p.a.childs[0], p.b.childs[1]));
                        stack.add(new sStkNN(p.a.childs[1], p.b.childs[1]));
                        continue;
                    }
                    stack.add(new sStkNN(p.a.childs[0], p.b));
                    stack.add(new sStkNN(p.a.childs[1], p.b));
                    continue;
                }
                if (p.b.isinternal()) {
                    stack.add(new sStkNN(p.a, p.b.childs[0]));
                    stack.add(new sStkNN(p.a, p.b.childs[1]));
                    continue;
                }
                policy2.Process(p.a, p.b);
            } while (stack.size() > 0);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void collideTT(Node node, Transform transform, Node node2, Transform transform2, ICollide iCollide) {
        $Stack $Stack = $Stack.get();
        try {
            void policy2;
            void root1;
            Node root0;
            void xform1;
            void xform0;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform xform = $Stack.get$com$bulletphysics$linearmath$Transform();
            xform.inverse((Transform)xform0);
            xform.mul((Transform)xform1);
            Dbvt.collideTT(root0, (Node)root1, xform, (ICollide)policy2);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    public static void collideTV(Node root, DbvtAabbMm volume, ICollide policy2) {
        if (root != null) {
            ObjectArrayList<Node> stack = new ObjectArrayList<Node>(64);
            stack.add(root);
            do {
                Node n = (Node)stack.remove(stack.size() - 1);
                if (!DbvtAabbMm.Intersect(n.volume, volume)) continue;
                if (n.isinternal()) {
                    stack.add(n.childs[0]);
                    stack.add(n.childs[1]);
                    continue;
                }
                policy2.Process(n);
            } while (stack.size() > 0);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void collideRAY(Node node, Vector3f vector3f, Vector3f vector3f2, ICollide iCollide) {
        $Stack $Stack = $Stack.get();
        try {
            Node root;
            $Stack.push$javax$vecmath$Vector3f();
            if (root != null) {
                void direction;
                Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
                normal.normalize((Vector3f)direction);
                Vector3f invdir = $Stack.get$javax$vecmath$Vector3f();
                invdir.set(1.0f / normal.x, 1.0f / normal.y, 1.0f / normal.z);
                int[] signs = new int[]{direction.x < 0.0f ? 1 : 0, direction.y < 0.0f ? 1 : 0, direction.z < 0.0f ? 1 : 0};
                ObjectArrayList<Node> stack = new ObjectArrayList<Node>(64);
                stack.add(root);
                do {
                    void policy2;
                    void origin;
                    Node node2 = (Node)stack.remove(stack.size() - 1);
                    if (!DbvtAabbMm.Intersect(node2.volume, (Vector3f)origin, invdir, signs)) continue;
                    if (node2.isinternal()) {
                        stack.add(node2.childs[0]);
                        stack.add(node2.childs[1]);
                        continue;
                    }
                    policy2.Process(node2);
                } while (stack.size() != 0);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static void collideKDOP(Node root, Vector3f[] normals, float[] offsets, int count, ICollide policy2) {
        if (root != null) {
            int inside = (1 << count) - 1;
            ObjectArrayList<sStkNP> stack = new ObjectArrayList<sStkNP>(64);
            int[] signs = new int[32];
            assert (count < 32);
            for (int i = 0; i < count; ++i) {
                signs[i] = (normals[i].x >= 0.0f ? 1 : 0) + (normals[i].y >= 0.0f ? 2 : 0) + (normals[i].z >= 0.0f ? 4 : 0);
            }
            stack.add(new sStkNP(root, 0));
            do {
                sStkNP se = (sStkNP)stack.remove(stack.size() - 1);
                boolean out = false;
                int i = 0;
                int j = 1;
                while (!out && i < count) {
                    if (0 == (se.mask & j)) {
                        int side = se.node.volume.Classify(normals[i], offsets[i], signs[i]);
                        switch (side) {
                            case -1: {
                                out = true;
                                break;
                            }
                            case 1: {
                                se.mask |= j;
                            }
                        }
                    }
                    ++i;
                    j <<= 1;
                }
                if (out) continue;
                if (se.mask != inside && se.node.isinternal()) {
                    stack.add(new sStkNP(se.node.childs[0], se.mask));
                    stack.add(new sStkNP(se.node.childs[1], se.mask));
                    continue;
                }
                if (!policy2.AllLeaves(se.node)) continue;
                Dbvt.enumLeaves(se.node, policy2);
            } while (stack.size() != 0);
        }
    }

    public static void collideOCL(Node root, Vector3f[] normals, float[] offsets, Vector3f sortaxis, int count, ICollide policy2) {
        Dbvt.collideOCL(root, normals, offsets, sortaxis, count, policy2, true);
    }

    public static void collideOCL(Node root, Vector3f[] normals, float[] offsets, Vector3f sortaxis, int count, ICollide policy2, boolean fullsort) {
        if (root != null) {
            int srtsgns = (sortaxis.x >= 0.0f ? 1 : 0) + (sortaxis.y >= 0.0f ? 2 : 0) + (sortaxis.z >= 0.0f ? 4 : 0);
            int inside = (1 << count) - 1;
            ObjectArrayList<sStkNPS> stock = new ObjectArrayList<sStkNPS>();
            IntArrayList ifree = new IntArrayList();
            IntArrayList stack = new IntArrayList();
            int[] signs = new int[32];
            assert (count < 32);
            for (int i = 0; i < count; ++i) {
                signs[i] = (normals[i].x >= 0.0f ? 1 : 0) + (normals[i].y >= 0.0f ? 2 : 0) + (normals[i].z >= 0.0f ? 4 : 0);
            }
            stack.add(Dbvt.allocate(ifree, stock, new sStkNPS(root, 0, root.volume.ProjectMinimum(sortaxis, srtsgns))));
            do {
                int id = stack.remove(stack.size() - 1);
                sStkNPS se = stock.getQuick(id);
                ifree.add(id);
                if (se.mask != inside) {
                    boolean out = false;
                    int i = 0;
                    int j = 1;
                    while (!out && i < count) {
                        if (0 == (se.mask & j)) {
                            int side = se.node.volume.Classify(normals[i], offsets[i], signs[i]);
                            switch (side) {
                                case -1: {
                                    out = true;
                                    break;
                                }
                                case 1: {
                                    se.mask |= j;
                                }
                            }
                        }
                        ++i;
                        j <<= 1;
                    }
                    if (out) continue;
                }
                if (!policy2.Descent(se.node)) continue;
                if (se.node.isinternal()) {
                    Node[] pns = new Node[]{se.node.childs[0], se.node.childs[1]};
                    sStkNPS[] nes = new sStkNPS[]{new sStkNPS(pns[0], se.mask, pns[0].volume.ProjectMinimum(sortaxis, srtsgns)), new sStkNPS(pns[1], se.mask, pns[1].volume.ProjectMinimum(sortaxis, srtsgns))};
                    int q = nes[0].value < nes[1].value ? 1 : 0;
                    int j = stack.size();
                    if (fullsort && j > 0) {
                        int k;
                        j = Dbvt.nearest(stack, stock, nes[q].value, 0, stack.size());
                        stack.add(0);
                        for (k = stack.size() - 1; k > j; --k) {
                            stack.set(k, stack.get(k - 1));
                        }
                        stack.set(j, Dbvt.allocate(ifree, stock, nes[q]));
                        j = Dbvt.nearest(stack, stock, nes[1 - q].value, j, stack.size());
                        stack.add(0);
                        for (k = stack.size() - 1; k > j; --k) {
                            stack.set(k, stack.get(k - 1));
                        }
                        stack.set(j, Dbvt.allocate(ifree, stock, nes[1 - q]));
                        continue;
                    }
                    stack.add(Dbvt.allocate(ifree, stock, nes[q]));
                    stack.add(Dbvt.allocate(ifree, stock, nes[1 - q]));
                    continue;
                }
                policy2.Process(se.node, se.value);
            } while (stack.size() != 0);
        }
    }

    public static void collideTU(Node root, ICollide policy2) {
        if (root != null) {
            ObjectArrayList<Node> stack = new ObjectArrayList<Node>(64);
            stack.add(root);
            do {
                Node n;
                if (!policy2.Descent(n = (Node)stack.remove(stack.size() - 1))) continue;
                if (n.isinternal()) {
                    stack.add(n.childs[0]);
                    stack.add(n.childs[1]);
                    continue;
                }
                policy2.Process(n);
            } while (stack.size() > 0);
        }
    }

    public static int nearest(IntArrayList i, ObjectArrayList<sStkNPS> a, float v, int l, int h) {
        int m = 0;
        while (l < h) {
            m = l + h >> 1;
            if (a.getQuick((int)i.get((int)m)).value >= v) {
                l = m + 1;
                continue;
            }
            h = m;
        }
        return h;
    }

    public static int allocate(IntArrayList ifree, ObjectArrayList<sStkNPS> stock, sStkNPS value) {
        int i;
        if (ifree.size() > 0) {
            i = ifree.get(ifree.size() - 1);
            ifree.remove(ifree.size() - 1);
            stock.getQuick(i).set(value);
        } else {
            i = stock.size();
            stock.add(value);
        }
        return i;
    }

    private static int indexof(Node node) {
        return node.parent.childs[1] == node ? 1 : 0;
    }

    private static DbvtAabbMm merge(DbvtAabbMm a, DbvtAabbMm b, DbvtAabbMm out) {
        DbvtAabbMm.Merge(a, b, out);
        return out;
    }

    private static float size(DbvtAabbMm dbvtAabbMm) {
        $Stack $Stack = $Stack.get();
        try {
            DbvtAabbMm a;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f edges = a.Lengths($Stack.get$javax$vecmath$Vector3f());
            float f = edges.x * edges.y * edges.z + edges.x + edges.y + edges.z;
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static void deletenode(Dbvt pdbvt, Node node) {
        pdbvt.free = node;
    }

    private static void recursedeletenode(Dbvt pdbvt, Node node) {
        if (!node.isleaf()) {
            Dbvt.recursedeletenode(pdbvt, node.childs[0]);
            Dbvt.recursedeletenode(pdbvt, node.childs[1]);
        }
        if (node == pdbvt.root) {
            pdbvt.root = null;
        }
        Dbvt.deletenode(pdbvt, node);
    }

    private static Node createnode(Dbvt pdbvt, Node parent, DbvtAabbMm volume, Object data2) {
        Node node;
        if (pdbvt.free != null) {
            node = pdbvt.free;
            pdbvt.free = null;
        } else {
            node = new Node();
        }
        node.parent = parent;
        node.volume.set(volume);
        node.data = data2;
        node.childs[1] = null;
        return node;
    }

    private static void insertleaf(Dbvt pdbvt, Node root, Node leaf) {
        if (pdbvt.root == null) {
            pdbvt.root = leaf;
            leaf.parent = null;
        } else {
            if (!root.isleaf()) {
                while (!(root = DbvtAabbMm.Proximity(root.childs[0].volume, leaf.volume) < DbvtAabbMm.Proximity(root.childs[1].volume, leaf.volume) ? root.childs[0] : root.childs[1]).isleaf()) {
                }
            }
            Node prev = root.parent;
            Node node = Dbvt.createnode(pdbvt, prev, Dbvt.merge(leaf.volume, root.volume, new DbvtAabbMm()), null);
            if (prev != null) {
                prev.childs[Dbvt.indexof((Node)root)] = node;
                node.childs[0] = root;
                root.parent = node;
                node.childs[1] = leaf;
                leaf.parent = node;
                while (!prev.volume.Contain(node.volume)) {
                    DbvtAabbMm.Merge(prev.childs[0].volume, prev.childs[1].volume, prev.volume);
                    node = prev;
                    prev = node.parent;
                    if (null != prev) continue;
                    break;
                }
            } else {
                node.childs[0] = root;
                root.parent = node;
                node.childs[1] = leaf;
                leaf.parent = node;
                pdbvt.root = node;
            }
        }
    }

    private static Node removeleaf(Dbvt pdbvt, Node leaf) {
        if (leaf == pdbvt.root) {
            pdbvt.root = null;
            return null;
        }
        Node parent = leaf.parent;
        Node prev = parent.parent;
        Node sibling = parent.childs[1 - Dbvt.indexof(leaf)];
        if (prev != null) {
            prev.childs[Dbvt.indexof((Node)parent)] = sibling;
            sibling.parent = prev;
            Dbvt.deletenode(pdbvt, parent);
            while (prev != null) {
                DbvtAabbMm pb = prev.volume;
                DbvtAabbMm.Merge(prev.childs[0].volume, prev.childs[1].volume, prev.volume);
                if (!DbvtAabbMm.NotEqual(pb, prev.volume)) break;
                prev = prev.parent;
            }
            return prev != null ? prev : pdbvt.root;
        }
        pdbvt.root = sibling;
        sibling.parent = null;
        Dbvt.deletenode(pdbvt, parent);
        return pdbvt.root;
    }

    private static void fetchleaves(Dbvt pdbvt, Node root, ObjectArrayList<Node> leaves) {
        Dbvt.fetchleaves(pdbvt, root, leaves, -1);
    }

    private static void fetchleaves(Dbvt pdbvt, Node root, ObjectArrayList<Node> leaves, int depth) {
        if (root.isinternal() && depth != 0) {
            Dbvt.fetchleaves(pdbvt, root.childs[0], leaves, depth - 1);
            Dbvt.fetchleaves(pdbvt, root.childs[1], leaves, depth - 1);
            Dbvt.deletenode(pdbvt, root);
        } else {
            leaves.add(root);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void split(ObjectArrayList<Node> objectArrayList, ObjectArrayList<Node> objectArrayList2, ObjectArrayList<Node> objectArrayList3, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            ObjectArrayList<Node> leaves;
            void right;
            void left;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            MiscUtil.resize(left, 0, Node.class);
            MiscUtil.resize(right, 0, Node.class);
            int ni = leaves.size();
            for (int i = 0; i < ni; ++i) {
                void axis;
                void org;
                leaves.getQuick((int)i).volume.Center(tmp);
                tmp.sub((Tuple3f)org);
                if (axis.dot(tmp) < 0.0f) {
                    left.add(leaves.getQuick(i));
                    continue;
                }
                right.add(leaves.getQuick(i));
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static DbvtAabbMm bounds(ObjectArrayList<Node> leaves) {
        DbvtAabbMm volume = new DbvtAabbMm(leaves.getQuick((int)0).volume);
        int ni = leaves.size();
        for (int i = 1; i < ni; ++i) {
            Dbvt.merge(volume, leaves.getQuick((int)i).volume, volume);
        }
        return volume;
    }

    private static void bottomup(Dbvt pdbvt, ObjectArrayList<Node> leaves) {
        DbvtAabbMm tmpVolume = new DbvtAabbMm();
        while (leaves.size() > 1) {
            float minsize = Float.MAX_VALUE;
            int[] minidx = new int[]{-1, -1};
            for (int i = 0; i < leaves.size(); ++i) {
                for (int j = i + 1; j < leaves.size(); ++j) {
                    float sz = Dbvt.size(Dbvt.merge(leaves.getQuick((int)i).volume, leaves.getQuick((int)j).volume, tmpVolume));
                    if (!(sz < minsize)) continue;
                    minsize = sz;
                    minidx[0] = i;
                    minidx[1] = j;
                }
            }
            Node[] n = new Node[]{leaves.getQuick(minidx[0]), leaves.getQuick(minidx[1])};
            Node p = Dbvt.createnode(pdbvt, null, Dbvt.merge(n[0].volume, n[1].volume, new DbvtAabbMm()), null);
            p.childs[0] = n[0];
            p.childs[1] = n[1];
            n[0].parent = p;
            n[1].parent = p;
            leaves.setQuick(minidx[0], p);
            Collections.swap(leaves, minidx[1], leaves.size() - 1);
            leaves.removeQuick(leaves.size() - 1);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static Node topdown(Dbvt dbvt, ObjectArrayList<Node> objectArrayList, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void leaves;
            $Stack.push$javax$vecmath$Vector3f();
            if (leaves.size() > 1) {
                Dbvt pdbvt;
                void bu_treshold;
                if (leaves.size() > bu_treshold) {
                    int i;
                    DbvtAabbMm vol = Dbvt.bounds((ObjectArrayList<Node>)leaves);
                    Vector3f org = vol.Center($Stack.get$javax$vecmath$Vector3f());
                    ObjectArrayList[] sets = new ObjectArrayList[2];
                    for (int i2 = 0; i2 < sets.length; ++i2) {
                        sets[i2] = new ObjectArrayList();
                    }
                    int bestaxis = -1;
                    int bestmidp = leaves.size();
                    int[][] splitcount = new int[][]{{0, 0}, {0, 0}, {0, 0}};
                    Vector3f x = $Stack.get$javax$vecmath$Vector3f();
                    for (i = 0; i < leaves.size(); ++i) {
                        ((Node)leaves.getQuick((int)i)).volume.Center(x);
                        x.sub(org);
                        for (int j = 0; j < 3; ++j) {
                            int[] nArray = splitcount[j];
                            int n2 = x.dot(axis[j]) > 0.0f ? 1 : 0;
                            nArray[n2] = nArray[n2] + 1;
                        }
                    }
                    for (i = 0; i < 3; ++i) {
                        int midp;
                        if (splitcount[i][0] <= 0 || splitcount[i][1] <= 0 || (midp = Math.abs(splitcount[i][0] - splitcount[i][1])) >= bestmidp) continue;
                        bestaxis = i;
                        bestmidp = midp;
                    }
                    if (bestaxis >= 0) {
                        Dbvt.split((ObjectArrayList<Node>)leaves, sets[0], sets[1], org, axis[bestaxis]);
                    } else {
                        int ni = leaves.size();
                        for (i = 0; i < ni; ++i) {
                            sets[i & 1].add(leaves.getQuick(i));
                        }
                    }
                    Node node = Dbvt.createnode(pdbvt, null, vol, null);
                    node.childs[0] = Dbvt.topdown(pdbvt, sets[0], (int)bu_treshold);
                    node.childs[1] = Dbvt.topdown(pdbvt, sets[1], (int)bu_treshold);
                    node.childs[0].parent = node;
                    node.childs[1].parent = node;
                    $Stack.pop$javax$vecmath$Vector3f();
                    return node;
                }
                Dbvt.bottomup(pdbvt, (ObjectArrayList<Node>)leaves);
                Node node = (Node)leaves.getQuick(0);
                $Stack.pop$javax$vecmath$Vector3f();
                return node;
            }
            Node node = (Node)leaves.getQuick(0);
            $Stack.pop$javax$vecmath$Vector3f();
            return node;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static Node sort(Node n, Node[] r) {
        Node p = n.parent;
        assert (n.isinternal());
        if (p != null && p.hashCode() > n.hashCode()) {
            int i = Dbvt.indexof(n);
            int j = 1 - i;
            Node s = p.childs[j];
            Node q = p.parent;
            assert (n == p.childs[i]);
            if (q != null) {
                q.childs[Dbvt.indexof((Node)p)] = n;
            } else {
                r[0] = n;
            }
            s.parent = n;
            p.parent = n;
            n.parent = q;
            p.childs[0] = n.childs[0];
            p.childs[1] = n.childs[1];
            n.childs[0].parent = p;
            n.childs[1].parent = p;
            n.childs[i] = p;
            n.childs[j] = s;
            DbvtAabbMm.swap(p.volume, n.volume);
            return p;
        }
        return n;
    }

    private static Node walkup(Node n, int count) {
        while (n != null && count-- != 0) {
            n = n.parent;
        }
        return n;
    }

    public static class IClone {
        public void CloneLeaf(Node n) {
        }
    }

    public static abstract class IWriter {
        public abstract void Prepare(Node var1, int var2);

        public abstract void WriteNode(Node var1, int var2, int var3, int var4, int var5);

        public abstract void WriteLeaf(Node var1, int var2, int var3);
    }

    public static class ICollide {
        public void Process(Node n1, Node n2) {
        }

        public void Process(Node n) {
        }

        public void Process(Node n, float f) {
            this.Process(n);
        }

        public boolean Descent(Node n) {
            return true;
        }

        public boolean AllLeaves(Node n) {
            return true;
        }
    }

    public static class sStkCLN {
        public Node node;
        public Node parent;

        public sStkCLN(Node n, Node p) {
            this.node = n;
            this.parent = p;
        }
    }

    public static class sStkNPS {
        public Node node;
        public int mask;
        public float value;

        public sStkNPS() {
        }

        public sStkNPS(Node n, int m, float v) {
            this.node = n;
            this.mask = m;
            this.value = v;
        }

        public void set(sStkNPS o) {
            this.node = o.node;
            this.mask = o.mask;
            this.value = o.value;
        }
    }

    public static class sStkNP {
        public Node node;
        public int mask;

        public sStkNP(Node n, int m) {
            this.node = n;
            this.mask = m;
        }
    }

    public static class sStkNN {
        public Node a;
        public Node b;

        public sStkNN(Node na, Node nb) {
            this.a = na;
            this.b = nb;
        }
    }

    public static class Node {
        public final DbvtAabbMm volume = new DbvtAabbMm();
        public Node parent;
        public final Node[] childs = new Node[2];
        public Object data;

        public boolean isleaf() {
            return this.childs[1] == null;
        }

        public boolean isinternal() {
            return !this.isleaf();
        }
    }
}

