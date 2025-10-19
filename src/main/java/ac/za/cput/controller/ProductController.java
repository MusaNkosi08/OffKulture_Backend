package ac.za.cput.controller;

import ac.za.cput.domain.Product;
import ac.za.cput.factory.ProductFactory;
import ac.za.cput.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        Product newProduct = ProductFactory.createProduct(product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategoryId(), product.getImageIds());
        return productService.create(newProduct);
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable String id) {
        return productService.read(id);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return productService.getAll();
    }
}
