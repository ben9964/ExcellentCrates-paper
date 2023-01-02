package su.nightexpress.excellentcrates.editor;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import su.nexmedia.engine.api.editor.EditorButtonType;
import su.nexmedia.engine.utils.ComponentUtil;
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.excellentcrates.config.Config;
import su.nightexpress.excellentcrates.hooks.HookId;

import java.util.ArrayList;
import java.util.List;

public enum CrateEditorType implements EditorButtonType {

    EDITOR_CRATES(Material.ENDER_CHEST, "Crate Editor",
        EditorButtonType.info("Create and configure your crates here!"),
        EditorButtonType.click("Left-Click to <white>Navigate</white>")),
    EDITOR_KEYS(Material.TRIPWIRE_HOOK, "Key Editor",
        EditorButtonType.info("Create and configure crate keys here!"),
        EditorButtonType.click("Left-Click to <white>Navigate</white>")),

    CRATE_OBJECT(Material.CHEST, "<yellow>" + Placeholders.CRATE_NAME + "</yellow> <gray>(ID: <white>" + Placeholders.CRATE_ID + "</white>)",
        EditorButtonType.click("Left-Click to <white>Edit</white>\nShift-Right to <white>Delete <gray>(No Undo)")),
    CRATE_CREATE(Material.ANVIL, "Create a Crate",
        EditorButtonType.info("Creates a new crate."),
        EditorButtonType.click("Left-Click to <white>Create</white>")),
    CRATE_CHANGE_NAME(Material.NAME_TAG, "Crate Display Name",
        EditorButtonType.current(Placeholders.CRATE_NAME),
        EditorButtonType.info("Sets the crate display name. This name is used in messages, GUIs, holograms, etc."),
        EditorButtonType.click("Left-Click to <white>Change</white>")),
    CRATE_CHANGE_PERMISSION(Material.REDSTONE, "Permission Requirement",
        EditorButtonType.current("Enabled: <white>" + Placeholders.CRATE_PERMISSION_REQUIRED + "</white>\nNode: <white>" + Placeholders.CRATE_PERMISSION + "</white>"),
        EditorButtonType.info("Sets whether permission is required to open this crate."),
        EditorButtonType.click("Left-Click to <white>Toggle</white>")),
    CRATE_CHANGE_COOLDOWN(Material.CLOCK, "Open Cooldown",
        EditorButtonType.current(Placeholders.CRATE_OPENING_COOLDOWN),
        EditorButtonType.info("Sets the cooldown for opening this crate again."),
        EditorButtonType.note("When set a negative value, crate can be opened only once."),
        EditorButtonType.click("Left-Click to <white>Change</white>\nRight-Click to <white>Disable</white>\n[Q] Key to <white>One-Timed</white>")),
    CRATE_CHANGE_CONFIG(Material.PAINTING, "GUI Layout",
        EditorButtonType.current("Preview: <white>" + Placeholders.CRATE_PREVIEW_CONFIG + "</white>\nOpening: <white>" + Placeholders.CRATE_ANIMATION_CONFIG + "</white>"),
        EditorButtonType.info("Sets the configuration used for crate Preview and Opening GUIs."),
        EditorButtonType.note("You can create/edit crate Previews in " + Config.DIR_PREVIEWS + " folder."),
        EditorButtonType.note("You can create/edit crate Openings in " + Config.DIR_OPENINGS + " folder."),
        EditorButtonType.click("Left-Click to <white>Change Opening</white>\nRight-Click to <white>Disable Opening</white>\nShift-Left to <white>Change Preview</white>\nShift-Right to <white>Disable Preview</white>")),
    CRATE_CHANGE_CONFIG_OPENING,
    CRATE_CHANGE_CONFIG_PREVIEW,
    CRATE_CHANGE_KEYS(Material.TRIPWIRE_HOOK, "Attached Keys",
        EditorButtonType.current(Placeholders.CRATE_KEY_IDS),
        EditorButtonType.info("Sets a list of crate keys, that will open this crate."),
        EditorButtonType.note("If no keys are attached, crate can be opened without any key(s)."),
        EditorButtonType.warn("Make sure to provide correct key identifiers!"),
        EditorButtonType.click("Left-Click to <white>Add Key</white>\nRight-Click to <white>Clear List</white>")),
    CRATE_CHANGE_CITIZENS(Material.PLAYER_HEAD, "Attached Citizens NPCs",
        EditorButtonType.current("NPC Ids:\n" + Placeholders.CRATE_ATTACHED_CITIZENS),
        EditorButtonType.info("Sets a list of NPC Ids that will open and preview this crate on clicks."),
        EditorButtonType.warn("You must have Citizens plugin installed!"),
        EditorButtonType.click("Left-Click to <white>Add NPC</white>\nRight-Click to <white>Clear List</white>")),
    CRATE_CHANGE_OPEN_COST(Material.GOLD_NUGGET, "Open Cost",
        EditorButtonType.current("Money: <white>$" + Placeholders.CRATE_OPENING_COST_MONEY + "</white>\nExp Levels: <white>" + Placeholders.CRATE_OPENING_COST_EXP + "</white>"),
        EditorButtonType.info("Sets how many money/exp player will have to pay to open this crate."),
        EditorButtonType.warn("You must have Vault + Economy plugins installed for the Money cost to work!"),
        EditorButtonType.click("Left-Click to <white>Change Money</white>\nRight-Click to <white>Change Exp</white>\nShift-Left to <white>Disable Money</white>\nShift-Right to <white>Disable Exp</white>")),
    CRATE_CHANGE_OPEN_COST_MONEY,
    CRATE_CHANGE_OPEN_COST_EXP,
    CRATE_CHANGE_ITEM(Material.ENDER_CHEST, "Crate Item",
        EditorButtonType.current(Placeholders.CRATE_ITEM_NAME),
        EditorButtonType.info("Sets the crate item, that will be used when you give this crate to players, or adding it to crate menus."),
        EditorButtonType.note("Apply custom item name, lore and other settings before you put it here for best result."),
        EditorButtonType.click("Drag & Drop to <white>Replace</white>\nRight-Click to <white>Get Item</white>")),

    CRATE_CHANGE_BLOCK_LOCATION(Material.CHEST, "Block Locations & Pushback",
        EditorButtonType.current(Placeholders.CRATE_BLOCK_LOCATIONS + "\nPushback Enabled: <white>" + Placeholders.CRATE_BLOCK_PUSHBACK_ENABLED + "</white>"),
        EditorButtonType.info("Sets a list of block locations to which this crate will be attached. When clicking on that blocks, it will preview or open the crate.\nAlso sets if the crate should push players back when they can't open the crate."),
        EditorButtonType.click("Left-Click to <white>Assign Block</white>\nRight-Click to <white>Clear List</white>\n[Q] Key to <white>Toggle Pushback</white>")),
    CRATE_CHANGE_BLOCK_HOLOGRAM(Material.ARMOR_STAND, "Block Hologram",
        EditorButtonType.current("Enabled: <white>" + Placeholders.CRATE_BLOCK_HOLOGRAM_ENABLED + "</white>\nY Offset: <white>" + Placeholders.CRATE_BLOCK_HOLOGRAM_OFFSET_Y + "</white>\nText:\n" + Placeholders.CRATE_BLOCK_HOLOGRAM_TEXT),
        EditorButtonType.info("Sets the hologram text to appear above the crate block(s)."),
        EditorButtonType.warn("You must have holograms plugin installed:\n- " + HookId.HOLOGRAPHIC_DISPLAYS + "\n- " + HookId.DECENT_HOLOGRAMS),
        EditorButtonType.click("Left-Click to <white>Add Line</white>\nRight-Click to <white>Clear Text</white>\nShift-Left to <white>Toggle Hologram</white>\nShift-Right to <white>Change Y Offset</white>")),
    CRATE_CHANGE_BLOCK_HOLOGRAM_TEXT,
    CRATE_CHANGE_BLOCK_HOLOGRAM_OFFSET_Y,
    CRATE_CHANGE_BLOCK_EFFECT(Material.BLAZE_POWDER, "Block Effect",
        EditorButtonType.current("Model: <white>" + Placeholders.CRATE_BLOCK_EFFECT_MODEL + "</white>\nParticle: <white>" + Placeholders.CRATE_BLOCK_EFFECT_PARTICLE_NAME + "</white>\nData: <white>" + Placeholders.CRATE_BLOCK_EFFECT_PARTICLE_DATA + "</white>"),
        EditorButtonType.info("Sets effect to play around the crate blocks infinitely."),
        EditorButtonType.note("Data format for colored particles: 'R,G,B' (255,0,0)"),
        EditorButtonType.note("Data format for item/block particles: MATERIAL_NAME (SAND)"),
        EditorButtonType.click("[Q] Key to <white>Toggle Model</white>\nLeft-Click to <white>Change Particle</white>\nRight-Click to <white>Change Data</white>")),
    CRATE_CHANGE_BLOCK_EFFECT_PARTICLE_NAME,
    CRATE_CHANGE_BLOCK_EFFECT_PARTICLE_DATA,
    CRATE_CHANGE_REWARDS(Material.EMERALD, "Crate Rewards",
        EditorButtonType.info("Here you can create and manage rewards for the crate."),
        EditorButtonType.click("Left-Click to <white>Navigate</white>")),

    REWARD_OBJECT(Material.EMERALD, "<yellow>" + Placeholders.REWARD_NAME + " <gray>(ID: <white>" + Placeholders.REWARD_ID + "</white>)",
        EditorButtonType.info("Chance: <white>" + Placeholders.REWARD_CHANCE + "%</white>"),
        EditorButtonType.click("Left-Click to <white>Edit</white>\n[Q] Key to <white>Delete <gray>(No Undo)\nShift-Left to <white>Move Forward</white>\nShift-Right to <white>Move Back</white>")),
    REWARD_CREATE(Material.ANVIL, "Create Reward",
        EditorButtonType.info("Creates a new reward for the crate."),
        EditorButtonType.click("Left-Click to <white>Create</white>\nDrag & Drop to <white>Quick Create</white>")),
    REWARD_SORT(Material.COMPARATOR, "Sort Rewards",
        EditorButtonType.info("Automatically sort your rewards in a certain order."),
        EditorButtonType.click("Left-Click to <white>Sort by Chance</white>\nRight-Click to <white>Sort by Type</white>\nShift-Left to <white>Sort by Name</white>")),
    REWARD_CHANGE_NAME(Material.NAME_TAG, "Reward Display Name",
        EditorButtonType.current(Placeholders.REWARD_NAME),
        EditorButtonType.info("Sets the reward display name. This name is used in messages mostly."),
        EditorButtonType.warn("This is NOT the reward preview item name!"),
        EditorButtonType.click("Left-Click to <white>Change</white>\nRight-Click to <white>Sync with Preview Name</white>")),
    REWARD_CHANGE_PREVIEW(Material.ITEM_FRAME, "Preview Item",
        EditorButtonType.current(Placeholders.REWARD_PREVIEW_NAME),
        EditorButtonType.info("Sets the preview item for this reward. This item will be displayed in crate preview and opening GUIs to display rewards."),
        EditorButtonType.note("Apply custom name, lore and other settings to the item before put it here for best result."),
        EditorButtonType.click("Drag & Drop to <white>Replace</white>\nRight-Click to <white>Get Item</white>")),
    REWARD_CHANGE_CHANCE(Material.COMPARATOR, "Chance",
        EditorButtonType.current(Placeholders.REWARD_CHANCE + "%"),
        EditorButtonType.info("Sets the chance for this reward to be rolled."),
        EditorButtonType.note("Reward chances works as 'weight' actually, so they don't have to be up to 100%."),
        EditorButtonType.click("Left-Click to <white>Change</white>")),
    REWARD_CHANGE_COMMANDS(Material.COMMAND_BLOCK, "Reward Commands",
        EditorButtonType.current(Placeholders.REWARD_COMMANDS),
        EditorButtonType.info("A list of commands that will be executed when this reward is given to the player."),
        EditorButtonType.note("Look in chat for command prefixes when adding a command."),
        EditorButtonType.click("Left-Click to <white>Add Command</white>\nRight-Click to <white>Clear List</white>")),
    REWARD_CHANGE_ITEMS(Material.CHEST_MINECART, "Reward Items",
        EditorButtonType.info("A list of items that will be added to the player's inventory when this reward is given."),
        EditorButtonType.note("Simply close the inventory to save & return."),
        EditorButtonType.click("Left-Click to <white>Navigate</white>")),
    REWARD_CHANGE_BROADCAST(Material.ENDER_EYE, "Broadcast",
        EditorButtonType.current("Enabled: <white>" + Placeholders.REWARD_BROADCAST + "</white>"),
        EditorButtonType.info("Sets whether a win message will be broadcasted to all online players for this reward."),
        EditorButtonType.click("Left-Click to <white>Toggle</white>")),
    REWARD_CHANGE_WIN_LIMITS(Material.REPEATER, "Win Limits",
        EditorButtonType.current("Amount: <white>" + Placeholders.REWARD_WIN_LIMIT_AMOUNT + "</white>\nCooldown: <white>" + Placeholders.REWARD_WIN_LIMIT_COOLDOWN + "</white>"),
        EditorButtonType.info("Sets how many times and how often this reward can be rolled out to the player."),
        EditorButtonType.note("Set amount to -1 for unlimit."),
        EditorButtonType.note("Set cooldown to -1 for a one-time reward."),
        EditorButtonType.warn("Limit is per player, not a global one."),
        EditorButtonType.click("Left-Click to <white>Change Amount</white>\nRight-Click to <white>Change Cooldown</white>\n[Q] Key to <white>Disable</white>")),
    REWARD_CHANGE_WIN_LIMITS_AMOUNT,
    REWARD_CHANGE_WIN_LIMITS_COOLDOWN,

    KEY_OBJECT(Material.TRIPWIRE_HOOK, "<yellow>" + Placeholders.KEY_NAME + " <gray>(ID: <white>" + Placeholders.KEY_ID + "</white>)",
        EditorButtonType.note("Is Virtual: <white>" + Placeholders.KEY_VIRTUAL + "</white>"),
        EditorButtonType.click("Left-Click to <white>Edit</white>\nShift-Right to <white>Delete <gray>(No Undo)")),
    KEY_CREATE(Material.ANVIL, "Create Key",
        EditorButtonType.info("Creates a new crate key."),
        EditorButtonType.click("Left-Click to <white>Create</white>")),
    KEY_CHANGE_NAME(Material.NAME_TAG, "Key Display Name",
        EditorButtonType.current(Placeholders.KEY_NAME),
        EditorButtonType.info("Sets the key display name. This name is used in messages mostly."),
        EditorButtonType.warn("This option does not affect display name of the key item!"),
        EditorButtonType.click("Left-Click to <white>Change</white>")),
    KEY_CHANGE_ITEM(Material.TRIPWIRE_HOOK, "Key Item",
        EditorButtonType.current(Placeholders.KEY_ITEM_NAME),
        EditorButtonType.info("Sets the key item, that will be used when key is given to player's inventory."),
        EditorButtonType.note("Apply custom name, lore and other settings before put item here for best result."),
        EditorButtonType.click("Drag & Drop to <white>Replace</white>\nRight-Click to <white>Get Item</white>")),
    KEY_CHANGE_VIRTUAL(Material.ENDER_PEARL, "Virtual Key",
        EditorButtonType.current("Is Virtual: <white>" + Placeholders.KEY_VIRTUAL + "</white>"),
        EditorButtonType.info("Sets whether this key is a virtual key. Virtual keys can not be given as inventory items and are stored in the database."),
        EditorButtonType.click("Left-Click to <white>Toggle</white>")),
    ;

    private final Material        material;
    private       Component       name;
    private       List<Component> lore;

    CrateEditorType() {
        this(Material.AIR, "", "");
    }

    CrateEditorType(@NotNull Material material, @NotNull String name, @NotNull String... lore) {
        this.material = material;
        this.setName(ComponentUtil.asComponent(name));
        this.setLore(ComponentUtil.asComponent(EditorButtonType.fineLore(lore)));
    }

    @NotNull
    @Override
    public Material getMaterial() {
        return material;
    }

    @NotNull
    public Component getName() {
        return name;
    }

    public void setName(@NotNull Component name) {
        this.name = name;
    }

    @NotNull
    public List<Component> getLore() {
        return lore;
    }

    public void setLore(@NotNull List<Component> lore) {
        this.lore = new ArrayList<>(lore);
    }
}
