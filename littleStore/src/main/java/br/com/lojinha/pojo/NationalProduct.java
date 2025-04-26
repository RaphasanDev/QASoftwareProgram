package br.com.lojinha.pojo;

import br.com.lojinha.enums.Size;
import br.com.lojinha.interfaces.Favorite;

public class NationalProduct extends Product implements Favorite {
   private double nationalTax;

    //If the extended class has a constructor, it is mandatory to give the information that is requested in the constructor of the extended class
    public NationalProduct(String initialBrand, Size initialSize) {
        super(initialBrand, initialSize);
    }

    public double getNationalTax() {
        return this.nationalTax;
    }

    public void setNationalTax(double nationalTax) {
        this.nationalTax = nationalTax;
    }

    public String getFavoriteData(){
        return this.getName() + ", " + this.getBrand() + ", " + this.getValue();
    }
}
