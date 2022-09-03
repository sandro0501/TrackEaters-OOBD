package dao;

import java.util.ArrayList;
import dto.Cameriere;

public interface CameriereDAO {
	
	public ArrayList<Cameriere> getCamerieriRistorante(int codRistorante);

}
