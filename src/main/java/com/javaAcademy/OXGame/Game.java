package com.javaAcademy.OXGame;

import java.util.Scanner;

import com.javaAcademy.OXGame.businessLogic.CheckerAlgorithm;
import com.javaAcademy.OXGame.model.GameArena;
import com.javaAcademy.OXGame.model.Symbol;
import com.javaAcademy.OXGame.view.TablePrinter;

public class Game {
	
	private static Scanner s;

	public void startGame(int x, int y, int charSeriesDim) {
		GameArena gameArena = GameArena.getGameArena(x,y);
		CheckerAlgorithm checker = new CheckerAlgorithm(gameArena, charSeriesDim);
		boolean someoneWin = false;
		int cnt = 0;
		do{
			if(cnt%2 == 0) {
				setChar(gameArena, Symbol.O, isEmpty(gameArena, Symbol.O));
				someoneWin = checker.win(gameArena, Symbol.O);
			} else {
				setChar(gameArena, Symbol.X, isEmpty(gameArena, Symbol.X));
				someoneWin = checker.win(gameArena, Symbol.X);
			}
			
	    	cnt++;
	    	TablePrinter.printArena(gameArena); 
		} while(cnt < gameArena.getAmountOfSymbols() && !someoneWin);
	}
	
	private static Point isEmpty(GameArena arena, Symbol symbol) {
		s = new Scanner(System.in);
		System.out.println("Now player: " + symbol + " move.");
		
		System.out.println("\nChoose x: ");
    	final int yDim = Integer.parseInt(s.nextLine());
    	
    	System.out.println("\nChoose y: ");
    	final int xDim = Integer.parseInt(s.nextLine());
    	
    	
    	System.out.println("You chose: " + xDim+"|"+yDim);
		
		if((arena.getArena()[xDim][yDim]).equals(Symbol.EMPTY)) {
			return new Point(xDim,yDim);
		}
		System.out.println("Point is occupied! Please choose new");
		return isEmpty(arena, symbol);
	}
	
	private static void setChar(GameArena arena, Symbol symbol, Point point) {
    	arena.getArena()[point.getX()][point.getY()] = symbol;
	}
}
