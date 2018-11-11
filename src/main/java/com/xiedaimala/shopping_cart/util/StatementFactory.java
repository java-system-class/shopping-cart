package com.xiedaimala.shopping_cart.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


@Component("statement")
public class StatementFactory implements FactoryBean<Statement> {

    @Override
    public Statement getObject() throws Exception {
        // 创建数据库连接
        Connection connection = DriverManager.getConnection("jdbc:sqlite:resources/sample.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        return statement;
    }

    @Override
    public Class<?> getObjectType() {
        return Statement.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
