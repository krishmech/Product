package Spring.Project.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;

import Spring.Project.Model.Product;
import Spring.Project.Repository.ProductRepo;
import Spring.Project.Service.ProductService;
import Spring.Project.dto.ProductRequest;
import Spring.Project.dto.ProductResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepo productRepository;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddProduct(@RequestBody ProductRequest productRequest){
        productService.AddProduct(productRequest);
    }

    @GetMapping("/getProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> GetProducts(){
        List<Product> products= productRepository.findAll();
        
        return products.stream().map(product -> ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build()).toList();
        
    }

    @GetMapping("/getProduct/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable String name){
        return productRepository.findByName(name);
    }

    @GetMapping("/Session")
    public CsrfToken Session(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}