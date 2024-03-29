package com.mara.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.mara.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.mara.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.mara.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.mara.domain.Wishlist.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Wish.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Region.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Country.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Location.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Department.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Department.class.getName() + ".employees", jcacheConfiguration);
            cm.createCache(com.mara.domain.Task.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Task.class.getName() + ".jobs", jcacheConfiguration);
            cm.createCache(com.mara.domain.Employee.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Employee.class.getName() + ".jobs", jcacheConfiguration);
            cm.createCache(com.mara.domain.Job.class.getName(), jcacheConfiguration);
            cm.createCache(com.mara.domain.Job.class.getName() + ".tasks", jcacheConfiguration);
            cm.createCache(com.mara.domain.JobHistory.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
