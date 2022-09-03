package dao;

import java.util.ArrayList;

import dto.Sala;

public interface SalaDAO {
	
	 ArrayList<Sala> getSaleByCodRistorante(int codRistorante);
}
