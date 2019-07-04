package n11;

import static org.junit.Assert.*;

import org.junit.Test;


public class n11test {
	
	/*Testi buradan baþlatabilirsiniz
	 * 
	 * Test baþladýgýnda tarayýcýyý tam ekran yapmak veya fareyi tarayýnýzýn 
	 * üzerinde tutmak bazý kodlarýn doðru çalýþmasýný engelleyebilir.
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
