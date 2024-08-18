package shopping.product.dto;


import jakarta.persistence.*;

@Entity
@Table(name="product")
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="name")
    private String name;         // 상품명

    @Column(name="price")
    private int price;           // 상품가격

    @Column(name="file_url")
    private String fileUrl;     // 이미지 경로

    public ProductDto() {

    }


    public ProductDto(int id, String name, int price, String fileUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fileUrl = fileUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
