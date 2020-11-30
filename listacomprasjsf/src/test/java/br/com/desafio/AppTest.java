package br.com.desafio;

import static org.junit.Assert.assertTrue;

import javax.persistence.Persistence;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("listacomprasjsf");
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
