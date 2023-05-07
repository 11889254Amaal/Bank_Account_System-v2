package com.example.Bank.management.system2.Controller;

import com.example.Bank.management.system2.ObjectRequest.AddAccountForCustomer;
import com.example.Bank.management.system2.ObjectRequest.UpdateBlanceWhenCreateTranscation;
import com.example.Bank.management.system2.Service.AccountServices;
import com.example.Bank.management.system2.Service.TranscationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "Transcation")
public class TranscationController {
    @Autowired
    TranscationServices transcationServices;



    @RequestMapping(value = "addTranscation", method = RequestMethod.POST)
    public String addTranscation(@RequestBody UpdateBlanceWhenCreateTranscation updateBlanceWhenCreateTranscation) {
        transcationServices.addTranscation(updateBlanceWhenCreateTranscation);
        String UpdateBalance = "Balance update  Successfully";
        return UpdateBalance;

    }


}
