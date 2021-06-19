package bossesAreBullies;

import basemod.BaseMod;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import java.nio.charset.StandardCharsets;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class BossesAreBullies implements
        EditStringsSubscriber
    {

    public static final String modID = "bossesarebullies";

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    public BossesAreBullies() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        BossesAreBullies thismod = new BossesAreBullies();
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(UIStrings.class, modID +  "Resources/localization/eng/UIstrings.json");
    }

}
