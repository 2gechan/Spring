package com.gechan.board.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageDto {

	@Builder.Default // 기본 값 1페이지로 설정
	private int pageNum = 1; // 보고자 하는 페이지번호

	private int totalCount; // 게시판 전체 게시물 수
	private int offsetNum; // 선택된 페이지마다 가져올 게시물의 시작 시퀀스 번호

	@Builder.Default // 기본 값 10개로 설정
	private int limitCount = 10; // 보여질 데이터 개수(페이지당 보여지는 게시물 개수)
	private int pageNumCount; // 게시물이 limitCount로 나뉜 총 페이지 개수

	private int firstPageNum; // 현재 페이지 기준으로 하단의 첫번째 페이지번호
	private int lastPageNum; // 현재 페이지 기준으로 하단의 마지막 페이지번호

	private int finalPageNum; // 전체 데이터의 마지막 페이지 계산 결과

	public int getFinalPageNum() {
		// 게시물이 없을 경우 Exception 발생 대비 if조건문으로 먼저 비교
		if (totalCount < 1) {
			return 0;
		}
		this.finalPageNum = (this.totalCount + (this.limitCount - 1)) / this.limitCount;
		return this.finalPageNum;
	}

	public int getOffSetNum() {
		this.offsetNum = (pageNum - 1) * limitCount;
		return this.offsetNum;
	}

	public int getFirstPageNum() {
		this.firstPageNum = (int) (pageNum - (limitCount / 2));
		this.firstPageNum = this.firstPageNum < 1 ? 1 : this.firstPageNum;
		return firstPageNum;
	}
	
	public int getLastPageNum() {
		this.firstPageNum = this.getFirstPageNum();
		this.finalPageNum = this.getFinalPageNum();
		
		this.lastPageNum = this.firstPageNum + this.limitCount + 1;
		this.lastPageNum = this.lastPageNum > this.finalPageNum ?  this.finalPageNum : this.lastPageNum;
		return this.lastPageNum;
	}

}
