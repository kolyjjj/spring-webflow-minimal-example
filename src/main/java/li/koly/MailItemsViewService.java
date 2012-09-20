package li.koly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MailItemsViewService {

    private static Map<String, Set<MailItemModel>> mailItemsMap = new HashMap<String, Set<MailItemModel>>();

    public boolean isUserValid(String username){

        boolean validUser = mailItemsMap.keySet().contains(username);
        return validUser;
    }

    public Set<MailItemModel> retriveMailItems(String username){
        
        Set<MailItemModel> mailItemsSet = mailItemsMap.get(username);
        return mailItemsSet;
    }

    static{

        Set<MailItemModel> modelSet = new HashSet<MailItemModel>();
        modelSet.add(mailViewModel("admin@abc.com", "System Upgrade", "Upgrade your system from virus protection"));
        modelSet.add(mailViewModel("timesheet-admin@abc.com", "Timesheet Reminder", "Complete your timesheet entries for this week"));

        mailItemsMap.put("admin", modelSet);
    }

    private static MailItemModel mailViewModel(String from, String subject, String message){

        MailItemModel model = new MailItemModel();
        model.setFrom(from);
        model.setSubject(subject);
        model.setMessage(message);
        return model;
    }
}