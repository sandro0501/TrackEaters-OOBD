package dao;

import dto.Operatore;

public interface OperatoreDAO {
	Operatore getOperatore(String username, String password, String ruoloOperatore);
}
