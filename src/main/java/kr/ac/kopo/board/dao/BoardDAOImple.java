package kr.ac.kopo.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImple implements BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    @Override
    public List<BoardVO> getAllPost() {
        
        List<BoardVO> boardlist =
                sqlSessionTemplate.selectList("springboard.board.dao.BoardDAO.selectAll");
        // sql문의 이름 mapper.xml
        
        
        return boardlist;
    }

    @Override
    public BoardVO getPostByNo(int no) {
        // TODO Auto-generated method stub
        BoardVO boardVO = sqlSessionTemplate.selectOne("springboard.board.dao.BoardDAO.selectbyNo", no);
        return boardVO;
    }

    @Override
    public void writeNewPost(BoardVO boardVO) {
        // TODO Auto-generated method stub
        sqlSessionTemplate.insert("springboard.board.dao.BoardDAO.insert", boardVO);
    }
    

}
