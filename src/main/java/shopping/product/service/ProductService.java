package shopping.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.product.dto.ProductDto;
import shopping.product.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Map<String,String> findById(Long productId) {
        Optional<ProductDto> rst = productRepository.findById(productId);

        Map<String,String> result = new HashMap<>();
        if(rst.isEmpty()) {
            result.put("resultMsg", "조회 결과가 없습니다.");
        } else {
            ProductDto productDto = rst.get();

            result.put("id", Integer.toString(productDto.getId()));
            result.put("name", productDto.getName());
            result.put("price", Integer.toString(productDto.getPrice()));
            result.put("fileUrl", productDto.getFileUrl());
        }

        return result;
    }
    /**
     * 상품 목록 조회
     * @return
     */
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    /**
     * 상품 추가
     * @param book
     * @return
     */
    public Map<String,String> save(Map<String,String> book){
        ProductDto productDto = new ProductDto();
        productDto.setName(book.get("name"));
        productDto.setPrice(Integer.parseInt(book.get("price")));
        productDto.setFileUrl(book.get("fileUrl"));

        productRepository.save(productDto);

        return book;
    }

    /**
     * 상품 업데이트
     * @param product
     * @return
     */
    public Map<String,String> update(Map<String,String> product) {
        Map<String,String> result = new HashMap<>();

        Optional<ProductDto> getDto = productRepository.findById(Long.parseLong(product.get("id")));


        if(!getDto.isEmpty()) {
            ProductDto productDto = getDto.get();
            productDto.setName(product.get("name"));
            productDto.setPrice(Integer.parseInt(product.get("price")));
            productDto.setFileUrl(product.get("fileUrl"));

            productRepository.save(productDto);

            result.put("id", Integer.toString(productDto.getId()));
            result.put("name", productDto.getName());
            result.put("price", Integer.toString(productDto.getPrice()));
            result.put("fileUrl", productDto.getFileUrl());

        } else {
            result.put("resultMsg", "상품 조회 결과가 없습니다.");
        }

        return result;
    }

    /**
     * 상품 삭제
     *
     * @param productId
     */
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }


    /** 상품명 유효성 검사
     *
     * @param name
     * @return
     */
    public boolean check(String name) {
        String[] swearWords = new String[] {"시발", "새끼", "개새끼", "병신" };
        String regExp = "^[가-힣a-zA-Z0-9\s]*$";
        String[] sign = {"\\(", "\\)" ,"\\[", "\\]", "\\+" ,"\\-", "\\&", "\\/", "\\_"};

        // 최대 15자
        if(name.length() > 15)
            return false;

        // 비속어 필터링
        for(int i=0; i<swearWords.length; i++) {
            if(name.contains(swearWords[i])) {
                return false;
            }
        }

        // 특수문자 검사
        String tmpStr = name;
        if(!Pattern.matches(regExp, name)) {
            for(int i=0; i<sign.length; i++)
                tmpStr = tmpStr.replaceAll(sign[i], " ");
        }

        if(!Pattern.matches(regExp, tmpStr)) {
            return false;
        }

        return true;
    }


}
