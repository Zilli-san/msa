package se.magnus.microservices.core.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.Product;
import se.magnus.api.core.product.ProductService;
import se.magnus.util.http.ServiceUtil;

@RestController
public class ProductServiceImpl implements ProductService {

    private final ServiceUtil serviceUtil; // 오타(sesrviceUtil) 주의!

    @Autowired
    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId) {
        // serviceUtil을 사용하여 현재 서비스의 주소(호스트/포트)를 가져와서 Product 객체에 담아 반환합니다.
     
        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}