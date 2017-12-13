package Dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import JavaBeans.Users;

@Component("authdao")
public class AuthDao {

	private static NamedParameterJdbcTemplate jdbc;
	
	public AuthDao() {
		System.out.println("AuthDao Starting..");
	}
	
	@Autowired
	public void setDatasource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Transactional
    public boolean CreatnewAccount(Users users) {
    	String sql = "insert into users(username,password,email,enabled) values(:username,:password,:email,:enabled)";
    	String auth_sql = "insert authorities(username,authority) values(:username,:authiritey)";
    	BeanPropertySqlParameterSource bean = new BeanPropertySqlParameterSource(users);
    	jdbc.update(sql, bean);
    	return jdbc.update(auth_sql, bean)==1;
    }

	public boolean exists(String username) {
		// TODO Auto-generated method stub
		String map = "select count(*) from users where username=:username";
		return jdbc.queryForObject(map, new MapSqlParameterSource("username",username),Integer.class)>0;
	}
}


