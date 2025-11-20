package com.next_website_be.Service;


import com.next_website_be.DTO.Request.BrandRequestDTO;
import com.next_website_be.DTO.Response.BrandResponseDTO;
import com.next_website_be.Entities.Brand;
import com.next_website_be.Mapper.BrandMapper;
import com.next_website_be.Repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public List<BrandResponseDTO> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BrandResponseDTO getBrandById(String id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        return brandMapper.toDTO(brand);
    }

    public BrandResponseDTO createBrand(BrandRequestDTO requestDTO) {
        Brand brand = brandMapper.toEntity(requestDTO);
        Brand savedBrand = brandRepository.save(brand);
        return brandMapper.toDTO(savedBrand);
    }

    public BrandResponseDTO updateBrand(String id, BrandRequestDTO requestDTO) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        brand.setName(requestDTO.getName());
        brand.setDescription(requestDTO.getDescription());
        brand.setLogoUrl(requestDTO.getLogoUrl());
        Brand updatedBrand = brandRepository.save(brand);
        return brandMapper.toDTO(updatedBrand);
    }

    public void deleteBrand(String id) {
        brandRepository.deleteById(id);
    }
}
