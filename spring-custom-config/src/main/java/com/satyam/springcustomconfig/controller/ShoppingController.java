package com.satyam.springcustomconfig.controller;

import com.satyam.springcustomconfig.config.ShoppingConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    private final ShoppingConfig config;

    public ShoppingController(ShoppingConfig config) {
        this.config = config;
    }

    @GetMapping("/shopping")
    public String shopping() {

        StringBuilder sb = new StringBuilder();

        sb.append("Owner : ")
                .append(config.getOwner())
                .append("\n\n");

        sb.append("Budget : ")
                .append(config.getBudget())
                .append("\n\n");

        config.getItems().forEach((category, list) -> {

            sb.append(category)
                    .append("\n");

            list.forEach(item ->
                    sb.append("   - ")
                            .append(item)
                            .append("\n"));

            sb.append("\n");
        });

        return sb.toString();
    }
}
