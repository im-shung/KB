package kb.cms;

public class Customer implements Comparable<Customer>{

	int num;
	String name;
	String address;

	public Customer() {
		super();
	}

	public Customer(int num, String name, String address) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [num=").append(num).append(", name=").append(name).append(", address=").append(address)
				.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Customer o) {
		// 고객 번호로 sort
//		return this.num - o.num;
		
		// 고객 이름으로 sort
		return this.name.compareTo(o.name);
	}

}
