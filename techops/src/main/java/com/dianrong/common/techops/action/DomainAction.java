package com.dianrong.common.techops.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dianrong.common.techops.service.TechOpsService;
import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.DomainDto;
import com.dianrong.common.uniauth.sharerw.facade.UARWFacade;

/**
 * Created by Arc on 14/2/16.
 */
@RestController
@RequestMapping("domain")
public class DomainAction {

    @Resource
    private UARWFacade uARWFacade;
    
    @Resource
    private TechOpsService techOpsService;
    
    @RequestMapping(value = "/all" , method= RequestMethod.GET)
    public Response<List<DomainDto>> getAllLoginDomains(HttpServletRequest request) {
    	List<DomainDto> domainDtoList = techOpsService.getDropDownDomainList(request.getRemoteAddr());
    	return new Response<List<DomainDto>>(domainDtoList);
    }
}