package com.example.riporting;

import com.example.riporting.service.RiportingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReportInit implements CommandLineRunner {
    private final RiportingService riportingService;

    public ReportInit(RiportingService riportingService) {
        this.riportingService = riportingService;
    }

    @Override
    public void run(String... args) {
        riportingService.runInitRiports();
    }
}
