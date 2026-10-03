/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Type;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class einh
extends qlgf {
    public int _b;
    public double _c;
    public double _d;
    public double _e;

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public einh(Entity entity) {
        this(entity.dimension, entity.posX, entity.posY, entity.posZ);
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public einh(World world, double d, double d2, double d3) {
        this(world.provider._i, d, d2, d3);
    }

    public einh(NBTTagCompound nBTTagCompound) {
        this(nBTTagCompound._f("dim"), nBTTagCompound._i("x"), nBTTagCompound._i("y"), nBTTagCompound._i("z"));
    }

    public einh(int n, double d, double d2, double d3) {
        this._b = n;
        this._c = d;
        this._d = d2;
        this._e = d3;
    }

    public int _c() {
        return einh._a(this._c);
    }

    public int _d() {
        return einh._a(this._d);
    }

    public int _e() {
        return einh._a(this._e);
    }

    private static int _a(double d) {
        int n = (int)d;
        return d < (double)n ? n - 1 : n;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public Vec3 _f() {
        return Vec3._a(this._c, this._d, this._e);
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public int _g() {
        World world = this._i();
        if (world != null) {
            return world.getBlockId(this._c(), this._d(), this._e());
        }
        return 0;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public TileEntity _h() {
        World world = this._i();
        if (world != null) {
            return world.getBlockTileEntity(this._c(), this._d(), this._e());
        }
        return null;
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public World _i() {
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
            return InvokeWithResult.client(() -> this._j());
        }
        return InvokeWithResult.frontend(() -> null);
    }

    public long _a(einh einh2) {
        int n = Math.abs(this._c() - einh2._c()) + 1;
        int n2 = Math.abs(this._d() - einh2._d()) + 1;
        int n3 = Math.abs(this._e() - einh2._e()) + 1;
        long l = (long)n * (long)n2 * (long)n3;
        return l;
    }

    @ezey(_a={eidj.CLIENT})
    public World _j() {
        if (this._b == Minecraft._E()._r.provider._i) {
            return Minecraft._E()._r;
        }
        return null;
    }

    public einh _k() {
        return new einh(this._b, (double)this._c(), (double)this._d(), (double)this._e());
    }

    public einh _b(einh einh2) {
        return new einh(this._b, Math.min(this._c, einh2._c), Math.min(this._d, einh2._d), Math.min(this._e, einh2._e));
    }

    public einh _c(einh einh2) {
        return new einh(this._b, Math.max(this._c, einh2._c), Math.max(this._d, einh2._d), Math.max(this._e, einh2._e));
    }

    public NBTTagCompound _a() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("x", this._c);
        nBTTagCompound._a("y", this._d);
        nBTTagCompound._a("z", this._e);
        nBTTagCompound._a("dim", this._b);
        return nBTTagCompound;
    }

    public String toString() {
        return "LocalLocation{dim=" + this._b + ", x=" + this._c + ", y=" + this._d + ", z=" + this._e + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        einh einh2 = (einh)object;
        if (this._b != einh2._b) {
            return false;
        }
        if (Double.compare(einh2._c, this._c) != 0) {
            return false;
        }
        if (Double.compare(einh2._d, this._d) != 0) {
            return false;
        }
        return Double.compare(einh2._e, this._e) == 0;
    }

    public int hashCode() {
        int n = this._b;
        long l = Double.doubleToLongBits(this._c);
        n = 31 * n + (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(this._d);
        n = 31 * n + (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(this._e);
        n = 31 * n + (int)(l ^ l >>> 32);
        return n;
    }

    public einh() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = dataInput.readInt();
        this._c = dataInput.readDouble();
        this._d = dataInput.readDouble();
        this._e = dataInput.readDouble();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._b);
        dataOutput.writeDouble(this._c);
        dataOutput.writeDouble(this._d);
        dataOutput.writeDouble(this._e);
    }

    static class kjui
    implements JsonDeserializer<einh> {
        kjui() {
        }

        public einh _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonArray jsonArray;
            int n = 0;
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                jsonArray = jsonObject.getAsJsonArray("pos");
                if (jsonObject.has("dimension")) {
                    n = jsonObject.get("dimension").getAsInt();
                }
            }
            return new einh(n, jsonArray.get(0).getAsDouble(), jsonArray.get(1).getAsDouble(), jsonArray.get(2).getAsDouble());
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

