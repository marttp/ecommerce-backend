package com.webtutsplus.ecommerce.service;

import com.webtutsplus.ecommerce.dto.ProductDto;
import com.webtutsplus.ecommerce.model.Category;
import com.webtutsplus.ecommerce.model.Product;
import com.webtutsplus.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public void updateProduct(long productID, Product newProduct) {
        Product oldProduct = productRepository.findById(productID).get();
        oldProduct.setName(newProduct.getName());
        oldProduct.setImageURL(newProduct.getImageURL());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setDescription(newProduct.getDescription());
        productRepository.save(oldProduct);
    }

    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        // TODO
        // change product to product DTO
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: products) {
            // create product dto from product
            // add in the list
        }
        return productDtos;
    }

    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product(productDto.getName(), productDto.getImageURL(), productDto.getPrice(), productDto.getDescription(), category);
        return product;
    }

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public void updateProduct(long productID, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }
}
