package vttp2022.day21.day21.repository;

public class Query {
    public static String SQL_SELECT_CAT = "select distinct(id), cat_name from categories";
    public static String SQL_SELECT_STYLE = "select s.id, style_name from categories as c join styles as s on c.id = s.cat_id where cat_id = ? order by style_name ";
    public static String SQL_SELECT_BREWRIES = "select distinct(brewery_id), br.name from categories as c join styles as s on c.id = s.cat_id join beers as b on s.id = b.style_id join breweries as br on b.brewery_id = br.id where b.style_id = ? order by b.brewery_id";
    public static String SQL_SELECT_BREWRIES_COUNT = "select count((brewery_id)) as count from categories as c join styles as s on c.id = s.cat_id join beers as b on s.id = b.style_id join breweries as br on b.brewery_id = br.id where b.style_id = ? order by b.brewery_id";
}
