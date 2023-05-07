package com.example.Bank.management.system2.ObjectRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UpdateBlanceWhenCreateTranscation {

    Integer id;

    Integer amount;

    Long account_number;
}
