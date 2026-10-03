/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractListeningExecutorService
implements ListeningExecutorService {
    @Override
    public ListenableFuture<?> submit(Runnable task) {
        ListenableFutureTask<Object> ftask = ListenableFutureTask.create(task, null);
        this.execute(ftask);
        return ftask;
    }

    @Override
    public <T> ListenableFuture<T> submit(Runnable task, @Nullable T result2) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task, result2);
        this.execute(ftask);
        return ftask;
    }

    @Override
    public <T> ListenableFuture<T> submit(Callable<T> task) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task);
        this.execute(ftask);
        return ftask;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        try {
            return MoreExecutors.invokeAnyImpl(this, tasks, false, 0L);
        }
        catch (TimeoutException cannotHappen) {
            throw new AssertionError();
        }
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return MoreExecutors.invokeAnyImpl(this, tasks, true, unit.toNanos(timeout));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if (tasks == null) {
            throw new NullPointerException();
        }
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try {
            for (Callable<T> callable : tasks) {
                ListenableFutureTask<T> listenableFutureTask = ListenableFutureTask.create(callable);
                futures.add(listenableFutureTask);
                this.execute(listenableFutureTask);
            }
            for (Future future : futures) {
                if (future.isDone()) continue;
                try {
                    future.get();
                }
                catch (CancellationException cancellationException) {
                }
                catch (ExecutionException executionException) {}
            }
            done = true;
            ArrayList<Future<T>> arrayList = futures;
            return arrayList;
        }
        finally {
            if (!done) {
                for (Future future : futures) {
                    future.cancel(true);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        if (tasks == null || unit == null) {
            throw new NullPointerException();
        }
        long nanos = unit.toNanos(timeout);
        ArrayList<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try {
            for (Callable<T> t : tasks) {
                futures.add(ListenableFutureTask.create(t));
            }
            long lastTime = System.nanoTime();
            Iterator it = futures.iterator();
            while (it.hasNext()) {
                this.execute((Runnable)it.next());
                long now = System.nanoTime();
                lastTime = now;
                if ((nanos -= now - lastTime) > 0L) continue;
                ArrayList<Future<T>> arrayList = futures;
                return arrayList;
            }
            for (Future future : futures) {
                if (future.isDone()) continue;
                if (nanos <= 0L) {
                    ArrayList<Future<T>> arrayList = futures;
                    return arrayList;
                }
                try {
                    future.get(nanos, TimeUnit.NANOSECONDS);
                }
                catch (CancellationException ignore) {
                }
                catch (ExecutionException ignore) {
                }
                catch (TimeoutException toe) {
                    ArrayList<Future<T>> arrayList = futures;
                    if (!done) {
                        for (Future future2 : futures) {
                            future2.cancel(true);
                        }
                    }
                    return arrayList;
                }
                long now = System.nanoTime();
                nanos -= now - lastTime;
                lastTime = now;
            }
            done = true;
            ArrayList<Future<T>> arrayList = futures;
            return arrayList;
        }
        finally {
            if (!done) {
                for (Future future : futures) {
                    future.cancel(true);
                }
            }
        }
    }
}

