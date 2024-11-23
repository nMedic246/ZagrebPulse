package com.zagreb.hackl.ZagrebPulse.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;  // Import for CaffeineCacheManager
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        cacheManager.registerCustomCache("categories", defaultCache());
        cacheManager.registerCustomCache("types", defaultCache());


        return cacheManager;
    }

    private static Cache<Object, Object> defaultCache() {
        return Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build();
    }

    private static Cache<Object, Object> customCache() {
        return Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
    }
}