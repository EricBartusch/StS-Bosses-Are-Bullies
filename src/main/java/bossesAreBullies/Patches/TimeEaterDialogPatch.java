package bossesAreBullies.Patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.beyond.TimeEater;

import static bossesAreBullies.BossesAreBullies.makeID;

public class TimeEaterDialogPatch {

    @SpirePatch(clz = TimeEater.class, method = SpirePatch.CLASS)
    public static class TimeEaterExtraDialog
    {
        public static SpireField<String[]> extraDialog = new SpireField(() -> CardCrawlGame.languagePack.getUIString(makeID("ExtraTimeEaterText")).TEXT);
    }

    @SpirePatch(clz = TimeEater.class, method = "takeTurn")
    public static class TimeEaterDialog {

        @SpirePrefixPatch
        public static void Prefix(TimeEater __instance, @ByRef boolean[] ___firstTurn) {
            if(___firstTurn[0] && Settings.hasRubyKey && Settings.hasSapphireKey && !Settings.hasEmeraldKey) {
                String[] dialog = TimeEaterExtraDialog.extraDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if(Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 3.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[1], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[2], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[5], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 2.0F, 2.0F));


                ___firstTurn[0] = false;
                if(wasFast) {
                    Settings.FAST_MODE = Settings.FAST_MODE = true;
                }
            } else if(___firstTurn[0] && Settings.hasRubyKey && !Settings.hasSapphireKey && Settings.hasEmeraldKey) {
                String[] dialog = TimeEaterExtraDialog.extraDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if(Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 3.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[1], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[4], 3.5F, 3.5F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[5], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 2.0F, 2.0F));


                ___firstTurn[0] = false;
                if(wasFast) {
                    Settings.FAST_MODE = Settings.FAST_MODE = true;
                }
            } else if(___firstTurn[0] && !Settings.hasRubyKey && Settings.hasSapphireKey && Settings.hasEmeraldKey) {
                String[] dialog = TimeEaterExtraDialog.extraDialog.get(__instance);
                boolean wasFast = Settings.FAST_MODE;
                if (Settings.FAST_MODE) {
                    Settings.FAST_MODE = false;
                }
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[0], 3.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[1], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[3], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[5], 2.0F, 2.0F));
                AbstractDungeon.actionManager.addToBottom(new TalkAction(__instance, dialog[6], 2.0F, 2.0F));

                ___firstTurn[0] = false;
                if (wasFast) {
                    Settings.FAST_MODE = Settings.FAST_MODE = true;
                }
            }
        }
    }
}
