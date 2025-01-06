package eCommerce.DAO;

import java.util.List;

import eCommerce.model.Board;

public interface BoardDAO {
	public boolean addBoard(Board board);
	public boolean updateBoard(Board board);
	public boolean deleteBoard(int boardId);

	public List<Board> listBoards();
	public Board getBoard(int boradId);  
}

