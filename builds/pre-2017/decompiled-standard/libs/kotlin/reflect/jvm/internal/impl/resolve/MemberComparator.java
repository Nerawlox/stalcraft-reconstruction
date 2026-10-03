/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class MemberComparator
implements Comparator<DeclarationDescriptor> {
    public static final MemberComparator INSTANCE = new MemberComparator();
    private static final DescriptorRenderer RENDERER = DescriptorRenderer.Companion.withOptions((Function1<? super DescriptorRendererOptions, Unit>)new Function1<DescriptorRendererOptions, Unit>(){

        @Override
        public Unit invoke(DescriptorRendererOptions options) {
            options.setWithDefinedIn(false);
            options.setVerbose(true);
            options.setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            options.setModifiers(DescriptorRendererModifier.ALL);
            return Unit.INSTANCE;
        }
    });

    private MemberComparator() {
    }

    private static int getDeclarationPriority(DeclarationDescriptor descriptor2) {
        if (DescriptorUtils.isEnumEntry(descriptor2)) {
            return 8;
        }
        if (descriptor2 instanceof ConstructorDescriptor) {
            return 7;
        }
        if (descriptor2 instanceof PropertyDescriptor) {
            if (((PropertyDescriptor)descriptor2).getExtensionReceiverParameter() == null) {
                return 6;
            }
            return 5;
        }
        if (descriptor2 instanceof FunctionDescriptor) {
            if (((FunctionDescriptor)descriptor2).getExtensionReceiverParameter() == null) {
                return 4;
            }
            return 3;
        }
        if (descriptor2 instanceof ClassDescriptor) {
            return 2;
        }
        if (descriptor2 instanceof TypeAliasDescriptor) {
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(DeclarationDescriptor o1, DeclarationDescriptor o2) {
        int renderDiff;
        int prioritiesCompareTo = MemberComparator.getDeclarationPriority(o2) - MemberComparator.getDeclarationPriority(o1);
        if (prioritiesCompareTo != 0) {
            return prioritiesCompareTo;
        }
        if (DescriptorUtils.isEnumEntry(o1) && DescriptorUtils.isEnumEntry(o2)) {
            return 0;
        }
        int namesCompareTo = o1.getName().compareTo(o2.getName());
        if (namesCompareTo != 0) {
            return namesCompareTo;
        }
        if (o1 instanceof TypeAliasDescriptor && o2 instanceof TypeAliasDescriptor) {
            String r2;
            TypeAliasDescriptor ta1 = (TypeAliasDescriptor)o1;
            TypeAliasDescriptor ta2 = (TypeAliasDescriptor)o2;
            String r1 = RENDERER.renderType(ta1.getUnderlyingType());
            int underlyingTypesCompareTo = r1.compareTo(r2 = RENDERER.renderType(ta2.getUnderlyingType()));
            if (underlyingTypesCompareTo != 0) {
                return underlyingTypesCompareTo;
            }
        } else if (o1 instanceof CallableDescriptor && o2 instanceof CallableDescriptor) {
            String r2;
            String r1;
            int receiversCompareTo;
            CallableDescriptor c1 = (CallableDescriptor)o1;
            CallableDescriptor c2 = (CallableDescriptor)o2;
            ReceiverParameterDescriptor c1ReceiverParameter = c1.getExtensionReceiverParameter();
            ReceiverParameterDescriptor c2ReceiverParameter = c2.getExtensionReceiverParameter();
            assert (c1ReceiverParameter != null == (c2ReceiverParameter != null));
            if (c1ReceiverParameter != null && (receiversCompareTo = (r1 = RENDERER.renderType(c1ReceiverParameter.getType())).compareTo(r2 = RENDERER.renderType(c2ReceiverParameter.getType()))) != 0) {
                return receiversCompareTo;
            }
            List<ValueParameterDescriptor> c1ValueParameters = c1.getValueParameters();
            List<ValueParameterDescriptor> c2ValueParameters = c2.getValueParameters();
            for (int i = 0; i < Math.min(c1ValueParameters.size(), c2ValueParameters.size()); ++i) {
                String p2;
                String p1 = RENDERER.renderType(c1ValueParameters.get(i).getType());
                int parametersCompareTo = p1.compareTo(p2 = RENDERER.renderType(c2ValueParameters.get(i).getType()));
                if (parametersCompareTo == 0) continue;
                return parametersCompareTo;
            }
            int valueParametersNumberCompareTo = c1ValueParameters.size() - c2ValueParameters.size();
            if (valueParametersNumberCompareTo != 0) {
                return valueParametersNumberCompareTo;
            }
            List<TypeParameterDescriptor> c1TypeParameters = c1.getTypeParameters();
            List<TypeParameterDescriptor> c2TypeParameters = c2.getTypeParameters();
            for (int i = 0; i < Math.min(c1TypeParameters.size(), c2TypeParameters.size()); ++i) {
                List<KotlinType> c1Bounds = c1TypeParameters.get(i).getUpperBounds();
                List<KotlinType> c2Bounds = c2TypeParameters.get(i).getUpperBounds();
                int boundsCountCompareTo = c1Bounds.size() - c2Bounds.size();
                if (boundsCountCompareTo != 0) {
                    return boundsCountCompareTo;
                }
                for (int j = 0; j < c1Bounds.size(); ++j) {
                    String b2;
                    String b1 = RENDERER.renderType(c1Bounds.get(j));
                    int boundCompareTo = b1.compareTo(b2 = RENDERER.renderType(c2Bounds.get(j)));
                    if (boundCompareTo == 0) continue;
                    return boundCompareTo;
                }
            }
            int typeParametersCompareTo = c1TypeParameters.size() - c2TypeParameters.size();
            if (typeParametersCompareTo != 0) {
                return typeParametersCompareTo;
            }
            if (c1 instanceof CallableMemberDescriptor && c2 instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor.Kind c1Kind = ((CallableMemberDescriptor)c1).getKind();
                CallableMemberDescriptor.Kind c2Kind = ((CallableMemberDescriptor)c2).getKind();
                int kindsCompareTo = c1Kind.ordinal() - c2Kind.ordinal();
                if (kindsCompareTo != 0) {
                    return kindsCompareTo;
                }
            }
        } else if (o1 instanceof ClassDescriptor && o2 instanceof ClassDescriptor) {
            ClassDescriptor class1 = (ClassDescriptor)o1;
            ClassDescriptor class2 = (ClassDescriptor)o2;
            if (class1.getKind().ordinal() != class2.getKind().ordinal()) {
                return class1.getKind().ordinal() - class2.getKind().ordinal();
            }
            if (class1.isCompanionObject() != class2.isCompanionObject()) {
                return class1.isCompanionObject() ? 1 : -1;
            }
        } else {
            throw new AssertionError((Object)String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", o1, o1.getClass(), o2, o2.getClass()));
        }
        if ((renderDiff = RENDERER.render(o1).compareTo(RENDERER.render(o2))) != 0) {
            return renderDiff;
        }
        Name firstModuleName = DescriptorUtils.getContainingModule(o1).getName();
        Name secondModuleName = DescriptorUtils.getContainingModule(o2).getName();
        return firstModuleName.compareTo(secondModuleName);
    }
}

