/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map.render;

import com.google.common.collect.Multimap;
import gloomyfolken.mods.anomaly.jxtc;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import gloomyfolken.mods.stalker.mobs.spawn.MutantSpawnerConfiguration;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionConfiguration;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionEntry;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import gloomyfolken.mods.stalker.respawn.jxtc;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.map.ExtraMapData;
import mods.pda.client.map.MapSettings;
import mods.pda.client.minimap.MapCanvas;
import mods.sound.SoundMod;
import mods.sound.client.ClientSoundController;
import mods.sound.config.SoundSource;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.controllers.QuestMark;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class OperatorMapRenderer
implements MapCanvas.MapRenderer {
    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        MapSettings mapSettings = PdaClient.mapSettings;
        if (SoundMod.visualDebug) {
            for (ClientSoundController.SourceGroup sourceGroup : SoundMod.instance.soundController.sourceGroups.values()) {
                this.drawSoundSources(mapCanvas, sourceGroup);
            }
        }
        if (mapSettings.locationsDebug) {
            this.drawLocationBounds(mapCanvas, mapSettings.locationBounds);
        }
        if (mapSettings.mobsRegions) {
            this.drawSpawnRegions(mapCanvas, StalkerMobsClient.getInstance().getLocalRegionsData());
        }
        ExtraMapData extraMapData = PdaMod.getClientPda().extraMapData;
        if (mapSettings.mobSpawners) {
            this.drawMobSpawners(mapCanvas, extraMapData.getTiles());
        }
        if (mapSettings.npc) {
            this.drawNpc(mapCanvas, mapSettings, extraMapData.getNpcs());
        }
        if (mapSettings.advancedClanLands) {
            this.drawFullMapLands(mapCanvas, yuch._a._q);
        }
        if (mapSettings.savepoints) {
            this.drawSavepoints(mapCanvas, extraMapData.getTiles());
        }
        if (mapSettings.quests) {
            this.drawQuests(mapSettings, mapCanvas, extraMapData.getQuestMarks(), extraMapData.getConfirmedQuests());
        }
        if (mapSettings.teleports) {
            this.drawTeleports(mapCanvas, extraMapData.getTiles());
        }
        if (mapSettings.chests) {
            this.drawChests(mapCanvas, extraMapData.getTiles());
        }
    }

    private void drawChests(MapCanvas mapCanvas, List<TileEntity> list) {
        Point point = new Point(84, 821);
        Point point2 = new Point(74, 821);
        Dimension dimension = new Dimension(9, 11);
        mapCanvas.renderer.bindTexture(iedw._a);
        for (TileEntity tileEntity : list) {
            if (!(tileEntity instanceof hbio)) continue;
            hbio hbio2 = (hbio)tileEntity;
            boolean bl = hbio2._a();
            mapCanvas.drawMapIcon(hbio2.xCoord, hbio2.zCoord, bl ? point2 : point, dimension, () -> "\u0422\u0430\u0439\u043d\u0438\u043a\n" + (bl ? "\u0412\u043a\u043b\u044e\u0447\u0435\u043d" : "\u0412\u044b\u043a\u043b\u044e\u0447\u0435\u043d"), -1, false, false, 1024.0, 1024.0);
        }
    }

    private void drawSoundSources(MapCanvas mapCanvas, ClientSoundController.SourceGroup sourceGroup) {
        GL11.glEnable(3042);
        boolean bl = sourceGroup.state == 0;
        Minecraft._E()._R()._a(iedw._a);
        Point point = new Point(435, 839);
        Dimension dimension = new Dimension(24, 24);
        for (SoundSource soundSource : sourceGroup.sources) {
            Supplier<String> supplier = () -> {
                String string = "\u00a7e\u0418\u0441\u0442\u043e\u0447\u043d\u0438\u043a \u0437\u0432\u0443\u043a\u0430\u00a7r\n\u0413\u0440\u0443\u043f\u043f\u0430: " + soundSource.getGroup() + "|" + sourceGroup.id + "\n\u0421\u043b\u044b\u0448\u0438\u043c\u043e\u0441\u0442\u044c: " + soundSource.getRolloff() + "\n\u0413\u0440\u043e\u043c\u043a\u043e\u0441\u0442\u044c: " + (double)soundSource.getGain() * 100.0 + "\nState: " + sourceGroup.state;
                if (sourceGroup.lastPlayed != null) {
                    string = string + "\n\n\u0421\u0435\u0439\u0447\u0430\u0441 \u0438\u0433\u0440\u0430\u0435\u0442: " + sourceGroup.lastPlayed.path;
                }
                return string;
            };
            Vector2f vector2f = mapCanvas.drawMapIcon(new Vector2f(soundSource.getPos().x, soundSource.getPos().z), point, dimension, supplier, sourceGroup.color, false, false);
            float f = soundSource.getRolloff() / mapCanvas.getZoom();
            this.enableStippleLine(15, 3.0f, (float)(sourceGroup.color >> 16 & 0xFF) / 255.0f, (float)(sourceGroup.color >> 8 & 0xFF) / 255.0f, (float)(sourceGroup.color & 0xFF) / 255.0f, 0.8f);
            if (sourceGroup.state == 0) {
                GL11.glDisable(2852);
            }
            GL11.glBegin(2);
            mapCanvas.drawCircle(vector2f.x, vector2f.y, (float)(Math.sqrt(f) * 10.0), f);
            GL11.glEnd();
            GL11.glDisable(2852);
            GL11.glEnable(3553);
        }
    }

    private void drawTeleports(MapCanvas mapCanvas, List<TileEntity> list) {
        Point point = new Point(129, 769);
        Dimension dimension = new Dimension(23, 23);
        for (TileEntity tileEntity : list) {
            if (!(tileEntity instanceof jydd)) continue;
            jydd jydd2 = (jydd)tileEntity;
            gloomyfolken.mods.anomaly.jxtc jxtc2 = jydd2._i();
            Supplier<String> supplier = () -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)EnumChatFormatting._o).append("\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\n").append("\u0414\u0438\u0430\u043b\u043e\u0433: ").append(jxtc2._c()).append("\n").append("\u041d\u041f\u0421: ").append(jxtc2._f()).append("\n").append("\u0420\u0430\u0437\u043c\u0435\u0440: ").append(String.format("%.2f", jxtc2._b())).append("\n");
                ArrayList<jxtc.kjui> arrayList = jxtc2._a();
                if (!arrayList.isEmpty()) {
                    stringBuilder.append("\n\u041f\u043e\u0437\u0438\u0446\u0438\u0438:\n");
                }
                for (int i = 0; i < arrayList.size(); ++i) {
                    jxtc.kjui kjui2 = arrayList.get(i);
                    stringBuilder.append(i + 1).append(".").append(String.format("%d, %d, %d", kjui2._a(), kjui2._b(), kjui2._c())).append(" (").append(String.format("%.2f", Float.valueOf(kjui2._e()))).append(")\n");
                }
                return stringBuilder.toString();
            };
            mapCanvas.renderer.bindTexture(iedw._a);
            Vector2f vector2f = new Vector2f(jydd2.xCoord, jydd2.zCoord);
            mapCanvas.drawMapIcon(vector2f, point, dimension, supplier, -1, true, false);
        }
    }

    public void drawSpawnRegions(MapCanvas mapCanvas, HashMap<String, SpawnRegionEntry> hashMap) {
        Object object;
        Vector2f vector2f;
        SpawnRegionEntry spawnRegionEntry;
        for (Map.Entry<String, SpawnRegionEntry> entry : hashMap.entrySet()) {
            Vector2f vector2f2;
            this.enableStippleLine(15, 2.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            spawnRegionEntry = entry.getValue();
            if (spawnRegionEntry.getBounds().getPoints().isEmpty()) continue;
            ArrayList<Point2D.Float> arrayList = new ArrayList<Point2D.Float>();
            GL11.glLineWidth(10.0f);
            GL11.glBegin(2);
            for (java.awt.Point object2 : spawnRegionEntry.getBounds().getPoints()) {
                vector2f = mapCanvas.worldCoordsToScreen(new Vector2f(object2.x, object2.y));
                GL11.glVertex2d(vector2f.x, vector2f.y);
                arrayList.add(new Point2D.Float(vector2f.x, vector2f.y));
            }
            GL11.glEnd();
            GL11.glBegin(4);
            for (kksf kksf2 : spawnRegionEntry.getBounds().getTriangles()) {
                vector2f = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf2._h().x, kksf2._h().y)));
                object = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf2._i().x, kksf2._i().y)));
                vector2f2 = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf2._j().x, kksf2._j().y)));
                GL11.glVertex2d(vector2f2.x, vector2f2.y);
                GL11.glVertex2d(((Vector2f)object).x, ((Vector2f)object).y);
                GL11.glVertex2d(vector2f.x, vector2f.y);
            }
            GL11.glEnd();
            GL11.glLineWidth(3.0f);
            GL11.glDisable(2852);
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.25f);
            GL11.glBegin(1);
            for (kksf kksf3 : spawnRegionEntry.getBounds().getTriangles()) {
                vector2f = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf3._h().x, kksf3._h().y)));
                object = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf3._i().x, kksf3._i().y)));
                vector2f2 = new Vector2f(mapCanvas.worldCoordsToScreen(new Vector2f(kksf3._j().x, kksf3._j().y)));
                GL11.glVertex2d(vector2f2.x, vector2f2.y);
                GL11.glVertex2d(((Vector2f)object).x, ((Vector2f)object).y);
                GL11.glVertex2d(((Vector2f)object).x, ((Vector2f)object).y);
                GL11.glVertex2d(vector2f.x, vector2f.y);
                GL11.glVertex2d(vector2f.x, vector2f.y);
                GL11.glVertex2d(vector2f2.x, vector2f2.y);
            }
            GL11.glEnd();
            float f = (mapCanvas.cursorPos.x - mapCanvas.mapCenter.x) * mapCanvas.renderer.scale;
            float f2 = (mapCanvas.cursorPos.y - mapCanvas.mapCenter.y) * mapCanvas.renderer.scale;
            if (!iuyu._a(f, f2, arrayList)) continue;
            mapCanvas.pendingTooltip = this.getSpawnerTooltip(entry.getKey(), entry.getValue().getConfiguration());
        }
        GL11.glDisable(2852);
        GL11.glEnable(3553);
        for (Map.Entry<String, SpawnRegionEntry> entry : hashMap.entrySet()) {
            spawnRegionEntry = entry.getValue();
            if (spawnRegionEntry.getBounds().getPoints().isEmpty()) continue;
            int n = 0;
            for (java.awt.Point point : spawnRegionEntry.getBounds().getPoints()) {
                vector2f = mapCanvas.worldCoordsToScreen(new Vector2f(point.x, point.y));
                object = ExternalFont.tahoma11;
                ((ExternalFont)object).drawString(n + "", (double)vector2f.x, (double)vector2f.y, -1, true);
                ++n;
            }
        }
    }

    private StringBuilder getSpawnerCommonInfo(String string, MutantSpawnerConfiguration mutantSpawnerConfiguration) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)EnumChatFormatting._o)).append(string).append("\n\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e \u043c\u0443\u0442\u0430\u043d\u0442\u043e\u0432: ").append(mutantSpawnerConfiguration.getMaxEntityCount()).append("\n\u0411\u043b\u043e\u043a\u0438:").append(Arrays.toString((Object[])mutantSpawnerConfiguration.getSufficientBlocks()));
        if (mutantSpawnerConfiguration instanceof SpawnRegionConfiguration) {
            stringBuilder.append("\n\u0412\u044b\u0441\u043e\u0442\u0430 \u0441\u043f\u0430\u0432\u043d\u0430: ").append(((SpawnRegionConfiguration)mutantSpawnerConfiguration).getYMin()).append(" - ").append(((SpawnRegionConfiguration)mutantSpawnerConfiguration).getYMax());
        }
        return stringBuilder;
    }

    private String getSpawnerTooltip(String string, MutantSpawnerConfiguration mutantSpawnerConfiguration) {
        StringBuilder stringBuilder = this.getSpawnerCommonInfo(string, mutantSpawnerConfiguration);
        float f = (float)mutantSpawnerConfiguration.getPossibleSpawnEntries().stream().mapToDouble(qman::getWeight).sum();
        if (f <= 0.0f) {
            f = 1.0f;
        }
        if (!mutantSpawnerConfiguration.getPossibleSpawnEntries().isEmpty()) {
            stringBuilder.append("\n\u0421\u0443\u0449\u043d\u043e\u0441\u0442\u0438:");
            ArrayList<qman> arrayList = mutantSpawnerConfiguration.getPossibleSpawnEntries();
            for (int i = 0; i < arrayList.size(); ++i) {
                qman qman2 = arrayList.get(i);
                stringBuilder.append("\n").append(i + 1).append(". ").append(qman2.getConfigurationName()).append(" (").append(String.format("%.2f", Float.valueOf((float)((int)qman2.getWeight()) / f * 100.0f))).append("%)");
            }
        }
        return stringBuilder.toString();
    }

    private void drawMobSpawners(MapCanvas mapCanvas, List<TileEntity> list) {
        for (TileEntity tileEntity : list) {
            if (!(tileEntity instanceof TileEntityMutantSpawner)) continue;
            TileEntityMutantSpawner tileEntityMutantSpawner = (TileEntityMutantSpawner)tileEntity;
            float f = tileEntityMutantSpawner.xCoord;
            float f2 = tileEntityMutantSpawner.zCoord;
            Vector2f vector2f = mapCanvas.worldCoordsToScreen(f + (float)tileEntityMutantSpawner.getXMin(), f2 + (float)tileEntityMutantSpawner.getZMin(), new Vector2f());
            Vector2f vector2f2 = mapCanvas.worldCoordsToScreen(f + (float)tileEntityMutantSpawner.getXMax(), f2 + (float)tileEntityMutantSpawner.getZMax(), new Vector2f());
            this.enableStippleLine(5, 2.0f, 1.0f, 0.6f, 0.0f, 0.5f);
            GL11.glBegin(2);
            GL11.glVertex2d(vector2f.x, vector2f.y);
            GL11.glVertex2d(vector2f2.x, vector2f.y);
            GL11.glVertex2d(vector2f2.x, vector2f2.y);
            GL11.glVertex2d(vector2f.x, vector2f2.y);
            GL11.glEnd();
            GL11.glDisable(2852);
            GL11.glEnable(3553);
            boolean bl = tileEntityMutantSpawner.getSpawnEnabled();
            mapCanvas.renderer.bindTexture(iedw._a);
            mapCanvas.drawMapIcon(new Vector2f(f, f2), new Point(462, 839), new Dimension(24, 24), () -> this.getSpawnerTooltip("\u0421\u043f\u0430\u0432\u043d\u0435\u0440 \u043c\u0443\u0442\u0430\u043d\u0442\u043e\u0432", tileEntityMutantSpawner.getConfiguration()), bl ? -16732161 : -1024256, false, false);
        }
    }

    public void drawNpc(MapCanvas mapCanvas, MapSettings mapSettings, List<MapNpc> list) {
        for (MapNpc mapNpc : list) {
            String string;
            if (mapSettings.jobFilter != EnumJobType.None && mapSettings.jobFilter != mapNpc.job || mapSettings.roleFilter != EnumRoleType.None && mapSettings.roleFilter != mapNpc.role || mapSettings.cloneType == 1 && !mapNpc.cloned || mapSettings.cloneType == 2 && mapNpc.cloned || mapSettings.onlyConfirmed && !mapNpc.confirmed || !(string = mapSettings.playerFilter).isEmpty() && !mapNpc.owner.contains(string) && !mapNpc.creator.contains(string) && !mapNpc.approver.contains(string) || !mapSettings.npcFilter.isEmpty() && !mapNpc.name.contains(mapSettings.npcFilter)) continue;
            mapCanvas.renderer.bindTexture(iedw._a);
            mapCanvas.drawMapIcon(new Vector2f(mapNpc.xPos, mapNpc.zPos), new Point(364, 876), new Dimension(24, 24), () -> this.getNpcTooltip(mapNpc), mapNpc.confirmed ? -16711936 : -1, false, false);
        }
    }

    private String getNpcTooltip(MapNpc mapNpc) {
        return String.valueOf((Object)EnumChatFormatting._o) + "\u041d\u041f\u0421 " + mapNpc.name + "\n\u0420\u043e\u043b\u044c: " + mapNpc.role.name() + "\n\u0421\u043f\u0435\u0446\u0438\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u044f: " + mapNpc.job.name() + "\n\u0421\u043e\u0437\u0434\u0430\u043d:" + mapNpc.creator + "\n\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + mapNpc.owner + "\n\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d: " + (mapNpc.confirmed ? "\u0414\u0430 (" + mapNpc.approver + ")" : "\u041d\u0435\u0442") + "\n\u041a\u043b\u043e\u043d: " + (mapNpc.cloned ? "\u0414\u0430" : "\u041d\u0435\u0442");
    }

    public void drawQuests(MapSettings mapSettings, MapCanvas mapCanvas, Multimap<String, QuestMark> multimap, Set<String> set) {
        mapCanvas.renderer.bindTexture(iedw._a);
        for (Map.Entry<String, QuestMark> entry : multimap.entries()) {
            String string = entry.getKey();
            QuestMark questMark = entry.getValue();
            boolean bl = set.contains(string);
            if (mapSettings.questType == 1 && !bl || mapSettings.questType == 2 && bl || !string.contains(mapSettings.questFilter)) continue;
            Supplier<String> supplier = () -> (Object)((Object)EnumChatFormatting._o) + "\u0417\u0430\u0434\u0430\u043d\u0438\u0435 " + string + "\n\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u043e: " + (bl ? "\u0414\u0430" : "\u041d\u0435\u0442");
            Vec3 vec3 = questMark.getPos();
            if (!(questMark.getRadius() <= 0.0f) && mapCanvas.drawQuestArea((float)vec3._c, (float)vec3._e, questMark.getRadius(), supplier, bl, false)) continue;
            mapCanvas.drawQuestIcon(new Vector3f((float)vec3._c, (float)vec3._d, (float)vec3._e), bl ? -16711936 : -1, supplier, false);
        }
    }

    public void drawSavepoints(MapCanvas mapCanvas, List<TileEntity> list) {
        for (TileEntity tileEntity : list) {
            if (!(tileEntity instanceof jxtc)) {
                return;
            }
            jxtc jxtc2 = (jxtc)tileEntity;
            Vector2f vector2f = new Vector2f(jxtc2.xCoord, jxtc2.zCoord);
            Vector2f vector2f2 = mapCanvas.worldCoordsToScreen(vector2f);
            float f = (float)jxtc2._l / mapCanvas.getZoom();
            this.enableStippleLine(15, 3.0f, 0.0f, 1.0f, 0.0f, 0.5f);
            GL11.glBegin(2);
            mapCanvas.drawCircle(vector2f2.x, vector2f2.y, (float)(Math.sqrt(f) * 10.0), f);
            GL11.glEnd();
            GL11.glDisable(2852);
            GL11.glEnable(3553);
            Supplier<String> supplier = () -> (Object)((Object)EnumChatFormatting._o) + "\u0421\u0435\u0439\u0432\u0437\u043e\u043d\u0430 " + jxtc2._k + "\n\u0424\u0440\u0430\u043a\u0446\u0438\u0438: " + String.join((CharSequence)",", jxtc2._n.stream().map(tupg2 -> tupg2._d).collect(Collectors.toList())) + "\n\u041f\u0440\u0438\u043d\u0443\u0434\u0438\u0442\u0435\u043b\u044c\u043d\u043ee \u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435: " + (jxtc2._m ? "\u0414\u0430" : "\u041d\u0435\u0442") + this.getRespawnString(jxtc2);
            mapCanvas.renderer.bindTexture(iedw._a);
            mapCanvas.drawMapIcon(vector2f, new Point(391, 874), new Dimension(24, 24), supplier, -1, false, false);
        }
    }

    private String getRespawnString(jxtc jxtc2) {
        if (jxtc2._a() != null) {
            einh einh2 = jxtc2._a()._b;
            return String.format("\n\u0422\u043e\u0447\u043a\u0430 \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0435\u043d\u0438\u044f: %d, %d, %d", einh2._c(), einh2._d(), einh2._e());
        }
        return "";
    }

    public void drawFullMapLands(MapCanvas mapCanvas, List<kkzc.kjui> list) {
        this.enableStippleLine(15, 2.0f, 0.1f, 0.1f, 1.0f, 1.0f);
        for (kkzc.kjui kjui2 : list) {
            dfkn dfkn2 = kjui2._a._h;
            Vector2f vector2f = mapCanvas.worldCoordsToScreen(new Vector2f((float)dfkn2._a, (float)dfkn2._c), new Vector2f());
            Vector2f vector2f2 = mapCanvas.worldCoordsToScreen(new Vector2f((float)dfkn2._d, (float)dfkn2._f), new Vector2f());
            GL11.glBegin(2);
            GL11.glVertex2d(vector2f.x, vector2f.y);
            GL11.glVertex2d(vector2f2.x, vector2f.y);
            GL11.glVertex2d(vector2f2.x, vector2f2.y);
            GL11.glVertex2d(vector2f.x, vector2f2.y);
            GL11.glEnd();
        }
        GL11.glDisable(2852);
        GL11.glEnable(3553);
    }

    public void drawLocationBounds(MapCanvas mapCanvas, List<List<Vector2f>> list) {
        this.enableStippleLine(15, 1.5f, 1.0f, 1.0f, 0.0f, 0.5f);
        for (List<Vector2f> list2 : list) {
            GL11.glBegin(2);
            for (Vector2f vector2f : list2) {
                Vector2f vector2f2 = mapCanvas.worldCoordsToScreen(vector2f);
                GL11.glVertex2d(vector2f2.x, vector2f2.y);
            }
            GL11.glEnd();
        }
        GL11.glDisable(2852);
        GL11.glEnable(3553);
    }

    private void enableStippleLine(int n, float f, float f2, float f3, float f4, float f5) {
        GL11.glLineStipple(n, (short)-21846);
        GL11.glDisable(3553);
        GL11.glLineWidth(f);
        GL11.glColor4f(f2, f3, f4, f5);
        GL11.glEnable(3042);
        GL11.glEnable(2852);
    }
}

