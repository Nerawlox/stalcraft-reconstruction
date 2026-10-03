/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;

public class ClientCommandHandler
extends ohmz {
    public static final ClientCommandHandler instance = new ClientCommandHandler();
    public String[] latestAutoComplete = null;

    @Override
    public int func_71556_a(nemo nemo2, String string) {
        if ((string = string.trim()).startsWith("/")) {
            string = string.substring(1);
        }
        String[] stringArray = string.split(" ");
        String[] stringArray2 = new String[stringArray.length - 1];
        String string2 = stringArray[0];
        System.arraycopy(stringArray, 1, stringArray2, 0, stringArray2.length);
        kmew kmew2 = (kmew)this.func_71555_a().get(string2);
        try {
            if (kmew2 == null) {
                return 0;
            }
            if (kmew2.func_71519_b(nemo2)) {
                CommandEvent commandEvent = new CommandEvent(kmew2, nemo2, stringArray2);
                if (MinecraftForge.EVENT_BUS.post(commandEvent)) {
                    if (commandEvent.exception != null) {
                        throw commandEvent.exception;
                    }
                    return 0;
                }
                kmew2.func_71515_b(nemo2, stringArray2);
                return 1;
            }
            nemo2.func_70006_a(this.format("commands.generic.permission")._a(ezfc._m));
        }
        catch (pksd pksd2) {
            nemo2.func_70006_a(this.format("commands.generic.usage", this.format(pksd2.getMessage(), pksd2._a()))._a(ezfc._m));
        }
        catch (cekk cekk2) {
            nemo2.func_70006_a(this.format(cekk2.getMessage(), cekk2._a())._a(ezfc._m));
        }
        catch (Throwable throwable) {
            nemo2.func_70006_a(this.format("commands.generic.exception")._a(ezfc._m));
            throwable.printStackTrace();
        }
        return 0;
    }

    private zwat format(String string, Object ... objectArray) {
        return zwat._b(string, objectArray);
    }

    private zwat format(String string) {
        return zwat._e(string);
    }

    public void autoComplete(String string, String string2) {
        this.latestAutoComplete = null;
        if (string.charAt(0) == '/') {
            List list;
            string = string.substring(1);
            xpzm xpzm2 = FMLClientHandler.instance().getClient();
            if (xpzm2._B instanceof fndz && (list = this.func_71558_b(xpzm2._t, string)) != null && !list.isEmpty()) {
                if (string.indexOf(32) == -1) {
                    for (int i = 0; i < list.size(); ++i) {
                        list.set(i, (Object)((Object)ezfc._h) + "/" + (String)list.get(i) + (Object)((Object)ezfc._v));
                    }
                } else {
                    for (int i = 0; i < list.size(); ++i) {
                        list.set(i, (Object)((Object)ezfc._h) + (String)list.get(i) + (Object)((Object)ezfc._v));
                    }
                }
                this.latestAutoComplete = list.toArray(new String[list.size()]);
            }
        }
    }
}

