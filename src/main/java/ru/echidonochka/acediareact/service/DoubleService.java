package ru.echidonochka.acediareact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.echidonochka.acediareact.client.DoubleClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoubleService {
    private final DoubleClient doubleClient;

    public List<Integer> makeDouble(List<Integer> values) {
        return values.stream()
                .map(i -> i * 2)
                .toList();
    }

    public List<Integer> proxyDouble(List<Integer> values) {
        return doubleClient.makeDouble(values)
                .collectList()
                .blockOptional()
                .orElse(List.of());
    }
}
