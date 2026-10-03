/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.io.AccessDeniedException;
import kotlin.io.FileTreeWalk$FileTreeWalkIterator$WhenMappings;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"})
public final class FileTreeWalk
implements Sequence<File> {
    private final File start;
    private final FileWalkDirection direction;
    private final Function1<File, Boolean> onEnter;
    private final Function1<File, Unit> onLeave;
    private final Function2<File, IOException, Unit> onFail;
    private final int maxDepth;

    @Override
    @NotNull
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }

    @NotNull
    public final FileTreeWalk onEnter(@NotNull Function1<? super File, Boolean> function) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        return new FileTreeWalk(this.start, this.direction, function, this.onLeave, this.onFail, this.maxDepth);
    }

    @NotNull
    public final FileTreeWalk onLeave(@NotNull Function1<? super File, Unit> function) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, function, this.onFail, this.maxDepth);
    }

    @NotNull
    public final FileTreeWalk onFail(@NotNull Function2<? super File, ? super IOException, Unit> function) {
        Intrinsics.checkParameterIsNotNull(function, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    @NotNull
    public final FileTreeWalk maxDepth(int depth) {
        if (depth <= 0) {
            throw (Throwable)new IllegalArgumentException("depth must be positive, but was " + depth + ".");
        }
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, depth);
    }

    private FileTreeWalk(File start, FileWalkDirection direction, Function1<? super File, Boolean> onEnter, Function1<? super File, Unit> onLeave, Function2<? super File, ? super IOException, Unit> onFail, int maxDepth) {
        this.start = start;
        this.direction = direction;
        this.onEnter = onEnter;
        this.onLeave = onLeave;
        this.onFail = onFail;
        this.maxDepth = maxDepth;
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        if ((n2 & 0x20) != 0) {
            n = Integer.MAX_VALUE;
        }
        this(file, fileWalkDirection, function1, function12, function2, n);
    }

    public FileTreeWalk(@NotNull File start, @NotNull FileWalkDirection direction) {
        Intrinsics.checkParameterIsNotNull(start, "start");
        Intrinsics.checkParameterIsNotNull((Object)direction, "direction");
        this(start, direction, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        this(file, fileWalkDirection);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2={"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"})
    private static abstract class WalkState {
        @NotNull
        private final File root;

        @Nullable
        public abstract File step();

        @NotNull
        public final File getRoot() {
            return this.root;
        }

        public WalkState(@NotNull File root) {
            Intrinsics.checkParameterIsNotNull(root, "root");
            this.root = root;
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"})
    private static abstract class DirectoryState
    extends WalkState {
        public DirectoryState(@NotNull File rootDir) {
            Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
            super(rootDir);
            if (_Assertions.ENABLED) {
                boolean bl = rootDir.isDirectory();
                if (_Assertions.ENABLED && !bl) {
                    String string = "rootDir must be verified to be directory beforehand.";
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
            }
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/Stack;", "Lkotlin/io/FileTreeWalk$WalkState;", "getState", "()Ljava/util/Stack;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"})
    private final class FileTreeWalkIterator
    extends AbstractIterator<File> {
        private final Stack<WalkState> state = new Stack();

        private final Stack<WalkState> getState() {
            return this.state;
        }

        @Override
        protected void computeNext() {
            File nextFile = this.gotoNext();
            if (nextFile != null) {
                this.setNext(nextFile);
            } else {
                this.done();
            }
        }

        private final DirectoryState directoryState(File root) {
            DirectoryState directoryState;
            switch (FileTreeWalk$FileTreeWalkIterator$WhenMappings.$EnumSwitchMapping$0[FileTreeWalk.this.direction.ordinal()]) {
                case 1: {
                    directoryState = new TopDownDirectoryState(root);
                    break;
                }
                case 2: {
                    directoryState = new BottomUpDirectoryState(root);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return directoryState;
        }

        private final File gotoNext() {
            while (!this.state.empty()) {
                WalkState topState;
                File file;
                if (this.state.peek() == null) {
                    Intrinsics.throwNpe();
                }
                if ((file = topState.step()) == null) {
                    this.state.pop();
                    continue;
                }
                if (Intrinsics.areEqual(file, topState.getRoot()) || !file.isDirectory() || this.state.size() >= FileTreeWalk.this.maxDepth) {
                    return file;
                }
                this.state.push(this.directoryState(file));
            }
            return null;
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.start.isDirectory()) {
                this.state.push(this.directoryState(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                this.state.push(new SingleFileState(FileTreeWalk.this.start));
            } else {
                this.done();
            }
        }

        @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\n\u00a8\u0006\u001c"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "getFailed", "()Z", "setFailed", "(Z)V", "fileIndex", "", "getFileIndex", "()I", "setFileIndex", "(I)V", "fileList", "", "getFileList", "()[Ljava/io/File;", "setFileList", "([Ljava/io/File;)V", "[Ljava/io/File;", "rootVisited", "getRootVisited", "setRootVisited", "step", "kotlin-stdlib"})
        private final class BottomUpDirectoryState
        extends DirectoryState {
            private boolean rootVisited;
            private File[] fileList;
            private int fileIndex;
            private boolean failed;

            private final boolean getRootVisited() {
                return this.rootVisited;
            }

            private final void setRootVisited(boolean bl) {
                this.rootVisited = bl;
            }

            private final File[] getFileList() {
                return this.fileList;
            }

            private final void setFileList(File[] fileArray) {
                this.fileList = fileArray;
            }

            private final int getFileIndex() {
                return this.fileIndex;
            }

            private final void setFileIndex(int n) {
                this.fileIndex = n;
            }

            private final boolean getFailed() {
                return this.failed;
            }

            private final void setFailed(boolean bl) {
                this.failed = bl;
            }

            @Override
            @Nullable
            public File step() {
                block9: {
                    if (!this.failed && this.fileList == null) {
                        Function1 function1 = FileTreeWalk.this.onEnter;
                        if (Intrinsics.areEqual(function1 != null ? (Boolean)function1.invoke(this.getRoot()) : null, false)) {
                            return null;
                        }
                        this.fileList = this.getRoot().listFiles();
                        if (this.fileList == null) {
                            Function2 function2 = FileTreeWalk.this.onFail;
                            if (function2 != null) {
                                Unit cfr_ignored_0 = (Unit)function2.invoke(this.getRoot(), new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                            }
                            this.failed = true;
                        }
                    }
                    if (this.fileList != null) {
                        if (this.fileList == null) {
                            Intrinsics.throwNpe();
                        }
                        if (this.fileIndex < ((Object[])this.fileList).length) {
                            if (this.fileList == null) {
                                Intrinsics.throwNpe();
                            }
                            int n = this.fileIndex;
                            this.fileIndex = n + 1;
                            return this.fileList[n];
                        }
                    }
                    if (!this.rootVisited) {
                        this.rootVisited = true;
                        return this.getRoot();
                    }
                    Function1 function1 = FileTreeWalk.this.onLeave;
                    if (function1 == null) break block9;
                    Unit cfr_ignored_1 = (Unit)function1.invoke(this.getRoot());
                }
                return null;
            }

            public BottomUpDirectoryState(File rootDir) {
                Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
                super(rootDir);
            }
        }

        @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "getFileIndex", "()I", "setFileIndex", "(I)V", "fileList", "", "getFileList", "()[Ljava/io/File;", "setFileList", "([Ljava/io/File;)V", "[Ljava/io/File;", "rootVisited", "", "getRootVisited", "()Z", "setRootVisited", "(Z)V", "step", "kotlin-stdlib"})
        private final class TopDownDirectoryState
        extends DirectoryState {
            private boolean rootVisited;
            private File[] fileList;
            private int fileIndex;

            private final boolean getRootVisited() {
                return this.rootVisited;
            }

            private final void setRootVisited(boolean bl) {
                this.rootVisited = bl;
            }

            private final File[] getFileList() {
                return this.fileList;
            }

            private final void setFileList(File[] fileArray) {
                this.fileList = fileArray;
            }

            private final int getFileIndex() {
                return this.fileIndex;
            }

            private final void setFileIndex(int n) {
                this.fileIndex = n;
            }

            @Override
            @Nullable
            public File step() {
                block15: {
                    block12: {
                        block13: {
                            block14: {
                                block11: {
                                    if (!this.rootVisited) {
                                        Function1 function1 = FileTreeWalk.this.onEnter;
                                        if (Intrinsics.areEqual(function1 != null ? (Boolean)function1.invoke(this.getRoot()) : null, false)) {
                                            return null;
                                        }
                                        this.rootVisited = true;
                                        return this.getRoot();
                                    }
                                    if (this.fileList == null) break block11;
                                    if (this.fileList == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    if (this.fileIndex >= ((Object[])this.fileList).length) break block12;
                                }
                                if (this.fileList != null) break block13;
                                this.fileList = this.getRoot().listFiles();
                                if (this.fileList == null) {
                                    Function2 function2 = FileTreeWalk.this.onFail;
                                    if (function2 != null) {
                                        Unit cfr_ignored_0 = (Unit)function2.invoke(this.getRoot(), new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                                    }
                                }
                                if (this.fileList == null) break block14;
                                if (this.fileList == null) {
                                    Intrinsics.throwNpe();
                                }
                                if (((Object[])this.fileList).length != 0) break block13;
                            }
                            Function1 function1 = FileTreeWalk.this.onLeave;
                            if (function1 != null) {
                                Unit cfr_ignored_1 = (Unit)function1.invoke(this.getRoot());
                            }
                            return null;
                        }
                        if (this.fileList == null) {
                            Intrinsics.throwNpe();
                        }
                        int n = this.fileIndex;
                        this.fileIndex = n + 1;
                        return this.fileList[n];
                    }
                    Function1 function1 = FileTreeWalk.this.onLeave;
                    if (function1 == null) break block15;
                    Unit cfr_ignored_2 = (Unit)function1.invoke(this.getRoot());
                }
                return null;
            }

            public TopDownDirectoryState(File rootDir) {
                Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
                super(rootDir);
            }
        }

        @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "getVisited", "()Z", "setVisited", "(Z)V", "step", "kotlin-stdlib"})
        private final class SingleFileState
        extends WalkState {
            private boolean visited;

            private final boolean getVisited() {
                return this.visited;
            }

            private final void setVisited(boolean bl) {
                this.visited = bl;
            }

            @Override
            @Nullable
            public File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return this.getRoot();
            }

            public SingleFileState(File rootFile) {
                Intrinsics.checkParameterIsNotNull(rootFile, "rootFile");
                super(rootFile);
                if (_Assertions.ENABLED) {
                    boolean bl = rootFile.isFile();
                    if (_Assertions.ENABLED && !bl) {
                        String string = "rootFile must be verified to be file beforehand.";
                        throw (Throwable)((Object)new AssertionError((Object)string));
                    }
                }
            }
        }
    }
}

