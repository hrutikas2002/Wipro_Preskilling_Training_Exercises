package com.wipro.thread;

import java.util.List;

public class ChangeCase 
{
	private List<String> names;

	public ChangeCase(List<String> names) {
		super();
		this.names = names;
	}

	public void change() {
		Runnable vowel = () -> {
			for (int i = 0; i < names.size(); i++) {
				char firstChar = Character.toLowerCase(names.get(i).charAt(0));
				if ((firstChar=='a')||(firstChar=='e')||(firstChar=='i')||(firstChar=='o')||(firstChar=='u')) {
					names.set(i, names.get(i).toUpperCase());
				}
			}
		};

		Runnable consonant = () -> {
			for (int i = 0; i < names.size(); i++) {
				char firstChar = Character.toLowerCase(names.get(i).charAt(0));
				if ((firstChar!='a') && (firstChar!='e') && (firstChar!='i') && (firstChar!='o') && (firstChar!='u')) {
					names.set(i, names.get(i).toLowerCase());
				}
			}
		};

		Thread thread1 = new Thread(vowel);
		Thread thread2 = new Thread(consonant);

		thread1.start();
		thread2.start();
	}

	public List<String> getNewNames() {
		return names;
	}
}
