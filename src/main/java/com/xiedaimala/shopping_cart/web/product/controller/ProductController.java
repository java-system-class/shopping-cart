package com.xiedaimala.shopping_cart.web.product.controller;

import com.xiedaimala.shopping_cart.web.product.model.ProductDao;
import com.xiedaimala.shopping_cart.web.product.view.GetProductResponse;
import com.xiedaimala.shopping_cart.web.product.view.ListProductResponse;
import com.xiedaimala.shopping_cart.web.product.view.create.CreateProductRequest;
import com.xiedaimala.shopping_cart.web.product.view.create.CreateProductResponse;
import com.xiedaimala.shopping_cart.web.product.view.create.validator.CreateProductRequestValidator;
import com.xiedaimala.shopping_cart.web.product.model.Product;
import com.xiedaimala.shopping_cart.web.product.view.UpdateProductRequest;
import com.xiedaimala.shopping_cart.web.product.view.UpdateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductDao productDao;
    private CreateProductRequestValidator createProductRequestValidator;

    public ProductController(CreateProductRequestValidator createProductRequestValidator, ProductDao productDao) {
        this.createProductRequestValidator = createProductRequestValidator;
        this.productDao = productDao;
    }

    /**
     * List products
     */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        List<Product> products = productDao.findAll();
        return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
    }

    /**
     * Get product
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId) {
        Product product = productDao.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
        }
    }

    /**
     * Create product
     */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        // 实现
        boolean validate = createProductRequestValidator.validate(createProductRequest);

        Product product = productDao.save(new Product(createProductRequest.getName(), createProductRequest.getDescription(), createProductRequest.getPrice()));
        return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
    }

    /*
     * 已经定义好了输入和输出!
     * 同时也定义好了期望的输入内容和相应的执行结果!
     * 想象成一个黑箱, 是不是可以写测试了, 即使没有实现, 但是起始状态测试是不能通过的, 只是用来帮助我们明确功能
     * 开发就转换成写代码让测试通过! --> 符合功能的逻辑要求! 其实这个就是测试驱动开发!
     */

    /**
     * Update product
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable long productId, @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = productDao.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product.setPrice(updateProductRequest.getPrice());
        product = productDao.save(product);

        return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.OK);
    }
}
