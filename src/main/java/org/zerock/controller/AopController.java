package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.aop.RoutingDataSource;
import org.zerock.domain.MemberVO;
import org.zerock.service.AopService;
import org.zerock.util.DbContextHolder;
import org.zerock.util.DbType;

@RequestMapping("/aop")
@Controller
public class AopController {

    @Autowired
    AopService aopService;

  @RequestMapping("/hello")
  public String sayHello() {
    if(DbContextHolder.getDbType() == DbType.MASTER) {
        System.out.println("이런 슈밤바");
    }
    DbContextHolder.setDbType(DbType.REPLICA1);
    try{
        aopService.regist(new MemberVO("darkduk","김덕주",32));
    }catch(Exception e) {
        e.printStackTrace();
    }

    return "Hello World ";
  }



}
