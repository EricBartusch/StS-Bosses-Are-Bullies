package bossesAreBullies.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.beyond.Deca;
import com.megacrit.cardcrawl.monsters.beyond.Donu;

import static bossesAreBullies.BossesAreBullies.makeID;

public class DonuDecaExtraDialogPatch {

    @SpirePatch(clz = Deca.class, method = SpirePatch.CLASS)
    public static class DecaExtraDialog
    {
        public static SpireField<String[]> extraDecaDialog = new SpireField(() -> CardCrawlGame.languagePack.getUIString(makeID("ExtraDonuDecaText")).TEXT);
        public static SpireField<Boolean> isFirstTurn = new SpireField(() -> true);
    }

    @SpirePatch(clz = Deca.class, method = "takeTurn")
    public static class DecaDialog {

        @SpirePrefixPatch
        public static void Prefix(Deca __instance) {
            if(DecaExtraDialog.isFirstTurn.get(__instance) && Settings.hasRubyKey && Settings.hasSapphireKey && !Settings.hasEmeraldKey) {
                DecaExtraDialog.isFirstTurn.set(__instance, false);
                String[] dialog = DecaExtraDialog.extraDecaDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if(Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }

                Donu donu = (Donu)AbstractDungeon.getCurrRoom().monsters.monsters.get(1);
                if(!donu.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 2.0F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[1], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[2], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[3], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[4], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[5], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[7], 2.0F, 2.0F));
                } else {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[10], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[11], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[12], 3.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[13], 2.0F, 3.0F));
                }

                if(wasFast) {
                    Settings.FAST_MODE = true;
                }
            } else if(DecaExtraDialog.isFirstTurn.get(__instance) && !Settings.hasRubyKey && Settings.hasSapphireKey && Settings.hasEmeraldKey) {
                DecaExtraDialog.isFirstTurn.set(__instance, false);
                String[] dialog = DecaExtraDialog.extraDecaDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if(Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }

                Donu donu = (Donu)AbstractDungeon.getCurrRoom().monsters.monsters.get(1);
                if(!donu.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 2.0F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[1], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[2], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[3], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[4], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[5], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[9], 2.0F, 2.0F));
                } else {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[10], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[11], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[12], 3.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[13], 3.0F, 3.0F));
                }

                if(wasFast) {
                    Settings.FAST_MODE = true;
                }
            } else if(DecaExtraDialog.isFirstTurn.get(__instance) && Settings.hasRubyKey && !Settings.hasSapphireKey && Settings.hasEmeraldKey) {
                DecaExtraDialog.isFirstTurn.set(__instance, false);
                String[] dialog = DecaExtraDialog.extraDecaDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if (Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }

                Donu donu = (Donu) AbstractDungeon.getCurrRoom().monsters.monsters.get(1);
                if (!donu.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 2.0F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[1], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[2], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[3], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[4], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[5], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(donu, dialog[8], 2.0F, 2.0F));
                } else {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[10], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[11], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[12], 3.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[13], 2.0F, 3.0F));
                }

                if (wasFast) {
                    Settings.FAST_MODE = true;
                }
            }
        }
    }

    @SpirePatch(clz = Donu.class, method = SpirePatch.CLASS)
    public static class DonuExtraDialog
    {
        public static SpireField<String[]> extraDonuDecaDialog = new SpireField(() -> CardCrawlGame.languagePack.getUIString(makeID("ExtraDonuDecaText")).TEXT);
        public static SpireField<Boolean> isFirstTurn = new SpireField(() -> true);
    }

    @SpirePatch(clz = Donu.class, method = "takeTurn")
    public static class DonuDialog {

        @SpirePrefixPatch
        public static void Prefix(Donu __instance) {
            if (DonuExtraDialog.isFirstTurn.get(__instance) && (
                    (Settings.hasRubyKey && Settings.hasSapphireKey && !Settings.hasEmeraldKey) ||
                    (!Settings.hasRubyKey && Settings.hasSapphireKey && Settings.hasEmeraldKey) ||
                    (Settings.hasRubyKey && !Settings.hasSapphireKey && Settings.hasEmeraldKey))
                    ) {
                DonuExtraDialog.isFirstTurn.set(__instance, false);
                String[] dialog = DonuExtraDialog.extraDonuDecaDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if (Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }

                Deca deca = (Deca)AbstractDungeon.getCurrRoom().monsters.monsters.get(0);
                if(deca.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[10], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[11], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[12], 3.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[13], 2.0F, 3.0F));
                }

                if(wasFast) {
                    Settings.FAST_MODE = true;
                }
            }
        }
    }
}
