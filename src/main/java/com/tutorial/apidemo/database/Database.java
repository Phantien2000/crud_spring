package com.tutorial.apidemo.database;

import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Now connect with mysql using JPA
/*
docker run -d --rm --name mysql-spring-boot-tutorial \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_USER=hoangnd \
-e MYSQL_PASSWORD=123456 \
-e MYSQL_DATABASE=test_db \
-p 3309:3306 \
--volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u hoangnd -p

* */
@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private ProductRepository productRepository;

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("MacBook Pro 16", 2020,2200.0, "10");
                Product productB = new Product("iPad Air White", 2021,599.0,"11");
               logger.info("insert data: "+productRepository.save(productA));
               logger.info("insert data: "+productRepository.save(productB));
                // Delete a product
//                Long productIdToDelete = 5L; // Specify the ID of the product to delete
//                boolean productExists = productRepository.existsById(productIdToDelete);
//                if (productExists) {
//                    productRepository.deleteById(productIdToDelete);
//                    logger.info("Deleted product with ID: " + productIdToDelete);
//                } else {
//                    logger.info("Product with ID " + productIdToDelete + " not found");
//                }

            }
        };
        /////////////Create branch T1 ///////////////////
        /////////////Create branch T1 Lan 2///////////////////
    }
}



