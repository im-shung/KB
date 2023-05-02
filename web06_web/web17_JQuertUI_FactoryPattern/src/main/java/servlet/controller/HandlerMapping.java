package servlet.controller;

/**
 * 서블릿이 제공하는 command값에 따라서 
 * Component를 여기서 직접 생성한다.
 * 
 * 여러 개의 Component를 생성하는 공장이기 때문에
 * 무조건 하나만 생성되도록 싱글톤 패턴으로 작성
 *
 */
public class HandlerMapping {

	/* 싱글톤 패턴 */
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
		System.out.println("Creating HandlerMapping...싱글톤...");
	}
	public static HandlerMapping getInstance() {
		return factory;
	}

	// command값에 따라서 Component를 생성하는 기능
	public Controller createComponent(String command) {
		Controller controller = null;
		
		if (command.equals("subject.do")) {
			controller = new SubjectController();
			System.out.println("new SubjectController()...");
		} else if (command.equals("branches.do")) {
			controller = new BranchesController();
			System.out.println("new BranchesController()...");
		} 
		return controller; // return 타입이 인터페이스!!
	}
	
}
