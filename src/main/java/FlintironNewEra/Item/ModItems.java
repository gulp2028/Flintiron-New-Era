package FlintironNewEra.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {

    public static Item COPPER_CARTRIDGE;
    public static Item CRUDE_POWDER;
    public static Item IRON_CARTRIDGE;
    public static Item GOLD_CARTRIDGE;
    public static Item FLINTSTONE_CARTRIDGE;
    // ignores (vanilla) armour
    public static Item FLINTSTONE_INGOT;
    public static Item RAW_FLINTSTONE;
    public static Item MUSKET;
    public static Item FLINTSTONE_ORE_ITEM;
    public static Item POLISH;
    public static Item CARTRIDGE;

    public static Item register(Block block) {
        return register(new BlockItem(block, new Item.Settings()));
    }

    public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
        return register(new BlockItem(block, (Item.Settings)settingsOperator.apply(new Item.Settings())));
    }

    public static Item register(Block block, Block... blocks) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings());

        for(Block block2 : blocks) {
            Item.BLOCK_ITEMS.put(block2, blockItem);
        }

        return register(blockItem);
    }

    public static Item register(BlockItem item) {
        return register((Block)item.getBlock(), item);
    }

    public static Item register(Block block, Item item) {
        return register(Registries.BLOCK.getId(block), item);
    }

    public static Item register(String id, Item item) {
        return register(Identifier.ofVanilla(id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item) Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(FLINTSTONE_INGOT);
            content.add(CRUDE_POWDER);
            content.add(POLISH);
        });


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(COPPER_CARTRIDGE);
            content.add(IRON_CARTRIDGE);
            content.add(GOLD_CARTRIDGE);
            content.add(FLINTSTONE_CARTRIDGE);
            content.add(MUSKET);
            content.add(CARTRIDGE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.add(RAW_FLINTSTONE);

        });



}}
