package com.orderms.order.services.clients;

import com.orderms.order.dtos.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("client")
public interface CostumerClient {
    @RequestMapping(method = RequestMethod.GET,  value= "/client/id")
    public ResponseEntity<ClientDto> getClientById(@RequestParam long id);

}
