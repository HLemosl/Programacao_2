import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Prog2.Agenda;

class AgendaTest {
	
	Agenda agenda;

	@BeforeEach
	void setUp() throws Exception {
		agenda = new Agenda();
	}

	@Test
	void testCadastraContato() {
		boolean contato1 = agenda.cadastraContato(10, "Adam", "Victor", "68-968461568");
		assertTrue(contato1);
		boolean contato2 = agenda.cadastraContato(90, "Helena", "", "(27)952433514");
		assertTrue(contato2);
		boolean contato3 = agenda.cadastraContato(30, "Marianna", "Martins", "");
		assertTrue(contato3);
		
		
	}
	
	@Test
	void testCadastraContatoInvalidos() {
		boolean contato4 = agenda.cadastraContato(0, "Eliane", "Araújo", "(83)911111111");
		assertFalse(contato4);
		boolean contato5 = agenda.cadastraContato(101, "Lívia", "Sampaio", "(83)922222222");
		assertFalse(contato5);
	}

	@Test
	void testListaContatos() {
		agenda.cadastraContato(70, "Luiz", "Gustavo", "86-935435244");
		agenda.cadastraContato(40, "Isabelly", "", "(71)54871956");
		agenda.cadastraContato(60, "Antônio", "Saturnim", "(63)981554922");
		
		assertEquals(agenda.listaContatos(), "40 - Isabelly \n60 - Antônio Saturnim\n70 - Luiz Gustavo\n");
	}

	@Test
	void testExibeContatos() {
		agenda.cadastraContato(100, "Joaquim", "Oliveira", "(79)45436548");
		
		assertEquals(agenda.exibeContatos(100), "Joaquim Oliveira - (79)45436548");
	}
	
	@Test
	void testExibeContatosInvalidos() {
		agenda.cadastraContato(60, "Antônio", "Saturnim", "(63)981554922");
		
		assertEquals(agenda.exibeContatos(100), "POSIÇÃO INVÁLIDA!");
	}
	
	@Test
	void testEquals() {
		agenda.cadastraContato(15, "Antoninha", "BFF", "8365494654");
		agenda.cadastraContato(25, "Rogerio", "(Amor)", "19-964573244");
		
		Agenda agendaSecundaria = new Agenda();
		agendaSecundaria.cadastraContato(15, "Antoninha", "BFF", "8365494654");
		agendaSecundaria.cadastraContato(25, "Rogerio", "(Amor)", "19-964573244");
		
		Agenda agendaTerciaria = new Agenda();
		agendaTerciaria.cadastraContato(35, "Felipe", "Santos", "(11)54789632");
		agendaTerciaria.cadastraContato(45, "Rafinha", "Muleke", "82-49885621");
		
		assertEquals(agenda, agendaSecundaria);
		assertNotEquals(agenda, agendaTerciaria);
		assertNotEquals(agendaSecundaria, agendaTerciaria);
		
	}
}
