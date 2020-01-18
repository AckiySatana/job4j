package Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
       if (!users.containsKey(user)) {
           users.put(user, new ArrayList<Account>());
       }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        //putIfAbsent
        if (!users.get(user).contains(account)){
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User us: users.keySet()) {
            if (us.getPassport().contains(passport)){
              user = us;
              break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        //Этот метод ищет счет пользователя по реквизитам.
        // Сначала нужно найти пользователя.
        // Потом получить список счетов этого пользователя и в нем найти нужный счет.
        User user = findByPassport(passport);
        Account account = null;
        for (Account acc : users.get(user)) {
            if (acc.getRequisite().contains(requisite)) {
                account = acc;
                System.out.println("finded req " + account.getBalance());
                break;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {

        boolean rsl = false;
        //найдем клиентов: отправителя и получателя
        User sender = findByPassport(srcPassport) , rec = findByPassport(destPassport);

        //проверим что счета есть
        if (    users.get(sender).indexOf(findByRequisite(destPassport,dеstRequisite))  >= 0
                && users.get(rec).indexOf(findByRequisite(srcPassport,srcRequisite))    >= 0) {
            System.out.println("accounts exists");
            // найдем счета
            Account acc_send = findByRequisite(srcPassport,srcRequisite);
            Account acc_dest = findByRequisite(destPassport,dеstRequisite);

            if (acc_send.getBalance() >= amount) {
                acc_send.setBalance(acc_send.getBalance() - amount);
                acc_dest.setBalance(acc_dest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}