package com.example.springboothw132.ControllerBank;

import com.example.springboothw132.ApiResponce.ApiResponce;
import com.example.springboothw132.Model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class Bank {

    ArrayList<Customer> banks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getBanks() {
        return banks;
    }

    @PostMapping("/add")
    public ApiResponce addInfo(@RequestBody Customer bank) {
        banks.add(bank);
        return new ApiResponce("data added");

    }

    @PutMapping("/update/{index}")
    public ApiResponce updateInfo(@PathVariable int index, @RequestBody Customer bank) {
        banks.set(index, bank);
        return new ApiResponce("Data updated");

    }

    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteInfo(@PathVariable int index) {
        banks.remove(index);
        return new ApiResponce("data deleted");
    }

    @PutMapping("/withdraw/{Username}/{balance}")
    public ApiResponce withdraw (@PathVariable String Username, @PathVariable double balance) {
        for (Customer user :banks ) {
            if (user.getUsername().equalsIgnoreCase(Username)) {
                if (user.getBalance() < balance) {
                    return new ApiResponce("don't have money");
                }//end-if
                else {
                    user.setBalance(user.getBalance() - balance);
                    return new ApiResponce("withdraw successfully");
                }//end-else

                } //end-if
            }//end-for
        return new ApiResponce("Wrong !!");
    }

    @PutMapping("/deposit/{Username}/{balance}")
    public ApiResponce depositMoney(@PathVariable String Username, @PathVariable double balance) {
        for (Customer user : banks) {
            if (user.getUsername().equalsIgnoreCase((Username))) {
                user.setBalance(user.getBalance() + balance);
                return new ApiResponce(" Deposit successfully");
            }
            else {
                return new ApiResponce("Deposit unsuccessfully");
            }
        }
            return new ApiResponce("wrong info !!");
    }
}