package sales.product.service;

import sales.product.Product;

import java.util.Set;

public interface ProductService {
    void saveProduct(Product product);

    void updateProduct(Product product);

    Set<Product> getAll();
}
