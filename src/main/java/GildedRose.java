import java.util.ArrayList;
import java.util.List;


public class GildedRose {
    private static final int MAX_QUALITY = 50;

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
    }


    public static List<Item> updateQuality(List<Item> items) {
        for (Item item : items) {
            if (itemQuiPerdQualite(item)) {
                diminueQualite(item);
            } else {
                augmenterQualite(item);

                if (backstagePass(item)) {
                    updateBackstagePassQualite(item);
                }
            }

            if (itemDoitEtreVenduEventuellement(item)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (itemDepasseDate(item)) {
                if (!agedBrie(item)) {
                    if (!backstagePass(item)) {
                        if (item.getQuality() > 0 && itemDoitEtreVenduEventuellement(item)) {
                            diminueQualite(item);
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    augmenterQualite(item);
                }
            }
        }

        return items;
    }

    private static boolean itemDepasseDate(Item item) {
        return item.getSellIn() < 0;
    }

    private static void diminueQualite(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    private static boolean itemDoitEtreVenduEventuellement(Item item) {
        return !sulfuras(item);
    }

    private static void augmenterQualite(Item item) {
        if (item.getQuality() < MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private static boolean itemQuiPerdQualite(Item item) {
        return !agedBrie(item) && !backstagePass(item) && item.getQuality() > 0 && !sulfuras(item);
    }

    private static void updateBackstagePassQualite(Item item) {
        if (item.getSellIn() < 11) {
            item.setQuality(item.getQuality() + 1);
        }

        if (item.getSellIn() < 6) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private static boolean backstagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    private static boolean sulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private static boolean agedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
    }

}