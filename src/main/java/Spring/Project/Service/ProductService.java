package Spring.Project.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Spring.Project.Model.Product;
import Spring.Project.Repository.ProductRepo;
import Spring.Project.dto.ProductRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepository;

    public void AddProduct(@RequestBody ProductRequest productDetail){
        Product product = Product.builder()
                .name(productDetail.getName())
                .description(productDetail.getDescription())
                .price(productDetail.getPrice())
                .quantity(productDetail.getQuantity())
                .build();

        productRepository.save(product);
    }
}
