/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands.client;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;
import noppes.npcs.packet.PacketReplaceSounds;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

@ezey(_a={eidj.CLIENT})
public class CommandReplaceSounds
extends CommandBase {
    @Override
    public String getCommandName() {
        return "replacesounds";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/replacesounds <csv file>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 1) {
            new ofaz(new jxsn(ugqi._a, (Object)((Object)EnumChatFormatting._m) + "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0444\u0430\u0439\u043b")).processClient(false);
            return;
        }
        File file = new File(String.join((CharSequence)" ", ArrayUtils.subarray(stringArray, 0, stringArray.length - 1)));
        if (!file.exists()) {
            new ofaz(new jxsn(ugqi._a, (Object)((Object)EnumChatFormatting._m) + "\u0424\u0430\u0439\u043b " + file + " \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d")).processClient(false);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            List<String> list = IOUtils.readLines(fileInputStream);
            for (String string : list) {
                String[] stringArray2 = string.split(",");
                if (stringArray2.length > 0 && stringArray2.length < 2) {
                    hashMap.put(stringArray2[0], "");
                    continue;
                }
                if (stringArray2.length < 2) continue;
                hashMap.put(stringArray2[0], stringArray2[1]);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        new PacketReplaceSounds(hashMap).sendToServer();
    }
}

