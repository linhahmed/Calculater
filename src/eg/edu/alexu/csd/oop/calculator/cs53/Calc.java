package eg.edu.alexu.csd.oop.calculator.cs53;

import java.io.*;
import java.util.ArrayList;

public class Calc implements Calculator {
	private double first;
	private double second;
	private String op;
	private int count = 0;
	private int flag = 0;
	String current = null;
	String next = null;
	String prev = null;
	ArrayList<String> help = new ArrayList<String>();

	@Override
	public void input(String s) {
		if (s == null) {
			first = 0;
			second = 0;
			op = "";
			return;
		}
		String[] str = null;
		char[] ch = s.toCharArray();
		int neg1 = 0, neg2 = 0;
		if (s.contains("+")) {
			op = "+";
			str = s.split("\\+");
		} else if (s.contains("*")) {
			op = "*";
			str = s.split("\\*");
		} else if (s.contains("/")) {
			op = "/";
			str = s.split("\\/");
		} else if (s.contains("-")) {
			op = "-";
			String str1 = s;
			char[] ch1 = ch;
			if (ch[0] == '-') {
				StringBuilder tri = new StringBuilder(s);
				tri.deleteCharAt(0);
				str1 = tri.toString();
				ch1 = str1.toCharArray();
				neg1 = 1;
			}
			int i;
			for (i = 0; i < ch1.length; i++) {
				if (ch1[i] == '-') {
					break;
				}
			}
			if (ch1[i + 1] == '-') {
				StringBuilder tri = new StringBuilder(str1);
				tri.deleteCharAt(i + 1);
				str1 = tri.toString();
				ch1 = str1.toCharArray();
				neg2 = 1;
			}
			str = str1.split("\\-");
		}
		first = Double.parseDouble(str[0]);
		second = Double.parseDouble(str[1]);
		if (neg1 == 1) {
			first = -first;
		}
		if (neg2 == 1) {
			second = -second;
		}
		
		if(s != current && s!= prev && s != next) {
			if (count < 5) {
				help.add(s);
				count++;
				flag = count - 1;
			} else if (count == 5) {
				help.remove(0);
				help.add(s);
			}
		}
	}

	@Override
	public String getResult() {
		String answer = null;
		double result = 0;
		switch (op) {
		case "+":
			result = first + second;
			break;

		case "-":
			result = first - second;
			break;

		case "*":
			result = first * second;
			break;

		case "/":
			if (second != 0) {
				result = first / second;
			} else {
				op = "Cannot divide by zero";
				return op;
			}
			break;
		}
		answer = Double.toString(result);
		return answer;
	}

	int counter = 0;

	@Override
	public String current() {
		if(help.isEmpty()) {
			current = null;
		}
	    else if (current == null && count > 0) {
			current = (String) help.get(count - 1);
			input(current);
		} else if (current == null && count == 0) {
			current= null;
		} else if (flag == count - 1) {
			current = (String) help.get(count - 1);
			input(current);

		} else if (flag == 0 || help.size()==1) {

			current = (String) help.get(0);
			input(current);
		} 
		return current;
	}
	int countp=0;
	@Override
	public String prev() {
		countp++;
		prev=null;
		if (count == 0) {
			prev=null;
		} else if (flag == 0) {
			prev = null;
			current = (String) help.get(0);

		} else if (flag == count - 1) {
			flag--;
			prev = (String) help.get(flag);
			input(prev);
			current = (String) help.get(flag);
		} else {
			flag--;
			prev = (String) help.get(flag);
			input(prev);
			current = (String) help.get(flag + 1);
		}
		return prev;
	}

	@Override
	public String next() {
	    next = null;
		if (count == 0) {
			return null;
		}
		if (flag < count - 1) {
			flag++;
			next = (String) help.get(flag);
			input(next);
			current = (String) help.get(flag);
		} else if (flag == count - 1) {
			next = null;
			current = (String) help.get(count - 1);

		} else if (flag == count) {
			next = (String) help.get(count - 1);
			input(next);
			current = (String) help.get(count - 1);
		}
		return next;
	}

	int count1 = 0;

	@Override
	public void save() {
		try {
			if(countp>0 && (prev==null || prev == help.get(0))) {
				FileWriter fstream = new FileWriter("out.txt");
				BufferedWriter out = new BufferedWriter(fstream);

				out.write((String) help.get(0) + "\n");
				out.flush();

				// Close the output stream

				out.close();
			}else {
				// Create file
				FileWriter fstream = new FileWriter("out.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				for (int i = 0; i < help.size(); i++) {
					out.write((String) help.get(i) + "\n");
					out.flush();
				}
				// Close the output stream

				out.close();
			}

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}


	}

	@Override
	public void load() {
		@SuppressWarnings("unused")
		File file = new File("out.txt");

		try (BufferedReader reader = new BufferedReader(new FileReader(new File("out.txt")))) {

			help.clear();
			String line;
			counter++;
			while ((line = reader.readLine()) != null)
				help.add(line);
			System.out.println(help);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
