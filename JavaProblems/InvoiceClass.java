public class InvoiceClass
{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
    private double amount;
    
    public InvoiceClass( String partNumber, String partDescription, int quantity, double pricePerItem)
    {
        this.setPartNumber(partNumber);
        this.setPartDescription(partDescription);
        this.setQuantity(quantity);
        this.setPricePerItem(pricePerItem);
    }
    
    public void setPartNumber(String partNumber)
    {
        this.partNumber = partNumber;
    }
        
    public String getPartNumber()
    {
        return partNumber;
    }
    
    public void setPartDescription(String partDescription)
    {
        this.partDescription = partDescription;
    }
        
    public String getPartDescription()
    {
        return partDescription;
    }
    
    public void setQuantity(int quantity)
    {
        if(quantity > 0)
            {this.quantity = quantity;}
        else 
            {this.quantity = 0;}
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setPricePerItem(double pricePerItem)
    {
        if(pricePerItem > 0)
            {this.pricePerItem = pricePerItem;}
        else 
            {this.pricePerItem = 0.0;}
    }
    
    public double getPricePerItem()
    {
        return pricePerItem;
    }
    
    private double getInvoiceAmount()
    {
        amount = getPricePerItem() * getQuantity();
        return amount;    
    }
    
    public String toString()
    {
        return "Part Number " + getPartNumber() + " PartDescription " + getPartDescription() 
        + " Quantity " + getQuantity() + " Price Per Item" + getPricePerItem() + " Amount " + getInvoiceAmount();
    }
    
    public void print()
    {
        System.out.println(toString());
    }

}

