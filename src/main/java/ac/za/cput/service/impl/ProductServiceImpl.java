package ac.za.cput.service.impl;

import ac.za.cput.domain.Product;
import ac.za.cput.repository.IProductRepository;
import ac.za.cput.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    @Autowired
    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return this.repository.save(product);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }
}
