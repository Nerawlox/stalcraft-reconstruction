/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import java.util.ArrayList;
import java.util.Collection;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.IEventListener;

public class ListenerList {
    private static ArrayList<ListenerList> allLists = new ArrayList();
    private static int maxSize = 0;
    private ListenerList parent;
    private ListenerListInst[] lists = new ListenerListInst[0];

    public ListenerList() {
        allLists.add(this);
        this.resizeLists(maxSize);
    }

    public ListenerList(ListenerList listenerList) {
        allLists.add(this);
        this.parent = listenerList;
        this.resizeLists(maxSize);
    }

    public static void resize(int n) {
        if (n <= maxSize) {
            return;
        }
        for (ListenerList listenerList : allLists) {
            listenerList.resizeLists(n);
        }
        maxSize = n;
    }

    public void resizeLists(int n) {
        int n2;
        if (this.parent != null) {
            this.parent.resizeLists(n);
        }
        if (this.lists.length >= n) {
            return;
        }
        ListenerListInst[] listenerListInstArray = new ListenerListInst[n];
        for (n2 = 0; n2 < this.lists.length; ++n2) {
            listenerListInstArray[n2] = this.lists[n2];
        }
        while (n2 < n) {
            listenerListInstArray[n2] = this.parent != null ? new ListenerListInst(this.parent.getInstance(n2)) : new ListenerListInst();
            ++n2;
        }
        this.lists = listenerListInstArray;
    }

    public static void clearBusID(int n) {
        for (ListenerList listenerList : allLists) {
            listenerList.lists[n].dispose();
        }
    }

    protected ListenerListInst getInstance(int n) {
        return this.lists[n];
    }

    public IEventListener[] getListeners(int n) {
        return this.lists[n].getListeners();
    }

    public void register(int n, EventPriority eventPriority, IEventListener iEventListener) {
        this.lists[n].register(eventPriority, iEventListener);
    }

    public void unregister(int n, IEventListener iEventListener) {
        this.lists[n].unregister(iEventListener);
    }

    public static void unregiterAll(int n, IEventListener iEventListener) {
        for (ListenerList listenerList : allLists) {
            listenerList.unregister(n, iEventListener);
        }
    }

    private class ListenerListInst {
        private boolean rebuild = true;
        private IEventListener[] listeners;
        private ArrayList<ArrayList<IEventListener>> priorities;
        private ListenerListInst parent;

        private ListenerListInst() {
            int n = EventPriority.values().length;
            this.priorities = new ArrayList(n);
            for (int i = 0; i < n; ++i) {
                this.priorities.add(new ArrayList());
            }
        }

        public void dispose() {
            for (ArrayList<IEventListener> arrayList : this.priorities) {
                arrayList.clear();
            }
            this.priorities.clear();
            this.parent = null;
            this.listeners = null;
        }

        private ListenerListInst(ListenerListInst listenerListInst) {
            this();
            this.parent = listenerListInst;
        }

        public ArrayList<IEventListener> getListeners(EventPriority eventPriority) {
            ArrayList<IEventListener> arrayList = new ArrayList<IEventListener>((Collection)this.priorities.get(eventPriority.ordinal()));
            if (this.parent != null) {
                arrayList.addAll(this.parent.getListeners(eventPriority));
            }
            return arrayList;
        }

        public IEventListener[] getListeners() {
            if (this.shouldRebuild()) {
                this.buildCache();
            }
            return this.listeners;
        }

        protected boolean shouldRebuild() {
            return this.rebuild || this.parent != null && this.parent.shouldRebuild();
        }

        private void buildCache() {
            if (this.parent != null && this.parent.shouldRebuild()) {
                this.parent.buildCache();
            }
            ArrayList<IEventListener> arrayList = new ArrayList<IEventListener>();
            for (EventPriority eventPriority : EventPriority.values()) {
                arrayList.addAll(this.getListeners(eventPriority));
            }
            this.listeners = arrayList.toArray(new IEventListener[arrayList.size()]);
            this.rebuild = false;
        }

        public void register(EventPriority eventPriority, IEventListener iEventListener) {
            this.priorities.get(eventPriority.ordinal()).add(iEventListener);
            this.rebuild = true;
        }

        public void unregister(IEventListener iEventListener) {
            for (ArrayList<IEventListener> arrayList : this.priorities) {
                if (!arrayList.remove(iEventListener)) continue;
                this.rebuild = true;
            }
        }
    }
}

