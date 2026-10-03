/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NodeListIterator
implements Iterator<Node> {
    private Class<?> _klass;
    private boolean _isSiblingList;
    private Node _pointer;
    private NodeList _list;
    private int _pos;
    private Node _next;
    private Node _current;

    public NodeListIterator(NodeList nodeList) {
        this(nodeList, Node.class);
    }

    public NodeListIterator(NodeList nodeList, Class<?> clazz) {
        this._klass = clazz;
        if (nodeList instanceof Node) {
            this._isSiblingList = true;
            this._pointer = ((Node)((Object)nodeList)).getFirstChild();
        } else {
            this._isSiblingList = false;
            this._list = nodeList;
        }
    }

    @Override
    public boolean hasNext() {
        while (this._next == null) {
            if (this._isSiblingList) {
                if (this._pointer == null) {
                    return false;
                }
                this._next = this._pointer;
                this._pointer = this._pointer.getNextSibling();
            } else {
                if (this._pos >= this._list.getLength()) {
                    return false;
                }
                this._next = this._list.item(this._pos++);
            }
            if (this._klass.isInstance(this._next)) continue;
            this._next = null;
        }
        return true;
    }

    @Override
    public Node next() {
        if (this.hasNext()) {
            this._current = this._next;
            this._next = null;
            return this._current;
        }
        throw new NoSuchElementException("invalid index: " + this._pos);
    }

    @Override
    public void remove() {
        if (this._current == null) {
            throw new IllegalStateException("no current node");
        }
        Node node = this._current.getParentNode();
        node.removeChild(this._current);
        --this._pos;
        this._current = null;
    }
}

