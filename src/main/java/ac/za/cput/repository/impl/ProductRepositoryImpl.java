package ac.za.cput.repository.impl;

import ac.za.cput.domain.Product;
import ac.za.cput.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {

    private static ProductRepositoryImpl repository = null;
    private List<Product> productList;

    private ProductRepositoryImpl() {
        productList = new ArrayList<>();
    }

    public static ProductRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ProductRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        this.productList.add(product);
        return product;
    }

    @Override
    public Product read(String id) {
        return this.productList.stream()
                .filter(product -> product.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product update(Product product) {
        Product toUpdate = read(product.getId());
        if (toUpdate != null) {
            this.productList.remove(toUpdate);
            this.productList.add(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Product toDelete = read(id);
        if (toDelete != null) {
            this.productList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return this.productList;
    }
}
