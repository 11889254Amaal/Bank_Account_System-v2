package com.example.Bank.management.system2.SendMailing;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelForMailing {
    private List<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
