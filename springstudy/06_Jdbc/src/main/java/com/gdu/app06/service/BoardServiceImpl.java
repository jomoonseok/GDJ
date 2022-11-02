package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;

/*
	@Service
	Service에 추가하는 @Component
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색된다.
	root-context.xml이나 @Configuration에 Bean으로 등록하지 않아도 컨테이너에 만들어 진다.
*/

@Service // Service가 사용하는 @Component
public class BoardServiceImpl implements BoardService {

	
	// Service는 DAO를 사용한다.
	@Autowired // 컨테이너에 생성된 bean 중에서 BoardDAO 타입의 bean을 가져오시오
	private BoardDAO dao;
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remeveBoard(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
