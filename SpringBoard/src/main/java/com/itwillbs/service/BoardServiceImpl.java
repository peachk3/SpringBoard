package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// DAO 객체를 주입
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.debug("연결된 DAO 메서드를 호출");
		
		// DAO에서 생성한 메서드 호출
		bdao.create(vo);
		
		logger.debug(" 글쓰기 완료 ");
		
	}

	
}
