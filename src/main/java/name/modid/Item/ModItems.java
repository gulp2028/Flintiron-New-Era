package name.modid.ModItems

public class ModItems {
    public static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(Flintiron.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        return Registry.register(
                Registries.ITEM,
                id,
                factory.apply(new Item.Settings().registryKey(key))
        );
    }

}

