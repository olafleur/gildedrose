import java.util.ArrayList;
import java.util.List;


public class GildedRose {
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
            if (!agedBrie(item) && !backstagePass(item)) {
                if (item.getQuality() > 0) {
                    if (!sulfuras(item)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (backstagePass(item)) {
                        if (item.getSellIn() < 11 && item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }

                        if (item.getSellIn() < 6 && item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }

            if (!sulfuras(item)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!agedBrie(item)) {
                    if (!backstagePass(item)) {
                        if (item.getQuality() > 0) {
                            if (!sulfuras(item)) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }

        return items;
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