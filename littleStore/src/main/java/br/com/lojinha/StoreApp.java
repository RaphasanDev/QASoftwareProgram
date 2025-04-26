package br.com.lojinha;

import br.com.lojinha.enums.Size;
import br.com.lojinha.pojo.InternationalProduct;
import br.com.lojinha.pojo.NationalProduct;
import br.com.lojinha.pojo.Product;
import br.com.lojinha.pojo.AdditionalItem;

import java.util.ArrayList;
import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
        Product myProduct = new Product("Sony", Size.LARGE);
        myProduct.setName("Play Station 4");

        //myProduct.setBrand("Sony");
        myProduct.setValue(499.99);
        //myProduct.setSize(Size.MEDIUM);
        List<AdditionalItem> itensIncluded = new ArrayList<>();

        AdditionalItem firstAdditionalItem = new AdditionalItem("Controle", 2);
        //firstAdditionalItem.setName("Controle");
        //firstAdditionalItem.setQuantity(2);

        AdditionalItem secondAdditionalItem = new AdditionalItem("Jogo",3);
        //secondAdditionalItem.setName("Jogo");
        //secondAdditionalItem.setQuantity(3);

        AdditionalItem thirdAdditionalItem = new AdditionalItem("Energy Cable",1);
        //thirdAdditionalItem.setName("Energy Cable");
        //thirdAdditionalItem.setQuantity(1);

        itensIncluded.add(firstAdditionalItem);
        itensIncluded.add(secondAdditionalItem);
        itensIncluded.add(thirdAdditionalItem);
        myProduct.setIncludedItems(itensIncluded);

        for (AdditionalItem currentItem : myProduct.getIncludedItems()){
        System.out.println("Item: " + currentItem.getName());
            System.out.println("Quantity: " + currentItem.getQuantity());

        }
        System.out.println(myProduct.getSize());
        System.out.println(myProduct.getValue());
        System.out.println(myProduct.getBrand());

        NationalProduct myNationalProduct = new NationalProduct("Sony", Size.MEDIUM);
        myNationalProduct.setNationalTax(0.55789);
        System.out.println(myNationalProduct.getNationalTax());

        InternationalProduct myInternationalProduct = new InternationalProduct("Sony", Size.LARGE);
        myInternationalProduct.setImportedTax(0.88789);
        System.out.println(myInternationalProduct.getImportedTax());

        myInternationalProduct.setValue(-100.00); //using the polymorphism to change how the method works, so it's possible to set differents rules for each child class.
        myNationalProduct.setValue(1);
        System.out.println(myInternationalProduct.getValue());
        System.out.println(myNationalProduct.getValue());
        
        
    }




}
