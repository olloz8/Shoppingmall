package eCommerce.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.model.Comment;

@Repository("commentDAO")
@Transactional

public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addComment(Comment comment) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteComment(int commentId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Comment comment = session.get(Comment.class, commentId);
			session.delete(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean updateComment(Comment comment) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(comment);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	@Override
	public List<Comment> listComments() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Comment");
		List<Comment> listComments = query.list();
		return listComments;
	}
	
    @Override
    public List<Comment> getCommentsByBoardId(int boardId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Comment where boardId = :boardId");
        query.setParameter("boardId", boardId);
        List<Comment> listComments = query.list();
        return listComments;
    }

	@Override
	public Comment getComment(int commentId) {
		Session session = sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, commentId);
		return comment;
	}


}



