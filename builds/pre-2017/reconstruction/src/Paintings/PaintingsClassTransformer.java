/*
 * Decompiled with CFR 0.152.
 */
package Paintings;

import java.io.InputStream;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.io.IOUtils;

public class PaintingsClassTransformer
implements IClassTransformer {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (!string2.equals("net.minecraft.util.EnumArt")) return byArray;
        try (InputStream inputStream = this.getClass().getResourceAsStream("/EnumArt.patch");){
            byte[] byArray3 = IOUtils.toByteArray(inputStream);
            System.out.println("Replacing EnumArt");
            byte[] byArray2 = byArray3;
            return byArray2;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return byArray;
    }
}

