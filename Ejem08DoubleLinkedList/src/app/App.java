package app;

import doublelinkedlist.DoubleLinkedList;

public class App {

	public static void main(String[] args) {

		DoubleLinkedList<String> names = new DoubleLinkedList<String>(); // <-- GUARDA CADENAS
		
		names.addEnd("Karely");
		names.addEnd("Abraham");
		names.addEnd("Gerardo");
		names.addStart("Pablo");
		names.addStart("Daniel");
		names.addStart("Alejandro");
		names.addEnd("Andres");
		names.addEnd("Susana");
		names.addEnd("Eduardo");
	
		
	
		names.printer();
	
		System.out.println("-----Remove--(en este caso Daniel)---------");
		
		//System.out.println("Search: " + names.Search("Roxx"));
		System.out.println(names.remove("Daniel"));
		System.out.println();
		names.printer();	
		System.out.println("-------Reindex------------");
		names.reindex();
		System.out.println("-------Get First----------");
		names.getfirst();
		System.out.println("-------Get Last------------");
		names.getlast();
		System.out.println("-------Remove First----------");
		names.removefirst();
		names.printerstart();
		System.out.println("-------Remove Last----------");
		names.removelast();
		names.printerend();
		System.out.println("-------Size--------------");
		names.size();
		System.out.println("-------Is Empty----------");
		boolean resp=names.isEmpty();
		if(resp)
			System.out.println("Lista vacia");
		else
			System.out.println("La lista contiene datos");
	
		System.out.println("-------Replace-----------");
		names.replace("Pablo","Alex");
		names.printer();
		System.out.println("---------Indexof-(En este caso Karely)-------");
		System.out.println("La posicion es: "+names.indexof("Karely"));
		System.out.println("---------RemoveBefore--(Borro el anterior a Karely)-----");
		names.removebefore("Karely");
		names.printer();
		System.out.println("---------RemoveAfter--(Borro uno despues de Andres)-----");
		names.removeafter("Andres");
		names.printer();
		System.out.println("--------Clear--------------");
		names.clear();
		names.printer();
	}
}























