package ru.echidonochka.acediareact.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.echidonochka.acediareact.service.DoubleService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/double")
public class DoubleController {
    private final DoubleService doubleService;

    @PutMapping
    public List<Integer> doublePut(@RequestBody List<Integer> values) {
        log.info("PUT /double {}", values);
        return doubleService.makeDouble(values);
    }

    @GetMapping
    public List<Integer> doubleGet(@RequestParam List<Integer> values) {
        log.info("GET /double {}", values);
        return doubleService.proxyDouble(values);
    }
}