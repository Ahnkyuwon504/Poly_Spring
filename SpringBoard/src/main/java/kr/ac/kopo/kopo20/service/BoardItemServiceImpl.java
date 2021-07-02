package kr.ac.kopo.kopo20.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo20.dao.BoardItemRepository;
import kr.ac.kopo.kopo20.dao.BoardRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService{
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private BoardItemRepository boardItemRepository;

}
