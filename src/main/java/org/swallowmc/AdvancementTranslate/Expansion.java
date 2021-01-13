
package org.swallowmc.AdvancementTranslate;

import com.google.gson.JsonObject;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Expansion extends PlaceholderExpansion {
    private AdvancementTranslate plugin;

    public Expansion(AdvancementTranslate plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {

        return true;
    }

    @Override
    public String getAuthor() {
        return this.plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier() {
        return "AdvancementTranslate";
    }

    @Override
    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        JsonObject advancements = plugin.advancements;
        try {
            return advancements.get(identifier).getAsString();
        } catch (Exception e) {
            plugin.getLogger().warning("无法找到进度["+identifier+"]的翻译！");
            return identifier;
        }
    }
}
