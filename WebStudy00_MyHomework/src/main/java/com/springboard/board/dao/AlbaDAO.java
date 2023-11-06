package com.springboard.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboard.board.vo.AlbaVO;
@Mapper
public interface AlbaDAO {
	/**
	 * 모든 알바 목록 출력
	 */
	public List<AlbaVO> selectAlbaList();
}
