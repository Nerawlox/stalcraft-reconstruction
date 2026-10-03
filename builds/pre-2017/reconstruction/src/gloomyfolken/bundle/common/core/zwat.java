/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.jgro;
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwaw;
import gloomyfolken.mods.physics.core.packet.PacketEntityImpulse;
import gloomyfolken.mods.physics.core.packet.PacketEntityPhysPropsInit;
import gloomyfolken.mods.physics.ragdolls.packet.PacketDeleteCorpse;
import gloomyfolken.mods.physics.ragdolls.packet.PacketOpenCorpseContainer;
import gloomyfolken.mods.physics.ragdolls.packet.PacketSearchCorpse;
import gloomyfolken.mods.stalker.mobs.packet.PacketCameraShake;
import gloomyfolken.mods.stalker.mobs.packet.PacketClientNoise;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigAdd;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigDelete;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigList;
import gloomyfolken.mods.stalker.mobs.packet.PacketConfigTest;
import gloomyfolken.mods.stalker.mobs.packet.PacketEditTileConfig;
import gloomyfolken.mods.stalker.mobs.packet.PacketNewMutantState;
import gloomyfolken.mods.stalker.mobs.packet.PacketNoiseAmount;
import gloomyfolken.mods.stalker.mobs.packet.PacketPathMark;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsAction;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsBase;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsData;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsState;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnStatistics;
import gloomyfolken.mods.stalker.mobs.packet.PacketUpdateState;
import gloomyfolken.mods.stalker.mobs.packet.event.PacketGenericEffectEvent;
import gloomyfolken.mods.stalker.mobs.packet.event.PacketVampireKissEvent;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.UUID;
import mods.pda.packet.NpcSyncPacket;
import mods.pda.packet.PacketExtraMapData;
import mods.pda.packet.PacketIgnoreAction;
import mods.pda.packet.PacketIgnoredList;
import mods.pda.packet.PacketMapTeleport;
import mods.pda.packet.RequestExtraMapData;
import mods.pda.packet.WaypointsSyncPacket;
import mods.regions.packet.PacketClearSelection;
import mods.regions.packet.PacketDisplayedRegions;
import mods.regions.packet.PacketPlayersNearby;
import mods.regions.packet.PacketPresetBlock;
import mods.regions.packet.PacketRegions;
import mods.regions.packet.PacketSelectionUpdate;
import mods.sound.packet.PacketEditSound;
import mods.sound.packet.PacketSoundData;
import mods.sound.packet.PacketSourcesData;
import noppes.npcs.NpcSynchronizer;
import noppes.npcs.packet.PacketApproveNpcRequest;
import noppes.npcs.packet.PacketBuyTradepack;
import noppes.npcs.packet.PacketConfirmedQuestCategories;
import noppes.npcs.packet.PacketDupliNpcRequest;
import noppes.npcs.packet.PacketGuideTeleportRequest;
import noppes.npcs.packet.PacketInformFactionPoints;
import noppes.npcs.packet.PacketInteractClosestNpc;
import noppes.npcs.packet.PacketLockedDialogCategories;
import noppes.npcs.packet.PacketNpcSounds;
import noppes.npcs.packet.PacketOpenApproveGui;
import noppes.npcs.packet.PacketOpenCustomGui;
import noppes.npcs.packet.PacketOpenGuide;
import noppes.npcs.packet.PacketOpenTradepacks;
import noppes.npcs.packet.PacketQuestsAvailability;
import noppes.npcs.packet.PacketRegionAvailability;
import noppes.npcs.packet.PacketReplaceSounds;
import noppes.npcs.packet.PacketSellTradepack;
import noppes.npcs.packet.PacketSetDungeons;
import noppes.npcs.packet.PacketSetOwnerNpcRequest;
import noppes.npcs.packet.PacketSortTrader;
import noppes.npcs.packet.PacketTradepackSold;
import noppes.npcs.packet.PacketUnusedCategories;
import noppes.npcs.packet.PacketUpdateEquipState;
import noppes.npcs.packet.PacketUpdateNPCFaction;
import noppes.npcs.packet.QuestLogPacket;

@jgro
@zwaw
public abstract class zwat
extends qlgf
implements ctih {
    private static UUID protocolVersion = zwat.registerProtocolVersion();

    private static void registerPersistentPackets() {
        zwat.registerPacket(mqbj.class, 1);
        zwat.registerPacket(mqar.class, 2);
    }

    private static void registerPackets() {
        zwat.registerPacket(PacketInformFactionPoints.class, 100);
        zwat.registerPacket(PacketEntityPhysPropsInit.class, 101);
        zwat.registerPacket(PacketExtraMapData.class, 102);
        zwat.registerPacket(ntaf.class, 103);
        zwat.registerPacket(PacketSpawnRegionsAction.class, 104);
        zwat.registerPacket(kldm.class, 105);
        zwat.registerPacket(zfhb.class, 106);
        zwat.registerPacket(zfdc.class, 107);
        zwat.registerPacket(jyon.class, 108);
        zwat.registerPacket(ejwv.class, 109);
        zwat.registerPacket(uguf.class, 110);
        zwat.registerPacket(sros.class, 111);
        zwat.registerPacket(tvkv.class, 112);
        zwat.registerPacket(fljj.class, 113);
        zwat.registerPacket(mqdr.class, 114);
        zwat.registerPacket(dwdm.class, 115);
        zwat.registerPacket(dfdf.class, 116);
        zwat.registerPacket(xams.class, 117);
        zwat.registerPacket(hrpq.class, 118);
        zwat.registerPacket(ezlp.class, 119);
        zwat.registerPacket(PacketSortTrader.class, 120);
        zwat.registerPacket(PacketApproveNpcRequest.class, 121);
        zwat.registerPacket(ctfo.class, 122);
        zwat.registerPacket(brks.class, 123);
        zwat.registerPacket(dggv.class, 124);
        zwat.registerPacket(qlnh.class, 125);
        zwat.registerPacket(yudo.class, 126);
        zwat.registerPacket(hsao.class, 128);
        zwat.registerPacket(twdg.class, 129);
        zwat.registerPacket(tdpf.class, 130);
        zwat.registerPacket(zxgf.class, 131);
        zwat.registerPacket(kleu.class, 132);
        zwat.registerPacket(kljg.class, 133);
        zwat.registerPacket(kjze.class, 134);
        zwat.registerPacket(ugrc.class, 135);
        zwat.registerPacket(dxrm.class, 136);
        zwat.registerPacket(tuuw.class, 137);
        zwat.registerPacket(cunq.class, 138);
        zwat.registerPacket(bqbp.class, 139);
        zwat.registerPacket(loij.class, 141);
        zwat.registerPacket(kjyw.class, 142);
        zwat.registerPacket(zfhm.class, 143);
        zwat.registerPacket(hrrp.class, 144);
        zwat.registerPacket(uhbb.class, 145);
        zwat.registerPacket(ozul.class, 146);
        zwat.registerPacket(cthk.class, 147);
        zwat.registerPacket(srot.class, 148);
        zwat.registerPacket(ncxz.class, 149);
        zwat.registerPacket(iuqq.class, 150);
        zwat.registerPacket(ctzy.class, 151);
        zwat.registerPacket(pzku.class, 152);
        zwat.registerPacket(dwdb.class, 154);
        zwat.registerPacket(rols.class, 155);
        zwat.registerPacket(PacketClearSelection.class, 156);
        zwat.registerPacket(pzmv.class, 157);
        zwat.registerPacket(PacketReplaceSounds.class, 159);
        zwat.registerPacket(PacketDupliNpcRequest.SetDuplicated.class, 160);
        zwat.registerPacket(piir.class, 161);
        zwat.registerPacket(eigw.class, 162);
        zwat.registerPacket(ncbx.class, 164);
        zwat.registerPacket(saoy.class, 165);
        zwat.registerPacket(ytcl.class, 166);
        zwat.registerPacket(amzi.class, 167);
        zwat.registerPacket(idwt.class, 168);
        zwat.registerPacket(gont.class, 169);
        zwat.registerPacket(ezhm.class, 170);
        zwat.registerPacket(iuxb.class, 171);
        zwat.registerPacket(PacketSpawnRegionsBase.class, 172);
        zwat.registerPacket(PacketSourcesData.class, 173);
        zwat.registerPacket(uxxx.class, 174);
        zwat.registerPacket(srtr.class, 175);
        zwat.registerPacket(flkj.class, 176);
        zwat.registerPacket(dfpw.class, 177);
        zwat.registerPacket(haqj.class, 178);
        zwat.registerPacket(xrat.class, 179);
        zwat.registerPacket(sanm.class, 180);
        zwat.registerPacket(htbp.class, 181);
        zwat.registerPacket(jibv.class, 182);
        zwat.registerPacket(tydk.class, 183);
        zwat.registerPacket(NpcSynchronizer.PacketDupliNpc.class, 184);
        zwat.registerPacket(PacketConfirmedQuestCategories.class, 186);
        zwat.registerPacket(pjid.class, 187);
        zwat.registerPacket(PacketSetDungeons.class, 189);
        zwat.registerPacket(kkpg.class, 190);
        zwat.registerPacket(wohx.class, 191);
        zwat.registerPacket(PacketOpenApproveGui.class, 192);
        zwat.registerPacket(gomc.class, 193);
        zwat.registerPacket(eijo.class, 194);
        zwat.registerPacket(dgtt.class, 195);
        zwat.registerPacket(fmux.class, 196);
        zwat.registerPacket(ofaz.class, 197);
        zwat.registerPacket(PacketOpenCorpseContainer.class, 198);
        zwat.registerPacket(NpcSynchronizer.PacketLastNpc.class, 199);
        zwat.registerPacket(mqbb.class, 200);
        zwat.registerPacket(ntyw.class, 201);
        zwat.registerPacket(ropb.class, 202);
        zwat.registerPacket(ofbx.class, 203);
        zwat.registerPacket(tdrl.class, 204);
        zwat.registerPacket(WaypointsSyncPacket.class, 205);
        zwat.registerPacket(ccpx.class, 206);
        zwat.registerPacket(wnsz.class, 207);
        zwat.registerPacket(vjuh.class, 208);
        zwat.registerPacket(zfeq.class, 209);
        zwat.registerPacket(hbzl.class, 210);
        zwat.registerPacket(ogta.class, 211);
        zwat.registerPacket(dwim.class, 213);
        zwat.registerPacket(PacketMapTeleport.class, 216);
        zwat.registerPacket(idpz.class, 217);
        zwat.registerPacket(braz.class, 218);
        zwat.registerPacket(PacketGuideTeleportRequest.class, 219);
        zwat.registerPacket(jiae.class, 220);
        zwat.registerPacket(owfa.class, 221);
        zwat.registerPacket(PacketOpenCustomGui.class, 222);
        zwat.registerPacket(NpcSynchronizer.PacketDupliNpcsList.class, 223);
        zwat.registerPacket(stdy.class, 224);
        zwat.registerPacket(sald.class, 227);
        zwat.registerPacket(brpi.class, 228);
        zwat.registerPacket(bano.class, 229);
        zwat.registerPacket(uxwj.class, 230);
        zwat.registerPacket(dguk.class, 231);
        zwat.registerPacket(PacketPathMark.class, 232);
        zwat.registerPacket(eiku.class, 233);
        zwat.registerPacket(twdl.class, 234);
        zwat.registerPacket(PacketDupliNpcRequest.EditNpc.class, 235);
        zwat.registerPacket(PacketPlayersNearby.class, 236);
        zwat.registerPacket(RequestExtraMapData.class, 238);
        zwat.registerPacket(ivlc.class, 239);
        zwat.registerPacket(PacketBuyTradepack.class, 240);
        zwat.registerPacket(eigm.class, 241);
        zwat.registerPacket(gloomyfolken.mods.bundle.zwat.class, 242);
        zwat.registerPacket(rpxd.class, 243);
        zwat.registerPacket(PacketConfigDelete.class, 244);
        zwat.registerPacket(bqda.class, 245);
        zwat.registerPacket(jgxr.class, 246);
        zwat.registerPacket(PacketIgnoreAction.class, 247);
        zwat.registerPacket(dgol.class, 248);
        zwat.registerPacket(PacketClientNoise.class, 249);
        zwat.registerPacket(nuna.class, 250);
        zwat.registerPacket(cdqw.class, 251);
        zwat.registerPacket(PacketSpawnRegionsData.class, 252);
        zwat.registerPacket(aohw.class, 253);
        zwat.registerPacket(hbzg.class, 254);
        zwat.registerPacket(hshn.class, 255);
        zwat.registerPacket(PacketConfigAdd.class, 256);
        zwat.registerPacket(qlgl.class, 257);
        zwat.registerPacket(PacketOpenGuide.class, 259);
        zwat.registerPacket(ndke.class, 260);
        zwat.registerPacket(zffj.class, 262);
        zwat.registerPacket(xriw.class, 263);
        zwat.registerPacket(PacketNoiseAmount.class, 264);
        zwat.registerPacket(ncxk.class, 265);
        zwat.registerPacket(rori.class, 266);
        zwat.registerPacket(eiet.class, 267);
        zwat.registerPacket(cddu.class, 269);
        zwat.registerPacket(eikj.class, 270);
        zwat.registerPacket(htbo.class, 271);
        zwat.registerPacket(PacketConfigTest.class, 272);
        zwat.registerPacket(mqas.class, 273);
        zwat.registerPacket(ogtn.class, 274);
        zwat.registerPacket(lolm.class, 275);
        zwat.registerPacket(eigd.class, 276);
        zwat.registerPacket(tejk.class, 277);
        zwat.registerPacket(wnrx.class, 278);
        zwat.registerPacket(ofzv.class, 279);
        zwat.registerPacket(owfm.class, 280);
        zwat.registerPacket(sare.class, 281);
        zwat.registerPacket(PacketDeleteCorpse.class, 282);
        zwat.registerPacket(PacketSoundData.class, 283);
        zwat.registerPacket(lmyh.class, 284);
        zwat.registerPacket(PacketConfig.class, 285);
        zwat.registerPacket(fmbw.class, 286);
        zwat.registerPacket(PacketSpawnRegionsState.class, 288);
        zwat.registerPacket(zxgn.class, 289);
        zwat.registerPacket(PacketRegionAvailability.class, 290);
        zwat.registerPacket(ncww.class, 292);
        zwat.registerPacket(srpu.class, 293);
        zwat.registerPacket(zwcc.class, 294);
        zwat.registerPacket(xcpd.class, 295);
        zwat.registerPacket(dwfk.class, 296);
        zwat.registerPacket(sbez.class, 297);
        zwat.registerPacket(ctcn.class, 298);
        zwat.registerPacket(htbr.class, 299);
        zwat.registerPacket(aoid.class, 300);
        zwat.registerPacket(xqxb.class, 301);
        zwat.registerPacket(yurh.class, 302);
        zwat.registerPacket(zwjg.class, 303);
        zwat.registerPacket(ivai.class, 304);
        zwat.registerPacket(uiag.class, 305);
        zwat.registerPacket(ydlr.class, 306);
        zwat.registerPacket(bajw.class, 307);
        zwat.registerPacket(ncpw.class, 308);
        zwat.registerPacket(tdqj.class, 309);
        zwat.registerPacket(PacketUpdateNPCFaction.class, 310);
        zwat.registerPacket(owha.class, 311);
        zwat.registerPacket(jywg.class, 312);
        zwat.registerPacket(mqcx.class, 313);
        zwat.registerPacket(ycab.class, 314);
        zwat.registerPacket(jygo.class, 315);
        zwat.registerPacket(gloomyfolken.mods.ejection.zwaw.class, 316);
        zwat.registerPacket(idtg.class, 317);
        zwat.registerPacket(xqcm.class, 319);
        zwat.registerPacket(uxzh.class, 320);
        zwat.registerPacket(yuoj.class, 321);
        zwat.registerPacket(idtl.class, 322);
        zwat.registerPacket(piev.class, 324);
        zwat.registerPacket(PacketLockedDialogCategories.class, 325);
        zwat.registerPacket(dxaa.class, 326);
        zwat.registerPacket(fllp.class, 327);
        zwat.registerPacket(dwed.class, 328);
        zwat.registerPacket(PacketDupliNpcRequest.RemoveGroup.class, 329);
        zwat.registerPacket(ncaj.class, 330);
        zwat.registerPacket(piet.class, 331);
        zwat.registerPacket(dfiq.class, 332);
        zwat.registerPacket(yfpr.class, 333);
        zwat.registerPacket(mqba.class, 334);
        zwat.registerPacket(ncdg.class, 335);
        zwat.registerPacket(oxyd.class, 336);
        zwat.registerPacket(PacketConfigList.class, 337);
        zwat.registerPacket(owtl.class, 338);
        zwat.registerPacket(PacketEntityImpulse.class, 339);
        zwat.registerPacket(ezna.class, 340);
        zwat.registerPacket(zwat.class, 341);
        zwat.registerPacket(wmxl.class, 342);
        zwat.registerPacket(iurq.class, 343);
        zwat.registerPacket(PacketNpcSounds.class, 344);
        zwat.registerPacket(piho.class, 345);
        zwat.registerPacket(klis.class, 346);
        zwat.registerPacket(ezmu.class, 347);
        zwat.registerPacket(PacketDupliNpcRequest.RemoveNPCs.class, 348);
        zwat.registerPacket(ytyx.class, 349);
        zwat.registerPacket(yuln.class, 350);
        zwat.registerPacket(nuly.class, 351);
        zwat.registerPacket(iutg.class, 352);
        zwat.registerPacket(PacketIgnoredList.class, 353);
        zwat.registerPacket(ncxe.class, 354);
        zwat.registerPacket(flht.class, 355);
        zwat.registerPacket(pzjz.class, 356);
        zwat.registerPacket(iuxx.class, 357);
        zwat.registerPacket(wnsl.class, 358);
        zwat.registerPacket(jxzm.class, 359);
        zwat.registerPacket(nuob.class, 361);
        zwat.registerPacket(rord.class, 362);
        zwat.registerPacket(roqd.class, 363);
        zwat.registerPacket(flkl.class, 364);
        zwat.registerPacket(srqe.class, 365);
        zwat.registerPacket(sszo.class, 366);
        zwat.registerPacket(iurn.class, 367);
        zwat.registerPacket(haqh.class, 368);
        zwat.registerPacket(PacketPresetBlock.class, 370);
        zwat.registerPacket(PacketInteractClosestNpc.class, 371);
        zwat.registerPacket(PacketSpawnStatistics.class, 372);
        zwat.registerPacket(nwuf.class, 373);
        zwat.registerPacket(ccfp.class, 374);
        zwat.registerPacket(PacketSetOwnerNpcRequest.class, 376);
        zwat.registerPacket(ugwx.class, 377);
        zwat.registerPacket(PacketGenericEffectEvent.class, 378);
        zwat.registerPacket(PacketRegions.class, 379);
        zwat.registerPacket(PacketUnusedCategories.class, 380);
        zwat.registerPacket(PacketTradepackSold.class, 381);
        zwat.registerPacket(dfiv.class, 382);
        zwat.registerPacket(QuestLogPacket.class, 383);
        zwat.registerPacket(ivkt.class, 384);
        zwat.registerPacket(ofhw.class, 386);
        zwat.registerPacket(nudm.class, 387);
        zwat.registerPacket(flmy.class, 388);
        zwat.registerPacket(vjvn.class, 389);
        zwat.registerPacket(gloomyfolken.mods.bundle.zwaw.class, 390);
        zwat.registerPacket(dfsr.class, 391);
        zwat.registerPacket(PacketOpenTradepacks.class, 392);
        zwat.registerPacket(zfgr.class, 394);
        zwat.registerPacket(xqcq.class, 395);
        zwat.registerPacket(NpcSyncPacket.class, 396);
        zwat.registerPacket(PacketCameraShake.class, 397);
        zwat.registerPacket(sasu.class, 398);
        zwat.registerPacket(eikd.class, 399);
        zwat.registerPacket(eifc.class, 400);
        zwat.registerPacket(ncdr.class, 401);
        zwat.registerPacket(PacketSearchCorpse.class, 402);
        zwat.registerPacket(nudp.class, 403);
        zwat.registerPacket(hvdo.class, 404);
        zwat.registerPacket(PacketSellTradepack.class, 405);
        zwat.registerPacket(ydkq.class, 406);
        zwat.registerPacket(hsso.class, 407);
        zwat.registerPacket(dxpi.class, 408);
        zwat.registerPacket(PacketDupliNpcRequest.RenameGroup.class, 409);
        zwat.registerPacket(ejxc.class, 410);
        zwat.registerPacket(PacketDisplayedRegions.class, 411);
        zwat.registerPacket(gokg.class, 413);
        zwat.registerPacket(PacketVampireKissEvent.class, 414);
        zwat.registerPacket(ycxm.class, 415);
        zwat.registerPacket(lmyw.class, 416);
        zwat.registerPacket(PacketNewMutantState.class, 417);
        zwat.registerPacket(mqvh.class, 419);
        zwat.registerPacket(ogou.class, 420);
        zwat.registerPacket(ezll.class, 421);
        zwat.registerPacket(idsc.class, 422);
        zwat.registerPacket(dwfp.class, 423);
        zwat.registerPacket(mqbh.class, 424);
        zwat.registerPacket(PacketEditTileConfig.class, 426);
        zwat.registerPacket(PacketUpdateEquipState.class, 428);
        zwat.registerPacket(aqod.class, 429);
        zwat.registerPacket(PacketEditSound.class, 430);
        zwat.registerPacket(numa.class, 431);
        zwat.registerPacket(sbyp.class, 432);
        zwat.registerPacket(PacketQuestsAvailability.class, 433);
        zwat.registerPacket(xriz.class, 434);
        zwat.registerPacket(PacketUpdateState.class, 435);
        zwat.registerPacket(pzms.class, 436);
        zwat.registerPacket(eiiu.class, 437);
        zwat.registerPacket(idwy.class, 438);
        zwat.registerPacket(iejr.class, 439);
        zwat.registerPacket(ntyc.class, 440);
        zwat.registerPacket(elyz.class, 441);
        zwat.registerPacket(iwat.class, 442);
        zwat.registerPacket(ntra.class, 443);
        zwat.registerPacket(qljc.class, 444);
        zwat.registerPacket(wnsd.class, 445);
        zwat.registerPacket(qlmx.class, 446);
        zwat.registerPacket(zfhr.class, 447);
        zwat.registerPacket(pzub.class, 448);
        zwat.registerPacket(sbqn.class, 449);
        zwat.registerPacket(nwrm.class, 450);
        zwat.registerPacket(PacketSelectionUpdate.class, 451);
    }

    private static UUID registerProtocolVersion() {
        return new UUID(7953955223947396419L, -4995430377341798163L);
    }

    public static void init() {
    }

    public static UUID getProtocolVersion() {
        return protocolVersion;
    }

    private static void registerPacket(Class<? extends ctih> clazz, int n) {
        sryv._a(clazz, n);
    }

    public final int getPacketId() {
        return sryv._a(this);
    }

    public boolean canProcessWhenDead() {
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    public void processClient(boolean bl) {
        throw new RuntimeException("processClient not implemented for packet " + this.getClass());
    }

    @ezey(_a={eidj.CLIENT})
    public final void sendToServer() {
        ncul._a(this);
    }

    @ezey(_a={eidj.CLIENT})
    public final void sendClientToBackend() {
        ncul._b(this);
    }

    static {
        zwat.registerPersistentPackets();
        zwat.registerPackets();
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

