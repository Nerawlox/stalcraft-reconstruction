/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReadKotlinClassHeaderAnnotationVisitor
implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final boolean IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS = new HashMap<ClassId, KotlinClassHeader.Kind>();
    private JvmMetadataVersion metadataVersion = null;
    private JvmBytecodeBinaryVersion bytecodeVersion = null;
    private String extraString = null;
    private int extraInt = 0;
    private String[] data = null;
    private String[] strings = null;
    private String[] incompatibleData = null;
    private KotlinClassHeader.Kind headerKind = null;

    @Nullable
    public KotlinClassHeader createHeader() {
        if (this.headerKind == null) {
            return null;
        }
        if (!this.metadataVersion.isCompatible()) {
            this.incompatibleData = this.data;
        }
        if (this.metadataVersion == null || !this.metadataVersion.isCompatible()) {
            this.data = null;
        } else if (this.shouldHaveData() && this.data == null) {
            return null;
        }
        return new KotlinClassHeader(this.headerKind, this.metadataVersion != null ? this.metadataVersion : JvmMetadataVersion.INVALID_VERSION, this.bytecodeVersion != null ? this.bytecodeVersion : JvmBytecodeBinaryVersion.INVALID_VERSION, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt);
    }

    private boolean shouldHaveData() {
        return this.headerKind == KotlinClassHeader.Kind.CLASS || this.headerKind == KotlinClassHeader.Kind.FILE_FACADE || this.headerKind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement source) {
        if (classId == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor", "visitAnnotation"));
        }
        FqName fqName2 = classId.asSingleFqName();
        if (fqName2.equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor();
        }
        if (IGNORE_OLD_METADATA) {
            return null;
        }
        if (this.headerKind != null) {
            return null;
        }
        KotlinClassHeader.Kind newKind = HEADER_KINDS.get(classId);
        if (newKind != null) {
            this.headerKind = newKind;
            return new OldDeprecatedAnnotationArgumentVisitor();
        }
        return null;
    }

    @Override
    public void visitEnd() {
    }

    static /* synthetic */ String[] access$702(ReadKotlinClassHeaderAnnotationVisitor x0, String[] x1) {
        x0.data = x1;
        return x1;
    }

    static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor x0, String[] x1) {
        x0.strings = x1;
        return x1;
    }

    static {
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static abstract class CollectStringArrayAnnotationVisitor
    implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings = new ArrayList<String>();

        @Override
        public void visit(@Nullable Object value) {
            if (value instanceof String) {
                this.strings.add((String)value);
            }
        }

        @Override
        public void visitEnum(@NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (enumClassId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor", "visitEnum"));
            }
            if (enumEntryName == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor", "visitEnum"));
            }
        }

        @Override
        public void visitEnd() {
            this.visitEnd(this.strings.toArray(new String[this.strings.size()]));
        }

        protected abstract void visitEnd(@NotNull String[] var1);
    }

    private class OldDeprecatedAnnotationArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private OldDeprecatedAnnotationArgumentVisitor() {
        }

        @Override
        public void visit(@Nullable Name name2, @Nullable Object value) {
            if (name2 == null) {
                return;
            }
            String string = name2.asString();
            if ("version".equals(string)) {
                if (value instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersion = new JvmMetadataVersion((int[])value);
                    if (ReadKotlinClassHeaderAnnotationVisitor.this.bytecodeVersion == null) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.bytecodeVersion = new JvmBytecodeBinaryVersion((int[])value);
                    }
                }
            } else if ("multifileClassName".equals(string)) {
                ReadKotlinClassHeaderAnnotationVisitor.this.extraString = value instanceof String ? (String)value : null;
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name2) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitArray"));
            }
            String string = name2.asString();
            if ("data".equals(string) || "filePartClassNames".equals(string)) {
                return this.dataArrayVisitor();
            }
            if ("strings".equals(string)) {
                return this.stringsArrayVisitor();
            }
            return null;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            CollectStringArrayAnnotationVisitor collectStringArrayAnnotationVisitor = new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] data2) {
                    if (data2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$702(ReadKotlinClassHeaderAnnotationVisitor.this, data2);
                }
            };
            if (collectStringArrayAnnotationVisitor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "dataArrayVisitor"));
            }
            return collectStringArrayAnnotationVisitor;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            CollectStringArrayAnnotationVisitor collectStringArrayAnnotationVisitor = new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] data2) {
                    if (data2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$802(ReadKotlinClassHeaderAnnotationVisitor.this, data2);
                }
            };
            if (collectStringArrayAnnotationVisitor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "stringsArrayVisitor"));
            }
            return collectStringArrayAnnotationVisitor;
        }

        @Override
        public void visitEnum(@NotNull Name name2, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"));
            }
            if (enumClassId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"));
            }
            if (enumEntryName == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitEnum"));
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name2, @NotNull ClassId classId) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitAnnotation"));
            }
            if (classId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor", "visitAnnotation"));
            }
            return null;
        }

        @Override
        public void visitEnd() {
        }
    }

    private class KotlinMetadataArgumentVisitor
    implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private KotlinMetadataArgumentVisitor() {
        }

        @Override
        public void visit(@Nullable Name name2, @Nullable Object value) {
            if (name2 == null) {
                return;
            }
            String string = name2.asString();
            if ("k".equals(string)) {
                if (value instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = KotlinClassHeader.Kind.getById((Integer)value);
                }
            } else if ("mv".equals(string)) {
                if (value instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersion = new JvmMetadataVersion((int[])value);
                }
            } else if ("bv".equals(string)) {
                if (value instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.bytecodeVersion = new JvmBytecodeBinaryVersion((int[])value);
                }
            } else if ("xs".equals(string)) {
                if (value instanceof String) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraString = (String)value;
                }
            } else if ("xi".equals(string) && value instanceof Integer) {
                ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = (Integer)value;
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name name2) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitArray"));
            }
            String string = name2.asString();
            if ("d1".equals(string)) {
                return this.dataArrayVisitor();
            }
            if ("d2".equals(string)) {
                return this.stringsArrayVisitor();
            }
            return null;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            CollectStringArrayAnnotationVisitor collectStringArrayAnnotationVisitor = new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] result2) {
                    if (result2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$702(ReadKotlinClassHeaderAnnotationVisitor.this, result2);
                }
            };
            if (collectStringArrayAnnotationVisitor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "dataArrayVisitor"));
            }
            return collectStringArrayAnnotationVisitor;
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            CollectStringArrayAnnotationVisitor collectStringArrayAnnotationVisitor = new CollectStringArrayAnnotationVisitor(){

                @Override
                protected void visitEnd(@NotNull String[] result2) {
                    if (result2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
                    }
                    ReadKotlinClassHeaderAnnotationVisitor.access$802(ReadKotlinClassHeaderAnnotationVisitor.this, result2);
                }
            };
            if (collectStringArrayAnnotationVisitor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "stringsArrayVisitor"));
            }
            return collectStringArrayAnnotationVisitor;
        }

        @Override
        public void visitEnum(@NotNull Name name2, @NotNull ClassId enumClassId, @NotNull Name enumEntryName) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"));
            }
            if (enumClassId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClassId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"));
            }
            if (enumEntryName == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntryName", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitEnum"));
            }
        }

        @Override
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name name2, @NotNull ClassId classId) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitAnnotation"));
            }
            if (classId == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classId", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor", "visitAnnotation"));
            }
            return null;
        }

        @Override
        public void visitEnd() {
        }
    }
}

