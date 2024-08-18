package shopping.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.product.dto.ProductDto;
import shopping.product.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    // 상품 목록 조회
    @GetMapping("/products")
    public List<ProductDto> findAll() {
        List<ProductDto> productList = productService.findAll();

        return productList;
    }


    // 특정 상품 조회
    @GetMapping("/products/{productId}")
    public Map<String, String> findById(@RequestParam("productId") Long productId) {
        Map<String, String> result = new HashMap<String, String>();

        result = productService.findById(productId);

        return result;
    }



    // 상품 추가
    @PostMapping("/products")
    public Map<String,String> save(@RequestBody Map<String, String> product) {
        Map<String, String> result = new HashMap<String, String>();

        if (!productService.check(product.get("name"))) {
            result.put("resultMsg", "상품 명명규칙이 잘못되었습니다.");
            return result;
        }

        result = productService.save(product);


        return result;
    }


    // 상품 수정
    @PutMapping("products")
    public Map<String,String> update(@RequestBody  Map<String, String> product) {
        Map<String, String> result = new HashMap<String, String>();

        if (!productService.check(product.get("name"))) {
            result.put("resultMsg", "상품 명명규칙이 잘못되었습니다.");
            return result;
        }

        result = productService.update(product);

        return result;
    }


    // 상품 삭제
    @DeleteMapping("products")
    public String deleteById(@RequestParam Long productId) {

        productService.deleteById(productId);

        return "삭제 완료";
    }

}
