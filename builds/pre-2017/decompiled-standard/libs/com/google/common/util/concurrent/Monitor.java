/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@Beta
public final class Monitor {
    private final boolean fair;
    private final ReentrantLock lock;
    @GuardedBy(value="lock")
    private final ArrayList<Guard> activeGuards = Lists.newArrayListWithCapacity(1);

    public Monitor() {
        this(false);
    }

    public Monitor(boolean fair) {
        this.fair = fair;
        this.lock = new ReentrantLock(fair);
    }

    public void enter() {
        this.lock.lock();
    }

    public void enterInterruptibly() throws InterruptedException {
        this.lock.lockInterruptibly();
    }

    public boolean enter(long time, TimeUnit unit) {
        long timeoutNanos;
        ReentrantLock lock = this.lock;
        if (!this.fair && lock.tryLock()) {
            return true;
        }
        long startNanos = System.nanoTime();
        long remainingNanos = timeoutNanos = unit.toNanos(time);
        boolean interruptIgnored = false;
        while (true) {
            try {
                boolean bl = lock.tryLock(remainingNanos, TimeUnit.NANOSECONDS);
                return bl;
            }
            catch (InterruptedException ignored) {
                interruptIgnored = true;
                remainingNanos = timeoutNanos - (System.nanoTime() - startNanos);
                continue;
            }
            break;
        }
        finally {
            if (interruptIgnored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean enterInterruptibly(long time, TimeUnit unit) throws InterruptedException {
        return this.lock.tryLock(time, unit);
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enterWhen(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean reentrant = lock.isHeldByCurrentThread();
        boolean success = false;
        lock.lockInterruptibly();
        try {
            this.waitInterruptibly(guard, reentrant);
            success = true;
        }
        finally {
            if (!success) {
                lock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enterWhenUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean reentrant = lock.isHeldByCurrentThread();
        boolean success = false;
        lock.lock();
        try {
            this.waitUninterruptibly(guard, reentrant);
            success = true;
        }
        finally {
            if (!success) {
                lock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterWhen(Guard guard, long time, TimeUnit unit) throws InterruptedException {
        long remainingNanos;
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean reentrant = lock.isHeldByCurrentThread();
        if (!this.fair && lock.tryLock()) {
            remainingNanos = unit.toNanos(time);
        } else {
            long startNanos = System.nanoTime();
            if (!lock.tryLock(time, unit)) {
                return false;
            }
            remainingNanos = unit.toNanos(time) - (System.nanoTime() - startNanos);
        }
        boolean satisfied = false;
        try {
            satisfied = this.waitInterruptibly(guard, remainingNanos, reentrant);
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterWhenUninterruptibly(Guard guard, long time, TimeUnit unit) {
        long remainingNanos;
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        boolean reentrant = lock.isHeldByCurrentThread();
        boolean interruptIgnored = false;
        if (!this.fair && lock.tryLock()) {
            remainingNanos = unit.toNanos(time);
        } else {
            long timeoutNanos;
            long startNanos = System.nanoTime();
            remainingNanos = timeoutNanos = unit.toNanos(time);
            while (true) {
                try {
                    if (lock.tryLock(remainingNanos, TimeUnit.NANOSECONDS)) break;
                    boolean bl = false;
                    return bl;
                }
                catch (InterruptedException ignored) {
                    interruptIgnored = true;
                    continue;
                }
                finally {
                    remainingNanos = timeoutNanos - (System.nanoTime() - startNanos);
                    continue;
                }
                break;
            }
        }
        boolean satisfied = false;
        try {
            satisfied = this.waitUninterruptibly(guard, remainingNanos, reentrant);
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        boolean bl = satisfied;
        return bl;
        finally {
            if (interruptIgnored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        boolean satisfied = false;
        try {
            satisfied = guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIfInterruptibly(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        boolean satisfied = false;
        try {
            satisfied = guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIf(Guard guard, long time, TimeUnit unit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        if (!this.enter(time, unit)) {
            return false;
        }
        boolean satisfied = false;
        try {
            satisfied = guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enterIfInterruptibly(Guard guard, long time, TimeUnit unit) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        if (!lock.tryLock(time, unit)) {
            return false;
        }
        boolean satisfied = false;
        try {
            satisfied = guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean tryEnterIf(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock lock = this.lock;
        if (!lock.tryLock()) {
            return false;
        }
        boolean satisfied = false;
        try {
            satisfied = guard.isSatisfied();
        }
        finally {
            if (!satisfied) {
                lock.unlock();
            }
        }
        return satisfied;
    }

    public void waitFor(Guard guard) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        this.waitInterruptibly(guard, true);
    }

    public void waitForUninterruptibly(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        this.waitUninterruptibly(guard, true);
    }

    public boolean waitFor(Guard guard, long time, TimeUnit unit) throws InterruptedException {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.waitInterruptibly(guard, unit.toNanos(time), true);
    }

    public boolean waitForUninterruptibly(Guard guard, long time, TimeUnit unit) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.waitUninterruptibly(guard, unit.toNanos(time), true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void leave() {
        ReentrantLock lock = this.lock;
        if (!lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        try {
            this.signalConditionsOfSatisfiedGuards(null);
        }
        finally {
            lock.unlock();
        }
    }

    public boolean isFair() {
        return this.lock.isFair();
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasQueuedThread(Thread thread2) {
        return this.lock.hasQueuedThread(thread2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasWaiters(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            boolean bl = guard.waiterCount > 0;
            return bl;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getWaitQueueLength(Guard guard) {
        if (guard.monitor != this) {
            throw new IllegalMonitorStateException();
        }
        this.lock.lock();
        try {
            int n = guard.waiterCount;
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    @GuardedBy(value="lock")
    private void signalConditionsOfSatisfiedGuards(@Nullable Guard interruptedGuard) {
        ArrayList<Guard> guards = this.activeGuards;
        int guardCount = guards.size();
        try {
            for (int i = 0; i < guardCount; ++i) {
                Guard guard = guards.get(i);
                if (guard == interruptedGuard && guard.waiterCount == 1 || !guard.isSatisfied()) continue;
                guard.condition.signal();
                return;
            }
        }
        catch (Throwable throwable) {
            for (int i = 0; i < guardCount; ++i) {
                Guard guard = guards.get(i);
                guard.condition.signalAll();
            }
            throw Throwables.propagate(throwable);
        }
    }

    @GuardedBy(value="lock")
    private void incrementWaiters(Guard guard) {
        int waiters;
        if ((waiters = guard.waiterCount++) == 0) {
            this.activeGuards.add(guard);
        }
    }

    @GuardedBy(value="lock")
    private void decrementWaiters(Guard guard) {
        int waiters;
        if ((waiters = --guard.waiterCount) == 0) {
            this.activeGuards.remove(guard);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GuardedBy(value="lock")
    private void waitInterruptibly(Guard guard, boolean signalBeforeWaiting) throws InterruptedException {
        if (!guard.isSatisfied()) {
            if (signalBeforeWaiting) {
                this.signalConditionsOfSatisfiedGuards(null);
            }
            this.incrementWaiters(guard);
            try {
                Condition condition = guard.condition;
                do {
                    try {
                        condition.await();
                    }
                    catch (InterruptedException interrupt) {
                        try {
                            this.signalConditionsOfSatisfiedGuards(guard);
                        }
                        catch (Throwable throwable) {
                            Thread.currentThread().interrupt();
                            throw Throwables.propagate(throwable);
                        }
                        throw interrupt;
                    }
                } while (!guard.isSatisfied());
            }
            finally {
                this.decrementWaiters(guard);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GuardedBy(value="lock")
    private void waitUninterruptibly(Guard guard, boolean signalBeforeWaiting) {
        if (!guard.isSatisfied()) {
            if (signalBeforeWaiting) {
                this.signalConditionsOfSatisfiedGuards(null);
            }
            this.incrementWaiters(guard);
            try {
                Condition condition = guard.condition;
                do {
                    condition.awaitUninterruptibly();
                } while (!guard.isSatisfied());
            }
            finally {
                this.decrementWaiters(guard);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GuardedBy(value="lock")
    private boolean waitInterruptibly(Guard guard, long remainingNanos, boolean signalBeforeWaiting) throws InterruptedException {
        if (!guard.isSatisfied()) {
            if (signalBeforeWaiting) {
                this.signalConditionsOfSatisfiedGuards(null);
            }
            this.incrementWaiters(guard);
            try {
                Condition condition = guard.condition;
                do {
                    if (remainingNanos <= 0L) {
                        boolean bl = false;
                        return bl;
                    }
                    try {
                        remainingNanos = condition.awaitNanos(remainingNanos);
                    }
                    catch (InterruptedException interrupt) {
                        try {
                            this.signalConditionsOfSatisfiedGuards(guard);
                        }
                        catch (Throwable throwable) {
                            Thread.currentThread().interrupt();
                            throw Throwables.propagate(throwable);
                        }
                        throw interrupt;
                    }
                } while (!guard.isSatisfied());
            }
            finally {
                this.decrementWaiters(guard);
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GuardedBy(value="lock")
    private boolean waitUninterruptibly(Guard guard, long timeoutNanos, boolean signalBeforeWaiting) {
        if (!guard.isSatisfied()) {
            long startNanos = System.nanoTime();
            if (signalBeforeWaiting) {
                this.signalConditionsOfSatisfiedGuards(null);
            }
            boolean interruptIgnored = false;
            try {
                this.incrementWaiters(guard);
                try {
                    Condition condition = guard.condition;
                    long remainingNanos = timeoutNanos;
                    do {
                        if (remainingNanos <= 0L) {
                            boolean bl = false;
                            return bl;
                        }
                        try {
                            remainingNanos = condition.awaitNanos(remainingNanos);
                        }
                        catch (InterruptedException ignored) {
                            try {
                                this.signalConditionsOfSatisfiedGuards(guard);
                            }
                            catch (Throwable throwable) {
                                Thread.currentThread().interrupt();
                                throw Throwables.propagate(throwable);
                            }
                            interruptIgnored = true;
                            remainingNanos = timeoutNanos - (System.nanoTime() - startNanos);
                        }
                    } while (!guard.isSatisfied());
                }
                finally {
                    this.decrementWaiters(guard);
                }
            }
            finally {
                if (interruptIgnored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    @Beta
    public static abstract class Guard {
        final Monitor monitor;
        final Condition condition;
        @GuardedBy(value="monitor.lock")
        int waiterCount = 0;

        protected Guard(Monitor monitor) {
            this.monitor = Preconditions.checkNotNull(monitor, "monitor");
            this.condition = monitor.lock.newCondition();
        }

        public abstract boolean isSatisfied();

        public final boolean equals(Object other) {
            return this == other;
        }

        public final int hashCode() {
            return super.hashCode();
        }
    }
}

