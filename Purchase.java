package hackerrank;

import java.util.List;

/**
 *	TODO: Complete the Purchase class
 */
public class Purchase {
    /**
     * Find the PurchasedItems for each of the given barcodes.
     *
     * @param itemBarcodeList A list of barcodes.
     * @return A list of PurchasedItems.
     */
    public static List<PurchasedItem> getPurchasedItemsList(List<String> itemBarcodeList) {
        // TODO: Complete the function.
        itemBarcodeList.forEach(itemBarcode->{

        });
        return null;
    }

    /**
     * Find the total number of available items in the given category.
     *
     * @param category The item's category.
     * @return The number of available items in that category.
     */
    public static Integer getNumberOfAvailableItemsInCategory(String category) {
    	// TODO: Complete the function.
        return 0;
    }

    /**
     * Find the total number of available items priced lower than upperLimit.
     *
     * @param upperLimit
     * @return available items with lower price than upperLimit
     */
    public static Integer getTotalAvailableLowerPricedItemsWithoutDiscount(Float upperLimit) {
    	// TODO: Complete the function.
        return 0;
    }

    /**
     * Find the total number of available items priced higher than lowerLimit.
     * @param lowerLimit
     * @return available items with higher price than lowerLimit
     */
    public static Integer getTotalAvailableHigherPricedItemsWithoutDiscount(Float lowerLimit) {
    	// TODO: Complete the function.
        return 0;
    }

    /**
     * Find whether the item with the given barcode is available.
     *
     * @param barcode The item's barcode.
     * @return true if the item is available and false if it is not.
     */
    public static boolean isAvailable(String barcode) {
    	// TODO: Complete the function.
        return true;
    }

    /**
     * Count the total number of available items.
     *
     * @return The total number of available items.
     */
    public static Integer getTotalAvailableItems() {
    	// TODO: Complete the function.
        return 0;
    }

    /**
     * Count the total number of unavailable items.
     *
     * @return The total number of unavailable items.
     */
    public static Integer getTotalUnAvailableItems() {
    	// TODO: Complete the function.
        return 0;
    }
}
