package com.edburguer.dto.initDb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryInitDbDto {
    private Long id;

    private String name;

    private String imageUrl;
}
