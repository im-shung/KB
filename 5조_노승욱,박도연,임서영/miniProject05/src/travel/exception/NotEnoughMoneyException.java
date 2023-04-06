package travel.exception;

public class NotEnoughMoneyException extends Exception{
	public NotEnoughMoneyException(){
		this("가지고 있는 돈으로 항공권을 살 수 없습니다.");
	}
	public NotEnoughMoneyException(String message){
		super(message);
	}
}
