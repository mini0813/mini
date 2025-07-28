package arraylist;

public class ArrayExam02 {
	public static void main(String[] args) {
		List<String> list = new MyArrayList<>();
	
	list.add("개발");
	list.add("힘들지만");
	list.add("힘들지않다");
	list.add("할 수 있다");
	list.add("오예!");
	
	System.out.println("총 데이터 수: " + list.size() + "\n");
	
	System.out.println("인덱스 2번 항목: " + list.get(2) + "\n");
	
	for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
	

	System.out.println();
	list.remove(2);
	list.remove(2);

	for(int i = 0; i < list.size(); i++) {
		String s = list.get(i);
		System.out.println(i + ": " + s);
	}

	System.out.println();
	System.out.println("------------------------------------------");

	System.out.println();
	for(String s:list) {
		System.out.println(s);
		}
	};	
}
