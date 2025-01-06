package eCommerce.DAO;

import java.util.List;

import eCommerce.model.Comment;

public interface CommentDAO {
    public boolean addComment(Comment comment);
    public boolean updateComment(Comment comment);
    public boolean deleteComment(int commentId);
    
    public List<Comment> listComments();
    public List<Comment> getCommentsByBoardId(int boardId);
    public Comment getComment(int commentId);
}



