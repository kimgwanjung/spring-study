package kr.ac.kopo.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired
    private BoardDAO boardDAO;
    
    @Override
    public List<BoardVO> getAllBoard() {
        // TODO Auto-generated method stub
        List<BoardVO> boardlist = boardDAO.getAllPost();
        return boardlist;
    }

    @Override
    public BoardVO getPostByNo(int no) {
        BoardVO board = boardDAO.getPostByNo(no);
        return board;
    }

    @Override
    public void writeNewPost(BoardVO boardVO) {
        boardDAO.writeNewPost(boardVO);
    }

}
