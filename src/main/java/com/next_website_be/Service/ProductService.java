package com.next_website_be.Service;

import com.next_website_be.DTO.Request.ProductRequestDTO;
import com.next_website_be.DTO.Response.ProductResponseDTO;
import com.next_website_be.Entities.Product;

import com.next_website_be.Mapper.ProductMapper;
import com.next_website_be.Repository.BrandRepository;
import com.next_website_be.Repository.CategoryRepository;
import com.next_website_be.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> getAllProducts() {
        return productMapper.toResponseDTOList(productRepository.findAll());
    }

    public ProductResponseDTO getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toResponseDTO(product);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = productMapper.toEntity(requestDTO);
        product.setBrand(brandRepository.findById(requestDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found")));
        product.setCategory(categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
        return productMapper.toResponseDTO(productRepository.save(product));
    }

    public ProductResponseDTO updateProduct(String id, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(requestDTO.getName());
        product.setDescription(requestDTO.getDescription());
        product.setPrice(requestDTO.getPrice());
        product.setBrand(brandRepository.findById(requestDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found")));
        product.setCategory(categoryRepository.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
        return productMapper.toResponseDTO(productRepository.save(product));
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
