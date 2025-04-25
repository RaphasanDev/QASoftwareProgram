package br.com.lojinha.pojo;

import br.com.lojinha.enums.Size;
import br.com.lojinha.interfaces.Favorite;

public class InternationalProduct extends Product implements Favorite {
    private double importedTax;

    //If the extended class has a constructor, it is mandatory to give the information that is requested in the constructor of the extended class
    public InternationalProduct(String initialBrand, Size initialSize) {
        super(initialBrand, initialSize);
    }


    public void setValue(double newValue) {
        if(newValue > -100){
            this.value = newValue;
        }else{
            throw new IllegalArgumentException("Values must be greater than -100!");
        }
    }

    public void setImportedTax(double importedTax) {
        this.importedTax = importedTax;
    }

    public double getImportedTax() {
        return importedTax;
    }

    public String getFavoriteData() {
        return this.getName() + ", " + this.getBrand() + ", " + this.getValue();
    }
}
