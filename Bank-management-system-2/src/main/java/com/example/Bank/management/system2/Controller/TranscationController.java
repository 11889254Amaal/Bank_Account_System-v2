package com.example.Bank.management.system2.Controller;

import com.example.Bank.management.system2.ObjectRequest.*;
import com.example.Bank.management.system2.Service.AccountServices;
import com.example.Bank.management.system2.Service.TranscationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "CalculatInterst", method = RequestMethod.POST)
    public String CalculatInterst(@RequestBody AddAccountForCustomer addAccountForCustomer) {
        transcationServices.CalculateInterst(addAccountForCustomer);
        String UpdateBalance = "Account Balance update  Successfully";
        return UpdateBalance;

    }

    @RequestMapping(value = "updateTranscationDetails", method = RequestMethod.POST)
    public String updateTranscationInfo(@RequestBody UpdateTranscationRequeast updateTranscationRequeast) {
        transcationServices.updateTranscationInfo(updateTranscationRequeast);
        String UpdateTranscationInfo = "Transcation Update Successfully";
        return UpdateTranscationInfo;

    }

    @RequestMapping(value = "deleteLoan", method = RequestMethod.POST)
    public String deleteTranscation(@RequestParam Integer id) {
        try {
            transcationServices.deleteTranscation(id);
            return "Transcation delete Successfully";
        } catch (Exception e) {
            return "Transcation delete Failed";
        }
    }



}
