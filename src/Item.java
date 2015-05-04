

public class Item {

	private String pageURL;
	private Integer quantity;
	private Double budgetPrice;
	
	public Item(String pageURL, Double budgetPrice, Integer quantity) {
		this.pageURL = pageURL;
		this.quantity = quantity;
		this.budgetPrice = budgetPrice;
	}
	
	public Double getBudgetPrice() {
		return budgetPrice;
	}
	
	public String getPageURL() {
		return pageURL;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void substractItemQuantity(){
		this.quantity --;
	}
	
}
