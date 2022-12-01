package vttp2022.day21.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp2022.day21.day21.repository.Query.*;

@Repository
public class CatRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SqlRowSet getCat(){

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_CAT);
        return rs;
    }

    public SqlRowSet getStyle(String styleId){

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_STYLE, styleId);
        return rs;
    }

    public SqlRowSet getBrewries(String styleId){
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_BREWRIES, styleId);
        return rs;
    }

    public SqlRowSet getBrewriesCount(String styleId){
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_BREWRIES_COUNT, styleId);
        return rs;
    }
}
