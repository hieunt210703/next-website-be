package com.next_website_be.Controller;

import com.next_website_be.DTO.Request.BrandRequestDTO;
import com.next_website_be.DTO.Response.BrandResponseDTO;
import com.next_website_be.Service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<BrandResponseDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public BrandResponseDTO getBrandById(@PathVariable String id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public BrandResponseDTO createBrand(@RequestBody BrandRequestDTO requestDTO) {
        return brandService.createBrand(requestDTO);
    }

    @PutMapping("/{id}")
    public BrandResponseDTO updateBrand(@PathVariable String id, @RequestBody BrandRequestDTO requestDTO) {
        return brandService.updateBrand(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable String id) {
        brandService.deleteBrand(id);
    }
}
