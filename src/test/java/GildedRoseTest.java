import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {

	@Test
	public void dexterityVestDecreasesTo9and18() {
		//Given
        List<Item> list = new ArrayList<Item>();

        list.add(new Item("+5 Dexterity Vest", 10, 20));

        assertEquals(9, GildedRose.updateQuality(list).get(0).getSellIn());
        assertEquals(18, GildedRose.updateQuality(list).get(0).getQuality());
	}
}
