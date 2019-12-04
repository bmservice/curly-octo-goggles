import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final ReentrantLock lock=new ReentrantLock();
  //账户
   private String accountNo;
  //余额
   private double balance;
   public Account(){}

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Account(String account, double balance){
       this.accountNo=account;
       this.balance=balance;
   }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj!=null&&obj.getClass()==Account.class){
            Account target=(Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
    public void draw(double drawAmount) {
        try {

            lock.lock();
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance -= drawAmount;
                System.out.println("余额为" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + "余额不足");
            }

        }finally {
            lock.unlock();
        }
    }
}
