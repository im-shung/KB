package travel.exception;

public class NotEnoughQuantityException extends Exception{
	public NotEnoughQuantityException(){
		this("남아있는 항공권이 없습니다.");
	}
	public NotEnoughQuantityException(String message){
		super(message);
	}
}
