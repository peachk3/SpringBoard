package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 게시판 글 작성
	public void create(BoardVO vo) throws Exception;
	// => 호출시 예외 처리하도록 설정
	
	// 게시판 리스트(ALL)
	public List<BoardVO> listAll() throws Exception;

	// 게시글 조회수 1 증가
	public void updateReadCnt(int bno) throws Exception;
	
	public BoardVO getBoard(int bno) throws Exception;

	public void updateBoard(BoardVO vo) throws Exception;
	
	
	
}
