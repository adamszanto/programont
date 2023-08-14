package com.example.riporting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SpringConfig {
    // TODO: Meg lehet adni hogy milyen packagek-et logoljon. Package nevet megadjuk, amik az alatt a package alatt vannak akkor azok futnak be abba a logba.
    // TODO: 4 service csinálni, 1-1 metódust annotálni, stb... -> log keretrendszer pedig egyes service-ket külön külön logfájlba mentik ki.

    // <logger name="hu.telekom.wop.adminbe" level="DEBUG" additivity="true"/>
}
