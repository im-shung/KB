package servlet.controller;

// 결과페이지 이름 & 페이지 이동 방식에 대한 정보를 저장하는 클래스
public class ModelAndView {

	private String path;

	// 보통 페이지 이동 방법이 forward!
	// ->> boolean의 기본값이 false니까 변수이름이 isRedirect로 하는 것이 좋다.
	private boolean isRedirect;

	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public ModelAndView(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
