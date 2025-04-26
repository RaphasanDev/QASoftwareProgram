package br.com.lojinha.pojo;

import br.com.lojinha.enums.Size;

import java.util.List;

public class Product {
    private String name;
    private String brand;
    protected double value;
    private List<AdditionalItem> includedItems;
    private Size size;

    public Product(String initialBrand, Size initialSize) {
        this.brand = initialBrand;
        this.size = initialSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        if(newValue > 0){
            this.value = newValue;
        }else{
            throw new IllegalArgumentException("Values must be greater than zero!");
        }
    }

    public List<AdditionalItem> getIncludedItems() {
        return includedItems;
    }

    public void setIncludedItems(List<AdditionalItem> includedItems) {
        this.includedItems = includedItems;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size newSize) {

        //if(newSize.equalsIgnoreCase("Small") || newSize.equalsIgnoreCase("Medium") || newSize.equalsIgnoreCase("Large")){
        //    this.size = newSize;
        //}else{
        //    throw new IllegalArgumentException("Size must be small, medium or large");
        //}
        //Those lines are not the best way to limit the choices. We should use ENUM as a best practice.
        this.size = newSize;
    }
}
