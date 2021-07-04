package kr.ac.kopo.kopo20.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo20.domain.*;
import kr.ac.kopo.kopo20.dao.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		boardRepository.create(board);
	}

	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return boardRepository.selectOne(id);
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return boardRepository.selectAll();
				
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		boardRepository.update(board);
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		boardRepository.delete(board);
	}

}
