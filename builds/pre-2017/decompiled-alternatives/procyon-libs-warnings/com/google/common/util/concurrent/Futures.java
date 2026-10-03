// 
// Decompiled by Procyon v0.6.0
// 

package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.base.Optional;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Arrays;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import com.google.common.collect.Ordering;

public final class Futures
{
    private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER;
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST;
    
    private Futures() {
    }
    
    @Beta
    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(final ListenableFuture<V> future, final Function<Exception, X> mapper) {
        return (CheckedFuture<V, X>)new MappingCheckedFuture((com.google.common.util.concurrent.ListenableFuture<Object>)Preconditions.checkNotNull((Object)future), (com.google.common.base.Function<Exception, Exception>)mapper);
    }
    
    public static <V> ListenableFuture<V> immediateFuture(@Nullable final V value) {
        return (ListenableFuture<V>)new ImmediateSuccessfulFuture(value);
    }
    
    @Beta
    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable final V value) {
        return (CheckedFuture<V, X>)new ImmediateSuccessfulCheckedFuture(value);
    }
    
    public static <V> ListenableFuture<V> immediateFailedFuture(final Throwable throwable) {
        Preconditions.checkNotNull((Object)throwable);
        return (ListenableFuture<V>)new ImmediateFailedFuture(throwable);
    }
    
    @Beta
    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return (ListenableFuture<V>)new ImmediateCancelledFuture();
    }
    
    @Beta
    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(final X exception) {
        Preconditions.checkNotNull((Object)exception);
        return (CheckedFuture<V, X>)new ImmediateFailedCheckedFuture(exception);
    }
    
    @Beta
    public static <V> ListenableFuture<V> withFallback(final ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback) {
        return withFallback(input, fallback, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<V> withFallback(final ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback, final Executor executor) {
        Preconditions.checkNotNull((Object)fallback);
        return (ListenableFuture<V>)new FallbackFuture(input, fallback, executor);
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> input, final AsyncFunction<? super I, ? extends O> function) {
        return transform(input, function, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> input, final AsyncFunction<? super I, ? extends O> function, final Executor executor) {
        final ChainingListenableFuture<I, O> output = new ChainingListenableFuture<I, O>((AsyncFunction)function, (ListenableFuture)input);
        input.addListener((Runnable)output, executor);
        return (ListenableFuture<O>)output;
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> input, final Function<? super I, ? extends O> function) {
        return transform(input, function, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    public static <I, O> ListenableFuture<O> transform(final ListenableFuture<I> input, final Function<? super I, ? extends O> function, final Executor executor) {
        Preconditions.checkNotNull((Object)function);
        final AsyncFunction<I, O> wrapperFunction = (AsyncFunction<I, O>)new AsyncFunction<I, O>() {
            public ListenableFuture<O> apply(final I input) {
                final O output = (O)function.apply((Object)input);
                return Futures.immediateFuture(output);
            }
        };
        return transform(input, (com.google.common.util.concurrent.AsyncFunction<? super I, ? extends O>)wrapperFunction, executor);
    }
    
    @Beta
    public static <I, O> Future<O> lazyTransform(final Future<I> input, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull((Object)input);
        Preconditions.checkNotNull((Object)function);
        return new Future<O>() {
            @Override
            public boolean cancel(final boolean mayInterruptIfRunning) {
                return input.cancel(mayInterruptIfRunning);
            }
            
            @Override
            public boolean isCancelled() {
                return input.isCancelled();
            }
            
            @Override
            public boolean isDone() {
                return input.isDone();
            }
            
            @Override
            public O get() throws InterruptedException, ExecutionException {
                return this.applyTransformation(input.get());
            }
            
            @Override
            public O get(final long timeout, final TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return this.applyTransformation(input.get(timeout, unit));
            }
            
            private O applyTransformation(final I input) throws ExecutionException {
                try {
                    return (O)function.apply((Object)input);
                }
                catch (final Throwable t) {
                    throw new ExecutionException(t);
                }
            }
        };
    }
    
    @Beta
    public static <V> ListenableFuture<V> dereference(final ListenableFuture<? extends ListenableFuture<? extends V>> nested) {
        return transform(nested, (com.google.common.util.concurrent.AsyncFunction<? super ListenableFuture<? extends V>, ? extends V>)Futures.DEREFERENCER);
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(final ListenableFuture<? extends V>... futures) {
        return listFuture((com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>>)ImmutableList.copyOf((Object[])futures), true, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(final Iterable<? extends ListenableFuture<? extends V>> futures) {
        return listFuture((com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>>)ImmutableList.copyOf((Iterable)futures), true, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(final ListenableFuture<? extends V>... futures) {
        return listFuture((com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>>)ImmutableList.copyOf((Object[])futures), false, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(final Iterable<? extends ListenableFuture<? extends V>> futures) {
        return listFuture((com.google.common.collect.ImmutableList<com.google.common.util.concurrent.ListenableFuture<? extends V>>)ImmutableList.copyOf((Iterable)futures), false, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    public static <V> void addCallback(final ListenableFuture<V> future, final FutureCallback<? super V> callback) {
        addCallback(future, callback, (Executor)MoreExecutors.sameThreadExecutor());
    }
    
    public static <V> void addCallback(final ListenableFuture<V> future, final FutureCallback<? super V> callback, final Executor executor) {
        Preconditions.checkNotNull((Object)callback);
        final Runnable callbackListener = new Runnable() {
            @Override
            public void run() {
                V value;
                try {
                    value = (V)Uninterruptibles.getUninterruptibly((Future)future);
                }
                catch (final ExecutionException e) {
                    callback.onFailure(e.getCause());
                    return;
                }
                catch (final RuntimeException e2) {
                    callback.onFailure((Throwable)e2);
                    return;
                }
                catch (final Error e3) {
                    callback.onFailure((Throwable)e3);
                    return;
                }
                callback.onSuccess((Object)value);
            }
        };
        future.addListener(callbackListener, executor);
    }
    
    @Beta
    public static <V, X extends Exception> V get(final Future<V> future, final Class<X> exceptionClass) throws X, Exception {
        Preconditions.checkNotNull((Object)future);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(exceptionClass), "Futures.get exception type (%s) must not be a RuntimeException", new Object[] { exceptionClass });
        try {
            return future.get();
        }
        catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        }
        catch (final ExecutionException e2) {
            wrapAndThrowExceptionOrError(e2.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }
    
    @Beta
    public static <V, X extends Exception> V get(final Future<V> future, final long timeout, final TimeUnit unit, final Class<X> exceptionClass) throws X, Exception {
        Preconditions.checkNotNull((Object)future);
        Preconditions.checkNotNull((Object)unit);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(exceptionClass), "Futures.get exception type (%s) must not be a RuntimeException", new Object[] { exceptionClass });
        try {
            return future.get(timeout, unit);
        }
        catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        }
        catch (final TimeoutException e2) {
            throw newWithCause(exceptionClass, e2);
        }
        catch (final ExecutionException e3) {
            wrapAndThrowExceptionOrError(e3.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }
    
    private static <X extends Exception> void wrapAndThrowExceptionOrError(final Throwable cause, final Class<X> exceptionClass) throws X, Exception {
        if (cause instanceof Error) {
            throw new ExecutionError((Error)cause);
        }
        if (cause instanceof RuntimeException) {
            throw new UncheckedExecutionException(cause);
        }
        throw newWithCause(exceptionClass, cause);
    }
    
    @Beta
    public static <V> V getUnchecked(final Future<V> future) {
        Preconditions.checkNotNull((Object)future);
        try {
            return (V)Uninterruptibles.getUninterruptibly((Future)future);
        }
        catch (final ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }
    
    private static void wrapAndThrowUnchecked(final Throwable cause) {
        if (cause instanceof Error) {
            throw new ExecutionError((Error)cause);
        }
        throw new UncheckedExecutionException(cause);
    }
    
    private static <X extends Exception> X newWithCause(final Class<X> exceptionClass, final Throwable cause) {
        final List<Constructor<X>> constructors = Arrays.asList((Constructor<X>[])exceptionClass.getConstructors());
        for (final Constructor<X> constructor : preferringStrings(constructors)) {
            final X instance = newFromConstructor(constructor, cause);
            if (instance != null) {
                if (instance.getCause() == null) {
                    instance.initCause(cause);
                }
                return instance;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + exceptionClass + " in response to chained exception", cause);
    }
    
    private static <X extends Exception> List<Constructor<X>> preferringStrings(final List<Constructor<X>> constructors) {
        return Futures.WITH_STRING_PARAM_FIRST.sortedCopy((Iterable)constructors);
    }
    
    @Nullable
    private static <X> X newFromConstructor(final Constructor<X> constructor, final Throwable cause) {
        final Class<?>[] paramTypes = constructor.getParameterTypes();
        final Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; ++i) {
            final Class<?> paramType = paramTypes[i];
            if (paramType.equals(String.class)) {
                params[i] = cause.toString();
            }
            else {
                if (!paramType.equals(Throwable.class)) {
                    return null;
                }
                params[i] = cause;
            }
        }
        try {
            return constructor.newInstance(params);
        }
        catch (final IllegalArgumentException e) {
            return null;
        }
        catch (final InstantiationException e2) {
            return null;
        }
        catch (final IllegalAccessException e3) {
            return null;
        }
        catch (final InvocationTargetException e4) {
            return null;
        }
    }
    
    private static <V> ListenableFuture<List<V>> listFuture(final ImmutableList<ListenableFuture<? extends V>> futures, final boolean allMustSucceed, final Executor listenerExecutor) {
        return (ListenableFuture<List<V>>)new CombinedFuture((com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<?>>)futures, allMustSucceed, listenerExecutor, (FutureCombiner<Object, Object>)new FutureCombiner<V, List<V>>() {
            @Override
            public List<V> combine(final List<Optional<V>> values) {
                final List<V> result = Lists.newArrayList();
                for (final Optional<V> element : values) {
                    result.add((V)((element != null) ? element.orNull() : null));
                }
                return result;
            }
        });
    }
    
    static {
        DEREFERENCER = (AsyncFunction)new AsyncFunction<ListenableFuture<Object>, Object>() {
            public ListenableFuture<Object> apply(final ListenableFuture<Object> input) {
                return input;
            }
        };
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf((Function)new Function<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> input) {
                return Arrays.asList(input.getParameterTypes()).contains(String.class);
            }
        }).reverse();
    }
    
    private abstract static class ImmediateFuture<V> implements ListenableFuture<V>
    {
        private static final Logger log;
        
        public void addListener(final Runnable listener, final Executor executor) {
            Preconditions.checkNotNull((Object)listener, (Object)"Runnable was null.");
            Preconditions.checkNotNull((Object)executor, (Object)"Executor was null.");
            try {
                executor.execute(listener);
            }
            catch (final RuntimeException e) {
                ImmediateFuture.log.log(Level.SEVERE, "RuntimeException while executing runnable " + listener + " with executor " + executor, e);
            }
        }
        
        public boolean cancel(final boolean mayInterruptIfRunning) {
            return false;
        }
        
        public abstract V get() throws ExecutionException;
        
        public V get(final long timeout, final TimeUnit unit) throws ExecutionException {
            Preconditions.checkNotNull((Object)unit);
            return this.get();
        }
        
        public boolean isCancelled() {
            return false;
        }
        
        public boolean isDone() {
            return true;
        }
        
        static {
            log = Logger.getLogger(ImmediateFuture.class.getName());
        }
    }
    
    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V>
    {
        @Nullable
        private final V value;
        
        ImmediateSuccessfulFuture(@Nullable final V value) {
            this.value = value;
        }
        
        @Override
        public V get() {
            return this.value;
        }
    }
    
    private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X>
    {
        @Nullable
        private final V value;
        
        ImmediateSuccessfulCheckedFuture(@Nullable final V value) {
            this.value = value;
        }
        
        @Override
        public V get() {
            return this.value;
        }
        
        public V checkedGet() {
            return this.value;
        }
        
        public V checkedGet(final long timeout, final TimeUnit unit) {
            Preconditions.checkNotNull((Object)unit);
            return this.value;
        }
    }
    
    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V>
    {
        private final Throwable thrown;
        
        ImmediateFailedFuture(final Throwable thrown) {
            this.thrown = thrown;
        }
        
        @Override
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }
    
    private static class ImmediateCancelledFuture<V> extends ImmediateFuture<V>
    {
        private final CancellationException thrown;
        
        ImmediateCancelledFuture() {
            this.thrown = new CancellationException("Immediate cancelled future.");
        }
        
        @Override
        public boolean isCancelled() {
            return true;
        }
        
        @Override
        public V get() {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", (Throwable)this.thrown);
        }
    }
    
    private static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X>
    {
        private final X thrown;
        
        ImmediateFailedCheckedFuture(final X thrown) {
            this.thrown = thrown;
        }
        
        @Override
        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
        
        public V checkedGet() throws X, Exception {
            throw this.thrown;
        }
        
        public V checkedGet(final long timeout, final TimeUnit unit) throws X, Exception {
            Preconditions.checkNotNull((Object)unit);
            throw this.thrown;
        }
    }
    
    private static class FallbackFuture<V> extends AbstractFuture<V>
    {
        private volatile ListenableFuture<? extends V> running;
        
        FallbackFuture(final ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback, final Executor executor) {
            Futures.addCallback((com.google.common.util.concurrent.ListenableFuture<Object>)(this.running = input), (com.google.common.util.concurrent.FutureCallback<? super Object>)new FutureCallback<V>() {
                public void onSuccess(final V value) {
                    FallbackFuture.this.set((Object)value);
                }
                
                public void onFailure(final Throwable t) {
                    if (FallbackFuture.this.isCancelled()) {
                        return;
                    }
                    try {
                        FallbackFuture.this.running = (ListenableFuture<? extends V>)fallback.create(t);
                        if (FallbackFuture.this.isCancelled()) {
                            FallbackFuture.this.running.cancel(FallbackFuture.this.wasInterrupted());
                            return;
                        }
                        Futures.addCallback((com.google.common.util.concurrent.ListenableFuture<Object>)FallbackFuture.this.running, (com.google.common.util.concurrent.FutureCallback<? super Object>)new FutureCallback<V>() {
                            public void onSuccess(final V value) {
                                FallbackFuture.this.set((Object)value);
                            }
                            
                            public void onFailure(final Throwable t) {
                                if (FallbackFuture.this.running.isCancelled()) {
                                    FallbackFuture.this.cancel(false);
                                }
                                else {
                                    FallbackFuture.this.setException(t);
                                }
                            }
                        }, (Executor)MoreExecutors.sameThreadExecutor());
                    }
                    catch (final Exception e) {
                        FallbackFuture.this.setException((Throwable)e);
                    }
                    catch (final Error e2) {
                        FallbackFuture.this.setException((Throwable)e2);
                    }
                }
            }, executor);
        }
        
        public boolean cancel(final boolean mayInterruptIfRunning) {
            if (super.cancel(mayInterruptIfRunning)) {
                this.running.cancel(mayInterruptIfRunning);
                return true;
            }
            return false;
        }
    }
    
    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable
    {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private volatile ListenableFuture<? extends O> outputFuture;
        private final CountDownLatch outputCreated;
        
        private ChainingListenableFuture(final AsyncFunction<? super I, ? extends O> function, final ListenableFuture<? extends I> inputFuture) {
            this.outputCreated = new CountDownLatch(1);
            this.function = (AsyncFunction<? super I, ? extends O>)Preconditions.checkNotNull((Object)function);
            this.inputFuture = (ListenableFuture<? extends I>)Preconditions.checkNotNull((Object)inputFuture);
        }
        
        public boolean cancel(final boolean mayInterruptIfRunning) {
            if (super.cancel(mayInterruptIfRunning)) {
                this.cancel((Future<?>)this.inputFuture, mayInterruptIfRunning);
                this.cancel((Future<?>)this.outputFuture, mayInterruptIfRunning);
                return true;
            }
            return false;
        }
        
        private void cancel(@Nullable final Future<?> future, final boolean mayInterruptIfRunning) {
            if (future != null) {
                future.cancel(mayInterruptIfRunning);
            }
        }
        
        public void run() {
            try {
                I sourceResult;
                try {
                    sourceResult = (I)Uninterruptibles.getUninterruptibly((Future)this.inputFuture);
                }
                catch (final CancellationException e) {
                    this.cancel(false);
                    return;
                }
                catch (final ExecutionException e2) {
                    this.setException(e2.getCause());
                    return;
                }
                final ListenableFuture apply = this.function.apply((Object)sourceResult);
                this.outputFuture = (ListenableFuture<? extends O>)apply;
                final ListenableFuture<? extends O> outputFuture = (ListenableFuture<? extends O>)apply;
                if (this.isCancelled()) {
                    outputFuture.cancel(this.wasInterrupted());
                    this.outputFuture = null;
                    return;
                }
                outputFuture.addListener((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ChainingListenableFuture.this.set(Uninterruptibles.getUninterruptibly((Future)outputFuture));
                        }
                        catch (final CancellationException e) {
                            ChainingListenableFuture.this.cancel(false);
                        }
                        catch (final ExecutionException e2) {
                            ChainingListenableFuture.this.setException(e2.getCause());
                        }
                        finally {
                            ChainingListenableFuture.this.outputFuture = null;
                        }
                    }
                }, (Executor)MoreExecutors.sameThreadExecutor());
            }
            catch (final UndeclaredThrowableException e3) {
                this.setException(e3.getCause());
            }
            catch (final Exception e4) {
                this.setException((Throwable)e4);
            }
            catch (final Error e5) {
                this.setException((Throwable)e5);
            }
            finally {
                this.function = null;
                this.inputFuture = null;
                this.outputCreated.countDown();
            }
        }
    }
    
    private static class CombinedFuture<V, C> extends AbstractFuture<C>
    {
        ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
        final boolean allMustSucceed;
        final AtomicInteger remaining;
        FutureCombiner<V, C> combiner;
        List<Optional<V>> values;
        
        CombinedFuture(final ImmutableCollection<? extends ListenableFuture<? extends V>> futures, final boolean allMustSucceed, final Executor listenerExecutor, final FutureCombiner<V, C> combiner) {
            this.futures = futures;
            this.allMustSucceed = allMustSucceed;
            this.remaining = new AtomicInteger(futures.size());
            this.combiner = combiner;
            this.values = Lists.newArrayListWithCapacity(futures.size());
            this.init(listenerExecutor);
        }
        
        protected void init(final Executor listenerExecutor) {
            this.addListener((Runnable)new Runnable() {
                @Override
                public void run() {
                    if (CombinedFuture.this.isCancelled()) {
                        for (final ListenableFuture<?> future : CombinedFuture.this.futures) {
                            future.cancel(CombinedFuture.this.wasInterrupted());
                        }
                    }
                    CombinedFuture.this.futures = null;
                    CombinedFuture.this.values = null;
                    CombinedFuture.this.combiner = null;
                }
            }, (Executor)MoreExecutors.sameThreadExecutor());
            if (this.futures.isEmpty()) {
                this.set((Object)this.combiner.combine((List<com.google.common.base.Optional<V>>)ImmutableList.of()));
                return;
            }
            for (int i = 0; i < this.futures.size(); ++i) {
                this.values.add(null);
            }
            int i = 0;
            for (final ListenableFuture<? extends V> listenable : this.futures) {
                final int index = i++;
                listenable.addListener((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CombinedFuture.this.setOneValue(index, (Future)listenable);
                    }
                }, listenerExecutor);
            }
        }
        
        private void setOneValue(final int index, final Future<? extends V> future) {
            final List<Optional<V>> localValues = this.values;
            if (this.isDone() || localValues == null) {
                Preconditions.checkState(this.allMustSucceed || this.isCancelled(), (Object)"Future was done before all dependencies completed");
                return;
            }
            try {
                Preconditions.checkState(future.isDone(), (Object)"Tried to set value from future which is not done");
                final V returnValue = (V)Uninterruptibles.getUninterruptibly((Future)future);
                localValues.set(index, (Optional<V>)Optional.fromNullable((Object)returnValue));
            }
            catch (final CancellationException e) {
                if (this.allMustSucceed) {
                    this.cancel(false);
                }
            }
            catch (final ExecutionException e2) {
                if (this.allMustSucceed) {
                    this.setException(e2.getCause());
                }
            }
            catch (final RuntimeException e3) {
                if (this.allMustSucceed) {
                    this.setException((Throwable)e3);
                }
            }
            catch (final Error e4) {
                this.setException((Throwable)e4);
            }
            finally {
                final int newRemaining = this.remaining.decrementAndGet();
                Preconditions.checkState(newRemaining >= 0, (Object)"Less than 0 remaining futures");
                if (newRemaining == 0) {
                    final FutureCombiner<V, C> localCombiner = this.combiner;
                    if (localCombiner != null) {
                        this.set((Object)localCombiner.combine(localValues));
                    }
                    else {
                        Preconditions.checkState(this.isDone());
                    }
                }
            }
        }
    }
    
    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X>
    {
        final Function<Exception, X> mapper;
        
        MappingCheckedFuture(final ListenableFuture<V> delegate, final Function<Exception, X> mapper) {
            super((ListenableFuture)delegate);
            this.mapper = (Function<Exception, X>)Preconditions.checkNotNull((Object)mapper);
        }
        
        protected X mapException(final Exception e) {
            return (X)this.mapper.apply((Object)e);
        }
    }
    
    private interface FutureCombiner<V, C>
    {
        C combine(final List<Optional<V>> p0);
    }
}
