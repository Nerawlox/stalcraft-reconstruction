/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.lwjgl.opengl.GL11;

public class TreeScrollList
extends McScrollList<TreeElement> {
    protected Map<TreeElement, TreeNode> el2node = new HashMap<TreeElement, TreeNode>();

    public TreeScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<TreeElement> list2, Point point, Dimension dimension) {
        super(iAdvancedGui, componentButtonStyle, list2, point, dimension);
        list2.forEach(this::node);
    }

    @Override
    protected void drawLine(int n, int n2, Point point) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        TreeElement treeElement = (TreeElement)this.lines.get(n);
        this.renderer.drawButton(this.getLocation().x, n2 + 2, new Dimension(this.getTotalWidth(), this.getStyle().getSize().height), this.getStyle(), this.getState(n, point));
        TreeNode treeNode = this.el2node.get(treeElement);
        int n3 = 5 + 15 * treeNode.level;
        int n4 = n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2;
        String string = treeElement.getString();
        string = !treeNode.element.elements().isEmpty() ? (treeNode.expanded ? "\u2212 " : "+ ") + string : "\u2022 " + string;
        this.renderer.drawString(string, this.getLocation().x + n3, n4, treeElement.getColor());
        if (this.isDrawLineSeparators() && n != this.lines.size() - 1) {
            this.renderer.drawRect(this.getLocation().x, n2 + this.getStyle().getSize().height + 2, this.getSize().width, 1.0, 0x64646464);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void setSelectedLineId(int n) {
        super.setSelectedLineId(n);
        this.onLineSelected();
    }

    public boolean isExpanded(TreeElement treeElement) {
        return this.el2node.get((Object)treeElement).expanded;
    }

    public void expandAll() {
        List<TreeNode> list2 = this.lines.stream().map(this.el2node::get).filter(treeNode -> !treeNode.expanded && !treeNode.isLeaf()).collect(Collectors.toList());
        list2.forEach(this::expand);
        if (!list2.isEmpty()) {
            this.selectedLineId = -1;
        }
    }

    private void onLineSelected() {
        if (this.selectedLineId == -1) {
            return;
        }
        TreeElement treeElement = (TreeElement)this.lines.get(this.selectedLineId);
        if (treeElement == null) {
            return;
        }
        TreeNode treeNode = this.el2node.get(treeElement);
        if (treeNode.expanded) {
            this.wrap(treeNode);
            treeNode.expanded = false;
            this.selectedLineId = -1;
        } else if (!treeNode.element.elements().isEmpty()) {
            this.expand(treeNode);
            this.selectedLineId = -1;
        }
    }

    private void wrap(TreeNode treeNode) {
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>(treeNode.children);
        arrayList.forEach(this::clearNode);
    }

    private void clearNode(TreeNode treeNode) {
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>(treeNode.children);
        arrayList.forEach(this::clearNode);
        for (TreeNode treeNode2 : arrayList) {
            this.clearNode(treeNode2);
        }
        this.lines.remove(treeNode.element);
        this.el2node.remove(treeNode.element);
        treeNode.parent.children.remove(treeNode);
    }

    private void expand(TreeNode treeNode) {
        Collection<? extends TreeElement> collection = treeNode.element.elements();
        Collection collection2 = collection.stream().map(treeElement -> this.node(treeNode, (TreeElement)treeElement)).collect(Collectors.toList());
        treeNode.setChildren(collection2);
        treeNode.expanded = true;
        this.lines.addAll(this.lines.indexOf(treeNode.element) + 1, collection);
    }

    private TreeNode node(TreeNode treeNode, TreeElement treeElement) {
        TreeNode treeNode2 = this.node(treeElement);
        treeNode2.parent = treeNode;
        treeNode2.level = treeNode.level + 1;
        return treeNode2;
    }

    private TreeNode node(TreeElement treeElement2) {
        return this.el2node.computeIfAbsent(treeElement2, treeElement -> new TreeNode(null, (TreeElement)treeElement));
    }

    public static interface TreeElement
    extends vjsq {
        public Collection<? extends TreeElement> elements();

        default public boolean isLeaf() {
            return this.elements().isEmpty();
        }
    }

    protected class TreeNode {
        public TreeNode parent;
        public TreeElement element;
        public Collection<TreeNode> children = new ArrayList<TreeNode>();
        public boolean expanded = false;
        public int level;

        public TreeNode(TreeNode treeNode, TreeElement treeElement) {
            this.parent = treeNode;
            this.element = treeElement;
        }

        public Collection<TreeNode> getChildren() {
            return this.children;
        }

        public void setChildren(Collection<TreeNode> collection) {
            this.children = collection;
        }

        public TreeNode getParent() {
            return this.parent;
        }

        public TreeElement getElement() {
            return this.element;
        }

        public int getLevel() {
            return this.level;
        }

        public void setLevel(int n) {
            this.level = n;
        }

        public boolean isLeaf() {
            return this.element.isLeaf();
        }
    }
}

