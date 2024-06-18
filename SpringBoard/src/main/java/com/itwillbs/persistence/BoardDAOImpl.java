package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.mysql.cj.xdevapi.Statement;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비 연결 정보 -> 주입
	@Inject
	private SqlSession sqlSession;

	// mapper의 NAMESPACE 정보 저장
	private static final String NAMESPACE="com.itwillbs.mapper.BoardMapper.";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		logger.debug(" 연결된 mapper에 SQL 구문 실행 ");
		sqlSession.insert(NAMESPACE + "create", vo); // NAMESPACE + 구문 id
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		logger.debug(" listAll() 실행 ");
		// mapper에 설정된 SQL 구문 실행(+디비 연결)

		//List<BoardVO> boardList = sqlSession.selectList(statement);
		// return boardList;
		
		return sqlSession.selectList(NAMESPACE + "listALL");
	}

	@Override
	public void updateReadCnt(int bno) throws Exception {
		logger.debug(" updateReadCnt(bno) 실행");

		sqlSession.update(NAMESPACE + "updateReadCnt", bno);
		
		
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug(" getBaord(int bno) 실행");
		
		return sqlSession.selectOne(NAMESPACE + "getBoard", bno);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.debug("updateBoard(BoardVO vo) 실행");
		
		sqlSession.update(NAMESPACE + "updateBoard", vo);
		
	}

	

	  
	
}
