package org.zerock.persistence;

import org.zerock.domain.MemberVO;

public interface AopDAO {

  public void create(MemberVO vo) throws Exception;

}
