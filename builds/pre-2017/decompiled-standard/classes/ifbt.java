/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import net.minecraftforge.client.IItemRenderer;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
public final class ifbt {
    public static final /* synthetic */ int[] _a;

    static {
        _a = new int[IItemRenderer.ItemRenderType.values().length];
        ifbt._a[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 1;
        ifbt._a[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 2;
    }
}

