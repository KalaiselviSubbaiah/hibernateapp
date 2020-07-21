package hibernateapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import persistent.Item;

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
    	HashMap<String, Object> barCodeMap = new HashMap<>();
    	barCodeMap.put("itemBarcodeList", itemBarcodeList);
    	 PurchasedItem purIte = null ;
    	 List<PurchasedItem> getPurItems = new ArrayList();
    	 List<Item> items = new ArrayList();
    	 Optional<HashMap<String, Object>> namedParameters =  Optional.of(barCodeMap);
    	
    	 String hql  = "FROM Item   WHERE itemBarcode IN :itemBarcodeList and itemAvailablity =1";
    	 
    	 items = HibernateQueryRunner.getItemsList(hql, namedParameters);
    	
        // TODO: Complete the function.
    	 for (Item outitems : items)  
         {
    		//getting discounted price
    		 float reducedPrice = outitems.getItemPrice() * (100- outitems.getItemDiscount())/100;
    		 purIte = new PurchasedItem(outitems.getItemBarcode(),outitems.getItemName(),outitems.getItemCategory(),reducedPrice);
    		 getPurItems.add(purIte);
    		
         }
    	 getPurItems.forEach(System.out::println);
        return getPurItems;
    }

    /**
     * Find the total number of available items in the given category.
     *
     * @param category The item's category.
     * @return The number of available items in that category.
     */
    public static Integer getNumberOfAvailableItemsInCategory(String category) {
    	// TODO: Complete the function.
    	HashMap<String, Object> categoryMap = new HashMap<>();
    	categoryMap.put("category", category);
    	 Optional<HashMap<String, Object>> namedParameters =  Optional.of(categoryMap);
        String hql  = "  Select count(*) FROM Item   WHERE itemCategory IN :category and itemAvailablity =1 group by itemCategory";
        TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
        if (namedParameters.isPresent()) {
            namedParameters.get().forEach(query::setParameter);
        }
        
        return query.getSingleResult().intValue();
  
    }

    /**
     * Find the total number of available items priced lower than upperLimit.
     *
     * @param upperLimit
     * @return available items with lower price than upperLimit
     */
    public static Integer getTotalAvailableLowerPricedItemsWithoutDiscount(Float upperLimit) {
    	HashMap<String, Object> limitMap = new HashMap<>();
    	limitMap.put("upperLimit", upperLimit);
    	 Optional<HashMap<String, Object>> namedParameters =  Optional.of(limitMap);
        String hql  = "  Select count(*) FROM Item   WHERE itemPrice < :upperLimit and itemAvailablity =1 ";
        TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
        if (namedParameters.isPresent()) {
            namedParameters.get().forEach(query::setParameter);
        }
        
        return query.getSingleResult().intValue();
    }

    /**
     * Find the total number of available items priced higher than lowerLimit.
     * @param lowerLimit
     * @return available items with higher price than lowerLimit
     */
    public static Integer getTotalAvailableHigherPricedItemsWithoutDiscount(Float lowerLimit) {
    	HashMap<String, Object> limitMap = new HashMap<>();
    	limitMap.put("lowerLimit", lowerLimit);
    	 Optional<HashMap<String, Object>> namedParameters =  Optional.of(limitMap);
        String hql  = "  Select count(*) FROM Item   WHERE itemPrice > :lowerLimit and itemAvailablity =1 ";
        TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
        if (namedParameters.isPresent()) {
            namedParameters.get().forEach(query::setParameter);
        }
        
        return query.getSingleResult().intValue();
    }

    /**
     * Find whether the item with the given barcode is available.
     *
     * @param barcode The item's barcode.
     * @return true if the item is available and false if it is not.
     */
    public static boolean isAvailable(String barcode) {
    	boolean isAvailable = false;
    	
    	// TODO: Complete the function.
    	HashMap<String, Object> barcodeMap = new HashMap<>();
    	barcodeMap.put("barcode", barcode);
    	 Optional<HashMap<String, Object>> namedParameters =  Optional.of(barcodeMap);
        String hql  = "  Select count(*) FROM Item   WHERE itemBarcode IN :barcode and itemAvailablity =1 ";
        TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
        if (namedParameters.isPresent()) {
            namedParameters.get().forEach(query::setParameter);
        }
     if(query.getSingleResult().intValue() != 0 )  isAvailable = true;
        
        return isAvailable;
    }

    /**
     * Count the total number of available items.
     *
     * @return The total number of available items.
     */
    public static Integer getTotalAvailableItems() {
    
        String hql  = "  Select count(*) FROM Item   WHERE  itemAvailablity =1 ";
        TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
       
        
        return query.getSingleResult().intValue();
    }

    /**
     * Count the total number of unavailable items.
     *
     * @return The total number of unavailable items.
     */
    public static Integer getTotalUnAvailableItems() {
    	 String hql  = "  Select count(*) FROM Item   WHERE  itemAvailablity =0 ";
         TypedQuery<Long> query = HibernateSessionHelper.session.createQuery(hql);
        
         
         return query.getSingleResult().intValue();
    }
}
