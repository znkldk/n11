package n11;

import static org.junit.Assert.*;

import org.junit.Test;


public class n11test {
	
	/*Testi buradan ba�latabilirsiniz
	 * 
	 * Test ba�lad�g�nda taray�c�y� tam ekran yapmak veya fareyi taray�n�z�n 
	 * �zerinde tutmak baz� kodlar�n do�ru �al��mas�n� engelleyebilir.
	 * 
	 */

	@Test
	public void n11egit() {
		
		int i=0;
		anakod testet= new anakod();
		i=testet.anakod();
		System.out.println(i);
		assertEquals( i, 1);
	}


}
