package arraylist;


public class ArrayExam {
	public static void main(String[] args) {
		List<String> list = new MyArrayList<String>();

		list.add("Java");
		list.add("C++");
		list.add("Python");
		list.add("C#");
		list.add("Objective-C");

		int size = list.size();
		System.out.println("총 데이터 수: " + size);
		System.out.println();

		String item = list.get(2);
		System.out.println("인덱스 2번 항목: " + item + "\n");

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();

		list.remove(2);
		list.remove(2);
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
//		list.removeAll();
		System.out.println("----------------------------------");
		System.out.println("총 데이터 수: " + list.size());

		
		
		for (String s : list) {
			System.out.println(s);
			}
		}
	}

