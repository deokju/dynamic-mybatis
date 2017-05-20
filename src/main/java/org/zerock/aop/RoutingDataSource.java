package org.zerock.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.zerock.util.DbContextHolder;

public class RoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(RoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.info(">>> determineCurrentLookupKey thread: {}", Thread.currentThread().getName() );
        log.info(">>> RoutingDataSource: {}", DbContextHolder.getDbType());
        return DbContextHolder.getDbType();
    }
}