package shopping.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductDto,Long> {


    // 상품 추가
    public ProductDto save(ProductDto productDto);

    // 상품 목록
    public List<ProductDto> findAll();

    // 상품 조회
    public Optional<ProductDto> findById(Long id);

    // 상품 삭제
    public void deleteById(Long id);


}
