package shopping.product.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.product.dto.BookDto;
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


    /** 상품 목록 조회
     *
     * @return
     */
    @GetMapping("/products")
    public List<BookDto> findAll() {
        List<BookDto> bookList = new ArrayList<>();

        return bookList;
    }

    /** 특정 상품 조회 기능
     *
     * @param productId
     * @return
     */
    @GetMapping("/products")
    public Map<String, String> findById(@RequestParam("productId") int productId) {
        Map<String, String> result = new HashMap<String, String>();


        return result;
    }


    /** 상품 추가 기능
     *
     * @param book
     * @return
     */
    @PostMapping("/products")
    public String insertByMap(@RequestBody Map<String, String> book) {
        Map<String, String> result = new HashMap<String, String>();

        if (productService.check(book.get("name"))) {

        }


        return "";
    }

    /**
     * 상품 수정 기능
     * @param book
     * @return
     */
    @PutMapping("products")
    public Map<String,String> updateByMap(@RequestBody  Map<String, String> book) {
        Map<String, String> result = new HashMap<String, String>();

        return result;
    }

    /** 상품 삭제 기능
     *
     * @param ProductId
     * @return
     */
    @DeleteMapping("products")
    public String deleteById(@RequestParam int ProductId) {

        return "";
    }

}
