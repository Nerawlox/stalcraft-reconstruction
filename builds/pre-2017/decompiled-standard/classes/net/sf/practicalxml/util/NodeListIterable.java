/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.util;

import java.util.Iterator;
import net.sf.practicalxml.util.NodeListIterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NodeListIterable
implements Iterable<Node> {
    private NodeList _list;

    public NodeListIterable(NodeList nodeList) {
        this._list = nodeList;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeListIterator(this._list);
    }
}

