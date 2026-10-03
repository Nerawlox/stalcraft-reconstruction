/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@SideOnly(value=Side.CLIENT)
public abstract class bas {
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("{");
        for (Field field : this.getClass().getFields()) {
            if (bas.a(field)) continue;
            try {
                stringbuilder.append(field.getName()).append("=").append(field.get(this)).append(" ");
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        stringbuilder.deleteCharAt(stringbuilder.length() - 1);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    private static boolean a(Field par0Field) {
        return Modifier.isStatic(par0Field.getModifiers());
    }
}

