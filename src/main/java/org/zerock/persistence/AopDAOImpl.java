package org.zerock.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.SearchCriteria;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AopDAOImpl implements AopDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.AopMapper";

  @Override
  public void create(MemberVO vo) throws Exception {
    session.insert(namespace + ".create", vo);
  }
}
