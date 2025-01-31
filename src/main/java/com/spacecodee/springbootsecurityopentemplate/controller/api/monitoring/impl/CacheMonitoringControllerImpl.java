package com.spacecodee.springbootsecurityopentemplate.controller.api.monitoring.impl;

import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.spacecodee.springbootsecurityopentemplate.controller.api.monitoring.ICacheMonitoringController;
import com.spacecodee.springbootsecurityopentemplate.controller.base.AbstractController;
import com.spacecodee.springbootsecurityopentemplate.data.common.response.ApiResponseDataPojo;
import com.spacecodee.springbootsecurityopentemplate.language.MessageParameterHandler;
import com.spacecodee.springbootsecurityopentemplate.language.MessageUtilComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/monitoring/cache")
public class CacheMonitoringControllerImpl extends AbstractController implements ICacheMonitoringController {

    private final LoadingCache<String, Integer> requestCountsCache;

    public CacheMonitoringControllerImpl(MessageUtilComponent messageUtilComponent,
                                         MessageParameterHandler messageParameterHandler,
                                         LoadingCache<String, Integer> requestCountsCache) {
        super(messageUtilComponent, messageParameterHandler);
        this.requestCountsCache = requestCountsCache;
    }

    @Override
    public ResponseEntity<ApiResponseDataPojo<CacheStats>> getCacheStats(String locale) {
        log.debug("Retrieving cache statistics");
        CacheStats stats = this.requestCountsCache.stats();

        return ResponseEntity.ok(
                super.createDataResponse(
                        stats,
                        "monitoring.cache.stats",
                        locale,
                        HttpStatus.OK,
                        stats.hitCount(),
                        stats.missCount(),
                        this.requestCountsCache.size()));
    }
}