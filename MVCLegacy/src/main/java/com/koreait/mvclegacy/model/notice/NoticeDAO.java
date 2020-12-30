package com.koreait.mvclegacy.model.notice;

import java.util.List;

import com.koreait.mvclegacy.model.domain.Notice;

//EnterPrise ���߿����� �Ը� ũ�� ������ �� ��������(MVC)��ü���� ����ȭ �Ǿ� �ִ�.
//�� �������� �ִ�. �̶� �и��� ��ü���� ����� �����Ѱ� ����. �� ��ü�� ���յ��� ���ߴ� ���� ����.
//�� ����� ������ ����� DI��. �� ������ ���� ��ü �������� ����, �ܺο��� ���� �޵�,
//���Թ޴� ��ü�� �ش� �ڷ����� �����ڷ������� ���ڴ� ���̴�.

public interface NoticeDAO {
	public List selectAll();
	public Notice select(int notice_id);
	public void insert(Notice notice);
	public void update(Notice notice);
	public void delete(int notice_id);
}
