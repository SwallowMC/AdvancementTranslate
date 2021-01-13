package org.swallowmc.AdvancementTranslate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvancementTranslate extends JavaPlugin {
    Gson gson = (new GsonBuilder()).setLenient().create();
    public JsonObject advancements;


    @Override
    public void onEnable() {
        advancements = this.getAdvancements();
        new Expansion(this).register();
    }

    private JsonObject getAdvancements() {
        InputStream is = this.getResource("advancements.json");
        byte[] bytes = new byte[0];

        try {
            bytes = new byte[is.available()];
            is.read(bytes);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        String str = new String(bytes);
        JsonObject obj = gson.fromJson(str, JsonObject.class);
        return obj;
    }
}
