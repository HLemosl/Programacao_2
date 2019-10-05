import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Prog2.ControleDeAlunos;

class ControleDeAlunosTest {
	
	ControleDeAlunos controleDeAlunos;
	
	@BeforeEach
	void setUp() throws Exception {
		controleDeAlunos = new ControleDeAlunos();
		
		controleDeAlunos.cadastraAluno("250", "Pedro Wanderley", "Computação");
		controleDeAlunos.cadastraAluno("500", "Jaciane Cruz", "Computação");
		controleDeAlunos.cadastraAluno("750", "Jadson Luan", "Computação");
		controleDeAlunos.cadastraAluno("1250", "Debora Leda", "Computação");
		controleDeAlunos.cadastraAluno("1500", "Hércules Rodrigues", "Computação");
		controleDeAlunos.cadastraAluno("1750", "Anderson", "Computação");
		controleDeAlunos.cadastraAluno("2250", "Nilton Ginani", "Computação");
		controleDeAlunos.cadastraAluno("2500", "Antônio Neto", "Computação");
		controleDeAlunos.cadastraAluno("2750", "João Felipe", "Computação");
		controleDeAlunos.cadastraAluno("3000", "Leonardo Veiga", "Computação");
		controleDeAlunos.cadastraAluno("3250", "Thiago Lima", "Computação");
		controleDeAlunos.cadastraAluno("3500", "Matheus Freitas", "Computação");
		
		controleDeAlunos.cadastraGrupo("Reprovados2019.2");
		controleDeAlunos.cadastraGrupo("Desesper@dos em P2");
		controleDeAlunos.cadastraGrupo("EstudantesUFCG");
		controleDeAlunos.cadastraGrupo("Concluintes P2");
		
		
	}

	@Test
	void testCadastraAluno() {
		assertTrue(controleDeAlunos.cadastraAluno("1", "Matheus Gaudêncio", "Computação"));
		assertTrue(controleDeAlunos.cadastraAluno("1000", "lívi4 s4mp4io", "comput4ç4o"));
		assertTrue(controleDeAlunos.cadastraAluno("2000", "ELIANE ARAÚJO", "COMPUTAÇÃO"));
	}
	
	@Test
	void testAlunoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno(null, "Henrique", "Computação"));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno("3", null, "Computação"));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno("3", "Henrique", null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno("     ", "Henrique", "Computação"));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno("3", "     ", "Computação"));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraAluno("3", "Henrique", "  "));
		
	}

	@Test
	void testCadastraAlunoInvalido() {
		assertFalse(controleDeAlunos.cadastraAluno("250", "Felipe", "Computação"));
		assertFalse(controleDeAlunos.cadastraAluno("500", "JK", "Computação"));
	}
	
	@Test
	void testExibeAluno() {
		assertEquals(controleDeAlunos.exibeAluno("750"), "Aluno: 750 - Jadson Luan - Computação");
		assertEquals(controleDeAlunos.exibeAluno("1250"), "Aluno: 1250 - Debora Leda - Computação");
	}

	@Test
	void testeExibeAlunoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.exibeAluno(null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.exibeAluno("    "));
	}
	
	@Test
	void testExisteGrupo() {
		assertTrue(controleDeAlunos.existeGrupo("Reprovados2019.2"));
		assertTrue(controleDeAlunos.existeGrupo("Desesper@dos em P2"));
		assertFalse(controleDeAlunos.existeGrupo("Tô na Final!!"));
		assertFalse(controleDeAlunos.existeGrupo(":)"));
	}
	
	@Test
	void testExisteGrupoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.existeGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.existeGrupo("     "));
	}

	@Test
	void testCadastraGrupo() {
		controleDeAlunos.cadastraGrupo("MonitoresP2 2019.2");
		controleDeAlunos.cadastraGrupo("ProfessoresP2 2019.2");
		controleDeAlunos.cadastraGrupo("Alunos P2 - Outros Semestres");
	}
	
	@Test
	void testXadastraGrupoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.cadastraGrupo("    "));
	}
	
	@Test
	void testAlocaAluno() {
		assertEquals(controleDeAlunos.alocaAluno("1500", "EstudantesUFCG"), 1);
		assertEquals(controleDeAlunos.alocaAluno("1", "EstudantesUFCG"), 2);
		assertEquals(controleDeAlunos.alocaAluno("1000", "MonitoresP2 2019.2"), 3);
	}

	@Test
	void testAlocaAlunoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.alocaAluno("   ", "DoidosUFCG"));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.alocaAluno("Henrique", null));
	}
	
	@Test
	void testImprimeGrupo() {
		controleDeAlunos.alocaAluno("2250", "Concluintes P2");
		controleDeAlunos.alocaAluno("2500", "Concluintes P2");
		
		assertEquals(controleDeAlunos.imprimeGrupo("Concluintes P2"), "* 2250 - Nilton Ginani - Computação\n* 2500 - Antônio Neto - Computação\n");
		assertEquals(controleDeAlunos.imprimeGrupo("BestMonitores"), "falha");
	}
	
	@Test
	void testImprimeGrupoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.imprimeGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.imprimeGrupo("  "));
	}

	@Test
	void testAlunoRespondeu() {
		assertTrue(controleDeAlunos.alunoRespondeu("2750"));
		assertFalse(controleDeAlunos.alunoRespondeu("2000"));
		
	}
	
	@Test
	void testAlunoRespondeuNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.alunoRespondeu(null));
		assertThrows(IllegalArgumentException.class, () -> controleDeAlunos.alunoRespondeu("   "));
	}

	@Test
	void testImprimeQuestoesQuadro() {
		controleDeAlunos.alunoRespondeu("3000");
		controleDeAlunos.alunoRespondeu("3250");
		controleDeAlunos.alunoRespondeu("3500");
		
		assertEquals(controleDeAlunos.imprimeQuestoesQuadro(), "1. 3000 - Leonardo Veiga - Computação\n2. 3250 - Thiago Lima - Computação\n3. 3500 - Matheus Freitas - Computação\n");
	}
}
