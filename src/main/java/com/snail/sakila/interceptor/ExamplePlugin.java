package com.snail.sakila.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;
@Slf4j
@Intercepts({@Signature(method = "",type= StatementHandler.class,args = {Connection.class,Integer.class})})
public class ExamplePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("ExamplePlugin");
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
