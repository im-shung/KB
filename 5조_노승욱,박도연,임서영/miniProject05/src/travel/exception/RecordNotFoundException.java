package travel.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException(){
		this("정보가 존재하지 않습니다.");
	}
	public RecordNotFoundException(String message){
		super(message);
	}
}
