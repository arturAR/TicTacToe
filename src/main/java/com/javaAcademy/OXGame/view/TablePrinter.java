package com.javaAcademy.OXGame.view;

import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Symbol;

public class TablePrinter {

	public static void printArena(GameArena arena) {
		Symbol[][] playArena = arena.getArena();
		for(int x = 1; x < arena.getXDimension(); x++) {
			System.out.println();
			for(int y = 1; y < arena.getYDimension(); y++) {
				System.out.print("  |" +  printPoint(playArena[x][y]) );
			}
		}
	}
	
	public static String printPoint(Symbol point) {
		return point.toString();
	}	
}
