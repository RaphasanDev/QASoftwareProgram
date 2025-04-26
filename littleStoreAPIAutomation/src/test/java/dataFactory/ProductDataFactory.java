package dataFactory;

import pojo.Component;
import pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDataFactory {
    public static Product createCommomProductWithVariableValue(double value){
        Product product = new Product();
        product.setProdutoNome("Xbox S Series");

        product.setProdutoValor(value);
        List<String> colors = new ArrayList<>();
        colors.add("preto");
        colors.add("branco");
        product.setProdutoCores(colors);
        product.setProdutoUrlMock("");

        List<Component> components = new ArrayList<>();

        Component component = new Component();

        component.setComponenteNome("Controle");
        component.setComponenteQuantidade(2);
        component.setComponenteNome("FC 2024");
        component.setComponenteQuantidade(1);
        components.add(component);
        product.setComponentes(components);
        return product;
    }
}
