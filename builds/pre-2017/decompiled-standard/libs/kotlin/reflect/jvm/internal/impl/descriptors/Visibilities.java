/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Visibilities {
    @NotNull
    public static final Visibility PRIVATE = new Visibility("private", false){

        @Override
        public boolean mustCheckInImports() {
            return true;
        }

        private boolean inSameFile(@NotNull DeclarationDescriptor what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "inSameFile"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "inSameFile"));
            }
            SourceFile fromContainingFile = DescriptorUtils.getContainingSourceFile(from);
            if (fromContainingFile != SourceFile.NO_SOURCE_FILE) {
                return fromContainingFile.equals(DescriptorUtils.getContainingSourceFile(what));
            }
            return false;
        }

        private boolean hasContainingSourceFile(@NotNull DeclarationDescriptor descriptor2) {
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "hasContainingSourceFile"));
            }
            return DescriptorUtils.getContainingSourceFile(descriptor2) != SourceFile.NO_SOURCE_FILE;
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            ClassifierDescriptorWithTypeParameters classDescriptor;
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1", "isVisible"));
            }
            if (DescriptorUtils.isTopLevelDeclaration(what) && this.hasContainingSourceFile(from)) {
                return this.inSameFile(what, from);
            }
            if (what instanceof ConstructorDescriptor && DescriptorUtils.isSealedClass(classDescriptor = ((ConstructorDescriptor)what).getContainingDeclaration()) && DescriptorUtils.isTopLevelDeclaration(classDescriptor) && from instanceof ConstructorDescriptor && DescriptorUtils.isTopLevelDeclaration(from.getContainingDeclaration()) && this.inSameFile(what, from)) {
                return true;
            }
            DeclarationDescriptor parent = what;
            while (!(parent == null || (parent = parent.getContainingDeclaration()) instanceof ClassDescriptor && !DescriptorUtils.isCompanionObject(parent) || parent instanceof PackageFragmentDescriptor)) {
            }
            if (parent == null) {
                return false;
            }
            for (DeclarationDescriptor fromParent = from; fromParent != null; fromParent = fromParent.getContainingDeclaration()) {
                if (parent == fromParent) {
                    return true;
                }
                if (!(fromParent instanceof PackageFragmentDescriptor)) continue;
                return parent instanceof PackageFragmentDescriptor && ((PackageFragmentDescriptor)parent).getFqName().equals(((PackageFragmentDescriptor)fromParent).getFqName()) && DescriptorUtils.areInSameModule(fromParent, parent);
            }
            return false;
        }
    };
    @NotNull
    public static final Visibility PRIVATE_TO_THIS = new Visibility("private_to_this", false){

        @Override
        public boolean isVisible(@Nullable ReceiverValue thisObject, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2", "isVisible"));
            }
            if (PRIVATE.isVisible(thisObject, what, from)) {
                if (thisObject == ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (thisObject == IRRELEVANT_RECEIVER) {
                    return false;
                }
                ClassDescriptor classDescriptor = DescriptorUtils.getParentOfType(what, ClassDescriptor.class);
                if (classDescriptor != null && thisObject instanceof ThisClassReceiver) {
                    return ((ThisClassReceiver)thisObject).getClassDescriptor().getOriginal().equals(classDescriptor.getOriginal());
                }
            }
            return false;
        }

        @Override
        public boolean mustCheckInImports() {
            return true;
        }

        @Override
        @NotNull
        public String getDisplayName() {
            if ("private/*private to this*/" == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2", "getDisplayName"));
            }
            return "private/*private to this*/";
        }
    };
    @NotNull
    public static final Visibility PROTECTED = new Visibility("protected", true){

        @Override
        public boolean mustCheckInImports() {
            return false;
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            ClassDescriptor companionOwner;
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "isVisible"));
            }
            ClassDescriptor givenDescriptorContainingClass = DescriptorUtils.getParentOfType(what, ClassDescriptor.class);
            ClassDescriptor fromClass = DescriptorUtils.getParentOfType(from, ClassDescriptor.class, false);
            if (fromClass == null) {
                return false;
            }
            if (givenDescriptorContainingClass != null && DescriptorUtils.isCompanionObject(givenDescriptorContainingClass) && (companionOwner = DescriptorUtils.getParentOfType(givenDescriptorContainingClass, ClassDescriptor.class)) != null && DescriptorUtils.isSubclass(fromClass, companionOwner)) {
                return true;
            }
            DeclarationDescriptorWithVisibility whatDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(what);
            ClassDescriptor classDescriptor = DescriptorUtils.getParentOfType(whatDeclaration, ClassDescriptor.class);
            if (classDescriptor == null) {
                return false;
            }
            if (DescriptorUtils.isSubclass(fromClass, classDescriptor) && this.doesReceiverFitForProtectedVisibility(receiver, whatDeclaration, fromClass)) {
                return true;
            }
            return this.isVisible(receiver, what, fromClass.getContainingDeclaration());
        }

        private boolean doesReceiverFitForProtectedVisibility(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility whatDeclaration, @NotNull ClassDescriptor fromClass) {
            if (whatDeclaration == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "whatDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "doesReceiverFitForProtectedVisibility"));
            }
            if (fromClass == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromClass", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3", "doesReceiverFitForProtectedVisibility"));
            }
            if (receiver == FALSE_IF_PROTECTED) {
                return false;
            }
            if (!(whatDeclaration instanceof CallableMemberDescriptor)) {
                return true;
            }
            if (whatDeclaration instanceof ConstructorDescriptor) {
                return true;
            }
            if (receiver == ALWAYS_SUITABLE_RECEIVER) {
                return true;
            }
            if (receiver == IRRELEVANT_RECEIVER || receiver == null) {
                return false;
            }
            KotlinType actualReceiverType = receiver instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue)receiver).getThisType() : receiver.getType();
            return DescriptorUtils.isSubtypeOfClass(actualReceiverType, fromClass) || DynamicTypesKt.isDynamic(actualReceiverType);
        }
    };
    @NotNull
    public static final Visibility INTERNAL = new Visibility("internal", false){

        @Override
        public boolean mustCheckInImports() {
            return true;
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            DeclarationDescriptor fromOrModule;
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4", "isVisible"));
            }
            DeclarationDescriptor declarationDescriptor = fromOrModule = from instanceof PackageViewDescriptor ? ((PackageViewDescriptor)from).getModule() : from;
            if (!DescriptorUtils.getContainingModule(fromOrModule).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(what))) {
                return false;
            }
            return MODULE_VISIBILITY_HELPER.isInFriendModule(what, from);
        }
    };
    @NotNull
    public static final Visibility PUBLIC = new Visibility("public", true){

        @Override
        public boolean mustCheckInImports() {
            return false;
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5", "isVisible"));
            }
            return true;
        }
    };
    @NotNull
    public static final Visibility LOCAL = new Visibility("local", false){

        @Override
        public boolean mustCheckInImports() {
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6", "isVisible"));
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    };
    @NotNull
    public static final Visibility INHERITED = new Visibility("inherited", false){

        @Override
        public boolean mustCheckInImports() {
            throw new IllegalStateException("This method shouldn't be invoked for INHERITED visibility");
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7", "isVisible"));
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    @NotNull
    public static final Visibility INVISIBLE_FAKE = new Visibility("invisible_fake", false){

        @Override
        public boolean mustCheckInImports() {
            throw new IllegalStateException("This method shouldn't be invoked for INVISIBLE_FAKE visibility");
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8", "isVisible"));
            }
            return false;
        }
    };
    @NotNull
    public static final Visibility UNKNOWN = new Visibility("unknown", false){

        @Override
        public boolean mustCheckInImports() {
            throw new IllegalStateException("This method shouldn't be invoked for UNKNOWN visibility");
        }

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9", "isVisible"));
            }
            return false;
        }
    };
    public static final Set<Visibility> INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new Visibility[]{PRIVATE, PRIVATE_TO_THIS, INTERNAL, LOCAL}));
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;
    public static final Visibility DEFAULT_VISIBILITY;
    private static final ReceiverValue IRRELEVANT_RECEIVER;
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED;
    @NotNull
    private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;

    private Visibilities() {
    }

    public static boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        if (what == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisible"));
        }
        if (from == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisible"));
        }
        return Visibilities.findInvisibleMember(receiver, what, from) == null;
    }

    public static boolean isVisibleIgnoringReceiver(@NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        if (what == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleIgnoringReceiver"));
        }
        if (from == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleIgnoringReceiver"));
        }
        return Visibilities.findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, what, from) == null;
    }

    public static boolean isVisibleWithAnyReceiver(@NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        if (what == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleWithAnyReceiver"));
        }
        if (from == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isVisibleWithAnyReceiver"));
        }
        return Visibilities.findInvisibleMember(IRRELEVANT_RECEIVER, what, from) == null;
    }

    @Nullable
    public static DeclarationDescriptorWithVisibility findInvisibleMember(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        DeclarationDescriptorWithVisibility invisibleUnderlying;
        if (what == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "findInvisibleMember"));
        }
        if (from == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "findInvisibleMember"));
        }
        DeclarationDescriptorWithVisibility parent = (DeclarationDescriptorWithVisibility)what.getOriginal();
        while (parent != null && parent.getVisibility() != LOCAL) {
            if (!parent.getVisibility().isVisible(receiver, parent, from)) {
                return parent;
            }
            parent = DescriptorUtils.getParentOfType(parent, DeclarationDescriptorWithVisibility.class);
        }
        if (what instanceof TypeAliasConstructorDescriptor && (invisibleUnderlying = Visibilities.findInvisibleMember(receiver, ((TypeAliasConstructorDescriptor)what).getUnderlyingConstructorDescriptor(), from)) != null) {
            return invisibleUnderlying;
        }
        return null;
    }

    @Nullable
    static Integer compareLocal(@NotNull Visibility first, @NotNull Visibility second) {
        if (first == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "first", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compareLocal"));
        }
        if (second == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "second", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compareLocal"));
        }
        if (first == second) {
            return 0;
        }
        Integer firstIndex = ORDERED_VISIBILITIES.get(first);
        Integer secondIndex = ORDERED_VISIBILITIES.get(second);
        if (firstIndex == null || secondIndex == null || firstIndex.equals(secondIndex)) {
            return null;
        }
        return firstIndex - secondIndex;
    }

    @Nullable
    public static Integer compare(@NotNull Visibility first, @NotNull Visibility second) {
        if (first == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "first", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compare"));
        }
        if (second == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "second", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "compare"));
        }
        Integer result2 = first.compareTo(second);
        if (result2 != null) {
            return result2;
        }
        Integer oppositeResult = second.compareTo(first);
        if (oppositeResult != null) {
            return -oppositeResult.intValue();
        }
        return null;
    }

    public static boolean isPrivate(@NotNull Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities", "isPrivate"));
        }
        return visibility == PRIVATE || visibility == PRIVATE_TO_THIS;
    }

    static {
        HashMap<Visibility, Integer> visibilities = CollectionsKt.newHashMapWithExpectedSize(4);
        visibilities.put(PRIVATE_TO_THIS, 0);
        visibilities.put(PRIVATE, 0);
        visibilities.put(INTERNAL, 1);
        visibilities.put(PROTECTED, 1);
        visibilities.put(PUBLIC, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(visibilities);
        DEFAULT_VISIBILITY = PUBLIC;
        IRRELEVANT_RECEIVER = new ReceiverValue(){

            @Override
            @NotNull
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        ALWAYS_SUITABLE_RECEIVER = new ReceiverValue(){

            @Override
            @NotNull
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        FALSE_IF_PROTECTED = new ReceiverValue(){

            @Override
            @NotNull
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        Iterator<ModuleVisibilityHelper> iterator2 = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        MODULE_VISIBILITY_HELPER = iterator2.hasNext() ? iterator2.next() : ModuleVisibilityHelper.EMPTY.INSTANCE;
    }
}

