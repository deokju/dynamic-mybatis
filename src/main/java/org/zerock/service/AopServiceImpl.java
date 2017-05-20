package org.zerock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.AopDAO;
import org.zerock.persistence.BoardDAO;

import javax.inject.Inject;
import java.util.List;

@Service
public class AopServiceImpl implements AopService {

  @Inject
  private AopDAO aopDAO;


  @Override
  public void regist(MemberVO memberVO) throws Exception {
    aopDAO.create(memberVO);
  }
}
