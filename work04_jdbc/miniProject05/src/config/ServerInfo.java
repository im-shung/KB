package config;

public interface ServerInfo {
// 인터페이스는 filed가 없고 상수로 이루어져 있다. -> public static final이 생략되어 있음
	String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String USER = "kb_db";
	String PASS = "1234";
	
	
}
