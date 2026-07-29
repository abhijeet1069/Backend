package com.satyam.springcustomconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource(
        value = "classpath:shopping.yml",
        factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "shopping")
public class ShoppingConfig {
    private String owner;
    private int budget;
    private Map<String, List<String>> items;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Map<String, List<String>> getItems() {
        return items;
    }

    public void setItems(Map<String, List<String>> items) {
        this.items = items;
    }
}
