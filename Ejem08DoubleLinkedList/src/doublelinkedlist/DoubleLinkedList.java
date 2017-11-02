package doublelinkedlist;

import node.node;

public class DoubleLinkedList<T> {

private node<T> start = null, end = null;
	
	
	public DoubleLinkedList(){
		start = new node<T>();
		start.setIndex(-1); //
		end = new node<T>();
		end.setIndex(-1);
	}
	public DoubleLinkedList(T value){
		this();
		end.setBack(new node<T>(value));
		start.setNext(end.getBack());
		start.getNext().setIndex(0); // 
	}
	
	@SuppressWarnings("unused")
	public void reindex() {
		node<T> tmp = start;
		int inde = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(inde + 1);
			System.out.println(inde + 1);
			inde++;
		}
	}
	

	public void addStart(T value){
		node<T> tmp = start.getNext();
		start.setNext(new node<T>(value));
		
		if(tmp == null){
			end.setBack(start.getNext());
			start.getNext().setIndex(0);
		}else{
			start.getNext().setNext(tmp);
			tmp.setBack(start.getNext());
		}
	}
	public void addEnd(T value){
		node<T> tmp = end.getBack();
		end.setBack(new node<T>(value));
		
		if(tmp == null){
			start.setNext(end.getBack());
			end.getBack().setIndex(0);
		}else{
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
	}
	public node<T> Search(T value){
		return Search(value, start, end);
	}
	private node<T> Search(T value, node<T> start, node<T> end){  // BUSCAR RECURSIVO NDOE // <---- PARA USARLO
		if(start.getNext() == null || end.getBack() == null){
			System.out.println(""); return null;
		}else if(start.getNext().getValue().equals(value)){
				return start.getNext();
			}else if(end.getBack().getValue().equals(value)){
					return end.getBack();
				}else if ((start.getNext().equals(end)) || (start.equals(end))){
					System.out.println("Nombre no encontrado"); return null;
				}
			return Search(value, start.getNext(), end.getBack());
			}
	public boolean remove(T value){
		node<T> tmp = Search(value);
		if(tmp!=null){
			if(tmp.getNext() != null){
				tmp.getNext().setBack(tmp.getBack());
			}else{
				end.setBack(tmp.getBack());
			}
			if(tmp.getBack() != null){
				tmp.getBack().setNext(tmp.getNext());
			}else{
				start.setNext(tmp.getNext());
			}
			return true;
		}
		return false;
	}
	public void printerstart() { 
		node<T> tmp = start;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			
			System.out.println(tmp.getValue());
		}
	}
	public void printerend() { 
		node<T> tmp = end;
		while (tmp.getBack()!=null) {
			tmp = tmp.getBack();
			System.out.println(tmp.getValue());
		}
	}
	public void printer() { 
		printer(start);
	}
	private void printer(node<T> tmp) {
		if (tmp.getNext()== null)
			return;
		else{
			System.out.println(tmp.getNext().getValue());
		    printer(tmp.getNext());
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	public boolean isEmpty()
	{
		if (start.getNext()==null && end.getBack()==null) // en este if verificamos si el next del inicio de la lista es nulo al igual que el														//
		{												 //back del end si es asi nos returna un true
			return true;
		}
		else
		{
			return false;								//de lo contrario nos returna un false
		}		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	 	 
	 public void clear(){
		 start.setNext(null);							//decimos que el next del inicio es igual a nulo para borrar los datos de la lista
		 end.setBack(null);
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 public void getfirst(){
			node<T> tmp  = start;						//creamos una variable temporal
			if(tmp.getNext()!=null){						//si la temporal en su getnext es diferente a nulo
				System.out.println(tmp.getNext().getValue());// imprime el valor de tmp.getnext().getValue()
			}
			
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 
	 public void getlast() {
			node<T>tmp =end;//creamos una variable temporal
			if(tmp.getBack()!=null){	//si la temporal en su getback es diferente a nullo
				System.out.println(tmp.getBack().getValue()); //imprimimos el valor del tmp.getnext
			}
			
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 public void removefirst() {
			node<T> tmp = end;		
		 if(start.getNext()!=null){												//si el next del inicio es diferente a nulo entra al if
			 if(start.getNext().getNext()!=null){								//si el inicio en su getnext getnext es diferente a nulo realiza lo sig.
				 start.setNext(start.getNext().getNext());					//el setnext de start sera igual a start.getnext.getnext, osea dara dos saltos
				 start.getNext().setBack(null);						//y start en su getnext.setback sera igual a nulo asi se borrara 
				 
			 }else{
				 start.setNext(null);								//si no el next de inicio sera igual a nulo
			     start.getNext().setBack(null);						//y start en su getnext tendra un valor a nulo 
			 }
		 }
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 public void removelast() {
		 
		 if(end.getBack()!=null){
			 if(end.getBack().getBack()!=null){					//si end.getback.getback es diferente a nulo entra realiza lo sig.
				 end.setBack(end.getBack().getBack());			// end.setback sera igual a end.getback.getback.. como quien dice da dos saltos
				 end.getBack().setNext(null);					// end.getback tendra un valor de nulo
				 
				 }else{
				 end.setBack(null);						//si no el back del end sera igual a null
				 end.getBack().setNext(null);			// y end en su getback tendra valor de null
			 }
		 }
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void size() {

			int aux=0;						//tenemos un auxiliar que nos ayudara a obtener la cantidad en la lista
			node<T> tmp = start;			//creamos un temporal
			while (tmp.getNext()!=null) {//mientras temporal.getnext sea diferente a null
				tmp = tmp.getNext();		//temporal avanzara una posicion
				tmp.setIndex(aux);
				
				aux++;
				
			}
			System.out.println(aux); 		//Se muestra el total que se acumulo en el auxiliar
			System.gc();
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public node <T> replace (T value, T newvalor) {
		
			node<T> tmp = end;
			while(tmp.getBack()!=null){						//mientras tmp en su getback sea diferente a null realizara lo siguiente
				if(tmp.getBack().getValue().equals(value)){	//si el valor de tmp.getback es igual al valor que estamos buscando entonces
					tmp.getBack().setValue(newvalor);		// el getback de tmp reemplazara el valor por el nuevo valor
				}
				tmp=tmp.getBack();							//si no el tmp dara un salto para volver a recorrer la lista
			}
			return null;
			
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public long indexof(T value)
		{
			node<T> temp= start;					//creamos un temporal de sentinel
			while(temp.getNext()!=null){			//mientras temporal.getnext sea diferente a nulo entra al if
			if (temp.getNext().getValue().equals(value)){//si el valor del getnext de temporal es igual al valor recibido
				return temp.getIndex()+2;}				//returnamos la posicion en donde se encuentra
			else{
				temp=temp.getNext();					//si no avanzamos una posicion y volvemos a recorrer
			}
				
			}
			return 0;
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void removebefore(T value)
		{
			node<T> tmp = Search(value);			// creamos un tmp donde guardaremos el valor introducido y lo jalaremos del metodo search para que nos lo busque
			if(!isEmpty()&&tmp != null)				//si es diferente a vacio y el temporal es diferente a null entra y realiza lo sig.
			{
				if(tmp.getBack()==null){		//si tmp.getback es igual a nullo entonces 	
					tmp.setBack(null);			//tmp.setback es igual a null de esta manera evitamos que marque error al tratar de borrar un anterior al primer dato
				}
				
				else{ 
				if(tmp.getBack().getBack()!= null) {		//si no tmp da dos saltos si es diferente a null
					tmp.setBack(tmp.getBack().getBack());	//tmp.setback sera igual a tmp.getback.getback
					if(start.getNext().getNext()== tmp)		//inicio da dos saltos y si es igual a tmp entonces
						start.setNext(start.getNext().getNext());	//inicio.setnext sera iigual a inicio.getnext.getnext
					else
					{
						tmp = tmp.getBack();				//si no, tmp es igual a tmp.getback()
						tmp.setNext(tmp.getNext().getNext());	//y tmp.setnext sera igual a tmp.getnext().getnext()
					}
				}else 
				{
					tmp.setBack(null);//si no entonces tmp.setback sera igual a null
					start.setNext(start.getNext().getNext()); //y inicio.setnext sera igual ainicio.getnext.getnext
				}
			}
			}		
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void removeafter(T value)
		{
			node<T> tmp=Search(value);// creamos un tmp donde guardaremos el valor introducido y lo jalaremos del metodo search para que nos lo busque
			if(!isEmpty()&&tmp != null)//si es diferente a vacio y el temporal es diferente a null entra y realiza lo sig.
			{
				
				if(tmp.getNext()==null){ //si tmp.getnext es igual a nulo entonces 	
					tmp.setNext(null); //tmp.setnext es igual a null de esta manera evitamos que marque error al tratar de borrar uno despues del ultimo dato
				
				}else{
				
				if(tmp.getNext().getNext()!=null) {	//si no tmp da dos saltos si es diferente a null
					tmp.setNext(tmp.getNext().getNext());//tmp.senext sera igual a tmp.getnext.getnext
					if(end.getBack().getBack()==tmp)		//end da dos saltos y si es igual a tmp entonces
						end.setBack(end.getBack().getBack());	//end.setback sera iigual a end.getback.getback
					else
					{
						tmp=tmp.getNext();							//si no, tmp es igual a tmp.getnext()
						tmp.setBack(tmp.getBack().getBack());		//y tmp.setback sera igual a tmp.getback().getback()
					}
				}else 
				{
					tmp.setNext(null);			//si no entonces tmp.setnext sera igual a null
					end.setBack(end.getBack().getBack());	//y end.setback sera igual a end.getback.getback
				}
			}
			}
		}
		
/////////////////////////////////////////////////////////////////////////////////7
	
		
	 
}
