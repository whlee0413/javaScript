package co.yedam.app.model;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
	INSERT(1), UPDATE(2), DELETE(3), SEARCH(4), SELECT(5), EXIT(9);

	public final int value;

	private Menu(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private static Map<Integer, Menu> map = new HashMap<>();

	static {
		for (Menu menu : Menu.values()) {
			map.put(menu.value, menu);
		}
	}

	public static Menu valueOf(int pageType) {
		return (Menu) map.get(pageType);
	}

	/*
	 * public static Menu valueOf2(int option) { for (Menu menu : Menu.values()) {
	 * if(menu.value == option) return menu; } return null; }
	 */
}
