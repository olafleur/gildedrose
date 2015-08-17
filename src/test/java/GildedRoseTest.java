import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {
    private List<Item> list;

    @Before
    public void before() {
        list = new ArrayList<Item>();
    }

	@Test
	public void dexterityVest() {
        list.add(new Item("+5 Dexterity Vest", 10, 20));

        List<Item> resultingList = GildedRose.updateQuality(list);

        assertEquals(9, resultingList.get(0).getSellIn());
        assertEquals(19, resultingList.get(0).getQuality());
	}

    @Test
    public void agedBrie() {
        list.add(new Item("Aged Brie", 2, 0));

        List<Item> resultingList = GildedRose.updateQuality(list);

        assertEquals(1, resultingList.get(0).getSellIn());
        assertEquals(1, resultingList.get(0).getQuality());
    }

    @Test
    public void elixir() {
        list.add(new Item("Elixir of the Mongoose", 5, 7));

        List<Item> resultingList = GildedRose.updateQuality(list);

        assertEquals(4, resultingList.get(0).getSellIn());
        assertEquals(6, resultingList.get(0).getQuality());
    }
}
