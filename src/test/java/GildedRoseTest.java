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

        assertEquals(9, GildedRose.updateQuality(list).get(0).getSellIn());
        assertEquals(18, GildedRose.updateQuality(list).get(0).getQuality());
	}

    @Test
    public void agedBrie() {
        list.add(new Item("Aged Brie", 2, 0));

        assertEquals(1, GildedRose.updateQuality(list).get(0).getSellIn());
        assertEquals(2, GildedRose.updateQuality(list).get(0).getQuality());
    }
}
