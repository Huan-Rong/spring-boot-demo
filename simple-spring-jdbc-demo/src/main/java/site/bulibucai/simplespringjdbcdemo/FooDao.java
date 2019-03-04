package site.bulibucai.simplespringjdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void insertData() {
        // 使用 JdbcTemplate 的方式：编写原生 SQL 的方式。
        // update 方法可以实现插入、删除、修改。
        Arrays.asList("b", "c").forEach(bar -> {
            jdbcTemplate.update("INSERT INTO FOO(BAR) VALUES(?)", bar);
        });

        // 使用 SimpleJdbcInsert 的方式：Spring JDBC 封装了简单的 SQL 操作，不需要编写 SQL。
        HashMap<String, String> row = new HashMap<>();
        row.put("BAR", "d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d:{}", id.longValue());
    }

    public void listData() {
        log.info("Count: {}",
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));
        List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
        list.forEach(s -> log.info("BAR: {}", s));

        List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Foo.builder()
                        .id(rs.getLong(1))
                        .bar(rs.getString(2))
                        .build();
            }
        });

        fooList.forEach(f -> log.info("FOO: {}", f));
    }
}
