package com.example.Bank.management.system2.SendMailing;

public interface MailingRepository {


    String sendSimpleMailToMany(ModelForMailing mailingModel);
    String sendSimpleMail(ModelForMailing mailingModel);

    String sendMailWithAttachmentToMany(ModelForMailing mailingModel);
    String sendMailWithAttachment(ModelForMailing mailingModel);
}
