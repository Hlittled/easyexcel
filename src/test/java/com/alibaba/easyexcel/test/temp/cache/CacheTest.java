package com.alibaba.easyexcel.test.temp.cache;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import customize.org.apache.poi.xssf.streaming.SXSSFRow;
import customize.org.apache.poi.xssf.streaming.SXSSFSheet;
import customize.org.apache.poi.xssf.streaming.SXSSFWorkbook;
import customize.org.apache.poi.xssf.usermodel.XSSFRow;
import customize.org.apache.poi.xssf.usermodel.XSSFSheet;
import customize.org.apache.poi.xssf.usermodel.XSSFWorkbook;
import customize.org.ehcache.Cache;
import customize.org.ehcache.PersistentCacheManager;
import customize.org.ehcache.config.builders.CacheConfigurationBuilder;
import customize.org.ehcache.config.builders.CacheManagerBuilder;
import customize.org.ehcache.config.builders.ResourcePoolsBuilder;
import customize.org.ehcache.config.units.MemoryUnit;
import org.junit.Ignore;
import org.junit.Test;
import customize.org.slf4j.Logger;
import customize.org.slf4j.LoggerFactory;

import com.alibaba.easyexcel.test.temp.poi.Poi2Test;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.fastjson.JSON;

/**
 *
 * @author Jiaju Zhuang
 **/
@Ignore
public class CacheTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(Poi2Test.class);

    @Test
    public void cache() throws Exception {

        File readTempFile = FileUtils.createCacheTmpFile();

        File cacheFile = new File(readTempFile.getPath(), UUID.randomUUID().toString());
        PersistentCacheManager persistentCacheManager =
            CacheManagerBuilder.newCacheManagerBuilder().with(CacheManagerBuilder.persistence(cacheFile))
                .withCache("cache", CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, HashMap.class,
                    ResourcePoolsBuilder.newResourcePoolsBuilder().disk(10, MemoryUnit.GB)))
                .build(true);
        Cache<Integer, HashMap> cache = persistentCacheManager.getCache("cache", Integer.class, HashMap.class);

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "test");

        cache.put(1, map);
        LOGGER.info("dd1:{}", JSON.toJSONString(cache.get(1)));

        cache.clear();

        LOGGER.info("dd2:{}", JSON.toJSONString(cache.get(1)));
    }

}
