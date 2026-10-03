/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.shop.ShopMod;
import gloomyfolken.mods.shop.data.CaseData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.client.xpzm;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class hsso
extends zwat {
    public String _a;

    public hsso(CaseData caseData) {
        this._a = ShopMod._a.toJson(caseData);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] byArray = this._a.getBytes(Charsets.UTF_8);
        gZIPOutputStream.write(byArray);
        gZIPOutputStream.close();
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        dataOutput.writeInt(byteArrayOutputStream.size());
        dataOutput.writeInt(byArray.length);
        dataOutput.write(byArray2);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        int n2 = dataInput.readInt();
        byte[] byArray = new byte[n];
        byte[] byArray2 = new byte[n2];
        dataInput.readFully(byArray);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        IOUtils.readFully(gZIPInputStream, byArray2);
        gZIPInputStream.close();
        byteArrayInputStream.close();
        this._a = new String(byArray2, Charsets.UTF_8);
    }

    @Override
    public void processClient(boolean bl) {
        CaseData caseData = ShopMod._a.fromJson(this._a, CaseData.class);
        ShopMod._a(caseData);
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B instanceof kjui) {
            ((kjui)((Object)xpzm2._B))._a(caseData);
        }
    }

    public hsso() {
    }

    public static interface kjui {
        public void _a(CaseData var1);
    }
}

