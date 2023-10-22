package com.bomfim.demoloom.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/loom")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        getSleep();
        return "Hello World " + Thread.currentThread();
    }

    @GetMapping("/many")
    public String helloWorldMany() throws ExecutionException, InterruptedException {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(HelloWorldController::getSleep),
                CompletableFuture.runAsync(HelloWorldController::getSleep),
                CompletableFuture.runAsync(HelloWorldController::getSleep),
                CompletableFuture.runAsync(HelloWorldController::getSleep)
        ).get();

        return "Hello World " + Thread.currentThread();
    }

    private static void getSleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
