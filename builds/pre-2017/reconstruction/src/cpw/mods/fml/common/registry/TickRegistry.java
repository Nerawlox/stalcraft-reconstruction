/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.collect.Queues;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.SingleIntervalHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public class TickRegistry {
    private static PriorityQueue<TickQueueElement> clientTickHandlers = Queues.newPriorityQueue();
    private static PriorityQueue<TickQueueElement> serverTickHandlers = Queues.newPriorityQueue();
    private static AtomicLong clientTickCounter = new AtomicLong();
    private static AtomicLong serverTickCounter = new AtomicLong();

    public static void registerScheduledTickHandler(IScheduledTickHandler iScheduledTickHandler, Side side) {
        TickRegistry.getQueue(side).add(new TickQueueElement(iScheduledTickHandler, TickRegistry.getCounter(side).get()));
    }

    private static PriorityQueue<TickQueueElement> getQueue(Side side) {
        return side.isClient() ? clientTickHandlers : serverTickHandlers;
    }

    private static AtomicLong getCounter(Side side) {
        return side.isClient() ? clientTickCounter : serverTickCounter;
    }

    public static void registerTickHandler(ITickHandler iTickHandler, Side side) {
        TickRegistry.registerScheduledTickHandler(new SingleIntervalHandler(iTickHandler), side);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void updateTickQueue(List<IScheduledTickHandler> list2, Side side) {
        List<IScheduledTickHandler> list3 = list2;
        synchronized (list3) {
            list2.clear();
            long l = TickRegistry.getCounter(side).incrementAndGet();
            PriorityQueue<TickQueueElement> priorityQueue = TickRegistry.getQueue(side);
            while (priorityQueue.size() != 0 && priorityQueue.peek().scheduledNow(l)) {
                TickQueueElement tickQueueElement = priorityQueue.poll();
                tickQueueElement.update(l);
                priorityQueue.offer(tickQueueElement);
                list2.add(tickQueueElement.ticker);
            }
        }
    }

    public static class TickQueueElement
    implements Comparable<TickQueueElement> {
        private long next;
        public IScheduledTickHandler ticker;

        public TickQueueElement(IScheduledTickHandler iScheduledTickHandler, long l) {
            this.ticker = iScheduledTickHandler;
            this.update(l);
        }

        @Override
        public int compareTo(TickQueueElement tickQueueElement) {
            return (int)(this.next - tickQueueElement.next);
        }

        public void update(long l) {
            this.next = l + (long)Math.max(this.ticker.nextTickSpacing(), 1);
        }

        public boolean scheduledNow(long l) {
            return l >= this.next;
        }
    }
}

