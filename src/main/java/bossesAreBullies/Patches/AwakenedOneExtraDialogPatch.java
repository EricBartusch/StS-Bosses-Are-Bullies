package bossesAreBullies.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.beyond.AwakenedOne;
import com.megacrit.cardcrawl.monsters.beyond.Deca;
import com.megacrit.cardcrawl.monsters.beyond.Donu;
import com.megacrit.cardcrawl.monsters.exordium.Cultist;

import static bossesAreBullies.BossesAreBullies.makeID;

public class AwakenedOneExtraDialogPatch {

    @SpirePatch(clz = AwakenedOne.class, method = SpirePatch.CLASS)
    public static class AwakenedOneExtraDialog
    {
        public static SpireField<String[]> extraAwakenedOneDialog = new SpireField(() -> CardCrawlGame.languagePack.getUIString(makeID("ExtraAwakenedOneText")).TEXT);
        public static SpireField<Boolean> isFirstTurn = new SpireField(() -> true);
    }

    @SpirePatch(clz = AwakenedOne.class, method = "takeTurn")
    public static class DecaDialog {

        @SpirePrefixPatch
        public static void Prefix(Deca __instance) {
            if (AwakenedOneExtraDialog.isFirstTurn.get(__instance) && (
                    (Settings.hasRubyKey && Settings.hasSapphireKey && !Settings.hasEmeraldKey) ||
                    (!Settings.hasRubyKey && Settings.hasSapphireKey && Settings.hasEmeraldKey) ||
                    (Settings.hasRubyKey && !Settings.hasSapphireKey && Settings.hasEmeraldKey))
                    )   {
                AwakenedOneExtraDialog.isFirstTurn.set(__instance, false);
                String[] dialog = AwakenedOneExtraDialog.extraAwakenedOneDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if(Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }

                Cultist frank = (Cultist) AbstractDungeon.getCurrRoom().monsters.monsters.get(0);
                Cultist jeff  = (Cultist) AbstractDungeon.getCurrRoom().monsters.monsters.get(1);

                if(!jeff.isDeadOrEscaped() && !frank.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[0], 1.0F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(jeff, dialog[1], 1.0F, 1.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[2], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(jeff, dialog[3], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[4], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(jeff, dialog[5], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[6], 3.0F, 3.0F));
                } else if (!jeff.isDeadOrEscaped()){
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[7], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[9], 2.0F, 1.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[10], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[11], 2.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[12], 1.5F, 1.5F));
                } else if (!frank.isDeadOrEscaped()) {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[8], 2.0F, 2.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[9], 2.0F, 1.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[10], 1.5F, 1.5F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[11], 2.0F, 3.0F));
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[12], 1.5F, 1.5F));
                } else {
                    AbstractDungeon.actionManager.addToBottom(new TalkAction(frank, dialog[13], 3.0F, 3.0F));
                }

                if(wasFast) {
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
