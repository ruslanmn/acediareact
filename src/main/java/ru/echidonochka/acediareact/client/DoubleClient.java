package ru.echidonochka.acediareact.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoubleClient {
    private final WebClient webClient;

    public Flux<Integer> makeDouble(List<Integer> values) {
        return Flux.fromIterable(values)
                .buffer(2)
                .flatMapSequential(this::makeDoubleBatch);
    }

    private Flux<Integer> makeDoubleBatch(List<Integer> values) {
        return webClient.put()
                .uri("/double")
                .bodyValue(values)
                .retrieve()
                .bodyToFlux(Integer.class);
    }
}
