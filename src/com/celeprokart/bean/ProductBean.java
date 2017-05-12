package com.celeprokart.bean;

public class ProductBean {

	String product_name;
	String category;
	String sellordonate;
	String price;
	String image;
	String charity;
	String celebrity;
	int product_id;
	String flag;
	String celebName;

	public String getCelebName() {
		return celebName;
	}
	public void setCelebName(String celebName) {
		this.celebName = celebName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getCelebrity() {
		return celebrity;
	}
	public void setCelebrity(String celebrity) {
		this.celebrity = celebrity;
	}
	public String getCharity() {
		return charity;
	}
	public void setCharity(String charity) {
		this.charity = charity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSellordonate() {
		return sellordonate;
	}
	public void setSellordonate(String sellordonate) {
		this.sellordonate = sellordonate;
	}
	@Override
	public String toString() {
		return "ProductBean [product_name=" + product_name + ", category=" + category + ", sellordonate=" + sellordonate
				+ ", price=" + price + ", image=" + image + ", charity=" + charity + ", celebrity=" + celebrity + "]";
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
