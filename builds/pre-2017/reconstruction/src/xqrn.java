/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class xqrn
implements IExtendedEntityProperties {
    public static final String _a = "ItemAnimationHandler";
    private EntityItem _c;
    public ogej _b;

    public xqrn(EntityItem entityItem, anoq anoq2) {
        this._c = entityItem;
        anoq anoq3 = anoq2;
        this._b = new ogej(anoq2._f((ItemStack)entityItem.getEntityItem())._a, new hsnd[0]);
        this._b._b(new jytp(new nuco(), "idle_ground")._a(gpnw._c));
    }

    @Override
    public void saveNBTData(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void loadNBTData(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void init(Entity entity, World world) {
    }

    public void _a() {
        this._b._b();
    }

    public static xqrn _a(EntityItem entityItem) {
        anoq anoq2;
        xqrn xqrn2 = (xqrn)entityItem.extendedProperties.get(_a);
        if (xqrn2 != null) {
            return xqrn2;
        }
        ItemStack itemStack = entityItem.getEntityItem();
        if (itemStack != null && (anoq2 = anoq._a(itemStack._a())) != null && anoq2._k) {
            xqrn2 = new xqrn(entityItem, anoq2);
            entityItem.registerExtendedProperties(_a, xqrn2);
        }
        return xqrn2;
    }
}

