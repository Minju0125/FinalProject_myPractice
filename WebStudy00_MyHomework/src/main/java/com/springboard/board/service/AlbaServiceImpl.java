package com.springboard.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springboard.board.dao.AlbaDAO;
import com.springboard.board.vo.AlbaVO;

@Service
public class AlbaServiceImpl implements AlbaService{
	@Inject
	private AlbaDAO dao;

	@Override
	public List<AlbaVO> retrieveAlbaList() {
		return dao.selectAlbaList();
	} 

}
