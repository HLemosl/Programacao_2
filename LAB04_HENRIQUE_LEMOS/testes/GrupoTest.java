import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Prog2.Aluno;
import Prog2.Grupo;

class GrupoTest {
	
	Grupo grupo;
	
	@BeforeEach
	void setUp() throws Exception {
		grupo = new Grupo("Teste de Grupos");
		
		grupo.alocaEmGrupo(new Aluno("2", "Pedro Wanderley", "Computação"));
		grupo.alocaEmGrupo(new Aluno("3", "Jaciane Cruz", "Computação"));
		grupo.alocaEmGrupo(new Aluno("4", "Jadson Luan", "Computação"));
	}


	@Test
	void testGrupo() {
		new Grupo("Animados Para Estudar");
		new Grupo("3sp3r4nç4 p4r4 p4ss4r");
		new Grupo("f@s de P2");
	}
	
	@Test
	void testGrupoNuloVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Grupo(null));
		assertThrows(IllegalArgumentException.class, () -> new Grupo(""));
	}

	@Test
	void testAlocaEmGrupo() {
		grupo.alocaEmGrupo(new Aluno("1", "Matheus Gaudêncio", "Computação"));
		grupo.alocaEmGrupo(new Aluno("1000", "Lívia Sampaio", "Computação"));
		grupo.alocaEmGrupo(new Aluno("2000", "Eliane Araújo", "Computação"));
	}
	
	@Test
	void testImpressaoGrupo() {
		assertEquals(grupo.impressaoGrupo(), "* 2 - Pedro Wanderley - Computação\n* 3 - Jaciane Cruz - Computação\n* 4 - Jadson Luan - Computação\n");
	}
	
	@Test
	void testHashCode() {
		 assertEquals(new Grupo("Teste Certo").hashCode(), new Grupo("Teste Certo").hashCode());
		 assertNotEquals(new Grupo("Teste Errado").hashCode(), new Grupo("TesteErrado").hashCode());
	}

	@Test
	void testEqualsObject() {
		assertEquals(new Grupo("Fãs de Futebol"), new Grupo("Fãs de Futebol"));
		assertNotEquals(new Grupo("Adoradores de Filme"), new Grupo("Adoradores de Séries"));
	}
}
