package com.dev.simplegallery.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * <p>
 */
public class DummyContent {

    /**
     * An array of sample (product) items.
     */
    public static final List<ProductItem> ITEMS = new ArrayList<ProductItem>();

    /**
     * A map of sample (product) items, by ID.
     */
    public static final Map<String, ProductItem> ITEM_MAP = new HashMap<String, ProductItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createProductItem(i));
        }
    }

    private static void addItem(ProductItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ProductItem createProductItem(int position) {
        return new ProductItem(String.valueOf(position),
                "Item " + position,
                makeDescription(),
                makePrice());
    }

    private static String makeDescription() {
        return "Product description";
    }

    private static float makePrice() {
        return 59.9f;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ProductItem {
        public final String id;
        public final String imgUrl;
        public final String description;
        public final float price;

        public ProductItem(String id, String imgUrl, String description, float price) {
            this.id = id;
            this.imgUrl = imgUrl;
            this.description = description;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductItem{" +
                    "id='" + id + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
