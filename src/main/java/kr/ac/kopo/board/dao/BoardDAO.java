package kr.ac.kopo.board.dao;

import java.util.List;
import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
    public List<BoardVO> getAllPost();
    
    public BoardVO getPostByNo(int no);
    
    public void writeNewPost(BoardVO boardVO);


}
