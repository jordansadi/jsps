package us.jordan.model;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
    private List<Item> itemCatalog = new ArrayList<>();
    private int nextProductNumber;

    public ItemCatalog() {
        nextProductNumber = 1;
        itemCatalog.add(new Item(nextProductNumber++, "MilwaukeeHome Shirt", 30.99, "T-shirts and sweatshirts in every color you can think of"));
        itemCatalog.add(new Item(nextProductNumber++, "Wiskullsin Shirt", 30.99, "Wisconsin pride with a sp00ky vibe"));
        itemCatalog.add(new Item(nextProductNumber++, "Giltee Shirt", 30.99, "Classy Milwaukee shirts from a local brand"));
        itemCatalog.add(new Item(nextProductNumber++, "Orchard Street Apparel Shirt", 30.99, "T-shirts and sweatshirts in every color you can think of"));
        itemCatalog.add(new Item(nextProductNumber++, "Brew City Brand Shirt", 25.99, "Milwaukee pride for the kids"));
        itemCatalog.add(new Item(nextProductNumber++, "Fern & Nettle Soap", 8.99, "Locally-made soaps with unexpected smells"));
        itemCatalog.add(new Item(nextProductNumber++, "Tactile Craftworks Wallet", 15.99, "Feel like a fancy person with these leather wallets"));
        itemCatalog.add(new Item(nextProductNumber++, "Dear Darlington Jewelry", 20.99, "Support local artists while taking your outfits to the next level"));
        itemCatalog.add(new Item(nextProductNumber++, "Paper Pleasers Mug", 12.99, "Decorated with the Milwaukee skyline"));
        itemCatalog.add(new Item(nextProductNumber++, "Indulgence Chocolatiers Chocolate", 6.99, "You're going to eat chocolate anyway, so it might as well be locally made"));
    }

    public List<Item> getItemCatalog() {
        return itemCatalog;
    }

    public Item getSingleItem(int itemNum) {
        Item item=null;

        for(Item i: itemCatalog) {
            if (i.getProductNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }
}
