package com.example.riporting.service;

import com.example.riporting.repository.*;
import com.example.riporting.repository.entity.Customer;
import com.example.riporting.repository.entity.EmailAddress;
import com.example.riporting.repository.entity.Product;
import com.example.riporting.repository.entity.QueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

@Service
public class RiportingService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final EmailAddressRepository emailAddressRepository;
    private final ItemRepository itemRepository;
    private final CustomRepository customRepository;
    private final Logger logger = LoggerFactory.getLogger(RiportingService.class);

    public RiportingService(ProductRepository productRepository, CustomerRepository customerRepository, EmailAddressRepository emailAddressRepository, ItemRepository itemRepository, CustomRepository customRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.emailAddressRepository = emailAddressRepository;
        this.itemRepository = itemRepository;
        this.customRepository = customRepository;
    }

  //  @Scheduled(fixedRate = 10000)
    public void generateProductReportEveryTenSeconds() {

        LocalTime currentTime = LocalTime.now();
        DecimalFormat df = new DecimalFormat("00");
        String time = currentTime.getHour() + ":" + df.format(currentTime.getMinute()) + ":" + currentTime.getSecond();

        logger.info("Generating Product List Riport at: {}", time);
        List<Product> products = productRepository.findAll();
        for(Product product : products) {
            logger.info("Product ID:\t\t {}", product.getId());
            logger.info("SKU:\t\t\t {}", product.getSku());
            logger.info("Name:\t\t\t {}", product.getName());
            logger.info("Price:\t\t\t {}", product.getPrice());
            logger.info("----");
        }
        logger.info("Product Report has been generated.");
    }

  //  @Scheduled(cron = "0 * * * * *")
    public void generateCustomerReportEveryMinute() {
        generateCustomReport(QueryType.DEFAULT, logger);
    }

    public void generateCustomReport(QueryType queryType, Logger logger) {
        LocalTime currentTime = LocalTime.now();
        DecimalFormat df = new DecimalFormat("00");
        String time = currentTime.getHour() + ":" + df.format(currentTime.getMinute()) + ":" + currentTime.getSecond();

        logger.info("Generating Customer Report at: {}", time);
        // Alap query:
        List<Customer> customers;

        switch (queryType) {
            case JPA:
                customers = customerRepository.findAll();
                break;
            case JPQL:
                customers = customRepository.findAllCustomersJpql();
                break;
            case NATIVE_SQL:
                customers = customRepository.findAllCustomersNativeSql();
                break;
            default:
                // Alap query:
                customers = customerRepository.findAll();
                break;
        }

        for(Customer customer : customers) {
            logger.info("Customer ID:\t\t {}", customer.getId());
            logger.info("Name:\t\t\t {}", customer.getName());
            logger.info("Birthdate:\t\t {}", customer.getBirthdate());

            EmailAddress emailAddress = emailAddressRepository.findFirstByCustomer(customer);
            logger.info("Email:\t\t\t {}", emailAddress);
        }
        logger.info("Customer report has been generated.");
    }


 //   @Scheduled(fixedRateString = "${riport.emailReportRate}")
    public void generateEmailReportOnCustom() {
        LocalTime currentTime = LocalTime.now();
        DecimalFormat df = new DecimalFormat("00");
        String time = currentTime.getHour() + ":" + df.format(currentTime.getMinute()) + ":" + currentTime.getSecond();

        logger.info("Generating Email Report at: {}", time);
        List<EmailAddress> emailAddresses = emailAddressRepository.findAll();
        for(EmailAddress email : emailAddresses) {
            logger.info("Email address:\t\t\t {}", email.getAddress());
        }
    }

    public void generateRiportOnStartupJpa() {
        Logger loggerJpa = LoggerFactory.getLogger("JpaReport");
        loggerJpa.info("Running init report (jpa) on startup");
        Instant start = Instant.now();
        generateCustomReport(QueryType.JPA, loggerJpa);
        Instant finish = Instant.now();

        Duration duration = Duration.between(start, finish);
        long seconds = duration.getSeconds();
        long millis = duration.toMillis() % 1000;

        loggerJpa.info("---- JPA speed is: " + seconds  +" seconds, " + millis +" miliseconds ----");
    }

    public void generateRiportOnStartupJpql() {
        Logger loggerJpql = LoggerFactory.getLogger("JpqlReport");
        loggerJpql.info("Running init report (jpql) on startup");
        Instant start = Instant.now();
        generateCustomReport(QueryType.JPQL, loggerJpql);
        Instant finish = Instant.now();

        Duration duration = Duration.between(start, finish);
        long seconds = duration.getSeconds();
        long millis = duration.toMillis() % 1000;

        loggerJpql.info("---- JPQL speed is: " + seconds  +" seconds, " + millis +" miliseconds ----");
    }

    public void generateRiportOnStartupNativeSql() {
        Logger loggerNativeSql = LoggerFactory.getLogger("NativeSqlReport");
        logger.info("Running init report (native sql) on startup.");
        Instant start = Instant.now();
        generateCustomReport(QueryType.NATIVE_SQL, loggerNativeSql);
        Instant finish = Instant.now();

        Duration duration = Duration.between(start, finish);
        long seconds = duration.getSeconds();
        long millis = duration.toMillis() % 1000;

        logger.info("---- Native SQL speed is: " + seconds  +" seconds, " + millis +" miliseconds ----");
    }

    public void runInitRiports() {
        generateRiportOnStartupJpa();
        generateRiportOnStartupJpql();
        generateRiportOnStartupNativeSql();
    }
}
