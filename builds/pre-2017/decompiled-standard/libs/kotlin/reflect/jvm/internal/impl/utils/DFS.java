/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public class DFS {
    public static <N, R> R dfs(@NotNull Collection<N> nodes, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, R> handler) {
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        if (handler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        for (N node : nodes) {
            DFS.doDfs(node, neighbors, visited, handler);
        }
        return handler.result();
    }

    public static <N, R> R dfs(@NotNull Collection<N> nodes, @NotNull Neighbors<N> neighbors, @NotNull NodeHandler<N, R> handler) {
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        if (handler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfs"));
        }
        return DFS.dfs(nodes, neighbors, new VisitedWithSet(), handler);
    }

    public static <N> Boolean ifAny(@NotNull Collection<N> nodes, @NotNull Neighbors<N> neighbors, final @NotNull Function1<N, Boolean> predicate) {
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"));
        }
        if (predicate == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "predicate", "kotlin/reflect/jvm/internal/impl/utils/DFS", "ifAny"));
        }
        final boolean[] result2 = new boolean[1];
        return (Boolean)DFS.dfs(nodes, neighbors, new AbstractNodeHandler<N, Boolean>(){

            @Override
            public boolean beforeChildren(N current) {
                if (((Boolean)predicate.invoke(current)).booleanValue()) {
                    result2[0] = true;
                }
                return !result2[0];
            }

            @Override
            public Boolean result() {
                return result2[0];
            }
        });
    }

    public static <N, R> R dfsFromNode(@NotNull N node, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, R> handler) {
        if (node == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "node", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        if (handler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        DFS.doDfs(node, neighbors, visited, handler);
        return handler.result();
    }

    public static <N> void dfsFromNode(@NotNull N node, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited) {
        if (node == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "node", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "dfsFromNode"));
        }
        DFS.dfsFromNode(node, neighbors, visited, new AbstractNodeHandler<N, Void>(){

            @Override
            public Void result() {
                return null;
            }
        });
    }

    public static <N> List<N> topologicalOrder(@NotNull Iterable<N> nodes, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited) {
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "topologicalOrder"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "topologicalOrder"));
        }
        if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "topologicalOrder"));
        }
        TopologicalOrder handler = new TopologicalOrder();
        for (N node : nodes) {
            DFS.doDfs(node, neighbors, visited, handler);
        }
        return (List)handler.result();
    }

    public static <N> List<N> topologicalOrder(@NotNull Iterable<N> nodes, @NotNull Neighbors<N> neighbors) {
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nodes", "kotlin/reflect/jvm/internal/impl/utils/DFS", "topologicalOrder"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "topologicalOrder"));
        }
        return DFS.topologicalOrder(nodes, neighbors, new VisitedWithSet());
    }

    private static <N> void doDfs(@NotNull N current, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, ?> handler) {
        if (current == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "current", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"));
        }
        if (neighbors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "neighbors", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"));
        }
        if (visited == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"));
        }
        if (handler == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "handler", "kotlin/reflect/jvm/internal/impl/utils/DFS", "doDfs"));
        }
        if (!visited.checkAndMarkVisited(current)) {
            return;
        }
        if (!handler.beforeChildren(current)) {
            return;
        }
        for (N neighbor : neighbors.getNeighbors(current)) {
            DFS.doDfs(neighbor, neighbors, visited, handler);
        }
        handler.afterChildren(current);
    }

    public static class TopologicalOrder<N>
    extends NodeHandlerWithListResult<N, N> {
        @Override
        public void afterChildren(N current) {
            ((LinkedList)this.result).addFirst(current);
        }
    }

    public static abstract class NodeHandlerWithListResult<N, R>
    extends CollectingNodeHandler<N, R, LinkedList<R>> {
        protected NodeHandlerWithListResult() {
            super(new LinkedList());
        }
    }

    public static abstract class CollectingNodeHandler<N, R, C extends Iterable<R>>
    extends AbstractNodeHandler<N, C> {
        @NotNull
        protected final C result;

        protected CollectingNodeHandler(@NotNull C result2) {
            if (result2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler", "<init>"));
            }
            this.result = result2;
        }

        @Override
        @NotNull
        public C result() {
            C c = this.result;
            if (c == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler", "result"));
            }
            return c;
        }
    }

    public static class VisitedWithSet<N>
    implements Visited<N> {
        private final Set<N> visited;

        public VisitedWithSet() {
            this(new HashSet());
        }

        public VisitedWithSet(@NotNull Set<N> visited) {
            if (visited == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
            }
            this.visited = visited;
        }

        @Override
        public boolean checkAndMarkVisited(N current) {
            return this.visited.add(current);
        }
    }

    public static abstract class AbstractNodeHandler<N, R>
    implements NodeHandler<N, R> {
        @Override
        public boolean beforeChildren(N current) {
            return true;
        }

        @Override
        public void afterChildren(N current) {
        }
    }

    public static interface Visited<N> {
        public boolean checkAndMarkVisited(N var1);
    }

    public static interface Neighbors<N> {
        @NotNull
        public Iterable<? extends N> getNeighbors(N var1);
    }

    public static interface NodeHandler<N, R> {
        public boolean beforeChildren(N var1);

        public void afterChildren(N var1);

        public R result();
    }
}

