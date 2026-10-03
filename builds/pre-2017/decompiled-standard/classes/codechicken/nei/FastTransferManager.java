/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class FastTransferManager {
    public LinkedList<LinkedList<Integer>> slotZones = new LinkedList();
    public HashMap<Integer, Integer> slotZoneMap = new HashMap();

    private void generateSlotMap(jjgc jjgc2, cvzo cvzo2) {
        cvzo2 = cvzo2._l();
        cvzo2._b = 1;
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            if (this.slotZoneMap.containsKey(i) || !jjgc2.func_75139_a(i).func_75214_a(cvzo2)) continue;
            HashSet<Integer> hashSet = new HashSet<Integer>();
            this.findConnectedSlots(jjgc2, i, hashSet);
            LinkedList<Integer> linkedList = new LinkedList<Integer>(hashSet);
            Collections.sort(linkedList, new SlotPositionComparator(jjgc2));
            this.slotZones.add(linkedList);
            Iterator iterator2 = linkedList.iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                this.slotZoneMap.put(n, this.slotZones.size() - 1);
            }
        }
    }

    private void findConnectedSlots(jjgc jjgc2, int n, HashSet<Integer> hashSet) {
        hashSet.add(n);
        yeso yeso2 = jjgc2.func_75139_a(n);
        int n2 = 18;
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            if (hashSet.contains(i)) continue;
            yeso yeso3 = jjgc2.func_75139_a(i);
            if (Math.abs(yeso2.field_75223_e - yeso3.field_75223_e) > 18 || Math.abs(yeso2.field_75221_f - yeso3.field_75221_f) > 18) continue;
            this.findConnectedSlots(jjgc2, i, hashSet);
        }
    }

    public static int findSlotWithItem(jjgc jjgc2, cvzo cvzo2) {
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            cvzo cvzo3 = jjgc2.func_75139_a(i).func_75211_c();
            if (cvzo3 == null || !NEIServerUtils.areStacksSameType(cvzo3, cvzo2)) continue;
            return i;
        }
        return -1;
    }

    public static void clearSlots(jjgc jjgc2) {
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            ((yeso)jjgc2.field_75151_b.get(i)).func_75215_d(null);
        }
    }

    public void performMassTransfer(zybc zybc2, int n, int n2, cvzo cvzo2) {
        this.generateSlotMap(zybc2.field_74193_d, cvzo2);
        Integer n3 = this.slotZoneMap.get(n);
        Integer n4 = this.slotZoneMap.get(n2);
        if (n3 == null || n4 == null || n3 == n4) {
            return;
        }
        if (NEIClientUtils.getHeldItem() != null && !NEIServerUtils.areStacksSameType(cvzo2, NEIClientUtils.getHeldItem())) {
            return;
        }
        if (!this.fillZoneWithHeldItem(zybc2, n4)) {
            return;
        }
        Iterator iterator2 = this.slotZones.get(n3).iterator();
        while (iterator2.hasNext()) {
            int n5 = (Integer)iterator2.next();
            cvzo cvzo3 = zybc2.field_74193_d.func_75139_a(n5).func_75211_c();
            if (!NEIServerUtils.areStacksSameType(cvzo2, cvzo3)) continue;
            FastTransferManager.clickSlot(zybc2, n5);
            if (this.fillZoneWithHeldItem(zybc2, n4)) continue;
            FastTransferManager.clickSlot(zybc2, n5);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int findShiftClickDestinationSlot(jjgc jjgc2, int n) {
        LinkedList<cvzo> linkedList = this.saveContainer(jjgc2);
        yeso yeso2 = jjgc2.func_75139_a(n);
        cvzo cvzo2 = yeso2.func_75211_c();
        if (cvzo2 == null) {
            return -1;
        }
        cvzo2._b = 1;
        yeso2.func_75215_d(cvzo2._l());
        LinkedList<cvzo> linkedList2 = this.saveContainer(jjgc2);
        jjgc2.func_75144_a(n, 0, 1, NEIClientUtils.mc()._t);
        LinkedList<cvzo> linkedList3 = this.saveContainer(jjgc2);
        try {
            int n2;
            for (n2 = 0; n2 < linkedList2.size(); ++n2) {
                cvzo cvzo3;
                cvzo cvzo4;
                if (n2 == n || NEIServerUtils.areStacksIdentical(cvzo4 = linkedList2.get(n2), cvzo3 = linkedList3.get(n2)) || cvzo3 == null || (cvzo4 != null || !NEIServerUtils.areStacksSameType(cvzo2, cvzo3)) && (!NEIServerUtils.areStacksSameType(cvzo2, cvzo3) || cvzo3._b - cvzo4._b <= 0)) continue;
                int n3 = n2;
                return n3;
            }
            n2 = -1;
            return n2;
        }
        finally {
            this.restoreContainer(jjgc2, linkedList);
        }
    }

    public LinkedList<cvzo> saveContainer(jjgc jjgc2) {
        LinkedList<cvzo> linkedList = new LinkedList<cvzo>();
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            linkedList.add(NEIServerUtils.copyStack(jjgc2.func_75139_a(i).func_75211_c()));
        }
        return linkedList;
    }

    public void restoreContainer(jjgc jjgc2, LinkedList<cvzo> linkedList) {
        for (int i = 0; i < jjgc2.field_75151_b.size(); ++i) {
            jjgc2.func_75139_a(i).func_75215_d(linkedList.get(i));
        }
        jjgc2.func_75144_a(-999, 0, 0, NEIClientUtils.mc()._t);
    }

    public void transferItem(zybc zybc2, int n) {
        int n2 = this.findShiftClickDestinationSlot(zybc2.field_74193_d, n);
        if (n2 == -1) {
            return;
        }
        yeso yeso2 = zybc2.field_74193_d.func_75139_a(n);
        if (yeso2.func_75214_a(yeso2.func_75211_c())) {
            this.moveOneItem(zybc2, n, n2);
        } else {
            this.moveOutputSet(zybc2, n, n2);
        }
    }

    public void moveOutputSet(zybc zybc2, int n, int n2) {
        if (NEIClientUtils.getHeldItem() != null) {
            return;
        }
        FastTransferManager.clickSlot(zybc2, n);
        if (NEIClientUtils.getHeldItem() == null) {
            return;
        }
        FastTransferManager.clickSlot(zybc2, n2);
    }

    public void moveOneItem(zybc zybc2, int n, int n2) {
        FastTransferManager.clickSlot(zybc2, n);
        FastTransferManager.clickSlot(zybc2, n2, 1);
        FastTransferManager.clickSlot(zybc2, n);
    }

    public void retrieveItem(zybc zybc2, int n) {
        Integer n2;
        yeso yeso2 = zybc2.field_74193_d.func_75139_a(n);
        cvzo cvzo2 = yeso2.func_75211_c();
        if (cvzo2 == null || cvzo2._b == yeso2.func_75219_a() || cvzo2._b == cvzo2._d()) {
            return;
        }
        this.generateSlotMap(zybc2.field_74193_d, cvzo2);
        Integer n3 = this.slotZoneMap.get(n);
        if (n3 == null) {
            return;
        }
        int n4 = this.findShiftClickDestinationSlot(zybc2.field_74193_d, n);
        int n5 = -1;
        if (n4 != -1 && (n2 = this.slotZoneMap.get(n4)) != null && this.retrieveItemFromZone(zybc2, n5 = n2.intValue(), n)) {
            return;
        }
        for (int i = 0; i < this.slotZones.size(); ++i) {
            if (i == n3 || i == n5 || !this.retrieveItemFromZone(zybc2, i, n)) continue;
            return;
        }
        this.retrieveItemFromZone(zybc2, n3, n);
    }

    private boolean retrieveItemFromZone(zybc zybc2, int n, int n2) {
        yeso yeso2;
        cvzo cvzo2;
        int n3;
        cvzo cvzo3 = zybc2.field_74193_d.func_75139_a(n2).func_75211_c();
        Iterator iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n3 = (Integer)iterator2.next();
            if (n3 == n2 || !NEIServerUtils.areStacksSameType(cvzo3, cvzo2 = (yeso2 = zybc2.field_74193_d.func_75139_a(n3)).func_75211_c()) || cvzo2._b == yeso2.func_75219_a() || cvzo2._b == cvzo2._d()) continue;
            this.moveOneItem(zybc2, n3, n2);
            return true;
        }
        iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n3 = (Integer)iterator2.next();
            if (n3 == n2 || !NEIServerUtils.areStacksSameType(cvzo3, cvzo2 = (yeso2 = zybc2.field_74193_d.func_75139_a(n3)).func_75211_c())) continue;
            this.moveOneItem(zybc2, n3, n2);
            return true;
        }
        return false;
    }

    public static void clickSlot(zybc zybc2, int n) {
        FastTransferManager.clickSlot(zybc2, n, 0);
    }

    public static void clickSlot(zybc zybc2, int n, int n2) {
        FastTransferManager.clickSlot(zybc2, n, n2, 0);
    }

    public static void clickSlot(zybc zybc2, int n, int n2, int n3) {
        jjgc jjgc2 = zybc2.field_74193_d;
        yeso yeso2 = null;
        if (n >= 0 && n < jjgc2.field_75151_b.size()) {
            yeso2 = jjgc2.func_75139_a(n);
        }
        zybc2.sendMouseClick(yeso2, n, n2, n3);
    }

    private boolean fillZoneWithHeldItem(zybc zybc2, int n) {
        cvzo cvzo2;
        cvzo cvzo3;
        int n2;
        Iterator iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            cvzo3 = NEIClientUtils.getHeldItem();
            if (cvzo3 == null) break;
            cvzo2 = zybc2.field_74193_d.func_75139_a(n2).func_75211_c();
            if (!NEIServerUtils.areStacksSameType(cvzo2, cvzo3)) continue;
            FastTransferManager.clickSlot(zybc2, n2);
        }
        iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            cvzo3 = NEIClientUtils.getHeldItem();
            if (cvzo3 == null) break;
            cvzo2 = zybc2.field_74193_d.func_75139_a(n2).func_75211_c();
            if (cvzo2 != null) continue;
            FastTransferManager.clickSlot(zybc2, n2);
        }
        return NEIClientUtils.getHeldItem() == null;
    }

    public void throwAll(zybc zybc2, int n) {
        cvzo cvzo2 = NEIClientUtils.getHeldItem();
        if (cvzo2 == null) {
            return;
        }
        FastTransferManager.clickSlot(zybc2, -999);
        this.generateSlotMap(zybc2.field_74193_d, cvzo2);
        Iterator iterator2 = this.slotZones.get(this.slotZoneMap.get(n)).iterator();
        while (iterator2.hasNext()) {
            int n2 = (Integer)iterator2.next();
            yeso yeso2 = zybc2.field_74193_d.func_75139_a(n2);
            if (!NEIServerUtils.areStacksSameType(cvzo2, yeso2.func_75211_c())) continue;
            FastTransferManager.clickSlot(zybc2, n2);
            FastTransferManager.clickSlot(zybc2, -999);
        }
    }

    public static class SlotPositionComparator
    implements Comparator<Integer> {
        jjgc container;

        public SlotPositionComparator(jjgc jjgc2) {
            this.container = jjgc2;
        }

        @Override
        public int compare(Integer n, Integer n2) {
            yeso yeso2 = this.container.func_75139_a(n);
            yeso yeso3 = this.container.func_75139_a(n2);
            if (yeso3.field_75221_f != yeso2.field_75221_f) {
                return yeso2.field_75221_f - yeso3.field_75221_f;
            }
            return yeso2.field_75223_e - yeso3.field_75223_e;
        }
    }
}

