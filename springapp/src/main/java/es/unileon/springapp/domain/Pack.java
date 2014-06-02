package es.unileon.springapp.domain;

import es.unileon.springapp.domain.Buyable;


public abstract class Pack {

    private Buyable product;

    private int amount;

    public Pack(){
    	
    }
    
    public Pack(Buyable product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }


    /**
     * @return the product
     */
    public Buyable getProduct() {
        return product;
    }
    
    public void setProduct(Buyable product) {
        this.product = product;
    }
    
    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
