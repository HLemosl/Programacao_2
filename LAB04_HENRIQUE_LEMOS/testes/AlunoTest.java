import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Prog2.Aluno;

class AlunoTest {

	@Test
	void testAluno() {
		new Aluno("5", "Débora Leda", "Computação");
		new Aluno("6", "Hércules Rodrigues", "Computação");
		new Aluno("7", "Anderson", "Computação");
	}

	@Test
	void testAlunoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno(null, "Henrique", "Computação"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("3", "          ", "Computação"));
	}
	
	@Test
	void testHashCode() {
		assertEquals(new Aluno("1", "Henrique", "Computação").hashCode(), new Aluno("1", "Helen Cavalcanti", "Computação").hashCode());
		assertNotEquals(new Aluno("2", "Henrique", "Computação").hashCode(), new Aluno("3", "Henrique", "Computação").hashCode());
	}

	@Test
	void testEqualsObject() {
		assertEquals(new Aluno("8", "Nilton Ginani", "Computação"), new Aluno("8", "Antônio Neto", "Computação"));
		assertEquals(new Aluno("9", "João Felipe", "Computação"), new Aluno("9", "Leonardo Veiga", "Computação"));
		assertNotEquals(new Aluno("10", "Thiago Lima", "Computação"), new Aluno("11", "Matheus Freitas", "Computação"));
	}

	@Test
	void testToString() {
		Aluno teste1 = new Aluno("12", "Henrique Lemos", "Computação");
		Aluno teste2 = new Aluno("13", "Andrielly Lucena", "Computação");
		Aluno teste3 = new Aluno("14", "Helen Cavalcante", "Computação");
		
		assertEquals(teste1.toString(), "12 - Henrique Lemos - Computação");
		assertEquals(teste2.toString(), "13 - Andrielly Lucena - Computação");
		assertEquals(teste3.toString(), "14 - Helen Cavalcante - Computação");
	}

}
