import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Prog2.Contatos;

class ContatosTest {
	Contatos teste1;
	Contatos teste2;
	Contatos teste3;
	Contatos teste4;

	@BeforeEach
	void setUp() throws Exception {
		teste1 = new Contatos(1, "Henrique", "Lemos", "+55 (11)40028922");
		teste2 = new Contatos(20, "Fabiana", "", "(21)24691116");
		teste3 = new Contatos(50, "Marcos", "Praga Monteiro", "");
		teste4 = new Contatos(80, "!@#$%*()", ")(*&$#@!", "83-965417258");
	}

	@Test
	void testContatosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Contatos(10, "      ", "Guadalupe", "17-985641742"));
		assertThrows(IllegalArgumentException.class, () -> new Contatos(90, "", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Contatos(35, " ", "Almeida", "(82)49325581"));
	}

	@Test
	void testEqualsObject() {
		Contatos compara1 = new Contatos(80, "!@#$%*()", ")(*&$#@!", "83-965417258");
		assertEquals(teste4, compara1);
		Contatos compara2 = new Contatos(20, "Matheus", "Gaudêncio", "(83)900000000");
		assertNotEquals(teste2, compara2);
	}

	@Test
	void testToString() {
		String msg1 = "Henrique Lemos - +55 (11)40028922";
		assertEquals(teste1.toString(), msg1);
		String msg2 = "Fabiana  - (21)24691116";
		assertEquals(teste2.toString(), msg2);
		String msg3 = "Marcos Praga Monteiro - ";
		assertEquals(teste3.toString(), msg3);
		String msg4 = "!@#$%*() )(*&$#@! - 83-965417258";
		assertEquals(teste4.toString(), msg4);
	}

	@Test
	void testContatoToString() {
		String cnt1 = "1 - Henrique Lemos";
		assertEquals(teste1.contatoToString(), cnt1);
		String cnt2 = "20 - Fabiana ";
		assertEquals(teste2.contatoToString(), cnt2);
		String cnt3 = "50 - Marcos Praga Monteiro";
		assertEquals(teste3.contatoToString(), cnt3);
		String cnt4 = "80 - !@#$%*() )(*&$#@!";
		assertEquals(teste4.contatoToString(), cnt4);
	}
}
