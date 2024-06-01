package com.infitry.virtualthread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VirtualThreadController {
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/virtual-thread")
    public String virtualThread() throws InterruptedException {
        Thread.sleep(1000);
        return "OK";
    }

    @GetMapping("/virtual-thread/database")
    public String virtualThreadWithDatabase() {
        return jdbcTemplate.queryForList("SELECT sleep(1);").toString();
    }
}
