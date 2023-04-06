package travel.exception;

public class SSNNotFoundException extends Exception{
	public SSNNotFoundException(){
		this("회원이 존재하지 않습니다.");
	}
	public SSNNotFoundException(String message){
		super(message);
	}
}
