/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Type;

public class gotk
extends einh {
    public String _a;

    public gotk(String string, einh einh2) {
        super(einh2._b, einh2._c, einh2._d, einh2._e);
        this._a = string;
    }

    public gotk(qoac qoac2) {
        super(qoac2);
        this._a = qoac2._j("server");
    }

    public gotk(String string, int n, double d, double d2, double d3) {
        super(n, d, d2, d3);
        this._a = string;
    }

    @Override
    public qoac _a() {
        qoac qoac2 = super._a();
        qoac2._a("server", this._a);
        return qoac2;
    }

    public einh _b() {
        return new einh(this._b, this._c, this._d, this._e);
    }

    @Override
    public String toString() {
        return "GlobalLocation{locationName='" + this._a + '\'' + ", dim=" + this._b + ", x=" + this._c + ", y=" + this._d + ", z=" + this._e + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        gotk gotk2 = (gotk)object;
        return this._a != null ? this._a.equals(gotk2._a) : gotk2._a == null;
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this._a != null ? this._a.hashCode() : 0);
        return n;
    }

    public gotk() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._a);
    }

    static class kjui
    implements JsonDeserializer<gotk> {
        kjui() {
        }

        public gotk _a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            einh einh2 = (einh)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)einh.class));
            return new gotk(jsonElement.getAsJsonObject().get("location").getAsString(), einh2);
        }

        @Override
        public /* synthetic */ Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return this._a(jsonElement, type, jsonDeserializationContext);
        }
    }
}

