package es.unileon.springapp.domain;

import es.unileon.springapp.domain.Buyable;


public abstract class Pack {

    protected final Buyable product;

    protected int amount;

    public Pack(Buyable product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }


    /**
     * @return the product
     */
    public Buyable getProduct() {
        return product;
    }
    
    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
