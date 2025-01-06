package eCommerce.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.model.Board;
import eCommerce.model.WishItem;

@Repository("boardDAO")
@Transactional

public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBoard(Board board) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(board);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBoard(int boardId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Board board = session.get(Board.class, boardId);
			session.delete(board);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean updateBoard(Board board) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(board);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	@Override
	public List<Board> listBoards() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Board");
		List<Board> listBoards = query.list();
		return listBoards;
	}

	@Override
	public Board getBoard(int boardId) {
		Session session = sessionFactory.getCurrentSession();
		Board board = session.get(Board.class, boardId);
		return board;
	}

}