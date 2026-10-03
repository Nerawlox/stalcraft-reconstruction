// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.collections.CollectionsKt;
import java.util.List;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import java.io.File;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 5 }, bv = { 1, 0, 1 }, k = 5, xi = 1, d1 = { "\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a(\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a(\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002?\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002?\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002?\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F?\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F?\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F?\u0006\u0006\u001a\u0004\b\b\u0010\u0004?\u0006+" }, d2 = { "extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib" }, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt
{
    @NotNull
    public static final File createTempDir(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkParameterIsNotNull((Object)prefix, "prefix");
        final File dir = File.createTempFile(prefix, suffix, directory);
        dir.delete();
        if (dir.mkdir()) {
            final File file = dir;
            Intrinsics.checkExpressionValueIsNotNull((Object)file, "dir");
            return file;
        }
        throw new IOException("Unable to create temporary directory " + dir + ".");
    }
    
    @NotNull
    public static final File createTempFile(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkParameterIsNotNull((Object)prefix, "prefix");
        final File tempFile = File.createTempFile(prefix, suffix, directory);
        Intrinsics.checkExpressionValueIsNotNull((Object)tempFile, "File.createTempFile(prefix, suffix, directory)");
        return tempFile;
    }
    
    @NotNull
    public static final String getExtension(@NotNull final File $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return StringsKt.substringAfterLast($receiver.getName(), '.', "");
    }
    
    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull final File $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        String s;
        if (File.separatorChar != '/') {
            s = StringsKt.replace$default($receiver.getPath(), File.separatorChar, '/', false, 4, (Object)null);
        }
        else {
            Intrinsics.checkExpressionValueIsNotNull((Object)(s = $receiver.getPath()), "path");
        }
        return s;
    }
    
    @NotNull
    public static final String getNameWithoutExtension(@NotNull final File $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return StringsKt.substringBeforeLast$default($receiver.getName(), ".", (String)null, 2, (Object)null);
    }
    
    @NotNull
    public static final String toRelativeString(@NotNull final File $receiver, @NotNull final File base) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($receiver, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + $receiver + " and " + base + ".");
    }
    
    @NotNull
    public static final File relativeTo(@NotNull final File $receiver, @NotNull final File base) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)base, "base");
        return new File(FilesKt.toRelativeString($receiver, base));
    }
    
    @NotNull
    public static final File relativeToOrSelf(@NotNull final File $receiver, @NotNull final File base) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($receiver, base);
        File file;
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            final String it = relativeStringOrNull$FilesKt__UtilsKt;
            file = new File(it);
        }
        else {
            file = $receiver;
        }
        return file;
    }
    
    @Nullable
    public static final File relativeToOrNull(@NotNull final File $receiver, @NotNull final File base) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($receiver, base);
        File file;
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            final String it = relativeStringOrNull$FilesKt__UtilsKt;
            file = new File(it);
        }
        else {
            file = null;
        }
        return file;
    }
    
    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(@NotNull final File $receiver, final File base) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    kotlin/io/FilesKt.toComponents:(Ljava/io/File;)Lkotlin/io/FilePathComponents;
        //     4: invokestatic    kotlin/io/FilesKt__UtilsKt.normalize$FilesKt__UtilsKt:(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;
        //     7: astore_2        /* thisComponents */
        //     8: aload_1         /* base */
        //     9: invokestatic    kotlin/io/FilesKt.toComponents:(Ljava/io/File;)Lkotlin/io/FilePathComponents;
        //    12: invokestatic    kotlin/io/FilesKt__UtilsKt.normalize$FilesKt__UtilsKt:(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;
        //    15: astore_3        /* baseComponents */
        //    16: aload_2         /* thisComponents */
        //    17: invokevirtual   kotlin/io/FilePathComponents.getRoot:()Ljava/io/File;
        //    20: aload_3         /* baseComponents */
        //    21: invokevirtual   kotlin/io/FilePathComponents.getRoot:()Ljava/io/File;
        //    24: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    27: iconst_1       
        //    28: ixor           
        //    29: ifeq            34
        //    32: aconst_null    
        //    33: areturn        
        //    34: aload_3         /* baseComponents */
        //    35: invokevirtual   kotlin/io/FilePathComponents.getSize:()I
        //    38: istore          baseCount
        //    40: aload_2         /* thisComponents */
        //    41: invokevirtual   kotlin/io/FilePathComponents.getSize:()I
        //    44: istore          thisCount
        //    46: aload_0         /* $receiver */
        //    47: astore          7
        //    49: aload           7
        //    51: checkcast       Ljava/io/File;
        //    54: astore          $receiver
        //    56: iconst_0       
        //    57: istore          i
        //    59: iload           thisCount
        //    61: istore          10
        //    63: iload           baseCount
        //    65: istore          11
        //    67: iload           10
        //    69: iload           11
        //    71: invokestatic    java/lang/Math.min:(II)I
        //    74: istore          maxSameCount
        //    76: iload           i
        //    78: iload           maxSameCount
        //    80: if_icmpge       123
        //    83: aload_2         /* thisComponents */
        //    84: invokevirtual   kotlin/io/FilePathComponents.getSegments:()Ljava/util/List;
        //    87: iload           i
        //    89: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    94: checkcast       Ljava/io/File;
        //    97: aload_3         /* baseComponents */
        //    98: invokevirtual   kotlin/io/FilePathComponents.getSegments:()Ljava/util/List;
        //   101: iload           i
        //   103: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   108: checkcast       Ljava/io/File;
        //   111: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   114: ifeq            123
        //   117: iinc            i, 1
        //   120: goto            76
        //   123: iload           i
        //   125: istore          sameCount
        //   127: new             Ljava/lang/StringBuilder;
        //   130: dup            
        //   131: invokespecial   java/lang/StringBuilder.<init>:()V
        //   134: astore          res
        //   136: iload           baseCount
        //   138: iconst_1       
        //   139: isub           
        //   140: istore          8
        //   142: iload           sameCount
        //   144: istore          9
        //   146: iload           8
        //   148: iload           9
        //   150: if_icmplt       217
        //   153: aload_3         /* baseComponents */
        //   154: invokevirtual   kotlin/io/FilePathComponents.getSegments:()Ljava/util/List;
        //   157: iload           i
        //   159: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   164: checkcast       Ljava/io/File;
        //   167: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //   170: ldc             ".."
        //   172: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   175: ifeq            180
        //   178: aconst_null    
        //   179: areturn        
        //   180: aload           res
        //   182: ldc             ".."
        //   184: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: pop            
        //   188: iload           i
        //   190: iload           sameCount
        //   192: if_icmpeq       204
        //   195: aload           res
        //   197: getstatic       java/io/File.separatorChar:C
        //   200: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   203: pop            
        //   204: iload           i
        //   206: iload           9
        //   208: if_icmpeq       217
        //   211: iinc            i, -1
        //   214: goto            153
        //   217: iload           sameCount
        //   219: iload           thisCount
        //   221: if_icmpge       284
        //   224: iload           sameCount
        //   226: iload           baseCount
        //   228: if_icmpge       240
        //   231: aload           res
        //   233: getstatic       java/io/File.separatorChar:C
        //   236: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   239: pop            
        //   240: aload_2         /* thisComponents */
        //   241: invokevirtual   kotlin/io/FilePathComponents.getSegments:()Ljava/util/List;
        //   244: checkcast       Ljava/lang/Iterable;
        //   247: iload           sameCount
        //   249: invokestatic    kotlin/collections/CollectionsKt.drop:(Ljava/lang/Iterable;I)Ljava/util/List;
        //   252: checkcast       Ljava/lang/Iterable;
        //   255: aload           res
        //   257: checkcast       Ljava/lang/Appendable;
        //   260: getstatic       java/io/File.separator:Ljava/lang/String;
        //   263: dup            
        //   264: ldc             "File.separator"
        //   266: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   269: checkcast       Ljava/lang/CharSequence;
        //   272: aconst_null    
        //   273: aconst_null    
        //   274: iconst_0       
        //   275: aconst_null    
        //   276: aconst_null    
        //   277: bipush          124
        //   279: aconst_null    
        //   280: invokestatic    kotlin/collections/CollectionsKt.joinTo$default:(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/Appendable;
        //   283: pop            
        //   284: aload           res
        //   286: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   289: areturn        
        //    StackMapTable: 00 09 FD 00 22 07 00 93 07 00 93 FF 00 29 00 0D 07 00 12 07 00 12 07 00 93 07 00 93 01 01 00 07 00 12 07 00 12 01 01 01 01 00 00 2E FF 00 1D 00 0D 07 00 12 07 00 12 07 00 93 07 00 93 01 01 01 07 00 25 01 01 01 01 01 00 00 1A 17 0C 16 2B
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final File copyTo(@NotNull final File $receiver, @NotNull final File target, final boolean overwrite, final int bufferSize) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "$receiver"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* target */
        //     7: ldc             "target"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* $receiver */
        //    13: invokevirtual   java/io/File.exists:()Z
        //    16: ifne            36
        //    19: new             Lkotlin/io/NoSuchFileException;
        //    22: dup            
        //    23: aload_0         /* $receiver */
        //    24: aconst_null    
        //    25: ldc             "The source file doesn't exist."
        //    27: iconst_2       
        //    28: aconst_null    
        //    29: invokespecial   kotlin/io/NoSuchFileException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //    32: checkcast       Ljava/lang/Throwable;
        //    35: athrow         
        //    36: aload_1         /* target */
        //    37: invokevirtual   java/io/File.exists:()Z
        //    40: ifeq            85
        //    43: iload_2         /* overwrite */
        //    44: ifne            51
        //    47: iconst_1       
        //    48: goto            63
        //    51: aload_1         /* target */
        //    52: invokevirtual   java/io/File.delete:()Z
        //    55: ifne            62
        //    58: iconst_1       
        //    59: goto            63
        //    62: iconst_0       
        //    63: istore          stillExists
        //    65: iload           stillExists
        //    67: ifeq            85
        //    70: new             Lkotlin/io/FileAlreadyExistsException;
        //    73: dup            
        //    74: aload_0         /* $receiver */
        //    75: aload_1         /* target */
        //    76: ldc             "The destination file already exists."
        //    78: invokespecial   kotlin/io/FileAlreadyExistsException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        //    81: checkcast       Ljava/lang/Throwable;
        //    84: athrow         
        //    85: aload_0         /* $receiver */
        //    86: invokevirtual   java/io/File.isDirectory:()Z
        //    89: ifeq            117
        //    92: aload_1         /* target */
        //    93: invokevirtual   java/io/File.mkdirs:()Z
        //    96: ifne            114
        //    99: new             Lkotlin/io/FileSystemException;
        //   102: dup            
        //   103: aload_0         /* $receiver */
        //   104: aload_1         /* target */
        //   105: ldc             "Failed to create target directory."
        //   107: invokespecial   kotlin/io/FileSystemException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        //   110: checkcast       Ljava/lang/Throwable;
        //   113: athrow         
        //   114: goto            324
        //   117: aload_1         /* target */
        //   118: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   121: dup            
        //   122: ifnull          132
        //   125: invokevirtual   java/io/File.mkdirs:()Z
        //   128: pop            
        //   129: goto            133
        //   132: pop            
        //   133: aload_0         /* $receiver */
        //   134: astore          4
        //   136: new             Ljava/io/FileInputStream;
        //   139: dup            
        //   140: aload           4
        //   142: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   145: checkcast       Ljava/io/Closeable;
        //   148: astore          4
        //   150: iconst_0       
        //   151: istore          5
        //   153: nop            
        //   154: aload           4
        //   156: checkcast       Ljava/io/FileInputStream;
        //   159: astore          input
        //   161: aload_1         /* target */
        //   162: astore          8
        //   164: new             Ljava/io/FileOutputStream;
        //   167: dup            
        //   168: aload           8
        //   170: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   173: checkcast       Ljava/io/Closeable;
        //   176: astore          8
        //   178: iconst_0       
        //   179: istore          9
        //   181: nop            
        //   182: aload           8
        //   184: checkcast       Ljava/io/FileOutputStream;
        //   187: astore          output
        //   189: aload           input
        //   191: checkcast       Ljava/io/InputStream;
        //   194: aload           output
        //   196: checkcast       Ljava/io/OutputStream;
        //   199: iload_3         /* bufferSize */
        //   200: invokestatic    kotlin/io/ByteStreamsKt.copyTo:(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
        //   203: lstore          null
        //   205: iload           9
        //   207: ifne            217
        //   210: aload           8
        //   212: invokeinterface java/io/Closeable.close:()V
        //   217: lload           10
        //   219: goto            263
        //   222: astore          10
        //   224: iconst_1       
        //   225: istore          9
        //   227: nop            
        //   228: aload           8
        //   230: invokeinterface java/io/Closeable.close:()V
        //   235: goto            240
        //   238: astore          12
        //   240: aload           10
        //   242: checkcast       Ljava/lang/Throwable;
        //   245: athrow         
        //   246: astore          10
        //   248: iload           9
        //   250: ifne            260
        //   253: aload           8
        //   255: invokeinterface java/io/Closeable.close:()V
        //   260: aload           10
        //   262: athrow         
        //   263: lstore          null
        //   265: iload           5
        //   267: ifne            277
        //   270: aload           4
        //   272: invokeinterface java/io/Closeable.close:()V
        //   277: lload           6
        //   279: goto            323
        //   282: astore          6
        //   284: iconst_1       
        //   285: istore          5
        //   287: nop            
        //   288: aload           4
        //   290: invokeinterface java/io/Closeable.close:()V
        //   295: goto            300
        //   298: astore          8
        //   300: aload           6
        //   302: checkcast       Ljava/lang/Throwable;
        //   305: athrow         
        //   306: astore          6
        //   308: iload           5
        //   310: ifne            320
        //   313: aload           4
        //   315: invokeinterface java/io/Closeable.close:()V
        //   320: aload           6
        //   322: athrow         
        //   323: pop2           
        //   324: aload_1         /* target */
        //   325: areturn        
        //    StackMapTable: 00 18 24 0E 0A 40 01 15 1C 02 4E 07 00 12 00 FF 00 53 00 0B 07 00 12 07 00 12 01 01 07 01 00 01 07 00 FB 00 07 01 00 01 04 00 00 FF 00 04 00 0A 07 00 12 07 00 12 01 01 07 01 00 01 07 00 FB 00 07 01 00 01 00 01 07 00 D8 FF 00 0F 00 0B 07 00 12 07 00 12 01 01 07 01 00 01 07 00 FB 00 07 01 00 01 07 00 D8 00 01 07 00 D8 01 FF 00 05 00 0A 07 00 12 07 00 12 01 01 07 01 00 01 07 00 FB 00 07 01 00 01 00 01 07 00 3D FC 00 0D 07 00 3D FF 00 02 00 0B 07 00 12 07 00 12 01 01 07 01 00 01 07 00 FB 00 07 01 00 01 04 00 01 04 FF 00 0D 00 0A 07 00 12 07 00 12 01 01 07 01 00 01 04 07 01 00 01 04 00 00 FF 00 04 00 06 07 00 12 07 00 12 01 01 07 01 00 01 00 01 07 00 D8 FF 00 0F 00 07 07 00 12 07 00 12 01 01 07 01 00 01 07 00 D8 00 01 07 00 D8 01 FF 00 05 00 06 07 00 12 07 00 12 01 01 07 01 00 01 00 01 07 00 3D FC 00 0D 07 00 3D FF 00 02 00 0A 07 00 12 07 00 12 01 01 07 01 00 01 04 07 01 00 01 04 00 01 04 FF 00 00 00 04 07 00 12 07 00 12 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  181    205    222    246    Ljava/lang/Exception;
        //  227    235    238    240    Ljava/lang/Exception;
        //  181    205    246    263    Any
        //  222    246    246    263    Any
        //  246    248    246    263    Any
        //  153    265    282    306    Ljava/lang/Exception;
        //  287    295    298    300    Ljava/lang/Exception;
        //  153    265    306    323    Any
        //  282    306    306    323    Any
        //  306    308    306    323    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.ArrayIndexOutOfBoundsException: -1
        //     at java.util.ArrayList.elementData(ArrayList.java:424)
        //     at java.util.ArrayList.remove(ArrayList.java:501)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:552)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2086)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final boolean copyRecursively(@NotNull final File $receiver, @NotNull final File target, final boolean overwrite, @NotNull final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)target, "target");
        Intrinsics.checkParameterIsNotNull((Object)onError, "onError");
        if (!$receiver.exists()) {
            return Intrinsics.areEqual((Object)onError.invoke((Object)$receiver, (Object)new NoSuchFileException($receiver, (File)null, "The source file doesn't exist.", 2, (DefaultConstructorMarker)null)), (Object)OnErrorAction.TERMINATE) ^ true;
        }
        try {
            for (final File src : FilesKt.walkTopDown($receiver).onFail((Function2)new FilesKt__UtilsKt$copyRecursively.FilesKt__UtilsKt$copyRecursively$2((Function2)onError))) {
                if (!src.exists()) {
                    if (Intrinsics.areEqual((Object)onError.invoke((Object)src, (Object)new NoSuchFileException(src, (File)null, "The source file doesn't exist.", 2, (DefaultConstructorMarker)null)), (Object)OnErrorAction.TERMINATE)) {
                        return false;
                    }
                    continue;
                }
                else {
                    final String relPath = FilesKt.toRelativeString(src, $receiver);
                    final File dstFile = new File(target, relPath);
                    if (dstFile.exists() && (!src.isDirectory() || !dstFile.isDirectory())) {
                        final boolean stillExists = !overwrite || (dstFile.isDirectory() ? (!FilesKt.deleteRecursively(dstFile)) : (!dstFile.delete()));
                        if (stillExists) {
                            if (Intrinsics.areEqual((Object)onError.invoke((Object)dstFile, (Object)new FileAlreadyExistsException(src, dstFile, "The destination file already exists.")), (Object)OnErrorAction.TERMINATE)) {
                                return false;
                            }
                            continue;
                        }
                    }
                    if (src.isDirectory()) {
                        dstFile.mkdirs();
                    }
                    else {
                        if (FilesKt.copyTo$default(src, dstFile, overwrite, 0, 4, (Object)null).length() != src.length() && Intrinsics.areEqual((Object)onError.invoke((Object)src, (Object)new IOException("Source file wasn't copied completely, length of destination file differs.")), (Object)OnErrorAction.TERMINATE)) {
                            return false;
                        }
                        continue;
                    }
                }
            }
            return true;
        }
        catch (final TerminateException e) {
            return false;
        }
    }
    
    public static final boolean deleteRecursively(@NotNull final File $receiver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "$receiver"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $receiver */
        //     7: invokestatic    kotlin/io/FilesKt.walkBottomUp:(Ljava/io/File;)Lkotlin/io/FileTreeWalk;
        //    10: checkcast       Lkotlin/sequences/Sequence;
        //    13: astore_1       
        //    14: iconst_1       
        //    15: istore_2        /* initial$iv */
        //    16: iload_2         /* initial$iv */
        //    17: istore_3        /* accumulator$iv */
        //    18: aload_1         /* $receiver$iv */
        //    19: invokeinterface kotlin/sequences/Sequence.iterator:()Ljava/util/Iterator;
        //    24: astore          4
        //    26: aload           4
        //    28: invokeinterface java/util/Iterator.hasNext:()Z
        //    33: ifeq            85
        //    36: aload           4
        //    38: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    43: astore          element$iv
        //    45: iload_3         /* accumulator$iv */
        //    46: aload           element$iv
        //    48: checkcast       Ljava/io/File;
        //    51: astore          6
        //    53: istore          res
        //    55: aload           it
        //    57: invokevirtual   java/io/File.delete:()Z
        //    60: ifne            71
        //    63: aload           it
        //    65: invokevirtual   java/io/File.exists:()Z
        //    68: ifne            80
        //    71: iload           res
        //    73: ifeq            80
        //    76: iconst_1       
        //    77: goto            81
        //    80: iconst_0       
        //    81: istore_3        /* accumulator$iv */
        //    82: goto            26
        //    85: iload_3         /* accumulator$iv */
        //    86: ireturn        
        //    StackMapTable: 00 05 FF 00 1A 00 05 07 00 12 07 01 6E 01 01 07 01 43 00 00 FE 00 2C 07 01 79 07 00 12 01 08 40 01 F8 00 03
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final boolean startsWith(@NotNull final File $receiver, @NotNull final File other) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)other, "other");
        final FilePathComponents components = FilesKt.toComponents($receiver);
        final FilePathComponents otherComponents = FilesKt.toComponents(other);
        return !(Intrinsics.areEqual((Object)components.getRoot(), (Object)otherComponents.getRoot()) ^ true) && components.getSize() >= otherComponents.getSize() && components.getSegments().subList(0, otherComponents.getSize()).equals(otherComponents.getSegments());
    }
    
    public static final boolean startsWith(@NotNull final File $receiver, @NotNull final String other) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)other, "other");
        return FilesKt.startsWith($receiver, new File(other));
    }
    
    public static final boolean endsWith(@NotNull final File $receiver, @NotNull final File other) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)other, "other");
        final FilePathComponents components = FilesKt.toComponents($receiver);
        final FilePathComponents otherComponents = FilesKt.toComponents(other);
        if (otherComponents.isRooted()) {
            return Intrinsics.areEqual((Object)$receiver, (Object)other);
        }
        final int shift = components.getSize() - otherComponents.getSize();
        return shift >= 0 && components.getSegments().subList(shift, components.getSize()).equals(otherComponents.getSegments());
    }
    
    public static final boolean endsWith(@NotNull final File $receiver, @NotNull final String other) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)other, "other");
        return FilesKt.endsWith($receiver, new File(other));
    }
    
    @NotNull
    public static final File normalize(@NotNull final File $receiver) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        final FilePathComponents $receiver2 = FilesKt.toComponents($receiver);
        final File root = $receiver2.getRoot();
        final Iterable iterable = normalize$FilesKt__UtilsKt($receiver2.getSegments());
        final String separator = File.separator;
        Intrinsics.checkExpressionValueIsNotNull((Object)separator, "File.separator");
        return FilesKt.resolve(root, CollectionsKt.joinToString$default(iterable, (CharSequence)separator, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null));
    }
    
    private static final FilePathComponents normalize$FilesKt__UtilsKt(@NotNull final FilePathComponents $receiver) {
        return new FilePathComponents($receiver.getRoot(), (List)normalize$FilesKt__UtilsKt($receiver.getSegments()));
    }
    
    private static final List<File> normalize$FilesKt__UtilsKt(@NotNull final List<? extends File> $receiver) {
        final List list = new ArrayList($receiver.size());
        for (final File file : $receiver) {
            final String name;
            final String s = name = file.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case 1472: {
                        if (s.equals("..")) {
                            if (!list.isEmpty() && (Intrinsics.areEqual((Object)((File)CollectionsKt.last(list)).getName(), (Object)"..") ^ true)) {
                                list.remove(list.size() - 1);
                            }
                            else {
                                list.add(file);
                            }
                            continue;
                        }
                        break;
                    }
                    case 46: {
                        if (s.equals(".")) {
                            continue;
                        }
                        break;
                    }
                }
            }
            list.add(file);
        }
        return list;
    }
    
    @NotNull
    public static final File resolve(@NotNull final File $receiver, @NotNull final File relative) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)relative, "relative");
        if (FilesKt.isRooted(relative)) {
            return relative;
        }
        final String baseName = $receiver.toString();
        return (baseName.length() == 0 || StringsKt.endsWith$default((CharSequence)baseName, File.separatorChar, false, 2, (Object)null)) ? new File(baseName + relative) : new File(baseName + File.separatorChar + relative);
    }
    
    @NotNull
    public static final File resolve(@NotNull final File $receiver, @NotNull final String relative) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)relative, "relative");
        return FilesKt.resolve($receiver, new File(relative));
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File $receiver, @NotNull final File relative) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)relative, "relative");
        final FilePathComponents components = FilesKt.toComponents($receiver);
        final File parentSubPath = (components.getSize() == 0) ? new File("..") : components.subPath(0, components.getSize() - 1);
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), parentSubPath), relative);
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File $receiver, @NotNull final String relative) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)relative, "relative");
        return FilesKt.resolveSibling($receiver, new File(relative));
    }
    
    public FilesKt__UtilsKt() {
    }
}
