/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.constants;

public enum EnumPlayerPacket {
    FollowerHire("FollowerHire", 0),
    FollowerExtend("FollowerExtend", 1),
    Trader("Trader", 2),
    FollowerState("FollowerState", 3),
    Transport("Transport", 4),
    BankUnlock("BankUnlock", 5),
    BankUpgrade("BankUpgrade", 6),
    Dialog("Dialog", 7),
    QuestLog("QuestLog", 8),
    AdvancedQuestLog("QuestLog", 18),
    CompletedQuestLog("FullQuestLog", 17),
    QuestCompletion("QuestCompletion", 9),
    CheckQuestCompletion("CheckQuestCompletion", 10),
    BankSlotOpen("BankSlotOpen", 11),
    FactionsGet("FactionsGet", 12),
    MailGet("MailGet", 13),
    MailDelete("MailDelete", 14),
    MailSend("MailSend", 15),
    MailRead("MailRead", 16),
    ProbeItem("ProbeItem", 17),
    CloseDialog("CloseDialog", 18);

    private static final EnumPlayerPacket[] $VALUES;

    private EnumPlayerPacket(String string2, int n2) {
    }

    static {
        $VALUES = new EnumPlayerPacket[]{FollowerHire, FollowerExtend, Trader, FollowerState, Transport, BankUnlock, BankUpgrade, Dialog, QuestLog, QuestCompletion, CheckQuestCompletion, BankSlotOpen, FactionsGet, MailGet, MailDelete, MailSend, MailRead};
    }
}

